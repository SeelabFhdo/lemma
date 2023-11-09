/*
 * generated by Xtext 2.32.0
 */
package de.fhdo.lemma.technology.mappingdsl.serializer;

import com.google.inject.Inject;
import de.fhdo.lemma.technology.mappingdsl.services.MappingDslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class MappingDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MappingDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_DataOperationMapping_SemicolonKeyword_2_1_or___LeftCurlyBracketKeyword_2_0_0_RightCurlyBracketKeyword_2_0_4__;
	protected AbstractElementAlias match_DataOperation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_3__q;
	protected AbstractElementAlias match_OperationAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__;
	protected AbstractElementAlias match_ServiceAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MappingDslGrammarAccess) access;
		match_DataOperationMapping_SemicolonKeyword_2_1_or___LeftCurlyBracketKeyword_2_0_0_RightCurlyBracketKeyword_2_0_4__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getDataOperationMappingAccess().getLeftCurlyBracketKeyword_2_0_0()), new TokenAlias(false, false, grammarAccess.getDataOperationMappingAccess().getRightCurlyBracketKeyword_2_0_4())), new TokenAlias(false, false, grammarAccess.getDataOperationMappingAccess().getSemicolonKeyword_2_1()));
		match_DataOperation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3()));
		match_OperationAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0()), new TokenAlias(false, false, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3())), new TokenAlias(false, false, grammarAccess.getOperationAspectAccess().getSemicolonKeyword_6_1()));
		match_ServiceAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0()), new TokenAlias(false, false, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3())), new TokenAlias(false, false, grammarAccess.getServiceAspectAccess().getSemicolonKeyword_6_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_DataOperationMapping_SemicolonKeyword_2_1_or___LeftCurlyBracketKeyword_2_0_0_RightCurlyBracketKeyword_2_0_4__.equals(syntax))
				emit_DataOperationMapping_SemicolonKeyword_2_1_or___LeftCurlyBracketKeyword_2_0_0_RightCurlyBracketKeyword_2_0_4__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DataOperation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_3__q.equals(syntax))
				emit_DataOperation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_OperationAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__.equals(syntax))
				emit_OperationAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ServiceAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__.equals(syntax))
				emit_ServiceAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('{' '}') | ';'
	 *
	 * This ambiguous syntax occurs at:
	 *     dataOperation=[DataOperation|ID] (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_DataOperationMapping_SemicolonKeyword_2_1_or___LeftCurlyBracketKeyword_2_0_0_RightCurlyBracketKeyword_2_0_4__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) '&lt;' features+=DataOperationFeature
	 *     name=ID (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_DataOperation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('{' '}') | ';'
	 *
	 * This ambiguous syntax occurs at:
	 *     joinPoints+=OperationJoinPointType (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_OperationAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('{' '}') | ';'
	 *
	 * This ambiguous syntax occurs at:
	 *     joinPoints+=ServiceJoinPointType (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ServiceAspect_SemicolonKeyword_6_1_or___LeftCurlyBracketKeyword_6_0_0_RightCurlyBracketKeyword_6_0_3__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
