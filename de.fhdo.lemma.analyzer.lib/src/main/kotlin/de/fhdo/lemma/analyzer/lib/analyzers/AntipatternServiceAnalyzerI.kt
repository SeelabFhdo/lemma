package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern

interface AntipatternServiceAnalyzerI : AnalyzerI {
    fun checkExistingAntipattern(): Collection<Antipattern>
}