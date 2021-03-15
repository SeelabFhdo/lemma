package de.fhdo.lemma.visualizer.model

import guru.nidi.graphviz.engine.Format

data class ImageConfig(val height : Int? = null, val width : Int? = null, val format : Format? = Format.PNG)