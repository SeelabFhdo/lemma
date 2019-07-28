package de.fhdo.lemma.technology.mappingdsl.parser.antlr.internal;

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
import de.fhdo.lemma.technology.mappingdsl.services.MappingDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMappingDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BOOLEAN", "RULE_BIG_DECIMAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'{'", "'aspects'", "'}'", "'::'", "'protocols'", "'endpoints'", "'interface'", "'operation'", "'parameters'", "'referred'", "'primitive'", "':'", "';'", "'complex'", "'->'", "'.'", "'/'", "','", "'('", "')'", "'import'", "'from'", "'as'", "'@'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'technology'", "'typedef'", "'='", "'noimpl'", "'refers'", "'fault'", "'?'", "'data'", "'formats'", "'default'", "'with'", "'format'", "'based'", "'on'", "'list'", "'structure'", "'environments'", "'service'", "'properties'", "'<'", "'>'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'aspect'", "'for'", "'datatypes'", "'context'", "'extends'", "'hide'", "'enum'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'functional'", "'utility'", "'infrastructure'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'<->'", "'mandatory'", "'singleval'", "'types'", "'fields'", "'containers'", "'derived'"
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
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=6;
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
    public static final int RULE_BIG_DECIMAL=7;
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
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__105=105;

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
    // InternalMappingDsl.g:72:1: ruleTechnologyMapping returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )* ) ;
    public final EObject ruleTechnologyMapping() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_typeMappings_1_0 = null;

        EObject lv_serviceMappings_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )* ) )
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )* )
            {
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )* )
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )*
            {
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==34) ) {
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
            	    						"de.fhdo.lemma.ServiceDsl.Import");
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

            // InternalMappingDsl.g:99:3: ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalMappingDsl.g:100:4: (lv_typeMappings_1_0= ruleComplexTypeMapping )
            	    {
            	    // InternalMappingDsl.g:100:4: (lv_typeMappings_1_0= ruleComplexTypeMapping )
            	    // InternalMappingDsl.g:101:5: lv_typeMappings_1_0= ruleComplexTypeMapping
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyMappingAccess().getTypeMappingsComplexTypeMappingParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_typeMappings_1_0=ruleComplexTypeMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"typeMappings",
            	    						lv_typeMappings_1_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ComplexTypeMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMappingDsl.g:118:3: ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||LA3_0==37) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMappingDsl.g:119:4: (lv_serviceMappings_2_0= ruleMicroserviceMapping )
            	    {
            	    // InternalMappingDsl.g:119:4: (lv_serviceMappings_2_0= ruleMicroserviceMapping )
            	    // InternalMappingDsl.g:120:5: lv_serviceMappings_2_0= ruleMicroserviceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyMappingAccess().getServiceMappingsMicroserviceMappingParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_serviceMappings_2_0=ruleMicroserviceMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"serviceMappings",
            	    						lv_serviceMappings_2_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.MicroserviceMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleTechnologyMapping"


    // $ANTLR start "entryRuleComplexTypeMapping"
    // InternalMappingDsl.g:141:1: entryRuleComplexTypeMapping returns [EObject current=null] : iv_ruleComplexTypeMapping= ruleComplexTypeMapping EOF ;
    public final EObject entryRuleComplexTypeMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeMapping = null;


        try {
            // InternalMappingDsl.g:141:59: (iv_ruleComplexTypeMapping= ruleComplexTypeMapping EOF )
            // InternalMappingDsl.g:142:2: iv_ruleComplexTypeMapping= ruleComplexTypeMapping EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexTypeMapping=ruleComplexTypeMapping();

            state._fsp--;

             current =iv_ruleComplexTypeMapping; 
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
    // $ANTLR end "entryRuleComplexTypeMapping"


    // $ANTLR start "ruleComplexTypeMapping"
    // InternalMappingDsl.g:148:1: ruleComplexTypeMapping returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexType ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* otherlv_9= '}' ) ;
    public final EObject ruleComplexTypeMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_technologyReferences_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_aspects_6_0 = null;

        EObject lv_fieldMappings_8_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:154:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexType ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* otherlv_9= '}' ) )
            // InternalMappingDsl.g:155:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexType ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* otherlv_9= '}' )
            {
            // InternalMappingDsl.g:155:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexType ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* otherlv_9= '}' )
            // InternalMappingDsl.g:156:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexType ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* otherlv_9= '}'
            {
            // InternalMappingDsl.g:156:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==37) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMappingDsl.g:157:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalMappingDsl.g:157:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalMappingDsl.g:158:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_technologyReferences_0_0=ruleTechnologyReference();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"technologyReferences",
            	    						lv_technologyReferences_0_0,
            	    						"de.fhdo.lemma.ServiceDsl.TechnologyReference");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeMappingAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:179:3: ( (lv_type_2_0= ruleImportedComplexType ) )
            // InternalMappingDsl.g:180:4: (lv_type_2_0= ruleImportedComplexType )
            {
            // InternalMappingDsl.g:180:4: (lv_type_2_0= ruleImportedComplexType )
            // InternalMappingDsl.g:181:5: lv_type_2_0= ruleImportedComplexType
            {

            					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getTypeImportedComplexTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_2_0=ruleImportedComplexType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ImportedComplexType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getComplexTypeMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:202:3: (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMappingDsl.g:203:4: otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getComplexTypeMappingAccess().getAspectsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getComplexTypeMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:211:4: ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMappingDsl.g:212:5: (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:212:5: (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:213:6: lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_6_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_6_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    otherlv_7=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getComplexTypeMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:235:3: ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==29) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMappingDsl.g:236:4: (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping )
            	    {
            	    // InternalMappingDsl.g:236:4: (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping )
            	    // InternalMappingDsl.g:237:5: lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping
            	    {

            	    					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getFieldMappingsTechnologySpecificFieldMappingParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_fieldMappings_8_0=ruleTechnologySpecificFieldMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fieldMappings",
            	    						lv_fieldMappings_8_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificFieldMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getComplexTypeMappingAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleComplexTypeMapping"


    // $ANTLR start "entryRuleImportedComplexType"
    // InternalMappingDsl.g:262:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalMappingDsl.g:262:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalMappingDsl.g:263:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
            {
             newCompositeNode(grammarAccess.getImportedComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedComplexType=ruleImportedComplexType();

            state._fsp--;

             current =iv_ruleImportedComplexType; 
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
    // $ANTLR end "entryRuleImportedComplexType"


    // $ANTLR start "ruleImportedComplexType"
    // InternalMappingDsl.g:269:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:275:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:276:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:276:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:277:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:277:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:278:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:278:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:279:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getServiceModelImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:294:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:295:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:295:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:296:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_2, grammarAccess.getImportedComplexTypeAccess().getDataModelImportImportCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_3());
            		
            // InternalMappingDsl.g:311:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:312:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:312:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:313:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedComplexTypeAccess().getTypeComplexTypeCrossReference_4_0());
            				
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
    // $ANTLR end "ruleImportedComplexType"


    // $ANTLR start "entryRuleMicroserviceMapping"
    // InternalMappingDsl.g:331:1: entryRuleMicroserviceMapping returns [EObject current=null] : iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF ;
    public final EObject entryRuleMicroserviceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroserviceMapping = null;


        try {
            // InternalMappingDsl.g:331:60: (iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF )
            // InternalMappingDsl.g:332:2: iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF
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
    // InternalMappingDsl.g:338:1: ruleMicroserviceMapping returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' ) ;
    public final EObject ruleMicroserviceMapping() throws RecognitionException {
        EObject current = null;

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
        Token otherlv_18=null;
        EObject lv_technologyReferences_0_0 = null;

        EObject lv_microservice_1_0 = null;

        EObject lv_protocols_5_0 = null;

        EObject lv_endpoints_9_0 = null;

        EObject lv_aspects_13_0 = null;

        EObject lv_interfaceMappings_15_0 = null;

        EObject lv_referredOperationMappings_16_0 = null;

        EObject lv_operationMappings_17_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:344:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' ) )
            // InternalMappingDsl.g:345:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' )
            {
            // InternalMappingDsl.g:345:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' )
            // InternalMappingDsl.g:346:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}'
            {
            // InternalMappingDsl.g:346:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==37) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMappingDsl.g:347:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalMappingDsl.g:347:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalMappingDsl.g:348:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_technologyReferences_0_0=ruleTechnologyReference();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"technologyReferences",
            	    						lv_technologyReferences_0_0,
            	    						"de.fhdo.lemma.ServiceDsl.TechnologyReference");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalMappingDsl.g:365:3: ( (lv_microservice_1_0= ruleImportedMicroservice ) )
            // InternalMappingDsl.g:366:4: (lv_microservice_1_0= ruleImportedMicroservice )
            {
            // InternalMappingDsl.g:366:4: (lv_microservice_1_0= ruleImportedMicroservice )
            // InternalMappingDsl.g:367:5: lv_microservice_1_0= ruleImportedMicroservice
            {

            					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getMicroserviceImportedMicroserviceParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_microservice_1_0=ruleImportedMicroservice();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            					}
            					set(
            						current,
            						"microservice",
            						lv_microservice_1_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ImportedMicroservice");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:388:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMappingDsl.g:389:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:397:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=96 && LA9_0<=97)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMappingDsl.g:398:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:398:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:399:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    lv_protocols_5_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_5_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_17); 

                    				newLeafNode(otherlv_6, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:421:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMappingDsl.g:422:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_10); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:430:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMappingDsl.g:431:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:431:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:432:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_endpoints_9_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_9_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:454:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMappingDsl.g:455:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:463:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMappingDsl.g:464:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:464:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:465:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_13_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_13_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_14=(Token)match(input,16,FOLLOW_19); 

                    				newLeafNode(otherlv_14, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:487:3: ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==20) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMappingDsl.g:488:4: (lv_interfaceMappings_15_0= ruleInterfaceMapping )
            	    {
            	    // InternalMappingDsl.g:488:4: (lv_interfaceMappings_15_0= ruleInterfaceMapping )
            	    // InternalMappingDsl.g:489:5: lv_interfaceMappings_15_0= ruleInterfaceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getInterfaceMappingsInterfaceMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_interfaceMappings_15_0=ruleInterfaceMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"interfaceMappings",
            	    						lv_interfaceMappings_15_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.InterfaceMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalMappingDsl.g:506:3: ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMappingDsl.g:507:4: (lv_referredOperationMappings_16_0= ruleReferredOperationMapping )
            	    {
            	    // InternalMappingDsl.g:507:4: (lv_referredOperationMappings_16_0= ruleReferredOperationMapping )
            	    // InternalMappingDsl.g:508:5: lv_referredOperationMappings_16_0= ruleReferredOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getReferredOperationMappingsReferredOperationMappingParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_referredOperationMappings_16_0=ruleReferredOperationMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referredOperationMappings",
            	    						lv_referredOperationMappings_16_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ReferredOperationMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // InternalMappingDsl.g:525:3: ( (lv_operationMappings_17_0= ruleOperationMapping ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==21) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMappingDsl.g:526:4: (lv_operationMappings_17_0= ruleOperationMapping )
            	    {
            	    // InternalMappingDsl.g:526:4: (lv_operationMappings_17_0= ruleOperationMapping )
            	    // InternalMappingDsl.g:527:5: lv_operationMappings_17_0= ruleOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getOperationMappingsOperationMappingParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_operationMappings_17_0=ruleOperationMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operationMappings",
            	    						lv_operationMappings_17_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.OperationMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_18=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_9());
            		

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
    // InternalMappingDsl.g:552:1: entryRuleInterfaceMapping returns [EObject current=null] : iv_ruleInterfaceMapping= ruleInterfaceMapping EOF ;
    public final EObject entryRuleInterfaceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceMapping = null;


        try {
            // InternalMappingDsl.g:552:57: (iv_ruleInterfaceMapping= ruleInterfaceMapping EOF )
            // InternalMappingDsl.g:553:2: iv_ruleInterfaceMapping= ruleInterfaceMapping EOF
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
    // InternalMappingDsl.g:559:1: ruleInterfaceMapping returns [EObject current=null] : (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) ;
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
            // InternalMappingDsl.g:565:2: ( (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalMappingDsl.g:566:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalMappingDsl.g:566:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            // InternalMappingDsl.g:567:3: otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getInterfaceMappingAccess().getInterfaceKeyword_0());
            		
            // InternalMappingDsl.g:571:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:572:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:572:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:573:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_1, grammarAccess.getInterfaceMappingAccess().getInterfaceInterfaceCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:588:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMappingDsl.g:589:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:597:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=96 && LA18_0<=97)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalMappingDsl.g:598:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:598:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:599:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    lv_protocols_5_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_5_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
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

                    otherlv_6=(Token)match(input,16,FOLLOW_23); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:621:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMappingDsl.g:622:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:630:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
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
                    	    // InternalMappingDsl.g:631:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:631:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:632:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_endpoints_9_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_9_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
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

                    otherlv_10=(Token)match(input,16,FOLLOW_24); 

                    				newLeafNode(otherlv_10, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:654:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMappingDsl.g:655:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:663:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:664:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:664:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:665:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_13_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_13_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_14=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_14, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:695:1: entryRuleOperationMapping returns [EObject current=null] : iv_ruleOperationMapping= ruleOperationMapping EOF ;
    public final EObject entryRuleOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationMapping = null;


        try {
            // InternalMappingDsl.g:695:57: (iv_ruleOperationMapping= ruleOperationMapping EOF )
            // InternalMappingDsl.g:696:2: iv_ruleOperationMapping= ruleOperationMapping EOF
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
    // InternalMappingDsl.g:702:1: ruleOperationMapping returns [EObject current=null] : (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' ) ;
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
        Token otherlv_19=null;
        EObject lv_protocols_5_0 = null;

        EObject lv_endpoints_9_0 = null;

        EObject lv_aspects_13_0 = null;

        EObject lv_parameterMappings_17_1 = null;

        EObject lv_parameterMappings_17_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:708:2: ( (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' ) )
            // InternalMappingDsl.g:709:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' )
            {
            // InternalMappingDsl.g:709:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' )
            // InternalMappingDsl.g:710:3: otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationMappingAccess().getOperationKeyword_0());
            		
            // InternalMappingDsl.g:714:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:715:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:715:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:716:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOperationMappingAccess().getOperationOperationCrossReference_1_0());
            				
            pushFollow(FOLLOW_8);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:734:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==18) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMappingDsl.g:735:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:743:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=96 && LA24_0<=97)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalMappingDsl.g:744:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:744:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:745:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    lv_protocols_5_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_5_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
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

                    otherlv_6=(Token)match(input,16,FOLLOW_27); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:767:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==19) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMappingDsl.g:768:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:776:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalMappingDsl.g:777:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:777:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:778:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_endpoints_9_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_9_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_28); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:800:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==15) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMappingDsl.g:801:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getOperationMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:809:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalMappingDsl.g:810:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:810:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:811:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_13_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_13_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_14=(Token)match(input,16,FOLLOW_29); 

                    				newLeafNode(otherlv_14, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:833:3: (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==22) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMappingDsl.g:834:4: otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,22,FOLLOW_8); 

                    				newLeafNode(otherlv_15, grammarAccess.getOperationMappingAccess().getParametersKeyword_6_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_30); 

                    				newLeafNode(otherlv_16, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:842:4: ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==24||LA31_0==27) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalMappingDsl.g:843:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    	    {
                    	    // InternalMappingDsl.g:843:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    	    // InternalMappingDsl.g:844:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    	    {
                    	    // InternalMappingDsl.g:844:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    	    int alt30=2;
                    	    int LA30_0 = input.LA(1);

                    	    if ( (LA30_0==24) ) {
                    	        alt30=1;
                    	    }
                    	    else if ( (LA30_0==27) ) {
                    	        alt30=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 30, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt30) {
                    	        case 1 :
                    	            // InternalMappingDsl.g:845:7: lv_parameterMappings_17_1= rulePrimitiveParameterMapping
                    	            {

                    	            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_2_0_0());
                    	            						
                    	            pushFollow(FOLLOW_31);
                    	            lv_parameterMappings_17_1=rulePrimitiveParameterMapping();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"parameterMappings",
                    	            								lv_parameterMappings_17_1,
                    	            								"de.fhdo.lemma.technology.mappingdsl.MappingDsl.PrimitiveParameterMapping");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalMappingDsl.g:861:7: lv_parameterMappings_17_2= ruleComplexParameterMapping
                    	            {

                    	            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_2_0_1());
                    	            						
                    	            pushFollow(FOLLOW_31);
                    	            lv_parameterMappings_17_2=ruleComplexParameterMapping();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getOperationMappingRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"parameterMappings",
                    	            								lv_parameterMappings_17_2,
                    	            								"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ComplexParameterMapping");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;

                    	    }


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

                    otherlv_18=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_18, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_19=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_7());
            		

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
    // InternalMappingDsl.g:892:1: entryRuleReferredOperationMapping returns [EObject current=null] : iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF ;
    public final EObject entryRuleReferredOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperationMapping = null;


        try {
            // InternalMappingDsl.g:892:65: (iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF )
            // InternalMappingDsl.g:893:2: iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF
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
    // InternalMappingDsl.g:899:1: ruleReferredOperationMapping returns [EObject current=null] : (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) ;
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
            // InternalMappingDsl.g:905:2: ( (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) )
            // InternalMappingDsl.g:906:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            {
            // InternalMappingDsl.g:906:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            // InternalMappingDsl.g:907:3: otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReferredOperationMappingAccess().getReferredKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getReferredOperationMappingAccess().getOperationKeyword_1());
            		
            // InternalMappingDsl.g:915:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:916:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:916:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:917:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getOperationReferredOperationCrossReference_2_0());
            				
            pushFollow(FOLLOW_8);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:935:3: (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==18) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMappingDsl.g:936:4: otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationMappingAccess().getProtocolsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,14,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:944:4: ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0>=96 && LA33_0<=97)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalMappingDsl.g:945:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:945:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:946:6: lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    lv_protocols_6_0=ruleTechnologySpecificProtocolSpecification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_6_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocolSpecification");
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

                    otherlv_7=(Token)match(input,16,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:968:3: (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==19) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMappingDsl.g:969:4: otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationMappingAccess().getEndpointsKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:977:4: ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_ID) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalMappingDsl.g:978:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:978:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:979:6: lv_endpoints_10_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_endpoints_10_0=ruleTechnologySpecificEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_10_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificEndpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_24); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:1001:3: (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==15) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalMappingDsl.g:1002:4: otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_12, grammarAccess.getReferredOperationMappingAccess().getAspectsKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:1010:4: ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==RULE_ID) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1011:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1011:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1012:6: lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_14_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_14_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);

                    otherlv_15=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_15, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_16=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:1042:1: entryRulePrimitiveParameterMapping returns [EObject current=null] : iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF ;
    public final EObject entryRulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveParameterMapping = null;


        try {
            // InternalMappingDsl.g:1042:66: (iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF )
            // InternalMappingDsl.g:1043:2: iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF
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
    // InternalMappingDsl.g:1049:1: rulePrimitiveParameterMapping returns [EObject current=null] : (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
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
        Token otherlv_12=null;
        EObject lv_aspects_9_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1055:2: ( (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) )
            // InternalMappingDsl.g:1056:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
            {
            // InternalMappingDsl.g:1056:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
            // InternalMappingDsl.g:1057:3: otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveKeyword_0());
            		
            // InternalMappingDsl.g:1061:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1062:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1062:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1063:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(otherlv_1, grammarAccess.getPrimitiveParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1074:3: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMappingDsl.g:1075:4: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimitiveParameterMappingAccess().getColonKeyword_2_0());
                    			
                    // InternalMappingDsl.g:1079:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:1080:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:1080:5: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:1081:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_3, grammarAccess.getPrimitiveParameterMappingAccess().getTechnologyImportCrossReference_2_1_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimitiveParameterMappingAccess().getColonColonKeyword_2_2());
                    			
                    // InternalMappingDsl.g:1096:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:1097:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:1097:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:1098:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveTypeTechnologySpecificPrimitiveTypeCrossReference_2_3_0());
                    					
                    pushFollow(FOLLOW_34);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:1113:3: ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==14) ) {
                alt41=1;
            }
            else if ( (LA41_0==26) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalMappingDsl.g:1114:4: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:1114:4: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                    // InternalMappingDsl.g:1115:5: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_35); 

                    					newLeafNode(otherlv_6, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0_0());
                    				
                    otherlv_7=(Token)match(input,15,FOLLOW_8); 

                    					newLeafNode(otherlv_7, grammarAccess.getPrimitiveParameterMappingAccess().getAspectsKeyword_3_0_1());
                    				
                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    					newLeafNode(otherlv_8, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0_2());
                    				
                    // InternalMappingDsl.g:1127:5: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1128:6: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1128:6: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1129:7: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_3_0_3_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_9_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPrimitiveParameterMappingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"aspects",
                    	    								lv_aspects_9_0,
                    	    								"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_25); 

                    					newLeafNode(otherlv_10, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_0_4());
                    				
                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_11, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_0_5());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1156:4: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getPrimitiveParameterMappingAccess().getSemicolonKeyword_3_1());
                    			

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
    // InternalMappingDsl.g:1165:1: entryRuleComplexParameterMapping returns [EObject current=null] : iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF ;
    public final EObject entryRuleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexParameterMapping = null;


        try {
            // InternalMappingDsl.g:1165:64: (iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF )
            // InternalMappingDsl.g:1166:2: iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF
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
    // InternalMappingDsl.g:1172:1: ruleComplexParameterMapping returns [EObject current=null] : (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) ) ;
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_aspects_9_0 = null;

        EObject lv_aspects_17_0 = null;

        EObject lv_fieldMappings_19_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1178:2: ( (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) ) )
            // InternalMappingDsl.g:1179:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) )
            {
            // InternalMappingDsl.g:1179:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) )
            // InternalMappingDsl.g:1180:3: otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexParameterMappingAccess().getComplexKeyword_0());
            		
            // InternalMappingDsl.g:1184:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1185:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1185:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1186:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_1, grammarAccess.getComplexParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1197:3: ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==14||(LA48_0>=25 && LA48_0<=26)) ) {
                alt48=1;
            }
            else if ( (LA48_0==28) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalMappingDsl.g:1198:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
                    {
                    // InternalMappingDsl.g:1198:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
                    // InternalMappingDsl.g:1199:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
                    {
                    // InternalMappingDsl.g:1199:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==25) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalMappingDsl.g:1200:6: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_2=(Token)match(input,25,FOLLOW_7); 

                            						newLeafNode(otherlv_2, grammarAccess.getComplexParameterMappingAccess().getColonKeyword_2_0_0_0());
                            					
                            // InternalMappingDsl.g:1204:6: ( (otherlv_3= RULE_ID ) )
                            // InternalMappingDsl.g:1205:7: (otherlv_3= RULE_ID )
                            {
                            // InternalMappingDsl.g:1205:7: (otherlv_3= RULE_ID )
                            // InternalMappingDsl.g:1206:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

                            								newLeafNode(otherlv_3, grammarAccess.getComplexParameterMappingAccess().getTechnologyImportCrossReference_2_0_0_1_0());
                            							

                            }


                            }

                            otherlv_4=(Token)match(input,17,FOLLOW_7); 

                            						newLeafNode(otherlv_4, grammarAccess.getComplexParameterMappingAccess().getColonColonKeyword_2_0_0_2());
                            					
                            // InternalMappingDsl.g:1221:6: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1222:7: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1222:7: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1223:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getTechnologySpecificComplexTypeComplexTypeCrossReference_2_0_0_3_0());
                            							
                            pushFollow(FOLLOW_34);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1238:5: ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==14) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==26) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalMappingDsl.g:1239:6: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                            {
                            // InternalMappingDsl.g:1239:6: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                            // InternalMappingDsl.g:1240:7: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                            {
                            otherlv_6=(Token)match(input,14,FOLLOW_35); 

                            							newLeafNode(otherlv_6, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0_0());
                            						
                            otherlv_7=(Token)match(input,15,FOLLOW_8); 

                            							newLeafNode(otherlv_7, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_0_1_0_1());
                            						
                            otherlv_8=(Token)match(input,14,FOLLOW_7); 

                            							newLeafNode(otherlv_8, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0_2());
                            						
                            // InternalMappingDsl.g:1252:7: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt43=0;
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==RULE_ID) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1253:8: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1253:8: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1254:9: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    									newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_1_0_3_0());
                            	    								
                            	    pushFollow(FOLLOW_10);
                            	    lv_aspects_9_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"aspects",
                            	    										lv_aspects_9_0,
                            	    										"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                            otherlv_10=(Token)match(input,16,FOLLOW_25); 

                            							newLeafNode(otherlv_10, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_0_4());
                            						
                            otherlv_11=(Token)match(input,16,FOLLOW_2); 

                            							newLeafNode(otherlv_11, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_0_5());
                            						

                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1281:6: otherlv_12= ';'
                            {
                            otherlv_12=(Token)match(input,26,FOLLOW_2); 

                            						newLeafNode(otherlv_12, grammarAccess.getComplexParameterMappingAccess().getSemicolonKeyword_2_0_1_1());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1288:4: (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' )
                    {
                    // InternalMappingDsl.g:1288:4: (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' )
                    // InternalMappingDsl.g:1289:5: otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}'
                    {
                    otherlv_13=(Token)match(input,28,FOLLOW_8); 

                    					newLeafNode(otherlv_13, grammarAccess.getComplexParameterMappingAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
                    				
                    otherlv_14=(Token)match(input,14,FOLLOW_37); 

                    					newLeafNode(otherlv_14, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_1());
                    				
                    // InternalMappingDsl.g:1297:5: (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==15) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalMappingDsl.g:1298:6: otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}'
                            {
                            otherlv_15=(Token)match(input,15,FOLLOW_8); 

                            						newLeafNode(otherlv_15, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_1_2_0());
                            					
                            otherlv_16=(Token)match(input,14,FOLLOW_7); 

                            						newLeafNode(otherlv_16, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_2_1());
                            					
                            // InternalMappingDsl.g:1306:6: ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                            	    // InternalMappingDsl.g:1307:7: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1307:7: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1308:8: lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_1_2_2_0());
                            	    							
                            	    pushFollow(FOLLOW_10);
                            	    lv_aspects_17_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"aspects",
                            	    									lv_aspects_17_0,
                            	    									"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                            otherlv_18=(Token)match(input,16,FOLLOW_38); 

                            						newLeafNode(otherlv_18, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_2_3());
                            					

                            }
                            break;

                    }

                    // InternalMappingDsl.g:1330:5: ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==RULE_ID||LA47_0==29) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1331:6: (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping )
                    	    {
                    	    // InternalMappingDsl.g:1331:6: (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping )
                    	    // InternalMappingDsl.g:1332:7: lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping
                    	    {

                    	    							newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getFieldMappingsTechnologySpecificFieldMappingParserRuleCall_2_1_3_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_fieldMappings_19_0=ruleTechnologySpecificFieldMapping();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"fieldMappings",
                    	    								lv_fieldMappings_19_0,
                    	    								"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificFieldMapping");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt47 >= 1 ) break loop47;
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);

                    otherlv_20=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_20, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_4());
                    				

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


    // $ANTLR start "entryRuleTechnologySpecificFieldMapping"
    // InternalMappingDsl.g:1359:1: entryRuleTechnologySpecificFieldMapping returns [EObject current=null] : iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF ;
    public final EObject entryRuleTechnologySpecificFieldMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificFieldMapping = null;


        try {
            // InternalMappingDsl.g:1359:71: (iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF )
            // InternalMappingDsl.g:1360:2: iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificFieldMapping=ruleTechnologySpecificFieldMapping();

            state._fsp--;

             current =iv_ruleTechnologySpecificFieldMapping; 
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
    // $ANTLR end "entryRuleTechnologySpecificFieldMapping"


    // $ANTLR start "ruleTechnologySpecificFieldMapping"
    // InternalMappingDsl.g:1366:1: ruleTechnologySpecificFieldMapping returns [EObject current=null] : ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) ) ;
    public final EObject ruleTechnologySpecificFieldMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        EObject lv_aspects_5_0 = null;

        EObject lv_aspects_16_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1372:2: ( ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) ) )
            // InternalMappingDsl.g:1373:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) )
            {
            // InternalMappingDsl.g:1373:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==29) ) {
                alt53=1;
            }
            else if ( (LA53_0==RULE_ID) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalMappingDsl.g:1374:3: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' )
                    {
                    // InternalMappingDsl.g:1374:3: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' )
                    // InternalMappingDsl.g:1375:4: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}'
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificFieldMappingAccess().getFullStopKeyword_0_0());
                    			
                    // InternalMappingDsl.g:1379:4: ( (otherlv_1= RULE_ID ) )
                    // InternalMappingDsl.g:1380:5: (otherlv_1= RULE_ID )
                    {
                    // InternalMappingDsl.g:1380:5: (otherlv_1= RULE_ID )
                    // InternalMappingDsl.g:1381:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificFieldMappingAccess().getEnumerationFieldEnumerationFieldCrossReference_0_1_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,14,FOLLOW_35); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    otherlv_3=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsKeyword_0_3());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_0_4());
                    			
                    // InternalMappingDsl.g:1404:4: ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==RULE_ID) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1405:5: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1405:5: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1406:6: lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_0_5_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_5_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologySpecificFieldMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_5_0,
                    	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_0_6());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_0_7());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1433:3: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) )
                    {
                    // InternalMappingDsl.g:1433:3: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) )
                    // InternalMappingDsl.g:1434:4: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' )
                    {
                    // InternalMappingDsl.g:1434:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:1435:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:1435:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:1436:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_33); 

                    						newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificFieldMappingAccess().getDataFieldDataFieldCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalMappingDsl.g:1447:4: (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==25) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalMappingDsl.g:1448:5: otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_9=(Token)match(input,25,FOLLOW_7); 

                            					newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificFieldMappingAccess().getColonKeyword_1_1_0());
                            				
                            // InternalMappingDsl.g:1452:5: ( (otherlv_10= RULE_ID ) )
                            // InternalMappingDsl.g:1453:6: (otherlv_10= RULE_ID )
                            {
                            // InternalMappingDsl.g:1453:6: (otherlv_10= RULE_ID )
                            // InternalMappingDsl.g:1454:7: otherlv_10= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                            							}
                            						
                            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                            							newLeafNode(otherlv_10, grammarAccess.getTechnologySpecificFieldMappingAccess().getTechnologyImportCrossReference_1_1_1_0());
                            						

                            }


                            }

                            otherlv_11=(Token)match(input,17,FOLLOW_7); 

                            					newLeafNode(otherlv_11, grammarAccess.getTechnologySpecificFieldMappingAccess().getColonColonKeyword_1_1_2());
                            				
                            // InternalMappingDsl.g:1469:5: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1470:6: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1470:6: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1471:7: ruleQualifiedName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getTypeTypeCrossReference_1_1_3_0());
                            						
                            pushFollow(FOLLOW_34);
                            ruleQualifiedName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1486:4: ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==14) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==26) ) {
                        alt52=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalMappingDsl.g:1487:5: (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' )
                            {
                            // InternalMappingDsl.g:1487:5: (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' )
                            // InternalMappingDsl.g:1488:6: otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}'
                            {
                            otherlv_13=(Token)match(input,14,FOLLOW_35); 

                            						newLeafNode(otherlv_13, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_1_2_0_0());
                            					
                            otherlv_14=(Token)match(input,15,FOLLOW_8); 

                            						newLeafNode(otherlv_14, grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsKeyword_1_2_0_1());
                            					
                            otherlv_15=(Token)match(input,14,FOLLOW_7); 

                            						newLeafNode(otherlv_15, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_1_2_0_2());
                            					
                            // InternalMappingDsl.g:1500:6: ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt51=0;
                            loop51:
                            do {
                                int alt51=2;
                                int LA51_0 = input.LA(1);

                                if ( (LA51_0==RULE_ID) ) {
                                    alt51=1;
                                }


                                switch (alt51) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1501:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1501:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1502:8: lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_1_2_0_3_0());
                            	    							
                            	    pushFollow(FOLLOW_10);
                            	    lv_aspects_16_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getTechnologySpecificFieldMappingRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"aspects",
                            	    									lv_aspects_16_0,
                            	    									"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt51 >= 1 ) break loop51;
                                        EarlyExitException eee =
                                            new EarlyExitException(51, input);
                                        throw eee;
                                }
                                cnt51++;
                            } while (true);

                            otherlv_17=(Token)match(input,16,FOLLOW_25); 

                            						newLeafNode(otherlv_17, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_1_2_0_4());
                            					
                            otherlv_18=(Token)match(input,16,FOLLOW_2); 

                            						newLeafNode(otherlv_18, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_1_2_0_5());
                            					

                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1529:5: otherlv_19= ';'
                            {
                            otherlv_19=(Token)match(input,26,FOLLOW_2); 

                            					newLeafNode(otherlv_19, grammarAccess.getTechnologySpecificFieldMappingAccess().getSemicolonKeyword_1_2_1());
                            				

                            }
                            break;

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
    // $ANTLR end "ruleTechnologySpecificFieldMapping"


    // $ANTLR start "entryRuleImportedMicroservice"
    // InternalMappingDsl.g:1539:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:1539:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalMappingDsl.g:1540:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalMappingDsl.g:1546:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1552:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalMappingDsl.g:1553:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalMappingDsl.g:1553:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalMappingDsl.g:1554:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalMappingDsl.g:1554:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1555:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1555:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1556:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1571:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:1572:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:1572:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:1573:5: ruleQualifiedNameWithAtLeastOneLevel
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
    // InternalMappingDsl.g:1591:1: entryRuleTechnologySpecificProtocolSpecification returns [EObject current=null] : iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF ;
    public final EObject entryRuleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:1591:80: (iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF )
            // InternalMappingDsl.g:1592:2: iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF
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
    // InternalMappingDsl.g:1598:1: ruleTechnologySpecificProtocolSpecification returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) ;
    public final EObject ruleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_communicationType_0_0 = null;

        EObject lv_technologySpecificProtocol_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1604:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) )
            // InternalMappingDsl.g:1605:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            {
            // InternalMappingDsl.g:1605:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            // InternalMappingDsl.g:1606:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            {
            // InternalMappingDsl.g:1606:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:1607:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:1607:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:1608:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
            lv_communicationType_0_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_0_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getColonKeyword_1());
            		
            // InternalMappingDsl.g:1629:3: ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1630:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1630:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1631:5: lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol
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
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocol");
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
    // InternalMappingDsl.g:1652:1: entryRuleTechnologySpecificProtocol returns [EObject current=null] : iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF ;
    public final EObject entryRuleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocol = null;


        try {
            // InternalMappingDsl.g:1652:67: (iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF )
            // InternalMappingDsl.g:1653:2: iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF
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
    // InternalMappingDsl.g:1659:1: ruleTechnologySpecificProtocol returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1665:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:1666:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:1666:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:1667:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:1667:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1668:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1668:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1669:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificProtocolAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1684:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1685:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1685:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1686:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_40);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1700:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==30) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMappingDsl.g:1701:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificProtocolAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:1705:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:1706:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:1706:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:1707:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:1723:1: entryRuleTechnologySpecificEndpoint returns [EObject current=null] : iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF ;
    public final EObject entryRuleTechnologySpecificEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificEndpoint = null;


        try {
            // InternalMappingDsl.g:1723:67: (iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF )
            // InternalMappingDsl.g:1724:2: iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF
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
    // InternalMappingDsl.g:1730:1: ruleTechnologySpecificEndpoint returns [EObject current=null] : ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:1736:2: ( ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:1737:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:1737:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:1738:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:1738:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1739:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1739:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1740:5: lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_41);
            lv_technologySpecificProtocols_0_0=ruleTechnologySpecificProtocol();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologySpecificEndpointRule());
            					}
            					add(
            						current,
            						"technologySpecificProtocols",
            						lv_technologySpecificProtocols_0_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocol");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1757:3: (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==31) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMappingDsl.g:1758:4: otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:1762:4: ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    // InternalMappingDsl.g:1763:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    {
            	    // InternalMappingDsl.g:1763:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    // InternalMappingDsl.g:1764:6: lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol
            	    {

            	    						newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_technologySpecificProtocols_2_0=ruleTechnologySpecificProtocol();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTechnologySpecificEndpointRule());
            	    						}
            	    						add(
            	    							current,
            	    							"technologySpecificProtocols",
            	    							lv_technologySpecificProtocols_2_0,
            	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificProtocol");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_3=(Token)match(input,25,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:1786:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:1787:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:1787:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:1788:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

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

            // InternalMappingDsl.g:1804:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==31) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalMappingDsl.g:1805:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,31,FOLLOW_42); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:1809:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:1810:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:1810:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:1811:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

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
            	    break loop56;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:1836:1: entryRuleTechnologySpecificImportedServiceAspect returns [EObject current=null] : iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF ;
    public final EObject entryRuleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:1836:80: (iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF )
            // InternalMappingDsl.g:1837:2: iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF
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
    // InternalMappingDsl.g:1843:1: ruleTechnologySpecificImportedServiceAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) ;
    public final EObject ruleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_singlePropertyValue_4_0 = null;

        EObject lv_values_5_0 = null;

        EObject lv_values_7_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1849:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:1850:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:1850:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            // InternalMappingDsl.g:1851:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';'
            {
            // InternalMappingDsl.g:1851:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1852:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1852:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1853:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1868:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1869:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1869:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1870:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getAspectServiceAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_44);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1884:3: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==32) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMappingDsl.g:1885:4: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_45); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalMappingDsl.g:1889:4: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_BIG_DECIMAL)) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==RULE_ID) ) {
                        alt58=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalMappingDsl.g:1890:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:1890:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:1891:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:1891:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:1892:7: lv_singlePropertyValue_4_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_46);
                            lv_singlePropertyValue_4_0=rulePrimitiveValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            							}
                            							set(
                            								current,
                            								"singlePropertyValue",
                            								lv_singlePropertyValue_4_0,
                            								"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1910:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:1910:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:1911:6: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:1911:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:1912:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:1912:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:1913:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_0_0());
                            							
                            pushFollow(FOLLOW_47);
                            lv_values_5_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_5_0,
                            									"de.fhdo.lemma.ServiceDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalMappingDsl.g:1930:6: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==31) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1931:7: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,31,FOLLOW_45); 

                            	    							newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getCommaKeyword_3_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:1935:7: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:1936:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:1936:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:1937:9: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_47);
                            	    lv_values_7_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_7_0,
                            	    										"de.fhdo.lemma.ServiceDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop57;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,33,FOLLOW_48); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getRightParenthesisKeyword_3_2());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSemicolonKeyword_4());
            		

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
    // InternalMappingDsl.g:1970:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMappingDsl.g:1970:47: (iv_ruleImport= ruleImport EOF )
            // InternalMappingDsl.g:1971:2: iv_ruleImport= ruleImport EOF
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
    // InternalMappingDsl.g:1977:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:1983:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:1984:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:1984:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:1985:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMappingDsl.g:1989:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalMappingDsl.g:1990:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalMappingDsl.g:1990:4: (lv_importType_1_0= ruleImportType )
            // InternalMappingDsl.g:1991:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
            lv_importType_1_0=ruleImportType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importType",
            						lv_importType_1_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ImportType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:2012:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:2013:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:2013:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:2014:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

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

            otherlv_4=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:2034:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:2035:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:2035:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:2036:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:2056:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalMappingDsl.g:2056:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalMappingDsl.g:2057:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalMappingDsl.g:2063:1: ruleMicroservice returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) ;
    public final EObject ruleMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_version_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        EObject lv_technologyReferences_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_protocols_2_0 = null;

        EObject lv_endpoints_6_0 = null;

        EObject lv_aspects_8_0 = null;

        Enumerator lv_visibility_9_0 = null;

        Enumerator lv_type_10_0 = null;

        AntlrDatatypeRuleToken lv_name_12_0 = null;

        EObject lv_requiredMicroservices_19_0 = null;

        EObject lv_requiredMicroservices_21_0 = null;

        EObject lv_requiredInterfaces_26_0 = null;

        EObject lv_requiredInterfaces_28_0 = null;

        EObject lv_requiredOperations_33_0 = null;

        EObject lv_requiredOperations_35_0 = null;

        EObject lv_interfaces_37_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:2069:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) )
            // InternalMappingDsl.g:2070:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            {
            // InternalMappingDsl.g:2070:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            // InternalMappingDsl.g:2071:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}'
            {
            // InternalMappingDsl.g:2071:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==37) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==44) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalMappingDsl.g:2072:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalMappingDsl.g:2072:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalMappingDsl.g:2073:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_52);
            	    lv_technologyReferences_0_0=ruleTechnologyReference();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"technologyReferences",
            	    						lv_technologyReferences_0_0,
            	    						"de.fhdo.lemma.ServiceDsl.TechnologyReference");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            // InternalMappingDsl.g:2090:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==37) ) {
                int LA62_1 = input.LA(2);

                if ( ((LA62_1>=96 && LA62_1<=97)) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // InternalMappingDsl.g:2091:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2091:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2092:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2092:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2093:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_52);
                    lv_protocols_1_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_1_0,
                    							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2110:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==37) ) {
                        int LA61_1 = input.LA(2);

                        if ( ((LA61_1>=96 && LA61_1<=97)) ) {
                            alt61=1;
                        }
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalMappingDsl.g:2111:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2111:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2112:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_52);
                            lv_protocols_2_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_2_0,
                            							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2130:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==37) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==19) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalMappingDsl.g:2131:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_53); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,19,FOLLOW_54); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMappingDsl.g:2143:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==RULE_ID) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2144:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2144:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2145:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
                    	    lv_endpoints_6_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_6_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);

                    otherlv_7=(Token)match(input,33,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2167:3: ( (lv_aspects_8_0= ruleImportedServiceAspect ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==37) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalMappingDsl.g:2168:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2168:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2169:5: lv_aspects_8_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_52);
            	    lv_aspects_8_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_8_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            // InternalMappingDsl.g:2186:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=87 && LA66_0<=89)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalMappingDsl.g:2187:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2187:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2188:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_52);
                    lv_visibility_9_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_9_0,
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2205:3: ( (lv_type_10_0= ruleMicroserviceType ) )
            // InternalMappingDsl.g:2206:4: (lv_type_10_0= ruleMicroserviceType )
            {
            // InternalMappingDsl.g:2206:4: (lv_type_10_0= ruleMicroserviceType )
            // InternalMappingDsl.g:2207:5: lv_type_10_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_56);
            lv_type_10_0=ruleMicroserviceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_10_0,
            						"de.fhdo.lemma.ServiceDsl.MicroserviceType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_6());
            		
            // InternalMappingDsl.g:2228:3: ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:2229:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:2229:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:2230:5: lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_57);
            lv_name_12_0=ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_12_0,
            						"de.fhdo.lemma.ServiceDsl.QualifiedNameWithAtLeastOneLevel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:2247:3: (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==39) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalMappingDsl.g:2248:4: otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) )
                    {
                    otherlv_13=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalMappingDsl.g:2252:4: ( (lv_version_14_0= RULE_ID ) )
                    // InternalMappingDsl.g:2253:5: (lv_version_14_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2253:5: (lv_version_14_0= RULE_ID )
                    // InternalMappingDsl.g:2254:6: lv_version_14_0= RULE_ID
                    {
                    lv_version_14_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_version_14_0, grammarAccess.getMicroserviceAccess().getVersionIDTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMicroserviceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"version",
                    							lv_version_14_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,14,FOLLOW_58); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalMappingDsl.g:2275:3: (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==40) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==41) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalMappingDsl.g:2276:4: otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}'
                    {
                    otherlv_16=(Token)match(input,40,FOLLOW_59); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_17=(Token)match(input,41,FOLLOW_8); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_18=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalMappingDsl.g:2288:4: ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) )
                    // InternalMappingDsl.g:2289:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalMappingDsl.g:2289:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    // InternalMappingDsl.g:2290:6: lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_requiredMicroservices_19_0=rulePossiblyImportedMicroservice();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredMicroservices",
                    							lv_requiredMicroservices_19_0,
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedMicroservice");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2307:4: (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==31) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2308:5: otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_20=(Token)match(input,31,FOLLOW_7); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2312:5: ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalMappingDsl.g:2313:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalMappingDsl.g:2313:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    // InternalMappingDsl.g:2314:7: lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
                    	    lv_requiredMicroservices_21_0=rulePossiblyImportedMicroservice();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredMicroservices",
                    	    								lv_requiredMicroservices_21_0,
                    	    								"de.fhdo.lemma.ServiceDsl.PossiblyImportedMicroservice");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,16,FOLLOW_58); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2337:3: (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==40) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==42) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalMappingDsl.g:2338:4: otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}'
                    {
                    otherlv_23=(Token)match(input,40,FOLLOW_61); 

                    				newLeafNode(otherlv_23, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_24=(Token)match(input,42,FOLLOW_8); 

                    				newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_25=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalMappingDsl.g:2350:4: ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) )
                    // InternalMappingDsl.g:2351:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    {
                    // InternalMappingDsl.g:2351:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    // InternalMappingDsl.g:2352:6: lv_requiredInterfaces_26_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_requiredInterfaces_26_0=rulePossiblyImportedInterface();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredInterfaces",
                    							lv_requiredInterfaces_26_0,
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedInterface");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2369:4: (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==31) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2370:5: otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_27=(Token)match(input,31,FOLLOW_7); 

                    	    					newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2374:5: ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    // InternalMappingDsl.g:2375:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalMappingDsl.g:2375:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    // InternalMappingDsl.g:2376:7: lv_requiredInterfaces_28_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
                    	    lv_requiredInterfaces_28_0=rulePossiblyImportedInterface();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredInterfaces",
                    	    								lv_requiredInterfaces_28_0,
                    	    								"de.fhdo.lemma.ServiceDsl.PossiblyImportedInterface");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,16,FOLLOW_58); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2399:3: (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==40) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMappingDsl.g:2400:4: otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}'
                    {
                    otherlv_30=(Token)match(input,40,FOLLOW_62); 

                    				newLeafNode(otherlv_30, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_31=(Token)match(input,43,FOLLOW_8); 

                    				newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_32=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalMappingDsl.g:2412:4: ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:2413:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:2413:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:2414:6: lv_requiredOperations_33_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_requiredOperations_33_0=rulePossiblyImportedOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredOperations",
                    							lv_requiredOperations_33_0,
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2431:4: (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==31) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2432:5: otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_34=(Token)match(input,31,FOLLOW_7); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2436:5: ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    // InternalMappingDsl.g:2437:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalMappingDsl.g:2437:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    // InternalMappingDsl.g:2438:7: lv_requiredOperations_35_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
                    	    lv_requiredOperations_35_0=rulePossiblyImportedOperation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredOperations",
                    	    								lv_requiredOperations_35_0,
                    	    								"de.fhdo.lemma.ServiceDsl.PossiblyImportedOperation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,16,FOLLOW_58); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2461:3: ( (lv_interfaces_37_0= ruleInterface ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==20||LA74_0==37||LA74_0==47||(LA74_0>=87 && LA74_0<=89)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalMappingDsl.g:2462:4: (lv_interfaces_37_0= ruleInterface )
            	    {
            	    // InternalMappingDsl.g:2462:4: (lv_interfaces_37_0= ruleInterface )
            	    // InternalMappingDsl.g:2463:5: lv_interfaces_37_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_63);
            	    lv_interfaces_37_0=ruleInterface();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"interfaces",
            	    						lv_interfaces_37_0,
            	    						"de.fhdo.lemma.ServiceDsl.Interface");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            otherlv_38=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_38, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_14());
            		

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


    // $ANTLR start "entryRuleTechnologyReference"
    // InternalMappingDsl.g:2488:1: entryRuleTechnologyReference returns [EObject current=null] : iv_ruleTechnologyReference= ruleTechnologyReference EOF ;
    public final EObject entryRuleTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyReference = null;


        try {
            // InternalMappingDsl.g:2488:60: (iv_ruleTechnologyReference= ruleTechnologyReference EOF )
            // InternalMappingDsl.g:2489:2: iv_ruleTechnologyReference= ruleTechnologyReference EOF
            {
             newCompositeNode(grammarAccess.getTechnologyReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologyReference=ruleTechnologyReference();

            state._fsp--;

             current =iv_ruleTechnologyReference; 
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
    // $ANTLR end "entryRuleTechnologyReference"


    // $ANTLR start "ruleTechnologyReference"
    // InternalMappingDsl.g:2495:1: ruleTechnologyReference returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) ;
    public final EObject ruleTechnologyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_isTypeDefinitionTechnology_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2501:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) )
            // InternalMappingDsl.g:2502:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            {
            // InternalMappingDsl.g:2502:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            // InternalMappingDsl.g:2503:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,44,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:2515:3: ( (otherlv_3= RULE_ID ) )
            // InternalMappingDsl.g:2516:4: (otherlv_3= RULE_ID )
            {
            // InternalMappingDsl.g:2516:4: (otherlv_3= RULE_ID )
            // InternalMappingDsl.g:2517:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(otherlv_3, grammarAccess.getTechnologyReferenceAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            // InternalMappingDsl.g:2528:3: (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==31) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalMappingDsl.g:2529:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_65); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,45,FOLLOW_66); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,46,FOLLOW_67); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologyReferenceAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalMappingDsl.g:2541:4: ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:2542:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:2542:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:2543:6: lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN
                    {
                    lv_isTypeDefinitionTechnology_7_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_46); 

                    						newLeafNode(lv_isTypeDefinitionTechnology_7_0, grammarAccess.getTechnologyReferenceAccess().getIsTypeDefinitionTechnologyBOOLEANTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologyReferenceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"isTypeDefinitionTechnology",
                    							lv_isTypeDefinitionTechnology_7_0,
                    							"de.fhdo.lemma.data.DataDsl.BOOLEAN");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,33,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTechnologyReferenceAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleTechnologyReference"


    // $ANTLR start "entryRulePossiblyImportedMicroservice"
    // InternalMappingDsl.g:2568:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:2568:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalMappingDsl.g:2569:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalMappingDsl.g:2575:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2581:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2582:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2582:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2583:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2583:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==17) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalMappingDsl.g:2584:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2584:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2585:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2585:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2586:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2602:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2603:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2603:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2604:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2622:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalMappingDsl.g:2622:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalMappingDsl.g:2623:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalMappingDsl.g:2629:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2635:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2636:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2636:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2637:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2637:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==17) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // InternalMappingDsl.g:2638:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2638:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2639:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2639:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2640:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2656:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2657:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2657:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2658:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2676:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalMappingDsl.g:2676:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalMappingDsl.g:2677:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalMappingDsl.g:2683:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2689:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2690:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2690:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2691:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2691:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==17) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // InternalMappingDsl.g:2692:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2692:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2693:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2693:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2694:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2710:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2711:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2711:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2712:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2730:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalMappingDsl.g:2730:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalMappingDsl.g:2731:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalMappingDsl.g:2737:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) ;
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
            // InternalMappingDsl.g:2743:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) )
            // InternalMappingDsl.g:2744:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            {
            // InternalMappingDsl.g:2744:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            // InternalMappingDsl.g:2745:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}'
            {
            // InternalMappingDsl.g:2745:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==37) ) {
                int LA80_1 = input.LA(2);

                if ( ((LA80_1>=96 && LA80_1<=97)) ) {
                    alt80=1;
                }
            }
            switch (alt80) {
                case 1 :
                    // InternalMappingDsl.g:2746:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2746:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2747:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2747:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2748:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_68);
                    lv_protocols_0_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_0_0,
                    							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2765:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==37) ) {
                        int LA79_1 = input.LA(2);

                        if ( ((LA79_1>=96 && LA79_1<=97)) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalMappingDsl.g:2766:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2766:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2767:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_68);
                            lv_protocols_1_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_1_0,
                            							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2785:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==37) ) {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==19) ) {
                    alt82=1;
                }
            }
            switch (alt82) {
                case 1 :
                    // InternalMappingDsl.g:2786:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,37,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_54); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2798:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt81=0;
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==RULE_ID) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2799:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2799:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2800:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
                    	    lv_endpoints_5_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_5_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt81 >= 1 ) break loop81;
                                EarlyExitException eee =
                                    new EarlyExitException(81, input);
                                throw eee;
                        }
                        cnt81++;
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_68); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2822:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==37) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalMappingDsl.g:2823:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2823:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2824:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_68);
            	    lv_aspects_7_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_7_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

            // InternalMappingDsl.g:2841:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==47) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMappingDsl.g:2842:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:2842:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:2843:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,47,FOLLOW_69); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2855:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=87 && LA85_0<=89)) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalMappingDsl.g:2856:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2856:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2857:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_70);
                    lv_visibility_9_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_9_0,
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_10, grammarAccess.getInterfaceAccess().getInterfaceKeyword_5());
            		
            // InternalMappingDsl.g:2878:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalMappingDsl.g:2879:4: (lv_name_11_0= RULE_ID )
            {
            // InternalMappingDsl.g:2879:4: (lv_name_11_0= RULE_ID )
            // InternalMappingDsl.g:2880:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_12=(Token)match(input,14,FOLLOW_71); 

            			newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMappingDsl.g:2900:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*
            loop86:
            do {
                int alt86=2;
                alt86 = dfa86.predict(input);
                switch (alt86) {
            	case 1 :
            	    // InternalMappingDsl.g:2901:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    {
            	    // InternalMappingDsl.g:2901:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    // InternalMappingDsl.g:2902:5: lv_referredOperations_13_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_71);
            	    lv_referredOperations_13_0=ruleReferredOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referredOperations",
            	    						lv_referredOperations_13_0,
            	    						"de.fhdo.lemma.ServiceDsl.ReferredOperation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

            // InternalMappingDsl.g:2919:3: ( (lv_operations_14_0= ruleOperation ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==RULE_ID||LA87_0==37||LA87_0==47||(LA87_0>=87 && LA87_0<=89)) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalMappingDsl.g:2920:4: (lv_operations_14_0= ruleOperation )
            	    {
            	    // InternalMappingDsl.g:2920:4: (lv_operations_14_0= ruleOperation )
            	    // InternalMappingDsl.g:2921:5: lv_operations_14_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_72);
            	    lv_operations_14_0=ruleOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operations",
            	    						lv_operations_14_0,
            	    						"de.fhdo.lemma.ServiceDsl.Operation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            otherlv_15=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:2946:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMappingDsl.g:2946:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMappingDsl.g:2947:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalMappingDsl.g:2953:1: ruleOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) ;
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
            // InternalMappingDsl.g:2959:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) )
            // InternalMappingDsl.g:2960:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            {
            // InternalMappingDsl.g:2960:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            // InternalMappingDsl.g:2961:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';'
            {
            // InternalMappingDsl.g:2961:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==37) ) {
                int LA89_1 = input.LA(2);

                if ( ((LA89_1>=96 && LA89_1<=97)) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // InternalMappingDsl.g:2962:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2962:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2963:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2963:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2964:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_73);
                    lv_protocols_0_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_0_0,
                    							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:2981:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==37) ) {
                        int LA88_1 = input.LA(2);

                        if ( ((LA88_1>=96 && LA88_1<=97)) ) {
                            alt88=1;
                        }
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalMappingDsl.g:2982:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2982:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2983:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_73);
                            lv_protocols_1_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getOperationRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_1_0,
                            							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3001:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==37) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==19) ) {
                    alt91=1;
                }
            }
            switch (alt91) {
                case 1 :
                    // InternalMappingDsl.g:3002:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,37,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_54); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:3014:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt90=0;
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==RULE_ID) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // InternalMappingDsl.g:3015:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:3015:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:3016:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
                    	    lv_endpoints_5_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_5_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt90 >= 1 ) break loop90;
                                EarlyExitException eee =
                                    new EarlyExitException(90, input);
                                throw eee;
                        }
                        cnt90++;
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_73); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3038:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==37) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalMappingDsl.g:3039:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3039:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3040:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_73);
            	    lv_aspects_7_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_7_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            // InternalMappingDsl.g:3057:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==47) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalMappingDsl.g:3058:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:3058:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:3059:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,47,FOLLOW_74); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3071:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=87 && LA94_0<=89)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalMappingDsl.g:3072:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:3072:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:3073:5: lv_visibility_9_0= ruleVisibility
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
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3090:3: ( (lv_name_10_0= RULE_ID ) )
            // InternalMappingDsl.g:3091:4: (lv_name_10_0= RULE_ID )
            {
            // InternalMappingDsl.g:3091:4: (lv_name_10_0= RULE_ID )
            // InternalMappingDsl.g:3092:5: lv_name_10_0= RULE_ID
            {
            lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_54); 

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

            otherlv_11=(Token)match(input,32,FOLLOW_75); 

            			newLeafNode(otherlv_11, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_6());
            		
            // InternalMappingDsl.g:3112:3: ( (lv_parameters_12_0= ruleParameter ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==37||(LA95_0>=96 && LA95_0<=97)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalMappingDsl.g:3113:4: (lv_parameters_12_0= ruleParameter )
                    {
                    // InternalMappingDsl.g:3113:4: (lv_parameters_12_0= ruleParameter )
                    // InternalMappingDsl.g:3114:5: lv_parameters_12_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_47);
                    lv_parameters_12_0=ruleParameter();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					add(
                    						current,
                    						"parameters",
                    						lv_parameters_12_0,
                    						"de.fhdo.lemma.ServiceDsl.Parameter");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3131:3: (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==31) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalMappingDsl.g:3132:4: otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) )
            	    {
            	    otherlv_13=(Token)match(input,31,FOLLOW_76); 

            	    				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMappingDsl.g:3136:4: ( (lv_parameters_14_0= ruleParameter ) )
            	    // InternalMappingDsl.g:3137:5: (lv_parameters_14_0= ruleParameter )
            	    {
            	    // InternalMappingDsl.g:3137:5: (lv_parameters_14_0= ruleParameter )
            	    // InternalMappingDsl.g:3138:6: lv_parameters_14_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_parameters_14_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_14_0,
            	    							"de.fhdo.lemma.ServiceDsl.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            otherlv_15=(Token)match(input,33,FOLLOW_48); 

            			newLeafNode(otherlv_15, grammarAccess.getOperationAccess().getRightParenthesisKeyword_9());
            		
            otherlv_16=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:3168:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalMappingDsl.g:3168:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalMappingDsl.g:3169:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalMappingDsl.g:3175:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalMappingDsl.g:3181:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalMappingDsl.g:3182:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalMappingDsl.g:3182:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalMappingDsl.g:3183:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalMappingDsl.g:3183:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==37) ) {
                int LA98_1 = input.LA(2);

                if ( ((LA98_1>=96 && LA98_1<=97)) ) {
                    alt98=1;
                }
            }
            switch (alt98) {
                case 1 :
                    // InternalMappingDsl.g:3184:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:3184:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:3185:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:3185:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:3186:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_77);
                    lv_protocols_0_0=ruleProtocolSpecification();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                    						}
                    						add(
                    							current,
                    							"protocols",
                    							lv_protocols_0_0,
                    							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:3203:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==37) ) {
                        int LA97_1 = input.LA(2);

                        if ( ((LA97_1>=96 && LA97_1<=97)) ) {
                            alt97=1;
                        }
                    }
                    switch (alt97) {
                        case 1 :
                            // InternalMappingDsl.g:3204:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:3204:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:3205:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_77);
                            lv_protocols_1_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                            						}
                            						add(
                            							current,
                            							"protocols",
                            							lv_protocols_1_0,
                            							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3223:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==37) ) {
                int LA100_1 = input.LA(2);

                if ( (LA100_1==19) ) {
                    alt100=1;
                }
            }
            switch (alt100) {
                case 1 :
                    // InternalMappingDsl.g:3224:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,37,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_54); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:3236:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt99=0;
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==RULE_ID) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // InternalMappingDsl.g:3237:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:3237:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:3238:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
                    	    lv_endpoints_5_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_5_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt99 >= 1 ) break loop99;
                                EarlyExitException eee =
                                    new EarlyExitException(99, input);
                                throw eee;
                        }
                        cnt99++;
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_77); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3260:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==37) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalMappingDsl.g:3261:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3261:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3262:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_77);
            	    lv_aspects_7_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReferredOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_7_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);

            otherlv_8=(Token)match(input,48,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalMappingDsl.g:3283:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3284:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3284:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3285:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_48);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:3307:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMappingDsl.g:3307:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMappingDsl.g:3308:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalMappingDsl.g:3314:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalMappingDsl.g:3320:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalMappingDsl.g:3321:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalMappingDsl.g:3321:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalMappingDsl.g:3322:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalMappingDsl.g:3322:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==37) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalMappingDsl.g:3323:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3323:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3324:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_76);
            	    lv_aspects_0_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParameterRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_0_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            // InternalMappingDsl.g:3341:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3342:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3342:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3343:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_78);
            lv_communicationType_1_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_1_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3360:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=93 && LA103_0<=95)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalMappingDsl.g:3361:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:3361:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:3362:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_79);
                    lv_exchangePattern_2_0=ruleExchangePattern();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterRule());
                    					}
                    					set(
                    						current,
                    						"exchangePattern",
                    						lv_exchangePattern_2_0,
                    						"de.fhdo.lemma.technology.TechnologyDsl.ExchangePattern");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3379:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==49) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalMappingDsl.g:3380:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalMappingDsl.g:3380:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalMappingDsl.g:3381:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,49,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3393:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalMappingDsl.g:3394:4: (lv_name_4_0= RULE_ID )
            {
            // InternalMappingDsl.g:3394:4: (lv_name_4_0= RULE_ID )
            // InternalMappingDsl.g:3395:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_80); 

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

            // InternalMappingDsl.g:3411:3: ( (lv_optional_5_0= '?' ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==50) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalMappingDsl.g:3412:4: (lv_optional_5_0= '?' )
                    {
                    // InternalMappingDsl.g:3412:4: (lv_optional_5_0= '?' )
                    // InternalMappingDsl.g:3413:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,50,FOLLOW_39); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,25,FOLLOW_81); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalMappingDsl.g:3429:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=77 && LA106_0<=86)) ) {
                alt106=1;
            }
            else if ( (LA106_0==RULE_ID) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalMappingDsl.g:3430:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:3430:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:3431:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:3431:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalMappingDsl.g:3432:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_primitiveType_7_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_7_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:3450:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalMappingDsl.g:3450:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalMappingDsl.g:3451:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalMappingDsl.g:3451:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalMappingDsl.g:3452:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_importedType_8_0=ruleImportedType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"importedType",
                    							lv_importedType_8_0,
                    							"de.fhdo.lemma.ServiceDsl.ImportedType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3470:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==46) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalMappingDsl.g:3471:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalMappingDsl.g:3475:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:3476:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:3476:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:3477:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedOperation");
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
    // InternalMappingDsl.g:3499:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalMappingDsl.g:3499:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalMappingDsl.g:3500:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalMappingDsl.g:3506:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3512:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:3513:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:3513:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:3514:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:3514:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3515:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3515:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3516:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3531:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3532:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3532:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3533:5: ruleQualifiedName
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
    // InternalMappingDsl.g:3551:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:3551:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalMappingDsl.g:3552:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalMappingDsl.g:3558:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3564:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalMappingDsl.g:3565:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalMappingDsl.g:3565:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalMappingDsl.g:3566:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3570:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3571:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3571:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3572:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_54);
            lv_communicationType_1_0=ruleCommunicationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"communicationType",
            						lv_communicationType_1_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:3593:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3594:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3594:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3595:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getProtocolImportedProtocolAndDataFormatParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_46);
            lv_protocol_3_0=ruleImportedProtocolAndDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolSpecificationRule());
            					}
            					set(
            						current,
            						"protocol",
            						lv_protocol_3_0,
            						"de.fhdo.lemma.ServiceDsl.ImportedProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_2); 

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
    // InternalMappingDsl.g:3620:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalMappingDsl.g:3620:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalMappingDsl.g:3621:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalMappingDsl.g:3627:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3633:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:3634:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:3634:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:3635:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:3635:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3636:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3636:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3637:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3652:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3653:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3653:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3654:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_40);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3668:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==30) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalMappingDsl.g:3669:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:3673:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:3674:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:3674:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:3675:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:3691:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalMappingDsl.g:3691:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalMappingDsl.g:3692:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalMappingDsl.g:3698:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:3704:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:3705:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:3705:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:3706:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:3706:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3707:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3707:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3708:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_41);
            lv_protocols_0_0=ruleImportedProtocolAndDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEndpointRule());
            					}
            					add(
            						current,
            						"protocols",
            						lv_protocols_0_0,
            						"de.fhdo.lemma.ServiceDsl.ImportedProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3725:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==31) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalMappingDsl.g:3726:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:3730:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalMappingDsl.g:3731:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalMappingDsl.g:3731:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalMappingDsl.g:3732:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_protocols_2_0=ruleImportedProtocolAndDataFormat();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEndpointRule());
            	    						}
            	    						add(
            	    							current,
            	    							"protocols",
            	    							lv_protocols_2_0,
            	    							"de.fhdo.lemma.ServiceDsl.ImportedProtocolAndDataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);

            otherlv_3=(Token)match(input,25,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:3754:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:3755:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:3755:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:3756:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

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

            // InternalMappingDsl.g:3772:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==31) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalMappingDsl.g:3773:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,31,FOLLOW_42); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:3777:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:3778:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:3778:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:3779:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

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
            	    break loop110;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:3804:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:3804:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalMappingDsl.g:3805:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalMappingDsl.g:3811:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalMappingDsl.g:3817:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalMappingDsl.g:3818:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalMappingDsl.g:3818:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalMappingDsl.g:3819:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3823:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:3824:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:3824:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:3825:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalMappingDsl.g:3840:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3841:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3841:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3842:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_83);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3856:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==32) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalMappingDsl.g:3857:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_45); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMappingDsl.g:3861:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( ((LA112_0>=RULE_STRING && LA112_0<=RULE_BIG_DECIMAL)) ) {
                        alt112=1;
                    }
                    else if ( (LA112_0==RULE_ID) ) {
                        alt112=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 112, 0, input);

                        throw nvae;
                    }
                    switch (alt112) {
                        case 1 :
                            // InternalMappingDsl.g:3862:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:3862:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:3863:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:3863:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:3864:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_46);
                            lv_singlePropertyValue_5_0=rulePrimitiveValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            							}
                            							set(
                            								current,
                            								"singlePropertyValue",
                            								lv_singlePropertyValue_5_0,
                            								"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:3882:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:3882:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:3883:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:3883:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:3884:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:3884:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:3885:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_47);
                            lv_values_6_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_6_0,
                            									"de.fhdo.lemma.ServiceDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalMappingDsl.g:3902:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop111:
                            do {
                                int alt111=2;
                                int LA111_0 = input.LA(1);

                                if ( (LA111_0==31) ) {
                                    alt111=1;
                                }


                                switch (alt111) {
                            	case 1 :
                            	    // InternalMappingDsl.g:3903:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,31,FOLLOW_45); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:3907:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:3908:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:3908:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:3909:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_47);
                            	    lv_values_8_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_8_0,
                            	    										"de.fhdo.lemma.ServiceDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop111;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,33,FOLLOW_2); 

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
    // InternalMappingDsl.g:3938:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalMappingDsl.g:3938:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalMappingDsl.g:3939:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalMappingDsl.g:3945:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) ;
    public final EObject rulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3951:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) )
            // InternalMappingDsl.g:3952:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            {
            // InternalMappingDsl.g:3952:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_ID) ) {
                int LA114_1 = input.LA(2);

                if ( (LA114_1==32) ) {
                    alt114=2;
                }
                else if ( (LA114_1==46) ) {
                    alt114=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 114, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // InternalMappingDsl.g:3953:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    {
                    // InternalMappingDsl.g:3953:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    // InternalMappingDsl.g:3954:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
                    {
                    // InternalMappingDsl.g:3954:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:3955:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:3955:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:3956:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_66); 

                    						newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,46,FOLLOW_84); 

                    				newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:3971:4: ( (lv_value_2_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:3972:5: (lv_value_2_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:3972:5: (lv_value_2_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:3973:6: lv_value_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getPropertyValueAssignmentAccess().getValuePrimitiveValueParserRuleCall_0_2_0());
                    					
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
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:3992:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    {
                    // InternalMappingDsl.g:3992:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    // InternalMappingDsl.g:3993:4: ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')'
                    {
                    // InternalMappingDsl.g:3993:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:3994:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:3994:5: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:3995:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_54); 

                    						newLeafNode(otherlv_3, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,32,FOLLOW_84); 

                    				newLeafNode(otherlv_4, grammarAccess.getPropertyValueAssignmentAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalMappingDsl.g:4010:4: ( (lv_value_5_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:4011:5: (lv_value_5_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:4011:5: (lv_value_5_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:4012:6: lv_value_5_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getPropertyValueAssignmentAccess().getValuePrimitiveValueParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_value_5_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,33,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getPropertyValueAssignmentAccess().getRightParenthesisKeyword_1_3());
                    			

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
    // $ANTLR end "rulePropertyValueAssignment"


    // $ANTLR start "entryRuleQualifiedNameWithAtLeastOneLevel"
    // InternalMappingDsl.g:4038:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalMappingDsl.g:4038:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalMappingDsl.g:4039:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalMappingDsl.g:4045:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:4051:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalMappingDsl.g:4052:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalMappingDsl.g:4052:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalMappingDsl.g:4053:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_85); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,29,FOLLOW_7); 

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
    // InternalMappingDsl.g:4079:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalMappingDsl.g:4079:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalMappingDsl.g:4080:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalMappingDsl.g:4086:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:4092:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:4093:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:4093:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:4094:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,44,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,35,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:4106:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:4107:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:4107:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:4108:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

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

            otherlv_4=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:4128:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:4129:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:4129:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:4130:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:4150:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalMappingDsl.g:4150:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalMappingDsl.g:4151:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalMappingDsl.g:4157:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalMappingDsl.g:4163:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalMappingDsl.g:4164:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalMappingDsl.g:4164:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalMappingDsl.g:4165:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalMappingDsl.g:4165:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:4166:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:4166:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:4167:5: lv_communicationType_0_0= ruleCommunicationType
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
            						"de.fhdo.lemma.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4184:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:4185:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:4185:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:4186:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_86); 

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

            otherlv_2=(Token)match(input,51,FOLLOW_87); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,52,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalMappingDsl.g:4210:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalMappingDsl.g:4211:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalMappingDsl.g:4211:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalMappingDsl.g:4212:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_88);
            lv_dataFormats_4_0=ruleDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProtocolRule());
            					}
            					add(
            						current,
            						"dataFormats",
            						lv_dataFormats_4_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.DataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4229:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==31) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // InternalMappingDsl.g:4230:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,31,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:4234:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalMappingDsl.g:4235:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalMappingDsl.g:4235:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalMappingDsl.g:4236:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_88);
            	    lv_dataFormats_6_0=ruleDataFormat();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProtocolRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dataFormats",
            	    							lv_dataFormats_6_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.DataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop115;
                }
            } while (true);

            // InternalMappingDsl.g:4254:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==53) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalMappingDsl.g:4255:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:4255:4: ( (lv_default_7_0= 'default' ) )
                    // InternalMappingDsl.g:4256:5: (lv_default_7_0= 'default' )
                    {
                    // InternalMappingDsl.g:4256:5: (lv_default_7_0= 'default' )
                    // InternalMappingDsl.g:4257:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,53,FOLLOW_89); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,54,FOLLOW_90); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,55,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalMappingDsl.g:4277:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMappingDsl.g:4278:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMappingDsl.g:4278:5: (otherlv_10= RULE_ID )
                    // InternalMappingDsl.g:4279:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_48); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:4299:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalMappingDsl.g:4299:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalMappingDsl.g:4300:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalMappingDsl.g:4306:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4312:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalMappingDsl.g:4313:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:4313:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4314:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4314:3: (lv_formatName_0_0= RULE_ID )
            // InternalMappingDsl.g:4315:4: lv_formatName_0_0= RULE_ID
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
    // InternalMappingDsl.g:4334:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalMappingDsl.g:4334:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalMappingDsl.g:4335:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalMappingDsl.g:4341:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:4347:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:4348:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:4348:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalMappingDsl.g:4349:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_91); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4357:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4358:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4358:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4359:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_92); 

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

            // InternalMappingDsl.g:4375:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==56) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalMappingDsl.g:4376:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,56,FOLLOW_93); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,57,FOLLOW_94); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalMappingDsl.g:4384:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:4385:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:4385:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalMappingDsl.g:4386:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_88);
                    lv_basicBuiltinPrimitiveTypes_5_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
                    						}
                    						add(
                    							current,
                    							"basicBuiltinPrimitiveTypes",
                    							lv_basicBuiltinPrimitiveTypes_5_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:4403:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==31) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4404:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_94); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMappingDsl.g:4408:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalMappingDsl.g:4409:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalMappingDsl.g:4409:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalMappingDsl.g:4410:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_88);
                    	    lv_basicBuiltinPrimitiveTypes_7_0=rulePrimitiveType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"basicBuiltinPrimitiveTypes",
                    	    								lv_basicBuiltinPrimitiveTypes_7_0,
                    	    								"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop117;
                        }
                    } while (true);

                    // InternalMappingDsl.g:4428:4: ( (lv_default_8_0= 'default' ) )?
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==53) ) {
                        alt118=1;
                    }
                    switch (alt118) {
                        case 1 :
                            // InternalMappingDsl.g:4429:5: (lv_default_8_0= 'default' )
                            {
                            // InternalMappingDsl.g:4429:5: (lv_default_8_0= 'default' )
                            // InternalMappingDsl.g:4430:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,53,FOLLOW_48); 

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

            otherlv_9=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:4451:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalMappingDsl.g:4451:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalMappingDsl.g:4452:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalMappingDsl.g:4458:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4464:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4465:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4465:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4466:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_91); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4474:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4475:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4475:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4476:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_48); 

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

            otherlv_3=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:4500:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalMappingDsl.g:4500:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalMappingDsl.g:4501:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalMappingDsl.g:4507:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4513:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4514:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4514:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4515:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_91); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4523:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4524:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4524:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4525:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_48); 

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

            otherlv_3=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:4549:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalMappingDsl.g:4549:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalMappingDsl.g:4550:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalMappingDsl.g:4556:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4562:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:4563:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:4563:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:4564:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:4564:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==RULE_ID) ) {
                int LA120_1 = input.LA(2);

                if ( (LA120_1==17) ) {
                    alt120=1;
                }
            }
            switch (alt120) {
                case 1 :
                    // InternalMappingDsl.g:4565:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:4565:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:4566:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:4566:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:4567:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:4583:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4584:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4584:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4585:5: ruleQualifiedName
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
    // InternalMappingDsl.g:4603:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalMappingDsl.g:4603:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalMappingDsl.g:4604:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalMappingDsl.g:4610:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:4616:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalMappingDsl.g:4617:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4617:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalMappingDsl.g:4618:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalMappingDsl.g:4618:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4619:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4619:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4620:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_95);
            lv_compatibleTypes_0_0=rulePossiblyImportedTechnologySpecificType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            					}
            					add(
            						current,
            						"compatibleTypes",
            						lv_compatibleTypes_0_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.PossiblyImportedTechnologySpecificType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4637:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==31) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // InternalMappingDsl.g:4638:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:4642:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalMappingDsl.g:4643:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalMappingDsl.g:4643:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalMappingDsl.g:4644:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_95);
            	    lv_compatibleTypes_2_0=rulePossiblyImportedTechnologySpecificType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            	    						}
            	    						add(
            	    							current,
            	    							"compatibleTypes",
            	    							lv_compatibleTypes_2_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.PossiblyImportedTechnologySpecificType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop121;
                }
            } while (true);

            // InternalMappingDsl.g:4662:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalMappingDsl.g:4663:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalMappingDsl.g:4663:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalMappingDsl.g:4664:5: lv_direction_3_0= ruleCompatibilityDirection
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
            						"de.fhdo.lemma.technology.TechnologyDsl.CompatibilityDirection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4681:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4682:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4682:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4683:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_48);
            lv_mappingType_4_0=rulePossiblyImportedTechnologySpecificType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompatibilityMatrixEntryRule());
            					}
            					set(
            						current,
            						"mappingType",
            						lv_mappingType_4_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.PossiblyImportedTechnologySpecificType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:4708:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalMappingDsl.g:4708:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalMappingDsl.g:4709:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalMappingDsl.g:4715:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4721:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4722:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4722:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4723:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4723:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4724:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4724:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4725:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_1=(Token)match(input,14,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,60,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,46,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4757:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4758:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4758:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4759:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_43);
            lv_operationEnvironments_5_0=ruleOperationEnvironment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeploymentTechnologyRule());
            					}
            					add(
            						current,
            						"operationEnvironments",
            						lv_operationEnvironments_5_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4776:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==31) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // InternalMappingDsl.g:4777:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,31,FOLLOW_42); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4781:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4782:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4782:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4783:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_operationEnvironments_7_0=ruleOperationEnvironment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeploymentTechnologyRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operationEnvironments",
            	    							lv_operationEnvironments_7_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop122;
                }
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_97); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4805:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==61) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalMappingDsl.g:4806:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,61,FOLLOW_98); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,62,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_94); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4818:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt123=0;
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( ((LA123_0>=77 && LA123_0<=86)) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4819:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4819:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4820:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_99);
                    	    lv_serviceProperties_12_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDeploymentTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"serviceProperties",
                    	    							lv_serviceProperties_12_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt123 >= 1 ) break loop123;
                                EarlyExitException eee =
                                    new EarlyExitException(123, input);
                                throw eee;
                        }
                        cnt123++;
                    } while (true);

                    otherlv_13=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:4850:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalMappingDsl.g:4850:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalMappingDsl.g:4851:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalMappingDsl.g:4857:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4863:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4864:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4864:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4865:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4865:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4866:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4866:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4867:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_1=(Token)match(input,14,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,60,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,46,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4899:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4900:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4900:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4901:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_43);
            lv_operationEnvironments_5_0=ruleOperationEnvironment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInfrastructureTechnologyRule());
            					}
            					add(
            						current,
            						"operationEnvironments",
            						lv_operationEnvironments_5_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4918:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==31) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // InternalMappingDsl.g:4919:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,31,FOLLOW_42); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4923:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4924:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4924:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4925:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_operationEnvironments_7_0=ruleOperationEnvironment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInfrastructureTechnologyRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operationEnvironments",
            	    							lv_operationEnvironments_7_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_97); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4947:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==61) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalMappingDsl.g:4948:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,61,FOLLOW_98); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,62,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_94); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4960:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt126=0;
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( ((LA126_0>=77 && LA126_0<=86)) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4961:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4961:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4962:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_99);
                    	    lv_serviceProperties_12_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"serviceProperties",
                    	    							lv_serviceProperties_12_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt126 >= 1 ) break loop126;
                                EarlyExitException eee =
                                    new EarlyExitException(126, input);
                                throw eee;
                        }
                        cnt126++;
                    } while (true);

                    otherlv_13=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:4992:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalMappingDsl.g:4992:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalMappingDsl.g:4993:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalMappingDsl.g:4999:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5005:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalMappingDsl.g:5006:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalMappingDsl.g:5006:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalMappingDsl.g:5007:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalMappingDsl.g:5007:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalMappingDsl.g:5008:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalMappingDsl.g:5008:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalMappingDsl.g:5009:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_100); 

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

            // InternalMappingDsl.g:5025:3: ( (lv_default_1_0= 'default' ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==53) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalMappingDsl.g:5026:4: (lv_default_1_0= 'default' )
                    {
                    // InternalMappingDsl.g:5026:4: (lv_default_1_0= 'default' )
                    // InternalMappingDsl.g:5027:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,53,FOLLOW_2); 

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
    // InternalMappingDsl.g:5043:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalMappingDsl.g:5043:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalMappingDsl.g:5044:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalMappingDsl.g:5050:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:5056:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:5057:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:5057:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalMappingDsl.g:5058:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalMappingDsl.g:5058:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalMappingDsl.g:5059:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalMappingDsl.g:5059:4: (lv_type_0_0= rulePrimitiveType )
            // InternalMappingDsl.g:5060:5: lv_type_0_0= rulePrimitiveType
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
            						"de.fhdo.lemma.data.DataDsl.PrimitiveType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:5077:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5078:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5078:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5079:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_101); 

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

            // InternalMappingDsl.g:5095:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==46) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalMappingDsl.g:5096:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_84); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalMappingDsl.g:5100:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:5101:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:5101:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:5102:6: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_102);
                    lv_defaultValue_3_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    						}
                    						set(
                    							current,
                    							"defaultValue",
                    							lv_defaultValue_3_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:5120:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==63) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalMappingDsl.g:5121:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,63,FOLLOW_103); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalMappingDsl.g:5125:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalMappingDsl.g:5126:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalMappingDsl.g:5126:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalMappingDsl.g:5127:6: lv_features_5_0= rulePropertyFeature
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_104);
                    lv_features_5_0=rulePropertyFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_5_0,
                    							"de.fhdo.lemma.technology.TechnologyDsl.PropertyFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:5144:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( (LA130_0==31) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5145:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_103); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalMappingDsl.g:5149:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalMappingDsl.g:5150:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalMappingDsl.g:5150:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalMappingDsl.g:5151:7: lv_features_7_0= rulePropertyFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
                    	    lv_features_7_0=rulePropertyFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_7_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.PropertyFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop130;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,64,FOLLOW_48); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificPropertyAccess().getGreaterThanSignKeyword_3_3());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:5182:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalMappingDsl.g:5182:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalMappingDsl.g:5183:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalMappingDsl.g:5189:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalMappingDsl.g:5195:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalMappingDsl.g:5196:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalMappingDsl.g:5196:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt132=4;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt132=1;
                }
                break;
            case 66:
                {
                alt132=2;
                }
                break;
            case 67:
                {
                alt132=3;
                }
                break;
            case 68:
                {
                alt132=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }

            switch (alt132) {
                case 1 :
                    // InternalMappingDsl.g:5197:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalMappingDsl.g:5197:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalMappingDsl.g:5198:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalMappingDsl.g:5198:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalMappingDsl.g:5199:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalMappingDsl.g:5199:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalMappingDsl.g:5200:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,65,FOLLOW_66); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,46,FOLLOW_105); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:5216:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalMappingDsl.g:5217:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:5217:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:5218:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    							"de.fhdo.lemma.technology.TechnologyDsl.ExchangePattern");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5237:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalMappingDsl.g:5237:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalMappingDsl.g:5238:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalMappingDsl.g:5238:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalMappingDsl.g:5239:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalMappingDsl.g:5239:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalMappingDsl.g:5240:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,66,FOLLOW_66); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,46,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalMappingDsl.g:5256:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalMappingDsl.g:5257:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalMappingDsl.g:5257:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalMappingDsl.g:5258:6: lv_communicationType_5_0= ruleCommunicationType
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
                    							"de.fhdo.lemma.technology.TechnologyDsl.CommunicationType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:5277:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:5277:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalMappingDsl.g:5278:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:5278:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalMappingDsl.g:5279:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalMappingDsl.g:5279:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalMappingDsl.g:5280:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,67,FOLLOW_66); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMappingDsl.g:5296:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:5297:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:5297:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:5298:6: otherlv_8= RULE_ID
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
                    // InternalMappingDsl.g:5311:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:5311:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalMappingDsl.g:5312:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:5312:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalMappingDsl.g:5313:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalMappingDsl.g:5313:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalMappingDsl.g:5314:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,68,FOLLOW_66); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalMappingDsl.g:5330:4: ( (otherlv_11= RULE_ID ) )
                    // InternalMappingDsl.g:5331:5: (otherlv_11= RULE_ID )
                    {
                    // InternalMappingDsl.g:5331:5: (otherlv_11= RULE_ID )
                    // InternalMappingDsl.g:5332:6: otherlv_11= RULE_ID
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
    // InternalMappingDsl.g:5348:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:5348:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalMappingDsl.g:5349:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalMappingDsl.g:5355:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMappingDsl.g:5361:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:5362:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:5362:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:5363:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_54); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_106); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:5371:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalMappingDsl.g:5372:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalMappingDsl.g:5372:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalMappingDsl.g:5373:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_47);
            lv_pointcuts_2_0=ruleServiceAspectPointcut();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceAspectPointcutSelectorRule());
            					}
            					add(
            						current,
            						"pointcuts",
            						lv_pointcuts_2_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.ServiceAspectPointcut");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:5390:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( (LA133_0==31) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // InternalMappingDsl.g:5391:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,31,FOLLOW_106); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:5395:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalMappingDsl.g:5396:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:5396:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalMappingDsl.g:5397:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_pointcuts_4_0=ruleServiceAspectPointcut();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceAspectPointcutSelectorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pointcuts",
            	    							lv_pointcuts_4_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.ServiceAspectPointcut");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop133;
                }
            } while (true);

            otherlv_5=(Token)match(input,33,FOLLOW_48); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
    // InternalMappingDsl.g:5427:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalMappingDsl.g:5427:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalMappingDsl.g:5428:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalMappingDsl.g:5434:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalMappingDsl.g:5440:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalMappingDsl.g:5441:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalMappingDsl.g:5441:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalMappingDsl.g:5442:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5446:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5447:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5447:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5448:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_107); 

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

            otherlv_2=(Token)match(input,71,FOLLOW_108); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5468:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalMappingDsl.g:5469:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalMappingDsl.g:5469:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalMappingDsl.g:5470:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_109);
            lv_joinPoints_3_0=ruleServiceJoinPointType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceAspectRule());
            					}
            					add(
            						current,
            						"joinPoints",
            						lv_joinPoints_3_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.ServiceJoinPointType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:5487:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==31) ) {
                    alt134=1;
                }


                switch (alt134) {
            	case 1 :
            	    // InternalMappingDsl.g:5488:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_108); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5492:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalMappingDsl.g:5493:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5493:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalMappingDsl.g:5494:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_109);
            	    lv_joinPoints_5_0=ruleServiceJoinPointType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"joinPoints",
            	    							lv_joinPoints_5_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.ServiceJoinPointType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop134;
                }
            } while (true);

            // InternalMappingDsl.g:5512:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==14) ) {
                alt137=1;
            }
            else if ( (LA137_0==26) ) {
                alt137=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }
            switch (alt137) {
                case 1 :
                    // InternalMappingDsl.g:5513:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalMappingDsl.g:5513:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalMappingDsl.g:5514:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_110); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5518:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( (LA135_0==69) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5519:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:5519:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalMappingDsl.g:5520:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_110);
                    	    lv_pointcutSelectors_7_0=ruleServiceAspectPointcutSelector();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"pointcutSelectors",
                    	    								lv_pointcutSelectors_7_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.ServiceAspectPointcutSelector");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop135;
                        }
                    } while (true);

                    // InternalMappingDsl.g:5537:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( ((LA136_0>=77 && LA136_0<=86)) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5538:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5538:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5539:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_99);
                    	    lv_properties_8_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_8_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop136;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5562:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,26,FOLLOW_2); 

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


    // $ANTLR start "entryRuleOperationAspectPointcut"
    // InternalMappingDsl.g:5571:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalMappingDsl.g:5571:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalMappingDsl.g:5572:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
            {
             newCompositeNode(grammarAccess.getOperationAspectPointcutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationAspectPointcut=ruleOperationAspectPointcut();

            state._fsp--;

             current =iv_ruleOperationAspectPointcut; 
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
    // $ANTLR end "entryRuleOperationAspectPointcut"


    // $ANTLR start "ruleOperationAspectPointcut"
    // InternalMappingDsl.g:5578:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5584:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5585:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5585:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalMappingDsl.g:5586:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalMappingDsl.g:5586:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalMappingDsl.g:5587:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalMappingDsl.g:5587:4: (lv_forTechnology_0_0= 'technology' )
            // InternalMappingDsl.g:5588:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,44,FOLLOW_66); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", true, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,46,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalMappingDsl.g:5604:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:5605:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:5605:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:5606:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getOperationAspectPointcutAccess().getTechnologyEObjectCrossReference_2_0());
            				

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
    // $ANTLR end "ruleOperationAspectPointcut"


    // $ANTLR start "entryRuleOperationAspectPointcutSelector"
    // InternalMappingDsl.g:5621:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:5621:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalMappingDsl.g:5622:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
            {
             newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationAspectPointcutSelector=ruleOperationAspectPointcutSelector();

            state._fsp--;

             current =iv_ruleOperationAspectPointcutSelector; 
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
    // $ANTLR end "entryRuleOperationAspectPointcutSelector"


    // $ANTLR start "ruleOperationAspectPointcutSelector"
    // InternalMappingDsl.g:5628:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleOperationAspectPointcutSelector() throws RecognitionException {
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
            // InternalMappingDsl.g:5634:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:5635:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:5635:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:5636:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_54); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_64); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:5644:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalMappingDsl.g:5645:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalMappingDsl.g:5645:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalMappingDsl.g:5646:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
            {

            					newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_47);
            lv_pointcuts_2_0=ruleOperationAspectPointcut();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationAspectPointcutSelectorRule());
            					}
            					add(
            						current,
            						"pointcuts",
            						lv_pointcuts_2_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationAspectPointcut");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:5663:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( (LA138_0==31) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // InternalMappingDsl.g:5664:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,31,FOLLOW_64); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:5668:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalMappingDsl.g:5669:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:5669:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalMappingDsl.g:5670:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_pointcuts_4_0=ruleOperationAspectPointcut();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationAspectPointcutSelectorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pointcuts",
            	    							lv_pointcuts_4_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationAspectPointcut");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop138;
                }
            } while (true);

            otherlv_5=(Token)match(input,33,FOLLOW_48); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getOperationAspectPointcutSelectorAccess().getSemicolonKeyword_5());
            		

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
    // $ANTLR end "ruleOperationAspectPointcutSelector"


    // $ANTLR start "entryRuleOperationAspect"
    // InternalMappingDsl.g:5700:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalMappingDsl.g:5700:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalMappingDsl.g:5701:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalMappingDsl.g:5707:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
    public final EObject ruleOperationAspect() throws RecognitionException {
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
            // InternalMappingDsl.g:5713:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalMappingDsl.g:5714:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalMappingDsl.g:5714:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalMappingDsl.g:5715:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5719:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5720:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5720:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5721:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_107); 

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

            otherlv_2=(Token)match(input,71,FOLLOW_111); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5741:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalMappingDsl.g:5742:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalMappingDsl.g:5742:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalMappingDsl.g:5743:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_109);
            lv_joinPoints_3_0=ruleOperationJoinPointType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationAspectRule());
            					}
            					add(
            						current,
            						"joinPoints",
            						lv_joinPoints_3_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationJoinPointType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:5760:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop139:
            do {
                int alt139=2;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==31) ) {
                    alt139=1;
                }


                switch (alt139) {
            	case 1 :
            	    // InternalMappingDsl.g:5761:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_111); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5765:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalMappingDsl.g:5766:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5766:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalMappingDsl.g:5767:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_109);
            	    lv_joinPoints_5_0=ruleOperationJoinPointType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"joinPoints",
            	    							lv_joinPoints_5_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationJoinPointType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop139;
                }
            } while (true);

            // InternalMappingDsl.g:5785:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==14) ) {
                alt142=1;
            }
            else if ( (LA142_0==26) ) {
                alt142=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }
            switch (alt142) {
                case 1 :
                    // InternalMappingDsl.g:5786:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalMappingDsl.g:5786:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalMappingDsl.g:5787:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_110); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5791:5: ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )*
                    loop140:
                    do {
                        int alt140=2;
                        int LA140_0 = input.LA(1);

                        if ( (LA140_0==69) ) {
                            alt140=1;
                        }


                        switch (alt140) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5792:6: (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:5792:6: (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector )
                    	    // InternalMappingDsl.g:5793:7: lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPointcutSelectorsOperationAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_110);
                    	    lv_pointcutSelectors_7_0=ruleOperationAspectPointcutSelector();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"pointcutSelectors",
                    	    								lv_pointcutSelectors_7_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.OperationAspectPointcutSelector");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop140;
                        }
                    } while (true);

                    // InternalMappingDsl.g:5810:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop141:
                    do {
                        int alt141=2;
                        int LA141_0 = input.LA(1);

                        if ( ((LA141_0>=77 && LA141_0<=86)) ) {
                            alt141=1;
                        }


                        switch (alt141) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5811:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5811:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5812:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_99);
                    	    lv_properties_8_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_8_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop141;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5835:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationAspectAccess().getSemicolonKeyword_5_1());
                    			

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
    // InternalMappingDsl.g:5844:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalMappingDsl.g:5844:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalMappingDsl.g:5845:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalMappingDsl.g:5851:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:5857:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5858:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5858:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5859:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_112); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,72,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,35,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:5871:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:5872:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:5872:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:5873:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

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

            otherlv_4=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:5893:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:5894:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:5894:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:5895:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:5915:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalMappingDsl.g:5915:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalMappingDsl.g:5916:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalMappingDsl.g:5922:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalMappingDsl.g:5928:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalMappingDsl.g:5929:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalMappingDsl.g:5929:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalMappingDsl.g:5930:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalMappingDsl.g:5934:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5935:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5935:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5936:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_113); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5956:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt145=3;
            int LA145_0 = input.LA(1);

            if ( ((LA145_0>=58 && LA145_0<=59)||LA145_0==76) ) {
                alt145=1;
            }
            else if ( (LA145_0==73) ) {
                alt145=2;
            }
            switch (alt145) {
                case 1 :
                    // InternalMappingDsl.g:5957:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalMappingDsl.g:5957:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt143=0;
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);

                        if ( ((LA143_0>=58 && LA143_0<=59)||LA143_0==76) ) {
                            alt143=1;
                        }


                        switch (alt143) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5958:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalMappingDsl.g:5958:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalMappingDsl.g:5959:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_114);
                    	    lv_complexTypes_3_0=ruleComplexType();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVersionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"complexTypes",
                    	    							lv_complexTypes_3_0,
                    	    							"de.fhdo.lemma.data.DataDsl.ComplexType");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt143 >= 1 ) break loop143;
                                EarlyExitException eee =
                                    new EarlyExitException(143, input);
                                throw eee;
                        }
                        cnt143++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5977:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalMappingDsl.g:5977:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt144=0;
                    loop144:
                    do {
                        int alt144=2;
                        int LA144_0 = input.LA(1);

                        if ( (LA144_0==73) ) {
                            alt144=1;
                        }


                        switch (alt144) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5978:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalMappingDsl.g:5978:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalMappingDsl.g:5979:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_115);
                    	    lv_contexts_4_0=ruleContext();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVersionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"contexts",
                    	    							lv_contexts_4_0,
                    	    							"de.fhdo.lemma.data.DataDsl.Context");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt144 >= 1 ) break loop144;
                                EarlyExitException eee =
                                    new EarlyExitException(144, input);
                                throw eee;
                        }
                        cnt144++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:6005:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMappingDsl.g:6005:48: (iv_ruleContext= ruleContext EOF )
            // InternalMappingDsl.g:6006:2: iv_ruleContext= ruleContext EOF
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
    // InternalMappingDsl.g:6012:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6018:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalMappingDsl.g:6019:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalMappingDsl.g:6019:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalMappingDsl.g:6020:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalMappingDsl.g:6024:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6025:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6025:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6026:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_116); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:6046:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt146=0;
            loop146:
            do {
                int alt146=2;
                int LA146_0 = input.LA(1);

                if ( ((LA146_0>=58 && LA146_0<=59)||LA146_0==76) ) {
                    alt146=1;
                }


                switch (alt146) {
            	case 1 :
            	    // InternalMappingDsl.g:6047:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalMappingDsl.g:6047:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalMappingDsl.g:6048:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_114);
            	    lv_complexTypes_3_0=ruleComplexType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"complexTypes",
            	    						lv_complexTypes_3_0,
            	    						"de.fhdo.lemma.data.DataDsl.ComplexType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt146 >= 1 ) break loop146;
                        EarlyExitException eee =
                            new EarlyExitException(146, input);
                        throw eee;
                }
                cnt146++;
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:6073:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalMappingDsl.g:6073:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalMappingDsl.g:6074:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalMappingDsl.g:6080:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6086:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalMappingDsl.g:6087:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalMappingDsl.g:6087:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt147=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt147=1;
                }
                break;
            case 58:
                {
                alt147=2;
                }
                break;
            case 76:
                {
                alt147=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 147, 0, input);

                throw nvae;
            }

            switch (alt147) {
                case 1 :
                    // InternalMappingDsl.g:6088:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalMappingDsl.g:6097:3: this_ListType_1= ruleListType
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
                    // InternalMappingDsl.g:6106:3: this_Enumeration_2= ruleEnumeration
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
    // InternalMappingDsl.g:6118:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalMappingDsl.g:6118:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalMappingDsl.g:6119:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalMappingDsl.g:6125:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) ;
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
            // InternalMappingDsl.g:6131:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) )
            // InternalMappingDsl.g:6132:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            {
            // InternalMappingDsl.g:6132:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            // InternalMappingDsl.g:6133:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalMappingDsl.g:6137:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6138:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6138:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6139:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_117); 

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

            // InternalMappingDsl.g:6155:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==74) ) {
                alt148=1;
            }
            switch (alt148) {
                case 1 :
                    // InternalMappingDsl.g:6156:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,74,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMappingDsl.g:6160:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:6161:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:6161:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:6162:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_118); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:6181:3: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==RULE_ID||LA150_0==75||(LA150_0>=77 && LA150_0<=86)) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalMappingDsl.g:6182:4: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalMappingDsl.g:6182:4: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalMappingDsl.g:6183:5: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:6183:5: (lv_dataFields_5_0= ruleDataField )
                    // InternalMappingDsl.g:6184:6: lv_dataFields_5_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_dataFields_5_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_5_0,
                    							"de.fhdo.lemma.data.DataDsl.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:6201:4: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop149:
                    do {
                        int alt149=2;
                        int LA149_0 = input.LA(1);

                        if ( (LA149_0==31) ) {
                            alt149=1;
                        }


                        switch (alt149) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6202:5: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_119); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalMappingDsl.g:6206:5: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:6207:6: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:6207:6: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalMappingDsl.g:6208:7: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
                    	    lv_dataFields_7_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataFields",
                    	    								lv_dataFields_7_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop149;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:6235:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalMappingDsl.g:6235:49: (iv_ruleListType= ruleListType EOF )
            // InternalMappingDsl.g:6236:2: iv_ruleListType= ruleListType EOF
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
    // InternalMappingDsl.g:6242:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalMappingDsl.g:6248:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalMappingDsl.g:6249:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalMappingDsl.g:6249:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt152=2;
            alt152 = dfa152.predict(input);
            switch (alt152) {
                case 1 :
                    // InternalMappingDsl.g:6250:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalMappingDsl.g:6250:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalMappingDsl.g:6251:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,58,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalMappingDsl.g:6255:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalMappingDsl.g:6256:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:6256:5: (lv_name_1_0= RULE_ID )
                    // InternalMappingDsl.g:6257:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

                    otherlv_2=(Token)match(input,14,FOLLOW_119); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalMappingDsl.g:6277:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalMappingDsl.g:6278:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:6278:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalMappingDsl.g:6279:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_dataFields_3_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTypeRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_3_0,
                    							"de.fhdo.lemma.data.DataDsl.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:6296:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop151:
                    do {
                        int alt151=2;
                        int LA151_0 = input.LA(1);

                        if ( (LA151_0==31) ) {
                            alt151=1;
                        }


                        switch (alt151) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6297:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_119); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalMappingDsl.g:6301:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:6302:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:6302:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalMappingDsl.g:6303:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
                    	    lv_dataFields_5_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getListTypeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataFields",
                    	    								lv_dataFields_5_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop151;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6327:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:6327:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalMappingDsl.g:6328:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,58,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalMappingDsl.g:6332:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalMappingDsl.g:6333:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:6333:5: (lv_name_8_0= RULE_ID )
                    // InternalMappingDsl.g:6334:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

                    otherlv_9=(Token)match(input,14,FOLLOW_94); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalMappingDsl.g:6354:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:6355:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:6355:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalMappingDsl.g:6356:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_primitiveType_10_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTypeRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_10_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:6382:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalMappingDsl.g:6382:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalMappingDsl.g:6383:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalMappingDsl.g:6389:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;

        Enumerator lv_features_5_0 = null;

        Enumerator lv_features_7_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6395:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? ) )
            // InternalMappingDsl.g:6396:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? )
            {
            // InternalMappingDsl.g:6396:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? )
            // InternalMappingDsl.g:6397:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )?
            {
            // InternalMappingDsl.g:6397:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==75) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // InternalMappingDsl.g:6398:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalMappingDsl.g:6398:4: (lv_hidden_0_0= 'hide' )
                    // InternalMappingDsl.g:6399:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,75,FOLLOW_81); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:6411:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt154=3;
            int LA154_0 = input.LA(1);

            if ( ((LA154_0>=77 && LA154_0<=86)) ) {
                alt154=1;
            }
            else if ( (LA154_0==RULE_ID) ) {
                int LA154_2 = input.LA(2);

                if ( (LA154_2==RULE_ID||LA154_2==17||LA154_2==29) ) {
                    alt154=2;
                }
            }
            switch (alt154) {
                case 1 :
                    // InternalMappingDsl.g:6412:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:6412:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:6413:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:6413:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalMappingDsl.g:6414:6: lv_primitiveType_1_0= rulePrimitiveType
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
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6432:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalMappingDsl.g:6432:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalMappingDsl.g:6433:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalMappingDsl.g:6433:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalMappingDsl.g:6434:6: lv_complexType_2_0= rulePossiblyImportedComplexType
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
                    							"de.fhdo.lemma.data.DataDsl.PossiblyImportedComplexType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:6452:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMappingDsl.g:6453:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMappingDsl.g:6453:4: (lv_name_3_0= RULE_ID )
            // InternalMappingDsl.g:6454:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_120); 

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

            // InternalMappingDsl.g:6470:3: (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==63) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalMappingDsl.g:6471:4: otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,63,FOLLOW_121); 

                    				newLeafNode(otherlv_4, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalMappingDsl.g:6475:4: ( (lv_features_5_0= ruleFieldFeature ) )
                    // InternalMappingDsl.g:6476:5: (lv_features_5_0= ruleFieldFeature )
                    {
                    // InternalMappingDsl.g:6476:5: (lv_features_5_0= ruleFieldFeature )
                    // InternalMappingDsl.g:6477:6: lv_features_5_0= ruleFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_104);
                    lv_features_5_0=ruleFieldFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_5_0,
                    							"de.fhdo.lemma.data.DataDsl.FieldFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:6494:4: (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )*
                    loop155:
                    do {
                        int alt155=2;
                        int LA155_0 = input.LA(1);

                        if ( (LA155_0==31) ) {
                            alt155=1;
                        }


                        switch (alt155) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6495:5: otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_121); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalMappingDsl.g:6499:5: ( (lv_features_7_0= ruleFieldFeature ) )
                    	    // InternalMappingDsl.g:6500:6: (lv_features_7_0= ruleFieldFeature )
                    	    {
                    	    // InternalMappingDsl.g:6500:6: (lv_features_7_0= ruleFieldFeature )
                    	    // InternalMappingDsl.g:6501:7: lv_features_7_0= ruleFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
                    	    lv_features_7_0=ruleFieldFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_7_0,
                    	    								"de.fhdo.lemma.data.DataDsl.FieldFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop155;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,64,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_3_3());
                    			

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
    // $ANTLR end "ruleDataField"


    // $ANTLR start "entryRuleEnumeration"
    // InternalMappingDsl.g:6528:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalMappingDsl.g:6528:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalMappingDsl.g:6529:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalMappingDsl.g:6535:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
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
            // InternalMappingDsl.g:6541:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalMappingDsl.g:6542:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalMappingDsl.g:6542:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalMappingDsl.g:6543:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalMappingDsl.g:6547:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6548:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6548:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6549:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:6569:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalMappingDsl.g:6570:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalMappingDsl.g:6570:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalMappingDsl.g:6571:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_60);
            lv_fields_3_0=ruleEnumerationField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"fields",
            						lv_fields_3_0,
            						"de.fhdo.lemma.data.DataDsl.EnumerationField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:6588:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop157:
            do {
                int alt157=2;
                int LA157_0 = input.LA(1);

                if ( (LA157_0==31) ) {
                    alt157=1;
                }


                switch (alt157) {
            	case 1 :
            	    // InternalMappingDsl.g:6589:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,31,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:6593:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalMappingDsl.g:6594:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalMappingDsl.g:6594:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalMappingDsl.g:6595:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
            	    lv_fields_5_0=ruleEnumerationField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_5_0,
            	    							"de.fhdo.lemma.data.DataDsl.EnumerationField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop157;
                }
            } while (true);

            otherlv_6=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMappingDsl.g:6621:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalMappingDsl.g:6621:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalMappingDsl.g:6622:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalMappingDsl.g:6628:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6634:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalMappingDsl.g:6635:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalMappingDsl.g:6635:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalMappingDsl.g:6636:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalMappingDsl.g:6636:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:6637:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:6637:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:6638:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_83); 

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

            // InternalMappingDsl.g:6654:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==32) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // InternalMappingDsl.g:6655:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_84); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalMappingDsl.g:6659:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:6660:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:6660:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:6661:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_initializationValue_2_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEnumerationFieldRule());
                    						}
                    						set(
                    							current,
                    							"initializationValue",
                    							lv_initializationValue_2_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,33,FOLLOW_2); 

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
    // InternalMappingDsl.g:6687:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalMappingDsl.g:6687:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalMappingDsl.g:6688:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalMappingDsl.g:6694:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6700:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalMappingDsl.g:6701:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDsl.g:6701:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt159=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt159=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt159=2;
                }
                break;
            case RULE_STRING:
                {
                alt159=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 159, 0, input);

                throw nvae;
            }

            switch (alt159) {
                case 1 :
                    // InternalMappingDsl.g:6702:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalMappingDsl.g:6702:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalMappingDsl.g:6703:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalMappingDsl.g:6703:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalMappingDsl.g:6704:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    						"de.fhdo.lemma.data.DataDsl.BIG_DECIMAL");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6721:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalMappingDsl.g:6721:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:6722:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:6722:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:6723:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    						"de.fhdo.lemma.data.DataDsl.BOOLEAN");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6740:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalMappingDsl.g:6740:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalMappingDsl.g:6741:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalMappingDsl.g:6741:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalMappingDsl.g:6742:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalMappingDsl.g:6762:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalMappingDsl.g:6762:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalMappingDsl.g:6763:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
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
    // InternalMappingDsl.g:6769:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6775:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:6776:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:6776:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:6777:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:6777:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==RULE_ID) ) {
                int LA160_1 = input.LA(2);

                if ( (LA160_1==17) ) {
                    alt160=1;
                }
            }
            switch (alt160) {
                case 1 :
                    // InternalMappingDsl.g:6778:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:6778:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:6779:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:6779:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:6780:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:6796:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:6797:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:6797:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:6798:5: ruleQualifiedName
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
    // InternalMappingDsl.g:6816:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalMappingDsl.g:6816:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalMappingDsl.g:6817:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalMappingDsl.g:6823:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalMappingDsl.g:6829:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalMappingDsl.g:6830:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalMappingDsl.g:6830:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt161=10;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt161=1;
                }
                break;
            case 78:
                {
                alt161=2;
                }
                break;
            case 79:
                {
                alt161=3;
                }
                break;
            case 80:
                {
                alt161=4;
                }
                break;
            case 81:
                {
                alt161=5;
                }
                break;
            case 82:
                {
                alt161=6;
                }
                break;
            case 83:
                {
                alt161=7;
                }
                break;
            case 84:
                {
                alt161=8;
                }
                break;
            case 85:
                {
                alt161=9;
                }
                break;
            case 86:
                {
                alt161=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 161, 0, input);

                throw nvae;
            }

            switch (alt161) {
                case 1 :
                    // InternalMappingDsl.g:6831:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalMappingDsl.g:6831:3: ( () otherlv_1= 'boolean' )
                    // InternalMappingDsl.g:6832:4: () otherlv_1= 'boolean'
                    {
                    // InternalMappingDsl.g:6832:4: ()
                    // InternalMappingDsl.g:6833:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,77,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6845:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalMappingDsl.g:6845:3: ( () otherlv_3= 'byte' )
                    // InternalMappingDsl.g:6846:4: () otherlv_3= 'byte'
                    {
                    // InternalMappingDsl.g:6846:4: ()
                    // InternalMappingDsl.g:6847:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,78,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6859:3: ( () otherlv_5= 'char' )
                    {
                    // InternalMappingDsl.g:6859:3: ( () otherlv_5= 'char' )
                    // InternalMappingDsl.g:6860:4: () otherlv_5= 'char'
                    {
                    // InternalMappingDsl.g:6860:4: ()
                    // InternalMappingDsl.g:6861:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,79,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:6873:3: ( () otherlv_7= 'date' )
                    {
                    // InternalMappingDsl.g:6873:3: ( () otherlv_7= 'date' )
                    // InternalMappingDsl.g:6874:4: () otherlv_7= 'date'
                    {
                    // InternalMappingDsl.g:6874:4: ()
                    // InternalMappingDsl.g:6875:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,80,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:6887:3: ( () otherlv_9= 'double' )
                    {
                    // InternalMappingDsl.g:6887:3: ( () otherlv_9= 'double' )
                    // InternalMappingDsl.g:6888:4: () otherlv_9= 'double'
                    {
                    // InternalMappingDsl.g:6888:4: ()
                    // InternalMappingDsl.g:6889:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,81,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:6901:3: ( () otherlv_11= 'float' )
                    {
                    // InternalMappingDsl.g:6901:3: ( () otherlv_11= 'float' )
                    // InternalMappingDsl.g:6902:4: () otherlv_11= 'float'
                    {
                    // InternalMappingDsl.g:6902:4: ()
                    // InternalMappingDsl.g:6903:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,82,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMappingDsl.g:6915:3: ( () otherlv_13= 'int' )
                    {
                    // InternalMappingDsl.g:6915:3: ( () otherlv_13= 'int' )
                    // InternalMappingDsl.g:6916:4: () otherlv_13= 'int'
                    {
                    // InternalMappingDsl.g:6916:4: ()
                    // InternalMappingDsl.g:6917:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,83,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMappingDsl.g:6929:3: ( () otherlv_15= 'long' )
                    {
                    // InternalMappingDsl.g:6929:3: ( () otherlv_15= 'long' )
                    // InternalMappingDsl.g:6930:4: () otherlv_15= 'long'
                    {
                    // InternalMappingDsl.g:6930:4: ()
                    // InternalMappingDsl.g:6931:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,84,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMappingDsl.g:6943:3: ( () otherlv_17= 'short' )
                    {
                    // InternalMappingDsl.g:6943:3: ( () otherlv_17= 'short' )
                    // InternalMappingDsl.g:6944:4: () otherlv_17= 'short'
                    {
                    // InternalMappingDsl.g:6944:4: ()
                    // InternalMappingDsl.g:6945:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,85,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMappingDsl.g:6957:3: ( () otherlv_19= 'string' )
                    {
                    // InternalMappingDsl.g:6957:3: ( () otherlv_19= 'string' )
                    // InternalMappingDsl.g:6958:4: () otherlv_19= 'string'
                    {
                    // InternalMappingDsl.g:6958:4: ()
                    // InternalMappingDsl.g:6959:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,86,FOLLOW_2); 

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
    // InternalMappingDsl.g:6974:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMappingDsl.g:6974:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMappingDsl.g:6975:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMappingDsl.g:6981:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6987:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMappingDsl.g:6988:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMappingDsl.g:6988:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMappingDsl.g:6989:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_122); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMappingDsl.g:6996:3: (kw= '.' this_ID_2= RULE_ID )*
            loop162:
            do {
                int alt162=2;
                int LA162_0 = input.LA(1);

                if ( (LA162_0==29) ) {
                    alt162=1;
                }


                switch (alt162) {
            	case 1 :
            	    // InternalMappingDsl.g:6997:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,29,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_122); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop162;
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
    // InternalMappingDsl.g:7014:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7020:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalMappingDsl.g:7021:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalMappingDsl.g:7021:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==44) ) {
                alt163=1;
            }
            else if ( (LA163_0==41) ) {
                alt163=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 163, 0, input);

                throw nvae;
            }
            switch (alt163) {
                case 1 :
                    // InternalMappingDsl.g:7022:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalMappingDsl.g:7022:3: (enumLiteral_0= 'technology' )
                    // InternalMappingDsl.g:7023:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7030:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalMappingDsl.g:7030:3: (enumLiteral_1= 'microservices' )
                    // InternalMappingDsl.g:7031:4: enumLiteral_1= 'microservices'
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
    // InternalMappingDsl.g:7041:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7047:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalMappingDsl.g:7048:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalMappingDsl.g:7048:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt164=3;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt164=1;
                }
                break;
            case 88:
                {
                alt164=2;
                }
                break;
            case 89:
                {
                alt164=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 164, 0, input);

                throw nvae;
            }

            switch (alt164) {
                case 1 :
                    // InternalMappingDsl.g:7049:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalMappingDsl.g:7049:3: (enumLiteral_0= 'internal' )
                    // InternalMappingDsl.g:7050:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7057:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalMappingDsl.g:7057:3: (enumLiteral_1= 'architecture' )
                    // InternalMappingDsl.g:7058:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:7065:3: (enumLiteral_2= 'public' )
                    {
                    // InternalMappingDsl.g:7065:3: (enumLiteral_2= 'public' )
                    // InternalMappingDsl.g:7066:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,89,FOLLOW_2); 

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
    // InternalMappingDsl.g:7076:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7082:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalMappingDsl.g:7083:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:7083:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt165=3;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt165=1;
                }
                break;
            case 91:
                {
                alt165=2;
                }
                break;
            case 92:
                {
                alt165=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 165, 0, input);

                throw nvae;
            }

            switch (alt165) {
                case 1 :
                    // InternalMappingDsl.g:7084:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalMappingDsl.g:7084:3: (enumLiteral_0= 'functional' )
                    // InternalMappingDsl.g:7085:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7092:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalMappingDsl.g:7092:3: (enumLiteral_1= 'utility' )
                    // InternalMappingDsl.g:7093:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:7100:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:7100:3: (enumLiteral_2= 'infrastructure' )
                    // InternalMappingDsl.g:7101:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,92,FOLLOW_2); 

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
    // InternalMappingDsl.g:7111:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7117:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalMappingDsl.g:7118:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalMappingDsl.g:7118:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt166=3;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt166=1;
                }
                break;
            case 94:
                {
                alt166=2;
                }
                break;
            case 95:
                {
                alt166=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 166, 0, input);

                throw nvae;
            }

            switch (alt166) {
                case 1 :
                    // InternalMappingDsl.g:7119:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMappingDsl.g:7119:3: (enumLiteral_0= 'in' )
                    // InternalMappingDsl.g:7120:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7127:3: (enumLiteral_1= 'out' )
                    {
                    // InternalMappingDsl.g:7127:3: (enumLiteral_1= 'out' )
                    // InternalMappingDsl.g:7128:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:7135:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalMappingDsl.g:7135:3: (enumLiteral_2= 'inout' )
                    // InternalMappingDsl.g:7136:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,95,FOLLOW_2); 

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
    // InternalMappingDsl.g:7146:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7152:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalMappingDsl.g:7153:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalMappingDsl.g:7153:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt167=2;
            int LA167_0 = input.LA(1);

            if ( (LA167_0==96) ) {
                alt167=1;
            }
            else if ( (LA167_0==97) ) {
                alt167=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 167, 0, input);

                throw nvae;
            }
            switch (alt167) {
                case 1 :
                    // InternalMappingDsl.g:7154:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalMappingDsl.g:7154:3: (enumLiteral_0= 'sync' )
                    // InternalMappingDsl.g:7155:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7162:3: (enumLiteral_1= 'async' )
                    {
                    // InternalMappingDsl.g:7162:3: (enumLiteral_1= 'async' )
                    // InternalMappingDsl.g:7163:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

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
    // InternalMappingDsl.g:7173:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7179:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalMappingDsl.g:7180:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalMappingDsl.g:7180:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt168=3;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt168=1;
                }
                break;
            case 28:
                {
                alt168=2;
                }
                break;
            case 99:
                {
                alt168=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 168, 0, input);

                throw nvae;
            }

            switch (alt168) {
                case 1 :
                    // InternalMappingDsl.g:7181:3: (enumLiteral_0= '<-' )
                    {
                    // InternalMappingDsl.g:7181:3: (enumLiteral_0= '<-' )
                    // InternalMappingDsl.g:7182:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7189:3: (enumLiteral_1= '->' )
                    {
                    // InternalMappingDsl.g:7189:3: (enumLiteral_1= '->' )
                    // InternalMappingDsl.g:7190:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:7197:3: (enumLiteral_2= '<->' )
                    {
                    // InternalMappingDsl.g:7197:3: (enumLiteral_2= '<->' )
                    // InternalMappingDsl.g:7198:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,99,FOLLOW_2); 

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
    // InternalMappingDsl.g:7208:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7214:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalMappingDsl.g:7215:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalMappingDsl.g:7215:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==100) ) {
                alt169=1;
            }
            else if ( (LA169_0==101) ) {
                alt169=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 169, 0, input);

                throw nvae;
            }
            switch (alt169) {
                case 1 :
                    // InternalMappingDsl.g:7216:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalMappingDsl.g:7216:3: (enumLiteral_0= 'mandatory' )
                    // InternalMappingDsl.g:7217:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7224:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalMappingDsl.g:7224:3: (enumLiteral_1= 'singleval' )
                    // InternalMappingDsl.g:7225:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); 

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
    // InternalMappingDsl.g:7235:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) ;
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
            // InternalMappingDsl.g:7241:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) )
            // InternalMappingDsl.g:7242:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            {
            // InternalMappingDsl.g:7242:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            int alt170=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt170=1;
                }
                break;
            case 42:
                {
                alt170=2;
                }
                break;
            case 43:
                {
                alt170=3;
                }
                break;
            case 22:
                {
                alt170=4;
                }
                break;
            case 102:
                {
                alt170=5;
                }
                break;
            case 103:
                {
                alt170=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 170, 0, input);

                throw nvae;
            }

            switch (alt170) {
                case 1 :
                    // InternalMappingDsl.g:7243:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalMappingDsl.g:7243:3: (enumLiteral_0= 'microservices' )
                    // InternalMappingDsl.g:7244:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7251:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalMappingDsl.g:7251:3: (enumLiteral_1= 'interfaces' )
                    // InternalMappingDsl.g:7252:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:7259:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalMappingDsl.g:7259:3: (enumLiteral_2= 'operations' )
                    // InternalMappingDsl.g:7260:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:7267:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalMappingDsl.g:7267:3: (enumLiteral_3= 'parameters' )
                    // InternalMappingDsl.g:7268:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:7275:3: (enumLiteral_4= 'types' )
                    {
                    // InternalMappingDsl.g:7275:3: (enumLiteral_4= 'types' )
                    // InternalMappingDsl.g:7276:4: enumLiteral_4= 'types'
                    {
                    enumLiteral_4=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:7283:3: (enumLiteral_5= 'fields' )
                    {
                    // InternalMappingDsl.g:7283:3: (enumLiteral_5= 'fields' )
                    // InternalMappingDsl.g:7284:4: enumLiteral_5= 'fields'
                    {
                    enumLiteral_5=(Token)match(input,103,FOLLOW_2); 

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
    // InternalMappingDsl.g:7294:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7300:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalMappingDsl.g:7301:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:7301:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==104) ) {
                alt171=1;
            }
            else if ( (LA171_0==92) ) {
                alt171=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 171, 0, input);

                throw nvae;
            }
            switch (alt171) {
                case 1 :
                    // InternalMappingDsl.g:7302:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalMappingDsl.g:7302:3: (enumLiteral_0= 'containers' )
                    // InternalMappingDsl.g:7303:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7310:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:7310:3: (enumLiteral_1= 'infrastructure' )
                    // InternalMappingDsl.g:7311:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

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


    // $ANTLR start "ruleFieldFeature"
    // InternalMappingDsl.g:7321:1: ruleFieldFeature returns [Enumerator current=null] : (enumLiteral_0= 'derived' ) ;
    public final Enumerator ruleFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:7327:2: ( (enumLiteral_0= 'derived' ) )
            // InternalMappingDsl.g:7328:2: (enumLiteral_0= 'derived' )
            {
            // InternalMappingDsl.g:7328:2: (enumLiteral_0= 'derived' )
            // InternalMappingDsl.g:7329:3: enumLiteral_0= 'derived'
            {
            enumLiteral_0=(Token)match(input,105,FOLLOW_2); 

            			current = grammarAccess.getFieldFeatureAccess().getDERIVEDEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getFieldFeatureAccess().getDERIVEDEnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleFieldFeature"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA152 dfa152 = new DFA152(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\2\13\uffff";
    static final String dfa_3s = "\1\4\1\54\2\uffff\1\40\1\4\1\37\1\55\1\4\1\56\1\6\1\41";
    static final String dfa_4s = "\1\45\1\54\2\uffff\1\40\1\4\1\41\1\55\1\45\1\56\1\6\1\41";
    static final String dfa_5s = "\2\uffff\1\2\1\1\10\uffff";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\10\uffff\1\3\27\uffff\1\1",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\7\1\uffff\1\10",
            "\1\11",
            "\1\2\10\uffff\1\3\27\uffff\1\1",
            "\1\12",
            "\1\13",
            "\1\10"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 99:3: ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )*";
        }
    }
    static final String dfa_8s = "\123\uffff";
    static final String dfa_9s = "\2\4\2\uffff\1\40\1\21\2\40\3\4\1\21\1\4\1\21\5\4\1\31\1\4\3\41\1\40\1\35\3\4\1\5\1\4\2\5\3\4\2\31\1\21\1\32\3\37\3\41\1\35\1\41\2\4\1\5\2\4\1\37\2\40\1\31\1\32\1\4\1\40\3\4\2\5\1\21\2\31\3\41\3\37\1\4\1\37\1\35\3\4\1\35\1\41\1\4";
    static final String dfa_10s = "\1\131\1\141\2\uffff\1\40\1\21\2\40\3\4\1\21\1\131\1\21\2\4\1\7\2\4\1\37\1\131\3\41\1\56\1\41\3\4\1\5\1\131\2\7\2\4\1\131\2\37\1\21\1\37\10\41\1\141\1\4\1\5\1\41\1\4\1\41\2\40\2\37\1\131\1\56\3\4\2\7\1\21\2\37\6\41\1\4\2\41\2\4\1\131\2\41\1\23";
    static final String dfa_11s = "\2\uffff\1\2\1\1\117\uffff";
    static final String dfa_12s = "\123\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\13\uffff\1\2\24\uffff\1\1\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\5\16\uffff\1\4\114\uffff\1\6\1\7",
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
            "\1\2\30\uffff\1\17\2\uffff\1\20\4\uffff\1\21\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\30\1\27\1\26\1\25",
            "\1\5",
            "\1\31",
            "\1\35\3\uffff\1\32\1\33\1\34",
            "\1\2\30\uffff\1\17\2\uffff\1\20\4\uffff\1\21\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\40\15\uffff\1\37",
            "\1\41\1\42\2\uffff\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\2\40\uffff\1\21\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\52\1\51\1\50",
            "\1\55\1\54\1\53",
            "\1\56",
            "\1\57",
            "\1\2\40\uffff\1\60\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\35\3\uffff\1\32\1\33\1\34",
            "\1\35\5\uffff\1\34",
            "\1\61",
            "\1\63\4\uffff\1\62",
            "\1\64\1\uffff\1\36",
            "\1\64\1\uffff\1\36",
            "\1\64\1\uffff\1\36",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\41\1\42\2\uffff\1\43",
            "\1\43",
            "\1\5\16\uffff\1\4\114\uffff\1\66\1\67",
            "\1\70",
            "\1\71",
            "\1\13\34\uffff\1\72",
            "\1\73",
            "\1\64\1\uffff\1\36",
            "\1\74",
            "\1\74",
            "\1\35\3\uffff\1\75\1\76\1\34",
            "\1\63\4\uffff\1\62",
            "\1\2\40\uffff\1\21\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\77\15\uffff\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\106\1\105\1\104",
            "\1\111\1\110\1\107",
            "\1\112",
            "\1\35\3\uffff\1\75\1\76\1\34",
            "\1\35\5\uffff\1\34",
            "\1\113",
            "\1\113",
            "\1\113",
            "\1\64\1\uffff\1\36",
            "\1\64\1\uffff\1\36",
            "\1\64\1\uffff\1\36",
            "\1\114",
            "\1\64\1\uffff\1\36",
            "\1\115\1\116\2\uffff\1\117",
            "\1\120",
            "\1\121",
            "\1\2\40\uffff\1\122\11\uffff\1\2\1\3\46\uffff\3\2",
            "\1\115\1\116\2\uffff\1\117",
            "\1\117",
            "\1\5\16\uffff\1\4"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 2900:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_14s = "\20\uffff";
    static final String dfa_15s = "\1\72\1\4\1\16\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_16s = "\1\72\1\4\1\16\1\126\1\uffff\12\20\1\uffff";
    static final String dfa_17s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_18s = "\20\uffff}>";
    static final String[] dfa_19s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\106\uffff\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
            "",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            "\1\4\13\uffff\1\17",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA152 extends DFA {

        public DFA152(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 152;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "6249:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000002400002012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000002000002012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000002000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000002000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000020018010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000020010010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000BD8000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010000L,0x0000000300000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000B98000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000B18000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000A10000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000000D8000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000098000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000000004D8000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000498000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000418000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000009010000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000006004000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000016004000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000020008010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000082000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000104000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000120000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000002000000000L,0x000000001F800000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000008000004000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000812000100000L,0x0000000003800000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000812000110000L,0x0000000003800000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000802000100000L,0x0000000003800000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000100000L,0x0000000003800000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0001802000010010L,0x0000000003800000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000802000010010L,0x0000000003800000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000802000000010L,0x0000000003800000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000010L,0x0000000003800000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000002280000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000002000000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0001002000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0002000000000010L,0x00000000E0000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0004000002000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000010L,0x00000000007FE000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0020000084000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0100000004000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x00000000007FE000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000090000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x2000000000010000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000010000L,0x00000000007FE000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x8000400004000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x8000000004000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000003000000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x00000E0000400000L,0x000000C000000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000084004000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000010000L,0x00000000007FE020L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000010010000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0C00000000010000L,0x0000000000001200L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0C00000000010000L,0x0000000000001000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000200L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0C00000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000400L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000010010L,0x00000000007FE800L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000010L,0x00000000007FE800L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000020000002L});

}