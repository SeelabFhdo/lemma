package de.fhdo.reconstruction.framework.util

import java.io.File

/**
 * Directory explorer for deserializing a single Java file or a whole directory.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class DirExplorer() {

    /**
     * Interface for file handling based of a file, path and level.
     */
    private fun fileHandler (level: Int, path: String, file: File) {
        println(file.toString())
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
