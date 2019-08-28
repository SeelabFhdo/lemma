package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.comments.BlockComment
import com.github.javaparser.printer.PrettyPrinter
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getAllImportsForTargetElementsOfType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getFilePath
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.isGeneratedPropertyAccessor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.methodsExcludingPropertyAccessors
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setFilePath
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.countLines
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.countLines
import de.fhdo.lemma.model_processing.utils.toMutableMap
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File
import java.lang.Exception
import java.lang.IllegalArgumentException
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
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String,
        intermediateEObject: EObject, intermediateModelFilePath: String, originalModelFilePath: String)
        : Map<String, String> {
        delegate = ExtendedGenerationGapSerializerBase()
        return delegate.serialize(node, targetFolderPath, targetFilePath)
    }

    /**
     * Adapt generated files after the code generation phase has completed. For instance, add missing constructors to
     * inherited classes
     */
    override fun codeGenerationPhaseCompleted(allGeneratedFiles : Map<String, Pair<String, Charset>>)
        = delegate.codeGenerationPhaseCompletedCallback(allGeneratedFiles)
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
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject,
        intermediateModelFilePath: String, originalModelFilePath: String) : Map<String, String> {
        delegate = ExtendedGenerationGapSerializerBase()
        val serializationResults = delegate.serialize(node, targetFolderPath, targetFilePath)

        serializationResults.forEach{ (path, result) ->
            MainState.addGeneratedLineCountInfo(
                countLines(
                    path to result,
                    intermediateEObject,
                    originalModelFilePath
                )
            )
        }

        return serializationResults
    }

    /**
     * Adapt generated files after the code generation phase has completed. For instance, add missing constructors to
     * inherited classes
     */
    override fun codeGenerationPhaseCompleted(allGeneratedFiles : Map<String, Pair<String, Charset>>)
        : Map<String, String> {
        val adaptedFiles = delegate.codeGenerationPhaseCompletedCallback(allGeneratedFiles)

        // Also adapt existing line count information
        val generatedLineCountInfo: List<LineCountInfo> by MainState
        generatedLineCountInfo.forEach {
            val adaptedContentWithLineCountInfo = adaptedFiles[it.serializationTargetFilePath]
            if (adaptedContentWithLineCountInfo !== null)
                it.serializationResultLineCount = adaptedContentWithLineCountInfo.countLines()
        }

        return adaptedFiles
    }
}

