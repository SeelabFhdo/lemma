package de.fhdo.lemma.reconstruction.spring.parser

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.visitor.VoidVisitorAdapter
import de.fhdo.lemma.reconstruction.spring.context.SpringContext
import java.io.File


/**
 * Directory explorer for deserializing a single Java file or a whole directory.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class JavaDirExplorer() {

    /**
     * Interface for file handling based of a file, path and level.
     */
    private fun fileHandler (level: Int, path: String, file: File) {
        val javaParser = JavaParser().parse(file).result.get()
        println()
        object : VoidVisitorAdapter<Any?>() {
            override fun visit(n: ClassOrInterfaceDeclaration, arg: Any?) {
                SpringContext.addClass(file.path, n)
                println()
            }
        }.visit(javaParser, null)

    }

    /**
     * Interface for filtering files or directories.
     */
    private fun filter(path: String): Boolean {
        return when {
            path.endsWith(".java") -> true
            //path.endsWith(".properties") -> true
            else -> false
        }
    }

    /**
     * Methode for exploring all files or directories based of a file path.
     */
    fun explore(level: Int, path: String, file: File) {
        if (file.isDirectory) {
           file.listFiles()?.forEach {
               explore(level + 1, path + "/" + it.name, it)
           }
        } else {
            if (filter(path)) {
                fileHandler(level, path, file)
            }
        }
    }

    /**
     * Explore a single file.
     */
    fun explore(root: File) {
        explore(0, "", root)
    }
}

/**
 * Iterator for visiting all nodes.
 */
class NodeIterator(val nodeHandler: NodeHandler) {
    /**
     * Interface for handling nodes.
     */
    abstract class NodeHandler: (Node) -> Boolean {
       abstract fun handle(node: Node) : Boolean
   }

    /**
     * Explore all child nodes.
     */
    fun explore(node: Node) {
        if (nodeHandler.handle(node)) {
            node.childNodes.forEach{
                explore(it)
            }
        }
    }
}