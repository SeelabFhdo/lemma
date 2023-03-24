package de.fhdo.lemma.analyzer

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType

internal object AntipatternAnalysisPrinting {

    fun printAntipatternAnalysis(antipattern: Collection<Antipattern>, analysisType: String){
        section("Antipattern analysis result - Type: $analysisType")
        if(antipattern.isEmpty()){
            println("No potential antipatterns identified. Everything seems to be clean.")
            blankLine()
            return
        }
        println("Disclaimer: Identified Antipattern are not always bad practices, but can be a hint!")
        subsection("Statistic - Identified antipatterns")
        val statistic = getStatistic(antipattern)
        statistic.keys.forEach {println("${it.displayName}:\t ${statistic.get(it)}")}
        blankLine()
        subsection("List - All identified antipatterns")
        antipattern.forEach{ println("${it.type.displayName}:\t ${it.message}") }
        blankLine()
    }

    private fun getStatistic(antipatterns: Collection<Antipattern>): Map<AntipatternType, Int> {
        val result = mutableMapOf<AntipatternType, Int>()
        for (antipattern in antipatterns) {
            val count = result.get(antipattern.type)
            if (count == null){
                result[antipattern.type] = 1
            }else{
                result[antipattern.type] = count + 1
            }
        }
        return result
    }
}