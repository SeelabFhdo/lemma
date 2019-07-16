package de.fhdo.ddmm.technology.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.fhdo.ddmm.technology.services.TechnologyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTechnologyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'technology'", "'{'", "'types'", "'compatibility'", "'matrix'", "'}'", "'protocols'", "'service'", "'aspects'", "'deployment'", "'technologies'", "'infrastructure'", "'operation'", "'import'", "'from'", "'as'", "'data'", "'formats'", "','", "'default'", "'with'", "'format'", "';'", "'primitive'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'::'", "'environments'", "'='", "'properties'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'('", "')'", "'aspect'", "'for'", "'datatypes'", "'version'", "'context'", "'extends'", "'hide'", "'enum'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'->'", "'<->'", "'mandatory'", "'singleval'", "'microservices'", "'interfaces'", "'operations'", "'parameters'", "'fields'", "'containers'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int RULE_BIG_DECIMAL=6;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalTechnologyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTechnologyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTechnologyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTechnologyDsl.g"; }



     	private TechnologyDslGrammarAccess grammarAccess;

        public InternalTechnologyDslParser(TokenStream input, TechnologyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Technology";
       	}

       	@Override
       	protected TechnologyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTechnology"
    // InternalTechnologyDsl.g:65:1: entryRuleTechnology returns [EObject current=null] : iv_ruleTechnology= ruleTechnology EOF ;
    public final EObject entryRuleTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnology = null;


        try {
            // InternalTechnologyDsl.g:65:51: (iv_ruleTechnology= ruleTechnology EOF )
            // InternalTechnologyDsl.g:66:2: iv_ruleTechnology= ruleTechnology EOF
            {
             newCompositeNode(grammarAccess.getTechnologyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnology=ruleTechnology();

            state._fsp--;

             current =iv_ruleTechnology; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnology"


    // $ANTLR start "ruleTechnology"
    // InternalTechnologyDsl.g:72:1: ruleTechnology returns [EObject current=null] : ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' ) ;
    public final EObject ruleTechnology() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        EObject lv_imports_0_0 = null;

        EObject lv_primitiveTypes_6_0 = null;

        EObject lv_listTypes_7_0 = null;

        EObject lv_dataStructures_8_0 = null;

        EObject lv_compatibilityEntries_12_0 = null;

        EObject lv_protocols_17_0 = null;

        EObject lv_serviceAspects_22_0 = null;

        EObject lv_deploymentTechnologies_27_0 = null;

        EObject lv_infrastructureTechnologies_32_0 = null;

        EObject lv_operationAspects_37_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' ) )
            // InternalTechnologyDsl.g:79:2: ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' )
            {
            // InternalTechnologyDsl.g:79:2: ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' )
            // InternalTechnologyDsl.g:80:3: ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}'
            {
            // InternalTechnologyDsl.g:80:3: ( (lv_imports_0_0= ruleTechnologyImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==26) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTechnologyDsl.g:81:4: (lv_imports_0_0= ruleTechnologyImport )
            	    {
            	    // InternalTechnologyDsl.g:81:4: (lv_imports_0_0= ruleTechnologyImport )
            	    // InternalTechnologyDsl.g:82:5: lv_imports_0_0= ruleTechnologyImport
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyAccess().getImportsTechnologyImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleTechnologyImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"de.fhdo.ddmm.technology.TechnologyDsl.TechnologyImport");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyAccess().getTechnologyKeyword_1());
            		
            // InternalTechnologyDsl.g:103:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:104:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:104:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:105:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTechnologyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTechnologyDsl.g:125:3: (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTechnologyDsl.g:126:4: otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyAccess().getTypesKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalTechnologyDsl.g:134:4: ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=4;
                        switch ( input.LA(1) ) {
                        case 36:
                            {
                            alt2=1;
                            }
                            break;
                        case 40:
                            {
                            alt2=2;
                            }
                            break;
                        case 41:
                            {
                            alt2=3;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:135:5: ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) )
                    	    {
                    	    // InternalTechnologyDsl.g:135:5: ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) )
                    	    // InternalTechnologyDsl.g:136:6: (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType )
                    	    {
                    	    // InternalTechnologyDsl.g:136:6: (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType )
                    	    // InternalTechnologyDsl.g:137:7: lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologyAccess().getPrimitiveTypesTechnologySpecificPrimitiveTypeParserRuleCall_4_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_primitiveTypes_6_0=ruleTechnologySpecificPrimitiveType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"primitiveTypes",
                    	    								lv_primitiveTypes_6_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificPrimitiveType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTechnologyDsl.g:155:5: ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) )
                    	    {
                    	    // InternalTechnologyDsl.g:155:5: ( (lv_listTypes_7_0= ruleTechnologySpecificListType ) )
                    	    // InternalTechnologyDsl.g:156:6: (lv_listTypes_7_0= ruleTechnologySpecificListType )
                    	    {
                    	    // InternalTechnologyDsl.g:156:6: (lv_listTypes_7_0= ruleTechnologySpecificListType )
                    	    // InternalTechnologyDsl.g:157:7: lv_listTypes_7_0= ruleTechnologySpecificListType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologyAccess().getListTypesTechnologySpecificListTypeParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_listTypes_7_0=ruleTechnologySpecificListType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"listTypes",
                    	    								lv_listTypes_7_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificListType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTechnologyDsl.g:175:5: ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) )
                    	    {
                    	    // InternalTechnologyDsl.g:175:5: ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) )
                    	    // InternalTechnologyDsl.g:176:6: (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure )
                    	    {
                    	    // InternalTechnologyDsl.g:176:6: (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure )
                    	    // InternalTechnologyDsl.g:177:7: lv_dataStructures_8_0= ruleTechnologySpecificDataStructure
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologyAccess().getDataStructuresTechnologySpecificDataStructureParserRuleCall_4_2_2_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_dataStructures_8_0=ruleTechnologySpecificDataStructure();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataStructures",
                    	    								lv_dataStructures_8_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificDataStructure");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    // InternalTechnologyDsl.g:195:4: (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==16) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalTechnologyDsl.g:196:5: otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}'
                            {
                            otherlv_9=(Token)match(input,16,FOLLOW_9); 

                            					newLeafNode(otherlv_9, grammarAccess.getTechnologyAccess().getCompatibilityKeyword_4_3_0());
                            				
                            otherlv_10=(Token)match(input,17,FOLLOW_5); 

                            					newLeafNode(otherlv_10, grammarAccess.getTechnologyAccess().getMatrixKeyword_4_3_1());
                            				
                            otherlv_11=(Token)match(input,14,FOLLOW_4); 

                            					newLeafNode(otherlv_11, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_3_2());
                            				
                            // InternalTechnologyDsl.g:208:5: ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+
                            int cnt3=0;
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==RULE_ID) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // InternalTechnologyDsl.g:209:6: (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry )
                            	    {
                            	    // InternalTechnologyDsl.g:209:6: (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry )
                            	    // InternalTechnologyDsl.g:210:7: lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry
                            	    {

                            	    							newCompositeNode(grammarAccess.getTechnologyAccess().getCompatibilityEntriesCompatibilityMatrixEntryParserRuleCall_4_3_3_0());
                            	    						
                            	    pushFollow(FOLLOW_10);
                            	    lv_compatibilityEntries_12_0=ruleCompatibilityMatrixEntry();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"compatibilityEntries",
                            	    								lv_compatibilityEntries_12_0,
                            	    								"de.fhdo.ddmm.technology.TechnologyDsl.CompatibilityMatrixEntry");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt3 >= 1 ) break loop3;
                                        EarlyExitException eee =
                                            new EarlyExitException(3, input);
                                        throw eee;
                                }
                                cnt3++;
                            } while (true);

                            otherlv_13=(Token)match(input,18,FOLLOW_11); 

                            					newLeafNode(otherlv_13, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_3_4());
                            				

                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_14, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:237:3: (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalTechnologyDsl.g:238:4: otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_5); 

                    				newLeafNode(otherlv_15, grammarAccess.getTechnologyAccess().getProtocolsKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_16, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalTechnologyDsl.g:246:4: ( (lv_protocols_17_0= ruleProtocol ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=75 && LA6_0<=76)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:247:5: (lv_protocols_17_0= ruleProtocol )
                    	    {
                    	    // InternalTechnologyDsl.g:247:5: (lv_protocols_17_0= ruleProtocol )
                    	    // InternalTechnologyDsl.g:248:6: lv_protocols_17_0= ruleProtocol
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getProtocolsProtocolParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_protocols_17_0=ruleProtocol();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_17_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.Protocol");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    otherlv_18=(Token)match(input,18,FOLLOW_15); 

                    				newLeafNode(otherlv_18, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:270:3: (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTechnologyDsl.g:271:4: otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}'
                    {
                    otherlv_19=(Token)match(input,20,FOLLOW_16); 

                    				newLeafNode(otherlv_19, grammarAccess.getTechnologyAccess().getServiceKeyword_6_0());
                    			
                    otherlv_20=(Token)match(input,21,FOLLOW_5); 

                    				newLeafNode(otherlv_20, grammarAccess.getTechnologyAccess().getAspectsKeyword_6_1());
                    			
                    otherlv_21=(Token)match(input,14,FOLLOW_17); 

                    				newLeafNode(otherlv_21, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_6_2());
                    			
                    // InternalTechnologyDsl.g:283:4: ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==53) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:284:5: (lv_serviceAspects_22_0= ruleServiceAspect )
                    	    {
                    	    // InternalTechnologyDsl.g:284:5: (lv_serviceAspects_22_0= ruleServiceAspect )
                    	    // InternalTechnologyDsl.g:285:6: lv_serviceAspects_22_0= ruleServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getServiceAspectsServiceAspectParserRuleCall_6_3_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_serviceAspects_22_0=ruleServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"serviceAspects",
                    	    							lv_serviceAspects_22_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.ServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_23=(Token)match(input,18,FOLLOW_19); 

                    				newLeafNode(otherlv_23, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:307:3: (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTechnologyDsl.g:308:4: otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}'
                    {
                    otherlv_24=(Token)match(input,22,FOLLOW_20); 

                    				newLeafNode(otherlv_24, grammarAccess.getTechnologyAccess().getDeploymentKeyword_7_0());
                    			
                    otherlv_25=(Token)match(input,23,FOLLOW_5); 

                    				newLeafNode(otherlv_25, grammarAccess.getTechnologyAccess().getTechnologiesKeyword_7_1());
                    			
                    otherlv_26=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_26, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_7_2());
                    			
                    // InternalTechnologyDsl.g:320:4: ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:321:5: (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology )
                    	    {
                    	    // InternalTechnologyDsl.g:321:5: (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology )
                    	    // InternalTechnologyDsl.g:322:6: lv_deploymentTechnologies_27_0= ruleDeploymentTechnology
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesDeploymentTechnologyParserRuleCall_7_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_deploymentTechnologies_27_0=ruleDeploymentTechnology();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"deploymentTechnologies",
                    	    							lv_deploymentTechnologies_27_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.DeploymentTechnology");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    otherlv_28=(Token)match(input,18,FOLLOW_21); 

                    				newLeafNode(otherlv_28, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_7_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:344:3: (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTechnologyDsl.g:345:4: otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}'
                    {
                    otherlv_29=(Token)match(input,24,FOLLOW_20); 

                    				newLeafNode(otherlv_29, grammarAccess.getTechnologyAccess().getInfrastructureKeyword_8_0());
                    			
                    otherlv_30=(Token)match(input,23,FOLLOW_5); 

                    				newLeafNode(otherlv_30, grammarAccess.getTechnologyAccess().getTechnologiesKeyword_8_1());
                    			
                    otherlv_31=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_31, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalTechnologyDsl.g:357:4: ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:358:5: (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology )
                    	    {
                    	    // InternalTechnologyDsl.g:358:5: (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology )
                    	    // InternalTechnologyDsl.g:359:6: lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesInfrastructureTechnologyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_infrastructureTechnologies_32_0=ruleInfrastructureTechnology();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"infrastructureTechnologies",
                    	    							lv_infrastructureTechnologies_32_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.InfrastructureTechnology");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_33=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_33, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:381:3: (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTechnologyDsl.g:382:4: otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}'
                    {
                    otherlv_34=(Token)match(input,25,FOLLOW_16); 

                    				newLeafNode(otherlv_34, grammarAccess.getTechnologyAccess().getOperationKeyword_9_0());
                    			
                    otherlv_35=(Token)match(input,21,FOLLOW_5); 

                    				newLeafNode(otherlv_35, grammarAccess.getTechnologyAccess().getAspectsKeyword_9_1());
                    			
                    otherlv_36=(Token)match(input,14,FOLLOW_17); 

                    				newLeafNode(otherlv_36, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_9_2());
                    			
                    // InternalTechnologyDsl.g:394:4: ( (lv_operationAspects_37_0= ruleOperationAspect ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==53) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:395:5: (lv_operationAspects_37_0= ruleOperationAspect )
                    	    {
                    	    // InternalTechnologyDsl.g:395:5: (lv_operationAspects_37_0= ruleOperationAspect )
                    	    // InternalTechnologyDsl.g:396:6: lv_operationAspects_37_0= ruleOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getOperationAspectsOperationAspectParserRuleCall_9_3_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_operationAspects_37_0=ruleOperationAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"operationAspects",
                    	    							lv_operationAspects_37_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.OperationAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    otherlv_38=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_38, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_9_4());
                    			

                    }
                    break;

            }

            otherlv_39=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_39, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnology"


    // $ANTLR start "entryRuleTechnologyImport"
    // InternalTechnologyDsl.g:426:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalTechnologyDsl.g:426:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalTechnologyDsl.g:427:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
            {
             newCompositeNode(grammarAccess.getTechnologyImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologyImport=ruleTechnologyImport();

            state._fsp--;

             current =iv_ruleTechnologyImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologyImport"


    // $ANTLR start "ruleTechnologyImport"
    // InternalTechnologyDsl.g:433:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
    public final EObject ruleTechnologyImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:439:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:440:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:440:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:441:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalTechnologyDsl.g:453:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:454:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:454:4: (lv_importURI_3_0= RULE_STRING )
            // InternalTechnologyDsl.g:455:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getTechnologyImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalTechnologyDsl.g:475:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTechnologyDsl.g:476:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:476:4: (lv_name_5_0= RULE_ID )
            // InternalTechnologyDsl.g:477:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_5_0, grammarAccess.getTechnologyImportAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologyImport"


    // $ANTLR start "entryRuleProtocol"
    // InternalTechnologyDsl.g:497:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalTechnologyDsl.g:497:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalTechnologyDsl.g:498:2: iv_ruleProtocol= ruleProtocol EOF
            {
             newCompositeNode(grammarAccess.getProtocolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProtocol=ruleProtocol();

            state._fsp--;

             current =iv_ruleProtocol; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProtocol"


    // $ANTLR start "ruleProtocol"
    // InternalTechnologyDsl.g:504:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleProtocol() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_default_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_communicationType_0_0 = null;

        EObject lv_dataFormats_4_0 = null;

        EObject lv_dataFormats_6_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:510:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalTechnologyDsl.g:511:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalTechnologyDsl.g:511:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalTechnologyDsl.g:512:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalTechnologyDsl.g:512:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalTechnologyDsl.g:513:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalTechnologyDsl.g:513:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalTechnologyDsl.g:514:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_communicationType_0_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_0_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:531:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:532:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:532:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:533:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProtocolAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProtocolRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalTechnologyDsl.g:557:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalTechnologyDsl.g:558:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalTechnologyDsl.g:558:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalTechnologyDsl.g:559:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_29);
            lv_dataFormats_4_0=ruleDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolRule());
            					}
            					add(
            						current,
            						"dataFormats",
            						lv_dataFormats_4_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.DataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:576:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTechnologyDsl.g:577:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,31,FOLLOW_4); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTechnologyDsl.g:581:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalTechnologyDsl.g:582:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalTechnologyDsl.g:582:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalTechnologyDsl.g:583:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_dataFormats_6_0=ruleDataFormat();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProtocolRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dataFormats",
            	    							lv_dataFormats_6_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.DataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // InternalTechnologyDsl.g:601:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTechnologyDsl.g:602:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalTechnologyDsl.g:602:4: ( (lv_default_7_0= 'default' ) )
                    // InternalTechnologyDsl.g:603:5: (lv_default_7_0= 'default' )
                    {
                    // InternalTechnologyDsl.g:603:5: (lv_default_7_0= 'default' )
                    // InternalTechnologyDsl.g:604:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,32,FOLLOW_30); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,33,FOLLOW_31); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,34,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalTechnologyDsl.g:624:4: ( (otherlv_10= RULE_ID ) )
                    // InternalTechnologyDsl.g:625:5: (otherlv_10= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:625:5: (otherlv_10= RULE_ID )
                    // InternalTechnologyDsl.g:626:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getProtocolAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProtocol"


    // $ANTLR start "entryRuleDataFormat"
    // InternalTechnologyDsl.g:646:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalTechnologyDsl.g:646:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalTechnologyDsl.g:647:2: iv_ruleDataFormat= ruleDataFormat EOF
            {
             newCompositeNode(grammarAccess.getDataFormatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataFormat=ruleDataFormat();

            state._fsp--;

             current =iv_ruleDataFormat; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataFormat"


    // $ANTLR start "ruleDataFormat"
    // InternalTechnologyDsl.g:653:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:659:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:660:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalTechnologyDsl.g:660:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:661:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:661:3: (lv_formatName_0_0= RULE_ID )
            // InternalTechnologyDsl.g:662:4: lv_formatName_0_0= RULE_ID
            {
            lv_formatName_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_formatName_0_0, grammarAccess.getDataFormatAccess().getFormatNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDataFormatRule());
            				}
            				setWithLastConsumed(
            					current,
            					"formatName",
            					lv_formatName_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataFormat"


    // $ANTLR start "entryRuleTechnologySpecificPrimitiveType"
    // InternalTechnologyDsl.g:681:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalTechnologyDsl.g:681:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalTechnologyDsl.g:682:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificPrimitiveType=ruleTechnologySpecificPrimitiveType();

            state._fsp--;

             current =iv_ruleTechnologySpecificPrimitiveType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologySpecificPrimitiveType"


    // $ANTLR start "ruleTechnologySpecificPrimitiveType"
    // InternalTechnologyDsl.g:688:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
    public final EObject ruleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_default_8_0=null;
        Token otherlv_9=null;
        EObject lv_basicBuiltinPrimitiveTypes_5_0 = null;

        EObject lv_basicBuiltinPrimitiveTypes_7_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:694:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalTechnologyDsl.g:695:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalTechnologyDsl.g:695:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalTechnologyDsl.g:696:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalTechnologyDsl.g:704:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:705:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:705:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:706:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTechnologyDsl.g:722:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==38) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTechnologyDsl.g:723:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_35); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,39,FOLLOW_36); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalTechnologyDsl.g:731:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:732:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:732:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:733:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_basicBuiltinPrimitiveTypes_5_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
                    						}
                    						add(
                    							current,
                    							"basicBuiltinPrimitiveTypes",
                    							lv_basicBuiltinPrimitiveTypes_5_0,
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTechnologyDsl.g:750:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==31) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:751:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_36); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalTechnologyDsl.g:755:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalTechnologyDsl.g:756:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalTechnologyDsl.g:756:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalTechnologyDsl.g:757:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
                    	    lv_basicBuiltinPrimitiveTypes_7_0=rulePrimitiveType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"basicBuiltinPrimitiveTypes",
                    	    								lv_basicBuiltinPrimitiveTypes_7_0,
                    	    								"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    // InternalTechnologyDsl.g:775:4: ( (lv_default_8_0= 'default' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==32) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalTechnologyDsl.g:776:5: (lv_default_8_0= 'default' )
                            {
                            // InternalTechnologyDsl.g:776:5: (lv_default_8_0= 'default' )
                            // InternalTechnologyDsl.g:777:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,32,FOLLOW_32); 

                            						newLeafNode(lv_default_8_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
                            						}
                            						setWithLastConsumed(current, "default", true, "default");
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologySpecificPrimitiveType"


    // $ANTLR start "entryRuleTechnologySpecificListType"
    // InternalTechnologyDsl.g:798:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalTechnologyDsl.g:798:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalTechnologyDsl.g:799:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificListTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificListType=ruleTechnologySpecificListType();

            state._fsp--;

             current =iv_ruleTechnologySpecificListType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologySpecificListType"


    // $ANTLR start "ruleTechnologySpecificListType"
    // InternalTechnologyDsl.g:805:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:811:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalTechnologyDsl.g:812:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalTechnologyDsl.g:812:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalTechnologyDsl.g:813:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalTechnologyDsl.g:821:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:822:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:822:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:823:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTechnologySpecificListTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificListTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificListTypeAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologySpecificListType"


    // $ANTLR start "entryRuleTechnologySpecificDataStructure"
    // InternalTechnologyDsl.g:847:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalTechnologyDsl.g:847:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalTechnologyDsl.g:848:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificDataStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificDataStructure=ruleTechnologySpecificDataStructure();

            state._fsp--;

             current =iv_ruleTechnologySpecificDataStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologySpecificDataStructure"


    // $ANTLR start "ruleTechnologySpecificDataStructure"
    // InternalTechnologyDsl.g:854:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:860:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalTechnologyDsl.g:861:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalTechnologyDsl.g:861:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalTechnologyDsl.g:862:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalTechnologyDsl.g:870:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:871:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:871:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:872:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTechnologySpecificDataStructureAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificDataStructureRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificDataStructureAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologySpecificDataStructure"


    // $ANTLR start "entryRulePossiblyImportedTechnologySpecificType"
    // InternalTechnologyDsl.g:896:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalTechnologyDsl.g:896:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalTechnologyDsl.g:897:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
            {
             newCompositeNode(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePossiblyImportedTechnologySpecificType=rulePossiblyImportedTechnologySpecificType();

            state._fsp--;

             current =iv_rulePossiblyImportedTechnologySpecificType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePossiblyImportedTechnologySpecificType"


    // $ANTLR start "rulePossiblyImportedTechnologySpecificType"
    // InternalTechnologyDsl.g:903:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:909:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalTechnologyDsl.g:910:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalTechnologyDsl.g:910:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:911:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:911:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==42) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalTechnologyDsl.g:912:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalTechnologyDsl.g:912:4: ( (otherlv_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:913:5: (otherlv_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:913:5: (otherlv_0= RULE_ID )
                    // InternalTechnologyDsl.g:914:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_37); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:930:3: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:931:4: ( ruleQualifiedName )
            {
            // InternalTechnologyDsl.g:931:4: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:932:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeTypeCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePossiblyImportedTechnologySpecificType"


    // $ANTLR start "entryRuleCompatibilityMatrixEntry"
    // InternalTechnologyDsl.g:950:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalTechnologyDsl.g:950:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalTechnologyDsl.g:951:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
            {
             newCompositeNode(grammarAccess.getCompatibilityMatrixEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompatibilityMatrixEntry=ruleCompatibilityMatrixEntry();

            state._fsp--;

             current =iv_ruleCompatibilityMatrixEntry; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompatibilityMatrixEntry"


    // $ANTLR start "ruleCompatibilityMatrixEntry"
    // InternalTechnologyDsl.g:957:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
    public final EObject ruleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_compatibleTypes_0_0 = null;

        EObject lv_compatibleTypes_2_0 = null;

        Enumerator lv_direction_3_0 = null;

        EObject lv_mappingType_4_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:963:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalTechnologyDsl.g:964:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalTechnologyDsl.g:964:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalTechnologyDsl.g:965:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalTechnologyDsl.g:965:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:966:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:966:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:967:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
            lv_compatibleTypes_0_0=rulePossiblyImportedTechnologySpecificType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            					}
            					add(
            						current,
            						"compatibleTypes",
            						lv_compatibleTypes_0_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.PossiblyImportedTechnologySpecificType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:984:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==31) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalTechnologyDsl.g:985:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalTechnologyDsl.g:989:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalTechnologyDsl.g:990:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalTechnologyDsl.g:990:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalTechnologyDsl.g:991:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_38);
            	    lv_compatibleTypes_2_0=rulePossiblyImportedTechnologySpecificType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            	    						}
            	    						add(
            	    							current,
            	    							"compatibleTypes",
            	    							lv_compatibleTypes_2_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.PossiblyImportedTechnologySpecificType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalTechnologyDsl.g:1009:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalTechnologyDsl.g:1010:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalTechnologyDsl.g:1010:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalTechnologyDsl.g:1011:5: lv_direction_3_0= ruleCompatibilityDirection
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_direction_3_0=ruleCompatibilityDirection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            					}
            					set(
            						current,
            						"direction",
            						lv_direction_3_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.CompatibilityDirection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1028:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:1029:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:1029:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:1030:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_32);
            lv_mappingType_4_0=rulePossiblyImportedTechnologySpecificType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            					}
            					set(
            						current,
            						"mappingType",
            						lv_mappingType_4_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.PossiblyImportedTechnologySpecificType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCompatibilityMatrixEntryAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompatibilityMatrixEntry"


    // $ANTLR start "entryRuleDeploymentTechnology"
    // InternalTechnologyDsl.g:1055:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalTechnologyDsl.g:1055:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalTechnologyDsl.g:1056:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
            {
             newCompositeNode(grammarAccess.getDeploymentTechnologyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeploymentTechnology=ruleDeploymentTechnology();

            state._fsp--;

             current =iv_ruleDeploymentTechnology; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeploymentTechnology"


    // $ANTLR start "ruleDeploymentTechnology"
    // InternalTechnologyDsl.g:1062:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
    public final EObject ruleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        EObject lv_operationEnvironments_5_0 = null;

        EObject lv_operationEnvironments_7_0 = null;

        EObject lv_serviceProperties_12_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1068:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalTechnologyDsl.g:1069:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalTechnologyDsl.g:1069:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalTechnologyDsl.g:1070:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalTechnologyDsl.g:1070:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1071:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1071:4: (lv_name_0_0= RULE_ID )
            // InternalTechnologyDsl.g:1072:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDeploymentTechnologyAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeploymentTechnologyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,43,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,44,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalTechnologyDsl.g:1104:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:1105:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:1105:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalTechnologyDsl.g:1106:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_42);
            lv_operationEnvironments_5_0=ruleOperationEnvironment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeploymentTechnologyRule());
            					}
            					add(
            						current,
            						"operationEnvironments",
            						lv_operationEnvironments_5_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1123:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==31) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1124:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,31,FOLLOW_25); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTechnologyDsl.g:1128:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalTechnologyDsl.g:1129:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalTechnologyDsl.g:1129:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalTechnologyDsl.g:1130:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_operationEnvironments_7_0=ruleOperationEnvironment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeploymentTechnologyRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operationEnvironments",
            	    							lv_operationEnvironments_7_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_8=(Token)match(input,35,FOLLOW_43); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalTechnologyDsl.g:1152:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTechnologyDsl.g:1153:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,20,FOLLOW_44); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,45,FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalTechnologyDsl.g:1165:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=61 && LA24_0<=70)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1166:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:1166:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:1167:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_45);
                    	    lv_serviceProperties_12_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDeploymentTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"serviceProperties",
                    	    							lv_serviceProperties_12_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    otherlv_13=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeploymentTechnology"


    // $ANTLR start "entryRuleInfrastructureTechnology"
    // InternalTechnologyDsl.g:1197:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalTechnologyDsl.g:1197:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalTechnologyDsl.g:1198:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureTechnologyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfrastructureTechnology=ruleInfrastructureTechnology();

            state._fsp--;

             current =iv_ruleInfrastructureTechnology; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfrastructureTechnology"


    // $ANTLR start "ruleInfrastructureTechnology"
    // InternalTechnologyDsl.g:1204:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
    public final EObject ruleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        EObject lv_operationEnvironments_5_0 = null;

        EObject lv_operationEnvironments_7_0 = null;

        EObject lv_serviceProperties_12_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1210:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalTechnologyDsl.g:1211:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalTechnologyDsl.g:1211:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalTechnologyDsl.g:1212:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalTechnologyDsl.g:1212:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1213:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1213:4: (lv_name_0_0= RULE_ID )
            // InternalTechnologyDsl.g:1214:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getInfrastructureTechnologyAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfrastructureTechnologyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,43,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,44,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalTechnologyDsl.g:1246:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:1247:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:1247:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalTechnologyDsl.g:1248:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_42);
            lv_operationEnvironments_5_0=ruleOperationEnvironment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInfrastructureTechnologyRule());
            					}
            					add(
            						current,
            						"operationEnvironments",
            						lv_operationEnvironments_5_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1265:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==31) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1266:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,31,FOLLOW_25); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTechnologyDsl.g:1270:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalTechnologyDsl.g:1271:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalTechnologyDsl.g:1271:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalTechnologyDsl.g:1272:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_operationEnvironments_7_0=ruleOperationEnvironment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInfrastructureTechnologyRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operationEnvironments",
            	    							lv_operationEnvironments_7_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_8=(Token)match(input,35,FOLLOW_43); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalTechnologyDsl.g:1294:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==20) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTechnologyDsl.g:1295:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,20,FOLLOW_44); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,45,FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalTechnologyDsl.g:1307:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=61 && LA27_0<=70)) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1308:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:1308:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:1309:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_45);
                    	    lv_serviceProperties_12_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"serviceProperties",
                    	    							lv_serviceProperties_12_0,
                    	    							"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    otherlv_13=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfrastructureTechnology"


    // $ANTLR start "entryRuleOperationEnvironment"
    // InternalTechnologyDsl.g:1339:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalTechnologyDsl.g:1339:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalTechnologyDsl.g:1340:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
            {
             newCompositeNode(grammarAccess.getOperationEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationEnvironment=ruleOperationEnvironment();

            state._fsp--;

             current =iv_ruleOperationEnvironment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationEnvironment"


    // $ANTLR start "ruleOperationEnvironment"
    // InternalTechnologyDsl.g:1346:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:1352:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalTechnologyDsl.g:1353:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalTechnologyDsl.g:1353:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalTechnologyDsl.g:1354:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalTechnologyDsl.g:1354:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:1355:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:1355:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalTechnologyDsl.g:1356:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

            					newLeafNode(lv_environmentName_0_0, grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationEnvironmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"environmentName",
            						lv_environmentName_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTechnologyDsl.g:1372:3: ( (lv_default_1_0= 'default' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTechnologyDsl.g:1373:4: (lv_default_1_0= 'default' )
                    {
                    // InternalTechnologyDsl.g:1373:4: (lv_default_1_0= 'default' )
                    // InternalTechnologyDsl.g:1374:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_default_1_0, grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationEnvironmentRule());
                    					}
                    					setWithLastConsumed(current, "default", true, "default");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationEnvironment"


    // $ANTLR start "entryRuleTechnologySpecificProperty"
    // InternalTechnologyDsl.g:1390:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalTechnologyDsl.g:1390:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalTechnologyDsl.g:1391:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificProperty=ruleTechnologySpecificProperty();

            state._fsp--;

             current =iv_ruleTechnologySpecificProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologySpecificProperty"


    // $ANTLR start "ruleTechnologySpecificProperty"
    // InternalTechnologyDsl.g:1397:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}' )? otherlv_9= ';' ) ;
    public final EObject ruleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_type_0_0 = null;

        EObject lv_defaultValue_3_0 = null;

        Enumerator lv_features_5_0 = null;

        Enumerator lv_features_7_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1403:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}' )? otherlv_9= ';' ) )
            // InternalTechnologyDsl.g:1404:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}' )? otherlv_9= ';' )
            {
            // InternalTechnologyDsl.g:1404:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}' )? otherlv_9= ';' )
            // InternalTechnologyDsl.g:1405:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}' )? otherlv_9= ';'
            {
            // InternalTechnologyDsl.g:1405:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalTechnologyDsl.g:1406:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:1406:4: (lv_type_0_0= rulePrimitiveType )
            // InternalTechnologyDsl.g:1407:5: lv_type_0_0= rulePrimitiveType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=rulePrimitiveType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1424:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1425:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1425:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:1426:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTechnologySpecificPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTechnologyDsl.g:1442:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTechnologyDsl.g:1443:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_48); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:1447:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalTechnologyDsl.g:1448:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalTechnologyDsl.g:1448:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalTechnologyDsl.g:1449:6: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_49);
                    lv_defaultValue_3_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    						}
                    						set(
                    							current,
                    							"defaultValue",
                    							lv_defaultValue_3_0,
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTechnologyDsl.g:1467:3: (otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTechnologyDsl.g:1468:4: otherlv_4= '{' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_50); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalTechnologyDsl.g:1472:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalTechnologyDsl.g:1473:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalTechnologyDsl.g:1473:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalTechnologyDsl.g:1474:6: lv_features_5_0= rulePropertyFeature
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_features_5_0=rulePropertyFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_5_0,
                    							"de.fhdo.ddmm.technology.TechnologyDsl.PropertyFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTechnologyDsl.g:1491:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==31) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1492:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_50); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:1496:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalTechnologyDsl.g:1497:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:1497:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalTechnologyDsl.g:1498:7: lv_features_7_0= rulePropertyFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
                    	    lv_features_7_0=rulePropertyFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_7_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.PropertyFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,18,FOLLOW_32); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificPropertyAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificPropertyAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologySpecificProperty"


    // $ANTLR start "entryRuleServiceAspectPointcut"
    // InternalTechnologyDsl.g:1529:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalTechnologyDsl.g:1529:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalTechnologyDsl.g:1530:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
            {
             newCompositeNode(grammarAccess.getServiceAspectPointcutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceAspectPointcut=ruleServiceAspectPointcut();

            state._fsp--;

             current =iv_ruleServiceAspectPointcut; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceAspectPointcut"


    // $ANTLR start "ruleServiceAspectPointcut"
    // InternalTechnologyDsl.g:1536:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
    public final EObject ruleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forExchangePattern_0_0=null;
        Token otherlv_1=null;
        Token lv_forCommunicationType_3_0=null;
        Token otherlv_4=null;
        Token lv_forProtocol_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_forDataFormat_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_exchangePattern_2_0 = null;

        Enumerator lv_communicationType_5_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1542:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalTechnologyDsl.g:1543:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalTechnologyDsl.g:1543:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt33=1;
                }
                break;
            case 47:
                {
                alt33=2;
                }
                break;
            case 48:
                {
                alt33=3;
                }
                break;
            case 49:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalTechnologyDsl.g:1544:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalTechnologyDsl.g:1544:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalTechnologyDsl.g:1545:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalTechnologyDsl.g:1545:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalTechnologyDsl.g:1546:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalTechnologyDsl.g:1546:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalTechnologyDsl.g:1547:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,46,FOLLOW_41); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,44,FOLLOW_52); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalTechnologyDsl.g:1563:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalTechnologyDsl.g:1564:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalTechnologyDsl.g:1564:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalTechnologyDsl.g:1565:6: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    						newCompositeNode(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternExchangePatternEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_exchangePattern_2_0=ruleExchangePattern();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						set(
                    							current,
                    							"exchangePattern",
                    							lv_exchangePattern_2_0,
                    							"de.fhdo.ddmm.technology.TechnologyDsl.ExchangePattern");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1584:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalTechnologyDsl.g:1584:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalTechnologyDsl.g:1585:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalTechnologyDsl.g:1585:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalTechnologyDsl.g:1586:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalTechnologyDsl.g:1586:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalTechnologyDsl.g:1587:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,47,FOLLOW_41); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,44,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalTechnologyDsl.g:1603:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalTechnologyDsl.g:1604:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalTechnologyDsl.g:1604:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalTechnologyDsl.g:1605:6: lv_communicationType_5_0= ruleCommunicationType
                    {

                    						newCompositeNode(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_communicationType_5_0=ruleCommunicationType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						set(
                    							current,
                    							"communicationType",
                    							lv_communicationType_5_0,
                    							"de.fhdo.ddmm.technology.TechnologyDsl.CommunicationType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1624:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalTechnologyDsl.g:1624:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalTechnologyDsl.g:1625:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalTechnologyDsl.g:1625:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalTechnologyDsl.g:1626:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalTechnologyDsl.g:1626:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalTechnologyDsl.g:1627:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,48,FOLLOW_41); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,44,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalTechnologyDsl.g:1643:4: ( (otherlv_8= RULE_ID ) )
                    // InternalTechnologyDsl.g:1644:5: (otherlv_8= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:1644:5: (otherlv_8= RULE_ID )
                    // InternalTechnologyDsl.g:1645:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_8, grammarAccess.getServiceAspectPointcutAccess().getProtocolProtocolCrossReference_2_2_0());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:1658:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalTechnologyDsl.g:1658:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalTechnologyDsl.g:1659:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalTechnologyDsl.g:1659:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalTechnologyDsl.g:1660:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalTechnologyDsl.g:1660:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalTechnologyDsl.g:1661:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,49,FOLLOW_41); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,44,FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalTechnologyDsl.g:1677:4: ( (otherlv_11= RULE_ID ) )
                    // InternalTechnologyDsl.g:1678:5: (otherlv_11= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:1678:5: (otherlv_11= RULE_ID )
                    // InternalTechnologyDsl.g:1679:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_11, grammarAccess.getServiceAspectPointcutAccess().getDataFormatDataFormatCrossReference_3_2_0());
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceAspectPointcut"


    // $ANTLR start "entryRuleServiceAspectPointcutSelector"
    // InternalTechnologyDsl.g:1695:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalTechnologyDsl.g:1695:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalTechnologyDsl.g:1696:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
            {
             newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceAspectPointcutSelector=ruleServiceAspectPointcutSelector();

            state._fsp--;

             current =iv_ruleServiceAspectPointcutSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceAspectPointcutSelector"


    // $ANTLR start "ruleServiceAspectPointcutSelector"
    // InternalTechnologyDsl.g:1702:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_pointcuts_2_0 = null;

        EObject lv_pointcuts_4_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1708:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalTechnologyDsl.g:1709:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalTechnologyDsl.g:1709:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalTechnologyDsl.g:1710:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_53); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,51,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTechnologyDsl.g:1718:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalTechnologyDsl.g:1719:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalTechnologyDsl.g:1719:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalTechnologyDsl.g:1720:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_55);
            lv_pointcuts_2_0=ruleServiceAspectPointcut();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceAspectPointcutSelectorRule());
            					}
            					add(
            						current,
            						"pointcuts",
            						lv_pointcuts_2_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.ServiceAspectPointcut");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1737:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==31) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1738:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,31,FOLLOW_54); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalTechnologyDsl.g:1742:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalTechnologyDsl.g:1743:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalTechnologyDsl.g:1743:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalTechnologyDsl.g:1744:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_pointcuts_4_0=ruleServiceAspectPointcut();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceAspectPointcutSelectorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pointcuts",
            	    							lv_pointcuts_4_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.ServiceAspectPointcut");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_5=(Token)match(input,52,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getServiceAspectPointcutSelectorAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceAspectPointcutSelector"


    // $ANTLR start "entryRuleServiceAspect"
    // InternalTechnologyDsl.g:1774:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalTechnologyDsl.g:1774:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalTechnologyDsl.g:1775:2: iv_ruleServiceAspect= ruleServiceAspect EOF
            {
             newCompositeNode(grammarAccess.getServiceAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceAspect=ruleServiceAspect();

            state._fsp--;

             current =iv_ruleServiceAspect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceAspect"


    // $ANTLR start "ruleServiceAspect"
    // InternalTechnologyDsl.g:1781:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
    public final EObject ruleServiceAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Enumerator lv_joinPoints_3_0 = null;

        Enumerator lv_joinPoints_5_0 = null;

        EObject lv_pointcutSelectors_7_0 = null;

        EObject lv_properties_8_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1787:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalTechnologyDsl.g:1788:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalTechnologyDsl.g:1788:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalTechnologyDsl.g:1789:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalTechnologyDsl.g:1793:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1794:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1794:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:1795:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            					newLeafNode(lv_name_1_0, grammarAccess.getServiceAspectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceAspectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,54,FOLLOW_57); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalTechnologyDsl.g:1815:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalTechnologyDsl.g:1816:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalTechnologyDsl.g:1816:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalTechnologyDsl.g:1817:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_58);
            lv_joinPoints_3_0=ruleServiceJoinPointType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceAspectRule());
            					}
            					add(
            						current,
            						"joinPoints",
            						lv_joinPoints_3_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.ServiceJoinPointType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1834:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==31) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1835:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_57); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalTechnologyDsl.g:1839:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalTechnologyDsl.g:1840:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalTechnologyDsl.g:1840:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalTechnologyDsl.g:1841:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_58);
            	    lv_joinPoints_5_0=ruleServiceJoinPointType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"joinPoints",
            	    							lv_joinPoints_5_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.ServiceJoinPointType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalTechnologyDsl.g:1859:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==14) ) {
                alt38=1;
            }
            else if ( (LA38_0==35) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalTechnologyDsl.g:1860:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalTechnologyDsl.g:1860:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalTechnologyDsl.g:1861:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_59); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalTechnologyDsl.g:1865:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==50) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1866:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalTechnologyDsl.g:1866:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalTechnologyDsl.g:1867:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_59);
                    	    lv_pointcutSelectors_7_0=ruleServiceAspectPointcutSelector();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"pointcutSelectors",
                    	    								lv_pointcutSelectors_7_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.ServiceAspectPointcutSelector");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    // InternalTechnologyDsl.g:1884:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( ((LA37_0>=61 && LA37_0<=70)) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1885:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:1885:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:1886:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
                    	    lv_properties_8_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_8_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,18,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1909:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectAccess().getSemicolonKeyword_5_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceAspect"


    // $ANTLR start "entryRuleOperationAspect"
    // InternalTechnologyDsl.g:1918:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalTechnologyDsl.g:1918:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalTechnologyDsl.g:1919:2: iv_ruleOperationAspect= ruleOperationAspect EOF
            {
             newCompositeNode(grammarAccess.getOperationAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationAspect=ruleOperationAspect();

            state._fsp--;

             current =iv_ruleOperationAspect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationAspect"


    // $ANTLR start "ruleOperationAspect"
    // InternalTechnologyDsl.g:1925:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) ;
    public final EObject ruleOperationAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Enumerator lv_joinPoints_3_0 = null;

        Enumerator lv_joinPoints_5_0 = null;

        EObject lv_properties_7_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:1931:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) )
            // InternalTechnologyDsl.g:1932:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            {
            // InternalTechnologyDsl.g:1932:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            // InternalTechnologyDsl.g:1933:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalTechnologyDsl.g:1937:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1938:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1938:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:1939:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOperationAspectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,54,FOLLOW_60); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalTechnologyDsl.g:1959:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalTechnologyDsl.g:1960:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalTechnologyDsl.g:1960:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalTechnologyDsl.g:1961:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_58);
            lv_joinPoints_3_0=ruleOperationJoinPointType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationAspectRule());
            					}
            					add(
            						current,
            						"joinPoints",
            						lv_joinPoints_3_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.OperationJoinPointType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:1978:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==31) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1979:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_60); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalTechnologyDsl.g:1983:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalTechnologyDsl.g:1984:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalTechnologyDsl.g:1984:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalTechnologyDsl.g:1985:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_58);
            	    lv_joinPoints_5_0=ruleOperationJoinPointType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"joinPoints",
            	    							lv_joinPoints_5_0,
            	    							"de.fhdo.ddmm.technology.TechnologyDsl.OperationJoinPointType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            // InternalTechnologyDsl.g:2003:3: ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==14) ) {
                alt41=1;
            }
            else if ( (LA41_0==35) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalTechnologyDsl.g:2004:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    {
                    // InternalTechnologyDsl.g:2004:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    // InternalTechnologyDsl.g:2005:5: otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_45); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalTechnologyDsl.g:2009:5: ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=61 && LA40_0<=70)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2010:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:2010:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:2011:7: lv_properties_7_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
                    	    lv_properties_7_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_7_0,
                    	    								"de.fhdo.ddmm.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,18,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2034:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getSemicolonKeyword_5_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationAspect"


    // $ANTLR start "entryRuleComplexTypeImport"
    // InternalTechnologyDsl.g:2043:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalTechnologyDsl.g:2043:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalTechnologyDsl.g:2044:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexTypeImport=ruleComplexTypeImport();

            state._fsp--;

             current =iv_ruleComplexTypeImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexTypeImport"


    // $ANTLR start "ruleComplexTypeImport"
    // InternalTechnologyDsl.g:2050:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
    public final EObject ruleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:2056:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:2057:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:2057:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:2058:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_61); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,55,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalTechnologyDsl.g:2070:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:2071:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:2071:4: (lv_importURI_3_0= RULE_STRING )
            // InternalTechnologyDsl.g:2072:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexTypeImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalTechnologyDsl.g:2092:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2093:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2093:4: (lv_name_5_0= RULE_ID )
            // InternalTechnologyDsl.g:2094:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_5_0, grammarAccess.getComplexTypeImportAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexTypeImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexTypeImport"


    // $ANTLR start "entryRuleVersion"
    // InternalTechnologyDsl.g:2114:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalTechnologyDsl.g:2114:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalTechnologyDsl.g:2115:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // InternalTechnologyDsl.g:2121:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_complexTypes_3_0 = null;

        EObject lv_contexts_4_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2127:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalTechnologyDsl.g:2128:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalTechnologyDsl.g:2128:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalTechnologyDsl.g:2129:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalTechnologyDsl.g:2133:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2134:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2134:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2135:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVersionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVersionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_62); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTechnologyDsl.g:2155:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt44=3;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=40 && LA44_0<=41)||LA44_0==60) ) {
                alt44=1;
            }
            else if ( (LA44_0==57) ) {
                alt44=2;
            }
            switch (alt44) {
                case 1 :
                    // InternalTechnologyDsl.g:2156:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalTechnologyDsl.g:2156:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=40 && LA42_0<=41)||LA42_0==60) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2157:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalTechnologyDsl.g:2157:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalTechnologyDsl.g:2158:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_63);
                    	    lv_complexTypes_3_0=ruleComplexType();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVersionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"complexTypes",
                    	    							lv_complexTypes_3_0,
                    	    							"de.fhdo.ddmm.data.DataDsl.ComplexType");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2176:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalTechnologyDsl.g:2176:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt43=0;
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==57) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2177:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalTechnologyDsl.g:2177:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalTechnologyDsl.g:2178:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_64);
                    	    lv_contexts_4_0=ruleContext();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVersionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"contexts",
                    	    							lv_contexts_4_0,
                    	    							"de.fhdo.ddmm.data.DataDsl.Context");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt43 >= 1 ) break loop43;
                                EarlyExitException eee =
                                    new EarlyExitException(43, input);
                                throw eee;
                        }
                        cnt43++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleContext"
    // InternalTechnologyDsl.g:2204:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalTechnologyDsl.g:2204:48: (iv_ruleContext= ruleContext EOF )
            // InternalTechnologyDsl.g:2205:2: iv_ruleContext= ruleContext EOF
            {
             newCompositeNode(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContext=ruleContext();

            state._fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalTechnologyDsl.g:2211:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2217:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalTechnologyDsl.g:2218:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalTechnologyDsl.g:2218:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalTechnologyDsl.g:2219:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalTechnologyDsl.g:2223:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2224:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2224:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2225:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContextAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_65); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTechnologyDsl.g:2245:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=40 && LA45_0<=41)||LA45_0==60) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2246:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalTechnologyDsl.g:2246:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalTechnologyDsl.g:2247:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_63);
            	    lv_complexTypes_3_0=ruleComplexType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"complexTypes",
            	    						lv_complexTypes_3_0,
            	    						"de.fhdo.ddmm.data.DataDsl.ComplexType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRuleComplexType"
    // InternalTechnologyDsl.g:2272:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalTechnologyDsl.g:2272:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalTechnologyDsl.g:2273:2: iv_ruleComplexType= ruleComplexType EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexType=ruleComplexType();

            state._fsp--;

             current =iv_ruleComplexType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexType"


    // $ANTLR start "ruleComplexType"
    // InternalTechnologyDsl.g:2279:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2285:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalTechnologyDsl.g:2286:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalTechnologyDsl.g:2286:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt46=1;
                }
                break;
            case 40:
                {
                alt46=2;
                }
                break;
            case 60:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalTechnologyDsl.g:2287:3: this_DataStructure_0= ruleDataStructure
                    {

                    			newCompositeNode(grammarAccess.getComplexTypeAccess().getDataStructureParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataStructure_0=ruleDataStructure();

                    state._fsp--;


                    			current = this_DataStructure_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2296:3: this_ListType_1= ruleListType
                    {

                    			newCompositeNode(grammarAccess.getComplexTypeAccess().getListTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ListType_1=ruleListType();

                    state._fsp--;


                    			current = this_ListType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:2305:3: this_Enumeration_2= ruleEnumeration
                    {

                    			newCompositeNode(grammarAccess.getComplexTypeAccess().getEnumerationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Enumeration_2=ruleEnumeration();

                    state._fsp--;


                    			current = this_Enumeration_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexType"


    // $ANTLR start "entryRuleDataStructure"
    // InternalTechnologyDsl.g:2317:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalTechnologyDsl.g:2317:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalTechnologyDsl.g:2318:2: iv_ruleDataStructure= ruleDataStructure EOF
            {
             newCompositeNode(grammarAccess.getDataStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataStructure=ruleDataStructure();

            state._fsp--;

             current =iv_ruleDataStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataStructure"


    // $ANTLR start "ruleDataStructure"
    // InternalTechnologyDsl.g:2324:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) ;
    public final EObject ruleDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_dataFields_5_0 = null;

        EObject lv_dataFields_7_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2330:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) )
            // InternalTechnologyDsl.g:2331:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            {
            // InternalTechnologyDsl.g:2331:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            // InternalTechnologyDsl.g:2332:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalTechnologyDsl.g:2336:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2337:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2337:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2338:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_66); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataStructureAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataStructureRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTechnologyDsl.g:2354:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==58) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTechnologyDsl.g:2355:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:2359:4: ( ( ruleQualifiedName ) )
                    // InternalTechnologyDsl.g:2360:5: ( ruleQualifiedName )
                    {
                    // InternalTechnologyDsl.g:2360:5: ( ruleQualifiedName )
                    // InternalTechnologyDsl.g:2361:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_67); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTechnologyDsl.g:2380:3: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID||LA49_0==59||(LA49_0>=61 && LA49_0<=70)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalTechnologyDsl.g:2381:4: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalTechnologyDsl.g:2381:4: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalTechnologyDsl.g:2382:5: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalTechnologyDsl.g:2382:5: (lv_dataFields_5_0= ruleDataField )
                    // InternalTechnologyDsl.g:2383:6: lv_dataFields_5_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_dataFields_5_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_5_0,
                    							"de.fhdo.ddmm.data.DataDsl.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTechnologyDsl.g:2400:4: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==31) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2401:5: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_68); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalTechnologyDsl.g:2405:5: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalTechnologyDsl.g:2406:6: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalTechnologyDsl.g:2406:6: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalTechnologyDsl.g:2407:7: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
                    	    lv_dataFields_7_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataFields",
                    	    								lv_dataFields_7_0,
                    	    								"de.fhdo.ddmm.data.DataDsl.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataStructure"


    // $ANTLR start "entryRuleListType"
    // InternalTechnologyDsl.g:2434:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalTechnologyDsl.g:2434:49: (iv_ruleListType= ruleListType EOF )
            // InternalTechnologyDsl.g:2435:2: iv_ruleListType= ruleListType EOF
            {
             newCompositeNode(grammarAccess.getListTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListType=ruleListType();

            state._fsp--;

             current =iv_ruleListType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // InternalTechnologyDsl.g:2441:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_dataFields_3_0 = null;

        EObject lv_dataFields_5_0 = null;

        EObject lv_primitiveType_10_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2447:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalTechnologyDsl.g:2448:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalTechnologyDsl.g:2448:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalTechnologyDsl.g:2449:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalTechnologyDsl.g:2449:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalTechnologyDsl.g:2450:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,40,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalTechnologyDsl.g:2454:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:2455:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:2455:5: (lv_name_1_0= RULE_ID )
                    // InternalTechnologyDsl.g:2456:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getListTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,14,FOLLOW_68); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalTechnologyDsl.g:2476:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalTechnologyDsl.g:2477:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalTechnologyDsl.g:2477:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalTechnologyDsl.g:2478:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_dataFields_3_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTypeRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_3_0,
                    							"de.fhdo.ddmm.data.DataDsl.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTechnologyDsl.g:2495:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==31) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2496:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_68); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalTechnologyDsl.g:2500:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalTechnologyDsl.g:2501:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalTechnologyDsl.g:2501:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalTechnologyDsl.g:2502:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
                    	    lv_dataFields_5_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getListTypeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataFields",
                    	    								lv_dataFields_5_0,
                    	    								"de.fhdo.ddmm.data.DataDsl.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2526:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalTechnologyDsl.g:2526:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalTechnologyDsl.g:2527:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,40,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalTechnologyDsl.g:2531:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:2532:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:2532:5: (lv_name_8_0= RULE_ID )
                    // InternalTechnologyDsl.g:2533:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_5); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getListTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_8_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalTechnologyDsl.g:2553:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:2554:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:2554:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:2555:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_primitiveType_10_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTypeRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_10_0,
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleDataField"
    // InternalTechnologyDsl.g:2581:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalTechnologyDsl.g:2581:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalTechnologyDsl.g:2582:2: iv_ruleDataField= ruleDataField EOF
            {
             newCompositeNode(grammarAccess.getDataFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataField=ruleDataField();

            state._fsp--;

             current =iv_ruleDataField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataField"


    // $ANTLR start "ruleDataField"
    // InternalTechnologyDsl.g:2588:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2594:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:2595:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:2595:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:2596:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalTechnologyDsl.g:2596:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==59) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalTechnologyDsl.g:2597:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalTechnologyDsl.g:2597:4: (lv_hidden_0_0= 'hide' )
                    // InternalTechnologyDsl.g:2598:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,59,FOLLOW_69); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalTechnologyDsl.g:2610:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt53=3;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=61 && LA53_0<=70)) ) {
                alt53=1;
            }
            else if ( (LA53_0==RULE_ID) ) {
                int LA53_2 = input.LA(2);

                if ( (LA53_2==RULE_ID||LA53_2==42||LA53_2==71) ) {
                    alt53=2;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalTechnologyDsl.g:2611:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalTechnologyDsl.g:2611:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:2612:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:2612:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:2613:6: lv_primitiveType_1_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_primitiveType_1_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_1_0,
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2631:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalTechnologyDsl.g:2631:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalTechnologyDsl.g:2632:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalTechnologyDsl.g:2632:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalTechnologyDsl.g:2633:6: lv_complexType_2_0= rulePossiblyImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_complexType_2_0=rulePossiblyImportedComplexType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"complexType",
                    							lv_complexType_2_0,
                    							"de.fhdo.ddmm.data.DataDsl.PossiblyImportedComplexType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTechnologyDsl.g:2651:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2652:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2652:4: (lv_name_3_0= RULE_ID )
            // InternalTechnologyDsl.g:2653:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getDataFieldAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataField"


    // $ANTLR start "entryRuleEnumeration"
    // InternalTechnologyDsl.g:2673:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalTechnologyDsl.g:2673:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalTechnologyDsl.g:2674:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalTechnologyDsl.g:2680:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2686:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalTechnologyDsl.g:2687:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalTechnologyDsl.g:2687:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalTechnologyDsl.g:2688:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalTechnologyDsl.g:2692:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2693:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2693:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2694:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTechnologyDsl.g:2714:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalTechnologyDsl.g:2715:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalTechnologyDsl.g:2715:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalTechnologyDsl.g:2716:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_51);
            lv_fields_3_0=ruleEnumerationField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"fields",
            						lv_fields_3_0,
            						"de.fhdo.ddmm.data.DataDsl.EnumerationField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTechnologyDsl.g:2733:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==31) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2734:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_4); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalTechnologyDsl.g:2738:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalTechnologyDsl.g:2739:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalTechnologyDsl.g:2739:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalTechnologyDsl.g:2740:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_fields_5_0=ruleEnumerationField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_5_0,
            	    							"de.fhdo.ddmm.data.DataDsl.EnumerationField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_6=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleEnumerationField"
    // InternalTechnologyDsl.g:2766:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalTechnologyDsl.g:2766:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalTechnologyDsl.g:2767:2: iv_ruleEnumerationField= ruleEnumerationField EOF
            {
             newCompositeNode(grammarAccess.getEnumerationFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationField=ruleEnumerationField();

            state._fsp--;

             current =iv_ruleEnumerationField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationField"


    // $ANTLR start "ruleEnumerationField"
    // InternalTechnologyDsl.g:2773:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2779:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalTechnologyDsl.g:2780:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalTechnologyDsl.g:2780:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalTechnologyDsl.g:2781:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalTechnologyDsl.g:2781:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2782:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2782:4: (lv_name_0_0= RULE_ID )
            // InternalTechnologyDsl.g:2783:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_70); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumerationFieldAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalTechnologyDsl.g:2799:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==51) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTechnologyDsl.g:2800:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalTechnologyDsl.g:2804:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalTechnologyDsl.g:2805:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalTechnologyDsl.g:2805:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalTechnologyDsl.g:2806:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_71);
                    lv_initializationValue_2_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEnumerationFieldRule());
                    						}
                    						set(
                    							current,
                    							"initializationValue",
                    							lv_initializationValue_2_0,
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,52,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getEnumerationFieldAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationField"


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalTechnologyDsl.g:2832:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalTechnologyDsl.g:2832:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalTechnologyDsl.g:2833:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveValueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveValue=rulePrimitiveValue();

            state._fsp--;

             current =iv_rulePrimitiveValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveValue"


    // $ANTLR start "rulePrimitiveValue"
    // InternalTechnologyDsl.g:2839:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:2845:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalTechnologyDsl.g:2846:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalTechnologyDsl.g:2846:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt56=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt56=2;
                }
                break;
            case RULE_STRING:
                {
                alt56=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalTechnologyDsl.g:2847:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalTechnologyDsl.g:2847:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalTechnologyDsl.g:2848:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalTechnologyDsl.g:2848:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalTechnologyDsl.g:2849:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
                    {
                    lv_numericValue_0_0=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_2); 

                    					newLeafNode(lv_numericValue_0_0, grammarAccess.getPrimitiveValueAccess().getNumericValueBIG_DECIMALTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"numericValue",
                    						lv_numericValue_0_0,
                    						"de.fhdo.ddmm.data.DataDsl.BIG_DECIMAL");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2866:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalTechnologyDsl.g:2866:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalTechnologyDsl.g:2867:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalTechnologyDsl.g:2867:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalTechnologyDsl.g:2868:5: lv_booleanValue_1_0= RULE_BOOLEAN
                    {
                    lv_booleanValue_1_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    					newLeafNode(lv_booleanValue_1_0, grammarAccess.getPrimitiveValueAccess().getBooleanValueBOOLEANTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"booleanValue",
                    						lv_booleanValue_1_0,
                    						"de.fhdo.ddmm.data.DataDsl.BOOLEAN");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:2885:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalTechnologyDsl.g:2885:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalTechnologyDsl.g:2886:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalTechnologyDsl.g:2886:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalTechnologyDsl.g:2887:5: lv_stringValue_2_0= RULE_STRING
                    {
                    lv_stringValue_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_stringValue_2_0, grammarAccess.getPrimitiveValueAccess().getStringValueSTRINGTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"stringValue",
                    						lv_stringValue_2_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveValue"


    // $ANTLR start "entryRulePossiblyImportedComplexType"
    // InternalTechnologyDsl.g:2907:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalTechnologyDsl.g:2907:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalTechnologyDsl.g:2908:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
            {
             newCompositeNode(grammarAccess.getPossiblyImportedComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePossiblyImportedComplexType=rulePossiblyImportedComplexType();

            state._fsp--;

             current =iv_rulePossiblyImportedComplexType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePossiblyImportedComplexType"


    // $ANTLR start "rulePossiblyImportedComplexType"
    // InternalTechnologyDsl.g:2914:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:2920:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalTechnologyDsl.g:2921:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalTechnologyDsl.g:2921:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:2922:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:2922:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==42) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalTechnologyDsl.g:2923:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalTechnologyDsl.g:2923:4: ( (otherlv_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:2924:5: (otherlv_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:2924:5: (otherlv_0= RULE_ID )
                    // InternalTechnologyDsl.g:2925:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_37); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:2941:3: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:2942:4: ( ruleQualifiedName )
            {
            // InternalTechnologyDsl.g:2942:4: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:2943:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePossiblyImportedComplexType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalTechnologyDsl.g:2961:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalTechnologyDsl.g:2961:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalTechnologyDsl.g:2962:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalTechnologyDsl.g:2968:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:2974:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalTechnologyDsl.g:2975:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalTechnologyDsl.g:2975:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt58=10;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt58=1;
                }
                break;
            case 62:
                {
                alt58=2;
                }
                break;
            case 63:
                {
                alt58=3;
                }
                break;
            case 64:
                {
                alt58=4;
                }
                break;
            case 65:
                {
                alt58=5;
                }
                break;
            case 66:
                {
                alt58=6;
                }
                break;
            case 67:
                {
                alt58=7;
                }
                break;
            case 68:
                {
                alt58=8;
                }
                break;
            case 69:
                {
                alt58=9;
                }
                break;
            case 70:
                {
                alt58=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalTechnologyDsl.g:2976:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalTechnologyDsl.g:2976:3: ( () otherlv_1= 'boolean' )
                    // InternalTechnologyDsl.g:2977:4: () otherlv_1= 'boolean'
                    {
                    // InternalTechnologyDsl.g:2977:4: ()
                    // InternalTechnologyDsl.g:2978:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,61,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2990:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalTechnologyDsl.g:2990:3: ( () otherlv_3= 'byte' )
                    // InternalTechnologyDsl.g:2991:4: () otherlv_3= 'byte'
                    {
                    // InternalTechnologyDsl.g:2991:4: ()
                    // InternalTechnologyDsl.g:2992:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3004:3: ( () otherlv_5= 'char' )
                    {
                    // InternalTechnologyDsl.g:3004:3: ( () otherlv_5= 'char' )
                    // InternalTechnologyDsl.g:3005:4: () otherlv_5= 'char'
                    {
                    // InternalTechnologyDsl.g:3005:4: ()
                    // InternalTechnologyDsl.g:3006:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,63,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:3018:3: ( () otherlv_7= 'date' )
                    {
                    // InternalTechnologyDsl.g:3018:3: ( () otherlv_7= 'date' )
                    // InternalTechnologyDsl.g:3019:4: () otherlv_7= 'date'
                    {
                    // InternalTechnologyDsl.g:3019:4: ()
                    // InternalTechnologyDsl.g:3020:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,64,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:3032:3: ( () otherlv_9= 'double' )
                    {
                    // InternalTechnologyDsl.g:3032:3: ( () otherlv_9= 'double' )
                    // InternalTechnologyDsl.g:3033:4: () otherlv_9= 'double'
                    {
                    // InternalTechnologyDsl.g:3033:4: ()
                    // InternalTechnologyDsl.g:3034:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,65,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTechnologyDsl.g:3046:3: ( () otherlv_11= 'float' )
                    {
                    // InternalTechnologyDsl.g:3046:3: ( () otherlv_11= 'float' )
                    // InternalTechnologyDsl.g:3047:4: () otherlv_11= 'float'
                    {
                    // InternalTechnologyDsl.g:3047:4: ()
                    // InternalTechnologyDsl.g:3048:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,66,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTechnologyDsl.g:3060:3: ( () otherlv_13= 'int' )
                    {
                    // InternalTechnologyDsl.g:3060:3: ( () otherlv_13= 'int' )
                    // InternalTechnologyDsl.g:3061:4: () otherlv_13= 'int'
                    {
                    // InternalTechnologyDsl.g:3061:4: ()
                    // InternalTechnologyDsl.g:3062:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,67,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalTechnologyDsl.g:3074:3: ( () otherlv_15= 'long' )
                    {
                    // InternalTechnologyDsl.g:3074:3: ( () otherlv_15= 'long' )
                    // InternalTechnologyDsl.g:3075:4: () otherlv_15= 'long'
                    {
                    // InternalTechnologyDsl.g:3075:4: ()
                    // InternalTechnologyDsl.g:3076:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,68,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalTechnologyDsl.g:3088:3: ( () otherlv_17= 'short' )
                    {
                    // InternalTechnologyDsl.g:3088:3: ( () otherlv_17= 'short' )
                    // InternalTechnologyDsl.g:3089:4: () otherlv_17= 'short'
                    {
                    // InternalTechnologyDsl.g:3089:4: ()
                    // InternalTechnologyDsl.g:3090:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,69,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalTechnologyDsl.g:3102:3: ( () otherlv_19= 'string' )
                    {
                    // InternalTechnologyDsl.g:3102:3: ( () otherlv_19= 'string' )
                    // InternalTechnologyDsl.g:3103:4: () otherlv_19= 'string'
                    {
                    // InternalTechnologyDsl.g:3103:4: ()
                    // InternalTechnologyDsl.g:3104:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,70,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTechnologyDsl.g:3119:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTechnologyDsl.g:3119:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTechnologyDsl.g:3120:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTechnologyDsl.g:3126:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3132:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTechnologyDsl.g:3133:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTechnologyDsl.g:3133:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTechnologyDsl.g:3134:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_72); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTechnologyDsl.g:3141:3: (kw= '.' this_ID_2= RULE_ID )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==71) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3142:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,71,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_72); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleExchangePattern"
    // InternalTechnologyDsl.g:3159:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3165:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalTechnologyDsl.g:3166:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalTechnologyDsl.g:3166:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt60=1;
                }
                break;
            case 73:
                {
                alt60=2;
                }
                break;
            case 74:
                {
                alt60=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalTechnologyDsl.g:3167:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTechnologyDsl.g:3167:3: (enumLiteral_0= 'in' )
                    // InternalTechnologyDsl.g:3168:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3175:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTechnologyDsl.g:3175:3: (enumLiteral_1= 'out' )
                    // InternalTechnologyDsl.g:3176:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3183:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTechnologyDsl.g:3183:3: (enumLiteral_2= 'inout' )
                    // InternalTechnologyDsl.g:3184:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getExchangePatternAccess().getINOUTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExchangePattern"


    // $ANTLR start "ruleCommunicationType"
    // InternalTechnologyDsl.g:3194:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3200:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalTechnologyDsl.g:3201:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalTechnologyDsl.g:3201:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==75) ) {
                alt61=1;
            }
            else if ( (LA61_0==76) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalTechnologyDsl.g:3202:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalTechnologyDsl.g:3202:3: (enumLiteral_0= 'sync' )
                    // InternalTechnologyDsl.g:3203:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3210:3: (enumLiteral_1= 'async' )
                    {
                    // InternalTechnologyDsl.g:3210:3: (enumLiteral_1= 'async' )
                    // InternalTechnologyDsl.g:3211:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommunicationType"


    // $ANTLR start "ruleCompatibilityDirection"
    // InternalTechnologyDsl.g:3221:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3227:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalTechnologyDsl.g:3228:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalTechnologyDsl.g:3228:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt62=1;
                }
                break;
            case 78:
                {
                alt62=2;
                }
                break;
            case 79:
                {
                alt62=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalTechnologyDsl.g:3229:3: (enumLiteral_0= '<-' )
                    {
                    // InternalTechnologyDsl.g:3229:3: (enumLiteral_0= '<-' )
                    // InternalTechnologyDsl.g:3230:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3237:3: (enumLiteral_1= '->' )
                    {
                    // InternalTechnologyDsl.g:3237:3: (enumLiteral_1= '->' )
                    // InternalTechnologyDsl.g:3238:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3245:3: (enumLiteral_2= '<->' )
                    {
                    // InternalTechnologyDsl.g:3245:3: (enumLiteral_2= '<->' )
                    // InternalTechnologyDsl.g:3246:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getBIDIRECTIONALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCompatibilityDirectionAccess().getBIDIRECTIONALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompatibilityDirection"


    // $ANTLR start "rulePropertyFeature"
    // InternalTechnologyDsl.g:3256:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3262:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalTechnologyDsl.g:3263:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalTechnologyDsl.g:3263:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==80) ) {
                alt63=1;
            }
            else if ( (LA63_0==81) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalTechnologyDsl.g:3264:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalTechnologyDsl.g:3264:3: (enumLiteral_0= 'mandatory' )
                    // InternalTechnologyDsl.g:3265:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3272:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalTechnologyDsl.g:3272:3: (enumLiteral_1= 'singleval' )
                    // InternalTechnologyDsl.g:3273:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getSINGLE_VALUEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPropertyFeatureAccess().getSINGLE_VALUEDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyFeature"


    // $ANTLR start "ruleServiceJoinPointType"
    // InternalTechnologyDsl.g:3283:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) ;
    public final Enumerator ruleServiceJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3289:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) )
            // InternalTechnologyDsl.g:3290:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            {
            // InternalTechnologyDsl.g:3290:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt64=1;
                }
                break;
            case 83:
                {
                alt64=2;
                }
                break;
            case 84:
                {
                alt64=3;
                }
                break;
            case 85:
                {
                alt64=4;
                }
                break;
            case 15:
                {
                alt64=5;
                }
                break;
            case 86:
                {
                alt64=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalTechnologyDsl.g:3291:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalTechnologyDsl.g:3291:3: (enumLiteral_0= 'microservices' )
                    // InternalTechnologyDsl.g:3292:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3299:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalTechnologyDsl.g:3299:3: (enumLiteral_1= 'interfaces' )
                    // InternalTechnologyDsl.g:3300:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3307:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalTechnologyDsl.g:3307:3: (enumLiteral_2= 'operations' )
                    // InternalTechnologyDsl.g:3308:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:3315:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalTechnologyDsl.g:3315:3: (enumLiteral_3= 'parameters' )
                    // InternalTechnologyDsl.g:3316:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:3323:3: (enumLiteral_4= 'types' )
                    {
                    // InternalTechnologyDsl.g:3323:3: (enumLiteral_4= 'types' )
                    // InternalTechnologyDsl.g:3324:4: enumLiteral_4= 'types'
                    {
                    enumLiteral_4=(Token)match(input,15,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTechnologyDsl.g:3331:3: (enumLiteral_5= 'fields' )
                    {
                    // InternalTechnologyDsl.g:3331:3: (enumLiteral_5= 'fields' )
                    // InternalTechnologyDsl.g:3332:4: enumLiteral_5= 'fields'
                    {
                    enumLiteral_5=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceJoinPointType"


    // $ANTLR start "ruleOperationJoinPointType"
    // InternalTechnologyDsl.g:3342:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3348:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalTechnologyDsl.g:3349:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalTechnologyDsl.g:3349:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==87) ) {
                alt65=1;
            }
            else if ( (LA65_0==24) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalTechnologyDsl.g:3350:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalTechnologyDsl.g:3350:3: (enumLiteral_0= 'containers' )
                    // InternalTechnologyDsl.g:3351:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3358:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalTechnologyDsl.g:3358:3: (enumLiteral_1= 'infrastructure' )
                    // InternalTechnologyDsl.g:3359:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getINFRASTRUCTURE_NODESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperationJoinPointTypeAccess().getINFRASTRUCTURE_NODESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationJoinPointType"

    // Delegated rules


    protected DFA51 dfa51 = new DFA51(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\50\1\4\1\16\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_3s = "\1\50\1\4\1\16\1\106\1\uffff\12\22\1\uffff";
    static final String dfa_4s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\66\uffff\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
            "",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2448:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000035C8000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000031000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000031000050000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000035C0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L,0x0000000000001800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003540000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000003440000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000980000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xE000000000000000L,0x000000000000007FL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000080000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000880000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0xE000000000040000L,0x000000000000007FL});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000100800004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000030000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000700L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0003C00000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0010000080000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000008000L,0x00000000007C0000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000880004000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xE004000000040000L,0x000000000000007FL});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000001000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x1200030000040000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1000030000040000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0200000000040000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1000030000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0400000000004000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0xE800000000040010L,0x000000000000007FL});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xE800000000000010L,0x000000000000007FL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0xE000000000000010L,0x000000000000007FL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});

}