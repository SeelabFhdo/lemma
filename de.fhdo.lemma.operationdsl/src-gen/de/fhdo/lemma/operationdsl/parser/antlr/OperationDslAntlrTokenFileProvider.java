/*
 * generated by Xtext 2.26.0
 */
package de.fhdo.lemma.operationdsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class OperationDslAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("de/fhdo/lemma/operationdsl/parser/antlr/internal/InternalOperationDsl.tokens");
	}
}
