package de.fhdo.lemma.model_processing.code_generation.java_base

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CountingPlainCodeGenerationSerializer
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.DefaultSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.CountingMavenDependencySerializer
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Entry point of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    /* Setup dependency injections and determine the injected implementations per expected interface */
    startKoin { modules( module {
        factory<AbstractSerializationConfiguration> { DefaultSerializationConfiguration }
        factory<CodeGenerationSerializerI> { CountingPlainCodeGenerationSerializer() }
        factory<DependencySerializerI<*, *>> { CountingMavenDependencySerializer() }
    } ) }

    /* Run the Java base generator */
    JavaBaseGenerator().run(args)
}

/**
 * Main class of the Java base generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class JavaBaseGenerator : AbstractModelProcessor("de.fhdo.lemma.model_processing.code_generation.java_base")