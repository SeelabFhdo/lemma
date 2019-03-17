package de.fhdo.ddmm.live_validation

import java.util.Properties

private const val PROPERTY_RESOURCE_FILE = "live_validation.properties"

/**
 * Internal object to allow a uniform access to the application's properties at runtime.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object ApplicationProperties {
    private val properties = Properties()
    private var loaded = false

    /**
     * Get property from the property resource file
     */
    operator fun get(propertyName: String) : Any? {
        if (!loaded) {
            properties.load(this.javaClass.classLoader.getResourceAsStream(PROPERTY_RESOURCE_FILE))
            loaded = true
        }

        return properties[propertyName]
    }
}