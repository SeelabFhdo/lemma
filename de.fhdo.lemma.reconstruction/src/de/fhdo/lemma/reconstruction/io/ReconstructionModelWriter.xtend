package de.fhdo.lemma.reconstruction.io

import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup
import de.fhdo.lemma.operationdsl.extractor.OperationDslExtractor
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor
import de.fhdo.lemma.reconstruction.util.Util
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor
import de.fhdo.lemma.utils.LemmaUtils
import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.core.runtime.FileLocator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtend.lib.annotations.Accessors
import org.osgi.framework.FrameworkUtil

/**
 * Writing of generated LEMMA models into a target folder.
 *
 * Extracting a model to its textual representation, writing it to disk and
 * masking the parts the validation rejects belong together: the file that ends
 * up in the target folder is the masked one, not the extractor's output. The
 * reconstruction wizard and the regression test therefore share this class so
 * that both observe the same result.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReconstructionModelWriter {
    /**
     * Folder of this bundle holding the hand-written technology models, and
     * the suffix of such a model.
     */
    static val TECHNOLOGY_MODEL_FOLDER = "models/technology"
    static val TECHNOLOGY_MODEL_SUFFIX = ".technology"

    /**
     * Write a LEMMA domain model to the "domain" sub folder of the given
     * target folder and return the path of the written file.
     */
    def static String writeDataModel(DataModel model, String targetFolder) {
        val extractedModel = new DataDslExtractor().extractToString(model)
        val fileName = model.contexts.get(0).name
        val folder = '''«targetFolder»«File.separator»domain'''
        val filePath = '''«folder»«File.separator»«fileName».data'''

        Files.createDirectories(Paths.get(folder))
        Files.write(Paths.get(filePath), extractedModel.bytes)

        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
        val injector = new DataDslStandaloneSetup().createInjectorAndDoEMFRegistration
        maskIssues(filePath, injector.getInstance(XtextResourceSet))

        return filePath
    }

    /**
     * Write a LEMMA service model to the "service" sub folder of the given
     * target folder and return the path of the written file.
     */
    def static String writeServiceModel(ServiceModel model, String targetFolder) {
        val extractedModel = new ServiceDslExtractor().extractToString(model)
        val fileName = model.microservices.get(0).qualifiedNameParts.lastOrNull
        val folder = '''«targetFolder»«File.separator»service'''
        val filePath = '''«folder»«File.separator»«fileName».services'''

        Files.createDirectories(Paths.get(folder))
        Files.write(Paths.get(filePath), extractedModel.bytes)

        EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, ServicePackage.eINSTANCE)
        val injector = new ServiceDslStandaloneSetup().createInjectorAndDoEMFRegistration
        maskIssues(filePath, injector.getInstance(XtextResourceSet))

        return filePath
    }

    /**
     * Write a LEMMA operation model to the "operation" sub folder of the given
     * target folder and return the path of the written file.
     */
    def static String writeOperationModel(OperationModel model, String fileName,
        String targetFolder) {
        val extractedModel = new OperationDslExtractor().extractToString(model)
        val folder = '''«targetFolder»«File.separator»operation'''
        val filePath = '''«folder»«File.separator»«fileName».operation'''

        Files.createDirectories(Paths.get(folder))
        Files.write(Paths.get(filePath), extractedModel.bytes)

        EPackage.Registry.INSTANCE.put(OperationPackage.eNS_URI, OperationPackage.eINSTANCE)
        val injector = new OperationDslStandaloneSetup().createInjectorAndDoEMFRegistration
        maskIssues(filePath, injector.getInstance(XtextResourceSet))

        return filePath
    }

    /**
     * Copy the technology models of this bundle into a sub folder of the
     * target folder, and return the names of the copied files.
     *
     * A generated operation model imports its technology model by a relative
     * path, so the model has to exist next to the generated one. Copying it
     * here keeps the generated models self-contained: the folder the wizard
     * writes to opens on its own, without a reference into this bundle.
     */
    def static List<String> copyTechnologyModels(String targetFolder, String subFolder) {
        val copied = <String>newLinkedList
        val folder = Paths.get('''«targetFolder»«File.separator»«subFolder»'''.toString)
        Files.createDirectories(folder)

        val bundle = FrameworkUtil.getBundle(ReconstructionModelWriter)
        if (bundle === null) {
            // There is no bundle outside a running Eclipse, which is how the
            // regression test writes its models. Copying from the working
            // directory lets the imports of those models resolve, so the test
            // sees what the wizard produces rather than a folder in which every
            // import is dangling.
            return copyFrom(new File(TECHNOLOGY_MODEL_FOLDER), folder, copied)
        }

        // The models are a plain folder of the bundle rather than a source
        // folder. A launched workbench does not necessarily expose such a
        // folder as a bundle entry, so the file system of the bundle is read
        // when the entries yield nothing.
        val entries = bundle.findEntries(TECHNOLOGY_MODEL_FOLDER, "*" + TECHNOLOGY_MODEL_SUFFIX,
            false)
        if (entries !== null) {
            while (entries.hasMoreElements) {
                val entry = entries.nextElement
                val fileName = entry.path.substring(entry.path.lastIndexOf("/") + 1)
                val stream = entry.openStream
                try {
                    Files.copy(stream, folder.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING)
                    copied.add(fileName)
                } finally {
                    stream.close
                }
            }
        }

        if (copied.empty) {
            copyFrom(new File(FileLocator.getBundleFile(bundle), TECHNOLOGY_MODEL_FOLDER),
                folder, copied)
        }

        return copied
    }

    /**
     * Copy the technology models of a folder of the file system, and report
     * where they were looked for.
     */
    private def static List<String> copyFrom(File modelFolder, Path targetFolder,
        List<String> copied) {
        lastLookupLocation = modelFolder.absolutePath
        val models = modelFolder.listFiles
        if (models === null) {
            lastLookupLocation = '''«modelFolder.absolutePath» (does not exist)'''.toString
            return copied
        }

        models.filter[name.endsWith(TECHNOLOGY_MODEL_SUFFIX)].forEach[
            Files.copy(toPath, targetFolder.resolve(name), StandardCopyOption.REPLACE_EXISTING)
            copied.add(name)
        ]
        return copied
    }

    /**
     * Where the last copy looked for the technology models on the file system.
     *
     * Reported when nothing was copied: whether the folder is missing from the
     * bundle or the bundle itself is a different one than expected cannot be
     * told apart without the path that was tried.
     */
    @Accessors(PUBLIC_GETTER)
    static String lastLookupLocation = "not attempted"

    /**
     * Load a written model, validate it and mask the parts the validation
     * rejects.
     */
    private def static maskIssues(String path, XtextResourceSet resourceSet) {
        val uri = LemmaUtils.convertToAbsoluteFileUri(URI.createURI(path).toString, path)
        val resource = resourceSet.createResource(URI.createURI(uri)) as XtextResource
        resource.load(new FileInputStream(path), resourceSet.getLoadOptions())
        val validator = resource.getResourceServiceProvider().getResourceValidator()
        val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)

        if (!issues.nullOrEmpty) {
            val maskedModel = Util.maskModel(path, issues)
            Files.write(Path.of(path), maskedModel, Charset.defaultCharset)
        }
    }
}
