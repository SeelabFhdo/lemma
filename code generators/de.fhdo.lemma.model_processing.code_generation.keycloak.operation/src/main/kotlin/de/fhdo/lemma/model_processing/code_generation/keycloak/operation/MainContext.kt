package de.fhdo.lemma.model_processing.code_generation.keycloak.operation

import com.fasterxml.jackson.databind.ObjectMapper
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
        private lateinit var roles: Roles
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

        fun addGroup(groupName: String, roles: String){
            groups[groupName] = Group(groupName)
        }

        fun addRealmRole(role: Role) {
            this.roles.addRealmRole(role)
        }

        fun addClientRole(client: String, role: Role) {
            this.roles.addClientRoles(client, role)
        }

        fun createRealm(properties: Map<String, Any>) {
            this.realm = Realm()
            this.realm.addRealmProperties(properties)
        }

        fun getRealmAsJson(): String{
            println(realm)
            return realm.getRealmAsJsonString()
        }

        fun reset() {
            realmClients.clear()
            groups.clear()
            users.clear()
        }

    }
}

