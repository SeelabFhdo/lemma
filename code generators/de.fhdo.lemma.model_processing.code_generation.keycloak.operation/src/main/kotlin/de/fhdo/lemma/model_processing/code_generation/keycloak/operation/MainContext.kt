package de.fhdo.lemma.model_processing.code_generation.keycloak.operation

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Client
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Group
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Realm
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Role
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.Roles
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.User
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig.UserActions

internal object MainContext {

    object State {

        private lateinit var realm: Realm
        private val roles: Roles = Roles()
        private val clients = mutableMapOf<String, Client>()
        private val groups = mutableMapOf<String, Group>()
        private val users = mutableListOf<User>()

        fun initialize() {

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

        fun addRole(clientName: String, properties: Map<String, Any>) {
            val roleName = properties["name"] as String
            properties["clientRole"]?.let {
                if (it as Boolean) {
                    return this.roles.addClientRoles(clientName, Role(roleName, properties.toMutableMap()))
                }
            }
            this.roles.addRealmRole(Role(roleName, properties.toMutableMap()))
        }
    }
}