/**
 * [CodeGenerationSerializerI] implementation for the Extended Generation Gap Pattern (cf.
 * [Greifenberg et al.](https://link.springer.com/chapter/10.1007/978-3-319-27869-8_7)). This implementation does the
 * following with the passed [Node]:
 *      - If the node is not a Java class (e.g., an enumeration): Plain serialization.
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
    private val serializationConfiguration: AbstractSerializationConfiguration by inject()

    companion object {
        private const val GENERATION_SUBFOLDER = "gen"
        private const val GEN_IMPL_CLASS_SUFFIX = "GenImpl"
    }

    /**
     * Do the actual serialization according to the Extended Generation Gap Pattern
     */
    fun serialize(node: Node, targetFolderPath: String, targetFilePath: String) : Map<String, String> {
        val originalClass = node.getClassDeclaration()

        /* If the node does not comprise a class (e.g., its an enum) do the plain serialization */
        if (originalClass === null) {
            val generatedCode = node.serialize()
            return mapOf("$targetFolderPath${File.separator}$targetFilePath" to generatedCode)
        }

        /* If the node comprises a class, do the serialization according to the Extended Generated Gap Pattern for it */
        val fullTargetFile = "$targetFolderPath${File.separator}$targetFilePath".asFile()
        val fullTargetFolderPath = fullTargetFile.parent
        val targetClassname = fullTargetFile.nameWithoutExtension

        val extensionInterface = findExtensionInterface(fullTargetFolderPath, targetClassname)
        return if (extensionInterface === null)
                generateWithoutGap(originalClass, fullTargetFolderPath, GENERATION_SUBFOLDER, targetClassname)
            else
                generateWithGap(originalClass, extensionInterface, fullTargetFolderPath, GENERATION_SUBFOLDER,
                    targetClassname)
    }

    /**
     * Try to find the extension interface in the given [folderPath] and for the given [classname]. The extension
     * interface has to reside in a Java file with the same name as [classname] and the "Ext" suffix. Moreover, the
     * extension interface needs to be named after the filename, i.e., [classname] with suffix "Ext".
     */
    private fun findExtensionInterface(folderPath: String, classname: String) : ClassOrInterfaceDeclaration? {
        val extensionFilePath = "$folderPath${File.separator}${classname}Ext.java"
        val extensionInterface = extensionFilePath.asFile().getEponymousJavaClassOrInterface()
        return if (extensionInterface !== null && extensionInterface.isInterface)
                extensionInterface
            else
                null
    }

    /**
     * Helper to get a [ClassOrInterfaceDeclaration] that has the same name as this [File] instance.
     */
    private fun File.getEponymousJavaClassOrInterface()
        = try {
            val parsedCompilationUnit = StaticJavaParser.parse(this)
            parsedCompilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java) {
                it.nameAsString == nameWithoutExtension
            }.orElseGet { null }
        } catch (ex: Exception) {
            null
        }

    /**
     * Do the generation without adding the *GenImpl "gap file"
     */
    private fun generateWithoutGap(originalClass: ClassOrInterfaceDeclaration, targetFolderPath: String,
        genSubfolderName: String, targetClassname: String) : Map<String, String> {
        val generatedFiles = mutableMapOf<String, String>()

        /* Create the *Gen interface and let the original class implement it */
        val genInterface = generateGenInterface(originalClass, genSubfolderName)
        val genInterfaceName = genInterface.nameAsString
        originalClass.addImport(genInterface.fullyQualifiedName.get(), ImportTargetElementType.IMPLEMENTED_INTERFACE)
        originalClass.addImplementedType(genInterfaceName)

        val genInterfaceFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "$genInterfaceName.java"
        genInterface.setFilePath(genInterfaceFilePath)
        generatedFiles[genInterfaceFilePath] = genInterface.serialize()

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(originalClass)

        /*
         * The *Gen interface comprises by definition the signatures of all methods of the original class. They are thus
         * marked as being overridden in the original class. In case the method is not a trivial getter/setter and to
         * prevent syntax errors, we set its body to throw a "not implemented" exception.
         */
        originalClass.methods.forEach {
            it.addMarkerAnnotation("Override")

            if (!it.isGeneratedPropertyAccessor)
                it.setBody(
                    """throw new UnsupportedOperationException("Not implemented");""",
                    withBlockComment = """
                        FIXME If you safely want to implement this method, create an extension interface called 
                        ${originalClass.nameAsString}Ext in the same folder as this class file and run the code 
                        generator again. Otherwise, this file and all your changes to it will probably get overwritten 
                        the next time the code generator is executed.
                    """.trimIndent()
                )
        }

        val originalClassFilePath = "$targetFolderPath${File.separator}$targetClassname.java"
        originalClass.setFilePath(originalClassFilePath)
        generatedFiles[originalClassFilePath] = originalClass.serialize()

        return generatedFiles
    }

    /**
     * Helper to create the *Gen interface
     */
    private fun generateGenInterface(originalClass: ClassOrInterfaceDeclaration, subpackage: String)
        : ClassOrInterfaceDeclaration {
        /*
         * Determine the name and package of the interface. The name corresponds to the name of the original class with
         * the "Gen" suffix. The package corresponds to the package of the original class but including the given
         * sub-package, if any. Eventually, create the actual ClassOrInterfaceDeclaration instance representing the
         * interface.
         */
        val interfaceName = "${originalClass.nameAsString}Gen"
        val interfacePackage = originalClass.getPackageName() + if (subpackage.isNotEmpty()) ".$subpackage" else ""
        val genInterface = newJavaClassOrInterface(interfacePackage, interfaceName, true)

        /*
         * Because the interface comprises all methods of the original class copy all method-related imports to it */
        originalClass.getAllImportsForTargetElementsOfType(ImportTargetElementType.METHOD).forEach {
            genInterface.addImport(it, ImportTargetElementType.METHOD)
        }

        /* Copy all method signatures of the original class */
        originalClass.methods.forEach { method ->
            val methodSignature = genInterface.addMethod(method.nameAsString).removeBody()
            methodSignature.type = method.type
            method.parameters.forEach {
                val parameter = Parameter()
                parameter.setType(it.typeAsString)
                parameter.setName(it.nameAsString)
                methodSignature.addParameter(parameter)
            }
        }

        return genInterface
    }

    /**
     * Do the generation with the "gap files"
     */
    private fun generateWithGap(originalClass: ClassOrInterfaceDeclaration, extInterface: ClassOrInterfaceDeclaration,
        targetFolderPath: String, genSubfolderName: String, targetClassname: String) : Map<String, String> {
        val generatedFiles = mutableMapOf<String, String>()

        /* Create the *Gen interface and let it extend the extension interface */
        val genInterface = generateGenInterface(originalClass, genSubfolderName)
        genInterface.addImport(extInterface.fullyQualifiedName.get(), ImportTargetElementType.SUPER)
        genInterface.addExtendedType(extInterface.nameAsString)

        val genInterfaceFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${genInterface.nameAsString}.java"
        genInterface.setFilePath(genInterfaceFilePath)
        generatedFiles[genInterfaceFilePath] = genInterface.serialize()

        /*
         * The original class becomes the *GenImpl class, because it already comprises all elements needed in the
         * *GenImpl class
         */
        val originalClassnameBeforeAdaptation = originalClass.nameAsString
        val originalClassPackageBeforeAdaptation = originalClass.getPackageName()
        adaptToGenImplClass(originalClass, genInterface)
        val genImplClassFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${originalClass.nameAsString}.java"
        originalClass.setFilePath(genImplClassFilePath)
        generatedFiles[genImplClassFilePath] = originalClass.serialize()

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(originalClass)

        /* Generate the class for adding custom code */
        var customImplClass = generateCustomImplClass(originalClass, originalClassnameBeforeAdaptation,
            originalClassPackageBeforeAdaptation, extInterface.nameAsString)
        val classFilePath = "$targetFolderPath${File.separator}$targetClassname.java"
        customImplClass.setFilePath(classFilePath)
        generatedFiles[classFilePath] = customImplClass.serialize()

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(customImplClass)

        // The creation of constructors for the custom implementation class is delayed to the end of the code generation
        // phase when all super-constructors are definitely known
        DelayedConstructors.add(customImplClass)

        return generatedFiles
    }

    /**
     * Adapt the given class to be compliant with the *GenImpl class as prescribed by the Extended Generation Gap
     * Pattern
     */
    private fun adaptToGenImplClass(genImplClass: ClassOrInterfaceDeclaration,
        genInterface: ClassOrInterfaceDeclaration) {
        /* Adapt name, package, visibility, and let the class implement the *Gen interface */
        genImplClass.setPackageName(genInterface.getPackageName())
        genImplClass.setName("${genImplClass.nameAsString}$GEN_IMPL_CLASS_SUFFIX")
        genImplClass.isAbstract = true
        genImplClass.addImplementedType(genInterface.nameAsString)

        /*
         * In case the class that shall become the *GenImpl class extends a superclass, it gets all imports related to
         * that superclass. However, and for now, its constructors are removed. They will be later added back to the
         * class within codeGenerationPhaseCompletedCallback(). This is necessary, because we only know when all code
         * generations were done, the final "shape" of the superclass comprising its field constructors, which will be
         * called by the *GenImpl class.
         */
        val extendedClass = genImplClass.getSuperclass()
        if (extendedClass !== null) {
            genImplClass.getAllImportsForTargetElementsOfType(ImportTargetElementType.SUPER).forEach {
                genImplClass.addImport(it, ImportTargetElementType.SUPER)
            }

            // Remove constructors and delay their generation
            genImplClass.constructors.forEach { genImplClass.remove(it) }
            DelayedConstructors.add(genImplClass)
        } else
            // In case the class has no superclass, its constructors are just adapted to the new *GenImpl name
            genImplClass.constructors.forEach { it.setName(genImplClass.nameAsString) }

        /*
         * Switch visibility of private fields to protected for convenient access to them in the custom implementation
         * class
         */
        genImplClass.fields.forEach {
            if (it.isPrivate) {
                it.removeModifier(Modifier.Keyword.PRIVATE)
                it.addModifier(Modifier.Keyword.PROTECTED)
            }
        }

        /* Change bodies of non-trivial getters/setters to "not implemented yet" stubs */
        genImplClass.methodsExcludingPropertyAccessors.forEach {
            // The methods of the *Gen interface being implemented by this class are equivalent to its already existing
            // non-trivial getters/setters created by the visiting handlers. Thus, we just add the @Override annotation
            // to them here.
            it.addMarkerAnnotation("Override")

            // In case the method in the original class is private, we make it protected in the adapted *GenImpl class,
            // because otherwise it cannot be overridden with a non-stub body
            if (it.isPrivate) {
                it.removeModifier(Modifier.Keyword.PRIVATE)
                it.addModifier(Modifier.Keyword.PROTECTED)
            }

            // Set "not implemented yet" stub body
            it.setBody("""throw new UnsupportedOperationException("Not implemented yet");""")
        }
    }

    /**
     * Generate the class, which may hold custom code according to the Extended Generation Gap Pattern
     */
    private fun generateCustomImplClass(genImplClass: ClassOrInterfaceDeclaration, classname: String,
        packageName: String, extInterfaceName: String) : ClassOrInterfaceDeclaration {
        /* The class extends the *GenImpl class */
        val customImplClass = newJavaClassOrInterface(packageName, classname)
        customImplClass.setComment(BlockComment(
            """
                This class might comprise custom code. It will not be overwritten by the code generator as long as its
                extension interface $extInterfaceName exists and the class extends ${genImplClass.nameAsString}. As soon
                as one these circumstances does not happen to be the case anymore, this file will be overwritten, when
                the code generator is not explicitly invoked with the --preserve_existing_files command line option!
            """.trimIndent()
        ))
        customImplClass.setSuperclass(genImplClass.fullyQualifiedName.get())

        /* Mark the class to comprise custom code in order to safely distinguish it from other generated classes */
        customImplClass.markAsCustomImpl()

        /*
         * For each non-trivial getter/setter generate a stub delegating implementation that can be replaced with custom
         * code
         */
        genImplClass.methodsExcludingPropertyAccessors.forEach { method ->
            method.addMarkerAnnotation("Override")
            val parameterString = method.parameters.map { it.name }.joinToString()
            method.setBody(
                if (method.type.isVoidType)
                    """super.${method.name}($parameterString);"""
                else
                    """return super.${method.name}($parameterString);""",
                "// TODO Implement me. Will otherwise throw UnsupportedOperationException from super call."
            )
        }

        return customImplClass
    }

    /**
     * Helper to retrieve the [ClassOrInterfaceDeclaration] from a [Node]. This only returns classes, not interfaces.
     */
    private fun Node.getClassDeclaration() : ClassOrInterfaceDeclaration?
        = when(this) {
                is CompilationUnit -> findFirst(ClassOrInterfaceDeclaration::class.java) { !it.isInterface }
                    .orElseGet { null }
                is ClassOrInterfaceDeclaration -> this
                else -> null
            }

    /**
     * Helper to serialize an AST [Node]
     */
    private fun Node.serialize() : String {
        val compilationUnit = when(this) {
            is CompilationUnit -> this
            is ClassOrInterfaceDeclaration -> this.parentNode.get() as CompilationUnit
            else -> throw IllegalArgumentException("Serialization of nodes of type ${this::class.java.name} is not" +
                "supported")
        }

        val prettyPrinter = PrettyPrinter(serializationConfiguration)
        return prettyPrinter.print(compilationUnit)
    }

    /**
     * Callback when the end of the code generation phase is reached. Its main purpose is to add missing constructors
     * to generated classes.
     */
    fun codeGenerationPhaseCompletedCallback(allGeneratedFiles : Map<String, Pair<String, Charset>>)
        : Map<String, String> {
        val adaptedFiles = mutableMapOf<String, String>()

        /*
         * Iterate over the list of missing (delayed constructors), determine the next class to which to add missing
         * constructors (this is always those class with missing constructors at the top of the inheritance hierarchy,
         * because constructor generation must rely on super constructors).
         */
        val classesWithoutConstructors = DelayedConstructors.keys.toMutableList()
        val classesToFullyQualifiedNames = classesWithoutConstructors
            .map { it.fullyQualifiedName.get() to it }
            .toMutableMap()
        while (classesWithoutConstructors.isNotEmpty()) {
            // Determine the class with missing constructors at the top of the inheritance hierarchy
            var nextClass = classesWithoutConstructors.first()
            var nextClassSuperName : String?
            do {
                nextClassSuperName = nextClass.getSuperclass()
                var superWithoutConstructors = if (nextClassSuperName !== null)
                        classesToFullyQualifiedNames[nextClassSuperName]
                    else
                        null

                if (superWithoutConstructors !== null)
                    nextClass = superWithoutConstructors
            } while (superWithoutConstructors !== null)

            // Shrink the lists of classes to do
            val nextClassFullyQualifiedName = nextClass.fullyQualifiedName.get()
            classesWithoutConstructors.remove(nextClass)
            classesToFullyQualifiedNames.remove(nextClassFullyQualifiedName)

            // Add the missing constructors to the next class, based on its superclass, and re-serialize the class
            if (nextClassSuperName !== null) {
                nextClass.addConstructors(AvailableSuperConstructors[nextClassSuperName]!!)
                AvailableSuperConstructors[nextClassFullyQualifiedName] = nextClass.constructors

                val nextClassFilePath = nextClass.getFilePath()!!
                val nextClassFile = nextClassFilePath.asFile()
                // In case the class is the one for custom implementations and already exists, merge the generated one
                // with it
                if (nextClass.isCustomImpl() && comprisesCustomCode(nextClassFile))
                    nextClass = mergeWithExistingCustomImplClass(nextClass, nextClassFile)

                adaptedFiles[nextClassFilePath] = nextClass.serialize()
            }
        }

        return adaptedFiles
    }

    /**
     * Helper to check if the given [customImplFile] comprises custom code. This is likely to be the case if the
     * [ClassOrInterfaceDeclaration] within the [customImplFile] extends its corresponding *GenImpl class.
     */
    private fun comprisesCustomCode(customImplFile: File) : Boolean {
        if (!customImplFile.exists())
            return false

        val existingCustomImplClass = customImplFile.getEponymousJavaClassOrInterface()
        // In case the class comprises syntax errors and could thus not be parsed (which must be the case, because we
        // know here that the file actually exists), it might be safer to not overwrite the existing code, because it
        // was somehow changed already
        if (existingCustomImplClass === null)
            return true

        val expectedGenImplClassname = "${existingCustomImplClass.nameAsString}$GEN_IMPL_CLASS_SUFFIX"
        return expectedGenImplClassname in existingCustomImplClass.extendedTypes.map { it.nameAsString }
    }

    /**
     * Helper to merge the given generated custom implementation class with an already existing one. The merging logic
     * copies constructors and methods of the generated into the existing class.
     */
    private fun mergeWithExistingCustomImplClass(customImplClass: ClassOrInterfaceDeclaration, existingClassFile: File)
        : ClassOrInterfaceDeclaration {
        val existingClass = existingClassFile.getEponymousJavaClassOrInterface()
        if (existingClass === null || existingClass.isInterface)
            throw PhaseException("Could not parse existing custom implementation file ${existingClassFile.path}. " +
                "Either it contains syntax errors or is not a Java class.")

        val missingConstructors = diffCallables(customImplClass.constructors, existingClass.constructors)
        missingConstructors.forEach { it.copyTo(existingClass) }

        val missingMethods = diffCallables(customImplClass.methods, existingClass.methods)
        missingMethods.forEach { it.copyTo(existingClass) }

        return existingClass
    }

    /**
     * Helper to diff two classes based on their [CallableDeclaration] lists, i.e., their constructors or methods. The
     * functions returns all [CallableDeclaration] instances of the [source] list that are not in the [target] list. The
     * diff of the callables is based on their signatures (name and parameter types).
     */
    private fun <T: CallableDeclaration<*>> diffCallables(source: List<T>, target: List<T>) : List<T> {
        val missingCallablesInTarget = mutableListOf<T>()
        val targetSignatures = target.map { targetCallable ->
            val parameterTypesString = targetCallable.parameters.joinToString { it.typeAsString }
            "${targetCallable.name}$parameterTypesString"
        }

        source.forEach { sourceCallable ->
            val parameterTypesString = sourceCallable.parameters.joinToString { it.typeAsString }
            val signatureString = "${sourceCallable.name}$parameterTypesString"
            if (signatureString !in targetSignatures)
                missingCallablesInTarget.add(sourceCallable)
        }

        return missingCallablesInTarget
    }

    /**
     * Helper to copy this [ConstructorDeclaration] to the given [target] [ClassOrInterfaceDeclaration]
     */
    private fun ConstructorDeclaration.copyTo(target: ClassOrInterfaceDeclaration) {
        val copiedConstructor = target.addConstructor()
        copiedConstructor.modifiers = modifiers

        parameters.forEach {
            val parameter = Parameter()
            parameter.setType(it.typeAsString)
            parameter.setName(it.nameAsString)
            copiedConstructor.addParameter(parameter)
        }

        copiedConstructor.body = body
    }

    /**
     * Helper to copy this [MethodDeclaration] to the given [target] [ClassOrInterfaceDeclaration]
     */
    private fun MethodDeclaration.copyTo(target: ClassOrInterfaceDeclaration) {
        val copiedMethod = target.addMethod(name.asString())
        copiedMethod.modifiers = modifiers

        parameters.forEach {
            val parameter = Parameter()
            parameter.setType(it.typeAsString)
            parameter.setName(it.nameAsString)
            copiedMethod.addParameter(parameter)
        }

        copiedMethod.setBody(body.toString())
    }

    /**
     * Helper to add constructors to a class based on a list of [superConstructors]
     */
    private fun ClassOrInterfaceDeclaration.addConstructors(superConstructors: List<ConstructorDeclaration>) {
        // Make sure that each class has an empty constructor
        var emptyConstructorAdded = false

        /*
         * First, create the trivial delegating constructors, i.e., those constructors that invoke super(). There will
         * be a delegating constructor for each super-constructor
         */
        val generatedDelegatingConstructors = mutableListOf<ConstructorDeclaration>()
        superConstructors.forEach { constructor ->
            val delegatingConstructor = addConstructor()
            // Copy modifiers
            delegatingConstructor.modifiers = constructor.modifiers

            // Copy parameters
            val parameterNames = mutableListOf<String>()
            constructor.parameters.forEach {
                parameterNames.add(it.nameAsString)
                val parameter = Parameter()
                parameter.setType(it.typeAsString)
                parameter.setName(it.nameAsString)
                delegatingConstructor.addParameter(parameter)
            }

            // Add delegating body to invoke super() and keep track whether this was an empty constructor
            delegatingConstructor.setBody("""super(${parameterNames.joinToString()});""")
            emptyConstructorAdded = emptyConstructorAdded || constructor.parameters.isEmpty()
            generatedDelegatingConstructors.add(delegatingConstructor)
        }

        /* Add missing empty constructor */
        if (!emptyConstructorAdded)
            addConstructor(Modifier.Keyword.PUBLIC)

        if (fields.isEmpty())
            return

        /*
         * Add constructors for all fields of the class and each delegating super-constructor. That is, field
         * constructors delegate to super constructors, before they initialize the fields of the class.
         */
        // Create a reusable list of parameters for the field constructors
        val allFieldsConstructorParameters = mutableListOf<Parameter>()
        fields.forEach {
            val attribute = it.variables[0]
            val parameter = Parameter()
            parameter.setType(attribute.typeAsString)
            parameter.setName(attribute.nameAsString)
            allFieldsConstructorParameters.add(parameter)
        }

        // Create a delegating field constructor for all previously created delegating constructor
        generatedDelegatingConstructors.forEach { delegatingConstructor ->
            // Create constructor and add parameters
            val allFieldsConstructor = addConstructor(Modifier.Keyword.PUBLIC)
            delegatingConstructor.parameters.forEach { allFieldsConstructor.addParameter(it) }

            // Generate body. The first statement of the body is the same as for the delegating constructor, i.e., its
            // call to super(). After that, all fields of the class get initialized
            val bodyStatements = mutableListOf(delegatingConstructor.body.statements.joinToString { it.toString() })
            allFieldsConstructorParameters.forEach {
                allFieldsConstructor.addParameter(it)
                bodyStatements.add("""this.${it.nameAsString} = ${it.nameAsString};""")
            }
            allFieldsConstructor.setBody(*bodyStatements.toTypedArray())
        }

        AvailableSuperConstructors.addFrom(this)
    }
}

