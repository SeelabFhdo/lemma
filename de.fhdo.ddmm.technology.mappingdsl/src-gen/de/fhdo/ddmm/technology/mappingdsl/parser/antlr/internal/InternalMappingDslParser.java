package de.fhdo.ddmm.technology.mappingdsl.parser.antlr.internal;

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
import de.fhdo.ddmm.technology.mappingdsl.services.MappingDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMappingDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'technology'", "'('", "')'", "'{'", "'protocols'", "'}'", "'endpoints'", "'aspects'", "'interface'", "'operation'", "'parameters'", "','", "'referred'", "'primitive'", "':'", "'::'", "'complex'", "'->'", "'.'", "'/'", "';'", "'import'", "'from'", "'as'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'noimpl'", "'refers'", "'fault'", "'?'", "'='", "'data'", "'formats'", "'default'", "'with'", "'format'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'environments'", "'service'", "'properties'", "'mandatory'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'aspect'", "'for'", "'datatypes'", "'context'", "'extends'", "'hide'", "'enum'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'functional'", "'utility'", "'infrastructure'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'<->'", "'fields'", "'containers'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int RULE_BIG_DECIMAL=6;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalMappingDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMappingDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMappingDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMappingDsl.g"; }



     	private MappingDslGrammarAccess grammarAccess;

        public InternalMappingDslParser(TokenStream input, MappingDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TechnologyMapping";
       	}

       	@Override
       	protected MappingDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTechnologyMapping"
    // InternalMappingDsl.g:65:1: entryRuleTechnologyMapping returns [EObject current=null] : iv_ruleTechnologyMapping= ruleTechnologyMapping EOF ;
    public final EObject entryRuleTechnologyMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyMapping = null;


        try {
            // InternalMappingDsl.g:65:58: (iv_ruleTechnologyMapping= ruleTechnologyMapping EOF )
            // InternalMappingDsl.g:66:2: iv_ruleTechnologyMapping= ruleTechnologyMapping EOF
            {
             newCompositeNode(grammarAccess.getTechnologyMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologyMapping=ruleTechnologyMapping();

            state._fsp--;

             current =iv_ruleTechnologyMapping; 
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
    // $ANTLR end "entryRuleTechnologyMapping"


    // $ANTLR start "ruleTechnologyMapping"
    // InternalMappingDsl.g:72:1: ruleTechnologyMapping returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_serviceMappings_1_0= ruleMicroserviceMapping ) )+ ) ;
    public final EObject ruleTechnologyMapping() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_serviceMappings_1_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_serviceMappings_1_0= ruleMicroserviceMapping ) )+ ) )
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_serviceMappings_1_0= ruleMicroserviceMapping ) )+ )
            {
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_serviceMappings_1_0= ruleMicroserviceMapping ) )+ )
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+ ( (lv_serviceMappings_1_0= ruleMicroserviceMapping ) )+
            {
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMappingDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalMappingDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalMappingDsl.g:82:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyMappingAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"de.fhdo.ddmm.ServiceDsl.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // InternalMappingDsl.g:99:3: ( (lv_serviceMappings_1_0= ruleMicroserviceMapping ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMappingDsl.g:100:4: (lv_serviceMappings_1_0= ruleMicroserviceMapping )
            	    {
            	    // InternalMappingDsl.g:100:4: (lv_serviceMappings_1_0= ruleMicroserviceMapping )
            	    // InternalMappingDsl.g:101:5: lv_serviceMappings_1_0= ruleMicroserviceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyMappingAccess().getServiceMappingsMicroserviceMappingParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_serviceMappings_1_0=ruleMicroserviceMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"serviceMappings",
            	    						lv_serviceMappings_1_0,
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.MicroserviceMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

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
    // $ANTLR end "ruleTechnologyMapping"


    // $ANTLR start "entryRuleMicroserviceMapping"
    // InternalMappingDsl.g:122:1: entryRuleMicroserviceMapping returns [EObject current=null] : iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF ;
    public final EObject entryRuleMicroserviceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroserviceMapping = null;


        try {
            // InternalMappingDsl.g:122:60: (iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF )
            // InternalMappingDsl.g:123:2: iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF
            {
             newCompositeNode(grammarAccess.getMicroserviceMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMicroserviceMapping=ruleMicroserviceMapping();

            state._fsp--;

             current =iv_ruleMicroserviceMapping; 
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
    // $ANTLR end "entryRuleMicroserviceMapping"


    // $ANTLR start "ruleMicroserviceMapping"
    // InternalMappingDsl.g:129:1: ruleMicroserviceMapping returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' ) ;
    public final EObject ruleMicroserviceMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_22=null;
        EObject lv_microservice_5_0 = null;

        EObject lv_protocols_9_0 = null;

        EObject lv_endpoints_13_0 = null;

        EObject lv_aspects_17_0 = null;

        EObject lv_interfaceMappings_19_0 = null;

        EObject lv_referredOperationMappings_20_0 = null;

        EObject lv_operationMappings_21_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:135:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' ) )
            // InternalMappingDsl.g:136:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' )
            {
            // InternalMappingDsl.g:136:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' )
            // InternalMappingDsl.g:137:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}'
            {
            // InternalMappingDsl.g:137:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMappingDsl.g:138:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getMicroserviceMappingAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMicroserviceMappingAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMicroserviceMappingAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalMappingDsl.g:150:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:151:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:151:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:152:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMicroserviceMappingRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_3, grammarAccess.getMicroserviceMappingAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_9); 

            	    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceMappingAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            // InternalMappingDsl.g:168:3: ( (lv_microservice_5_0= ruleImportedMicroservice ) )
            // InternalMappingDsl.g:169:4: (lv_microservice_5_0= ruleImportedMicroservice )
            {
            // InternalMappingDsl.g:169:4: (lv_microservice_5_0= ruleImportedMicroservice )
            // InternalMappingDsl.g:170:5: lv_microservice_5_0= ruleImportedMicroservice
            {

            					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getMicroserviceImportedMicroserviceParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_microservice_5_0=ruleImportedMicroservice();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            					}
            					set(
            						current,
            						"microservice",
            						lv_microservice_5_0,
            						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ImportedMicroservice");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_6, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:191:3: (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMappingDsl.g:192:4: otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:200:4: ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=94 && LA4_0<=95)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalMappingDsl.g:201:5: (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:201:5: (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:202:6: lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_protocols_9_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_9_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_14); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:224:3: (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMappingDsl.g:225:4: otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,20,FOLLOW_10); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_12=(Token)match(input,17,FOLLOW_15); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:233:4: ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalMappingDsl.g:234:5: (lv_endpoints_13_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:234:5: (lv_endpoints_13_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:235:6: lv_endpoints_13_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_13_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_13_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,19,FOLLOW_16); 

                    				newLeafNode(otherlv_14, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:257:3: (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMappingDsl.g:258:4: otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_15, grammarAccess.getMicroserviceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:266:4: ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalMappingDsl.g:267:5: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:267:5: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:268:6: lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_aspects_17_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_17_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_18=(Token)match(input,19,FOLLOW_17); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:290:3: ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMappingDsl.g:291:4: (lv_interfaceMappings_19_0= ruleInterfaceMapping )
            	    {
            	    // InternalMappingDsl.g:291:4: (lv_interfaceMappings_19_0= ruleInterfaceMapping )
            	    // InternalMappingDsl.g:292:5: lv_interfaceMappings_19_0= ruleInterfaceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getInterfaceMappingsInterfaceMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_interfaceMappings_19_0=ruleInterfaceMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"interfaceMappings",
            	    						lv_interfaceMappings_19_0,
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.InterfaceMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalMappingDsl.g:309:3: ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMappingDsl.g:310:4: (lv_referredOperationMappings_20_0= ruleReferredOperationMapping )
            	    {
            	    // InternalMappingDsl.g:310:4: (lv_referredOperationMappings_20_0= ruleReferredOperationMapping )
            	    // InternalMappingDsl.g:311:5: lv_referredOperationMappings_20_0= ruleReferredOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getReferredOperationMappingsReferredOperationMappingParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_referredOperationMappings_20_0=ruleReferredOperationMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referredOperationMappings",
            	    						lv_referredOperationMappings_20_0,
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ReferredOperationMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalMappingDsl.g:328:3: ( (lv_operationMappings_21_0= ruleOperationMapping ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMappingDsl.g:329:4: (lv_operationMappings_21_0= ruleOperationMapping )
            	    {
            	    // InternalMappingDsl.g:329:4: (lv_operationMappings_21_0= ruleOperationMapping )
            	    // InternalMappingDsl.g:330:5: lv_operationMappings_21_0= ruleOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getOperationMappingsOperationMappingParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_operationMappings_21_0=ruleOperationMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operationMappings",
            	    						lv_operationMappings_21_0,
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.OperationMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_22=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_9());
            		

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
    // $ANTLR end "ruleMicroserviceMapping"


    // $ANTLR start "entryRuleInterfaceMapping"
    // InternalMappingDsl.g:355:1: entryRuleInterfaceMapping returns [EObject current=null] : iv_ruleInterfaceMapping= ruleInterfaceMapping EOF ;
    public final EObject entryRuleInterfaceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceMapping = null;


        try {
            // InternalMappingDsl.g:355:57: (iv_ruleInterfaceMapping= ruleInterfaceMapping EOF )
            // InternalMappingDsl.g:356:2: iv_ruleInterfaceMapping= ruleInterfaceMapping EOF
            {
             newCompositeNode(grammarAccess.getInterfaceMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterfaceMapping=ruleInterfaceMapping();

            state._fsp--;

             current =iv_ruleInterfaceMapping; 
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
    // $ANTLR end "entryRuleInterfaceMapping"


    // $ANTLR start "ruleInterfaceMapping"
    // InternalMappingDsl.g:362:1: ruleInterfaceMapping returns [EObject current=null] : (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) ;
    public final EObject ruleInterfaceMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_protocols_5_0 = null;

        EObject lv_endpoints_9_0 = null;

        EObject lv_aspects_13_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:368:2: ( (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalMappingDsl.g:369:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalMappingDsl.g:369:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            // InternalMappingDsl.g:370:3: otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getInterfaceMappingAccess().getInterfaceKeyword_0());
            		
            // InternalMappingDsl.g:374:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:375:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:375:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:376:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getInterfaceMappingAccess().getInterfaceInterfaceCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:391:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMappingDsl.g:392:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:400:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=94 && LA13_0<=95)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMappingDsl.g:401:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:401:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:402:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_protocols_5_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_5_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:424:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMappingDsl.g:425:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:433:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalMappingDsl.g:434:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:434:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:435:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_9_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_9_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_22); 

                    				newLeafNode(otherlv_10, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:457:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==21) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMappingDsl.g:458:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:466:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalMappingDsl.g:467:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:467:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:468:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_aspects_13_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_13_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    otherlv_14=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_14, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleInterfaceMapping"


    // $ANTLR start "entryRuleOperationMapping"
    // InternalMappingDsl.g:498:1: entryRuleOperationMapping returns [EObject current=null] : iv_ruleOperationMapping= ruleOperationMapping EOF ;
    public final EObject entryRuleOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationMapping = null;


        try {
            // InternalMappingDsl.g:498:57: (iv_ruleOperationMapping= ruleOperationMapping EOF )
            // InternalMappingDsl.g:499:2: iv_ruleOperationMapping= ruleOperationMapping EOF
            {
             newCompositeNode(grammarAccess.getOperationMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationMapping=ruleOperationMapping();

            state._fsp--;

             current =iv_ruleOperationMapping; 
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
    // $ANTLR end "entryRuleOperationMapping"


    // $ANTLR start "ruleOperationMapping"
    // InternalMappingDsl.g:505:1: ruleOperationMapping returns [EObject current=null] : (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' ) ;
    public final EObject ruleOperationMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject lv_protocols_5_0 = null;

        EObject lv_endpoints_9_0 = null;

        EObject lv_aspects_13_0 = null;

        EObject lv_parameterMappings_17_1 = null;

        EObject lv_parameterMappings_17_2 = null;

        EObject lv_parameterMappings_19_1 = null;

        EObject lv_parameterMappings_19_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:511:2: ( (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' ) )
            // InternalMappingDsl.g:512:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' )
            {
            // InternalMappingDsl.g:512:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' )
            // InternalMappingDsl.g:513:3: otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationMappingAccess().getOperationKeyword_0());
            		
            // InternalMappingDsl.g:517:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:518:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:518:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:519:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOperationMappingAccess().getOperationOperationCrossReference_1_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:537:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==18) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMappingDsl.g:538:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:546:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=94 && LA19_0<=95)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalMappingDsl.g:547:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:547:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:548:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_protocols_5_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_5_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_25); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:570:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMappingDsl.g:571:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:579:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalMappingDsl.g:580:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:580:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:581:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_9_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_9_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_26); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:603:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==21) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMappingDsl.g:604:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_11, grammarAccess.getOperationMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:612:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalMappingDsl.g:613:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:613:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:614:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_aspects_13_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_13_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    otherlv_14=(Token)match(input,19,FOLLOW_27); 

                    				newLeafNode(otherlv_14, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:636:3: (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==24) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMappingDsl.g:637:4: otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,24,FOLLOW_10); 

                    				newLeafNode(otherlv_15, grammarAccess.getOperationMappingAccess().getParametersKeyword_6_0());
                    			
                    otherlv_16=(Token)match(input,17,FOLLOW_28); 

                    				newLeafNode(otherlv_16, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:645:4: ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )
                    // InternalMappingDsl.g:646:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    {
                    // InternalMappingDsl.g:646:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    // InternalMappingDsl.g:647:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    {
                    // InternalMappingDsl.g:647:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==27) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==30) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalMappingDsl.g:648:7: lv_parameterMappings_17_1= rulePrimitiveParameterMapping
                            {

                            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_2_0_0());
                            						
                            pushFollow(FOLLOW_29);
                            lv_parameterMappings_17_1=rulePrimitiveParameterMapping();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                            							}
                            							add(
                            								current,
                            								"parameterMappings",
                            								lv_parameterMappings_17_1,
                            								"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.PrimitiveParameterMapping");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:664:7: lv_parameterMappings_17_2= ruleComplexParameterMapping
                            {

                            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_2_0_1());
                            						
                            pushFollow(FOLLOW_29);
                            lv_parameterMappings_17_2=ruleComplexParameterMapping();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                            							}
                            							add(
                            								current,
                            								"parameterMappings",
                            								lv_parameterMappings_17_2,
                            								"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ComplexParameterMapping");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalMappingDsl.g:682:4: (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==25) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalMappingDsl.g:683:5: otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) )
                    	    {
                    	    otherlv_18=(Token)match(input,25,FOLLOW_28); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getOperationMappingAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMappingDsl.g:687:5: ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) )
                    	    // InternalMappingDsl.g:688:6: ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) )
                    	    {
                    	    // InternalMappingDsl.g:688:6: ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) )
                    	    // InternalMappingDsl.g:689:7: (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping )
                    	    {
                    	    // InternalMappingDsl.g:689:7: (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping )
                    	    int alt26=2;
                    	    int LA26_0 = input.LA(1);

                    	    if ( (LA26_0==27) ) {
                    	        alt26=1;
                    	    }
                    	    else if ( (LA26_0==30) ) {
                    	        alt26=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 26, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt26) {
                    	        case 1 :
                    	            // InternalMappingDsl.g:690:8: lv_parameterMappings_19_1= rulePrimitiveParameterMapping
                    	            {

                    	            								newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_3_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_29);
                    	            lv_parameterMappings_19_1=rulePrimitiveParameterMapping();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"parameterMappings",
                    	            									lv_parameterMappings_19_1,
                    	            									"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.PrimitiveParameterMapping");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalMappingDsl.g:706:8: lv_parameterMappings_19_2= ruleComplexParameterMapping
                    	            {

                    	            								newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_3_1_0_1());
                    	            							
                    	            pushFollow(FOLLOW_29);
                    	            lv_parameterMappings_19_2=ruleComplexParameterMapping();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"parameterMappings",
                    	            									lv_parameterMappings_19_2,
                    	            									"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ComplexParameterMapping");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_20, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_21=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleOperationMapping"


    // $ANTLR start "entryRuleReferredOperationMapping"
    // InternalMappingDsl.g:738:1: entryRuleReferredOperationMapping returns [EObject current=null] : iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF ;
    public final EObject entryRuleReferredOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperationMapping = null;


        try {
            // InternalMappingDsl.g:738:65: (iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF )
            // InternalMappingDsl.g:739:2: iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF
            {
             newCompositeNode(grammarAccess.getReferredOperationMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferredOperationMapping=ruleReferredOperationMapping();

            state._fsp--;

             current =iv_ruleReferredOperationMapping; 
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
    // $ANTLR end "entryRuleReferredOperationMapping"


    // $ANTLR start "ruleReferredOperationMapping"
    // InternalMappingDsl.g:745:1: ruleReferredOperationMapping returns [EObject current=null] : (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) ;
    public final EObject ruleReferredOperationMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        EObject lv_protocols_6_0 = null;

        EObject lv_endpoints_10_0 = null;

        EObject lv_aspects_14_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:751:2: ( (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) )
            // InternalMappingDsl.g:752:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            {
            // InternalMappingDsl.g:752:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            // InternalMappingDsl.g:753:3: otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_30); 

            			newLeafNode(otherlv_0, grammarAccess.getReferredOperationMappingAccess().getReferredKeyword_0());
            		
            otherlv_1=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getReferredOperationMappingAccess().getOperationKeyword_1());
            		
            // InternalMappingDsl.g:761:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:762:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:762:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:763:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getOperationReferredOperationCrossReference_2_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:781:3: (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==18) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMappingDsl.g:782:4: otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationMappingAccess().getProtocolsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_5, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:790:4: ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( ((LA29_0>=94 && LA29_0<=95)) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalMappingDsl.g:791:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:791:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:792:6: lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_protocols_6_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_6_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);

                    otherlv_7=(Token)match(input,19,FOLLOW_21); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:814:3: (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==20) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMappingDsl.g:815:4: otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_10); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationMappingAccess().getEndpointsKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:823:4: ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_ID) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalMappingDsl.g:824:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:824:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:825:6: lv_endpoints_10_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_10_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_10_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    otherlv_11=(Token)match(input,19,FOLLOW_22); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:847:3: (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==21) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMappingDsl.g:848:4: otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_12, grammarAccess.getReferredOperationMappingAccess().getAspectsKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:856:4: ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalMappingDsl.g:857:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:857:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:858:6: lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_aspects_14_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_14_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);

                    otherlv_15=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_15, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_16=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleReferredOperationMapping"


    // $ANTLR start "entryRulePrimitiveParameterMapping"
    // InternalMappingDsl.g:888:1: entryRulePrimitiveParameterMapping returns [EObject current=null] : iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF ;
    public final EObject entryRulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveParameterMapping = null;


        try {
            // InternalMappingDsl.g:888:66: (iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF )
            // InternalMappingDsl.g:889:2: iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveParameterMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveParameterMapping=rulePrimitiveParameterMapping();

            state._fsp--;

             current =iv_rulePrimitiveParameterMapping; 
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
    // $ANTLR end "entryRulePrimitiveParameterMapping"


    // $ANTLR start "rulePrimitiveParameterMapping"
    // InternalMappingDsl.g:895:1: rulePrimitiveParameterMapping returns [EObject current=null] : (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) ;
    public final EObject rulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_aspects_9_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:901:2: ( (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) )
            // InternalMappingDsl.g:902:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? )
            {
            // InternalMappingDsl.g:902:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? )
            // InternalMappingDsl.g:903:3: otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveKeyword_0());
            		
            // InternalMappingDsl.g:907:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:908:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:908:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:909:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_1, grammarAccess.getPrimitiveParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:920:3: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMappingDsl.g:921:4: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimitiveParameterMappingAccess().getColonKeyword_2_0());
                    			
                    // InternalMappingDsl.g:925:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:926:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:926:5: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:927:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_3, grammarAccess.getPrimitiveParameterMappingAccess().getTechnologyImportCrossReference_2_1_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimitiveParameterMappingAccess().getColonColonKeyword_2_2());
                    			
                    // InternalMappingDsl.g:942:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:943:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:943:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:944:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveTypeTechnologySpecificPrimitiveTypeCrossReference_2_3_0());
                    					
                    pushFollow(FOLLOW_33);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:959:3: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMappingDsl.g:960:4: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    otherlv_7=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveParameterMappingAccess().getAspectsKeyword_3_1());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_2());
                    			
                    // InternalMappingDsl.g:972:4: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_ID) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalMappingDsl.g:973:5: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:973:5: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:974:6: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_aspects_9_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPrimitiveParameterMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_9_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_10, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_4());
                    			
                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_5());
                    			

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
    // $ANTLR end "rulePrimitiveParameterMapping"


    // $ANTLR start "entryRuleComplexParameterMapping"
    // InternalMappingDsl.g:1004:1: entryRuleComplexParameterMapping returns [EObject current=null] : iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF ;
    public final EObject entryRuleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexParameterMapping = null;


        try {
            // InternalMappingDsl.g:1004:64: (iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF )
            // InternalMappingDsl.g:1005:2: iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF
            {
             newCompositeNode(grammarAccess.getComplexParameterMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexParameterMapping=ruleComplexParameterMapping();

            state._fsp--;

             current =iv_ruleComplexParameterMapping; 
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
    // $ANTLR end "entryRuleComplexParameterMapping"


    // $ANTLR start "ruleComplexParameterMapping"
    // InternalMappingDsl.g:1011:1: ruleComplexParameterMapping returns [EObject current=null] : (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) | (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' ) ) ) ;
    public final EObject ruleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject lv_aspects_9_0 = null;

        EObject lv_aspects_16_0 = null;

        EObject lv_dataFieldMappings_18_0 = null;

        EObject lv_dataFieldMappings_20_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1017:2: ( (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) | (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' ) ) ) )
            // InternalMappingDsl.g:1018:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) | (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' ) ) )
            {
            // InternalMappingDsl.g:1018:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) | (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' ) ) )
            // InternalMappingDsl.g:1019:3: otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) | (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexParameterMappingAccess().getComplexKeyword_0());
            		
            // InternalMappingDsl.g:1023:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1024:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1024:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1025:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(otherlv_1, grammarAccess.getComplexParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1036:3: ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? ) | (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==EOF||LA44_0==17||LA44_0==19||LA44_0==25||LA44_0==28) ) {
                alt44=1;
            }
            else if ( (LA44_0==31) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalMappingDsl.g:1037:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? )
                    {
                    // InternalMappingDsl.g:1037:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )? )
                    // InternalMappingDsl.g:1038:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )?
                    {
                    // InternalMappingDsl.g:1038:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==28) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalMappingDsl.g:1039:6: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_2=(Token)match(input,28,FOLLOW_7); 

                            						newLeafNode(otherlv_2, grammarAccess.getComplexParameterMappingAccess().getColonKeyword_2_0_0_0());
                            					
                            // InternalMappingDsl.g:1043:6: ( (otherlv_3= RULE_ID ) )
                            // InternalMappingDsl.g:1044:7: (otherlv_3= RULE_ID )
                            {
                            // InternalMappingDsl.g:1044:7: (otherlv_3= RULE_ID )
                            // InternalMappingDsl.g:1045:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_32); 

                            								newLeafNode(otherlv_3, grammarAccess.getComplexParameterMappingAccess().getTechnologyImportCrossReference_2_0_0_1_0());
                            							

                            }


                            }

                            otherlv_4=(Token)match(input,29,FOLLOW_7); 

                            						newLeafNode(otherlv_4, grammarAccess.getComplexParameterMappingAccess().getColonColonKeyword_2_0_0_2());
                            					
                            // InternalMappingDsl.g:1060:6: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1061:7: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1061:7: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1062:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getTechnologySpecificComplexTypeComplexTypeCrossReference_2_0_0_3_0());
                            							
                            pushFollow(FOLLOW_33);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1077:5: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==17) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalMappingDsl.g:1078:6: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                            {
                            otherlv_6=(Token)match(input,17,FOLLOW_34); 

                            						newLeafNode(otherlv_6, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0());
                            					
                            otherlv_7=(Token)match(input,21,FOLLOW_10); 

                            						newLeafNode(otherlv_7, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_0_1_1());
                            					
                            otherlv_8=(Token)match(input,17,FOLLOW_7); 

                            						newLeafNode(otherlv_8, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_2());
                            					
                            // InternalMappingDsl.g:1090:6: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt39=0;
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==RULE_ID) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1091:7: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1091:7: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1092:8: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_1_3_0());
                            	    							
                            	    pushFollow(FOLLOW_15);
                            	    lv_aspects_9_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"aspects",
                            	    									lv_aspects_9_0,
                            	    									"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt39 >= 1 ) break loop39;
                                        EarlyExitException eee =
                                            new EarlyExitException(39, input);
                                        throw eee;
                                }
                                cnt39++;
                            } while (true);

                            otherlv_10=(Token)match(input,19,FOLLOW_23); 

                            						newLeafNode(otherlv_10, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_4());
                            					
                            otherlv_11=(Token)match(input,19,FOLLOW_2); 

                            						newLeafNode(otherlv_11, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_5());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1120:4: (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' )
                    {
                    // InternalMappingDsl.g:1120:4: (otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}' )
                    // InternalMappingDsl.g:1121:5: otherlv_12= '->' otherlv_13= '{' (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )? ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_21= '}'
                    {
                    otherlv_12=(Token)match(input,31,FOLLOW_10); 

                    					newLeafNode(otherlv_12, grammarAccess.getComplexParameterMappingAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
                    				
                    otherlv_13=(Token)match(input,17,FOLLOW_36); 

                    					newLeafNode(otherlv_13, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_1());
                    				
                    // InternalMappingDsl.g:1129:5: (otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==21) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalMappingDsl.g:1130:6: otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}'
                            {
                            otherlv_14=(Token)match(input,21,FOLLOW_10); 

                            						newLeafNode(otherlv_14, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_1_2_0());
                            					
                            otherlv_15=(Token)match(input,17,FOLLOW_7); 

                            						newLeafNode(otherlv_15, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_2_1());
                            					
                            // InternalMappingDsl.g:1138:6: ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt41=0;
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==RULE_ID) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1139:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1139:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1140:8: lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_1_2_2_0());
                            	    							
                            	    pushFollow(FOLLOW_15);
                            	    lv_aspects_16_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"aspects",
                            	    									lv_aspects_16_0,
                            	    									"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt41 >= 1 ) break loop41;
                                        EarlyExitException eee =
                                            new EarlyExitException(41, input);
                                        throw eee;
                                }
                                cnt41++;
                            } while (true);

                            otherlv_17=(Token)match(input,19,FOLLOW_36); 

                            						newLeafNode(otherlv_17, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_2_3());
                            					

                            }
                            break;

                    }

                    // InternalMappingDsl.g:1162:5: ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) )
                    // InternalMappingDsl.g:1163:6: (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping )
                    {
                    // InternalMappingDsl.g:1163:6: (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping )
                    // InternalMappingDsl.g:1164:7: lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping
                    {

                    							newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getDataFieldMappingsTechnologySpecificDataFieldTypeMappingParserRuleCall_2_1_3_0());
                    						
                    pushFollow(FOLLOW_29);
                    lv_dataFieldMappings_18_0=ruleTechnologySpecificDataFieldTypeMapping();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                    							}
                    							add(
                    								current,
                    								"dataFieldMappings",
                    								lv_dataFieldMappings_18_0,
                    								"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificDataFieldTypeMapping");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalMappingDsl.g:1181:5: (otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==25) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1182:6: otherlv_19= ',' ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) )
                    	    {
                    	    otherlv_19=(Token)match(input,25,FOLLOW_36); 

                    	    						newLeafNode(otherlv_19, grammarAccess.getComplexParameterMappingAccess().getCommaKeyword_2_1_4_0());
                    	    					
                    	    // InternalMappingDsl.g:1186:6: ( (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping ) )
                    	    // InternalMappingDsl.g:1187:7: (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping )
                    	    {
                    	    // InternalMappingDsl.g:1187:7: (lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping )
                    	    // InternalMappingDsl.g:1188:8: lv_dataFieldMappings_20_0= ruleTechnologySpecificDataFieldTypeMapping
                    	    {

                    	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getDataFieldMappingsTechnologySpecificDataFieldTypeMappingParserRuleCall_2_1_4_1_0());
                    	    							
                    	    pushFollow(FOLLOW_29);
                    	    lv_dataFieldMappings_20_0=ruleTechnologySpecificDataFieldTypeMapping();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"dataFieldMappings",
                    	    									lv_dataFieldMappings_20_0,
                    	    									"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificDataFieldTypeMapping");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(otherlv_21, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_5());
                    				

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
    // $ANTLR end "ruleComplexParameterMapping"


    // $ANTLR start "entryRuleTechnologySpecificDataFieldTypeMapping"
    // InternalMappingDsl.g:1216:1: entryRuleTechnologySpecificDataFieldTypeMapping returns [EObject current=null] : iv_ruleTechnologySpecificDataFieldTypeMapping= ruleTechnologySpecificDataFieldTypeMapping EOF ;
    public final EObject entryRuleTechnologySpecificDataFieldTypeMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataFieldTypeMapping = null;


        try {
            // InternalMappingDsl.g:1216:79: (iv_ruleTechnologySpecificDataFieldTypeMapping= ruleTechnologySpecificDataFieldTypeMapping EOF )
            // InternalMappingDsl.g:1217:2: iv_ruleTechnologySpecificDataFieldTypeMapping= ruleTechnologySpecificDataFieldTypeMapping EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificDataFieldTypeMapping=ruleTechnologySpecificDataFieldTypeMapping();

            state._fsp--;

             current =iv_ruleTechnologySpecificDataFieldTypeMapping; 
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
    // $ANTLR end "entryRuleTechnologySpecificDataFieldTypeMapping"


    // $ANTLR start "ruleTechnologySpecificDataFieldTypeMapping"
    // InternalMappingDsl.g:1223:1: ruleTechnologySpecificDataFieldTypeMapping returns [EObject current=null] : ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )? ) ;
    public final EObject ruleTechnologySpecificDataFieldTypeMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_dataFieldHierarchy_0_0 = null;

        EObject lv_aspects_8_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1229:2: ( ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )? ) )
            // InternalMappingDsl.g:1230:2: ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )? )
            {
            // InternalMappingDsl.g:1230:2: ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )? )
            // InternalMappingDsl.g:1231:3: ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )?
            {
            // InternalMappingDsl.g:1231:3: ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) )
            // InternalMappingDsl.g:1232:4: (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy )
            {
            // InternalMappingDsl.g:1232:4: (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy )
            // InternalMappingDsl.g:1233:5: lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getDataFieldHierarchyDataFieldHierarchyParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_37);
            lv_dataFieldHierarchy_0_0=ruleDataFieldHierarchy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule());
            					}
            					set(
            						current,
            						"dataFieldHierarchy",
            						lv_dataFieldHierarchy_0_0,
            						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.DataFieldHierarchy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getColonKeyword_1());
            		
            // InternalMappingDsl.g:1254:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:1255:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:1255:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:1256:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getTechnologyImportCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getColonColonKeyword_3());
            		
            // InternalMappingDsl.g:1271:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1272:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1272:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1273:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getTypeTypeCrossReference_4_0());
            				
            pushFollow(FOLLOW_33);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1287:3: (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==17) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalMappingDsl.g:1288:4: otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_34); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getAspectsKeyword_5_1());
                    			
                    otherlv_7=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getLeftCurlyBracketKeyword_5_2());
                    			
                    // InternalMappingDsl.g:1300:4: ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt45=0;
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_ID) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1301:5: (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1301:5: (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1302:6: lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_aspects_8_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_8_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_9=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getRightCurlyBracketKeyword_5_4());
                    			
                    otherlv_10=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getRightCurlyBracketKeyword_5_5());
                    			

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
    // $ANTLR end "ruleTechnologySpecificDataFieldTypeMapping"


    // $ANTLR start "entryRuleDataFieldHierarchy"
    // InternalMappingDsl.g:1332:1: entryRuleDataFieldHierarchy returns [EObject current=null] : iv_ruleDataFieldHierarchy= ruleDataFieldHierarchy EOF ;
    public final EObject entryRuleDataFieldHierarchy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFieldHierarchy = null;


        try {
            // InternalMappingDsl.g:1332:59: (iv_ruleDataFieldHierarchy= ruleDataFieldHierarchy EOF )
            // InternalMappingDsl.g:1333:2: iv_ruleDataFieldHierarchy= ruleDataFieldHierarchy EOF
            {
             newCompositeNode(grammarAccess.getDataFieldHierarchyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataFieldHierarchy=ruleDataFieldHierarchy();

            state._fsp--;

             current =iv_ruleDataFieldHierarchy; 
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
    // $ANTLR end "entryRuleDataFieldHierarchy"


    // $ANTLR start "ruleDataFieldHierarchy"
    // InternalMappingDsl.g:1339:1: ruleDataFieldHierarchy returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleDataFieldHierarchy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1345:2: ( ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalMappingDsl.g:1346:2: ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalMappingDsl.g:1346:2: ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalMappingDsl.g:1347:3: ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalMappingDsl.g:1347:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1348:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1348:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1349:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataFieldHierarchyRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_0, grammarAccess.getDataFieldHierarchyAccess().getDataFieldsDataFieldCrossReference_0_0());
            				

            }


            }

            // InternalMappingDsl.g:1360:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==32) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMappingDsl.g:1361:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalMappingDsl.g:1361:4: ()
            	    // InternalMappingDsl.g:1362:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getDataFieldHierarchyAccess().getDataFieldHierarchyPreviousAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDataFieldHierarchyAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalMappingDsl.g:1372:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:1373:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:1373:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:1374:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDataFieldHierarchyRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						newLeafNode(otherlv_3, grammarAccess.getDataFieldHierarchyAccess().getDataFieldsDataFieldCrossReference_1_2_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleDataFieldHierarchy"


    // $ANTLR start "entryRuleImportedMicroservice"
    // InternalMappingDsl.g:1390:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:1390:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalMappingDsl.g:1391:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
            {
             newCompositeNode(grammarAccess.getImportedMicroserviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedMicroservice=ruleImportedMicroservice();

            state._fsp--;

             current =iv_ruleImportedMicroservice; 
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
    // $ANTLR end "entryRuleImportedMicroservice"


    // $ANTLR start "ruleImportedMicroservice"
    // InternalMappingDsl.g:1397:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1403:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalMappingDsl.g:1404:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalMappingDsl.g:1404:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalMappingDsl.g:1405:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalMappingDsl.g:1405:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1406:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1406:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1407:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1422:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:1423:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:1423:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:1424:5: ruleQualifiedNameWithAtLeastOneLevel
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedMicroserviceAccess().getMicroserviceMicroserviceCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedNameWithAtLeastOneLevel();

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
    // $ANTLR end "ruleImportedMicroservice"


    // $ANTLR start "entryRuleTechnologySpecificProtocolSpecification"
    // InternalMappingDsl.g:1442:1: entryRuleTechnologySpecificProtocolSpecification returns [EObject current=null] : iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF ;
    public final EObject entryRuleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:1442:80: (iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF )
            // InternalMappingDsl.g:1443:2: iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificProtocolSpecification=ruleTechnologySpecificProtocolSpecification();

            state._fsp--;

             current =iv_ruleTechnologySpecificProtocolSpecification; 
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
    // $ANTLR end "entryRuleTechnologySpecificProtocolSpecification"


    // $ANTLR start "ruleTechnologySpecificProtocolSpecification"
    // InternalMappingDsl.g:1449:1: ruleTechnologySpecificProtocolSpecification returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) ;
    public final EObject ruleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_communicationType_0_0 = null;

        EObject lv_technologySpecificProtocol_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1455:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) )
            // InternalMappingDsl.g:1456:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            {
            // InternalMappingDsl.g:1456:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            // InternalMappingDsl.g:1457:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            {
            // InternalMappingDsl.g:1457:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:1458:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:1458:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:1459:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_37);
            lv_communicationType_0_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_0_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getColonKeyword_1());
            		
            // InternalMappingDsl.g:1480:3: ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1481:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1481:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1482:5: lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getTechnologySpecificProtocolTechnologySpecificProtocolParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_technologySpecificProtocol_2_0=ruleTechnologySpecificProtocol();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"technologySpecificProtocol",
            						lv_technologySpecificProtocol_2_0,
            						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocol");
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
    // $ANTLR end "ruleTechnologySpecificProtocolSpecification"


    // $ANTLR start "entryRuleTechnologySpecificProtocol"
    // InternalMappingDsl.g:1503:1: entryRuleTechnologySpecificProtocol returns [EObject current=null] : iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF ;
    public final EObject entryRuleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocol = null;


        try {
            // InternalMappingDsl.g:1503:67: (iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF )
            // InternalMappingDsl.g:1504:2: iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificProtocolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificProtocol=ruleTechnologySpecificProtocol();

            state._fsp--;

             current =iv_ruleTechnologySpecificProtocol; 
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
    // $ANTLR end "entryRuleTechnologySpecificProtocol"


    // $ANTLR start "ruleTechnologySpecificProtocol"
    // InternalMappingDsl.g:1510:1: ruleTechnologySpecificProtocol returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1516:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:1517:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:1517:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:1518:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:1518:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1519:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1519:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1520:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificProtocolAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1535:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1536:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1536:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1537:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_39);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1551:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==33) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalMappingDsl.g:1552:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificProtocolAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:1556:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:1557:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:1557:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:1558:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificProtocolAccess().getDataFormatDataFormatCrossReference_3_1_0());
                    					

                    }


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
    // $ANTLR end "ruleTechnologySpecificProtocol"


    // $ANTLR start "entryRuleTechnologySpecificEndpoint"
    // InternalMappingDsl.g:1574:1: entryRuleTechnologySpecificEndpoint returns [EObject current=null] : iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF ;
    public final EObject entryRuleTechnologySpecificEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificEndpoint = null;


        try {
            // InternalMappingDsl.g:1574:67: (iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF )
            // InternalMappingDsl.g:1575:2: iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificEndpointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificEndpoint=ruleTechnologySpecificEndpoint();

            state._fsp--;

             current =iv_ruleTechnologySpecificEndpoint; 
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
    // $ANTLR end "entryRuleTechnologySpecificEndpoint"


    // $ANTLR start "ruleTechnologySpecificEndpoint"
    // InternalMappingDsl.g:1581:1: ruleTechnologySpecificEndpoint returns [EObject current=null] : ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
    public final EObject ruleTechnologySpecificEndpoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_addresses_4_0=null;
        Token otherlv_5=null;
        Token lv_addresses_6_0=null;
        Token otherlv_7=null;
        EObject lv_technologySpecificProtocols_0_0 = null;

        EObject lv_technologySpecificProtocols_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1587:2: ( ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:1588:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:1588:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:1589:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:1589:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1590:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1590:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1591:5: lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
            lv_technologySpecificProtocols_0_0=ruleTechnologySpecificProtocol();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificEndpointRule());
            					}
            					add(
            						current,
            						"technologySpecificProtocols",
            						lv_technologySpecificProtocols_0_0,
            						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocol");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1608:3: (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==25) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalMappingDsl.g:1609:4: otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:1613:4: ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    // InternalMappingDsl.g:1614:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    {
            	    // InternalMappingDsl.g:1614:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    // InternalMappingDsl.g:1615:6: lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol
            	    {

            	    						newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_technologySpecificProtocols_2_0=ruleTechnologySpecificProtocol();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTechnologySpecificEndpointRule());
            	    						}
            	    						add(
            	    							current,
            	    							"technologySpecificProtocols",
            	    							lv_technologySpecificProtocols_2_0,
            	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificProtocol");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:1637:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:1638:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:1638:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:1639:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getTechnologySpecificEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMappingDsl.g:1655:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==25) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalMappingDsl.g:1656:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_41); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:1660:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:1661:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:1661:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:1662:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getTechnologySpecificEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTechnologySpecificEndpointRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"addresses",
            	    							lv_addresses_6_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_7=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificEndpointAccess().getSemicolonKeyword_5());
            		

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
    // $ANTLR end "ruleTechnologySpecificEndpoint"


    // $ANTLR start "entryRuleTechnologySpecificImportedServiceAspect"
    // InternalMappingDsl.g:1687:1: entryRuleTechnologySpecificImportedServiceAspect returns [EObject current=null] : iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF ;
    public final EObject entryRuleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:1687:80: (iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF )
            // InternalMappingDsl.g:1688:2: iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificImportedServiceAspect=ruleTechnologySpecificImportedServiceAspect();

            state._fsp--;

             current =iv_ruleTechnologySpecificImportedServiceAspect; 
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
    // $ANTLR end "entryRuleTechnologySpecificImportedServiceAspect"


    // $ANTLR start "ruleTechnologySpecificImportedServiceAspect"
    // InternalMappingDsl.g:1694:1: ruleTechnologySpecificImportedServiceAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' ) | otherlv_7= ';' ) ) ;
    public final EObject ruleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_singlePropertyValue_4_0 = null;

        EObject lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1700:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' ) | otherlv_7= ';' ) ) )
            // InternalMappingDsl.g:1701:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' ) | otherlv_7= ';' ) )
            {
            // InternalMappingDsl.g:1701:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' ) | otherlv_7= ';' ) )
            // InternalMappingDsl.g:1702:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' ) | otherlv_7= ';' )
            {
            // InternalMappingDsl.g:1702:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1703:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1703:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1704:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1719:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1720:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1720:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1721:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getAspectServiceAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_43);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1735:3: ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' ) | otherlv_7= ';' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==15) ) {
                alt52=1;
            }
            else if ( (LA52_0==34) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalMappingDsl.g:1736:4: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' )
                    {
                    // InternalMappingDsl.g:1736:4: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')' )
                    // InternalMappingDsl.g:1737:5: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) ) otherlv_6= ')'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_44); 

                    					newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getLeftParenthesisKeyword_3_0_0());
                    				
                    // InternalMappingDsl.g:1741:5: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( (lv_values_5_0= rulePropertyValueAssignment ) ) )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_BOOLEAN)) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==RULE_ID) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalMappingDsl.g:1742:6: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:1742:6: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:1743:7: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:1743:7: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:1744:8: lv_singlePropertyValue_4_0= rulePrimitiveValue
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_3_0_1_0_0());
                            							
                            pushFollow(FOLLOW_8);
                            lv_singlePropertyValue_4_0=rulePrimitiveValue();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            								}
                            								set(
                            									current,
                            									"singlePropertyValue",
                            									lv_singlePropertyValue_4_0,
                            									"de.fhdo.ddmm.data.DataDsl.PrimitiveValue");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1762:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            {
                            // InternalMappingDsl.g:1762:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:1763:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:1763:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:1764:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_0_1_1_0());
                            							
                            pushFollow(FOLLOW_8);
                            lv_values_5_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_5_0,
                            									"de.fhdo.ddmm.ServiceDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getRightParenthesisKeyword_3_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1788:4: otherlv_7= ';'
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSemicolonKeyword_3_1());
                    			

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
    // $ANTLR end "ruleTechnologySpecificImportedServiceAspect"


    // $ANTLR start "entryRuleImport"
    // InternalMappingDsl.g:1797:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMappingDsl.g:1797:47: (iv_ruleImport= ruleImport EOF )
            // InternalMappingDsl.g:1798:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalMappingDsl.g:1804:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Enumerator lv_importType_1_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1810:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:1811:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:1811:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:1812:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMappingDsl.g:1816:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalMappingDsl.g:1817:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalMappingDsl.g:1817:4: (lv_importType_1_0= ruleImportType )
            // InternalMappingDsl.g:1818:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_46);
            lv_importType_1_0=ruleImportType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importType",
            						lv_importType_1_0,
            						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ImportType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,36,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:1839:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:1840:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:1840:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:1841:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:1861:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:1862:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:1862:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:1863:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_5_0, grammarAccess.getImportAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMicroservice"
    // InternalMappingDsl.g:1883:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalMappingDsl.g:1883:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalMappingDsl.g:1884:2: iv_ruleMicroservice= ruleMicroservice EOF
            {
             newCompositeNode(grammarAccess.getMicroserviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMicroservice=ruleMicroservice();

            state._fsp--;

             current =iv_ruleMicroservice; 
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
    // $ANTLR end "entryRuleMicroservice"


    // $ANTLR start "ruleMicroservice"
    // InternalMappingDsl.g:1890:1: ruleMicroservice returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) ;
    public final EObject ruleMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_version_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        EObject lv_protocols_5_0 = null;

        EObject lv_protocols_6_0 = null;

        EObject lv_endpoints_10_0 = null;

        EObject lv_aspects_12_0 = null;

        Enumerator lv_visibility_13_0 = null;

        Enumerator lv_type_14_0 = null;

        AntlrDatatypeRuleToken lv_name_16_0 = null;

        EObject lv_requiredMicroservices_23_0 = null;

        EObject lv_requiredMicroservices_25_0 = null;

        EObject lv_requiredInterfaces_30_0 = null;

        EObject lv_requiredInterfaces_32_0 = null;

        EObject lv_requiredOperations_37_0 = null;

        EObject lv_requiredOperations_39_0 = null;

        EObject lv_interfaces_41_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1896:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) )
            // InternalMappingDsl.g:1897:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            {
            // InternalMappingDsl.g:1897:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            // InternalMappingDsl.g:1898:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}'
            {
            // InternalMappingDsl.g:1898:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==13) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==14) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalMappingDsl.g:1899:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMicroserviceAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalMappingDsl.g:1911:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:1912:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:1912:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:1913:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMicroserviceRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_48); 

            	    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_0_4());
            	    			

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // InternalMappingDsl.g:1929:3: ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==13) ) {
                int LA55_1 = input.LA(2);

                if ( ((LA55_1>=94 && LA55_1<=95)) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalMappingDsl.g:1930:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:1930:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:1931:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:1931:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:1932:6: lv_protocols_5_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_48);
                    lv_protocols_5_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_5_0,
                    							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:1949:4: ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==13) ) {
                        int LA54_1 = input.LA(2);

                        if ( ((LA54_1>=94 && LA54_1<=95)) ) {
                            alt54=1;
                        }
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalMappingDsl.g:1950:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:1950:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:1951:6: lv_protocols_6_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_48);
                            lv_protocols_6_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_6_0,
                            							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:1969:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==13) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==20) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalMappingDsl.g:1970:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_49); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMappingDsl.g:1982:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
                    int cnt56=0;
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==RULE_ID) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1983:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:1983:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:1984:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_endpoints_10_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_10_0,
                    	    							"de.fhdo.ddmm.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt56 >= 1 ) break loop56;
                                EarlyExitException eee =
                                    new EarlyExitException(56, input);
                                throw eee;
                        }
                        cnt56++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_48); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2006:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==13) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalMappingDsl.g:2007:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2007:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2008:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_aspects_12_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_12_0,
            	    						"de.fhdo.ddmm.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            // InternalMappingDsl.g:2025:3: ( (lv_visibility_13_0= ruleVisibility ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=85 && LA59_0<=87)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMappingDsl.g:2026:4: (lv_visibility_13_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2026:4: (lv_visibility_13_0= ruleVisibility )
                    // InternalMappingDsl.g:2027:5: lv_visibility_13_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_48);
                    lv_visibility_13_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_13_0,
                    						"de.fhdo.ddmm.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2044:3: ( (lv_type_14_0= ruleMicroserviceType ) )
            // InternalMappingDsl.g:2045:4: (lv_type_14_0= ruleMicroserviceType )
            {
            // InternalMappingDsl.g:2045:4: (lv_type_14_0= ruleMicroserviceType )
            // InternalMappingDsl.g:2046:5: lv_type_14_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_51);
            lv_type_14_0=ruleMicroserviceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_14_0,
            						"de.fhdo.ddmm.ServiceDsl.MicroserviceType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_6());
            		
            // InternalMappingDsl.g:2067:3: ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:2068:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:2068:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:2069:5: lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_52);
            lv_name_16_0=ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_16_0,
            						"de.fhdo.ddmm.ServiceDsl.QualifiedNameWithAtLeastOneLevel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:2086:3: (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==39) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalMappingDsl.g:2087:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalMappingDsl.g:2091:4: ( (lv_version_18_0= RULE_ID ) )
                    // InternalMappingDsl.g:2092:5: (lv_version_18_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2092:5: (lv_version_18_0= RULE_ID )
                    // InternalMappingDsl.g:2093:6: lv_version_18_0= RULE_ID
                    {
                    lv_version_18_0=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(lv_version_18_0, grammarAccess.getMicroserviceAccess().getVersionIDTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMicroserviceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"version",
                    							lv_version_18_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,17,FOLLOW_53); 

            			newLeafNode(otherlv_19, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalMappingDsl.g:2114:3: (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==40) ) {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==41) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // InternalMappingDsl.g:2115:4: otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}'
                    {
                    otherlv_20=(Token)match(input,40,FOLLOW_54); 

                    				newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_21=(Token)match(input,41,FOLLOW_10); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_22=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalMappingDsl.g:2127:4: ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) )
                    // InternalMappingDsl.g:2128:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalMappingDsl.g:2128:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    // InternalMappingDsl.g:2129:6: lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_requiredMicroservices_23_0=rulePossiblyImportedMicroservice();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredMicroservices",
                    							lv_requiredMicroservices_23_0,
                    							"de.fhdo.ddmm.ServiceDsl.PossiblyImportedMicroservice");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2146:4: (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==25) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2147:5: otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_24=(Token)match(input,25,FOLLOW_7); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2151:5: ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalMappingDsl.g:2152:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalMappingDsl.g:2152:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    // InternalMappingDsl.g:2153:7: lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
                    	    lv_requiredMicroservices_25_0=rulePossiblyImportedMicroservice();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredMicroservices",
                    	    								lv_requiredMicroservices_25_0,
                    	    								"de.fhdo.ddmm.ServiceDsl.PossiblyImportedMicroservice");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,19,FOLLOW_53); 

                    				newLeafNode(otherlv_26, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2176:3: (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==40) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==42) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalMappingDsl.g:2177:4: otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}'
                    {
                    otherlv_27=(Token)match(input,40,FOLLOW_55); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_28=(Token)match(input,42,FOLLOW_10); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_29=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalMappingDsl.g:2189:4: ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) )
                    // InternalMappingDsl.g:2190:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    {
                    // InternalMappingDsl.g:2190:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    // InternalMappingDsl.g:2191:6: lv_requiredInterfaces_30_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_requiredInterfaces_30_0=rulePossiblyImportedInterface();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredInterfaces",
                    							lv_requiredInterfaces_30_0,
                    							"de.fhdo.ddmm.ServiceDsl.PossiblyImportedInterface");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2208:4: (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==25) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2209:5: otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_31=(Token)match(input,25,FOLLOW_7); 

                    	    					newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2213:5: ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    // InternalMappingDsl.g:2214:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalMappingDsl.g:2214:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    // InternalMappingDsl.g:2215:7: lv_requiredInterfaces_32_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
                    	    lv_requiredInterfaces_32_0=rulePossiblyImportedInterface();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredInterfaces",
                    	    								lv_requiredInterfaces_32_0,
                    	    								"de.fhdo.ddmm.ServiceDsl.PossiblyImportedInterface");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,19,FOLLOW_53); 

                    				newLeafNode(otherlv_33, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2238:3: (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==40) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalMappingDsl.g:2239:4: otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}'
                    {
                    otherlv_34=(Token)match(input,40,FOLLOW_56); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_35=(Token)match(input,43,FOLLOW_10); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_36=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalMappingDsl.g:2251:4: ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:2252:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:2252:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:2253:6: lv_requiredOperations_37_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_requiredOperations_37_0=rulePossiblyImportedOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredOperations",
                    							lv_requiredOperations_37_0,
                    							"de.fhdo.ddmm.ServiceDsl.PossiblyImportedOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2270:4: (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==25) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2271:5: otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_38=(Token)match(input,25,FOLLOW_7); 

                    	    					newLeafNode(otherlv_38, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2275:5: ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    // InternalMappingDsl.g:2276:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalMappingDsl.g:2276:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    // InternalMappingDsl.g:2277:7: lv_requiredOperations_39_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
                    	    lv_requiredOperations_39_0=rulePossiblyImportedOperation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredOperations",
                    	    								lv_requiredOperations_39_0,
                    	    								"de.fhdo.ddmm.ServiceDsl.PossiblyImportedOperation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_40=(Token)match(input,19,FOLLOW_53); 

                    				newLeafNode(otherlv_40, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2300:3: ( (lv_interfaces_41_0= ruleInterface ) )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==13||LA67_0==22||LA67_0==44||(LA67_0>=85 && LA67_0<=87)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalMappingDsl.g:2301:4: (lv_interfaces_41_0= ruleInterface )
            	    {
            	    // InternalMappingDsl.g:2301:4: (lv_interfaces_41_0= ruleInterface )
            	    // InternalMappingDsl.g:2302:5: lv_interfaces_41_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_57);
            	    lv_interfaces_41_0=ruleInterface();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"interfaces",
            	    						lv_interfaces_41_0,
            	    						"de.fhdo.ddmm.ServiceDsl.Interface");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
            } while (true);

            otherlv_42=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_42, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_14());
            		

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
    // $ANTLR end "ruleMicroservice"


    // $ANTLR start "entryRulePossiblyImportedMicroservice"
    // InternalMappingDsl.g:2327:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:2327:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalMappingDsl.g:2328:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
            {
             newCompositeNode(grammarAccess.getPossiblyImportedMicroserviceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePossiblyImportedMicroservice=rulePossiblyImportedMicroservice();

            state._fsp--;

             current =iv_rulePossiblyImportedMicroservice; 
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
    // $ANTLR end "entryRulePossiblyImportedMicroservice"


    // $ANTLR start "rulePossiblyImportedMicroservice"
    // InternalMappingDsl.g:2334:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2340:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2341:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2341:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2342:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2342:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==29) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalMappingDsl.g:2343:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2343:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2344:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2344:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2345:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2361:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2362:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2362:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2363:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPossiblyImportedMicroserviceAccess().getMicroserviceMicroserviceCrossReference_1_0());
            				
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
    // $ANTLR end "rulePossiblyImportedMicroservice"


    // $ANTLR start "entryRulePossiblyImportedInterface"
    // InternalMappingDsl.g:2381:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalMappingDsl.g:2381:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalMappingDsl.g:2382:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
            {
             newCompositeNode(grammarAccess.getPossiblyImportedInterfaceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePossiblyImportedInterface=rulePossiblyImportedInterface();

            state._fsp--;

             current =iv_rulePossiblyImportedInterface; 
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
    // $ANTLR end "entryRulePossiblyImportedInterface"


    // $ANTLR start "rulePossiblyImportedInterface"
    // InternalMappingDsl.g:2388:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2394:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2395:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2395:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2396:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2396:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==29) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalMappingDsl.g:2397:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2397:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2398:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2398:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2399:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2415:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2416:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2416:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2417:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPossiblyImportedInterfaceAccess().getInterfaceInterfaceCrossReference_1_0());
            				
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
    // $ANTLR end "rulePossiblyImportedInterface"


    // $ANTLR start "entryRulePossiblyImportedOperation"
    // InternalMappingDsl.g:2435:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalMappingDsl.g:2435:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalMappingDsl.g:2436:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
            {
             newCompositeNode(grammarAccess.getPossiblyImportedOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePossiblyImportedOperation=rulePossiblyImportedOperation();

            state._fsp--;

             current =iv_rulePossiblyImportedOperation; 
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
    // $ANTLR end "entryRulePossiblyImportedOperation"


    // $ANTLR start "rulePossiblyImportedOperation"
    // InternalMappingDsl.g:2442:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2448:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2449:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2449:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2450:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2450:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==29) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalMappingDsl.g:2451:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2451:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2452:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2452:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2453:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2469:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2470:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2470:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2471:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPossiblyImportedOperationAccess().getOperationOperationCrossReference_1_0());
            				
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
    // $ANTLR end "rulePossiblyImportedOperation"


    // $ANTLR start "entryRuleInterface"
    // InternalMappingDsl.g:2489:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalMappingDsl.g:2489:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalMappingDsl.g:2490:2: iv_ruleInterface= ruleInterface EOF
            {
             newCompositeNode(grammarAccess.getInterfaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterface=ruleInterface();

            state._fsp--;

             current =iv_ruleInterface; 
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
    // $ANTLR end "entryRuleInterface"


    // $ANTLR start "ruleInterface"
    // InternalMappingDsl.g:2496:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) ;
    public final EObject ruleInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_notImplemented_8_0=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_endpoints_5_0 = null;

        EObject lv_aspects_7_0 = null;

        Enumerator lv_visibility_9_0 = null;

        EObject lv_referredOperations_13_0 = null;

        EObject lv_operations_14_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:2502:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) )
            // InternalMappingDsl.g:2503:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            {
            // InternalMappingDsl.g:2503:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            // InternalMappingDsl.g:2504:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}'
            {
            // InternalMappingDsl.g:2504:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==13) ) {
                int LA72_1 = input.LA(2);

                if ( ((LA72_1>=94 && LA72_1<=95)) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalMappingDsl.g:2505:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2505:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2506:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2506:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2507:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_protocols_0_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_0_0,
                    							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2524:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==13) ) {
                        int LA71_1 = input.LA(2);

                        if ( ((LA71_1>=94 && LA71_1<=95)) ) {
                            alt71=1;
                        }
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalMappingDsl.g:2525:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2525:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2526:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_58);
                            lv_protocols_1_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_1_0,
                            							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2544:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==13) ) {
                int LA74_1 = input.LA(2);

                if ( (LA74_1==20) ) {
                    alt74=1;
                }
            }
            switch (alt74) {
                case 1 :
                    // InternalMappingDsl.g:2545:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_49); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2557:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==RULE_ID) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2558:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2558:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2559:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_endpoints_5_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_5_0,
                    	    							"de.fhdo.ddmm.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_58); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2581:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==13) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalMappingDsl.g:2582:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2582:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2583:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_58);
            	    lv_aspects_7_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_7_0,
            	    						"de.fhdo.ddmm.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            // InternalMappingDsl.g:2600:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==44) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalMappingDsl.g:2601:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:2601:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:2602:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,44,FOLLOW_59); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2614:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=85 && LA77_0<=87)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalMappingDsl.g:2615:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2615:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2616:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_60);
                    lv_visibility_9_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_9_0,
                    						"de.fhdo.ddmm.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_10, grammarAccess.getInterfaceAccess().getInterfaceKeyword_5());
            		
            // InternalMappingDsl.g:2637:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalMappingDsl.g:2638:4: (lv_name_11_0= RULE_ID )
            {
            // InternalMappingDsl.g:2638:4: (lv_name_11_0= RULE_ID )
            // InternalMappingDsl.g:2639:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_11_0, grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_11_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_12=(Token)match(input,17,FOLLOW_61); 

            			newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMappingDsl.g:2659:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*
            loop78:
            do {
                int alt78=2;
                alt78 = dfa78.predict(input);
                switch (alt78) {
            	case 1 :
            	    // InternalMappingDsl.g:2660:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    {
            	    // InternalMappingDsl.g:2660:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    // InternalMappingDsl.g:2661:5: lv_referredOperations_13_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_61);
            	    lv_referredOperations_13_0=ruleReferredOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referredOperations",
            	    						lv_referredOperations_13_0,
            	    						"de.fhdo.ddmm.ServiceDsl.ReferredOperation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // InternalMappingDsl.g:2678:3: ( (lv_operations_14_0= ruleOperation ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_ID||LA79_0==13||LA79_0==44||(LA79_0>=85 && LA79_0<=87)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalMappingDsl.g:2679:4: (lv_operations_14_0= ruleOperation )
            	    {
            	    // InternalMappingDsl.g:2679:4: (lv_operations_14_0= ruleOperation )
            	    // InternalMappingDsl.g:2680:5: lv_operations_14_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_62);
            	    lv_operations_14_0=ruleOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operations",
            	    						lv_operations_14_0,
            	    						"de.fhdo.ddmm.ServiceDsl.Operation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            otherlv_15=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleInterface"


    // $ANTLR start "entryRuleOperation"
    // InternalMappingDsl.g:2705:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMappingDsl.g:2705:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMappingDsl.g:2706:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalMappingDsl.g:2712:1: ruleOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_notImplemented_8_0=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_endpoints_5_0 = null;

        EObject lv_aspects_7_0 = null;

        Enumerator lv_visibility_9_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_parameters_14_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:2718:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) )
            // InternalMappingDsl.g:2719:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            {
            // InternalMappingDsl.g:2719:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            // InternalMappingDsl.g:2720:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';'
            {
            // InternalMappingDsl.g:2720:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==13) ) {
                int LA81_1 = input.LA(2);

                if ( ((LA81_1>=94 && LA81_1<=95)) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // InternalMappingDsl.g:2721:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2721:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2722:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2722:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2723:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_63);
                    lv_protocols_0_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_0_0,
                    							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2740:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==13) ) {
                        int LA80_1 = input.LA(2);

                        if ( ((LA80_1>=94 && LA80_1<=95)) ) {
                            alt80=1;
                        }
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalMappingDsl.g:2741:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2741:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2742:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_63);
                            lv_protocols_1_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getOperationRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_1_0,
                            							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2760:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==13) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==20) ) {
                    alt83=1;
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalMappingDsl.g:2761:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_49); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2773:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt82=0;
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==RULE_ID) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2774:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2774:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2775:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_endpoints_5_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_5_0,
                    	    							"de.fhdo.ddmm.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt82 >= 1 ) break loop82;
                                EarlyExitException eee =
                                    new EarlyExitException(82, input);
                                throw eee;
                        }
                        cnt82++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_63); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2797:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==13) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalMappingDsl.g:2798:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2798:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2799:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_63);
            	    lv_aspects_7_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_7_0,
            	    						"de.fhdo.ddmm.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            // InternalMappingDsl.g:2816:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==44) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalMappingDsl.g:2817:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:2817:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:2818:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,44,FOLLOW_64); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2830:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( ((LA86_0>=85 && LA86_0<=87)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalMappingDsl.g:2831:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2831:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2832:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_visibility_9_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_9_0,
                    						"de.fhdo.ddmm.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2849:3: ( (lv_name_10_0= RULE_ID ) )
            // InternalMappingDsl.g:2850:4: (lv_name_10_0= RULE_ID )
            {
            // InternalMappingDsl.g:2850:4: (lv_name_10_0= RULE_ID )
            // InternalMappingDsl.g:2851:5: lv_name_10_0= RULE_ID
            {
            lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_10_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_10_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_11=(Token)match(input,15,FOLLOW_65); 

            			newLeafNode(otherlv_11, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_6());
            		
            // InternalMappingDsl.g:2871:3: ( (lv_parameters_12_0= ruleParameter ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==13||(LA87_0>=94 && LA87_0<=95)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalMappingDsl.g:2872:4: (lv_parameters_12_0= ruleParameter )
                    {
                    // InternalMappingDsl.g:2872:4: (lv_parameters_12_0= ruleParameter )
                    // InternalMappingDsl.g:2873:5: lv_parameters_12_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_66);
                    lv_parameters_12_0=ruleParameter();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					add(
                    						current,
                    						"parameters",
                    						lv_parameters_12_0,
                    						"de.fhdo.ddmm.ServiceDsl.Parameter");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2890:3: (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==25) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalMappingDsl.g:2891:4: otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) )
            	    {
            	    otherlv_13=(Token)match(input,25,FOLLOW_67); 

            	    				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMappingDsl.g:2895:4: ( (lv_parameters_14_0= ruleParameter ) )
            	    // InternalMappingDsl.g:2896:5: (lv_parameters_14_0= ruleParameter )
            	    {
            	    // InternalMappingDsl.g:2896:5: (lv_parameters_14_0= ruleParameter )
            	    // InternalMappingDsl.g:2897:6: lv_parameters_14_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_66);
            	    lv_parameters_14_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_14_0,
            	    							"de.fhdo.ddmm.ServiceDsl.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            otherlv_15=(Token)match(input,16,FOLLOW_68); 

            			newLeafNode(otherlv_15, grammarAccess.getOperationAccess().getRightParenthesisKeyword_9());
            		
            otherlv_16=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getOperationAccess().getSemicolonKeyword_10());
            		

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleReferredOperation"
    // InternalMappingDsl.g:2927:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalMappingDsl.g:2927:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalMappingDsl.g:2928:2: iv_ruleReferredOperation= ruleReferredOperation EOF
            {
             newCompositeNode(grammarAccess.getReferredOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferredOperation=ruleReferredOperation();

            state._fsp--;

             current =iv_ruleReferredOperation; 
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
    // $ANTLR end "entryRuleReferredOperation"


    // $ANTLR start "ruleReferredOperation"
    // InternalMappingDsl.g:2934:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
    public final EObject ruleReferredOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_endpoints_5_0 = null;

        EObject lv_aspects_7_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:2940:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalMappingDsl.g:2941:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalMappingDsl.g:2941:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalMappingDsl.g:2942:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalMappingDsl.g:2942:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==13) ) {
                int LA90_1 = input.LA(2);

                if ( ((LA90_1>=94 && LA90_1<=95)) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalMappingDsl.g:2943:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2943:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2944:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2944:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2945:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_69);
                    lv_protocols_0_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_0_0,
                    							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2962:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==13) ) {
                        int LA89_1 = input.LA(2);

                        if ( ((LA89_1>=94 && LA89_1<=95)) ) {
                            alt89=1;
                        }
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalMappingDsl.g:2963:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2963:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2964:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_69);
                            lv_protocols_1_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_1_0,
                            							"de.fhdo.ddmm.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2982:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==13) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==20) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // InternalMappingDsl.g:2983:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_49); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2995:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt91=0;
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==RULE_ID) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2996:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2996:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2997:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_endpoints_5_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_5_0,
                    	    							"de.fhdo.ddmm.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt91 >= 1 ) break loop91;
                                EarlyExitException eee =
                                    new EarlyExitException(91, input);
                                throw eee;
                        }
                        cnt91++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_69); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3019:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==13) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalMappingDsl.g:3020:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3020:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3021:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_69);
            	    lv_aspects_7_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReferredOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_7_0,
            	    						"de.fhdo.ddmm.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            otherlv_8=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalMappingDsl.g:3042:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3043:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3043:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3044:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_68);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getReferredOperationAccess().getSemicolonKeyword_5());
            		

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
    // $ANTLR end "ruleReferredOperation"


    // $ANTLR start "entryRuleParameter"
    // InternalMappingDsl.g:3066:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMappingDsl.g:3066:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMappingDsl.g:3067:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalMappingDsl.g:3073:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_communicatesFault_3_0=null;
        Token lv_name_4_0=null;
        Token lv_optional_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_aspects_0_0 = null;

        Enumerator lv_communicationType_1_0 = null;

        Enumerator lv_exchangePattern_2_0 = null;

        EObject lv_primitiveType_7_0 = null;

        EObject lv_importedType_8_0 = null;

        EObject lv_initializedByOperation_10_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3079:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalMappingDsl.g:3080:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalMappingDsl.g:3080:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalMappingDsl.g:3081:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalMappingDsl.g:3081:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==13) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalMappingDsl.g:3082:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3082:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3083:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_67);
            	    lv_aspects_0_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParameterRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_0_0,
            	    						"de.fhdo.ddmm.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            // InternalMappingDsl.g:3100:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3101:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3101:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3102:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_70);
            lv_communicationType_1_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_1_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3119:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=91 && LA95_0<=93)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalMappingDsl.g:3120:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:3120:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:3121:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_71);
                    lv_exchangePattern_2_0=ruleExchangePattern();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterRule());
                    					}
                    					set(
                    						current,
                    						"exchangePattern",
                    						lv_exchangePattern_2_0,
                    						"de.fhdo.ddmm.technology.TechnologyDsl.ExchangePattern");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3138:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==46) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalMappingDsl.g:3139:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalMappingDsl.g:3139:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalMappingDsl.g:3140:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,46,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3152:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalMappingDsl.g:3153:4: (lv_name_4_0= RULE_ID )
            {
            // InternalMappingDsl.g:3153:4: (lv_name_4_0= RULE_ID )
            // InternalMappingDsl.g:3154:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_72); 

            					newLeafNode(lv_name_4_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMappingDsl.g:3170:3: ( (lv_optional_5_0= '?' ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==47) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalMappingDsl.g:3171:4: (lv_optional_5_0= '?' )
                    {
                    // InternalMappingDsl.g:3171:4: (lv_optional_5_0= '?' )
                    // InternalMappingDsl.g:3172:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,47,FOLLOW_37); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,28,FOLLOW_73); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalMappingDsl.g:3188:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( ((LA98_0>=75 && LA98_0<=84)) ) {
                alt98=1;
            }
            else if ( (LA98_0==RULE_ID) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalMappingDsl.g:3189:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:3189:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:3190:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:3190:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalMappingDsl.g:3191:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_74);
                    lv_primitiveType_7_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_7_0,
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:3209:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalMappingDsl.g:3209:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalMappingDsl.g:3210:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalMappingDsl.g:3210:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalMappingDsl.g:3211:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_74);
                    lv_importedType_8_0=ruleImportedType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"importedType",
                    							lv_importedType_8_0,
                    							"de.fhdo.ddmm.ServiceDsl.ImportedType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3229:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==48) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalMappingDsl.g:3230:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalMappingDsl.g:3234:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:3235:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:3235:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:3236:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getInitializedByOperationPossiblyImportedOperationParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_initializedByOperation_10_0=rulePossiblyImportedOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"initializedByOperation",
                    							lv_initializedByOperation_10_0,
                    							"de.fhdo.ddmm.ServiceDsl.PossiblyImportedOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleImportedType"
    // InternalMappingDsl.g:3258:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalMappingDsl.g:3258:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalMappingDsl.g:3259:2: iv_ruleImportedType= ruleImportedType EOF
            {
             newCompositeNode(grammarAccess.getImportedTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedType=ruleImportedType();

            state._fsp--;

             current =iv_ruleImportedType; 
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
    // $ANTLR end "entryRuleImportedType"


    // $ANTLR start "ruleImportedType"
    // InternalMappingDsl.g:3265:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3271:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:3272:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:3272:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:3273:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:3273:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3274:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3274:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3275:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3290:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3291:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3291:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3292:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedTypeAccess().getTypeTypeCrossReference_2_0());
            				
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
    // $ANTLR end "ruleImportedType"


    // $ANTLR start "entryRuleProtocolSpecification"
    // InternalMappingDsl.g:3310:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:3310:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalMappingDsl.g:3311:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
            {
             newCompositeNode(grammarAccess.getProtocolSpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProtocolSpecification=ruleProtocolSpecification();

            state._fsp--;

             current =iv_ruleProtocolSpecification; 
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
    // $ANTLR end "entryRuleProtocolSpecification"


    // $ANTLR start "ruleProtocolSpecification"
    // InternalMappingDsl.g:3317:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3323:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalMappingDsl.g:3324:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalMappingDsl.g:3324:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalMappingDsl.g:3325:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3329:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3330:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3330:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3331:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_communicationType_1_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_1_0,
            						"de.fhdo.ddmm.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:3352:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3353:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3353:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3354:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getProtocolImportedProtocolAndDataFormatParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_protocol_3_0=ruleImportedProtocolAndDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"protocol",
            						lv_protocol_3_0,
            						"de.fhdo.ddmm.ServiceDsl.ImportedProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getProtocolSpecificationAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleProtocolSpecification"


    // $ANTLR start "entryRuleImportedProtocolAndDataFormat"
    // InternalMappingDsl.g:3379:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalMappingDsl.g:3379:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalMappingDsl.g:3380:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
            {
             newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedProtocolAndDataFormat=ruleImportedProtocolAndDataFormat();

            state._fsp--;

             current =iv_ruleImportedProtocolAndDataFormat; 
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
    // $ANTLR end "entryRuleImportedProtocolAndDataFormat"


    // $ANTLR start "ruleImportedProtocolAndDataFormat"
    // InternalMappingDsl.g:3386:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3392:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:3393:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:3393:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:3394:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:3394:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3395:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3395:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3396:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3411:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3412:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3412:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3413:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_39);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3427:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==33) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalMappingDsl.g:3428:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:3432:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:3433:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:3433:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:3434:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_4, grammarAccess.getImportedProtocolAndDataFormatAccess().getDataFormatDataFormatCrossReference_3_1_0());
                    					

                    }


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
    // $ANTLR end "ruleImportedProtocolAndDataFormat"


    // $ANTLR start "entryRuleEndpoint"
    // InternalMappingDsl.g:3450:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalMappingDsl.g:3450:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalMappingDsl.g:3451:2: iv_ruleEndpoint= ruleEndpoint EOF
            {
             newCompositeNode(grammarAccess.getEndpointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndpoint=ruleEndpoint();

            state._fsp--;

             current =iv_ruleEndpoint; 
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
    // $ANTLR end "entryRuleEndpoint"


    // $ANTLR start "ruleEndpoint"
    // InternalMappingDsl.g:3457:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
    public final EObject ruleEndpoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_addresses_4_0=null;
        Token otherlv_5=null;
        Token lv_addresses_6_0=null;
        Token otherlv_7=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3463:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:3464:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:3464:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:3465:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:3465:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3466:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3466:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3467:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
            lv_protocols_0_0=ruleImportedProtocolAndDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEndpointRule());
            					}
            					add(
            						current,
            						"protocols",
            						lv_protocols_0_0,
            						"de.fhdo.ddmm.ServiceDsl.ImportedProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3484:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==25) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalMappingDsl.g:3485:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:3489:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalMappingDsl.g:3490:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalMappingDsl.g:3490:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalMappingDsl.g:3491:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_protocols_2_0=ruleImportedProtocolAndDataFormat();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEndpointRule());
            	    						}
            	    						add(
            	    							current,
            	    							"protocols",
            	    							lv_protocols_2_0,
            	    							"de.fhdo.ddmm.ServiceDsl.ImportedProtocolAndDataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:3513:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:3514:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:3514:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:3515:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMappingDsl.g:3531:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==25) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalMappingDsl.g:3532:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_41); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:3536:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:3537:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:3537:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:3538:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getEndpointRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"addresses",
            	    							lv_addresses_6_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            otherlv_7=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEndpointAccess().getSemicolonKeyword_5());
            		

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
    // $ANTLR end "ruleEndpoint"


    // $ANTLR start "entryRuleImportedServiceAspect"
    // InternalMappingDsl.g:3563:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:3563:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalMappingDsl.g:3564:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
            {
             newCompositeNode(grammarAccess.getImportedServiceAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedServiceAspect=ruleImportedServiceAspect();

            state._fsp--;

             current =iv_ruleImportedServiceAspect; 
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
    // $ANTLR end "entryRuleImportedServiceAspect"


    // $ANTLR start "ruleImportedServiceAspect"
    // InternalMappingDsl.g:3570:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
    public final EObject ruleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_singlePropertyValue_5_0 = null;

        EObject lv_values_6_0 = null;

        EObject lv_values_8_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3576:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalMappingDsl.g:3577:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalMappingDsl.g:3577:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalMappingDsl.g:3578:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3582:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:3583:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:3583:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:3584:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalMappingDsl.g:3599:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3600:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3600:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3601:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_75);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3615:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==15) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalMappingDsl.g:3616:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_44); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMappingDsl.g:3620:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( ((LA104_0>=RULE_STRING && LA104_0<=RULE_BOOLEAN)) ) {
                        alt104=1;
                    }
                    else if ( (LA104_0==RULE_ID) ) {
                        alt104=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 104, 0, input);

                        throw nvae;
                    }
                    switch (alt104) {
                        case 1 :
                            // InternalMappingDsl.g:3621:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:3621:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:3622:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:3622:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:3623:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_8);
                            lv_singlePropertyValue_5_0=rulePrimitiveValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            							}
                            							set(
                            								current,
                            								"singlePropertyValue",
                            								lv_singlePropertyValue_5_0,
                            								"de.fhdo.ddmm.data.DataDsl.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:3641:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:3641:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:3642:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:3642:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:3643:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:3643:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:3644:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_66);
                            lv_values_6_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_6_0,
                            									"de.fhdo.ddmm.ServiceDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalMappingDsl.g:3661:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop103:
                            do {
                                int alt103=2;
                                int LA103_0 = input.LA(1);

                                if ( (LA103_0==25) ) {
                                    alt103=1;
                                }


                                switch (alt103) {
                            	case 1 :
                            	    // InternalMappingDsl.g:3662:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_44); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:3666:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:3667:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:3667:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:3668:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_66);
                            	    lv_values_8_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_8_0,
                            	    										"de.fhdo.ddmm.ServiceDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop103;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getImportedServiceAspectAccess().getRightParenthesisKeyword_4_2());
                    			

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
    // $ANTLR end "ruleImportedServiceAspect"


    // $ANTLR start "entryRulePropertyValueAssignment"
    // InternalMappingDsl.g:3697:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalMappingDsl.g:3697:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalMappingDsl.g:3698:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyValueAssignment=rulePropertyValueAssignment();

            state._fsp--;

             current =iv_rulePropertyValueAssignment; 
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
    // $ANTLR end "entryRulePropertyValueAssignment"


    // $ANTLR start "rulePropertyValueAssignment"
    // InternalMappingDsl.g:3704:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject rulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3710:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalMappingDsl.g:3711:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalMappingDsl.g:3711:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalMappingDsl.g:3712:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalMappingDsl.g:3712:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3713:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3713:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3714:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_76); 

            					newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_77); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalMappingDsl.g:3729:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalMappingDsl.g:3730:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalMappingDsl.g:3730:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalMappingDsl.g:3731:5: lv_value_2_0= rulePrimitiveValue
            {

            					newCompositeNode(grammarAccess.getPropertyValueAssignmentAccess().getValuePrimitiveValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=rulePrimitiveValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropertyValueAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.fhdo.ddmm.data.DataDsl.PrimitiveValue");
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
    // $ANTLR end "rulePropertyValueAssignment"


    // $ANTLR start "entryRuleQualifiedNameWithAtLeastOneLevel"
    // InternalMappingDsl.g:3752:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalMappingDsl.g:3752:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalMappingDsl.g:3753:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithAtLeastOneLevelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithAtLeastOneLevel=ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;

             current =iv_ruleQualifiedNameWithAtLeastOneLevel.getText(); 
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
    // $ANTLR end "entryRuleQualifiedNameWithAtLeastOneLevel"


    // $ANTLR start "ruleQualifiedNameWithAtLeastOneLevel"
    // InternalMappingDsl.g:3759:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3765:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalMappingDsl.g:3766:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalMappingDsl.g:3766:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalMappingDsl.g:3767:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_78); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,32,FOLLOW_7); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getFullStopKeyword_1());
            		

            			newCompositeNode(grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getQualifiedNameParserRuleCall_2());
            		
            pushFollow(FOLLOW_2);
            this_QualifiedName_2=ruleQualifiedName();

            state._fsp--;


            			current.merge(this_QualifiedName_2);
            		

            			afterParserOrEnumRuleCall();
            		

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
    // $ANTLR end "ruleQualifiedNameWithAtLeastOneLevel"


    // $ANTLR start "entryRuleTechnologyImport"
    // InternalMappingDsl.g:3793:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalMappingDsl.g:3793:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalMappingDsl.g:3794:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalMappingDsl.g:3800:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:3806:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:3807:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:3807:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:3808:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_46); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:3820:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:3821:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:3821:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:3822:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

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

            otherlv_4=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:3842:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:3843:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:3843:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:3844:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:3864:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalMappingDsl.g:3864:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalMappingDsl.g:3865:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalMappingDsl.g:3871:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalMappingDsl.g:3877:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalMappingDsl.g:3878:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalMappingDsl.g:3878:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalMappingDsl.g:3879:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalMappingDsl.g:3879:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3880:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3880:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:3881:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            // InternalMappingDsl.g:3898:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:3899:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:3899:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:3900:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_79); 

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

            otherlv_2=(Token)match(input,49,FOLLOW_80); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalMappingDsl.g:3924:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalMappingDsl.g:3925:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalMappingDsl.g:3925:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalMappingDsl.g:3926:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_81);
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

            // InternalMappingDsl.g:3943:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==25) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // InternalMappingDsl.g:3944:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:3948:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalMappingDsl.g:3949:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalMappingDsl.g:3949:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalMappingDsl.g:3950:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_81);
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
            	    break loop106;
                }
            } while (true);

            // InternalMappingDsl.g:3968:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==51) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalMappingDsl.g:3969:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:3969:4: ( (lv_default_7_0= 'default' ) )
                    // InternalMappingDsl.g:3970:5: (lv_default_7_0= 'default' )
                    {
                    // InternalMappingDsl.g:3970:5: (lv_default_7_0= 'default' )
                    // InternalMappingDsl.g:3971:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,51,FOLLOW_82); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,52,FOLLOW_83); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalMappingDsl.g:3991:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMappingDsl.g:3992:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMappingDsl.g:3992:5: (otherlv_10= RULE_ID )
                    // InternalMappingDsl.g:3993:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_68); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:4013:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalMappingDsl.g:4013:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalMappingDsl.g:4014:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalMappingDsl.g:4020:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4026:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalMappingDsl.g:4027:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:4027:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4028:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4028:3: (lv_formatName_0_0= RULE_ID )
            // InternalMappingDsl.g:4029:4: lv_formatName_0_0= RULE_ID
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
    // InternalMappingDsl.g:4048:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalMappingDsl.g:4048:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalMappingDsl.g:4049:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalMappingDsl.g:4055:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:4061:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:4062:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:4062:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalMappingDsl.g:4063:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4071:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4072:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4072:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4073:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_85); 

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

            // InternalMappingDsl.g:4089:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==55) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalMappingDsl.g:4090:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_86); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,56,FOLLOW_87); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalMappingDsl.g:4098:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:4099:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:4099:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalMappingDsl.g:4100:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_81);
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

                    // InternalMappingDsl.g:4117:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==25) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4118:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,25,FOLLOW_87); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMappingDsl.g:4122:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalMappingDsl.g:4123:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalMappingDsl.g:4123:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalMappingDsl.g:4124:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_81);
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
                    	    break loop108;
                        }
                    } while (true);

                    // InternalMappingDsl.g:4142:4: ( (lv_default_8_0= 'default' ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==51) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalMappingDsl.g:4143:5: (lv_default_8_0= 'default' )
                            {
                            // InternalMappingDsl.g:4143:5: (lv_default_8_0= 'default' )
                            // InternalMappingDsl.g:4144:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,51,FOLLOW_68); 

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

            otherlv_9=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:4165:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalMappingDsl.g:4165:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalMappingDsl.g:4166:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalMappingDsl.g:4172:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4178:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4179:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4179:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4180:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4188:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4189:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4189:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4190:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_68); 

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

            otherlv_3=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:4214:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalMappingDsl.g:4214:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalMappingDsl.g:4215:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalMappingDsl.g:4221:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4227:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4228:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4228:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4229:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4237:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4238:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4238:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4239:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_68); 

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

            otherlv_3=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:4263:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalMappingDsl.g:4263:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalMappingDsl.g:4264:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalMappingDsl.g:4270:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4276:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:4277:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:4277:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:4278:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:4278:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==RULE_ID) ) {
                int LA111_1 = input.LA(2);

                if ( (LA111_1==29) ) {
                    alt111=1;
                }
            }
            switch (alt111) {
                case 1 :
                    // InternalMappingDsl.g:4279:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:4279:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:4280:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:4280:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:4281:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:4297:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4298:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4298:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4299:5: ruleQualifiedName
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
    // InternalMappingDsl.g:4317:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalMappingDsl.g:4317:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalMappingDsl.g:4318:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalMappingDsl.g:4324:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:4330:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalMappingDsl.g:4331:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4331:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalMappingDsl.g:4332:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalMappingDsl.g:4332:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4333:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4333:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4334:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_88);
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

            // InternalMappingDsl.g:4351:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==25) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // InternalMappingDsl.g:4352:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:4356:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalMappingDsl.g:4357:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalMappingDsl.g:4357:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalMappingDsl.g:4358:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_88);
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
            	    break loop112;
                }
            } while (true);

            // InternalMappingDsl.g:4376:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalMappingDsl.g:4377:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalMappingDsl.g:4377:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalMappingDsl.g:4378:5: lv_direction_3_0= ruleCompatibilityDirection
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
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

            // InternalMappingDsl.g:4395:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4396:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4396:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4397:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_68);
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

            otherlv_5=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:4422:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalMappingDsl.g:4422:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalMappingDsl.g:4423:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalMappingDsl.g:4429:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4435:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4436:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4436:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4437:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4437:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4438:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4438:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4439:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_1=(Token)match(input,17,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_89); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,59,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4471:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4472:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4472:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4473:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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

            // InternalMappingDsl.g:4490:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==25) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalMappingDsl.g:4491:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_41); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4495:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4496:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4496:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4497:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    break loop113;
                }
            } while (true);

            otherlv_8=(Token)match(input,34,FOLLOW_90); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4519:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==60) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalMappingDsl.g:4520:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,60,FOLLOW_91); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,61,FOLLOW_10); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,17,FOLLOW_87); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4532:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt114=0;
                    loop114:
                    do {
                        int alt114=2;
                        int LA114_0 = input.LA(1);

                        if ( ((LA114_0>=75 && LA114_0<=84)) ) {
                            alt114=1;
                        }


                        switch (alt114) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4533:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4533:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4534:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_92);
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
                    	    if ( cnt114 >= 1 ) break loop114;
                                EarlyExitException eee =
                                    new EarlyExitException(114, input);
                                throw eee;
                        }
                        cnt114++;
                    } while (true);

                    otherlv_13=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:4564:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalMappingDsl.g:4564:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalMappingDsl.g:4565:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalMappingDsl.g:4571:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4577:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4578:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4578:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4579:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4579:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4580:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4580:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4581:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_1=(Token)match(input,17,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_89); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,59,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4613:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4614:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4614:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4615:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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

            // InternalMappingDsl.g:4632:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==25) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalMappingDsl.g:4633:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_41); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4637:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4638:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4638:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4639:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    break loop116;
                }
            } while (true);

            otherlv_8=(Token)match(input,34,FOLLOW_90); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4661:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==60) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalMappingDsl.g:4662:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,60,FOLLOW_91); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,61,FOLLOW_10); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,17,FOLLOW_87); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4674:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt117=0;
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( ((LA117_0>=75 && LA117_0<=84)) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4675:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4675:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4676:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_92);
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
                    	    if ( cnt117 >= 1 ) break loop117;
                                EarlyExitException eee =
                                    new EarlyExitException(117, input);
                                throw eee;
                        }
                        cnt117++;
                    } while (true);

                    otherlv_13=(Token)match(input,19,FOLLOW_23); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:4706:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalMappingDsl.g:4706:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalMappingDsl.g:4707:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalMappingDsl.g:4713:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4719:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalMappingDsl.g:4720:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalMappingDsl.g:4720:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalMappingDsl.g:4721:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalMappingDsl.g:4721:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalMappingDsl.g:4722:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalMappingDsl.g:4722:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalMappingDsl.g:4723:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_93); 

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

            // InternalMappingDsl.g:4739:3: ( (lv_default_1_0= 'default' ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==51) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalMappingDsl.g:4740:4: (lv_default_1_0= 'default' )
                    {
                    // InternalMappingDsl.g:4740:4: (lv_default_1_0= 'default' )
                    // InternalMappingDsl.g:4741:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,51,FOLLOW_2); 

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
    // InternalMappingDsl.g:4757:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalMappingDsl.g:4757:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalMappingDsl.g:4758:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalMappingDsl.g:4764:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_mandatory_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_0_0 = null;

        EObject lv_defaultValue_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:4770:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) )
            // InternalMappingDsl.g:4771:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4771:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            // InternalMappingDsl.g:4772:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';'
            {
            // InternalMappingDsl.g:4772:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalMappingDsl.g:4773:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalMappingDsl.g:4773:4: (lv_type_0_0= rulePrimitiveType )
            // InternalMappingDsl.g:4774:5: lv_type_0_0= rulePrimitiveType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            // InternalMappingDsl.g:4791:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:4792:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:4792:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:4793:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_94); 

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

            // InternalMappingDsl.g:4809:3: ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )?
            int alt120=3;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==48) ) {
                alt120=1;
            }
            else if ( (LA120_0==62) ) {
                alt120=2;
            }
            switch (alt120) {
                case 1 :
                    // InternalMappingDsl.g:4810:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    {
                    // InternalMappingDsl.g:4810:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    // InternalMappingDsl.g:4811:5: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_77); 

                    					newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0_0());
                    				
                    // InternalMappingDsl.g:4815:5: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:4816:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:4816:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:4817:7: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_68);
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


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:4836:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    {
                    // InternalMappingDsl.g:4836:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    // InternalMappingDsl.g:4837:5: (lv_mandatory_4_0= 'mandatory' )
                    {
                    // InternalMappingDsl.g:4837:5: (lv_mandatory_4_0= 'mandatory' )
                    // InternalMappingDsl.g:4838:6: lv_mandatory_4_0= 'mandatory'
                    {
                    lv_mandatory_4_0=(Token)match(input,62,FOLLOW_68); 

                    						newLeafNode(lv_mandatory_4_0, grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificPropertyRule());
                    						}
                    						setWithLastConsumed(current, "mandatory", true, "mandatory");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificPropertyAccess().getSemicolonKeyword_3());
            		

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
    // InternalMappingDsl.g:4859:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalMappingDsl.g:4859:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalMappingDsl.g:4860:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalMappingDsl.g:4866:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalMappingDsl.g:4872:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalMappingDsl.g:4873:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalMappingDsl.g:4873:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt121=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt121=1;
                }
                break;
            case 64:
                {
                alt121=2;
                }
                break;
            case 65:
                {
                alt121=3;
                }
                break;
            case 66:
                {
                alt121=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalMappingDsl.g:4874:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalMappingDsl.g:4874:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalMappingDsl.g:4875:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalMappingDsl.g:4875:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalMappingDsl.g:4876:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalMappingDsl.g:4876:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalMappingDsl.g:4877:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,63,FOLLOW_76); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,48,FOLLOW_95); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:4893:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalMappingDsl.g:4894:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:4894:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:4895:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalMappingDsl.g:4914:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalMappingDsl.g:4914:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalMappingDsl.g:4915:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalMappingDsl.g:4915:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalMappingDsl.g:4916:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalMappingDsl.g:4916:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalMappingDsl.g:4917:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,64,FOLLOW_76); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,48,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalMappingDsl.g:4933:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalMappingDsl.g:4934:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalMappingDsl.g:4934:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalMappingDsl.g:4935:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalMappingDsl.g:4954:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:4954:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalMappingDsl.g:4955:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:4955:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalMappingDsl.g:4956:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalMappingDsl.g:4956:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalMappingDsl.g:4957:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,65,FOLLOW_76); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMappingDsl.g:4973:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:4974:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:4974:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:4975:6: otherlv_8= RULE_ID
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
                    // InternalMappingDsl.g:4988:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:4988:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalMappingDsl.g:4989:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:4989:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalMappingDsl.g:4990:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalMappingDsl.g:4990:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalMappingDsl.g:4991:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,66,FOLLOW_76); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalMappingDsl.g:5007:4: ( (otherlv_11= RULE_ID ) )
                    // InternalMappingDsl.g:5008:5: (otherlv_11= RULE_ID )
                    {
                    // InternalMappingDsl.g:5008:5: (otherlv_11= RULE_ID )
                    // InternalMappingDsl.g:5009:6: otherlv_11= RULE_ID
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
    // InternalMappingDsl.g:5025:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:5025:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalMappingDsl.g:5026:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalMappingDsl.g:5032:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMappingDsl.g:5038:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:5039:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:5039:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:5040:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_96); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:5048:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalMappingDsl.g:5049:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalMappingDsl.g:5049:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalMappingDsl.g:5050:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_66);
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

            // InternalMappingDsl.g:5067:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==25) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // InternalMappingDsl.g:5068:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_96); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:5072:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalMappingDsl.g:5073:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:5073:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalMappingDsl.g:5074:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_66);
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
            	    break loop122;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_68); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:5104:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalMappingDsl.g:5104:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalMappingDsl.g:5105:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalMappingDsl.g:5111:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalMappingDsl.g:5117:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalMappingDsl.g:5118:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalMappingDsl.g:5118:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalMappingDsl.g:5119:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5123:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5124:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5124:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5125:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_97); 

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

            otherlv_2=(Token)match(input,69,FOLLOW_98); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5145:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalMappingDsl.g:5146:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalMappingDsl.g:5146:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalMappingDsl.g:5147:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_99);
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

            // InternalMappingDsl.g:5164:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==25) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // InternalMappingDsl.g:5165:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_98); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5169:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalMappingDsl.g:5170:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5170:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalMappingDsl.g:5171:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_99);
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
            	    break loop123;
                }
            } while (true);

            // InternalMappingDsl.g:5189:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==17) ) {
                alt126=1;
            }
            else if ( (LA126_0==34) ) {
                alt126=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }
            switch (alt126) {
                case 1 :
                    // InternalMappingDsl.g:5190:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalMappingDsl.g:5190:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalMappingDsl.g:5191:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_100); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5195:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==67) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5196:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:5196:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalMappingDsl.g:5197:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_100);
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
                    	    break loop124;
                        }
                    } while (true);

                    // InternalMappingDsl.g:5214:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop125:
                    do {
                        int alt125=2;
                        int LA125_0 = input.LA(1);

                        if ( ((LA125_0>=75 && LA125_0<=84)) ) {
                            alt125=1;
                        }


                        switch (alt125) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5215:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5215:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5216:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_92);
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
                    	    break loop125;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5239:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:5248:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalMappingDsl.g:5248:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalMappingDsl.g:5249:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalMappingDsl.g:5255:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) ;
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
            // InternalMappingDsl.g:5261:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) )
            // InternalMappingDsl.g:5262:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            {
            // InternalMappingDsl.g:5262:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            // InternalMappingDsl.g:5263:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5267:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5268:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5268:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5269:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_97); 

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

            otherlv_2=(Token)match(input,69,FOLLOW_101); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5289:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalMappingDsl.g:5290:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalMappingDsl.g:5290:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalMappingDsl.g:5291:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_99);
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

            // InternalMappingDsl.g:5308:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==25) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // InternalMappingDsl.g:5309:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_101); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5313:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalMappingDsl.g:5314:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5314:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalMappingDsl.g:5315:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_99);
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
            	    break loop127;
                }
            } while (true);

            // InternalMappingDsl.g:5333:3: ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==17) ) {
                alt129=1;
            }
            else if ( (LA129_0==34) ) {
                alt129=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // InternalMappingDsl.g:5334:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    {
                    // InternalMappingDsl.g:5334:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    // InternalMappingDsl.g:5335:5: otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_92); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5339:5: ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( ((LA128_0>=75 && LA128_0<=84)) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5340:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5340:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5341:7: lv_properties_7_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_92);
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
                    	    break loop128;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5364:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,34,FOLLOW_2); 

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
    // InternalMappingDsl.g:5373:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalMappingDsl.g:5373:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalMappingDsl.g:5374:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalMappingDsl.g:5380:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:5386:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5387:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5387:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5388:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_102); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,70,FOLLOW_46); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:5400:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:5401:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:5401:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:5402:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

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

            otherlv_4=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:5422:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:5423:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:5423:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:5424:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:5444:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalMappingDsl.g:5444:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalMappingDsl.g:5445:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalMappingDsl.g:5451:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalMappingDsl.g:5457:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalMappingDsl.g:5458:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalMappingDsl.g:5458:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalMappingDsl.g:5459:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalMappingDsl.g:5463:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5464:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5464:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5465:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_103); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5485:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt132=3;
            int LA132_0 = input.LA(1);

            if ( ((LA132_0>=57 && LA132_0<=58)||LA132_0==74) ) {
                alt132=1;
            }
            else if ( (LA132_0==71) ) {
                alt132=2;
            }
            switch (alt132) {
                case 1 :
                    // InternalMappingDsl.g:5486:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalMappingDsl.g:5486:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt130=0;
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( ((LA130_0>=57 && LA130_0<=58)||LA130_0==74) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5487:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalMappingDsl.g:5487:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalMappingDsl.g:5488:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_104);
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
                    	    if ( cnt130 >= 1 ) break loop130;
                                EarlyExitException eee =
                                    new EarlyExitException(130, input);
                                throw eee;
                        }
                        cnt130++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5506:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalMappingDsl.g:5506:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt131=0;
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==71) ) {
                            alt131=1;
                        }


                        switch (alt131) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5507:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalMappingDsl.g:5507:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalMappingDsl.g:5508:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_105);
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
                    	    if ( cnt131 >= 1 ) break loop131;
                                EarlyExitException eee =
                                    new EarlyExitException(131, input);
                                throw eee;
                        }
                        cnt131++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:5534:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMappingDsl.g:5534:48: (iv_ruleContext= ruleContext EOF )
            // InternalMappingDsl.g:5535:2: iv_ruleContext= ruleContext EOF
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
    // InternalMappingDsl.g:5541:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5547:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalMappingDsl.g:5548:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalMappingDsl.g:5548:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalMappingDsl.g:5549:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalMappingDsl.g:5553:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5554:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5554:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5555:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_106); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5575:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt133=0;
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( ((LA133_0>=57 && LA133_0<=58)||LA133_0==74) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // InternalMappingDsl.g:5576:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalMappingDsl.g:5576:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalMappingDsl.g:5577:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_104);
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
            	    if ( cnt133 >= 1 ) break loop133;
                        EarlyExitException eee =
                            new EarlyExitException(133, input);
                        throw eee;
                }
                cnt133++;
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:5602:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalMappingDsl.g:5602:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalMappingDsl.g:5603:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalMappingDsl.g:5609:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5615:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalMappingDsl.g:5616:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalMappingDsl.g:5616:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt134=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt134=1;
                }
                break;
            case 57:
                {
                alt134=2;
                }
                break;
            case 74:
                {
                alt134=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // InternalMappingDsl.g:5617:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalMappingDsl.g:5626:3: this_ListType_1= ruleListType
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
                    // InternalMappingDsl.g:5635:3: this_Enumeration_2= ruleEnumeration
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
    // InternalMappingDsl.g:5647:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalMappingDsl.g:5647:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalMappingDsl.g:5648:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalMappingDsl.g:5654:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) ;
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
            // InternalMappingDsl.g:5660:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) )
            // InternalMappingDsl.g:5661:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            {
            // InternalMappingDsl.g:5661:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            // InternalMappingDsl.g:5662:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalMappingDsl.g:5666:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5667:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5667:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5668:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_107); 

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

            // InternalMappingDsl.g:5684:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==72) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalMappingDsl.g:5685:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,72,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMappingDsl.g:5689:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:5690:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:5690:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:5691:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_108); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:5710:3: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==RULE_ID||LA137_0==73||(LA137_0>=75 && LA137_0<=84)) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalMappingDsl.g:5711:4: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalMappingDsl.g:5711:4: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalMappingDsl.g:5712:5: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:5712:5: (lv_dataFields_5_0= ruleDataField )
                    // InternalMappingDsl.g:5713:6: lv_dataFields_5_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_29);
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

                    // InternalMappingDsl.g:5730:4: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==25) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5731:5: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,25,FOLLOW_109); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalMappingDsl.g:5735:5: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:5736:6: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:5736:6: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalMappingDsl.g:5737:7: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop136;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:5764:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalMappingDsl.g:5764:49: (iv_ruleListType= ruleListType EOF )
            // InternalMappingDsl.g:5765:2: iv_ruleListType= ruleListType EOF
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
    // InternalMappingDsl.g:5771:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalMappingDsl.g:5777:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalMappingDsl.g:5778:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalMappingDsl.g:5778:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt139=2;
            alt139 = dfa139.predict(input);
            switch (alt139) {
                case 1 :
                    // InternalMappingDsl.g:5779:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalMappingDsl.g:5779:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalMappingDsl.g:5780:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalMappingDsl.g:5784:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalMappingDsl.g:5785:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5785:5: (lv_name_1_0= RULE_ID )
                    // InternalMappingDsl.g:5786:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

                    otherlv_2=(Token)match(input,17,FOLLOW_109); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalMappingDsl.g:5806:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalMappingDsl.g:5807:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:5807:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalMappingDsl.g:5808:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_29);
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

                    // InternalMappingDsl.g:5825:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop138:
                    do {
                        int alt138=2;
                        int LA138_0 = input.LA(1);

                        if ( (LA138_0==25) ) {
                            alt138=1;
                        }


                        switch (alt138) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5826:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_109); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalMappingDsl.g:5830:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:5831:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:5831:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalMappingDsl.g:5832:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop138;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5856:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:5856:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalMappingDsl.g:5857:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalMappingDsl.g:5861:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalMappingDsl.g:5862:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5862:5: (lv_name_8_0= RULE_ID )
                    // InternalMappingDsl.g:5863:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

                    otherlv_9=(Token)match(input,17,FOLLOW_87); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalMappingDsl.g:5883:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:5884:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:5884:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalMappingDsl.g:5885:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_23);
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

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:5911:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalMappingDsl.g:5911:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalMappingDsl.g:5912:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalMappingDsl.g:5918:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5924:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5925:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5925:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5926:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:5926:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==73) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // InternalMappingDsl.g:5927:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalMappingDsl.g:5927:4: (lv_hidden_0_0= 'hide' )
                    // InternalMappingDsl.g:5928:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,73,FOLLOW_73); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:5940:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt141=3;
            int LA141_0 = input.LA(1);

            if ( ((LA141_0>=75 && LA141_0<=84)) ) {
                alt141=1;
            }
            else if ( (LA141_0==RULE_ID) ) {
                int LA141_2 = input.LA(2);

                if ( (LA141_2==RULE_ID||LA141_2==29||LA141_2==32) ) {
                    alt141=2;
                }
            }
            switch (alt141) {
                case 1 :
                    // InternalMappingDsl.g:5941:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:5941:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:5942:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:5942:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalMappingDsl.g:5943:6: lv_primitiveType_1_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_7);
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
                    // InternalMappingDsl.g:5961:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalMappingDsl.g:5961:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalMappingDsl.g:5962:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalMappingDsl.g:5962:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalMappingDsl.g:5963:6: lv_complexType_2_0= rulePossiblyImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_7);
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

            // InternalMappingDsl.g:5981:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMappingDsl.g:5982:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMappingDsl.g:5982:4: (lv_name_3_0= RULE_ID )
            // InternalMappingDsl.g:5983:5: lv_name_3_0= RULE_ID
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
    // InternalMappingDsl.g:6003:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalMappingDsl.g:6003:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalMappingDsl.g:6004:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalMappingDsl.g:6010:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
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
            // InternalMappingDsl.g:6016:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalMappingDsl.g:6017:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalMappingDsl.g:6017:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalMappingDsl.g:6018:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalMappingDsl.g:6022:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6023:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6023:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6024:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:6044:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalMappingDsl.g:6045:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalMappingDsl.g:6045:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalMappingDsl.g:6046:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_29);
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

            // InternalMappingDsl.g:6063:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( (LA142_0==25) ) {
                    alt142=1;
                }


                switch (alt142) {
            	case 1 :
            	    // InternalMappingDsl.g:6064:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:6068:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalMappingDsl.g:6069:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalMappingDsl.g:6069:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalMappingDsl.g:6070:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    break loop142;
                }
            } while (true);

            otherlv_6=(Token)match(input,19,FOLLOW_2); 

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
    // InternalMappingDsl.g:6096:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalMappingDsl.g:6096:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalMappingDsl.g:6097:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalMappingDsl.g:6103:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6109:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalMappingDsl.g:6110:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalMappingDsl.g:6110:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalMappingDsl.g:6111:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalMappingDsl.g:6111:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:6112:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:6112:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:6113:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_75); 

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

            // InternalMappingDsl.g:6129:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==15) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // InternalMappingDsl.g:6130:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_77); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalMappingDsl.g:6134:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:6135:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:6135:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:6136:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
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

                    otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:6162:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalMappingDsl.g:6162:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalMappingDsl.g:6163:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalMappingDsl.g:6169:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6175:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalMappingDsl.g:6176:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDsl.g:6176:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt144=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt144=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt144=2;
                }
                break;
            case RULE_STRING:
                {
                alt144=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 144, 0, input);

                throw nvae;
            }

            switch (alt144) {
                case 1 :
                    // InternalMappingDsl.g:6177:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalMappingDsl.g:6177:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalMappingDsl.g:6178:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalMappingDsl.g:6178:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalMappingDsl.g:6179:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalMappingDsl.g:6196:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalMappingDsl.g:6196:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:6197:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:6197:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:6198:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalMappingDsl.g:6215:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalMappingDsl.g:6215:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalMappingDsl.g:6216:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalMappingDsl.g:6216:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalMappingDsl.g:6217:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalMappingDsl.g:6237:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalMappingDsl.g:6237:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalMappingDsl.g:6238:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
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
    // InternalMappingDsl.g:6244:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6250:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:6251:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:6251:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:6252:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:6252:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==RULE_ID) ) {
                int LA145_1 = input.LA(2);

                if ( (LA145_1==29) ) {
                    alt145=1;
                }
            }
            switch (alt145) {
                case 1 :
                    // InternalMappingDsl.g:6253:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:6253:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:6254:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:6254:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:6255:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:6271:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:6272:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:6272:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:6273:5: ruleQualifiedName
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
    // InternalMappingDsl.g:6291:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalMappingDsl.g:6291:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalMappingDsl.g:6292:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalMappingDsl.g:6298:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalMappingDsl.g:6304:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalMappingDsl.g:6305:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalMappingDsl.g:6305:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt146=10;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt146=1;
                }
                break;
            case 76:
                {
                alt146=2;
                }
                break;
            case 77:
                {
                alt146=3;
                }
                break;
            case 78:
                {
                alt146=4;
                }
                break;
            case 79:
                {
                alt146=5;
                }
                break;
            case 80:
                {
                alt146=6;
                }
                break;
            case 81:
                {
                alt146=7;
                }
                break;
            case 82:
                {
                alt146=8;
                }
                break;
            case 83:
                {
                alt146=9;
                }
                break;
            case 84:
                {
                alt146=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }

            switch (alt146) {
                case 1 :
                    // InternalMappingDsl.g:6306:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalMappingDsl.g:6306:3: ( () otherlv_1= 'boolean' )
                    // InternalMappingDsl.g:6307:4: () otherlv_1= 'boolean'
                    {
                    // InternalMappingDsl.g:6307:4: ()
                    // InternalMappingDsl.g:6308:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,75,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6320:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalMappingDsl.g:6320:3: ( () otherlv_3= 'byte' )
                    // InternalMappingDsl.g:6321:4: () otherlv_3= 'byte'
                    {
                    // InternalMappingDsl.g:6321:4: ()
                    // InternalMappingDsl.g:6322:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,76,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6334:3: ( () otherlv_5= 'char' )
                    {
                    // InternalMappingDsl.g:6334:3: ( () otherlv_5= 'char' )
                    // InternalMappingDsl.g:6335:4: () otherlv_5= 'char'
                    {
                    // InternalMappingDsl.g:6335:4: ()
                    // InternalMappingDsl.g:6336:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,77,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:6348:3: ( () otherlv_7= 'date' )
                    {
                    // InternalMappingDsl.g:6348:3: ( () otherlv_7= 'date' )
                    // InternalMappingDsl.g:6349:4: () otherlv_7= 'date'
                    {
                    // InternalMappingDsl.g:6349:4: ()
                    // InternalMappingDsl.g:6350:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,78,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:6362:3: ( () otherlv_9= 'double' )
                    {
                    // InternalMappingDsl.g:6362:3: ( () otherlv_9= 'double' )
                    // InternalMappingDsl.g:6363:4: () otherlv_9= 'double'
                    {
                    // InternalMappingDsl.g:6363:4: ()
                    // InternalMappingDsl.g:6364:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,79,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:6376:3: ( () otherlv_11= 'float' )
                    {
                    // InternalMappingDsl.g:6376:3: ( () otherlv_11= 'float' )
                    // InternalMappingDsl.g:6377:4: () otherlv_11= 'float'
                    {
                    // InternalMappingDsl.g:6377:4: ()
                    // InternalMappingDsl.g:6378:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,80,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMappingDsl.g:6390:3: ( () otherlv_13= 'int' )
                    {
                    // InternalMappingDsl.g:6390:3: ( () otherlv_13= 'int' )
                    // InternalMappingDsl.g:6391:4: () otherlv_13= 'int'
                    {
                    // InternalMappingDsl.g:6391:4: ()
                    // InternalMappingDsl.g:6392:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,81,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMappingDsl.g:6404:3: ( () otherlv_15= 'long' )
                    {
                    // InternalMappingDsl.g:6404:3: ( () otherlv_15= 'long' )
                    // InternalMappingDsl.g:6405:4: () otherlv_15= 'long'
                    {
                    // InternalMappingDsl.g:6405:4: ()
                    // InternalMappingDsl.g:6406:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,82,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMappingDsl.g:6418:3: ( () otherlv_17= 'short' )
                    {
                    // InternalMappingDsl.g:6418:3: ( () otherlv_17= 'short' )
                    // InternalMappingDsl.g:6419:4: () otherlv_17= 'short'
                    {
                    // InternalMappingDsl.g:6419:4: ()
                    // InternalMappingDsl.g:6420:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,83,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMappingDsl.g:6432:3: ( () otherlv_19= 'string' )
                    {
                    // InternalMappingDsl.g:6432:3: ( () otherlv_19= 'string' )
                    // InternalMappingDsl.g:6433:4: () otherlv_19= 'string'
                    {
                    // InternalMappingDsl.g:6433:4: ()
                    // InternalMappingDsl.g:6434:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,84,FOLLOW_2); 

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
    // InternalMappingDsl.g:6449:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMappingDsl.g:6449:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMappingDsl.g:6450:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMappingDsl.g:6456:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6462:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMappingDsl.g:6463:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMappingDsl.g:6463:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMappingDsl.g:6464:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMappingDsl.g:6471:3: (kw= '.' this_ID_2= RULE_ID )*
            loop147:
            do {
                int alt147=2;
                int LA147_0 = input.LA(1);

                if ( (LA147_0==32) ) {
                    alt147=1;
                }


                switch (alt147) {
            	case 1 :
            	    // InternalMappingDsl.g:6472:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,32,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop147;
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


    // $ANTLR start "ruleImportType"
    // InternalMappingDsl.g:6489:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6495:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalMappingDsl.g:6496:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalMappingDsl.g:6496:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==14) ) {
                alt148=1;
            }
            else if ( (LA148_0==41) ) {
                alt148=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }
            switch (alt148) {
                case 1 :
                    // InternalMappingDsl.g:6497:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalMappingDsl.g:6497:3: (enumLiteral_0= 'technology' )
                    // InternalMappingDsl.g:6498:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,14,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6505:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalMappingDsl.g:6505:3: (enumLiteral_1= 'microservices' )
                    // InternalMappingDsl.g:6506:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleImportType"


    // $ANTLR start "ruleVisibility"
    // InternalMappingDsl.g:6516:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6522:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalMappingDsl.g:6523:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalMappingDsl.g:6523:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt149=3;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt149=1;
                }
                break;
            case 86:
                {
                alt149=2;
                }
                break;
            case 87:
                {
                alt149=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // InternalMappingDsl.g:6524:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalMappingDsl.g:6524:3: (enumLiteral_0= 'internal' )
                    // InternalMappingDsl.g:6525:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6532:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalMappingDsl.g:6532:3: (enumLiteral_1= 'architecture' )
                    // InternalMappingDsl.g:6533:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6540:3: (enumLiteral_2= 'public' )
                    {
                    // InternalMappingDsl.g:6540:3: (enumLiteral_2= 'public' )
                    // InternalMappingDsl.g:6541:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "ruleMicroserviceType"
    // InternalMappingDsl.g:6551:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6557:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalMappingDsl.g:6558:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:6558:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt150=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt150=1;
                }
                break;
            case 89:
                {
                alt150=2;
                }
                break;
            case 90:
                {
                alt150=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;
            }

            switch (alt150) {
                case 1 :
                    // InternalMappingDsl.g:6559:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalMappingDsl.g:6559:3: (enumLiteral_0= 'functional' )
                    // InternalMappingDsl.g:6560:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6567:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalMappingDsl.g:6567:3: (enumLiteral_1= 'utility' )
                    // InternalMappingDsl.g:6568:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6575:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:6575:3: (enumLiteral_2= 'infrastructure' )
                    // InternalMappingDsl.g:6576:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getINFRASTRUCTUREEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMicroserviceTypeAccess().getINFRASTRUCTUREEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleMicroserviceType"


    // $ANTLR start "ruleExchangePattern"
    // InternalMappingDsl.g:6586:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6592:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalMappingDsl.g:6593:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalMappingDsl.g:6593:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt151=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt151=1;
                }
                break;
            case 92:
                {
                alt151=2;
                }
                break;
            case 93:
                {
                alt151=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 151, 0, input);

                throw nvae;
            }

            switch (alt151) {
                case 1 :
                    // InternalMappingDsl.g:6594:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMappingDsl.g:6594:3: (enumLiteral_0= 'in' )
                    // InternalMappingDsl.g:6595:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6602:3: (enumLiteral_1= 'out' )
                    {
                    // InternalMappingDsl.g:6602:3: (enumLiteral_1= 'out' )
                    // InternalMappingDsl.g:6603:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6610:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalMappingDsl.g:6610:3: (enumLiteral_2= 'inout' )
                    // InternalMappingDsl.g:6611:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,93,FOLLOW_2); 

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
    // InternalMappingDsl.g:6621:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6627:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalMappingDsl.g:6628:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalMappingDsl.g:6628:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==94) ) {
                alt152=1;
            }
            else if ( (LA152_0==95) ) {
                alt152=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }
            switch (alt152) {
                case 1 :
                    // InternalMappingDsl.g:6629:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalMappingDsl.g:6629:3: (enumLiteral_0= 'sync' )
                    // InternalMappingDsl.g:6630:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6637:3: (enumLiteral_1= 'async' )
                    {
                    // InternalMappingDsl.g:6637:3: (enumLiteral_1= 'async' )
                    // InternalMappingDsl.g:6638:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); 

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
    // InternalMappingDsl.g:6648:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6654:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalMappingDsl.g:6655:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalMappingDsl.g:6655:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt153=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt153=1;
                }
                break;
            case 31:
                {
                alt153=2;
                }
                break;
            case 97:
                {
                alt153=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalMappingDsl.g:6656:3: (enumLiteral_0= '<-' )
                    {
                    // InternalMappingDsl.g:6656:3: (enumLiteral_0= '<-' )
                    // InternalMappingDsl.g:6657:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6664:3: (enumLiteral_1= '->' )
                    {
                    // InternalMappingDsl.g:6664:3: (enumLiteral_1= '->' )
                    // InternalMappingDsl.g:6665:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6672:3: (enumLiteral_2= '<->' )
                    {
                    // InternalMappingDsl.g:6672:3: (enumLiteral_2= '<->' )
                    // InternalMappingDsl.g:6673:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,97,FOLLOW_2); 

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


    // $ANTLR start "ruleServiceJoinPointType"
    // InternalMappingDsl.g:6683:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) ) ;
    public final Enumerator ruleServiceJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6689:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) ) )
            // InternalMappingDsl.g:6690:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) )
            {
            // InternalMappingDsl.g:6690:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) )
            int alt154=5;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt154=1;
                }
                break;
            case 42:
                {
                alt154=2;
                }
                break;
            case 43:
                {
                alt154=3;
                }
                break;
            case 24:
                {
                alt154=4;
                }
                break;
            case 98:
                {
                alt154=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);

                throw nvae;
            }

            switch (alt154) {
                case 1 :
                    // InternalMappingDsl.g:6691:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalMappingDsl.g:6691:3: (enumLiteral_0= 'microservices' )
                    // InternalMappingDsl.g:6692:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6699:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalMappingDsl.g:6699:3: (enumLiteral_1= 'interfaces' )
                    // InternalMappingDsl.g:6700:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6707:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalMappingDsl.g:6707:3: (enumLiteral_2= 'operations' )
                    // InternalMappingDsl.g:6708:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:6715:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalMappingDsl.g:6715:3: (enumLiteral_3= 'parameters' )
                    // InternalMappingDsl.g:6716:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:6723:3: (enumLiteral_4= 'fields' )
                    {
                    // InternalMappingDsl.g:6723:3: (enumLiteral_4= 'fields' )
                    // InternalMappingDsl.g:6724:4: enumLiteral_4= 'fields'
                    {
                    enumLiteral_4=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_4());
                    			

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
    // InternalMappingDsl.g:6734:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6740:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalMappingDsl.g:6741:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:6741:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==99) ) {
                alt155=1;
            }
            else if ( (LA155_0==90) ) {
                alt155=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 155, 0, input);

                throw nvae;
            }
            switch (alt155) {
                case 1 :
                    // InternalMappingDsl.g:6742:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalMappingDsl.g:6742:3: (enumLiteral_0= 'containers' )
                    // InternalMappingDsl.g:6743:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6750:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:6750:3: (enumLiteral_1= 'infrastructure' )
                    // InternalMappingDsl.g:6751:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

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


    protected DFA78 dfa78 = new DFA78(this);
    protected DFA139 dfa139 = new DFA139(this);
    static final String dfa_1s = "\111\uffff";
    static final String dfa_2s = "\2\4\2\uffff\1\35\3\17\4\4\2\35\6\4\3\20\1\60\1\31\1\20\1\4\1\5\3\4\1\5\3\4\3\20\2\31\1\35\1\31\2\20\3\4\1\5\1\4\2\17\1\60\2\31\2\4\1\5\2\4\1\35\3\20\2\31\1\4\1\20\3\4\2\20\1\4";
    static final String dfa_3s = "\1\127\1\137\2\uffff\1\35\3\17\3\4\1\127\2\35\1\4\1\7\3\4\1\127\3\20\1\60\2\41\1\127\1\7\3\4\1\5\2\4\1\127\3\31\1\41\1\34\1\35\1\42\1\41\1\20\1\137\2\4\1\5\1\20\2\17\1\60\1\41\1\42\1\127\1\4\1\7\2\4\1\35\3\31\1\41\1\34\1\4\1\41\2\4\1\127\1\41\1\20\1\24";
    static final String dfa_4s = "\2\uffff\1\2\1\1\105\uffff";
    static final String dfa_5s = "\111\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\10\uffff\1\1\5\uffff\1\2\30\uffff\1\2\1\3\47\uffff\3\2",
            "\1\4\17\uffff\1\5\111\uffff\1\6\1\7",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\2\10\uffff\1\20\1\uffff\1\17\20\uffff\1\16\13\uffff\1\2\1\3\47\uffff\3\2",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\27\1\26\1\24\1\25",
            "\1\4",
            "\1\30",
            "\1\31",
            "\1\2\10\uffff\1\20\1\uffff\1\17\20\uffff\1\16\13\uffff\1\2\1\3\47\uffff\3\2",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\33",
            "\1\36\2\uffff\1\37\3\uffff\1\34\1\35",
            "\1\42\17\uffff\1\40\1\41",
            "\1\2\10\uffff\1\20\36\uffff\1\2\1\3\47\uffff\3\2",
            "\1\45\1\43\1\44",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\2\10\uffff\1\54\36\uffff\1\2\1\3\47\uffff\3\2",
            "\1\32\10\uffff\1\55",
            "\1\32\10\uffff\1\55",
            "\1\32\10\uffff\1\55",
            "\1\36\2\uffff\1\37\3\uffff\1\34\1\35",
            "\1\36\2\uffff\1\37",
            "\1\56",
            "\1\57\10\uffff\1\60",
            "\1\42\17\uffff\1\40\1\41",
            "\1\42",
            "\1\4\17\uffff\1\5\111\uffff\1\61\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\14\13\uffff\1\66",
            "\1\67",
            "\1\67",
            "\1\70",
            "\1\36\2\uffff\1\37\3\uffff\1\71\1\72",
            "\1\57\10\uffff\1\60",
            "\1\2\10\uffff\1\20\36\uffff\1\2\1\3\47\uffff\3\2",
            "\1\73",
            "\1\76\1\74\1\75",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\32\10\uffff\1\55",
            "\1\32\10\uffff\1\55",
            "\1\32\10\uffff\1\55",
            "\1\36\2\uffff\1\37\3\uffff\1\71\1\72",
            "\1\36\2\uffff\1\37",
            "\1\102",
            "\1\105\17\uffff\1\103\1\104",
            "\1\106",
            "\1\107",
            "\1\2\10\uffff\1\110\36\uffff\1\2\1\3\47\uffff\3\2",
            "\1\105\17\uffff\1\103\1\104",
            "\1\105",
            "\1\4\17\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 2659:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_7s = "\20\uffff";
    static final String dfa_8s = "\1\71\1\4\1\21\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_9s = "\1\71\1\4\1\21\1\124\1\uffff\12\23\1\uffff";
    static final String dfa_10s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_11s = "\20\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\104\uffff\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
            "",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            "\1\4\16\uffff\1\17",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA139 extends DFA {

        public DFA139(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 139;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "5778:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000800002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004FC0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004F80000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004E80000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004C80000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004880000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000013C0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001380000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001280000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000010020002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000090020002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000402000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000400008000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000002000L,0x0000000007E00000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000110000402000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000110000482000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000100000402000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000400000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000300000082010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000100000082010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000100000002010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000002012000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000002000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000200000002000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000400000000010L,0x0000000038000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000800010000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000010L,0x00000000001FF800L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0008000402000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0080000400000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x00000000001FF800L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000082000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000080000L,0x00000000001FF800L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x4001000400000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000000038000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x00000E0001000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000402020000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000080000L,0x00000000001FF808L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000804000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0600000000080000L,0x0000000000000480L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0600000000080000L,0x0000000000000400L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000080L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0600000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000100L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000080010L,0x00000000001FFA00L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000010L,0x00000000001FFA00L});

}