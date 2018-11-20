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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'technology'", "'('", "')'", "'{'", "'protocols'", "'}'", "'endpoints'", "'aspects'", "'interface'", "'operation'", "'parameters'", "','", "'referred'", "'primitive'", "':'", "'complex'", "'->'", "'.'", "'::'", "'/'", "';'", "'import'", "'from'", "'as'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'noimpl'", "'refers'", "'fault'", "'?'", "'='", "'data'", "'formats'", "'default'", "'with'", "'format'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'environments'", "'service'", "'properties'", "'mandatory'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'aspect'", "'for'", "'datatypes'", "'context'", "'extends'", "'hide'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'functional'", "'utility'", "'infrastructure'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'<->'", "'fields'", "'containers'"
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
    // InternalMappingDsl.g:72:1: ruleTechnologyMapping returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_mappings_1_0= ruleMicroserviceMapping ) )+ ) ;
    public final EObject ruleTechnologyMapping() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_mappings_1_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_mappings_1_0= ruleMicroserviceMapping ) )+ ) )
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_mappings_1_0= ruleMicroserviceMapping ) )+ )
            {
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_mappings_1_0= ruleMicroserviceMapping ) )+ )
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+ ( (lv_mappings_1_0= ruleMicroserviceMapping ) )+
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

            // InternalMappingDsl.g:99:3: ( (lv_mappings_1_0= ruleMicroserviceMapping ) )+
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
            	    // InternalMappingDsl.g:100:4: (lv_mappings_1_0= ruleMicroserviceMapping )
            	    {
            	    // InternalMappingDsl.g:100:4: (lv_mappings_1_0= ruleMicroserviceMapping )
            	    // InternalMappingDsl.g:101:5: lv_mappings_1_0= ruleMicroserviceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyMappingAccess().getMappingsMicroserviceMappingParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_mappings_1_0=ruleMicroserviceMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mappings",
            	    						lv_mappings_1_0,
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
    // InternalMappingDsl.g:129:1: ruleMicroserviceMapping returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' ) ;
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
            // InternalMappingDsl.g:135:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' ) )
            // InternalMappingDsl.g:136:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' )
            {
            // InternalMappingDsl.g:136:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' )
            // InternalMappingDsl.g:137:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMicroserviceMappingAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getMicroserviceMappingAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMicroserviceMappingAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:149:3: ( (otherlv_3= RULE_ID ) )
            // InternalMappingDsl.g:150:4: (otherlv_3= RULE_ID )
            {
            // InternalMappingDsl.g:150:4: (otherlv_3= RULE_ID )
            // InternalMappingDsl.g:151:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMicroserviceMappingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_3, grammarAccess.getMicroserviceMappingAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getMicroserviceMappingAccess().getRightParenthesisKeyword_4());
            		
            // InternalMappingDsl.g:166:3: ( (lv_microservice_5_0= ruleImportedMicroservice ) )
            // InternalMappingDsl.g:167:4: (lv_microservice_5_0= ruleImportedMicroservice )
            {
            // InternalMappingDsl.g:167:4: (lv_microservice_5_0= ruleImportedMicroservice )
            // InternalMappingDsl.g:168:5: lv_microservice_5_0= ruleImportedMicroservice
            {

            					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getMicroserviceImportedMicroserviceParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
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

            otherlv_6=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalMappingDsl.g:189:3: (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMappingDsl.g:190:4: otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceMappingAccess().getProtocolsKeyword_7_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalMappingDsl.g:198:4: ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=93 && LA3_0<=94)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalMappingDsl.g:199:5: (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:199:5: (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:200:6: lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_7_2_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
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
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:222:3: (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMappingDsl.g:223:4: otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,20,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceMappingAccess().getEndpointsKeyword_8_0());
                    			
                    otherlv_12=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_8_1());
                    			
                    // InternalMappingDsl.g:231:4: ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMappingDsl.g:232:5: (lv_endpoints_13_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:232:5: (lv_endpoints_13_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:233:6: lv_endpoints_13_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_8_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,19,FOLLOW_15); 

                    				newLeafNode(otherlv_14, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_8_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:255:3: (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMappingDsl.g:256:4: otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_15, grammarAccess.getMicroserviceMappingAccess().getAspectsKeyword_9_0());
                    			
                    otherlv_16=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_9_1());
                    			
                    // InternalMappingDsl.g:264:4: ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalMappingDsl.g:265:5: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:265:5: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:266:6: lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_9_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    otherlv_18=(Token)match(input,19,FOLLOW_16); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:288:3: ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMappingDsl.g:289:4: (lv_interfaceMappings_19_0= ruleInterfaceMapping )
            	    {
            	    // InternalMappingDsl.g:289:4: (lv_interfaceMappings_19_0= ruleInterfaceMapping )
            	    // InternalMappingDsl.g:290:5: lv_interfaceMappings_19_0= ruleInterfaceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getInterfaceMappingsInterfaceMappingParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop9;
                }
            } while (true);

            // InternalMappingDsl.g:307:3: ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMappingDsl.g:308:4: (lv_referredOperationMappings_20_0= ruleReferredOperationMapping )
            	    {
            	    // InternalMappingDsl.g:308:4: (lv_referredOperationMappings_20_0= ruleReferredOperationMapping )
            	    // InternalMappingDsl.g:309:5: lv_referredOperationMappings_20_0= ruleReferredOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getReferredOperationMappingsReferredOperationMappingParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_17);
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
            	    break loop10;
                }
            } while (true);

            // InternalMappingDsl.g:326:3: ( (lv_operationMappings_21_0= ruleOperationMapping ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMappingDsl.g:327:4: (lv_operationMappings_21_0= ruleOperationMapping )
            	    {
            	    // InternalMappingDsl.g:327:4: (lv_operationMappings_21_0= ruleOperationMapping )
            	    // InternalMappingDsl.g:328:5: lv_operationMappings_21_0= ruleOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getOperationMappingsOperationMappingParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_18);
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
            	    break loop11;
                }
            } while (true);

            otherlv_22=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_13());
            		

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
    // InternalMappingDsl.g:353:1: entryRuleInterfaceMapping returns [EObject current=null] : iv_ruleInterfaceMapping= ruleInterfaceMapping EOF ;
    public final EObject entryRuleInterfaceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceMapping = null;


        try {
            // InternalMappingDsl.g:353:57: (iv_ruleInterfaceMapping= ruleInterfaceMapping EOF )
            // InternalMappingDsl.g:354:2: iv_ruleInterfaceMapping= ruleInterfaceMapping EOF
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
    // InternalMappingDsl.g:360:1: ruleInterfaceMapping returns [EObject current=null] : (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) ;
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
            // InternalMappingDsl.g:366:2: ( (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalMappingDsl.g:367:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalMappingDsl.g:367:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            // InternalMappingDsl.g:368:3: otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getInterfaceMappingAccess().getInterfaceKeyword_0());
            		
            // InternalMappingDsl.g:372:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:373:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:373:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:374:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_1, grammarAccess.getInterfaceMappingAccess().getInterfaceInterfaceCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:389:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMappingDsl.g:390:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:398:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=93 && LA12_0<=94)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalMappingDsl.g:399:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:399:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:400:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
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
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_20); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:422:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMappingDsl.g:423:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:431:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalMappingDsl.g:432:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:432:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:433:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_21); 

                    				newLeafNode(otherlv_10, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:455:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==21) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMappingDsl.g:456:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:464:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalMappingDsl.g:465:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:465:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:466:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    otherlv_14=(Token)match(input,19,FOLLOW_22); 

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
    // InternalMappingDsl.g:496:1: entryRuleOperationMapping returns [EObject current=null] : iv_ruleOperationMapping= ruleOperationMapping EOF ;
    public final EObject entryRuleOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationMapping = null;


        try {
            // InternalMappingDsl.g:496:57: (iv_ruleOperationMapping= ruleOperationMapping EOF )
            // InternalMappingDsl.g:497:2: iv_ruleOperationMapping= ruleOperationMapping EOF
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
    // InternalMappingDsl.g:503:1: ruleOperationMapping returns [EObject current=null] : (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' ) ;
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
            // InternalMappingDsl.g:509:2: ( (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' ) )
            // InternalMappingDsl.g:510:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' )
            {
            // InternalMappingDsl.g:510:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}' )
            // InternalMappingDsl.g:511:3: otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )? otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationMappingAccess().getOperationKeyword_0());
            		
            // InternalMappingDsl.g:515:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:516:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:516:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:517:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOperationMappingAccess().getOperationOperationCrossReference_1_0());
            				
            pushFollow(FOLLOW_9);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:535:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMappingDsl.g:536:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:544:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=93 && LA18_0<=94)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalMappingDsl.g:545:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:545:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:546:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
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
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:568:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMappingDsl.g:569:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:577:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMappingDsl.g:578:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:578:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:579:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_25); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:601:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==21) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMappingDsl.g:602:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getOperationMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:610:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalMappingDsl.g:611:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:611:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:612:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    otherlv_14=(Token)match(input,19,FOLLOW_26); 

                    				newLeafNode(otherlv_14, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:634:3: (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==24) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMappingDsl.g:635:4: otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) ) (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_15, grammarAccess.getOperationMappingAccess().getParametersKeyword_6_0());
                    			
                    otherlv_16=(Token)match(input,17,FOLLOW_27); 

                    				newLeafNode(otherlv_16, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:643:4: ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )
                    // InternalMappingDsl.g:644:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    {
                    // InternalMappingDsl.g:644:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    // InternalMappingDsl.g:645:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    {
                    // InternalMappingDsl.g:645:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==27) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==29) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalMappingDsl.g:646:7: lv_parameterMappings_17_1= rulePrimitiveParameterMapping
                            {

                            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_2_0_0());
                            						
                            pushFollow(FOLLOW_28);
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
                            // InternalMappingDsl.g:662:7: lv_parameterMappings_17_2= ruleComplexParameterMapping
                            {

                            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_2_0_1());
                            						
                            pushFollow(FOLLOW_28);
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

                    // InternalMappingDsl.g:680:4: (otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==25) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalMappingDsl.g:681:5: otherlv_18= ',' ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) )
                    	    {
                    	    otherlv_18=(Token)match(input,25,FOLLOW_27); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getOperationMappingAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalMappingDsl.g:685:5: ( ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) ) )
                    	    // InternalMappingDsl.g:686:6: ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) )
                    	    {
                    	    // InternalMappingDsl.g:686:6: ( (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping ) )
                    	    // InternalMappingDsl.g:687:7: (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping )
                    	    {
                    	    // InternalMappingDsl.g:687:7: (lv_parameterMappings_19_1= rulePrimitiveParameterMapping | lv_parameterMappings_19_2= ruleComplexParameterMapping )
                    	    int alt25=2;
                    	    int LA25_0 = input.LA(1);

                    	    if ( (LA25_0==27) ) {
                    	        alt25=1;
                    	    }
                    	    else if ( (LA25_0==29) ) {
                    	        alt25=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 25, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt25) {
                    	        case 1 :
                    	            // InternalMappingDsl.g:688:8: lv_parameterMappings_19_1= rulePrimitiveParameterMapping
                    	            {

                    	            								newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_3_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_28);
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
                    	            // InternalMappingDsl.g:704:8: lv_parameterMappings_19_2= ruleComplexParameterMapping
                    	            {

                    	            								newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_3_1_0_1());
                    	            							
                    	            pushFollow(FOLLOW_28);
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
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,19,FOLLOW_22); 

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
    // InternalMappingDsl.g:736:1: entryRuleReferredOperationMapping returns [EObject current=null] : iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF ;
    public final EObject entryRuleReferredOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperationMapping = null;


        try {
            // InternalMappingDsl.g:736:65: (iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF )
            // InternalMappingDsl.g:737:2: iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF
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
    // InternalMappingDsl.g:743:1: ruleReferredOperationMapping returns [EObject current=null] : (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) ;
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
            // InternalMappingDsl.g:749:2: ( (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) )
            // InternalMappingDsl.g:750:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            {
            // InternalMappingDsl.g:750:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            // InternalMappingDsl.g:751:3: otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getReferredOperationMappingAccess().getReferredKeyword_0());
            		
            otherlv_1=(Token)match(input,23,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getReferredOperationMappingAccess().getOperationKeyword_1());
            		
            // InternalMappingDsl.g:759:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:760:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:760:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:761:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getOperationReferredOperationCrossReference_2_0());
            				
            pushFollow(FOLLOW_9);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:779:3: (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==18) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMappingDsl.g:780:4: otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationMappingAccess().getProtocolsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:788:4: ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>=93 && LA28_0<=94)) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalMappingDsl.g:789:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:789:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:790:6: lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
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
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    otherlv_7=(Token)match(input,19,FOLLOW_20); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:812:3: (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==20) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMappingDsl.g:813:4: otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_9); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationMappingAccess().getEndpointsKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:821:4: ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalMappingDsl.g:822:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:822:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:823:6: lv_endpoints_10_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    otherlv_11=(Token)match(input,19,FOLLOW_21); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:845:3: (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==21) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMappingDsl.g:846:4: otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_12, grammarAccess.getReferredOperationMappingAccess().getAspectsKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:854:4: ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_ID) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalMappingDsl.g:855:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:855:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:856:6: lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);

                    otherlv_15=(Token)match(input,19,FOLLOW_22); 

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
    // InternalMappingDsl.g:886:1: entryRulePrimitiveParameterMapping returns [EObject current=null] : iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF ;
    public final EObject entryRulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveParameterMapping = null;


        try {
            // InternalMappingDsl.g:886:66: (iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF )
            // InternalMappingDsl.g:887:2: iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF
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
    // InternalMappingDsl.g:893:1: rulePrimitiveParameterMapping returns [EObject current=null] : (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) ;
    public final EObject rulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_aspects_7_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:899:2: ( (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) )
            // InternalMappingDsl.g:900:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? )
            {
            // InternalMappingDsl.g:900:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? )
            // InternalMappingDsl.g:901:3: otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveKeyword_0());
            		
            // InternalMappingDsl.g:905:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:906:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:906:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:907:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_1, grammarAccess.getPrimitiveParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getPrimitiveParameterMappingAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:922:3: ( (otherlv_3= RULE_ID ) )
            // InternalMappingDsl.g:923:4: (otherlv_3= RULE_ID )
            {
            // InternalMappingDsl.g:923:4: (otherlv_3= RULE_ID )
            // InternalMappingDsl.g:924:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_3, grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveTypeTechnologySpecificPrimitiveTypeCrossReference_3_0());
            				

            }


            }

            // InternalMappingDsl.g:935:3: (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==17) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMappingDsl.g:936:4: otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_32); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveParameterMappingAccess().getAspectsKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_4_2());
                    			
                    // InternalMappingDsl.g:948:4: ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_ID) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalMappingDsl.g:949:5: (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:949:5: (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:950:6: lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_4_3_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_aspects_7_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPrimitiveParameterMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_7_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    otherlv_8=(Token)match(input,19,FOLLOW_22); 

                    				newLeafNode(otherlv_8, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_4_4());
                    			
                    otherlv_9=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_4_5());
                    			

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
    // InternalMappingDsl.g:980:1: entryRuleComplexParameterMapping returns [EObject current=null] : iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF ;
    public final EObject entryRuleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexParameterMapping = null;


        try {
            // InternalMappingDsl.g:980:64: (iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF )
            // InternalMappingDsl.g:981:2: iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF
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
    // InternalMappingDsl.g:987:1: ruleComplexParameterMapping returns [EObject current=null] : (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) | (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' ) ) ) ;
    public final EObject ruleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_aspects_7_0 = null;

        EObject lv_aspects_14_0 = null;

        EObject lv_dataFieldMappings_16_0 = null;

        EObject lv_dataFieldMappings_18_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:993:2: ( (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) | (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' ) ) ) )
            // InternalMappingDsl.g:994:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) | (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' ) ) )
            {
            // InternalMappingDsl.g:994:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) | (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' ) ) )
            // InternalMappingDsl.g:995:3: otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) | (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexParameterMappingAccess().getComplexKeyword_0());
            		
            // InternalMappingDsl.g:999:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1000:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1000:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1001:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(otherlv_1, grammarAccess.getComplexParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1012:3: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? ) | (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==28) ) {
                alt41=1;
            }
            else if ( (LA41_0==30) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalMappingDsl.g:1013:4: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? )
                    {
                    // InternalMappingDsl.g:1013:4: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )? )
                    // InternalMappingDsl.g:1014:5: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )?
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_7); 

                    					newLeafNode(otherlv_2, grammarAccess.getComplexParameterMappingAccess().getColonKeyword_2_0_0());
                    				
                    // InternalMappingDsl.g:1018:5: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:1019:6: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:1019:6: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:1020:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_31); 

                    							newLeafNode(otherlv_3, grammarAccess.getComplexParameterMappingAccess().getTechnologySpecificComplexTypeComplexTypeCrossReference_2_0_1_0());
                    						

                    }


                    }

                    // InternalMappingDsl.g:1031:5: (otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}' )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==17) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalMappingDsl.g:1032:6: otherlv_4= '{' otherlv_5= 'aspects' otherlv_6= '{' ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_8= '}' otherlv_9= '}'
                            {
                            otherlv_4=(Token)match(input,17,FOLLOW_32); 

                            						newLeafNode(otherlv_4, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_2_0());
                            					
                            otherlv_5=(Token)match(input,21,FOLLOW_9); 

                            						newLeafNode(otherlv_5, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_0_2_1());
                            					
                            otherlv_6=(Token)match(input,17,FOLLOW_7); 

                            						newLeafNode(otherlv_6, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_2_2());
                            					
                            // InternalMappingDsl.g:1044:6: ( (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                            	    // InternalMappingDsl.g:1045:7: (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1045:7: (lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1046:8: lv_aspects_7_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_2_3_0());
                            	    							
                            	    pushFollow(FOLLOW_14);
                            	    lv_aspects_7_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"aspects",
                            	    									lv_aspects_7_0,
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

                            otherlv_8=(Token)match(input,19,FOLLOW_22); 

                            						newLeafNode(otherlv_8, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_2_4());
                            					
                            otherlv_9=(Token)match(input,19,FOLLOW_2); 

                            						newLeafNode(otherlv_9, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_2_5());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1074:4: (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' )
                    {
                    // InternalMappingDsl.g:1074:4: (otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}' )
                    // InternalMappingDsl.g:1075:5: otherlv_10= '->' otherlv_11= '{' (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) ) (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )* otherlv_19= '}'
                    {
                    otherlv_10=(Token)match(input,30,FOLLOW_9); 

                    					newLeafNode(otherlv_10, grammarAccess.getComplexParameterMappingAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
                    				
                    otherlv_11=(Token)match(input,17,FOLLOW_34); 

                    					newLeafNode(otherlv_11, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_1());
                    				
                    // InternalMappingDsl.g:1083:5: (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==21) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalMappingDsl.g:1084:6: otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}'
                            {
                            otherlv_12=(Token)match(input,21,FOLLOW_9); 

                            						newLeafNode(otherlv_12, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_1_2_0());
                            					
                            otherlv_13=(Token)match(input,17,FOLLOW_7); 

                            						newLeafNode(otherlv_13, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_2_1());
                            					
                            // InternalMappingDsl.g:1092:6: ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt38=0;
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==RULE_ID) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1093:7: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1093:7: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1094:8: lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_1_2_2_0());
                            	    							
                            	    pushFollow(FOLLOW_14);
                            	    lv_aspects_14_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
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
                            	    if ( cnt38 >= 1 ) break loop38;
                                        EarlyExitException eee =
                                            new EarlyExitException(38, input);
                                        throw eee;
                                }
                                cnt38++;
                            } while (true);

                            otherlv_15=(Token)match(input,19,FOLLOW_34); 

                            						newLeafNode(otherlv_15, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_2_3());
                            					

                            }
                            break;

                    }

                    // InternalMappingDsl.g:1116:5: ( (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping ) )
                    // InternalMappingDsl.g:1117:6: (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping )
                    {
                    // InternalMappingDsl.g:1117:6: (lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping )
                    // InternalMappingDsl.g:1118:7: lv_dataFieldMappings_16_0= ruleTechnologySpecificDataFieldTypeMapping
                    {

                    							newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getDataFieldMappingsTechnologySpecificDataFieldTypeMappingParserRuleCall_2_1_3_0());
                    						
                    pushFollow(FOLLOW_28);
                    lv_dataFieldMappings_16_0=ruleTechnologySpecificDataFieldTypeMapping();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                    							}
                    							add(
                    								current,
                    								"dataFieldMappings",
                    								lv_dataFieldMappings_16_0,
                    								"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificDataFieldTypeMapping");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalMappingDsl.g:1135:5: (otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==25) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1136:6: otherlv_17= ',' ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) )
                    	    {
                    	    otherlv_17=(Token)match(input,25,FOLLOW_34); 

                    	    						newLeafNode(otherlv_17, grammarAccess.getComplexParameterMappingAccess().getCommaKeyword_2_1_4_0());
                    	    					
                    	    // InternalMappingDsl.g:1140:6: ( (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping ) )
                    	    // InternalMappingDsl.g:1141:7: (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping )
                    	    {
                    	    // InternalMappingDsl.g:1141:7: (lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping )
                    	    // InternalMappingDsl.g:1142:8: lv_dataFieldMappings_18_0= ruleTechnologySpecificDataFieldTypeMapping
                    	    {

                    	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getDataFieldMappingsTechnologySpecificDataFieldTypeMappingParserRuleCall_2_1_4_1_0());
                    	    							
                    	    pushFollow(FOLLOW_28);
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


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(otherlv_19, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_5());
                    				

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
    // InternalMappingDsl.g:1170:1: entryRuleTechnologySpecificDataFieldTypeMapping returns [EObject current=null] : iv_ruleTechnologySpecificDataFieldTypeMapping= ruleTechnologySpecificDataFieldTypeMapping EOF ;
    public final EObject entryRuleTechnologySpecificDataFieldTypeMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataFieldTypeMapping = null;


        try {
            // InternalMappingDsl.g:1170:79: (iv_ruleTechnologySpecificDataFieldTypeMapping= ruleTechnologySpecificDataFieldTypeMapping EOF )
            // InternalMappingDsl.g:1171:2: iv_ruleTechnologySpecificDataFieldTypeMapping= ruleTechnologySpecificDataFieldTypeMapping EOF
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
    // InternalMappingDsl.g:1177:1: ruleTechnologySpecificDataFieldTypeMapping returns [EObject current=null] : ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}' )? ) ;
    public final EObject ruleTechnologySpecificDataFieldTypeMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_dataFieldHierarchy_0_0 = null;

        EObject lv_aspects_6_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1183:2: ( ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}' )? ) )
            // InternalMappingDsl.g:1184:2: ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}' )? )
            {
            // InternalMappingDsl.g:1184:2: ( ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}' )? )
            // InternalMappingDsl.g:1185:3: ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}' )?
            {
            // InternalMappingDsl.g:1185:3: ( (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy ) )
            // InternalMappingDsl.g:1186:4: (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy )
            {
            // InternalMappingDsl.g:1186:4: (lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy )
            // InternalMappingDsl.g:1187:5: lv_dataFieldHierarchy_0_0= ruleDataFieldHierarchy
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getDataFieldHierarchyDataFieldHierarchyParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_30);
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
            		
            // InternalMappingDsl.g:1208:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:1209:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:1209:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:1210:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getTypeTypeCrossReference_2_0());
            				

            }


            }

            // InternalMappingDsl.g:1221:3: (otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==17) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMappingDsl.g:1222:4: otherlv_3= '{' otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_32); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getAspectsKeyword_3_1());
                    			
                    otherlv_5=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getLeftCurlyBracketKeyword_3_2());
                    			
                    // InternalMappingDsl.g:1234:4: ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1235:5: (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1235:5: (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1236:6: lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_aspects_6_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologySpecificDataFieldTypeMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_6_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_7=(Token)match(input,19,FOLLOW_22); 

                    				newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getRightCurlyBracketKeyword_3_4());
                    			
                    otherlv_8=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificDataFieldTypeMappingAccess().getRightCurlyBracketKeyword_3_5());
                    			

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
    // InternalMappingDsl.g:1266:1: entryRuleDataFieldHierarchy returns [EObject current=null] : iv_ruleDataFieldHierarchy= ruleDataFieldHierarchy EOF ;
    public final EObject entryRuleDataFieldHierarchy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFieldHierarchy = null;


        try {
            // InternalMappingDsl.g:1266:59: (iv_ruleDataFieldHierarchy= ruleDataFieldHierarchy EOF )
            // InternalMappingDsl.g:1267:2: iv_ruleDataFieldHierarchy= ruleDataFieldHierarchy EOF
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
    // InternalMappingDsl.g:1273:1: ruleDataFieldHierarchy returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleDataFieldHierarchy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1279:2: ( ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalMappingDsl.g:1280:2: ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalMappingDsl.g:1280:2: ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalMappingDsl.g:1281:3: ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalMappingDsl.g:1281:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1282:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1282:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1283:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataFieldHierarchyRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(otherlv_0, grammarAccess.getDataFieldHierarchyAccess().getDataFieldsDataFieldCrossReference_0_0());
            				

            }


            }

            // InternalMappingDsl.g:1294:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==31) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalMappingDsl.g:1295:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalMappingDsl.g:1295:4: ()
            	    // InternalMappingDsl.g:1296:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getDataFieldHierarchyAccess().getDataFieldHierarchyPreviousAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDataFieldHierarchyAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalMappingDsl.g:1306:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:1307:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:1307:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:1308:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDataFieldHierarchyRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); 

            	    						newLeafNode(otherlv_3, grammarAccess.getDataFieldHierarchyAccess().getDataFieldsDataFieldCrossReference_1_2_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalMappingDsl.g:1324:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:1324:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalMappingDsl.g:1325:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalMappingDsl.g:1331:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1337:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalMappingDsl.g:1338:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalMappingDsl.g:1338:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalMappingDsl.g:1339:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalMappingDsl.g:1339:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1340:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1340:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1341:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1356:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:1357:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:1357:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:1358:5: ruleQualifiedNameWithAtLeastOneLevel
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
    // InternalMappingDsl.g:1376:1: entryRuleTechnologySpecificProtocolSpecification returns [EObject current=null] : iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF ;
    public final EObject entryRuleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:1376:80: (iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF )
            // InternalMappingDsl.g:1377:2: iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF
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
    // InternalMappingDsl.g:1383:1: ruleTechnologySpecificProtocolSpecification returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) ;
    public final EObject ruleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_communicationType_0_0 = null;

        EObject lv_technologySpecificProtocol_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1389:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) )
            // InternalMappingDsl.g:1390:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            {
            // InternalMappingDsl.g:1390:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            // InternalMappingDsl.g:1391:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            {
            // InternalMappingDsl.g:1391:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:1392:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:1392:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:1393:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_30);
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
            		
            // InternalMappingDsl.g:1414:3: ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1415:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1415:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1416:5: lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol
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
    // InternalMappingDsl.g:1437:1: entryRuleTechnologySpecificProtocol returns [EObject current=null] : iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF ;
    public final EObject entryRuleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocol = null;


        try {
            // InternalMappingDsl.g:1437:67: (iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF )
            // InternalMappingDsl.g:1438:2: iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF
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
    // InternalMappingDsl.g:1444:1: ruleTechnologySpecificProtocol returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '/' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1450:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '/' ( (otherlv_2= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:1451:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '/' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:1451:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '/' ( (otherlv_2= RULE_ID ) ) )? )
            // InternalMappingDsl.g:1452:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '/' ( (otherlv_2= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:1452:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1453:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1453:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1454:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificProtocolAccess().getProtocolProtocolCrossReference_0_0());
            				

            }


            }

            // InternalMappingDsl.g:1465:3: (otherlv_1= '/' ( (otherlv_2= RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==33) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMappingDsl.g:1466:4: otherlv_1= '/' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolAccess().getSolidusKeyword_1_0());
                    			
                    // InternalMappingDsl.g:1470:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMappingDsl.g:1471:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMappingDsl.g:1471:5: (otherlv_2= RULE_ID )
                    // InternalMappingDsl.g:1472:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificProtocolAccess().getDataFormatDataFormatCrossReference_1_1_0());
                    					

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
    // InternalMappingDsl.g:1488:1: entryRuleTechnologySpecificEndpoint returns [EObject current=null] : iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF ;
    public final EObject entryRuleTechnologySpecificEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificEndpoint = null;


        try {
            // InternalMappingDsl.g:1488:67: (iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF )
            // InternalMappingDsl.g:1489:2: iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF
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
    // InternalMappingDsl.g:1495:1: ruleTechnologySpecificEndpoint returns [EObject current=null] : ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:1501:2: ( ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:1502:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:1502:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:1503:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:1503:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1504:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1504:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1505:5: lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalMappingDsl.g:1522:3: (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==25) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalMappingDsl.g:1523:4: otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:1527:4: ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    // InternalMappingDsl.g:1528:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    {
            	    // InternalMappingDsl.g:1528:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    // InternalMappingDsl.g:1529:6: lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol
            	    {

            	    						newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_38);
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
            	    break loop46;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_39); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:1551:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:1552:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:1552:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:1553:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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

            // InternalMappingDsl.g:1569:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==25) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMappingDsl.g:1570:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_39); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:1574:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:1575:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:1575:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:1576:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    break loop47;
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
    // InternalMappingDsl.g:1601:1: entryRuleTechnologySpecificImportedServiceAspect returns [EObject current=null] : iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF ;
    public final EObject entryRuleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:1601:80: (iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF )
            // InternalMappingDsl.g:1602:2: iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF
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
    // InternalMappingDsl.g:1608:1: ruleTechnologySpecificImportedServiceAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' ) | otherlv_5= ';' ) ) ;
    public final EObject ruleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_singlePropertyValue_2_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1614:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' ) | otherlv_5= ';' ) ) )
            // InternalMappingDsl.g:1615:2: ( ( (otherlv_0= RULE_ID ) ) ( (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' ) | otherlv_5= ';' ) )
            {
            // InternalMappingDsl.g:1615:2: ( ( (otherlv_0= RULE_ID ) ) ( (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' ) | otherlv_5= ';' ) )
            // InternalMappingDsl.g:1616:3: ( (otherlv_0= RULE_ID ) ) ( (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' ) | otherlv_5= ';' )
            {
            // InternalMappingDsl.g:1616:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1617:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1617:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1618:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_0_0());
            				

            }


            }

            // InternalMappingDsl.g:1629:3: ( (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' ) | otherlv_5= ';' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==15) ) {
                alt49=1;
            }
            else if ( (LA49_0==34) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalMappingDsl.g:1630:4: (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' )
                    {
                    // InternalMappingDsl.g:1630:4: (otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')' )
                    // InternalMappingDsl.g:1631:5: otherlv_1= '(' ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_42); 

                    					newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getLeftParenthesisKeyword_1_0_0());
                    				
                    // InternalMappingDsl.g:1635:5: ( ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) ) | ( (lv_values_3_0= rulePropertyValueAssignment ) ) )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( ((LA48_0>=RULE_STRING && LA48_0<=RULE_BOOLEAN)) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==RULE_ID) ) {
                        alt48=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalMappingDsl.g:1636:6: ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:1636:6: ( (lv_singlePropertyValue_2_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:1637:7: (lv_singlePropertyValue_2_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:1637:7: (lv_singlePropertyValue_2_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:1638:8: lv_singlePropertyValue_2_0= rulePrimitiveValue
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_1_0_1_0_0());
                            							
                            pushFollow(FOLLOW_8);
                            lv_singlePropertyValue_2_0=rulePrimitiveValue();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            								}
                            								set(
                            									current,
                            									"singlePropertyValue",
                            									lv_singlePropertyValue_2_0,
                            									"de.fhdo.ddmm.ServiceDsl.PrimitiveValue");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1656:6: ( (lv_values_3_0= rulePropertyValueAssignment ) )
                            {
                            // InternalMappingDsl.g:1656:6: ( (lv_values_3_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:1657:7: (lv_values_3_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:1657:7: (lv_values_3_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:1658:8: lv_values_3_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_1_0_1_1_0());
                            							
                            pushFollow(FOLLOW_8);
                            lv_values_3_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_3_0,
                            									"de.fhdo.ddmm.ServiceDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getRightParenthesisKeyword_1_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1682:4: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSemicolonKeyword_1_1());
                    			

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
    // InternalMappingDsl.g:1691:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMappingDsl.g:1691:47: (iv_ruleImport= ruleImport EOF )
            // InternalMappingDsl.g:1692:2: iv_ruleImport= ruleImport EOF
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
    // InternalMappingDsl.g:1698:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:1704:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:1705:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:1705:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:1706:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMappingDsl.g:1710:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalMappingDsl.g:1711:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalMappingDsl.g:1711:4: (lv_importType_1_0= ruleImportType )
            // InternalMappingDsl.g:1712:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_44);
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

            otherlv_2=(Token)match(input,36,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:1733:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:1734:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:1734:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:1735:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

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
            		
            // InternalMappingDsl.g:1755:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:1756:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:1756:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:1757:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:1777:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalMappingDsl.g:1777:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalMappingDsl.g:1778:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalMappingDsl.g:1784:1: ruleMicroservice returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) ;
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
            // InternalMappingDsl.g:1790:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) )
            // InternalMappingDsl.g:1791:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            {
            // InternalMappingDsl.g:1791:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            // InternalMappingDsl.g:1792:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}'
            {
            // InternalMappingDsl.g:1792:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==13) ) {
                    int LA50_1 = input.LA(2);

                    if ( (LA50_1==14) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalMappingDsl.g:1793:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMicroserviceAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalMappingDsl.g:1805:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:1806:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:1806:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:1807:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMicroserviceRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_46); 

            	    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_0_4());
            	    			

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // InternalMappingDsl.g:1823:3: ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==13) ) {
                int LA52_1 = input.LA(2);

                if ( ((LA52_1>=93 && LA52_1<=94)) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalMappingDsl.g:1824:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:1824:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:1825:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:1825:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:1826:6: lv_protocols_5_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_46);
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

                    // InternalMappingDsl.g:1843:4: ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==13) ) {
                        int LA51_1 = input.LA(2);

                        if ( ((LA51_1>=93 && LA51_1<=94)) ) {
                            alt51=1;
                        }
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalMappingDsl.g:1844:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:1844:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:1845:6: lv_protocols_6_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_46);
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

            // InternalMappingDsl.g:1863:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==13) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==20) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalMappingDsl.g:1864:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_47); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMappingDsl.g:1876:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==RULE_ID) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1877:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:1877:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:1878:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    if ( cnt53 >= 1 ) break loop53;
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_46); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:1900:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==13) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMappingDsl.g:1901:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:1901:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:1902:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_46);
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
            	    break loop55;
                }
            } while (true);

            // InternalMappingDsl.g:1919:3: ( (lv_visibility_13_0= ruleVisibility ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=84 && LA56_0<=86)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalMappingDsl.g:1920:4: (lv_visibility_13_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:1920:4: (lv_visibility_13_0= ruleVisibility )
                    // InternalMappingDsl.g:1921:5: lv_visibility_13_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_46);
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

            // InternalMappingDsl.g:1938:3: ( (lv_type_14_0= ruleMicroserviceType ) )
            // InternalMappingDsl.g:1939:4: (lv_type_14_0= ruleMicroserviceType )
            {
            // InternalMappingDsl.g:1939:4: (lv_type_14_0= ruleMicroserviceType )
            // InternalMappingDsl.g:1940:5: lv_type_14_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_49);
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
            		
            // InternalMappingDsl.g:1961:3: ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:1962:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:1962:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:1963:5: lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_50);
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

            // InternalMappingDsl.g:1980:3: (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==39) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalMappingDsl.g:1981:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalMappingDsl.g:1985:4: ( (lv_version_18_0= RULE_ID ) )
                    // InternalMappingDsl.g:1986:5: (lv_version_18_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:1986:5: (lv_version_18_0= RULE_ID )
                    // InternalMappingDsl.g:1987:6: lv_version_18_0= RULE_ID
                    {
                    lv_version_18_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_19=(Token)match(input,17,FOLLOW_51); 

            			newLeafNode(otherlv_19, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalMappingDsl.g:2008:3: (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==40) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==41) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalMappingDsl.g:2009:4: otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}'
                    {
                    otherlv_20=(Token)match(input,40,FOLLOW_52); 

                    				newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_21=(Token)match(input,41,FOLLOW_9); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_22=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalMappingDsl.g:2021:4: ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) )
                    // InternalMappingDsl.g:2022:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalMappingDsl.g:2022:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    // InternalMappingDsl.g:2023:6: lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    // InternalMappingDsl.g:2040:4: (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==25) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2041:5: otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_24=(Token)match(input,25,FOLLOW_7); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2045:5: ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalMappingDsl.g:2046:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalMappingDsl.g:2046:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    // InternalMappingDsl.g:2047:7: lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_26, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2070:3: (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==40) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==42) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalMappingDsl.g:2071:4: otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}'
                    {
                    otherlv_27=(Token)match(input,40,FOLLOW_53); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_28=(Token)match(input,42,FOLLOW_9); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_29=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalMappingDsl.g:2083:4: ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) )
                    // InternalMappingDsl.g:2084:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    {
                    // InternalMappingDsl.g:2084:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    // InternalMappingDsl.g:2085:6: lv_requiredInterfaces_30_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    // InternalMappingDsl.g:2102:4: (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==25) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2103:5: otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_31=(Token)match(input,25,FOLLOW_7); 

                    	    					newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2107:5: ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    // InternalMappingDsl.g:2108:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalMappingDsl.g:2108:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    // InternalMappingDsl.g:2109:7: lv_requiredInterfaces_32_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_33, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2132:3: (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==40) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMappingDsl.g:2133:4: otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}'
                    {
                    otherlv_34=(Token)match(input,40,FOLLOW_54); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_35=(Token)match(input,43,FOLLOW_9); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_36=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalMappingDsl.g:2145:4: ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:2146:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:2146:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:2147:6: lv_requiredOperations_37_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    // InternalMappingDsl.g:2164:4: (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==25) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2165:5: otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_38=(Token)match(input,25,FOLLOW_7); 

                    	    					newLeafNode(otherlv_38, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2169:5: ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    // InternalMappingDsl.g:2170:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalMappingDsl.g:2170:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    // InternalMappingDsl.g:2171:7: lv_requiredOperations_39_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop62;
                        }
                    } while (true);

                    otherlv_40=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_40, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2194:3: ( (lv_interfaces_41_0= ruleInterface ) )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==13||LA64_0==22||LA64_0==44||(LA64_0>=84 && LA64_0<=86)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalMappingDsl.g:2195:4: (lv_interfaces_41_0= ruleInterface )
            	    {
            	    // InternalMappingDsl.g:2195:4: (lv_interfaces_41_0= ruleInterface )
            	    // InternalMappingDsl.g:2196:5: lv_interfaces_41_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_55);
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
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
    // InternalMappingDsl.g:2221:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:2221:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalMappingDsl.g:2222:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalMappingDsl.g:2228:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2234:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2235:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2235:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2236:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2236:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==32) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalMappingDsl.g:2237:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2237:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2238:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2238:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2239:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2255:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2256:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2256:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2257:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2275:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalMappingDsl.g:2275:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalMappingDsl.g:2276:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalMappingDsl.g:2282:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2288:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2289:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2289:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2290:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2290:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==32) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalMappingDsl.g:2291:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2291:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2292:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2292:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2293:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2309:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2310:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2310:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2311:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2329:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalMappingDsl.g:2329:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalMappingDsl.g:2330:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalMappingDsl.g:2336:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2342:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2343:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2343:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2344:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2344:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==32) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // InternalMappingDsl.g:2345:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2345:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2346:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2346:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2347:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2363:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2364:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2364:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2365:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2383:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalMappingDsl.g:2383:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalMappingDsl.g:2384:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalMappingDsl.g:2390:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) ;
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
            // InternalMappingDsl.g:2396:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) )
            // InternalMappingDsl.g:2397:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            {
            // InternalMappingDsl.g:2397:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            // InternalMappingDsl.g:2398:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}'
            {
            // InternalMappingDsl.g:2398:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==13) ) {
                int LA69_1 = input.LA(2);

                if ( ((LA69_1>=93 && LA69_1<=94)) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalMappingDsl.g:2399:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2399:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2400:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2400:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2401:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_56);
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

                    // InternalMappingDsl.g:2418:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==13) ) {
                        int LA68_1 = input.LA(2);

                        if ( ((LA68_1>=93 && LA68_1<=94)) ) {
                            alt68=1;
                        }
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalMappingDsl.g:2419:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2419:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2420:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_56);
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

            // InternalMappingDsl.g:2438:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==13) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==20) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalMappingDsl.g:2439:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_47); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2451:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt70=0;
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==RULE_ID) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2452:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2452:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2453:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    if ( cnt70 >= 1 ) break loop70;
                                EarlyExitException eee =
                                    new EarlyExitException(70, input);
                                throw eee;
                        }
                        cnt70++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_56); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2475:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==13) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalMappingDsl.g:2476:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2476:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2477:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_56);
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
            	    break loop72;
                }
            } while (true);

            // InternalMappingDsl.g:2494:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==44) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMappingDsl.g:2495:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:2495:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:2496:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,44,FOLLOW_57); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2508:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=84 && LA74_0<=86)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalMappingDsl.g:2509:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2509:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2510:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_58);
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
            		
            // InternalMappingDsl.g:2531:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalMappingDsl.g:2532:4: (lv_name_11_0= RULE_ID )
            {
            // InternalMappingDsl.g:2532:4: (lv_name_11_0= RULE_ID )
            // InternalMappingDsl.g:2533:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_12=(Token)match(input,17,FOLLOW_59); 

            			newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMappingDsl.g:2553:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*
            loop75:
            do {
                int alt75=2;
                alt75 = dfa75.predict(input);
                switch (alt75) {
            	case 1 :
            	    // InternalMappingDsl.g:2554:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    {
            	    // InternalMappingDsl.g:2554:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    // InternalMappingDsl.g:2555:5: lv_referredOperations_13_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_59);
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
            	    break loop75;
                }
            } while (true);

            // InternalMappingDsl.g:2572:3: ( (lv_operations_14_0= ruleOperation ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID||LA76_0==13||LA76_0==44||(LA76_0>=84 && LA76_0<=86)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalMappingDsl.g:2573:4: (lv_operations_14_0= ruleOperation )
            	    {
            	    // InternalMappingDsl.g:2573:4: (lv_operations_14_0= ruleOperation )
            	    // InternalMappingDsl.g:2574:5: lv_operations_14_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_60);
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
            	    break loop76;
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
    // InternalMappingDsl.g:2599:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMappingDsl.g:2599:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMappingDsl.g:2600:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalMappingDsl.g:2606:1: ruleOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) ;
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
            // InternalMappingDsl.g:2612:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) )
            // InternalMappingDsl.g:2613:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            {
            // InternalMappingDsl.g:2613:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            // InternalMappingDsl.g:2614:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';'
            {
            // InternalMappingDsl.g:2614:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==13) ) {
                int LA78_1 = input.LA(2);

                if ( ((LA78_1>=93 && LA78_1<=94)) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // InternalMappingDsl.g:2615:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2615:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2616:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2616:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2617:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalMappingDsl.g:2634:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==13) ) {
                        int LA77_1 = input.LA(2);

                        if ( ((LA77_1>=93 && LA77_1<=94)) ) {
                            alt77=1;
                        }
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalMappingDsl.g:2635:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2635:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2636:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_61);
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

            // InternalMappingDsl.g:2654:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==13) ) {
                int LA80_1 = input.LA(2);

                if ( (LA80_1==20) ) {
                    alt80=1;
                }
            }
            switch (alt80) {
                case 1 :
                    // InternalMappingDsl.g:2655:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_47); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2667:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt79=0;
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==RULE_ID) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2668:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2668:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2669:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    if ( cnt79 >= 1 ) break loop79;
                                EarlyExitException eee =
                                    new EarlyExitException(79, input);
                                throw eee;
                        }
                        cnt79++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_61); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2691:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==13) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalMappingDsl.g:2692:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2692:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2693:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_61);
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
            	    break loop81;
                }
            } while (true);

            // InternalMappingDsl.g:2710:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==44) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalMappingDsl.g:2711:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:2711:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:2712:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,44,FOLLOW_62); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2724:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=84 && LA83_0<=86)) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalMappingDsl.g:2725:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2725:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2726:5: lv_visibility_9_0= ruleVisibility
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

            // InternalMappingDsl.g:2743:3: ( (lv_name_10_0= RULE_ID ) )
            // InternalMappingDsl.g:2744:4: (lv_name_10_0= RULE_ID )
            {
            // InternalMappingDsl.g:2744:4: (lv_name_10_0= RULE_ID )
            // InternalMappingDsl.g:2745:5: lv_name_10_0= RULE_ID
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

            otherlv_11=(Token)match(input,15,FOLLOW_63); 

            			newLeafNode(otherlv_11, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_6());
            		
            // InternalMappingDsl.g:2765:3: ( (lv_parameters_12_0= ruleParameter ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==13||(LA84_0>=93 && LA84_0<=94)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMappingDsl.g:2766:4: (lv_parameters_12_0= ruleParameter )
                    {
                    // InternalMappingDsl.g:2766:4: (lv_parameters_12_0= ruleParameter )
                    // InternalMappingDsl.g:2767:5: lv_parameters_12_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_64);
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

            // InternalMappingDsl.g:2784:3: (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==25) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalMappingDsl.g:2785:4: otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) )
            	    {
            	    otherlv_13=(Token)match(input,25,FOLLOW_65); 

            	    				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMappingDsl.g:2789:4: ( (lv_parameters_14_0= ruleParameter ) )
            	    // InternalMappingDsl.g:2790:5: (lv_parameters_14_0= ruleParameter )
            	    {
            	    // InternalMappingDsl.g:2790:5: (lv_parameters_14_0= ruleParameter )
            	    // InternalMappingDsl.g:2791:6: lv_parameters_14_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_64);
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
            	    break loop85;
                }
            } while (true);

            otherlv_15=(Token)match(input,16,FOLLOW_66); 

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
    // InternalMappingDsl.g:2821:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalMappingDsl.g:2821:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalMappingDsl.g:2822:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalMappingDsl.g:2828:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalMappingDsl.g:2834:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalMappingDsl.g:2835:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalMappingDsl.g:2835:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalMappingDsl.g:2836:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalMappingDsl.g:2836:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==13) ) {
                int LA87_1 = input.LA(2);

                if ( ((LA87_1>=93 && LA87_1<=94)) ) {
                    alt87=1;
                }
            }
            switch (alt87) {
                case 1 :
                    // InternalMappingDsl.g:2837:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2837:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2838:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2838:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2839:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_67);
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

                    // InternalMappingDsl.g:2856:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==13) ) {
                        int LA86_1 = input.LA(2);

                        if ( ((LA86_1>=93 && LA86_1<=94)) ) {
                            alt86=1;
                        }
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalMappingDsl.g:2857:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2857:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2858:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_67);
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

            // InternalMappingDsl.g:2876:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==13) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==20) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // InternalMappingDsl.g:2877:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_47); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2889:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt88=0;
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==RULE_ID) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2890:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2890:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2891:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    if ( cnt88 >= 1 ) break loop88;
                                EarlyExitException eee =
                                    new EarlyExitException(88, input);
                                throw eee;
                        }
                        cnt88++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_67); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2913:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==13) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalMappingDsl.g:2914:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2914:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2915:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_67);
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
            	    break loop90;
                }
            } while (true);

            otherlv_8=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalMappingDsl.g:2936:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2937:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2937:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2938:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_66);
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
    // InternalMappingDsl.g:2960:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMappingDsl.g:2960:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMappingDsl.g:2961:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalMappingDsl.g:2967:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalMappingDsl.g:2973:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalMappingDsl.g:2974:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalMappingDsl.g:2974:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalMappingDsl.g:2975:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalMappingDsl.g:2975:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==13) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalMappingDsl.g:2976:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2976:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2977:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_65);
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
            	    break loop91;
                }
            } while (true);

            // InternalMappingDsl.g:2994:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:2995:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:2995:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:2996:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalMappingDsl.g:3013:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=90 && LA92_0<=92)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalMappingDsl.g:3014:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:3014:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:3015:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_69);
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

            // InternalMappingDsl.g:3032:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==46) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalMappingDsl.g:3033:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalMappingDsl.g:3033:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalMappingDsl.g:3034:5: lv_communicatesFault_3_0= 'fault'
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

            // InternalMappingDsl.g:3046:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalMappingDsl.g:3047:4: (lv_name_4_0= RULE_ID )
            {
            // InternalMappingDsl.g:3047:4: (lv_name_4_0= RULE_ID )
            // InternalMappingDsl.g:3048:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_70); 

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

            // InternalMappingDsl.g:3064:3: ( (lv_optional_5_0= '?' ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==47) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalMappingDsl.g:3065:4: (lv_optional_5_0= '?' )
                    {
                    // InternalMappingDsl.g:3065:4: (lv_optional_5_0= '?' )
                    // InternalMappingDsl.g:3066:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,47,FOLLOW_30); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,28,FOLLOW_71); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalMappingDsl.g:3082:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=74 && LA95_0<=83)) ) {
                alt95=1;
            }
            else if ( (LA95_0==RULE_ID) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalMappingDsl.g:3083:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:3083:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:3084:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:3084:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalMappingDsl.g:3085:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_72);
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
                    // InternalMappingDsl.g:3103:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalMappingDsl.g:3103:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalMappingDsl.g:3104:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalMappingDsl.g:3104:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalMappingDsl.g:3105:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_72);
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

            // InternalMappingDsl.g:3123:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==48) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalMappingDsl.g:3124:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalMappingDsl.g:3128:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:3129:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:3129:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:3130:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalMappingDsl.g:3152:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalMappingDsl.g:3152:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalMappingDsl.g:3153:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalMappingDsl.g:3159:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3165:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:3166:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:3166:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:3167:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:3167:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3168:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3168:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3169:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3184:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3185:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3185:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3186:5: ruleQualifiedName
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
    // InternalMappingDsl.g:3204:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:3204:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalMappingDsl.g:3205:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalMappingDsl.g:3211:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3217:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalMappingDsl.g:3218:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalMappingDsl.g:3218:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalMappingDsl.g:3219:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3223:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3224:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3224:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3225:5: lv_communicationType_1_0= ruleCommunicationType
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
            		
            // InternalMappingDsl.g:3246:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3247:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3247:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3248:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
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
    // InternalMappingDsl.g:3273:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalMappingDsl.g:3273:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalMappingDsl.g:3274:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalMappingDsl.g:3280:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3286:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:3287:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:3287:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:3288:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:3288:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3289:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3289:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3290:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3305:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3306:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3306:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3307:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_37);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3321:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==33) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalMappingDsl.g:3322:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:3326:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:3327:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:3327:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:3328:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:3344:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalMappingDsl.g:3344:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalMappingDsl.g:3345:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalMappingDsl.g:3351:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:3357:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:3358:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:3358:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:3359:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:3359:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3360:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3360:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3361:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalMappingDsl.g:3378:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==25) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalMappingDsl.g:3379:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:3383:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalMappingDsl.g:3384:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalMappingDsl.g:3384:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalMappingDsl.g:3385:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_38);
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
            	    break loop98;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_39); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:3407:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:3408:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:3408:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:3409:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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

            // InternalMappingDsl.g:3425:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==25) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalMappingDsl.g:3426:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_39); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:3430:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:3431:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:3431:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:3432:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    break loop99;
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
    // InternalMappingDsl.g:3457:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:3457:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalMappingDsl.g:3458:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalMappingDsl.g:3464:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalMappingDsl.g:3470:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalMappingDsl.g:3471:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalMappingDsl.g:3471:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalMappingDsl.g:3472:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3476:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:3477:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:3477:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:3478:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalMappingDsl.g:3493:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3494:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3494:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3495:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_73);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3509:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==15) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalMappingDsl.g:3510:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_42); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMappingDsl.g:3514:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( ((LA101_0>=RULE_STRING && LA101_0<=RULE_BOOLEAN)) ) {
                        alt101=1;
                    }
                    else if ( (LA101_0==RULE_ID) ) {
                        alt101=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 101, 0, input);

                        throw nvae;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalMappingDsl.g:3515:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:3515:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:3516:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:3516:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:3517:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
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
                            								"de.fhdo.ddmm.ServiceDsl.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:3535:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:3535:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:3536:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:3536:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:3537:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:3537:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:3538:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_64);
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

                            // InternalMappingDsl.g:3555:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop100:
                            do {
                                int alt100=2;
                                int LA100_0 = input.LA(1);

                                if ( (LA100_0==25) ) {
                                    alt100=1;
                                }


                                switch (alt100) {
                            	case 1 :
                            	    // InternalMappingDsl.g:3556:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_42); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:3560:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:3561:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:3561:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:3562:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_64);
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
                            	    break loop100;
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


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalMappingDsl.g:3591:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalMappingDsl.g:3591:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalMappingDsl.g:3592:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalMappingDsl.g:3598:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3604:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalMappingDsl.g:3605:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDsl.g:3605:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt103=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt103=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt103=2;
                }
                break;
            case RULE_STRING:
                {
                alt103=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // InternalMappingDsl.g:3606:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalMappingDsl.g:3606:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalMappingDsl.g:3607:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalMappingDsl.g:3607:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalMappingDsl.g:3608:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalMappingDsl.g:3625:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalMappingDsl.g:3625:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:3626:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:3626:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:3627:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalMappingDsl.g:3644:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalMappingDsl.g:3644:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalMappingDsl.g:3645:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalMappingDsl.g:3645:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalMappingDsl.g:3646:5: lv_stringValue_2_0= RULE_STRING
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


    // $ANTLR start "entryRulePropertyValueAssignment"
    // InternalMappingDsl.g:3666:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalMappingDsl.g:3666:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalMappingDsl.g:3667:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalMappingDsl.g:3673:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject rulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3679:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalMappingDsl.g:3680:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalMappingDsl.g:3680:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalMappingDsl.g:3681:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalMappingDsl.g:3681:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3682:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3682:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3683:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_74); 

            					newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_75); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalMappingDsl.g:3698:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalMappingDsl.g:3699:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalMappingDsl.g:3699:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalMappingDsl.g:3700:5: lv_value_2_0= rulePrimitiveValue
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
            						"de.fhdo.ddmm.ServiceDsl.PrimitiveValue");
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
    // InternalMappingDsl.g:3721:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalMappingDsl.g:3721:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalMappingDsl.g:3722:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalMappingDsl.g:3728:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3734:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalMappingDsl.g:3735:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalMappingDsl.g:3735:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalMappingDsl.g:3736:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_76); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,31,FOLLOW_7); 

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
    // InternalMappingDsl.g:3762:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalMappingDsl.g:3762:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalMappingDsl.g:3763:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalMappingDsl.g:3769:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:3775:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:3776:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:3776:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:3777:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:3789:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:3790:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:3790:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:3791:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

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
            		
            // InternalMappingDsl.g:3811:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:3812:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:3812:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:3813:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:3833:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalMappingDsl.g:3833:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalMappingDsl.g:3834:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalMappingDsl.g:3840:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalMappingDsl.g:3846:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalMappingDsl.g:3847:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalMappingDsl.g:3847:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalMappingDsl.g:3848:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalMappingDsl.g:3848:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3849:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3849:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:3850:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalMappingDsl.g:3867:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:3868:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:3868:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:3869:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_77); 

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

            otherlv_2=(Token)match(input,49,FOLLOW_78); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalMappingDsl.g:3893:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalMappingDsl.g:3894:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalMappingDsl.g:3894:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalMappingDsl.g:3895:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_79);
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

            // InternalMappingDsl.g:3912:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==25) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // InternalMappingDsl.g:3913:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:3917:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalMappingDsl.g:3918:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalMappingDsl.g:3918:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalMappingDsl.g:3919:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_79);
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
            	    break loop104;
                }
            } while (true);

            // InternalMappingDsl.g:3937:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==51) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalMappingDsl.g:3938:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:3938:4: ( (lv_default_7_0= 'default' ) )
                    // InternalMappingDsl.g:3939:5: (lv_default_7_0= 'default' )
                    {
                    // InternalMappingDsl.g:3939:5: (lv_default_7_0= 'default' )
                    // InternalMappingDsl.g:3940:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,51,FOLLOW_80); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,52,FOLLOW_81); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalMappingDsl.g:3960:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMappingDsl.g:3961:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMappingDsl.g:3961:5: (otherlv_10= RULE_ID )
                    // InternalMappingDsl.g:3962:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_66); 

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
    // InternalMappingDsl.g:3982:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalMappingDsl.g:3982:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalMappingDsl.g:3983:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalMappingDsl.g:3989:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3995:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalMappingDsl.g:3996:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:3996:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalMappingDsl.g:3997:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:3997:3: (lv_formatName_0_0= RULE_ID )
            // InternalMappingDsl.g:3998:4: lv_formatName_0_0= RULE_ID
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
    // InternalMappingDsl.g:4017:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalMappingDsl.g:4017:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalMappingDsl.g:4018:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalMappingDsl.g:4024:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:4030:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:4031:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:4031:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalMappingDsl.g:4032:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4040:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4041:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4041:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4042:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_83); 

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

            // InternalMappingDsl.g:4058:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==55) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalMappingDsl.g:4059:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_84); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,56,FOLLOW_85); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalMappingDsl.g:4067:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:4068:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:4068:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalMappingDsl.g:4069:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_79);
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

                    // InternalMappingDsl.g:4086:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==25) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4087:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,25,FOLLOW_85); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMappingDsl.g:4091:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalMappingDsl.g:4092:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalMappingDsl.g:4092:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalMappingDsl.g:4093:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop106;
                        }
                    } while (true);

                    // InternalMappingDsl.g:4111:4: ( (lv_default_8_0= 'default' ) )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==51) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalMappingDsl.g:4112:5: (lv_default_8_0= 'default' )
                            {
                            // InternalMappingDsl.g:4112:5: (lv_default_8_0= 'default' )
                            // InternalMappingDsl.g:4113:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,51,FOLLOW_66); 

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
    // InternalMappingDsl.g:4134:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalMappingDsl.g:4134:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalMappingDsl.g:4135:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalMappingDsl.g:4141:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4147:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4148:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4148:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4149:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4157:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4158:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4158:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4159:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_66); 

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
    // InternalMappingDsl.g:4183:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalMappingDsl.g:4183:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalMappingDsl.g:4184:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalMappingDsl.g:4190:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4196:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4197:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4197:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4198:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4206:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4207:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4207:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4208:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_66); 

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
    // InternalMappingDsl.g:4232:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalMappingDsl.g:4232:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalMappingDsl.g:4233:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalMappingDsl.g:4239:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4245:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:4246:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:4246:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:4247:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:4247:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_ID) ) {
                int LA109_1 = input.LA(2);

                if ( (LA109_1==32) ) {
                    alt109=1;
                }
            }
            switch (alt109) {
                case 1 :
                    // InternalMappingDsl.g:4248:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:4248:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:4249:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:4249:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:4250:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:4266:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4267:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4267:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4268:5: ruleQualifiedName
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
    // InternalMappingDsl.g:4286:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalMappingDsl.g:4286:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalMappingDsl.g:4287:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalMappingDsl.g:4293:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:4299:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalMappingDsl.g:4300:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4300:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalMappingDsl.g:4301:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalMappingDsl.g:4301:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4302:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4302:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4303:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_86);
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

            // InternalMappingDsl.g:4320:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==25) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalMappingDsl.g:4321:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:4325:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalMappingDsl.g:4326:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalMappingDsl.g:4326:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalMappingDsl.g:4327:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_86);
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
            	    break loop110;
                }
            } while (true);

            // InternalMappingDsl.g:4345:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalMappingDsl.g:4346:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalMappingDsl.g:4346:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalMappingDsl.g:4347:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalMappingDsl.g:4364:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4365:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4365:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4366:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_66);
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
    // InternalMappingDsl.g:4391:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalMappingDsl.g:4391:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalMappingDsl.g:4392:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalMappingDsl.g:4398:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4404:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4405:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4405:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4406:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4406:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4407:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4407:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4408:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_1=(Token)match(input,17,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_87); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,59,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_39); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4440:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4441:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4441:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4442:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_40);
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

            // InternalMappingDsl.g:4459:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==25) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // InternalMappingDsl.g:4460:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_39); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4464:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4465:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4465:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4466:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
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
            	    break loop111;
                }
            } while (true);

            otherlv_8=(Token)match(input,34,FOLLOW_88); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4488:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==60) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalMappingDsl.g:4489:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,60,FOLLOW_89); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,61,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,17,FOLLOW_85); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4501:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt112=0;
                    loop112:
                    do {
                        int alt112=2;
                        int LA112_0 = input.LA(1);

                        if ( ((LA112_0>=74 && LA112_0<=83)) ) {
                            alt112=1;
                        }


                        switch (alt112) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4502:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4502:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4503:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_90);
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
                    	    if ( cnt112 >= 1 ) break loop112;
                                EarlyExitException eee =
                                    new EarlyExitException(112, input);
                                throw eee;
                        }
                        cnt112++;
                    } while (true);

                    otherlv_13=(Token)match(input,19,FOLLOW_22); 

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
    // InternalMappingDsl.g:4533:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalMappingDsl.g:4533:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalMappingDsl.g:4534:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalMappingDsl.g:4540:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4546:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4547:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4547:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4548:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4548:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4549:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4549:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4550:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_1=(Token)match(input,17,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_87); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,59,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_39); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4582:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4583:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4583:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4584:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_40);
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

            // InternalMappingDsl.g:4601:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==25) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalMappingDsl.g:4602:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_39); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4606:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4607:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4607:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4608:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
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
            	    break loop114;
                }
            } while (true);

            otherlv_8=(Token)match(input,34,FOLLOW_88); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4630:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==60) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalMappingDsl.g:4631:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,60,FOLLOW_89); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,61,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,17,FOLLOW_85); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4643:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt115=0;
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( ((LA115_0>=74 && LA115_0<=83)) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4644:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4644:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4645:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_90);
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
                    	    if ( cnt115 >= 1 ) break loop115;
                                EarlyExitException eee =
                                    new EarlyExitException(115, input);
                                throw eee;
                        }
                        cnt115++;
                    } while (true);

                    otherlv_13=(Token)match(input,19,FOLLOW_22); 

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
    // InternalMappingDsl.g:4675:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalMappingDsl.g:4675:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalMappingDsl.g:4676:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalMappingDsl.g:4682:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4688:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalMappingDsl.g:4689:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalMappingDsl.g:4689:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalMappingDsl.g:4690:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalMappingDsl.g:4690:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalMappingDsl.g:4691:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalMappingDsl.g:4691:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalMappingDsl.g:4692:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_91); 

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

            // InternalMappingDsl.g:4708:3: ( (lv_default_1_0= 'default' ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==51) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalMappingDsl.g:4709:4: (lv_default_1_0= 'default' )
                    {
                    // InternalMappingDsl.g:4709:4: (lv_default_1_0= 'default' )
                    // InternalMappingDsl.g:4710:5: lv_default_1_0= 'default'
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
    // InternalMappingDsl.g:4726:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalMappingDsl.g:4726:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalMappingDsl.g:4727:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalMappingDsl.g:4733:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:4739:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) )
            // InternalMappingDsl.g:4740:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4740:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            // InternalMappingDsl.g:4741:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';'
            {
            // InternalMappingDsl.g:4741:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalMappingDsl.g:4742:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalMappingDsl.g:4742:4: (lv_type_0_0= rulePrimitiveType )
            // InternalMappingDsl.g:4743:5: lv_type_0_0= rulePrimitiveType
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

            // InternalMappingDsl.g:4760:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:4761:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:4761:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:4762:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_92); 

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

            // InternalMappingDsl.g:4778:3: ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )?
            int alt118=3;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==48) ) {
                alt118=1;
            }
            else if ( (LA118_0==62) ) {
                alt118=2;
            }
            switch (alt118) {
                case 1 :
                    // InternalMappingDsl.g:4779:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    {
                    // InternalMappingDsl.g:4779:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    // InternalMappingDsl.g:4780:5: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_75); 

                    					newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0_0());
                    				
                    // InternalMappingDsl.g:4784:5: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:4785:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:4785:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:4786:7: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_66);
                    lv_defaultValue_3_0=rulePrimitiveValue();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    							}
                    							set(
                    								current,
                    								"defaultValue",
                    								lv_defaultValue_3_0,
                    								"de.fhdo.ddmm.ServiceDsl.PrimitiveValue");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:4805:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    {
                    // InternalMappingDsl.g:4805:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    // InternalMappingDsl.g:4806:5: (lv_mandatory_4_0= 'mandatory' )
                    {
                    // InternalMappingDsl.g:4806:5: (lv_mandatory_4_0= 'mandatory' )
                    // InternalMappingDsl.g:4807:6: lv_mandatory_4_0= 'mandatory'
                    {
                    lv_mandatory_4_0=(Token)match(input,62,FOLLOW_66); 

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
    // InternalMappingDsl.g:4828:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalMappingDsl.g:4828:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalMappingDsl.g:4829:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalMappingDsl.g:4835:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalMappingDsl.g:4841:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalMappingDsl.g:4842:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalMappingDsl.g:4842:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt119=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt119=1;
                }
                break;
            case 64:
                {
                alt119=2;
                }
                break;
            case 65:
                {
                alt119=3;
                }
                break;
            case 66:
                {
                alt119=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // InternalMappingDsl.g:4843:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalMappingDsl.g:4843:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalMappingDsl.g:4844:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalMappingDsl.g:4844:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalMappingDsl.g:4845:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalMappingDsl.g:4845:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalMappingDsl.g:4846:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,63,FOLLOW_74); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,48,FOLLOW_93); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:4862:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalMappingDsl.g:4863:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:4863:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:4864:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalMappingDsl.g:4883:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalMappingDsl.g:4883:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalMappingDsl.g:4884:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalMappingDsl.g:4884:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalMappingDsl.g:4885:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalMappingDsl.g:4885:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalMappingDsl.g:4886:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,64,FOLLOW_74); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,48,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalMappingDsl.g:4902:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalMappingDsl.g:4903:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalMappingDsl.g:4903:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalMappingDsl.g:4904:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalMappingDsl.g:4923:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:4923:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalMappingDsl.g:4924:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:4924:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalMappingDsl.g:4925:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalMappingDsl.g:4925:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalMappingDsl.g:4926:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,65,FOLLOW_74); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMappingDsl.g:4942:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:4943:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:4943:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:4944:6: otherlv_8= RULE_ID
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
                    // InternalMappingDsl.g:4957:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:4957:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalMappingDsl.g:4958:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:4958:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalMappingDsl.g:4959:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalMappingDsl.g:4959:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalMappingDsl.g:4960:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,66,FOLLOW_74); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalMappingDsl.g:4976:4: ( (otherlv_11= RULE_ID ) )
                    // InternalMappingDsl.g:4977:5: (otherlv_11= RULE_ID )
                    {
                    // InternalMappingDsl.g:4977:5: (otherlv_11= RULE_ID )
                    // InternalMappingDsl.g:4978:6: otherlv_11= RULE_ID
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
    // InternalMappingDsl.g:4994:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:4994:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalMappingDsl.g:4995:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalMappingDsl.g:5001:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMappingDsl.g:5007:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:5008:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:5008:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:5009:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_94); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:5017:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalMappingDsl.g:5018:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalMappingDsl.g:5018:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalMappingDsl.g:5019:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_64);
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

            // InternalMappingDsl.g:5036:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==25) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalMappingDsl.g:5037:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_94); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:5041:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalMappingDsl.g:5042:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:5042:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalMappingDsl.g:5043:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_64);
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
            	    break loop120;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_66); 

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
    // InternalMappingDsl.g:5073:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalMappingDsl.g:5073:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalMappingDsl.g:5074:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalMappingDsl.g:5080:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalMappingDsl.g:5086:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalMappingDsl.g:5087:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalMappingDsl.g:5087:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalMappingDsl.g:5088:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5092:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5093:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5093:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5094:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_95); 

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

            otherlv_2=(Token)match(input,69,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5114:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalMappingDsl.g:5115:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalMappingDsl.g:5115:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalMappingDsl.g:5116:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_97);
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

            // InternalMappingDsl.g:5133:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==25) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // InternalMappingDsl.g:5134:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_96); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5138:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalMappingDsl.g:5139:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5139:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalMappingDsl.g:5140:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_97);
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
            	    break loop121;
                }
            } while (true);

            // InternalMappingDsl.g:5158:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==17) ) {
                alt124=1;
            }
            else if ( (LA124_0==34) ) {
                alt124=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }
            switch (alt124) {
                case 1 :
                    // InternalMappingDsl.g:5159:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalMappingDsl.g:5159:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalMappingDsl.g:5160:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_98); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5164:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop122:
                    do {
                        int alt122=2;
                        int LA122_0 = input.LA(1);

                        if ( (LA122_0==67) ) {
                            alt122=1;
                        }


                        switch (alt122) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5165:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:5165:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalMappingDsl.g:5166:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_98);
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
                    	    break loop122;
                        }
                    } while (true);

                    // InternalMappingDsl.g:5183:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( ((LA123_0>=74 && LA123_0<=83)) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5184:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5184:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5185:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_90);
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
                    	    break loop123;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5208:4: otherlv_10= ';'
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
    // InternalMappingDsl.g:5217:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalMappingDsl.g:5217:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalMappingDsl.g:5218:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalMappingDsl.g:5224:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) ;
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
            // InternalMappingDsl.g:5230:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) )
            // InternalMappingDsl.g:5231:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            {
            // InternalMappingDsl.g:5231:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            // InternalMappingDsl.g:5232:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5236:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5237:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5237:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5238:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_95); 

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

            otherlv_2=(Token)match(input,69,FOLLOW_99); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5258:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalMappingDsl.g:5259:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalMappingDsl.g:5259:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalMappingDsl.g:5260:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_97);
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

            // InternalMappingDsl.g:5277:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==25) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // InternalMappingDsl.g:5278:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_99); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5282:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalMappingDsl.g:5283:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5283:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalMappingDsl.g:5284:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_97);
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
            	    break loop125;
                }
            } while (true);

            // InternalMappingDsl.g:5302:3: ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==17) ) {
                alt127=1;
            }
            else if ( (LA127_0==34) ) {
                alt127=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // InternalMappingDsl.g:5303:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    {
                    // InternalMappingDsl.g:5303:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    // InternalMappingDsl.g:5304:5: otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_90); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5308:5: ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( ((LA126_0>=74 && LA126_0<=83)) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5309:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5309:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5310:7: lv_properties_7_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_90);
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
                    	    break loop126;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5333:4: otherlv_9= ';'
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
    // InternalMappingDsl.g:5342:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalMappingDsl.g:5342:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalMappingDsl.g:5343:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalMappingDsl.g:5349:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:5355:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5356:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5356:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5357:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_100); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,70,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:5369:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:5370:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:5370:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:5371:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

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
            		
            // InternalMappingDsl.g:5391:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:5392:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:5392:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:5393:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:5413:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalMappingDsl.g:5413:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalMappingDsl.g:5414:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalMappingDsl.g:5420:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalMappingDsl.g:5426:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalMappingDsl.g:5427:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalMappingDsl.g:5427:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalMappingDsl.g:5428:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalMappingDsl.g:5432:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5433:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5433:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5434:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_101); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5454:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt130=3;
            int LA130_0 = input.LA(1);

            if ( ((LA130_0>=57 && LA130_0<=58)) ) {
                alt130=1;
            }
            else if ( (LA130_0==71) ) {
                alt130=2;
            }
            switch (alt130) {
                case 1 :
                    // InternalMappingDsl.g:5455:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalMappingDsl.g:5455:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt128=0;
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( ((LA128_0>=57 && LA128_0<=58)) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5456:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalMappingDsl.g:5456:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalMappingDsl.g:5457:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_102);
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
                    	    if ( cnt128 >= 1 ) break loop128;
                                EarlyExitException eee =
                                    new EarlyExitException(128, input);
                                throw eee;
                        }
                        cnt128++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5475:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalMappingDsl.g:5475:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt129=0;
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==71) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5476:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalMappingDsl.g:5476:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalMappingDsl.g:5477:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_103);
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
                    	    if ( cnt129 >= 1 ) break loop129;
                                EarlyExitException eee =
                                    new EarlyExitException(129, input);
                                throw eee;
                        }
                        cnt129++;
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
    // InternalMappingDsl.g:5503:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMappingDsl.g:5503:48: (iv_ruleContext= ruleContext EOF )
            // InternalMappingDsl.g:5504:2: iv_ruleContext= ruleContext EOF
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
    // InternalMappingDsl.g:5510:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5516:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalMappingDsl.g:5517:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalMappingDsl.g:5517:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalMappingDsl.g:5518:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalMappingDsl.g:5522:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5523:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5523:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5524:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_104); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5544:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt131=0;
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( ((LA131_0>=57 && LA131_0<=58)) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // InternalMappingDsl.g:5545:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalMappingDsl.g:5545:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalMappingDsl.g:5546:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_102);
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
            	    if ( cnt131 >= 1 ) break loop131;
                        EarlyExitException eee =
                            new EarlyExitException(131, input);
                        throw eee;
                }
                cnt131++;
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
    // InternalMappingDsl.g:5571:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalMappingDsl.g:5571:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalMappingDsl.g:5572:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalMappingDsl.g:5578:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5584:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType ) )
            // InternalMappingDsl.g:5585:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType )
            {
            // InternalMappingDsl.g:5585:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==58) ) {
                alt132=1;
            }
            else if ( (LA132_0==57) ) {
                alt132=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // InternalMappingDsl.g:5586:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalMappingDsl.g:5595:3: this_ListType_1= ruleListType
                    {

                    			newCompositeNode(grammarAccess.getComplexTypeAccess().getListTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ListType_1=ruleListType();

                    state._fsp--;


                    			current = this_ListType_1;
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
    // InternalMappingDsl.g:5607:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalMappingDsl.g:5607:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalMappingDsl.g:5608:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalMappingDsl.g:5614:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) ;
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
            // InternalMappingDsl.g:5620:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) )
            // InternalMappingDsl.g:5621:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            {
            // InternalMappingDsl.g:5621:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            // InternalMappingDsl.g:5622:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalMappingDsl.g:5626:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5627:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5627:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5628:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_105); 

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

            // InternalMappingDsl.g:5644:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==72) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // InternalMappingDsl.g:5645:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,72,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMappingDsl.g:5649:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:5650:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:5650:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:5651:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_106); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:5670:3: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==RULE_ID||(LA135_0>=73 && LA135_0<=83)) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalMappingDsl.g:5671:4: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalMappingDsl.g:5671:4: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalMappingDsl.g:5672:5: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:5672:5: (lv_dataFields_5_0= ruleDataField )
                    // InternalMappingDsl.g:5673:6: lv_dataFields_5_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    // InternalMappingDsl.g:5690:4: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==25) ) {
                            alt134=1;
                        }


                        switch (alt134) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5691:5: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,25,FOLLOW_107); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalMappingDsl.g:5695:5: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:5696:6: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:5696:6: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalMappingDsl.g:5697:7: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop134;
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
    // InternalMappingDsl.g:5724:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalMappingDsl.g:5724:49: (iv_ruleListType= ruleListType EOF )
            // InternalMappingDsl.g:5725:2: iv_ruleListType= ruleListType EOF
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
    // InternalMappingDsl.g:5731:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalMappingDsl.g:5737:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalMappingDsl.g:5738:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalMappingDsl.g:5738:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt137=2;
            alt137 = dfa137.predict(input);
            switch (alt137) {
                case 1 :
                    // InternalMappingDsl.g:5739:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalMappingDsl.g:5739:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalMappingDsl.g:5740:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalMappingDsl.g:5744:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalMappingDsl.g:5745:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5745:5: (lv_name_1_0= RULE_ID )
                    // InternalMappingDsl.g:5746:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

                    otherlv_2=(Token)match(input,17,FOLLOW_107); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalMappingDsl.g:5766:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalMappingDsl.g:5767:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:5767:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalMappingDsl.g:5768:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    // InternalMappingDsl.g:5785:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==25) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5786:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_107); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalMappingDsl.g:5790:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:5791:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:5791:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalMappingDsl.g:5792:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
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
                    	    break loop136;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5816:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:5816:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalMappingDsl.g:5817:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalMappingDsl.g:5821:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalMappingDsl.g:5822:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5822:5: (lv_name_8_0= RULE_ID )
                    // InternalMappingDsl.g:5823:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

                    otherlv_9=(Token)match(input,17,FOLLOW_85); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalMappingDsl.g:5843:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:5844:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:5844:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalMappingDsl.g:5845:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_22);
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
    // InternalMappingDsl.g:5871:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalMappingDsl.g:5871:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalMappingDsl.g:5872:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalMappingDsl.g:5878:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5884:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5885:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5885:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5886:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:5886:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==73) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalMappingDsl.g:5887:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalMappingDsl.g:5887:4: (lv_hidden_0_0= 'hide' )
                    // InternalMappingDsl.g:5888:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,73,FOLLOW_71); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:5900:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt139=3;
            int LA139_0 = input.LA(1);

            if ( ((LA139_0>=74 && LA139_0<=83)) ) {
                alt139=1;
            }
            else if ( (LA139_0==RULE_ID) ) {
                int LA139_2 = input.LA(2);

                if ( (LA139_2==RULE_ID||(LA139_2>=31 && LA139_2<=32)) ) {
                    alt139=2;
                }
            }
            switch (alt139) {
                case 1 :
                    // InternalMappingDsl.g:5901:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:5901:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:5902:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:5902:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalMappingDsl.g:5903:6: lv_primitiveType_1_0= rulePrimitiveType
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
                    // InternalMappingDsl.g:5921:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalMappingDsl.g:5921:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalMappingDsl.g:5922:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalMappingDsl.g:5922:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalMappingDsl.g:5923:6: lv_complexType_2_0= rulePossiblyImportedComplexType
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

            // InternalMappingDsl.g:5941:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMappingDsl.g:5942:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMappingDsl.g:5942:4: (lv_name_3_0= RULE_ID )
            // InternalMappingDsl.g:5943:5: lv_name_3_0= RULE_ID
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


    // $ANTLR start "entryRulePossiblyImportedComplexType"
    // InternalMappingDsl.g:5963:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalMappingDsl.g:5963:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalMappingDsl.g:5964:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
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
    // InternalMappingDsl.g:5970:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5976:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:5977:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:5977:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:5978:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:5978:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==RULE_ID) ) {
                int LA140_1 = input.LA(2);

                if ( (LA140_1==32) ) {
                    alt140=1;
                }
            }
            switch (alt140) {
                case 1 :
                    // InternalMappingDsl.g:5979:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:5979:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:5980:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5980:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:5981:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:5997:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:5998:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:5998:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:5999:5: ruleQualifiedName
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
    // InternalMappingDsl.g:6017:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalMappingDsl.g:6017:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalMappingDsl.g:6018:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalMappingDsl.g:6024:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalMappingDsl.g:6030:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalMappingDsl.g:6031:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalMappingDsl.g:6031:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt141=10;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt141=1;
                }
                break;
            case 75:
                {
                alt141=2;
                }
                break;
            case 76:
                {
                alt141=3;
                }
                break;
            case 77:
                {
                alt141=4;
                }
                break;
            case 78:
                {
                alt141=5;
                }
                break;
            case 79:
                {
                alt141=6;
                }
                break;
            case 80:
                {
                alt141=7;
                }
                break;
            case 81:
                {
                alt141=8;
                }
                break;
            case 82:
                {
                alt141=9;
                }
                break;
            case 83:
                {
                alt141=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }

            switch (alt141) {
                case 1 :
                    // InternalMappingDsl.g:6032:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalMappingDsl.g:6032:3: ( () otherlv_1= 'boolean' )
                    // InternalMappingDsl.g:6033:4: () otherlv_1= 'boolean'
                    {
                    // InternalMappingDsl.g:6033:4: ()
                    // InternalMappingDsl.g:6034:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,74,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6046:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalMappingDsl.g:6046:3: ( () otherlv_3= 'byte' )
                    // InternalMappingDsl.g:6047:4: () otherlv_3= 'byte'
                    {
                    // InternalMappingDsl.g:6047:4: ()
                    // InternalMappingDsl.g:6048:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,75,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6060:3: ( () otherlv_5= 'char' )
                    {
                    // InternalMappingDsl.g:6060:3: ( () otherlv_5= 'char' )
                    // InternalMappingDsl.g:6061:4: () otherlv_5= 'char'
                    {
                    // InternalMappingDsl.g:6061:4: ()
                    // InternalMappingDsl.g:6062:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,76,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:6074:3: ( () otherlv_7= 'date' )
                    {
                    // InternalMappingDsl.g:6074:3: ( () otherlv_7= 'date' )
                    // InternalMappingDsl.g:6075:4: () otherlv_7= 'date'
                    {
                    // InternalMappingDsl.g:6075:4: ()
                    // InternalMappingDsl.g:6076:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,77,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:6088:3: ( () otherlv_9= 'double' )
                    {
                    // InternalMappingDsl.g:6088:3: ( () otherlv_9= 'double' )
                    // InternalMappingDsl.g:6089:4: () otherlv_9= 'double'
                    {
                    // InternalMappingDsl.g:6089:4: ()
                    // InternalMappingDsl.g:6090:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,78,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:6102:3: ( () otherlv_11= 'float' )
                    {
                    // InternalMappingDsl.g:6102:3: ( () otherlv_11= 'float' )
                    // InternalMappingDsl.g:6103:4: () otherlv_11= 'float'
                    {
                    // InternalMappingDsl.g:6103:4: ()
                    // InternalMappingDsl.g:6104:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,79,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMappingDsl.g:6116:3: ( () otherlv_13= 'int' )
                    {
                    // InternalMappingDsl.g:6116:3: ( () otherlv_13= 'int' )
                    // InternalMappingDsl.g:6117:4: () otherlv_13= 'int'
                    {
                    // InternalMappingDsl.g:6117:4: ()
                    // InternalMappingDsl.g:6118:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,80,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMappingDsl.g:6130:3: ( () otherlv_15= 'long' )
                    {
                    // InternalMappingDsl.g:6130:3: ( () otherlv_15= 'long' )
                    // InternalMappingDsl.g:6131:4: () otherlv_15= 'long'
                    {
                    // InternalMappingDsl.g:6131:4: ()
                    // InternalMappingDsl.g:6132:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,81,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMappingDsl.g:6144:3: ( () otherlv_17= 'short' )
                    {
                    // InternalMappingDsl.g:6144:3: ( () otherlv_17= 'short' )
                    // InternalMappingDsl.g:6145:4: () otherlv_17= 'short'
                    {
                    // InternalMappingDsl.g:6145:4: ()
                    // InternalMappingDsl.g:6146:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,82,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMappingDsl.g:6158:3: ( () otherlv_19= 'string' )
                    {
                    // InternalMappingDsl.g:6158:3: ( () otherlv_19= 'string' )
                    // InternalMappingDsl.g:6159:4: () otherlv_19= 'string'
                    {
                    // InternalMappingDsl.g:6159:4: ()
                    // InternalMappingDsl.g:6160:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,83,FOLLOW_2); 

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
    // InternalMappingDsl.g:6175:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMappingDsl.g:6175:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMappingDsl.g:6176:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMappingDsl.g:6182:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6188:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMappingDsl.g:6189:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMappingDsl.g:6189:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMappingDsl.g:6190:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMappingDsl.g:6197:3: (kw= '.' this_ID_2= RULE_ID )*
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( (LA142_0==31) ) {
                    alt142=1;
                }


                switch (alt142) {
            	case 1 :
            	    // InternalMappingDsl.g:6198:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_35); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop142;
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
    // InternalMappingDsl.g:6215:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6221:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalMappingDsl.g:6222:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalMappingDsl.g:6222:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==14) ) {
                alt143=1;
            }
            else if ( (LA143_0==41) ) {
                alt143=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 143, 0, input);

                throw nvae;
            }
            switch (alt143) {
                case 1 :
                    // InternalMappingDsl.g:6223:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalMappingDsl.g:6223:3: (enumLiteral_0= 'technology' )
                    // InternalMappingDsl.g:6224:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,14,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6231:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalMappingDsl.g:6231:3: (enumLiteral_1= 'microservices' )
                    // InternalMappingDsl.g:6232:4: enumLiteral_1= 'microservices'
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
    // InternalMappingDsl.g:6242:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6248:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalMappingDsl.g:6249:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalMappingDsl.g:6249:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt144=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt144=1;
                }
                break;
            case 85:
                {
                alt144=2;
                }
                break;
            case 86:
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
                    // InternalMappingDsl.g:6250:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalMappingDsl.g:6250:3: (enumLiteral_0= 'internal' )
                    // InternalMappingDsl.g:6251:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6258:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalMappingDsl.g:6258:3: (enumLiteral_1= 'architecture' )
                    // InternalMappingDsl.g:6259:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6266:3: (enumLiteral_2= 'public' )
                    {
                    // InternalMappingDsl.g:6266:3: (enumLiteral_2= 'public' )
                    // InternalMappingDsl.g:6267:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); 

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
    // InternalMappingDsl.g:6277:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6283:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalMappingDsl.g:6284:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:6284:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt145=3;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt145=1;
                }
                break;
            case 88:
                {
                alt145=2;
                }
                break;
            case 89:
                {
                alt145=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }

            switch (alt145) {
                case 1 :
                    // InternalMappingDsl.g:6285:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalMappingDsl.g:6285:3: (enumLiteral_0= 'functional' )
                    // InternalMappingDsl.g:6286:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6293:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalMappingDsl.g:6293:3: (enumLiteral_1= 'utility' )
                    // InternalMappingDsl.g:6294:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6301:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:6301:3: (enumLiteral_2= 'infrastructure' )
                    // InternalMappingDsl.g:6302:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,89,FOLLOW_2); 

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
    // InternalMappingDsl.g:6312:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6318:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalMappingDsl.g:6319:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalMappingDsl.g:6319:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt146=3;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt146=1;
                }
                break;
            case 91:
                {
                alt146=2;
                }
                break;
            case 92:
                {
                alt146=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }

            switch (alt146) {
                case 1 :
                    // InternalMappingDsl.g:6320:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMappingDsl.g:6320:3: (enumLiteral_0= 'in' )
                    // InternalMappingDsl.g:6321:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6328:3: (enumLiteral_1= 'out' )
                    {
                    // InternalMappingDsl.g:6328:3: (enumLiteral_1= 'out' )
                    // InternalMappingDsl.g:6329:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6336:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalMappingDsl.g:6336:3: (enumLiteral_2= 'inout' )
                    // InternalMappingDsl.g:6337:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,92,FOLLOW_2); 

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
    // InternalMappingDsl.g:6347:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6353:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalMappingDsl.g:6354:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalMappingDsl.g:6354:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==93) ) {
                alt147=1;
            }
            else if ( (LA147_0==94) ) {
                alt147=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 147, 0, input);

                throw nvae;
            }
            switch (alt147) {
                case 1 :
                    // InternalMappingDsl.g:6355:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalMappingDsl.g:6355:3: (enumLiteral_0= 'sync' )
                    // InternalMappingDsl.g:6356:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6363:3: (enumLiteral_1= 'async' )
                    {
                    // InternalMappingDsl.g:6363:3: (enumLiteral_1= 'async' )
                    // InternalMappingDsl.g:6364:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); 

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
    // InternalMappingDsl.g:6374:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6380:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalMappingDsl.g:6381:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalMappingDsl.g:6381:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt148=3;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt148=1;
                }
                break;
            case 30:
                {
                alt148=2;
                }
                break;
            case 96:
                {
                alt148=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }

            switch (alt148) {
                case 1 :
                    // InternalMappingDsl.g:6382:3: (enumLiteral_0= '<-' )
                    {
                    // InternalMappingDsl.g:6382:3: (enumLiteral_0= '<-' )
                    // InternalMappingDsl.g:6383:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6390:3: (enumLiteral_1= '->' )
                    {
                    // InternalMappingDsl.g:6390:3: (enumLiteral_1= '->' )
                    // InternalMappingDsl.g:6391:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6398:3: (enumLiteral_2= '<->' )
                    {
                    // InternalMappingDsl.g:6398:3: (enumLiteral_2= '<->' )
                    // InternalMappingDsl.g:6399:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); 

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
    // InternalMappingDsl.g:6409:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) ) ;
    public final Enumerator ruleServiceJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6415:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) ) )
            // InternalMappingDsl.g:6416:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) )
            {
            // InternalMappingDsl.g:6416:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) )
            int alt149=5;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt149=1;
                }
                break;
            case 42:
                {
                alt149=2;
                }
                break;
            case 43:
                {
                alt149=3;
                }
                break;
            case 24:
                {
                alt149=4;
                }
                break;
            case 97:
                {
                alt149=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // InternalMappingDsl.g:6417:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalMappingDsl.g:6417:3: (enumLiteral_0= 'microservices' )
                    // InternalMappingDsl.g:6418:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6425:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalMappingDsl.g:6425:3: (enumLiteral_1= 'interfaces' )
                    // InternalMappingDsl.g:6426:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6433:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalMappingDsl.g:6433:3: (enumLiteral_2= 'operations' )
                    // InternalMappingDsl.g:6434:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:6441:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalMappingDsl.g:6441:3: (enumLiteral_3= 'parameters' )
                    // InternalMappingDsl.g:6442:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:6449:3: (enumLiteral_4= 'fields' )
                    {
                    // InternalMappingDsl.g:6449:3: (enumLiteral_4= 'fields' )
                    // InternalMappingDsl.g:6450:4: enumLiteral_4= 'fields'
                    {
                    enumLiteral_4=(Token)match(input,97,FOLLOW_2); 

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
    // InternalMappingDsl.g:6460:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6466:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalMappingDsl.g:6467:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:6467:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==98) ) {
                alt150=1;
            }
            else if ( (LA150_0==89) ) {
                alt150=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;
            }
            switch (alt150) {
                case 1 :
                    // InternalMappingDsl.g:6468:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalMappingDsl.g:6468:3: (enumLiteral_0= 'containers' )
                    // InternalMappingDsl.g:6469:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6476:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:6476:3: (enumLiteral_1= 'infrastructure' )
                    // InternalMappingDsl.g:6477:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); 

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


    protected DFA75 dfa75 = new DFA75(this);
    protected DFA137 dfa137 = new DFA137(this);
    static final String dfa_1s = "\111\uffff";
    static final String dfa_2s = "\2\4\2\uffff\1\17\1\40\2\17\3\4\1\40\1\4\1\40\5\4\1\31\1\4\3\20\1\60\1\20\3\4\1\5\1\4\1\5\3\4\2\31\1\40\1\31\5\20\2\4\1\5\2\4\2\17\2\31\1\4\1\60\3\4\1\5\1\40\2\31\3\20\1\4\1\20\3\4\2\20\1\4";
    static final String dfa_3s = "\1\126\1\136\2\uffff\1\17\1\40\2\17\3\4\1\40\1\126\1\40\2\4\1\7\2\4\1\41\1\126\3\20\1\60\1\41\3\4\1\5\1\126\1\7\2\4\1\126\1\41\1\34\1\40\1\42\3\31\1\41\1\20\1\136\1\4\1\5\1\20\1\4\2\17\1\41\1\42\1\126\1\60\3\4\1\7\1\40\1\41\1\34\3\31\1\4\1\41\2\4\1\126\1\41\1\20\1\24";
    static final String dfa_4s = "\2\uffff\1\2\1\1\105\uffff";
    static final String dfa_5s = "\111\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\10\uffff\1\1\5\uffff\1\2\30\uffff\1\2\1\3\46\uffff\3\2",
            "\1\5\17\uffff\1\4\110\uffff\1\6\1\7",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\2\10\uffff\1\21\1\uffff\1\20\17\uffff\1\17\14\uffff\1\2\1\3\46\uffff\3\2",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\30\1\27\1\25\1\26",
            "\1\5",
            "\1\31",
            "\1\34\2\uffff\1\35\2\uffff\1\32\1\uffff\1\33",
            "\1\2\10\uffff\1\21\1\uffff\1\20\17\uffff\1\17\14\uffff\1\2\1\3\46\uffff\3\2",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\37",
            "\1\42\16\uffff\1\40\1\uffff\1\41",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\2\10\uffff\1\21\36\uffff\1\2\1\3\46\uffff\3\2",
            "\1\51\1\47\1\50",
            "\1\52",
            "\1\53",
            "\1\2\10\uffff\1\54\36\uffff\1\2\1\3\46\uffff\3\2",
            "\1\34\2\uffff\1\35\2\uffff\1\32\1\uffff\1\33",
            "\1\34\2\uffff\1\35",
            "\1\55",
            "\1\56\10\uffff\1\57",
            "\1\36\10\uffff\1\60",
            "\1\36\10\uffff\1\60",
            "\1\36\10\uffff\1\60",
            "\1\42\16\uffff\1\40\1\uffff\1\41",
            "\1\42",
            "\1\5\17\uffff\1\4\110\uffff\1\61\1\62",
            "\1\63",
            "\1\64",
            "\1\13\13\uffff\1\65",
            "\1\66",
            "\1\67",
            "\1\67",
            "\1\34\2\uffff\1\35\2\uffff\1\70\1\uffff\1\71",
            "\1\56\10\uffff\1\57",
            "\1\2\10\uffff\1\21\36\uffff\1\2\1\3\46\uffff\3\2",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\100\1\76\1\77",
            "\1\101",
            "\1\34\2\uffff\1\35\2\uffff\1\70\1\uffff\1\71",
            "\1\34\2\uffff\1\35",
            "\1\36\10\uffff\1\60",
            "\1\36\10\uffff\1\60",
            "\1\36\10\uffff\1\60",
            "\1\102",
            "\1\105\16\uffff\1\103\1\uffff\1\104",
            "\1\106",
            "\1\107",
            "\1\2\10\uffff\1\110\36\uffff\1\2\1\3\46\uffff\3\2",
            "\1\105\16\uffff\1\103\1\uffff\1\104",
            "\1\105",
            "\1\5\17\uffff\1\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 2553:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_7s = "\20\uffff";
    static final String dfa_8s = "\1\71\1\4\1\21\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_9s = "\1\71\1\4\1\21\1\123\1\uffff\12\23\1\uffff";
    static final String dfa_10s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_11s = "\20\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\104\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
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

    class DFA137 extends DFA {

        public DFA137(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 137;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "5738:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
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
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004FC0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L,0x0000000060000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004F80000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004E80000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004C80000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004880000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000013C0000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001380000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001280000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000028000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000402000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000400008000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000002000L,0x0000000003F00000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000110000402000L,0x0000000000700000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000110000482000L,0x0000000000700000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000100000402000L,0x0000000000700000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000400000L,0x0000000000700000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000300000082010L,0x0000000000700000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000100000082010L,0x0000000000700000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000100000002010L,0x0000000000700000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000010L,0x0000000000700000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000002012000L,0x0000000060000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000002000L,0x0000000060000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000200000002000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000400000000010L,0x000000001C000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000800010000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000010L,0x00000000000FFC00L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0008000402000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0080000400000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x00000000000FFC00L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000042000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000080000L,0x00000000000FFC00L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x4001000400000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x000000001C000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x00000E0001000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000402020000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000080000L,0x00000000000FFC08L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000000402000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0600000000080000L,0x0000000000000080L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0600000000080000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000080L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000100L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000080010L,0x00000000000FFE00L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000010L,0x00000000000FFE00L});

}