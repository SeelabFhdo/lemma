package de.fhdo.lemma.parser.antlr.internal;

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
import de.fhdo.lemma.services.ServiceDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalServiceDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BOOLEAN", "RULE_NUMBER_WITH_TRAILING_PERIOD", "RULE_BIG_DECIMAL", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "'from'", "'as'", "'@'", "'endpoints'", "'('", "')'", "'({'", "'})'", "'microservice'", "'version'", "'{'", "'required'", "'microservices'", "','", "'}'", "'interfaces'", "'operations'", "'technology'", "'typedef'", "'='", "'::'", "'noimpl'", "'interface'", "'---'", "'@param'", "'@required'", "';'", "'refers'", "'fault'", "'?'", "':'", "'.'", "'<'", "'>'", "'-'", "'--'", "'/'", "'types'", "'compatibility'", "'matrix'", "'protocols'", "'service'", "'aspects'", "'deployment'", "'technologies'", "'infrastructure'", "'operation'", "'data'", "'formats'", "'default'", "'with'", "'format'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'primitive'", "'type'", "'based'", "'on'", "'collection'", "'list'", "'structure'", "'->'", "'<-'", "'<->'", "'environments'", "'properties'", "'mandatory'", "'singleval'", "'parameters'", "'fields'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'aspect'", "'for'", "'containers'", "'selector'", "'datatypes'", "'context'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'extends'", "'identifier'", "'neverEmpty'", "'part'", "'hide'", "'immutable'", "'enum'", "'closure'", "'sideEffectFree'", "'validator'", "'function'", "'procedure'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'param'", "'functional'", "'utility'", "'unspecified'", "'domainOperations'", "'domainParameters'"
    };
    public static final int T__50=50;
    public static final int RULE_NUMBER_WITH_TRAILING_PERIOD=7;
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
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=10;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
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
    public static final int RULE_BIG_DECIMAL=8;
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
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=9;
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


        public InternalServiceDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalServiceDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalServiceDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalServiceDsl.g"; }



     	private ServiceDslGrammarAccess grammarAccess;

        public InternalServiceDslParser(TokenStream input, ServiceDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ServiceModel";
       	}

       	@Override
       	protected ServiceDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleServiceModel"
    // InternalServiceDsl.g:65:1: entryRuleServiceModel returns [EObject current=null] : iv_ruleServiceModel= ruleServiceModel EOF ;
    public final EObject entryRuleServiceModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceModel = null;


        try {
            // InternalServiceDsl.g:65:53: (iv_ruleServiceModel= ruleServiceModel EOF )
            // InternalServiceDsl.g:66:2: iv_ruleServiceModel= ruleServiceModel EOF
            {
             newCompositeNode(grammarAccess.getServiceModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceModel=ruleServiceModel();

            state._fsp--;

             current =iv_ruleServiceModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceModel"


    // $ANTLR start "ruleServiceModel"
    // InternalServiceDsl.g:72:1: ruleServiceModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_microservices_1_0= ruleMicroservice ) )+ ) ;
    public final EObject ruleServiceModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_microservices_1_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_microservices_1_0= ruleMicroservice ) )+ ) )
            // InternalServiceDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_microservices_1_0= ruleMicroservice ) )+ )
            {
            // InternalServiceDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_microservices_1_0= ruleMicroservice ) )+ )
            // InternalServiceDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_microservices_1_0= ruleMicroservice ) )+
            {
            // InternalServiceDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalServiceDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalServiceDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalServiceDsl.g:82:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getServiceModelAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getServiceModelRule());
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
            	    break loop1;
                }
            } while (true);

            // InternalServiceDsl.g:99:3: ( (lv_microservices_1_0= ruleMicroservice ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17||LA2_0==60||(LA2_0>=130 && LA2_0<=132)||(LA2_0>=134 && LA2_0<=135)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalServiceDsl.g:100:4: (lv_microservices_1_0= ruleMicroservice )
            	    {
            	    // InternalServiceDsl.g:100:4: (lv_microservices_1_0= ruleMicroservice )
            	    // InternalServiceDsl.g:101:5: lv_microservices_1_0= ruleMicroservice
            	    {

            	    					newCompositeNode(grammarAccess.getServiceModelAccess().getMicroservicesMicroserviceParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_microservices_1_0=ruleMicroservice();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getServiceModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"microservices",
            	    						lv_microservices_1_0,
            	    						"de.fhdo.lemma.ServiceDsl.Microservice");
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
    // $ANTLR end "ruleServiceModel"


    // $ANTLR start "entryRuleImport"
    // InternalServiceDsl.g:122:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalServiceDsl.g:122:47: (iv_ruleImport= ruleImport EOF )
            // InternalServiceDsl.g:123:2: iv_ruleImport= ruleImport EOF
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
    // InternalServiceDsl.g:129:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalServiceDsl.g:135:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:136:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:136:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalServiceDsl.g:137:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalServiceDsl.g:141:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalServiceDsl.g:142:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalServiceDsl.g:142:4: (lv_importType_1_0= ruleImportType )
            // InternalServiceDsl.g:143:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_importType_1_0=ruleImportType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importType",
            						lv_importType_1_0,
            						"de.fhdo.lemma.ServiceDsl.ImportType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalServiceDsl.g:164:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalServiceDsl.g:165:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalServiceDsl.g:165:4: (lv_importURI_3_0= RULE_STRING )
            // InternalServiceDsl.g:166:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.ServiceDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalServiceDsl.g:186:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:187:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:187:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:188:5: lv_name_5_0= RULE_ID
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
    // InternalServiceDsl.g:208:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalServiceDsl.g:208:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalServiceDsl.g:209:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalServiceDsl.g:215:1: ruleMicroservice returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' ) ;
    public final EObject ruleMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_version_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        EObject lv_technologyReferences_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_protocols_2_0 = null;

        EObject lv_endpoints_6_0 = null;

        EObject lv_endpoints_11_0 = null;

        EObject lv_aspects_13_0 = null;

        Enumerator lv_visibility_14_0 = null;

        Enumerator lv_type_15_0 = null;

        AntlrDatatypeRuleToken lv_name_17_0 = null;

        EObject lv_requiredMicroservices_24_0 = null;

        EObject lv_requiredMicroservices_26_0 = null;

        EObject lv_requiredInterfaces_31_0 = null;

        EObject lv_requiredInterfaces_33_0 = null;

        EObject lv_requiredOperations_38_0 = null;

        EObject lv_requiredOperations_40_0 = null;

        EObject lv_interfaces_42_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:221:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' ) )
            // InternalServiceDsl.g:222:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' )
            {
            // InternalServiceDsl.g:222:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' )
            // InternalServiceDsl.g:223:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}'
            {
            // InternalServiceDsl.g:223:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==32) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // InternalServiceDsl.g:224:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalServiceDsl.g:224:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalServiceDsl.g:225:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_10);
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
            	    break loop3;
                }
            } while (true);

            // InternalServiceDsl.g:242:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>=70 && LA5_1<=71)) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalServiceDsl.g:243:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalServiceDsl.g:243:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalServiceDsl.g:244:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalServiceDsl.g:244:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalServiceDsl.g:245:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_10);
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

                    // InternalServiceDsl.g:262:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==17) ) {
                        int LA4_1 = input.LA(2);

                        if ( ((LA4_1>=70 && LA4_1<=71)) ) {
                            alt4=1;
                        }
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalServiceDsl.g:263:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalServiceDsl.g:263:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalServiceDsl.g:264:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_10);
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

            // InternalServiceDsl.g:282:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==18) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==19) ) {
                        alt7=1;
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalServiceDsl.g:283:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,19,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalServiceDsl.g:295:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalServiceDsl.g:296:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:296:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:297:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    otherlv_7=(Token)match(input,20,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:319:3: (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==18) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // InternalServiceDsl.g:320:4: otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})'
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_3_1());
                    			
                    otherlv_10=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceAccess().getLeftParenthesisLeftCurlyBracketKeyword_3_2());
                    			
                    // InternalServiceDsl.g:332:4: ( (lv_endpoints_11_0= ruleEndpoint ) )+
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
                    	    // InternalServiceDsl.g:333:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:333:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:334:6: lv_endpoints_11_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_11_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_11_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
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

                    otherlv_12=(Token)match(input,22,FOLLOW_10); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceAccess().getRightCurlyBracketRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:356:3: ( (lv_aspects_13_0= ruleImportedServiceAspect ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalServiceDsl.g:357:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    {
            	    // InternalServiceDsl.g:357:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    // InternalServiceDsl.g:358:5: lv_aspects_13_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_aspects_13_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_13_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalServiceDsl.g:375:3: ( (lv_visibility_14_0= ruleVisibility ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=130 && LA11_0<=132)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalServiceDsl.g:376:4: (lv_visibility_14_0= ruleVisibility )
                    {
                    // InternalServiceDsl.g:376:4: (lv_visibility_14_0= ruleVisibility )
                    // InternalServiceDsl.g:377:5: lv_visibility_14_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_visibility_14_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_14_0,
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:394:3: ( (lv_type_15_0= ruleMicroserviceType ) )
            // InternalServiceDsl.g:395:4: (lv_type_15_0= ruleMicroserviceType )
            {
            // InternalServiceDsl.g:395:4: (lv_type_15_0= ruleMicroserviceType )
            // InternalServiceDsl.g:396:5: lv_type_15_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_15_0=ruleMicroserviceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_15_0,
            						"de.fhdo.lemma.ServiceDsl.MicroserviceType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,23,FOLLOW_9); 

            			newLeafNode(otherlv_16, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_7());
            		
            // InternalServiceDsl.g:417:3: ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalServiceDsl.g:418:4: (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalServiceDsl.g:418:4: (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalServiceDsl.g:419:5: lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_17_0=ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_17_0,
            						"de.fhdo.lemma.ServiceDsl.QualifiedNameWithAtLeastOneLevel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalServiceDsl.g:436:3: (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalServiceDsl.g:437:4: otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) )
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceAccess().getVersionKeyword_9_0());
                    			
                    // InternalServiceDsl.g:441:4: ( (lv_version_19_0= RULE_ID ) )
                    // InternalServiceDsl.g:442:5: (lv_version_19_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:442:5: (lv_version_19_0= RULE_ID )
                    // InternalServiceDsl.g:443:6: lv_version_19_0= RULE_ID
                    {
                    lv_version_19_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    						newLeafNode(lv_version_19_0, grammarAccess.getMicroserviceAccess().getVersionIDTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMicroserviceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"version",
                    							lv_version_19_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_20=(Token)match(input,25,FOLLOW_19); 

            			newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalServiceDsl.g:464:3: (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==27) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalServiceDsl.g:465:4: otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}'
                    {
                    otherlv_21=(Token)match(input,26,FOLLOW_20); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_22=(Token)match(input,27,FOLLOW_18); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_11_1());
                    			
                    otherlv_23=(Token)match(input,25,FOLLOW_9); 

                    				newLeafNode(otherlv_23, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalServiceDsl.g:477:4: ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) )
                    // InternalServiceDsl.g:478:5: (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalServiceDsl.g:478:5: (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice )
                    // InternalServiceDsl.g:479:6: lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_requiredMicroservices_24_0=rulePossiblyImportedMicroservice();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredMicroservices",
                    							lv_requiredMicroservices_24_0,
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedMicroservice");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalServiceDsl.g:496:4: (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==28) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalServiceDsl.g:497:5: otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_25=(Token)match(input,28,FOLLOW_9); 

                    	    					newLeafNode(otherlv_25, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalServiceDsl.g:501:5: ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalServiceDsl.g:502:6: (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalServiceDsl.g:502:6: (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice )
                    	    // InternalServiceDsl.g:503:7: lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_requiredMicroservices_26_0=rulePossiblyImportedMicroservice();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredMicroservices",
                    	    								lv_requiredMicroservices_26_0,
                    	    								"de.fhdo.lemma.ServiceDsl.PossiblyImportedMicroservice");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,29,FOLLOW_19); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:526:3: (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==30) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalServiceDsl.g:527:4: otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}'
                    {
                    otherlv_28=(Token)match(input,26,FOLLOW_22); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_29=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_12_1());
                    			
                    otherlv_30=(Token)match(input,25,FOLLOW_9); 

                    				newLeafNode(otherlv_30, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalServiceDsl.g:539:4: ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) )
                    // InternalServiceDsl.g:540:5: (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface )
                    {
                    // InternalServiceDsl.g:540:5: (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface )
                    // InternalServiceDsl.g:541:6: lv_requiredInterfaces_31_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_requiredInterfaces_31_0=rulePossiblyImportedInterface();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredInterfaces",
                    							lv_requiredInterfaces_31_0,
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedInterface");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalServiceDsl.g:558:4: (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==28) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalServiceDsl.g:559:5: otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_32=(Token)match(input,28,FOLLOW_9); 

                    	    					newLeafNode(otherlv_32, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalServiceDsl.g:563:5: ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) )
                    	    // InternalServiceDsl.g:564:6: (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalServiceDsl.g:564:6: (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface )
                    	    // InternalServiceDsl.g:565:7: lv_requiredInterfaces_33_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_requiredInterfaces_33_0=rulePossiblyImportedInterface();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredInterfaces",
                    	    								lv_requiredInterfaces_33_0,
                    	    								"de.fhdo.lemma.ServiceDsl.PossiblyImportedInterface");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_34=(Token)match(input,29,FOLLOW_19); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:588:3: (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalServiceDsl.g:589:4: otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}'
                    {
                    otherlv_35=(Token)match(input,26,FOLLOW_23); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getRequiredKeyword_13_0());
                    			
                    otherlv_36=(Token)match(input,31,FOLLOW_18); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getOperationsKeyword_13_1());
                    			
                    otherlv_37=(Token)match(input,25,FOLLOW_9); 

                    				newLeafNode(otherlv_37, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_13_2());
                    			
                    // InternalServiceDsl.g:601:4: ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) )
                    // InternalServiceDsl.g:602:5: (lv_requiredOperations_38_0= rulePossiblyImportedOperation )
                    {
                    // InternalServiceDsl.g:602:5: (lv_requiredOperations_38_0= rulePossiblyImportedOperation )
                    // InternalServiceDsl.g:603:6: lv_requiredOperations_38_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_13_3_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_requiredOperations_38_0=rulePossiblyImportedOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    						}
                    						add(
                    							current,
                    							"requiredOperations",
                    							lv_requiredOperations_38_0,
                    							"de.fhdo.lemma.ServiceDsl.PossiblyImportedOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalServiceDsl.g:620:4: (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==28) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalServiceDsl.g:621:5: otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_39=(Token)match(input,28,FOLLOW_9); 

                    	    					newLeafNode(otherlv_39, grammarAccess.getMicroserviceAccess().getCommaKeyword_13_4_0());
                    	    				
                    	    // InternalServiceDsl.g:625:5: ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) )
                    	    // InternalServiceDsl.g:626:6: (lv_requiredOperations_40_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalServiceDsl.g:626:6: (lv_requiredOperations_40_0= rulePossiblyImportedOperation )
                    	    // InternalServiceDsl.g:627:7: lv_requiredOperations_40_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_13_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_requiredOperations_40_0=rulePossiblyImportedOperation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMicroserviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredOperations",
                    	    								lv_requiredOperations_40_0,
                    	    								"de.fhdo.lemma.ServiceDsl.PossiblyImportedOperation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_41=(Token)match(input,29,FOLLOW_19); 

                    				newLeafNode(otherlv_41, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_13_5());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:650:3: ( (lv_interfaces_42_0= ruleInterface ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==17||(LA19_0>=36 && LA19_0<=37)||(LA19_0>=130 && LA19_0<=132)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalServiceDsl.g:651:4: (lv_interfaces_42_0= ruleInterface )
            	    {
            	    // InternalServiceDsl.g:651:4: (lv_interfaces_42_0= ruleInterface )
            	    // InternalServiceDsl.g:652:5: lv_interfaces_42_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_24);
            	    lv_interfaces_42_0=ruleInterface();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMicroserviceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"interfaces",
            	    						lv_interfaces_42_0,
            	    						"de.fhdo.lemma.ServiceDsl.Interface");
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

            otherlv_43=(Token)match(input,29,FOLLOW_2); 

            			newLeafNode(otherlv_43, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

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
    // InternalServiceDsl.g:677:1: entryRuleTechnologyReference returns [EObject current=null] : iv_ruleTechnologyReference= ruleTechnologyReference EOF ;
    public final EObject entryRuleTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyReference = null;


        try {
            // InternalServiceDsl.g:677:60: (iv_ruleTechnologyReference= ruleTechnologyReference EOF )
            // InternalServiceDsl.g:678:2: iv_ruleTechnologyReference= ruleTechnologyReference EOF
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
    // InternalServiceDsl.g:684:1: ruleTechnologyReference returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) ;
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
            // InternalServiceDsl.g:690:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) )
            // InternalServiceDsl.g:691:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            {
            // InternalServiceDsl.g:691:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            // InternalServiceDsl.g:692:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalServiceDsl.g:704:3: ( (otherlv_3= RULE_ID ) )
            // InternalServiceDsl.g:705:4: (otherlv_3= RULE_ID )
            {
            // InternalServiceDsl.g:705:4: (otherlv_3= RULE_ID )
            // InternalServiceDsl.g:706:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(otherlv_3, grammarAccess.getTechnologyReferenceAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            // InternalServiceDsl.g:717:3: (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalServiceDsl.g:718:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,33,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologyReferenceAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalServiceDsl.g:730:4: ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    // InternalServiceDsl.g:731:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    {
                    // InternalServiceDsl.g:731:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    // InternalServiceDsl.g:732:6: lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN
                    {
                    lv_isTypeDefinitionTechnology_7_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_30); 

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

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

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
    // InternalServiceDsl.g:757:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalServiceDsl.g:757:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalServiceDsl.g:758:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalServiceDsl.g:764:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:770:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:771:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:771:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:772:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:772:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==35) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalServiceDsl.g:773:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalServiceDsl.g:773:4: ( (otherlv_0= RULE_ID ) )
                    // InternalServiceDsl.g:774:5: (otherlv_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:774:5: (otherlv_0= RULE_ID )
                    // InternalServiceDsl.g:775:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,35,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:791:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:792:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:792:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:793:5: ruleQualifiedName
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
    // InternalServiceDsl.g:811:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalServiceDsl.g:811:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalServiceDsl.g:812:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalServiceDsl.g:818:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:824:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:825:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:825:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:826:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:826:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==35) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalServiceDsl.g:827:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalServiceDsl.g:827:4: ( (otherlv_0= RULE_ID ) )
                    // InternalServiceDsl.g:828:5: (otherlv_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:828:5: (otherlv_0= RULE_ID )
                    // InternalServiceDsl.g:829:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,35,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:845:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:846:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:846:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:847:5: ruleQualifiedName
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
    // InternalServiceDsl.g:865:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalServiceDsl.g:865:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalServiceDsl.g:866:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalServiceDsl.g:872:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:878:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:879:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:879:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:880:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:880:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==35) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // InternalServiceDsl.g:881:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalServiceDsl.g:881:4: ( (otherlv_0= RULE_ID ) )
                    // InternalServiceDsl.g:882:5: (otherlv_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:882:5: (otherlv_0= RULE_ID )
                    // InternalServiceDsl.g:883:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,35,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:899:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:900:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:900:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:901:5: ruleQualifiedName
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
    // InternalServiceDsl.g:919:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalServiceDsl.g:919:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalServiceDsl.g:920:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalServiceDsl.g:926:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' ) ;
    public final EObject ruleInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_notImplemented_13_0=null;
        Token otherlv_15=null;
        Token lv_name_16_0=null;
        Token otherlv_17=null;
        Token lv_version_18_0=null;
        Token otherlv_19=null;
        Token otherlv_22=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_endpoints_5_0 = null;

        EObject lv_endpoints_10_0 = null;

        EObject lv_aspects_12_0 = null;

        Enumerator lv_visibility_14_0 = null;

        EObject lv_referredOperations_20_0 = null;

        EObject lv_operations_21_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:932:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' ) )
            // InternalServiceDsl.g:933:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' )
            {
            // InternalServiceDsl.g:933:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' )
            // InternalServiceDsl.g:934:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}'
            {
            // InternalServiceDsl.g:934:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==17) ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>=70 && LA25_1<=71)) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalServiceDsl.g:935:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalServiceDsl.g:935:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalServiceDsl.g:936:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalServiceDsl.g:936:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalServiceDsl.g:937:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_32);
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

                    // InternalServiceDsl.g:954:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==17) ) {
                        int LA24_1 = input.LA(2);

                        if ( ((LA24_1>=70 && LA24_1<=71)) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalServiceDsl.g:955:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalServiceDsl.g:955:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalServiceDsl.g:956:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_32);
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

            // InternalServiceDsl.g:974:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==18) ) {
                    int LA27_3 = input.LA(3);

                    if ( (LA27_3==19) ) {
                        alt27=1;
                    }
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalServiceDsl.g:975:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,19,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalServiceDsl.g:987:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalServiceDsl.g:988:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:988:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:989:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_32); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1011:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==17) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==18) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalServiceDsl.g:1012:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_9, grammarAccess.getInterfaceAccess().getLeftParenthesisLeftCurlyBracketKeyword_2_2());
                    			
                    // InternalServiceDsl.g:1024:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
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
                    	    // InternalServiceDsl.g:1025:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:1025:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:1026:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_10_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_10_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
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

                    otherlv_11=(Token)match(input,22,FOLLOW_32); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceAccess().getRightCurlyBracketRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1048:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==17) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalServiceDsl.g:1049:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalServiceDsl.g:1049:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalServiceDsl.g:1050:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_aspects_12_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_12_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalServiceDsl.g:1067:3: ( (lv_notImplemented_13_0= 'noimpl' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalServiceDsl.g:1068:4: (lv_notImplemented_13_0= 'noimpl' )
                    {
                    // InternalServiceDsl.g:1068:4: (lv_notImplemented_13_0= 'noimpl' )
                    // InternalServiceDsl.g:1069:5: lv_notImplemented_13_0= 'noimpl'
                    {
                    lv_notImplemented_13_0=(Token)match(input,36,FOLLOW_33); 

                    					newLeafNode(lv_notImplemented_13_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", lv_notImplemented_13_0 != null, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1081:3: ( (lv_visibility_14_0= ruleVisibility ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=130 && LA32_0<=132)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalServiceDsl.g:1082:4: (lv_visibility_14_0= ruleVisibility )
                    {
                    // InternalServiceDsl.g:1082:4: (lv_visibility_14_0= ruleVisibility )
                    // InternalServiceDsl.g:1083:5: lv_visibility_14_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_34);
                    lv_visibility_14_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_14_0,
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,37,FOLLOW_9); 

            			newLeafNode(otherlv_15, grammarAccess.getInterfaceAccess().getInterfaceKeyword_6());
            		
            // InternalServiceDsl.g:1104:3: ( (lv_name_16_0= RULE_ID ) )
            // InternalServiceDsl.g:1105:4: (lv_name_16_0= RULE_ID )
            {
            // InternalServiceDsl.g:1105:4: (lv_name_16_0= RULE_ID )
            // InternalServiceDsl.g:1106:5: lv_name_16_0= RULE_ID
            {
            lv_name_16_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_16_0, grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInterfaceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_16_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalServiceDsl.g:1122:3: (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==24) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalServiceDsl.g:1123:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_17, grammarAccess.getInterfaceAccess().getVersionKeyword_8_0());
                    			
                    // InternalServiceDsl.g:1127:4: ( (lv_version_18_0= RULE_ID ) )
                    // InternalServiceDsl.g:1128:5: (lv_version_18_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:1128:5: (lv_version_18_0= RULE_ID )
                    // InternalServiceDsl.g:1129:6: lv_version_18_0= RULE_ID
                    {
                    lv_version_18_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    						newLeafNode(lv_version_18_0, grammarAccess.getInterfaceAccess().getVersionIDTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInterfaceRule());
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

            otherlv_19=(Token)match(input,25,FOLLOW_35); 

            			newLeafNode(otherlv_19, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalServiceDsl.g:1150:3: ( (lv_referredOperations_20_0= ruleReferredOperation ) )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // InternalServiceDsl.g:1151:4: (lv_referredOperations_20_0= ruleReferredOperation )
            	    {
            	    // InternalServiceDsl.g:1151:4: (lv_referredOperations_20_0= ruleReferredOperation )
            	    // InternalServiceDsl.g:1152:5: lv_referredOperations_20_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_referredOperations_20_0=ruleReferredOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"referredOperations",
            	    						lv_referredOperations_20_0,
            	    						"de.fhdo.lemma.ServiceDsl.ReferredOperation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalServiceDsl.g:1169:3: ( (lv_operations_21_0= ruleOperation ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID||LA35_0==17||LA35_0==36||LA35_0==38||(LA35_0>=130 && LA35_0<=132)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalServiceDsl.g:1170:4: (lv_operations_21_0= ruleOperation )
            	    {
            	    // InternalServiceDsl.g:1170:4: (lv_operations_21_0= ruleOperation )
            	    // InternalServiceDsl.g:1171:5: lv_operations_21_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_operations_21_0=ruleOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInterfaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operations",
            	    						lv_operations_21_0,
            	    						"de.fhdo.lemma.ServiceDsl.Operation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_22=(Token)match(input,29,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getInterfaceAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

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
    // InternalServiceDsl.g:1196:1: entryRuleApiOperationComment returns [EObject current=null] : iv_ruleApiOperationComment= ruleApiOperationComment EOF ;
    public final EObject entryRuleApiOperationComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiOperationComment = null;


        try {
            // InternalServiceDsl.g:1196:60: (iv_ruleApiOperationComment= ruleApiOperationComment EOF )
            // InternalServiceDsl.g:1197:2: iv_ruleApiOperationComment= ruleApiOperationComment EOF
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
    // InternalServiceDsl.g:1203:1: ruleApiOperationComment returns [EObject current=null] : (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) ;
    public final EObject ruleApiOperationComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_comment_1_0 = null;

        EObject lv_parameterComments_2_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:1209:2: ( (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) )
            // InternalServiceDsl.g:1210:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            {
            // InternalServiceDsl.g:1210:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            // InternalServiceDsl.g:1211:3: otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getApiOperationCommentAccess().getHyphenMinusHyphenMinusHyphenMinusKeyword_0());
            		
            // InternalServiceDsl.g:1215:3: ( (lv_comment_1_0= ruleAnything ) )
            // InternalServiceDsl.g:1216:4: (lv_comment_1_0= ruleAnything )
            {
            // InternalServiceDsl.g:1216:4: (lv_comment_1_0= ruleAnything )
            // InternalServiceDsl.g:1217:5: lv_comment_1_0= ruleAnything
            {

            					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getCommentAnythingParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalServiceDsl.g:1234:3: ( (lv_parameterComments_2_0= ruleApiParameterComment ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=39 && LA36_0<=40)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalServiceDsl.g:1235:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    {
            	    // InternalServiceDsl.g:1235:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    // InternalServiceDsl.g:1236:5: lv_parameterComments_2_0= ruleApiParameterComment
            	    {

            	    					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getParameterCommentsApiParameterCommentParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_38);
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
            	    break loop36;
                }
            } while (true);

            otherlv_3=(Token)match(input,38,FOLLOW_2); 

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
    // InternalServiceDsl.g:1261:1: entryRuleApiParameterComment returns [EObject current=null] : iv_ruleApiParameterComment= ruleApiParameterComment EOF ;
    public final EObject entryRuleApiParameterComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiParameterComment = null;


        try {
            // InternalServiceDsl.g:1261:60: (iv_ruleApiParameterComment= ruleApiParameterComment EOF )
            // InternalServiceDsl.g:1262:2: iv_ruleApiParameterComment= ruleApiParameterComment EOF
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
    // InternalServiceDsl.g:1268:1: ruleApiParameterComment returns [EObject current=null] : ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) ) ;
    public final EObject ruleApiParameterComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_required_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_comment_3_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:1274:2: ( ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) ) )
            // InternalServiceDsl.g:1275:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) )
            {
            // InternalServiceDsl.g:1275:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) )
            // InternalServiceDsl.g:1276:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) )
            {
            // InternalServiceDsl.g:1276:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==39) ) {
                alt37=1;
            }
            else if ( (LA37_0==40) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalServiceDsl.g:1277:4: otherlv_0= '@param'
                    {
                    otherlv_0=(Token)match(input,39,FOLLOW_9); 

                    				newLeafNode(otherlv_0, grammarAccess.getApiParameterCommentAccess().getParamKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:1282:4: ( (lv_required_1_0= '@required' ) )
                    {
                    // InternalServiceDsl.g:1282:4: ( (lv_required_1_0= '@required' ) )
                    // InternalServiceDsl.g:1283:5: (lv_required_1_0= '@required' )
                    {
                    // InternalServiceDsl.g:1283:5: (lv_required_1_0= '@required' )
                    // InternalServiceDsl.g:1284:6: lv_required_1_0= '@required'
                    {
                    lv_required_1_0=(Token)match(input,40,FOLLOW_9); 

                    						newLeafNode(lv_required_1_0, grammarAccess.getApiParameterCommentAccess().getRequiredRequiredKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getApiParameterCommentRule());
                    						}
                    						setWithLastConsumed(current, "required", lv_required_1_0 != null, "@required");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1297:3: ( (otherlv_2= RULE_ID ) )
            // InternalServiceDsl.g:1298:4: (otherlv_2= RULE_ID )
            {
            // InternalServiceDsl.g:1298:4: (otherlv_2= RULE_ID )
            // InternalServiceDsl.g:1299:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApiParameterCommentRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_2, grammarAccess.getApiParameterCommentAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalServiceDsl.g:1310:3: ( (lv_comment_3_0= ruleAnything ) )
            // InternalServiceDsl.g:1311:4: (lv_comment_3_0= ruleAnything )
            {
            // InternalServiceDsl.g:1311:4: (lv_comment_3_0= ruleAnything )
            // InternalServiceDsl.g:1312:5: lv_comment_3_0= ruleAnything
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
    // InternalServiceDsl.g:1333:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalServiceDsl.g:1333:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalServiceDsl.g:1334:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalServiceDsl.g:1340:1: ruleOperation returns [EObject current=null] : ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_notImplemented_14_0=null;
        Token lv_name_16_0=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        EObject lv_apiOperationComment_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_protocols_2_0 = null;

        EObject lv_endpoints_6_0 = null;

        EObject lv_endpoints_11_0 = null;

        EObject lv_aspects_13_0 = null;

        Enumerator lv_visibility_15_0 = null;

        EObject lv_parameters_18_0 = null;

        EObject lv_parameters_20_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:1346:2: ( ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' ) )
            // InternalServiceDsl.g:1347:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' )
            {
            // InternalServiceDsl.g:1347:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' )
            // InternalServiceDsl.g:1348:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';'
            {
            // InternalServiceDsl.g:1348:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalServiceDsl.g:1349:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    {
                    // InternalServiceDsl.g:1349:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    // InternalServiceDsl.g:1350:5: lv_apiOperationComment_0_0= ruleApiOperationComment
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getApiOperationCommentApiOperationCommentParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_39);
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

            // InternalServiceDsl.g:1367:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==17) ) {
                int LA40_1 = input.LA(2);

                if ( ((LA40_1>=70 && LA40_1<=71)) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalServiceDsl.g:1368:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalServiceDsl.g:1368:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalServiceDsl.g:1369:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalServiceDsl.g:1369:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalServiceDsl.g:1370:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_39);
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

                    // InternalServiceDsl.g:1387:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==17) ) {
                        int LA39_1 = input.LA(2);

                        if ( ((LA39_1>=70 && LA39_1<=71)) ) {
                            alt39=1;
                        }
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalServiceDsl.g:1388:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalServiceDsl.g:1388:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalServiceDsl.g:1389:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_39);
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

            // InternalServiceDsl.g:1407:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==17) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==18) ) {
                    int LA42_3 = input.LA(3);

                    if ( (LA42_3==19) ) {
                        alt42=1;
                    }
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalServiceDsl.g:1408:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,19,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalServiceDsl.g:1420:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
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
                    	    // InternalServiceDsl.g:1421:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:1421:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:1422:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_7=(Token)match(input,20,FOLLOW_39); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1444:3: (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==17) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==18) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalServiceDsl.g:1445:4: otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})'
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getCommercialAtKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getOperationAccess().getEndpointsKeyword_3_1());
                    			
                    otherlv_10=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationAccess().getLeftParenthesisLeftCurlyBracketKeyword_3_2());
                    			
                    // InternalServiceDsl.g:1457:4: ( (lv_endpoints_11_0= ruleEndpoint ) )+
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
                    	    // InternalServiceDsl.g:1458:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:1458:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:1459:6: lv_endpoints_11_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_11_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_11_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
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

                    otherlv_12=(Token)match(input,22,FOLLOW_39); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationAccess().getRightCurlyBracketRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1481:3: ( (lv_aspects_13_0= ruleImportedServiceAspect ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==17) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalServiceDsl.g:1482:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    {
            	    // InternalServiceDsl.g:1482:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    // InternalServiceDsl.g:1483:5: lv_aspects_13_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_aspects_13_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_13_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // InternalServiceDsl.g:1500:3: ( (lv_notImplemented_14_0= 'noimpl' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==36) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalServiceDsl.g:1501:4: (lv_notImplemented_14_0= 'noimpl' )
                    {
                    // InternalServiceDsl.g:1501:4: (lv_notImplemented_14_0= 'noimpl' )
                    // InternalServiceDsl.g:1502:5: lv_notImplemented_14_0= 'noimpl'
                    {
                    lv_notImplemented_14_0=(Token)match(input,36,FOLLOW_40); 

                    					newLeafNode(lv_notImplemented_14_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", lv_notImplemented_14_0 != null, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1514:3: ( (lv_visibility_15_0= ruleVisibility ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=130 && LA47_0<=132)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalServiceDsl.g:1515:4: (lv_visibility_15_0= ruleVisibility )
                    {
                    // InternalServiceDsl.g:1515:4: (lv_visibility_15_0= ruleVisibility )
                    // InternalServiceDsl.g:1516:5: lv_visibility_15_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_9);
                    lv_visibility_15_0=ruleVisibility();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					set(
                    						current,
                    						"visibility",
                    						lv_visibility_15_0,
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1533:3: ( (lv_name_16_0= RULE_ID ) )
            // InternalServiceDsl.g:1534:4: (lv_name_16_0= RULE_ID )
            {
            // InternalServiceDsl.g:1534:4: (lv_name_16_0= RULE_ID )
            // InternalServiceDsl.g:1535:5: lv_name_16_0= RULE_ID
            {
            lv_name_16_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_16_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_16_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_17=(Token)match(input,19,FOLLOW_41); 

            			newLeafNode(otherlv_17, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_8());
            		
            // InternalServiceDsl.g:1555:3: ( (lv_parameters_18_0= ruleParameter ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==17||(LA48_0>=70 && LA48_0<=71)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalServiceDsl.g:1556:4: (lv_parameters_18_0= ruleParameter )
                    {
                    // InternalServiceDsl.g:1556:4: (lv_parameters_18_0= ruleParameter )
                    // InternalServiceDsl.g:1557:5: lv_parameters_18_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_9_0());
                    				
                    pushFollow(FOLLOW_26);
                    lv_parameters_18_0=ruleParameter();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					add(
                    						current,
                    						"parameters",
                    						lv_parameters_18_0,
                    						"de.fhdo.lemma.ServiceDsl.Parameter");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1574:3: (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==28) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalServiceDsl.g:1575:4: otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) )
            	    {
            	    otherlv_19=(Token)match(input,28,FOLLOW_42); 

            	    				newLeafNode(otherlv_19, grammarAccess.getOperationAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalServiceDsl.g:1579:4: ( (lv_parameters_20_0= ruleParameter ) )
            	    // InternalServiceDsl.g:1580:5: (lv_parameters_20_0= ruleParameter )
            	    {
            	    // InternalServiceDsl.g:1580:5: (lv_parameters_20_0= ruleParameter )
            	    // InternalServiceDsl.g:1581:6: lv_parameters_20_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_parameters_20_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_20_0,
            	    							"de.fhdo.lemma.ServiceDsl.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_21=(Token)match(input,20,FOLLOW_43); 

            			newLeafNode(otherlv_21, grammarAccess.getOperationAccess().getRightParenthesisKeyword_11());
            		
            otherlv_22=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getOperationAccess().getSemicolonKeyword_12());
            		

            }


            }


            	leaveRule();

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
    // InternalServiceDsl.g:1611:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalServiceDsl.g:1611:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalServiceDsl.g:1612:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalServiceDsl.g:1618:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' ) ;
    public final EObject ruleReferredOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_protocols_0_0 = null;

        EObject lv_protocols_1_0 = null;

        EObject lv_endpoints_5_0 = null;

        EObject lv_endpoints_10_0 = null;

        EObject lv_aspects_12_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:1624:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' ) )
            // InternalServiceDsl.g:1625:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' )
            {
            // InternalServiceDsl.g:1625:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' )
            // InternalServiceDsl.g:1626:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';'
            {
            // InternalServiceDsl.g:1626:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==17) ) {
                int LA51_1 = input.LA(2);

                if ( ((LA51_1>=70 && LA51_1<=71)) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // InternalServiceDsl.g:1627:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalServiceDsl.g:1627:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalServiceDsl.g:1628:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalServiceDsl.g:1628:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalServiceDsl.g:1629:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_44);
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

                    // InternalServiceDsl.g:1646:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==17) ) {
                        int LA50_1 = input.LA(2);

                        if ( ((LA50_1>=70 && LA50_1<=71)) ) {
                            alt50=1;
                        }
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalServiceDsl.g:1647:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalServiceDsl.g:1647:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalServiceDsl.g:1648:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_44);
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

            // InternalServiceDsl.g:1666:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==17) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==18) ) {
                    int LA53_3 = input.LA(3);

                    if ( (LA53_3==19) ) {
                        alt53=1;
                    }
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalServiceDsl.g:1667:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,19,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalServiceDsl.g:1679:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalServiceDsl.g:1680:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:1680:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:1681:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_44); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1703:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==17) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==18) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalServiceDsl.g:1704:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,21,FOLLOW_9); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationAccess().getLeftParenthesisLeftCurlyBracketKeyword_2_2());
                    			
                    // InternalServiceDsl.g:1716:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
                    int cnt54=0;
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==RULE_ID) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalServiceDsl.g:1717:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalServiceDsl.g:1717:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalServiceDsl.g:1718:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    lv_endpoints_10_0=ruleEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getReferredOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_10_0,
                    	    							"de.fhdo.lemma.ServiceDsl.Endpoint");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt54 >= 1 ) break loop54;
                                EarlyExitException eee =
                                    new EarlyExitException(54, input);
                                throw eee;
                        }
                        cnt54++;
                    } while (true);

                    otherlv_11=(Token)match(input,22,FOLLOW_44); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationAccess().getRightCurlyBracketRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1740:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==17) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalServiceDsl.g:1741:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalServiceDsl.g:1741:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalServiceDsl.g:1742:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_44);
            	    lv_aspects_12_0=ruleImportedServiceAspect();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReferredOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aspects",
            	    						lv_aspects_12_0,
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            otherlv_13=(Token)match(input,42,FOLLOW_9); 

            			newLeafNode(otherlv_13, grammarAccess.getReferredOperationAccess().getRefersKeyword_4());
            		
            // InternalServiceDsl.g:1763:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:1764:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:1764:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:1765:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_5_0());
            				
            pushFollow(FOLLOW_43);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getReferredOperationAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalServiceDsl.g:1787:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalServiceDsl.g:1787:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalServiceDsl.g:1788:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalServiceDsl.g:1794:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalServiceDsl.g:1800:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalServiceDsl.g:1801:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalServiceDsl.g:1801:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalServiceDsl.g:1802:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalServiceDsl.g:1802:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==17) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalServiceDsl.g:1803:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalServiceDsl.g:1803:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalServiceDsl.g:1804:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_42);
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
            	    break loop57;
                }
            } while (true);

            // InternalServiceDsl.g:1821:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalServiceDsl.g:1822:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalServiceDsl.g:1822:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalServiceDsl.g:1823:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_45);
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

            // InternalServiceDsl.g:1840:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=67 && LA58_0<=69)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalServiceDsl.g:1841:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalServiceDsl.g:1841:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalServiceDsl.g:1842:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_46);
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

            // InternalServiceDsl.g:1859:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==43) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalServiceDsl.g:1860:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalServiceDsl.g:1860:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalServiceDsl.g:1861:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,43,FOLLOW_9); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", lv_communicatesFault_3_0 != null, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1873:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalServiceDsl.g:1874:4: (lv_name_4_0= RULE_ID )
            {
            // InternalServiceDsl.g:1874:4: (lv_name_4_0= RULE_ID )
            // InternalServiceDsl.g:1875:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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

            // InternalServiceDsl.g:1891:3: ( (lv_optional_5_0= '?' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==44) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalServiceDsl.g:1892:4: (lv_optional_5_0= '?' )
                    {
                    // InternalServiceDsl.g:1892:4: (lv_optional_5_0= '?' )
                    // InternalServiceDsl.g:1893:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,44,FOLLOW_48); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", lv_optional_5_0 != null, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,45,FOLLOW_49); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalServiceDsl.g:1909:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=120 && LA61_0<=129)||LA61_0==136) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalServiceDsl.g:1910:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalServiceDsl.g:1910:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:1911:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:1911:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalServiceDsl.g:1912:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_50);
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
                    // InternalServiceDsl.g:1930:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalServiceDsl.g:1930:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalServiceDsl.g:1931:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalServiceDsl.g:1931:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalServiceDsl.g:1932:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_50);
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

            // InternalServiceDsl.g:1950:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==34) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalServiceDsl.g:1951:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,34,FOLLOW_9); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalServiceDsl.g:1955:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalServiceDsl.g:1956:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalServiceDsl.g:1956:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalServiceDsl.g:1957:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalServiceDsl.g:1979:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalServiceDsl.g:1979:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalServiceDsl.g:1980:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalServiceDsl.g:1986:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:1992:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:1993:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:1993:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:1994:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:1994:3: ( (otherlv_0= RULE_ID ) )
            // InternalServiceDsl.g:1995:4: (otherlv_0= RULE_ID )
            {
            // InternalServiceDsl.g:1995:4: (otherlv_0= RULE_ID )
            // InternalServiceDsl.g:1996:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalServiceDsl.g:2011:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:2012:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:2012:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:2013:5: ruleQualifiedName
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
    // InternalServiceDsl.g:2031:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalServiceDsl.g:2031:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalServiceDsl.g:2032:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalServiceDsl.g:2038:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:2044:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalServiceDsl.g:2045:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalServiceDsl.g:2045:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalServiceDsl.g:2046:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_42); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalServiceDsl.g:2050:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalServiceDsl.g:2051:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalServiceDsl.g:2051:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalServiceDsl.g:2052:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
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

            otherlv_2=(Token)match(input,19,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalServiceDsl.g:2073:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalServiceDsl.g:2074:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalServiceDsl.g:2074:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalServiceDsl.g:2075:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolSpecificationAccess().getProtocolImportedProtocolAndDataFormatParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_30);
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

            otherlv_4=(Token)match(input,20,FOLLOW_2); 

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
    // InternalServiceDsl.g:2100:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalServiceDsl.g:2100:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalServiceDsl.g:2101:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalServiceDsl.g:2107:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:2113:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? ) )
            // InternalServiceDsl.g:2114:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? )
            {
            // InternalServiceDsl.g:2114:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? )
            // InternalServiceDsl.g:2115:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )?
            {
            // InternalServiceDsl.g:2115:3: ( (otherlv_0= RULE_ID ) )
            // InternalServiceDsl.g:2116:4: (otherlv_0= RULE_ID )
            {
            // InternalServiceDsl.g:2116:4: (otherlv_0= RULE_ID )
            // InternalServiceDsl.g:2117:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalServiceDsl.g:2132:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:2133:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:2133:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:2134:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalServiceDsl.g:2148:3: (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==19) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalServiceDsl.g:2149:4: otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalServiceDsl.g:2153:4: ( (otherlv_4= RULE_STRING ) )
                    // InternalServiceDsl.g:2154:5: (otherlv_4= RULE_STRING )
                    {
                    // InternalServiceDsl.g:2154:5: (otherlv_4= RULE_STRING )
                    // InternalServiceDsl.g:2155:6: otherlv_4= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_30); 

                    						newLeafNode(otherlv_4, grammarAccess.getImportedProtocolAndDataFormatAccess().getDataFormatDataFormatCrossReference_3_1_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getImportedProtocolAndDataFormatAccess().getRightParenthesisKeyword_3_2());
                    			

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
    // InternalServiceDsl.g:2175:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalServiceDsl.g:2175:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalServiceDsl.g:2176:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalServiceDsl.g:2182:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalServiceDsl.g:2188:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalServiceDsl.g:2189:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalServiceDsl.g:2189:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalServiceDsl.g:2190:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalServiceDsl.g:2190:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalServiceDsl.g:2191:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalServiceDsl.g:2191:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalServiceDsl.g:2192:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalServiceDsl.g:2209:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==28) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalServiceDsl.g:2210:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_9); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalServiceDsl.g:2214:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalServiceDsl.g:2215:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalServiceDsl.g:2215:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalServiceDsl.g:2216:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
            	    break loop64;
                }
            } while (true);

            otherlv_3=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalServiceDsl.g:2238:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalServiceDsl.g:2239:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalServiceDsl.g:2239:4: (lv_addresses_4_0= RULE_STRING )
            // InternalServiceDsl.g:2240:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"de.fhdo.lemma.ServiceDsl.STRING");
            				

            }


            }

            // InternalServiceDsl.g:2256:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==28) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalServiceDsl.g:2257:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,28,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalServiceDsl.g:2261:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalServiceDsl.g:2262:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalServiceDsl.g:2262:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalServiceDsl.g:2263:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getEndpointRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"addresses",
            	    							lv_addresses_6_0,
            	    							"de.fhdo.lemma.ServiceDsl.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_7=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:2288:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalServiceDsl.g:2288:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalServiceDsl.g:2289:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalServiceDsl.g:2295:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalServiceDsl.g:2301:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalServiceDsl.g:2302:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalServiceDsl.g:2302:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalServiceDsl.g:2303:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalServiceDsl.g:2307:3: ( (otherlv_1= RULE_ID ) )
            // InternalServiceDsl.g:2308:4: (otherlv_1= RULE_ID )
            {
            // InternalServiceDsl.g:2308:4: (otherlv_1= RULE_ID )
            // InternalServiceDsl.g:2309:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalServiceDsl.g:2324:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:2325:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:2325:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:2326:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalServiceDsl.g:2340:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==19) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalServiceDsl.g:2341:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_54); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalServiceDsl.g:2345:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_STRING||LA67_0==RULE_BOOLEAN||LA67_0==RULE_BIG_DECIMAL) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==RULE_ID) ) {
                        alt67=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalServiceDsl.g:2346:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalServiceDsl.g:2346:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalServiceDsl.g:2347:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalServiceDsl.g:2347:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalServiceDsl.g:2348:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_30);
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
                            // InternalServiceDsl.g:2366:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalServiceDsl.g:2366:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalServiceDsl.g:2367:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalServiceDsl.g:2367:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalServiceDsl.g:2368:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalServiceDsl.g:2368:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalServiceDsl.g:2369:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_26);
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

                            // InternalServiceDsl.g:2386:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop66:
                            do {
                                int alt66=2;
                                int LA66_0 = input.LA(1);

                                if ( (LA66_0==28) ) {
                                    alt66=1;
                                }


                                switch (alt66) {
                            	case 1 :
                            	    // InternalServiceDsl.g:2387:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,28,FOLLOW_54); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalServiceDsl.g:2391:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalServiceDsl.g:2392:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalServiceDsl.g:2392:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalServiceDsl.g:2393:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_26);
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
                            	    break loop66;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_2); 

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
    // InternalServiceDsl.g:2422:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalServiceDsl.g:2422:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalServiceDsl.g:2423:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalServiceDsl.g:2429:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) ;
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
            // InternalServiceDsl.g:2435:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) )
            // InternalServiceDsl.g:2436:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            {
            // InternalServiceDsl.g:2436:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==34) ) {
                    alt69=1;
                }
                else if ( (LA69_1==19) ) {
                    alt69=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalServiceDsl.g:2437:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    {
                    // InternalServiceDsl.g:2437:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    // InternalServiceDsl.g:2438:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
                    {
                    // InternalServiceDsl.g:2438:4: ( (otherlv_0= RULE_ID ) )
                    // InternalServiceDsl.g:2439:5: (otherlv_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:2439:5: (otherlv_0= RULE_ID )
                    // InternalServiceDsl.g:2440:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,34,FOLLOW_55); 

                    				newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalServiceDsl.g:2455:4: ( (lv_value_2_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:2456:5: (lv_value_2_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:2456:5: (lv_value_2_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:2457:6: lv_value_2_0= rulePrimitiveValue
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
                    // InternalServiceDsl.g:2476:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    {
                    // InternalServiceDsl.g:2476:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    // InternalServiceDsl.g:2477:4: ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')'
                    {
                    // InternalServiceDsl.g:2477:4: ( (otherlv_3= RULE_ID ) )
                    // InternalServiceDsl.g:2478:5: (otherlv_3= RULE_ID )
                    {
                    // InternalServiceDsl.g:2478:5: (otherlv_3= RULE_ID )
                    // InternalServiceDsl.g:2479:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_3, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,19,FOLLOW_55); 

                    				newLeafNode(otherlv_4, grammarAccess.getPropertyValueAssignmentAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalServiceDsl.g:2494:4: ( (lv_value_5_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:2495:5: (lv_value_5_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:2495:5: (lv_value_5_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:2496:6: lv_value_5_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getPropertyValueAssignmentAccess().getValuePrimitiveValueParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_30);
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

                    otherlv_6=(Token)match(input,20,FOLLOW_2); 

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
    // InternalServiceDsl.g:2522:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalServiceDsl.g:2522:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalServiceDsl.g:2523:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalServiceDsl.g:2529:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:2535:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalServiceDsl.g:2536:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalServiceDsl.g:2536:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalServiceDsl.g:2537:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,46,FOLLOW_9); 

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
    // InternalServiceDsl.g:2563:1: entryRuleAnything returns [String current=null] : iv_ruleAnything= ruleAnything EOF ;
    public final String entryRuleAnything() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnything = null;


        try {
            // InternalServiceDsl.g:2563:48: (iv_ruleAnything= ruleAnything EOF )
            // InternalServiceDsl.g:2564:2: iv_ruleAnything= ruleAnything EOF
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
    // InternalServiceDsl.g:2570:1: ruleAnything returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+ ;
    public final AntlrDatatypeRuleToken ruleAnything() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_BOOLEAN_117=null;
        Token this_NUMBER_WITH_TRAILING_PERIOD_118=null;
        Token this_BIG_DECIMAL_119=null;
        Token this_ID_120=null;
        Token this_STRING_121=null;
        Token this_ANY_OTHER_122=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:2576:2: ( (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+ )
            // InternalServiceDsl.g:2577:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+
            {
            // InternalServiceDsl.g:2577:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+
            int cnt70=0;
            loop70:
            do {
                int alt70=123;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    alt70=1;
                    }
                    break;
                case 29:
                    {
                    alt70=2;
                    }
                    break;
                case 47:
                    {
                    alt70=3;
                    }
                    break;
                case 48:
                    {
                    alt70=4;
                    }
                    break;
                case 28:
                    {
                    alt70=5;
                    }
                    break;
                case 19:
                    {
                    alt70=6;
                    }
                    break;
                case 20:
                    {
                    alt70=7;
                    }
                    break;
                case 35:
                    {
                    alt70=8;
                    }
                    break;
                case 46:
                    {
                    alt70=9;
                    }
                    break;
                case 49:
                    {
                    alt70=10;
                    }
                    break;
                case 50:
                    {
                    alt70=11;
                    }
                    break;
                case 51:
                    {
                    alt70=12;
                    }
                    break;
                case 44:
                    {
                    alt70=13;
                    }
                    break;
                case 45:
                    {
                    alt70=14;
                    }
                    break;
                case 17:
                    {
                    alt70=15;
                    }
                    break;
                case 34:
                    {
                    alt70=16;
                    }
                    break;
                case 41:
                    {
                    alt70=17;
                    }
                    break;
                case 32:
                    {
                    alt70=18;
                    }
                    break;
                case 52:
                    {
                    alt70=19;
                    }
                    break;
                case 53:
                    {
                    alt70=20;
                    }
                    break;
                case 54:
                    {
                    alt70=21;
                    }
                    break;
                case 55:
                    {
                    alt70=22;
                    }
                    break;
                case 56:
                    {
                    alt70=23;
                    }
                    break;
                case 57:
                    {
                    alt70=24;
                    }
                    break;
                case 58:
                    {
                    alt70=25;
                    }
                    break;
                case 59:
                    {
                    alt70=26;
                    }
                    break;
                case 60:
                    {
                    alt70=27;
                    }
                    break;
                case 61:
                    {
                    alt70=28;
                    }
                    break;
                case 14:
                    {
                    alt70=29;
                    }
                    break;
                case 15:
                    {
                    alt70=30;
                    }
                    break;
                case 16:
                    {
                    alt70=31;
                    }
                    break;
                case 62:
                    {
                    alt70=32;
                    }
                    break;
                case 63:
                    {
                    alt70=33;
                    }
                    break;
                case 64:
                    {
                    alt70=34;
                    }
                    break;
                case 65:
                    {
                    alt70=35;
                    }
                    break;
                case 66:
                    {
                    alt70=36;
                    }
                    break;
                case 67:
                    {
                    alt70=37;
                    }
                    break;
                case 68:
                    {
                    alt70=38;
                    }
                    break;
                case 69:
                    {
                    alt70=39;
                    }
                    break;
                case 70:
                    {
                    alt70=40;
                    }
                    break;
                case 71:
                    {
                    alt70=41;
                    }
                    break;
                case 72:
                    {
                    alt70=42;
                    }
                    break;
                case 73:
                    {
                    alt70=43;
                    }
                    break;
                case 74:
                    {
                    alt70=44;
                    }
                    break;
                case 75:
                    {
                    alt70=45;
                    }
                    break;
                case 76:
                    {
                    alt70=46;
                    }
                    break;
                case 77:
                    {
                    alt70=47;
                    }
                    break;
                case 78:
                    {
                    alt70=48;
                    }
                    break;
                case 79:
                    {
                    alt70=49;
                    }
                    break;
                case 80:
                    {
                    alt70=50;
                    }
                    break;
                case 81:
                    {
                    alt70=51;
                    }
                    break;
                case 82:
                    {
                    alt70=52;
                    }
                    break;
                case 83:
                    {
                    alt70=53;
                    }
                    break;
                case 84:
                    {
                    alt70=54;
                    }
                    break;
                case 85:
                    {
                    alt70=55;
                    }
                    break;
                case 27:
                    {
                    alt70=56;
                    }
                    break;
                case 30:
                    {
                    alt70=57;
                    }
                    break;
                case 31:
                    {
                    alt70=58;
                    }
                    break;
                case 86:
                    {
                    alt70=59;
                    }
                    break;
                case 87:
                    {
                    alt70=60;
                    }
                    break;
                case 88:
                    {
                    alt70=61;
                    }
                    break;
                case 89:
                    {
                    alt70=62;
                    }
                    break;
                case 90:
                    {
                    alt70=63;
                    }
                    break;
                case 91:
                    {
                    alt70=64;
                    }
                    break;
                case 92:
                    {
                    alt70=65;
                    }
                    break;
                case 93:
                    {
                    alt70=66;
                    }
                    break;
                case 94:
                    {
                    alt70=67;
                    }
                    break;
                case 95:
                    {
                    alt70=68;
                    }
                    break;
                case 24:
                    {
                    alt70=69;
                    }
                    break;
                case 97:
                    {
                    alt70=70;
                    }
                    break;
                case 98:
                    {
                    alt70=71;
                    }
                    break;
                case 99:
                    {
                    alt70=72;
                    }
                    break;
                case 100:
                    {
                    alt70=73;
                    }
                    break;
                case 101:
                    {
                    alt70=74;
                    }
                    break;
                case 102:
                    {
                    alt70=75;
                    }
                    break;
                case 103:
                    {
                    alt70=76;
                    }
                    break;
                case 104:
                    {
                    alt70=77;
                    }
                    break;
                case 105:
                    {
                    alt70=78;
                    }
                    break;
                case 106:
                    {
                    alt70=79;
                    }
                    break;
                case 107:
                    {
                    alt70=80;
                    }
                    break;
                case 108:
                    {
                    alt70=81;
                    }
                    break;
                case 109:
                    {
                    alt70=82;
                    }
                    break;
                case 110:
                    {
                    alt70=83;
                    }
                    break;
                case 111:
                    {
                    alt70=84;
                    }
                    break;
                case 112:
                    {
                    alt70=85;
                    }
                    break;
                case 113:
                    {
                    alt70=86;
                    }
                    break;
                case 114:
                    {
                    alt70=87;
                    }
                    break;
                case 115:
                    {
                    alt70=88;
                    }
                    break;
                case 116:
                    {
                    alt70=89;
                    }
                    break;
                case 117:
                    {
                    alt70=90;
                    }
                    break;
                case 118:
                    {
                    alt70=91;
                    }
                    break;
                case 119:
                    {
                    alt70=92;
                    }
                    break;
                case 120:
                    {
                    alt70=93;
                    }
                    break;
                case 121:
                    {
                    alt70=94;
                    }
                    break;
                case 122:
                    {
                    alt70=95;
                    }
                    break;
                case 123:
                    {
                    alt70=96;
                    }
                    break;
                case 124:
                    {
                    alt70=97;
                    }
                    break;
                case 125:
                    {
                    alt70=98;
                    }
                    break;
                case 126:
                    {
                    alt70=99;
                    }
                    break;
                case 127:
                    {
                    alt70=100;
                    }
                    break;
                case 128:
                    {
                    alt70=101;
                    }
                    break;
                case 129:
                    {
                    alt70=102;
                    }
                    break;
                case 130:
                    {
                    alt70=103;
                    }
                    break;
                case 131:
                    {
                    alt70=104;
                    }
                    break;
                case 132:
                    {
                    alt70=105;
                    }
                    break;
                case 18:
                    {
                    alt70=106;
                    }
                    break;
                case 23:
                    {
                    alt70=107;
                    }
                    break;
                case 26:
                    {
                    alt70=108;
                    }
                    break;
                case 33:
                    {
                    alt70=109;
                    }
                    break;
                case 36:
                    {
                    alt70=110;
                    }
                    break;
                case 37:
                    {
                    alt70=111;
                    }
                    break;
                case 133:
                    {
                    alt70=112;
                    }
                    break;
                case 42:
                    {
                    alt70=113;
                    }
                    break;
                case 43:
                    {
                    alt70=114;
                    }
                    break;
                case 134:
                    {
                    alt70=115;
                    }
                    break;
                case 135:
                    {
                    alt70=116;
                    }
                    break;
                case RULE_BOOLEAN:
                    {
                    alt70=117;
                    }
                    break;
                case RULE_NUMBER_WITH_TRAILING_PERIOD:
                    {
                    alt70=118;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt70=119;
                    }
                    break;
                case RULE_ID:
                    {
                    alt70=120;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt70=121;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt70=122;
                    }
                    break;

                }

                switch (alt70) {
            	case 1 :
            	    // InternalServiceDsl.g:2578:3: kw= '{'
            	    {
            	    kw=(Token)match(input,25,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftCurlyBracketKeyword_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalServiceDsl.g:2584:3: kw= '}'
            	    {
            	    kw=(Token)match(input,29,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightCurlyBracketKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalServiceDsl.g:2590:3: kw= '<'
            	    {
            	    kw=(Token)match(input,47,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignKeyword_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalServiceDsl.g:2596:3: kw= '>'
            	    {
            	    kw=(Token)match(input,48,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getGreaterThanSignKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalServiceDsl.g:2602:3: kw= ','
            	    {
            	    kw=(Token)match(input,28,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommaKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalServiceDsl.g:2608:3: kw= '('
            	    {
            	    kw=(Token)match(input,19,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftParenthesisKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalServiceDsl.g:2614:3: kw= ')'
            	    {
            	    kw=(Token)match(input,20,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightParenthesisKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalServiceDsl.g:2620:3: kw= '::'
            	    {
            	    kw=(Token)match(input,35,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonColonKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalServiceDsl.g:2626:3: kw= '.'
            	    {
            	    kw=(Token)match(input,46,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFullStopKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalServiceDsl.g:2632:3: kw= '-'
            	    {
            	    kw=(Token)match(input,49,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalServiceDsl.g:2638:3: kw= '--'
            	    {
            	    kw=(Token)match(input,50,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusHyphenMinusKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalServiceDsl.g:2644:3: kw= '/'
            	    {
            	    kw=(Token)match(input,51,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSolidusKeyword_11());
            	    		

            	    }
            	    break;
            	case 13 :
            	    // InternalServiceDsl.g:2650:3: kw= '?'
            	    {
            	    kw=(Token)match(input,44,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getQuestionMarkKeyword_12());
            	    		

            	    }
            	    break;
            	case 14 :
            	    // InternalServiceDsl.g:2656:3: kw= ':'
            	    {
            	    kw=(Token)match(input,45,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonKeyword_13());
            	    		

            	    }
            	    break;
            	case 15 :
            	    // InternalServiceDsl.g:2662:3: kw= '@'
            	    {
            	    kw=(Token)match(input,17,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommercialAtKeyword_14());
            	    		

            	    }
            	    break;
            	case 16 :
            	    // InternalServiceDsl.g:2668:3: kw= '='
            	    {
            	    kw=(Token)match(input,34,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEqualsSignKeyword_15());
            	    		

            	    }
            	    break;
            	case 17 :
            	    // InternalServiceDsl.g:2674:3: kw= ';'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSemicolonKeyword_16());
            	    		

            	    }
            	    break;
            	case 18 :
            	    // InternalServiceDsl.g:2680:3: kw= 'technology'
            	    {
            	    kw=(Token)match(input,32,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologyKeyword_17());
            	    		

            	    }
            	    break;
            	case 19 :
            	    // InternalServiceDsl.g:2686:3: kw= 'types'
            	    {
            	    kw=(Token)match(input,52,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypesKeyword_18());
            	    		

            	    }
            	    break;
            	case 20 :
            	    // InternalServiceDsl.g:2692:3: kw= 'compatibility'
            	    {
            	    kw=(Token)match(input,53,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCompatibilityKeyword_19());
            	    		

            	    }
            	    break;
            	case 21 :
            	    // InternalServiceDsl.g:2698:3: kw= 'matrix'
            	    {
            	    kw=(Token)match(input,54,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMatrixKeyword_20());
            	    		

            	    }
            	    break;
            	case 22 :
            	    // InternalServiceDsl.g:2704:3: kw= 'protocols'
            	    {
            	    kw=(Token)match(input,55,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolsKeyword_21());
            	    		

            	    }
            	    break;
            	case 23 :
            	    // InternalServiceDsl.g:2710:3: kw= 'service'
            	    {
            	    kw=(Token)match(input,56,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getServiceKeyword_22());
            	    		

            	    }
            	    break;
            	case 24 :
            	    // InternalServiceDsl.g:2716:3: kw= 'aspects'
            	    {
            	    kw=(Token)match(input,57,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectsKeyword_23());
            	    		

            	    }
            	    break;
            	case 25 :
            	    // InternalServiceDsl.g:2722:3: kw= 'deployment'
            	    {
            	    kw=(Token)match(input,58,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDeploymentKeyword_24());
            	    		

            	    }
            	    break;
            	case 26 :
            	    // InternalServiceDsl.g:2728:3: kw= 'technologies'
            	    {
            	    kw=(Token)match(input,59,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologiesKeyword_25());
            	    		

            	    }
            	    break;
            	case 27 :
            	    // InternalServiceDsl.g:2734:3: kw= 'infrastructure'
            	    {
            	    kw=(Token)match(input,60,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureKeyword_26());
            	    		

            	    }
            	    break;
            	case 28 :
            	    // InternalServiceDsl.g:2740:3: kw= 'operation'
            	    {
            	    kw=(Token)match(input,61,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationKeyword_27());
            	    		

            	    }
            	    break;
            	case 29 :
            	    // InternalServiceDsl.g:2746:3: kw= 'import'
            	    {
            	    kw=(Token)match(input,14,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImportKeyword_28());
            	    		

            	    }
            	    break;
            	case 30 :
            	    // InternalServiceDsl.g:2752:3: kw= 'from'
            	    {
            	    kw=(Token)match(input,15,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFromKeyword_29());
            	    		

            	    }
            	    break;
            	case 31 :
            	    // InternalServiceDsl.g:2758:3: kw= 'as'
            	    {
            	    kw=(Token)match(input,16,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsKeyword_30());
            	    		

            	    }
            	    break;
            	case 32 :
            	    // InternalServiceDsl.g:2764:3: kw= 'data'
            	    {
            	    kw=(Token)match(input,62,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDataKeyword_31());
            	    		

            	    }
            	    break;
            	case 33 :
            	    // InternalServiceDsl.g:2770:3: kw= 'formats'
            	    {
            	    kw=(Token)match(input,63,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatsKeyword_32());
            	    		

            	    }
            	    break;
            	case 34 :
            	    // InternalServiceDsl.g:2776:3: kw= 'default'
            	    {
            	    kw=(Token)match(input,64,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDefaultKeyword_33());
            	    		

            	    }
            	    break;
            	case 35 :
            	    // InternalServiceDsl.g:2782:3: kw= 'with'
            	    {
            	    kw=(Token)match(input,65,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getWithKeyword_34());
            	    		

            	    }
            	    break;
            	case 36 :
            	    // InternalServiceDsl.g:2788:3: kw= 'format'
            	    {
            	    kw=(Token)match(input,66,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatKeyword_35());
            	    		

            	    }
            	    break;
            	case 37 :
            	    // InternalServiceDsl.g:2794:3: kw= 'in'
            	    {
            	    kw=(Token)match(input,67,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInKeyword_36());
            	    		

            	    }
            	    break;
            	case 38 :
            	    // InternalServiceDsl.g:2800:3: kw= 'out'
            	    {
            	    kw=(Token)match(input,68,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOutKeyword_37());
            	    		

            	    }
            	    break;
            	case 39 :
            	    // InternalServiceDsl.g:2806:3: kw= 'inout'
            	    {
            	    kw=(Token)match(input,69,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInoutKeyword_38());
            	    		

            	    }
            	    break;
            	case 40 :
            	    // InternalServiceDsl.g:2812:3: kw= 'sync'
            	    {
            	    kw=(Token)match(input,70,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSyncKeyword_39());
            	    		

            	    }
            	    break;
            	case 41 :
            	    // InternalServiceDsl.g:2818:3: kw= 'async'
            	    {
            	    kw=(Token)match(input,71,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsyncKeyword_40());
            	    		

            	    }
            	    break;
            	case 42 :
            	    // InternalServiceDsl.g:2824:3: kw= 'primitive'
            	    {
            	    kw=(Token)match(input,72,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPrimitiveKeyword_41());
            	    		

            	    }
            	    break;
            	case 43 :
            	    // InternalServiceDsl.g:2830:3: kw= 'type'
            	    {
            	    kw=(Token)match(input,73,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypeKeyword_42());
            	    		

            	    }
            	    break;
            	case 44 :
            	    // InternalServiceDsl.g:2836:3: kw= 'based'
            	    {
            	    kw=(Token)match(input,74,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBasedKeyword_43());
            	    		

            	    }
            	    break;
            	case 45 :
            	    // InternalServiceDsl.g:2842:3: kw= 'on'
            	    {
            	    kw=(Token)match(input,75,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOnKeyword_44());
            	    		

            	    }
            	    break;
            	case 46 :
            	    // InternalServiceDsl.g:2848:3: kw= 'collection'
            	    {
            	    kw=(Token)match(input,76,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCollectionKeyword_45());
            	    		

            	    }
            	    break;
            	case 47 :
            	    // InternalServiceDsl.g:2854:3: kw= 'list'
            	    {
            	    kw=(Token)match(input,77,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getListKeyword_46());
            	    		

            	    }
            	    break;
            	case 48 :
            	    // InternalServiceDsl.g:2860:3: kw= 'structure'
            	    {
            	    kw=(Token)match(input,78,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStructureKeyword_47());
            	    		

            	    }
            	    break;
            	case 49 :
            	    // InternalServiceDsl.g:2866:3: kw= '->'
            	    {
            	    kw=(Token)match(input,79,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusGreaterThanSignKeyword_48());
            	    		

            	    }
            	    break;
            	case 50 :
            	    // InternalServiceDsl.g:2872:3: kw= '<-'
            	    {
            	    kw=(Token)match(input,80,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusKeyword_49());
            	    		

            	    }
            	    break;
            	case 51 :
            	    // InternalServiceDsl.g:2878:3: kw= '<->'
            	    {
            	    kw=(Token)match(input,81,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_50());
            	    		

            	    }
            	    break;
            	case 52 :
            	    // InternalServiceDsl.g:2884:3: kw= 'environments'
            	    {
            	    kw=(Token)match(input,82,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnvironmentsKeyword_51());
            	    		

            	    }
            	    break;
            	case 53 :
            	    // InternalServiceDsl.g:2890:3: kw= 'properties'
            	    {
            	    kw=(Token)match(input,83,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPropertiesKeyword_52());
            	    		

            	    }
            	    break;
            	case 54 :
            	    // InternalServiceDsl.g:2896:3: kw= 'mandatory'
            	    {
            	    kw=(Token)match(input,84,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMandatoryKeyword_53());
            	    		

            	    }
            	    break;
            	case 55 :
            	    // InternalServiceDsl.g:2902:3: kw= 'singleval'
            	    {
            	    kw=(Token)match(input,85,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSinglevalKeyword_54());
            	    		

            	    }
            	    break;
            	case 56 :
            	    // InternalServiceDsl.g:2908:3: kw= 'microservices'
            	    {
            	    kw=(Token)match(input,27,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroservicesKeyword_55());
            	    		

            	    }
            	    break;
            	case 57 :
            	    // InternalServiceDsl.g:2914:3: kw= 'interfaces'
            	    {
            	    kw=(Token)match(input,30,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfacesKeyword_56());
            	    		

            	    }
            	    break;
            	case 58 :
            	    // InternalServiceDsl.g:2920:3: kw= 'operations'
            	    {
            	    kw=(Token)match(input,31,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationsKeyword_57());
            	    		

            	    }
            	    break;
            	case 59 :
            	    // InternalServiceDsl.g:2926:3: kw= 'parameters'
            	    {
            	    kw=(Token)match(input,86,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParametersKeyword_58());
            	    		

            	    }
            	    break;
            	case 60 :
            	    // InternalServiceDsl.g:2932:3: kw= 'fields'
            	    {
            	    kw=(Token)match(input,87,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFieldsKeyword_59());
            	    		

            	    }
            	    break;
            	case 61 :
            	    // InternalServiceDsl.g:2938:3: kw= 'exchange_pattern'
            	    {
            	    kw=(Token)match(input,88,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExchange_patternKeyword_60());
            	    		

            	    }
            	    break;
            	case 62 :
            	    // InternalServiceDsl.g:2944:3: kw= 'communication_type'
            	    {
            	    kw=(Token)match(input,89,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommunication_typeKeyword_61());
            	    		

            	    }
            	    break;
            	case 63 :
            	    // InternalServiceDsl.g:2950:3: kw= 'protocol'
            	    {
            	    kw=(Token)match(input,90,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolKeyword_62());
            	    		

            	    }
            	    break;
            	case 64 :
            	    // InternalServiceDsl.g:2956:3: kw= 'data_format'
            	    {
            	    kw=(Token)match(input,91,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getData_formatKeyword_63());
            	    		

            	    }
            	    break;
            	case 65 :
            	    // InternalServiceDsl.g:2962:3: kw= 'aspect'
            	    {
            	    kw=(Token)match(input,92,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectKeyword_64());
            	    		

            	    }
            	    break;
            	case 66 :
            	    // InternalServiceDsl.g:2968:3: kw= 'for'
            	    {
            	    kw=(Token)match(input,93,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getForKeyword_65());
            	    		

            	    }
            	    break;
            	case 67 :
            	    // InternalServiceDsl.g:2974:3: kw= 'containers'
            	    {
            	    kw=(Token)match(input,94,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContainersKeyword_66());
            	    		

            	    }
            	    break;
            	case 68 :
            	    // InternalServiceDsl.g:2980:3: (kw= 'selector' kw= 'datatypes' )
            	    {
            	    // InternalServiceDsl.g:2980:3: (kw= 'selector' kw= 'datatypes' )
            	    // InternalServiceDsl.g:2981:4: kw= 'selector' kw= 'datatypes'
            	    {
            	    kw=(Token)match(input,95,FOLLOW_58); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getSelectorKeyword_67_0());
            	    			
            	    kw=(Token)match(input,96,FOLLOW_57); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getDatatypesKeyword_67_1());
            	    			

            	    }


            	    }
            	    break;
            	case 69 :
            	    // InternalServiceDsl.g:2993:3: kw= 'version'
            	    {
            	    kw=(Token)match(input,24,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getVersionKeyword_68());
            	    		

            	    }
            	    break;
            	case 70 :
            	    // InternalServiceDsl.g:2999:3: kw= 'context'
            	    {
            	    kw=(Token)match(input,97,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContextKeyword_69());
            	    		

            	    }
            	    break;
            	case 71 :
            	    // InternalServiceDsl.g:3005:3: kw= 'aggregate'
            	    {
            	    kw=(Token)match(input,98,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAggregateKeyword_70());
            	    		

            	    }
            	    break;
            	case 72 :
            	    // InternalServiceDsl.g:3011:3: kw= 'applicationService'
            	    {
            	    kw=(Token)match(input,99,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getApplicationServiceKeyword_71());
            	    		

            	    }
            	    break;
            	case 73 :
            	    // InternalServiceDsl.g:3017:3: kw= 'domainEvent'
            	    {
            	    kw=(Token)match(input,100,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainEventKeyword_72());
            	    		

            	    }
            	    break;
            	case 74 :
            	    // InternalServiceDsl.g:3023:3: kw= 'domainService'
            	    {
            	    kw=(Token)match(input,101,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainServiceKeyword_73());
            	    		

            	    }
            	    break;
            	case 75 :
            	    // InternalServiceDsl.g:3029:3: kw= 'entity'
            	    {
            	    kw=(Token)match(input,102,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEntityKeyword_74());
            	    		

            	    }
            	    break;
            	case 76 :
            	    // InternalServiceDsl.g:3035:3: kw= 'factory'
            	    {
            	    kw=(Token)match(input,103,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFactoryKeyword_75());
            	    		

            	    }
            	    break;
            	case 77 :
            	    // InternalServiceDsl.g:3041:3: kw= 'infrastructureService'
            	    {
            	    kw=(Token)match(input,104,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureServiceKeyword_76());
            	    		

            	    }
            	    break;
            	case 78 :
            	    // InternalServiceDsl.g:3047:3: kw= 'repository'
            	    {
            	    kw=(Token)match(input,105,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRepositoryKeyword_77());
            	    		

            	    }
            	    break;
            	case 79 :
            	    // InternalServiceDsl.g:3053:3: kw= 'specification'
            	    {
            	    kw=(Token)match(input,106,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSpecificationKeyword_78());
            	    		

            	    }
            	    break;
            	case 80 :
            	    // InternalServiceDsl.g:3059:3: kw= 'valueObject'
            	    {
            	    kw=(Token)match(input,107,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValueObjectKeyword_79());
            	    		

            	    }
            	    break;
            	case 81 :
            	    // InternalServiceDsl.g:3065:3: kw= 'extends'
            	    {
            	    kw=(Token)match(input,108,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExtendsKeyword_80());
            	    		

            	    }
            	    break;
            	case 82 :
            	    // InternalServiceDsl.g:3071:3: kw= 'identifier'
            	    {
            	    kw=(Token)match(input,109,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIdentifierKeyword_81());
            	    		

            	    }
            	    break;
            	case 83 :
            	    // InternalServiceDsl.g:3077:3: kw= 'neverEmpty'
            	    {
            	    kw=(Token)match(input,110,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNeverEmptyKeyword_82());
            	    		

            	    }
            	    break;
            	case 84 :
            	    // InternalServiceDsl.g:3083:3: kw= 'part'
            	    {
            	    kw=(Token)match(input,111,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPartKeyword_83());
            	    		

            	    }
            	    break;
            	case 85 :
            	    // InternalServiceDsl.g:3089:3: kw= 'hide'
            	    {
            	    kw=(Token)match(input,112,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHideKeyword_84());
            	    		

            	    }
            	    break;
            	case 86 :
            	    // InternalServiceDsl.g:3095:3: kw= 'immutable'
            	    {
            	    kw=(Token)match(input,113,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImmutableKeyword_85());
            	    		

            	    }
            	    break;
            	case 87 :
            	    // InternalServiceDsl.g:3101:3: kw= 'enum'
            	    {
            	    kw=(Token)match(input,114,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnumKeyword_86());
            	    		

            	    }
            	    break;
            	case 88 :
            	    // InternalServiceDsl.g:3107:3: kw= 'closure'
            	    {
            	    kw=(Token)match(input,115,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getClosureKeyword_87());
            	    		

            	    }
            	    break;
            	case 89 :
            	    // InternalServiceDsl.g:3113:3: kw= 'sideEffectFree'
            	    {
            	    kw=(Token)match(input,116,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSideEffectFreeKeyword_88());
            	    		

            	    }
            	    break;
            	case 90 :
            	    // InternalServiceDsl.g:3119:3: kw= 'validator'
            	    {
            	    kw=(Token)match(input,117,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValidatorKeyword_89());
            	    		

            	    }
            	    break;
            	case 91 :
            	    // InternalServiceDsl.g:3125:3: kw= 'function'
            	    {
            	    kw=(Token)match(input,118,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionKeyword_90());
            	    		

            	    }
            	    break;
            	case 92 :
            	    // InternalServiceDsl.g:3131:3: kw= 'procedure'
            	    {
            	    kw=(Token)match(input,119,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProcedureKeyword_91());
            	    		

            	    }
            	    break;
            	case 93 :
            	    // InternalServiceDsl.g:3137:3: kw= 'boolean'
            	    {
            	    kw=(Token)match(input,120,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBooleanKeyword_92());
            	    		

            	    }
            	    break;
            	case 94 :
            	    // InternalServiceDsl.g:3143:3: kw= 'byte'
            	    {
            	    kw=(Token)match(input,121,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getByteKeyword_93());
            	    		

            	    }
            	    break;
            	case 95 :
            	    // InternalServiceDsl.g:3149:3: kw= 'char'
            	    {
            	    kw=(Token)match(input,122,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCharKeyword_94());
            	    		

            	    }
            	    break;
            	case 96 :
            	    // InternalServiceDsl.g:3155:3: kw= 'date'
            	    {
            	    kw=(Token)match(input,123,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDateKeyword_95());
            	    		

            	    }
            	    break;
            	case 97 :
            	    // InternalServiceDsl.g:3161:3: kw= 'double'
            	    {
            	    kw=(Token)match(input,124,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDoubleKeyword_96());
            	    		

            	    }
            	    break;
            	case 98 :
            	    // InternalServiceDsl.g:3167:3: kw= 'float'
            	    {
            	    kw=(Token)match(input,125,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFloatKeyword_97());
            	    		

            	    }
            	    break;
            	case 99 :
            	    // InternalServiceDsl.g:3173:3: kw= 'int'
            	    {
            	    kw=(Token)match(input,126,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIntKeyword_98());
            	    		

            	    }
            	    break;
            	case 100 :
            	    // InternalServiceDsl.g:3179:3: kw= 'long'
            	    {
            	    kw=(Token)match(input,127,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLongKeyword_99());
            	    		

            	    }
            	    break;
            	case 101 :
            	    // InternalServiceDsl.g:3185:3: kw= 'short'
            	    {
            	    kw=(Token)match(input,128,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getShortKeyword_100());
            	    		

            	    }
            	    break;
            	case 102 :
            	    // InternalServiceDsl.g:3191:3: kw= 'string'
            	    {
            	    kw=(Token)match(input,129,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStringKeyword_101());
            	    		

            	    }
            	    break;
            	case 103 :
            	    // InternalServiceDsl.g:3197:3: kw= 'internal'
            	    {
            	    kw=(Token)match(input,130,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInternalKeyword_102());
            	    		

            	    }
            	    break;
            	case 104 :
            	    // InternalServiceDsl.g:3203:3: kw= 'architecture'
            	    {
            	    kw=(Token)match(input,131,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getArchitectureKeyword_103());
            	    		

            	    }
            	    break;
            	case 105 :
            	    // InternalServiceDsl.g:3209:3: kw= 'public'
            	    {
            	    kw=(Token)match(input,132,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPublicKeyword_104());
            	    		

            	    }
            	    break;
            	case 106 :
            	    // InternalServiceDsl.g:3215:3: kw= 'endpoints'
            	    {
            	    kw=(Token)match(input,18,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEndpointsKeyword_105());
            	    		

            	    }
            	    break;
            	case 107 :
            	    // InternalServiceDsl.g:3221:3: kw= 'microservice'
            	    {
            	    kw=(Token)match(input,23,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroserviceKeyword_106());
            	    		

            	    }
            	    break;
            	case 108 :
            	    // InternalServiceDsl.g:3227:3: kw= 'required'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRequiredKeyword_107());
            	    		

            	    }
            	    break;
            	case 109 :
            	    // InternalServiceDsl.g:3233:3: kw= 'typedef'
            	    {
            	    kw=(Token)match(input,33,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypedefKeyword_108());
            	    		

            	    }
            	    break;
            	case 110 :
            	    // InternalServiceDsl.g:3239:3: kw= 'noimpl'
            	    {
            	    kw=(Token)match(input,36,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNoimplKeyword_109());
            	    		

            	    }
            	    break;
            	case 111 :
            	    // InternalServiceDsl.g:3245:3: kw= 'interface'
            	    {
            	    kw=(Token)match(input,37,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfaceKeyword_110());
            	    		

            	    }
            	    break;
            	case 112 :
            	    // InternalServiceDsl.g:3251:3: kw= 'param'
            	    {
            	    kw=(Token)match(input,133,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParamKeyword_111());
            	    		

            	    }
            	    break;
            	case 113 :
            	    // InternalServiceDsl.g:3257:3: kw= 'refers'
            	    {
            	    kw=(Token)match(input,42,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRefersKeyword_112());
            	    		

            	    }
            	    break;
            	case 114 :
            	    // InternalServiceDsl.g:3263:3: kw= 'fault'
            	    {
            	    kw=(Token)match(input,43,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFaultKeyword_113());
            	    		

            	    }
            	    break;
            	case 115 :
            	    // InternalServiceDsl.g:3269:3: kw= 'functional'
            	    {
            	    kw=(Token)match(input,134,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionalKeyword_114());
            	    		

            	    }
            	    break;
            	case 116 :
            	    // InternalServiceDsl.g:3275:3: kw= 'utility'
            	    {
            	    kw=(Token)match(input,135,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getUtilityKeyword_115());
            	    		

            	    }
            	    break;
            	case 117 :
            	    // InternalServiceDsl.g:3281:3: this_BOOLEAN_117= RULE_BOOLEAN
            	    {
            	    this_BOOLEAN_117=(Token)match(input,RULE_BOOLEAN,FOLLOW_57); 

            	    			current.merge(this_BOOLEAN_117);
            	    		

            	    			newLeafNode(this_BOOLEAN_117, grammarAccess.getAnythingAccess().getBOOLEANTerminalRuleCall_116());
            	    		

            	    }
            	    break;
            	case 118 :
            	    // InternalServiceDsl.g:3289:3: this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD
            	    {
            	    this_NUMBER_WITH_TRAILING_PERIOD_118=(Token)match(input,RULE_NUMBER_WITH_TRAILING_PERIOD,FOLLOW_57); 

            	    			current.merge(this_NUMBER_WITH_TRAILING_PERIOD_118);
            	    		

            	    			newLeafNode(this_NUMBER_WITH_TRAILING_PERIOD_118, grammarAccess.getAnythingAccess().getNUMBER_WITH_TRAILING_PERIODTerminalRuleCall_117());
            	    		

            	    }
            	    break;
            	case 119 :
            	    // InternalServiceDsl.g:3297:3: this_BIG_DECIMAL_119= RULE_BIG_DECIMAL
            	    {
            	    this_BIG_DECIMAL_119=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_57); 

            	    			current.merge(this_BIG_DECIMAL_119);
            	    		

            	    			newLeafNode(this_BIG_DECIMAL_119, grammarAccess.getAnythingAccess().getBIG_DECIMALTerminalRuleCall_118());
            	    		

            	    }
            	    break;
            	case 120 :
            	    // InternalServiceDsl.g:3305:3: this_ID_120= RULE_ID
            	    {
            	    this_ID_120=(Token)match(input,RULE_ID,FOLLOW_57); 

            	    			current.merge(this_ID_120);
            	    		

            	    			newLeafNode(this_ID_120, grammarAccess.getAnythingAccess().getIDTerminalRuleCall_119());
            	    		

            	    }
            	    break;
            	case 121 :
            	    // InternalServiceDsl.g:3313:3: this_STRING_121= RULE_STRING
            	    {
            	    this_STRING_121=(Token)match(input,RULE_STRING,FOLLOW_57); 

            	    			current.merge(this_STRING_121);
            	    		

            	    			newLeafNode(this_STRING_121, grammarAccess.getAnythingAccess().getSTRINGTerminalRuleCall_120());
            	    		

            	    }
            	    break;
            	case 122 :
            	    // InternalServiceDsl.g:3321:3: this_ANY_OTHER_122= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_122=(Token)match(input,RULE_ANY_OTHER,FOLLOW_57); 

            	    			current.merge(this_ANY_OTHER_122);
            	    		

            	    			newLeafNode(this_ANY_OTHER_122, grammarAccess.getAnythingAccess().getANY_OTHERTerminalRuleCall_121());
            	    		

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


            }


            	leaveRule();

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
    // InternalServiceDsl.g:3332:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalServiceDsl.g:3332:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalServiceDsl.g:3333:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalServiceDsl.g:3339:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalServiceDsl.g:3345:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:3346:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:3346:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalServiceDsl.g:3347:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalServiceDsl.g:3359:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalServiceDsl.g:3360:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalServiceDsl.g:3360:4: (lv_importURI_3_0= RULE_STRING )
            // InternalServiceDsl.g:3361:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getTechnologyImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.ServiceDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalServiceDsl.g:3381:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:3382:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:3382:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:3383:5: lv_name_5_0= RULE_ID
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
    // InternalServiceDsl.g:3403:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalServiceDsl.g:3403:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalServiceDsl.g:3404:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalServiceDsl.g:3410:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) ;
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
            // InternalServiceDsl.g:3416:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // InternalServiceDsl.g:3417:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // InternalServiceDsl.g:3417:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            // InternalServiceDsl.g:3418:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // InternalServiceDsl.g:3418:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalServiceDsl.g:3419:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalServiceDsl.g:3419:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalServiceDsl.g:3420:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalServiceDsl.g:3437:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:3438:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:3438:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:3439:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_59); 

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

            otherlv_2=(Token)match(input,62,FOLLOW_60); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,63,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalServiceDsl.g:3463:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalServiceDsl.g:3464:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalServiceDsl.g:3464:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalServiceDsl.g:3465:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_61);
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

            // InternalServiceDsl.g:3482:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==28) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalServiceDsl.g:3483:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,28,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:3487:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalServiceDsl.g:3488:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalServiceDsl.g:3488:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalServiceDsl.g:3489:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_61);
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
            	    break loop71;
                }
            } while (true);

            // InternalServiceDsl.g:3507:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==64) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalServiceDsl.g:3508:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) )
                    {
                    // InternalServiceDsl.g:3508:4: ( (lv_default_7_0= 'default' ) )
                    // InternalServiceDsl.g:3509:5: (lv_default_7_0= 'default' )
                    {
                    // InternalServiceDsl.g:3509:5: (lv_default_7_0= 'default' )
                    // InternalServiceDsl.g:3510:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,64,FOLLOW_62); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", lv_default_7_0 != null, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,65,FOLLOW_63); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,66,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalServiceDsl.g:3530:4: ( (otherlv_10= RULE_STRING ) )
                    // InternalServiceDsl.g:3531:5: (otherlv_10= RULE_STRING )
                    {
                    // InternalServiceDsl.g:3531:5: (otherlv_10= RULE_STRING )
                    // InternalServiceDsl.g:3532:6: otherlv_10= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_STRING,FOLLOW_43); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:3552:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalServiceDsl.g:3552:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalServiceDsl.g:3553:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalServiceDsl.g:3559:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_STRING ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3565:2: ( ( (lv_formatName_0_0= RULE_STRING ) ) )
            // InternalServiceDsl.g:3566:2: ( (lv_formatName_0_0= RULE_STRING ) )
            {
            // InternalServiceDsl.g:3566:2: ( (lv_formatName_0_0= RULE_STRING ) )
            // InternalServiceDsl.g:3567:3: (lv_formatName_0_0= RULE_STRING )
            {
            // InternalServiceDsl.g:3567:3: (lv_formatName_0_0= RULE_STRING )
            // InternalServiceDsl.g:3568:4: lv_formatName_0_0= RULE_STRING
            {
            lv_formatName_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_formatName_0_0, grammarAccess.getDataFormatAccess().getFormatNameSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDataFormatRule());
            				}
            				setWithLastConsumed(
            					current,
            					"formatName",
            					lv_formatName_0_0,
            					"de.fhdo.lemma.ServiceDsl.STRING");
            			

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
    // InternalServiceDsl.g:3587:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalServiceDsl.g:3587:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalServiceDsl.g:3588:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalServiceDsl.g:3594:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalServiceDsl.g:3600:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalServiceDsl.g:3601:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalServiceDsl.g:3601:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalServiceDsl.g:3602:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalServiceDsl.g:3610:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalServiceDsl.g:3611:4: (lv_name_2_0= RULE_ID )
            {
            // InternalServiceDsl.g:3611:4: (lv_name_2_0= RULE_ID )
            // InternalServiceDsl.g:3612:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_65); 

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

            // InternalServiceDsl.g:3628:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==74) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalServiceDsl.g:3629:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,74,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,75,FOLLOW_67); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalServiceDsl.g:3637:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:3638:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:3638:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalServiceDsl.g:3639:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_61);
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

                    // InternalServiceDsl.g:3656:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==28) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalServiceDsl.g:3657:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,28,FOLLOW_67); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalServiceDsl.g:3661:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalServiceDsl.g:3662:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalServiceDsl.g:3662:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalServiceDsl.g:3663:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop73;
                        }
                    } while (true);

                    // InternalServiceDsl.g:3681:4: ( (lv_default_8_0= 'default' ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==64) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalServiceDsl.g:3682:5: (lv_default_8_0= 'default' )
                            {
                            // InternalServiceDsl.g:3682:5: (lv_default_8_0= 'default' )
                            // InternalServiceDsl.g:3683:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,64,FOLLOW_43); 

                            						newLeafNode(lv_default_8_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTechnologySpecificPrimitiveTypeRule());
                            						}
                            						setWithLastConsumed(current, "default", lv_default_8_0 != null, "default");
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:3704:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalServiceDsl.g:3704:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalServiceDsl.g:3705:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalServiceDsl.g:3711:1: ruleTechnologySpecificListType returns [EObject current=null] : ( (otherlv_0= 'collection' | otherlv_1= 'list' ) otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3717:2: ( ( (otherlv_0= 'collection' | otherlv_1= 'list' ) otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) )
            // InternalServiceDsl.g:3718:2: ( (otherlv_0= 'collection' | otherlv_1= 'list' ) otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            {
            // InternalServiceDsl.g:3718:2: ( (otherlv_0= 'collection' | otherlv_1= 'list' ) otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            // InternalServiceDsl.g:3719:3: (otherlv_0= 'collection' | otherlv_1= 'list' ) otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';'
            {
            // InternalServiceDsl.g:3719:3: (otherlv_0= 'collection' | otherlv_1= 'list' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==76) ) {
                alt76=1;
            }
            else if ( (LA76_0==77) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalServiceDsl.g:3720:4: otherlv_0= 'collection'
                    {
                    otherlv_0=(Token)match(input,76,FOLLOW_64); 

                    				newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getCollectionKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:3725:4: otherlv_1= 'list'
                    {
                    otherlv_1=(Token)match(input,77,FOLLOW_64); 

                    				newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalServiceDsl.g:3734:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalServiceDsl.g:3735:4: (lv_name_3_0= RULE_ID )
            {
            // InternalServiceDsl.g:3735:4: (lv_name_3_0= RULE_ID )
            // InternalServiceDsl.g:3736:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(lv_name_3_0, grammarAccess.getTechnologySpecificListTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificListTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificListTypeAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalServiceDsl.g:3760:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalServiceDsl.g:3760:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalServiceDsl.g:3761:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalServiceDsl.g:3767:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3773:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalServiceDsl.g:3774:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalServiceDsl.g:3774:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalServiceDsl.g:3775:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,73,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalServiceDsl.g:3783:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalServiceDsl.g:3784:4: (lv_name_2_0= RULE_ID )
            {
            // InternalServiceDsl.g:3784:4: (lv_name_2_0= RULE_ID )
            // InternalServiceDsl.g:3785:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_43); 

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

            otherlv_3=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:3809:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalServiceDsl.g:3809:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalServiceDsl.g:3810:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalServiceDsl.g:3816:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3822:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:3823:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:3823:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:3824:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:3824:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==35) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // InternalServiceDsl.g:3825:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalServiceDsl.g:3825:4: ( (otherlv_0= RULE_ID ) )
                    // InternalServiceDsl.g:3826:5: (otherlv_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:3826:5: (otherlv_0= RULE_ID )
                    // InternalServiceDsl.g:3827:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,35,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:3843:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:3844:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:3844:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:3845:5: ruleQualifiedName
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
    // InternalServiceDsl.g:3863:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalServiceDsl.g:3863:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalServiceDsl.g:3864:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalServiceDsl.g:3870:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalServiceDsl.g:3876:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalServiceDsl.g:3877:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalServiceDsl.g:3877:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalServiceDsl.g:3878:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalServiceDsl.g:3878:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalServiceDsl.g:3879:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalServiceDsl.g:3879:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalServiceDsl.g:3880:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalServiceDsl.g:3897:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==28) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalServiceDsl.g:3898:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_9); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalServiceDsl.g:3902:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalServiceDsl.g:3903:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalServiceDsl.g:3903:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalServiceDsl.g:3904:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_68);
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
            	    break loop78;
                }
            } while (true);

            // InternalServiceDsl.g:3922:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalServiceDsl.g:3923:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalServiceDsl.g:3923:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalServiceDsl.g:3924:5: lv_direction_3_0= ruleCompatibilityDirection
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalServiceDsl.g:3941:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalServiceDsl.g:3942:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalServiceDsl.g:3942:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalServiceDsl.g:3943:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_43);
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

            otherlv_5=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:3968:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalServiceDsl.g:3968:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalServiceDsl.g:3969:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalServiceDsl.g:3975:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalServiceDsl.g:3981:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalServiceDsl.g:3982:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalServiceDsl.g:3982:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalServiceDsl.g:3983:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalServiceDsl.g:3983:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalServiceDsl.g:3984:4: (lv_name_0_0= RULE_ID )
            {
            // InternalServiceDsl.g:3984:4: (lv_name_0_0= RULE_ID )
            // InternalServiceDsl.g:3985:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_1=(Token)match(input,25,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,61,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,82,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalServiceDsl.g:4017:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalServiceDsl.g:4018:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalServiceDsl.g:4018:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalServiceDsl.g:4019:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_53);
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

            // InternalServiceDsl.g:4036:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==28) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalServiceDsl.g:4037:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,28,FOLLOW_7); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalServiceDsl.g:4041:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalServiceDsl.g:4042:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalServiceDsl.g:4042:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalServiceDsl.g:4043:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_53);
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
            	    break loop79;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_71); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalServiceDsl.g:4065:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==56) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalServiceDsl.g:4066:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,56,FOLLOW_72); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,83,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,25,FOLLOW_67); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalServiceDsl.g:4078:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt80=0;
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( ((LA80_0>=120 && LA80_0<=129)||LA80_0==136) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4079:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:4079:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:4080:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_73);
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
                    	    if ( cnt80 >= 1 ) break loop80;
                                EarlyExitException eee =
                                    new EarlyExitException(80, input);
                                throw eee;
                        }
                        cnt80++;
                    } while (true);

                    otherlv_13=(Token)match(input,29,FOLLOW_74); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,29,FOLLOW_2); 

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
    // InternalServiceDsl.g:4110:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalServiceDsl.g:4110:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalServiceDsl.g:4111:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalServiceDsl.g:4117:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalServiceDsl.g:4123:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalServiceDsl.g:4124:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalServiceDsl.g:4124:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalServiceDsl.g:4125:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalServiceDsl.g:4125:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalServiceDsl.g:4126:4: (lv_name_0_0= RULE_ID )
            {
            // InternalServiceDsl.g:4126:4: (lv_name_0_0= RULE_ID )
            // InternalServiceDsl.g:4127:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_1=(Token)match(input,25,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,61,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,82,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalServiceDsl.g:4159:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalServiceDsl.g:4160:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalServiceDsl.g:4160:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalServiceDsl.g:4161:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_53);
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

            // InternalServiceDsl.g:4178:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==28) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalServiceDsl.g:4179:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,28,FOLLOW_7); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalServiceDsl.g:4183:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalServiceDsl.g:4184:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalServiceDsl.g:4184:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalServiceDsl.g:4185:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_53);
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
            	    break loop82;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_71); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalServiceDsl.g:4207:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==56) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalServiceDsl.g:4208:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,56,FOLLOW_72); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,83,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,25,FOLLOW_67); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalServiceDsl.g:4220:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt83=0;
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( ((LA83_0>=120 && LA83_0<=129)||LA83_0==136) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4221:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:4221:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:4222:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_73);
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
                    	    if ( cnt83 >= 1 ) break loop83;
                                EarlyExitException eee =
                                    new EarlyExitException(83, input);
                                throw eee;
                        }
                        cnt83++;
                    } while (true);

                    otherlv_13=(Token)match(input,29,FOLLOW_74); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,29,FOLLOW_2); 

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
    // InternalServiceDsl.g:4252:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalServiceDsl.g:4252:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalServiceDsl.g:4253:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalServiceDsl.g:4259:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:4265:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalServiceDsl.g:4266:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalServiceDsl.g:4266:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalServiceDsl.g:4267:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalServiceDsl.g:4267:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalServiceDsl.g:4268:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalServiceDsl.g:4268:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalServiceDsl.g:4269:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_75); 

            					newLeafNode(lv_environmentName_0_0, grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationEnvironmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"environmentName",
            						lv_environmentName_0_0,
            						"de.fhdo.lemma.ServiceDsl.STRING");
            				

            }


            }

            // InternalServiceDsl.g:4285:3: ( (lv_default_1_0= 'default' ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==64) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalServiceDsl.g:4286:4: (lv_default_1_0= 'default' )
                    {
                    // InternalServiceDsl.g:4286:4: (lv_default_1_0= 'default' )
                    // InternalServiceDsl.g:4287:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,64,FOLLOW_2); 

                    					newLeafNode(lv_default_1_0, grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationEnvironmentRule());
                    					}
                    					setWithLastConsumed(current, "default", lv_default_1_0 != null, "default");
                    				

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
    // InternalServiceDsl.g:4303:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalServiceDsl.g:4303:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalServiceDsl.g:4304:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalServiceDsl.g:4310:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalServiceDsl.g:4316:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalServiceDsl.g:4317:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalServiceDsl.g:4317:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalServiceDsl.g:4318:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalServiceDsl.g:4318:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalServiceDsl.g:4319:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalServiceDsl.g:4319:4: (lv_type_0_0= rulePrimitiveType )
            // InternalServiceDsl.g:4320:5: lv_type_0_0= rulePrimitiveType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalServiceDsl.g:4337:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:4338:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:4338:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:4339:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_76); 

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

            // InternalServiceDsl.g:4355:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==34) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalServiceDsl.g:4356:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:4360:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:4361:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:4361:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:4362:6: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_77);
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

            // InternalServiceDsl.g:4380:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==47) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalServiceDsl.g:4381:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_78); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalServiceDsl.g:4385:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalServiceDsl.g:4386:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalServiceDsl.g:4386:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalServiceDsl.g:4387:6: lv_features_5_0= rulePropertyFeature
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_79);
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

                    // InternalServiceDsl.g:4404:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==28) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4405:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,28,FOLLOW_78); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalServiceDsl.g:4409:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalServiceDsl.g:4410:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalServiceDsl.g:4410:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalServiceDsl.g:4411:7: lv_features_7_0= rulePropertyFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop87;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,48,FOLLOW_43); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificPropertyAccess().getGreaterThanSignKeyword_3_3());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:4442:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalServiceDsl.g:4442:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalServiceDsl.g:4443:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalServiceDsl.g:4449:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) ;
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
            // InternalServiceDsl.g:4455:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) )
            // InternalServiceDsl.g:4456:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            {
            // InternalServiceDsl.g:4456:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            int alt89=4;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt89=1;
                }
                break;
            case 89:
                {
                alt89=2;
                }
                break;
            case 90:
                {
                alt89=3;
                }
                break;
            case 91:
                {
                alt89=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalServiceDsl.g:4457:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalServiceDsl.g:4457:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalServiceDsl.g:4458:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalServiceDsl.g:4458:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalServiceDsl.g:4459:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalServiceDsl.g:4459:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalServiceDsl.g:4460:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,88,FOLLOW_28); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", lv_forExchangePattern_0_0 != null, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,34,FOLLOW_80); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalServiceDsl.g:4476:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalServiceDsl.g:4477:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalServiceDsl.g:4477:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalServiceDsl.g:4478:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalServiceDsl.g:4497:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalServiceDsl.g:4497:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalServiceDsl.g:4498:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalServiceDsl.g:4498:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalServiceDsl.g:4499:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalServiceDsl.g:4499:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalServiceDsl.g:4500:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,89,FOLLOW_28); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", lv_forCommunicationType_3_0 != null, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,34,FOLLOW_42); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalServiceDsl.g:4516:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalServiceDsl.g:4517:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalServiceDsl.g:4517:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalServiceDsl.g:4518:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalServiceDsl.g:4537:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalServiceDsl.g:4537:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalServiceDsl.g:4538:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalServiceDsl.g:4538:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalServiceDsl.g:4539:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalServiceDsl.g:4539:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalServiceDsl.g:4540:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,90,FOLLOW_28); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", lv_forProtocol_6_0 != null, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,34,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalServiceDsl.g:4556:4: ( (otherlv_8= RULE_ID ) )
                    // InternalServiceDsl.g:4557:5: (otherlv_8= RULE_ID )
                    {
                    // InternalServiceDsl.g:4557:5: (otherlv_8= RULE_ID )
                    // InternalServiceDsl.g:4558:6: otherlv_8= RULE_ID
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
                    // InternalServiceDsl.g:4571:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    {
                    // InternalServiceDsl.g:4571:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    // InternalServiceDsl.g:4572:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) )
                    {
                    // InternalServiceDsl.g:4572:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalServiceDsl.g:4573:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalServiceDsl.g:4573:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalServiceDsl.g:4574:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,91,FOLLOW_28); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", lv_forDataFormat_9_0 != null, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,34,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalServiceDsl.g:4590:4: ( (otherlv_11= RULE_STRING ) )
                    // InternalServiceDsl.g:4591:5: (otherlv_11= RULE_STRING )
                    {
                    // InternalServiceDsl.g:4591:5: (otherlv_11= RULE_STRING )
                    // InternalServiceDsl.g:4592:6: otherlv_11= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_STRING,FOLLOW_2); 

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
    // InternalServiceDsl.g:4608:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalServiceDsl.g:4608:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalServiceDsl.g:4609:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalServiceDsl.g:4615:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalServiceDsl.g:4621:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalServiceDsl.g:4622:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalServiceDsl.g:4622:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalServiceDsl.g:4623:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_81); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalServiceDsl.g:4631:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalServiceDsl.g:4632:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalServiceDsl.g:4632:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalServiceDsl.g:4633:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
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

            // InternalServiceDsl.g:4650:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==28) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalServiceDsl.g:4651:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,28,FOLLOW_81); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalServiceDsl.g:4655:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalServiceDsl.g:4656:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalServiceDsl.g:4656:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalServiceDsl.g:4657:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
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
            	    break loop90;
                }
            } while (true);

            otherlv_5=(Token)match(input,20,FOLLOW_43); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:4687:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalServiceDsl.g:4687:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalServiceDsl.g:4688:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalServiceDsl.g:4694:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalServiceDsl.g:4700:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalServiceDsl.g:4701:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalServiceDsl.g:4701:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalServiceDsl.g:4702:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalServiceDsl.g:4706:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:4707:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:4707:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:4708:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_82); 

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

            // InternalServiceDsl.g:4724:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==47) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalServiceDsl.g:4725:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_83); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:4729:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalServiceDsl.g:4730:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalServiceDsl.g:4730:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalServiceDsl.g:4731:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_79);
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

                    // InternalServiceDsl.g:4748:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==28) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4749:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_83); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:4753:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalServiceDsl.g:4754:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalServiceDsl.g:4754:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalServiceDsl.g:4755:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop91;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,48,FOLLOW_84); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,93,FOLLOW_85); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceAspectAccess().getForKeyword_3());
            		
            // InternalServiceDsl.g:4782:3: ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) )
            // InternalServiceDsl.g:4783:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            {
            // InternalServiceDsl.g:4783:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            // InternalServiceDsl.g:4784:5: lv_joinPoints_8_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_86);
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

            // InternalServiceDsl.g:4801:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==28) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalServiceDsl.g:4802:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,28,FOLLOW_85); 

            	    				newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:4806:4: ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    // InternalServiceDsl.g:4807:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    {
            	    // InternalServiceDsl.g:4807:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    // InternalServiceDsl.g:4808:6: lv_joinPoints_10_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_86);
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
            	    break loop93;
                }
            } while (true);

            // InternalServiceDsl.g:4826:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==25) ) {
                alt96=1;
            }
            else if ( (LA96_0==41) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalServiceDsl.g:4827:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalServiceDsl.g:4827:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalServiceDsl.g:4828:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,25,FOLLOW_87); 

                    					newLeafNode(otherlv_11, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalServiceDsl.g:4832:5: ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==95) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4833:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalServiceDsl.g:4833:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    // InternalServiceDsl.g:4834:7: lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_87);
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
                    	    break loop94;
                        }
                    } while (true);

                    // InternalServiceDsl.g:4851:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( ((LA95_0>=120 && LA95_0<=129)||LA95_0==136) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4852:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:4852:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:4853:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_73);
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
                    	    break loop95;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,29,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:4876:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:4885:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalServiceDsl.g:4885:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalServiceDsl.g:4886:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalServiceDsl.g:4892:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:4898:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalServiceDsl.g:4899:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:4899:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalServiceDsl.g:4900:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalServiceDsl.g:4900:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalServiceDsl.g:4901:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalServiceDsl.g:4901:4: (lv_forTechnology_0_0= 'technology' )
            // InternalServiceDsl.g:4902:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,32,FOLLOW_28); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", lv_forTechnology_0_0 != null, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalServiceDsl.g:4918:3: ( (otherlv_2= RULE_ID ) )
            // InternalServiceDsl.g:4919:4: (otherlv_2= RULE_ID )
            {
            // InternalServiceDsl.g:4919:4: (otherlv_2= RULE_ID )
            // InternalServiceDsl.g:4920:5: otherlv_2= RULE_ID
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
    // InternalServiceDsl.g:4935:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalServiceDsl.g:4935:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalServiceDsl.g:4936:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalServiceDsl.g:4942:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalServiceDsl.g:4948:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalServiceDsl.g:4949:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalServiceDsl.g:4949:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalServiceDsl.g:4950:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalServiceDsl.g:4958:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalServiceDsl.g:4959:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalServiceDsl.g:4959:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalServiceDsl.g:4960:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
            {

            					newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
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

            // InternalServiceDsl.g:4977:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==28) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalServiceDsl.g:4978:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,28,FOLLOW_25); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalServiceDsl.g:4982:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalServiceDsl.g:4983:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalServiceDsl.g:4983:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalServiceDsl.g:4984:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
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
            	    break loop97;
                }
            } while (true);

            otherlv_5=(Token)match(input,20,FOLLOW_43); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:5014:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalServiceDsl.g:5014:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalServiceDsl.g:5015:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalServiceDsl.g:5021:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalServiceDsl.g:5027:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalServiceDsl.g:5028:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalServiceDsl.g:5028:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalServiceDsl.g:5029:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalServiceDsl.g:5033:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5034:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5034:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5035:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_82); 

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

            // InternalServiceDsl.g:5051:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==47) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalServiceDsl.g:5052:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_83); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:5056:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalServiceDsl.g:5057:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalServiceDsl.g:5057:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalServiceDsl.g:5058:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_79);
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

                    // InternalServiceDsl.g:5075:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==28) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5076:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_83); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:5080:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalServiceDsl.g:5081:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalServiceDsl.g:5081:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalServiceDsl.g:5082:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop98;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,48,FOLLOW_84); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,93,FOLLOW_88); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAspectAccess().getForKeyword_3());
            		
            // InternalServiceDsl.g:5109:3: ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) )
            // InternalServiceDsl.g:5110:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            {
            // InternalServiceDsl.g:5110:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            // InternalServiceDsl.g:5111:5: lv_joinPoints_8_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_86);
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

            // InternalServiceDsl.g:5128:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==28) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalServiceDsl.g:5129:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,28,FOLLOW_88); 

            	    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:5133:4: ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    // InternalServiceDsl.g:5134:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    {
            	    // InternalServiceDsl.g:5134:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    // InternalServiceDsl.g:5135:6: lv_joinPoints_10_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_86);
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
            	    break loop100;
                }
            } while (true);

            // InternalServiceDsl.g:5153:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==25) ) {
                alt103=1;
            }
            else if ( (LA103_0==41) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalServiceDsl.g:5154:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalServiceDsl.g:5154:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalServiceDsl.g:5155:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,25,FOLLOW_87); 

                    					newLeafNode(otherlv_11, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalServiceDsl.g:5159:5: ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==95) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5160:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalServiceDsl.g:5160:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    // InternalServiceDsl.g:5161:7: lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPointcutSelectorsOperationAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_87);
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
                    	    break loop101;
                        }
                    } while (true);

                    // InternalServiceDsl.g:5178:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( ((LA102_0>=120 && LA102_0<=129)||LA102_0==136) ) {
                            alt102=1;
                        }


                        switch (alt102) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5179:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:5179:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:5180:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_73);
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
                    	    break loop102;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,29,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:5203:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,41,FOLLOW_2); 

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
    // InternalServiceDsl.g:5212:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalServiceDsl.g:5212:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalServiceDsl.g:5213:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalServiceDsl.g:5219:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalServiceDsl.g:5225:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:5226:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:5226:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalServiceDsl.g:5227:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_58); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,96,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalServiceDsl.g:5239:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalServiceDsl.g:5240:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalServiceDsl.g:5240:4: (lv_importURI_3_0= RULE_STRING )
            // InternalServiceDsl.g:5241:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexTypeImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.ServiceDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalServiceDsl.g:5261:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:5262:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:5262:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:5263:5: lv_name_5_0= RULE_ID
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
    // InternalServiceDsl.g:5283:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalServiceDsl.g:5283:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalServiceDsl.g:5284:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalServiceDsl.g:5290:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalServiceDsl.g:5296:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalServiceDsl.g:5297:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalServiceDsl.g:5297:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalServiceDsl.g:5298:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalServiceDsl.g:5302:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5303:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5303:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5304:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_89); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalServiceDsl.g:5324:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt106=3;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=76 && LA106_0<=78)||LA106_0==114) ) {
                alt106=1;
            }
            else if ( (LA106_0==97) ) {
                alt106=2;
            }
            switch (alt106) {
                case 1 :
                    // InternalServiceDsl.g:5325:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalServiceDsl.g:5325:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt104=0;
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( ((LA104_0>=76 && LA104_0<=78)||LA104_0==114) ) {
                            alt104=1;
                        }


                        switch (alt104) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5326:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalServiceDsl.g:5326:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalServiceDsl.g:5327:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_90);
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
                    	    if ( cnt104 >= 1 ) break loop104;
                                EarlyExitException eee =
                                    new EarlyExitException(104, input);
                                throw eee;
                        }
                        cnt104++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:5345:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalServiceDsl.g:5345:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt105=0;
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==97) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5346:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalServiceDsl.g:5346:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalServiceDsl.g:5347:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_91);
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
                    	    if ( cnt105 >= 1 ) break loop105;
                                EarlyExitException eee =
                                    new EarlyExitException(105, input);
                                throw eee;
                        }
                        cnt105++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_2); 

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
    // InternalServiceDsl.g:5373:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalServiceDsl.g:5373:48: (iv_ruleContext= ruleContext EOF )
            // InternalServiceDsl.g:5374:2: iv_ruleContext= ruleContext EOF
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
    // InternalServiceDsl.g:5380:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:5386:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalServiceDsl.g:5387:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalServiceDsl.g:5387:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalServiceDsl.g:5388:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalServiceDsl.g:5392:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5393:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5393:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5394:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_92); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalServiceDsl.g:5414:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt107=0;
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( ((LA107_0>=76 && LA107_0<=78)||LA107_0==114) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalServiceDsl.g:5415:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalServiceDsl.g:5415:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalServiceDsl.g:5416:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_90);
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
            	    if ( cnt107 >= 1 ) break loop107;
                        EarlyExitException eee =
                            new EarlyExitException(107, input);
                        throw eee;
                }
                cnt107++;
            } while (true);

            otherlv_4=(Token)match(input,29,FOLLOW_2); 

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
    // InternalServiceDsl.g:5441:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalServiceDsl.g:5441:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalServiceDsl.g:5442:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalServiceDsl.g:5448:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:5454:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalServiceDsl.g:5455:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalServiceDsl.g:5455:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt108=3;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt108=1;
                }
                break;
            case 76:
            case 77:
                {
                alt108=2;
                }
                break;
            case 114:
                {
                alt108=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalServiceDsl.g:5456:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalServiceDsl.g:5465:3: this_ListType_1= ruleListType
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
                    // InternalServiceDsl.g:5474:3: this_Enumeration_2= ruleEnumeration
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
    // InternalServiceDsl.g:5486:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalServiceDsl.g:5486:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalServiceDsl.g:5487:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalServiceDsl.g:5493:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalServiceDsl.g:5499:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalServiceDsl.g:5500:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalServiceDsl.g:5500:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalServiceDsl.g:5501:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalServiceDsl.g:5505:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5506:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5506:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5507:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_93); 

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

            // InternalServiceDsl.g:5523:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==47) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalServiceDsl.g:5524:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:5528:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalServiceDsl.g:5529:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalServiceDsl.g:5529:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalServiceDsl.g:5530:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_79);
                    lv_features_3_0=ruleComplexTypeFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_3_0,
                    							"de.fhdo.lemma.data.DataDsl.ComplexTypeFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalServiceDsl.g:5547:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop109:
                    do {
                        int alt109=2;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==28) ) {
                            alt109=1;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5548:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_94); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:5552:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalServiceDsl.g:5553:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalServiceDsl.g:5553:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalServiceDsl.g:5554:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
                    	    lv_features_5_0=ruleComplexTypeFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_5_0,
                    	    								"de.fhdo.lemma.data.DataDsl.ComplexTypeFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop109;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,48,FOLLOW_95); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:5577:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==108) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalServiceDsl.g:5578:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,108,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalServiceDsl.g:5582:4: ( ( ruleQualifiedName ) )
                    // InternalServiceDsl.g:5583:5: ( ruleQualifiedName )
                    {
                    // InternalServiceDsl.g:5583:5: ( ruleQualifiedName )
                    // InternalServiceDsl.g:5584:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,25,FOLLOW_96); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalServiceDsl.g:5603:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==RULE_ID||(LA115_0>=112 && LA115_0<=113)||(LA115_0>=118 && LA115_0<=129)||LA115_0==136) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalServiceDsl.g:5604:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalServiceDsl.g:5604:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt112=2;
                    switch ( input.LA(1) ) {
                    case 112:
                        {
                        int LA112_1 = input.LA(2);

                        if ( (LA112_1==RULE_ID||LA112_1==113||(LA112_1>=120 && LA112_1<=129)||LA112_1==136) ) {
                            alt112=1;
                        }
                        else if ( ((LA112_1>=118 && LA112_1<=119)) ) {
                            alt112=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 112, 1, input);

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
                        alt112=1;
                        }
                        break;
                    case 118:
                    case 119:
                        {
                        alt112=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 112, 0, input);

                        throw nvae;
                    }

                    switch (alt112) {
                        case 1 :
                            // InternalServiceDsl.g:5605:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalServiceDsl.g:5605:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalServiceDsl.g:5606:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalServiceDsl.g:5606:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalServiceDsl.g:5607:7: lv_dataFields_10_0= ruleDataField
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0());
                            						
                            pushFollow(FOLLOW_21);
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
                            // InternalServiceDsl.g:5625:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalServiceDsl.g:5625:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalServiceDsl.g:5626:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalServiceDsl.g:5626:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalServiceDsl.g:5627:7: lv_operations_11_0= ruleDataOperation
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0());
                            						
                            pushFollow(FOLLOW_21);
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

                    // InternalServiceDsl.g:5645:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop114:
                    do {
                        int alt114=2;
                        int LA114_0 = input.LA(1);

                        if ( (LA114_0==28) ) {
                            alt114=1;
                        }


                        switch (alt114) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5646:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,28,FOLLOW_97); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalServiceDsl.g:5650:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt113=2;
                    	    switch ( input.LA(1) ) {
                    	    case 112:
                    	        {
                    	        int LA113_1 = input.LA(2);

                    	        if ( ((LA113_1>=118 && LA113_1<=119)) ) {
                    	            alt113=2;
                    	        }
                    	        else if ( (LA113_1==RULE_ID||LA113_1==113||(LA113_1>=120 && LA113_1<=129)||LA113_1==136) ) {
                    	            alt113=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 113, 1, input);

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
                    	        alt113=1;
                    	        }
                    	        break;
                    	    case 118:
                    	    case 119:
                    	        {
                    	        alt113=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 113, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt113) {
                    	        case 1 :
                    	            // InternalServiceDsl.g:5651:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalServiceDsl.g:5651:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalServiceDsl.g:5652:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalServiceDsl.g:5652:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalServiceDsl.g:5653:8: lv_dataFields_13_0= ruleDataField
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_21);
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
                    	            // InternalServiceDsl.g:5671:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalServiceDsl.g:5671:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalServiceDsl.g:5672:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalServiceDsl.g:5672:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalServiceDsl.g:5673:8: lv_operations_14_0= ruleDataOperation
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_21);
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
                    	    break loop114;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,29,FOLLOW_2); 

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
    // InternalServiceDsl.g:5701:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalServiceDsl.g:5701:49: (iv_ruleListType= ruleListType EOF )
            // InternalServiceDsl.g:5702:2: iv_ruleListType= ruleListType EOF
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
    // InternalServiceDsl.g:5708:1: ruleListType returns [EObject current=null] : ( ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' ) | ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_dataFields_4_0 = null;

        EObject lv_dataFields_6_0 = null;

        EObject lv_primitiveType_12_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:5714:2: ( ( ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' ) | ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' ) ) )
            // InternalServiceDsl.g:5715:2: ( ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' ) | ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' ) )
            {
            // InternalServiceDsl.g:5715:2: ( ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' ) | ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' ) )
            int alt119=2;
            alt119 = dfa119.predict(input);
            switch (alt119) {
                case 1 :
                    // InternalServiceDsl.g:5716:3: ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' )
                    {
                    // InternalServiceDsl.g:5716:3: ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' )
                    // InternalServiceDsl.g:5717:4: (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}'
                    {
                    // InternalServiceDsl.g:5717:4: (otherlv_0= 'collection' | otherlv_1= 'list' )
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==76) ) {
                        alt116=1;
                    }
                    else if ( (LA116_0==77) ) {
                        alt116=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 116, 0, input);

                        throw nvae;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalServiceDsl.g:5718:5: otherlv_0= 'collection'
                            {
                            otherlv_0=(Token)match(input,76,FOLLOW_9); 

                            					newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getCollectionKeyword_0_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalServiceDsl.g:5723:5: otherlv_1= 'list'
                            {
                            otherlv_1=(Token)match(input,77,FOLLOW_9); 

                            					newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getListKeyword_0_0_1());
                            				

                            }
                            break;

                    }

                    // InternalServiceDsl.g:5728:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalServiceDsl.g:5729:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:5729:5: (lv_name_2_0= RULE_ID )
                    // InternalServiceDsl.g:5730:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getListTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_98); 

                    				newLeafNode(otherlv_3, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalServiceDsl.g:5750:4: ( (lv_dataFields_4_0= ruleDataField ) )
                    // InternalServiceDsl.g:5751:5: (lv_dataFields_4_0= ruleDataField )
                    {
                    // InternalServiceDsl.g:5751:5: (lv_dataFields_4_0= ruleDataField )
                    // InternalServiceDsl.g:5752:6: lv_dataFields_4_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_dataFields_4_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTypeRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_4_0,
                    							"de.fhdo.lemma.data.DataDsl.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalServiceDsl.g:5769:4: (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )*
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==28) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5770:5: otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) )
                    	    {
                    	    otherlv_5=(Token)match(input,28,FOLLOW_98); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalServiceDsl.g:5774:5: ( (lv_dataFields_6_0= ruleDataField ) )
                    	    // InternalServiceDsl.g:5775:6: (lv_dataFields_6_0= ruleDataField )
                    	    {
                    	    // InternalServiceDsl.g:5775:6: (lv_dataFields_6_0= ruleDataField )
                    	    // InternalServiceDsl.g:5776:7: lv_dataFields_6_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
                    	    lv_dataFields_6_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getListTypeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataFields",
                    	    								lv_dataFields_6_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop117;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,29,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:5800:3: ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' )
                    {
                    // InternalServiceDsl.g:5800:3: ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' )
                    // InternalServiceDsl.g:5801:4: (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}'
                    {
                    // InternalServiceDsl.g:5801:4: (otherlv_8= 'collection' | otherlv_9= 'list' )
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==76) ) {
                        alt118=1;
                    }
                    else if ( (LA118_0==77) ) {
                        alt118=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 118, 0, input);

                        throw nvae;
                    }
                    switch (alt118) {
                        case 1 :
                            // InternalServiceDsl.g:5802:5: otherlv_8= 'collection'
                            {
                            otherlv_8=(Token)match(input,76,FOLLOW_9); 

                            					newLeafNode(otherlv_8, grammarAccess.getListTypeAccess().getCollectionKeyword_1_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalServiceDsl.g:5807:5: otherlv_9= 'list'
                            {
                            otherlv_9=(Token)match(input,77,FOLLOW_9); 

                            					newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getListKeyword_1_0_1());
                            				

                            }
                            break;

                    }

                    // InternalServiceDsl.g:5812:4: ( (lv_name_10_0= RULE_ID ) )
                    // InternalServiceDsl.g:5813:5: (lv_name_10_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:5813:5: (lv_name_10_0= RULE_ID )
                    // InternalServiceDsl.g:5814:6: lv_name_10_0= RULE_ID
                    {
                    lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    						newLeafNode(lv_name_10_0, grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getListTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_10_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,25,FOLLOW_67); 

                    				newLeafNode(otherlv_11, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalServiceDsl.g:5834:4: ( (lv_primitiveType_12_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:5835:5: (lv_primitiveType_12_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:5835:5: (lv_primitiveType_12_0= rulePrimitiveType )
                    // InternalServiceDsl.g:5836:6: lv_primitiveType_12_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_74);
                    lv_primitiveType_12_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListTypeRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_12_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,29,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4());
                    			

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
    // InternalServiceDsl.g:5862:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalServiceDsl.g:5862:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalServiceDsl.g:5863:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalServiceDsl.g:5869:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
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
            // InternalServiceDsl.g:5875:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalServiceDsl.g:5876:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalServiceDsl.g:5876:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalServiceDsl.g:5877:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalServiceDsl.g:5877:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==112) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalServiceDsl.g:5878:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalServiceDsl.g:5878:4: (lv_hidden_0_0= 'hide' )
                    // InternalServiceDsl.g:5879:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,112,FOLLOW_99); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:5891:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==113) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalServiceDsl.g:5892:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalServiceDsl.g:5892:4: (lv_immutable_1_0= 'immutable' )
                    // InternalServiceDsl.g:5893:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,113,FOLLOW_49); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", lv_immutable_1_0 != null, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:5905:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt122=4;
            int LA122_0 = input.LA(1);

            if ( ((LA122_0>=120 && LA122_0<=129)||LA122_0==136) ) {
                alt122=1;
            }
            else if ( (LA122_0==RULE_ID) ) {
                int LA122_2 = input.LA(2);

                if ( (LA122_2==35) ) {
                    alt122=3;
                }
                else if ( (LA122_2==RULE_ID||LA122_2==46) ) {
                    alt122=2;
                }
            }
            switch (alt122) {
                case 1 :
                    // InternalServiceDsl.g:5906:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalServiceDsl.g:5906:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:5907:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:5907:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalServiceDsl.g:5908:6: lv_primitiveType_2_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_9);
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
                    // InternalServiceDsl.g:5926:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalServiceDsl.g:5926:4: ( ( ruleQualifiedName ) )
                    // InternalServiceDsl.g:5927:5: ( ruleQualifiedName )
                    {
                    // InternalServiceDsl.g:5927:5: ( ruleQualifiedName )
                    // InternalServiceDsl.g:5928:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataFieldRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:5943:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalServiceDsl.g:5943:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalServiceDsl.g:5944:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalServiceDsl.g:5944:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalServiceDsl.g:5945:6: lv_importedComplexType_4_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_9);
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

            // InternalServiceDsl.g:5963:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:5964:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:5964:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:5965:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_100); 

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

            // InternalServiceDsl.g:5981:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==34) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalServiceDsl.g:5982:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_55); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalServiceDsl.g:5986:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:5987:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:5987:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:5988:6: lv_initializationValue_7_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_101);
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

            // InternalServiceDsl.g:6006:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==47) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalServiceDsl.g:6007:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,47,FOLLOW_102); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalServiceDsl.g:6011:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalServiceDsl.g:6012:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalServiceDsl.g:6012:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalServiceDsl.g:6013:6: lv_features_9_0= ruleDataFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_79);
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

                    // InternalServiceDsl.g:6030:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==28) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6031:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,28,FOLLOW_102); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6035:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalServiceDsl.g:6036:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalServiceDsl.g:6036:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalServiceDsl.g:6037:7: lv_features_11_0= ruleDataFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop124;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,48,FOLLOW_2); 

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
    // InternalServiceDsl.g:6064:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalServiceDsl.g:6064:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalServiceDsl.g:6065:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalServiceDsl.g:6071:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_features_3_0 = null;

        Enumerator lv_features_5_0 = null;

        EObject lv_fields_8_0 = null;

        EObject lv_fields_10_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:6077:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) )
            // InternalServiceDsl.g:6078:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            {
            // InternalServiceDsl.g:6078:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            // InternalServiceDsl.g:6079:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,114,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalServiceDsl.g:6083:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:6084:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:6084:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:6085:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_103); 

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

            // InternalServiceDsl.g:6101:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==47) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalServiceDsl.g:6102:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:6106:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalServiceDsl.g:6107:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalServiceDsl.g:6107:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalServiceDsl.g:6108:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_79);
                    lv_features_3_0=ruleComplexTypeFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_3_0,
                    							"de.fhdo.lemma.data.DataDsl.ComplexTypeFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalServiceDsl.g:6125:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==28) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6126:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_94); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6130:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalServiceDsl.g:6131:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalServiceDsl.g:6131:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalServiceDsl.g:6132:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
                    	    lv_features_5_0=ruleComplexTypeFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEnumerationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_5_0,
                    	    								"de.fhdo.lemma.data.DataDsl.ComplexTypeFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,48,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalServiceDsl.g:6159:3: ( (lv_fields_8_0= ruleEnumerationField ) )
            // InternalServiceDsl.g:6160:4: (lv_fields_8_0= ruleEnumerationField )
            {
            // InternalServiceDsl.g:6160:4: (lv_fields_8_0= ruleEnumerationField )
            // InternalServiceDsl.g:6161:5: lv_fields_8_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_fields_8_0=ruleEnumerationField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"fields",
            						lv_fields_8_0,
            						"de.fhdo.lemma.data.DataDsl.EnumerationField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalServiceDsl.g:6178:3: (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==28) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // InternalServiceDsl.g:6179:4: otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) )
            	    {
            	    otherlv_9=(Token)match(input,28,FOLLOW_9); 

            	    				newLeafNode(otherlv_9, grammarAccess.getEnumerationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:6183:4: ( (lv_fields_10_0= ruleEnumerationField ) )
            	    // InternalServiceDsl.g:6184:5: (lv_fields_10_0= ruleEnumerationField )
            	    {
            	    // InternalServiceDsl.g:6184:5: (lv_fields_10_0= ruleEnumerationField )
            	    // InternalServiceDsl.g:6185:6: lv_fields_10_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_fields_10_0=ruleEnumerationField();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fields",
            	    							lv_fields_10_0,
            	    							"de.fhdo.lemma.data.DataDsl.EnumerationField");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop128;
                }
            } while (true);

            otherlv_11=(Token)match(input,29,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalServiceDsl.g:6211:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalServiceDsl.g:6211:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalServiceDsl.g:6212:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalServiceDsl.g:6218:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:6224:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalServiceDsl.g:6225:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalServiceDsl.g:6225:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalServiceDsl.g:6226:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalServiceDsl.g:6226:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalServiceDsl.g:6227:4: (lv_name_0_0= RULE_ID )
            {
            // InternalServiceDsl.g:6227:4: (lv_name_0_0= RULE_ID )
            // InternalServiceDsl.g:6228:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_51); 

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

            // InternalServiceDsl.g:6244:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==19) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalServiceDsl.g:6245:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_55); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalServiceDsl.g:6249:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:6250:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:6250:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:6251:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_30);
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

                    otherlv_3=(Token)match(input,20,FOLLOW_2); 

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
    // InternalServiceDsl.g:6277:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalServiceDsl.g:6277:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalServiceDsl.g:6278:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalServiceDsl.g:6284:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalServiceDsl.g:6290:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalServiceDsl.g:6291:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalServiceDsl.g:6291:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalServiceDsl.g:6292:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalServiceDsl.g:6292:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==112) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalServiceDsl.g:6293:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalServiceDsl.g:6293:4: (lv_hidden_0_0= 'hide' )
                    // InternalServiceDsl.g:6294:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,112,FOLLOW_104); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:6306:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==119) ) {
                alt132=1;
            }
            else if ( (LA132_0==118) ) {
                alt132=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // InternalServiceDsl.g:6307:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalServiceDsl.g:6307:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalServiceDsl.g:6308:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalServiceDsl.g:6308:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalServiceDsl.g:6309:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,119,FOLLOW_9); 

                    						newLeafNode(lv_hasNoReturnType_1_0, grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationRule());
                    						}
                    						setWithLastConsumed(current, "hasNoReturnType", lv_hasNoReturnType_1_0 != null, "procedure");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:6322:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalServiceDsl.g:6322:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalServiceDsl.g:6323:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,118,FOLLOW_49); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalServiceDsl.g:6327:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt131=4;
                    int LA131_0 = input.LA(1);

                    if ( ((LA131_0>=120 && LA131_0<=129)||LA131_0==136) ) {
                        alt131=1;
                    }
                    else if ( (LA131_0==RULE_ID) ) {
                        int LA131_2 = input.LA(2);

                        if ( (LA131_2==35) ) {
                            alt131=3;
                        }
                        else if ( (LA131_2==RULE_ID||LA131_2==46) ) {
                            alt131=2;
                        }
                    }
                    switch (alt131) {
                        case 1 :
                            // InternalServiceDsl.g:6328:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalServiceDsl.g:6328:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalServiceDsl.g:6329:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalServiceDsl.g:6329:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalServiceDsl.g:6330:8: lv_primitiveReturnType_3_0= rulePrimitiveType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypePrimitiveTypeParserRuleCall_1_1_1_0_0());
                            							
                            pushFollow(FOLLOW_9);
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
                            // InternalServiceDsl.g:6348:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalServiceDsl.g:6348:6: ( ( ruleQualifiedName ) )
                            // InternalServiceDsl.g:6349:7: ( ruleQualifiedName )
                            {
                            // InternalServiceDsl.g:6349:7: ( ruleQualifiedName )
                            // InternalServiceDsl.g:6350:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getDataOperationRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0());
                            							
                            pushFollow(FOLLOW_9);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalServiceDsl.g:6365:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalServiceDsl.g:6365:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalServiceDsl.g:6366:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalServiceDsl.g:6366:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalServiceDsl.g:6367:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeImportedComplexTypeParserRuleCall_1_1_1_2_0());
                            							
                            pushFollow(FOLLOW_9);
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

            // InternalServiceDsl.g:6387:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalServiceDsl.g:6388:4: (lv_name_6_0= RULE_ID )
            {
            // InternalServiceDsl.g:6388:4: (lv_name_6_0= RULE_ID )
            // InternalServiceDsl.g:6389:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_105); 

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

            // InternalServiceDsl.g:6405:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==19) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalServiceDsl.g:6406:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_106); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalServiceDsl.g:6410:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt133=2;
                    int LA133_0 = input.LA(1);

                    if ( (LA133_0==RULE_ID||(LA133_0>=120 && LA133_0<=129)||LA133_0==136) ) {
                        alt133=1;
                    }
                    switch (alt133) {
                        case 1 :
                            // InternalServiceDsl.g:6411:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalServiceDsl.g:6411:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalServiceDsl.g:6412:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_26);
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

                    // InternalServiceDsl.g:6429:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==28) ) {
                            alt134=1;
                        }


                        switch (alt134) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6430:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,28,FOLLOW_49); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6434:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalServiceDsl.g:6435:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalServiceDsl.g:6435:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalServiceDsl.g:6436:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_26);
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
                    	    break loop134;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,20,FOLLOW_101); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:6459:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==47) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalServiceDsl.g:6460:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,47,FOLLOW_107); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalServiceDsl.g:6464:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalServiceDsl.g:6465:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalServiceDsl.g:6465:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalServiceDsl.g:6466:6: lv_features_13_0= ruleDataOperationFeature
                    {

                    						newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_79);
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

                    // InternalServiceDsl.g:6483:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==28) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6484:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,28,FOLLOW_107); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6488:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalServiceDsl.g:6489:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalServiceDsl.g:6489:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalServiceDsl.g:6490:7: lv_features_15_0= ruleDataOperationFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop136;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,48,FOLLOW_2); 

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
    // InternalServiceDsl.g:6517:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalServiceDsl.g:6517:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalServiceDsl.g:6518:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalServiceDsl.g:6524:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:6530:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:6531:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:6531:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalServiceDsl.g:6532:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalServiceDsl.g:6532:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt138=3;
            int LA138_0 = input.LA(1);

            if ( ((LA138_0>=120 && LA138_0<=129)||LA138_0==136) ) {
                alt138=1;
            }
            else if ( (LA138_0==RULE_ID) ) {
                int LA138_2 = input.LA(2);

                if ( (LA138_2==RULE_ID||LA138_2==46) ) {
                    alt138=2;
                }
                else if ( (LA138_2==35) ) {
                    alt138=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 138, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // InternalServiceDsl.g:6533:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalServiceDsl.g:6533:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:6534:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:6534:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalServiceDsl.g:6535:6: lv_primitiveType_0_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_9);
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
                    // InternalServiceDsl.g:6553:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalServiceDsl.g:6553:4: ( ( ruleQualifiedName ) )
                    // InternalServiceDsl.g:6554:5: ( ruleQualifiedName )
                    {
                    // InternalServiceDsl.g:6554:5: ( ruleQualifiedName )
                    // InternalServiceDsl.g:6555:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:6570:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalServiceDsl.g:6570:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalServiceDsl.g:6571:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalServiceDsl.g:6571:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalServiceDsl.g:6572:6: lv_importedComplexType_2_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_9);
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

            // InternalServiceDsl.g:6590:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalServiceDsl.g:6591:4: (lv_name_3_0= RULE_ID )
            {
            // InternalServiceDsl.g:6591:4: (lv_name_3_0= RULE_ID )
            // InternalServiceDsl.g:6592:5: lv_name_3_0= RULE_ID
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
    // InternalServiceDsl.g:6612:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalServiceDsl.g:6612:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalServiceDsl.g:6613:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalServiceDsl.g:6619:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6625:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalServiceDsl.g:6626:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalServiceDsl.g:6626:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt139=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt139=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt139=2;
                }
                break;
            case RULE_STRING:
                {
                alt139=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // InternalServiceDsl.g:6627:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalServiceDsl.g:6627:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalServiceDsl.g:6628:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalServiceDsl.g:6628:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalServiceDsl.g:6629:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalServiceDsl.g:6646:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalServiceDsl.g:6646:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalServiceDsl.g:6647:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalServiceDsl.g:6647:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalServiceDsl.g:6648:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalServiceDsl.g:6665:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalServiceDsl.g:6665:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalServiceDsl.g:6666:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalServiceDsl.g:6666:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalServiceDsl.g:6667:5: lv_stringValue_2_0= RULE_STRING
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
                    						"de.fhdo.lemma.ServiceDsl.STRING");
                    				

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
    // InternalServiceDsl.g:6687:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalServiceDsl.g:6687:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalServiceDsl.g:6688:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalServiceDsl.g:6694:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6700:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:6701:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:6701:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:6702:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:6702:3: ( (otherlv_0= RULE_ID ) )
            // InternalServiceDsl.g:6703:4: (otherlv_0= RULE_ID )
            {
            // InternalServiceDsl.g:6703:4: (otherlv_0= RULE_ID )
            // InternalServiceDsl.g:6704:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalServiceDsl.g:6719:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:6720:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:6720:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:6721:5: ruleQualifiedName
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
    // InternalServiceDsl.g:6739:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalServiceDsl.g:6739:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalServiceDsl.g:6740:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalServiceDsl.g:6746:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
            // InternalServiceDsl.g:6752:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalServiceDsl.g:6753:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalServiceDsl.g:6753:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt140=11;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt140=1;
                }
                break;
            case 121:
                {
                alt140=2;
                }
                break;
            case 122:
                {
                alt140=3;
                }
                break;
            case 123:
                {
                alt140=4;
                }
                break;
            case 124:
                {
                alt140=5;
                }
                break;
            case 125:
                {
                alt140=6;
                }
                break;
            case 126:
                {
                alt140=7;
                }
                break;
            case 127:
                {
                alt140=8;
                }
                break;
            case 128:
                {
                alt140=9;
                }
                break;
            case 129:
                {
                alt140=10;
                }
                break;
            case 136:
                {
                alt140=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }

            switch (alt140) {
                case 1 :
                    // InternalServiceDsl.g:6754:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalServiceDsl.g:6754:3: ( () otherlv_1= 'boolean' )
                    // InternalServiceDsl.g:6755:4: () otherlv_1= 'boolean'
                    {
                    // InternalServiceDsl.g:6755:4: ()
                    // InternalServiceDsl.g:6756:5: 
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
                    // InternalServiceDsl.g:6768:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalServiceDsl.g:6768:3: ( () otherlv_3= 'byte' )
                    // InternalServiceDsl.g:6769:4: () otherlv_3= 'byte'
                    {
                    // InternalServiceDsl.g:6769:4: ()
                    // InternalServiceDsl.g:6770:5: 
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
                    // InternalServiceDsl.g:6782:3: ( () otherlv_5= 'char' )
                    {
                    // InternalServiceDsl.g:6782:3: ( () otherlv_5= 'char' )
                    // InternalServiceDsl.g:6783:4: () otherlv_5= 'char'
                    {
                    // InternalServiceDsl.g:6783:4: ()
                    // InternalServiceDsl.g:6784:5: 
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
                    // InternalServiceDsl.g:6796:3: ( () otherlv_7= 'date' )
                    {
                    // InternalServiceDsl.g:6796:3: ( () otherlv_7= 'date' )
                    // InternalServiceDsl.g:6797:4: () otherlv_7= 'date'
                    {
                    // InternalServiceDsl.g:6797:4: ()
                    // InternalServiceDsl.g:6798:5: 
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
                    // InternalServiceDsl.g:6810:3: ( () otherlv_9= 'double' )
                    {
                    // InternalServiceDsl.g:6810:3: ( () otherlv_9= 'double' )
                    // InternalServiceDsl.g:6811:4: () otherlv_9= 'double'
                    {
                    // InternalServiceDsl.g:6811:4: ()
                    // InternalServiceDsl.g:6812:5: 
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
                    // InternalServiceDsl.g:6824:3: ( () otherlv_11= 'float' )
                    {
                    // InternalServiceDsl.g:6824:3: ( () otherlv_11= 'float' )
                    // InternalServiceDsl.g:6825:4: () otherlv_11= 'float'
                    {
                    // InternalServiceDsl.g:6825:4: ()
                    // InternalServiceDsl.g:6826:5: 
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
                    // InternalServiceDsl.g:6838:3: ( () otherlv_13= 'int' )
                    {
                    // InternalServiceDsl.g:6838:3: ( () otherlv_13= 'int' )
                    // InternalServiceDsl.g:6839:4: () otherlv_13= 'int'
                    {
                    // InternalServiceDsl.g:6839:4: ()
                    // InternalServiceDsl.g:6840:5: 
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
                    // InternalServiceDsl.g:6852:3: ( () otherlv_15= 'long' )
                    {
                    // InternalServiceDsl.g:6852:3: ( () otherlv_15= 'long' )
                    // InternalServiceDsl.g:6853:4: () otherlv_15= 'long'
                    {
                    // InternalServiceDsl.g:6853:4: ()
                    // InternalServiceDsl.g:6854:5: 
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
                    // InternalServiceDsl.g:6866:3: ( () otherlv_17= 'short' )
                    {
                    // InternalServiceDsl.g:6866:3: ( () otherlv_17= 'short' )
                    // InternalServiceDsl.g:6867:4: () otherlv_17= 'short'
                    {
                    // InternalServiceDsl.g:6867:4: ()
                    // InternalServiceDsl.g:6868:5: 
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
                    // InternalServiceDsl.g:6880:3: ( () otherlv_19= 'string' )
                    {
                    // InternalServiceDsl.g:6880:3: ( () otherlv_19= 'string' )
                    // InternalServiceDsl.g:6881:4: () otherlv_19= 'string'
                    {
                    // InternalServiceDsl.g:6881:4: ()
                    // InternalServiceDsl.g:6882:5: 
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
                    // InternalServiceDsl.g:6894:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalServiceDsl.g:6894:3: ( () otherlv_21= 'unspecified' )
                    // InternalServiceDsl.g:6895:4: () otherlv_21= 'unspecified'
                    {
                    // InternalServiceDsl.g:6895:4: ()
                    // InternalServiceDsl.g:6896:5: 
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
    // InternalServiceDsl.g:6911:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalServiceDsl.g:6911:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalServiceDsl.g:6912:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalServiceDsl.g:6918:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6924:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalServiceDsl.g:6925:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalServiceDsl.g:6925:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalServiceDsl.g:6926:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_108); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalServiceDsl.g:6933:3: (kw= '.' this_ID_2= RULE_ID )*
            loop141:
            do {
                int alt141=2;
                int LA141_0 = input.LA(1);

                if ( (LA141_0==46) ) {
                    alt141=1;
                }


                switch (alt141) {
            	case 1 :
            	    // InternalServiceDsl.g:6934:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,46,FOLLOW_9); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_108); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop141;
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
    // InternalServiceDsl.g:6951:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6957:2: ( ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) ) )
            // InternalServiceDsl.g:6958:2: ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) )
            {
            // InternalServiceDsl.g:6958:2: ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) )
            int alt142=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt142=1;
                }
                break;
            case 32:
                {
                alt142=2;
                }
                break;
            case 27:
                {
                alt142=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }

            switch (alt142) {
                case 1 :
                    // InternalServiceDsl.g:6959:3: (enumLiteral_0= 'datatypes' )
                    {
                    // InternalServiceDsl.g:6959:3: (enumLiteral_0= 'datatypes' )
                    // InternalServiceDsl.g:6960:4: enumLiteral_0= 'datatypes'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getDATATYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getDATATYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:6967:3: (enumLiteral_1= 'technology' )
                    {
                    // InternalServiceDsl.g:6967:3: (enumLiteral_1= 'technology' )
                    // InternalServiceDsl.g:6968:4: enumLiteral_1= 'technology'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:6975:3: (enumLiteral_2= 'microservices' )
                    {
                    // InternalServiceDsl.g:6975:3: (enumLiteral_2= 'microservices' )
                    // InternalServiceDsl.g:6976:4: enumLiteral_2= 'microservices'
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_2());
                    			

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
    // InternalServiceDsl.g:6986:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6992:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalServiceDsl.g:6993:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalServiceDsl.g:6993:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt143=3;
            switch ( input.LA(1) ) {
            case 130:
                {
                alt143=1;
                }
                break;
            case 131:
                {
                alt143=2;
                }
                break;
            case 132:
                {
                alt143=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 143, 0, input);

                throw nvae;
            }

            switch (alt143) {
                case 1 :
                    // InternalServiceDsl.g:6994:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalServiceDsl.g:6994:3: (enumLiteral_0= 'internal' )
                    // InternalServiceDsl.g:6995:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7002:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalServiceDsl.g:7002:3: (enumLiteral_1= 'architecture' )
                    // InternalServiceDsl.g:7003:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7010:3: (enumLiteral_2= 'public' )
                    {
                    // InternalServiceDsl.g:7010:3: (enumLiteral_2= 'public' )
                    // InternalServiceDsl.g:7011:4: enumLiteral_2= 'public'
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
    // InternalServiceDsl.g:7021:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7027:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalServiceDsl.g:7028:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalServiceDsl.g:7028:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt144=3;
            switch ( input.LA(1) ) {
            case 134:
                {
                alt144=1;
                }
                break;
            case 135:
                {
                alt144=2;
                }
                break;
            case 60:
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
                    // InternalServiceDsl.g:7029:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalServiceDsl.g:7029:3: (enumLiteral_0= 'functional' )
                    // InternalServiceDsl.g:7030:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7037:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalServiceDsl.g:7037:3: (enumLiteral_1= 'utility' )
                    // InternalServiceDsl.g:7038:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7045:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalServiceDsl.g:7045:3: (enumLiteral_2= 'infrastructure' )
                    // InternalServiceDsl.g:7046:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

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
    // InternalServiceDsl.g:7056:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7062:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalServiceDsl.g:7063:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalServiceDsl.g:7063:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt145=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt145=1;
                }
                break;
            case 68:
                {
                alt145=2;
                }
                break;
            case 69:
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
                    // InternalServiceDsl.g:7064:3: (enumLiteral_0= 'in' )
                    {
                    // InternalServiceDsl.g:7064:3: (enumLiteral_0= 'in' )
                    // InternalServiceDsl.g:7065:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7072:3: (enumLiteral_1= 'out' )
                    {
                    // InternalServiceDsl.g:7072:3: (enumLiteral_1= 'out' )
                    // InternalServiceDsl.g:7073:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7080:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalServiceDsl.g:7080:3: (enumLiteral_2= 'inout' )
                    // InternalServiceDsl.g:7081:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,69,FOLLOW_2); 

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
    // InternalServiceDsl.g:7091:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7097:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalServiceDsl.g:7098:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalServiceDsl.g:7098:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==70) ) {
                alt146=1;
            }
            else if ( (LA146_0==71) ) {
                alt146=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }
            switch (alt146) {
                case 1 :
                    // InternalServiceDsl.g:7099:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalServiceDsl.g:7099:3: (enumLiteral_0= 'sync' )
                    // InternalServiceDsl.g:7100:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7107:3: (enumLiteral_1= 'async' )
                    {
                    // InternalServiceDsl.g:7107:3: (enumLiteral_1= 'async' )
                    // InternalServiceDsl.g:7108:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); 

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
    // InternalServiceDsl.g:7118:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7124:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalServiceDsl.g:7125:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalServiceDsl.g:7125:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt147=3;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt147=1;
                }
                break;
            case 79:
                {
                alt147=2;
                }
                break;
            case 81:
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
                    // InternalServiceDsl.g:7126:3: (enumLiteral_0= '<-' )
                    {
                    // InternalServiceDsl.g:7126:3: (enumLiteral_0= '<-' )
                    // InternalServiceDsl.g:7127:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7134:3: (enumLiteral_1= '->' )
                    {
                    // InternalServiceDsl.g:7134:3: (enumLiteral_1= '->' )
                    // InternalServiceDsl.g:7135:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7142:3: (enumLiteral_2= '<->' )
                    {
                    // InternalServiceDsl.g:7142:3: (enumLiteral_2= '<->' )
                    // InternalServiceDsl.g:7143:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,81,FOLLOW_2); 

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
    // InternalServiceDsl.g:7153:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7159:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalServiceDsl.g:7160:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalServiceDsl.g:7160:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==84) ) {
                alt148=1;
            }
            else if ( (LA148_0==85) ) {
                alt148=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }
            switch (alt148) {
                case 1 :
                    // InternalServiceDsl.g:7161:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalServiceDsl.g:7161:3: (enumLiteral_0= 'mandatory' )
                    // InternalServiceDsl.g:7162:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7169:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalServiceDsl.g:7169:3: (enumLiteral_1= 'singleval' )
                    // InternalServiceDsl.g:7170:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

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
    // InternalServiceDsl.g:7180:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) ;
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
            // InternalServiceDsl.g:7186:2: ( ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) )
            // InternalServiceDsl.g:7187:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            {
            // InternalServiceDsl.g:7187:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            int alt149=8;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt149=1;
                }
                break;
            case 87:
                {
                alt149=2;
                }
                break;
            case 137:
                {
                alt149=3;
                }
                break;
            case 138:
                {
                alt149=4;
                }
                break;
            case 27:
                {
                alt149=5;
                }
                break;
            case 30:
                {
                alt149=6;
                }
                break;
            case 31:
                {
                alt149=7;
                }
                break;
            case 86:
                {
                alt149=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // InternalServiceDsl.g:7188:3: (enumLiteral_0= 'types' )
                    {
                    // InternalServiceDsl.g:7188:3: (enumLiteral_0= 'types' )
                    // InternalServiceDsl.g:7189:4: enumLiteral_0= 'types'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7196:3: (enumLiteral_1= 'fields' )
                    {
                    // InternalServiceDsl.g:7196:3: (enumLiteral_1= 'fields' )
                    // InternalServiceDsl.g:7197:4: enumLiteral_1= 'fields'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7204:3: (enumLiteral_2= 'domainOperations' )
                    {
                    // InternalServiceDsl.g:7204:3: (enumLiteral_2= 'domainOperations' )
                    // InternalServiceDsl.g:7205:4: enumLiteral_2= 'domainOperations'
                    {
                    enumLiteral_2=(Token)match(input,137,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:7212:3: (enumLiteral_3= 'domainParameters' )
                    {
                    // InternalServiceDsl.g:7212:3: (enumLiteral_3= 'domainParameters' )
                    // InternalServiceDsl.g:7213:4: enumLiteral_3= 'domainParameters'
                    {
                    enumLiteral_3=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalServiceDsl.g:7220:3: (enumLiteral_4= 'microservices' )
                    {
                    // InternalServiceDsl.g:7220:3: (enumLiteral_4= 'microservices' )
                    // InternalServiceDsl.g:7221:4: enumLiteral_4= 'microservices'
                    {
                    enumLiteral_4=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalServiceDsl.g:7228:3: (enumLiteral_5= 'interfaces' )
                    {
                    // InternalServiceDsl.g:7228:3: (enumLiteral_5= 'interfaces' )
                    // InternalServiceDsl.g:7229:4: enumLiteral_5= 'interfaces'
                    {
                    enumLiteral_5=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalServiceDsl.g:7236:3: (enumLiteral_6= 'operations' )
                    {
                    // InternalServiceDsl.g:7236:3: (enumLiteral_6= 'operations' )
                    // InternalServiceDsl.g:7237:4: enumLiteral_6= 'operations'
                    {
                    enumLiteral_6=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalServiceDsl.g:7244:3: (enumLiteral_7= 'parameters' )
                    {
                    // InternalServiceDsl.g:7244:3: (enumLiteral_7= 'parameters' )
                    // InternalServiceDsl.g:7245:4: enumLiteral_7= 'parameters'
                    {
                    enumLiteral_7=(Token)match(input,86,FOLLOW_2); 

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
    // InternalServiceDsl.g:7255:1: ruleAspectFeature returns [Enumerator current=null] : (enumLiteral_0= 'singleval' ) ;
    public final Enumerator ruleAspectFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7261:2: ( (enumLiteral_0= 'singleval' ) )
            // InternalServiceDsl.g:7262:2: (enumLiteral_0= 'singleval' )
            {
            // InternalServiceDsl.g:7262:2: (enumLiteral_0= 'singleval' )
            // InternalServiceDsl.g:7263:3: enumLiteral_0= 'singleval'
            {
            enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

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
    // InternalServiceDsl.g:7272:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7278:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalServiceDsl.g:7279:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalServiceDsl.g:7279:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==94) ) {
                alt150=1;
            }
            else if ( (LA150_0==60) ) {
                alt150=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;
            }
            switch (alt150) {
                case 1 :
                    // InternalServiceDsl.g:7280:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalServiceDsl.g:7280:3: (enumLiteral_0= 'containers' )
                    // InternalServiceDsl.g:7281:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7288:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalServiceDsl.g:7288:3: (enumLiteral_1= 'infrastructure' )
                    // InternalServiceDsl.g:7289:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

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


    // $ANTLR start "ruleComplexTypeFeature"
    // InternalServiceDsl.g:7299:1: ruleComplexTypeFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
    public final Enumerator ruleComplexTypeFeature() throws RecognitionException {
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
            // InternalServiceDsl.g:7305:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalServiceDsl.g:7306:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalServiceDsl.g:7306:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt151=11;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt151=1;
                }
                break;
            case 99:
                {
                alt151=2;
                }
                break;
            case 100:
                {
                alt151=3;
                }
                break;
            case 101:
                {
                alt151=4;
                }
                break;
            case 102:
                {
                alt151=5;
                }
                break;
            case 103:
                {
                alt151=6;
                }
                break;
            case 104:
                {
                alt151=7;
                }
                break;
            case 105:
                {
                alt151=8;
                }
                break;
            case 56:
                {
                alt151=9;
                }
                break;
            case 106:
                {
                alt151=10;
                }
                break;
            case 107:
                {
                alt151=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 151, 0, input);

                throw nvae;
            }

            switch (alt151) {
                case 1 :
                    // InternalServiceDsl.g:7307:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalServiceDsl.g:7307:3: (enumLiteral_0= 'aggregate' )
                    // InternalServiceDsl.g:7308:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7315:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalServiceDsl.g:7315:3: (enumLiteral_1= 'applicationService' )
                    // InternalServiceDsl.g:7316:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7323:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalServiceDsl.g:7323:3: (enumLiteral_2= 'domainEvent' )
                    // InternalServiceDsl.g:7324:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:7331:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalServiceDsl.g:7331:3: (enumLiteral_3= 'domainService' )
                    // InternalServiceDsl.g:7332:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalServiceDsl.g:7339:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalServiceDsl.g:7339:3: (enumLiteral_4= 'entity' )
                    // InternalServiceDsl.g:7340:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalServiceDsl.g:7347:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalServiceDsl.g:7347:3: (enumLiteral_5= 'factory' )
                    // InternalServiceDsl.g:7348:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalServiceDsl.g:7355:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalServiceDsl.g:7355:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalServiceDsl.g:7356:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalServiceDsl.g:7363:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalServiceDsl.g:7363:3: (enumLiteral_7= 'repository' )
                    // InternalServiceDsl.g:7364:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalServiceDsl.g:7371:3: (enumLiteral_8= 'service' )
                    {
                    // InternalServiceDsl.g:7371:3: (enumLiteral_8= 'service' )
                    // InternalServiceDsl.g:7372:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalServiceDsl.g:7379:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalServiceDsl.g:7379:3: (enumLiteral_9= 'specification' )
                    // InternalServiceDsl.g:7380:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalServiceDsl.g:7387:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalServiceDsl.g:7387:3: (enumLiteral_10= 'valueObject' )
                    // InternalServiceDsl.g:7388:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getComplexTypeFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10());
                    			

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
    // $ANTLR end "ruleComplexTypeFeature"


    // $ANTLR start "ruleDataFieldFeature"
    // InternalServiceDsl.g:7398:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7404:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalServiceDsl.g:7405:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalServiceDsl.g:7405:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt152=3;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt152=1;
                }
                break;
            case 110:
                {
                alt152=2;
                }
                break;
            case 111:
                {
                alt152=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }

            switch (alt152) {
                case 1 :
                    // InternalServiceDsl.g:7406:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalServiceDsl.g:7406:3: (enumLiteral_0= 'identifier' )
                    // InternalServiceDsl.g:7407:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7414:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalServiceDsl.g:7414:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalServiceDsl.g:7415:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7422:3: (enumLiteral_2= 'part' )
                    {
                    // InternalServiceDsl.g:7422:3: (enumLiteral_2= 'part' )
                    // InternalServiceDsl.g:7423:4: enumLiteral_2= 'part'
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
    // InternalServiceDsl.g:7433:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7439:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalServiceDsl.g:7440:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalServiceDsl.g:7440:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt153=4;
            switch ( input.LA(1) ) {
            case 115:
                {
                alt153=1;
                }
                break;
            case 109:
                {
                alt153=2;
                }
                break;
            case 116:
                {
                alt153=3;
                }
                break;
            case 117:
                {
                alt153=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalServiceDsl.g:7441:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalServiceDsl.g:7441:3: (enumLiteral_0= 'closure' )
                    // InternalServiceDsl.g:7442:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7449:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalServiceDsl.g:7449:3: (enumLiteral_1= 'identifier' )
                    // InternalServiceDsl.g:7450:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7457:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalServiceDsl.g:7457:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalServiceDsl.g:7458:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:7465:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalServiceDsl.g:7465:3: (enumLiteral_3= 'validator' )
                    // InternalServiceDsl.g:7466:4: enumLiteral_3= 'validator'
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


    protected DFA34 dfa34 = new DFA34(this);
    protected DFA119 dfa119 = new DFA119(this);
    static final String dfa_1s = "\161\uffff";
    static final String dfa_2s = "\1\5\1\uffff\1\5\1\uffff\1\43\3\23\5\5\3\43\1\5\1\4\5\5\3\24\4\23\1\5\2\4\1\5\1\4\2\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\6\24\1\23\1\24\1\5\1\23\1\24\1\43\1\34\1\23\1\24\1\43\1\34\1\5\2\24\2\23\1\34\1\5\1\4\1\5\1\34\1\5\1\4\1\5\1\23\1\5\1\23\1\34\1\5\1\23\1\34\1\5\2\4\1\43\1\5\1\4\1\5\1\4\1\5\6\24\1\5\1\23\1\24\1\23\1\24\1\25\1\24\1\23\2\34\1\5\1\4\1\5\1\23\1\24\1\5\1\24";
    static final String dfa_3s = "\1\u0084\1\uffff\1\107\1\uffff\1\43\2\23\1\25\4\5\1\u0084\3\43\1\5\1\10\4\5\1\u0084\3\24\1\42\3\56\1\u0084\2\10\1\5\1\4\1\u0084\1\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\3\34\3\24\1\56\1\24\1\107\1\56\1\24\1\43\1\51\1\56\1\24\1\43\1\51\1\5\1\34\1\24\2\23\1\55\1\5\1\4\1\26\1\55\1\5\1\4\1\24\1\42\1\5\1\56\1\51\1\u0084\1\56\1\51\1\u0084\2\10\1\43\1\5\1\4\1\5\1\4\1\22\3\34\3\24\1\5\1\56\1\24\1\56\1\24\1\25\1\34\1\56\2\55\1\5\1\4\1\u0084\1\56\1\24\1\22\1\24";
    static final String dfa_4s = "\1\uffff\1\2\1\uffff\1\1\155\uffff";
    static final String dfa_5s = "\161\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\13\uffff\1\2\13\uffff\1\1\6\uffff\1\1\1\uffff\1\1\3\uffff\1\3\127\uffff\3\1",
            "",
            "\1\4\14\uffff\1\7\63\uffff\1\5\1\6",
            "",
            "\1\10",
            "\1\11",
            "\1\11",
            "\1\13\1\uffff\1\12",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\1\13\uffff\1\22\1\uffff\1\21\20\uffff\1\1\5\uffff\1\3\3\uffff\1\20\123\uffff\3\1",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\31\1\32\1\30\1\uffff\1\27",
            "\1\4",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\1\13\uffff\1\22\1\uffff\1\21\20\uffff\1\1\5\uffff\1\3\3\uffff\1\20\123\uffff\3\1",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\40\16\uffff\1\37",
            "\1\42\1\43\31\uffff\1\41",
            "\1\45\10\uffff\1\46\20\uffff\1\47\1\44",
            "\1\51\10\uffff\1\52\20\uffff\1\53\1\50",
            "\1\1\13\uffff\1\22\22\uffff\1\1\5\uffff\1\3\127\uffff\3\1",
            "\1\56\1\uffff\1\55\1\uffff\1\54",
            "\1\61\1\uffff\1\60\1\uffff\1\57",
            "\1\62",
            "\1\63",
            "\1\1\13\uffff\1\64\22\uffff\1\1\5\uffff\1\3\127\uffff\3\1",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\36\7\uffff\1\75",
            "\1\36\7\uffff\1\75",
            "\1\36\7\uffff\1\75",
            "\1\76",
            "\1\76",
            "\1\76",
            "\1\42\1\43\31\uffff\1\41",
            "\1\77",
            "\1\4\14\uffff\1\7\63\uffff\1\100\1\101",
            "\1\45\10\uffff\1\46\20\uffff\1\47\1\44",
            "\1\102",
            "\1\103",
            "\1\104\14\uffff\1\105",
            "\1\51\10\uffff\1\52\20\uffff\1\53\1\50",
            "\1\106",
            "\1\107",
            "\1\110\14\uffff\1\111",
            "\1\112",
            "\1\36\7\uffff\1\75",
            "\1\43",
            "\1\113",
            "\1\113",
            "\1\46\20\uffff\1\47",
            "\1\114",
            "\1\115",
            "\1\16\20\uffff\1\116",
            "\1\52\20\uffff\1\53",
            "\1\117",
            "\1\120",
            "\1\17\16\uffff\1\121",
            "\1\123\16\uffff\1\122",
            "\1\124",
            "\1\126\10\uffff\1\46\20\uffff\1\47\1\125",
            "\1\104\14\uffff\1\105",
            "\1\1\13\uffff\1\22\22\uffff\1\1\5\uffff\1\3\127\uffff\3\1",
            "\1\130\10\uffff\1\52\20\uffff\1\53\1\127",
            "\1\110\14\uffff\1\111",
            "\1\1\13\uffff\1\131\22\uffff\1\1\5\uffff\1\3\127\uffff\3\1",
            "\1\134\1\uffff\1\133\1\uffff\1\132",
            "\1\137\1\uffff\1\136\1\uffff\1\135",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\4\14\uffff\1\145",
            "\1\36\7\uffff\1\75",
            "\1\36\7\uffff\1\75",
            "\1\36\7\uffff\1\75",
            "\1\146",
            "\1\146",
            "\1\146",
            "\1\147",
            "\1\126\10\uffff\1\46\20\uffff\1\47\1\125",
            "\1\150",
            "\1\130\10\uffff\1\52\20\uffff\1\53\1\127",
            "\1\151",
            "\1\12",
            "\1\36\7\uffff\1\75",
            "\1\153\1\154\31\uffff\1\152",
            "\1\46\20\uffff\1\47",
            "\1\52\20\uffff\1\53",
            "\1\155",
            "\1\156",
            "\1\1\13\uffff\1\157\22\uffff\1\1\5\uffff\1\3\127\uffff\3\1",
            "\1\153\1\154\31\uffff\1\152",
            "\1\160",
            "\1\4\14\uffff\1\7",
            "\1\154"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 1150:3: ( (lv_referredOperations_20_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_7s = "\22\uffff";
    static final String dfa_8s = "\1\114\2\5\1\31\14\5\2\uffff";
    static final String dfa_9s = "\1\115\2\5\1\31\1\u0088\13\35\2\uffff";
    static final String dfa_10s = "\20\uffff\1\1\1\2";
    static final String dfa_11s = "\22\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\1\2",
            "\1\3",
            "\1\3",
            "\1\4",
            "\1\20\152\uffff\2\20\6\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\6\uffff\1\17",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "\1\20\27\uffff\1\21",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA119 extends DFA {

        public DFA119(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 119;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "5715:2: ( ( (otherlv_0= 'collection' | otherlv_1= 'list' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_dataFields_4_0= ruleDataField ) ) (otherlv_5= ',' ( (lv_dataFields_6_0= ruleDataField ) ) )* otherlv_7= '}' ) | ( (otherlv_8= 'collection' | otherlv_9= 'list' ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '{' ( (lv_primitiveType_12_0= rulePrimitiveType ) ) otherlv_13= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x1000000000024000L,0x0000000000000000L,0x00000000000000DCL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x1000000000020002L,0x0000000000000000L,0x00000000000000DCL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000108000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x1000000000020000L,0x0000000000000000L,0x00000000000000DCL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000003004020000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000003024020000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000003000020000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000045020020020L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000005020020020L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xFFFFFE3FFF9FC3F0L,0xFFFFFFFEFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000001C000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000001000020020L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000010120000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000020000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000020000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000038L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000080000000020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000020L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000020010000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000170L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000150L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xFFFFFE3FFF9FC3F2L,0xFFFFFFFEFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000020010000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000010000000L,0x0000000000038000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0100000020000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000020000000L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000820400000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000820000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x000000000F000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000800000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x00100000C8000000L,0x0000000000C00000L,0x0000000000000600L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000020012000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000020000000L,0xFF00000080000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x1000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000020000000L,0x0004000200007000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000020000000L,0x0004000000007000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000020000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0004000000007000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000800002000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0100000000000000L,0x00000FFC00000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000002000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000020000020L,0xFFC3000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000020L,0xFFC3000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000020L,0xFF03000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000020L,0xFF02000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000800400000002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000E00000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000800000080002L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000010100020L,0xFF00000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0038200000000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000400000000002L});

}