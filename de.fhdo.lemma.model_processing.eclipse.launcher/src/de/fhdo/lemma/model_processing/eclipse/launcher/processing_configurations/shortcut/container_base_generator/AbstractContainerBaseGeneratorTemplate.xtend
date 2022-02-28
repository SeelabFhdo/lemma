package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.container_base_generator

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorTemplate
import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject
import java.util.Map
import de.fhdo.lemma.operation.OperationModel
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType

/**
 * Abstract superclass for launch configuration templates targeting code generation with the
 * Container Base Generator.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractContainerBaseGeneratorTemplate extends AbstractCodeGeneratorTemplate {
    /**
     * Constructor
     */
    new(ProcessorExecutableType generatorExecutableType, Shell parentShell, String name,
        IProject project, IFile file) {
        super(generatorExecutableType, parentShell, name, project, file)
    }

    /**
     * The template is applicable when the source operation model applies the container base
     * technology to at least one container
     */
    final override isApplicable(EObject modelRoot, Map<String, String> technologyNamePerAlias) {
        val technologyReferences = (modelRoot as OperationModel)
            .containers
            .map[it.technologies]
            .flatten

        // Convert import paths to absolute paths as otherwise cross-references to imported
        // technologies won't be resolvable
        makeImportPathsAbsolute(modelRoot, file)

        return  technologyReferences.exists[
            val alias = it.name
            val technologyName = technologyNamePerAlias.get(alias)
            "container_base".equalsIgnoreCase(technologyName)
        ]
    }
}