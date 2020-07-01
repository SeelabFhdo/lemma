package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.appendStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.asClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.emptyBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getEponymousJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasReturnStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasThrowStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.isOverridable
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.serialize
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setFilePath
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.countLines
import de.fhdo.lemma.model_processing.utils.countLines
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File
import java.nio.charset.Charset

/**
 * Serializes an AST [Node] following the Extended Generation Gap Pattern (cf.
 * [Greifenberg et al.](https://link.springer.com/chapter/10.1007/978-3-319-27869-8_7) and
 * [ExtendedGenerationGapSerializerBase]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationSerializer("extended-generation-gap", default = true)
internal class ExtendedGenerationGapSerializer : CodeGenerationSerializerI {
    private lateinit var delegate: ExtendedGenerationGapSerializerBase

    /**
     * Do the serialization (delegates to [ExtendedGenerationGapSerializerBase])
     */
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject?,
        originalModelFilePath: String?) : Map<String, Pair<String, Node?>> {
        delegate = ExtendedGenerationGapSerializerBase()
        return delegate.serialize(node, targetFolderPath, targetFilePath)
    }

    /**
     * Adapt generated files after the code generation phase has completed. For instance, add missing constructors to
     * inherited classes.
     */
    override fun codeGenerationPhaseCompleted(allGeneratedFiles : Map<String, Pair<String, Charset>>)
        = delegate.codeGenerationPhaseCompletedCallback()
}

/**
 * Serializes an AST [Node] following the Extended Generation Gap Pattern (cf.
 * [Greifenberg et al.](https://link.springer.com/chapter/10.1007/978-3-319-27869-8_7) and
 * [ExtendedGenerationGapSerializerBase]) and counts the generated LOCs.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationSerializer("extended-generation-gap-loc", true)
internal class CountingExtendedGenerationGapSerializer : CodeGenerationSerializerI {
    private lateinit var delegate: ExtendedGenerationGapSerializerBase

    /**
     * Do the serialization (delegates to [ExtendedGenerationGapSerializerBase])
     */
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject?,
        originalModelFilePath: String?) : Map<String, Pair<String, Node?>> {
        delegate = ExtendedGenerationGapSerializerBase()
        val serializationResults = delegate.serialize(node, targetFolderPath, targetFilePath)

        serializationResults.forEach{ (path, result) ->
            val (generatedCode, _) = result
            MainState.addOrUpdateGeneratedLineCountInfo(
                countLines(
                    path to generatedCode,
                    intermediateEObject,
                    originalModelFilePath
                )
            )
        }

        return serializationResults
    }

    /**
     * Adapt generated files after the code generation phase has completed. For instance, add missing constructors to
     * inherited classes.
     */
    override fun codeGenerationPhaseCompleted(allGeneratedFiles : Map<String, Pair<String, Charset>>)
        : Map<String, String> {
        val adaptedFiles = delegate.codeGenerationPhaseCompletedCallback()

        // Also adapt existing line count information
        val generatedLineCountInfo: List<LineCountInfo> by MainState
        generatedLineCountInfo.forEach {
            val adaptedContentWithLineCountInfo = adaptedFiles[it.serializationTargetFilePath]
            if (adaptedContentWithLineCountInfo != null)
                it.serializationResultLineCount = adaptedContentWithLineCountInfo.countLines(
                    forFile = it.serializationTargetFilePath
                )
        }

        return adaptedFiles
    }
}

