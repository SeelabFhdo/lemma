package de.fhdo.lemma.model_processing.code_generation.keycloak.operation

import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Client
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Group
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Realm
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Role
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Roles
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.User
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.addProperty
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.applicationPropertiesKeyMapper
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import java.io.File


internal object MainContext {

    object State {
        private lateinit var targetFolder: String
        private val applicationProperties = mutableMapOf<String, String>()
        private lateinit var realm: Realm
        private val clientRole = mutableMapOf<String, String>()
        private val roles: Roles = Roles()
        private val clients = mutableMapOf<String, Client>()
        private val groups = mutableMapOf<String, Group>()
        private val users = mutableListOf<User>()
        private val clientNames = mutableMapOf<String, String>()

        fun initialize(targetFolder: String) {
            this.targetFolder = targetFolder.trimEnd(File.separatorChar)
        }

        fun addApplicationProperties(applicationProperties: Map<String, String>) {
            this.applicationProperties.putAll(applicationProperties)
        }

        fun addApplicationProperty(key: String, value: String) {
            this.applicationProperties[key] = value
        }

        fun getClientApplicationProperties(client: String): SortableProperties {
            val sortableProperties = SortableProperties()
            applicationProperties.forEach { (key, value) ->
                sortableProperties.addProperty(applicationPropertiesKeyMapper(key) to value)
            }

            sortableProperties.addProperty((applicationPropertiesKeyMapper("resource") to getClientName(client)))
            if (!sortableProperties.containsKey("realm"))
                sortableProperties.addProperty(applicationPropertiesKeyMapper("realm") to realm.id)
            return sortableProperties
        }

        fun addRole(clientName: String, properties: Map<String, Any>) {
            val roleName = properties["name"] as String
            properties["clientRole"]?.let {
                if (it as Boolean) {
                    clientRole[clientName] = roleName
                    return this.roles.addClientRoles(clientName, Role(roleName, properties.toMutableMap()))
                }
            }
            this.roles.addRealmRole(Role(roleName, properties.toMutableMap()))
        }

        fun addUser(properties: Map<String, Any>) {
            val username = properties["username"] as String
            users.add(User(username, properties))
        }

        fun getRealmName() = realm.id

        fun addGroup(properties: Map<String, Any>) {
            val groupName = properties["name"] as String
            if (!groups.containsKey(groupName))
                groups[groupName] = Group(groupName)
            properties["realmRoles"]?.let { groups[groupName]?.addRoles((it as String).split(",")) }
        }

        fun createRealm(properties: Map<String, Any>) {
            this.realm = Realm(properties["realm"] as String)
            this.realm.addRealmProperties(properties)
        }

        fun addClient(properties: Map<String, Any>) {
            val clientId = properties["clientId"] as String
            if (!clients.containsKey(clientId))
                clients[clientId] = Client(clientId)
            clients[clientId]?.addProperties(properties)
        }

        fun addClient(clientId: String) {
            if (!clients.containsKey(clientId))
                clients[clientId] = Client(clientId)
            clients[clientId]?.addProperty("clientId", clientId)
            clients[clientId]?.addProperty("clientProtocol", "openid-connect")
        }

        fun addClientName(qualifiedName: String, clientName: String) {
            clientNames[qualifiedName] = clientName
        }


        fun getRealmAsJson(): String {
            realm.roles = roles
            realm.clients.putAll(clients)
            realm.groups.putAll(groups)
            realm.users.addAll(users)
            return realm.getRealmAsJsonString()
        }

        fun reset() {
            clients.clear()
            groups.clear()
            users.clear()
            roles.resetRoles()
        }

        fun getClientName(qualifiedName: String) = clientNames[qualifiedName] ?: qualifiedName

        fun findServiceByQualifiedName(qualifiedName: String): String? {
            ModelsContext.State.intermediateServiceModels.forEach { (uri, intermediateServiceModel) ->
                intermediateServiceModel.microservices.find { it.name == qualifiedName.trim() }
                    ?.let { intermediateMicroservice ->
                        return intermediateMicroservice.classname
                    }
            }

            ModelsContext.State.intermediateOperationModels.forEach { (uri, intermediateOperationModel) ->
                intermediateOperationModel.infrastructureNodes.find { it.name == qualifiedName.trim() }
                    ?.let { intermediateInfrastructureNode ->
                        return intermediateInfrastructureNode.name
                    }
            }
            return null
        }

        /**
         * Helper to calculate the target folder path of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPath(servicePackage: String) =
            "$targetFolder${File.separator}$servicePackage.packageToPath()"


        /**
         * Helper to calculate the target folder path for Java files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForJavaFiles(servicePackage: String) = listOf(
            targetFolder,
            servicePackage.packageToPath(),
            "src", "main", "java",
            servicePackage.packageToPath()
        ).joinToString(File.separator)


        /**
         * Helper to calculate the target folder path for resource files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForResourceFiles(servicePackage: String) = listOf(
            targetFolder,
            servicePackage.packageToPath(),
            "src", "main", "resources"
        ).joinToString(File.separator)

        fun getPath(pathSpecifier: PathSpecifier, servicePackage: String) = when (pathSpecifier) {
            PathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH -> currentMicroserviceTargetFolderPath(
                servicePackage
            )
            PathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH -> currentMicroserviceTargetFolderPathForJavaFiles(
                servicePackage
            )
            PathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH -> currentMicroserviceTargetFolderPathForResourceFiles(
                servicePackage
            )
        }
    }
}

enum class PathSpecifier {
    CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
    CURRENT_MICROSERVICE_RESOURCES_PATH,
    CURRENT_MICROSERVICE_GENERATION_TARGET_PATH
}




