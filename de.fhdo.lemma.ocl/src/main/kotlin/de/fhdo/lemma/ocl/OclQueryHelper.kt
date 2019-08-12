package de.fhdo.lemma.ocl

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory
import org.eclipse.ocl.ecore.OCL
import java.lang.ClassCastException
import kotlin.reflect.KClass

/**
 * Singleton facade with convenience methods for executing OCL queries on models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object OclQueryHelper {
    /**
     * Execute an OCL query on a model stored in an XMI file
     */
    fun <T: Any> query(modelFilePath: String, ePackageInstance: EPackage, query: String, clazz: Class<T>) : T? {
        Resource.Factory.Registry.INSTANCE.extensionToFactoryMap["xmi"] = XMIResourceFactoryImpl()
        EPackage.Registry.INSTANCE[ePackageInstance.nsURI] = ePackageInstance

        val resourceSet = ResourceSetImpl()
        val resource = resourceSet.createResource(URI.createURI(modelFilePath)) as Resource
        resource.load(null)
        return query(resource, query, clazz)
    }

    /**
     * Execute an OCL query on a model stored in an XMI file and return a [Collection] instance if the query returned an
     * OCL Collection instance
     */
    fun queryCollection(modelFilePath: String, ePackageInstance: EPackage, query: String)
            = query(modelFilePath, ePackageInstance, query, Collection::class.java)

    /**
     * Execute an OCL query on an EMF [Resource] instance
     */
    fun <T: Any> query(resource: Resource, query: String, clazz: Class<T>) : T? {
        if (resource.contents.isEmpty())
            return null

        EcoreUtil.resolveAll(resource)
        val rootObject = EcoreUtil.getRootContainer(resource.contents[0], false)
        return query(rootObject, query, clazz)
    }

    /**
     * Execute an OCL query on an EMF [Resource] instance and return a [Collection] instance if the query returned an
     * OCL Collection instance
     */
    fun queryCollection(resource: Resource, query: String)
            = OclQueryHelper.query(resource, query, Collection::class.java)

    /**
     * Execute a query on an EMF [EObject] instance
     */
    fun <T: Any> query(eObject: EObject, query: String, clazz: Class<T>) : T? {
        val ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE)
        val helper = ocl.createOCLHelper()
        helper.setContext(eObject.eClass())
        val oclQuery = helper.createQuery(query)

        val queryResult = ocl.createQuery(oclQuery).evaluate(eObject)
        return try {
            clazz.cast(queryResult)
        } catch (ex: ClassCastException) {
            null
        }
    }

    /**
     * Execute a query on an EMF [EObject] instance and return a [Collection] instance if the query returned an OCL
     * Collection instance
     */
    fun queryCollection(eObject: EObject, query: String) = OclQueryHelper.query(eObject, query, Collection::class.java)
}