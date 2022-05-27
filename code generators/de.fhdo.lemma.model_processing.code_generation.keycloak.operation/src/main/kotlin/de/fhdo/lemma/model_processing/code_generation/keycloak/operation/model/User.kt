package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model

data class User (
   val username: String,
   val firstname: String,
   val lastname : String,
   val email: String,
   val enabled: Boolean,
   val requiredUserActions: UserActions,
)


enum class UserActions{
    CONFIGURE_OTP, UPDATE_PASSWORD, UPDATE_PROFILE, VERIFY_EMAIL, UPDATE_USER_LOCALE
}