package de.fhdo.lemma.data.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.utils.LemmaUtils;
import de.fhdo.lemma.xtext.test.utils.ExpectedIssue;
import de.fhdo.lemma.xtext.test.utils.ExtendedValidationTestHelper;
import de.fhdo.lemma.xtext.test.utils.WorkspaceClosedAwareRunner;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for LEMMA's Domain Data Modeling Language.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@RunWith(WorkspaceClosedAwareRunner.class)
@InjectWith(ValidationTestHelperInjectorProvider.class)
@SuppressWarnings("all")
public class DataDslParsingTest {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private ParseHelper<DataModel> parseHelper;
  
  @Inject
  private ExtendedValidationTestHelper validationTestHelper;
  
  /**
   * Register EPackages required for model parsing and language testing
   */
  @BeforeClass
  public static void registerEcorePackages() {
    EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE);
  }
  
  @Test
  public void duplicateImportAlias() {
    final DataModel model = this.parseTestModel("DuplicateImportAlias.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE_IMPORT, null, "Duplicate import alias");
  }
  
  /**
   * Helper to parse a test model from the "models" package of the test project
   */
  private DataModel parseTestModel(final String relativeModelPath) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/");
      String _replace = this.getClass().getPackageName().replace(".", "/");
      _builder.append(_replace);
      _builder.append("/models/");
      _builder.append(relativeModelPath);
      final String resourcePath = _builder.toString();
      final URL resourceUrl = this.getClass().getResource(resourcePath);
      if ((resourceUrl == null)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Resource ");
        _builder_1.append(resourcePath);
        _builder_1.append(" does not exist");
        throw new IllegalArgumentException(_builder_1.toString());
      }
      final URI uri = resourceUrl.toURI();
      final String filePath = Paths.get(uri).toFile().getAbsolutePath();
      File _file = new File(filePath);
      final FileInputStream fis = new FileInputStream(_file);
      return this.parseHelper.parse(fis, org.eclipse.emf.common.util.URI.createURI(LemmaUtils.convertToFileUri(filePath)), 
        CollectionLiterals.<Object, Object>newHashMap(), this.resourceSetProvider.get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void duplicateImportFile() {
    final DataModel model = this.parseTestModel("DuplicateImportFile.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE_IMPORT, null, ("File is already " + 
      "being imported"));
  }
  
  @Test
  public void wrongImportModelKind() {
    final DataModel model = this.parseTestModel("WrongImportModelKind.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE_IMPORT, null, ("File does not " + 
      "contain a data model definition"));
  }
  
  @Test
  public void validImports() {
    this.validationTestHelper.assertNoIssues(this.parseTestModel("ValidImports.data"));
  }
  
  @Test
  public void duplicateVersion() {
    final DataModel model = this.parseTestModel("DuplicateVersion.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.VERSION, null, "Duplicate version");
  }
  
  @Test
  public void duplicateTopLevelContext() {
    final DataModel model = this.parseTestModel("DuplicateTopLevelContext.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.CONTEXT, null, "Duplicate context");
  }
  
  @Test
  public void duplicateTopLevelType() {
    final DataModel model = this.parseTestModel("DuplicateTopLevelType.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE, null, "Duplicate complex type");
  }
  
  @Test
  public void duplicateVersionContext() {
    final DataModel model = this.parseTestModel("DuplicateVersionContext.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.CONTEXT, null, "Duplicate context");
  }
  
  @Test
  public void duplicateVersionType() {
    final DataModel model = this.parseTestModel("DuplicateVersionType.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE, null, "Duplicate complex type");
  }
  
  @Test
  public void duplicateContextType() {
    final DataModel model = this.parseTestModel("DuplicateContextType.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE, null, "Duplicate complex type");
  }
  
  @Test
  public void duplicateFunctionParameter() {
    final DataModel model = this.parseTestModel("DuplicateFunctionParameter.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_OPERATION_PARAMETER, null, ("Duplicate " + 
      "parameter"));
  }
  
  @Test
  public void duplicateProcedureParameter() {
    final DataModel model = this.parseTestModel("DuplicateProcedureParameter.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_OPERATION_PARAMETER, null, ("Duplicate " + 
      "parameter"));
  }
  
  @Test
  public void validNesting_ContextType() {
    this.validationTestHelper.assertNoIssues(this.parseTestModel("ValidNesting_ContextType.data"));
  }
  
  @Test
  public void validNesting_VersionContextType() {
    this.validationTestHelper.assertNoIssues(this.parseTestModel("ValidNesting_VersionContextType.data"));
  }
  
  @Test
  public void validNesting_VersionType() {
    this.validationTestHelper.assertNoIssues(this.parseTestModel("ValidNesting_VersionType.data"));
  }
  
  @Test
  public void validNesting_Type() {
    this.validationTestHelper.assertNoIssues(this.parseTestModel("ValidNesting_Type.data"));
  }
  
  @Test
  public void duplicateStructureField() {
    final DataModel model = this.parseTestModel("DuplicateStructureField.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_STRUCTURE, null, ("Duplicate structure " + 
      "component"));
  }
  
  @Test
  public void duplicateStructureOperation() {
    final DataModel model = this.parseTestModel("DuplicateStructureOperation.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_STRUCTURE, null, ("Duplicate structure " + 
      "component"));
  }
  
  @Test
  public void duplicateStructureOperationDueToField() {
    final DataModel model = this.parseTestModel("DuplicateStructureOperationDueToField.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_STRUCTURE, null, ("Duplicate structure " + 
      "component"));
  }
  
  @Test
  public void duplicateStructureFieldDueToOperation() {
    final DataModel model = this.parseTestModel("DuplicateStructureFieldDueToOperation.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_STRUCTURE, null, ("Duplicate structure " + 
      "component"));
  }
  
  @Test
  public void duplicateFeaturesEnumeration() {
    final DataModel model = this.parseTestModel("DuplicateFeaturesEnumeration.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE, null, "Duplicate feature");
  }
  
  @Test
  public void duplicateFeaturesStructure() {
    final DataModel model = this.parseTestModel("DuplicateFeaturesStructure.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE, null, "Duplicate feature");
  }
  
  @Test
  public void aggregateFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("AggregateFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Only entities should be aggregates");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Aggregate should contain at least one part");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Aggregate feature constraint " + 
        "violations"), 
      Severity.WARNING, _mappedTo, _mappedTo_1);
  }
  
  @Test
  public void serviceFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("ServiceFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A service should not exhibit other domain features");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A service should comprise at least one operation");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A service should only comprise operations");
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Service feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      8, _mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  @Test
  public void domainEventFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("DomainEventFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Only value objects should be domain events");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Domain Event feature constraint " + 
        "violations"), 
      Severity.WARNING, _mappedTo);
  }
  
  @Test
  public void entityFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("EntityFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, 
      ("At least one non-inherited field or operation should be an identifier for the " + 
        "entity"));
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Identifier fields and operations should not be mixed");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Only one operation should be an identifier for the entity");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Entity feature constraint " + 
        "violations"), 
      Severity.WARNING, _mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  @Test
  public void factoryFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("FactoryFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A factory should not exhibit other domain features");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Factory operations should return aggregates or value objects");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "Factory operations should return aggregates or value objects");
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Factory feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      4, _mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  @Test
  public void repositoryFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("RepositoryFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A repository should comprise at least one operation");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A repository should not exhibit other domain features");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, 
      ("Complex typed parameters of repository operations should be entities or value " + 
        "objects"));
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Repository feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      4, _mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  @Test
  public void specificationFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("SpecificationFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A specification should not exhibit other domain features");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A specification should only comprise operations");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "A specification should comprise at least one validator operation");
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean");
    Pair<EClass, String> _mappedTo_4 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean");
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Specification feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      6, _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4);
  }
  
  @Test
  public void valueObjectFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("ValueObjectFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "The operations of a value object should be side-effect-free");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "The fields of a value object should be immutable");
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Value Object feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      26, _mappedTo, _mappedTo_1, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, ("A value object should not be an aggregate, entity, repository, " + 
        "service, or specification")), 8));
  }
  
  private List<Pair<EClass, String>> ofCount(final Pair<EClass, String> pair, final int n) {
    final ArrayList<Pair<EClass, String>> resultList = CollectionLiterals.<Pair<EClass, String>>newArrayList();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, n, true);
    for (final int i : _doubleDotLessThan) {
      EClass _key = pair.getKey();
      String _value = pair.getValue();
      Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(_key, _value);
      resultList.add(_mappedTo);
    }
    return resultList;
  }
  
  @Test
  public void dataFieldConstraints() {
    DataModel _parseTestModel = this.parseTestModel("DataFieldConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Field must have a type or be hidden");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Only primitively typed data fields can be initialized");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Field must have a type");
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Field must have a type");
    Pair<EClass, String> _mappedTo_4 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Hidden immutable fields need to be initialized");
    Pair<EClass, String> _mappedTo_5 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Duplicate feature");
    Pair<EClass, String> _mappedTo_6 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Field cannot redefine inherited field Structure2.field7");
    Pair<EClass, String> _mappedTo_7 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Feature assignment is not allowed for inherited fields");
    Pair<EClass, String> _mappedTo_8 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Inherited fields cannot be immutable");
    Pair<EClass, String> _mappedTo_9 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Field cannot redefine inherited field Structure2.field10");
    Pair<EClass, String> _mappedTo_10 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Field must have a type");
    Pair<EClass, String> _mappedTo_11 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Only primitively typed data fields can be initialized");
    Pair<EClass, String> _mappedTo_12 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Only data fields within data structures can be initialized");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      null, 
      Severity.ERROR, _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type boolean"), 5), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type byte"), 8), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type char"), 7), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type date"), 19), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type double"), 5), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type float"), 5), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type int"), 8), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type long"), 8), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type short"), 8), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type string"), 4), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Value is not of type unspecified"), 9));
  }
  
  @Test
  public void partFeatureConstraints() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The \"part\" feature is only allowed on data structure fields");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, _builder.toString());
    ExpectedIssue _expectedIssue = new ExpectedIssue(_mappedTo, 
      Severity.ERROR);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Only fields with a complex type may exhibit the \"part\" feature");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, _builder_1.toString());
    ExpectedIssue _expectedIssue_1 = new ExpectedIssue(_mappedTo_1, 
      Severity.ERROR);
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Parts should only be defined in aggregates");
    ExpectedIssue _expectedIssue_2 = new ExpectedIssue(_mappedTo_2, 
      Severity.WARNING);
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Parts of structural type should be entities or value objects");
    ExpectedIssue _expectedIssue_3 = new ExpectedIssue(_mappedTo_3, 
      Severity.WARNING);
    Pair<EClass, String> _mappedTo_4 = Pair.<EClass, String>of(DataPackage.Literals.DATA_FIELD, "Parts should be defined in the same namespace as the aggregate");
    ExpectedIssue _expectedIssue_4 = new ExpectedIssue(_mappedTo_4, 
      Severity.WARNING);
    this.validationTestHelper.assertIssuesOrdered(
      this.parseTestModel("PartFeatureConstraints.data"), 
      "Domain model does not yield expected issues for Part feature constraint violations", 
      6, Collections.<ExpectedIssue>unmodifiableList(CollectionLiterals.<ExpectedIssue>newArrayList(_expectedIssue, _expectedIssue_1, _expectedIssue_2, _expectedIssue_3, _expectedIssue_4)));
  }
  
  @Test
  public void operationConstraints() {
    DataModel _parseTestModel = this.parseTestModel("OperationConstraints.data");
    List<Pair<EClass, String>> _ofCount = this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "Duplicate feature"), 2);
    List<Pair<EClass, String>> _ofCount_1 = this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "Feature assignment is not allowed for inherited operations"), 2);
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "Operation cannot redefine operation Structure.myProcedure2");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, ("Hidden inherited operation must have the same operation type " + 
      "(procedure or function) as Structure.myFunction3"));
    List<Pair<EClass, String>> _ofCount_2 = this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "Hidden inherited operation must not specify parameters"), 2);
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "Hidden inherited operation must not specify a return type");
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "Operation must have a return type specification or be hidden");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      null, 
      Severity.ERROR, _ofCount, _ofCount_1, _mappedTo, _mappedTo_1, _ofCount_2, _mappedTo_2, _mappedTo_3);
  }
  
  @Test
  public void closureFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("ClosureFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should not be an identifier or validator");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should take exactly one parameter and have a return type");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should not be an identifier or validator");
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should take exactly one parameter and have a return type");
    Pair<EClass, String> _mappedTo_4 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should not be an identifier or validator");
    Pair<EClass, String> _mappedTo_5 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should take exactly one parameter and have a return type");
    Pair<EClass, String> _mappedTo_6 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should take exactly one parameter and have a return type");
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      ("Domain model does not yield expected warnings for Closure feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      18, _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should return a value of the same type as its parameter"), 4), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should return a value of the same type as its parameter"), 4), 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A closure should return a value of the same type as its parameter"), 2));
  }
  
  @Test
  public void sideEffectFreeFeatureConstraints() {
    this.validationTestHelper.assertIssuesExactlyAndOrdered(
      this.parseTestModel("SideEffectFreeFeatureConstraints.data"), 
      ("Domain model does not yield expected warnings for Side-Effect-Free feature " + 
        "constraint violations"), 
      Severity.WARNING, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A side effect free operation should be a function"), 2));
  }
  
  @Test
  public void validatorFeatureConstraints() {
    DataModel _parseTestModel = this.parseTestModel("ValidatorFeatureConstraints.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should be defined within a specification");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should be defined within a specification");
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean");
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should be defined within a specification");
    Pair<EClass, String> _mappedTo_4 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean");
    Pair<EClass, String> _mappedTo_5 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should be defined within a specification");
    Pair<EClass, String> _mappedTo_6 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should be defined within a specification");
    Pair<EClass, String> _mappedTo_7 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean");
    Pair<EClass, String> _mappedTo_8 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should be defined within a specification");
    Pair<EClass, String> _mappedTo_9 = Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      "Domain model does not yield expected warnings for Validator feature constraints", 
      Severity.WARNING, _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_OPERATION, "A validator operation should return a value of type boolean"), 4));
  }
  
  @Test
  public void cyclicImports1() {
    this.validationTestHelper.assertIssuesExactlyAndOrdered(
      this.parseTestModel("CyclicImports1.data"), 
      "Domain model does not yield expected errors for cyclic imports", 
      Severity.ERROR, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE_IMPORT, "Import introduces a cycle"), 2));
  }
  
  @Test
  public void cyclicImports2() {
    final DataModel model = this.parseTestModel("CyclicImports3.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE_IMPORT, null, ("Import introduces a " + 
      "cycle"));
  }
  
  @Test
  public void caseSensitiveImports() {
    File _file = new File("a");
    File _file_1 = new File("A");
    final boolean caseInsensitiveFileSystem = Objects.equal(_file, _file_1);
    if ((!caseInsensitiveFileSystem)) {
      return;
    }
    final DataModel model = this.parseTestModel("CaseSensitiveImports.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.COMPLEX_TYPE_IMPORT, null, (("Import paths are " + 
      "case sensitive, but the case sensitivity of this import path does not match its ") + 
      "appearance in the filesystem"));
  }
  
  @Test
  public void identifierFeatureConstraints() {
    final DataModel model = this.parseTestModel("IdentifierFeatureConstraints.data");
    this.validationTestHelper.assertWarning(model, DataPackage.Literals.DATA_OPERATION, null, ("An identifier should " + 
      "not be a validator"));
  }
  
  @Test
  public void cyclicInheritance() {
    this.validationTestHelper.assertIssuesExactlyAndOrdered(
      this.parseTestModel("CyclicInheritance.data"), 
      null, 
      Severity.ERROR, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.DATA_STRUCTURE, "Cyclic inheritance detected"), 4));
  }
  
  @Test
  public void emptyContext() {
    final DataModel model = this.parseTestModel("EmptyContext.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.CONTEXT, null, ("A context must define at least " + 
      "one complex type"));
  }
  
  @Test
  public void emptyVersion() {
    final DataModel model = this.parseTestModel("EmptyVersion.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.VERSION, null, ("A version must define at least " + 
      "one context or complex type"));
  }
  
  @Test
  public void enumerationFeatureConstraints() {
    this.validationTestHelper.assertIssuesOrdered(
      this.parseTestModel("EnumerationFeatureConstraints.data"), 
      ("Domain model does not yield expected warnings for enumeration feature constraint " + 
        "violations"), 
      Severity.WARNING, 
      10, 
      this.ofCount(Pair.<EClass, String>of(DataPackage.Literals.COMPLEX_TYPE, "An enumeration should only be a domain event or value object"), 9));
  }
  
  @Test
  public void duplicateCollectionField() {
    final DataModel model = this.parseTestModel("DuplicateCollectionField.data");
    this.validationTestHelper.assertError(model, DataPackage.Literals.DATA_FIELD, null, "Duplicate field field1");
  }
  
  @Test
  public void importedComplexTypeScoping() {
    DataModel _parseTestModel = this.parseTestModel("ImportedComplexTypeScoping2.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, "Couldn\'t resolve reference to Type \'Version2.Collection\'.");
    Pair<EClass, String> _mappedTo_1 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, ("Couldn\'t resolve reference to ComplexTypeImport " + 
      "\'OtherModel3\'."));
    Pair<EClass, String> _mappedTo_2 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, "Couldn\'t resolve reference to Type \'Version2.Enumeration\'.");
    Pair<EClass, String> _mappedTo_3 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, "Couldn\'t resolve reference to Type \'Version1.Structure7\'.");
    Pair<EClass, String> _mappedTo_4 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, ("Couldn\'t resolve reference to ComplexTypeImport " + 
      "\'OtherModel2\'."));
    Pair<EClass, String> _mappedTo_5 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, "Couldn\'t resolve reference to Type \'Version2.Enumeration\'.");
    Pair<EClass, String> _mappedTo_6 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, "Couldn\'t resolve reference to Type \'Version3.Enumeration\'.");
    Pair<EClass, String> _mappedTo_7 = Pair.<EClass, String>of(DataPackage.Literals.IMPORTED_COMPLEX_TYPE, "Couldn\'t resolve reference to Type \'Version1.Structure6\'.");
    this.validationTestHelper.assertIssuesExactlyAndOrdered(_parseTestModel, 
      "Domain model does not yield expected errors for imported complex type scoping", 
      Severity.ERROR, _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7);
  }
  
  @Test
  public void superStructureScoping() {
    DataModel _parseTestModel = this.parseTestModel("SuperStructureScoping1.data");
    Pair<EClass, String> _mappedTo = Pair.<EClass, String>of(DataPackage.Literals.DATA_STRUCTURE, "Couldn\'t resolve reference to DataStructure \'OtherModel\'.");
    this.validationTestHelper.assertIssuesOrdered(_parseTestModel, 
      "Domain model does not yield expected errors for super structure scoping", 
      Severity.ERROR, 
      3, _mappedTo);
  }
}