/**
 * Helper object to store all generated constructors of all classes identified by their fully-qualified names.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object AvailableSuperConstructors : HashMap<String, List<ConstructorDeclaration>>() {
    /**
     * Convenience method to add the constructors of the given [clazz]
     */
    fun addFrom(clazz: ClassOrInterfaceDeclaration) {
        this[clazz.fullyQualifiedName.get()] = clazz.constructors
    }
}

/**
 * Helper object to store all classes with delayed constructors that will be added to the after the code generation
 * phase has completed. Assigned to the [ClassOrInterfaceDeclaration] instance is the name of its superclass.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object DelayedConstructors : HashMap<ClassOrInterfaceDeclaration, String>() {
    /**
     * Convenience method to add a new [clazz]
     */
    fun add(clazz: ClassOrInterfaceDeclaration) {
        this[clazz] = clazz.getSuperclass()!!
    }
}

/**
 * Data key that enables to identify custom implementation classes generated by the
 * [ExtendedGenerationGapSerializerBase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object CustomImplMarkerDataKey : DataKey<Boolean>()

/**
 * Mark a [ClassOrInterfaceDeclaration] instance as a custom implementation class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ClassOrInterfaceDeclaration.markAsCustomImpl() {
    if (!containsData(CustomImplMarkerDataKey))
        setData(CustomImplMarkerDataKey, true)
}

/**
 * Check if a [ClassOrInterfaceDeclaration] instance is a custom implementation class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ClassOrInterfaceDeclaration.isCustomImpl()
    = containsData(CustomImplMarkerDataKey) && getData(CustomImplMarkerDataKey)