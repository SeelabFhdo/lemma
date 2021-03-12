package de.fhdo.lemma.visualizer.processor


// Probably not needed and crap ;)
class ProcessingThread(runArray : Array<String>) : Runnable {
    val runArray : Array<String> = runArray

    override fun run() {
        ModelProcessor().run(runArray)
    }
}