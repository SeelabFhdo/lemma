package de.fhdo.lemma.visualizer.model

import guru.nidi.graphviz.engine.Format

/**
 * Class is used to configure the output image.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
data class ImageConfig(val height : Int? = null, val width : Int? = null, val format : Format? = Format.PNG)