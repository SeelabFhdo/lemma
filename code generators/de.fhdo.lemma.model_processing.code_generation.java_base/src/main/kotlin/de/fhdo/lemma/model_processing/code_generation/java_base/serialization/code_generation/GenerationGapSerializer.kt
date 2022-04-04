package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.comments.BlockComment
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.ExpressionStmt
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SingleImportInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SuperclassInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImports
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristics
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.clearSerializationCharacteristics
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.copy
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.copySignature
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.createDelegatingConstructor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.diffCallables
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getAllImportsWithSerializationCharacteristics
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.asClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.emptyBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.findParentNode
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getEponymousJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getFilePath
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImportsInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.methodsExcludingPropertyAccessors
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getSerializationCharacteristics
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.insertBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.isOverridable
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.removeImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.serialize
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
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File
import java.nio.charset.Charset

/**
 * Serializes an AST [Node] following the Generation Gap Pattern (cf.
 * [Stahl and Völter](www.voelter.de/data/books/mdsd-en.pdf) and [GenerationGapSerializerBase]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationSerializer("generation-gap")
internal class GenerationGapSerializer : CodeGenerationSerializerI {
    private lateinit var delegate: GenerationGapSerializerBase

    /**
     * Do the serialization (delegates to [GenerationGapSerializerBase])
     */
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject?,
        originalModelFilePath: String?) : Map<String, Pair<String, Node?>> {
        delegate = GenerationGapSerializerBase()
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
 * Serializes an AST [Node] following the Generation Gap Pattern (cf.
 * [Stahl and Völter](www.voelter.de/data/books/mdsd-en.pdf) and [GenerationGapSerializerBase]) and counts the generated
 * LOCs.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationSerializer("generation-gap-loc", true)
internal class CountingGenerationGapSerializer : CodeGenerationSerializerI {
    private lateinit var delegate: GenerationGapSerializerBase

    /**
     * Do the serialization (delegates to [GenerationGapSerializerBase])
     */
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject?,
        originalModelFilePath: String?) : Map<String, Pair<String, Node?>> {
        delegate = GenerationGapSerializerBase()
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
 * [CodeGenerationSerializerI] implementation for the Generation Gap Pattern (cf.
 * [Stahl and Völter](www.voelter.de/data/books/mdsd-en.pdf) and [GenerationGapSerializerBase]). This implementation
 * does the following with the passed [Node]:
 *      - If the node is not a Java class (e.g., an enumeration or interface): Plain serialization.
 *
 *      - If the node is a Java class and its corresponding Java file does not exist, yet (suppose that the original
 *        Java class is called "x_" and shall reside in a file "x_.java"):
 *          - First, generate an interface called "x_Gen" in the file "gen/x_Gen.java". This interface comprises all
 *            method signatures from "x_" and extends the extension interface. Second, generate a class called
 *            "x_GenImpl" in the file "gen/x_GenImpl.java". This class is abstract and implements the "x_Gen" interface.
 *            Third, the "x_" class is adapted to extend the "x_GenImpl" class. Thus, the extends/implements
 *            relationships are the following:
 *                  - <<abstract>> gen/x_GenImpl --|> <<interface>> gen/x_Gen
 *                  - x_ --> <<abstract>> gen/x_GenImpl
 *            Hence, "gen/x_Gen" and "gen/x_GenImpl" can safely be re-generated in case the input model changes, while
 *            "x_" itself is customizable.
 *
 *      - If the node is a Java class and its corresponding Java file does in fact exist:
 *          - In case the extension interface exists, merge new generated constructors and methods into the existing
 *            class. Thus, no custom code will be overridden.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class GenerationGapSerializerBase : KoinComponent {
    private val serializationConfiguration: AbstractSerializationConfiguration by inject()

    companion object {
        internal const val GENERATION_SUBFOLDER = "gen"
        private const val GEN_IMPL_CLASS_SUFFIX = "GenImpl"
    }

    /**
     * Do the actual serialization according to the Generation Gap Pattern
     */
    internal fun serialize(node: Node, targetFolderPath: String, targetFilePath: String)
        : Map<String, Pair<String, Node?>> {
        val originalClass = node.asClassOrInterfaceDeclaration()

        /* If the node does not comprise a class (e.g., it's an enum or interface) do the plain serialization */
        if (originalClass == null || originalClass.isInterface) {
            val generatedCodeToNode = node.serialize(serializationConfiguration) to node
            return mapOf("$targetFolderPath${File.separator}$targetFilePath" to generatedCodeToNode)
        }

        /* If the node comprises a class, do the serialization according to the Generation Gap Pattern */
        val fullTargetFile = "$targetFolderPath${File.separator}$targetFilePath".asFile()
        val fullTargetFolderPath = fullTargetFile.parent
        val targetClassname = fullTargetFile.nameWithoutExtension

        return generate(originalClass, fullTargetFolderPath, GENERATION_SUBFOLDER, targetClassname)
    }

    /**
     * Do the generation with the "gap files"
     */
    private fun generate(originalClass: ClassOrInterfaceDeclaration, targetFolderPath: String,
        genSubfolderName: String, targetClassname: String) : Map<String, Pair<String, Node?>> {
        /* Create the *Gen interface */
        val genInterface = generateGenInterface(originalClass, genSubfolderName)

        val genInterfaceFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${genInterface.nameAsString}.java"
        genInterface.setFilePath(genInterfaceFilePath)

        /*
         * The original class becomes the *GenImpl class, because it already comprises all elements needed in the
         * *GenImpl class
         */
        val originalClassnameBeforeAdaptation = originalClass.nameAsString
        val originalClassPackageBeforeAdaptation = originalClass.getPackageName()
        val originalSerializationCharacteristics = adaptToGenImplClass(originalClass, genInterface)
        val genImplClassFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${originalClass.nameAsString}.java"
        originalClass.setFilePath(genImplClassFilePath)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(originalClass)

        /* Generate the class for adding custom code */
        val customImplClassComment =
            """
                This class might comprise custom code. It will not be overwritten by the code generator as long as it
                extends ${originalClass.nameAsString}. As soon as this is not the case anymore, this file will be 
                overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
                command line option!
            """.trimIndent()
        val customImplClass = generateCustomImplClass(originalClass, originalSerializationCharacteristics,
            originalClassnameBeforeAdaptation, originalClassPackageBeforeAdaptation, " $customImplClassComment ")
        val customImplClassFilePath = "$targetFolderPath${File.separator}$targetClassname.java"
        customImplClass.setFilePath(customImplClassFilePath)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(customImplClass)

        // The creation of constructors for the custom implementation class is delayed to the end of the code generation
        // phase when all super-constructors are definitely known
        DelayedConstructors.add(customImplClass)

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
     * Helper to create the *Gen interface
     */
    internal fun generateGenInterface(originalClass: ClassOrInterfaceDeclaration, subpackage: String)
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

        /* Determine methods from original class to copy */
        val originalMethods = originalClass.methods.filter { it.isRelocatableInGenInterface }
        if (originalMethods.isEmpty())
            return genInterface

        /* Copy all method's import and signatures of the original class to the *Gen interface */
        originalMethods.forEach { method ->
            val neededImports = method.getImportsInfo().filter {
                it.targetElementType == ImportTargetElementType.METHOD && it.isRelocatable
            }
            genInterface.addImports(neededImports)

            genInterface.addMember(method.copySignature())
        }

        return genInterface
    }

    /**
     * Helper property, which determines if a [MethodDeclaration] can be relocated in the *Gen interface
     */
    private val MethodDeclaration.isRelocatableInGenInterface
        get() = isRelocatable && isPublic && !isStatic

    /**
     * Shorthand convenience property to determine if a [Node] is relocatable
     */
    private val Node.isRelocatable
        get() = !hasSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

    /**
     * Shorthand convenience property to determine if a [SingleImportInfo] is relocatable
     */
    private val SingleImportInfo.isRelocatable
        get() = !hasSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

    /**
     * Adapt the given class to be compliant with the *GenImpl class as prescribed by the Generation Gap Pattern
     */
    internal fun adaptToGenImplClass(genImplClass: ClassOrInterfaceDeclaration,
        genInterface: ClassOrInterfaceDeclaration) : GenImplAdaptationResult {
        /*
         * Clear the serialization characteristics. They will be added to the custom implementation class, which will
         * later be generated. That is, because from the perspective of the code generators, they only generate custom
         * implementation classes. However, as we adapt these classes to become the *GenImpl classes for the sake of
         * convenience, we need to move the original serialization characteristics to the custom implementation classes
         * so that they can be treated at their intended locations.
         */
        val serializationCharacteristics = genImplClass.getSerializationCharacteristics()
        genImplClass.clearSerializationCharacteristics()

        /* Adapt name, package, visibility, and let the class implement the *Gen interface */
        val oldPackageName = genImplClass.getPackageName()
        val oldClassname = genImplClass.nameAsString
        genImplClass.setPackageName(genInterface.getPackageName())
        genImplClass.setName("$oldClassname$GEN_IMPL_CLASS_SUFFIX")
        genImplClass.isAbstract = true
        genImplClass.addImplementedType(genInterface.nameAsString)

        // If the package name changed, re-add all imports of the class to make them "visible"
        if (oldPackageName != genImplClass.getPackageName())
            copyAllImports(genImplClass, genImplClass)

        /*
         * In case the class that shall become the *GenImpl class extends a superclass, it gets all imports related to
         * that superclass and possible qualifiers of type parameters that point to the class are adapted to the
         * *GenImpl class. However, the generation of constructors is delayed. They will later be added back to the
         * class within codeGenerationPhaseCompletedCallback(). This is necessary, because we only know when all code
         * generations were done, the final "shape" of the superclass comprising its field constructors.
         */
        genImplClass.constructors.forEach { it.setName(genImplClass.nameAsString) }
        val superclassInfo = genImplClass.getSuperclass()
        if (superclassInfo != null) {
            copyImportsForType(ImportTargetElementType.SUPER, genImplClass, genImplClass)

            // If the superclass has type parameters with qualifiers, e.g., ArrayList<OriginalClassname.NestedClass>,
            // they will be adapted according to the *GenImpl classname, e.g.,
            // ArrayList<OriginalClassnameGenImpl.NestedClass>,
            replaceSuperclassTypeParameterQualifiers(genImplClass, superclassInfo, oldClassname)

            // Delay constructor generation
            DelayedConstructors.add(genImplClass)
        }

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

        /* Adapt methods */
        val methodBodiesToMerge = mutableMapOf<String, BlockStmt>()
        val methodBodiesToDelegate = mutableMapOf<String, BlockStmt>()
        genImplClass.methods.forEach {
            // In case the method in the original class is private, we make it protected in the adapted *GenImpl class,
            // because otherwise it cannot be overridden with a non-stub body
            if (it.isPrivate) {
                it.removeModifier(Modifier.Keyword.PRIVATE)
                it.addModifier(Modifier.Keyword.PROTECTED)
            } else if (it.isRelocatableInGenInterface && it.isOverridable)
                // The methods of the *Gen interface being implemented by this class are equivalent to its already
                // existing public, non-static, methods created by the visiting handlers. Thus, we just add the
                // @Override annotation to them here if it was not already added by code generation handlers (checked by
                // isOverridable()).
                it.addMarkerAnnotation("Override")

            // Collect bodies that need to be merged or delegated upon relocation in the *CustomImpl class
            if (!it.emptyBody) {
                if (it.mergeBodyOnRelocation)
                    methodBodiesToMerge[it.nameAsString] = it.body.get()
                else if (it.delegateBodyOnRelocation)
                    methodBodiesToDelegate[it.nameAsString] = it.body.get()
            }

            // Set "not implemented yet" stub body on methods whose body will delegate in *CustomImpl to *GenImpl
            // classes
            if (it.emptyBody || it.mergeBodyOnRelocation || it.delegateBodyOnRelocation)
                it.setBody("""throw new UnsupportedOperationException("Not implemented yet")""")
        }

        return GenImplAdaptationResult(serializationCharacteristics, methodBodiesToMerge, methodBodiesToDelegate)
    }

    /**
     * Helper to copy all imports from the [source] class/interface to the [target] class/interface
     */
    private fun copyAllImports(source: Node, target: ClassOrInterfaceDeclaration)
        = target.addImports(source.getImportsInfo().getAllImportInfo())

    /**
     * Helper to copy relocatable imports from the [source] class/interface to the [target] class/interface
     */
    private fun copyImportsForType(targetElementType: ImportTargetElementType, source: Node,
        target: ClassOrInterfaceDeclaration, onlyWhenRelocatable: Boolean = false) {
        val imports = source.getImportsInfo().filter {
            val isRelocatable = !onlyWhenRelocatable || it.isRelocatable
            isRelocatable && it.targetElementType == targetElementType
        }
        target.addImports(imports)
    }

    /**
     * Helper to replace qualifiers in type parameters of superclasses with the name of the given [clazz]
     */
    private fun replaceSuperclassTypeParameterQualifiers(clazz : ClassOrInterfaceDeclaration,
        superclassInfo: SuperclassInfo, oldQualifier: String) {
        if (superclassInfo.typeParameters.isEmpty())
            return

        // Replace qualifiers at the beginning of the superclass's type parameters, i.e., ArrayList<OldQualifier.Nested>
        // becomes ArrayList<ClazzName.Nested>
        val newTypeParameters = superclassInfo.typeParameters.map {
            if (it.startsWith("$oldQualifier."))
                it.replaceBefore(".", clazz.nameAsString)
            else
                it
        }

        // Replace old superclass with the new one including the adapted type parameters
        clazz.setSuperclass(superclassInfo.fullyQualifiedClassname, isExternalSuperclass = superclassInfo.isExternal,
            typeParameters = newTypeParameters)
    }

    /**
     * Shorthand convenience property to determine if the body of a [MethodDeclaration] needs to be merged upon
     * relocation
     */
    private val MethodDeclaration.mergeBodyOnRelocation
        get() = body.orElse(null)?.hasSerializationCharacteristic(SerializationCharacteristic.MERGE_ON_RELOCATION)
            ?: false

    /**
     * Shorthand convenience property to determine if the body of a [MethodDeclaration] needs to be delegated upon
     * relocation
     */
    private val MethodDeclaration.delegateBodyOnRelocation
        get() = body.orElse(null)?.hasSerializationCharacteristic(SerializationCharacteristic.DELEGATE_ON_RELOCATION)
            ?: false

    /**
     * Generate the class, which may hold custom code according to the Generation Gap Pattern
     */
    internal fun generateCustomImplClass(genImplClass: ClassOrInterfaceDeclaration,
        genImplAdaptationResult: GenImplAdaptationResult, classname: String, packageName: String,
        comment: String) : ClassOrInterfaceDeclaration {
        /* The class extends the *GenImpl class */
        val customImplClass = newJavaClassOrInterface(packageName, classname)
        customImplClass.addSerializationCharacteristics(genImplAdaptationResult.originalSerializationCharacteristics)
        customImplClass.setComment(BlockComment(comment))
        customImplClass.setSuperclass(genImplClass.fullyQualifiedName.get())

        /* Mark the class to comprise custom code in order to safely distinguish it from other generated classes */
        customImplClass.markAsCustomImpl()

        /*
         * Because the class will receive constructors (cf. codeGenerationPhaseCompletedCallback()) that delegate to the
         * constructors of its superclass, i.e., *GenImpl, copy all imports related to attributes' types. This is
         * necessary due to the *GenImpl class comprising "all-attributes-constructors".
         */
        copyImportsForType(ImportTargetElementType.ATTRIBUTE_TYPE, genImplClass, customImplClass)

        /* Remove imports that exhibit the "remove on relocation" characteristic */
        genImplClass.getAllImportsWithSerializationCharacteristics(SerializationCharacteristic.REMOVE_ON_RELOCATION)
            .forEach { customImplClass.removeImport(it.import, it.targetElementType) }

        /*
         * For each non-trivial getter/setter generate a stub delegating implementation that can be replaced with custom
         * code
         */
        for (originalMethod in genImplClass.methodsExcludingPropertyAccessors) {
            if (originalMethod.isFinal || originalMethod.removeOnRelocation)
                continue

            val method = originalMethod.copy()
            customImplClass.addMember(method)

            // Copy method-related imports
            copyAllImports(originalMethod, customImplClass)

            // If the method is not relocatable, stop right here (after we copied it to the custom implementation class)
            // and remove it from the *GenImpl class. Hence, it won't be relocated, but remain at the implementation
            // class (from the perspective of the code generation result).
            if (!originalMethod.isRelocatable) {
                genImplClass.members.remove(originalMethod)
                continue
            }

            // When the method is relocatable, remove members depending on their serialization characteristics
            removeNotRelocatableElements(originalMethod)
            removeElementsFromGeneratedMethodOnRelocation(originalMethod, method)

            // Create body of the method that delegated to the relocated version in the *GenImpl class
            if (method.isPublic && method.isOverridable)
                method.addMarkerAnnotation("Override")
            val parameterString = method.parameters.map { it.name }.joinToString()
            val delegatingClassName = if (!method.isStatic) "super" else genImplClass.nameAsString
            method.setBody(
                if (method.type.isVoidType)
                    "$delegatingClassName.${method.name}($parameterString)"
                else
                    "return $delegatingClassName.${method.name}($parameterString)",
                " TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call."
            )

            // Adapt method bodies, if specified by code generators
            mergeBodyIfSpecified(method, genImplAdaptationResult)
            delegateBodyIfSpecified(method, genImplAdaptationResult)
        }

        /* Undo element top-level relocations, if necessary */
        undoTopLevelElementRelocations(genImplClass, customImplClass)

        /* Remove top-level elements that exhibit the "remove on relocation" serialization characteristic */
        removeTopLevelElementsOnRelocation(genImplClass, customImplClass)

        /* Keep top-level elements that exhibit the "keep on relocation" serialization characteristic */
        keepTopLevelElementsOnRelocation(genImplClass, customImplClass)

        return customImplClass
    }

    /**
     * Shorthand convenience property to determine if a [Node] needs to be removed upon relocation
     */
    private val Node.removeOnRelocation
        get() = hasSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

    /**
     * Helper to remove not relocatable elements from a [MethodDeclaration]
     */
    private fun removeNotRelocatableElements(method: MethodDeclaration) {
        // Method annotations
        method.annotations.removeAll(method.annotations.filter { !it.isRelocatable })

        // Parameter annotations
        val notRelocatableParameterAnnotations = method.parameters
            .map { it.annotations }.flatten()
            .filter { !it.isRelocatable }
        method.parameters.forEach { it.annotations.removeAll(notRelocatableParameterAnnotations) }
    }

    /**
     * Helper to remove elements of the [originalMethod] that exhibit the serialization characteristic "remove on
     * relocation" from the [generatedMethod]
     */
    private fun removeElementsFromGeneratedMethodOnRelocation(originalMethod: MethodDeclaration,
        generatedMethod: MethodDeclaration) {
        // Method annotations
        val annotationsToRemove = originalMethod.annotations
            .filter { it.removeOnRelocation }
            .map { it.nameAsString }
        generatedMethod.annotations.removeAll(generatedMethod.annotations.filter {
            it.nameAsString in annotationsToRemove
        })

        // Parameter annotations
        val parameterAnnotationsToRemove = originalMethod.parameters
            .map { it.annotations }.flatten()
            .filter { it.removeOnRelocation }
        generatedMethod.parameters.forEach { it.annotations.removeAll(parameterAnnotationsToRemove) }
    }

    /**
     * Helper to merge the body of the given [method] with a body created by code generators. This only happens when
     * code generators specify the "merge on relocation" serialization characteristic on the method's body.
     */
    private fun mergeBodyIfSpecified(method: MethodDeclaration, genImplAdaptationResult: GenImplAdaptationResult) {
        val bodyToMerge = genImplAdaptationResult.methodBodiesToMerge[method.nameAsString]
        if (bodyToMerge != null)
            method.insertBody(bodyToMerge)
    }

    /**
     * Helper to adapt method-call-statements in the body of the given [method] so that they delegate to the body of the
     * the relocated version of the [method]. This only happens when code generators specify the "delegate on
     * relocation" serialization characteristic on the method's body.
     */
    private fun delegateBodyIfSpecified(method: MethodDeclaration, genImplAdaptationResult: GenImplAdaptationResult) {
        val bodyToDelegate = genImplAdaptationResult.methodBodiesToDelegate[method.nameAsString] ?: return
        method.insertBody(bodyToDelegate, adaptStatementBeforeInsertion = {
            if (it is ExpressionStmt && it.expression.isMethodCallExpr) {
                var delegatingMethodCall = it.expression.toString()
                if (!delegatingMethodCall.startsWith("super."))
                    delegatingMethodCall = "super.$delegatingMethodCall"
                it.setExpression(delegatingMethodCall)
            }

            it
        })
    }

    /**
     * Helper to remove relocated top-level elements from the [originalClass] and add them to the [generatedClass],
     * i.e., from the perspective of the code generation result, they were never relocated
     */
    private fun undoTopLevelElementRelocations(originalClass: ClassOrInterfaceDeclaration,
        generatedClass: ClassOrInterfaceDeclaration) {
        // Class imports
        val notRelocatableImports = originalClass
            .getAllImportsWithSerializationCharacteristics(SerializationCharacteristic.DONT_RELOCATE)
        notRelocatableImports.forEach {
            generatedClass.addImport(it.import, it.targetElementType)
            originalClass.removeImport(it.import, it.targetElementType)
        }

        // Class annotations
        val notRelocatableAnnotations = originalClass.annotations.filter { !it.isRelocatable }
        notRelocatableAnnotations.forEach {
            generatedClass.addAnnotation(it)
            originalClass.remove(it)
        }

        // Attributes
        val notRelocatableAttributes = originalClass.fields.filter { !it.isRelocatable }
        notRelocatableAttributes.forEach {
            generatedClass.members.addFirst(it)
            originalClass.remove(it)
        }
    }

    /**
     * Remove top-level elements, which exhibit the "remove on relocation" serialization characteristic in the
     * [originalClass], from the [generatedClass]
     */
    private fun removeTopLevelElementsOnRelocation(originalClass: ClassOrInterfaceDeclaration,
        generatedClass: ClassOrInterfaceDeclaration) {
        // Class imports
        val importsToRemove = originalClass
            .getAllImportsWithSerializationCharacteristics(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        importsToRemove.forEach { generatedClass.removeImport(it.import, it.targetElementType) }

        // Class annotations
        val annotationsToRemove = originalClass.annotations.filter { it.removeOnRelocation }
        annotationsToRemove.forEach { generatedClass.remove(it) }
    }

    /**
     * Keep top-level elements, which exhibit the "keep on relocation" serialization characteristic in the
     * [originalClass], in the [generatedClass]
     */
    private fun keepTopLevelElementsOnRelocation(originalClass: ClassOrInterfaceDeclaration,
        generatedClass: ClassOrInterfaceDeclaration) {
        // Class imports
        val keepImports = originalClass
            .getAllImportsWithSerializationCharacteristics(SerializationCharacteristic.KEEP_ON_RELOCATION)
        keepImports.forEach { generatedClass.addImport(it.import, it.targetElementType) }

        // Class annotations
        val keepAnnotations = originalClass.annotations.filter {
            it.hasSerializationCharacteristic(SerializationCharacteristic.KEEP_ON_RELOCATION)
        }
        keepAnnotations.forEach { generatedClass.addAnnotation(it) }
    }

    /**
     * Callback when the end of the code generation phase is reached. Its main purpose is to add constructors to
     * generated classes.
     */
    internal fun codeGenerationPhaseCompletedCallback() : Map<String, String> {
        val adaptedFiles = mutableMapOf<String, String>()

        /*
         * Iterate over the list of delayed constructors, determine the next class to which to add constructors (this is
         * always the class with delayed constructors at the top of the inheritance hierarchy, because constructor
         * generation must rely on super constructors).
         */
        val classesTodo = DelayedConstructors.keys.toMutableList()
        while (classesTodo.isNotEmpty()) {
            // Determine the class with delayed constructors at the top of the inheritance hierarchy. This class will
            // then get parsed again, because between its initial treatment by the serializer and this point in time it
            // might have been adapted again by Genlets that listen to, e.g., the Microservice Generation Finished event
            var nextClass = DelayedConstructors.getClass(classesTodo.first())!!
            var nextClassSuperName : String?
            do {
                nextClassSuperName = nextClass.getSuperclass()?.fullyQualifiedClassname
                val superWithDelayedConstructors = if (nextClassSuperName != null && nextClassSuperName in classesTodo)
                        DelayedConstructors.getClass(nextClassSuperName)
                    else
                        null

                if (superWithDelayedConstructors != null)
                    nextClass = superWithDelayedConstructors
            } while (superWithDelayedConstructors != null)

            // Shrink the lists of classes to do
            val nextClassFullyQualifiedName = nextClass.fullyQualifiedName.get()
            classesTodo.remove(nextClassFullyQualifiedName)

            if (nextClassSuperName == null)
                continue

            // Add constructors to the next class, if not otherwise stated by code generators
            if (!nextClass.hasSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)) {
                nextClass.addConstructors(nextClassSuperName)
                AvailableSuperConstructors[nextClassFullyQualifiedName] = nextClass.constructors
            }

            val nextClassFilePath = nextClass.getFilePath()!!
            val nextClassFile = nextClassFilePath.asFile()

            // In case the class is the one for custom implementations and already exists, merge the generated one with
            // it
            if (nextClass.isCustomImpl() && comprisesCustomCode(nextClassFile))
                nextClass = mergeWithExistingCustomImplClass(nextClass, nextClassFile)

            adaptedFiles[nextClassFilePath] = nextClass.serialize(serializationConfiguration)
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

        // In case the class comprises syntax errors and could thus not be parsed (which must be the case, because we
        // know here that the file actually exists), it might be safer to not overwrite the existing code, because it
        // was somehow changed already
        val existingCustomImplClass = customImplFile.getEponymousJavaClassOrInterface() ?: return true

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
        if (existingClass == null || existingClass.isInterface)
            throw PhaseException("Could not parse existing custom implementation file ${existingClassFile.path}. " +
                "It either contains syntax errors or is not a Java class.")

        val missingConstructors = diffCallables(customImplClass.constructors, existingClass.constructors)
        missingConstructors.forEach { existingClass.members.add(it) }

        val missingMethods = diffCallables(customImplClass.methods, existingClass.methods)
        missingMethods.forEach { existingClass.members.add(it) }

        // Merge possibly missing imports related to callables (import target element type METHOD)
        val existingCompilationUnit = existingClass.findParentNode<CompilationUnit>() ?: return existingClass
        val existingImports = existingCompilationUnit.imports.map { it.nameAsString }
        val customImplCallableImports = customImplClass.getImportsInfo()
            .filter {
                it.targetElementType == ImportTargetElementType.METHOD ||
                it.targetElementType == ImportTargetElementType.METHOD_BODY
            }
            .map { it.import }
        val missingImports = customImplCallableImports.minus(existingImports)
        missingImports.forEach { existingCompilationUnit.addImport(it) }

        return existingClass
    }

    /**
     * Helper to add constructors to a class based on its superclass
     */
    private fun ClassOrInterfaceDeclaration.addConstructors(superclassName: String) {
        var parameterlessConstructorAdded = false
        val hasExternalSuperclass = getSuperclass()?.isExternal ?: false
        val keepAlreadyExistingConstructors = !isCustomImpl() && hasExternalSuperclass
        val onlyAddDelegatingConstructors = isCustomImpl() && (getSuperSuperclass()?.isExternal ?: false)

        /*
         * We keep already existing constructors in case the class is not a *CustomImpl class and has an external
         * superclass, e.g., ArrayList or RuntimeException. In that case, we can't add any sensible constructors but
         * simply rely on the constructors being provided by code generators.
         */
        if (keepAlreadyExistingConstructors)
            return

        /*
         * We add only delegating constructors to custom implementation classes, whose *GenImpl superclass is an
         * external class and not a class being created by code generators. That is, we rely on the constructors being
         * provided by *GenImpl classes solely.
         */
        if (!onlyAddDelegatingConstructors)
            constructors.forEach { remove(it) }

        /*
         * Create the trivial delegating constructors, i.e., those constructors that invoke super(). There will be a
         * delegating constructor for each super-constructor.
         */
        val generatedDelegatingConstructors = mutableListOf<ConstructorDeclaration>()
        val superConstructors = AvailableSuperConstructors[superclassName]!!
        superConstructors.forEach {
            val delegatingConstructor = it.createDelegatingConstructor(nameAsString)
            addMember(delegatingConstructor)
            generatedDelegatingConstructors.add(delegatingConstructor)

            parameterlessConstructorAdded = parameterlessConstructorAdded || it.parameters.isEmpty()
        }

        if (onlyAddDelegatingConstructors)
            return

        /* Add missing parameterless constructor */
        if (!parameterlessConstructorAdded)
            addConstructor(Modifier.Keyword.PUBLIC)

        /*
         * Add constructors for all fields (if any) of the class and each delegating super-constructor. That is, field
         * constructors delegate to super constructors, before they initialize the fields of the class.
         */
        if (fields.isEmpty())
            return

        // Create a reusable list of parameters for the field constructors
        val allFieldsConstructorParameters = mutableListOf<Parameter>()
        attributes.forEach {
            val parameter = Parameter()
            parameter.setType(it.typeAsString)
            parameter.setName(it.nameAsString)
            allFieldsConstructorParameters.add(parameter)
        }

        // Create a delegating field constructor for all previously created delegating constructors
        generatedDelegatingConstructors.forEach { delegatingConstructor ->
            // Create constructor and add parameters
            val allFieldsConstructor = addConstructor(Modifier.Keyword.PUBLIC)
            delegatingConstructor.parameters.forEach { allFieldsConstructor.addParameter(it) }

            // Generate body. The first statement of the body is the same as for the delegating constructor, i.e., its
            // call to super(). After that, all fields of the class get initialized
            val bodyStatements = mutableListOf(delegatingConstructor.body.statements.joinToString { it.toString() })
            allFieldsConstructorParameters.forEach {
                allFieldsConstructor.addParameter(it)
                bodyStatements.add("this.${it.nameAsString} = ${it.nameAsString};")
            }
            allFieldsConstructor.setBody(*bodyStatements.toTypedArray())
        }

        AvailableSuperConstructors.addFrom(this)
    }

    /**
     * The superclass of the superclass of this [ClassOrInterfaceDeclaration]
     */
    private fun ClassOrInterfaceDeclaration.getSuperSuperclass() : SuperclassInfo? {
        val superclassInfo = getSuperclass() ?: return null
        val superclass = DelayedConstructors.getClass(superclassInfo.fullyQualifiedClassname) ?: return null
        return superclass.getSuperclass()
    }
}

/**
 * Helper object to store all generated constructors of all classes identified by their fully-qualified names.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object AvailableSuperConstructors : HashMap<String, List<ConstructorDeclaration>>() {
    /**
     * Convenience method to add the constructors of the given [clazz]
     */
    fun addFrom(clazz: ClassOrInterfaceDeclaration) {
        this[clazz.fullyQualifiedName.get()] = clazz.constructors
    }
}

/**
 * Helper object to store all classes with delayed constructors that will be added to classes after the code generation
 * phase has completed. Assigned to the class with delayed constructors is the name of its superclass.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object DelayedConstructors : HashMap<String, Pair<ClassOrInterfaceDeclaration, String>>() {
    /**
     * Convenience method to add a new [clazz]
     */
    fun add(clazz: ClassOrInterfaceDeclaration) {
        val superclassName = clazz.getSuperclass()!!.fullyQualifiedClassname
        this[clazz.fullyQualifiedName.get()] = clazz to superclassName
    }

    /**
     * Convenience method to get a [ClassOrInterfaceDeclaration] with delayed constructors named
     * [fullyQualifiedClassname]
     */
    fun getClass(fullyQualifiedClassname: String) : ClassOrInterfaceDeclaration? = this[fullyQualifiedClassname]?.first
}

/**
 * Data key that enables to identify custom implementation classes generated by the [GenerationGapSerializerBase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object CustomImplMarkerDataKey : DataKey<Boolean>()

/**
 * Mark a [ClassOrInterfaceDeclaration] instance as a custom implementation class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.markAsCustomImpl() {
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

/**
 * Represents parts of the result of adapting a given class to the *GenImpl class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class GenImplAdaptationResult(val originalSerializationCharacteristics: Set<SerializationCharacteristic>,
    val methodBodiesToMerge: Map<String, BlockStmt>, val methodBodiesToDelegate: Map<String, BlockStmt>)