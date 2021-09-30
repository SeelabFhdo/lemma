package de.fhdo.lemma.data.tests

import com.google.inject.Inject
import de.fhdo.lemma.data.DataModel
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import de.fhdo.lemma.data.DataPackage
import org.junit.BeforeClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.diagnostics.Severity

import static de.fhdo.lemma.data.DataPackage.Literals.*
import org.eclipse.emf.ecore.EClass
import java.util.List
import de.fhdo.lemma.utils.LemmaUtils
import java.io.File
import java.io.FileInputStream
import org.eclipse.emf.common.util.URI
import com.google.inject.Provider
import org.eclipse.xtext.resource.XtextResourceSet
import java.nio.file.Paths
import de.fhdo.lemma.xtext.test.utils.ExtendedValidationTestHelper
import de.fhdo.lemma.xtext.test.utils.ExpectedIssue
import de.fhdo.lemma.xtext.test.utils.WorkspaceClosedAwareRunner

/**
 * Test class for LEMMA's Domain Data Modeling Language.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@RunWith(WorkspaceClosedAwareRunner)
@InjectWith(ValidationTestHelperInjectorProvider)
class DataDslParsingTest {
    @Inject
    Provider<XtextResourceSet> resourceSetProvider;

    @Inject
    ParseHelper<DataModel> parseHelper

    @Inject
    ExtendedValidationTestHelper validationTestHelper

    /**
     * Register EPackages required for model parsing and language testing
     */
    @BeforeClass
    static def void registerEcorePackages() {
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
    }

    @Test
    def void duplicateImportAlias() {
        val model = parseTestModel("DuplicateImportAlias.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE_IMPORT, null, "Duplicate import alias")
    }

    /**
     * Helper to parse a test model from the "models" package of the test project
     */
    private def parseTestModel(String relativeModelPath) {
        val resourcePath = '''/«class.packageName.replace('.', '/')»/models/«relativeModelPath»'''
        val resourceUrl = class.getResource(resourcePath)
        if (resourceUrl === null)
            throw new IllegalArgumentException('''Resource «resourcePath» does not exist''')

        val uri = resourceUrl.toURI()
        val filePath = Paths.get(uri).toFile().absolutePath
        val fis = new FileInputStream(new File(filePath))
        return parseHelper.parse(fis, URI.createURI(LemmaUtils.convertToFileUri(filePath)),
            newHashMap, resourceSetProvider.get())
    }

    @Test
    def void duplicateImportFile() {
        val model = parseTestModel("DuplicateImportFile.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE_IMPORT, null, "File is already " +
            "being imported")
    }

    @Test
    def void wrongImportModelKind() {
        val model = parseTestModel("WrongImportModelKind.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE_IMPORT, null, "File does not " +
            "contain a data model definition")
    }

    @Test
    def void validImports() {
        validationTestHelper.assertNoIssues(parseTestModel("ValidImports.data"))
    }

    @Test
    def void duplicateVersion() {
        val model = parseTestModel("DuplicateVersion.data")
        validationTestHelper.assertError(model, VERSION, null, "Duplicate version")
    }

    @Test
    def void duplicateTopLevelContext() {
        val model = parseTestModel("DuplicateTopLevelContext.data")
        validationTestHelper.assertError(model, CONTEXT, null, "Duplicate context")
    }

    @Test
    def void duplicateTopLevelType() {
        val model = parseTestModel("DuplicateTopLevelType.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE, null, "Duplicate complex type")
    }

    @Test
    def void duplicateVersionContext() {
        val model = parseTestModel("DuplicateVersionContext.data")
        validationTestHelper.assertError(model, CONTEXT, null, "Duplicate context")
    }

    @Test
    def void duplicateVersionType() {
        val model = parseTestModel("DuplicateVersionType.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE, null, "Duplicate complex type")
    }

    @Test
    def void duplicateContextType() {
        val model = parseTestModel("DuplicateContextType.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE, null, "Duplicate complex type")
    }

    @Test
    def void duplicateFunctionParameter() {
        val model = parseTestModel("DuplicateFunctionParameter.data")
        validationTestHelper.assertError(model, DATA_OPERATION_PARAMETER, null, "Duplicate " +
            "parameter")
    }

    @Test
    def void duplicateProcedureParameter() {
        val model = parseTestModel("DuplicateProcedureParameter.data")
        validationTestHelper.assertError(model, DATA_OPERATION_PARAMETER, null, "Duplicate " +
            "parameter")
    }

    @Test
    def void validNesting_ContextType() {
        validationTestHelper.assertNoIssues(parseTestModel("ValidNesting_ContextType.data"))
    }

    @Test
    def void validNesting_VersionContextType() {
        validationTestHelper.assertNoIssues(parseTestModel("ValidNesting_VersionContextType.data"))
    }

    @Test
    def void validNesting_VersionType() {
        validationTestHelper.assertNoIssues(parseTestModel("ValidNesting_VersionType.data"))
    }

    @Test
    def void validNesting_Type() {
        validationTestHelper.assertNoIssues(parseTestModel("ValidNesting_Type.data"))
    }

    @Test
    def void duplicateStructureField() {
        val model = parseTestModel("DuplicateStructureField.data")
        validationTestHelper.assertError(model, DATA_STRUCTURE, null, "Duplicate structure " +
            "component")
    }

    @Test
    def void duplicateStructureOperation() {
        val model = parseTestModel("DuplicateStructureOperation.data")
        validationTestHelper.assertError(model, DATA_STRUCTURE, null, "Duplicate structure " +
            "component")
    }

    @Test
    def void duplicateStructureOperationDueToField() {
        val model = parseTestModel("DuplicateStructureOperationDueToField.data")
        validationTestHelper.assertError(model, DATA_STRUCTURE, null, "Duplicate structure " +
            "component")
    }

    @Test
    def void duplicateStructureFieldDueToOperation() {
        val model = parseTestModel("DuplicateStructureFieldDueToOperation.data")
        validationTestHelper.assertError(model, DATA_STRUCTURE, null, "Duplicate structure "+
            "component")
    }

    @Test
    def void duplicateFeaturesEnumeration() {
        val model = parseTestModel("DuplicateFeaturesEnumeration.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE, null, "Duplicate feature")
    }

    @Test
    def void duplicateFeaturesStructure() {
        val model = parseTestModel("DuplicateFeaturesStructure.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE, null, "Duplicate feature")
    }

    @Test
    def void aggregateFeatureConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("AggregateFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Aggregate feature constraint " +
            "violations",
            Severity.WARNING,
            COMPLEX_TYPE -> "Only entities should be aggregates",
            COMPLEX_TYPE -> "Aggregate should contain at least one part"
        )
    }

    @Test
    def void serviceFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("ServiceFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Service feature constraint " +
            "violations",
            Severity.WARNING,
            8,
            COMPLEX_TYPE -> "A service should not exhibit other domain features",
            COMPLEX_TYPE -> "A service should comprise at least one operation",
            COMPLEX_TYPE -> "A service should only comprise operations"
        )
    }

    @Test
    def void domainEventFeatureConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("DomainEventFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Domain Event feature constraint " +
            "violations",
            Severity.WARNING,
            COMPLEX_TYPE -> "Only value objects should be domain events"
        )
    }

    @Test
    def void entityFeatureConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("EntityFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Entity feature constraint " +
            "violations",
            Severity.WARNING,
            COMPLEX_TYPE ->
                "At least one non-inherited field or operation should be an identifier for the " +
                "entity",
            COMPLEX_TYPE -> "Identifier fields and operations should not be mixed",
            COMPLEX_TYPE -> "Only one operation should be an identifier for the entity"
        )
    }

    @Test
    def void factoryFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("FactoryFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Factory feature constraint " +
            "violations",
            Severity.WARNING,
            4,
            COMPLEX_TYPE -> "A factory should not exhibit other domain features",
            COMPLEX_TYPE -> "Factory operations should return aggregates or value objects",
            COMPLEX_TYPE -> "Factory operations should return aggregates or value objects"
        )
    }

    @Test
    def void repositoryFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("RepositoryFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Repository feature constraint " +
            "violations",
            Severity.WARNING,
            4,
            COMPLEX_TYPE -> "A repository should comprise at least one operation",
            COMPLEX_TYPE -> "A repository should not exhibit other domain features",
            COMPLEX_TYPE ->
                "Complex typed parameters of repository operations should be entities or value " +
                "objects"
        )
    }

    @Test
    def void specificationFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("SpecificationFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Specification feature constraint " +
            "violations",
            Severity.WARNING,
            6,
            COMPLEX_TYPE -> "A specification should not exhibit other domain features",
            COMPLEX_TYPE -> "A specification should only comprise operations",
            COMPLEX_TYPE -> "A specification should comprise at least one validator operation",
            DATA_OPERATION -> "A validator operation should return a value of type boolean",
            DATA_OPERATION -> "A validator operation should return a value of type boolean"
        )
    }

    @Test
    def void valueObjectFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("ValueObjectFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Value Object feature constraint " +
            "violations",
            Severity.WARNING,
            26,
            COMPLEX_TYPE -> "The operations of a value object should be side-effect-free",
            COMPLEX_TYPE -> "The fields of a value object should be immutable",
            (COMPLEX_TYPE -> "A value object should not be an aggregate, entity, repository, " +
                "service, or specification").ofCount(8)
        )
    }

    private def List<Pair<EClass, String>> ofCount(Pair<EClass, String> pair, int n) {
        val resultList = <Pair<EClass, String>>newArrayList
        for (int i : 0 ..< n)
            resultList.add(pair.key -> pair.value)
        return resultList
    }

    @Test
    def void dataFieldConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("DataFieldConstraints.data"),
            null,
            Severity.ERROR,
            // Structure
            DATA_FIELD -> "Field must have a type or be hidden",
            // Structure2
            DATA_FIELD -> "Only primitively typed data fields can be initialized",
            DATA_FIELD -> "Field must have a type",
            DATA_FIELD -> "Field must have a type",
            DATA_FIELD -> "Hidden immutable fields need to be initialized",
            DATA_FIELD -> "Duplicate feature",
            // Structure3
            DATA_FIELD -> "Field cannot redefine inherited field Structure2.field7",
            DATA_FIELD -> "Feature assignment is not allowed for inherited fields",
            DATA_FIELD -> "Inherited fields cannot be immutable",
            DATA_FIELD -> "Field cannot redefine inherited field Structure2.field10",
            // Structure6
            DATA_FIELD -> "Field must have a type",
            // List
            DATA_FIELD -> "Only primitively typed data fields can be initialized",
            DATA_FIELD -> "Only data fields within data structures can be initialized",
            // Structure7 (type checks)
            (DATA_FIELD -> "Value is not of type boolean").ofCount(5),
            (DATA_FIELD -> "Value is not of type byte").ofCount(8),
            (DATA_FIELD -> "Value is not of type char").ofCount(7),
            (DATA_FIELD -> "Value is not of type date").ofCount(19),
            (DATA_FIELD -> "Value is not of type double").ofCount(5),
            (DATA_FIELD -> "Value is not of type float").ofCount(5),
            (DATA_FIELD -> "Value is not of type int").ofCount(8),
            (DATA_FIELD -> "Value is not of type long").ofCount(8),
            (DATA_FIELD -> "Value is not of type short").ofCount(8),
            (DATA_FIELD -> "Value is not of type string").ofCount(4),
            (DATA_FIELD -> "Value is not of type unspecified").ofCount(9)
        )
    }

    @Test
    def void partFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("PartFeatureConstraints.data"),
            "Domain model does not yield expected issues for Part feature constraint violations",
            6, #[
            new ExpectedIssue(
                DATA_FIELD -> '''The "part" feature is only allowed on data structure fields''',
                Severity.ERROR
            ),
            new ExpectedIssue(
                DATA_FIELD -> '''Only fields with a complex type may exhibit the "part" feature''',
                Severity.ERROR
            ),
            new ExpectedIssue(DATA_FIELD -> "Parts should only be defined in aggregates",
                Severity.WARNING),
            new ExpectedIssue(
                DATA_FIELD -> "Parts of structural type should be entities or value objects",
                Severity.WARNING
            ),
            new ExpectedIssue(
                DATA_FIELD -> "Parts should be defined in the same namespace as the aggregate",
                Severity.WARNING
            )
        ])
    }

    @Test
    def void operationConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("OperationConstraints.data"),
            null,
            Severity.ERROR,
            // Structure
            (DATA_OPERATION -> "Duplicate feature").ofCount(2),
            // Structure2
            (DATA_OPERATION -> "Feature assignment is not allowed for inherited operations")
                .ofCount(2),
            DATA_OPERATION -> "Operation cannot redefine operation Structure.myProcedure2",
            DATA_OPERATION -> "Hidden inherited operation must have the same operation type " +
                "(procedure or function) as Structure.myFunction3",
            (DATA_OPERATION -> "Hidden inherited operation must not specify parameters").ofCount(2),
            DATA_OPERATION -> "Hidden inherited operation must not specify a return type",
            DATA_OPERATION -> "Operation must have a return type specification or be hidden"
        )
    }

    @Test
    def void closureFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("ClosureFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Closure feature constraint " +
            "violations",
            Severity.WARNING,
            18,
            // Context1.Structure
            DATA_OPERATION -> "A closure should not be an identifier or validator",
            DATA_OPERATION -> "A closure should take exactly one parameter and have a return type",
            DATA_OPERATION -> "A closure should not be an identifier or validator",
            DATA_OPERATION -> "A closure should take exactly one parameter and have a return type",
            DATA_OPERATION -> "A closure should not be an identifier or validator",
            DATA_OPERATION -> "A closure should take exactly one parameter and have a return type",
            DATA_OPERATION -> "A closure should take exactly one parameter and have a return type",
            // Context1.Structure2
            (DATA_OPERATION -> "A closure should return a value of the same type as its parameter")
                .ofCount(4),
            // Context1.Structure3
            (DATA_OPERATION -> "A closure should return a value of the same type as its parameter")
                .ofCount(4),
            // Context2.Structure2
            (DATA_OPERATION -> "A closure should return a value of the same type as its parameter")
                .ofCount(2)
        )
    }

    @Test
    def void sideEffectFreeFeatureConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("SideEffectFreeFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Side-Effect-Free feature " +
            "constraint violations",
            Severity.WARNING,
            (DATA_OPERATION -> "A side effect free operation should be a function").ofCount(2)
        )
    }

    @Test
    def void validatorFeatureConstraints() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("ValidatorFeatureConstraints.data"),
            "Domain model does not yield expected warnings for Validator feature constraints",
            Severity.WARNING,
            // Structure
            (DATA_OPERATION -> "A validator operation should be defined within a specification"),
            (DATA_OPERATION -> "A validator operation should be defined within a specification"),
            (DATA_OPERATION -> "A validator operation should return a value of type boolean"),
            (DATA_OPERATION -> "A validator operation should be defined within a specification"),
            (DATA_OPERATION -> "A validator operation should return a value of type boolean"),
            (DATA_OPERATION -> "A validator operation should be defined within a specification"),
            (DATA_OPERATION -> "A validator operation should be defined within a specification"),
            (DATA_OPERATION -> "A validator operation should return a value of type boolean"),
            (DATA_OPERATION -> "A validator operation should be defined within a specification"),
            (DATA_OPERATION -> "A validator operation should return a value of type boolean"),
            // MySpec
            (DATA_OPERATION -> "A validator operation should return a value of type boolean")
                .ofCount(4)
        )
    }

    @Test
    def void cyclicImports1() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("CyclicImports1.data"),
            "Domain model does not yield expected errors for cyclic imports",
            Severity.ERROR,
            (COMPLEX_TYPE_IMPORT -> "Import introduces a cycle").ofCount(2)
        )
    }

    @Test
    def void cyclicImports2() {
        val model = parseTestModel("CyclicImports3.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE_IMPORT, null, "Import introduces a " +
            "cycle")
    }

    @Test
    def void caseSensitiveImports() {
        val caseInsensitiveFileSystem = new File("a") == new File( "A" )
        // On case-sensitive file systems, the model will contain the error "File not found" for
        // which a dedicated test already exists
        if (!caseInsensitiveFileSystem)
            return

        val model = parseTestModel("CaseSensitiveImports.data")
        validationTestHelper.assertError(model, COMPLEX_TYPE_IMPORT, null, "Import paths are " +
            "case sensitive, but the case sensitivity of this import path does not match its " +
            "appearance in the filesystem")
    }

    @Test
    def void identifierFeatureConstraints() {
        val model = parseTestModel("IdentifierFeatureConstraints.data")
        validationTestHelper.assertWarning(model, DATA_OPERATION, null, "An identifier should " +
            "not be a validator")
    }

    @Test
    def void cyclicInheritance() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("CyclicInheritance.data"),
            null,
            Severity.ERROR,
            (DATA_STRUCTURE -> "Cyclic inheritance detected").ofCount(4)
        )
    }

    @Test
    def void emptyContext() {
        val model = parseTestModel("EmptyContext.data")
        validationTestHelper.assertError(model, CONTEXT, null, "A context must define at least " +
            "one complex type")
    }

    @Test
    def void emptyVersion() {
        val model = parseTestModel("EmptyVersion.data")
        validationTestHelper.assertError(model, VERSION, null, "A version must define at least " +
            "one context or complex type")
    }

    @Test
    def void enumerationFeatureConstraints() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("EnumerationFeatureConstraints.data"),
            "Domain model does not yield expected warnings for enumeration feature constraint " +
            "violations",
            Severity.WARNING,
            10,
            (COMPLEX_TYPE -> "An enumeration should only be a domain event or value object")
                .ofCount(9)
        )
    }

    @Test
    def void duplicateCollectionField() {
        val model = parseTestModel("DuplicateCollectionField.data")
        validationTestHelper.assertError(model, DATA_FIELD, null, "Duplicate field field1")
    }

    @Test
    def void importedComplexTypeScoping() {
        validationTestHelper.assertIssuesExactlyAndOrdered(
            parseTestModel("ImportedComplexTypeScoping2.data"),
            "Domain model does not yield expected errors for imported complex type scoping",
            Severity.ERROR,
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to Type 'Version2.Collection'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to ComplexTypeImport " +
                "'OtherModel3'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to Type 'Version2.Enumeration'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to Type 'Version1.Structure7'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to ComplexTypeImport " +
                "'OtherModel2'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to Type 'Version2.Enumeration'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to Type 'Version3.Enumeration'.",
            IMPORTED_COMPLEX_TYPE -> "Couldn't resolve reference to Type 'Version1.Structure6'."
        )
    }

    @Test
    def void superStructureScoping() {
        validationTestHelper.assertIssuesOrdered(
            parseTestModel("SuperStructureScoping1.data"),
            "Domain model does not yield expected errors for super structure scoping",
            Severity.ERROR,
            3,
            DATA_STRUCTURE -> "Couldn't resolve reference to DataStructure 'OtherModel'."
        )
    }
}