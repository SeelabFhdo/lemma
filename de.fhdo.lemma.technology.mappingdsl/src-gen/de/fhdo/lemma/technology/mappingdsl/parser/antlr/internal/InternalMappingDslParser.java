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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BOOLEAN", "RULE_BIG_DECIMAL", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'type'", "'{'", "'aspects'", "'}'", "'::'", "'protocols'", "'endpoints'", "'interface'", "'operation'", "'parameters'", "'referred'", "'primitive'", "':'", "';'", "'complex'", "'->'", "'.'", "'op'", "'return'", "'/'", "','", "'('", "')'", "'import'", "'from'", "'as'", "'@'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'technology'", "'typedef'", "'='", "'noimpl'", "'---'", "'@param'", "'@required'", "'refers'", "'fault'", "'?'", "'<'", "'>'", "'-'", "'--'", "'types'", "'compatibility'", "'matrix'", "'service'", "'deployment'", "'technologies'", "'infrastructure'", "'data'", "'formats'", "'default'", "'with'", "'format'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'based'", "'on'", "'list'", "'structure'", "'<-'", "'<->'", "'environments'", "'properties'", "'mandatory'", "'singleval'", "'fields'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'aspect'", "'for'", "'containers'", "'selector'", "'datatypes'", "'context'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'extends'", "'identifier'", "'neverEmpty'", "'part'", "'hide'", "'immutable'", "'enum'", "'closure'", "'sideEffectFree'", "'validator'", "'function'", "'procedure'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'param'", "'functional'", "'utility'", "'unspecified'", "'domainOperations'", "'domainParameters'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=9;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
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
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int RULE_BIG_DECIMAL=7;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=8;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
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

                if ( (LA3_0==RULE_ID||LA3_0==39) ) {
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
    // InternalMappingDsl.g:148:1: ruleComplexTypeMapping returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexTypeToMap ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* ( (lv_operationMappings_9_0= ruleDataOperationMapping ) )* otherlv_10= '}' ) ;
    public final EObject ruleComplexTypeMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_technologyReferences_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_aspects_6_0 = null;

        EObject lv_fieldMappings_8_0 = null;

        EObject lv_operationMappings_9_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:154:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexTypeToMap ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* ( (lv_operationMappings_9_0= ruleDataOperationMapping ) )* otherlv_10= '}' ) )
            // InternalMappingDsl.g:155:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexTypeToMap ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* ( (lv_operationMappings_9_0= ruleDataOperationMapping ) )* otherlv_10= '}' )
            {
            // InternalMappingDsl.g:155:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexTypeToMap ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* ( (lv_operationMappings_9_0= ruleDataOperationMapping ) )* otherlv_10= '}' )
            // InternalMappingDsl.g:156:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* otherlv_1= 'type' ( (lv_type_2_0= ruleImportedComplexTypeToMap ) ) otherlv_3= '{' (otherlv_4= 'aspects' otherlv_5= '{' ( (lv_aspects_6_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_7= '}' )? ( (lv_fieldMappings_8_0= ruleTechnologySpecificFieldMapping ) )* ( (lv_operationMappings_9_0= ruleDataOperationMapping ) )* otherlv_10= '}'
            {
            // InternalMappingDsl.g:156:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==39) ) {
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
            		
            // InternalMappingDsl.g:179:3: ( (lv_type_2_0= ruleImportedComplexTypeToMap ) )
            // InternalMappingDsl.g:180:4: (lv_type_2_0= ruleImportedComplexTypeToMap )
            {
            // InternalMappingDsl.g:180:4: (lv_type_2_0= ruleImportedComplexTypeToMap )
            // InternalMappingDsl.g:181:5: lv_type_2_0= ruleImportedComplexTypeToMap
            {

            					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getTypeImportedComplexTypeToMapParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_2_0=ruleImportedComplexTypeToMap();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.ImportedComplexTypeToMap");
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

            // InternalMappingDsl.g:254:3: ( (lv_operationMappings_9_0= ruleDataOperationMapping ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==30) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMappingDsl.g:255:4: (lv_operationMappings_9_0= ruleDataOperationMapping )
            	    {
            	    // InternalMappingDsl.g:255:4: (lv_operationMappings_9_0= ruleDataOperationMapping )
            	    // InternalMappingDsl.g:256:5: lv_operationMappings_9_0= ruleDataOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getComplexTypeMappingAccess().getOperationMappingsDataOperationMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_operationMappings_9_0=ruleDataOperationMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComplexTypeMappingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operationMappings",
            	    						lv_operationMappings_9_0,
            	    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.DataOperationMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_10=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getComplexTypeMappingAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleImportedComplexTypeToMap"
    // InternalMappingDsl.g:281:1: entryRuleImportedComplexTypeToMap returns [EObject current=null] : iv_ruleImportedComplexTypeToMap= ruleImportedComplexTypeToMap EOF ;
    public final EObject entryRuleImportedComplexTypeToMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexTypeToMap = null;


        try {
            // InternalMappingDsl.g:281:65: (iv_ruleImportedComplexTypeToMap= ruleImportedComplexTypeToMap EOF )
            // InternalMappingDsl.g:282:2: iv_ruleImportedComplexTypeToMap= ruleImportedComplexTypeToMap EOF
            {
             newCompositeNode(grammarAccess.getImportedComplexTypeToMapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedComplexTypeToMap=ruleImportedComplexTypeToMap();

            state._fsp--;

             current =iv_ruleImportedComplexTypeToMap; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedComplexTypeToMap"


    // $ANTLR start "ruleImportedComplexTypeToMap"
    // InternalMappingDsl.g:288:1: ruleImportedComplexTypeToMap returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexTypeToMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:294:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:295:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:295:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:296:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:296:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:297:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:297:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:298:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeToMapRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeToMapAccess().getServiceModelImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeToMapAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:313:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:314:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:314:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:315:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeToMapRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_2, grammarAccess.getImportedComplexTypeToMapAccess().getDataModelImportImportCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getImportedComplexTypeToMapAccess().getColonColonKeyword_3());
            		
            // InternalMappingDsl.g:330:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:331:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:331:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:332:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeToMapRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedComplexTypeToMapAccess().getTypeComplexTypeCrossReference_4_0());
            				
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
    // $ANTLR end "ruleImportedComplexTypeToMap"


    // $ANTLR start "entryRuleMicroserviceMapping"
    // InternalMappingDsl.g:350:1: entryRuleMicroserviceMapping returns [EObject current=null] : iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF ;
    public final EObject entryRuleMicroserviceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroserviceMapping = null;


        try {
            // InternalMappingDsl.g:350:60: (iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF )
            // InternalMappingDsl.g:351:2: iv_ruleMicroserviceMapping= ruleMicroserviceMapping EOF
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
    // InternalMappingDsl.g:357:1: ruleMicroserviceMapping returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' ) ;
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
            // InternalMappingDsl.g:363:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' ) )
            // InternalMappingDsl.g:364:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' )
            {
            // InternalMappingDsl.g:364:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}' )
            // InternalMappingDsl.g:365:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( (lv_microservice_1_0= ruleImportedMicroservice ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )* ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )* ( (lv_operationMappings_17_0= ruleOperationMapping ) )* otherlv_18= '}'
            {
            // InternalMappingDsl.g:365:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==39) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMappingDsl.g:366:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalMappingDsl.g:366:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalMappingDsl.g:367:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_14);
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
            	    break loop9;
                }
            } while (true);

            // InternalMappingDsl.g:384:3: ( (lv_microservice_1_0= ruleImportedMicroservice ) )
            // InternalMappingDsl.g:385:4: (lv_microservice_1_0= ruleImportedMicroservice )
            {
            // InternalMappingDsl.g:385:4: (lv_microservice_1_0= ruleImportedMicroservice )
            // InternalMappingDsl.g:386:5: lv_microservice_1_0= ruleImportedMicroservice
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

            otherlv_2=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:407:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMappingDsl.g:408:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_16); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:416:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=75 && LA10_0<=76)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalMappingDsl.g:417:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:417:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:418:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
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
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:440:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMappingDsl.g:441:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )* otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_10); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:449:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalMappingDsl.g:450:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:450:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:451:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_19); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:473:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMappingDsl.g:474:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:482:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:483:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:483:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:484:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
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
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_20); 

                    				newLeafNode(otherlv_14, grammarAccess.getMicroserviceMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:506:3: ( (lv_interfaceMappings_15_0= ruleInterfaceMapping ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==20) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMappingDsl.g:507:4: (lv_interfaceMappings_15_0= ruleInterfaceMapping )
            	    {
            	    // InternalMappingDsl.g:507:4: (lv_interfaceMappings_15_0= ruleInterfaceMapping )
            	    // InternalMappingDsl.g:508:5: lv_interfaceMappings_15_0= ruleInterfaceMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getInterfaceMappingsInterfaceMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_20);
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
            	    break loop16;
                }
            } while (true);

            // InternalMappingDsl.g:525:3: ( (lv_referredOperationMappings_16_0= ruleReferredOperationMapping ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==23) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMappingDsl.g:526:4: (lv_referredOperationMappings_16_0= ruleReferredOperationMapping )
            	    {
            	    // InternalMappingDsl.g:526:4: (lv_referredOperationMappings_16_0= ruleReferredOperationMapping )
            	    // InternalMappingDsl.g:527:5: lv_referredOperationMappings_16_0= ruleReferredOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getReferredOperationMappingsReferredOperationMappingParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_21);
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
            	    break loop17;
                }
            } while (true);

            // InternalMappingDsl.g:544:3: ( (lv_operationMappings_17_0= ruleOperationMapping ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==21) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMappingDsl.g:545:4: (lv_operationMappings_17_0= ruleOperationMapping )
            	    {
            	    // InternalMappingDsl.g:545:4: (lv_operationMappings_17_0= ruleOperationMapping )
            	    // InternalMappingDsl.g:546:5: lv_operationMappings_17_0= ruleOperationMapping
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceMappingAccess().getOperationMappingsOperationMappingParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_22);
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
            	    break loop18;
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
    // InternalMappingDsl.g:571:1: entryRuleInterfaceMapping returns [EObject current=null] : iv_ruleInterfaceMapping= ruleInterfaceMapping EOF ;
    public final EObject entryRuleInterfaceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceMapping = null;


        try {
            // InternalMappingDsl.g:571:57: (iv_ruleInterfaceMapping= ruleInterfaceMapping EOF )
            // InternalMappingDsl.g:572:2: iv_ruleInterfaceMapping= ruleInterfaceMapping EOF
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
    // InternalMappingDsl.g:578:1: ruleInterfaceMapping returns [EObject current=null] : (otherlv_0= 'interface' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) ;
    public final EObject ruleInterfaceMapping() throws RecognitionException {
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
        EObject lv_protocols_5_0 = null;

        EObject lv_endpoints_9_0 = null;

        EObject lv_aspects_13_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:584:2: ( (otherlv_0= 'interface' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalMappingDsl.g:585:2: (otherlv_0= 'interface' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalMappingDsl.g:585:2: (otherlv_0= 'interface' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}' )
            // InternalMappingDsl.g:586:3: otherlv_0= 'interface' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getInterfaceMappingAccess().getInterfaceKeyword_0());
            		
            // InternalMappingDsl.g:590:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:591:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:591:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:592:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceMappingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInterfaceMappingAccess().getInterfaceInterfaceCrossReference_1_0());
            				
            pushFollow(FOLLOW_8);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:610:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==18) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMappingDsl.g:611:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_16); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:619:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=75 && LA19_0<=76)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalMappingDsl.g:620:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:620:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:621:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
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
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:643:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMappingDsl.g:644:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:652:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
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
                    	    // InternalMappingDsl.g:653:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:653:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:654:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
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
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_10, grammarAccess.getInterfaceMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:676:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==15) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMappingDsl.g:677:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:685:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:686:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:686:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:687:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
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
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_26); 

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
    // InternalMappingDsl.g:717:1: entryRuleOperationMapping returns [EObject current=null] : iv_ruleOperationMapping= ruleOperationMapping EOF ;
    public final EObject entryRuleOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationMapping = null;


        try {
            // InternalMappingDsl.g:717:57: (iv_ruleOperationMapping= ruleOperationMapping EOF )
            // InternalMappingDsl.g:718:2: iv_ruleOperationMapping= ruleOperationMapping EOF
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
    // InternalMappingDsl.g:724:1: ruleOperationMapping returns [EObject current=null] : (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' ) ;
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
            // InternalMappingDsl.g:730:2: ( (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' ) )
            // InternalMappingDsl.g:731:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' )
            {
            // InternalMappingDsl.g:731:2: (otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}' )
            // InternalMappingDsl.g:732:3: otherlv_0= 'operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )? (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )? (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )? (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationMappingAccess().getOperationKeyword_0());
            		
            // InternalMappingDsl.g:736:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:737:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:737:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:738:5: ruleQualifiedName
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

            otherlv_2=(Token)match(input,14,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:756:3: (otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==18) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMappingDsl.g:757:4: otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationMappingAccess().getProtocolsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_16); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMappingDsl.g:765:4: ( (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=75 && LA25_0<=76)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalMappingDsl.g:766:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:766:5: (lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:767:6: lv_protocols_5_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
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
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_28); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:789:3: (otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==19) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMappingDsl.g:790:4: otherlv_7= 'endpoints' otherlv_8= '{' ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationMappingAccess().getEndpointsKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:798:4: ( (lv_endpoints_9_0= ruleTechnologySpecificEndpoint ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_ID) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalMappingDsl.g:799:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:799:5: (lv_endpoints_9_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:800:6: lv_endpoints_9_0= ruleTechnologySpecificEndpoint
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
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_29); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:822:3: (otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==15) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMappingDsl.g:823:4: otherlv_11= 'aspects' otherlv_12= '{' ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getOperationMappingAccess().getAspectsKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:831:4: ( (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_ID) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalMappingDsl.g:832:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:832:5: (lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:833:6: lv_aspects_13_0= ruleTechnologySpecificImportedServiceAspect
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
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_30); 

                    				newLeafNode(otherlv_14, grammarAccess.getOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:855:3: (otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==22) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMappingDsl.g:856:4: otherlv_15= 'parameters' otherlv_16= '{' ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,22,FOLLOW_8); 

                    				newLeafNode(otherlv_15, grammarAccess.getOperationMappingAccess().getParametersKeyword_6_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_31); 

                    				newLeafNode(otherlv_16, grammarAccess.getOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:864:4: ( ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==24||LA32_0==27) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalMappingDsl.g:865:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    	    {
                    	    // InternalMappingDsl.g:865:5: ( (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping ) )
                    	    // InternalMappingDsl.g:866:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    	    {
                    	    // InternalMappingDsl.g:866:6: (lv_parameterMappings_17_1= rulePrimitiveParameterMapping | lv_parameterMappings_17_2= ruleComplexParameterMapping )
                    	    int alt31=2;
                    	    int LA31_0 = input.LA(1);

                    	    if ( (LA31_0==24) ) {
                    	        alt31=1;
                    	    }
                    	    else if ( (LA31_0==27) ) {
                    	        alt31=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 31, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt31) {
                    	        case 1 :
                    	            // InternalMappingDsl.g:867:7: lv_parameterMappings_17_1= rulePrimitiveParameterMapping
                    	            {

                    	            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsPrimitiveParameterMappingParserRuleCall_6_2_0_0());
                    	            						
                    	            pushFollow(FOLLOW_32);
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
                    	            // InternalMappingDsl.g:883:7: lv_parameterMappings_17_2= ruleComplexParameterMapping
                    	            {

                    	            							newCompositeNode(grammarAccess.getOperationMappingAccess().getParameterMappingsComplexParameterMappingParserRuleCall_6_2_0_1());
                    	            						
                    	            pushFollow(FOLLOW_32);
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
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);

                    otherlv_18=(Token)match(input,16,FOLLOW_26); 

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
    // InternalMappingDsl.g:914:1: entryRuleReferredOperationMapping returns [EObject current=null] : iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF ;
    public final EObject entryRuleReferredOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperationMapping = null;


        try {
            // InternalMappingDsl.g:914:65: (iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF )
            // InternalMappingDsl.g:915:2: iv_ruleReferredOperationMapping= ruleReferredOperationMapping EOF
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
    // InternalMappingDsl.g:921:1: ruleReferredOperationMapping returns [EObject current=null] : (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) ;
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
            // InternalMappingDsl.g:927:2: ( (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' ) )
            // InternalMappingDsl.g:928:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            {
            // InternalMappingDsl.g:928:2: (otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}' )
            // InternalMappingDsl.g:929:3: otherlv_0= 'referred' otherlv_1= 'operation' ( ( ruleQualifiedName ) ) otherlv_3= '{' (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )? (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )? (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getReferredOperationMappingAccess().getReferredKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getReferredOperationMappingAccess().getOperationKeyword_1());
            		
            // InternalMappingDsl.g:937:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:938:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:938:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:939:5: ruleQualifiedName
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

            otherlv_3=(Token)match(input,14,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMappingDsl.g:957:3: (otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==18) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMappingDsl.g:958:4: otherlv_4= 'protocols' otherlv_5= '{' ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+ otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationMappingAccess().getProtocolsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,14,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMappingDsl.g:966:4: ( (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification ) )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( ((LA34_0>=75 && LA34_0<=76)) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalMappingDsl.g:967:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    {
                    	    // InternalMappingDsl.g:967:5: (lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification )
                    	    // InternalMappingDsl.g:968:6: lv_protocols_6_0= ruleTechnologySpecificProtocolSpecification
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationMappingAccess().getProtocolsTechnologySpecificProtocolSpecificationParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
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
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    otherlv_7=(Token)match(input,16,FOLLOW_24); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:990:3: (otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==19) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMappingDsl.g:991:4: otherlv_8= 'endpoints' otherlv_9= '{' ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationMappingAccess().getEndpointsKeyword_5_0());
                    			
                    otherlv_9=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMappingDsl.g:999:4: ( (lv_endpoints_10_0= ruleTechnologySpecificEndpoint ) )+
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
                    	    // InternalMappingDsl.g:1000:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:1000:5: (lv_endpoints_10_0= ruleTechnologySpecificEndpoint )
                    	    // InternalMappingDsl.g:1001:6: lv_endpoints_10_0= ruleTechnologySpecificEndpoint
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
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationMappingAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:1023:3: (otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==15) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMappingDsl.g:1024:4: otherlv_12= 'aspects' otherlv_13= '{' ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_12, grammarAccess.getReferredOperationMappingAccess().getAspectsKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getReferredOperationMappingAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalMappingDsl.g:1032:4: ( (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:1033:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1033:5: (lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1034:6: lv_aspects_14_0= ruleTechnologySpecificImportedServiceAspect
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
                    	    if ( cnt38 >= 1 ) break loop38;
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);

                    otherlv_15=(Token)match(input,16,FOLLOW_26); 

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
    // InternalMappingDsl.g:1064:1: entryRulePrimitiveParameterMapping returns [EObject current=null] : iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF ;
    public final EObject entryRulePrimitiveParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveParameterMapping = null;


        try {
            // InternalMappingDsl.g:1064:66: (iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF )
            // InternalMappingDsl.g:1065:2: iv_rulePrimitiveParameterMapping= rulePrimitiveParameterMapping EOF
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
    // InternalMappingDsl.g:1071:1: rulePrimitiveParameterMapping returns [EObject current=null] : (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
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
            // InternalMappingDsl.g:1077:2: ( (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) )
            // InternalMappingDsl.g:1078:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
            {
            // InternalMappingDsl.g:1078:2: (otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
            // InternalMappingDsl.g:1079:3: otherlv_0= 'primitive' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveKeyword_0());
            		
            // InternalMappingDsl.g:1083:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1084:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1084:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1085:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(otherlv_1, grammarAccess.getPrimitiveParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1096:3: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==25) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMappingDsl.g:1097:4: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimitiveParameterMappingAccess().getColonKeyword_2_0());
                    			
                    // InternalMappingDsl.g:1101:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:1102:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:1102:5: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:1103:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_3, grammarAccess.getPrimitiveParameterMappingAccess().getTechnologyImportCrossReference_2_1_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimitiveParameterMappingAccess().getColonColonKeyword_2_2());
                    			
                    // InternalMappingDsl.g:1118:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:1119:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:1119:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:1120:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimitiveParameterMappingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPrimitiveParameterMappingAccess().getPrimitiveTypeTechnologySpecificPrimitiveTypeCrossReference_2_3_0());
                    					
                    pushFollow(FOLLOW_35);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:1135:3: ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==14) ) {
                alt42=1;
            }
            else if ( (LA42_0==26) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalMappingDsl.g:1136:4: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:1136:4: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                    // InternalMappingDsl.g:1137:5: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_36); 

                    					newLeafNode(otherlv_6, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0_0());
                    				
                    otherlv_7=(Token)match(input,15,FOLLOW_8); 

                    					newLeafNode(otherlv_7, grammarAccess.getPrimitiveParameterMappingAccess().getAspectsKeyword_3_0_1());
                    				
                    otherlv_8=(Token)match(input,14,FOLLOW_7); 

                    					newLeafNode(otherlv_8, grammarAccess.getPrimitiveParameterMappingAccess().getLeftCurlyBracketKeyword_3_0_2());
                    				
                    // InternalMappingDsl.g:1149:5: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
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
                    	    // InternalMappingDsl.g:1150:6: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1150:6: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1151:7: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
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
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_26); 

                    					newLeafNode(otherlv_10, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_0_4());
                    				
                    otherlv_11=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_11, grammarAccess.getPrimitiveParameterMappingAccess().getRightCurlyBracketKeyword_3_0_5());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1178:4: otherlv_12= ';'
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
    // InternalMappingDsl.g:1187:1: entryRuleComplexParameterMapping returns [EObject current=null] : iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF ;
    public final EObject entryRuleComplexParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexParameterMapping = null;


        try {
            // InternalMappingDsl.g:1187:64: (iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF )
            // InternalMappingDsl.g:1188:2: iv_ruleComplexParameterMapping= ruleComplexParameterMapping EOF
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
    // InternalMappingDsl.g:1194:1: ruleComplexParameterMapping returns [EObject current=null] : (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) ) ;
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
            // InternalMappingDsl.g:1200:2: ( (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) ) )
            // InternalMappingDsl.g:1201:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) )
            {
            // InternalMappingDsl.g:1201:2: (otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) ) )
            // InternalMappingDsl.g:1202:3: otherlv_0= 'complex' ( (otherlv_1= RULE_ID ) ) ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexParameterMappingAccess().getComplexKeyword_0());
            		
            // InternalMappingDsl.g:1206:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1207:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1207:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1208:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexParameterMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_1, grammarAccess.getComplexParameterMappingAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1219:3: ( ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) ) | (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==14||(LA49_0>=25 && LA49_0<=26)) ) {
                alt49=1;
            }
            else if ( (LA49_0==28) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalMappingDsl.g:1220:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
                    {
                    // InternalMappingDsl.g:1220:4: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' ) )
                    // InternalMappingDsl.g:1221:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
                    {
                    // InternalMappingDsl.g:1221:5: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==25) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalMappingDsl.g:1222:6: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) otherlv_4= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_2=(Token)match(input,25,FOLLOW_7); 

                            						newLeafNode(otherlv_2, grammarAccess.getComplexParameterMappingAccess().getColonKeyword_2_0_0_0());
                            					
                            // InternalMappingDsl.g:1226:6: ( (otherlv_3= RULE_ID ) )
                            // InternalMappingDsl.g:1227:7: (otherlv_3= RULE_ID )
                            {
                            // InternalMappingDsl.g:1227:7: (otherlv_3= RULE_ID )
                            // InternalMappingDsl.g:1228:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_13); 

                            								newLeafNode(otherlv_3, grammarAccess.getComplexParameterMappingAccess().getTechnologyImportCrossReference_2_0_0_1_0());
                            							

                            }


                            }

                            otherlv_4=(Token)match(input,17,FOLLOW_7); 

                            						newLeafNode(otherlv_4, grammarAccess.getComplexParameterMappingAccess().getColonColonKeyword_2_0_0_2());
                            					
                            // InternalMappingDsl.g:1243:6: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1244:7: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1244:7: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1245:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getComplexParameterMappingRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getTechnologySpecificComplexTypeComplexTypeCrossReference_2_0_0_3_0());
                            							
                            pushFollow(FOLLOW_35);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1260:5: ( (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' ) | otherlv_12= ';' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==14) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==26) ) {
                        alt45=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalMappingDsl.g:1261:6: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                            {
                            // InternalMappingDsl.g:1261:6: (otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}' )
                            // InternalMappingDsl.g:1262:7: otherlv_6= '{' otherlv_7= 'aspects' otherlv_8= '{' ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_10= '}' otherlv_11= '}'
                            {
                            otherlv_6=(Token)match(input,14,FOLLOW_36); 

                            							newLeafNode(otherlv_6, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0_0());
                            						
                            otherlv_7=(Token)match(input,15,FOLLOW_8); 

                            							newLeafNode(otherlv_7, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_0_1_0_1());
                            						
                            otherlv_8=(Token)match(input,14,FOLLOW_7); 

                            							newLeafNode(otherlv_8, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_1_0_2());
                            						
                            // InternalMappingDsl.g:1274:7: ( (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt44=0;
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==RULE_ID) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1275:8: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1275:8: (lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1276:9: lv_aspects_9_0= ruleTechnologySpecificImportedServiceAspect
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
                            	    if ( cnt44 >= 1 ) break loop44;
                                        EarlyExitException eee =
                                            new EarlyExitException(44, input);
                                        throw eee;
                                }
                                cnt44++;
                            } while (true);

                            otherlv_10=(Token)match(input,16,FOLLOW_26); 

                            							newLeafNode(otherlv_10, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_0_4());
                            						
                            otherlv_11=(Token)match(input,16,FOLLOW_2); 

                            							newLeafNode(otherlv_11, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_0_1_0_5());
                            						

                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1303:6: otherlv_12= ';'
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
                    // InternalMappingDsl.g:1310:4: (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' )
                    {
                    // InternalMappingDsl.g:1310:4: (otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}' )
                    // InternalMappingDsl.g:1311:5: otherlv_13= '->' otherlv_14= '{' (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )? ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+ otherlv_20= '}'
                    {
                    otherlv_13=(Token)match(input,28,FOLLOW_8); 

                    					newLeafNode(otherlv_13, grammarAccess.getComplexParameterMappingAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
                    				
                    otherlv_14=(Token)match(input,14,FOLLOW_38); 

                    					newLeafNode(otherlv_14, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_1());
                    				
                    // InternalMappingDsl.g:1319:5: (otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}' )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==15) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalMappingDsl.g:1320:6: otherlv_15= 'aspects' otherlv_16= '{' ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_18= '}'
                            {
                            otherlv_15=(Token)match(input,15,FOLLOW_8); 

                            						newLeafNode(otherlv_15, grammarAccess.getComplexParameterMappingAccess().getAspectsKeyword_2_1_2_0());
                            					
                            otherlv_16=(Token)match(input,14,FOLLOW_7); 

                            						newLeafNode(otherlv_16, grammarAccess.getComplexParameterMappingAccess().getLeftCurlyBracketKeyword_2_1_2_1());
                            					
                            // InternalMappingDsl.g:1328:6: ( (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt46=0;
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==RULE_ID) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1329:7: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1329:7: (lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1330:8: lv_aspects_17_0= ruleTechnologySpecificImportedServiceAspect
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
                            	    if ( cnt46 >= 1 ) break loop46;
                                        EarlyExitException eee =
                                            new EarlyExitException(46, input);
                                        throw eee;
                                }
                                cnt46++;
                            } while (true);

                            otherlv_18=(Token)match(input,16,FOLLOW_39); 

                            						newLeafNode(otherlv_18, grammarAccess.getComplexParameterMappingAccess().getRightCurlyBracketKeyword_2_1_2_3());
                            					

                            }
                            break;

                    }

                    // InternalMappingDsl.g:1352:5: ( (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping ) )+
                    int cnt48=0;
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID||LA48_0==29) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1353:6: (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping )
                    	    {
                    	    // InternalMappingDsl.g:1353:6: (lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping )
                    	    // InternalMappingDsl.g:1354:7: lv_fieldMappings_19_0= ruleTechnologySpecificFieldMapping
                    	    {

                    	    							newCompositeNode(grammarAccess.getComplexParameterMappingAccess().getFieldMappingsTechnologySpecificFieldMappingParserRuleCall_2_1_3_0());
                    	    						
                    	    pushFollow(FOLLOW_40);
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
                    	    if ( cnt48 >= 1 ) break loop48;
                                EarlyExitException eee =
                                    new EarlyExitException(48, input);
                                throw eee;
                        }
                        cnt48++;
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
    // InternalMappingDsl.g:1381:1: entryRuleTechnologySpecificFieldMapping returns [EObject current=null] : iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF ;
    public final EObject entryRuleTechnologySpecificFieldMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificFieldMapping = null;


        try {
            // InternalMappingDsl.g:1381:71: (iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF )
            // InternalMappingDsl.g:1382:2: iv_ruleTechnologySpecificFieldMapping= ruleTechnologySpecificFieldMapping EOF
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
    // InternalMappingDsl.g:1388:1: ruleTechnologySpecificFieldMapping returns [EObject current=null] : ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) ) ;
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
            // InternalMappingDsl.g:1394:2: ( ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) ) )
            // InternalMappingDsl.g:1395:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) )
            {
            // InternalMappingDsl.g:1395:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' ) | ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==29) ) {
                alt54=1;
            }
            else if ( (LA54_0==RULE_ID) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalMappingDsl.g:1396:3: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' )
                    {
                    // InternalMappingDsl.g:1396:3: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}' )
                    // InternalMappingDsl.g:1397:4: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' otherlv_7= '}'
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificFieldMappingAccess().getFullStopKeyword_0_0());
                    			
                    // InternalMappingDsl.g:1401:4: ( (otherlv_1= RULE_ID ) )
                    // InternalMappingDsl.g:1402:5: (otherlv_1= RULE_ID )
                    {
                    // InternalMappingDsl.g:1402:5: (otherlv_1= RULE_ID )
                    // InternalMappingDsl.g:1403:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificFieldMappingAccess().getEnumerationFieldEnumerationFieldCrossReference_0_1_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    otherlv_3=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsKeyword_0_3());
                    			
                    otherlv_4=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_0_4());
                    			
                    // InternalMappingDsl.g:1426:4: ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==RULE_ID) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1427:5: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1427:5: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1428:6: lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect
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
                    	    if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_26); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_0_6());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_0_7());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1455:3: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) )
                    {
                    // InternalMappingDsl.g:1455:3: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' ) )
                    // InternalMappingDsl.g:1456:4: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' )
                    {
                    // InternalMappingDsl.g:1456:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:1457:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:1457:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:1458:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_34); 

                    						newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificFieldMappingAccess().getDataFieldDataFieldCrossReference_1_0_0());
                    					

                    }


                    }

                    // InternalMappingDsl.g:1469:4: (otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==25) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalMappingDsl.g:1470:5: otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '::' ( ( ruleQualifiedName ) )
                            {
                            otherlv_9=(Token)match(input,25,FOLLOW_7); 

                            					newLeafNode(otherlv_9, grammarAccess.getTechnologySpecificFieldMappingAccess().getColonKeyword_1_1_0());
                            				
                            // InternalMappingDsl.g:1474:5: ( (otherlv_10= RULE_ID ) )
                            // InternalMappingDsl.g:1475:6: (otherlv_10= RULE_ID )
                            {
                            // InternalMappingDsl.g:1475:6: (otherlv_10= RULE_ID )
                            // InternalMappingDsl.g:1476:7: otherlv_10= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                            							}
                            						
                            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

                            							newLeafNode(otherlv_10, grammarAccess.getTechnologySpecificFieldMappingAccess().getTechnologyImportCrossReference_1_1_1_0());
                            						

                            }


                            }

                            otherlv_11=(Token)match(input,17,FOLLOW_7); 

                            					newLeafNode(otherlv_11, grammarAccess.getTechnologySpecificFieldMappingAccess().getColonColonKeyword_1_1_2());
                            				
                            // InternalMappingDsl.g:1491:5: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:1492:6: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:1492:6: ( ruleQualifiedName )
                            // InternalMappingDsl.g:1493:7: ruleQualifiedName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTechnologySpecificFieldMappingRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getTechnologySpecificFieldMappingAccess().getTypeTypeCrossReference_1_1_3_0());
                            						
                            pushFollow(FOLLOW_35);
                            ruleQualifiedName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1508:4: ( (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' ) | otherlv_19= ';' )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==14) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==26) ) {
                        alt53=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalMappingDsl.g:1509:5: (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' )
                            {
                            // InternalMappingDsl.g:1509:5: (otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}' )
                            // InternalMappingDsl.g:1510:6: otherlv_13= '{' otherlv_14= 'aspects' otherlv_15= '{' ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_17= '}' otherlv_18= '}'
                            {
                            otherlv_13=(Token)match(input,14,FOLLOW_36); 

                            						newLeafNode(otherlv_13, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_1_2_0_0());
                            					
                            otherlv_14=(Token)match(input,15,FOLLOW_8); 

                            						newLeafNode(otherlv_14, grammarAccess.getTechnologySpecificFieldMappingAccess().getAspectsKeyword_1_2_0_1());
                            					
                            otherlv_15=(Token)match(input,14,FOLLOW_7); 

                            						newLeafNode(otherlv_15, grammarAccess.getTechnologySpecificFieldMappingAccess().getLeftCurlyBracketKeyword_1_2_0_2());
                            					
                            // InternalMappingDsl.g:1522:6: ( (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt52=0;
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==RULE_ID) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1523:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1523:7: (lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1524:8: lv_aspects_16_0= ruleTechnologySpecificImportedServiceAspect
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
                            	    if ( cnt52 >= 1 ) break loop52;
                                        EarlyExitException eee =
                                            new EarlyExitException(52, input);
                                        throw eee;
                                }
                                cnt52++;
                            } while (true);

                            otherlv_17=(Token)match(input,16,FOLLOW_26); 

                            						newLeafNode(otherlv_17, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_1_2_0_4());
                            					
                            otherlv_18=(Token)match(input,16,FOLLOW_2); 

                            						newLeafNode(otherlv_18, grammarAccess.getTechnologySpecificFieldMappingAccess().getRightCurlyBracketKeyword_1_2_0_5());
                            					

                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:1551:5: otherlv_19= ';'
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


    // $ANTLR start "entryRuleDataOperationMapping"
    // InternalMappingDsl.g:1561:1: entryRuleDataOperationMapping returns [EObject current=null] : iv_ruleDataOperationMapping= ruleDataOperationMapping EOF ;
    public final EObject entryRuleDataOperationMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationMapping = null;


        try {
            // InternalMappingDsl.g:1561:61: (iv_ruleDataOperationMapping= ruleDataOperationMapping EOF )
            // InternalMappingDsl.g:1562:2: iv_ruleDataOperationMapping= ruleDataOperationMapping EOF
            {
             newCompositeNode(grammarAccess.getDataOperationMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataOperationMapping=ruleDataOperationMapping();

            state._fsp--;

             current =iv_ruleDataOperationMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataOperationMapping"


    // $ANTLR start "ruleDataOperationMapping"
    // InternalMappingDsl.g:1568:1: ruleDataOperationMapping returns [EObject current=null] : (otherlv_0= 'op' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
    public final EObject ruleDataOperationMapping() throws RecognitionException {
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
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_aspects_5_0 = null;

        EObject lv_returnTypeMapping_9_0 = null;

        EObject lv_parameterMappings_12_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1574:2: ( (otherlv_0= 'op' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalMappingDsl.g:1575:2: (otherlv_0= 'op' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalMappingDsl.g:1575:2: (otherlv_0= 'op' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalMappingDsl.g:1576:3: otherlv_0= 'op' ( (otherlv_1= RULE_ID ) ) ( (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataOperationMappingAccess().getOpKeyword_0());
            		
            // InternalMappingDsl.g:1580:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:1581:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:1581:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:1582:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataOperationMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(otherlv_1, grammarAccess.getDataOperationMappingAccess().getDataOperationDataOperationCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:1593:3: ( (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' ) | otherlv_15= ';' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==14) ) {
                alt60=1;
            }
            else if ( (LA60_0==26) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalMappingDsl.g:1594:4: (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' )
                    {
                    // InternalMappingDsl.g:1594:4: (otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}' )
                    // InternalMappingDsl.g:1595:5: otherlv_2= '{' (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )? (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )? (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )? otherlv_14= '}'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_41); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationMappingAccess().getLeftCurlyBracketKeyword_2_0_0());
                    				
                    // InternalMappingDsl.g:1599:5: (otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}' )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==15) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalMappingDsl.g:1600:6: otherlv_3= 'aspects' otherlv_4= '{' ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_6= '}'
                            {
                            otherlv_3=(Token)match(input,15,FOLLOW_8); 

                            						newLeafNode(otherlv_3, grammarAccess.getDataOperationMappingAccess().getAspectsKeyword_2_0_1_0());
                            					
                            otherlv_4=(Token)match(input,14,FOLLOW_7); 

                            						newLeafNode(otherlv_4, grammarAccess.getDataOperationMappingAccess().getLeftCurlyBracketKeyword_2_0_1_1());
                            					
                            // InternalMappingDsl.g:1608:6: ( (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect ) )+
                            int cnt55=0;
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==RULE_ID) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1609:7: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                            	    {
                            	    // InternalMappingDsl.g:1609:7: (lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect )
                            	    // InternalMappingDsl.g:1610:8: lv_aspects_5_0= ruleTechnologySpecificImportedServiceAspect
                            	    {

                            	    								newCompositeNode(grammarAccess.getDataOperationMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_1_2_0());
                            	    							
                            	    pushFollow(FOLLOW_10);
                            	    lv_aspects_5_0=ruleTechnologySpecificImportedServiceAspect();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getDataOperationMappingRule());
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
                            	    if ( cnt55 >= 1 ) break loop55;
                                        EarlyExitException eee =
                                            new EarlyExitException(55, input);
                                        throw eee;
                                }
                                cnt55++;
                            } while (true);

                            otherlv_6=(Token)match(input,16,FOLLOW_42); 

                            						newLeafNode(otherlv_6, grammarAccess.getDataOperationMappingAccess().getRightCurlyBracketKeyword_2_0_1_3());
                            					

                            }
                            break;

                    }

                    // InternalMappingDsl.g:1632:5: (otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==31) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalMappingDsl.g:1633:6: otherlv_7= 'return' otherlv_8= 'type' ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) )
                            {
                            otherlv_7=(Token)match(input,31,FOLLOW_43); 

                            						newLeafNode(otherlv_7, grammarAccess.getDataOperationMappingAccess().getReturnKeyword_2_0_2_0());
                            					
                            otherlv_8=(Token)match(input,13,FOLLOW_34); 

                            						newLeafNode(otherlv_8, grammarAccess.getDataOperationMappingAccess().getTypeKeyword_2_0_2_1());
                            					
                            // InternalMappingDsl.g:1641:6: ( (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping ) )
                            // InternalMappingDsl.g:1642:7: (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping )
                            {
                            // InternalMappingDsl.g:1642:7: (lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping )
                            // InternalMappingDsl.g:1643:8: lv_returnTypeMapping_9_0= ruleDataOperationReturnTypeMapping
                            {

                            								newCompositeNode(grammarAccess.getDataOperationMappingAccess().getReturnTypeMappingDataOperationReturnTypeMappingParserRuleCall_2_0_2_2_0());
                            							
                            pushFollow(FOLLOW_30);
                            lv_returnTypeMapping_9_0=ruleDataOperationReturnTypeMapping();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getDataOperationMappingRule());
                            								}
                            								set(
                            									current,
                            									"returnTypeMapping",
                            									lv_returnTypeMapping_9_0,
                            									"de.fhdo.lemma.technology.mappingdsl.MappingDsl.DataOperationReturnTypeMapping");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:1661:5: (otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}' )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==22) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalMappingDsl.g:1662:6: otherlv_10= 'parameters' otherlv_11= '{' ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+ otherlv_13= '}'
                            {
                            otherlv_10=(Token)match(input,22,FOLLOW_8); 

                            						newLeafNode(otherlv_10, grammarAccess.getDataOperationMappingAccess().getParametersKeyword_2_0_3_0());
                            					
                            otherlv_11=(Token)match(input,14,FOLLOW_7); 

                            						newLeafNode(otherlv_11, grammarAccess.getDataOperationMappingAccess().getLeftCurlyBracketKeyword_2_0_3_1());
                            					
                            // InternalMappingDsl.g:1670:6: ( (lv_parameterMappings_12_0= ruleDataOperationParameterMapping ) )+
                            int cnt58=0;
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);

                                if ( (LA58_0==RULE_ID) ) {
                                    alt58=1;
                                }


                                switch (alt58) {
                            	case 1 :
                            	    // InternalMappingDsl.g:1671:7: (lv_parameterMappings_12_0= ruleDataOperationParameterMapping )
                            	    {
                            	    // InternalMappingDsl.g:1671:7: (lv_parameterMappings_12_0= ruleDataOperationParameterMapping )
                            	    // InternalMappingDsl.g:1672:8: lv_parameterMappings_12_0= ruleDataOperationParameterMapping
                            	    {

                            	    								newCompositeNode(grammarAccess.getDataOperationMappingAccess().getParameterMappingsDataOperationParameterMappingParserRuleCall_2_0_3_2_0());
                            	    							
                            	    pushFollow(FOLLOW_10);
                            	    lv_parameterMappings_12_0=ruleDataOperationParameterMapping();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getDataOperationMappingRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"parameterMappings",
                            	    									lv_parameterMappings_12_0,
                            	    									"de.fhdo.lemma.technology.mappingdsl.MappingDsl.DataOperationParameterMapping");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt58 >= 1 ) break loop58;
                                        EarlyExitException eee =
                                            new EarlyExitException(58, input);
                                        throw eee;
                                }
                                cnt58++;
                            } while (true);

                            otherlv_13=(Token)match(input,16,FOLLOW_26); 

                            						newLeafNode(otherlv_13, grammarAccess.getDataOperationMappingAccess().getRightCurlyBracketKeyword_2_0_3_3());
                            					

                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getDataOperationMappingAccess().getRightCurlyBracketKeyword_2_0_4());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1700:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getDataOperationMappingAccess().getSemicolonKeyword_2_1());
                    			

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
    // $ANTLR end "ruleDataOperationMapping"


    // $ANTLR start "entryRuleDataOperationReturnTypeMapping"
    // InternalMappingDsl.g:1709:1: entryRuleDataOperationReturnTypeMapping returns [EObject current=null] : iv_ruleDataOperationReturnTypeMapping= ruleDataOperationReturnTypeMapping EOF ;
    public final EObject entryRuleDataOperationReturnTypeMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationReturnTypeMapping = null;


        try {
            // InternalMappingDsl.g:1709:71: (iv_ruleDataOperationReturnTypeMapping= ruleDataOperationReturnTypeMapping EOF )
            // InternalMappingDsl.g:1710:2: iv_ruleDataOperationReturnTypeMapping= ruleDataOperationReturnTypeMapping EOF
            {
             newCompositeNode(grammarAccess.getDataOperationReturnTypeMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataOperationReturnTypeMapping=ruleDataOperationReturnTypeMapping();

            state._fsp--;

             current =iv_ruleDataOperationReturnTypeMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataOperationReturnTypeMapping"


    // $ANTLR start "ruleDataOperationReturnTypeMapping"
    // InternalMappingDsl.g:1716:1: ruleDataOperationReturnTypeMapping returns [EObject current=null] : ( () (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) ) ;
    public final EObject ruleDataOperationReturnTypeMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_aspects_8_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1722:2: ( ( () (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) ) )
            // InternalMappingDsl.g:1723:2: ( () (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) )
            {
            // InternalMappingDsl.g:1723:2: ( () (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) )
            // InternalMappingDsl.g:1724:3: () (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' )
            {
            // InternalMappingDsl.g:1724:3: ()
            // InternalMappingDsl.g:1725:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataOperationReturnTypeMappingAccess().getDataOperationReturnTypeMappingAction_0(),
            					current);
            			

            }

            // InternalMappingDsl.g:1731:3: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==25) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalMappingDsl.g:1732:4: otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataOperationReturnTypeMappingAccess().getColonKeyword_1_0());
                    			
                    // InternalMappingDsl.g:1736:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMappingDsl.g:1737:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMappingDsl.g:1737:5: (otherlv_2= RULE_ID )
                    // InternalMappingDsl.g:1738:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationReturnTypeMappingRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_2, grammarAccess.getDataOperationReturnTypeMappingAccess().getTechnologyImportCrossReference_1_1_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataOperationReturnTypeMappingAccess().getColonColonKeyword_1_2());
                    			
                    // InternalMappingDsl.g:1753:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:1754:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:1754:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:1755:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationReturnTypeMappingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataOperationReturnTypeMappingAccess().getTypeTypeCrossReference_1_3_0());
                    					
                    pushFollow(FOLLOW_35);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:1770:3: ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==14) ) {
                alt63=1;
            }
            else if ( (LA63_0==26) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalMappingDsl.g:1771:4: (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )
                    {
                    // InternalMappingDsl.g:1771:4: (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )
                    // InternalMappingDsl.g:1772:5: otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_36); 

                    					newLeafNode(otherlv_5, grammarAccess.getDataOperationReturnTypeMappingAccess().getLeftCurlyBracketKeyword_2_0_0());
                    				
                    otherlv_6=(Token)match(input,15,FOLLOW_8); 

                    					newLeafNode(otherlv_6, grammarAccess.getDataOperationReturnTypeMappingAccess().getAspectsKeyword_2_0_1());
                    				
                    otherlv_7=(Token)match(input,14,FOLLOW_7); 

                    					newLeafNode(otherlv_7, grammarAccess.getDataOperationReturnTypeMappingAccess().getLeftCurlyBracketKeyword_2_0_2());
                    				
                    // InternalMappingDsl.g:1784:5: ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt62=0;
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==RULE_ID) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1785:6: (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1785:6: (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1786:7: lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationReturnTypeMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_3_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_8_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataOperationReturnTypeMappingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"aspects",
                    	    								lv_aspects_8_0,
                    	    								"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt62 >= 1 ) break loop62;
                                EarlyExitException eee =
                                    new EarlyExitException(62, input);
                                throw eee;
                        }
                        cnt62++;
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_26); 

                    					newLeafNode(otherlv_9, grammarAccess.getDataOperationReturnTypeMappingAccess().getRightCurlyBracketKeyword_2_0_4());
                    				
                    otherlv_10=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_10, grammarAccess.getDataOperationReturnTypeMappingAccess().getRightCurlyBracketKeyword_2_0_5());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1813:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationReturnTypeMappingAccess().getSemicolonKeyword_2_1());
                    			

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
    // $ANTLR end "ruleDataOperationReturnTypeMapping"


    // $ANTLR start "entryRuleDataOperationParameterMapping"
    // InternalMappingDsl.g:1822:1: entryRuleDataOperationParameterMapping returns [EObject current=null] : iv_ruleDataOperationParameterMapping= ruleDataOperationParameterMapping EOF ;
    public final EObject entryRuleDataOperationParameterMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameterMapping = null;


        try {
            // InternalMappingDsl.g:1822:70: (iv_ruleDataOperationParameterMapping= ruleDataOperationParameterMapping EOF )
            // InternalMappingDsl.g:1823:2: iv_ruleDataOperationParameterMapping= ruleDataOperationParameterMapping EOF
            {
             newCompositeNode(grammarAccess.getDataOperationParameterMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataOperationParameterMapping=ruleDataOperationParameterMapping();

            state._fsp--;

             current =iv_ruleDataOperationParameterMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataOperationParameterMapping"


    // $ANTLR start "ruleDataOperationParameterMapping"
    // InternalMappingDsl.g:1829:1: ruleDataOperationParameterMapping returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) ) ;
    public final EObject ruleDataOperationParameterMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_aspects_8_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:1835:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) ) )
            // InternalMappingDsl.g:1836:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) )
            {
            // InternalMappingDsl.g:1836:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' ) )
            // InternalMappingDsl.g:1837:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )? ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' )
            {
            // InternalMappingDsl.g:1837:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1838:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1838:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1839:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataOperationParameterMappingRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(otherlv_0, grammarAccess.getDataOperationParameterMappingAccess().getParameterDataOperationParameterCrossReference_0_0());
            				

            }


            }

            // InternalMappingDsl.g:1850:3: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==25) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalMappingDsl.g:1851:4: otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= '::' ( ( ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataOperationParameterMappingAccess().getColonKeyword_1_0());
                    			
                    // InternalMappingDsl.g:1855:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMappingDsl.g:1856:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMappingDsl.g:1856:5: (otherlv_2= RULE_ID )
                    // InternalMappingDsl.g:1857:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationParameterMappingRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_2, grammarAccess.getDataOperationParameterMappingAccess().getTechnologyImportCrossReference_1_1_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataOperationParameterMappingAccess().getColonColonKeyword_1_2());
                    			
                    // InternalMappingDsl.g:1872:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:1873:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:1873:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:1874:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationParameterMappingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataOperationParameterMappingAccess().getTypeTypeCrossReference_1_3_0());
                    					
                    pushFollow(FOLLOW_35);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:1889:3: ( (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' ) | otherlv_11= ';' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==14) ) {
                alt66=1;
            }
            else if ( (LA66_0==26) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalMappingDsl.g:1890:4: (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )
                    {
                    // InternalMappingDsl.g:1890:4: (otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}' )
                    // InternalMappingDsl.g:1891:5: otherlv_5= '{' otherlv_6= 'aspects' otherlv_7= '{' ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+ otherlv_9= '}' otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_36); 

                    					newLeafNode(otherlv_5, grammarAccess.getDataOperationParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_0());
                    				
                    otherlv_6=(Token)match(input,15,FOLLOW_8); 

                    					newLeafNode(otherlv_6, grammarAccess.getDataOperationParameterMappingAccess().getAspectsKeyword_2_0_1());
                    				
                    otherlv_7=(Token)match(input,14,FOLLOW_7); 

                    					newLeafNode(otherlv_7, grammarAccess.getDataOperationParameterMappingAccess().getLeftCurlyBracketKeyword_2_0_2());
                    				
                    // InternalMappingDsl.g:1903:5: ( (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect ) )+
                    int cnt65=0;
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==RULE_ID) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalMappingDsl.g:1904:6: (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect )
                    	    {
                    	    // InternalMappingDsl.g:1904:6: (lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect )
                    	    // InternalMappingDsl.g:1905:7: lv_aspects_8_0= ruleTechnologySpecificImportedServiceAspect
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationParameterMappingAccess().getAspectsTechnologySpecificImportedServiceAspectParserRuleCall_2_0_3_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_aspects_8_0=ruleTechnologySpecificImportedServiceAspect();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataOperationParameterMappingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"aspects",
                    	    								lv_aspects_8_0,
                    	    								"de.fhdo.lemma.technology.mappingdsl.MappingDsl.TechnologySpecificImportedServiceAspect");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt65 >= 1 ) break loop65;
                                EarlyExitException eee =
                                    new EarlyExitException(65, input);
                                throw eee;
                        }
                        cnt65++;
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_26); 

                    					newLeafNode(otherlv_9, grammarAccess.getDataOperationParameterMappingAccess().getRightCurlyBracketKeyword_2_0_4());
                    				
                    otherlv_10=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_10, grammarAccess.getDataOperationParameterMappingAccess().getRightCurlyBracketKeyword_2_0_5());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:1932:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationParameterMappingAccess().getSemicolonKeyword_2_1());
                    			

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
    // $ANTLR end "ruleDataOperationParameterMapping"


    // $ANTLR start "entryRuleImportedMicroservice"
    // InternalMappingDsl.g:1941:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:1941:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalMappingDsl.g:1942:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalMappingDsl.g:1948:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:1954:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalMappingDsl.g:1955:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalMappingDsl.g:1955:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalMappingDsl.g:1956:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalMappingDsl.g:1956:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:1957:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:1957:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:1958:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:1973:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:1974:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:1974:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:1975:5: ruleQualifiedNameWithAtLeastOneLevel
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
    // InternalMappingDsl.g:1993:1: entryRuleTechnologySpecificProtocolSpecification returns [EObject current=null] : iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF ;
    public final EObject entryRuleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:1993:80: (iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF )
            // InternalMappingDsl.g:1994:2: iv_ruleTechnologySpecificProtocolSpecification= ruleTechnologySpecificProtocolSpecification EOF
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
    // InternalMappingDsl.g:2000:1: ruleTechnologySpecificProtocolSpecification returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) ;
    public final EObject ruleTechnologySpecificProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_communicationType_0_0 = null;

        EObject lv_technologySpecificProtocol_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:2006:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) ) )
            // InternalMappingDsl.g:2007:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            {
            // InternalMappingDsl.g:2007:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) ) )
            // InternalMappingDsl.g:2008:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) otherlv_1= ':' ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            {
            // InternalMappingDsl.g:2008:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:2009:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:2009:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:2010:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_44);
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
            		
            // InternalMappingDsl.g:2031:3: ( (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:2032:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:2032:4: (lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:2033:5: lv_technologySpecificProtocol_2_0= ruleTechnologySpecificProtocol
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
    // InternalMappingDsl.g:2054:1: entryRuleTechnologySpecificProtocol returns [EObject current=null] : iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF ;
    public final EObject entryRuleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProtocol = null;


        try {
            // InternalMappingDsl.g:2054:67: (iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF )
            // InternalMappingDsl.g:2055:2: iv_ruleTechnologySpecificProtocol= ruleTechnologySpecificProtocol EOF
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
    // InternalMappingDsl.g:2061:1: ruleTechnologySpecificProtocol returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleTechnologySpecificProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2067:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:2068:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:2068:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:2069:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:2069:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:2070:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:2070:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:2071:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificProtocolAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificProtocolAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:2086:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2087:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2087:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2088:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificProtocolRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificProtocolAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:2102:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==32) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalMappingDsl.g:2103:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificProtocolAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:2107:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:2108:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:2108:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:2109:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:2125:1: entryRuleTechnologySpecificEndpoint returns [EObject current=null] : iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF ;
    public final EObject entryRuleTechnologySpecificEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificEndpoint = null;


        try {
            // InternalMappingDsl.g:2125:67: (iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF )
            // InternalMappingDsl.g:2126:2: iv_ruleTechnologySpecificEndpoint= ruleTechnologySpecificEndpoint EOF
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
    // InternalMappingDsl.g:2132:1: ruleTechnologySpecificEndpoint returns [EObject current=null] : ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:2138:2: ( ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:2139:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:2139:2: ( ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:2140:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) ) (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:2140:3: ( (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol ) )
            // InternalMappingDsl.g:2141:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            {
            // InternalMappingDsl.g:2141:4: (lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol )
            // InternalMappingDsl.g:2142:5: lv_technologySpecificProtocols_0_0= ruleTechnologySpecificProtocol
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_46);
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

            // InternalMappingDsl.g:2159:3: (otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==33) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalMappingDsl.g:2160:4: otherlv_1= ',' ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:2164:4: ( (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol ) )
            	    // InternalMappingDsl.g:2165:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    {
            	    // InternalMappingDsl.g:2165:5: (lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol )
            	    // InternalMappingDsl.g:2166:6: lv_technologySpecificProtocols_2_0= ruleTechnologySpecificProtocol
            	    {

            	    						newCompositeNode(grammarAccess.getTechnologySpecificEndpointAccess().getTechnologySpecificProtocolsTechnologySpecificProtocolParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop68;
                }
            } while (true);

            otherlv_3=(Token)match(input,25,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:2188:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:2189:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:2189:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:2190:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_48); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getTechnologySpecificEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            				

            }


            }

            // InternalMappingDsl.g:2206:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==33) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalMappingDsl.g:2207:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,33,FOLLOW_47); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTechnologySpecificEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:2211:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:2212:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:2212:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:2213:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_48); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getTechnologySpecificEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTechnologySpecificEndpointRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"addresses",
            	    							lv_addresses_6_0,
            	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // InternalMappingDsl.g:2238:1: entryRuleTechnologySpecificImportedServiceAspect returns [EObject current=null] : iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF ;
    public final EObject entryRuleTechnologySpecificImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:2238:80: (iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF )
            // InternalMappingDsl.g:2239:2: iv_ruleTechnologySpecificImportedServiceAspect= ruleTechnologySpecificImportedServiceAspect EOF
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
    // InternalMappingDsl.g:2245:1: ruleTechnologySpecificImportedServiceAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:2251:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:2252:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:2252:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            // InternalMappingDsl.g:2253:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';'
            {
            // InternalMappingDsl.g:2253:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:2254:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:2254:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:2255:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:2270:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:2271:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:2271:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:2272:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getAspectServiceAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_49);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:2286:3: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==34) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalMappingDsl.g:2287:4: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_50); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalMappingDsl.g:2291:4: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( ((LA71_0>=RULE_STRING && LA71_0<=RULE_BIG_DECIMAL)) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==RULE_ID) ) {
                        alt71=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalMappingDsl.g:2292:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:2292:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:2293:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:2293:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:2294:7: lv_singlePropertyValue_4_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_51);
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
                            // InternalMappingDsl.g:2312:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:2312:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:2313:6: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:2313:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:2314:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:2314:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:2315:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_0_0());
                            							
                            pushFollow(FOLLOW_52);
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

                            // InternalMappingDsl.g:2332:6: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop70:
                            do {
                                int alt70=2;
                                int LA70_0 = input.LA(1);

                                if ( (LA70_0==33) ) {
                                    alt70=1;
                                }


                                switch (alt70) {
                            	case 1 :
                            	    // InternalMappingDsl.g:2333:7: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,33,FOLLOW_50); 

                            	    							newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getCommaKeyword_3_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:2337:7: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:2338:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:2338:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:2339:9: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getTechnologySpecificImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_52);
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
                            	    break loop70;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,35,FOLLOW_53); 

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
    // InternalMappingDsl.g:2372:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMappingDsl.g:2372:47: (iv_ruleImport= ruleImport EOF )
            // InternalMappingDsl.g:2373:2: iv_ruleImport= ruleImport EOF
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
    // InternalMappingDsl.g:2379:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:2385:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:2386:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:2386:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:2387:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_54); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMappingDsl.g:2391:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalMappingDsl.g:2392:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalMappingDsl.g:2392:4: (lv_importType_1_0= ruleImportType )
            // InternalMappingDsl.g:2393:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_55);
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

            otherlv_2=(Token)match(input,37,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:2414:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:2415:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:2415:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:2416:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_56); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:2436:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:2437:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:2437:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:2438:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:2458:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalMappingDsl.g:2458:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalMappingDsl.g:2459:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalMappingDsl.g:2465:1: ruleMicroservice returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) ;
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
            // InternalMappingDsl.g:2471:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) )
            // InternalMappingDsl.g:2472:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            {
            // InternalMappingDsl.g:2472:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            // InternalMappingDsl.g:2473:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}'
            {
            // InternalMappingDsl.g:2473:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==39) ) {
                    int LA73_1 = input.LA(2);

                    if ( (LA73_1==46) ) {
                        alt73=1;
                    }


                }


                switch (alt73) {
            	case 1 :
            	    // InternalMappingDsl.g:2474:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalMappingDsl.g:2474:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalMappingDsl.g:2475:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_57);
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
            	    break loop73;
                }
            } while (true);

            // InternalMappingDsl.g:2492:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==39) ) {
                int LA75_1 = input.LA(2);

                if ( ((LA75_1>=75 && LA75_1<=76)) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // InternalMappingDsl.g:2493:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:2493:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:2494:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:2494:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:2495:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_57);
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

                    // InternalMappingDsl.g:2512:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==39) ) {
                        int LA74_1 = input.LA(2);

                        if ( ((LA74_1>=75 && LA74_1<=76)) ) {
                            alt74=1;
                        }
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalMappingDsl.g:2513:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:2513:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:2514:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_57);
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

            // InternalMappingDsl.g:2532:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==39) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==19) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // InternalMappingDsl.g:2533:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_58); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,19,FOLLOW_59); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,34,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMappingDsl.g:2545:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==RULE_ID) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2546:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:2546:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:2547:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_60);
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
                    	    if ( cnt76 >= 1 ) break loop76;
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
                    } while (true);

                    otherlv_7=(Token)match(input,35,FOLLOW_57); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2569:3: ( (lv_aspects_8_0= ruleImportedServiceAspect ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==39) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalMappingDsl.g:2570:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:2570:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:2571:5: lv_aspects_8_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_57);
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
            	    break loop78;
                }
            } while (true);

            // InternalMappingDsl.g:2588:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=130 && LA79_0<=132)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalMappingDsl.g:2589:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:2589:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:2590:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_57);
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

            // InternalMappingDsl.g:2607:3: ( (lv_type_10_0= ruleMicroserviceType ) )
            // InternalMappingDsl.g:2608:4: (lv_type_10_0= ruleMicroserviceType )
            {
            // InternalMappingDsl.g:2608:4: (lv_type_10_0= ruleMicroserviceType )
            // InternalMappingDsl.g:2609:5: lv_type_10_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_61);
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

            otherlv_11=(Token)match(input,40,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_6());
            		
            // InternalMappingDsl.g:2630:3: ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalMappingDsl.g:2631:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalMappingDsl.g:2631:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalMappingDsl.g:2632:5: lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_62);
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

            // InternalMappingDsl.g:2649:3: (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==41) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalMappingDsl.g:2650:4: otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) )
                    {
                    otherlv_13=(Token)match(input,41,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalMappingDsl.g:2654:4: ( (lv_version_14_0= RULE_ID ) )
                    // InternalMappingDsl.g:2655:5: (lv_version_14_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2655:5: (lv_version_14_0= RULE_ID )
                    // InternalMappingDsl.g:2656:6: lv_version_14_0= RULE_ID
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

            otherlv_15=(Token)match(input,14,FOLLOW_63); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalMappingDsl.g:2677:3: (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==42) ) {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==43) ) {
                    alt82=1;
                }
            }
            switch (alt82) {
                case 1 :
                    // InternalMappingDsl.g:2678:4: otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}'
                    {
                    otherlv_16=(Token)match(input,42,FOLLOW_64); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_17=(Token)match(input,43,FOLLOW_8); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_18=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalMappingDsl.g:2690:4: ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) )
                    // InternalMappingDsl.g:2691:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalMappingDsl.g:2691:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    // InternalMappingDsl.g:2692:6: lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_65);
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

                    // InternalMappingDsl.g:2709:4: (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==33) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2710:5: otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_20=(Token)match(input,33,FOLLOW_7); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2714:5: ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalMappingDsl.g:2715:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalMappingDsl.g:2715:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    // InternalMappingDsl.g:2716:7: lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_65);
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
                    	    break loop81;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,16,FOLLOW_63); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2739:3: (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==42) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==44) ) {
                    alt84=1;
                }
            }
            switch (alt84) {
                case 1 :
                    // InternalMappingDsl.g:2740:4: otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}'
                    {
                    otherlv_23=(Token)match(input,42,FOLLOW_66); 

                    				newLeafNode(otherlv_23, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_24=(Token)match(input,44,FOLLOW_8); 

                    				newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_25=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalMappingDsl.g:2752:4: ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) )
                    // InternalMappingDsl.g:2753:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    {
                    // InternalMappingDsl.g:2753:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    // InternalMappingDsl.g:2754:6: lv_requiredInterfaces_26_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_65);
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

                    // InternalMappingDsl.g:2771:4: (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==33) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2772:5: otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_27=(Token)match(input,33,FOLLOW_7); 

                    	    					newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2776:5: ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    // InternalMappingDsl.g:2777:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalMappingDsl.g:2777:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    // InternalMappingDsl.g:2778:7: lv_requiredInterfaces_28_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_65);
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
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,16,FOLLOW_63); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2801:3: (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==42) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalMappingDsl.g:2802:4: otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}'
                    {
                    otherlv_30=(Token)match(input,42,FOLLOW_67); 

                    				newLeafNode(otherlv_30, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_31=(Token)match(input,45,FOLLOW_8); 

                    				newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_32=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalMappingDsl.g:2814:4: ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:2815:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:2815:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:2816:6: lv_requiredOperations_33_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_65);
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

                    // InternalMappingDsl.g:2833:4: (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==33) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // InternalMappingDsl.g:2834:5: otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_34=(Token)match(input,33,FOLLOW_7); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalMappingDsl.g:2838:5: ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    // InternalMappingDsl.g:2839:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalMappingDsl.g:2839:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    // InternalMappingDsl.g:2840:7: lv_requiredOperations_35_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_65);
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
                    	    break loop85;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,16,FOLLOW_63); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:2863:3: ( (lv_interfaces_37_0= ruleInterface ) )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==20||LA87_0==39||LA87_0==49||(LA87_0>=130 && LA87_0<=132)) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalMappingDsl.g:2864:4: (lv_interfaces_37_0= ruleInterface )
            	    {
            	    // InternalMappingDsl.g:2864:4: (lv_interfaces_37_0= ruleInterface )
            	    // InternalMappingDsl.g:2865:5: lv_interfaces_37_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_68);
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
            	    if ( cnt87 >= 1 ) break loop87;
                        EarlyExitException eee =
                            new EarlyExitException(87, input);
                        throw eee;
                }
                cnt87++;
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
    // InternalMappingDsl.g:2890:1: entryRuleTechnologyReference returns [EObject current=null] : iv_ruleTechnologyReference= ruleTechnologyReference EOF ;
    public final EObject entryRuleTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyReference = null;


        try {
            // InternalMappingDsl.g:2890:60: (iv_ruleTechnologyReference= ruleTechnologyReference EOF )
            // InternalMappingDsl.g:2891:2: iv_ruleTechnologyReference= ruleTechnologyReference EOF
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
    // InternalMappingDsl.g:2897:1: ruleTechnologyReference returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) ;
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
            // InternalMappingDsl.g:2903:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) )
            // InternalMappingDsl.g:2904:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            {
            // InternalMappingDsl.g:2904:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            // InternalMappingDsl.g:2905:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_69); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:2917:3: ( (otherlv_3= RULE_ID ) )
            // InternalMappingDsl.g:2918:4: (otherlv_3= RULE_ID )
            {
            // InternalMappingDsl.g:2918:4: (otherlv_3= RULE_ID )
            // InternalMappingDsl.g:2919:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_52); 

            					newLeafNode(otherlv_3, grammarAccess.getTechnologyReferenceAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            // InternalMappingDsl.g:2930:3: (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==33) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalMappingDsl.g:2931:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_70); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,47,FOLLOW_71); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,48,FOLLOW_72); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologyReferenceAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalMappingDsl.g:2943:4: ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:2944:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:2944:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:2945:6: lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN
                    {
                    lv_isTypeDefinitionTechnology_7_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_51); 

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

            otherlv_8=(Token)match(input,35,FOLLOW_2); 

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
    // InternalMappingDsl.g:2970:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalMappingDsl.g:2970:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalMappingDsl.g:2971:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalMappingDsl.g:2977:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:2983:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:2984:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:2984:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:2985:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:2985:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_ID) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==17) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // InternalMappingDsl.g:2986:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:2986:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:2987:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:2987:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:2988:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3004:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3005:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3005:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3006:5: ruleQualifiedName
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
    // InternalMappingDsl.g:3024:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalMappingDsl.g:3024:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalMappingDsl.g:3025:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalMappingDsl.g:3031:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3037:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:3038:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:3038:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:3039:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:3039:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==17) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalMappingDsl.g:3040:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:3040:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:3041:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:3041:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:3042:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3058:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3059:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3059:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3060:5: ruleQualifiedName
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
    // InternalMappingDsl.g:3078:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalMappingDsl.g:3078:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalMappingDsl.g:3079:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalMappingDsl.g:3085:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:3091:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:3092:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:3092:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:3093:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:3093:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==17) ) {
                    alt91=1;
                }
            }
            switch (alt91) {
                case 1 :
                    // InternalMappingDsl.g:3094:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:3094:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:3095:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:3095:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:3096:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3112:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3113:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3113:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3114:5: ruleQualifiedName
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
    // InternalMappingDsl.g:3132:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalMappingDsl.g:3132:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalMappingDsl.g:3133:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalMappingDsl.g:3139:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' ) ;
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
        Token lv_version_13_0=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_endpoints_5_0 = null;

        EObject lv_aspects_7_0 = null;

        Enumerator lv_visibility_9_0 = null;

        EObject lv_referredOperations_15_0 = null;

        EObject lv_operations_16_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3145:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' ) )
            // InternalMappingDsl.g:3146:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' )
            {
            // InternalMappingDsl.g:3146:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' )
            // InternalMappingDsl.g:3147:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}'
            {
            // InternalMappingDsl.g:3147:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==39) ) {
                int LA93_1 = input.LA(2);

                if ( ((LA93_1>=75 && LA93_1<=76)) ) {
                    alt93=1;
                }
            }
            switch (alt93) {
                case 1 :
                    // InternalMappingDsl.g:3148:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:3148:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:3149:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:3149:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:3150:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_73);
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

                    // InternalMappingDsl.g:3167:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==39) ) {
                        int LA92_1 = input.LA(2);

                        if ( ((LA92_1>=75 && LA92_1<=76)) ) {
                            alt92=1;
                        }
                    }
                    switch (alt92) {
                        case 1 :
                            // InternalMappingDsl.g:3168:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:3168:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:3169:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_73);
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

            // InternalMappingDsl.g:3187:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==39) ) {
                int LA95_1 = input.LA(2);

                if ( (LA95_1==19) ) {
                    alt95=1;
                }
            }
            switch (alt95) {
                case 1 :
                    // InternalMappingDsl.g:3188:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_58); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,34,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:3200:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt94=0;
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==RULE_ID) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalMappingDsl.g:3201:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:3201:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:3202:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_60);
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
                    	    if ( cnt94 >= 1 ) break loop94;
                                EarlyExitException eee =
                                    new EarlyExitException(94, input);
                                throw eee;
                        }
                        cnt94++;
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_73); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3224:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==39) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalMappingDsl.g:3225:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3225:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3226:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_73);
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
            	    break loop96;
                }
            } while (true);

            // InternalMappingDsl.g:3243:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==49) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalMappingDsl.g:3244:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:3244:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalMappingDsl.g:3245:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,49,FOLLOW_74); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3257:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( ((LA98_0>=130 && LA98_0<=132)) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalMappingDsl.g:3258:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:3258:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalMappingDsl.g:3259:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_75);
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
            		
            // InternalMappingDsl.g:3280:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalMappingDsl.g:3281:4: (lv_name_11_0= RULE_ID )
            {
            // InternalMappingDsl.g:3281:4: (lv_name_11_0= RULE_ID )
            // InternalMappingDsl.g:3282:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_62); 

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

            // InternalMappingDsl.g:3298:3: (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==41) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalMappingDsl.g:3299:4: otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) )
                    {
                    otherlv_12=(Token)match(input,41,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getVersionKeyword_7_0());
                    			
                    // InternalMappingDsl.g:3303:4: ( (lv_version_13_0= RULE_ID ) )
                    // InternalMappingDsl.g:3304:5: (lv_version_13_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:3304:5: (lv_version_13_0= RULE_ID )
                    // InternalMappingDsl.g:3305:6: lv_version_13_0= RULE_ID
                    {
                    lv_version_13_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_version_13_0, grammarAccess.getInterfaceAccess().getVersionIDTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInterfaceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"version",
                    							lv_version_13_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,14,FOLLOW_76); 

            			newLeafNode(otherlv_14, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalMappingDsl.g:3326:3: ( (lv_referredOperations_15_0= ruleReferredOperation ) )*
            loop100:
            do {
                int alt100=2;
                alt100 = dfa100.predict(input);
                switch (alt100) {
            	case 1 :
            	    // InternalMappingDsl.g:3327:4: (lv_referredOperations_15_0= ruleReferredOperation )
            	    {
            	    // InternalMappingDsl.g:3327:4: (lv_referredOperations_15_0= ruleReferredOperation )
            	    // InternalMappingDsl.g:3328:5: lv_referredOperations_15_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_76);
            	    lv_referredOperations_15_0=ruleReferredOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referredOperations",
            	    						lv_referredOperations_15_0,
            	    						"de.fhdo.lemma.ServiceDsl.ReferredOperation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);

            // InternalMappingDsl.g:3345:3: ( (lv_operations_16_0= ruleOperation ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==RULE_ID||LA101_0==39||(LA101_0>=49 && LA101_0<=50)||(LA101_0>=130 && LA101_0<=132)) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalMappingDsl.g:3346:4: (lv_operations_16_0= ruleOperation )
            	    {
            	    // InternalMappingDsl.g:3346:4: (lv_operations_16_0= ruleOperation )
            	    // InternalMappingDsl.g:3347:5: lv_operations_16_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_77);
            	    lv_operations_16_0=ruleOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operations",
            	    						lv_operations_16_0,
            	    						"de.fhdo.lemma.ServiceDsl.Operation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);

            otherlv_17=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleApiOperationComment"
    // InternalMappingDsl.g:3372:1: entryRuleApiOperationComment returns [EObject current=null] : iv_ruleApiOperationComment= ruleApiOperationComment EOF ;
    public final EObject entryRuleApiOperationComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiOperationComment = null;


        try {
            // InternalMappingDsl.g:3372:60: (iv_ruleApiOperationComment= ruleApiOperationComment EOF )
            // InternalMappingDsl.g:3373:2: iv_ruleApiOperationComment= ruleApiOperationComment EOF
            {
             newCompositeNode(grammarAccess.getApiOperationCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleApiOperationComment=ruleApiOperationComment();

            state._fsp--;

             current =iv_ruleApiOperationComment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApiOperationComment"


    // $ANTLR start "ruleApiOperationComment"
    // InternalMappingDsl.g:3379:1: ruleApiOperationComment returns [EObject current=null] : (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) ;
    public final EObject ruleApiOperationComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_comment_1_0 = null;

        EObject lv_parameterComments_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3385:2: ( (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) )
            // InternalMappingDsl.g:3386:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            {
            // InternalMappingDsl.g:3386:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            // InternalMappingDsl.g:3387:3: otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_78); 

            			newLeafNode(otherlv_0, grammarAccess.getApiOperationCommentAccess().getHyphenMinusHyphenMinusHyphenMinusKeyword_0());
            		
            // InternalMappingDsl.g:3391:3: ( (lv_comment_1_0= ruleAnything ) )
            // InternalMappingDsl.g:3392:4: (lv_comment_1_0= ruleAnything )
            {
            // InternalMappingDsl.g:3392:4: (lv_comment_1_0= ruleAnything )
            // InternalMappingDsl.g:3393:5: lv_comment_1_0= ruleAnything
            {

            					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getCommentAnythingParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_79);
            lv_comment_1_0=ruleAnything();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getApiOperationCommentRule());
            					}
            					set(
            						current,
            						"comment",
            						lv_comment_1_0,
            						"de.fhdo.lemma.ServiceDsl.Anything");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:3410:3: ( (lv_parameterComments_2_0= ruleApiParameterComment ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( ((LA102_0>=51 && LA102_0<=52)) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalMappingDsl.g:3411:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    {
            	    // InternalMappingDsl.g:3411:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    // InternalMappingDsl.g:3412:5: lv_parameterComments_2_0= ruleApiParameterComment
            	    {

            	    					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getParameterCommentsApiParameterCommentParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_79);
            	    lv_parameterComments_2_0=ruleApiParameterComment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getApiOperationCommentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parameterComments",
            	    						lv_parameterComments_2_0,
            	    						"de.fhdo.lemma.ServiceDsl.ApiParameterComment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            otherlv_3=(Token)match(input,50,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getApiOperationCommentAccess().getHyphenMinusHyphenMinusHyphenMinusKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApiOperationComment"


    // $ANTLR start "entryRuleApiParameterComment"
    // InternalMappingDsl.g:3437:1: entryRuleApiParameterComment returns [EObject current=null] : iv_ruleApiParameterComment= ruleApiParameterComment EOF ;
    public final EObject entryRuleApiParameterComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiParameterComment = null;


        try {
            // InternalMappingDsl.g:3437:60: (iv_ruleApiParameterComment= ruleApiParameterComment EOF )
            // InternalMappingDsl.g:3438:2: iv_ruleApiParameterComment= ruleApiParameterComment EOF
            {
             newCompositeNode(grammarAccess.getApiParameterCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleApiParameterComment=ruleApiParameterComment();

            state._fsp--;

             current =iv_ruleApiParameterComment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApiParameterComment"


    // $ANTLR start "ruleApiParameterComment"
    // InternalMappingDsl.g:3444:1: ruleApiParameterComment returns [EObject current=null] : ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) ) ;
    public final EObject ruleApiParameterComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_required_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_comment_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3450:2: ( ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) ) )
            // InternalMappingDsl.g:3451:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) )
            {
            // InternalMappingDsl.g:3451:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) )
            // InternalMappingDsl.g:3452:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) )
            {
            // InternalMappingDsl.g:3452:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==51) ) {
                alt103=1;
            }
            else if ( (LA103_0==52) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalMappingDsl.g:3453:4: otherlv_0= '@param'
                    {
                    otherlv_0=(Token)match(input,51,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getApiParameterCommentAccess().getParamKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:3458:4: ( (lv_required_1_0= '@required' ) )
                    {
                    // InternalMappingDsl.g:3458:4: ( (lv_required_1_0= '@required' ) )
                    // InternalMappingDsl.g:3459:5: (lv_required_1_0= '@required' )
                    {
                    // InternalMappingDsl.g:3459:5: (lv_required_1_0= '@required' )
                    // InternalMappingDsl.g:3460:6: lv_required_1_0= '@required'
                    {
                    lv_required_1_0=(Token)match(input,52,FOLLOW_7); 

                    						newLeafNode(lv_required_1_0, grammarAccess.getApiParameterCommentAccess().getRequiredRequiredKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getApiParameterCommentRule());
                    						}
                    						setWithLastConsumed(current, "required", true, "@required");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3473:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:3474:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:3474:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:3475:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApiParameterCommentRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_78); 

            					newLeafNode(otherlv_2, grammarAccess.getApiParameterCommentAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalMappingDsl.g:3486:3: ( (lv_comment_3_0= ruleAnything ) )
            // InternalMappingDsl.g:3487:4: (lv_comment_3_0= ruleAnything )
            {
            // InternalMappingDsl.g:3487:4: (lv_comment_3_0= ruleAnything )
            // InternalMappingDsl.g:3488:5: lv_comment_3_0= ruleAnything
            {

            					newCompositeNode(grammarAccess.getApiParameterCommentAccess().getCommentAnythingParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_comment_3_0=ruleAnything();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getApiParameterCommentRule());
            					}
            					set(
            						current,
            						"comment",
            						lv_comment_3_0,
            						"de.fhdo.lemma.ServiceDsl.Anything");
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
    // $ANTLR end "ruleApiParameterComment"


    // $ANTLR start "entryRuleOperation"
    // InternalMappingDsl.g:3509:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMappingDsl.g:3509:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMappingDsl.g:3510:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalMappingDsl.g:3516:1: ruleOperation returns [EObject current=null] : ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_notImplemented_9_0=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_apiOperationComment_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_protocols_2_0 = null;

        EObject lv_endpoints_6_0 = null;

        EObject lv_aspects_8_0 = null;

        Enumerator lv_visibility_10_0 = null;

        EObject lv_parameters_13_0 = null;

        EObject lv_parameters_15_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:3522:2: ( ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' ) )
            // InternalMappingDsl.g:3523:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' )
            {
            // InternalMappingDsl.g:3523:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' )
            // InternalMappingDsl.g:3524:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';'
            {
            // InternalMappingDsl.g:3524:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==50) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalMappingDsl.g:3525:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    {
                    // InternalMappingDsl.g:3525:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    // InternalMappingDsl.g:3526:5: lv_apiOperationComment_0_0= ruleApiOperationComment
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getApiOperationCommentApiOperationCommentParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_80);
                    lv_apiOperationComment_0_0=ruleApiOperationComment();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					set(
                    						current,
                    						"apiOperationComment",
                    						lv_apiOperationComment_0_0,
                    						"de.fhdo.lemma.ServiceDsl.ApiOperationComment");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3543:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==39) ) {
                int LA106_1 = input.LA(2);

                if ( ((LA106_1>=75 && LA106_1<=76)) ) {
                    alt106=1;
                }
            }
            switch (alt106) {
                case 1 :
                    // InternalMappingDsl.g:3544:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:3544:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:3545:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:3545:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:3546:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_80);
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

                    // InternalMappingDsl.g:3563:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==39) ) {
                        int LA105_1 = input.LA(2);

                        if ( ((LA105_1>=75 && LA105_1<=76)) ) {
                            alt105=1;
                        }
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalMappingDsl.g:3564:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:3564:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:3565:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_80);
                            lv_protocols_2_0=ruleProtocolSpecification();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getOperationRule());
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

            // InternalMappingDsl.g:3583:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==39) ) {
                int LA108_1 = input.LA(2);

                if ( (LA108_1==19) ) {
                    alt108=1;
                }
            }
            switch (alt108) {
                case 1 :
                    // InternalMappingDsl.g:3584:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_58); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,19,FOLLOW_59); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,34,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMappingDsl.g:3596:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
                    int cnt107=0;
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==RULE_ID) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalMappingDsl.g:3597:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:3597:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:3598:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_60);
                    	    lv_endpoints_6_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationRule());
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
                    	    if ( cnt107 >= 1 ) break loop107;
                                EarlyExitException eee =
                                    new EarlyExitException(107, input);
                                throw eee;
                        }
                        cnt107++;
                    } while (true);

                    otherlv_7=(Token)match(input,35,FOLLOW_80); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3620:3: ( (lv_aspects_8_0= ruleImportedServiceAspect ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==39) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalMappingDsl.g:3621:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3621:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3622:5: lv_aspects_8_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_80);
            	    lv_aspects_8_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationRule());
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
            	    break loop109;
                }
            } while (true);

            // InternalMappingDsl.g:3639:3: ( (lv_notImplemented_9_0= 'noimpl' ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==49) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalMappingDsl.g:3640:4: (lv_notImplemented_9_0= 'noimpl' )
                    {
                    // InternalMappingDsl.g:3640:4: (lv_notImplemented_9_0= 'noimpl' )
                    // InternalMappingDsl.g:3641:5: lv_notImplemented_9_0= 'noimpl'
                    {
                    lv_notImplemented_9_0=(Token)match(input,49,FOLLOW_81); 

                    					newLeafNode(lv_notImplemented_9_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3653:3: ( (lv_visibility_10_0= ruleVisibility ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( ((LA111_0>=130 && LA111_0<=132)) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalMappingDsl.g:3654:4: (lv_visibility_10_0= ruleVisibility )
                    {
                    // InternalMappingDsl.g:3654:4: (lv_visibility_10_0= ruleVisibility )
                    // InternalMappingDsl.g:3655:5: lv_visibility_10_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_visibility_10_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_10_0,
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3672:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalMappingDsl.g:3673:4: (lv_name_11_0= RULE_ID )
            {
            // InternalMappingDsl.g:3673:4: (lv_name_11_0= RULE_ID )
            // InternalMappingDsl.g:3674:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            					newLeafNode(lv_name_11_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_11_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_12=(Token)match(input,34,FOLLOW_82); 

            			newLeafNode(otherlv_12, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_7());
            		
            // InternalMappingDsl.g:3694:3: ( (lv_parameters_13_0= ruleParameter ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==39||(LA112_0>=75 && LA112_0<=76)) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalMappingDsl.g:3695:4: (lv_parameters_13_0= ruleParameter )
                    {
                    // InternalMappingDsl.g:3695:4: (lv_parameters_13_0= ruleParameter )
                    // InternalMappingDsl.g:3696:5: lv_parameters_13_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_52);
                    lv_parameters_13_0=ruleParameter();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					add(
                    						current,
                    						"parameters",
                    						lv_parameters_13_0,
                    						"de.fhdo.lemma.ServiceDsl.Parameter");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3713:3: (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==33) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalMappingDsl.g:3714:4: otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) )
            	    {
            	    otherlv_14=(Token)match(input,33,FOLLOW_83); 

            	    				newLeafNode(otherlv_14, grammarAccess.getOperationAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalMappingDsl.g:3718:4: ( (lv_parameters_15_0= ruleParameter ) )
            	    // InternalMappingDsl.g:3719:5: (lv_parameters_15_0= ruleParameter )
            	    {
            	    // InternalMappingDsl.g:3719:5: (lv_parameters_15_0= ruleParameter )
            	    // InternalMappingDsl.g:3720:6: lv_parameters_15_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
            	    lv_parameters_15_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_15_0,
            	    							"de.fhdo.lemma.ServiceDsl.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop113;
                }
            } while (true);

            otherlv_16=(Token)match(input,35,FOLLOW_53); 

            			newLeafNode(otherlv_16, grammarAccess.getOperationAccess().getRightParenthesisKeyword_10());
            		
            otherlv_17=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getOperationAccess().getSemicolonKeyword_11());
            		

            }


            }


            	leaveRule();

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
    // InternalMappingDsl.g:3750:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalMappingDsl.g:3750:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalMappingDsl.g:3751:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalMappingDsl.g:3757:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalMappingDsl.g:3763:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalMappingDsl.g:3764:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalMappingDsl.g:3764:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalMappingDsl.g:3765:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalMappingDsl.g:3765:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==39) ) {
                int LA115_1 = input.LA(2);

                if ( ((LA115_1>=75 && LA115_1<=76)) ) {
                    alt115=1;
                }
            }
            switch (alt115) {
                case 1 :
                    // InternalMappingDsl.g:3766:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalMappingDsl.g:3766:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalMappingDsl.g:3767:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalMappingDsl.g:3767:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalMappingDsl.g:3768:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_84);
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

                    // InternalMappingDsl.g:3785:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==39) ) {
                        int LA114_1 = input.LA(2);

                        if ( ((LA114_1>=75 && LA114_1<=76)) ) {
                            alt114=1;
                        }
                    }
                    switch (alt114) {
                        case 1 :
                            // InternalMappingDsl.g:3786:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalMappingDsl.g:3786:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalMappingDsl.g:3787:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_84);
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

            // InternalMappingDsl.g:3805:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==39) ) {
                int LA117_1 = input.LA(2);

                if ( (LA117_1==19) ) {
                    alt117=1;
                }
            }
            switch (alt117) {
                case 1 :
                    // InternalMappingDsl.g:3806:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_58); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,19,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,34,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMappingDsl.g:3818:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt116=0;
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==RULE_ID) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // InternalMappingDsl.g:3819:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalMappingDsl.g:3819:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalMappingDsl.g:3820:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_60);
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
                    	    if ( cnt116 >= 1 ) break loop116;
                                EarlyExitException eee =
                                    new EarlyExitException(116, input);
                                throw eee;
                        }
                        cnt116++;
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_84); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:3842:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==39) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalMappingDsl.g:3843:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3843:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3844:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_84);
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
            	    break loop118;
                }
            } while (true);

            otherlv_8=(Token)match(input,53,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalMappingDsl.g:3865:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:3866:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:3866:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:3867:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_53);
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
    // InternalMappingDsl.g:3889:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMappingDsl.g:3889:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMappingDsl.g:3890:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalMappingDsl.g:3896:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalMappingDsl.g:3902:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalMappingDsl.g:3903:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalMappingDsl.g:3903:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalMappingDsl.g:3904:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalMappingDsl.g:3904:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==39) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalMappingDsl.g:3905:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalMappingDsl.g:3905:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalMappingDsl.g:3906:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_83);
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
            	    break loop119;
                }
            } while (true);

            // InternalMappingDsl.g:3923:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:3924:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:3924:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:3925:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_85);
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

            // InternalMappingDsl.g:3942:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( ((LA120_0>=72 && LA120_0<=74)) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalMappingDsl.g:3943:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:3943:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:3944:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_86);
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

            // InternalMappingDsl.g:3961:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==54) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalMappingDsl.g:3962:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalMappingDsl.g:3962:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalMappingDsl.g:3963:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,54,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:3975:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalMappingDsl.g:3976:4: (lv_name_4_0= RULE_ID )
            {
            // InternalMappingDsl.g:3976:4: (lv_name_4_0= RULE_ID )
            // InternalMappingDsl.g:3977:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_87); 

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

            // InternalMappingDsl.g:3993:3: ( (lv_optional_5_0= '?' ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==55) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalMappingDsl.g:3994:4: (lv_optional_5_0= '?' )
                    {
                    // InternalMappingDsl.g:3994:4: (lv_optional_5_0= '?' )
                    // InternalMappingDsl.g:3995:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,55,FOLLOW_44); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,25,FOLLOW_88); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalMappingDsl.g:4011:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( ((LA123_0>=120 && LA123_0<=129)||LA123_0==136) ) {
                alt123=1;
            }
            else if ( (LA123_0==RULE_ID) ) {
                alt123=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalMappingDsl.g:4012:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:4012:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:4013:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:4013:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalMappingDsl.g:4014:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_89);
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
                    // InternalMappingDsl.g:4032:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalMappingDsl.g:4032:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalMappingDsl.g:4033:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalMappingDsl.g:4033:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalMappingDsl.g:4034:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_89);
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

            // InternalMappingDsl.g:4052:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==48) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalMappingDsl.g:4053:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalMappingDsl.g:4057:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalMappingDsl.g:4058:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalMappingDsl.g:4058:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalMappingDsl.g:4059:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalMappingDsl.g:4081:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalMappingDsl.g:4081:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalMappingDsl.g:4082:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalMappingDsl.g:4088:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4094:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:4095:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:4095:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:4096:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:4096:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:4097:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:4097:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:4098:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:4113:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4114:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4114:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4115:5: ruleQualifiedName
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
    // InternalMappingDsl.g:4133:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalMappingDsl.g:4133:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalMappingDsl.g:4134:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalMappingDsl.g:4140:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:4146:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalMappingDsl.g:4147:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalMappingDsl.g:4147:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalMappingDsl.g:4148:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:4152:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:4153:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:4153:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalMappingDsl.g:4154:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_59);
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

            otherlv_2=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMappingDsl.g:4175:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:4176:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:4176:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:4177:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getProtocolImportedProtocolAndDataFormatParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_51);
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

            otherlv_4=(Token)match(input,35,FOLLOW_2); 

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
    // InternalMappingDsl.g:4202:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalMappingDsl.g:4202:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalMappingDsl.g:4203:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalMappingDsl.g:4209:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4215:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMappingDsl.g:4216:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMappingDsl.g:4216:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMappingDsl.g:4217:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMappingDsl.g:4217:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:4218:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:4218:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:4219:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:4234:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4235:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4235:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4236:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4250:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==32) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalMappingDsl.g:4251:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalMappingDsl.g:4255:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMappingDsl.g:4256:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMappingDsl.g:4256:5: (otherlv_4= RULE_ID )
                    // InternalMappingDsl.g:4257:6: otherlv_4= RULE_ID
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
    // InternalMappingDsl.g:4273:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalMappingDsl.g:4273:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalMappingDsl.g:4274:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalMappingDsl.g:4280:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalMappingDsl.g:4286:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalMappingDsl.g:4287:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalMappingDsl.g:4287:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalMappingDsl.g:4288:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalMappingDsl.g:4288:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalMappingDsl.g:4289:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalMappingDsl.g:4289:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalMappingDsl.g:4290:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_46);
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

            // InternalMappingDsl.g:4307:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==33) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // InternalMappingDsl.g:4308:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:4312:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalMappingDsl.g:4313:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalMappingDsl.g:4313:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalMappingDsl.g:4314:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop126;
                }
            } while (true);

            otherlv_3=(Token)match(input,25,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalMappingDsl.g:4336:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalMappingDsl.g:4337:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalMappingDsl.g:4337:4: (lv_addresses_4_0= RULE_STRING )
            // InternalMappingDsl.g:4338:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_48); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            				

            }


            }

            // InternalMappingDsl.g:4354:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==33) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // InternalMappingDsl.g:4355:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,33,FOLLOW_47); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:4359:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalMappingDsl.g:4360:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalMappingDsl.g:4360:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalMappingDsl.g:4361:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_48); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getEndpointRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"addresses",
            	    							lv_addresses_6_0,
            	    							"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop127;
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
    // InternalMappingDsl.g:4386:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalMappingDsl.g:4386:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalMappingDsl.g:4387:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalMappingDsl.g:4393:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalMappingDsl.g:4399:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalMappingDsl.g:4400:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalMappingDsl.g:4400:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalMappingDsl.g:4401:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalMappingDsl.g:4405:3: ( (otherlv_1= RULE_ID ) )
            // InternalMappingDsl.g:4406:4: (otherlv_1= RULE_ID )
            {
            // InternalMappingDsl.g:4406:4: (otherlv_1= RULE_ID )
            // InternalMappingDsl.g:4407:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalMappingDsl.g:4422:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:4423:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:4423:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:4424:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_90);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:4438:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==34) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalMappingDsl.g:4439:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,34,FOLLOW_50); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMappingDsl.g:4443:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt129=2;
                    int LA129_0 = input.LA(1);

                    if ( ((LA129_0>=RULE_STRING && LA129_0<=RULE_BIG_DECIMAL)) ) {
                        alt129=1;
                    }
                    else if ( (LA129_0==RULE_ID) ) {
                        alt129=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 129, 0, input);

                        throw nvae;
                    }
                    switch (alt129) {
                        case 1 :
                            // InternalMappingDsl.g:4444:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalMappingDsl.g:4444:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalMappingDsl.g:4445:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalMappingDsl.g:4445:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalMappingDsl.g:4446:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_51);
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
                            // InternalMappingDsl.g:4464:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalMappingDsl.g:4464:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalMappingDsl.g:4465:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalMappingDsl.g:4465:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalMappingDsl.g:4466:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalMappingDsl.g:4466:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalMappingDsl.g:4467:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_52);
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

                            // InternalMappingDsl.g:4484:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop128:
                            do {
                                int alt128=2;
                                int LA128_0 = input.LA(1);

                                if ( (LA128_0==33) ) {
                                    alt128=1;
                                }


                                switch (alt128) {
                            	case 1 :
                            	    // InternalMappingDsl.g:4485:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,33,FOLLOW_50); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalMappingDsl.g:4489:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalMappingDsl.g:4490:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalMappingDsl.g:4490:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalMappingDsl.g:4491:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_52);
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
                            	    break loop128;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,35,FOLLOW_2); 

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
    // InternalMappingDsl.g:4520:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalMappingDsl.g:4520:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalMappingDsl.g:4521:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalMappingDsl.g:4527:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) ;
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
            // InternalMappingDsl.g:4533:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) )
            // InternalMappingDsl.g:4534:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            {
            // InternalMappingDsl.g:4534:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==RULE_ID) ) {
                int LA131_1 = input.LA(2);

                if ( (LA131_1==48) ) {
                    alt131=1;
                }
                else if ( (LA131_1==34) ) {
                    alt131=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // InternalMappingDsl.g:4535:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    {
                    // InternalMappingDsl.g:4535:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    // InternalMappingDsl.g:4536:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
                    {
                    // InternalMappingDsl.g:4536:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:4537:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:4537:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:4538:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_71); 

                    						newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,48,FOLLOW_91); 

                    				newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:4553:4: ( (lv_value_2_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:4554:5: (lv_value_2_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:4554:5: (lv_value_2_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:4555:6: lv_value_2_0= rulePrimitiveValue
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
                    // InternalMappingDsl.g:4574:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    {
                    // InternalMappingDsl.g:4574:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    // InternalMappingDsl.g:4575:4: ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')'
                    {
                    // InternalMappingDsl.g:4575:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMappingDsl.g:4576:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMappingDsl.g:4576:5: (otherlv_3= RULE_ID )
                    // InternalMappingDsl.g:4577:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_59); 

                    						newLeafNode(otherlv_3, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,34,FOLLOW_91); 

                    				newLeafNode(otherlv_4, grammarAccess.getPropertyValueAssignmentAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalMappingDsl.g:4592:4: ( (lv_value_5_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:4593:5: (lv_value_5_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:4593:5: (lv_value_5_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:4594:6: lv_value_5_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getPropertyValueAssignmentAccess().getValuePrimitiveValueParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    otherlv_6=(Token)match(input,35,FOLLOW_2); 

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
    // InternalMappingDsl.g:4620:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalMappingDsl.g:4620:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalMappingDsl.g:4621:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalMappingDsl.g:4627:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:4633:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalMappingDsl.g:4634:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalMappingDsl.g:4634:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalMappingDsl.g:4635:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_92); 

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


    // $ANTLR start "entryRuleAnything"
    // InternalMappingDsl.g:4661:1: entryRuleAnything returns [String current=null] : iv_ruleAnything= ruleAnything EOF ;
    public final String entryRuleAnything() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnything = null;


        try {
            // InternalMappingDsl.g:4661:48: (iv_ruleAnything= ruleAnything EOF )
            // InternalMappingDsl.g:4662:2: iv_ruleAnything= ruleAnything EOF
            {
             newCompositeNode(grammarAccess.getAnythingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnything=ruleAnything();

            state._fsp--;

             current =iv_ruleAnything.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnything"


    // $ANTLR start "ruleAnything"
    // InternalMappingDsl.g:4668:1: ruleAnything returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+ ;
    public final AntlrDatatypeRuleToken ruleAnything() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_BOOLEAN_116=null;
        Token this_BIG_DECIMAL_117=null;
        Token this_ID_118=null;
        Token this_STRING_119=null;
        Token this_ANY_OTHER_120=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:4674:2: ( (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+ )
            // InternalMappingDsl.g:4675:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+
            {
            // InternalMappingDsl.g:4675:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+
            int cnt132=0;
            loop132:
            do {
                int alt132=121;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    alt132=1;
                    }
                    break;
                case 16:
                    {
                    alt132=2;
                    }
                    break;
                case 56:
                    {
                    alt132=3;
                    }
                    break;
                case 57:
                    {
                    alt132=4;
                    }
                    break;
                case 33:
                    {
                    alt132=5;
                    }
                    break;
                case 34:
                    {
                    alt132=6;
                    }
                    break;
                case 35:
                    {
                    alt132=7;
                    }
                    break;
                case 17:
                    {
                    alt132=8;
                    }
                    break;
                case 29:
                    {
                    alt132=9;
                    }
                    break;
                case 58:
                    {
                    alt132=10;
                    }
                    break;
                case 59:
                    {
                    alt132=11;
                    }
                    break;
                case 32:
                    {
                    alt132=12;
                    }
                    break;
                case 55:
                    {
                    alt132=13;
                    }
                    break;
                case 25:
                    {
                    alt132=14;
                    }
                    break;
                case 39:
                    {
                    alt132=15;
                    }
                    break;
                case 48:
                    {
                    alt132=16;
                    }
                    break;
                case 26:
                    {
                    alt132=17;
                    }
                    break;
                case 46:
                    {
                    alt132=18;
                    }
                    break;
                case 60:
                    {
                    alt132=19;
                    }
                    break;
                case 61:
                    {
                    alt132=20;
                    }
                    break;
                case 62:
                    {
                    alt132=21;
                    }
                    break;
                case 18:
                    {
                    alt132=22;
                    }
                    break;
                case 63:
                    {
                    alt132=23;
                    }
                    break;
                case 15:
                    {
                    alt132=24;
                    }
                    break;
                case 64:
                    {
                    alt132=25;
                    }
                    break;
                case 65:
                    {
                    alt132=26;
                    }
                    break;
                case 66:
                    {
                    alt132=27;
                    }
                    break;
                case 21:
                    {
                    alt132=28;
                    }
                    break;
                case 36:
                    {
                    alt132=29;
                    }
                    break;
                case 37:
                    {
                    alt132=30;
                    }
                    break;
                case 38:
                    {
                    alt132=31;
                    }
                    break;
                case 67:
                    {
                    alt132=32;
                    }
                    break;
                case 68:
                    {
                    alt132=33;
                    }
                    break;
                case 69:
                    {
                    alt132=34;
                    }
                    break;
                case 70:
                    {
                    alt132=35;
                    }
                    break;
                case 71:
                    {
                    alt132=36;
                    }
                    break;
                case 72:
                    {
                    alt132=37;
                    }
                    break;
                case 73:
                    {
                    alt132=38;
                    }
                    break;
                case 74:
                    {
                    alt132=39;
                    }
                    break;
                case 75:
                    {
                    alt132=40;
                    }
                    break;
                case 76:
                    {
                    alt132=41;
                    }
                    break;
                case 24:
                    {
                    alt132=42;
                    }
                    break;
                case 13:
                    {
                    alt132=43;
                    }
                    break;
                case 77:
                    {
                    alt132=44;
                    }
                    break;
                case 78:
                    {
                    alt132=45;
                    }
                    break;
                case 79:
                    {
                    alt132=46;
                    }
                    break;
                case 80:
                    {
                    alt132=47;
                    }
                    break;
                case 28:
                    {
                    alt132=48;
                    }
                    break;
                case 81:
                    {
                    alt132=49;
                    }
                    break;
                case 82:
                    {
                    alt132=50;
                    }
                    break;
                case 83:
                    {
                    alt132=51;
                    }
                    break;
                case 84:
                    {
                    alt132=52;
                    }
                    break;
                case 85:
                    {
                    alt132=53;
                    }
                    break;
                case 86:
                    {
                    alt132=54;
                    }
                    break;
                case 43:
                    {
                    alt132=55;
                    }
                    break;
                case 44:
                    {
                    alt132=56;
                    }
                    break;
                case 45:
                    {
                    alt132=57;
                    }
                    break;
                case 22:
                    {
                    alt132=58;
                    }
                    break;
                case 87:
                    {
                    alt132=59;
                    }
                    break;
                case 88:
                    {
                    alt132=60;
                    }
                    break;
                case 89:
                    {
                    alt132=61;
                    }
                    break;
                case 90:
                    {
                    alt132=62;
                    }
                    break;
                case 91:
                    {
                    alt132=63;
                    }
                    break;
                case 92:
                    {
                    alt132=64;
                    }
                    break;
                case 93:
                    {
                    alt132=65;
                    }
                    break;
                case 94:
                    {
                    alt132=66;
                    }
                    break;
                case 95:
                    {
                    alt132=67;
                    }
                    break;
                case 41:
                    {
                    alt132=68;
                    }
                    break;
                case 97:
                    {
                    alt132=69;
                    }
                    break;
                case 98:
                    {
                    alt132=70;
                    }
                    break;
                case 99:
                    {
                    alt132=71;
                    }
                    break;
                case 100:
                    {
                    alt132=72;
                    }
                    break;
                case 101:
                    {
                    alt132=73;
                    }
                    break;
                case 102:
                    {
                    alt132=74;
                    }
                    break;
                case 103:
                    {
                    alt132=75;
                    }
                    break;
                case 104:
                    {
                    alt132=76;
                    }
                    break;
                case 105:
                    {
                    alt132=77;
                    }
                    break;
                case 106:
                    {
                    alt132=78;
                    }
                    break;
                case 107:
                    {
                    alt132=79;
                    }
                    break;
                case 108:
                    {
                    alt132=80;
                    }
                    break;
                case 109:
                    {
                    alt132=81;
                    }
                    break;
                case 110:
                    {
                    alt132=82;
                    }
                    break;
                case 111:
                    {
                    alt132=83;
                    }
                    break;
                case 112:
                    {
                    alt132=84;
                    }
                    break;
                case 113:
                    {
                    alt132=85;
                    }
                    break;
                case 114:
                    {
                    alt132=86;
                    }
                    break;
                case 115:
                    {
                    alt132=87;
                    }
                    break;
                case 116:
                    {
                    alt132=88;
                    }
                    break;
                case 117:
                    {
                    alt132=89;
                    }
                    break;
                case 118:
                    {
                    alt132=90;
                    }
                    break;
                case 119:
                    {
                    alt132=91;
                    }
                    break;
                case 120:
                    {
                    alt132=92;
                    }
                    break;
                case 121:
                    {
                    alt132=93;
                    }
                    break;
                case 122:
                    {
                    alt132=94;
                    }
                    break;
                case 123:
                    {
                    alt132=95;
                    }
                    break;
                case 124:
                    {
                    alt132=96;
                    }
                    break;
                case 125:
                    {
                    alt132=97;
                    }
                    break;
                case 126:
                    {
                    alt132=98;
                    }
                    break;
                case 127:
                    {
                    alt132=99;
                    }
                    break;
                case 128:
                    {
                    alt132=100;
                    }
                    break;
                case 129:
                    {
                    alt132=101;
                    }
                    break;
                case 130:
                    {
                    alt132=102;
                    }
                    break;
                case 131:
                    {
                    alt132=103;
                    }
                    break;
                case 132:
                    {
                    alt132=104;
                    }
                    break;
                case 19:
                    {
                    alt132=105;
                    }
                    break;
                case 40:
                    {
                    alt132=106;
                    }
                    break;
                case 42:
                    {
                    alt132=107;
                    }
                    break;
                case 47:
                    {
                    alt132=108;
                    }
                    break;
                case 49:
                    {
                    alt132=109;
                    }
                    break;
                case 20:
                    {
                    alt132=110;
                    }
                    break;
                case 133:
                    {
                    alt132=111;
                    }
                    break;
                case 53:
                    {
                    alt132=112;
                    }
                    break;
                case 54:
                    {
                    alt132=113;
                    }
                    break;
                case 134:
                    {
                    alt132=114;
                    }
                    break;
                case 135:
                    {
                    alt132=115;
                    }
                    break;
                case RULE_BOOLEAN:
                    {
                    alt132=116;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt132=117;
                    }
                    break;
                case RULE_ID:
                    {
                    alt132=118;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt132=119;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt132=120;
                    }
                    break;

                }

                switch (alt132) {
            	case 1 :
            	    // InternalMappingDsl.g:4676:3: kw= '{'
            	    {
            	    kw=(Token)match(input,14,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftCurlyBracketKeyword_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalMappingDsl.g:4682:3: kw= '}'
            	    {
            	    kw=(Token)match(input,16,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightCurlyBracketKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalMappingDsl.g:4688:3: kw= '<'
            	    {
            	    kw=(Token)match(input,56,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignKeyword_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalMappingDsl.g:4694:3: kw= '>'
            	    {
            	    kw=(Token)match(input,57,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getGreaterThanSignKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalMappingDsl.g:4700:3: kw= ','
            	    {
            	    kw=(Token)match(input,33,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommaKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalMappingDsl.g:4706:3: kw= '('
            	    {
            	    kw=(Token)match(input,34,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftParenthesisKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalMappingDsl.g:4712:3: kw= ')'
            	    {
            	    kw=(Token)match(input,35,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightParenthesisKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalMappingDsl.g:4718:3: kw= '::'
            	    {
            	    kw=(Token)match(input,17,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonColonKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalMappingDsl.g:4724:3: kw= '.'
            	    {
            	    kw=(Token)match(input,29,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFullStopKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalMappingDsl.g:4730:3: kw= '-'
            	    {
            	    kw=(Token)match(input,58,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalMappingDsl.g:4736:3: kw= '--'
            	    {
            	    kw=(Token)match(input,59,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusHyphenMinusKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalMappingDsl.g:4742:3: kw= '/'
            	    {
            	    kw=(Token)match(input,32,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSolidusKeyword_11());
            	    		

            	    }
            	    break;
            	case 13 :
            	    // InternalMappingDsl.g:4748:3: kw= '?'
            	    {
            	    kw=(Token)match(input,55,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getQuestionMarkKeyword_12());
            	    		

            	    }
            	    break;
            	case 14 :
            	    // InternalMappingDsl.g:4754:3: kw= ':'
            	    {
            	    kw=(Token)match(input,25,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonKeyword_13());
            	    		

            	    }
            	    break;
            	case 15 :
            	    // InternalMappingDsl.g:4760:3: kw= '@'
            	    {
            	    kw=(Token)match(input,39,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommercialAtKeyword_14());
            	    		

            	    }
            	    break;
            	case 16 :
            	    // InternalMappingDsl.g:4766:3: kw= '='
            	    {
            	    kw=(Token)match(input,48,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEqualsSignKeyword_15());
            	    		

            	    }
            	    break;
            	case 17 :
            	    // InternalMappingDsl.g:4772:3: kw= ';'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSemicolonKeyword_16());
            	    		

            	    }
            	    break;
            	case 18 :
            	    // InternalMappingDsl.g:4778:3: kw= 'technology'
            	    {
            	    kw=(Token)match(input,46,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologyKeyword_17());
            	    		

            	    }
            	    break;
            	case 19 :
            	    // InternalMappingDsl.g:4784:3: kw= 'types'
            	    {
            	    kw=(Token)match(input,60,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypesKeyword_18());
            	    		

            	    }
            	    break;
            	case 20 :
            	    // InternalMappingDsl.g:4790:3: kw= 'compatibility'
            	    {
            	    kw=(Token)match(input,61,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCompatibilityKeyword_19());
            	    		

            	    }
            	    break;
            	case 21 :
            	    // InternalMappingDsl.g:4796:3: kw= 'matrix'
            	    {
            	    kw=(Token)match(input,62,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMatrixKeyword_20());
            	    		

            	    }
            	    break;
            	case 22 :
            	    // InternalMappingDsl.g:4802:3: kw= 'protocols'
            	    {
            	    kw=(Token)match(input,18,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolsKeyword_21());
            	    		

            	    }
            	    break;
            	case 23 :
            	    // InternalMappingDsl.g:4808:3: kw= 'service'
            	    {
            	    kw=(Token)match(input,63,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getServiceKeyword_22());
            	    		

            	    }
            	    break;
            	case 24 :
            	    // InternalMappingDsl.g:4814:3: kw= 'aspects'
            	    {
            	    kw=(Token)match(input,15,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectsKeyword_23());
            	    		

            	    }
            	    break;
            	case 25 :
            	    // InternalMappingDsl.g:4820:3: kw= 'deployment'
            	    {
            	    kw=(Token)match(input,64,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDeploymentKeyword_24());
            	    		

            	    }
            	    break;
            	case 26 :
            	    // InternalMappingDsl.g:4826:3: kw= 'technologies'
            	    {
            	    kw=(Token)match(input,65,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologiesKeyword_25());
            	    		

            	    }
            	    break;
            	case 27 :
            	    // InternalMappingDsl.g:4832:3: kw= 'infrastructure'
            	    {
            	    kw=(Token)match(input,66,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureKeyword_26());
            	    		

            	    }
            	    break;
            	case 28 :
            	    // InternalMappingDsl.g:4838:3: kw= 'operation'
            	    {
            	    kw=(Token)match(input,21,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationKeyword_27());
            	    		

            	    }
            	    break;
            	case 29 :
            	    // InternalMappingDsl.g:4844:3: kw= 'import'
            	    {
            	    kw=(Token)match(input,36,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImportKeyword_28());
            	    		

            	    }
            	    break;
            	case 30 :
            	    // InternalMappingDsl.g:4850:3: kw= 'from'
            	    {
            	    kw=(Token)match(input,37,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFromKeyword_29());
            	    		

            	    }
            	    break;
            	case 31 :
            	    // InternalMappingDsl.g:4856:3: kw= 'as'
            	    {
            	    kw=(Token)match(input,38,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsKeyword_30());
            	    		

            	    }
            	    break;
            	case 32 :
            	    // InternalMappingDsl.g:4862:3: kw= 'data'
            	    {
            	    kw=(Token)match(input,67,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDataKeyword_31());
            	    		

            	    }
            	    break;
            	case 33 :
            	    // InternalMappingDsl.g:4868:3: kw= 'formats'
            	    {
            	    kw=(Token)match(input,68,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatsKeyword_32());
            	    		

            	    }
            	    break;
            	case 34 :
            	    // InternalMappingDsl.g:4874:3: kw= 'default'
            	    {
            	    kw=(Token)match(input,69,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDefaultKeyword_33());
            	    		

            	    }
            	    break;
            	case 35 :
            	    // InternalMappingDsl.g:4880:3: kw= 'with'
            	    {
            	    kw=(Token)match(input,70,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getWithKeyword_34());
            	    		

            	    }
            	    break;
            	case 36 :
            	    // InternalMappingDsl.g:4886:3: kw= 'format'
            	    {
            	    kw=(Token)match(input,71,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatKeyword_35());
            	    		

            	    }
            	    break;
            	case 37 :
            	    // InternalMappingDsl.g:4892:3: kw= 'in'
            	    {
            	    kw=(Token)match(input,72,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInKeyword_36());
            	    		

            	    }
            	    break;
            	case 38 :
            	    // InternalMappingDsl.g:4898:3: kw= 'out'
            	    {
            	    kw=(Token)match(input,73,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOutKeyword_37());
            	    		

            	    }
            	    break;
            	case 39 :
            	    // InternalMappingDsl.g:4904:3: kw= 'inout'
            	    {
            	    kw=(Token)match(input,74,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInoutKeyword_38());
            	    		

            	    }
            	    break;
            	case 40 :
            	    // InternalMappingDsl.g:4910:3: kw= 'sync'
            	    {
            	    kw=(Token)match(input,75,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSyncKeyword_39());
            	    		

            	    }
            	    break;
            	case 41 :
            	    // InternalMappingDsl.g:4916:3: kw= 'async'
            	    {
            	    kw=(Token)match(input,76,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsyncKeyword_40());
            	    		

            	    }
            	    break;
            	case 42 :
            	    // InternalMappingDsl.g:4922:3: kw= 'primitive'
            	    {
            	    kw=(Token)match(input,24,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPrimitiveKeyword_41());
            	    		

            	    }
            	    break;
            	case 43 :
            	    // InternalMappingDsl.g:4928:3: kw= 'type'
            	    {
            	    kw=(Token)match(input,13,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypeKeyword_42());
            	    		

            	    }
            	    break;
            	case 44 :
            	    // InternalMappingDsl.g:4934:3: kw= 'based'
            	    {
            	    kw=(Token)match(input,77,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBasedKeyword_43());
            	    		

            	    }
            	    break;
            	case 45 :
            	    // InternalMappingDsl.g:4940:3: kw= 'on'
            	    {
            	    kw=(Token)match(input,78,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOnKeyword_44());
            	    		

            	    }
            	    break;
            	case 46 :
            	    // InternalMappingDsl.g:4946:3: kw= 'list'
            	    {
            	    kw=(Token)match(input,79,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getListKeyword_45());
            	    		

            	    }
            	    break;
            	case 47 :
            	    // InternalMappingDsl.g:4952:3: kw= 'structure'
            	    {
            	    kw=(Token)match(input,80,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStructureKeyword_46());
            	    		

            	    }
            	    break;
            	case 48 :
            	    // InternalMappingDsl.g:4958:3: kw= '->'
            	    {
            	    kw=(Token)match(input,28,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusGreaterThanSignKeyword_47());
            	    		

            	    }
            	    break;
            	case 49 :
            	    // InternalMappingDsl.g:4964:3: kw= '<-'
            	    {
            	    kw=(Token)match(input,81,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusKeyword_48());
            	    		

            	    }
            	    break;
            	case 50 :
            	    // InternalMappingDsl.g:4970:3: kw= '<->'
            	    {
            	    kw=(Token)match(input,82,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_49());
            	    		

            	    }
            	    break;
            	case 51 :
            	    // InternalMappingDsl.g:4976:3: kw= 'environments'
            	    {
            	    kw=(Token)match(input,83,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnvironmentsKeyword_50());
            	    		

            	    }
            	    break;
            	case 52 :
            	    // InternalMappingDsl.g:4982:3: kw= 'properties'
            	    {
            	    kw=(Token)match(input,84,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPropertiesKeyword_51());
            	    		

            	    }
            	    break;
            	case 53 :
            	    // InternalMappingDsl.g:4988:3: kw= 'mandatory'
            	    {
            	    kw=(Token)match(input,85,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMandatoryKeyword_52());
            	    		

            	    }
            	    break;
            	case 54 :
            	    // InternalMappingDsl.g:4994:3: kw= 'singleval'
            	    {
            	    kw=(Token)match(input,86,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSinglevalKeyword_53());
            	    		

            	    }
            	    break;
            	case 55 :
            	    // InternalMappingDsl.g:5000:3: kw= 'microservices'
            	    {
            	    kw=(Token)match(input,43,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroservicesKeyword_54());
            	    		

            	    }
            	    break;
            	case 56 :
            	    // InternalMappingDsl.g:5006:3: kw= 'interfaces'
            	    {
            	    kw=(Token)match(input,44,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfacesKeyword_55());
            	    		

            	    }
            	    break;
            	case 57 :
            	    // InternalMappingDsl.g:5012:3: kw= 'operations'
            	    {
            	    kw=(Token)match(input,45,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationsKeyword_56());
            	    		

            	    }
            	    break;
            	case 58 :
            	    // InternalMappingDsl.g:5018:3: kw= 'parameters'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParametersKeyword_57());
            	    		

            	    }
            	    break;
            	case 59 :
            	    // InternalMappingDsl.g:5024:3: kw= 'fields'
            	    {
            	    kw=(Token)match(input,87,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFieldsKeyword_58());
            	    		

            	    }
            	    break;
            	case 60 :
            	    // InternalMappingDsl.g:5030:3: kw= 'exchange_pattern'
            	    {
            	    kw=(Token)match(input,88,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExchange_patternKeyword_59());
            	    		

            	    }
            	    break;
            	case 61 :
            	    // InternalMappingDsl.g:5036:3: kw= 'communication_type'
            	    {
            	    kw=(Token)match(input,89,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommunication_typeKeyword_60());
            	    		

            	    }
            	    break;
            	case 62 :
            	    // InternalMappingDsl.g:5042:3: kw= 'protocol'
            	    {
            	    kw=(Token)match(input,90,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolKeyword_61());
            	    		

            	    }
            	    break;
            	case 63 :
            	    // InternalMappingDsl.g:5048:3: kw= 'data_format'
            	    {
            	    kw=(Token)match(input,91,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getData_formatKeyword_62());
            	    		

            	    }
            	    break;
            	case 64 :
            	    // InternalMappingDsl.g:5054:3: kw= 'aspect'
            	    {
            	    kw=(Token)match(input,92,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectKeyword_63());
            	    		

            	    }
            	    break;
            	case 65 :
            	    // InternalMappingDsl.g:5060:3: kw= 'for'
            	    {
            	    kw=(Token)match(input,93,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getForKeyword_64());
            	    		

            	    }
            	    break;
            	case 66 :
            	    // InternalMappingDsl.g:5066:3: kw= 'containers'
            	    {
            	    kw=(Token)match(input,94,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContainersKeyword_65());
            	    		

            	    }
            	    break;
            	case 67 :
            	    // InternalMappingDsl.g:5072:3: (kw= 'selector' kw= 'datatypes' )
            	    {
            	    // InternalMappingDsl.g:5072:3: (kw= 'selector' kw= 'datatypes' )
            	    // InternalMappingDsl.g:5073:4: kw= 'selector' kw= 'datatypes'
            	    {
            	    kw=(Token)match(input,95,FOLLOW_94); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getSelectorKeyword_66_0());
            	    			
            	    kw=(Token)match(input,96,FOLLOW_93); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getDatatypesKeyword_66_1());
            	    			

            	    }


            	    }
            	    break;
            	case 68 :
            	    // InternalMappingDsl.g:5085:3: kw= 'version'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getVersionKeyword_67());
            	    		

            	    }
            	    break;
            	case 69 :
            	    // InternalMappingDsl.g:5091:3: kw= 'context'
            	    {
            	    kw=(Token)match(input,97,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContextKeyword_68());
            	    		

            	    }
            	    break;
            	case 70 :
            	    // InternalMappingDsl.g:5097:3: kw= 'aggregate'
            	    {
            	    kw=(Token)match(input,98,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAggregateKeyword_69());
            	    		

            	    }
            	    break;
            	case 71 :
            	    // InternalMappingDsl.g:5103:3: kw= 'applicationService'
            	    {
            	    kw=(Token)match(input,99,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getApplicationServiceKeyword_70());
            	    		

            	    }
            	    break;
            	case 72 :
            	    // InternalMappingDsl.g:5109:3: kw= 'domainEvent'
            	    {
            	    kw=(Token)match(input,100,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainEventKeyword_71());
            	    		

            	    }
            	    break;
            	case 73 :
            	    // InternalMappingDsl.g:5115:3: kw= 'domainService'
            	    {
            	    kw=(Token)match(input,101,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainServiceKeyword_72());
            	    		

            	    }
            	    break;
            	case 74 :
            	    // InternalMappingDsl.g:5121:3: kw= 'entity'
            	    {
            	    kw=(Token)match(input,102,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEntityKeyword_73());
            	    		

            	    }
            	    break;
            	case 75 :
            	    // InternalMappingDsl.g:5127:3: kw= 'factory'
            	    {
            	    kw=(Token)match(input,103,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFactoryKeyword_74());
            	    		

            	    }
            	    break;
            	case 76 :
            	    // InternalMappingDsl.g:5133:3: kw= 'infrastructureService'
            	    {
            	    kw=(Token)match(input,104,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureServiceKeyword_75());
            	    		

            	    }
            	    break;
            	case 77 :
            	    // InternalMappingDsl.g:5139:3: kw= 'repository'
            	    {
            	    kw=(Token)match(input,105,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRepositoryKeyword_76());
            	    		

            	    }
            	    break;
            	case 78 :
            	    // InternalMappingDsl.g:5145:3: kw= 'specification'
            	    {
            	    kw=(Token)match(input,106,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSpecificationKeyword_77());
            	    		

            	    }
            	    break;
            	case 79 :
            	    // InternalMappingDsl.g:5151:3: kw= 'valueObject'
            	    {
            	    kw=(Token)match(input,107,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValueObjectKeyword_78());
            	    		

            	    }
            	    break;
            	case 80 :
            	    // InternalMappingDsl.g:5157:3: kw= 'extends'
            	    {
            	    kw=(Token)match(input,108,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExtendsKeyword_79());
            	    		

            	    }
            	    break;
            	case 81 :
            	    // InternalMappingDsl.g:5163:3: kw= 'identifier'
            	    {
            	    kw=(Token)match(input,109,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIdentifierKeyword_80());
            	    		

            	    }
            	    break;
            	case 82 :
            	    // InternalMappingDsl.g:5169:3: kw= 'neverEmpty'
            	    {
            	    kw=(Token)match(input,110,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNeverEmptyKeyword_81());
            	    		

            	    }
            	    break;
            	case 83 :
            	    // InternalMappingDsl.g:5175:3: kw= 'part'
            	    {
            	    kw=(Token)match(input,111,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPartKeyword_82());
            	    		

            	    }
            	    break;
            	case 84 :
            	    // InternalMappingDsl.g:5181:3: kw= 'hide'
            	    {
            	    kw=(Token)match(input,112,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHideKeyword_83());
            	    		

            	    }
            	    break;
            	case 85 :
            	    // InternalMappingDsl.g:5187:3: kw= 'immutable'
            	    {
            	    kw=(Token)match(input,113,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImmutableKeyword_84());
            	    		

            	    }
            	    break;
            	case 86 :
            	    // InternalMappingDsl.g:5193:3: kw= 'enum'
            	    {
            	    kw=(Token)match(input,114,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnumKeyword_85());
            	    		

            	    }
            	    break;
            	case 87 :
            	    // InternalMappingDsl.g:5199:3: kw= 'closure'
            	    {
            	    kw=(Token)match(input,115,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getClosureKeyword_86());
            	    		

            	    }
            	    break;
            	case 88 :
            	    // InternalMappingDsl.g:5205:3: kw= 'sideEffectFree'
            	    {
            	    kw=(Token)match(input,116,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSideEffectFreeKeyword_87());
            	    		

            	    }
            	    break;
            	case 89 :
            	    // InternalMappingDsl.g:5211:3: kw= 'validator'
            	    {
            	    kw=(Token)match(input,117,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValidatorKeyword_88());
            	    		

            	    }
            	    break;
            	case 90 :
            	    // InternalMappingDsl.g:5217:3: kw= 'function'
            	    {
            	    kw=(Token)match(input,118,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionKeyword_89());
            	    		

            	    }
            	    break;
            	case 91 :
            	    // InternalMappingDsl.g:5223:3: kw= 'procedure'
            	    {
            	    kw=(Token)match(input,119,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProcedureKeyword_90());
            	    		

            	    }
            	    break;
            	case 92 :
            	    // InternalMappingDsl.g:5229:3: kw= 'boolean'
            	    {
            	    kw=(Token)match(input,120,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBooleanKeyword_91());
            	    		

            	    }
            	    break;
            	case 93 :
            	    // InternalMappingDsl.g:5235:3: kw= 'byte'
            	    {
            	    kw=(Token)match(input,121,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getByteKeyword_92());
            	    		

            	    }
            	    break;
            	case 94 :
            	    // InternalMappingDsl.g:5241:3: kw= 'char'
            	    {
            	    kw=(Token)match(input,122,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCharKeyword_93());
            	    		

            	    }
            	    break;
            	case 95 :
            	    // InternalMappingDsl.g:5247:3: kw= 'date'
            	    {
            	    kw=(Token)match(input,123,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDateKeyword_94());
            	    		

            	    }
            	    break;
            	case 96 :
            	    // InternalMappingDsl.g:5253:3: kw= 'double'
            	    {
            	    kw=(Token)match(input,124,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDoubleKeyword_95());
            	    		

            	    }
            	    break;
            	case 97 :
            	    // InternalMappingDsl.g:5259:3: kw= 'float'
            	    {
            	    kw=(Token)match(input,125,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFloatKeyword_96());
            	    		

            	    }
            	    break;
            	case 98 :
            	    // InternalMappingDsl.g:5265:3: kw= 'int'
            	    {
            	    kw=(Token)match(input,126,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIntKeyword_97());
            	    		

            	    }
            	    break;
            	case 99 :
            	    // InternalMappingDsl.g:5271:3: kw= 'long'
            	    {
            	    kw=(Token)match(input,127,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLongKeyword_98());
            	    		

            	    }
            	    break;
            	case 100 :
            	    // InternalMappingDsl.g:5277:3: kw= 'short'
            	    {
            	    kw=(Token)match(input,128,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getShortKeyword_99());
            	    		

            	    }
            	    break;
            	case 101 :
            	    // InternalMappingDsl.g:5283:3: kw= 'string'
            	    {
            	    kw=(Token)match(input,129,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStringKeyword_100());
            	    		

            	    }
            	    break;
            	case 102 :
            	    // InternalMappingDsl.g:5289:3: kw= 'internal'
            	    {
            	    kw=(Token)match(input,130,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInternalKeyword_101());
            	    		

            	    }
            	    break;
            	case 103 :
            	    // InternalMappingDsl.g:5295:3: kw= 'architecture'
            	    {
            	    kw=(Token)match(input,131,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getArchitectureKeyword_102());
            	    		

            	    }
            	    break;
            	case 104 :
            	    // InternalMappingDsl.g:5301:3: kw= 'public'
            	    {
            	    kw=(Token)match(input,132,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPublicKeyword_103());
            	    		

            	    }
            	    break;
            	case 105 :
            	    // InternalMappingDsl.g:5307:3: kw= 'endpoints'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEndpointsKeyword_104());
            	    		

            	    }
            	    break;
            	case 106 :
            	    // InternalMappingDsl.g:5313:3: kw= 'microservice'
            	    {
            	    kw=(Token)match(input,40,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroserviceKeyword_105());
            	    		

            	    }
            	    break;
            	case 107 :
            	    // InternalMappingDsl.g:5319:3: kw= 'required'
            	    {
            	    kw=(Token)match(input,42,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRequiredKeyword_106());
            	    		

            	    }
            	    break;
            	case 108 :
            	    // InternalMappingDsl.g:5325:3: kw= 'typedef'
            	    {
            	    kw=(Token)match(input,47,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypedefKeyword_107());
            	    		

            	    }
            	    break;
            	case 109 :
            	    // InternalMappingDsl.g:5331:3: kw= 'noimpl'
            	    {
            	    kw=(Token)match(input,49,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNoimplKeyword_108());
            	    		

            	    }
            	    break;
            	case 110 :
            	    // InternalMappingDsl.g:5337:3: kw= 'interface'
            	    {
            	    kw=(Token)match(input,20,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfaceKeyword_109());
            	    		

            	    }
            	    break;
            	case 111 :
            	    // InternalMappingDsl.g:5343:3: kw= 'param'
            	    {
            	    kw=(Token)match(input,133,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParamKeyword_110());
            	    		

            	    }
            	    break;
            	case 112 :
            	    // InternalMappingDsl.g:5349:3: kw= 'refers'
            	    {
            	    kw=(Token)match(input,53,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRefersKeyword_111());
            	    		

            	    }
            	    break;
            	case 113 :
            	    // InternalMappingDsl.g:5355:3: kw= 'fault'
            	    {
            	    kw=(Token)match(input,54,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFaultKeyword_112());
            	    		

            	    }
            	    break;
            	case 114 :
            	    // InternalMappingDsl.g:5361:3: kw= 'functional'
            	    {
            	    kw=(Token)match(input,134,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionalKeyword_113());
            	    		

            	    }
            	    break;
            	case 115 :
            	    // InternalMappingDsl.g:5367:3: kw= 'utility'
            	    {
            	    kw=(Token)match(input,135,FOLLOW_93); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getUtilityKeyword_114());
            	    		

            	    }
            	    break;
            	case 116 :
            	    // InternalMappingDsl.g:5373:3: this_BOOLEAN_116= RULE_BOOLEAN
            	    {
            	    this_BOOLEAN_116=(Token)match(input,RULE_BOOLEAN,FOLLOW_93); 

            	    			current.merge(this_BOOLEAN_116);
            	    		

            	    			newLeafNode(this_BOOLEAN_116, grammarAccess.getAnythingAccess().getBOOLEANTerminalRuleCall_115());
            	    		

            	    }
            	    break;
            	case 117 :
            	    // InternalMappingDsl.g:5381:3: this_BIG_DECIMAL_117= RULE_BIG_DECIMAL
            	    {
            	    this_BIG_DECIMAL_117=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_93); 

            	    			current.merge(this_BIG_DECIMAL_117);
            	    		

            	    			newLeafNode(this_BIG_DECIMAL_117, grammarAccess.getAnythingAccess().getBIG_DECIMALTerminalRuleCall_116());
            	    		

            	    }
            	    break;
            	case 118 :
            	    // InternalMappingDsl.g:5389:3: this_ID_118= RULE_ID
            	    {
            	    this_ID_118=(Token)match(input,RULE_ID,FOLLOW_93); 

            	    			current.merge(this_ID_118);
            	    		

            	    			newLeafNode(this_ID_118, grammarAccess.getAnythingAccess().getIDTerminalRuleCall_117());
            	    		

            	    }
            	    break;
            	case 119 :
            	    // InternalMappingDsl.g:5397:3: this_STRING_119= RULE_STRING
            	    {
            	    this_STRING_119=(Token)match(input,RULE_STRING,FOLLOW_93); 

            	    			current.merge(this_STRING_119);
            	    		

            	    			newLeafNode(this_STRING_119, grammarAccess.getAnythingAccess().getSTRINGTerminalRuleCall_118());
            	    		

            	    }
            	    break;
            	case 120 :
            	    // InternalMappingDsl.g:5405:3: this_ANY_OTHER_120= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_120=(Token)match(input,RULE_ANY_OTHER,FOLLOW_93); 

            	    			current.merge(this_ANY_OTHER_120);
            	    		

            	    			newLeafNode(this_ANY_OTHER_120, grammarAccess.getAnythingAccess().getANY_OTHERTerminalRuleCall_119());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt132 >= 1 ) break loop132;
                        EarlyExitException eee =
                            new EarlyExitException(132, input);
                        throw eee;
                }
                cnt132++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnything"


    // $ANTLR start "entryRuleTechnologyImport"
    // InternalMappingDsl.g:5416:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalMappingDsl.g:5416:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalMappingDsl.g:5417:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalMappingDsl.g:5423:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:5429:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:5430:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:5430:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5431:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_69); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,37,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:5443:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:5444:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:5444:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:5445:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_56); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getTechnologyImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:5465:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:5466:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:5466:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:5467:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:5487:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalMappingDsl.g:5487:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalMappingDsl.g:5488:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalMappingDsl.g:5494:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalMappingDsl.g:5500:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalMappingDsl.g:5501:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalMappingDsl.g:5501:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalMappingDsl.g:5502:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalMappingDsl.g:5502:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalMappingDsl.g:5503:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalMappingDsl.g:5503:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalMappingDsl.g:5504:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalMappingDsl.g:5521:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:5522:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:5522:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:5523:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_95); 

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

            otherlv_2=(Token)match(input,67,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,68,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalMappingDsl.g:5547:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalMappingDsl.g:5548:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalMappingDsl.g:5548:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalMappingDsl.g:5549:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_97);
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

            // InternalMappingDsl.g:5566:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( (LA133_0==33) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // InternalMappingDsl.g:5567:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,33,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:5571:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalMappingDsl.g:5572:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalMappingDsl.g:5572:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalMappingDsl.g:5573:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_97);
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
            	    break loop133;
                }
            } while (true);

            // InternalMappingDsl.g:5591:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==69) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalMappingDsl.g:5592:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:5592:4: ( (lv_default_7_0= 'default' ) )
                    // InternalMappingDsl.g:5593:5: (lv_default_7_0= 'default' )
                    {
                    // InternalMappingDsl.g:5593:5: (lv_default_7_0= 'default' )
                    // InternalMappingDsl.g:5594:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,69,FOLLOW_98); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,70,FOLLOW_99); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,71,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalMappingDsl.g:5614:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMappingDsl.g:5615:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMappingDsl.g:5615:5: (otherlv_10= RULE_ID )
                    // InternalMappingDsl.g:5616:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_53); 

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
    // InternalMappingDsl.g:5636:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalMappingDsl.g:5636:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalMappingDsl.g:5637:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalMappingDsl.g:5643:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5649:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalMappingDsl.g:5650:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:5650:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalMappingDsl.g:5651:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:5651:3: (lv_formatName_0_0= RULE_ID )
            // InternalMappingDsl.g:5652:4: lv_formatName_0_0= RULE_ID
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
    // InternalMappingDsl.g:5671:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalMappingDsl.g:5671:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalMappingDsl.g:5672:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalMappingDsl.g:5678:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:5684:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:5685:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:5685:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalMappingDsl.g:5686:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:5694:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:5695:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:5695:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:5696:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_100); 

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

            // InternalMappingDsl.g:5712:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==77) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalMappingDsl.g:5713:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,77,FOLLOW_101); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,78,FOLLOW_102); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalMappingDsl.g:5721:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:5722:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:5722:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalMappingDsl.g:5723:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_97);
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

                    // InternalMappingDsl.g:5740:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( (LA135_0==33) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // InternalMappingDsl.g:5741:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,33,FOLLOW_102); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMappingDsl.g:5745:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalMappingDsl.g:5746:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalMappingDsl.g:5746:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalMappingDsl.g:5747:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_97);
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
                    	    break loop135;
                        }
                    } while (true);

                    // InternalMappingDsl.g:5765:4: ( (lv_default_8_0= 'default' ) )?
                    int alt136=2;
                    int LA136_0 = input.LA(1);

                    if ( (LA136_0==69) ) {
                        alt136=1;
                    }
                    switch (alt136) {
                        case 1 :
                            // InternalMappingDsl.g:5766:5: (lv_default_8_0= 'default' )
                            {
                            // InternalMappingDsl.g:5766:5: (lv_default_8_0= 'default' )
                            // InternalMappingDsl.g:5767:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,69,FOLLOW_53); 

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
    // InternalMappingDsl.g:5788:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalMappingDsl.g:5788:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalMappingDsl.g:5789:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalMappingDsl.g:5795:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5801:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:5802:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:5802:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:5803:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:5811:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:5812:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:5812:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:5813:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_53); 

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
    // InternalMappingDsl.g:5837:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalMappingDsl.g:5837:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalMappingDsl.g:5838:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalMappingDsl.g:5844:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5850:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalMappingDsl.g:5851:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalMappingDsl.g:5851:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalMappingDsl.g:5852:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalMappingDsl.g:5860:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMappingDsl.g:5861:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMappingDsl.g:5861:4: (lv_name_2_0= RULE_ID )
            // InternalMappingDsl.g:5862:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_53); 

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
    // InternalMappingDsl.g:5886:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalMappingDsl.g:5886:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalMappingDsl.g:5887:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalMappingDsl.g:5893:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:5899:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:5900:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:5900:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:5901:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:5901:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==RULE_ID) ) {
                int LA138_1 = input.LA(2);

                if ( (LA138_1==17) ) {
                    alt138=1;
                }
            }
            switch (alt138) {
                case 1 :
                    // InternalMappingDsl.g:5902:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalMappingDsl.g:5902:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMappingDsl.g:5903:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:5903:5: (otherlv_0= RULE_ID )
                    // InternalMappingDsl.g:5904:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:5920:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:5921:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:5921:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:5922:5: ruleQualifiedName
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
    // InternalMappingDsl.g:5940:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalMappingDsl.g:5940:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalMappingDsl.g:5941:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalMappingDsl.g:5947:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalMappingDsl.g:5953:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalMappingDsl.g:5954:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalMappingDsl.g:5954:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalMappingDsl.g:5955:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalMappingDsl.g:5955:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:5956:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:5956:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:5957:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_103);
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

            // InternalMappingDsl.g:5974:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop139:
            do {
                int alt139=2;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==33) ) {
                    alt139=1;
                }


                switch (alt139) {
            	case 1 :
            	    // InternalMappingDsl.g:5975:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMappingDsl.g:5979:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalMappingDsl.g:5980:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalMappingDsl.g:5980:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalMappingDsl.g:5981:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_103);
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
            	    break loop139;
                }
            } while (true);

            // InternalMappingDsl.g:5999:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalMappingDsl.g:6000:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalMappingDsl.g:6000:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalMappingDsl.g:6001:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalMappingDsl.g:6018:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalMappingDsl.g:6019:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalMappingDsl.g:6019:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalMappingDsl.g:6020:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_53);
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
    // InternalMappingDsl.g:6045:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalMappingDsl.g:6045:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalMappingDsl.g:6046:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalMappingDsl.g:6052:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:6058:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:6059:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:6059:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:6060:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:6060:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:6061:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:6061:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:6062:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,14,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_104); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,83,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_47); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:6094:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:6095:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:6095:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:6096:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_48);
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

            // InternalMappingDsl.g:6113:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( (LA140_0==33) ) {
                    alt140=1;
                }


                switch (alt140) {
            	case 1 :
            	    // InternalMappingDsl.g:6114:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,33,FOLLOW_47); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:6118:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:6119:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:6119:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:6120:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop140;
                }
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_105); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:6142:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==63) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalMappingDsl.g:6143:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,63,FOLLOW_106); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,84,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_102); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:6155:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt141=0;
                    loop141:
                    do {
                        int alt141=2;
                        int LA141_0 = input.LA(1);

                        if ( ((LA141_0>=120 && LA141_0<=129)||LA141_0==136) ) {
                            alt141=1;
                        }


                        switch (alt141) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6156:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:6156:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:6157:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_107);
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
                    	    if ( cnt141 >= 1 ) break loop141;
                                EarlyExitException eee =
                                    new EarlyExitException(141, input);
                                throw eee;
                        }
                        cnt141++;
                    } while (true);

                    otherlv_13=(Token)match(input,16,FOLLOW_26); 

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
    // InternalMappingDsl.g:6187:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalMappingDsl.g:6187:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalMappingDsl.g:6188:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalMappingDsl.g:6194:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalMappingDsl.g:6200:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalMappingDsl.g:6201:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalMappingDsl.g:6201:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalMappingDsl.g:6202:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalMappingDsl.g:6202:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:6203:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:6203:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:6204:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,14,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_104); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,83,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_47); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalMappingDsl.g:6236:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalMappingDsl.g:6237:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalMappingDsl.g:6237:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalMappingDsl.g:6238:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_48);
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

            // InternalMappingDsl.g:6255:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop143:
            do {
                int alt143=2;
                int LA143_0 = input.LA(1);

                if ( (LA143_0==33) ) {
                    alt143=1;
                }


                switch (alt143) {
            	case 1 :
            	    // InternalMappingDsl.g:6256:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,33,FOLLOW_47); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMappingDsl.g:6260:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalMappingDsl.g:6261:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalMappingDsl.g:6261:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalMappingDsl.g:6262:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop143;
                }
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_105); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalMappingDsl.g:6284:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==63) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalMappingDsl.g:6285:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,63,FOLLOW_106); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,84,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_102); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalMappingDsl.g:6297:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt144=0;
                    loop144:
                    do {
                        int alt144=2;
                        int LA144_0 = input.LA(1);

                        if ( ((LA144_0>=120 && LA144_0<=129)||LA144_0==136) ) {
                            alt144=1;
                        }


                        switch (alt144) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6298:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:6298:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:6299:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_107);
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
                    	    if ( cnt144 >= 1 ) break loop144;
                                EarlyExitException eee =
                                    new EarlyExitException(144, input);
                                throw eee;
                        }
                        cnt144++;
                    } while (true);

                    otherlv_13=(Token)match(input,16,FOLLOW_26); 

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
    // InternalMappingDsl.g:6329:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalMappingDsl.g:6329:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalMappingDsl.g:6330:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalMappingDsl.g:6336:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6342:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalMappingDsl.g:6343:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalMappingDsl.g:6343:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalMappingDsl.g:6344:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalMappingDsl.g:6344:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalMappingDsl.g:6345:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalMappingDsl.g:6345:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalMappingDsl.g:6346:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_108); 

            					newLeafNode(lv_environmentName_0_0, grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationEnvironmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"environmentName",
            						lv_environmentName_0_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            				

            }


            }

            // InternalMappingDsl.g:6362:3: ( (lv_default_1_0= 'default' ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==69) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalMappingDsl.g:6363:4: (lv_default_1_0= 'default' )
                    {
                    // InternalMappingDsl.g:6363:4: (lv_default_1_0= 'default' )
                    // InternalMappingDsl.g:6364:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,69,FOLLOW_2); 

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
    // InternalMappingDsl.g:6380:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalMappingDsl.g:6380:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalMappingDsl.g:6381:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalMappingDsl.g:6387:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalMappingDsl.g:6393:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalMappingDsl.g:6394:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalMappingDsl.g:6394:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalMappingDsl.g:6395:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalMappingDsl.g:6395:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalMappingDsl.g:6396:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalMappingDsl.g:6396:4: (lv_type_0_0= rulePrimitiveType )
            // InternalMappingDsl.g:6397:5: lv_type_0_0= rulePrimitiveType
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

            // InternalMappingDsl.g:6414:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6415:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6415:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6416:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_109); 

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

            // InternalMappingDsl.g:6432:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==48) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalMappingDsl.g:6433:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_91); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalMappingDsl.g:6437:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:6438:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:6438:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:6439:6: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_110);
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

            // InternalMappingDsl.g:6457:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==56) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalMappingDsl.g:6458:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,56,FOLLOW_111); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalMappingDsl.g:6462:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalMappingDsl.g:6463:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalMappingDsl.g:6463:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalMappingDsl.g:6464:6: lv_features_5_0= rulePropertyFeature
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_112);
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

                    // InternalMappingDsl.g:6481:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop148:
                    do {
                        int alt148=2;
                        int LA148_0 = input.LA(1);

                        if ( (LA148_0==33) ) {
                            alt148=1;
                        }


                        switch (alt148) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6482:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,33,FOLLOW_111); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalMappingDsl.g:6486:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalMappingDsl.g:6487:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalMappingDsl.g:6487:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalMappingDsl.g:6488:7: lv_features_7_0= rulePropertyFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
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
                    	    break loop148;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,57,FOLLOW_53); 

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
    // InternalMappingDsl.g:6519:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalMappingDsl.g:6519:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalMappingDsl.g:6520:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalMappingDsl.g:6526:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalMappingDsl.g:6532:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalMappingDsl.g:6533:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalMappingDsl.g:6533:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt150=4;
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
            case 91:
                {
                alt150=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;
            }

            switch (alt150) {
                case 1 :
                    // InternalMappingDsl.g:6534:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalMappingDsl.g:6534:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalMappingDsl.g:6535:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalMappingDsl.g:6535:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalMappingDsl.g:6536:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalMappingDsl.g:6536:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalMappingDsl.g:6537:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,88,FOLLOW_71); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,48,FOLLOW_113); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalMappingDsl.g:6553:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalMappingDsl.g:6554:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalMappingDsl.g:6554:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalMappingDsl.g:6555:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalMappingDsl.g:6574:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalMappingDsl.g:6574:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalMappingDsl.g:6575:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalMappingDsl.g:6575:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalMappingDsl.g:6576:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalMappingDsl.g:6576:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalMappingDsl.g:6577:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,89,FOLLOW_71); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,48,FOLLOW_16); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalMappingDsl.g:6593:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalMappingDsl.g:6594:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalMappingDsl.g:6594:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalMappingDsl.g:6595:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalMappingDsl.g:6614:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:6614:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalMappingDsl.g:6615:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:6615:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalMappingDsl.g:6616:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalMappingDsl.g:6616:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalMappingDsl.g:6617:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,90,FOLLOW_71); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalMappingDsl.g:6633:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMappingDsl.g:6634:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMappingDsl.g:6634:5: (otherlv_8= RULE_ID )
                    // InternalMappingDsl.g:6635:6: otherlv_8= RULE_ID
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
                    // InternalMappingDsl.g:6648:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalMappingDsl.g:6648:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalMappingDsl.g:6649:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalMappingDsl.g:6649:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalMappingDsl.g:6650:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalMappingDsl.g:6650:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalMappingDsl.g:6651:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,91,FOLLOW_71); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,48,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalMappingDsl.g:6667:4: ( (otherlv_11= RULE_ID ) )
                    // InternalMappingDsl.g:6668:5: (otherlv_11= RULE_ID )
                    {
                    // InternalMappingDsl.g:6668:5: (otherlv_11= RULE_ID )
                    // InternalMappingDsl.g:6669:6: otherlv_11= RULE_ID
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
    // InternalMappingDsl.g:6685:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:6685:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalMappingDsl.g:6686:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalMappingDsl.g:6692:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMappingDsl.g:6698:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:6699:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:6699:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:6700:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_59); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,34,FOLLOW_114); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:6708:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalMappingDsl.g:6709:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalMappingDsl.g:6709:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalMappingDsl.g:6710:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalMappingDsl.g:6727:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop151:
            do {
                int alt151=2;
                int LA151_0 = input.LA(1);

                if ( (LA151_0==33) ) {
                    alt151=1;
                }


                switch (alt151) {
            	case 1 :
            	    // InternalMappingDsl.g:6728:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_114); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:6732:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalMappingDsl.g:6733:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:6733:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalMappingDsl.g:6734:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
            	    break loop151;
                }
            } while (true);

            otherlv_5=(Token)match(input,35,FOLLOW_53); 

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
    // InternalMappingDsl.g:6764:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalMappingDsl.g:6764:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalMappingDsl.g:6765:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalMappingDsl.g:6771:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
    public final EObject ruleServiceAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Enumerator lv_features_3_0 = null;

        Enumerator lv_features_5_0 = null;

        Enumerator lv_joinPoints_8_0 = null;

        Enumerator lv_joinPoints_10_0 = null;

        EObject lv_pointcutSelectors_12_0 = null;

        EObject lv_properties_13_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:6777:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalMappingDsl.g:6778:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalMappingDsl.g:6778:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalMappingDsl.g:6779:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:6783:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:6784:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:6784:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:6785:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_115); 

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

            // InternalMappingDsl.g:6801:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==56) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // InternalMappingDsl.g:6802:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_116); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalMappingDsl.g:6806:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalMappingDsl.g:6807:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalMappingDsl.g:6807:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalMappingDsl.g:6808:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_112);
                    lv_features_3_0=ruleAspectFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_3_0,
                    							"de.fhdo.lemma.technology.TechnologyDsl.AspectFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:6825:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop152:
                    do {
                        int alt152=2;
                        int LA152_0 = input.LA(1);

                        if ( (LA152_0==33) ) {
                            alt152=1;
                        }


                        switch (alt152) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6826:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_116); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalMappingDsl.g:6830:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalMappingDsl.g:6831:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalMappingDsl.g:6831:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalMappingDsl.g:6832:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
                    	    lv_features_5_0=ruleAspectFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_5_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.AspectFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop152;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,57,FOLLOW_117); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,93,FOLLOW_118); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceAspectAccess().getForKeyword_3());
            		
            // InternalMappingDsl.g:6859:3: ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) )
            // InternalMappingDsl.g:6860:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            {
            // InternalMappingDsl.g:6860:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            // InternalMappingDsl.g:6861:5: lv_joinPoints_8_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_119);
            lv_joinPoints_8_0=ruleServiceJoinPointType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceAspectRule());
            					}
            					add(
            						current,
            						"joinPoints",
            						lv_joinPoints_8_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.ServiceJoinPointType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:6878:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )*
            loop154:
            do {
                int alt154=2;
                int LA154_0 = input.LA(1);

                if ( (LA154_0==33) ) {
                    alt154=1;
                }


                switch (alt154) {
            	case 1 :
            	    // InternalMappingDsl.g:6879:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,33,FOLLOW_118); 

            	    				newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:6883:4: ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    // InternalMappingDsl.g:6884:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    {
            	    // InternalMappingDsl.g:6884:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    // InternalMappingDsl.g:6885:6: lv_joinPoints_10_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_119);
            	    lv_joinPoints_10_0=ruleServiceJoinPointType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"joinPoints",
            	    							lv_joinPoints_10_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.ServiceJoinPointType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop154;
                }
            } while (true);

            // InternalMappingDsl.g:6903:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==14) ) {
                alt157=1;
            }
            else if ( (LA157_0==26) ) {
                alt157=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 157, 0, input);

                throw nvae;
            }
            switch (alt157) {
                case 1 :
                    // InternalMappingDsl.g:6904:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalMappingDsl.g:6904:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalMappingDsl.g:6905:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,14,FOLLOW_120); 

                    					newLeafNode(otherlv_11, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalMappingDsl.g:6909:5: ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )*
                    loop155:
                    do {
                        int alt155=2;
                        int LA155_0 = input.LA(1);

                        if ( (LA155_0==95) ) {
                            alt155=1;
                        }


                        switch (alt155) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6910:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:6910:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    // InternalMappingDsl.g:6911:7: lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_120);
                    	    lv_pointcutSelectors_12_0=ruleServiceAspectPointcutSelector();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"pointcutSelectors",
                    	    								lv_pointcutSelectors_12_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.ServiceAspectPointcutSelector");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop155;
                        }
                    } while (true);

                    // InternalMappingDsl.g:6928:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop156:
                    do {
                        int alt156=2;
                        int LA156_0 = input.LA(1);

                        if ( ((LA156_0>=120 && LA156_0<=129)||LA156_0==136) ) {
                            alt156=1;
                        }


                        switch (alt156) {
                    	case 1 :
                    	    // InternalMappingDsl.g:6929:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:6929:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:6930:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_107);
                    	    lv_properties_13_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getServiceAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_13_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop156;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:6953:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getServiceAspectAccess().getSemicolonKeyword_6_1());
                    			

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
    // InternalMappingDsl.g:6962:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalMappingDsl.g:6962:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalMappingDsl.g:6963:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalMappingDsl.g:6969:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:6975:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalMappingDsl.g:6976:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:6976:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalMappingDsl.g:6977:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalMappingDsl.g:6977:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalMappingDsl.g:6978:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalMappingDsl.g:6978:4: (lv_forTechnology_0_0= 'technology' )
            // InternalMappingDsl.g:6979:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,46,FOLLOW_71); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", true, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalMappingDsl.g:6995:3: ( (otherlv_2= RULE_ID ) )
            // InternalMappingDsl.g:6996:4: (otherlv_2= RULE_ID )
            {
            // InternalMappingDsl.g:6996:4: (otherlv_2= RULE_ID )
            // InternalMappingDsl.g:6997:5: otherlv_2= RULE_ID
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
    // InternalMappingDsl.g:7012:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalMappingDsl.g:7012:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalMappingDsl.g:7013:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalMappingDsl.g:7019:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMappingDsl.g:7025:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMappingDsl.g:7026:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMappingDsl.g:7026:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalMappingDsl.g:7027:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_59); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,34,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMappingDsl.g:7035:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalMappingDsl.g:7036:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalMappingDsl.g:7036:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalMappingDsl.g:7037:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
            {

            					newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalMappingDsl.g:7054:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop158:
            do {
                int alt158=2;
                int LA158_0 = input.LA(1);

                if ( (LA158_0==33) ) {
                    alt158=1;
                }


                switch (alt158) {
            	case 1 :
            	    // InternalMappingDsl.g:7055:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_69); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMappingDsl.g:7059:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalMappingDsl.g:7060:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalMappingDsl.g:7060:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalMappingDsl.g:7061:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
            	    break loop158;
                }
            } while (true);

            otherlv_5=(Token)match(input,35,FOLLOW_53); 

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
    // InternalMappingDsl.g:7091:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalMappingDsl.g:7091:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalMappingDsl.g:7092:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalMappingDsl.g:7098:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
    public final EObject ruleOperationAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Enumerator lv_features_3_0 = null;

        Enumerator lv_features_5_0 = null;

        Enumerator lv_joinPoints_8_0 = null;

        Enumerator lv_joinPoints_10_0 = null;

        EObject lv_pointcutSelectors_12_0 = null;

        EObject lv_properties_13_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:7104:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalMappingDsl.g:7105:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalMappingDsl.g:7105:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalMappingDsl.g:7106:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalMappingDsl.g:7110:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:7111:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:7111:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:7112:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_115); 

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

            // InternalMappingDsl.g:7128:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==56) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalMappingDsl.g:7129:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_116); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalMappingDsl.g:7133:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalMappingDsl.g:7134:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalMappingDsl.g:7134:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalMappingDsl.g:7135:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_112);
                    lv_features_3_0=ruleAspectFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_3_0,
                    							"de.fhdo.lemma.technology.TechnologyDsl.AspectFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:7152:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop159:
                    do {
                        int alt159=2;
                        int LA159_0 = input.LA(1);

                        if ( (LA159_0==33) ) {
                            alt159=1;
                        }


                        switch (alt159) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7153:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_116); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalMappingDsl.g:7157:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalMappingDsl.g:7158:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalMappingDsl.g:7158:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalMappingDsl.g:7159:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
                    	    lv_features_5_0=ruleAspectFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_5_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.AspectFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop159;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,57,FOLLOW_117); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,93,FOLLOW_121); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAspectAccess().getForKeyword_3());
            		
            // InternalMappingDsl.g:7186:3: ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) )
            // InternalMappingDsl.g:7187:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            {
            // InternalMappingDsl.g:7187:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            // InternalMappingDsl.g:7188:5: lv_joinPoints_8_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_119);
            lv_joinPoints_8_0=ruleOperationJoinPointType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationAspectRule());
            					}
            					add(
            						current,
            						"joinPoints",
            						lv_joinPoints_8_0,
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationJoinPointType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMappingDsl.g:7205:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )*
            loop161:
            do {
                int alt161=2;
                int LA161_0 = input.LA(1);

                if ( (LA161_0==33) ) {
                    alt161=1;
                }


                switch (alt161) {
            	case 1 :
            	    // InternalMappingDsl.g:7206:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,33,FOLLOW_121); 

            	    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMappingDsl.g:7210:4: ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    // InternalMappingDsl.g:7211:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    {
            	    // InternalMappingDsl.g:7211:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    // InternalMappingDsl.g:7212:6: lv_joinPoints_10_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_119);
            	    lv_joinPoints_10_0=ruleOperationJoinPointType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"joinPoints",
            	    							lv_joinPoints_10_0,
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationJoinPointType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop161;
                }
            } while (true);

            // InternalMappingDsl.g:7230:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==14) ) {
                alt164=1;
            }
            else if ( (LA164_0==26) ) {
                alt164=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 164, 0, input);

                throw nvae;
            }
            switch (alt164) {
                case 1 :
                    // InternalMappingDsl.g:7231:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalMappingDsl.g:7231:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalMappingDsl.g:7232:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,14,FOLLOW_120); 

                    					newLeafNode(otherlv_11, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalMappingDsl.g:7236:5: ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )*
                    loop162:
                    do {
                        int alt162=2;
                        int LA162_0 = input.LA(1);

                        if ( (LA162_0==95) ) {
                            alt162=1;
                        }


                        switch (alt162) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7237:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalMappingDsl.g:7237:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    // InternalMappingDsl.g:7238:7: lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPointcutSelectorsOperationAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_120);
                    	    lv_pointcutSelectors_12_0=ruleOperationAspectPointcutSelector();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"pointcutSelectors",
                    	    								lv_pointcutSelectors_12_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.OperationAspectPointcutSelector");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop162;
                        }
                    } while (true);

                    // InternalMappingDsl.g:7255:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop163:
                    do {
                        int alt163=2;
                        int LA163_0 = input.LA(1);

                        if ( ((LA163_0>=120 && LA163_0<=129)||LA163_0==136) ) {
                            alt163=1;
                        }


                        switch (alt163) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7256:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalMappingDsl.g:7256:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalMappingDsl.g:7257:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_107);
                    	    lv_properties_13_0=ruleTechnologySpecificProperty();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationAspectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"properties",
                    	    								lv_properties_13_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificProperty");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop163;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7280:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getOperationAspectAccess().getSemicolonKeyword_6_1());
                    			

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
    // InternalMappingDsl.g:7289:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalMappingDsl.g:7289:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalMappingDsl.g:7290:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalMappingDsl.g:7296:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalMappingDsl.g:7302:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:7303:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:7303:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalMappingDsl.g:7304:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_94); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,96,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,37,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalMappingDsl.g:7316:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalMappingDsl.g:7317:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalMappingDsl.g:7317:4: (lv_importURI_3_0= RULE_STRING )
            // InternalMappingDsl.g:7318:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_56); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexTypeImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalMappingDsl.g:7338:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:7339:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:7339:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:7340:5: lv_name_5_0= RULE_ID
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
    // InternalMappingDsl.g:7360:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalMappingDsl.g:7360:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalMappingDsl.g:7361:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalMappingDsl.g:7367:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalMappingDsl.g:7373:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalMappingDsl.g:7374:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalMappingDsl.g:7374:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalMappingDsl.g:7375:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalMappingDsl.g:7379:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:7380:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:7380:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:7381:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,14,FOLLOW_122); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:7401:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt167=3;
            int LA167_0 = input.LA(1);

            if ( ((LA167_0>=79 && LA167_0<=80)||LA167_0==114) ) {
                alt167=1;
            }
            else if ( (LA167_0==97) ) {
                alt167=2;
            }
            switch (alt167) {
                case 1 :
                    // InternalMappingDsl.g:7402:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalMappingDsl.g:7402:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt165=0;
                    loop165:
                    do {
                        int alt165=2;
                        int LA165_0 = input.LA(1);

                        if ( ((LA165_0>=79 && LA165_0<=80)||LA165_0==114) ) {
                            alt165=1;
                        }


                        switch (alt165) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7403:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalMappingDsl.g:7403:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalMappingDsl.g:7404:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_123);
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
                    	    if ( cnt165 >= 1 ) break loop165;
                                EarlyExitException eee =
                                    new EarlyExitException(165, input);
                                throw eee;
                        }
                        cnt165++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7422:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalMappingDsl.g:7422:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt166=0;
                    loop166:
                    do {
                        int alt166=2;
                        int LA166_0 = input.LA(1);

                        if ( (LA166_0==97) ) {
                            alt166=1;
                        }


                        switch (alt166) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7423:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalMappingDsl.g:7423:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalMappingDsl.g:7424:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_124);
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
                    	    if ( cnt166 >= 1 ) break loop166;
                                EarlyExitException eee =
                                    new EarlyExitException(166, input);
                                throw eee;
                        }
                        cnt166++;
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
    // InternalMappingDsl.g:7450:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalMappingDsl.g:7450:48: (iv_ruleContext= ruleContext EOF )
            // InternalMappingDsl.g:7451:2: iv_ruleContext= ruleContext EOF
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
    // InternalMappingDsl.g:7457:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:7463:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalMappingDsl.g:7464:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalMappingDsl.g:7464:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalMappingDsl.g:7465:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalMappingDsl.g:7469:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:7470:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:7470:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:7471:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,14,FOLLOW_125); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMappingDsl.g:7491:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt168=0;
            loop168:
            do {
                int alt168=2;
                int LA168_0 = input.LA(1);

                if ( ((LA168_0>=79 && LA168_0<=80)||LA168_0==114) ) {
                    alt168=1;
                }


                switch (alt168) {
            	case 1 :
            	    // InternalMappingDsl.g:7492:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalMappingDsl.g:7492:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalMappingDsl.g:7493:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_123);
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
            	    if ( cnt168 >= 1 ) break loop168;
                        EarlyExitException eee =
                            new EarlyExitException(168, input);
                        throw eee;
                }
                cnt168++;
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
    // InternalMappingDsl.g:7518:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalMappingDsl.g:7518:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalMappingDsl.g:7519:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalMappingDsl.g:7525:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:7531:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalMappingDsl.g:7532:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalMappingDsl.g:7532:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt169=3;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt169=1;
                }
                break;
            case 79:
                {
                alt169=2;
                }
                break;
            case 114:
                {
                alt169=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 169, 0, input);

                throw nvae;
            }

            switch (alt169) {
                case 1 :
                    // InternalMappingDsl.g:7533:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalMappingDsl.g:7542:3: this_ListType_1= ruleListType
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
                    // InternalMappingDsl.g:7551:3: this_Enumeration_2= ruleEnumeration
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
    // InternalMappingDsl.g:7563:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalMappingDsl.g:7563:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalMappingDsl.g:7564:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalMappingDsl.g:7570:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
    public final EObject ruleDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Enumerator lv_features_3_0 = null;

        Enumerator lv_features_5_0 = null;

        EObject lv_dataFields_10_0 = null;

        EObject lv_operations_11_0 = null;

        EObject lv_dataFields_13_0 = null;

        EObject lv_operations_14_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:7576:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalMappingDsl.g:7577:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalMappingDsl.g:7577:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalMappingDsl.g:7578:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalMappingDsl.g:7582:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:7583:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:7583:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:7584:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_126); 

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

            // InternalMappingDsl.g:7600:3: (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )?
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==56) ) {
                alt171=1;
            }
            switch (alt171) {
                case 1 :
                    // InternalMappingDsl.g:7601:4: otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_127); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalMappingDsl.g:7605:4: ( (lv_features_3_0= ruleDataStructureFeature ) )
                    // InternalMappingDsl.g:7606:5: (lv_features_3_0= ruleDataStructureFeature )
                    {
                    // InternalMappingDsl.g:7606:5: (lv_features_3_0= ruleDataStructureFeature )
                    // InternalMappingDsl.g:7607:6: lv_features_3_0= ruleDataStructureFeature
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_112);
                    lv_features_3_0=ruleDataStructureFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_3_0,
                    							"de.fhdo.lemma.data.DataDsl.DataStructureFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:7624:4: (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )*
                    loop170:
                    do {
                        int alt170=2;
                        int LA170_0 = input.LA(1);

                        if ( (LA170_0==33) ) {
                            alt170=1;
                        }


                        switch (alt170) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7625:5: otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_127); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalMappingDsl.g:7629:5: ( (lv_features_5_0= ruleDataStructureFeature ) )
                    	    // InternalMappingDsl.g:7630:6: (lv_features_5_0= ruleDataStructureFeature )
                    	    {
                    	    // InternalMappingDsl.g:7630:6: (lv_features_5_0= ruleDataStructureFeature )
                    	    // InternalMappingDsl.g:7631:7: lv_features_5_0= ruleDataStructureFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
                    	    lv_features_5_0=ruleDataStructureFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_5_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataStructureFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop170;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,57,FOLLOW_128); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:7654:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==108) ) {
                alt172=1;
            }
            switch (alt172) {
                case 1 :
                    // InternalMappingDsl.g:7655:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,108,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalMappingDsl.g:7659:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:7660:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:7660:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:7661:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_129); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMappingDsl.g:7680:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt176=2;
            int LA176_0 = input.LA(1);

            if ( (LA176_0==RULE_ID||(LA176_0>=112 && LA176_0<=113)||(LA176_0>=118 && LA176_0<=129)||LA176_0==136) ) {
                alt176=1;
            }
            switch (alt176) {
                case 1 :
                    // InternalMappingDsl.g:7681:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalMappingDsl.g:7681:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt173=2;
                    switch ( input.LA(1) ) {
                    case 112:
                        {
                        int LA173_1 = input.LA(2);

                        if ( (LA173_1==RULE_ID||LA173_1==113||(LA173_1>=120 && LA173_1<=129)||LA173_1==136) ) {
                            alt173=1;
                        }
                        else if ( ((LA173_1>=118 && LA173_1<=119)) ) {
                            alt173=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 173, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 113:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 136:
                        {
                        alt173=1;
                        }
                        break;
                    case 118:
                    case 119:
                        {
                        alt173=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 173, 0, input);

                        throw nvae;
                    }

                    switch (alt173) {
                        case 1 :
                            // InternalMappingDsl.g:7682:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalMappingDsl.g:7682:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalMappingDsl.g:7683:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalMappingDsl.g:7683:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalMappingDsl.g:7684:7: lv_dataFields_10_0= ruleDataField
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0());
                            						
                            pushFollow(FOLLOW_65);
                            lv_dataFields_10_0=ruleDataField();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                            							}
                            							add(
                            								current,
                            								"dataFields",
                            								lv_dataFields_10_0,
                            								"de.fhdo.lemma.data.DataDsl.DataField");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:7702:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalMappingDsl.g:7702:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalMappingDsl.g:7703:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalMappingDsl.g:7703:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalMappingDsl.g:7704:7: lv_operations_11_0= ruleDataOperation
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0());
                            						
                            pushFollow(FOLLOW_65);
                            lv_operations_11_0=ruleDataOperation();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                            							}
                            							add(
                            								current,
                            								"operations",
                            								lv_operations_11_0,
                            								"de.fhdo.lemma.data.DataDsl.DataOperation");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:7722:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop175:
                    do {
                        int alt175=2;
                        int LA175_0 = input.LA(1);

                        if ( (LA175_0==33) ) {
                            alt175=1;
                        }


                        switch (alt175) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7723:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,33,FOLLOW_130); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalMappingDsl.g:7727:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt174=2;
                    	    switch ( input.LA(1) ) {
                    	    case 112:
                    	        {
                    	        int LA174_1 = input.LA(2);

                    	        if ( ((LA174_1>=118 && LA174_1<=119)) ) {
                    	            alt174=2;
                    	        }
                    	        else if ( (LA174_1==RULE_ID||LA174_1==113||(LA174_1>=120 && LA174_1<=129)||LA174_1==136) ) {
                    	            alt174=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 174, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 113:
                    	    case 120:
                    	    case 121:
                    	    case 122:
                    	    case 123:
                    	    case 124:
                    	    case 125:
                    	    case 126:
                    	    case 127:
                    	    case 128:
                    	    case 129:
                    	    case 136:
                    	        {
                    	        alt174=1;
                    	        }
                    	        break;
                    	    case 118:
                    	    case 119:
                    	        {
                    	        alt174=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 174, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt174) {
                    	        case 1 :
                    	            // InternalMappingDsl.g:7728:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalMappingDsl.g:7728:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalMappingDsl.g:7729:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalMappingDsl.g:7729:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalMappingDsl.g:7730:8: lv_dataFields_13_0= ruleDataField
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_65);
                    	            lv_dataFields_13_0=ruleDataField();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"dataFields",
                    	            									lv_dataFields_13_0,
                    	            									"de.fhdo.lemma.data.DataDsl.DataField");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalMappingDsl.g:7748:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalMappingDsl.g:7748:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalMappingDsl.g:7749:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalMappingDsl.g:7749:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalMappingDsl.g:7750:8: lv_operations_14_0= ruleDataOperation
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_65);
                    	            lv_operations_14_0=ruleDataOperation();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"operations",
                    	            									lv_operations_14_0,
                    	            									"de.fhdo.lemma.data.DataDsl.DataOperation");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop175;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalMappingDsl.g:7778:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalMappingDsl.g:7778:49: (iv_ruleListType= ruleListType EOF )
            // InternalMappingDsl.g:7779:2: iv_ruleListType= ruleListType EOF
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
    // InternalMappingDsl.g:7785:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalMappingDsl.g:7791:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalMappingDsl.g:7792:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalMappingDsl.g:7792:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt178=2;
            alt178 = dfa178.predict(input);
            switch (alt178) {
                case 1 :
                    // InternalMappingDsl.g:7793:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalMappingDsl.g:7793:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalMappingDsl.g:7794:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,79,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalMappingDsl.g:7798:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalMappingDsl.g:7799:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:7799:5: (lv_name_1_0= RULE_ID )
                    // InternalMappingDsl.g:7800:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,14,FOLLOW_131); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalMappingDsl.g:7820:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalMappingDsl.g:7821:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalMappingDsl.g:7821:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalMappingDsl.g:7822:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_65);
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

                    // InternalMappingDsl.g:7839:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop177:
                    do {
                        int alt177=2;
                        int LA177_0 = input.LA(1);

                        if ( (LA177_0==33) ) {
                            alt177=1;
                        }


                        switch (alt177) {
                    	case 1 :
                    	    // InternalMappingDsl.g:7840:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_131); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalMappingDsl.g:7844:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalMappingDsl.g:7845:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalMappingDsl.g:7845:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalMappingDsl.g:7846:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_65);
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
                    	    break loop177;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7870:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalMappingDsl.g:7870:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalMappingDsl.g:7871:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,79,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalMappingDsl.g:7875:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalMappingDsl.g:7876:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalMappingDsl.g:7876:5: (lv_name_8_0= RULE_ID )
                    // InternalMappingDsl.g:7877:6: lv_name_8_0= RULE_ID
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

                    otherlv_9=(Token)match(input,14,FOLLOW_102); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalMappingDsl.g:7897:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:7898:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:7898:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalMappingDsl.g:7899:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_26);
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
    // InternalMappingDsl.g:7925:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalMappingDsl.g:7925:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalMappingDsl.g:7926:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalMappingDsl.g:7932:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_immutable_1_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_primitiveType_2_0 = null;

        EObject lv_importedComplexType_4_0 = null;

        EObject lv_initializationValue_7_0 = null;

        Enumerator lv_features_9_0 = null;

        Enumerator lv_features_11_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:7938:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalMappingDsl.g:7939:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalMappingDsl.g:7939:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalMappingDsl.g:7940:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalMappingDsl.g:7940:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt179=2;
            int LA179_0 = input.LA(1);

            if ( (LA179_0==112) ) {
                alt179=1;
            }
            switch (alt179) {
                case 1 :
                    // InternalMappingDsl.g:7941:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalMappingDsl.g:7941:4: (lv_hidden_0_0= 'hide' )
                    // InternalMappingDsl.g:7942:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,112,FOLLOW_132); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:7954:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt180=2;
            int LA180_0 = input.LA(1);

            if ( (LA180_0==113) ) {
                alt180=1;
            }
            switch (alt180) {
                case 1 :
                    // InternalMappingDsl.g:7955:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalMappingDsl.g:7955:4: (lv_immutable_1_0= 'immutable' )
                    // InternalMappingDsl.g:7956:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,113,FOLLOW_88); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", true, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:7968:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt181=4;
            int LA181_0 = input.LA(1);

            if ( ((LA181_0>=120 && LA181_0<=129)||LA181_0==136) ) {
                alt181=1;
            }
            else if ( (LA181_0==RULE_ID) ) {
                int LA181_2 = input.LA(2);

                if ( (LA181_2==17) ) {
                    alt181=3;
                }
                else if ( (LA181_2==RULE_ID||LA181_2==29) ) {
                    alt181=2;
                }
            }
            switch (alt181) {
                case 1 :
                    // InternalMappingDsl.g:7969:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:7969:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:7970:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:7970:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalMappingDsl.g:7971:6: lv_primitiveType_2_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_primitiveType_2_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_2_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:7989:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalMappingDsl.g:7989:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:7990:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:7990:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:7991:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataFieldRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:8006:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalMappingDsl.g:8006:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalMappingDsl.g:8007:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalMappingDsl.g:8007:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalMappingDsl.g:8008:6: lv_importedComplexType_4_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_importedComplexType_4_0=ruleImportedComplexType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"importedComplexType",
                    							lv_importedComplexType_4_0,
                    							"de.fhdo.lemma.data.DataDsl.ImportedComplexType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:8026:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalMappingDsl.g:8027:4: (lv_name_5_0= RULE_ID )
            {
            // InternalMappingDsl.g:8027:4: (lv_name_5_0= RULE_ID )
            // InternalMappingDsl.g:8028:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_133); 

            					newLeafNode(lv_name_5_0, grammarAccess.getDataFieldAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMappingDsl.g:8044:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt182=2;
            int LA182_0 = input.LA(1);

            if ( (LA182_0==48) ) {
                alt182=1;
            }
            switch (alt182) {
                case 1 :
                    // InternalMappingDsl.g:8045:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,48,FOLLOW_91); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalMappingDsl.g:8049:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:8050:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:8050:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:8051:6: lv_initializationValue_7_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_134);
                    lv_initializationValue_7_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"initializationValue",
                    							lv_initializationValue_7_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:8069:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt184=2;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==56) ) {
                alt184=1;
            }
            switch (alt184) {
                case 1 :
                    // InternalMappingDsl.g:8070:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,56,FOLLOW_135); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalMappingDsl.g:8074:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalMappingDsl.g:8075:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalMappingDsl.g:8075:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalMappingDsl.g:8076:6: lv_features_9_0= ruleDataFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_112);
                    lv_features_9_0=ruleDataFieldFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_9_0,
                    							"de.fhdo.lemma.data.DataDsl.DataFieldFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:8093:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop183:
                    do {
                        int alt183=2;
                        int LA183_0 = input.LA(1);

                        if ( (LA183_0==33) ) {
                            alt183=1;
                        }


                        switch (alt183) {
                    	case 1 :
                    	    // InternalMappingDsl.g:8094:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,33,FOLLOW_135); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMappingDsl.g:8098:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalMappingDsl.g:8099:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalMappingDsl.g:8099:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalMappingDsl.g:8100:7: lv_features_11_0= ruleDataFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
                    	    lv_features_11_0=ruleDataFieldFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_11_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataFieldFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop183;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,57,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_5_3());
                    			

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
    // InternalMappingDsl.g:8127:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalMappingDsl.g:8127:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalMappingDsl.g:8128:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalMappingDsl.g:8134:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
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
            // InternalMappingDsl.g:8140:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalMappingDsl.g:8141:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalMappingDsl.g:8141:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalMappingDsl.g:8142:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,114,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalMappingDsl.g:8146:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMappingDsl.g:8147:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMappingDsl.g:8147:4: (lv_name_1_0= RULE_ID )
            // InternalMappingDsl.g:8148:5: lv_name_1_0= RULE_ID
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
            		
            // InternalMappingDsl.g:8168:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalMappingDsl.g:8169:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalMappingDsl.g:8169:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalMappingDsl.g:8170:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_65);
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

            // InternalMappingDsl.g:8187:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop185:
            do {
                int alt185=2;
                int LA185_0 = input.LA(1);

                if ( (LA185_0==33) ) {
                    alt185=1;
                }


                switch (alt185) {
            	case 1 :
            	    // InternalMappingDsl.g:8188:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,33,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMappingDsl.g:8192:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalMappingDsl.g:8193:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalMappingDsl.g:8193:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalMappingDsl.g:8194:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_65);
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
            	    break loop185;
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
    // InternalMappingDsl.g:8220:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalMappingDsl.g:8220:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalMappingDsl.g:8221:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalMappingDsl.g:8227:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:8233:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalMappingDsl.g:8234:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalMappingDsl.g:8234:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalMappingDsl.g:8235:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalMappingDsl.g:8235:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMappingDsl.g:8236:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMappingDsl.g:8236:4: (lv_name_0_0= RULE_ID )
            // InternalMappingDsl.g:8237:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_90); 

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

            // InternalMappingDsl.g:8253:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt186=2;
            int LA186_0 = input.LA(1);

            if ( (LA186_0==34) ) {
                alt186=1;
            }
            switch (alt186) {
                case 1 :
                    // InternalMappingDsl.g:8254:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_91); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalMappingDsl.g:8258:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalMappingDsl.g:8259:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalMappingDsl.g:8259:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalMappingDsl.g:8260:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    otherlv_3=(Token)match(input,35,FOLLOW_2); 

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


    // $ANTLR start "entryRuleDataOperation"
    // InternalMappingDsl.g:8286:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalMappingDsl.g:8286:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalMappingDsl.g:8287:2: iv_ruleDataOperation= ruleDataOperation EOF
            {
             newCompositeNode(grammarAccess.getDataOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataOperation=ruleDataOperation();

            state._fsp--;

             current =iv_ruleDataOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataOperation"


    // $ANTLR start "ruleDataOperation"
    // InternalMappingDsl.g:8293:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
    public final EObject ruleDataOperation() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_hasNoReturnType_1_0=null;
        Token otherlv_2=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_primitiveReturnType_3_0 = null;

        EObject lv_importedComplexReturnType_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        Enumerator lv_features_13_0 = null;

        Enumerator lv_features_15_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:8299:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalMappingDsl.g:8300:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalMappingDsl.g:8300:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalMappingDsl.g:8301:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalMappingDsl.g:8301:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt187=2;
            int LA187_0 = input.LA(1);

            if ( (LA187_0==112) ) {
                alt187=1;
            }
            switch (alt187) {
                case 1 :
                    // InternalMappingDsl.g:8302:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalMappingDsl.g:8302:4: (lv_hidden_0_0= 'hide' )
                    // InternalMappingDsl.g:8303:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,112,FOLLOW_136); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:8315:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt189=2;
            int LA189_0 = input.LA(1);

            if ( (LA189_0==119) ) {
                alt189=1;
            }
            else if ( (LA189_0==118) ) {
                alt189=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 189, 0, input);

                throw nvae;
            }
            switch (alt189) {
                case 1 :
                    // InternalMappingDsl.g:8316:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalMappingDsl.g:8316:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalMappingDsl.g:8317:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalMappingDsl.g:8317:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalMappingDsl.g:8318:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,119,FOLLOW_7); 

                    						newLeafNode(lv_hasNoReturnType_1_0, grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationRule());
                    						}
                    						setWithLastConsumed(current, "hasNoReturnType", true, "procedure");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:8331:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalMappingDsl.g:8331:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalMappingDsl.g:8332:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,118,FOLLOW_88); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalMappingDsl.g:8336:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt188=4;
                    int LA188_0 = input.LA(1);

                    if ( ((LA188_0>=120 && LA188_0<=129)||LA188_0==136) ) {
                        alt188=1;
                    }
                    else if ( (LA188_0==RULE_ID) ) {
                        int LA188_2 = input.LA(2);

                        if ( (LA188_2==17) ) {
                            alt188=3;
                        }
                        else if ( (LA188_2==RULE_ID||LA188_2==29) ) {
                            alt188=2;
                        }
                    }
                    switch (alt188) {
                        case 1 :
                            // InternalMappingDsl.g:8337:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalMappingDsl.g:8337:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalMappingDsl.g:8338:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalMappingDsl.g:8338:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalMappingDsl.g:8339:8: lv_primitiveReturnType_3_0= rulePrimitiveType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypePrimitiveTypeParserRuleCall_1_1_1_0_0());
                            							
                            pushFollow(FOLLOW_7);
                            lv_primitiveReturnType_3_0=rulePrimitiveType();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getDataOperationRule());
                            								}
                            								set(
                            									current,
                            									"primitiveReturnType",
                            									lv_primitiveReturnType_3_0,
                            									"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMappingDsl.g:8357:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalMappingDsl.g:8357:6: ( ( ruleQualifiedName ) )
                            // InternalMappingDsl.g:8358:7: ( ruleQualifiedName )
                            {
                            // InternalMappingDsl.g:8358:7: ( ruleQualifiedName )
                            // InternalMappingDsl.g:8359:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getDataOperationRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0());
                            							
                            pushFollow(FOLLOW_7);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalMappingDsl.g:8374:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalMappingDsl.g:8374:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalMappingDsl.g:8375:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalMappingDsl.g:8375:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalMappingDsl.g:8376:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeImportedComplexTypeParserRuleCall_1_1_1_2_0());
                            							
                            pushFollow(FOLLOW_7);
                            lv_importedComplexReturnType_5_0=ruleImportedComplexType();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getDataOperationRule());
                            								}
                            								set(
                            									current,
                            									"importedComplexReturnType",
                            									lv_importedComplexReturnType_5_0,
                            									"de.fhdo.lemma.data.DataDsl.ImportedComplexType");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:8396:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalMappingDsl.g:8397:4: (lv_name_6_0= RULE_ID )
            {
            // InternalMappingDsl.g:8397:4: (lv_name_6_0= RULE_ID )
            // InternalMappingDsl.g:8398:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_137); 

            					newLeafNode(lv_name_6_0, grammarAccess.getDataOperationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMappingDsl.g:8414:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt192=2;
            int LA192_0 = input.LA(1);

            if ( (LA192_0==34) ) {
                alt192=1;
            }
            switch (alt192) {
                case 1 :
                    // InternalMappingDsl.g:8415:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_138); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalMappingDsl.g:8419:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt190=2;
                    int LA190_0 = input.LA(1);

                    if ( (LA190_0==RULE_ID||(LA190_0>=120 && LA190_0<=129)||LA190_0==136) ) {
                        alt190=1;
                    }
                    switch (alt190) {
                        case 1 :
                            // InternalMappingDsl.g:8420:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalMappingDsl.g:8420:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalMappingDsl.g:8421:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_52);
                            lv_parameters_8_0=ruleDataOperationParameter();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getDataOperationRule());
                            						}
                            						add(
                            							current,
                            							"parameters",
                            							lv_parameters_8_0,
                            							"de.fhdo.lemma.data.DataDsl.DataOperationParameter");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalMappingDsl.g:8438:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop191:
                    do {
                        int alt191=2;
                        int LA191_0 = input.LA(1);

                        if ( (LA191_0==33) ) {
                            alt191=1;
                        }


                        switch (alt191) {
                    	case 1 :
                    	    // InternalMappingDsl.g:8439:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,33,FOLLOW_88); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalMappingDsl.g:8443:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalMappingDsl.g:8444:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalMappingDsl.g:8444:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalMappingDsl.g:8445:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_52);
                    	    lv_parameters_10_0=ruleDataOperationParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataOperationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_10_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataOperationParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop191;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,35,FOLLOW_134); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalMappingDsl.g:8468:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt194=2;
            int LA194_0 = input.LA(1);

            if ( (LA194_0==56) ) {
                alt194=1;
            }
            switch (alt194) {
                case 1 :
                    // InternalMappingDsl.g:8469:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,56,FOLLOW_139); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalMappingDsl.g:8473:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalMappingDsl.g:8474:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalMappingDsl.g:8474:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalMappingDsl.g:8475:6: lv_features_13_0= ruleDataOperationFeature
                    {

                    						newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_112);
                    lv_features_13_0=ruleDataOperationFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataOperationRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_13_0,
                    							"de.fhdo.lemma.data.DataDsl.DataOperationFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMappingDsl.g:8492:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop193:
                    do {
                        int alt193=2;
                        int LA193_0 = input.LA(1);

                        if ( (LA193_0==33) ) {
                            alt193=1;
                        }


                        switch (alt193) {
                    	case 1 :
                    	    // InternalMappingDsl.g:8493:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,33,FOLLOW_139); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalMappingDsl.g:8497:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalMappingDsl.g:8498:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalMappingDsl.g:8498:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalMappingDsl.g:8499:7: lv_features_15_0= ruleDataOperationFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
                    	    lv_features_15_0=ruleDataOperationFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataOperationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_15_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataOperationFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop193;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,57,FOLLOW_2); 

                    				newLeafNode(otherlv_16, grammarAccess.getDataOperationAccess().getGreaterThanSignKeyword_4_3());
                    			

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
    // $ANTLR end "ruleDataOperation"


    // $ANTLR start "entryRuleDataOperationParameter"
    // InternalMappingDsl.g:8526:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalMappingDsl.g:8526:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalMappingDsl.g:8527:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
            {
             newCompositeNode(grammarAccess.getDataOperationParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataOperationParameter=ruleDataOperationParameter();

            state._fsp--;

             current =iv_ruleDataOperationParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataOperationParameter"


    // $ANTLR start "ruleDataOperationParameter"
    // InternalMappingDsl.g:8533:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDsl.g:8539:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalMappingDsl.g:8540:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalMappingDsl.g:8540:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalMappingDsl.g:8541:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalMappingDsl.g:8541:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt195=3;
            int LA195_0 = input.LA(1);

            if ( ((LA195_0>=120 && LA195_0<=129)||LA195_0==136) ) {
                alt195=1;
            }
            else if ( (LA195_0==RULE_ID) ) {
                int LA195_2 = input.LA(2);

                if ( (LA195_2==17) ) {
                    alt195=3;
                }
                else if ( (LA195_2==RULE_ID||LA195_2==29) ) {
                    alt195=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 195, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 195, 0, input);

                throw nvae;
            }
            switch (alt195) {
                case 1 :
                    // InternalMappingDsl.g:8542:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalMappingDsl.g:8542:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalMappingDsl.g:8543:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalMappingDsl.g:8543:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalMappingDsl.g:8544:6: lv_primitiveType_0_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_primitiveType_0_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataOperationParameterRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_0_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:8562:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalMappingDsl.g:8562:4: ( ( ruleQualifiedName ) )
                    // InternalMappingDsl.g:8563:5: ( ruleQualifiedName )
                    {
                    // InternalMappingDsl.g:8563:5: ( ruleQualifiedName )
                    // InternalMappingDsl.g:8564:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:8579:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalMappingDsl.g:8579:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalMappingDsl.g:8580:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalMappingDsl.g:8580:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalMappingDsl.g:8581:6: lv_importedComplexType_2_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_importedComplexType_2_0=ruleImportedComplexType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataOperationParameterRule());
                    						}
                    						set(
                    							current,
                    							"importedComplexType",
                    							lv_importedComplexType_2_0,
                    							"de.fhdo.lemma.data.DataDsl.ImportedComplexType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMappingDsl.g:8599:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMappingDsl.g:8600:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMappingDsl.g:8600:4: (lv_name_3_0= RULE_ID )
            // InternalMappingDsl.g:8601:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getDataOperationParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataOperationParameterRule());
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
    // $ANTLR end "ruleDataOperationParameter"


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalMappingDsl.g:8621:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalMappingDsl.g:8621:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalMappingDsl.g:8622:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalMappingDsl.g:8628:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:8634:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalMappingDsl.g:8635:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDsl.g:8635:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt196=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt196=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt196=2;
                }
                break;
            case RULE_STRING:
                {
                alt196=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 196, 0, input);

                throw nvae;
            }

            switch (alt196) {
                case 1 :
                    // InternalMappingDsl.g:8636:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalMappingDsl.g:8636:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalMappingDsl.g:8637:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalMappingDsl.g:8637:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalMappingDsl.g:8638:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalMappingDsl.g:8655:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalMappingDsl.g:8655:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalMappingDsl.g:8656:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalMappingDsl.g:8656:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalMappingDsl.g:8657:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalMappingDsl.g:8674:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalMappingDsl.g:8674:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalMappingDsl.g:8675:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalMappingDsl.g:8675:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalMappingDsl.g:8676:5: lv_stringValue_2_0= RULE_STRING
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
                    						"de.fhdo.lemma.technology.mappingdsl.MappingDsl.STRING");
                    				

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


    // $ANTLR start "entryRuleImportedComplexType"
    // InternalMappingDsl.g:8696:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalMappingDsl.g:8696:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalMappingDsl.g:8697:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalMappingDsl.g:8703:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:8709:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalMappingDsl.g:8710:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalMappingDsl.g:8710:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalMappingDsl.g:8711:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalMappingDsl.g:8711:3: ( (otherlv_0= RULE_ID ) )
            // InternalMappingDsl.g:8712:4: (otherlv_0= RULE_ID )
            {
            // InternalMappingDsl.g:8712:4: (otherlv_0= RULE_ID )
            // InternalMappingDsl.g:8713:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalMappingDsl.g:8728:3: ( ( ruleQualifiedName ) )
            // InternalMappingDsl.g:8729:4: ( ruleQualifiedName )
            {
            // InternalMappingDsl.g:8729:4: ( ruleQualifiedName )
            // InternalMappingDsl.g:8730:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeCrossReference_2_0());
            				
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


    // $ANTLR start "entryRulePrimitiveType"
    // InternalMappingDsl.g:8748:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalMappingDsl.g:8748:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalMappingDsl.g:8749:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalMappingDsl.g:8755:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
        Token otherlv_21=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:8761:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalMappingDsl.g:8762:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalMappingDsl.g:8762:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt197=11;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt197=1;
                }
                break;
            case 121:
                {
                alt197=2;
                }
                break;
            case 122:
                {
                alt197=3;
                }
                break;
            case 123:
                {
                alt197=4;
                }
                break;
            case 124:
                {
                alt197=5;
                }
                break;
            case 125:
                {
                alt197=6;
                }
                break;
            case 126:
                {
                alt197=7;
                }
                break;
            case 127:
                {
                alt197=8;
                }
                break;
            case 128:
                {
                alt197=9;
                }
                break;
            case 129:
                {
                alt197=10;
                }
                break;
            case 136:
                {
                alt197=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 197, 0, input);

                throw nvae;
            }

            switch (alt197) {
                case 1 :
                    // InternalMappingDsl.g:8763:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalMappingDsl.g:8763:3: ( () otherlv_1= 'boolean' )
                    // InternalMappingDsl.g:8764:4: () otherlv_1= 'boolean'
                    {
                    // InternalMappingDsl.g:8764:4: ()
                    // InternalMappingDsl.g:8765:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,120,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:8777:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalMappingDsl.g:8777:3: ( () otherlv_3= 'byte' )
                    // InternalMappingDsl.g:8778:4: () otherlv_3= 'byte'
                    {
                    // InternalMappingDsl.g:8778:4: ()
                    // InternalMappingDsl.g:8779:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,121,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:8791:3: ( () otherlv_5= 'char' )
                    {
                    // InternalMappingDsl.g:8791:3: ( () otherlv_5= 'char' )
                    // InternalMappingDsl.g:8792:4: () otherlv_5= 'char'
                    {
                    // InternalMappingDsl.g:8792:4: ()
                    // InternalMappingDsl.g:8793:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,122,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:8805:3: ( () otherlv_7= 'date' )
                    {
                    // InternalMappingDsl.g:8805:3: ( () otherlv_7= 'date' )
                    // InternalMappingDsl.g:8806:4: () otherlv_7= 'date'
                    {
                    // InternalMappingDsl.g:8806:4: ()
                    // InternalMappingDsl.g:8807:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,123,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:8819:3: ( () otherlv_9= 'double' )
                    {
                    // InternalMappingDsl.g:8819:3: ( () otherlv_9= 'double' )
                    // InternalMappingDsl.g:8820:4: () otherlv_9= 'double'
                    {
                    // InternalMappingDsl.g:8820:4: ()
                    // InternalMappingDsl.g:8821:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,124,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:8833:3: ( () otherlv_11= 'float' )
                    {
                    // InternalMappingDsl.g:8833:3: ( () otherlv_11= 'float' )
                    // InternalMappingDsl.g:8834:4: () otherlv_11= 'float'
                    {
                    // InternalMappingDsl.g:8834:4: ()
                    // InternalMappingDsl.g:8835:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,125,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMappingDsl.g:8847:3: ( () otherlv_13= 'int' )
                    {
                    // InternalMappingDsl.g:8847:3: ( () otherlv_13= 'int' )
                    // InternalMappingDsl.g:8848:4: () otherlv_13= 'int'
                    {
                    // InternalMappingDsl.g:8848:4: ()
                    // InternalMappingDsl.g:8849:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,126,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMappingDsl.g:8861:3: ( () otherlv_15= 'long' )
                    {
                    // InternalMappingDsl.g:8861:3: ( () otherlv_15= 'long' )
                    // InternalMappingDsl.g:8862:4: () otherlv_15= 'long'
                    {
                    // InternalMappingDsl.g:8862:4: ()
                    // InternalMappingDsl.g:8863:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,127,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMappingDsl.g:8875:3: ( () otherlv_17= 'short' )
                    {
                    // InternalMappingDsl.g:8875:3: ( () otherlv_17= 'short' )
                    // InternalMappingDsl.g:8876:4: () otherlv_17= 'short'
                    {
                    // InternalMappingDsl.g:8876:4: ()
                    // InternalMappingDsl.g:8877:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,128,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMappingDsl.g:8889:3: ( () otherlv_19= 'string' )
                    {
                    // InternalMappingDsl.g:8889:3: ( () otherlv_19= 'string' )
                    // InternalMappingDsl.g:8890:4: () otherlv_19= 'string'
                    {
                    // InternalMappingDsl.g:8890:4: ()
                    // InternalMappingDsl.g:8891:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,129,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalMappingDsl.g:8903:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalMappingDsl.g:8903:3: ( () otherlv_21= 'unspecified' )
                    // InternalMappingDsl.g:8904:4: () otherlv_21= 'unspecified'
                    {
                    // InternalMappingDsl.g:8904:4: ()
                    // InternalMappingDsl.g:8905:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0(),
                    						current);
                    				

                    }

                    otherlv_21=(Token)match(input,136,FOLLOW_2); 

                    				newLeafNode(otherlv_21, grammarAccess.getPrimitiveTypeAccess().getUnspecifiedKeyword_10_1());
                    			

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
    // InternalMappingDsl.g:8920:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMappingDsl.g:8920:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMappingDsl.g:8921:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMappingDsl.g:8927:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:8933:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMappingDsl.g:8934:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMappingDsl.g:8934:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMappingDsl.g:8935:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_140); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalMappingDsl.g:8942:3: (kw= '.' this_ID_2= RULE_ID )*
            loop198:
            do {
                int alt198=2;
                int LA198_0 = input.LA(1);

                if ( (LA198_0==29) ) {
                    alt198=1;
                }


                switch (alt198) {
            	case 1 :
            	    // InternalMappingDsl.g:8943:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,29,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_140); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop198;
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
    // InternalMappingDsl.g:8960:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:8966:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalMappingDsl.g:8967:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalMappingDsl.g:8967:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt199=2;
            int LA199_0 = input.LA(1);

            if ( (LA199_0==46) ) {
                alt199=1;
            }
            else if ( (LA199_0==43) ) {
                alt199=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 199, 0, input);

                throw nvae;
            }
            switch (alt199) {
                case 1 :
                    // InternalMappingDsl.g:8968:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalMappingDsl.g:8968:3: (enumLiteral_0= 'technology' )
                    // InternalMappingDsl.g:8969:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:8976:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalMappingDsl.g:8976:3: (enumLiteral_1= 'microservices' )
                    // InternalMappingDsl.g:8977:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

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
    // InternalMappingDsl.g:8987:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:8993:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalMappingDsl.g:8994:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalMappingDsl.g:8994:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt200=3;
            switch ( input.LA(1) ) {
            case 130:
                {
                alt200=1;
                }
                break;
            case 131:
                {
                alt200=2;
                }
                break;
            case 132:
                {
                alt200=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 200, 0, input);

                throw nvae;
            }

            switch (alt200) {
                case 1 :
                    // InternalMappingDsl.g:8995:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalMappingDsl.g:8995:3: (enumLiteral_0= 'internal' )
                    // InternalMappingDsl.g:8996:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9003:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalMappingDsl.g:9003:3: (enumLiteral_1= 'architecture' )
                    // InternalMappingDsl.g:9004:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9011:3: (enumLiteral_2= 'public' )
                    {
                    // InternalMappingDsl.g:9011:3: (enumLiteral_2= 'public' )
                    // InternalMappingDsl.g:9012:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,132,FOLLOW_2); 

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
    // InternalMappingDsl.g:9022:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9028:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalMappingDsl.g:9029:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:9029:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt201=3;
            switch ( input.LA(1) ) {
            case 134:
                {
                alt201=1;
                }
                break;
            case 135:
                {
                alt201=2;
                }
                break;
            case 66:
                {
                alt201=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 201, 0, input);

                throw nvae;
            }

            switch (alt201) {
                case 1 :
                    // InternalMappingDsl.g:9030:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalMappingDsl.g:9030:3: (enumLiteral_0= 'functional' )
                    // InternalMappingDsl.g:9031:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9038:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalMappingDsl.g:9038:3: (enumLiteral_1= 'utility' )
                    // InternalMappingDsl.g:9039:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9046:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:9046:3: (enumLiteral_2= 'infrastructure' )
                    // InternalMappingDsl.g:9047:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,66,FOLLOW_2); 

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
    // InternalMappingDsl.g:9057:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9063:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalMappingDsl.g:9064:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalMappingDsl.g:9064:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt202=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt202=1;
                }
                break;
            case 73:
                {
                alt202=2;
                }
                break;
            case 74:
                {
                alt202=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 202, 0, input);

                throw nvae;
            }

            switch (alt202) {
                case 1 :
                    // InternalMappingDsl.g:9065:3: (enumLiteral_0= 'in' )
                    {
                    // InternalMappingDsl.g:9065:3: (enumLiteral_0= 'in' )
                    // InternalMappingDsl.g:9066:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9073:3: (enumLiteral_1= 'out' )
                    {
                    // InternalMappingDsl.g:9073:3: (enumLiteral_1= 'out' )
                    // InternalMappingDsl.g:9074:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9081:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalMappingDsl.g:9081:3: (enumLiteral_2= 'inout' )
                    // InternalMappingDsl.g:9082:4: enumLiteral_2= 'inout'
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
    // InternalMappingDsl.g:9092:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9098:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalMappingDsl.g:9099:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalMappingDsl.g:9099:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt203=2;
            int LA203_0 = input.LA(1);

            if ( (LA203_0==75) ) {
                alt203=1;
            }
            else if ( (LA203_0==76) ) {
                alt203=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 203, 0, input);

                throw nvae;
            }
            switch (alt203) {
                case 1 :
                    // InternalMappingDsl.g:9100:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalMappingDsl.g:9100:3: (enumLiteral_0= 'sync' )
                    // InternalMappingDsl.g:9101:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9108:3: (enumLiteral_1= 'async' )
                    {
                    // InternalMappingDsl.g:9108:3: (enumLiteral_1= 'async' )
                    // InternalMappingDsl.g:9109:4: enumLiteral_1= 'async'
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
    // InternalMappingDsl.g:9119:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9125:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalMappingDsl.g:9126:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalMappingDsl.g:9126:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt204=3;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt204=1;
                }
                break;
            case 28:
                {
                alt204=2;
                }
                break;
            case 82:
                {
                alt204=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 204, 0, input);

                throw nvae;
            }

            switch (alt204) {
                case 1 :
                    // InternalMappingDsl.g:9127:3: (enumLiteral_0= '<-' )
                    {
                    // InternalMappingDsl.g:9127:3: (enumLiteral_0= '<-' )
                    // InternalMappingDsl.g:9128:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9135:3: (enumLiteral_1= '->' )
                    {
                    // InternalMappingDsl.g:9135:3: (enumLiteral_1= '->' )
                    // InternalMappingDsl.g:9136:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9143:3: (enumLiteral_2= '<->' )
                    {
                    // InternalMappingDsl.g:9143:3: (enumLiteral_2= '<->' )
                    // InternalMappingDsl.g:9144:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,82,FOLLOW_2); 

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
    // InternalMappingDsl.g:9154:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9160:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalMappingDsl.g:9161:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalMappingDsl.g:9161:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt205=2;
            int LA205_0 = input.LA(1);

            if ( (LA205_0==85) ) {
                alt205=1;
            }
            else if ( (LA205_0==86) ) {
                alt205=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 205, 0, input);

                throw nvae;
            }
            switch (alt205) {
                case 1 :
                    // InternalMappingDsl.g:9162:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalMappingDsl.g:9162:3: (enumLiteral_0= 'mandatory' )
                    // InternalMappingDsl.g:9163:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9170:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalMappingDsl.g:9170:3: (enumLiteral_1= 'singleval' )
                    // InternalMappingDsl.g:9171:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

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
    // InternalMappingDsl.g:9181:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) ;
    public final Enumerator ruleServiceJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9187:2: ( ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) )
            // InternalMappingDsl.g:9188:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            {
            // InternalMappingDsl.g:9188:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            int alt206=8;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt206=1;
                }
                break;
            case 87:
                {
                alt206=2;
                }
                break;
            case 137:
                {
                alt206=3;
                }
                break;
            case 138:
                {
                alt206=4;
                }
                break;
            case 43:
                {
                alt206=5;
                }
                break;
            case 44:
                {
                alt206=6;
                }
                break;
            case 45:
                {
                alt206=7;
                }
                break;
            case 22:
                {
                alt206=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 206, 0, input);

                throw nvae;
            }

            switch (alt206) {
                case 1 :
                    // InternalMappingDsl.g:9189:3: (enumLiteral_0= 'types' )
                    {
                    // InternalMappingDsl.g:9189:3: (enumLiteral_0= 'types' )
                    // InternalMappingDsl.g:9190:4: enumLiteral_0= 'types'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9197:3: (enumLiteral_1= 'fields' )
                    {
                    // InternalMappingDsl.g:9197:3: (enumLiteral_1= 'fields' )
                    // InternalMappingDsl.g:9198:4: enumLiteral_1= 'fields'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9205:3: (enumLiteral_2= 'domainOperations' )
                    {
                    // InternalMappingDsl.g:9205:3: (enumLiteral_2= 'domainOperations' )
                    // InternalMappingDsl.g:9206:4: enumLiteral_2= 'domainOperations'
                    {
                    enumLiteral_2=(Token)match(input,137,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:9213:3: (enumLiteral_3= 'domainParameters' )
                    {
                    // InternalMappingDsl.g:9213:3: (enumLiteral_3= 'domainParameters' )
                    // InternalMappingDsl.g:9214:4: enumLiteral_3= 'domainParameters'
                    {
                    enumLiteral_3=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:9221:3: (enumLiteral_4= 'microservices' )
                    {
                    // InternalMappingDsl.g:9221:3: (enumLiteral_4= 'microservices' )
                    // InternalMappingDsl.g:9222:4: enumLiteral_4= 'microservices'
                    {
                    enumLiteral_4=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:9229:3: (enumLiteral_5= 'interfaces' )
                    {
                    // InternalMappingDsl.g:9229:3: (enumLiteral_5= 'interfaces' )
                    // InternalMappingDsl.g:9230:4: enumLiteral_5= 'interfaces'
                    {
                    enumLiteral_5=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMappingDsl.g:9237:3: (enumLiteral_6= 'operations' )
                    {
                    // InternalMappingDsl.g:9237:3: (enumLiteral_6= 'operations' )
                    // InternalMappingDsl.g:9238:4: enumLiteral_6= 'operations'
                    {
                    enumLiteral_6=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMappingDsl.g:9245:3: (enumLiteral_7= 'parameters' )
                    {
                    // InternalMappingDsl.g:9245:3: (enumLiteral_7= 'parameters' )
                    // InternalMappingDsl.g:9246:4: enumLiteral_7= 'parameters'
                    {
                    enumLiteral_7=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_7());
                    			

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


    // $ANTLR start "ruleAspectFeature"
    // InternalMappingDsl.g:9256:1: ruleAspectFeature returns [Enumerator current=null] : (enumLiteral_0= 'singleval' ) ;
    public final Enumerator ruleAspectFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9262:2: ( (enumLiteral_0= 'singleval' ) )
            // InternalMappingDsl.g:9263:2: (enumLiteral_0= 'singleval' )
            {
            // InternalMappingDsl.g:9263:2: (enumLiteral_0= 'singleval' )
            // InternalMappingDsl.g:9264:3: enumLiteral_0= 'singleval'
            {
            enumLiteral_0=(Token)match(input,86,FOLLOW_2); 

            			current = grammarAccess.getAspectFeatureAccess().getSINGLE_VALUEDEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getAspectFeatureAccess().getSINGLE_VALUEDEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAspectFeature"


    // $ANTLR start "ruleOperationJoinPointType"
    // InternalMappingDsl.g:9273:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9279:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalMappingDsl.g:9280:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalMappingDsl.g:9280:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt207=2;
            int LA207_0 = input.LA(1);

            if ( (LA207_0==94) ) {
                alt207=1;
            }
            else if ( (LA207_0==66) ) {
                alt207=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 207, 0, input);

                throw nvae;
            }
            switch (alt207) {
                case 1 :
                    // InternalMappingDsl.g:9281:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalMappingDsl.g:9281:3: (enumLiteral_0= 'containers' )
                    // InternalMappingDsl.g:9282:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9289:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalMappingDsl.g:9289:3: (enumLiteral_1= 'infrastructure' )
                    // InternalMappingDsl.g:9290:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); 

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


    // $ANTLR start "ruleDataStructureFeature"
    // InternalMappingDsl.g:9300:1: ruleDataStructureFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
    public final Enumerator ruleDataStructureFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9306:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalMappingDsl.g:9307:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalMappingDsl.g:9307:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt208=11;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt208=1;
                }
                break;
            case 99:
                {
                alt208=2;
                }
                break;
            case 100:
                {
                alt208=3;
                }
                break;
            case 101:
                {
                alt208=4;
                }
                break;
            case 102:
                {
                alt208=5;
                }
                break;
            case 103:
                {
                alt208=6;
                }
                break;
            case 104:
                {
                alt208=7;
                }
                break;
            case 105:
                {
                alt208=8;
                }
                break;
            case 63:
                {
                alt208=9;
                }
                break;
            case 106:
                {
                alt208=10;
                }
                break;
            case 107:
                {
                alt208=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 208, 0, input);

                throw nvae;
            }

            switch (alt208) {
                case 1 :
                    // InternalMappingDsl.g:9308:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalMappingDsl.g:9308:3: (enumLiteral_0= 'aggregate' )
                    // InternalMappingDsl.g:9309:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataStructureFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9316:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalMappingDsl.g:9316:3: (enumLiteral_1= 'applicationService' )
                    // InternalMappingDsl.g:9317:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataStructureFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9324:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalMappingDsl.g:9324:3: (enumLiteral_2= 'domainEvent' )
                    // InternalMappingDsl.g:9325:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataStructureFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:9332:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalMappingDsl.g:9332:3: (enumLiteral_3= 'domainService' )
                    // InternalMappingDsl.g:9333:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataStructureFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMappingDsl.g:9340:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalMappingDsl.g:9340:3: (enumLiteral_4= 'entity' )
                    // InternalMappingDsl.g:9341:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataStructureFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMappingDsl.g:9348:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalMappingDsl.g:9348:3: (enumLiteral_5= 'factory' )
                    // InternalMappingDsl.g:9349:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDataStructureFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMappingDsl.g:9356:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalMappingDsl.g:9356:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalMappingDsl.g:9357:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getDataStructureFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMappingDsl.g:9364:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalMappingDsl.g:9364:3: (enumLiteral_7= 'repository' )
                    // InternalMappingDsl.g:9365:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getDataStructureFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalMappingDsl.g:9372:3: (enumLiteral_8= 'service' )
                    {
                    // InternalMappingDsl.g:9372:3: (enumLiteral_8= 'service' )
                    // InternalMappingDsl.g:9373:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getDataStructureFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalMappingDsl.g:9380:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalMappingDsl.g:9380:3: (enumLiteral_9= 'specification' )
                    // InternalMappingDsl.g:9381:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getDataStructureFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalMappingDsl.g:9388:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalMappingDsl.g:9388:3: (enumLiteral_10= 'valueObject' )
                    // InternalMappingDsl.g:9389:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getDataStructureFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10());
                    			

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
    // $ANTLR end "ruleDataStructureFeature"


    // $ANTLR start "ruleDataFieldFeature"
    // InternalMappingDsl.g:9399:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9405:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalMappingDsl.g:9406:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalMappingDsl.g:9406:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt209=3;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt209=1;
                }
                break;
            case 110:
                {
                alt209=2;
                }
                break;
            case 111:
                {
                alt209=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 209, 0, input);

                throw nvae;
            }

            switch (alt209) {
                case 1 :
                    // InternalMappingDsl.g:9407:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalMappingDsl.g:9407:3: (enumLiteral_0= 'identifier' )
                    // InternalMappingDsl.g:9408:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9415:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalMappingDsl.g:9415:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalMappingDsl.g:9416:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9423:3: (enumLiteral_2= 'part' )
                    {
                    // InternalMappingDsl.g:9423:3: (enumLiteral_2= 'part' )
                    // InternalMappingDsl.g:9424:4: enumLiteral_2= 'part'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleDataFieldFeature"


    // $ANTLR start "ruleDataOperationFeature"
    // InternalMappingDsl.g:9434:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMappingDsl.g:9440:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalMappingDsl.g:9441:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalMappingDsl.g:9441:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt210=4;
            switch ( input.LA(1) ) {
            case 115:
                {
                alt210=1;
                }
                break;
            case 109:
                {
                alt210=2;
                }
                break;
            case 116:
                {
                alt210=3;
                }
                break;
            case 117:
                {
                alt210=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 210, 0, input);

                throw nvae;
            }

            switch (alt210) {
                case 1 :
                    // InternalMappingDsl.g:9442:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalMappingDsl.g:9442:3: (enumLiteral_0= 'closure' )
                    // InternalMappingDsl.g:9443:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9450:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalMappingDsl.g:9450:3: (enumLiteral_1= 'identifier' )
                    // InternalMappingDsl.g:9451:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDsl.g:9458:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalMappingDsl.g:9458:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalMappingDsl.g:9459:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDsl.g:9466:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalMappingDsl.g:9466:3: (enumLiteral_3= 'validator' )
                    // InternalMappingDsl.g:9467:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getVALIDATOREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataOperationFeatureAccess().getVALIDATOREnumLiteralDeclaration_3());
                    			

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
    // $ANTLR end "ruleDataOperationFeature"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA178 dfa178 = new DFA178(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\2\13\uffff";
    static final String dfa_3s = "\1\4\1\56\2\uffff\1\42\1\4\1\41\1\57\1\4\1\60\1\6\1\43";
    static final String dfa_4s = "\1\47\1\56\2\uffff\1\42\1\4\1\43\1\57\1\47\1\60\1\6\1\43";
    static final String dfa_5s = "\2\uffff\1\2\1\1\10\uffff";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\10\uffff\1\3\31\uffff\1\1",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\7\1\uffff\1\10",
            "\1\11",
            "\1\2\10\uffff\1\3\31\uffff\1\1",
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
    static final String dfa_9s = "\1\4\1\uffff\1\4\1\uffff\3\42\1\21\3\4\2\21\6\4\1\35\1\31\1\4\3\43\1\42\6\4\1\5\1\4\2\5\1\35\1\43\1\4\2\31\1\21\1\32\3\41\3\43\2\42\1\4\1\5\2\4\1\41\1\4\1\31\1\32\1\4\1\42\1\21\2\4\2\5\1\4\2\31\3\43\3\41\1\35\1\41\3\4\1\35\1\43\1\4";
    static final String dfa_10s = "\1\u0084\1\uffff\1\114\1\uffff\3\42\1\21\3\4\2\21\1\u0084\3\4\1\7\1\4\1\43\1\41\1\u0084\3\43\1\60\2\4\1\u0084\3\4\1\5\1\u0084\2\7\2\43\1\114\2\41\1\21\1\41\6\43\2\42\1\4\1\5\1\43\1\4\1\43\1\4\2\41\1\u0084\1\60\1\21\2\4\2\7\1\4\2\41\10\43\2\4\1\u0084\2\43\1\23";
    static final String dfa_11s = "\1\uffff\1\2\1\uffff\1\1\117\uffff";
    static final String dfa_12s = "\123\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\13\uffff\1\1\26\uffff\1\2\11\uffff\2\1\2\uffff\1\3\114\uffff\3\1",
            "",
            "\1\7\16\uffff\1\6\67\uffff\1\4\1\5",
            "",
            "\1\10",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\1\30\uffff\1\20\4\uffff\1\21\4\uffff\1\22\11\uffff\1\1\3\uffff\1\3\114\uffff\3\1",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\31\1\30\1\27\1\26",
            "\1\7",
            "\1\32\2\uffff\1\33\2\uffff\1\34",
            "\1\40\3\uffff\1\35\2\uffff\1\36\1\37",
            "\1\1\30\uffff\1\20\4\uffff\1\21\4\uffff\1\22\11\uffff\1\1\3\uffff\1\3\114\uffff\3\1",
            "\1\41",
            "\1\41",
            "\1\41",
            "\1\43\15\uffff\1\42",
            "\1\44",
            "\1\45",
            "\1\1\42\uffff\1\46\11\uffff\1\1\3\uffff\1\3\114\uffff\3\1",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\1\42\uffff\1\22\11\uffff\1\1\3\uffff\1\3\114\uffff\3\1",
            "\1\55\1\54\1\53",
            "\1\60\1\57\1\56",
            "\1\32\2\uffff\1\33\2\uffff\1\34",
            "\1\34",
            "\1\7\16\uffff\1\6\67\uffff\1\61\1\62",
            "\1\40\3\uffff\1\35\2\uffff\1\36\1\37",
            "\1\40\7\uffff\1\37",
            "\1\63",
            "\1\65\6\uffff\1\64",
            "\1\66\1\uffff\1\41",
            "\1\66\1\uffff\1\41",
            "\1\66\1\uffff\1\41",
            "\1\67",
            "\1\67",
            "\1\67",
            "\1\70",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\14\36\uffff\1\73",
            "\1\74",
            "\1\66\1\uffff\1\41",
            "\1\75",
            "\1\40\3\uffff\1\76\2\uffff\1\77\1\37",
            "\1\65\6\uffff\1\64",
            "\1\1\42\uffff\1\22\11\uffff\1\1\3\uffff\1\3\114\uffff\3\1",
            "\1\100\15\uffff\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\107\1\106\1\105",
            "\1\112\1\111\1\110",
            "\1\113",
            "\1\40\3\uffff\1\76\2\uffff\1\77\1\37",
            "\1\40\7\uffff\1\37",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\66\1\uffff\1\41",
            "\1\66\1\uffff\1\41",
            "\1\66\1\uffff\1\41",
            "\1\115\2\uffff\1\116\2\uffff\1\117",
            "\1\66\1\uffff\1\41",
            "\1\120",
            "\1\121",
            "\1\1\42\uffff\1\122\11\uffff\1\1\3\uffff\1\3\114\uffff\3\1",
            "\1\115\2\uffff\1\116\2\uffff\1\117",
            "\1\117",
            "\1\7\16\uffff\1\6"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 3326:3: ( (lv_referredOperations_15_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_14s = "\21\uffff";
    static final String dfa_15s = "\1\117\1\4\1\16\1\4\1\uffff\13\4\1\uffff";
    static final String dfa_16s = "\1\117\1\4\1\16\1\u0088\1\uffff\13\20\1\uffff";
    static final String dfa_17s = "\4\uffff\1\1\13\uffff\1\2";
    static final String dfa_18s = "\21\uffff}>";
    static final String[] dfa_19s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\153\uffff\2\4\6\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\6\uffff\1\17",
            "",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            "\1\4\13\uffff\1\20",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA178 extends DFA {

        public DFA178(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 178;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "7792:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000009000002012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000008000002012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000008000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000008000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000060018010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000060010010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000BD8000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L,0x0000000000001800L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000B98000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000B18000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000B10000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000A10000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000000D8000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000098000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000000004D8000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000498000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000418000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000009010000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000006004000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000016004000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000020008010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000020010010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000080418000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000080410000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000204000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000404000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000004L,0x00000000000000DCL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0002048000100000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000200010000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0002048000110000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0002008000100000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0026008000010010L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0006008000010010L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0xFFE3FFFF377FE1F0L,0xFFFFFFFEFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x001C000000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0002008000000010L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000008A00000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000008000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0020008000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0040000000000010L,0x0000000000000700L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0080000002000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000010L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0xFFE3FFFF377FE1F2L,0xFFFFFFFEFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000204000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000004000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000210000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x8000000000010000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000010000L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0101000004000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0100000004000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000700L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000000L,0x000000000F000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0100000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x1000380000400000L,0x0000000000800000L,0x0000000000000600L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000204004000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000010000L,0xFF00000080000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000004L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000010000L,0x0004000200018000L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000010000L,0x0004000000018000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000010000L,0x0000000200000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000000000L,0x0004000000018000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0100000000004000L,0x0000100000000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x8000000000000000L,0x00000FFC00000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000004000L,0x0000100000000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000010010L,0xFFC3000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000000010L,0xFFC3000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000000010L,0xFF03000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000000010L,0xFF02000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0101000000000002L});
    public static final BitSet FOLLOW_134 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_135 = new BitSet(new long[]{0x0000000000000000L,0x0000E00000000000L});
    public static final BitSet FOLLOW_136 = new BitSet(new long[]{0x0000000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_137 = new BitSet(new long[]{0x0100000400000002L});
    public static final BitSet FOLLOW_138 = new BitSet(new long[]{0x0000000A00000010L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_139 = new BitSet(new long[]{0x0000000000000000L,0x0038200000000000L});
    public static final BitSet FOLLOW_140 = new BitSet(new long[]{0x0000000020000002L});

}