package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.comments.BlockComment
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SuperclassInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.diffCallables
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getAllImportsForTargetElementsOfType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getClassDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getEponymousJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getFilePath
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getNodeImports
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.methodsExcludingPropertyAccessors
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
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
import de.fhdo.lemma.model_processing.utils.toMutableMap
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
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String,
        intermediateEObject: EObject, intermediateModelFilePath: String, originalModelFilePath: String)
        : Map<String, String> {
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
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject,
        intermediateModelFilePath: String, originalModelFilePath: String) : Map<String, String> {
        delegate = GenerationGapSerializerBase()
        val serializationResults = delegate.serialize(node, targetFolderPath, targetFilePath)

        serializationResults.forEach{ (path, result) ->
            MainState.addOrUpdateGeneratedLineCountInfo(
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
                it.serializationResultLineCount = adaptedContentWithLineCountInfo.countLines()
        }

        return adaptedFiles
    }
}

/**
 * [CodeGenerationSerializerI] implementation for the Generation Gap Pattern (cf.
 * [Stahl and Völter](www.voelter.de/data/books/mdsd-en.pdf) and [GenerationGapSerializerBase]). This implementation
 * does the following with the passed [Node]:
 *      - If the node is not a Java class (e.g., an enumeration): Plain serialization.
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
    internal fun serialize(node: Node, targetFolderPath: String, targetFilePath: String) : Map<String, String> {
        val originalClass = node.getClassDeclaration()

        /* If the node does not comprise a class (e.g., its an enum) do the plain serialization */
        if (originalClass == null) {
            val generatedCode = node.serialize(serializationConfiguration)
            return mapOf("$targetFolderPath${File.separator}$targetFilePath" to generatedCode)
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
        genSubfolderName: String, targetClassname: String) : Map<String, String> {
        val generatedFiles = mutableMapOf<String, String>()

        /* Create the *Gen interface */
        val genInterface = generateGenInterface(originalClass, genSubfolderName)

        val genInterfaceFilePath = "$targetFolderPath${File.separator}$genSubfolderName${File.separator}" +
            "${genInterface.nameAsString}.java"
        genInterface.setFilePath(genInterfaceFilePath)
        generatedFiles[genInterfaceFilePath] = genInterface.serialize(serializationConfiguration)

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
        generatedFiles[genImplClassFilePath] = originalClass.serialize(serializationConfiguration)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(originalClass)

        /* Generate the class for adding custom code */
        var customImplClass = generateCustomImplClass(originalClass, originalClassnameBeforeAdaptation,
            originalClassPackageBeforeAdaptation,
            """
                This class might comprise custom code. It will not be overwritten by the code generator as long as it
                extends ${originalClass.nameAsString}. As soon as this is not the case anymore, this file will be 
                overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
                command line option!
            """.trimIndent()
        )
        val classFilePath = "$targetFolderPath${File.separator}$targetClassname.java"
        customImplClass.setFilePath(classFilePath)
        generatedFiles[classFilePath] = customImplClass.serialize(serializationConfiguration)

        // Collect all constructors of the class in order to enable codeGenerationPhaseCompletedCallback() to derive
        // delegating super-constructors from them if necessary
        AvailableSuperConstructors.addFrom(customImplClass)

        // The creation of constructors for the custom implementation class is delayed to the end of the code generation
        // phase when all super-constructors are definitely known
        DelayedConstructors.add(customImplClass)

        return generatedFiles
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

        /* Because the interface comprises all methods of the original class, copy all method-related imports to it */
        originalClass.getAllImportsForTargetElementsOfType(ImportTargetElementType.METHOD).forEach {
            genInterface.addImport(it, ImportTargetElementType.METHOD)
        }

        /* Copy all method signatures of the original class */
        originalClass.methods.filter { it.isPublic }.forEach { method ->
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
     * Adapt the given class to be compliant with the *GenImpl class as prescribed by the Generation Gap Pattern
     */
    internal fun adaptToGenImplClass(genImplClass: ClassOrInterfaceDeclaration,
        genInterface: ClassOrInterfaceDeclaration) {
        val oldPackageName = genImplClass.getPackageName()
        val oldClassname = genImplClass.nameAsString

        /* Adapt name, package, visibility, and let the class implement the *Gen interface */
        genImplClass.setPackageName(genInterface.getPackageName())
        genImplClass.setName("$oldClassname$GEN_IMPL_CLASS_SUFFIX")
        genImplClass.isAbstract = true
        genImplClass.addImplementedType(genInterface.nameAsString)

        // If the package name changed, re-add all imports of the class to make them "visible"
        if (oldPackageName != genImplClass.getPackageName())
            ImportTargetElementType.values().forEach { targetElementType ->
                val importsOfTargetElementType = genImplClass.getAllImportsForTargetElementsOfType(targetElementType)
                importsOfTargetElementType.forEach { genImplClass.addImport(it, targetElementType) }
            }

        /*
         * In case the class that shall become the *GenImpl class extends a superclass, it gets all imports related to
         * that superclass and possible qualifiers of type parameters that point to the class are adapted to the
         * *GenImpl class. However, and for now, the constructors of the original class are removed. They will be later
         * added back to the class within codeGenerationPhaseCompletedCallback(). This is necessary, because we only
         * know when all code generations were done, the final "shape" of the superclass comprising its field
         * constructors, which will be called by the *GenImpl class.
         */
        val superclassInfo = genImplClass.getSuperclass()
        if (superclassInfo != null) {
            genImplClass.getAllImportsForTargetElementsOfType(ImportTargetElementType.SUPER).forEach {
                genImplClass.addImport(it, ImportTargetElementType.SUPER)
            }

            // If the superclass has type parameters with qualifiers, e.g., ArrayList<OriginalClassname.NestedClass>,
            // the will be adapted according to the *GenImpl classname, e.g.,
            // ArrayList<OriginalClassnameGenImpl.NestedClass>,
            replaceSuperclassTypeParameterQualifiers(genImplClass, superclassInfo, oldClassname)

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
            // In case the method in the original class is private, we make it protected in the adapted *GenImpl class,
            // because otherwise it cannot be overridden with a non-stub body
            if (it.isPrivate) {
                it.removeModifier(Modifier.Keyword.PRIVATE)
                it.addModifier(Modifier.Keyword.PROTECTED)
            } else
                // The methods of the *Gen interface being implemented by this class are equivalent to its already
                // existing non-private, non-trivial getters/setters created by the visiting handlers. Thus, we just add
                // the @Override annotation to them here.
                it.addMarkerAnnotation("Override")

            // Set "not implemented yet" stub body
            it.setBody("""throw new UnsupportedOperationException("Not implemented yet");""")
        }
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
        clazz.setSuperclass(superclassInfo.fullyQualifiedClassname, newTypeParameters)
    }

    /**
     * Generate the class, which may hold custom code according to the Generation Gap Pattern
     */
    internal fun generateCustomImplClass(genImplClass: ClassOrInterfaceDeclaration, classname: String,
        packageName: String, comment: String) : ClassOrInterfaceDeclaration {
        /* The class extends the *GenImpl class */
        val customImplClass = newJavaClassOrInterface(packageName, classname)
        customImplClass.setComment(BlockComment(comment))
        customImplClass.setSuperclass(genImplClass.fullyQualifiedName.get())

        /* Mark the class to comprise custom code in order to safely distinguish it from other generated classes */
        customImplClass.markAsCustomImpl()

        /*
         * Because the class will receive constructors (cf. codeGenerationPhaseCompletedCallback()) that delegate to the
         * constructors of its superclass, i.e., *GenImpl, copy all imports related to attributes' types. This is
         * necessary due to the *GenImpl class comprising "all-attributes-constructors".
         */
        genImplClass.getAllImportsForTargetElementsOfType(ImportTargetElementType.ATTRIBUTE_TYPE).forEach {
            customImplClass.addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE)
        }

        /*
         * For each non-trivial getter/setter generate a stub delegating implementation that can be replaced with custom
         * code
         */
        genImplClass.methodsExcludingPropertyAccessors.forEach { method ->
            // Copy method-related imports
            method.getNodeImports().forEach { (import, targetElementTypes) ->
                targetElementTypes.forEach { customImplClass.addImport(import, it) }
            }

            if (!method.annotations.map { it.nameAsString }.contains("Override"))
                method.addMarkerAnnotation("Override")
            val parameterString = method.parameters.map { it.name }.joinToString()
            method.setBody(
                if (method.type.isVoidType)
                    """super.${method.name}($parameterString);"""
                else
                    """return super.${method.name}($parameterString);""",
                "TODO Implement me. Will otherwise throw UnsupportedOperationException from super call."
            )
            customImplClass.members.add(method)
        }

        return customImplClass
    }

    /**
     * Callback when the end of the code generation phase is reached. Its main purpose is to add missing constructors
     * to generated classes.
     */
    internal fun codeGenerationPhaseCompletedCallback() : Map<String, String> {
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
                nextClassSuperName = nextClass.getSuperclass()?.fullyQualifiedClassname
                var superWithoutConstructors = if (nextClassSuperName != null)
                        classesToFullyQualifiedNames[nextClassSuperName]
                    else
                        null

                if (superWithoutConstructors != null)
                    nextClass = superWithoutConstructors
            } while (superWithoutConstructors != null)

            // Shrink the lists of classes to do
            val nextClassFullyQualifiedName = nextClass.fullyQualifiedName.get()
            classesWithoutConstructors.remove(nextClass)
            classesToFullyQualifiedNames.remove(nextClassFullyQualifiedName)

            if (nextClassSuperName == null)
                continue

            // Determine the missing constructors from the list of available constructors. There might be no available
            // constructors, e.g., when the superclass is from the Collections Framework and thus from Java's standard
            // library
            val missingConstructors = AvailableSuperConstructors[nextClassSuperName] ?: continue

            // Add the missing constructors to the next class, based on its superclass, and re-serialize the class
            nextClass.addConstructors(missingConstructors)
            AvailableSuperConstructors[nextClassFullyQualifiedName] = nextClass.constructors

            val nextClassFilePath = nextClass.getFilePath()!!
            val nextClassFile = nextClassFilePath.asFile()
            // In case the class is the one for custom implementations and already exists, merge the generated one
            // with it
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
                "Either it contains syntax errors or is not a Java class.")

        val missingConstructors = diffCallables(customImplClass.constructors, existingClass.constructors)
        missingConstructors.forEach { existingClass.members.add(it) }

        val missingMethods = diffCallables(customImplClass.methods, existingClass.methods)
        missingMethods.forEach { existingClass.members.add(it) }

        return existingClass
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
        attributes.forEach {
            val parameter = Parameter()
            parameter.setType(it.typeAsString)
            parameter.setName(it.nameAsString)
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
internal object AvailableSuperConstructors : HashMap<String, List<ConstructorDeclaration>>() {
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
internal object DelayedConstructors : HashMap<ClassOrInterfaceDeclaration, String>() {
    /**
     * Convenience method to add a new [clazz]
     */
    fun add(clazz: ClassOrInterfaceDeclaration) {
        this[clazz] = clazz.getSuperclass()!!.fullyQualifiedClassname
    }
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
internal fun ClassOrInterfaceDeclaration.isCustomImpl()
    = containsData(CustomImplMarkerDataKey) && getData(CustomImplMarkerDataKey)