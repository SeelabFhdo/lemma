package de.fhdo.ddmm.eclipse.ui.utils

import org.eclipse.ui.PlatformUI
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IFolder
import java.util.ArrayDeque
import org.eclipse.core.resources.IFile
import java.util.List
import org.eclipse.core.resources.IProject
import org.osgi.framework.FrameworkUtil
import org.eclipse.core.runtime.FileLocator
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.core.runtime.Path
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.common.base.Function
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.IEditorPart
import java.io.File

/**
 * Utility class for the DDMM UI plugin.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class DdmmUiUtils {
    public static val SERVICE_DSL_EDITOR_ID = "de.fhdo.ddmm.ServiceDsl"
    public static val MAPPING_DSL_EDITOR_ID = "de.fhdo.ddmm.technology.mappingdsl.MappingDsl"
    public static val OPERATION_DSL_EDITOR_ID = "de.fhdo.ddmm.operationdsl.OperationDsl"

    /**
     * Helper to get file extensions for registered DSL editors
     */
    static def getFileExtensions(String... forEditorIds) {
        val fileEditorMappings = PlatformUI.workbench.editorRegistry.fileEditorMappings
        val editorDescriptions = fileEditorMappings.filter[
            editors.map[id].exists[forEditorIds.contains(it)]
        ]

        return editorDescriptions.map[extension].toList
    }

    /**
     * Walk through workspace projects and find files with given extensions. If no extensions are
     * specified, all files of all projects will be retrieved.
     */
    static def findFilesInWorkspaceProjects(String... extensions) {
        val resultFiles = <IProject, List<IFile>> newHashMap
        val projects = ResourcesPlugin.workspace.root.projects
        projects.forEach[
            if (it.open) {
                val resultFilesForProject = findFilesInProject(extensions)
                resultFiles.put(it, resultFilesForProject)
            }
        ]
        return resultFiles
    }

    /**
     * Find files in project with the given extensions. If no extensions are specified, all files
     * will be retrieved.
     */
    static def findFilesInProject(IProject project, String... extensions) {
        if (project === null)
            return null

        val foldersAndFiles = project.members.filter[it instanceof IFolder || it instanceof IFile]
        val resourcesTodo = new ArrayDeque<IResource>(foldersAndFiles.toList)
        val resultFiles = <IFile> newArrayList
        while (!resourcesTodo.empty) {
            val resource = resourcesTodo.pop

            if (resource instanceof IFile) {
                if (extensions.empty)
                    resultFiles.add(resource)
                else if (hasExtension(resource, extensions))
                    resultFiles.add(resource)
            } else if (resource instanceof IFolder)
                resource.members.filter[it instanceof IFolder || it instanceof IFile].forEach[
                    resourcesTodo.push(it)
                ]
        }

        return resultFiles
    }

    /**
     * Check if a file has one of the given extensions
     */
    static def hasExtension(IFile file, String... fileExtensions) {
        if (file.fileExtension === null || file.fileExtension.empty)
            return false

        val extensionLowerCase = file.fileExtension.toLowerCase
        return fileExtensions.map[toLowerCase].contains(extensionLowerCase)
    }

    /**
     * Create enumeration text in Oxford comma style, e.g., "e1, e2, or e3"
     */
    static def createEnumerationText(List<String> elements) {
        if (elements === null)
            return null

        switch (elements.size) {
            case 0: return ""
            case 1: return elements.get(0)
            case 2: return '''«elements.get(0)» or «elements.get(1)»'''
        }

        val enumerationText = new StringBuffer
        for (i : 0..<elements.size - 1)
            enumerationText.append(elements.get(i) + ", ")
        enumerationText.append("or " + elements.last)
    }

    /**
     * Create an Image for the given filename with the given resource manager
     */
    static def createImage(ResourceManager resourceManager, Class<?> clazz, String filename) {
        return resourceManager.createImage(createImageDescriptor(clazz, filename))
    }

    /**
     * Create an ImageDescriptor for the given filename and the bundle of this class
     */
    static def createImageDescriptor(Class<?> clazz, String filename) {
        val bundle = FrameworkUtil.getBundle(clazz)
        val url = FileLocator.find(bundle, new Path("icons/" + filename), null)
        return ImageDescriptor.createFromURL(url)
    }

    /**
     * Load an Xtext file as XtextResource
     */
    static def loadXtextResource(IFile file) {
        val resourceSet = createResourceSetFor(file)
        if (resourceSet === null)
            return null

        val fileUri = URI.createPlatformResourceURI(file.fullPath.toString, true)
        val fileResource = resourceSet.getResource(fileUri, true)
        fileResource.load(null)
        return fileResource as XtextResource
    }

    /**
     * Load an XMI file
     */
    static def loadXmiResource(IFile file) {
        val resourceSet = new ResourceSetImpl()
        val fullPathUri = URI.createPlatformResourceURI(file.fullPath.toString, true)
        val resource = resourceSet.getResource(fullPathUri, true)
        resource.load(null)
        return resource as XMIResource
    }

    /**
     * Store file in XMI interchange format
     */
    static def storeAsXmi(IFile file, String targetFilePath) {
        val xtextResource = loadXtextResource(file)
        EcoreUtil2.resolveAll(xtextResource)
        val resourceSet = createResourceSetFor(file)
        val xmiResource = resourceSet.createResource(URI.createURI(targetFilePath))
        xmiResource.contents.add(xtextResource.contents.get(0))
        xmiResource.save(null)
    }

    /**
     * Validate an Xtext resource
     */
    static def validateXtextResource(XtextResource resource) {
        val validator = resource.resourceServiceProvider.resourceValidator
        val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
        return issues
    }

    /**
     * Remove extension from filename and return filename without extension
     */
    static def removeExtension(IFile file, Function<IFile, String> getBasePath) {
        if (file === null || getBasePath === null)
            return null

        if (file.name === null || file.name.empty)
            return ""

        if (file.fileExtension === null || file.fileExtension.empty)
            return file.name

        val basePath = getBasePath.apply(file)
        return removeExtension(basePath)
    }

    /**
     * Remove extension from filename and return filename without extension. The extension starts at
     * the last occurrence of a dot (".") in the filename.
     */
    static def removeExtension(String filename) {
        if (filename === null)
            return null

        return filename.substring(0, filename.lastIndexOf("."))
    }

    /**
     * Get extension of filename. The extension starts at the last occurrence of a dot (".") in the
     * filename.
     */
    static def getExtension(String filename) {
        if (filename === null)
            return null

        val filenameWithoutPath = new File(filename).name
        val lastIndexOfDot = filenameWithoutPath.lastIndexOf(".")
        return if (lastIndexOfDot > -1 && filenameWithoutPath.length > 1)
                filenameWithoutPath.substring(lastIndexOfDot + 1)
            else
                ""
    }

    /**
     * Helper to create ResourceSet from file
     */
    static def createResourceSetFor(IFile file) {
        val resourceSetProviderRegistry = IResourceServiceProvider.Registry.INSTANCE
        val fileUri =  URI.createURI(file.fullPath.toString)
        val resourceSetProvider = resourceSetProviderRegistry.getResourceServiceProvider(fileUri)
        return resourceSetProvider.get(ResourceSet)
    }

    /**
     * Run UI event loop
     */
    static def runEventLoop(Shell shell) {
        /* Code taken from Window.open() */
        val display = shell.display
        while (shell !== null && !shell.disposed)
            if (!display.readAndDispatch())
                display.sleep()

        if (!display.disposed)
            display.update()
    }

    /**
     * Get all open editor instances of the current Eclipse workbench
     */
    static def <T extends IEditorPart> getOpenEditorsOfType(Class<T> editorType) {
        val allOpenEditorReferences = PlatformUI.workbench
            .workbenchWindows
            .map[pages.toList].flatten
            .map[editorReferences.toList].flatten

        return allOpenEditorReferences.filter[
            val editor = it.getEditor(false)
            editor !== null && editor.getAdapter(editorType) !== null
        ].map[it.getEditor(false).getAdapter(editorType) as T]
    }
}