package de.fhdo.ddmm.acceleo.parser

import org.eclipse.acceleo.internal.parser.compiler.AcceleoParser
import org.eclipse.acceleo.internal.parser.compiler.AcceleoProject
import org.eclipse.acceleo.internal.parser.compiler.AcceleoProjectClasspathEntry
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.Monitor
import org.eclipse.emf.ecore.EPackage
import java.io.File
import java.lang.IllegalStateException

/**
 * Entry builder function for configuring and creating an Acceleo parser.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun parser(rootPath: String, initializer: ParserBuilder.() -> ParserBuilder)
    = ParserBuilder(rootPath).let(initializer).create()

/**
 * Builder for configuring and creating Acceleo parsers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class ParserBuilder(private val rootPath: String) {
    private val classpathEntries = mutableSetOf<AcceleoProjectClasspathEntry>()
    private var useBinaryResources = false
    private var usePlatformResourcePath = false
    private var trimPosition = false

    private lateinit var ePackage: EPackage

    /**
     * Configure domain-specific EPackage used in transformation modules
     */
    fun ePackage(ePackage: EPackage) : ParserBuilder {
        this.ePackage = ePackage
        return this
    }

    /**
     * Add an entry to Acceleo's classpath used throughout the parsing process
     */
    fun classpathEntry(inputDirectoryPath: String, outputDirectoryPath: String) : ParserBuilder {
        classpathEntries += AcceleoProjectClasspathEntry(File(inputDirectoryPath), File(outputDirectoryPath))
        return this
    }

    /**
     * Set useBinaryResources flag for Acceleo parser
     */
    fun useBinaryResources(value: Boolean = true) : ParserBuilder {
        useBinaryResources = value
        return this
    }

    /**
     * Set usePlatformResourcePath flag for Acceleo parser
     */
    fun usePlatformResourcePath(value: Boolean = true) : ParserBuilder {
        usePlatformResourcePath = value
        return this
    }

    /**
     * Set trimPosition flag for Acceleo parser
     */
    fun trimPosition(value: Boolean = true) : ParserBuilder {
        trimPosition = value
        return this
    }

    /**
     * Register EPackage and create a [Parser] instance according to the configuration
     */
    fun create() : Parser {
        EPackage.Registry.INSTANCE[ePackage.nsURI] = ePackage

        return Parser(
            AcceleoProject(File(rootPath), classpathEntries),
            useBinaryResources,
            usePlatformResourcePath,
            trimPosition
        )
    }
}

/**
 * Convenience extension of [AcceleoParser].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class Parser(acceleoProject: AcceleoProject, useBinaryResources: Boolean, usePlatformResourcePath: Boolean,
    trimPosition: Boolean) : AcceleoParser(acceleoProject, useBinaryResources, usePlatformResourcePath, trimPosition) {
    // Collect files that were parsed during a parsing process
    private lateinit var parsedFiles: Set<File>

    /**
     * Build all transformation modules contained in a project's root path
     */
    override fun buildAll(monitor: Monitor?): MutableSet<File> {
        parsedFiles = super.buildAll(monitor)
        return parsedFiles.map { it }.toMutableSet()
    }

    /**
     * Build a certain transformation module contained in a project's root path
     */
    override fun buildFile(file: File?, monitor: Monitor?): MutableSet<File> {
        parsedFiles = super.buildAll(monitor)
        return parsedFiles.map { it }.toMutableSet()
    }

    /**
     * Build all transformation modules with status outputs on STDOUT ([silent] set to true) or without status outputs
     * ([silent] set to false)
     */
    fun buildAll(silent: Boolean = false) {
        buildAll(if (silent) BasicMonitor() else BasicMonitor.Printing(System.out))
    }

    /**
     * Build a certain transformation module contained in a project's root path with status outputs on STDOUT ([silent]
     * set to true) or without status outputs ([silent] set to false)
     */
    fun buildFile(file: File, silent: Boolean= false) {
        buildFile(file, if (silent) BasicMonitor() else BasicMonitor.Printing(System.out))
    }

    /**
     * Get errors and warnings that occurred during a parsing process as printable messages
     */
    fun printableParsingResult() : StringBuffer {
        if (!::parsedFiles.isInitialized)
            throw IllegalStateException("Printable parsing result cannot be created, because no parsing occurred yet")

        if (parsedFiles.isEmpty())
            return StringBuffer("All transformation files are up-to-date: No EMTL files were created")

        val resultBuffer = StringBuffer()
        for (filePath in parsedFiles) {
            val problems = getProblems(filePath)
            val warnings = getWarnings(filePath)
            if (!problems.isEmpty() || !warnings.isEmpty())
                resultBuffer.newln("Messages occurred during parsing of $filePath:")

            problems.forEach { resultBuffer.newln("PROBLEM (${it.line}, ${it.posBegin}:${it.posEnd}): ${it.message}") }
            warnings.forEach { resultBuffer.newln("WARNING (${it.line}, ${it.posBegin}:${it.posEnd}): ${it.message}") }
        }
        return resultBuffer
    }
}

/**
 * Helper extension to append a [String] to a [StringBuffer] ended by a newline ('\n')
 */
private fun StringBuffer.newln(s: String) = this.append("$s\n")