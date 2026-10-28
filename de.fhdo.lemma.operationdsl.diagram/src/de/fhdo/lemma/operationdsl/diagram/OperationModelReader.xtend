package de.fhdo.lemma.operationdsl.diagram

import com.google.inject.Injector
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.operation.BasicEndpoint
import de.fhdo.lemma.operation.Container
import de.fhdo.lemma.operation.ImportedMicroservice
import de.fhdo.lemma.operation.ImportedOperationAspect
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.PossiblyImportedOperationNode
import de.fhdo.lemma.operation.ServiceDeploymentSpecification
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.technology.TechnologyPackage
import java.nio.file.Files
import java.nio.file.Path
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * Reads operation models into an [[OperationGraph]], following their imports.
 *
 * ## Why the parse tree is read
 *
 * A cross-reference of an operation model does not resolve outside a running
 * Xtext. Measured on `ChargingStationManagementCommandSide.operation`:
 *
 *     deployment technology: PROXY   written=DeploymentBase::_deployment.Docker
 *     deploys:               PROXY   written=CommandSideServices::de.puls.…CommandSide
 *     depends on:            PROXY   written=Infrastructure::APIGateway
 *     default value:         property=PROXY  written=clientPort = 2181
 *
 * Local features are therefore read from EMF and cross-references from the
 * parse tree. The written form is directly usable: a `deploys` reference holds
 * the microservice's name, so no service model has to be loaded.
 *
 * ## Why relations are de-duplicated
 *
 * `depends on nodes` and `used by nodes` are two directions of one relation, and
 * the models state the same one from both ends in different files:
 *
 *     Infrastructure.operation  APIGateway used by nodes CommandSideNodes::CommandSideContainer
 *     command-side.operation    CommandSideContainer depends on nodes Infrastructure::APIGateway
 *
 * Both are normalised to one direction and each pair kept once. Neither can be
 * dropped instead: `Broker used by nodes CommandSideContainer` has no mirror in
 * the container's own model.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OperationModelReader {
    static val ALIAS_SEPARATOR = "::"

    val XtextResourceSet resourceSet

    /**
     * Imports of each model read, as alias to the model it names.
     */
    val Map<String, Map<String, String>> importsByModel = newLinkedHashMap

    /**
     * Relations read but not yet resolved: a relation may point at a model that
     * is only reached through another one.
     */
    val List<PendingEdge> pending = newLinkedList

    new() {
        EPackage.Registry.INSTANCE.put(OperationPackage.eNS_URI, OperationPackage.eINSTANCE)
        EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, ServicePackage.eINSTANCE)
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
        EPackage.Registry.INSTANCE.put(TechnologyPackage.eNS_URI, TechnologyPackage.eINSTANCE)
        val Injector injector = new OperationDslStandaloneSetup()
            .createInjectorAndDoEMFRegistration
        resourceSet = injector.getInstance(XtextResourceSet)
    }

    /**
     * Read an operation model and everything it imports.
     */
    def OperationGraph read(Path entry) {
        return read(#[entry])
    }

    /**
     * Read operation models and everything they import.
     *
     * @param entries the operation models to start from
     * @return the nodes reachable from them, relations resolved
     */
    def OperationGraph read(List<Path> entries) {
        val graph = new OperationGraph
        val queue = <String>newLinkedList
        val visited = <String>newLinkedHashSet

        for (entry : entries) {
            val file = canonical(entry)
            queue.add(file)
            graph.addEntryFile(file)
        }

        while (!queue.empty) {
            val file = queue.remove(0)
            // Operation models import each other for real: Infrastructure and
            // the command side of charging-station-management each import the
            // other, so the visited set is not a precaution.
            if (visited.add(file)) {
                try {
                    queue.addAll(readModel(file, graph))
                } catch (Exception exception) {
                    graph.addProblem('''«file»: «exception.message»''')
                }
            }
        }

        resolveEdges(graph)
        return graph
    }

    /**
     * Read one model into the graph, and return the operation models it imports.
     */
    private def List<String> readModel(String file, OperationGraph graph) {
        if (!Files.isRegularFile(Path.of(file))) {
            throw new IllegalStateException("no such file")
        }

        // A resource set refuses to create a resource for a URI it already
        // holds, so one reader serves several reads.
        val uri = URI.createFileURI(file)
        val resource = resourceSet.getResource(uri, false) ?: resourceSet.createResource(uri)
        if (!resource.isLoaded) {
            resource.load(resourceSet.loadOptions)
        }
        if (resource.contents.empty) {
            throw new IllegalStateException("the file holds no operation model")
        }
        val model = resource.contents.head
        if (!(model instanceof OperationModel)) {
            throw new IllegalStateException("the file holds no operation model")
        }

        val operationModel = model as OperationModel
        val imports = newLinkedHashMap
        val reachable = <String>newLinkedList

        for (anImport : operationModel.imports) {
            val target = importedFile(anImport, Path.of(file))
            if (target !== null) {
                imports.put(anImport.name, target)
                // Only another operation model holds a node.
                if (anImport.importType === ImportType.OPERATION_NODES) {
                    reachable.add(target)
                }
            }
        }
        importsByModel.put(file, imports)

        for (container : operationModel.containers) {
            graph.add(readContainer(container, file))
        }
        for (node : operationModel.infrastructureNodes) {
            graph.add(readInfrastructureNode(node, file))
        }
        return reachable
    }

    private def String importedFile(Import anImport, Path model) {
        val uri = anImport.importURI
        if (uri.nullOrEmpty) {
            return null
        }
        try {
            return canonical(model.parent.resolve(uri))
        } catch (Exception exception) {
            return null
        }
    }

    /**
     * Read a container, what it deploys and what it needs.
     */
    private def NodeInfo readContainer(Container container, String file) {
        val node = new NodeInfo(container.name, NodeKind.CONTAINER)
        node.modelFile = file
        node.operationEnvironment = writtenFeature(container,
            OperationPackage.Literals.OPERATION_NODE__OPERATION_ENVIRONMENT)
        node.technologyWritten = written(container.deploymentTechnology)
        node.technology = simpleNameOf(node.technologyWritten)

        for (service : container.deployedServices) {
            node.artifacts.add(artifactOf(service))
        }
        readCommon(node, container.aspects, container.defaultServicePropertyValues,
            container.defaultBasicEndpoints, container.deploymentSpecifications)

        keep(node, container.dependsOnNodes, StatedAs.DEPENDS_ON, file)
        keep(node, container.usedByNodes, StatedAs.USED_BY, file)
        return node
    }

    /**
     * Read an infrastructure node, what it is and what it needs.
     */
    private def NodeInfo readInfrastructureNode(InfrastructureNode infrastructure, String file) {
        val node = new NodeInfo(infrastructure.name, NodeKind.INFRASTRUCTURE)
        node.modelFile = file
        node.operationEnvironment = writtenFeature(infrastructure,
            OperationPackage.Literals.OPERATION_NODE__OPERATION_ENVIRONMENT)
        node.technologyWritten = written(infrastructure.infrastructureTechnology)
        node.technology = simpleNameOf(node.technologyWritten)

        readCommon(node, infrastructure.aspects, infrastructure.defaultServicePropertyValues,
            infrastructure.endpoints, infrastructure.deploymentSpecifications)

        keep(node, infrastructure.dependsOnNodes, StatedAs.DEPENDS_ON, file)
        keep(node, infrastructure.usedByNodes, StatedAs.USED_BY, file)

        // "used by services" names a microservice rather than a node. The
        // service is an artifact of some container, so that container is the
        // other end - resolved once every model has been read.
        for (service : infrastructure.deployedServices) {
            pending.add(new PendingEdge(node, artifactOf(service).name,
                StatedAs.USED_BY_SERVICE, written(service), file))
        }
        return node
    }

    /**
     * What a container and an infrastructure node hold alike.
     */
    private def void readCommon(NodeInfo node, List<ImportedOperationAspect> aspects,
        List<?> defaultValues, List<BasicEndpoint> endpoints,
        List<ServiceDeploymentSpecification> specifications) {
        for (aspect : aspects) {
            node.aspects.add(aspectReference(aspect))
        }
        for (value : defaultValues) {
            node.defaultValues.add(collapse(written(value as EObject)))
        }
        for (endpoint : endpoints) {
            node.endpoints.add(endpointOf(endpoint))
        }
        for (specification : specifications) {
            node.specifications.add(specificationOf(specification))
        }
    }

    private def SpecificationInfo specificationOf(ServiceDeploymentSpecification specification) {
        val info = new SpecificationInfo(simpleNameOf(written(specification.service)))
        for (value : specification.servicePropertyValues) {
            info.propertyValues.add(collapse(written(value)))
        }
        for (endpoint : specification.basicEndpoints) {
            info.endpoints.add(endpointOf(endpoint))
        }
        return info
    }

    private def EndpointInfo endpointOf(BasicEndpoint endpoint) {
        val protocol = endpoint.protocols.map[simpleNameOf(written(it))].filterNull.join(", ")
        val info = new EndpointInfo(if (protocol.empty) null else protocol)
        info.addresses.addAll(endpoint.addresses)
        return info
    }

    /**
     * A microservice a container deploys, named from what the model wrote.
     */
    private def ArtifactInfo artifactOf(ImportedMicroservice service) {
        val text = written(service)
        return new ArtifactInfo(simpleNameOf(text), text)
    }

    private def AspectReference aspectReference(ImportedOperationAspect aspect) {
        val text = collapse(written(aspect))
        return new AspectReference(aspectName(text), text)
    }

    /**
     * Keep node relations until every model has been read.
     */
    private def void keep(NodeInfo node, List<PossiblyImportedOperationNode> references,
        StatedAs statedAs, String file) {
        for (reference : references) {
            pending.add(new PendingEdge(node, written(reference), statedAs,
                written(reference), file))
        }
    }

    /**
     * Resolve every kept relation, now that every model has been read.
     */
    private def void resolveEdges(OperationGraph graph) {
        for (entry : pending) {
            graph.add(resolve(entry, graph))
        }
        pending.clear
    }

    /**
     * Resolve one relation onto the nodes at its ends, in one direction.
     */
    private def NodeEdge resolve(PendingEdge entry, OperationGraph graph) {
        if (entry.statedAs === StatedAs.USED_BY_SERVICE) {
            return resolveServiceUsage(entry, graph)
        }

        val other = nodeNamed(entry.reference, entry.modelFile, graph)

        // "A depends on B" and "B used by A" are the same relation. Both become
        // an edge from the needing node to the needed one.
        val source = if (entry.statedAs === StatedAs.DEPENDS_ON) entry.node else other
        val target = if (entry.statedAs === StatedAs.DEPENDS_ON) other else entry.node

        if (other === null) {
            val stub = stubFor(entry.reference)
            val edge = new NodeEdge(
                if (entry.statedAs === StatedAs.DEPENDS_ON) entry.node else stub,
                if (entry.statedAs === StatedAs.DEPENDS_ON) stub else entry.node,
                entry.statedAs, entry.written)
            edge.resolved = false
            edge.reason = reasonFor(entry)
            return edge
        }
        return new NodeEdge(source, target, entry.statedAs, entry.written)
    }

    /**
     * Resolve a "used by services" onto the container that deploys the service.
     */
    private def NodeEdge resolveServiceUsage(PendingEdge entry, OperationGraph graph) {
        val container = graph.containerDeploying(entry.reference)
        if (container === null) {
            val stub = stubFor(entry.reference)
            val edge = new NodeEdge(stub, entry.node, entry.statedAs, entry.written)
            edge.resolved = false
            edge.reason = '''no container of the models read deploys «entry.reference»'''
            return edge
        }
        // The container needs the node, not the other way round.
        return new NodeEdge(container, entry.node, entry.statedAs, entry.written)
    }

    /**
     * The node a reference names: the alias says which model, the name which
     * node of it.
     *
     * An operation node carries no version and its name is a single identifier,
     * so there is no qualified name to take apart - but the name is still
     * matched against the nodes that were read rather than assumed to exist.
     */
    private def NodeInfo nodeNamed(String reference, String modelFile, OperationGraph graph) {
        if (reference.nullOrEmpty) {
            return null
        }
        val text = reference.replaceAll("\\s+", "")
        val separator = text.indexOf(ALIAS_SEPARATOR)

        var String file = modelFile
        var String name = text
        if (separator >= 0) {
            val alias = text.substring(0, separator)
            name = text.substring(separator + ALIAS_SEPARATOR.length)
            file = importsByModel.get(modelFile)?.get(alias)
            if (file === null) {
                return null
            }
        }
        return graph.nodeOf(file, name)
    }

    private def String reasonFor(PendingEdge entry) {
        val text = (entry.reference ?: "").replaceAll("\\s+", "")
        val separator = text.indexOf(ALIAS_SEPARATOR)
        if (separator >= 0) {
            val alias = text.substring(0, separator)
            if (importsByModel.get(entry.modelFile)?.get(alias) === null) {
                return '''no import is named «alias»'''
            }
            return '''the model that «alias» names declares no node «text.substring(separator + ALIAS_SEPARATOR.length)»'''
        }
        return '''this model declares no node «text»'''
    }

    /**
     * A node a relation names but no read model declares.
     */
    private def NodeInfo stubFor(String reference) {
        val text = (reference ?: "<unnamed>").replaceAll("\\s+", "")
        val separator = text.indexOf(ALIAS_SEPARATOR)
        val name = if (separator >= 0)
                text.substring(separator + ALIAS_SEPARATOR.length)
            else
                text
        val stub = new NodeInfo(name, NodeKind.INFRASTRUCTURE)
        stub.resolved = false
        return stub
    }

    /**
     * The name of an aspect, read from what the model wrote.
     */
    static def String aspectName(String written) {
        if (written.nullOrEmpty) {
            return null
        }
        var text = written
        val parenthesis = text.indexOf("(")
        if (parenthesis >= 0) {
            text = text.substring(0, parenthesis)
        }
        return simpleNameOf(text.replace(";", ""))
    }

    /**
     * The last part of a written reference: ``Docker`` of
     * ``DeploymentBase::_deployment.Docker``.
     */
    static def String simpleNameOf(String written) {
        if (written.nullOrEmpty) {
            return null
        }
        var text = written.trim
        val alias = text.indexOf(ALIAS_SEPARATOR)
        if (alias >= 0) {
            text = text.substring(alias + ALIAS_SEPARATOR.length)
        }
        val dot = text.lastIndexOf(".")
        return if (dot >= 0) text.substring(dot + 1) else text
    }

    /**
     * One line out of what may be several.
     *
     * An aspect value can be an embedded shell script - the ``command`` aspect
     * of ``examples/charging-station-management`` is one - and a newline inside
     * a token carries no meaning the diagram can use.
     */
    private def String collapse(String text) {
        return text?.replaceAll("\\s+", " ")?.trim
    }

    /**
     * What the model wrote for one feature of an element.
     *
     * An operation environment is referred to by a string rather than through a
     * contained element, so there is nothing whose own text holds it: the nodes
     * of that feature are the only place it is readable.
     */
    private def String writtenFeature(EObject element, EStructuralFeature feature) {
        if (element === null) {
            return null
        }
        val nodes = NodeModelUtils.findNodesForFeature(element, feature)
        if (nodes.empty) {
            return null
        }
        val text = nodes.map[NodeModelUtils.getTokenText(it)].join(" ").trim.replace("\"", "")
        return if (text.empty) null else text
    }

    /**
     * What the model wrote for an element, read from the parse tree.
     */
    private def String written(EObject element) {
        if (element === null) {
            return null
        }
        val node = NodeModelUtils.findActualNodeFor(element)
        if (node === null) {
            return null
        }
        val text = NodeModelUtils.getTokenText(node)?.trim
        return if (text.nullOrEmpty) null else text
    }

    private def String canonical(Path path) {
        return path.toAbsolutePath.normalize.toString
    }
}

/**
 * A relation read but not yet resolved.
 */
class PendingEdge {
    public val NodeInfo node
    public val String reference
    public val StatedAs statedAs
    public val String written
    public val String modelFile

    new(NodeInfo node, String reference, StatedAs statedAs, String written, String modelFile) {
        this.node = node
        this.reference = reference
        this.statedAs = statedAs
        this.written = written
        this.modelFile = modelFile
    }
}
