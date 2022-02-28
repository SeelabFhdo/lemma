package de.fhdo.lemma.eclipse.ui.utils;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.io.File;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorMapping;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Utility class for the LEMMA UI plugin.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LemmaUiUtils {
  public static final String DATA_DSL_EDITOR_ID = "de.fhdo.lemma.data.DataDsl";
  
  public static final String MAPPING_DSL_EDITOR_ID = "de.fhdo.lemma.technology.mappingdsl.MappingDsl";
  
  public static final String OPERATION_DSL_EDITOR_ID = "de.fhdo.lemma.operationdsl.OperationDsl";
  
  public static final String SERVICE_DSL_EDITOR_ID = "de.fhdo.lemma.ServiceDsl";
  
  public static final String TECHNOLOGY_DSL_EDITOR_ID = "de.fhdo.lemma.technology.technologydsl";
  
  /**
   * Helper to get file extensions for registered DSL editors
   */
  public static List<String> getFileExtensions(final String... forEditorIds) {
    final IFileEditorMapping[] fileEditorMappings = PlatformUI.getWorkbench().getEditorRegistry().getFileEditorMappings();
    final Function1<IFileEditorMapping, Boolean> _function = (IFileEditorMapping it) -> {
      final Function1<IEditorDescriptor, String> _function_1 = (IEditorDescriptor it_1) -> {
        return it_1.getId();
      };
      final Function1<String, Boolean> _function_2 = (String it_1) -> {
        return Boolean.valueOf(ArrayExtensions.contains(forEditorIds, it_1));
      };
      return Boolean.valueOf(IterableExtensions.<String>exists(ListExtensions.<IEditorDescriptor, String>map(((List<IEditorDescriptor>)Conversions.doWrapArray(it.getEditors())), _function_1), _function_2));
    };
    final Iterable<IFileEditorMapping> editorDescriptions = IterableExtensions.<IFileEditorMapping>filter(((Iterable<IFileEditorMapping>)Conversions.doWrapArray(fileEditorMappings)), _function);
    final Function1<IFileEditorMapping, String> _function_1 = (IFileEditorMapping it) -> {
      return it.getExtension();
    };
    return IterableExtensions.<String>toList(IterableExtensions.<IFileEditorMapping, String>map(editorDescriptions, _function_1));
  }
  
  /**
   * Walk through workspace projects and find files with given extensions. If no extensions are
   * specified, all files of all projects will be retrieved.
   */
  public static HashMap<IProject, List<IFile>> findFilesInWorkspaceProjects(final String... extensions) {
    final HashMap<IProject, List<IFile>> resultFiles = CollectionLiterals.<IProject, List<IFile>>newHashMap();
    final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    final Consumer<IProject> _function = (IProject it) -> {
      final List<IFile> resultFilesForProject = LemmaUiUtils.findFilesInProject(it, extensions);
      boolean _isEmpty = resultFilesForProject.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        resultFiles.put(it, resultFilesForProject);
      }
    };
    ((List<IProject>)Conversions.doWrapArray(projects)).forEach(_function);
    return resultFiles;
  }
  
  /**
   * Find files in project with the given extensions. If no extensions are specified, all files
   * will be retrieved.
   */
  public static List<IFile> findFilesInProject(final IProject project, final String... extensions) {
    try {
      if ((project == null)) {
        return null;
      }
      boolean _isOpen = project.isOpen();
      boolean _not = (!_isOpen);
      if (_not) {
        return CollectionLiterals.<IFile>emptyList();
      }
      final Function1<IResource, Boolean> _function = (IResource it) -> {
        return Boolean.valueOf(((it instanceof IFolder) || (it instanceof IFile)));
      };
      final Iterable<IResource> foldersAndFiles = IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(project.members())), _function);
      List<IResource> _list = IterableExtensions.<IResource>toList(foldersAndFiles);
      final ArrayDeque<IResource> resourcesTodo = new ArrayDeque<IResource>(_list);
      final ArrayList<IFile> resultFiles = CollectionLiterals.<IFile>newArrayList();
      while ((!resourcesTodo.isEmpty())) {
        {
          final IResource resource = resourcesTodo.pop();
          if ((resource instanceof IFile)) {
            boolean _isEmpty = ((List<String>)Conversions.doWrapArray(extensions)).isEmpty();
            if (_isEmpty) {
              resultFiles.add(((IFile)resource));
            } else {
              boolean _hasExtension = LemmaUiUtils.hasExtension(((IFile)resource), extensions);
              if (_hasExtension) {
                resultFiles.add(((IFile)resource));
              }
            }
          } else {
            if ((resource instanceof IFolder)) {
              final Function1<IResource, Boolean> _function_1 = (IResource it) -> {
                return Boolean.valueOf(((it instanceof IFolder) || (it instanceof IFile)));
              };
              final Consumer<IResource> _function_2 = (IResource it) -> {
                resourcesTodo.push(it);
              };
              IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(((IFolder)resource).members())), _function_1).forEach(_function_2);
            }
          }
        }
      }
      return resultFiles;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Check if a file has one of the given extensions
   */
  public static boolean hasExtension(final IFile file, final String... fileExtensions) {
    if (((file.getFileExtension() == null) || file.getFileExtension().isEmpty())) {
      return false;
    }
    final String extensionLowerCase = file.getFileExtension().toLowerCase();
    final Function1<String, String> _function = (String it) -> {
      return it.toLowerCase();
    };
    return ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(fileExtensions)), _function).contains(extensionLowerCase);
  }
  
  /**
   * Create an Image for the given filename with the given resource manager
   */
  public static Image createImage(final ResourceManager resourceManager, final Class<?> clazz, final String filename) {
    return resourceManager.createImage(LemmaUiUtils.createImageDescriptor(clazz, filename));
  }
  
  /**
   * Create an ImageDescriptor for the given filename and the bundle of this class
   */
  public static ImageDescriptor createImageDescriptor(final Class<?> clazz, final String filename) {
    final Bundle bundle = FrameworkUtil.getBundle(clazz);
    Path _path = new Path(("icons/" + filename));
    final URL url = FileLocator.find(bundle, _path, null);
    return ImageDescriptor.createFromURL(url);
  }
  
  /**
   * Load an Xtext resource from an Eclipse workspace
   */
  public static XtextResource loadXtextResource(final IFile file) {
    final String projectRelativeFilepath = file.getFullPath().toString();
    final XtextResourceSet resourceSet = LemmaUiUtils.createXtextResourceSetFor(projectRelativeFilepath);
    final URI platformUri = URI.createPlatformResourceURI(projectRelativeFilepath, true);
    XtextResource _loadXtextResource = null;
    if (resourceSet!=null) {
      _loadXtextResource=LemmaUiUtils.loadXtextResource(resourceSet, platformUri);
    }
    return _loadXtextResource;
  }
  
  /**
   * Helper to create an XtextResourceSet from a given file path
   */
  private static XtextResourceSet createXtextResourceSetFor(final String filepath) {
    final ResourceSet resourceSet = LemmaUiUtils.createResourceSetFor(filepath);
    XtextResourceSet _xifexpression = null;
    if ((resourceSet instanceof XtextResourceSet)) {
      _xifexpression = ((XtextResourceSet) resourceSet);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Helper to create a ResourceSet from a given file path
   */
  private static ResourceSet createResourceSetFor(final String filepath) {
    final IResourceServiceProvider.Registry resourceSetProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
    final URI fileUri = URI.createURI(filepath);
    final IResourceServiceProvider resourceSetProvider = resourceSetProviderRegistry.getResourceServiceProvider(fileUri);
    return resourceSetProvider.<ResourceSet>get(ResourceSet.class);
  }
  
  /**
   * Helper to load an XtextResource from a URI using the given XtextResourceSet
   */
  private static XtextResource loadXtextResource(final XtextResourceSet resourceSet, final URI uri) {
    try {
      final Resource fileResource = resourceSet.getResource(uri, true);
      fileResource.load(null);
      XtextResource _xifexpression = null;
      if ((fileResource instanceof XtextResource)) {
        _xifexpression = ((XtextResource) fileResource);
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Load an Xtext resource from a local file
   */
  public static XtextResource loadXtextResource(final String filepath) {
    final XtextResourceSet resourceSet = LemmaUiUtils.createXtextResourceSetFor(filepath);
    final URI fileUri = URI.createFileURI(filepath);
    XtextResource _loadXtextResource = null;
    if (resourceSet!=null) {
      _loadXtextResource=LemmaUiUtils.loadXtextResource(resourceSet, fileUri);
    }
    return _loadXtextResource;
  }
  
  /**
   * Load an XMI file
   */
  public static XMIResource loadXmiResource(final IFile file) {
    try {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      final URI fullPathUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      final Resource resource = resourceSet.getResource(fullPathUri, true);
      resource.load(null);
      return ((XMIResource) resource);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Store file in XMI interchange format
   */
  public static void storeAsXmi(final IFile file, final String targetFilePath) {
    try {
      final XtextResource xtextResource = LemmaUiUtils.loadXtextResource(file);
      EcoreUtil2.resolveAll(xtextResource);
      final ResourceSet resourceSet = LemmaUiUtils.createResourceSetFor(file.getFullPath().toString());
      final Resource xmiResource = resourceSet.createResource(URI.createURI(targetFilePath));
      xmiResource.getContents().add(xtextResource.getContents().get(0));
      xmiResource.save(null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Validate an Xtext resource
   */
  public static List<Issue> validateXtextResource(final XtextResource resource) {
    final IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
    final List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
    return issues;
  }
  
  /**
   * Remove extension from filename and return filename without extension
   */
  public static String removeExtension(final IFile file, final Function<IFile, String> getBasePath) {
    if (((file == null) || (getBasePath == null))) {
      return null;
    }
    if (((file.getName() == null) || file.getName().isEmpty())) {
      return "";
    }
    if (((file.getFileExtension() == null) || file.getFileExtension().isEmpty())) {
      return file.getName();
    }
    final String basePath = getBasePath.apply(file);
    return LemmaUiUtils.removeExtension(basePath);
  }
  
  /**
   * Remove extension from filename and return filename without extension. The extension starts at
   * the last occurrence of a dot (".") in the filename.
   */
  public static String removeExtension(final String filename) {
    if ((filename == null)) {
      return null;
    }
    return filename.substring(0, filename.lastIndexOf("."));
  }
  
  /**
   * Get extension of filename. The extension starts at the last occurrence of a dot (".") in the
   * filename.
   */
  public static String getExtension(final String filename) {
    if ((filename == null)) {
      return null;
    }
    final String filenameWithoutPath = new File(filename).getName();
    final int lastIndexOfDot = filenameWithoutPath.lastIndexOf(".");
    String _xifexpression = null;
    if (((lastIndexOfDot > (-1)) && (filenameWithoutPath.length() > 1))) {
      _xifexpression = filenameWithoutPath.substring((lastIndexOfDot + 1));
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  /**
   * Run UI event loop
   */
  public static void runEventLoop(final Shell shell) {
    final Display display = shell.getDisplay();
    while (((shell != null) && (!shell.isDisposed()))) {
      boolean _readAndDispatch = display.readAndDispatch();
      boolean _not = (!_readAndDispatch);
      if (_not) {
        display.sleep();
      }
    }
    boolean _isDisposed = display.isDisposed();
    boolean _not = (!_isDisposed);
    if (_not) {
      display.update();
    }
  }
  
  /**
   * Get all open editor instances of the current Eclipse workbench
   */
  public static <T extends IEditorPart> Iterable<T> getOpenEditorsOfType(final Class<T> editorType) {
    final Function1<IWorkbenchWindow, List<IWorkbenchPage>> _function = (IWorkbenchWindow it) -> {
      return IterableExtensions.<IWorkbenchPage>toList(((Iterable<IWorkbenchPage>)Conversions.doWrapArray(it.getPages())));
    };
    final Function1<IWorkbenchPage, List<IEditorReference>> _function_1 = (IWorkbenchPage it) -> {
      return IterableExtensions.<IEditorReference>toList(((Iterable<IEditorReference>)Conversions.doWrapArray(it.getEditorReferences())));
    };
    final Iterable<IEditorReference> allOpenEditorReferences = Iterables.<IEditorReference>concat(IterableExtensions.<IWorkbenchPage, List<IEditorReference>>map(Iterables.<IWorkbenchPage>concat(ListExtensions.<IWorkbenchWindow, List<IWorkbenchPage>>map(((List<IWorkbenchWindow>)Conversions.doWrapArray(PlatformUI.getWorkbench().getWorkbenchWindows())), _function)), _function_1));
    final Function1<IEditorReference, Boolean> _function_2 = (IEditorReference it) -> {
      boolean _xblockexpression = false;
      {
        final IEditorPart editor = it.getEditor(false);
        _xblockexpression = ((editor != null) && (editor.<T>getAdapter(editorType) != null));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    final Function1<IEditorReference, T> _function_3 = (IEditorReference it) -> {
      T _adapter = it.getEditor(false).<T>getAdapter(editorType);
      return ((T) _adapter);
    };
    return IterableExtensions.<IEditorReference, T>map(IterableExtensions.<IEditorReference>filter(allOpenEditorReferences, _function_2), _function_3);
  }
  
  /**
   * Get selected IResources from ExecutionEvent
   */
  public static List<IResource> getSelectedResources(final ExecutionEvent event) {
    try {
      final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
      final ISelection selection = window.getSelectionService().getSelection();
      if ((!(selection instanceof IStructuredSelection))) {
        return CollectionLiterals.<IResource>emptyList();
      }
      final ArrayList<IResource> selectedResources = CollectionLiterals.<IResource>newArrayList();
      List _list = ((IStructuredSelection) selection).toList();
      for (final Object element : _list) {
        if ((element instanceof IResource)) {
          selectedResources.add(((IResource)element));
        } else {
          if ((element instanceof IAdaptable)) {
            final IResource resource = ((IAdaptable)element).<IResource>getAdapter(IResource.class);
            if ((resource != null)) {
              selectedResources.add(resource);
            }
          }
        }
      }
      return selectedResources;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
