package de.fhdo.lemma.reconstruction.spring.web.parser

import com.github.javaparser.ast.CompilationUnit
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree


class JavaParseTree constructor(fileType: String, val compilationUnit: CompilationUnit):
    AbstractParseTree(fileType)