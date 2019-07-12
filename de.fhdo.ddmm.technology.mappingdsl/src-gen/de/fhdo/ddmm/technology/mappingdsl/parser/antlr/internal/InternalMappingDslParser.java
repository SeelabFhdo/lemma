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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'technology'", "'('", "')'", "'type'", "'{'", "'aspects'", "'}'", "'::'", "'protocols'", "'endpoints'", "'interface'", "'operation'", "'parameters'", "'referred'", "'primitive'", "':'", "';'", "'complex'", "'->'", "'.'", "'/'", "','", "'import'", "'from'", "'as'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'noimpl'", "'refers'", "'fault'", "'?'", "'='", "'data'", "'formats'", "'default'", "'with'", "'format'", "'based'", "'on'", "'list'", "'structure'", "'environments'", "'service'", "'properties'", "'mandatory'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'aspect'", "'for'", "'datatypes'", "'context'", "'extends'", "'hide'", "'enum'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'functional'", "'utility'", "'infrastructure'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'<->'", "'types'", "'fields'", "'containers'"
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
    // InternalMappingDsl.g:72:1: ruleTechnologyMapping returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )+ ) ;
    public final EObject ruleTechnologyMapping() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_typeMappings_1_0 = null;

        EObject lv_serviceMappings_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )+ ) )
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )+ )
            {
            // InternalMappingDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )+ )
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+ ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )* ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )+
            {
            // InternalMappingDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==36) ) {
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
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ComplexTypeMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMappingDsl.g:118:3: ( (lv_serviceMappings_2_0= ruleMicroserviceMapping ) )+
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
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.MicroserviceMapping");
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
    // InternalMappingDsl.g:148:1: ruleComplexTypeMapping returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'type' ( (lv_type_6_0= ruleImportedComplexType ) ) otherlv_7= '{' (otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}' )? ( (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping ) )* otherlv_13= '}' ) ;
    public final EObject ruleComplexTypeMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_type_6_0 = null;

        EObject lv_aspects_10_0 = null;

        EObject lv_fieldMappings_12_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:154:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'type' ( (lv_type_6_0= ruleImportedComplexType ) ) otherlv_7= '{' (otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}' )? ( (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping ) )* otherlv_13= '}' ) )
            // InternalMappingDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'type' ( (lv_type_6_0= ruleImportedComplexType ) ) otherlv_7= '{' (otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}' )? ( (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping ) )* otherlv_13= '}' )
            {
            // InternalMappingDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'type' ( (lv_type_6_0= ruleImportedComplexType ) ) otherlv_7= '{' (otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}' )? ( (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping ) )* otherlv_13= '}' )
            // InternalMappingDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'type' ( (lv_type_6_0= ruleImportedComplexType ) ) otherlv_7= '{' (otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}' )? ( (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping ) )* otherlv_13= '}'
            {
            // InternalMappingDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMappingDsl.g:157:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_6); 

            	    				newLeafNode(otherlv_0, grammarAccess.getComplexTypeMappingAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getComplexTypeMappingAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_2, grammarAccess.getComplexTypeMappingAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalMappingDsl.g:169:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:170:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:170:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:171:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getComplexTypeMappingRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    						newLeafNode(otherlv_3, grammarAccess.getComplexTypeMappingAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_10); 

            	    				newLeafNode(otherlv_4, grammarAccess.getComplexTypeMappingAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            otherlv_5=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getComplexTypeMappingAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:191:3: ( (lv_type_6_0= ruleImportedComplexType ) )
            // InternalMappingDsl.g:192:4: (lv_type_6_0= ruleImportedComplexType )
            {
            // InternalMappingDsl.g:192:4: (lv_type_6_0= ruleImportedComplexType )
            // InternalMappingDsl.g:193:5: lv_type_6_0= ruleImportedComplexType
            {

            					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getTypeImportedComplexTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_type_6_0=ruleImportedComplexType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.ImportedComplexType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_7, grammarAccess.getComplexTypeMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:214:3: (otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMappingDsl.g:215:4: otherlv_8= 'aspects' otherlv_9= '{' ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getComplexTypeMappingAccess().getAspectsKeyword_4_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getComplexTypeMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:223:4: ( (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:224:5: (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:224:5: (lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:225:6: lv_aspects_10_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_aspects_10_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_10_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_11=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_11, grammarAccess.getComplexTypeMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:247:3: ( (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==33) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMappingDsl.g:248:4: (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping )
            	    {
            	    // InternalMappingDsl.g:248:4: (lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping )
            	    // InternalMappingDsl.g:249:5: lv_fieldMappings_12_0= ruleTechnologySpecificFieldMapping
            	    {

            	    					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getFieldMappingsTechnologySpecificFieldMappingParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_fieldMappings_12_0=ruleTechnologySpecificFieldMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fieldMappings",
            	    						lv_fieldMappings_12_0,
            	    						"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificFieldMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getComplexTypeMappingAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalMappingDsl.g:274:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalMappingDsl.g:274:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalMappingDsl.g:275:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalMappingDsl.g:281:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:287:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:288:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:288:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:289:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:289:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:290:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:290:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:291:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getServiceModelImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:306:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:307:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:307:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:308:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_2, grammarAccess.getImportedComplexTypeAccess().getDataModelImportImportCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_3());
            		
            // InternalMappingDsl.g:323:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:324:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:324:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:325:5: ruleQualifiedName
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
    // InternalMappingDsl.g:343:1: entryRuleMicroserviceMapping returns [EObject current=null] : iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF ;
    public final EObject entryRuleMicroserviceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroserviceMapping = null;


        try {
            // InternalMappingDsl.g:343:60: (iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF )
            // InternalMappingDsl.g:344:2: iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF
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
    // InternalMappingDsl.g:350:1: ruleMicroserviceMapping returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' ) ;
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
            // InternalMappingDsl.g:356:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' ) )
            // InternalMappingDsl.g:357:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' )
            {
            // InternalMappingDsl.g:357:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}' )
            // InternalMappingDsl.g:358:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_microservice_5_0= ruleImportedMicroservice ) ) otherlv_6= '{' (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )? (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )? (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_21_0= ruleOperationMapping ) )* otherlv_22= '}'
            {
            // InternalMappingDsl.g:358:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==13) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMappingDsl.g:359:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_6); 

            	    				newLeafNode(otherlv_0, grammarAccess.getMicroserviceMappingAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMicroserviceMappingAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMicroserviceMappingAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalMappingDsl.g:371:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:372:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:372:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:373:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMicroserviceMappingRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    						newLeafNode(otherlv_3, grammarAccess.getMicroserviceMappingAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_16); 

            	    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceMappingAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            // InternalMappingDsl.g:389:3: ( (lv_microservice_5_0= ruleImportedMicroservice ) )
            // InternalMappingDsl.g:390:4: (lv_microservice_5_0= ruleImportedMicroservice )
            {
            // InternalMappingDsl.g:390:4: (lv_microservice_5_0= ruleImportedMicroservice )
            // InternalMappingDsl.g:391:5: lv_microservice_5_0= ruleImportedMicroservice
            {

            					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getMicroserviceImportedMicroserviceParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_6=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:412:3: (otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMappingDsl.g:413:4: otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:421:4: ( (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=94 && LA9_0<=95)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMappingDsl.g:422:5: (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:422:5: (lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:423:6: lv_protocols_9_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
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
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_20); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:445:3: (otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMappingDsl.g:446:4: otherlv_11= 'endpoints' otherlv_12= '{' ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,23,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_12=(Token)match(input,18,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:454:4: ( (lv_endpoints_13_0= ruleTechnologySpecificEndpoint ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMappingDsl.g:455:5: (lv_endpoints_13_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:455:5: (lv_endpoints_13_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:456:6: lv_endpoints_13_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,20,FOLLOW_21); 

                    				newLeafNode(otherlv_14, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:478:3: (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMappingDsl.g:479:4: otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_15, grammarAccess.getMicroserviceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:487:4: ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:488:5: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:488:5: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:489:6: lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    otherlv_18=(Token)match(input,20,FOLLOW_22); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:511:3: ( (lv_interfaceMappings_19_0= ruleInterfaceMapping ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMappingDsl.g:512:4: (lv_interfaceMappings_19_0= ruleInterfaceMapping )
            	    {
            	    // InternalMappingDsl.g:512:4: (lv_interfaceMappings_19_0= ruleInterfaceMapping )
            	    // InternalMappingDsl.g:513:5: lv_interfaceMappings_19_0= ruleInterfaceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getInterfaceMappingsInterfaceMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_22);
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
            	    break loop15;
                }
            } while (true);

            // InternalMappingDsl.g:530:3: ( (lv_referredOperationMappings_20_0= ruleReferredOperationMapping ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMappingDsl.g:531:4: (lv_referredOperationMappings_20_0= ruleReferredOperationMapping )
            	    {
            	    // InternalMappingDsl.g:531:4: (lv_referredOperationMappings_20_0= ruleReferredOperationMapping )
            	    // InternalMappingDsl.g:532:5: lv_referredOperationMappings_20_0= ruleReferredOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getReferredOperationMappingsReferredOperationMappingParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_23);
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
            	    break loop16;
                }
            } while (true);

            // InternalMappingDsl.g:549:3: ( (lv_operationMappings_21_0= ruleOperationMapping ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMappingDsl.g:550:4: (lv_operationMappings_21_0= ruleOperationMapping )
            	    {
            	    // InternalMappingDsl.g:550:4: (lv_operationMappings_21_0= ruleOperationMapping )
            	    // InternalMappingDsl.g:551:5: lv_operationMappings_21_0= ruleOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getOperationMappingsOperationMappingParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    break loop17;
                }
            } while (true);

            otherlv_22=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:576:1: entryRuleInterfaceMapping returns [EObject current=null] : iv_ruleInterfaceMapping= ruleInterfaceMapping EOF ;
    public final EObject entryRuleInterfaceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceMapping = null;


        try {
            // InternalMappingDsl.g:576:57: (iv_ruleInterfaceMapping= ruleInterfaceMapping EOF )
            // InternalMappingDsl.g:577:2: iv_ruleInterfaceMapping= ruleInterfaceMapping EOF
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
    // InternalMappingDsl.g:583:1: ruleInterfaceMapping returns [EObject current=null] : (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) ;
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
            // InternalMappingDsl.g:589:2: ( (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalMappingDsl.g:590:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalMappingDsl.g:590:2: (otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            // InternalMappingDsl.g:591:3: otherlv_0= 'interface' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getInterfaceMappingAccess().getInterfaceKeyword_0());
            		
            // InternalMappingDsl.g:595:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:596:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:596:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:597:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_1, grammarAccess.getInterfaceMappingAccess().getInterfaceInterfaceCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:612:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMappingDsl.g:613:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:621:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=94 && LA18_0<=95)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalMappingDsl.g:622:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:622:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:623:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
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
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_26); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:645:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMappingDsl.g:646:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:654:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
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
                    	    // InternalMappingDsl.g:655:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:655:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:656:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_27); 

                    				newLeafNode(otherlv_10, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:678:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMappingDsl.g:679:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:687:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:688:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:688:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:689:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    otherlv_14=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_14, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:719:1: entryRuleOperationMapping returns [EObject current=null] : iv_ruleOperationMapping= ruleOperationMapping EOF ;
    public final EObject entryRuleOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationMapping = null;


        try {
            // InternalMappingDsl.g:719:57: (iv_ruleOperationMapping= ruleOperationMapping EOF )
            // InternalMappingDsl.g:720:2: iv_ruleOperationMapping= ruleOperationMapping EOF
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
    // InternalMappingDsl.g:726:1: ruleOperationMapping returns [EObject current=null] : (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' ) ;
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
            // InternalMappingDsl.g:732:2: ( (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' ) )
            // InternalMappingDsl.g:733:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' )
            {
            // InternalMappingDsl.g:733:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' )
            // InternalMappingDsl.g:734:3: otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationMappingAccess().getOperationKeyword_0());
            		
            // InternalMappingDsl.g:738:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:739:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:739:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:740:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOperationMappingAccess().getOperationOperationCrossReference_1_0());
            				
            pushFollow(FOLLOW_11);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:758:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==22) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMappingDsl.g:759:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:767:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=94 && LA24_0<=95)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalMappingDsl.g:768:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:768:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:769:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
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
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_30); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:791:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==23) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMappingDsl.g:792:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:800:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
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
                    	    // InternalMappingDsl.g:801:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:801:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:802:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_31); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:824:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==19) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMappingDsl.g:825:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getOperationMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:833:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:834:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:834:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:835:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    otherlv_14=(Token)match(input,20,FOLLOW_32); 

                    				newLeafNode(otherlv_14, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:857:3: (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMappingDsl.g:858:4: otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_11); 

                    				newLeafNode(otherlv_15, grammarAccess.getOperationMappingAccess().getParametersKeyword_6_0());
                    			
                    otherlv_16=(Token)match(input,18,FOLLOW_33); 

                    				newLeafNode(otherlv_16, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:866:4: ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==28||LA31_0==31) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalMappingDsl.g:867:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    	    {
                    	    // InternalMappingDsl.g:867:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    	    // InternalMappingDsl.g:868:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    	    {
                    	    // InternalMappingDsl.g:868:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    	    int alt30=2;
                    	    int LA30_0 = input.LA(1);

                    	    if ( (LA30_0==28) ) {
                    	        alt30=1;
                    	    }
                    	    else if ( (LA30_0==31) ) {
                    	        alt30=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 30, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt30) {
                    	        case 1 :
                    	            // InternalMappingDsl.g:869:7: lv_parameterMappings_17_1= rulePrimitiveParameterMapping
                    	            {

                    	            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_2_0_0());
                    	            						
                    	            pushFollow(FOLLOW_34);
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
                    	            // InternalMappingDsl.g:885:7: lv_parameterMappings_17_2= ruleComplexParameterMapping
                    	            {

                    	            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_2_0_1());
                    	            						
                    	            pushFollow(FOLLOW_34);
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
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    otherlv_18=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_18, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_19=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:916:1: entryRuleReferredOperationMapping returns [EObject current=null] : iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF ;
    public final EObject entryRuleReferredOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperationMapping = null;


        try {
            // InternalMappingDsl.g:916:65: (iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF )
            // InternalMappingDsl.g:917:2: iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF
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
    // InternalMappingDsl.g:923:1: ruleReferredOperationMapping returns [EObject current=null] : (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) ;
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
            // InternalMappingDsl.g:929:2: ( (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) )
            // InternalMappingDsl.g:930:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            {
            // InternalMappingDsl.g:930:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            // InternalMappingDsl.g:931:3: otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getReferredOperationMappingAccess().getReferredKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getReferredOperationMappingAccess().getOperationKeyword_1());
            		
            // InternalMappingDsl.g:939:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:940:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:940:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:941:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getOperationReferredOperationCrossReference_2_0());
            				
            pushFollow(FOLLOW_11);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:959:3: (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMappingDsl.g:960:4: otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationMappingAccess().getProtocolsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,18,FOLLOW_18); 

                    				newLeafNode(otherlv_5, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:968:4: ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0>=94 && LA33_0<=95)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalMappingDsl.g:969:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:969:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:970:6: lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
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
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);

                    otherlv_7=(Token)match(input,20,FOLLOW_26); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:992:3: (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==23) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMappingDsl.g:993:4: otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,23,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationMappingAccess().getEndpointsKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:1001:4: ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+
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
                    	    // InternalMappingDsl.g:1002:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:1002:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:1003:6: lv_endpoints_10_0= ruleTechnologySpecificEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getEndpointsTechnologySpecificEndpointParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt35 >= 1 ) break loop35;
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    otherlv_11=(Token)match(input,20,FOLLOW_27); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:1025:3: (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalMappingDsl.g:1026:4: otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_12, grammarAccess.getReferredOperationMappingAccess().getAspectsKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_13, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:1034:4: ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:1035:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1035:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1036:6: lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);

                    otherlv_15=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_15, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_16=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:1066:1: entryRulePrimitiveParameterMapping returns [EObject current=null] : iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF ;
    public final EObject entryRulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveParameterMapping = null;


        try {
            // InternalMappingDsl.g:1066:66: (iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF )
            // InternalMappingDsl.g:1067:2: iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF
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
    // InternalMappingDsl.g:1073:1: rulePrimitiveParameterMapping returns [EObject current=null] : (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
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
            // InternalMappingDsl.g:1079:2: ( (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) )
            // InternalMappingDsl.g:1080:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
            {
            // InternalMappingDsl.g:1080:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
            // InternalMappingDsl.g:1081:3: otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveKeyword_0());
            		
            // InternalMappingDsl.g:1085:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1086:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1086:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1087:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_1, grammarAccess.getPrimitiveParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1098:3: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==29) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMappingDsl.g:1099:4: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimitiveParameterMappingAccess().getColonKeyword_2_0());
                    			
                    // InternalMappingDsl.g:1103:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:1104:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:1104:5: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:1105:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_3, grammarAccess.getPrimitiveParameterMappingAccess().getTechnologyImportCrossReference_2_1_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimitiveParameterMappingAccess().getColonColonKeyword_2_2());
                    			
                    // InternalMappingDsl.g:1120:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:1121:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:1121:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:1122:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveTypeTechnologySpecificPrimitiveTypeCrossReference_2_3_0());
                    					
                    pushFollow(FOLLOW_37);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:1137:3: ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==18) ) {
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
                    // InternalMappingDsl.g:1138:4: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:1138:4: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                    // InternalMappingDsl.g:1139:5: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_38); 

                    					newLeafNode(otherlv_6, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0_0());
                    				
                    otherlv_7=(Token)match(input,19,FOLLOW_11); 

                    					newLeafNode(otherlv_7, grammarAccess.getPrimitiveParameterMappingAccess().getAspectsKeyword_3_0_1());
                    				
                    otherlv_8=(Token)match(input,18,FOLLOW_8); 

                    					newLeafNode(otherlv_8, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0_2());
                    				
                    // InternalMappingDsl.g:1151:5: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:1152:6: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1152:6: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1153:7: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_3_0_3_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt40 >= 1 ) break loop40;
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_28); 

                    					newLeafNode(otherlv_10, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_0_4());
                    				
                    otherlv_11=(Token)match(input,20,FOLLOW_2); 

                    					newLeafNode(otherlv_11, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_0_5());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1180:4: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:1189:1: entryRuleComplexParameterMapping returns [EObject current=null] : iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF ;
    public final EObject entryRuleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexParameterMapping = null;


        try {
            // InternalMappingDsl.g:1189:64: (iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF )
            // InternalMappingDsl.g:1190:2: iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF
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
    // InternalMappingDsl.g:1196:1: ruleComplexParameterMapping returns [EObject current=null] : (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) ) ;
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
            // InternalMappingDsl.g:1202:2: ( (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) ) )
            // InternalMappingDsl.g:1203:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) )
            {
            // InternalMappingDsl.g:1203:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) )
            // InternalMappingDsl.g:1204:3: otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexParameterMappingAccess().getComplexKeyword_0());
            		
            // InternalMappingDsl.g:1208:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1209:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1209:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1210:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_1, grammarAccess.getComplexParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1221:3: ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==18||(LA48_0>=29 && LA48_0<=30)) ) {
                alt48=1;
            }
            else if ( (LA48_0==32) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalMappingDsl.g:1222:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
                    {
                    // InternalMappingDsl.g:1222:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
                    // InternalMappingDsl.g:1223:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
                    {
                    // InternalMappingDsl.g:1223:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==29) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalMappingDsl.g:1224:6: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_2=(Token)match(input,29,FOLLOW_8); 

                            						newLeafNode(otherlv_2, grammarAccess.getComplexParameterMappingAccess().getColonKeyword_2_0_0_0());
                            					
                            // InternalMappingDsl.g:1228:6: ( (otherlv_3= RULE_ID ) )
                            // InternalMappingDsl.g:1229:7: (otherlv_3= RULE_ID )
                            {
                            // InternalMappingDsl.g:1229:7: (otherlv_3= RULE_ID )
                            // InternalMappingDsl.g:1230:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_15); 

                            								newLeafNode(otherlv_3, grammarAccess.getComplexParameterMappingAccess().getTechnologyImportCrossReference_2_0_0_1_0());
                            							

                            }


                            }

                            otherlv_4=(Token)match(input,21,FOLLOW_8); 

                            						newLeafNode(otherlv_4, grammarAccess.getComplexParameterMappingAccess().getColonColonKeyword_2_0_0_2());
                            					
                            // InternalMappingDsl.g:1245:6: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1246:7: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1246:7: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1247:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getTechnologySpecificComplexTypeComplexTypeCrossReference_2_0_0_3_0());
                            							
                            pushFollow(FOLLOW_37);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1262:5: ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==18) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==30) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalMappingDsl.g:1263:6: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                            {
                            // InternalMappingDsl.g:1263:6: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                            // InternalMappingDsl.g:1264:7: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                            {
                            otherlv_6=(Token)match(input,18,FOLLOW_38); 

                            							newLeafNode(otherlv_6, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0_0());
                            						
                            otherlv_7=(Token)match(input,19,FOLLOW_11); 

                            							newLeafNode(otherlv_7, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_0_1_0_1());
                            						
                            otherlv_8=(Token)match(input,18,FOLLOW_8); 

                            							newLeafNode(otherlv_8, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0_2());
                            						
                            // InternalMappingDsl.g:1276:7: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                            	    // InternalMappingDsl.g:1277:8: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1277:8: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1278:9: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    									newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_1_0_3_0());
                            	    								
                            	    pushFollow(FOLLOW_13);
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
                            	    if ( cnt43 >= 1 ) break loop43;
                                        EarlyExitException eee =
                                            new EarlyExitException(43, input);
                                        throw eee;
                                }
                                cnt43++;
                            } while (true);

                            otherlv_10=(Token)match(input,20,FOLLOW_28); 

                            							newLeafNode(otherlv_10, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_0_4());
                            						
                            otherlv_11=(Token)match(input,20,FOLLOW_2); 

                            							newLeafNode(otherlv_11, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_0_5());
                            						

                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1305:6: otherlv_12= ';'
                            {
                            otherlv_12=(Token)match(input,30,FOLLOW_2); 

                            						newLeafNode(otherlv_12, grammarAccess.getComplexParameterMappingAccess().getSemicolonKeyword_2_0_1_1());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1312:4: (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' )
                    {
                    // InternalMappingDsl.g:1312:4: (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' )
                    // InternalMappingDsl.g:1313:5: otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}'
                    {
                    otherlv_13=(Token)match(input,32,FOLLOW_11); 

                    					newLeafNode(otherlv_13, grammarAccess.getComplexParameterMappingAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
                    				
                    otherlv_14=(Token)match(input,18,FOLLOW_40); 

                    					newLeafNode(otherlv_14, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_1());
                    				
                    // InternalMappingDsl.g:1321:5: (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==19) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalMappingDsl.g:1322:6: otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}'
                            {
                            otherlv_15=(Token)match(input,19,FOLLOW_11); 

                            						newLeafNode(otherlv_15, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_1_2_0());
                            					
                            otherlv_16=(Token)match(input,18,FOLLOW_8); 

                            						newLeafNode(otherlv_16, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_2_1());
                            					
                            // InternalMappingDsl.g:1330:6: ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                            	    // InternalMappingDsl.g:1331:7: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1331:7: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1332:8: lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_1_2_2_0());
                            	    							
                            	    pushFollow(FOLLOW_13);
                            	    lv_aspects_17_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
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
                            	    if ( cnt45 >= 1 ) break loop45;
                                        EarlyExitException eee =
                                            new EarlyExitException(45, input);
                                        throw eee;
                                }
                                cnt45++;
                            } while (true);

                            otherlv_18=(Token)match(input,20,FOLLOW_41); 

                            						newLeafNode(otherlv_18, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_2_3());
                            					

                            }
                            break;

                    }

                    // InternalMappingDsl.g:1354:5: ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==RULE_ID||LA47_0==33) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1355:6: (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping )
                    	    {
                    	    // InternalMappingDsl.g:1355:6: (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping )
                    	    // InternalMappingDsl.g:1356:7: lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping
                    	    {

                    	    							newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getFieldMappingsTechnologySpecificFieldMappingParserRuleCall_2_1_3_0());
                    	    						
                    	    pushFollow(FOLLOW_14);
                    	    lv_fieldMappings_19_0=ruleTechnologySpecificFieldMapping();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getComplexParameterMappingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"fieldMappings",
                    	    								lv_fieldMappings_19_0,
                    	    								"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificFieldMapping");
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

                    otherlv_20=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:1383:1: entryRuleTechnologySpecificFieldMapping returns [EObject current=null] : iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF ;
    public final EObject entryRuleTechnologySpecificFieldMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificFieldMapping = null;


        try {
            // InternalMappingDsl.g:1383:71: (iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF )
            // InternalMappingDsl.g:1384:2: iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF
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
    // InternalMappingDsl.g:1390:1: ruleTechnologySpecificFieldMapping returns [EObject current=null] : ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) ) ;
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
            // InternalMappingDsl.g:1396:2: ( ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) ) )
            // InternalMappingDsl.g:1397:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) )
            {
            // InternalMappingDsl.g:1397:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==33) ) {
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
                    // InternalMappingDsl.g:1398:3: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' )
                    {
                    // InternalMappingDsl.g:1398:3: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' )
                    // InternalMappingDsl.g:1399:4: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}'
                    {
                    otherlv_0=(Token)match(input,33,FOLLOW_8); 

                    				newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificFieldMappingAccess().getFullStopKeyword_0_0());
                    			
                    // InternalMappingDsl.g:1403:4: ( (otherlv_1= RULE_ID ) )
                    // InternalMappingDsl.g:1404:5: (otherlv_1= RULE_ID )
                    {
                    // InternalMappingDsl.g:1404:5: (otherlv_1= RULE_ID )
                    // InternalMappingDsl.g:1405:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificFieldMappingAccess().getEnumerationFieldEnumerationFieldCrossReference_0_1_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,18,FOLLOW_38); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsKeyword_0_3());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_0_4());
                    			
                    // InternalMappingDsl.g:1428:4: ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:1429:5: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1429:5: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1430:6: lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_0_5_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    lv_aspects_5_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologySpecificFieldMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_5_0,
                    	    							"de.fhdo.ddmm.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
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

                    otherlv_6=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_0_6());
                    			
                    otherlv_7=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_0_7());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1457:3: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) )
                    {
                    // InternalMappingDsl.g:1457:3: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) )
                    // InternalMappingDsl.g:1458:4: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' )
                    {
                    // InternalMappingDsl.g:1458:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:1459:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:1459:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:1460:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificFieldMappingAccess().getDataFieldDataFieldCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalMappingDsl.g:1471:4: (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==29) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalMappingDsl.g:1472:5: otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_9=(Token)match(input,29,FOLLOW_8); 

                            					newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificFieldMappingAccess().getColonKeyword_1_1_0());
                            				
                            // InternalMappingDsl.g:1476:5: ( (otherlv_10= RULE_ID ) )
                            // InternalMappingDsl.g:1477:6: (otherlv_10= RULE_ID )
                            {
                            // InternalMappingDsl.g:1477:6: (otherlv_10= RULE_ID )
                            // InternalMappingDsl.g:1478:7: otherlv_10= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                            							}
                            						
                            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_15); 

                            							newLeafNode(otherlv_10, grammarAccess.getTechnologySpecificFieldMappingAccess().getTechnologyImportCrossReference_1_1_1_0());
                            						

                            }


                            }

                            otherlv_11=(Token)match(input,21,FOLLOW_8); 

                            					newLeafNode(otherlv_11, grammarAccess.getTechnologySpecificFieldMappingAccess().getColonColonKeyword_1_1_2());
                            				
                            // InternalMappingDsl.g:1493:5: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1494:6: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1494:6: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1495:7: ruleQualifiedName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getTypeTypeCrossReference_1_1_3_0());
                            						
                            pushFollow(FOLLOW_37);
                            ruleQualifiedName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1510:4: ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==18) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==30) ) {
                        alt52=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalMappingDsl.g:1511:5: (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' )
                            {
                            // InternalMappingDsl.g:1511:5: (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' )
                            // InternalMappingDsl.g:1512:6: otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}'
                            {
                            otherlv_13=(Token)match(input,18,FOLLOW_38); 

                            						newLeafNode(otherlv_13, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_1_2_0_0());
                            					
                            otherlv_14=(Token)match(input,19,FOLLOW_11); 

                            						newLeafNode(otherlv_14, grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsKeyword_1_2_0_1());
                            					
                            otherlv_15=(Token)match(input,18,FOLLOW_8); 

                            						newLeafNode(otherlv_15, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_1_2_0_2());
                            					
                            // InternalMappingDsl.g:1524:6: ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                            	    // InternalMappingDsl.g:1525:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1525:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1526:8: lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_1_2_0_3_0());
                            	    							
                            	    pushFollow(FOLLOW_13);
                            	    lv_aspects_16_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getTechnologySpecificFieldMappingRule());
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
                            	    if ( cnt51 >= 1 ) break loop51;
                                        EarlyExitException eee =
                                            new EarlyExitException(51, input);
                                        throw eee;
                                }
                                cnt51++;
                            } while (true);

                            otherlv_17=(Token)match(input,20,FOLLOW_28); 

                            						newLeafNode(otherlv_17, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_1_2_0_4());
                            					
                            otherlv_18=(Token)match(input,20,FOLLOW_2); 

                            						newLeafNode(otherlv_18, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_1_2_0_5());
                            					

                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1553:5: otherlv_19= ';'
                            {
                            otherlv_19=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:1563:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:1563:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalMappingDsl.g:1564:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalMappingDsl.g:1570:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1576:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalMappingDsl.g:1577:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalMappingDsl.g:1577:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalMappingDsl.g:1578:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalMappingDsl.g:1578:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1579:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1579:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1580:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1595:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:1596:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:1596:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:1597:5: ruleQualifiedNameWithAtLeastOneLevel
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
    // InternalMappingDsl.g:1615:1: entryRuleTechnologySpecificProtocolSpecification returns [EObject current=null] : iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF ;
    public final EObject entryRuleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:1615:80: (iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF )
            // InternalMappingDsl.g:1616:2: iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF
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
    // InternalMappingDsl.g:1622:1: ruleTechnologySpecificProtocolSpecification returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) ;
    public final EObject ruleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_communicationType_0_0 = null;

        EObject lv_technologySpecificProtocol_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1628:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) )
            // InternalMappingDsl.g:1629:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            {
            // InternalMappingDsl.g:1629:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            // InternalMappingDsl.g:1630:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            {
            // InternalMappingDsl.g:1630:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:1631:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:1631:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:1632:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_42);
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

            otherlv_1=(Token)match(input,29,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getColonKeyword_1());
            		
            // InternalMappingDsl.g:1653:3: ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1654:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1654:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1655:5: lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol
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
    // InternalMappingDsl.g:1676:1: entryRuleTechnologySpecificProtocol returns [EObject current=null] : iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF ;
    public final EObject entryRuleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocol = null;


        try {
            // InternalMappingDsl.g:1676:67: (iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF )
            // InternalMappingDsl.g:1677:2: iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF
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
    // InternalMappingDsl.g:1683:1: ruleTechnologySpecificProtocol returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1689:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:1690:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:1690:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:1691:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:1691:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1692:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1692:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1693:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificProtocolAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1708:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1709:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1709:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1710:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_43);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1724:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==34) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMappingDsl.g:1725:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificProtocolAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:1729:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:1730:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:1730:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:1731:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:1747:1: entryRuleTechnologySpecificEndpoint returns [EObject current=null] : iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF ;
    public final EObject entryRuleTechnologySpecificEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificEndpoint = null;


        try {
            // InternalMappingDsl.g:1747:67: (iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF )
            // InternalMappingDsl.g:1748:2: iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF
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
    // InternalMappingDsl.g:1754:1: ruleTechnologySpecificEndpoint returns [EObject current=null] : ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:1760:2: ( ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:1761:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:1761:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:1762:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:1762:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:1763:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:1763:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:1764:5: lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_44);
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

            // InternalMappingDsl.g:1781:3: (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==35) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMappingDsl.g:1782:4: otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:1786:4: ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    // InternalMappingDsl.g:1787:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    {
            	    // InternalMappingDsl.g:1787:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    // InternalMappingDsl.g:1788:6: lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol
            	    {

            	    						newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	    break loop55;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_45); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:1810:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:1811:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:1811:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:1812:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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

            // InternalMappingDsl.g:1828:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==35) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalMappingDsl.g:1829:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,35,FOLLOW_45); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:1833:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:1834:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:1834:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:1835:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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

            otherlv_7=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:1860:1: entryRuleTechnologySpecificImportedServiceAspect returns [EObject current=null] : iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF ;
    public final EObject entryRuleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:1860:80: (iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF )
            // InternalMappingDsl.g:1861:2: iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF
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
    // InternalMappingDsl.g:1867:1: ruleTechnologySpecificImportedServiceAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:1873:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:1874:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:1874:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            // InternalMappingDsl.g:1875:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';'
            {
            // InternalMappingDsl.g:1875:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1876:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1876:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1877:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1892:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:1893:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:1893:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:1894:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getAspectServiceAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_47);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:1908:3: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==15) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMappingDsl.g:1909:4: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_48); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalMappingDsl.g:1913:4: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_BOOLEAN)) ) {
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
                            // InternalMappingDsl.g:1914:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:1914:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:1915:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:1915:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:1916:7: lv_singlePropertyValue_4_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_9);
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
                            // InternalMappingDsl.g:1934:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:1934:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:1935:6: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:1935:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:1936:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:1936:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:1937:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_0_0());
                            							
                            pushFollow(FOLLOW_49);
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

                            // InternalMappingDsl.g:1954:6: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==35) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1955:7: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,35,FOLLOW_48); 

                            	    							newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getCommaKeyword_3_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:1959:7: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:1960:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:1960:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:1961:9: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_49);
                            	    lv_values_7_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_7_0,
                            	    										"de.fhdo.ddmm.ServiceDsl.PropertyValueAssignment");
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

                    otherlv_8=(Token)match(input,16,FOLLOW_50); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getRightParenthesisKeyword_3_2());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:1994:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMappingDsl.g:1994:47: (iv_ruleImport= ruleImport EOF )
            // InternalMappingDsl.g:1995:2: iv_ruleImport= ruleImport EOF
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
    // InternalMappingDsl.g:2001:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:2007:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:2008:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:2008:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:2009:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMappingDsl.g:2013:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalMappingDsl.g:2014:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalMappingDsl.g:2014:4: (lv_importType_1_0= ruleImportType )
            // InternalMappingDsl.g:2015:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_52);
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

            otherlv_2=(Token)match(input,37,FOLLOW_45); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:2036:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:2037:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:2037:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:2038:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

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

            otherlv_4=(Token)match(input,38,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:2058:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:2059:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:2059:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:2060:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:2080:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalMappingDsl.g:2080:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalMappingDsl.g:2081:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalMappingDsl.g:2087:1: ruleMicroservice returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) ;
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
            // InternalMappingDsl.g:2093:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) )
            // InternalMappingDsl.g:2094:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            {
            // InternalMappingDsl.g:2094:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            // InternalMappingDsl.g:2095:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}'
            {
            // InternalMappingDsl.g:2095:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==13) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==14) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalMappingDsl.g:2096:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_6); 

            	    				newLeafNode(otherlv_0, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMicroserviceAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalMappingDsl.g:2108:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMappingDsl.g:2109:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMappingDsl.g:2109:5: (otherlv_3= RULE_ID )
            	    // InternalMappingDsl.g:2110:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMicroserviceRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    						newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_54); 

            	    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_0_4());
            	    			

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            // InternalMappingDsl.g:2126:3: ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==13) ) {
                int LA62_1 = input.LA(2);

                if ( ((LA62_1>=94 && LA62_1<=95)) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // InternalMappingDsl.g:2127:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2127:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2128:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2128:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2129:6: lv_protocols_5_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_54);
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

                    // InternalMappingDsl.g:2146:4: ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==13) ) {
                        int LA61_1 = input.LA(2);

                        if ( ((LA61_1>=94 && LA61_1<=95)) ) {
                            alt61=1;
                        }
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalMappingDsl.g:2147:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2147:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2148:6: lv_protocols_6_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_54);
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

            // InternalMappingDsl.g:2166:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==13) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==23) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalMappingDsl.g:2167:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,23,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMappingDsl.g:2179:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
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
                    	    // InternalMappingDsl.g:2180:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2180:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2181:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_56);
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
                    	    if ( cnt63 >= 1 ) break loop63;
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_54); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2203:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==13) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalMappingDsl.g:2204:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2204:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2205:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_54);
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
            	    break loop65;
                }
            } while (true);

            // InternalMappingDsl.g:2222:3: ( (lv_visibility_13_0= ruleVisibility ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=85 && LA66_0<=87)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalMappingDsl.g:2223:4: (lv_visibility_13_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2223:4: (lv_visibility_13_0= ruleVisibility )
                    // InternalMappingDsl.g:2224:5: lv_visibility_13_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_54);
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

            // InternalMappingDsl.g:2241:3: ( (lv_type_14_0= ruleMicroserviceType ) )
            // InternalMappingDsl.g:2242:4: (lv_type_14_0= ruleMicroserviceType )
            {
            // InternalMappingDsl.g:2242:4: (lv_type_14_0= ruleMicroserviceType )
            // InternalMappingDsl.g:2243:5: lv_type_14_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_57);
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

            otherlv_15=(Token)match(input,39,FOLLOW_8); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_6());
            		
            // InternalMappingDsl.g:2264:3: ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:2265:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:2265:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:2266:5: lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_58);
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

            // InternalMappingDsl.g:2283:3: (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==40) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalMappingDsl.g:2284:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,40,FOLLOW_8); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalMappingDsl.g:2288:4: ( (lv_version_18_0= RULE_ID ) )
                    // InternalMappingDsl.g:2289:5: (lv_version_18_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2289:5: (lv_version_18_0= RULE_ID )
                    // InternalMappingDsl.g:2290:6: lv_version_18_0= RULE_ID
                    {
                    lv_version_18_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_19=(Token)match(input,18,FOLLOW_59); 

            			newLeafNode(otherlv_19, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalMappingDsl.g:2311:3: (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==41) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==42) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalMappingDsl.g:2312:4: otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}'
                    {
                    otherlv_20=(Token)match(input,41,FOLLOW_60); 

                    				newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_21=(Token)match(input,42,FOLLOW_11); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_22=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalMappingDsl.g:2324:4: ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) )
                    // InternalMappingDsl.g:2325:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalMappingDsl.g:2325:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    // InternalMappingDsl.g:2326:6: lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalMappingDsl.g:2343:4: (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==35) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2344:5: otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_24=(Token)match(input,35,FOLLOW_8); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2348:5: ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalMappingDsl.g:2349:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalMappingDsl.g:2349:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    // InternalMappingDsl.g:2350:7: lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,20,FOLLOW_59); 

                    				newLeafNode(otherlv_26, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2373:3: (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==41) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==43) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalMappingDsl.g:2374:4: otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}'
                    {
                    otherlv_27=(Token)match(input,41,FOLLOW_62); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_28=(Token)match(input,43,FOLLOW_11); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_29=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalMappingDsl.g:2386:4: ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) )
                    // InternalMappingDsl.g:2387:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    {
                    // InternalMappingDsl.g:2387:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    // InternalMappingDsl.g:2388:6: lv_requiredInterfaces_30_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalMappingDsl.g:2405:4: (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==35) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2406:5: otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_31=(Token)match(input,35,FOLLOW_8); 

                    	    					newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2410:5: ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    // InternalMappingDsl.g:2411:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalMappingDsl.g:2411:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    // InternalMappingDsl.g:2412:7: lv_requiredInterfaces_32_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop70;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,20,FOLLOW_59); 

                    				newLeafNode(otherlv_33, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2435:3: (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==41) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMappingDsl.g:2436:4: otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}'
                    {
                    otherlv_34=(Token)match(input,41,FOLLOW_63); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_35=(Token)match(input,44,FOLLOW_11); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_36=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalMappingDsl.g:2448:4: ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:2449:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:2449:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:2450:6: lv_requiredOperations_37_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalMappingDsl.g:2467:4: (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==35) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2468:5: otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_38=(Token)match(input,35,FOLLOW_8); 

                    	    					newLeafNode(otherlv_38, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2472:5: ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    // InternalMappingDsl.g:2473:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalMappingDsl.g:2473:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    // InternalMappingDsl.g:2474:7: lv_requiredOperations_39_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_40=(Token)match(input,20,FOLLOW_59); 

                    				newLeafNode(otherlv_40, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2497:3: ( (lv_interfaces_41_0= ruleInterface ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==13||LA74_0==24||LA74_0==45||(LA74_0>=85 && LA74_0<=87)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalMappingDsl.g:2498:4: (lv_interfaces_41_0= ruleInterface )
            	    {
            	    // InternalMappingDsl.g:2498:4: (lv_interfaces_41_0= ruleInterface )
            	    // InternalMappingDsl.g:2499:5: lv_interfaces_41_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_64);
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
            	    if ( cnt74 >= 1 ) break loop74;
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            otherlv_42=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:2524:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:2524:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalMappingDsl.g:2525:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalMappingDsl.g:2531:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2537:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2538:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2538:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2539:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2539:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                int LA75_1 = input.LA(2);

                if ( (LA75_1==21) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // InternalMappingDsl.g:2540:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2540:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2541:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2541:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2542:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2558:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2559:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2559:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2560:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2578:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalMappingDsl.g:2578:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalMappingDsl.g:2579:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalMappingDsl.g:2585:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2591:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2592:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2592:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2593:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2593:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==21) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalMappingDsl.g:2594:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2594:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2595:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2595:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2596:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2612:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2613:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2613:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2614:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2632:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalMappingDsl.g:2632:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalMappingDsl.g:2633:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalMappingDsl.g:2639:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2645:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2646:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2646:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2647:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2647:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==21) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // InternalMappingDsl.g:2648:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2648:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2649:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2649:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2650:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2666:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2667:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2667:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2668:5: ruleQualifiedName
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
    // InternalMappingDsl.g:2686:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalMappingDsl.g:2686:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalMappingDsl.g:2687:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalMappingDsl.g:2693:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) ;
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
            // InternalMappingDsl.g:2699:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) )
            // InternalMappingDsl.g:2700:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            {
            // InternalMappingDsl.g:2700:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            // InternalMappingDsl.g:2701:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}'
            {
            // InternalMappingDsl.g:2701:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==13) ) {
                int LA79_1 = input.LA(2);

                if ( ((LA79_1>=94 && LA79_1<=95)) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // InternalMappingDsl.g:2702:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2702:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2703:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2703:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2704:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_65);
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

                    // InternalMappingDsl.g:2721:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==13) ) {
                        int LA78_1 = input.LA(2);

                        if ( ((LA78_1>=94 && LA78_1<=95)) ) {
                            alt78=1;
                        }
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalMappingDsl.g:2722:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2722:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2723:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_65);
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

            // InternalMappingDsl.g:2741:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==13) ) {
                int LA81_1 = input.LA(2);

                if ( (LA81_1==23) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // InternalMappingDsl.g:2742:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,23,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2754:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt80=0;
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==RULE_ID) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2755:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2755:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2756:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_56);
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
                    	    if ( cnt80 >= 1 ) break loop80;
                                EarlyExitException eee =
                                    new EarlyExitException(80, input);
                                throw eee;
                        }
                        cnt80++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_65); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2778:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==13) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalMappingDsl.g:2779:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2779:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2780:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_65);
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
            	    break loop82;
                }
            } while (true);

            // InternalMappingDsl.g:2797:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==45) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalMappingDsl.g:2798:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:2798:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:2799:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,45,FOLLOW_66); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:2811:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=85 && LA84_0<=87)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMappingDsl.g:2812:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2812:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2813:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_67);
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

            otherlv_10=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_10, grammarAccess.getInterfaceAccess().getInterfaceKeyword_5());
            		
            // InternalMappingDsl.g:2834:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalMappingDsl.g:2835:4: (lv_name_11_0= RULE_ID )
            {
            // InternalMappingDsl.g:2835:4: (lv_name_11_0= RULE_ID )
            // InternalMappingDsl.g:2836:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_12=(Token)match(input,18,FOLLOW_68); 

            			newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMappingDsl.g:2856:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*
            loop85:
            do {
                int alt85=2;
                alt85 = dfa85.predict(input);
                switch (alt85) {
            	case 1 :
            	    // InternalMappingDsl.g:2857:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    {
            	    // InternalMappingDsl.g:2857:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    // InternalMappingDsl.g:2858:5: lv_referredOperations_13_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_68);
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
            	    break loop85;
                }
            } while (true);

            // InternalMappingDsl.g:2875:3: ( (lv_operations_14_0= ruleOperation ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==RULE_ID||LA86_0==13||LA86_0==45||(LA86_0>=85 && LA86_0<=87)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalMappingDsl.g:2876:4: (lv_operations_14_0= ruleOperation )
            	    {
            	    // InternalMappingDsl.g:2876:4: (lv_operations_14_0= ruleOperation )
            	    // InternalMappingDsl.g:2877:5: lv_operations_14_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_69);
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
            	    break loop86;
                }
            } while (true);

            otherlv_15=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:2902:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMappingDsl.g:2902:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMappingDsl.g:2903:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalMappingDsl.g:2909:1: ruleOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) ;
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
            // InternalMappingDsl.g:2915:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) )
            // InternalMappingDsl.g:2916:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            {
            // InternalMappingDsl.g:2916:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            // InternalMappingDsl.g:2917:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';'
            {
            // InternalMappingDsl.g:2917:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==13) ) {
                int LA88_1 = input.LA(2);

                if ( ((LA88_1>=94 && LA88_1<=95)) ) {
                    alt88=1;
                }
            }
            switch (alt88) {
                case 1 :
                    // InternalMappingDsl.g:2918:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2918:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2919:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2919:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2920:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_70);
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

                    // InternalMappingDsl.g:2937:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==13) ) {
                        int LA87_1 = input.LA(2);

                        if ( ((LA87_1>=94 && LA87_1<=95)) ) {
                            alt87=1;
                        }
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalMappingDsl.g:2938:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2938:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2939:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_70);
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

            // InternalMappingDsl.g:2957:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==13) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==23) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalMappingDsl.g:2958:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,23,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:2970:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt89=0;
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==RULE_ID) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2971:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2971:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2972:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_56);
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
                    	    if ( cnt89 >= 1 ) break loop89;
                                EarlyExitException eee =
                                    new EarlyExitException(89, input);
                                throw eee;
                        }
                        cnt89++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_70); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2994:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==13) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalMappingDsl.g:2995:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2995:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2996:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_70);
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
            	    break loop91;
                }
            } while (true);

            // InternalMappingDsl.g:3013:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==45) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalMappingDsl.g:3014:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:3014:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:3015:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,45,FOLLOW_71); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3027:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( ((LA93_0>=85 && LA93_0<=87)) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalMappingDsl.g:3028:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:3028:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:3029:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_8);
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

            // InternalMappingDsl.g:3046:3: ( (lv_name_10_0= RULE_ID ) )
            // InternalMappingDsl.g:3047:4: (lv_name_10_0= RULE_ID )
            {
            // InternalMappingDsl.g:3047:4: (lv_name_10_0= RULE_ID )
            // InternalMappingDsl.g:3048:5: lv_name_10_0= RULE_ID
            {
            lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_7); 

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

            otherlv_11=(Token)match(input,15,FOLLOW_72); 

            			newLeafNode(otherlv_11, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_6());
            		
            // InternalMappingDsl.g:3068:3: ( (lv_parameters_12_0= ruleParameter ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==13||(LA94_0>=94 && LA94_0<=95)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalMappingDsl.g:3069:4: (lv_parameters_12_0= ruleParameter )
                    {
                    // InternalMappingDsl.g:3069:4: (lv_parameters_12_0= ruleParameter )
                    // InternalMappingDsl.g:3070:5: lv_parameters_12_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_49);
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

            // InternalMappingDsl.g:3087:3: (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==35) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalMappingDsl.g:3088:4: otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) )
            	    {
            	    otherlv_13=(Token)match(input,35,FOLLOW_73); 

            	    				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMappingDsl.g:3092:4: ( (lv_parameters_14_0= ruleParameter ) )
            	    // InternalMappingDsl.g:3093:5: (lv_parameters_14_0= ruleParameter )
            	    {
            	    // InternalMappingDsl.g:3093:5: (lv_parameters_14_0= ruleParameter )
            	    // InternalMappingDsl.g:3094:6: lv_parameters_14_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_49);
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
            	    break loop95;
                }
            } while (true);

            otherlv_15=(Token)match(input,16,FOLLOW_50); 

            			newLeafNode(otherlv_15, grammarAccess.getOperationAccess().getRightParenthesisKeyword_9());
            		
            otherlv_16=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:3124:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalMappingDsl.g:3124:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalMappingDsl.g:3125:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalMappingDsl.g:3131:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalMappingDsl.g:3137:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalMappingDsl.g:3138:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalMappingDsl.g:3138:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalMappingDsl.g:3139:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalMappingDsl.g:3139:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==13) ) {
                int LA97_1 = input.LA(2);

                if ( ((LA97_1>=94 && LA97_1<=95)) ) {
                    alt97=1;
                }
            }
            switch (alt97) {
                case 1 :
                    // InternalMappingDsl.g:3140:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:3140:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:3141:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:3141:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:3142:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_74);
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

                    // InternalMappingDsl.g:3159:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==13) ) {
                        int LA96_1 = input.LA(2);

                        if ( ((LA96_1>=94 && LA96_1<=95)) ) {
                            alt96=1;
                        }
                    }
                    switch (alt96) {
                        case 1 :
                            // InternalMappingDsl.g:3160:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:3160:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:3161:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_74);
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

            // InternalMappingDsl.g:3179:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==13) ) {
                int LA99_1 = input.LA(2);

                if ( (LA99_1==23) ) {
                    alt99=1;
                }
            }
            switch (alt99) {
                case 1 :
                    // InternalMappingDsl.g:3180:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,23,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:3192:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt98=0;
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==RULE_ID) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalMappingDsl.g:3193:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:3193:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:3194:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_56);
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
                    	    if ( cnt98 >= 1 ) break loop98;
                                EarlyExitException eee =
                                    new EarlyExitException(98, input);
                                throw eee;
                        }
                        cnt98++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_74); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3216:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==13) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalMappingDsl.g:3217:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3217:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3218:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_74);
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
            	    break loop100;
                }
            } while (true);

            otherlv_8=(Token)match(input,46,FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalMappingDsl.g:3239:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3240:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3240:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3241:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_50);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:3263:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMappingDsl.g:3263:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMappingDsl.g:3264:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalMappingDsl.g:3270:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalMappingDsl.g:3276:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalMappingDsl.g:3277:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalMappingDsl.g:3277:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalMappingDsl.g:3278:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalMappingDsl.g:3278:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==13) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalMappingDsl.g:3279:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3279:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3280:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_73);
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
            	    break loop101;
                }
            } while (true);

            // InternalMappingDsl.g:3297:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3298:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3298:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3299:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_75);
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

            // InternalMappingDsl.g:3316:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( ((LA102_0>=91 && LA102_0<=93)) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalMappingDsl.g:3317:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:3317:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:3318:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_76);
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

            // InternalMappingDsl.g:3335:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==47) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalMappingDsl.g:3336:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalMappingDsl.g:3336:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalMappingDsl.g:3337:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,47,FOLLOW_8); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3349:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalMappingDsl.g:3350:4: (lv_name_4_0= RULE_ID )
            {
            // InternalMappingDsl.g:3350:4: (lv_name_4_0= RULE_ID )
            // InternalMappingDsl.g:3351:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_77); 

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

            // InternalMappingDsl.g:3367:3: ( (lv_optional_5_0= '?' ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==48) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalMappingDsl.g:3368:4: (lv_optional_5_0= '?' )
                    {
                    // InternalMappingDsl.g:3368:4: (lv_optional_5_0= '?' )
                    // InternalMappingDsl.g:3369:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,48,FOLLOW_42); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,29,FOLLOW_78); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalMappingDsl.g:3385:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=75 && LA105_0<=84)) ) {
                alt105=1;
            }
            else if ( (LA105_0==RULE_ID) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalMappingDsl.g:3386:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:3386:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:3387:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:3387:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalMappingDsl.g:3388:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_79);
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
                    // InternalMappingDsl.g:3406:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalMappingDsl.g:3406:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalMappingDsl.g:3407:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalMappingDsl.g:3407:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalMappingDsl.g:3408:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_79);
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

            // InternalMappingDsl.g:3426:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==49) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalMappingDsl.g:3427:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,49,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalMappingDsl.g:3431:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:3432:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:3432:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:3433:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalMappingDsl.g:3455:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalMappingDsl.g:3455:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalMappingDsl.g:3456:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalMappingDsl.g:3462:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3468:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:3469:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:3469:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:3470:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:3470:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3471:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3471:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3472:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3487:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3488:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3488:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3489:5: ruleQualifiedName
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
    // InternalMappingDsl.g:3507:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:3507:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalMappingDsl.g:3508:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalMappingDsl.g:3514:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3520:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalMappingDsl.g:3521:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalMappingDsl.g:3521:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalMappingDsl.g:3522:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3526:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3527:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3527:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3528:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_2=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:3549:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3550:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3550:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3551:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getProtocolImportedProtocolAndDataFormatParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
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
    // InternalMappingDsl.g:3576:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalMappingDsl.g:3576:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalMappingDsl.g:3577:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalMappingDsl.g:3583:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3589:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:3590:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:3590:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:3591:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:3591:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3592:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3592:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3593:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:3608:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3609:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3609:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3610:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_43);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3624:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==34) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalMappingDsl.g:3625:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:3629:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:3630:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:3630:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:3631:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:3647:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalMappingDsl.g:3647:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalMappingDsl.g:3648:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalMappingDsl.g:3654:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:3660:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:3661:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:3661:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:3662:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:3662:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:3663:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:3663:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:3664:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_44);
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

            // InternalMappingDsl.g:3681:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==35) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalMappingDsl.g:3682:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:3686:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalMappingDsl.g:3687:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalMappingDsl.g:3687:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalMappingDsl.g:3688:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	    break loop108;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_45); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:3710:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:3711:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:3711:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:3712:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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

            // InternalMappingDsl.g:3728:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==35) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalMappingDsl.g:3729:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,35,FOLLOW_45); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:3733:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:3734:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:3734:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:3735:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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
            	    break loop109;
                }
            } while (true);

            otherlv_7=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:3760:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:3760:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalMappingDsl.g:3761:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalMappingDsl.g:3767:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalMappingDsl.g:3773:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalMappingDsl.g:3774:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalMappingDsl.g:3774:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalMappingDsl.g:3775:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:3779:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:3780:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:3780:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:3781:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalMappingDsl.g:3796:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3797:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3797:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3798:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_80);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3812:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==15) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalMappingDsl.g:3813:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_48); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMappingDsl.g:3817:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( ((LA111_0>=RULE_STRING && LA111_0<=RULE_BOOLEAN)) ) {
                        alt111=1;
                    }
                    else if ( (LA111_0==RULE_ID) ) {
                        alt111=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalMappingDsl.g:3818:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:3818:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:3819:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:3819:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:3820:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_9);
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
                            // InternalMappingDsl.g:3838:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:3838:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:3839:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:3839:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:3840:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:3840:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:3841:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_49);
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

                            // InternalMappingDsl.g:3858:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop110:
                            do {
                                int alt110=2;
                                int LA110_0 = input.LA(1);

                                if ( (LA110_0==35) ) {
                                    alt110=1;
                                }


                                switch (alt110) {
                            	case 1 :
                            	    // InternalMappingDsl.g:3859:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,35,FOLLOW_48); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:3863:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:3864:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:3864:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:3865:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_49);
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
                            	    break loop110;
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
    // InternalMappingDsl.g:3894:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalMappingDsl.g:3894:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalMappingDsl.g:3895:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalMappingDsl.g:3901:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject rulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3907:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalMappingDsl.g:3908:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalMappingDsl.g:3908:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalMappingDsl.g:3909:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalMappingDsl.g:3909:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:3910:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:3910:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:3911:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_81); 

            					newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,49,FOLLOW_82); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalMappingDsl.g:3926:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalMappingDsl.g:3927:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalMappingDsl.g:3927:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalMappingDsl.g:3928:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalMappingDsl.g:3949:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalMappingDsl.g:3949:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalMappingDsl.g:3950:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalMappingDsl.g:3956:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3962:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalMappingDsl.g:3963:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalMappingDsl.g:3963:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalMappingDsl.g:3964:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_83); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,33,FOLLOW_8); 

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
    // InternalMappingDsl.g:3990:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalMappingDsl.g:3990:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalMappingDsl.g:3991:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalMappingDsl.g:3997:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:4003:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:4004:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:4004:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:4005:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,37,FOLLOW_45); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:4017:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:4018:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:4018:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:4019:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

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

            otherlv_4=(Token)match(input,38,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:4039:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:4040:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:4040:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:4041:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:4061:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalMappingDsl.g:4061:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalMappingDsl.g:4062:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalMappingDsl.g:4068:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalMappingDsl.g:4074:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalMappingDsl.g:4075:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalMappingDsl.g:4075:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalMappingDsl.g:4076:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalMappingDsl.g:4076:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:4077:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:4077:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:4078:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
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

            // InternalMappingDsl.g:4095:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:4096:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:4096:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:4097:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_84); 

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

            otherlv_2=(Token)match(input,50,FOLLOW_85); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,51,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalMappingDsl.g:4121:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalMappingDsl.g:4122:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalMappingDsl.g:4122:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalMappingDsl.g:4123:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_86);
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

            // InternalMappingDsl.g:4140:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==35) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalMappingDsl.g:4141:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,35,FOLLOW_8); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:4145:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalMappingDsl.g:4146:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalMappingDsl.g:4146:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalMappingDsl.g:4147:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_86);
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
            	    break loop113;
                }
            } while (true);

            // InternalMappingDsl.g:4165:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==52) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalMappingDsl.g:4166:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:4166:4: ( (lv_default_7_0= 'default' ) )
                    // InternalMappingDsl.g:4167:5: (lv_default_7_0= 'default' )
                    {
                    // InternalMappingDsl.g:4167:5: (lv_default_7_0= 'default' )
                    // InternalMappingDsl.g:4168:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,52,FOLLOW_87); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,53,FOLLOW_88); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,54,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalMappingDsl.g:4188:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMappingDsl.g:4189:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMappingDsl.g:4189:5: (otherlv_10= RULE_ID )
                    // InternalMappingDsl.g:4190:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_50); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:4210:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalMappingDsl.g:4210:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalMappingDsl.g:4211:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalMappingDsl.g:4217:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4223:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalMappingDsl.g:4224:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:4224:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4225:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4225:3: (lv_formatName_0_0= RULE_ID )
            // InternalMappingDsl.g:4226:4: lv_formatName_0_0= RULE_ID
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
    // InternalMappingDsl.g:4245:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalMappingDsl.g:4245:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalMappingDsl.g:4246:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalMappingDsl.g:4252:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:4258:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:4259:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:4259:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalMappingDsl.g:4260:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_89); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4268:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4269:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4269:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4270:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_90); 

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

            // InternalMappingDsl.g:4286:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==55) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalMappingDsl.g:4287:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_91); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,56,FOLLOW_92); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalMappingDsl.g:4295:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:4296:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:4296:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalMappingDsl.g:4297:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_86);
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

                    // InternalMappingDsl.g:4314:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==35) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4315:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,35,FOLLOW_92); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMappingDsl.g:4319:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalMappingDsl.g:4320:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalMappingDsl.g:4320:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalMappingDsl.g:4321:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_86);
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
                    	    break loop115;
                        }
                    } while (true);

                    // InternalMappingDsl.g:4339:4: ( (lv_default_8_0= 'default' ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==52) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalMappingDsl.g:4340:5: (lv_default_8_0= 'default' )
                            {
                            // InternalMappingDsl.g:4340:5: (lv_default_8_0= 'default' )
                            // InternalMappingDsl.g:4341:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,52,FOLLOW_50); 

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

            otherlv_9=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:4362:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalMappingDsl.g:4362:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalMappingDsl.g:4363:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalMappingDsl.g:4369:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4375:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4376:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4376:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4377:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_89); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4385:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4386:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4386:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4387:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_50); 

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

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:4411:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalMappingDsl.g:4411:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalMappingDsl.g:4412:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalMappingDsl.g:4418:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4424:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:4425:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:4425:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:4426:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_89); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:4434:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:4435:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:4435:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:4436:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_50); 

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

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:4460:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalMappingDsl.g:4460:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalMappingDsl.g:4461:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalMappingDsl.g:4467:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4473:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:4474:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:4474:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:4475:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:4475:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==RULE_ID) ) {
                int LA118_1 = input.LA(2);

                if ( (LA118_1==21) ) {
                    alt118=1;
                }
            }
            switch (alt118) {
                case 1 :
                    // InternalMappingDsl.g:4476:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:4476:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:4477:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:4477:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:4478:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:4494:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4495:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4495:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4496:5: ruleQualifiedName
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
    // InternalMappingDsl.g:4514:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalMappingDsl.g:4514:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalMappingDsl.g:4515:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalMappingDsl.g:4521:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:4527:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalMappingDsl.g:4528:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4528:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalMappingDsl.g:4529:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalMappingDsl.g:4529:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4530:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4530:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4531:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_93);
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

            // InternalMappingDsl.g:4548:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==35) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalMappingDsl.g:4549:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:4553:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalMappingDsl.g:4554:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalMappingDsl.g:4554:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalMappingDsl.g:4555:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_93);
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
            	    break loop119;
                }
            } while (true);

            // InternalMappingDsl.g:4573:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalMappingDsl.g:4574:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalMappingDsl.g:4574:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalMappingDsl.g:4575:5: lv_direction_3_0= ruleCompatibilityDirection
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
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

            // InternalMappingDsl.g:4592:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:4593:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:4593:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:4594:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_50);
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

            otherlv_5=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:4619:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalMappingDsl.g:4619:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalMappingDsl.g:4620:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalMappingDsl.g:4626:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4632:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4633:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4633:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4634:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4634:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4635:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4635:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4636:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_1=(Token)match(input,18,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_94); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,59,FOLLOW_81); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,49,FOLLOW_45); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4668:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4669:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4669:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4670:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_46);
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

            // InternalMappingDsl.g:4687:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==35) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalMappingDsl.g:4688:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,35,FOLLOW_45); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4692:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4693:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4693:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4694:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop120;
                }
            } while (true);

            otherlv_8=(Token)match(input,30,FOLLOW_95); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4716:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==60) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalMappingDsl.g:4717:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,60,FOLLOW_96); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,61,FOLLOW_11); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,18,FOLLOW_92); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4729:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt121=0;
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( ((LA121_0>=75 && LA121_0<=84)) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4730:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4730:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4731:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_97);
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
                    	    if ( cnt121 >= 1 ) break loop121;
                                EarlyExitException eee =
                                    new EarlyExitException(121, input);
                                throw eee;
                        }
                        cnt121++;
                    } while (true);

                    otherlv_13=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:4761:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalMappingDsl.g:4761:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalMappingDsl.g:4762:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalMappingDsl.g:4768:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:4774:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:4775:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:4775:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:4776:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:4776:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:4777:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:4777:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:4778:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_1=(Token)match(input,18,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_94); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,59,FOLLOW_81); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,49,FOLLOW_45); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:4810:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:4811:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:4811:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:4812:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_46);
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

            // InternalMappingDsl.g:4829:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==35) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // InternalMappingDsl.g:4830:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,35,FOLLOW_45); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:4834:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:4835:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:4835:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:4836:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop123;
                }
            } while (true);

            otherlv_8=(Token)match(input,30,FOLLOW_95); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:4858:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==60) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalMappingDsl.g:4859:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,60,FOLLOW_96); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,61,FOLLOW_11); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,18,FOLLOW_92); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:4871:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt124=0;
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( ((LA124_0>=75 && LA124_0<=84)) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalMappingDsl.g:4872:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:4872:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:4873:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_97);
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
                    	    if ( cnt124 >= 1 ) break loop124;
                                EarlyExitException eee =
                                    new EarlyExitException(124, input);
                                throw eee;
                        }
                        cnt124++;
                    } while (true);

                    otherlv_13=(Token)match(input,20,FOLLOW_28); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:4903:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalMappingDsl.g:4903:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalMappingDsl.g:4904:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalMappingDsl.g:4910:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4916:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalMappingDsl.g:4917:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalMappingDsl.g:4917:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalMappingDsl.g:4918:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalMappingDsl.g:4918:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalMappingDsl.g:4919:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalMappingDsl.g:4919:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalMappingDsl.g:4920:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_98); 

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

            // InternalMappingDsl.g:4936:3: ( (lv_default_1_0= 'default' ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==52) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalMappingDsl.g:4937:4: (lv_default_1_0= 'default' )
                    {
                    // InternalMappingDsl.g:4937:4: (lv_default_1_0= 'default' )
                    // InternalMappingDsl.g:4938:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,52,FOLLOW_2); 

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
    // InternalMappingDsl.g:4954:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalMappingDsl.g:4954:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalMappingDsl.g:4955:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalMappingDsl.g:4961:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:4967:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) )
            // InternalMappingDsl.g:4968:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            {
            // InternalMappingDsl.g:4968:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            // InternalMappingDsl.g:4969:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';'
            {
            // InternalMappingDsl.g:4969:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalMappingDsl.g:4970:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalMappingDsl.g:4970:4: (lv_type_0_0= rulePrimitiveType )
            // InternalMappingDsl.g:4971:5: lv_type_0_0= rulePrimitiveType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
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

            // InternalMappingDsl.g:4988:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:4989:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:4989:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:4990:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_99); 

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

            // InternalMappingDsl.g:5006:3: ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )?
            int alt127=3;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==49) ) {
                alt127=1;
            }
            else if ( (LA127_0==62) ) {
                alt127=2;
            }
            switch (alt127) {
                case 1 :
                    // InternalMappingDsl.g:5007:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    {
                    // InternalMappingDsl.g:5007:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    // InternalMappingDsl.g:5008:5: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_82); 

                    					newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0_0());
                    				
                    // InternalMappingDsl.g:5012:5: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:5013:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:5013:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:5014:7: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_50);
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
                    // InternalMappingDsl.g:5033:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    {
                    // InternalMappingDsl.g:5033:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    // InternalMappingDsl.g:5034:5: (lv_mandatory_4_0= 'mandatory' )
                    {
                    // InternalMappingDsl.g:5034:5: (lv_mandatory_4_0= 'mandatory' )
                    // InternalMappingDsl.g:5035:6: lv_mandatory_4_0= 'mandatory'
                    {
                    lv_mandatory_4_0=(Token)match(input,62,FOLLOW_50); 

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

            otherlv_5=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:5056:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalMappingDsl.g:5056:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalMappingDsl.g:5057:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalMappingDsl.g:5063:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalMappingDsl.g:5069:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalMappingDsl.g:5070:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalMappingDsl.g:5070:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt128=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt128=1;
                }
                break;
            case 64:
                {
                alt128=2;
                }
                break;
            case 65:
                {
                alt128=3;
                }
                break;
            case 66:
                {
                alt128=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // InternalMappingDsl.g:5071:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalMappingDsl.g:5071:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalMappingDsl.g:5072:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalMappingDsl.g:5072:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalMappingDsl.g:5073:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalMappingDsl.g:5073:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalMappingDsl.g:5074:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,63,FOLLOW_81); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,49,FOLLOW_100); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:5090:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalMappingDsl.g:5091:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:5091:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:5092:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalMappingDsl.g:5111:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalMappingDsl.g:5111:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalMappingDsl.g:5112:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalMappingDsl.g:5112:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalMappingDsl.g:5113:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalMappingDsl.g:5113:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalMappingDsl.g:5114:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,64,FOLLOW_81); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,49,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalMappingDsl.g:5130:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalMappingDsl.g:5131:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalMappingDsl.g:5131:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalMappingDsl.g:5132:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalMappingDsl.g:5151:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:5151:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalMappingDsl.g:5152:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:5152:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalMappingDsl.g:5153:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalMappingDsl.g:5153:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalMappingDsl.g:5154:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,65,FOLLOW_81); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,49,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMappingDsl.g:5170:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:5171:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:5171:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:5172:6: otherlv_8= RULE_ID
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
                    // InternalMappingDsl.g:5185:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:5185:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalMappingDsl.g:5186:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:5186:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalMappingDsl.g:5187:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalMappingDsl.g:5187:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalMappingDsl.g:5188:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,66,FOLLOW_81); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,49,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalMappingDsl.g:5204:4: ( (otherlv_11= RULE_ID ) )
                    // InternalMappingDsl.g:5205:5: (otherlv_11= RULE_ID )
                    {
                    // InternalMappingDsl.g:5205:5: (otherlv_11= RULE_ID )
                    // InternalMappingDsl.g:5206:6: otherlv_11= RULE_ID
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
    // InternalMappingDsl.g:5222:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:5222:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalMappingDsl.g:5223:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalMappingDsl.g:5229:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMappingDsl.g:5235:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:5236:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:5236:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:5237:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_101); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:5245:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalMappingDsl.g:5246:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalMappingDsl.g:5246:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalMappingDsl.g:5247:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_49);
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

            // InternalMappingDsl.g:5264:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==35) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // InternalMappingDsl.g:5265:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_101); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:5269:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalMappingDsl.g:5270:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:5270:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalMappingDsl.g:5271:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_49);
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
            	    break loop129;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_50); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:5301:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalMappingDsl.g:5301:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalMappingDsl.g:5302:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalMappingDsl.g:5308:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalMappingDsl.g:5314:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalMappingDsl.g:5315:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalMappingDsl.g:5315:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalMappingDsl.g:5316:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5320:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5321:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5321:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5322:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_102); 

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

            otherlv_2=(Token)match(input,69,FOLLOW_103); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5342:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalMappingDsl.g:5343:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalMappingDsl.g:5343:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalMappingDsl.g:5344:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_104);
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

            // InternalMappingDsl.g:5361:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop130:
            do {
                int alt130=2;
                int LA130_0 = input.LA(1);

                if ( (LA130_0==35) ) {
                    alt130=1;
                }


                switch (alt130) {
            	case 1 :
            	    // InternalMappingDsl.g:5362:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,35,FOLLOW_103); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5366:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalMappingDsl.g:5367:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5367:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalMappingDsl.g:5368:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_104);
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
            	    break loop130;
                }
            } while (true);

            // InternalMappingDsl.g:5386:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==18) ) {
                alt133=1;
            }
            else if ( (LA133_0==30) ) {
                alt133=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }
            switch (alt133) {
                case 1 :
                    // InternalMappingDsl.g:5387:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalMappingDsl.g:5387:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalMappingDsl.g:5388:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_105); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5392:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==67) ) {
                            alt131=1;
                        }


                        switch (alt131) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5393:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:5393:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalMappingDsl.g:5394:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_105);
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
                    	    break loop131;
                        }
                    } while (true);

                    // InternalMappingDsl.g:5411:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop132:
                    do {
                        int alt132=2;
                        int LA132_0 = input.LA(1);

                        if ( ((LA132_0>=75 && LA132_0<=84)) ) {
                            alt132=1;
                        }


                        switch (alt132) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5412:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5412:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5413:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_97);
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
                    	    break loop132;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,20,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5436:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:5445:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalMappingDsl.g:5445:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalMappingDsl.g:5446:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalMappingDsl.g:5452:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) ;
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
            // InternalMappingDsl.g:5458:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) )
            // InternalMappingDsl.g:5459:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            {
            // InternalMappingDsl.g:5459:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            // InternalMappingDsl.g:5460:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:5464:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5465:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5465:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5466:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_102); 

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

            otherlv_2=(Token)match(input,69,FOLLOW_106); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalMappingDsl.g:5486:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalMappingDsl.g:5487:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalMappingDsl.g:5487:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalMappingDsl.g:5488:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_104);
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

            // InternalMappingDsl.g:5505:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==35) ) {
                    alt134=1;
                }


                switch (alt134) {
            	case 1 :
            	    // InternalMappingDsl.g:5506:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,35,FOLLOW_106); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:5510:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalMappingDsl.g:5511:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalMappingDsl.g:5511:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalMappingDsl.g:5512:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_104);
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
            	    break loop134;
                }
            } while (true);

            // InternalMappingDsl.g:5530:3: ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==18) ) {
                alt136=1;
            }
            else if ( (LA136_0==30) ) {
                alt136=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }
            switch (alt136) {
                case 1 :
                    // InternalMappingDsl.g:5531:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    {
                    // InternalMappingDsl.g:5531:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    // InternalMappingDsl.g:5532:5: otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_97); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalMappingDsl.g:5536:5: ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( ((LA135_0>=75 && LA135_0<=84)) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5537:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:5537:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:5538:7: lv_properties_7_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_97);
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
                    	    break loop135;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5561:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_2); 

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
    // InternalMappingDsl.g:5570:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalMappingDsl.g:5570:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalMappingDsl.g:5571:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalMappingDsl.g:5577:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:5583:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5584:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5584:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5585:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_107); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,70,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,37,FOLLOW_45); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:5597:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:5598:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:5598:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:5599:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

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

            otherlv_4=(Token)match(input,38,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:5619:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:5620:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:5620:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:5621:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:5641:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalMappingDsl.g:5641:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalMappingDsl.g:5642:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalMappingDsl.g:5648:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalMappingDsl.g:5654:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalMappingDsl.g:5655:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalMappingDsl.g:5655:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalMappingDsl.g:5656:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalMappingDsl.g:5660:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5661:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5661:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5662:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_108); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5682:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt139=3;
            int LA139_0 = input.LA(1);

            if ( ((LA139_0>=57 && LA139_0<=58)||LA139_0==74) ) {
                alt139=1;
            }
            else if ( (LA139_0==71) ) {
                alt139=2;
            }
            switch (alt139) {
                case 1 :
                    // InternalMappingDsl.g:5683:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalMappingDsl.g:5683:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt137=0;
                    loop137:
                    do {
                        int alt137=2;
                        int LA137_0 = input.LA(1);

                        if ( ((LA137_0>=57 && LA137_0<=58)||LA137_0==74) ) {
                            alt137=1;
                        }


                        switch (alt137) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5684:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalMappingDsl.g:5684:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalMappingDsl.g:5685:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_109);
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
                    	    if ( cnt137 >= 1 ) break loop137;
                                EarlyExitException eee =
                                    new EarlyExitException(137, input);
                                throw eee;
                        }
                        cnt137++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:5703:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalMappingDsl.g:5703:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt138=0;
                    loop138:
                    do {
                        int alt138=2;
                        int LA138_0 = input.LA(1);

                        if ( (LA138_0==71) ) {
                            alt138=1;
                        }


                        switch (alt138) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5704:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalMappingDsl.g:5704:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalMappingDsl.g:5705:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_110);
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
                    	    if ( cnt138 >= 1 ) break loop138;
                                EarlyExitException eee =
                                    new EarlyExitException(138, input);
                                throw eee;
                        }
                        cnt138++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:5731:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMappingDsl.g:5731:48: (iv_ruleContext= ruleContext EOF )
            // InternalMappingDsl.g:5732:2: iv_ruleContext= ruleContext EOF
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
    // InternalMappingDsl.g:5738:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5744:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalMappingDsl.g:5745:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalMappingDsl.g:5745:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalMappingDsl.g:5746:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalMappingDsl.g:5750:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5751:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5751:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5752:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_111); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:5772:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt140=0;
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( ((LA140_0>=57 && LA140_0<=58)||LA140_0==74) ) {
                    alt140=1;
                }


                switch (alt140) {
            	case 1 :
            	    // InternalMappingDsl.g:5773:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalMappingDsl.g:5773:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalMappingDsl.g:5774:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_109);
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
            	    if ( cnt140 >= 1 ) break loop140;
                        EarlyExitException eee =
                            new EarlyExitException(140, input);
                        throw eee;
                }
                cnt140++;
            } while (true);

            otherlv_4=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:5799:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalMappingDsl.g:5799:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalMappingDsl.g:5800:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalMappingDsl.g:5806:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:5812:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalMappingDsl.g:5813:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalMappingDsl.g:5813:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt141=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt141=1;
                }
                break;
            case 57:
                {
                alt141=2;
                }
                break;
            case 74:
                {
                alt141=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }

            switch (alt141) {
                case 1 :
                    // InternalMappingDsl.g:5814:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalMappingDsl.g:5823:3: this_ListType_1= ruleListType
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
                    // InternalMappingDsl.g:5832:3: this_Enumeration_2= ruleEnumeration
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
    // InternalMappingDsl.g:5844:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalMappingDsl.g:5844:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalMappingDsl.g:5845:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalMappingDsl.g:5851:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) ;
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
            // InternalMappingDsl.g:5857:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) )
            // InternalMappingDsl.g:5858:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            {
            // InternalMappingDsl.g:5858:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            // InternalMappingDsl.g:5859:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalMappingDsl.g:5863:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5864:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5864:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5865:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_112); 

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

            // InternalMappingDsl.g:5881:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==72) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalMappingDsl.g:5882:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,72,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMappingDsl.g:5886:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:5887:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:5887:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:5888:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_113); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:5907:3: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==RULE_ID||LA144_0==73||(LA144_0>=75 && LA144_0<=84)) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // InternalMappingDsl.g:5908:4: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalMappingDsl.g:5908:4: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalMappingDsl.g:5909:5: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:5909:5: (lv_dataFields_5_0= ruleDataField )
                    // InternalMappingDsl.g:5910:6: lv_dataFields_5_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalMappingDsl.g:5927:4: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);

                        if ( (LA143_0==35) ) {
                            alt143=1;
                        }


                        switch (alt143) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5928:5: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,35,FOLLOW_114); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalMappingDsl.g:5932:5: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:5933:6: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:5933:6: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalMappingDsl.g:5934:7: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop143;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:5961:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalMappingDsl.g:5961:49: (iv_ruleListType= ruleListType EOF )
            // InternalMappingDsl.g:5962:2: iv_ruleListType= ruleListType EOF
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
    // InternalMappingDsl.g:5968:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalMappingDsl.g:5974:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalMappingDsl.g:5975:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalMappingDsl.g:5975:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt146=2;
            alt146 = dfa146.predict(input);
            switch (alt146) {
                case 1 :
                    // InternalMappingDsl.g:5976:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalMappingDsl.g:5976:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalMappingDsl.g:5977:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,57,FOLLOW_8); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalMappingDsl.g:5981:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalMappingDsl.g:5982:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5982:5: (lv_name_1_0= RULE_ID )
                    // InternalMappingDsl.g:5983:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

                    otherlv_2=(Token)match(input,18,FOLLOW_114); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalMappingDsl.g:6003:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalMappingDsl.g:6004:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:6004:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalMappingDsl.g:6005:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalMappingDsl.g:6022:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop145:
                    do {
                        int alt145=2;
                        int LA145_0 = input.LA(1);

                        if ( (LA145_0==35) ) {
                            alt145=1;
                        }


                        switch (alt145) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6023:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,35,FOLLOW_114); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalMappingDsl.g:6027:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:6028:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:6028:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalMappingDsl.g:6029:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop145;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6053:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:6053:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalMappingDsl.g:6054:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,57,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalMappingDsl.g:6058:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalMappingDsl.g:6059:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:6059:5: (lv_name_8_0= RULE_ID )
                    // InternalMappingDsl.g:6060:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

                    otherlv_9=(Token)match(input,18,FOLLOW_92); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalMappingDsl.g:6080:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:6081:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:6081:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalMappingDsl.g:6082:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_28);
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

                    otherlv_11=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:6108:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalMappingDsl.g:6108:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalMappingDsl.g:6109:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalMappingDsl.g:6115:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6121:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:6122:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:6122:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalMappingDsl.g:6123:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:6123:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==73) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalMappingDsl.g:6124:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalMappingDsl.g:6124:4: (lv_hidden_0_0= 'hide' )
                    // InternalMappingDsl.g:6125:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,73,FOLLOW_78); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:6137:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt148=3;
            int LA148_0 = input.LA(1);

            if ( ((LA148_0>=75 && LA148_0<=84)) ) {
                alt148=1;
            }
            else if ( (LA148_0==RULE_ID) ) {
                int LA148_2 = input.LA(2);

                if ( (LA148_2==RULE_ID||LA148_2==21||LA148_2==33) ) {
                    alt148=2;
                }
            }
            switch (alt148) {
                case 1 :
                    // InternalMappingDsl.g:6138:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:6138:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:6139:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:6139:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalMappingDsl.g:6140:6: lv_primitiveType_1_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_8);
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
                    // InternalMappingDsl.g:6158:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalMappingDsl.g:6158:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalMappingDsl.g:6159:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalMappingDsl.g:6159:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalMappingDsl.g:6160:6: lv_complexType_2_0= rulePossiblyImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
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

            // InternalMappingDsl.g:6178:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMappingDsl.g:6179:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMappingDsl.g:6179:4: (lv_name_3_0= RULE_ID )
            // InternalMappingDsl.g:6180:5: lv_name_3_0= RULE_ID
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
    // InternalMappingDsl.g:6200:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalMappingDsl.g:6200:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalMappingDsl.g:6201:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalMappingDsl.g:6207:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
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
            // InternalMappingDsl.g:6213:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalMappingDsl.g:6214:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalMappingDsl.g:6214:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalMappingDsl.g:6215:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalMappingDsl.g:6219:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6220:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6220:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6221:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:6241:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalMappingDsl.g:6242:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalMappingDsl.g:6242:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalMappingDsl.g:6243:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_61);
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

            // InternalMappingDsl.g:6260:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop149:
            do {
                int alt149=2;
                int LA149_0 = input.LA(1);

                if ( (LA149_0==35) ) {
                    alt149=1;
                }


                switch (alt149) {
            	case 1 :
            	    // InternalMappingDsl.g:6261:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,35,FOLLOW_8); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:6265:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalMappingDsl.g:6266:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalMappingDsl.g:6266:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalMappingDsl.g:6267:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_61);
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
            	    break loop149;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

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
    // InternalMappingDsl.g:6293:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalMappingDsl.g:6293:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalMappingDsl.g:6294:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalMappingDsl.g:6300:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6306:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalMappingDsl.g:6307:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalMappingDsl.g:6307:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalMappingDsl.g:6308:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalMappingDsl.g:6308:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:6309:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:6309:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:6310:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_80); 

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

            // InternalMappingDsl.g:6326:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==15) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalMappingDsl.g:6327:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_82); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalMappingDsl.g:6331:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:6332:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:6332:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:6333:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_9);
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
    // InternalMappingDsl.g:6359:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalMappingDsl.g:6359:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalMappingDsl.g:6360:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalMappingDsl.g:6366:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6372:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalMappingDsl.g:6373:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDsl.g:6373:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt151=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt151=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt151=2;
                }
                break;
            case RULE_STRING:
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
                    // InternalMappingDsl.g:6374:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalMappingDsl.g:6374:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalMappingDsl.g:6375:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalMappingDsl.g:6375:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalMappingDsl.g:6376:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalMappingDsl.g:6393:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalMappingDsl.g:6393:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:6394:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:6394:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:6395:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalMappingDsl.g:6412:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalMappingDsl.g:6412:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalMappingDsl.g:6413:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalMappingDsl.g:6413:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalMappingDsl.g:6414:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalMappingDsl.g:6434:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalMappingDsl.g:6434:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalMappingDsl.g:6435:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
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
    // InternalMappingDsl.g:6441:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6447:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:6448:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:6448:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:6449:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:6449:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==RULE_ID) ) {
                int LA152_1 = input.LA(2);

                if ( (LA152_1==21) ) {
                    alt152=1;
                }
            }
            switch (alt152) {
                case 1 :
                    // InternalMappingDsl.g:6450:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:6450:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:6451:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:6451:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:6452:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:6468:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:6469:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:6469:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:6470:5: ruleQualifiedName
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
    // InternalMappingDsl.g:6488:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalMappingDsl.g:6488:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalMappingDsl.g:6489:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalMappingDsl.g:6495:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalMappingDsl.g:6501:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalMappingDsl.g:6502:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalMappingDsl.g:6502:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt153=10;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt153=1;
                }
                break;
            case 76:
                {
                alt153=2;
                }
                break;
            case 77:
                {
                alt153=3;
                }
                break;
            case 78:
                {
                alt153=4;
                }
                break;
            case 79:
                {
                alt153=5;
                }
                break;
            case 80:
                {
                alt153=6;
                }
                break;
            case 81:
                {
                alt153=7;
                }
                break;
            case 82:
                {
                alt153=8;
                }
                break;
            case 83:
                {
                alt153=9;
                }
                break;
            case 84:
                {
                alt153=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalMappingDsl.g:6503:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalMappingDsl.g:6503:3: ( () otherlv_1= 'boolean' )
                    // InternalMappingDsl.g:6504:4: () otherlv_1= 'boolean'
                    {
                    // InternalMappingDsl.g:6504:4: ()
                    // InternalMappingDsl.g:6505:5: 
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
                    // InternalMappingDsl.g:6517:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalMappingDsl.g:6517:3: ( () otherlv_3= 'byte' )
                    // InternalMappingDsl.g:6518:4: () otherlv_3= 'byte'
                    {
                    // InternalMappingDsl.g:6518:4: ()
                    // InternalMappingDsl.g:6519:5: 
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
                    // InternalMappingDsl.g:6531:3: ( () otherlv_5= 'char' )
                    {
                    // InternalMappingDsl.g:6531:3: ( () otherlv_5= 'char' )
                    // InternalMappingDsl.g:6532:4: () otherlv_5= 'char'
                    {
                    // InternalMappingDsl.g:6532:4: ()
                    // InternalMappingDsl.g:6533:5: 
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
                    // InternalMappingDsl.g:6545:3: ( () otherlv_7= 'date' )
                    {
                    // InternalMappingDsl.g:6545:3: ( () otherlv_7= 'date' )
                    // InternalMappingDsl.g:6546:4: () otherlv_7= 'date'
                    {
                    // InternalMappingDsl.g:6546:4: ()
                    // InternalMappingDsl.g:6547:5: 
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
                    // InternalMappingDsl.g:6559:3: ( () otherlv_9= 'double' )
                    {
                    // InternalMappingDsl.g:6559:3: ( () otherlv_9= 'double' )
                    // InternalMappingDsl.g:6560:4: () otherlv_9= 'double'
                    {
                    // InternalMappingDsl.g:6560:4: ()
                    // InternalMappingDsl.g:6561:5: 
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
                    // InternalMappingDsl.g:6573:3: ( () otherlv_11= 'float' )
                    {
                    // InternalMappingDsl.g:6573:3: ( () otherlv_11= 'float' )
                    // InternalMappingDsl.g:6574:4: () otherlv_11= 'float'
                    {
                    // InternalMappingDsl.g:6574:4: ()
                    // InternalMappingDsl.g:6575:5: 
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
                    // InternalMappingDsl.g:6587:3: ( () otherlv_13= 'int' )
                    {
                    // InternalMappingDsl.g:6587:3: ( () otherlv_13= 'int' )
                    // InternalMappingDsl.g:6588:4: () otherlv_13= 'int'
                    {
                    // InternalMappingDsl.g:6588:4: ()
                    // InternalMappingDsl.g:6589:5: 
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
                    // InternalMappingDsl.g:6601:3: ( () otherlv_15= 'long' )
                    {
                    // InternalMappingDsl.g:6601:3: ( () otherlv_15= 'long' )
                    // InternalMappingDsl.g:6602:4: () otherlv_15= 'long'
                    {
                    // InternalMappingDsl.g:6602:4: ()
                    // InternalMappingDsl.g:6603:5: 
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
                    // InternalMappingDsl.g:6615:3: ( () otherlv_17= 'short' )
                    {
                    // InternalMappingDsl.g:6615:3: ( () otherlv_17= 'short' )
                    // InternalMappingDsl.g:6616:4: () otherlv_17= 'short'
                    {
                    // InternalMappingDsl.g:6616:4: ()
                    // InternalMappingDsl.g:6617:5: 
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
                    // InternalMappingDsl.g:6629:3: ( () otherlv_19= 'string' )
                    {
                    // InternalMappingDsl.g:6629:3: ( () otherlv_19= 'string' )
                    // InternalMappingDsl.g:6630:4: () otherlv_19= 'string'
                    {
                    // InternalMappingDsl.g:6630:4: ()
                    // InternalMappingDsl.g:6631:5: 
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
    // InternalMappingDsl.g:6646:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMappingDsl.g:6646:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMappingDsl.g:6647:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMappingDsl.g:6653:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6659:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMappingDsl.g:6660:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMappingDsl.g:6660:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMappingDsl.g:6661:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_115); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMappingDsl.g:6668:3: (kw= '.' this_ID_2= RULE_ID )*
            loop154:
            do {
                int alt154=2;
                int LA154_0 = input.LA(1);

                if ( (LA154_0==33) ) {
                    alt154=1;
                }


                switch (alt154) {
            	case 1 :
            	    // InternalMappingDsl.g:6669:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,33,FOLLOW_8); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_115); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop154;
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
    // InternalMappingDsl.g:6686:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6692:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalMappingDsl.g:6693:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalMappingDsl.g:6693:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==14) ) {
                alt155=1;
            }
            else if ( (LA155_0==42) ) {
                alt155=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 155, 0, input);

                throw nvae;
            }
            switch (alt155) {
                case 1 :
                    // InternalMappingDsl.g:6694:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalMappingDsl.g:6694:3: (enumLiteral_0= 'technology' )
                    // InternalMappingDsl.g:6695:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,14,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6702:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalMappingDsl.g:6702:3: (enumLiteral_1= 'microservices' )
                    // InternalMappingDsl.g:6703:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

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
    // InternalMappingDsl.g:6713:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6719:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalMappingDsl.g:6720:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalMappingDsl.g:6720:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt156=3;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt156=1;
                }
                break;
            case 86:
                {
                alt156=2;
                }
                break;
            case 87:
                {
                alt156=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 156, 0, input);

                throw nvae;
            }

            switch (alt156) {
                case 1 :
                    // InternalMappingDsl.g:6721:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalMappingDsl.g:6721:3: (enumLiteral_0= 'internal' )
                    // InternalMappingDsl.g:6722:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6729:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalMappingDsl.g:6729:3: (enumLiteral_1= 'architecture' )
                    // InternalMappingDsl.g:6730:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6737:3: (enumLiteral_2= 'public' )
                    {
                    // InternalMappingDsl.g:6737:3: (enumLiteral_2= 'public' )
                    // InternalMappingDsl.g:6738:4: enumLiteral_2= 'public'
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
    // InternalMappingDsl.g:6748:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6754:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalMappingDsl.g:6755:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:6755:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt157=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt157=1;
                }
                break;
            case 89:
                {
                alt157=2;
                }
                break;
            case 90:
                {
                alt157=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 157, 0, input);

                throw nvae;
            }

            switch (alt157) {
                case 1 :
                    // InternalMappingDsl.g:6756:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalMappingDsl.g:6756:3: (enumLiteral_0= 'functional' )
                    // InternalMappingDsl.g:6757:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6764:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalMappingDsl.g:6764:3: (enumLiteral_1= 'utility' )
                    // InternalMappingDsl.g:6765:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6772:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:6772:3: (enumLiteral_2= 'infrastructure' )
                    // InternalMappingDsl.g:6773:4: enumLiteral_2= 'infrastructure'
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
    // InternalMappingDsl.g:6783:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6789:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalMappingDsl.g:6790:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalMappingDsl.g:6790:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt158=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt158=1;
                }
                break;
            case 92:
                {
                alt158=2;
                }
                break;
            case 93:
                {
                alt158=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 158, 0, input);

                throw nvae;
            }

            switch (alt158) {
                case 1 :
                    // InternalMappingDsl.g:6791:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMappingDsl.g:6791:3: (enumLiteral_0= 'in' )
                    // InternalMappingDsl.g:6792:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6799:3: (enumLiteral_1= 'out' )
                    {
                    // InternalMappingDsl.g:6799:3: (enumLiteral_1= 'out' )
                    // InternalMappingDsl.g:6800:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6807:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalMappingDsl.g:6807:3: (enumLiteral_2= 'inout' )
                    // InternalMappingDsl.g:6808:4: enumLiteral_2= 'inout'
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
    // InternalMappingDsl.g:6818:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6824:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalMappingDsl.g:6825:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalMappingDsl.g:6825:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==94) ) {
                alt159=1;
            }
            else if ( (LA159_0==95) ) {
                alt159=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 159, 0, input);

                throw nvae;
            }
            switch (alt159) {
                case 1 :
                    // InternalMappingDsl.g:6826:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalMappingDsl.g:6826:3: (enumLiteral_0= 'sync' )
                    // InternalMappingDsl.g:6827:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6834:3: (enumLiteral_1= 'async' )
                    {
                    // InternalMappingDsl.g:6834:3: (enumLiteral_1= 'async' )
                    // InternalMappingDsl.g:6835:4: enumLiteral_1= 'async'
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
    // InternalMappingDsl.g:6845:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6851:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalMappingDsl.g:6852:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalMappingDsl.g:6852:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt160=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt160=1;
                }
                break;
            case 32:
                {
                alt160=2;
                }
                break;
            case 97:
                {
                alt160=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;
            }

            switch (alt160) {
                case 1 :
                    // InternalMappingDsl.g:6853:3: (enumLiteral_0= '<-' )
                    {
                    // InternalMappingDsl.g:6853:3: (enumLiteral_0= '<-' )
                    // InternalMappingDsl.g:6854:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6861:3: (enumLiteral_1= '->' )
                    {
                    // InternalMappingDsl.g:6861:3: (enumLiteral_1= '->' )
                    // InternalMappingDsl.g:6862:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6869:3: (enumLiteral_2= '<->' )
                    {
                    // InternalMappingDsl.g:6869:3: (enumLiteral_2= '<->' )
                    // InternalMappingDsl.g:6870:4: enumLiteral_2= '<->'
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
    // InternalMappingDsl.g:6880:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) ;
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
            // InternalMappingDsl.g:6886:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) )
            // InternalMappingDsl.g:6887:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            {
            // InternalMappingDsl.g:6887:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            int alt161=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt161=1;
                }
                break;
            case 43:
                {
                alt161=2;
                }
                break;
            case 44:
                {
                alt161=3;
                }
                break;
            case 26:
                {
                alt161=4;
                }
                break;
            case 98:
                {
                alt161=5;
                }
                break;
            case 99:
                {
                alt161=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 161, 0, input);

                throw nvae;
            }

            switch (alt161) {
                case 1 :
                    // InternalMappingDsl.g:6888:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalMappingDsl.g:6888:3: (enumLiteral_0= 'microservices' )
                    // InternalMappingDsl.g:6889:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6896:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalMappingDsl.g:6896:3: (enumLiteral_1= 'interfaces' )
                    // InternalMappingDsl.g:6897:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:6904:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalMappingDsl.g:6904:3: (enumLiteral_2= 'operations' )
                    // InternalMappingDsl.g:6905:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:6912:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalMappingDsl.g:6912:3: (enumLiteral_3= 'parameters' )
                    // InternalMappingDsl.g:6913:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:6920:3: (enumLiteral_4= 'types' )
                    {
                    // InternalMappingDsl.g:6920:3: (enumLiteral_4= 'types' )
                    // InternalMappingDsl.g:6921:4: enumLiteral_4= 'types'
                    {
                    enumLiteral_4=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:6928:3: (enumLiteral_5= 'fields' )
                    {
                    // InternalMappingDsl.g:6928:3: (enumLiteral_5= 'fields' )
                    // InternalMappingDsl.g:6929:4: enumLiteral_5= 'fields'
                    {
                    enumLiteral_5=(Token)match(input,99,FOLLOW_2); 

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
    // InternalMappingDsl.g:6939:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6945:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalMappingDsl.g:6946:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:6946:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==100) ) {
                alt162=1;
            }
            else if ( (LA162_0==90) ) {
                alt162=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 162, 0, input);

                throw nvae;
            }
            switch (alt162) {
                case 1 :
                    // InternalMappingDsl.g:6947:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalMappingDsl.g:6947:3: (enumLiteral_0= 'containers' )
                    // InternalMappingDsl.g:6948:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6955:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:6955:3: (enumLiteral_1= 'infrastructure' )
                    // InternalMappingDsl.g:6956:4: enumLiteral_1= 'infrastructure'
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


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA146 dfa146 = new DFA146(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\1\15\1\16\1\17\1\4\1\20\1\4\2\uffff";
    static final String dfa_3s = "\1\15\1\16\1\17\1\4\1\20\1\21\2\uffff";
    static final String dfa_4s = "\6\uffff\1\2\1\1";
    static final String dfa_5s = "\10\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\6\10\uffff\1\1\3\uffff\1\7",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 99:3: ( (lv_typeMappings_1_0= ruleComplexTypeMapping ) )*";
        }
    }
    static final String dfa_7s = "\111\uffff";
    static final String dfa_8s = "\2\4\2\uffff\2\17\1\25\1\17\3\4\1\25\1\4\1\25\5\4\1\20\1\4\3\20\1\61\1\35\4\4\1\5\3\4\1\5\2\20\1\4\3\20\2\35\1\25\1\36\2\17\2\4\1\5\2\4\1\61\1\35\1\36\1\4\1\25\1\5\3\4\3\20\2\35\1\20\3\4\2\20\1\4";
    static final String dfa_9s = "\1\127\1\137\2\uffff\2\17\1\25\1\17\3\4\1\25\1\127\1\25\2\4\1\7\2\4\1\42\1\127\3\20\1\61\1\43\2\4\2\127\1\7\3\4\1\5\1\42\1\20\1\137\5\43\1\25\1\43\2\17\2\4\1\5\1\20\1\4\1\61\2\43\1\127\1\25\1\7\3\4\5\43\1\42\2\4\1\127\1\42\1\20\1\27";
    static final String dfa_10s = "\2\uffff\1\2\1\1\105\uffff";
    static final String dfa_11s = "\111\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\10\uffff\1\1\6\uffff\1\2\30\uffff\1\2\1\3\46\uffff\3\2",
            "\1\6\22\uffff\1\7\106\uffff\1\4\1\5",
            "",
            "",
            "\1\10",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\2\10\uffff\1\21\1\uffff\1\20\21\uffff\1\17\13\uffff\1\2\1\3\46\uffff\3\2",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\30\1\27\1\25\1\26",
            "\1\6",
            "\1\31",
            "\1\34\20\uffff\1\32\1\33",
            "\1\2\10\uffff\1\21\1\uffff\1\20\21\uffff\1\17\13\uffff\1\2\1\3\46\uffff\3\2",
            "\1\35",
            "\1\35",
            "\1\35",
            "\1\36",
            "\1\42\3\uffff\1\37\1\40\1\41",
            "\1\43",
            "\1\44",
            "\1\2\10\uffff\1\45\37\uffff\1\2\1\3\46\uffff\3\2",
            "\1\2\10\uffff\1\21\37\uffff\1\2\1\3\46\uffff\3\2",
            "\1\50\1\46\1\47",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\34\20\uffff\1\32\1\33",
            "\1\34",
            "\1\6\22\uffff\1\7\106\uffff\1\55\1\56",
            "\1\35\22\uffff\1\57",
            "\1\35\22\uffff\1\57",
            "\1\35\22\uffff\1\57",
            "\1\42\3\uffff\1\37\1\40\1\41",
            "\1\42\5\uffff\1\41",
            "\1\60",
            "\1\62\4\uffff\1\61",
            "\1\63",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\15\13\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\42\3\uffff\1\72\1\73\1\41",
            "\1\62\4\uffff\1\61",
            "\1\2\10\uffff\1\21\37\uffff\1\2\1\3\46\uffff\3\2",
            "\1\74",
            "\1\77\1\75\1\76",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\35\22\uffff\1\57",
            "\1\35\22\uffff\1\57",
            "\1\35\22\uffff\1\57",
            "\1\42\3\uffff\1\72\1\73\1\41",
            "\1\42\5\uffff\1\41",
            "\1\105\20\uffff\1\103\1\104",
            "\1\106",
            "\1\107",
            "\1\2\10\uffff\1\110\37\uffff\1\2\1\3\46\uffff\3\2",
            "\1\105\20\uffff\1\103\1\104",
            "\1\105",
            "\1\6\22\uffff\1\7"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()* loopback of 2856:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_13s = "\20\uffff";
    static final String dfa_14s = "\1\71\1\4\1\22\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_15s = "\1\71\1\4\1\22\1\124\1\uffff\12\24\1\uffff";
    static final String dfa_16s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_17s = "\20\uffff}>";
    static final String[] dfa_18s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\104\uffff\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
            "",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            "\1\4\17\uffff\1\17",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA146 extends DFA {

        public DFA146(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 146;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "5975:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000001000002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000200180010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000200100010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000BD80000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000100000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000B980000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000000B180000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000000B100000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000000A100000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000D80000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000980000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000004D80000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000004980000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000004180000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000090100000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000060040000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000160040000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000200080010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000820000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000040000004000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000002000L,0x0000000007E00000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000220001002000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000220001102000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000200001002000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000001000000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000600000102010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000200000102010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000200000002010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000010L,0x0000000000E00000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000800012000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000002000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000400000002000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000800000000010L,0x0000000038000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0001000020000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000010L,0x00000000001FF800L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0010000840000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0080000040000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x00000000001FF800L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000900000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x1000000000100000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000100000L,0x00000000001FF800L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x4002000040000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000038000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x00001C0004000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000840040000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000100000L,0x00000000001FF808L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000001004000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0600000000100000L,0x0000000000000480L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0600000000100000L,0x0000000000000400L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000080L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0600000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000100L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000100010L,0x00000000001FFA00L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000010L,0x00000000001FFA00L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000200000002L});

}