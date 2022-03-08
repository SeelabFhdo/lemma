package de.fhdo.lemma.model_processing.code_generation.java_base

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.findCodeGenerationSerializers
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.DefaultSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.CountingMavenDependencySerializer
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencySerializer
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Main class of the Java base generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class JavaBaseGenerator : AbstractModelProcessor("de.fhdo.lemma.model_processing.code_generation.java_base")

/**
 * Entry point of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    /* Parse commandline and setup dependency injection for code generation serializers */
    val serializerPackage = object{}.javaClass.packageName + ".serialization.code_generation"
    CommandLine(args, findCodeGenerationSerializers(serializerPackage))
    val (codeGenerationSerializer, _) = CommandLine.codeGenerationSerializer

    startKoin { modules( module {
        factory<AbstractSerializationConfiguration> { DefaultSerializationConfiguration }
        factory { codeGenerationSerializer }
        factory<DependencySerializerI<*>> {
            if (CommandLine.parameterLineCountFile != null)
                CountingMavenDependencySerializer()
            else
                MavenDependencySerializer()
        }
    } ) }

    /* Delegate execution to model processing framework */
    // Note that we only pass those arguments to the framework, which didn't match that supported by the Java Base
    // Generator. This approach enables to pass arguments to the generator itself instead of having to specify them for
    // the "main" code generation module.
    JavaBaseGenerator().run(CommandLine.unmatched)
}