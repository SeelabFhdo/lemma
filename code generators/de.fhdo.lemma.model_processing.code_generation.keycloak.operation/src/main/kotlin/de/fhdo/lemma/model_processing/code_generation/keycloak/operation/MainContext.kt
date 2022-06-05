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
        private val realmClients = mutableListOf<Client>()
        private val groups = mutableMapOf<String, Group>()
        private val users = mutableListOf<User>()

        fun initialize() {

        }

        fun addUser(
            username: String,
            firstname: String,
            lastname: String,
            email: String,
            enabled: Boolean,
            requiredUserActions: UserActions
        ) {
            users.add(User(username, firstname, lastname, email, enabled, requiredUserActions))
        }

        fun getRealmName() = realm.id

        fun addGroup(groupName: String, roles: String) {
            groups[groupName] = Group(groupName)
        }


        fun createRealm(properties: Map<String, Any>) {
            this.realm = Realm(properties["realm"] as String)
            this.realm.addRealmProperties(properties)
        }

        fun getRealmAsJson(): String {
            realm.roles = roles
            return realm.getRealmAsJsonString()
        }

        fun reset() {
            realmClients.clear()
            groups.clear()
            users.clear()
        }

        fun addRole(clientName: String, properties: Map<String, Any>) {
            if (properties.containsKey("clientRole")) {
                if(properties["clientRole"] as Boolean)
                    this.roles.addClientRoles(clientName,  Role(properties))
                else
                    this.roles.addRealmRole(Role(properties))
            }
            else{
                this.roles.addRealmRole(Role(properties))
            }
        }
    }
}

