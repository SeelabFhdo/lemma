/*
 * generated by Xtext 2.26.0
 */
package de.fhdo.lemma.data.parser.antlr;

import com.google.inject.Inject;
import de.fhdo.lemma.data.parser.antlr.internal.InternalDataDslParser;
import de.fhdo.lemma.data.services.DataDslGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class DataDslParser extends AbstractAntlrParser {

	@Inject
	private DataDslGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalDataDslParser createParser(XtextTokenStream stream) {
		return new InternalDataDslParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "DataModel";
	}

	public DataDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DataDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
