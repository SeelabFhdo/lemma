package de.fhdo.lemma.model_processing.code_generation.java_base

import com.github.javaparser.printer.PrettyPrinterConfiguration
import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.DefaultCodeGenerationSerializationPrettyPrinterConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencySerializer
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.PlainCodeGenerationSerializer
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.reflect.KClass

/**
 * Entry point of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    /* Setup dependency injections and determine the injected implementations per expected interface */
    startKoin { modules( module {
        factory<PrettyPrinterConfiguration> { DefaultCodeGenerationSerializationPrettyPrinterConfiguration }
        factory<CodeGenerationSerializerI> { PlainCodeGenerationSerializer() }
        factory<DependencySerializerI<*, *>> { MavenDependencySerializer() }
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