/**
 * [CodeGenerationSerializerI] implementation for the Extended Generation Gap Pattern (cf.
 * [Greifenberg et al.](https://link.springer.com/chapter/10.1007/978-3-319-27869-8_7)). It partially relies on
 * functionality provided by the [GenerationGapSerializerBase] and does the following with the passed [Node]:
 *      - If the node is not a Java class (e.g., an enumeration or interface): Plain serialization.
 *
 *      - If the node is a Java class and its corresponding Java file does not exist, yet (suppose that the original
 *        Java class is called "x_" and shall reside in a file "x_.java"):
 *          - If there is an "extension interface" in the same folder as the class file called "x_Ext" and stored in a
 *            file called "x_Ext.java", generate an interface called "x_Gen" in the file "gen/x_Gen.java". This
 *            interface comprises all method signatures from "x_" and extends the extension interface. Second, generate
 *            a class called "x_GenImpl" in the file "gen/x_GenImpl.java". This class is abstract and implements the
 *            "x_Gen" interface. Third, the "x_" class is adapted to extend the "x_GenImpl" class. Thus, the
 *            extends/implements relationships are the following:
 *                  - <<interface>> gen/x_Gen --> <<interface>> x_Ext
 *                  - <<abstract>> gen/x_GenImpl --|> <<interface>> gen/x_Gen
 *                  - x_ --> <<abstract>> gen/x_GenImpl
 *            Hence, if methods are added to the "x_Ext" interface, they need to be implemented in the "x_"class.
 *            However, "gen/x_Gen" and "gen/x_GenImpl" can safely be re-generated in case the input model changes.
 *
 *          - If no extension interface exists, generate an interface called "x_Gen" in the file "gen/x_Gen.java". Adapt
 *            the "x_" class to implement "x_Gen".
 *
 *      - If the node is a Java class and its corresponding Java file does in fact exist:
 *          - In case the extension interface exists, merge new generated constructors and methods into the existing
 *            class. Thus, no custom code will be overridden.
 *
 *          - In case the extension interface does not exist, overwrite the existing file (which will actually only
 *            happen if the code generator was not invoked with the --preserve_existing_files commandline option).
 *            However, no changes to any other existing files, e.g., "gen/x_GenImpl.java" (see above), are being made.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class ExtendedGenerationGapSerializerBase : KoinComponent {
    private val generationGapDelegate = GenerationGapSerializerBase()
    private val serializationConfiguration: AbstractSerializationConfiguration by inject()

    /**
     * Do the actual serialization according to the Extended Generation Gap Pattern
     */
    internal fun serialize(node: Node, targetFolderPath: String, targetFilePath: String)
        : Map<String, Pair<String, Node?>> {
        val originalClass = node.asClassOrInterfaceDeclaration()

        /* If the node does not comprise a class (e.g., its an enum or interface) do the plain serialization */
        if (originalClass == null || originalClass.isInterface) {
            val generatedCodeToNode = node.serialize(serializationConfiguration) to node
            return mapOf("$targetFolderPath${File.separator}$targetFilePath" to generatedCodeToNode)
        }

        /* If the node comprises a class, do the serialization according to the Extended Generation Gap Pattern */
        val fullTargetFile = "$targetFolderPath${File.separator}$targetFilePath".asFile()
        val fullTargetFolderPath = fullTargetFile.parent
        val targetClassname = fullTargetFile.nameWithoutExtension

        val extensionInterface = findExtensionInterface(fullTargetFolderPath, targetClassname)
        return if (extensionInterface == null)
                generateWithoutGap(originalClass, fullTargetFolderPath,
                    GenerationGapSerializerBase.GENERATION_SUBFOLDER, targetClassname)
            else
                generateWithGap(originalClass, extensionInterface, fullTargetFolderPath,
                    GenerationGapSerializerBase.GENERATION_SUBFOLDER, targetClassname)
    }

    /**
     * Try to find the extension interface in the given [folderPath] and for the given [classname]. The extension
     * interface has to reside in a Java file with the same name as [classname] and the "Ext" suffix. Moreover, the
     * extension interface needs to be named after the filename, i.e., [classname] with suffix "Ext".
     */
    private fun findExtensionInterface(folderPath: String, classname: String) : ClassOrInterfaceDeclaration? {
        val extensionFilePath = "$folderPath${File.separator}${classname}Ext.java"
        val extensionInterface = extensionFilePath.asFile().getEponymousJavaClassOrInterface()
        return if (extensionInterface != null && extensionInterface.isInterface)
                extensionInterface
            else
                null
    }

    /**
     * Do the generation without adding the *GenImpl "gap file"
     */
    private fun generateWithoutGap(originalClass: ClassOrInterfaceDeclaration, targetFolderPath: String,
        genSubfolderName: String, targetClassname: String) : Map<String, Pair<String, Node?>> {
        /* Create the *Gen interface and let the original class implement it */
        val genInterface = generationGapDelegate.generateGenInterface(originalClass, genSubfolderName)
        val genInterfaceName = genInterface.nameAsString
        originalClass.addImport(genInterface.fullyQualifiedName.get(), ImportTargetElementType.IMPLEMENTED_INTERFACE)
        originalClass.addImplementedType(genInterfaceName)

        val genInterfaceFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "$genInterfaceName.java"
        genInterface.setFilePath(genInterfaceFilePath)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(originalClass)

        /* Adapt methods */
        originalClass.methods.forEach { originalMethod ->
            val methodWasPulledUpToInterface = genInterface.methods.any { it.name == originalMethod.name }
            if (originalMethod.isOverridable && methodWasPulledUpToInterface)
                originalMethod.addMarkerAnnotation("Override")

            if (originalMethod.emptyBody) {
                val comment =
                    """
                        FIXME If you safely want to implement this method, create an extension interface called 
                        ${originalClass.nameAsString}Ext in the same folder as this class file and run the code 
                        generator again. Otherwise, this file and all your changes to it will probably get overwritten 
                        the next time the code generator is executed.
                    """.trimIndent()

                originalMethod.setBody(
                    """throw new UnsupportedOperationException("Not implemented")""",
                    withBlockComment = " $comment "
                )
            } else if (
                !originalMethod.type.isVoidType &&
                !originalMethod.hasReturnStatement &&
                !originalMethod.hasThrowStatement)
                originalMethod.appendStatement("""throw new UnsupportedOperationException("Not implemented yet");""")
        }

        val originalClassFilePath = "$targetFolderPath${File.separator}$targetClassname.java"
        originalClass.setFilePath(originalClassFilePath)

        /*
         * Do the actual serialization. This needs to be done when all generation methods have run, because there might
         * be adaptations subsequent to class' original generations.
         */
        val results = mutableMapOf<String, Pair<String, Node?>>()
        results[genInterfaceFilePath] = genInterface.serialize(serializationConfiguration) to genInterface
        results[originalClassFilePath] = originalClass.serialize(serializationConfiguration) to originalClass

        return results
    }

    /**
     * Do the generation with the "gap files"
     */
    private fun generateWithGap(originalClass: ClassOrInterfaceDeclaration, extInterface: ClassOrInterfaceDeclaration,
        targetFolderPath: String, genSubfolderName: String, targetClassname: String)
        : Map<String, Pair<String, Node?>> {
        /* Create the *Gen interface */
        val (genInterfaceFilePath, genInterface) = generateGenInterface(originalClass, extInterface, targetFolderPath,
            genSubfolderName)

        /*
         * The original class becomes the *GenImpl class, because it already comprises all elements needed in the
         * *GenImpl class
         */
        val originalClassnameBeforeAdaptation = originalClass.nameAsString
        val originalClassPackageBeforeAdaptation = originalClass.getPackageName()
        val (genImplAdaptationResult, genImplClassFilePath) = adaptToGenImplClass(originalClass, genInterface,
            targetFolderPath, genSubfolderName)

        /* Generate the class for adding custom code */
        val (customImplClassFilePath, customImplClass) = generateCustomImplClass(originalClass,
            genImplAdaptationResult, originalClassnameBeforeAdaptation, originalClassPackageBeforeAdaptation,
            extInterface, targetFolderPath, targetClassname)

        /*
         * Do the actual serialization. This needs to be done when all generation methods have run, because there might
         * be adaptations subsequent to class' original generations.
         */
        val results = mutableMapOf<String, Pair<String, Node?>>()
        results[genInterfaceFilePath] = genInterface.serialize(serializationConfiguration) to genInterface
        results[genImplClassFilePath] = originalClass.serialize(serializationConfiguration) to originalClass
        results[customImplClassFilePath] = customImplClass.serialize(serializationConfiguration) to customImplClass

        return results
    }

    /**
     * Helper to generate the *Gen interface
     */
    private fun generateGenInterface(originalClass: ClassOrInterfaceDeclaration,
        extInterface: ClassOrInterfaceDeclaration, targetFolderPath: String, genSubfolderName: String)
        : Pair<String, ClassOrInterfaceDeclaration> {
        val genInterface = generationGapDelegate.generateGenInterface(originalClass, genSubfolderName)
        genInterface.addImport(extInterface.fullyQualifiedName.get(), ImportTargetElementType.SUPER)
        genInterface.addExtendedType(extInterface.nameAsString)

        val genInterfaceFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${genInterface.nameAsString}.java"
        genInterface.setFilePath(genInterfaceFilePath)
        return genInterfaceFilePath to genInterface
    }

    /**
     * Helper to adapt the original class to become the *GenImpl class
     */
    private fun adaptToGenImplClass(originalClass: ClassOrInterfaceDeclaration,
        genInterface: ClassOrInterfaceDeclaration, targetFolderPath: String, genSubfolderName: String)
        : Pair<GenImplAdaptationResult, String> {
        val genImplAdaptationResult = generationGapDelegate.adaptToGenImplClass(originalClass, genInterface)

        val genImplClassFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${originalClass.nameAsString}.java"
        originalClass.setFilePath(genImplClassFilePath)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(originalClass)

        return genImplAdaptationResult to genImplClassFilePath
    }

    /**
     * Helper to generate the class for adding custom code
     */
    private fun generateCustomImplClass(
        originalClass: ClassOrInterfaceDeclaration,
        genImplAdaptationResult: GenImplAdaptationResult,
        originalClassnameBeforeGenImplAdaptation: String,
        originalClassPackageBeforeGenImplAdaptation: String,
        extInterface: ClassOrInterfaceDeclaration,
        targetFolderPath: String, targetClassname: String)
        : Pair<String, ClassOrInterfaceDeclaration> {
        val customImplClass = generationGapDelegate.generateCustomImplClass(
            originalClass,
            genImplAdaptationResult,
            originalClassnameBeforeGenImplAdaptation,
            originalClassPackageBeforeGenImplAdaptation,
            """
                This class might comprise custom code. It will not be overwritten by the code generator as long as its
                extension interface ${extInterface.nameAsString} exists and the class extends 
                ${originalClass.nameAsString}. As soon as one these circumstances does not happen to be the case 
                anymore, this file will be overwritten, when the code generator is not explicitly invoked with the
                --preserve_existing_files command line option!
            """.trimIndent()
        )

        val classFilePath = "$targetFolderPath${File.separator}$targetClassname.java"
        customImplClass.setFilePath(classFilePath)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(customImplClass)

        // The creation of constructors for the custom implementation class is delayed to the end of the code generation
        // phase when all super-constructors are definitely known
        DelayedConstructors.add(customImplClass)

        return classFilePath to customImplClass
    }

    /**
     * Callback when the end of the code generation phase is reached. Its main purpose is to add missing constructors
     * to generated classes.
     */
    internal fun codeGenerationPhaseCompletedCallback() = generationGapDelegate.codeGenerationPhaseCompletedCallback()
}