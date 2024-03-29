/*
 * generated by Xtext 2.26.0
 */
package de.fhdo.lemma.technology.mappingdsl.parser.antlr;

import com.google.inject.Inject;
import de.fhdo.lemma.technology.mappingdsl.parser.antlr.internal.InternalMappingDslParser;
import de.fhdo.lemma.technology.mappingdsl.services.MappingDslGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class MappingDslParser extends AbstractAntlrParser {

	@Inject
	private MappingDslGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMappingDslParser createParser(XtextTokenStream stream) {
		return new InternalMappingDslParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "TechnologyMapping";
	}

	public MappingDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MappingDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
