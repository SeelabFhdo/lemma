package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Dialog for selecting a local Docker image.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LocalDockerImageSelectionDialog extends Dialog {
  private static final String IMAGE_TAG_SEPARATOR = ":";
  
  private final List<Pair<String, String>> imagesAndTags;
  
  private final List<String> invalidImages;
  
  private TableViewer viewer;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String selectedImage = null;
  
  /**
   * Constructor
   */
  public LocalDockerImageSelectionDialog(final Shell parentShell, final String basicDockerCommand) {
    super(parentShell);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(basicDockerCommand);
    if (_isNullOrEmpty) {
      throw new IllegalArgumentException(("Docker selection dialog requires basic Docker " + 
        "command but none was given"));
    }
    final List<String> images = this.queryImagesWithTags(basicDockerCommand, LocalDockerImageSelectionDialog.IMAGE_TAG_SEPARATOR);
    final Pair<ArrayList<Pair<String, String>>, ArrayList<String>> splitResult = this.splitImagesByTag(images, LocalDockerImageSelectionDialog.IMAGE_TAG_SEPARATOR);
    this.imagesAndTags = splitResult.getKey();
    this.invalidImages = splitResult.getValue();
  }
  
  /**
   * Query local Docker images leveraging the basic Docker command. Returns the list of available
   * images including their tags. Throws an exception in case the executed query command, i.e.,
   * the basic Docker command plus some image query parameters, returns an exit code other than 0.
   */
  private List<String> queryImagesWithTags(final String basicDockerCommand, final String imageTagSeperator) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(basicDockerCommand);
    _builder.append(" image ls --format ");
    String _plus = (_builder.toString() + "\'{{.Repository}}");
    String _plus_1 = (_plus + imageTagSeperator);
    final String queryCommand = (_plus_1 + "{{.Tag}}\'");
    Pair<Integer, String> _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = Utils.executeShellCommandBlocking(queryCommand, 100, 10);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Invalid query command \"");
        _builder_1.append(queryCommand);
        _builder_1.append("\"");
        String _plus_2 = ("Available Docker images not determinable: " + _builder_1);
        throw new IllegalArgumentException(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final Pair<Integer, String> queryExitCodeAndResult = _xtrycatchfinallyexpression;
    final Integer exitCode = queryExitCodeAndResult.getKey();
    final String queryResult = queryExitCodeAndResult.getValue();
    List<String> _xifexpression = null;
    if (((exitCode).intValue() == 0)) {
      _xifexpression = queryResult.lines().sorted().collect(Collectors.<String>toList());
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Command \"");
      _builder_1.append(queryCommand);
      _builder_1.append("\" returned with exit code ");
      _builder_1.append(exitCode);
      _builder_1.append(": ");
      String _plus_2 = ("Available Docker images not determinable. " + _builder_1);
      String _plus_3 = (_plus_2 + queryResult);
      throw new IllegalArgumentException(_plus_3);
    }
    return _xifexpression;
  }
  
  /**
   * Split the given list of images with tags into a list of pairs with the image name as key and
   * the respective tag as value. Splitting assumes that each entry in the list of images with
   * tags starts with the image name, followed by a Docker-specific separator (usually a colon)
   * and the tag name. Next to the list of image-tag pairs, the method returns a second list that
   * comprises images that could not be split due to an non-supported format, e.g., an unexpected
   * tag separator.
   */
  private Pair<ArrayList<Pair<String, String>>, ArrayList<String>> splitImagesByTag(final List<String> imagesWithTags, final String imageTagSeperator) {
    final ArrayList<Pair<String, String>> splitImagesAndTags = CollectionLiterals.<Pair<String, String>>newArrayList();
    final ArrayList<String> unparseableImages = CollectionLiterals.<String>newArrayList();
    final Consumer<String> _function = (String it) -> {
      final String result = StringUtils.removeEnd(StringUtils.removeStart(it, "\'"), "\'");
      final String image = StringUtils.substringBeforeLast(result, imageTagSeperator);
      final String tag = StringUtils.substringAfterLast(result, imageTagSeperator);
      if (((!StringExtensions.isNullOrEmpty(image)) && (!StringExtensions.isNullOrEmpty(tag)))) {
        Pair<String, String> _mappedTo = Pair.<String, String>of(image, tag);
        splitImagesAndTags.add(_mappedTo);
      } else {
        unparseableImages.add(it);
      }
    };
    imagesWithTags.forEach(_function);
    return Pair.<ArrayList<Pair<String, String>>, ArrayList<String>>of(splitImagesAndTags, unparseableImages);
  }
  
  /**
   * Create dialog area
   */
  @Override
  public final Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite container = ((Composite) _createDialogArea);
    TableViewer _tableViewer = new TableViewer(container);
    this.viewer = _tableViewer;
    this.viewer.setContentProvider(new IStructuredContentProvider() {
      @Override
      public Object[] getElements(final Object inputElement) {
        return ((Object[])Conversions.unwrapArray(LocalDockerImageSelectionDialog.this.imagesAndTags, Object.class));
      }
    });
    final IDoubleClickListener _function = (DoubleClickEvent it) -> {
      ISelection _selection = it.getSelection();
      final IStructuredSelection selection = ((IStructuredSelection) _selection);
      Object _firstElement = null;
      if (selection!=null) {
        _firstElement=selection.getFirstElement();
      }
      final Pair<String, String> imageAndTag = ((Pair<String, String>) _firstElement);
      if ((imageAndTag != null)) {
        this.okPressedFor(imageAndTag);
      }
    };
    this.viewer.addDoubleClickListener(_function);
    Table _table = this.viewer.getTable();
    _table.setHeaderVisible(true);
    Table _table_1 = this.viewer.getTable();
    _table_1.setLinesVisible(true);
    Table _table_2 = this.viewer.getTable();
    GridData _gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
    _table_2.setLayoutData(_gridData);
    this.createImageColumn();
    this.createTagColumn();
    this.viewer.setInput(this.imagesAndTags);
    return container;
  }
  
  /**
   * Trigger click on OK for the given image and tag as dialog selection
   */
  private void okPressedFor(final Pair<String, String> imageAndTag) {
    StringConcatenation _builder = new StringConcatenation();
    String _key = imageAndTag.getKey();
    _builder.append(_key);
    _builder.append(":");
    String _value = imageAndTag.getValue();
    _builder.append(_value);
    this.selectedImage = _builder.toString();
    super.okPressed();
  }
  
  /**
   * Create image column for the table viewer
   */
  private void createImageColumn() {
    final TableViewerColumn column = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = column.getColumn();
    _column.setWidth(300);
    TableColumn _column_1 = column.getColumn();
    _column_1.setText("Image");
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((Pair<String, String>) element).getKey();
      }
    });
  }
  
  /**
   * Create tag column for the table viewer
   */
  private void createTagColumn() {
    final TableViewerColumn column = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = column.getColumn();
    _column.setWidth(150);
    TableColumn _column_1 = column.getColumn();
    _column_1.setText("Tag");
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((Pair<String, String>) element).getValue();
      }
    });
  }
  
  /**
   * Flag to indicate that the dialog is resizable
   */
  @Override
  public final boolean isResizable() {
    return true;
  }
  
  /**
   * Determine the initial dialog size
   */
  @Override
  public final Point getInitialSize() {
    return new Point(600, 700);
  }
  
  /**
   * Configure the shell
   */
  @Override
  public final void configureShell(final Shell shell) {
    super.configureShell(shell);
    shell.setText("Docker Image Selection");
  }
  
  /**
   * Open the dialog
   */
  @Override
  public final int open() {
    boolean _isEmpty = this.imagesAndTags.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(this.getShell(), "No Docker Images", "No local Docker images found");
      return Window.CANCEL;
    }
    boolean _isEmpty_1 = this.invalidImages.isEmpty();
    boolean _not = (!_isEmpty_1);
    if (_not) {
      Shell _shell = this.getShell();
      final Function1<String, String> _function = (String it) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\\t- ");
        _builder.append(it);
        return _builder.toString();
      };
      String _join = IterableExtensions.join(ListExtensions.<String, String>map(this.invalidImages, _function), "\n");
      String _plus = (("The image or tag " + 
        "names of the following local Docker images could not be parsed:\n") + _join);
      String _plus_1 = (_plus + "\nThey will be ");
      String _plus_2 = (_plus_1 + 
        "missing in the list of selectable images");
      MessageDialog.openWarning(_shell, "Non-Parseable Docker Images", _plus_2);
    }
    return super.open();
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public final void okPressed() {
    IStructuredSelection _singleRowSelectionOrError = Utils.singleRowSelectionOrError(this.viewer);
    Object _firstElement = null;
    if (_singleRowSelectionOrError!=null) {
      _firstElement=_singleRowSelectionOrError.getFirstElement();
    }
    final Pair<String, String> selectedRow = ((Pair<String, String>) _firstElement);
    if ((selectedRow != null)) {
      this.okPressedFor(selectedRow);
    }
  }
  
  /**
   * Cancel button was pressed
   */
  @Override
  public final void cancelPressed() {
    this.selectedImage = null;
    super.cancelPressed();
  }
  
  @Pure
  public String getSelectedImage() {
    return this.selectedImage;
  }
}
