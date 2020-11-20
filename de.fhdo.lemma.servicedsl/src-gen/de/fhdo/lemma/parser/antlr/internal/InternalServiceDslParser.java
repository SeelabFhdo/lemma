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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BOOLEAN", "RULE_BIG_DECIMAL", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "'from'", "'as'", "'@'", "'endpoints'", "'('", "')'", "'({'", "'})'", "'microservice'", "'version'", "'{'", "'required'", "'microservices'", "','", "'}'", "'interfaces'", "'operations'", "'technology'", "'typedef'", "'='", "'::'", "'noimpl'", "'interface'", "'---'", "'@param'", "'@required'", "';'", "'refers'", "'fault'", "'?'", "':'", "'.'", "'<'", "'>'", "'-'", "'--'", "'/'", "'types'", "'compatibility'", "'matrix'", "'protocols'", "'service'", "'aspects'", "'deployment'", "'technologies'", "'infrastructure'", "'operation'", "'data'", "'formats'", "'default'", "'with'", "'format'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'primitive'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'->'", "'<-'", "'<->'", "'environments'", "'properties'", "'mandatory'", "'singleval'", "'parameters'", "'fields'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'aspect'", "'for'", "'containers'", "'selector'", "'datatypes'", "'context'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'extends'", "'identifier'", "'neverEmpty'", "'part'", "'hide'", "'immutable'", "'enum'", "'closure'", "'sideEffectFree'", "'validator'", "'function'", "'procedure'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'param'", "'functional'", "'utility'", "'unspecified'", "'domainOperations'", "'domainParameters'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
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

                if ( (LA1_0==13) ) {
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

                if ( (LA2_0==16||LA2_0==59||(LA2_0>=128 && LA2_0<=130)||(LA2_0>=132 && LA2_0<=133)) ) {
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
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_7); 

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

            otherlv_4=(Token)match(input,15,FOLLOW_9); 

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

                if ( (LA3_0==16) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==31) ) {
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

            if ( (LA5_0==16) ) {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>=69 && LA5_1<=70)) ) {
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

                    if ( (LA4_0==16) ) {
                        int LA4_1 = input.LA(2);

                        if ( ((LA4_1>=69 && LA4_1<=70)) ) {
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

            if ( (LA7_0==16) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==17) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==18) ) {
                        alt7=1;
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalServiceDsl.g:283:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,18,FOLLOW_9); 

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

                    otherlv_7=(Token)match(input,19,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:319:3: (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==17) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // InternalServiceDsl.g:320:4: otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_3_1());
                    			
                    otherlv_10=(Token)match(input,20,FOLLOW_9); 

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

                    otherlv_12=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceAccess().getRightCurlyBracketRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:356:3: ( (lv_aspects_13_0= ruleImportedServiceAspect ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16) ) {
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

            if ( ((LA11_0>=128 && LA11_0<=130)) ) {
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

            otherlv_16=(Token)match(input,22,FOLLOW_9); 

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

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalServiceDsl.g:437:4: otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) )
                    {
                    otherlv_18=(Token)match(input,23,FOLLOW_9); 

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

            otherlv_20=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalServiceDsl.g:464:3: (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==26) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalServiceDsl.g:465:4: otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}'
                    {
                    otherlv_21=(Token)match(input,25,FOLLOW_20); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_22=(Token)match(input,26,FOLLOW_18); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_11_1());
                    			
                    otherlv_23=(Token)match(input,24,FOLLOW_9); 

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

                        if ( (LA13_0==27) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalServiceDsl.g:497:5: otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_25=(Token)match(input,27,FOLLOW_9); 

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

                    otherlv_27=(Token)match(input,28,FOLLOW_19); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:526:3: (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==29) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalServiceDsl.g:527:4: otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}'
                    {
                    otherlv_28=(Token)match(input,25,FOLLOW_22); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_29=(Token)match(input,29,FOLLOW_18); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_12_1());
                    			
                    otherlv_30=(Token)match(input,24,FOLLOW_9); 

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

                        if ( (LA15_0==27) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalServiceDsl.g:559:5: otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_32=(Token)match(input,27,FOLLOW_9); 

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

                    otherlv_34=(Token)match(input,28,FOLLOW_19); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:588:3: (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==25) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalServiceDsl.g:589:4: otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}'
                    {
                    otherlv_35=(Token)match(input,25,FOLLOW_23); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getRequiredKeyword_13_0());
                    			
                    otherlv_36=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getOperationsKeyword_13_1());
                    			
                    otherlv_37=(Token)match(input,24,FOLLOW_9); 

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

                        if ( (LA17_0==27) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalServiceDsl.g:621:5: otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_39=(Token)match(input,27,FOLLOW_9); 

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

                    otherlv_41=(Token)match(input,28,FOLLOW_19); 

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

                if ( (LA19_0==16||(LA19_0>=35 && LA19_0<=36)||(LA19_0>=128 && LA19_0<=130)) ) {
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

            otherlv_43=(Token)match(input,28,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,16,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_9); 

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

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalServiceDsl.g:718:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,32,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,33,FOLLOW_29); 

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

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

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

                if ( (LA21_1==34) ) {
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

                    otherlv_1=(Token)match(input,34,FOLLOW_9); 

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

                if ( (LA22_1==34) ) {
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

                    otherlv_1=(Token)match(input,34,FOLLOW_9); 

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

                if ( (LA23_1==34) ) {
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

                    otherlv_1=(Token)match(input,34,FOLLOW_9); 

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

            if ( (LA25_0==16) ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>=69 && LA25_1<=70)) ) {
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

                    if ( (LA24_0==16) ) {
                        int LA24_1 = input.LA(2);

                        if ( ((LA24_1>=69 && LA24_1<=70)) ) {
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

            if ( (LA27_0==16) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==17) ) {
                    int LA27_3 = input.LA(3);

                    if ( (LA27_3==18) ) {
                        alt27=1;
                    }
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalServiceDsl.g:975:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_9); 

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

                    otherlv_6=(Token)match(input,19,FOLLOW_32); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1011:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==16) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==17) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalServiceDsl.g:1012:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,20,FOLLOW_9); 

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

                    otherlv_11=(Token)match(input,21,FOLLOW_32); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceAccess().getRightCurlyBracketRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1048:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==16) ) {
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

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalServiceDsl.g:1068:4: (lv_notImplemented_13_0= 'noimpl' )
                    {
                    // InternalServiceDsl.g:1068:4: (lv_notImplemented_13_0= 'noimpl' )
                    // InternalServiceDsl.g:1069:5: lv_notImplemented_13_0= 'noimpl'
                    {
                    lv_notImplemented_13_0=(Token)match(input,35,FOLLOW_33); 

                    					newLeafNode(lv_notImplemented_13_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1081:3: ( (lv_visibility_14_0= ruleVisibility ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=128 && LA32_0<=130)) ) {
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

            otherlv_15=(Token)match(input,36,FOLLOW_9); 

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

            if ( (LA33_0==23) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalServiceDsl.g:1123:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,23,FOLLOW_9); 

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

            otherlv_19=(Token)match(input,24,FOLLOW_35); 

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

                if ( (LA35_0==RULE_ID||LA35_0==16||LA35_0==35||LA35_0==37||(LA35_0>=128 && LA35_0<=130)) ) {
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

            otherlv_22=(Token)match(input,28,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,37,FOLLOW_37); 

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

                if ( ((LA36_0>=38 && LA36_0<=39)) ) {
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

            otherlv_3=(Token)match(input,37,FOLLOW_2); 

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

            if ( (LA37_0==38) ) {
                alt37=1;
            }
            else if ( (LA37_0==39) ) {
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
                    otherlv_0=(Token)match(input,38,FOLLOW_9); 

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
                    lv_required_1_0=(Token)match(input,39,FOLLOW_9); 

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

            if ( (LA38_0==37) ) {
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

            if ( (LA40_0==16) ) {
                int LA40_1 = input.LA(2);

                if ( ((LA40_1>=69 && LA40_1<=70)) ) {
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

                    if ( (LA39_0==16) ) {
                        int LA39_1 = input.LA(2);

                        if ( ((LA39_1>=69 && LA39_1<=70)) ) {
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

            if ( (LA42_0==16) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==17) ) {
                    int LA42_3 = input.LA(3);

                    if ( (LA42_3==18) ) {
                        alt42=1;
                    }
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalServiceDsl.g:1408:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,18,FOLLOW_9); 

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

                    otherlv_7=(Token)match(input,19,FOLLOW_39); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1444:3: (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==16) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==17) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalServiceDsl.g:1445:4: otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getCommercialAtKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getOperationAccess().getEndpointsKeyword_3_1());
                    			
                    otherlv_10=(Token)match(input,20,FOLLOW_9); 

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

                    otherlv_12=(Token)match(input,21,FOLLOW_39); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationAccess().getRightCurlyBracketRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1481:3: ( (lv_aspects_13_0= ruleImportedServiceAspect ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==16) ) {
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

            if ( (LA46_0==35) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalServiceDsl.g:1501:4: (lv_notImplemented_14_0= 'noimpl' )
                    {
                    // InternalServiceDsl.g:1501:4: (lv_notImplemented_14_0= 'noimpl' )
                    // InternalServiceDsl.g:1502:5: lv_notImplemented_14_0= 'noimpl'
                    {
                    lv_notImplemented_14_0=(Token)match(input,35,FOLLOW_40); 

                    					newLeafNode(lv_notImplemented_14_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:1514:3: ( (lv_visibility_15_0= ruleVisibility ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=128 && LA47_0<=130)) ) {
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

            otherlv_17=(Token)match(input,18,FOLLOW_41); 

            			newLeafNode(otherlv_17, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_8());
            		
            // InternalServiceDsl.g:1555:3: ( (lv_parameters_18_0= ruleParameter ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==16||(LA48_0>=69 && LA48_0<=70)) ) {
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

                if ( (LA49_0==27) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalServiceDsl.g:1575:4: otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) )
            	    {
            	    otherlv_19=(Token)match(input,27,FOLLOW_42); 

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

            otherlv_21=(Token)match(input,19,FOLLOW_43); 

            			newLeafNode(otherlv_21, grammarAccess.getOperationAccess().getRightParenthesisKeyword_11());
            		
            otherlv_22=(Token)match(input,40,FOLLOW_2); 

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

            if ( (LA51_0==16) ) {
                int LA51_1 = input.LA(2);

                if ( ((LA51_1>=69 && LA51_1<=70)) ) {
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

                    if ( (LA50_0==16) ) {
                        int LA50_1 = input.LA(2);

                        if ( ((LA50_1>=69 && LA50_1<=70)) ) {
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

            if ( (LA53_0==16) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==17) ) {
                    int LA53_3 = input.LA(3);

                    if ( (LA53_3==18) ) {
                        alt53=1;
                    }
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalServiceDsl.g:1667:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,18,FOLLOW_9); 

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

                    otherlv_6=(Token)match(input,19,FOLLOW_44); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1703:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==16) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==17) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalServiceDsl.g:1704:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,17,FOLLOW_14); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,20,FOLLOW_9); 

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

                    otherlv_11=(Token)match(input,21,FOLLOW_44); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationAccess().getRightCurlyBracketRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:1740:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==16) ) {
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

            otherlv_13=(Token)match(input,41,FOLLOW_9); 

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

            otherlv_15=(Token)match(input,40,FOLLOW_2); 

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

                if ( (LA57_0==16) ) {
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

            if ( ((LA58_0>=66 && LA58_0<=68)) ) {
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

            if ( (LA59_0==42) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalServiceDsl.g:1860:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalServiceDsl.g:1860:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalServiceDsl.g:1861:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,42,FOLLOW_9); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

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

            if ( (LA60_0==43) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalServiceDsl.g:1892:4: (lv_optional_5_0= '?' )
                    {
                    // InternalServiceDsl.g:1892:4: (lv_optional_5_0= '?' )
                    // InternalServiceDsl.g:1893:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,43,FOLLOW_48); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,44,FOLLOW_49); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalServiceDsl.g:1909:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=118 && LA61_0<=127)||LA61_0==134) ) {
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

            if ( (LA62_0==33) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalServiceDsl.g:1951:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,33,FOLLOW_9); 

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

            otherlv_1=(Token)match(input,34,FOLLOW_9); 

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
            otherlv_0=(Token)match(input,16,FOLLOW_42); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_9); 

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

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

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

            otherlv_1=(Token)match(input,34,FOLLOW_9); 

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

            if ( (LA63_0==18) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalServiceDsl.g:2149:4: otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_7); 

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

                    otherlv_5=(Token)match(input,19,FOLLOW_2); 

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

                if ( (LA64_0==27) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalServiceDsl.g:2210:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FOLLOW_9); 

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

            otherlv_3=(Token)match(input,44,FOLLOW_7); 

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

                if ( (LA65_0==27) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalServiceDsl.g:2257:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,27,FOLLOW_7); 

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

            otherlv_7=(Token)match(input,40,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,34,FOLLOW_9); 

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

            if ( (LA68_0==18) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalServiceDsl.g:2341:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_54); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalServiceDsl.g:2345:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_STRING||(LA67_0>=RULE_BOOLEAN && LA67_0<=RULE_BIG_DECIMAL)) ) {
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

                                if ( (LA66_0==27) ) {
                                    alt66=1;
                                }


                                switch (alt66) {
                            	case 1 :
                            	    // InternalServiceDsl.g:2387:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,27,FOLLOW_54); 

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

                    otherlv_9=(Token)match(input,19,FOLLOW_2); 

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

                if ( (LA69_1==33) ) {
                    alt69=1;
                }
                else if ( (LA69_1==18) ) {
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

                    otherlv_1=(Token)match(input,33,FOLLOW_55); 

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

                    otherlv_4=(Token)match(input,18,FOLLOW_55); 

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

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

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
            		
            kw=(Token)match(input,45,FOLLOW_9); 

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
    // InternalServiceDsl.g:2570:1: ruleAnything returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+ ;
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
            // InternalServiceDsl.g:2576:2: ( (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+ )
            // InternalServiceDsl.g:2577:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+
            {
            // InternalServiceDsl.g:2577:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+
            int cnt70=0;
            loop70:
            do {
                int alt70=121;
                switch ( input.LA(1) ) {
                case 24:
                    {
                    alt70=1;
                    }
                    break;
                case 28:
                    {
                    alt70=2;
                    }
                    break;
                case 46:
                    {
                    alt70=3;
                    }
                    break;
                case 47:
                    {
                    alt70=4;
                    }
                    break;
                case 27:
                    {
                    alt70=5;
                    }
                    break;
                case 18:
                    {
                    alt70=6;
                    }
                    break;
                case 19:
                    {
                    alt70=7;
                    }
                    break;
                case 34:
                    {
                    alt70=8;
                    }
                    break;
                case 45:
                    {
                    alt70=9;
                    }
                    break;
                case 48:
                    {
                    alt70=10;
                    }
                    break;
                case 49:
                    {
                    alt70=11;
                    }
                    break;
                case 50:
                    {
                    alt70=12;
                    }
                    break;
                case 43:
                    {
                    alt70=13;
                    }
                    break;
                case 44:
                    {
                    alt70=14;
                    }
                    break;
                case 16:
                    {
                    alt70=15;
                    }
                    break;
                case 33:
                    {
                    alt70=16;
                    }
                    break;
                case 40:
                    {
                    alt70=17;
                    }
                    break;
                case 31:
                    {
                    alt70=18;
                    }
                    break;
                case 51:
                    {
                    alt70=19;
                    }
                    break;
                case 52:
                    {
                    alt70=20;
                    }
                    break;
                case 53:
                    {
                    alt70=21;
                    }
                    break;
                case 54:
                    {
                    alt70=22;
                    }
                    break;
                case 55:
                    {
                    alt70=23;
                    }
                    break;
                case 56:
                    {
                    alt70=24;
                    }
                    break;
                case 57:
                    {
                    alt70=25;
                    }
                    break;
                case 58:
                    {
                    alt70=26;
                    }
                    break;
                case 59:
                    {
                    alt70=27;
                    }
                    break;
                case 60:
                    {
                    alt70=28;
                    }
                    break;
                case 13:
                    {
                    alt70=29;
                    }
                    break;
                case 14:
                    {
                    alt70=30;
                    }
                    break;
                case 15:
                    {
                    alt70=31;
                    }
                    break;
                case 61:
                    {
                    alt70=32;
                    }
                    break;
                case 62:
                    {
                    alt70=33;
                    }
                    break;
                case 63:
                    {
                    alt70=34;
                    }
                    break;
                case 64:
                    {
                    alt70=35;
                    }
                    break;
                case 65:
                    {
                    alt70=36;
                    }
                    break;
                case 66:
                    {
                    alt70=37;
                    }
                    break;
                case 67:
                    {
                    alt70=38;
                    }
                    break;
                case 68:
                    {
                    alt70=39;
                    }
                    break;
                case 69:
                    {
                    alt70=40;
                    }
                    break;
                case 70:
                    {
                    alt70=41;
                    }
                    break;
                case 71:
                    {
                    alt70=42;
                    }
                    break;
                case 72:
                    {
                    alt70=43;
                    }
                    break;
                case 73:
                    {
                    alt70=44;
                    }
                    break;
                case 74:
                    {
                    alt70=45;
                    }
                    break;
                case 75:
                    {
                    alt70=46;
                    }
                    break;
                case 76:
                    {
                    alt70=47;
                    }
                    break;
                case 77:
                    {
                    alt70=48;
                    }
                    break;
                case 78:
                    {
                    alt70=49;
                    }
                    break;
                case 79:
                    {
                    alt70=50;
                    }
                    break;
                case 80:
                    {
                    alt70=51;
                    }
                    break;
                case 81:
                    {
                    alt70=52;
                    }
                    break;
                case 82:
                    {
                    alt70=53;
                    }
                    break;
                case 83:
                    {
                    alt70=54;
                    }
                    break;
                case 26:
                    {
                    alt70=55;
                    }
                    break;
                case 29:
                    {
                    alt70=56;
                    }
                    break;
                case 30:
                    {
                    alt70=57;
                    }
                    break;
                case 84:
                    {
                    alt70=58;
                    }
                    break;
                case 85:
                    {
                    alt70=59;
                    }
                    break;
                case 86:
                    {
                    alt70=60;
                    }
                    break;
                case 87:
                    {
                    alt70=61;
                    }
                    break;
                case 88:
                    {
                    alt70=62;
                    }
                    break;
                case 89:
                    {
                    alt70=63;
                    }
                    break;
                case 90:
                    {
                    alt70=64;
                    }
                    break;
                case 91:
                    {
                    alt70=65;
                    }
                    break;
                case 92:
                    {
                    alt70=66;
                    }
                    break;
                case 93:
                    {
                    alt70=67;
                    }
                    break;
                case 23:
                    {
                    alt70=68;
                    }
                    break;
                case 95:
                    {
                    alt70=69;
                    }
                    break;
                case 96:
                    {
                    alt70=70;
                    }
                    break;
                case 97:
                    {
                    alt70=71;
                    }
                    break;
                case 98:
                    {
                    alt70=72;
                    }
                    break;
                case 99:
                    {
                    alt70=73;
                    }
                    break;
                case 100:
                    {
                    alt70=74;
                    }
                    break;
                case 101:
                    {
                    alt70=75;
                    }
                    break;
                case 102:
                    {
                    alt70=76;
                    }
                    break;
                case 103:
                    {
                    alt70=77;
                    }
                    break;
                case 104:
                    {
                    alt70=78;
                    }
                    break;
                case 105:
                    {
                    alt70=79;
                    }
                    break;
                case 106:
                    {
                    alt70=80;
                    }
                    break;
                case 107:
                    {
                    alt70=81;
                    }
                    break;
                case 108:
                    {
                    alt70=82;
                    }
                    break;
                case 109:
                    {
                    alt70=83;
                    }
                    break;
                case 110:
                    {
                    alt70=84;
                    }
                    break;
                case 111:
                    {
                    alt70=85;
                    }
                    break;
                case 112:
                    {
                    alt70=86;
                    }
                    break;
                case 113:
                    {
                    alt70=87;
                    }
                    break;
                case 114:
                    {
                    alt70=88;
                    }
                    break;
                case 115:
                    {
                    alt70=89;
                    }
                    break;
                case 116:
                    {
                    alt70=90;
                    }
                    break;
                case 117:
                    {
                    alt70=91;
                    }
                    break;
                case 118:
                    {
                    alt70=92;
                    }
                    break;
                case 119:
                    {
                    alt70=93;
                    }
                    break;
                case 120:
                    {
                    alt70=94;
                    }
                    break;
                case 121:
                    {
                    alt70=95;
                    }
                    break;
                case 122:
                    {
                    alt70=96;
                    }
                    break;
                case 123:
                    {
                    alt70=97;
                    }
                    break;
                case 124:
                    {
                    alt70=98;
                    }
                    break;
                case 125:
                    {
                    alt70=99;
                    }
                    break;
                case 126:
                    {
                    alt70=100;
                    }
                    break;
                case 127:
                    {
                    alt70=101;
                    }
                    break;
                case 128:
                    {
                    alt70=102;
                    }
                    break;
                case 129:
                    {
                    alt70=103;
                    }
                    break;
                case 130:
                    {
                    alt70=104;
                    }
                    break;
                case 17:
                    {
                    alt70=105;
                    }
                    break;
                case 22:
                    {
                    alt70=106;
                    }
                    break;
                case 25:
                    {
                    alt70=107;
                    }
                    break;
                case 32:
                    {
                    alt70=108;
                    }
                    break;
                case 35:
                    {
                    alt70=109;
                    }
                    break;
                case 36:
                    {
                    alt70=110;
                    }
                    break;
                case 131:
                    {
                    alt70=111;
                    }
                    break;
                case 41:
                    {
                    alt70=112;
                    }
                    break;
                case 42:
                    {
                    alt70=113;
                    }
                    break;
                case 132:
                    {
                    alt70=114;
                    }
                    break;
                case 133:
                    {
                    alt70=115;
                    }
                    break;
                case RULE_BOOLEAN:
                    {
                    alt70=116;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt70=117;
                    }
                    break;
                case RULE_ID:
                    {
                    alt70=118;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt70=119;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt70=120;
                    }
                    break;

                }

                switch (alt70) {
            	case 1 :
            	    // InternalServiceDsl.g:2578:3: kw= '{'
            	    {
            	    kw=(Token)match(input,24,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftCurlyBracketKeyword_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalServiceDsl.g:2584:3: kw= '}'
            	    {
            	    kw=(Token)match(input,28,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightCurlyBracketKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalServiceDsl.g:2590:3: kw= '<'
            	    {
            	    kw=(Token)match(input,46,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignKeyword_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalServiceDsl.g:2596:3: kw= '>'
            	    {
            	    kw=(Token)match(input,47,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getGreaterThanSignKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalServiceDsl.g:2602:3: kw= ','
            	    {
            	    kw=(Token)match(input,27,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommaKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalServiceDsl.g:2608:3: kw= '('
            	    {
            	    kw=(Token)match(input,18,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftParenthesisKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalServiceDsl.g:2614:3: kw= ')'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightParenthesisKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalServiceDsl.g:2620:3: kw= '::'
            	    {
            	    kw=(Token)match(input,34,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonColonKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalServiceDsl.g:2626:3: kw= '.'
            	    {
            	    kw=(Token)match(input,45,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFullStopKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalServiceDsl.g:2632:3: kw= '-'
            	    {
            	    kw=(Token)match(input,48,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalServiceDsl.g:2638:3: kw= '--'
            	    {
            	    kw=(Token)match(input,49,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusHyphenMinusKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalServiceDsl.g:2644:3: kw= '/'
            	    {
            	    kw=(Token)match(input,50,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSolidusKeyword_11());
            	    		

            	    }
            	    break;
            	case 13 :
            	    // InternalServiceDsl.g:2650:3: kw= '?'
            	    {
            	    kw=(Token)match(input,43,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getQuestionMarkKeyword_12());
            	    		

            	    }
            	    break;
            	case 14 :
            	    // InternalServiceDsl.g:2656:3: kw= ':'
            	    {
            	    kw=(Token)match(input,44,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonKeyword_13());
            	    		

            	    }
            	    break;
            	case 15 :
            	    // InternalServiceDsl.g:2662:3: kw= '@'
            	    {
            	    kw=(Token)match(input,16,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommercialAtKeyword_14());
            	    		

            	    }
            	    break;
            	case 16 :
            	    // InternalServiceDsl.g:2668:3: kw= '='
            	    {
            	    kw=(Token)match(input,33,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEqualsSignKeyword_15());
            	    		

            	    }
            	    break;
            	case 17 :
            	    // InternalServiceDsl.g:2674:3: kw= ';'
            	    {
            	    kw=(Token)match(input,40,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSemicolonKeyword_16());
            	    		

            	    }
            	    break;
            	case 18 :
            	    // InternalServiceDsl.g:2680:3: kw= 'technology'
            	    {
            	    kw=(Token)match(input,31,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologyKeyword_17());
            	    		

            	    }
            	    break;
            	case 19 :
            	    // InternalServiceDsl.g:2686:3: kw= 'types'
            	    {
            	    kw=(Token)match(input,51,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypesKeyword_18());
            	    		

            	    }
            	    break;
            	case 20 :
            	    // InternalServiceDsl.g:2692:3: kw= 'compatibility'
            	    {
            	    kw=(Token)match(input,52,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCompatibilityKeyword_19());
            	    		

            	    }
            	    break;
            	case 21 :
            	    // InternalServiceDsl.g:2698:3: kw= 'matrix'
            	    {
            	    kw=(Token)match(input,53,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMatrixKeyword_20());
            	    		

            	    }
            	    break;
            	case 22 :
            	    // InternalServiceDsl.g:2704:3: kw= 'protocols'
            	    {
            	    kw=(Token)match(input,54,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolsKeyword_21());
            	    		

            	    }
            	    break;
            	case 23 :
            	    // InternalServiceDsl.g:2710:3: kw= 'service'
            	    {
            	    kw=(Token)match(input,55,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getServiceKeyword_22());
            	    		

            	    }
            	    break;
            	case 24 :
            	    // InternalServiceDsl.g:2716:3: kw= 'aspects'
            	    {
            	    kw=(Token)match(input,56,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectsKeyword_23());
            	    		

            	    }
            	    break;
            	case 25 :
            	    // InternalServiceDsl.g:2722:3: kw= 'deployment'
            	    {
            	    kw=(Token)match(input,57,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDeploymentKeyword_24());
            	    		

            	    }
            	    break;
            	case 26 :
            	    // InternalServiceDsl.g:2728:3: kw= 'technologies'
            	    {
            	    kw=(Token)match(input,58,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologiesKeyword_25());
            	    		

            	    }
            	    break;
            	case 27 :
            	    // InternalServiceDsl.g:2734:3: kw= 'infrastructure'
            	    {
            	    kw=(Token)match(input,59,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureKeyword_26());
            	    		

            	    }
            	    break;
            	case 28 :
            	    // InternalServiceDsl.g:2740:3: kw= 'operation'
            	    {
            	    kw=(Token)match(input,60,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationKeyword_27());
            	    		

            	    }
            	    break;
            	case 29 :
            	    // InternalServiceDsl.g:2746:3: kw= 'import'
            	    {
            	    kw=(Token)match(input,13,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImportKeyword_28());
            	    		

            	    }
            	    break;
            	case 30 :
            	    // InternalServiceDsl.g:2752:3: kw= 'from'
            	    {
            	    kw=(Token)match(input,14,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFromKeyword_29());
            	    		

            	    }
            	    break;
            	case 31 :
            	    // InternalServiceDsl.g:2758:3: kw= 'as'
            	    {
            	    kw=(Token)match(input,15,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsKeyword_30());
            	    		

            	    }
            	    break;
            	case 32 :
            	    // InternalServiceDsl.g:2764:3: kw= 'data'
            	    {
            	    kw=(Token)match(input,61,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDataKeyword_31());
            	    		

            	    }
            	    break;
            	case 33 :
            	    // InternalServiceDsl.g:2770:3: kw= 'formats'
            	    {
            	    kw=(Token)match(input,62,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatsKeyword_32());
            	    		

            	    }
            	    break;
            	case 34 :
            	    // InternalServiceDsl.g:2776:3: kw= 'default'
            	    {
            	    kw=(Token)match(input,63,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDefaultKeyword_33());
            	    		

            	    }
            	    break;
            	case 35 :
            	    // InternalServiceDsl.g:2782:3: kw= 'with'
            	    {
            	    kw=(Token)match(input,64,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getWithKeyword_34());
            	    		

            	    }
            	    break;
            	case 36 :
            	    // InternalServiceDsl.g:2788:3: kw= 'format'
            	    {
            	    kw=(Token)match(input,65,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatKeyword_35());
            	    		

            	    }
            	    break;
            	case 37 :
            	    // InternalServiceDsl.g:2794:3: kw= 'in'
            	    {
            	    kw=(Token)match(input,66,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInKeyword_36());
            	    		

            	    }
            	    break;
            	case 38 :
            	    // InternalServiceDsl.g:2800:3: kw= 'out'
            	    {
            	    kw=(Token)match(input,67,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOutKeyword_37());
            	    		

            	    }
            	    break;
            	case 39 :
            	    // InternalServiceDsl.g:2806:3: kw= 'inout'
            	    {
            	    kw=(Token)match(input,68,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInoutKeyword_38());
            	    		

            	    }
            	    break;
            	case 40 :
            	    // InternalServiceDsl.g:2812:3: kw= 'sync'
            	    {
            	    kw=(Token)match(input,69,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSyncKeyword_39());
            	    		

            	    }
            	    break;
            	case 41 :
            	    // InternalServiceDsl.g:2818:3: kw= 'async'
            	    {
            	    kw=(Token)match(input,70,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsyncKeyword_40());
            	    		

            	    }
            	    break;
            	case 42 :
            	    // InternalServiceDsl.g:2824:3: kw= 'primitive'
            	    {
            	    kw=(Token)match(input,71,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPrimitiveKeyword_41());
            	    		

            	    }
            	    break;
            	case 43 :
            	    // InternalServiceDsl.g:2830:3: kw= 'type'
            	    {
            	    kw=(Token)match(input,72,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypeKeyword_42());
            	    		

            	    }
            	    break;
            	case 44 :
            	    // InternalServiceDsl.g:2836:3: kw= 'based'
            	    {
            	    kw=(Token)match(input,73,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBasedKeyword_43());
            	    		

            	    }
            	    break;
            	case 45 :
            	    // InternalServiceDsl.g:2842:3: kw= 'on'
            	    {
            	    kw=(Token)match(input,74,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOnKeyword_44());
            	    		

            	    }
            	    break;
            	case 46 :
            	    // InternalServiceDsl.g:2848:3: kw= 'list'
            	    {
            	    kw=(Token)match(input,75,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getListKeyword_45());
            	    		

            	    }
            	    break;
            	case 47 :
            	    // InternalServiceDsl.g:2854:3: kw= 'structure'
            	    {
            	    kw=(Token)match(input,76,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStructureKeyword_46());
            	    		

            	    }
            	    break;
            	case 48 :
            	    // InternalServiceDsl.g:2860:3: kw= '->'
            	    {
            	    kw=(Token)match(input,77,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusGreaterThanSignKeyword_47());
            	    		

            	    }
            	    break;
            	case 49 :
            	    // InternalServiceDsl.g:2866:3: kw= '<-'
            	    {
            	    kw=(Token)match(input,78,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusKeyword_48());
            	    		

            	    }
            	    break;
            	case 50 :
            	    // InternalServiceDsl.g:2872:3: kw= '<->'
            	    {
            	    kw=(Token)match(input,79,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_49());
            	    		

            	    }
            	    break;
            	case 51 :
            	    // InternalServiceDsl.g:2878:3: kw= 'environments'
            	    {
            	    kw=(Token)match(input,80,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnvironmentsKeyword_50());
            	    		

            	    }
            	    break;
            	case 52 :
            	    // InternalServiceDsl.g:2884:3: kw= 'properties'
            	    {
            	    kw=(Token)match(input,81,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPropertiesKeyword_51());
            	    		

            	    }
            	    break;
            	case 53 :
            	    // InternalServiceDsl.g:2890:3: kw= 'mandatory'
            	    {
            	    kw=(Token)match(input,82,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMandatoryKeyword_52());
            	    		

            	    }
            	    break;
            	case 54 :
            	    // InternalServiceDsl.g:2896:3: kw= 'singleval'
            	    {
            	    kw=(Token)match(input,83,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSinglevalKeyword_53());
            	    		

            	    }
            	    break;
            	case 55 :
            	    // InternalServiceDsl.g:2902:3: kw= 'microservices'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroservicesKeyword_54());
            	    		

            	    }
            	    break;
            	case 56 :
            	    // InternalServiceDsl.g:2908:3: kw= 'interfaces'
            	    {
            	    kw=(Token)match(input,29,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfacesKeyword_55());
            	    		

            	    }
            	    break;
            	case 57 :
            	    // InternalServiceDsl.g:2914:3: kw= 'operations'
            	    {
            	    kw=(Token)match(input,30,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationsKeyword_56());
            	    		

            	    }
            	    break;
            	case 58 :
            	    // InternalServiceDsl.g:2920:3: kw= 'parameters'
            	    {
            	    kw=(Token)match(input,84,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParametersKeyword_57());
            	    		

            	    }
            	    break;
            	case 59 :
            	    // InternalServiceDsl.g:2926:3: kw= 'fields'
            	    {
            	    kw=(Token)match(input,85,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFieldsKeyword_58());
            	    		

            	    }
            	    break;
            	case 60 :
            	    // InternalServiceDsl.g:2932:3: kw= 'exchange_pattern'
            	    {
            	    kw=(Token)match(input,86,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExchange_patternKeyword_59());
            	    		

            	    }
            	    break;
            	case 61 :
            	    // InternalServiceDsl.g:2938:3: kw= 'communication_type'
            	    {
            	    kw=(Token)match(input,87,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommunication_typeKeyword_60());
            	    		

            	    }
            	    break;
            	case 62 :
            	    // InternalServiceDsl.g:2944:3: kw= 'protocol'
            	    {
            	    kw=(Token)match(input,88,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolKeyword_61());
            	    		

            	    }
            	    break;
            	case 63 :
            	    // InternalServiceDsl.g:2950:3: kw= 'data_format'
            	    {
            	    kw=(Token)match(input,89,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getData_formatKeyword_62());
            	    		

            	    }
            	    break;
            	case 64 :
            	    // InternalServiceDsl.g:2956:3: kw= 'aspect'
            	    {
            	    kw=(Token)match(input,90,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectKeyword_63());
            	    		

            	    }
            	    break;
            	case 65 :
            	    // InternalServiceDsl.g:2962:3: kw= 'for'
            	    {
            	    kw=(Token)match(input,91,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getForKeyword_64());
            	    		

            	    }
            	    break;
            	case 66 :
            	    // InternalServiceDsl.g:2968:3: kw= 'containers'
            	    {
            	    kw=(Token)match(input,92,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContainersKeyword_65());
            	    		

            	    }
            	    break;
            	case 67 :
            	    // InternalServiceDsl.g:2974:3: (kw= 'selector' kw= 'datatypes' )
            	    {
            	    // InternalServiceDsl.g:2974:3: (kw= 'selector' kw= 'datatypes' )
            	    // InternalServiceDsl.g:2975:4: kw= 'selector' kw= 'datatypes'
            	    {
            	    kw=(Token)match(input,93,FOLLOW_58); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getSelectorKeyword_66_0());
            	    			
            	    kw=(Token)match(input,94,FOLLOW_57); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getDatatypesKeyword_66_1());
            	    			

            	    }


            	    }
            	    break;
            	case 68 :
            	    // InternalServiceDsl.g:2987:3: kw= 'version'
            	    {
            	    kw=(Token)match(input,23,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getVersionKeyword_67());
            	    		

            	    }
            	    break;
            	case 69 :
            	    // InternalServiceDsl.g:2993:3: kw= 'context'
            	    {
            	    kw=(Token)match(input,95,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContextKeyword_68());
            	    		

            	    }
            	    break;
            	case 70 :
            	    // InternalServiceDsl.g:2999:3: kw= 'aggregate'
            	    {
            	    kw=(Token)match(input,96,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAggregateKeyword_69());
            	    		

            	    }
            	    break;
            	case 71 :
            	    // InternalServiceDsl.g:3005:3: kw= 'applicationService'
            	    {
            	    kw=(Token)match(input,97,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getApplicationServiceKeyword_70());
            	    		

            	    }
            	    break;
            	case 72 :
            	    // InternalServiceDsl.g:3011:3: kw= 'domainEvent'
            	    {
            	    kw=(Token)match(input,98,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainEventKeyword_71());
            	    		

            	    }
            	    break;
            	case 73 :
            	    // InternalServiceDsl.g:3017:3: kw= 'domainService'
            	    {
            	    kw=(Token)match(input,99,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainServiceKeyword_72());
            	    		

            	    }
            	    break;
            	case 74 :
            	    // InternalServiceDsl.g:3023:3: kw= 'entity'
            	    {
            	    kw=(Token)match(input,100,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEntityKeyword_73());
            	    		

            	    }
            	    break;
            	case 75 :
            	    // InternalServiceDsl.g:3029:3: kw= 'factory'
            	    {
            	    kw=(Token)match(input,101,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFactoryKeyword_74());
            	    		

            	    }
            	    break;
            	case 76 :
            	    // InternalServiceDsl.g:3035:3: kw= 'infrastructureService'
            	    {
            	    kw=(Token)match(input,102,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureServiceKeyword_75());
            	    		

            	    }
            	    break;
            	case 77 :
            	    // InternalServiceDsl.g:3041:3: kw= 'repository'
            	    {
            	    kw=(Token)match(input,103,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRepositoryKeyword_76());
            	    		

            	    }
            	    break;
            	case 78 :
            	    // InternalServiceDsl.g:3047:3: kw= 'specification'
            	    {
            	    kw=(Token)match(input,104,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSpecificationKeyword_77());
            	    		

            	    }
            	    break;
            	case 79 :
            	    // InternalServiceDsl.g:3053:3: kw= 'valueObject'
            	    {
            	    kw=(Token)match(input,105,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValueObjectKeyword_78());
            	    		

            	    }
            	    break;
            	case 80 :
            	    // InternalServiceDsl.g:3059:3: kw= 'extends'
            	    {
            	    kw=(Token)match(input,106,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExtendsKeyword_79());
            	    		

            	    }
            	    break;
            	case 81 :
            	    // InternalServiceDsl.g:3065:3: kw= 'identifier'
            	    {
            	    kw=(Token)match(input,107,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIdentifierKeyword_80());
            	    		

            	    }
            	    break;
            	case 82 :
            	    // InternalServiceDsl.g:3071:3: kw= 'neverEmpty'
            	    {
            	    kw=(Token)match(input,108,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNeverEmptyKeyword_81());
            	    		

            	    }
            	    break;
            	case 83 :
            	    // InternalServiceDsl.g:3077:3: kw= 'part'
            	    {
            	    kw=(Token)match(input,109,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPartKeyword_82());
            	    		

            	    }
            	    break;
            	case 84 :
            	    // InternalServiceDsl.g:3083:3: kw= 'hide'
            	    {
            	    kw=(Token)match(input,110,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHideKeyword_83());
            	    		

            	    }
            	    break;
            	case 85 :
            	    // InternalServiceDsl.g:3089:3: kw= 'immutable'
            	    {
            	    kw=(Token)match(input,111,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImmutableKeyword_84());
            	    		

            	    }
            	    break;
            	case 86 :
            	    // InternalServiceDsl.g:3095:3: kw= 'enum'
            	    {
            	    kw=(Token)match(input,112,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnumKeyword_85());
            	    		

            	    }
            	    break;
            	case 87 :
            	    // InternalServiceDsl.g:3101:3: kw= 'closure'
            	    {
            	    kw=(Token)match(input,113,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getClosureKeyword_86());
            	    		

            	    }
            	    break;
            	case 88 :
            	    // InternalServiceDsl.g:3107:3: kw= 'sideEffectFree'
            	    {
            	    kw=(Token)match(input,114,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSideEffectFreeKeyword_87());
            	    		

            	    }
            	    break;
            	case 89 :
            	    // InternalServiceDsl.g:3113:3: kw= 'validator'
            	    {
            	    kw=(Token)match(input,115,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValidatorKeyword_88());
            	    		

            	    }
            	    break;
            	case 90 :
            	    // InternalServiceDsl.g:3119:3: kw= 'function'
            	    {
            	    kw=(Token)match(input,116,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionKeyword_89());
            	    		

            	    }
            	    break;
            	case 91 :
            	    // InternalServiceDsl.g:3125:3: kw= 'procedure'
            	    {
            	    kw=(Token)match(input,117,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProcedureKeyword_90());
            	    		

            	    }
            	    break;
            	case 92 :
            	    // InternalServiceDsl.g:3131:3: kw= 'boolean'
            	    {
            	    kw=(Token)match(input,118,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBooleanKeyword_91());
            	    		

            	    }
            	    break;
            	case 93 :
            	    // InternalServiceDsl.g:3137:3: kw= 'byte'
            	    {
            	    kw=(Token)match(input,119,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getByteKeyword_92());
            	    		

            	    }
            	    break;
            	case 94 :
            	    // InternalServiceDsl.g:3143:3: kw= 'char'
            	    {
            	    kw=(Token)match(input,120,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCharKeyword_93());
            	    		

            	    }
            	    break;
            	case 95 :
            	    // InternalServiceDsl.g:3149:3: kw= 'date'
            	    {
            	    kw=(Token)match(input,121,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDateKeyword_94());
            	    		

            	    }
            	    break;
            	case 96 :
            	    // InternalServiceDsl.g:3155:3: kw= 'double'
            	    {
            	    kw=(Token)match(input,122,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDoubleKeyword_95());
            	    		

            	    }
            	    break;
            	case 97 :
            	    // InternalServiceDsl.g:3161:3: kw= 'float'
            	    {
            	    kw=(Token)match(input,123,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFloatKeyword_96());
            	    		

            	    }
            	    break;
            	case 98 :
            	    // InternalServiceDsl.g:3167:3: kw= 'int'
            	    {
            	    kw=(Token)match(input,124,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIntKeyword_97());
            	    		

            	    }
            	    break;
            	case 99 :
            	    // InternalServiceDsl.g:3173:3: kw= 'long'
            	    {
            	    kw=(Token)match(input,125,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLongKeyword_98());
            	    		

            	    }
            	    break;
            	case 100 :
            	    // InternalServiceDsl.g:3179:3: kw= 'short'
            	    {
            	    kw=(Token)match(input,126,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getShortKeyword_99());
            	    		

            	    }
            	    break;
            	case 101 :
            	    // InternalServiceDsl.g:3185:3: kw= 'string'
            	    {
            	    kw=(Token)match(input,127,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStringKeyword_100());
            	    		

            	    }
            	    break;
            	case 102 :
            	    // InternalServiceDsl.g:3191:3: kw= 'internal'
            	    {
            	    kw=(Token)match(input,128,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInternalKeyword_101());
            	    		

            	    }
            	    break;
            	case 103 :
            	    // InternalServiceDsl.g:3197:3: kw= 'architecture'
            	    {
            	    kw=(Token)match(input,129,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getArchitectureKeyword_102());
            	    		

            	    }
            	    break;
            	case 104 :
            	    // InternalServiceDsl.g:3203:3: kw= 'public'
            	    {
            	    kw=(Token)match(input,130,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPublicKeyword_103());
            	    		

            	    }
            	    break;
            	case 105 :
            	    // InternalServiceDsl.g:3209:3: kw= 'endpoints'
            	    {
            	    kw=(Token)match(input,17,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEndpointsKeyword_104());
            	    		

            	    }
            	    break;
            	case 106 :
            	    // InternalServiceDsl.g:3215:3: kw= 'microservice'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroserviceKeyword_105());
            	    		

            	    }
            	    break;
            	case 107 :
            	    // InternalServiceDsl.g:3221:3: kw= 'required'
            	    {
            	    kw=(Token)match(input,25,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRequiredKeyword_106());
            	    		

            	    }
            	    break;
            	case 108 :
            	    // InternalServiceDsl.g:3227:3: kw= 'typedef'
            	    {
            	    kw=(Token)match(input,32,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypedefKeyword_107());
            	    		

            	    }
            	    break;
            	case 109 :
            	    // InternalServiceDsl.g:3233:3: kw= 'noimpl'
            	    {
            	    kw=(Token)match(input,35,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNoimplKeyword_108());
            	    		

            	    }
            	    break;
            	case 110 :
            	    // InternalServiceDsl.g:3239:3: kw= 'interface'
            	    {
            	    kw=(Token)match(input,36,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfaceKeyword_109());
            	    		

            	    }
            	    break;
            	case 111 :
            	    // InternalServiceDsl.g:3245:3: kw= 'param'
            	    {
            	    kw=(Token)match(input,131,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParamKeyword_110());
            	    		

            	    }
            	    break;
            	case 112 :
            	    // InternalServiceDsl.g:3251:3: kw= 'refers'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRefersKeyword_111());
            	    		

            	    }
            	    break;
            	case 113 :
            	    // InternalServiceDsl.g:3257:3: kw= 'fault'
            	    {
            	    kw=(Token)match(input,42,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFaultKeyword_112());
            	    		

            	    }
            	    break;
            	case 114 :
            	    // InternalServiceDsl.g:3263:3: kw= 'functional'
            	    {
            	    kw=(Token)match(input,132,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionalKeyword_113());
            	    		

            	    }
            	    break;
            	case 115 :
            	    // InternalServiceDsl.g:3269:3: kw= 'utility'
            	    {
            	    kw=(Token)match(input,133,FOLLOW_57); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getUtilityKeyword_114());
            	    		

            	    }
            	    break;
            	case 116 :
            	    // InternalServiceDsl.g:3275:3: this_BOOLEAN_116= RULE_BOOLEAN
            	    {
            	    this_BOOLEAN_116=(Token)match(input,RULE_BOOLEAN,FOLLOW_57); 

            	    			current.merge(this_BOOLEAN_116);
            	    		

            	    			newLeafNode(this_BOOLEAN_116, grammarAccess.getAnythingAccess().getBOOLEANTerminalRuleCall_115());
            	    		

            	    }
            	    break;
            	case 117 :
            	    // InternalServiceDsl.g:3283:3: this_BIG_DECIMAL_117= RULE_BIG_DECIMAL
            	    {
            	    this_BIG_DECIMAL_117=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_57); 

            	    			current.merge(this_BIG_DECIMAL_117);
            	    		

            	    			newLeafNode(this_BIG_DECIMAL_117, grammarAccess.getAnythingAccess().getBIG_DECIMALTerminalRuleCall_116());
            	    		

            	    }
            	    break;
            	case 118 :
            	    // InternalServiceDsl.g:3291:3: this_ID_118= RULE_ID
            	    {
            	    this_ID_118=(Token)match(input,RULE_ID,FOLLOW_57); 

            	    			current.merge(this_ID_118);
            	    		

            	    			newLeafNode(this_ID_118, grammarAccess.getAnythingAccess().getIDTerminalRuleCall_117());
            	    		

            	    }
            	    break;
            	case 119 :
            	    // InternalServiceDsl.g:3299:3: this_STRING_119= RULE_STRING
            	    {
            	    this_STRING_119=(Token)match(input,RULE_STRING,FOLLOW_57); 

            	    			current.merge(this_STRING_119);
            	    		

            	    			newLeafNode(this_STRING_119, grammarAccess.getAnythingAccess().getSTRINGTerminalRuleCall_118());
            	    		

            	    }
            	    break;
            	case 120 :
            	    // InternalServiceDsl.g:3307:3: this_ANY_OTHER_120= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_120=(Token)match(input,RULE_ANY_OTHER,FOLLOW_57); 

            	    			current.merge(this_ANY_OTHER_120);
            	    		

            	    			newLeafNode(this_ANY_OTHER_120, grammarAccess.getAnythingAccess().getANY_OTHERTerminalRuleCall_119());
            	    		

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
    // InternalServiceDsl.g:3318:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalServiceDsl.g:3318:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalServiceDsl.g:3319:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalServiceDsl.g:3325:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalServiceDsl.g:3331:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:3332:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:3332:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalServiceDsl.g:3333:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalServiceDsl.g:3345:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalServiceDsl.g:3346:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalServiceDsl.g:3346:4: (lv_importURI_3_0= RULE_STRING )
            // InternalServiceDsl.g:3347:5: lv_importURI_3_0= RULE_STRING
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

            otherlv_4=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalServiceDsl.g:3367:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:3368:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:3368:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:3369:5: lv_name_5_0= RULE_ID
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
    // InternalServiceDsl.g:3389:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalServiceDsl.g:3389:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalServiceDsl.g:3390:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalServiceDsl.g:3396:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) ;
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
            // InternalServiceDsl.g:3402:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // InternalServiceDsl.g:3403:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // InternalServiceDsl.g:3403:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            // InternalServiceDsl.g:3404:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // InternalServiceDsl.g:3404:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalServiceDsl.g:3405:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalServiceDsl.g:3405:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalServiceDsl.g:3406:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalServiceDsl.g:3423:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:3424:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:3424:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:3425:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,61,FOLLOW_60); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,62,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalServiceDsl.g:3449:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalServiceDsl.g:3450:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalServiceDsl.g:3450:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalServiceDsl.g:3451:5: lv_dataFormats_4_0= ruleDataFormat
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

            // InternalServiceDsl.g:3468:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalServiceDsl.g:3469:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:3473:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalServiceDsl.g:3474:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalServiceDsl.g:3474:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalServiceDsl.g:3475:6: lv_dataFormats_6_0= ruleDataFormat
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

            // InternalServiceDsl.g:3493:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==63) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalServiceDsl.g:3494:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) )
                    {
                    // InternalServiceDsl.g:3494:4: ( (lv_default_7_0= 'default' ) )
                    // InternalServiceDsl.g:3495:5: (lv_default_7_0= 'default' )
                    {
                    // InternalServiceDsl.g:3495:5: (lv_default_7_0= 'default' )
                    // InternalServiceDsl.g:3496:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,63,FOLLOW_62); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,64,FOLLOW_63); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,65,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalServiceDsl.g:3516:4: ( (otherlv_10= RULE_STRING ) )
                    // InternalServiceDsl.g:3517:5: (otherlv_10= RULE_STRING )
                    {
                    // InternalServiceDsl.g:3517:5: (otherlv_10= RULE_STRING )
                    // InternalServiceDsl.g:3518:6: otherlv_10= RULE_STRING
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

            otherlv_11=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:3538:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalServiceDsl.g:3538:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalServiceDsl.g:3539:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalServiceDsl.g:3545:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_STRING ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3551:2: ( ( (lv_formatName_0_0= RULE_STRING ) ) )
            // InternalServiceDsl.g:3552:2: ( (lv_formatName_0_0= RULE_STRING ) )
            {
            // InternalServiceDsl.g:3552:2: ( (lv_formatName_0_0= RULE_STRING ) )
            // InternalServiceDsl.g:3553:3: (lv_formatName_0_0= RULE_STRING )
            {
            // InternalServiceDsl.g:3553:3: (lv_formatName_0_0= RULE_STRING )
            // InternalServiceDsl.g:3554:4: lv_formatName_0_0= RULE_STRING
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
    // InternalServiceDsl.g:3573:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalServiceDsl.g:3573:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalServiceDsl.g:3574:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalServiceDsl.g:3580:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalServiceDsl.g:3586:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalServiceDsl.g:3587:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalServiceDsl.g:3587:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalServiceDsl.g:3588:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,72,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalServiceDsl.g:3596:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalServiceDsl.g:3597:4: (lv_name_2_0= RULE_ID )
            {
            // InternalServiceDsl.g:3597:4: (lv_name_2_0= RULE_ID )
            // InternalServiceDsl.g:3598:5: lv_name_2_0= RULE_ID
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

            // InternalServiceDsl.g:3614:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==73) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalServiceDsl.g:3615:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,73,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,74,FOLLOW_67); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalServiceDsl.g:3623:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:3624:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:3624:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalServiceDsl.g:3625:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
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

                    // InternalServiceDsl.g:3642:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==27) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalServiceDsl.g:3643:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_67); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalServiceDsl.g:3647:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalServiceDsl.g:3648:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalServiceDsl.g:3648:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalServiceDsl.g:3649:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
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

                    // InternalServiceDsl.g:3667:4: ( (lv_default_8_0= 'default' ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==63) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalServiceDsl.g:3668:5: (lv_default_8_0= 'default' )
                            {
                            // InternalServiceDsl.g:3668:5: (lv_default_8_0= 'default' )
                            // InternalServiceDsl.g:3669:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,63,FOLLOW_43); 

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

            otherlv_9=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:3690:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalServiceDsl.g:3690:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalServiceDsl.g:3691:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalServiceDsl.g:3697:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3703:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalServiceDsl.g:3704:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalServiceDsl.g:3704:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalServiceDsl.g:3705:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,72,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalServiceDsl.g:3713:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalServiceDsl.g:3714:4: (lv_name_2_0= RULE_ID )
            {
            // InternalServiceDsl.g:3714:4: (lv_name_2_0= RULE_ID )
            // InternalServiceDsl.g:3715:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_43); 

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

            otherlv_3=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:3739:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalServiceDsl.g:3739:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalServiceDsl.g:3740:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalServiceDsl.g:3746:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3752:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalServiceDsl.g:3753:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalServiceDsl.g:3753:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalServiceDsl.g:3754:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,72,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalServiceDsl.g:3762:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalServiceDsl.g:3763:4: (lv_name_2_0= RULE_ID )
            {
            // InternalServiceDsl.g:3763:4: (lv_name_2_0= RULE_ID )
            // InternalServiceDsl.g:3764:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:3788:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalServiceDsl.g:3788:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalServiceDsl.g:3789:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalServiceDsl.g:3795:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:3801:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:3802:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:3802:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:3803:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:3803:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==34) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalServiceDsl.g:3804:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalServiceDsl.g:3804:4: ( (otherlv_0= RULE_ID ) )
                    // InternalServiceDsl.g:3805:5: (otherlv_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:3805:5: (otherlv_0= RULE_ID )
                    // InternalServiceDsl.g:3806:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,34,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:3822:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:3823:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:3823:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:3824:5: ruleQualifiedName
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
    // InternalServiceDsl.g:3842:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalServiceDsl.g:3842:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalServiceDsl.g:3843:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalServiceDsl.g:3849:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalServiceDsl.g:3855:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalServiceDsl.g:3856:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalServiceDsl.g:3856:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalServiceDsl.g:3857:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalServiceDsl.g:3857:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalServiceDsl.g:3858:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalServiceDsl.g:3858:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalServiceDsl.g:3859:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
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

            // InternalServiceDsl.g:3876:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==27) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalServiceDsl.g:3877:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FOLLOW_9); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalServiceDsl.g:3881:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalServiceDsl.g:3882:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalServiceDsl.g:3882:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalServiceDsl.g:3883:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
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
            	    break loop77;
                }
            } while (true);

            // InternalServiceDsl.g:3901:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalServiceDsl.g:3902:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalServiceDsl.g:3902:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalServiceDsl.g:3903:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalServiceDsl.g:3920:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalServiceDsl.g:3921:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalServiceDsl.g:3921:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalServiceDsl.g:3922:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
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

            otherlv_5=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:3947:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalServiceDsl.g:3947:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalServiceDsl.g:3948:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalServiceDsl.g:3954:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalServiceDsl.g:3960:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalServiceDsl.g:3961:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalServiceDsl.g:3961:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalServiceDsl.g:3962:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalServiceDsl.g:3962:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalServiceDsl.g:3963:4: (lv_name_0_0= RULE_ID )
            {
            // InternalServiceDsl.g:3963:4: (lv_name_0_0= RULE_ID )
            // InternalServiceDsl.g:3964:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,24,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,60,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,80,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalServiceDsl.g:3996:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalServiceDsl.g:3997:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalServiceDsl.g:3997:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalServiceDsl.g:3998:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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

            // InternalServiceDsl.g:4015:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==27) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalServiceDsl.g:4016:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalServiceDsl.g:4020:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalServiceDsl.g:4021:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalServiceDsl.g:4021:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalServiceDsl.g:4022:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    break loop78;
                }
            } while (true);

            otherlv_8=(Token)match(input,40,FOLLOW_71); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalServiceDsl.g:4044:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==55) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalServiceDsl.g:4045:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,55,FOLLOW_72); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,81,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,24,FOLLOW_67); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalServiceDsl.g:4057:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt79=0;
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( ((LA79_0>=118 && LA79_0<=127)||LA79_0==134) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4058:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:4058:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:4059:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
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
                    	    if ( cnt79 >= 1 ) break loop79;
                                EarlyExitException eee =
                                    new EarlyExitException(79, input);
                                throw eee;
                        }
                        cnt79++;
                    } while (true);

                    otherlv_13=(Token)match(input,28,FOLLOW_74); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:4089:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalServiceDsl.g:4089:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalServiceDsl.g:4090:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalServiceDsl.g:4096:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalServiceDsl.g:4102:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalServiceDsl.g:4103:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalServiceDsl.g:4103:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalServiceDsl.g:4104:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalServiceDsl.g:4104:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalServiceDsl.g:4105:4: (lv_name_0_0= RULE_ID )
            {
            // InternalServiceDsl.g:4105:4: (lv_name_0_0= RULE_ID )
            // InternalServiceDsl.g:4106:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,24,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,60,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,80,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalServiceDsl.g:4138:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalServiceDsl.g:4139:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalServiceDsl.g:4139:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalServiceDsl.g:4140:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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

            // InternalServiceDsl.g:4157:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==27) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalServiceDsl.g:4158:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalServiceDsl.g:4162:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalServiceDsl.g:4163:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalServiceDsl.g:4163:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalServiceDsl.g:4164:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    break loop81;
                }
            } while (true);

            otherlv_8=(Token)match(input,40,FOLLOW_71); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalServiceDsl.g:4186:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==55) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalServiceDsl.g:4187:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,55,FOLLOW_72); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,81,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,24,FOLLOW_67); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalServiceDsl.g:4199:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt82=0;
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( ((LA82_0>=118 && LA82_0<=127)||LA82_0==134) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4200:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:4200:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:4201:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
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
                    	    if ( cnt82 >= 1 ) break loop82;
                                EarlyExitException eee =
                                    new EarlyExitException(82, input);
                                throw eee;
                        }
                        cnt82++;
                    } while (true);

                    otherlv_13=(Token)match(input,28,FOLLOW_74); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:4231:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalServiceDsl.g:4231:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalServiceDsl.g:4232:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalServiceDsl.g:4238:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:4244:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalServiceDsl.g:4245:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalServiceDsl.g:4245:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalServiceDsl.g:4246:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalServiceDsl.g:4246:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalServiceDsl.g:4247:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalServiceDsl.g:4247:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalServiceDsl.g:4248:5: lv_environmentName_0_0= RULE_STRING
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

            // InternalServiceDsl.g:4264:3: ( (lv_default_1_0= 'default' ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==63) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalServiceDsl.g:4265:4: (lv_default_1_0= 'default' )
                    {
                    // InternalServiceDsl.g:4265:4: (lv_default_1_0= 'default' )
                    // InternalServiceDsl.g:4266:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,63,FOLLOW_2); 

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
    // InternalServiceDsl.g:4282:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalServiceDsl.g:4282:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalServiceDsl.g:4283:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalServiceDsl.g:4289:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalServiceDsl.g:4295:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalServiceDsl.g:4296:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalServiceDsl.g:4296:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalServiceDsl.g:4297:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalServiceDsl.g:4297:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalServiceDsl.g:4298:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalServiceDsl.g:4298:4: (lv_type_0_0= rulePrimitiveType )
            // InternalServiceDsl.g:4299:5: lv_type_0_0= rulePrimitiveType
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

            // InternalServiceDsl.g:4316:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:4317:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:4317:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:4318:5: lv_name_1_0= RULE_ID
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

            // InternalServiceDsl.g:4334:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==33) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalServiceDsl.g:4335:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:4339:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:4340:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:4340:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:4341:6: lv_defaultValue_3_0= rulePrimitiveValue
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

            // InternalServiceDsl.g:4359:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==46) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalServiceDsl.g:4360:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_78); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalServiceDsl.g:4364:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalServiceDsl.g:4365:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalServiceDsl.g:4365:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalServiceDsl.g:4366:6: lv_features_5_0= rulePropertyFeature
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

                    // InternalServiceDsl.g:4383:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==27) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4384:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_78); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalServiceDsl.g:4388:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalServiceDsl.g:4389:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalServiceDsl.g:4389:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalServiceDsl.g:4390:7: lv_features_7_0= rulePropertyFeature
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
                    	    break loop86;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,47,FOLLOW_43); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificPropertyAccess().getGreaterThanSignKeyword_3_3());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:4421:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalServiceDsl.g:4421:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalServiceDsl.g:4422:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalServiceDsl.g:4428:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) ;
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
            // InternalServiceDsl.g:4434:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) )
            // InternalServiceDsl.g:4435:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            {
            // InternalServiceDsl.g:4435:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            int alt88=4;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt88=1;
                }
                break;
            case 87:
                {
                alt88=2;
                }
                break;
            case 88:
                {
                alt88=3;
                }
                break;
            case 89:
                {
                alt88=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalServiceDsl.g:4436:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalServiceDsl.g:4436:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalServiceDsl.g:4437:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalServiceDsl.g:4437:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalServiceDsl.g:4438:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalServiceDsl.g:4438:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalServiceDsl.g:4439:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,86,FOLLOW_28); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_80); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalServiceDsl.g:4455:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalServiceDsl.g:4456:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalServiceDsl.g:4456:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalServiceDsl.g:4457:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalServiceDsl.g:4476:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalServiceDsl.g:4476:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalServiceDsl.g:4477:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalServiceDsl.g:4477:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalServiceDsl.g:4478:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalServiceDsl.g:4478:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalServiceDsl.g:4479:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,87,FOLLOW_28); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,33,FOLLOW_42); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalServiceDsl.g:4495:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalServiceDsl.g:4496:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalServiceDsl.g:4496:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalServiceDsl.g:4497:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalServiceDsl.g:4516:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalServiceDsl.g:4516:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalServiceDsl.g:4517:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalServiceDsl.g:4517:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalServiceDsl.g:4518:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalServiceDsl.g:4518:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalServiceDsl.g:4519:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,88,FOLLOW_28); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,33,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalServiceDsl.g:4535:4: ( (otherlv_8= RULE_ID ) )
                    // InternalServiceDsl.g:4536:5: (otherlv_8= RULE_ID )
                    {
                    // InternalServiceDsl.g:4536:5: (otherlv_8= RULE_ID )
                    // InternalServiceDsl.g:4537:6: otherlv_8= RULE_ID
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
                    // InternalServiceDsl.g:4550:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    {
                    // InternalServiceDsl.g:4550:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    // InternalServiceDsl.g:4551:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) )
                    {
                    // InternalServiceDsl.g:4551:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalServiceDsl.g:4552:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalServiceDsl.g:4552:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalServiceDsl.g:4553:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,89,FOLLOW_28); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,33,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalServiceDsl.g:4569:4: ( (otherlv_11= RULE_STRING ) )
                    // InternalServiceDsl.g:4570:5: (otherlv_11= RULE_STRING )
                    {
                    // InternalServiceDsl.g:4570:5: (otherlv_11= RULE_STRING )
                    // InternalServiceDsl.g:4571:6: otherlv_11= RULE_STRING
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
    // InternalServiceDsl.g:4587:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalServiceDsl.g:4587:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalServiceDsl.g:4588:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalServiceDsl.g:4594:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalServiceDsl.g:4600:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalServiceDsl.g:4601:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalServiceDsl.g:4601:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalServiceDsl.g:4602:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_81); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalServiceDsl.g:4610:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalServiceDsl.g:4611:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalServiceDsl.g:4611:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalServiceDsl.g:4612:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
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

            // InternalServiceDsl.g:4629:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==27) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalServiceDsl.g:4630:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,27,FOLLOW_81); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalServiceDsl.g:4634:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalServiceDsl.g:4635:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalServiceDsl.g:4635:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalServiceDsl.g:4636:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
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
            	    break loop89;
                }
            } while (true);

            otherlv_5=(Token)match(input,19,FOLLOW_43); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:4666:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalServiceDsl.g:4666:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalServiceDsl.g:4667:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalServiceDsl.g:4673:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalServiceDsl.g:4679:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalServiceDsl.g:4680:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalServiceDsl.g:4680:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalServiceDsl.g:4681:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,90,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalServiceDsl.g:4685:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:4686:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:4686:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:4687:5: lv_name_1_0= RULE_ID
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

            // InternalServiceDsl.g:4703:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==46) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalServiceDsl.g:4704:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_83); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:4708:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalServiceDsl.g:4709:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalServiceDsl.g:4709:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalServiceDsl.g:4710:6: lv_features_3_0= ruleAspectFeature
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

                    // InternalServiceDsl.g:4727:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==27) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4728:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_83); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:4732:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalServiceDsl.g:4733:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalServiceDsl.g:4733:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalServiceDsl.g:4734:7: lv_features_5_0= ruleAspectFeature
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
                    	    break loop90;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_84); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,91,FOLLOW_85); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceAspectAccess().getForKeyword_3());
            		
            // InternalServiceDsl.g:4761:3: ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) )
            // InternalServiceDsl.g:4762:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            {
            // InternalServiceDsl.g:4762:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            // InternalServiceDsl.g:4763:5: lv_joinPoints_8_0= ruleServiceJoinPointType
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

            // InternalServiceDsl.g:4780:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==27) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalServiceDsl.g:4781:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,27,FOLLOW_85); 

            	    				newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:4785:4: ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    // InternalServiceDsl.g:4786:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    {
            	    // InternalServiceDsl.g:4786:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    // InternalServiceDsl.g:4787:6: lv_joinPoints_10_0= ruleServiceJoinPointType
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
            	    break loop92;
                }
            } while (true);

            // InternalServiceDsl.g:4805:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==24) ) {
                alt95=1;
            }
            else if ( (LA95_0==40) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalServiceDsl.g:4806:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalServiceDsl.g:4806:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalServiceDsl.g:4807:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,24,FOLLOW_87); 

                    					newLeafNode(otherlv_11, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalServiceDsl.g:4811:5: ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==93) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4812:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalServiceDsl.g:4812:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    // InternalServiceDsl.g:4813:7: lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector
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
                    	    break loop93;
                        }
                    } while (true);

                    // InternalServiceDsl.g:4830:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( ((LA94_0>=118 && LA94_0<=127)||LA94_0==134) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalServiceDsl.g:4831:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:4831:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:4832:7: lv_properties_13_0= ruleTechnologySpecificProperty
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
                    	    break loop94;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:4855:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:4864:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalServiceDsl.g:4864:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalServiceDsl.g:4865:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalServiceDsl.g:4871:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:4877:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalServiceDsl.g:4878:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:4878:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalServiceDsl.g:4879:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalServiceDsl.g:4879:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalServiceDsl.g:4880:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalServiceDsl.g:4880:4: (lv_forTechnology_0_0= 'technology' )
            // InternalServiceDsl.g:4881:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,31,FOLLOW_28); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", true, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalServiceDsl.g:4897:3: ( (otherlv_2= RULE_ID ) )
            // InternalServiceDsl.g:4898:4: (otherlv_2= RULE_ID )
            {
            // InternalServiceDsl.g:4898:4: (otherlv_2= RULE_ID )
            // InternalServiceDsl.g:4899:5: otherlv_2= RULE_ID
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
    // InternalServiceDsl.g:4914:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalServiceDsl.g:4914:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalServiceDsl.g:4915:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalServiceDsl.g:4921:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalServiceDsl.g:4927:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalServiceDsl.g:4928:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalServiceDsl.g:4928:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalServiceDsl.g:4929:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalServiceDsl.g:4937:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalServiceDsl.g:4938:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalServiceDsl.g:4938:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalServiceDsl.g:4939:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
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

            // InternalServiceDsl.g:4956:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==27) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalServiceDsl.g:4957:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,27,FOLLOW_25); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalServiceDsl.g:4961:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalServiceDsl.g:4962:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalServiceDsl.g:4962:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalServiceDsl.g:4963:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
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
            	    break loop96;
                }
            } while (true);

            otherlv_5=(Token)match(input,19,FOLLOW_43); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:4993:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalServiceDsl.g:4993:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalServiceDsl.g:4994:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalServiceDsl.g:5000:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalServiceDsl.g:5006:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalServiceDsl.g:5007:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalServiceDsl.g:5007:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalServiceDsl.g:5008:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,90,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalServiceDsl.g:5012:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5013:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5013:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5014:5: lv_name_1_0= RULE_ID
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

            // InternalServiceDsl.g:5030:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==46) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalServiceDsl.g:5031:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_83); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:5035:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalServiceDsl.g:5036:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalServiceDsl.g:5036:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalServiceDsl.g:5037:6: lv_features_3_0= ruleAspectFeature
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

                    // InternalServiceDsl.g:5054:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==27) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5055:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_83); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:5059:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalServiceDsl.g:5060:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalServiceDsl.g:5060:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalServiceDsl.g:5061:7: lv_features_5_0= ruleAspectFeature
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
                    	    break loop97;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_84); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,91,FOLLOW_88); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAspectAccess().getForKeyword_3());
            		
            // InternalServiceDsl.g:5088:3: ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) )
            // InternalServiceDsl.g:5089:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            {
            // InternalServiceDsl.g:5089:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            // InternalServiceDsl.g:5090:5: lv_joinPoints_8_0= ruleOperationJoinPointType
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

            // InternalServiceDsl.g:5107:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==27) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalServiceDsl.g:5108:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,27,FOLLOW_88); 

            	    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:5112:4: ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    // InternalServiceDsl.g:5113:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    {
            	    // InternalServiceDsl.g:5113:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    // InternalServiceDsl.g:5114:6: lv_joinPoints_10_0= ruleOperationJoinPointType
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
            	    break loop99;
                }
            } while (true);

            // InternalServiceDsl.g:5132:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==24) ) {
                alt102=1;
            }
            else if ( (LA102_0==40) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalServiceDsl.g:5133:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalServiceDsl.g:5133:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalServiceDsl.g:5134:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,24,FOLLOW_87); 

                    					newLeafNode(otherlv_11, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalServiceDsl.g:5138:5: ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==93) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5139:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalServiceDsl.g:5139:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    // InternalServiceDsl.g:5140:7: lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector
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
                    	    break loop100;
                        }
                    } while (true);

                    // InternalServiceDsl.g:5157:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( ((LA101_0>=118 && LA101_0<=127)||LA101_0==134) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5158:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalServiceDsl.g:5158:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalServiceDsl.g:5159:7: lv_properties_13_0= ruleTechnologySpecificProperty
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
                    	    break loop101;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:5182:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,40,FOLLOW_2); 

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
    // InternalServiceDsl.g:5191:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalServiceDsl.g:5191:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalServiceDsl.g:5192:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalServiceDsl.g:5198:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalServiceDsl.g:5204:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:5205:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:5205:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalServiceDsl.g:5206:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_58); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,94,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalServiceDsl.g:5218:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalServiceDsl.g:5219:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalServiceDsl.g:5219:4: (lv_importURI_3_0= RULE_STRING )
            // InternalServiceDsl.g:5220:5: lv_importURI_3_0= RULE_STRING
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

            otherlv_4=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalServiceDsl.g:5240:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:5241:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:5241:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:5242:5: lv_name_5_0= RULE_ID
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
    // InternalServiceDsl.g:5262:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalServiceDsl.g:5262:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalServiceDsl.g:5263:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalServiceDsl.g:5269:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalServiceDsl.g:5275:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalServiceDsl.g:5276:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalServiceDsl.g:5276:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalServiceDsl.g:5277:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalServiceDsl.g:5281:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5282:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5282:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5283:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,24,FOLLOW_89); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalServiceDsl.g:5303:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt105=3;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=75 && LA105_0<=76)||LA105_0==112) ) {
                alt105=1;
            }
            else if ( (LA105_0==95) ) {
                alt105=2;
            }
            switch (alt105) {
                case 1 :
                    // InternalServiceDsl.g:5304:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalServiceDsl.g:5304:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt103=0;
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( ((LA103_0>=75 && LA103_0<=76)||LA103_0==112) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5305:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalServiceDsl.g:5305:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalServiceDsl.g:5306:6: lv_complexTypes_3_0= ruleComplexType
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
                    	    if ( cnt103 >= 1 ) break loop103;
                                EarlyExitException eee =
                                    new EarlyExitException(103, input);
                                throw eee;
                        }
                        cnt103++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:5324:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalServiceDsl.g:5324:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt104=0;
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==95) ) {
                            alt104=1;
                        }


                        switch (alt104) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5325:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalServiceDsl.g:5325:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalServiceDsl.g:5326:6: lv_contexts_4_0= ruleContext
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
                    	    if ( cnt104 >= 1 ) break loop104;
                                EarlyExitException eee =
                                    new EarlyExitException(104, input);
                                throw eee;
                        }
                        cnt104++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:5352:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalServiceDsl.g:5352:48: (iv_ruleContext= ruleContext EOF )
            // InternalServiceDsl.g:5353:2: iv_ruleContext= ruleContext EOF
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
    // InternalServiceDsl.g:5359:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:5365:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalServiceDsl.g:5366:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalServiceDsl.g:5366:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalServiceDsl.g:5367:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalServiceDsl.g:5371:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5372:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5372:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5373:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,24,FOLLOW_92); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalServiceDsl.g:5393:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt106=0;
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( ((LA106_0>=75 && LA106_0<=76)||LA106_0==112) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // InternalServiceDsl.g:5394:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalServiceDsl.g:5394:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalServiceDsl.g:5395:5: lv_complexTypes_3_0= ruleComplexType
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
            	    if ( cnt106 >= 1 ) break loop106;
                        EarlyExitException eee =
                            new EarlyExitException(106, input);
                        throw eee;
                }
                cnt106++;
            } while (true);

            otherlv_4=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:5420:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalServiceDsl.g:5420:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalServiceDsl.g:5421:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalServiceDsl.g:5427:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:5433:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalServiceDsl.g:5434:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalServiceDsl.g:5434:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt107=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt107=1;
                }
                break;
            case 75:
                {
                alt107=2;
                }
                break;
            case 112:
                {
                alt107=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalServiceDsl.g:5435:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalServiceDsl.g:5444:3: this_ListType_1= ruleListType
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
                    // InternalServiceDsl.g:5453:3: this_Enumeration_2= ruleEnumeration
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
    // InternalServiceDsl.g:5465:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalServiceDsl.g:5465:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalServiceDsl.g:5466:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalServiceDsl.g:5472:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalServiceDsl.g:5478:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalServiceDsl.g:5479:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalServiceDsl.g:5479:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalServiceDsl.g:5480:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalServiceDsl.g:5484:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:5485:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:5485:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:5486:5: lv_name_1_0= RULE_ID
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

            // InternalServiceDsl.g:5502:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==46) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalServiceDsl.g:5503:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:5507:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalServiceDsl.g:5508:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalServiceDsl.g:5508:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalServiceDsl.g:5509:6: lv_features_3_0= ruleComplexTypeFeature
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

                    // InternalServiceDsl.g:5526:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==27) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5527:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_94); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:5531:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalServiceDsl.g:5532:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalServiceDsl.g:5532:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalServiceDsl.g:5533:7: lv_features_5_0= ruleComplexTypeFeature
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
                    	    break loop108;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_95); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:5556:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==106) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalServiceDsl.g:5557:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,106,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalServiceDsl.g:5561:4: ( ( ruleQualifiedName ) )
                    // InternalServiceDsl.g:5562:5: ( ruleQualifiedName )
                    {
                    // InternalServiceDsl.g:5562:5: ( ruleQualifiedName )
                    // InternalServiceDsl.g:5563:6: ruleQualifiedName
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

            otherlv_9=(Token)match(input,24,FOLLOW_96); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalServiceDsl.g:5582:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_ID||(LA114_0>=110 && LA114_0<=111)||(LA114_0>=116 && LA114_0<=127)||LA114_0==134) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalServiceDsl.g:5583:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalServiceDsl.g:5583:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt111=2;
                    switch ( input.LA(1) ) {
                    case 110:
                        {
                        int LA111_1 = input.LA(2);

                        if ( ((LA111_1>=116 && LA111_1<=117)) ) {
                            alt111=2;
                        }
                        else if ( (LA111_1==RULE_ID||LA111_1==111||(LA111_1>=118 && LA111_1<=127)||LA111_1==134) ) {
                            alt111=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 111, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 111:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 134:
                        {
                        alt111=1;
                        }
                        break;
                    case 116:
                    case 117:
                        {
                        alt111=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }

                    switch (alt111) {
                        case 1 :
                            // InternalServiceDsl.g:5584:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalServiceDsl.g:5584:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalServiceDsl.g:5585:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalServiceDsl.g:5585:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalServiceDsl.g:5586:7: lv_dataFields_10_0= ruleDataField
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
                            // InternalServiceDsl.g:5604:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalServiceDsl.g:5604:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalServiceDsl.g:5605:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalServiceDsl.g:5605:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalServiceDsl.g:5606:7: lv_operations_11_0= ruleDataOperation
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

                    // InternalServiceDsl.g:5624:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==27) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5625:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,27,FOLLOW_97); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalServiceDsl.g:5629:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt112=2;
                    	    switch ( input.LA(1) ) {
                    	    case 110:
                    	        {
                    	        int LA112_1 = input.LA(2);

                    	        if ( ((LA112_1>=116 && LA112_1<=117)) ) {
                    	            alt112=2;
                    	        }
                    	        else if ( (LA112_1==RULE_ID||LA112_1==111||(LA112_1>=118 && LA112_1<=127)||LA112_1==134) ) {
                    	            alt112=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 112, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 111:
                    	    case 118:
                    	    case 119:
                    	    case 120:
                    	    case 121:
                    	    case 122:
                    	    case 123:
                    	    case 124:
                    	    case 125:
                    	    case 126:
                    	    case 127:
                    	    case 134:
                    	        {
                    	        alt112=1;
                    	        }
                    	        break;
                    	    case 116:
                    	    case 117:
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
                    	            // InternalServiceDsl.g:5630:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalServiceDsl.g:5630:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalServiceDsl.g:5631:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalServiceDsl.g:5631:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalServiceDsl.g:5632:8: lv_dataFields_13_0= ruleDataField
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
                    	            // InternalServiceDsl.g:5650:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalServiceDsl.g:5650:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalServiceDsl.g:5651:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalServiceDsl.g:5651:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalServiceDsl.g:5652:8: lv_operations_14_0= ruleDataOperation
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
                    	    break loop113;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:5680:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalServiceDsl.g:5680:49: (iv_ruleListType= ruleListType EOF )
            // InternalServiceDsl.g:5681:2: iv_ruleListType= ruleListType EOF
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
    // InternalServiceDsl.g:5687:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalServiceDsl.g:5693:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalServiceDsl.g:5694:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalServiceDsl.g:5694:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt116=2;
            alt116 = dfa116.predict(input);
            switch (alt116) {
                case 1 :
                    // InternalServiceDsl.g:5695:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalServiceDsl.g:5695:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalServiceDsl.g:5696:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,75,FOLLOW_9); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalServiceDsl.g:5700:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalServiceDsl.g:5701:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:5701:5: (lv_name_1_0= RULE_ID )
                    // InternalServiceDsl.g:5702:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

                    otherlv_2=(Token)match(input,24,FOLLOW_98); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalServiceDsl.g:5722:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalServiceDsl.g:5723:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalServiceDsl.g:5723:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalServiceDsl.g:5724:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_21);
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

                    // InternalServiceDsl.g:5741:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==27) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5742:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_98); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalServiceDsl.g:5746:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalServiceDsl.g:5747:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalServiceDsl.g:5747:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalServiceDsl.g:5748:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop115;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,28,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:5772:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalServiceDsl.g:5772:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalServiceDsl.g:5773:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,75,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalServiceDsl.g:5777:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalServiceDsl.g:5778:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalServiceDsl.g:5778:5: (lv_name_8_0= RULE_ID )
                    // InternalServiceDsl.g:5779:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

                    otherlv_9=(Token)match(input,24,FOLLOW_67); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalServiceDsl.g:5799:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:5800:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:5800:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalServiceDsl.g:5801:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_74);
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

                    otherlv_11=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:5827:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalServiceDsl.g:5827:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalServiceDsl.g:5828:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalServiceDsl.g:5834:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
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
            // InternalServiceDsl.g:5840:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalServiceDsl.g:5841:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalServiceDsl.g:5841:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalServiceDsl.g:5842:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalServiceDsl.g:5842:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==110) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalServiceDsl.g:5843:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalServiceDsl.g:5843:4: (lv_hidden_0_0= 'hide' )
                    // InternalServiceDsl.g:5844:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,110,FOLLOW_99); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:5856:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==111) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalServiceDsl.g:5857:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalServiceDsl.g:5857:4: (lv_immutable_1_0= 'immutable' )
                    // InternalServiceDsl.g:5858:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,111,FOLLOW_49); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", true, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:5870:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt119=4;
            int LA119_0 = input.LA(1);

            if ( ((LA119_0>=118 && LA119_0<=127)||LA119_0==134) ) {
                alt119=1;
            }
            else if ( (LA119_0==RULE_ID) ) {
                int LA119_2 = input.LA(2);

                if ( (LA119_2==34) ) {
                    alt119=3;
                }
                else if ( (LA119_2==RULE_ID||LA119_2==45) ) {
                    alt119=2;
                }
            }
            switch (alt119) {
                case 1 :
                    // InternalServiceDsl.g:5871:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalServiceDsl.g:5871:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:5872:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:5872:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalServiceDsl.g:5873:6: lv_primitiveType_2_0= rulePrimitiveType
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
                    // InternalServiceDsl.g:5891:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalServiceDsl.g:5891:4: ( ( ruleQualifiedName ) )
                    // InternalServiceDsl.g:5892:5: ( ruleQualifiedName )
                    {
                    // InternalServiceDsl.g:5892:5: ( ruleQualifiedName )
                    // InternalServiceDsl.g:5893:6: ruleQualifiedName
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
                    // InternalServiceDsl.g:5908:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalServiceDsl.g:5908:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalServiceDsl.g:5909:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalServiceDsl.g:5909:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalServiceDsl.g:5910:6: lv_importedComplexType_4_0= ruleImportedComplexType
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

            // InternalServiceDsl.g:5928:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalServiceDsl.g:5929:4: (lv_name_5_0= RULE_ID )
            {
            // InternalServiceDsl.g:5929:4: (lv_name_5_0= RULE_ID )
            // InternalServiceDsl.g:5930:5: lv_name_5_0= RULE_ID
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

            // InternalServiceDsl.g:5946:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==33) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalServiceDsl.g:5947:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_55); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalServiceDsl.g:5951:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:5952:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:5952:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:5953:6: lv_initializationValue_7_0= rulePrimitiveValue
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

            // InternalServiceDsl.g:5971:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==46) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalServiceDsl.g:5972:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,46,FOLLOW_102); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalServiceDsl.g:5976:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalServiceDsl.g:5977:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalServiceDsl.g:5977:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalServiceDsl.g:5978:6: lv_features_9_0= ruleDataFieldFeature
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

                    // InternalServiceDsl.g:5995:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( (LA121_0==27) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // InternalServiceDsl.g:5996:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,27,FOLLOW_102); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6000:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalServiceDsl.g:6001:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalServiceDsl.g:6001:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalServiceDsl.g:6002:7: lv_features_11_0= ruleDataFieldFeature
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
                    	    break loop121;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,47,FOLLOW_2); 

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
    // InternalServiceDsl.g:6029:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalServiceDsl.g:6029:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalServiceDsl.g:6030:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalServiceDsl.g:6036:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) ;
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
            // InternalServiceDsl.g:6042:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) )
            // InternalServiceDsl.g:6043:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            {
            // InternalServiceDsl.g:6043:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            // InternalServiceDsl.g:6044:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,112,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalServiceDsl.g:6048:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalServiceDsl.g:6049:4: (lv_name_1_0= RULE_ID )
            {
            // InternalServiceDsl.g:6049:4: (lv_name_1_0= RULE_ID )
            // InternalServiceDsl.g:6050:5: lv_name_1_0= RULE_ID
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

            // InternalServiceDsl.g:6066:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==46) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalServiceDsl.g:6067:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalServiceDsl.g:6071:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalServiceDsl.g:6072:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalServiceDsl.g:6072:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalServiceDsl.g:6073:6: lv_features_3_0= ruleComplexTypeFeature
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

                    // InternalServiceDsl.g:6090:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==27) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6091:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,27,FOLLOW_94); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6095:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalServiceDsl.g:6096:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalServiceDsl.g:6096:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalServiceDsl.g:6097:7: lv_features_5_0= ruleComplexTypeFeature
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
                    	    break loop123;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,24,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalServiceDsl.g:6124:3: ( (lv_fields_8_0= ruleEnumerationField ) )
            // InternalServiceDsl.g:6125:4: (lv_fields_8_0= ruleEnumerationField )
            {
            // InternalServiceDsl.g:6125:4: (lv_fields_8_0= ruleEnumerationField )
            // InternalServiceDsl.g:6126:5: lv_fields_8_0= ruleEnumerationField
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

            // InternalServiceDsl.g:6143:3: (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==27) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // InternalServiceDsl.g:6144:4: otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) )
            	    {
            	    otherlv_9=(Token)match(input,27,FOLLOW_9); 

            	    				newLeafNode(otherlv_9, grammarAccess.getEnumerationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalServiceDsl.g:6148:4: ( (lv_fields_10_0= ruleEnumerationField ) )
            	    // InternalServiceDsl.g:6149:5: (lv_fields_10_0= ruleEnumerationField )
            	    {
            	    // InternalServiceDsl.g:6149:5: (lv_fields_10_0= ruleEnumerationField )
            	    // InternalServiceDsl.g:6150:6: lv_fields_10_0= ruleEnumerationField
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
            	    break loop125;
                }
            } while (true);

            otherlv_11=(Token)match(input,28,FOLLOW_2); 

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
    // InternalServiceDsl.g:6176:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalServiceDsl.g:6176:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalServiceDsl.g:6177:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalServiceDsl.g:6183:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:6189:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalServiceDsl.g:6190:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalServiceDsl.g:6190:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalServiceDsl.g:6191:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalServiceDsl.g:6191:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalServiceDsl.g:6192:4: (lv_name_0_0= RULE_ID )
            {
            // InternalServiceDsl.g:6192:4: (lv_name_0_0= RULE_ID )
            // InternalServiceDsl.g:6193:5: lv_name_0_0= RULE_ID
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

            // InternalServiceDsl.g:6209:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==18) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalServiceDsl.g:6210:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_55); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalServiceDsl.g:6214:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalServiceDsl.g:6215:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalServiceDsl.g:6215:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalServiceDsl.g:6216:6: lv_initializationValue_2_0= rulePrimitiveValue
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

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

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
    // InternalServiceDsl.g:6242:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalServiceDsl.g:6242:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalServiceDsl.g:6243:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalServiceDsl.g:6249:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalServiceDsl.g:6255:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalServiceDsl.g:6256:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalServiceDsl.g:6256:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalServiceDsl.g:6257:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalServiceDsl.g:6257:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==110) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalServiceDsl.g:6258:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalServiceDsl.g:6258:4: (lv_hidden_0_0= 'hide' )
                    // InternalServiceDsl.g:6259:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,110,FOLLOW_104); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalServiceDsl.g:6271:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==117) ) {
                alt129=1;
            }
            else if ( (LA129_0==116) ) {
                alt129=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // InternalServiceDsl.g:6272:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalServiceDsl.g:6272:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalServiceDsl.g:6273:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalServiceDsl.g:6273:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalServiceDsl.g:6274:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,117,FOLLOW_9); 

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
                    // InternalServiceDsl.g:6287:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalServiceDsl.g:6287:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalServiceDsl.g:6288:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,116,FOLLOW_49); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalServiceDsl.g:6292:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt128=4;
                    int LA128_0 = input.LA(1);

                    if ( ((LA128_0>=118 && LA128_0<=127)||LA128_0==134) ) {
                        alt128=1;
                    }
                    else if ( (LA128_0==RULE_ID) ) {
                        int LA128_2 = input.LA(2);

                        if ( (LA128_2==34) ) {
                            alt128=3;
                        }
                        else if ( (LA128_2==RULE_ID||LA128_2==45) ) {
                            alt128=2;
                        }
                    }
                    switch (alt128) {
                        case 1 :
                            // InternalServiceDsl.g:6293:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalServiceDsl.g:6293:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalServiceDsl.g:6294:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalServiceDsl.g:6294:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalServiceDsl.g:6295:8: lv_primitiveReturnType_3_0= rulePrimitiveType
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
                            // InternalServiceDsl.g:6313:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalServiceDsl.g:6313:6: ( ( ruleQualifiedName ) )
                            // InternalServiceDsl.g:6314:7: ( ruleQualifiedName )
                            {
                            // InternalServiceDsl.g:6314:7: ( ruleQualifiedName )
                            // InternalServiceDsl.g:6315:8: ruleQualifiedName
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
                            // InternalServiceDsl.g:6330:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalServiceDsl.g:6330:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalServiceDsl.g:6331:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalServiceDsl.g:6331:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalServiceDsl.g:6332:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
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

            // InternalServiceDsl.g:6352:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalServiceDsl.g:6353:4: (lv_name_6_0= RULE_ID )
            {
            // InternalServiceDsl.g:6353:4: (lv_name_6_0= RULE_ID )
            // InternalServiceDsl.g:6354:5: lv_name_6_0= RULE_ID
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

            // InternalServiceDsl.g:6370:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==18) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // InternalServiceDsl.g:6371:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,18,FOLLOW_106); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalServiceDsl.g:6375:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==RULE_ID||(LA130_0>=118 && LA130_0<=127)||LA130_0==134) ) {
                        alt130=1;
                    }
                    switch (alt130) {
                        case 1 :
                            // InternalServiceDsl.g:6376:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalServiceDsl.g:6376:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalServiceDsl.g:6377:6: lv_parameters_8_0= ruleDataOperationParameter
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

                    // InternalServiceDsl.g:6394:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==27) ) {
                            alt131=1;
                        }


                        switch (alt131) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6395:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,27,FOLLOW_49); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6399:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalServiceDsl.g:6400:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalServiceDsl.g:6400:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalServiceDsl.g:6401:7: lv_parameters_10_0= ruleDataOperationParameter
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
                    	    break loop131;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,19,FOLLOW_101); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalServiceDsl.g:6424:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==46) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalServiceDsl.g:6425:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,46,FOLLOW_107); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalServiceDsl.g:6429:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalServiceDsl.g:6430:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalServiceDsl.g:6430:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalServiceDsl.g:6431:6: lv_features_13_0= ruleDataOperationFeature
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

                    // InternalServiceDsl.g:6448:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==27) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // InternalServiceDsl.g:6449:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,27,FOLLOW_107); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalServiceDsl.g:6453:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalServiceDsl.g:6454:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalServiceDsl.g:6454:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalServiceDsl.g:6455:7: lv_features_15_0= ruleDataOperationFeature
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
                    	    break loop133;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,47,FOLLOW_2); 

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
    // InternalServiceDsl.g:6482:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalServiceDsl.g:6482:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalServiceDsl.g:6483:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalServiceDsl.g:6489:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalServiceDsl.g:6495:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalServiceDsl.g:6496:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalServiceDsl.g:6496:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalServiceDsl.g:6497:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalServiceDsl.g:6497:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt135=3;
            int LA135_0 = input.LA(1);

            if ( ((LA135_0>=118 && LA135_0<=127)||LA135_0==134) ) {
                alt135=1;
            }
            else if ( (LA135_0==RULE_ID) ) {
                int LA135_2 = input.LA(2);

                if ( (LA135_2==34) ) {
                    alt135=3;
                }
                else if ( (LA135_2==RULE_ID||LA135_2==45) ) {
                    alt135=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 135, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }
            switch (alt135) {
                case 1 :
                    // InternalServiceDsl.g:6498:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalServiceDsl.g:6498:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalServiceDsl.g:6499:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalServiceDsl.g:6499:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalServiceDsl.g:6500:6: lv_primitiveType_0_0= rulePrimitiveType
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
                    // InternalServiceDsl.g:6518:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalServiceDsl.g:6518:4: ( ( ruleQualifiedName ) )
                    // InternalServiceDsl.g:6519:5: ( ruleQualifiedName )
                    {
                    // InternalServiceDsl.g:6519:5: ( ruleQualifiedName )
                    // InternalServiceDsl.g:6520:6: ruleQualifiedName
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
                    // InternalServiceDsl.g:6535:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalServiceDsl.g:6535:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalServiceDsl.g:6536:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalServiceDsl.g:6536:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalServiceDsl.g:6537:6: lv_importedComplexType_2_0= ruleImportedComplexType
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

            // InternalServiceDsl.g:6555:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalServiceDsl.g:6556:4: (lv_name_3_0= RULE_ID )
            {
            // InternalServiceDsl.g:6556:4: (lv_name_3_0= RULE_ID )
            // InternalServiceDsl.g:6557:5: lv_name_3_0= RULE_ID
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
    // InternalServiceDsl.g:6577:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalServiceDsl.g:6577:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalServiceDsl.g:6578:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalServiceDsl.g:6584:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6590:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalServiceDsl.g:6591:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalServiceDsl.g:6591:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt136=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt136=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt136=2;
                }
                break;
            case RULE_STRING:
                {
                alt136=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }

            switch (alt136) {
                case 1 :
                    // InternalServiceDsl.g:6592:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalServiceDsl.g:6592:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalServiceDsl.g:6593:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalServiceDsl.g:6593:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalServiceDsl.g:6594:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalServiceDsl.g:6611:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalServiceDsl.g:6611:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalServiceDsl.g:6612:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalServiceDsl.g:6612:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalServiceDsl.g:6613:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalServiceDsl.g:6630:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalServiceDsl.g:6630:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalServiceDsl.g:6631:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalServiceDsl.g:6631:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalServiceDsl.g:6632:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalServiceDsl.g:6652:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalServiceDsl.g:6652:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalServiceDsl.g:6653:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalServiceDsl.g:6659:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6665:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalServiceDsl.g:6666:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalServiceDsl.g:6666:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalServiceDsl.g:6667:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalServiceDsl.g:6667:3: ( (otherlv_0= RULE_ID ) )
            // InternalServiceDsl.g:6668:4: (otherlv_0= RULE_ID )
            {
            // InternalServiceDsl.g:6668:4: (otherlv_0= RULE_ID )
            // InternalServiceDsl.g:6669:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalServiceDsl.g:6684:3: ( ( ruleQualifiedName ) )
            // InternalServiceDsl.g:6685:4: ( ruleQualifiedName )
            {
            // InternalServiceDsl.g:6685:4: ( ruleQualifiedName )
            // InternalServiceDsl.g:6686:5: ruleQualifiedName
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
    // InternalServiceDsl.g:6704:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalServiceDsl.g:6704:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalServiceDsl.g:6705:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalServiceDsl.g:6711:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
            // InternalServiceDsl.g:6717:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalServiceDsl.g:6718:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalServiceDsl.g:6718:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt137=11;
            switch ( input.LA(1) ) {
            case 118:
                {
                alt137=1;
                }
                break;
            case 119:
                {
                alt137=2;
                }
                break;
            case 120:
                {
                alt137=3;
                }
                break;
            case 121:
                {
                alt137=4;
                }
                break;
            case 122:
                {
                alt137=5;
                }
                break;
            case 123:
                {
                alt137=6;
                }
                break;
            case 124:
                {
                alt137=7;
                }
                break;
            case 125:
                {
                alt137=8;
                }
                break;
            case 126:
                {
                alt137=9;
                }
                break;
            case 127:
                {
                alt137=10;
                }
                break;
            case 134:
                {
                alt137=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // InternalServiceDsl.g:6719:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalServiceDsl.g:6719:3: ( () otherlv_1= 'boolean' )
                    // InternalServiceDsl.g:6720:4: () otherlv_1= 'boolean'
                    {
                    // InternalServiceDsl.g:6720:4: ()
                    // InternalServiceDsl.g:6721:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,118,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:6733:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalServiceDsl.g:6733:3: ( () otherlv_3= 'byte' )
                    // InternalServiceDsl.g:6734:4: () otherlv_3= 'byte'
                    {
                    // InternalServiceDsl.g:6734:4: ()
                    // InternalServiceDsl.g:6735:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,119,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:6747:3: ( () otherlv_5= 'char' )
                    {
                    // InternalServiceDsl.g:6747:3: ( () otherlv_5= 'char' )
                    // InternalServiceDsl.g:6748:4: () otherlv_5= 'char'
                    {
                    // InternalServiceDsl.g:6748:4: ()
                    // InternalServiceDsl.g:6749:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,120,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:6761:3: ( () otherlv_7= 'date' )
                    {
                    // InternalServiceDsl.g:6761:3: ( () otherlv_7= 'date' )
                    // InternalServiceDsl.g:6762:4: () otherlv_7= 'date'
                    {
                    // InternalServiceDsl.g:6762:4: ()
                    // InternalServiceDsl.g:6763:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,121,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalServiceDsl.g:6775:3: ( () otherlv_9= 'double' )
                    {
                    // InternalServiceDsl.g:6775:3: ( () otherlv_9= 'double' )
                    // InternalServiceDsl.g:6776:4: () otherlv_9= 'double'
                    {
                    // InternalServiceDsl.g:6776:4: ()
                    // InternalServiceDsl.g:6777:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,122,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalServiceDsl.g:6789:3: ( () otherlv_11= 'float' )
                    {
                    // InternalServiceDsl.g:6789:3: ( () otherlv_11= 'float' )
                    // InternalServiceDsl.g:6790:4: () otherlv_11= 'float'
                    {
                    // InternalServiceDsl.g:6790:4: ()
                    // InternalServiceDsl.g:6791:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,123,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalServiceDsl.g:6803:3: ( () otherlv_13= 'int' )
                    {
                    // InternalServiceDsl.g:6803:3: ( () otherlv_13= 'int' )
                    // InternalServiceDsl.g:6804:4: () otherlv_13= 'int'
                    {
                    // InternalServiceDsl.g:6804:4: ()
                    // InternalServiceDsl.g:6805:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,124,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalServiceDsl.g:6817:3: ( () otherlv_15= 'long' )
                    {
                    // InternalServiceDsl.g:6817:3: ( () otherlv_15= 'long' )
                    // InternalServiceDsl.g:6818:4: () otherlv_15= 'long'
                    {
                    // InternalServiceDsl.g:6818:4: ()
                    // InternalServiceDsl.g:6819:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,125,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalServiceDsl.g:6831:3: ( () otherlv_17= 'short' )
                    {
                    // InternalServiceDsl.g:6831:3: ( () otherlv_17= 'short' )
                    // InternalServiceDsl.g:6832:4: () otherlv_17= 'short'
                    {
                    // InternalServiceDsl.g:6832:4: ()
                    // InternalServiceDsl.g:6833:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,126,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalServiceDsl.g:6845:3: ( () otherlv_19= 'string' )
                    {
                    // InternalServiceDsl.g:6845:3: ( () otherlv_19= 'string' )
                    // InternalServiceDsl.g:6846:4: () otherlv_19= 'string'
                    {
                    // InternalServiceDsl.g:6846:4: ()
                    // InternalServiceDsl.g:6847:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,127,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalServiceDsl.g:6859:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalServiceDsl.g:6859:3: ( () otherlv_21= 'unspecified' )
                    // InternalServiceDsl.g:6860:4: () otherlv_21= 'unspecified'
                    {
                    // InternalServiceDsl.g:6860:4: ()
                    // InternalServiceDsl.g:6861:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0(),
                    						current);
                    				

                    }

                    otherlv_21=(Token)match(input,134,FOLLOW_2); 

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
    // InternalServiceDsl.g:6876:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalServiceDsl.g:6876:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalServiceDsl.g:6877:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalServiceDsl.g:6883:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6889:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalServiceDsl.g:6890:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalServiceDsl.g:6890:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalServiceDsl.g:6891:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_108); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalServiceDsl.g:6898:3: (kw= '.' this_ID_2= RULE_ID )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( (LA138_0==45) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // InternalServiceDsl.g:6899:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,45,FOLLOW_9); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_108); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop138;
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
    // InternalServiceDsl.g:6916:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6922:2: ( ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) ) )
            // InternalServiceDsl.g:6923:2: ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) )
            {
            // InternalServiceDsl.g:6923:2: ( (enumLiteral_0= 'datatypes' ) | (enumLiteral_1= 'technology' ) | (enumLiteral_2= 'microservices' ) )
            int alt139=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt139=1;
                }
                break;
            case 31:
                {
                alt139=2;
                }
                break;
            case 26:
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
                    // InternalServiceDsl.g:6924:3: (enumLiteral_0= 'datatypes' )
                    {
                    // InternalServiceDsl.g:6924:3: (enumLiteral_0= 'datatypes' )
                    // InternalServiceDsl.g:6925:4: enumLiteral_0= 'datatypes'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getDATATYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getDATATYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:6932:3: (enumLiteral_1= 'technology' )
                    {
                    // InternalServiceDsl.g:6932:3: (enumLiteral_1= 'technology' )
                    // InternalServiceDsl.g:6933:4: enumLiteral_1= 'technology'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:6940:3: (enumLiteral_2= 'microservices' )
                    {
                    // InternalServiceDsl.g:6940:3: (enumLiteral_2= 'microservices' )
                    // InternalServiceDsl.g:6941:4: enumLiteral_2= 'microservices'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_2); 

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
    // InternalServiceDsl.g:6951:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6957:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalServiceDsl.g:6958:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalServiceDsl.g:6958:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt140=3;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt140=1;
                }
                break;
            case 129:
                {
                alt140=2;
                }
                break;
            case 130:
                {
                alt140=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }

            switch (alt140) {
                case 1 :
                    // InternalServiceDsl.g:6959:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalServiceDsl.g:6959:3: (enumLiteral_0= 'internal' )
                    // InternalServiceDsl.g:6960:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:6967:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalServiceDsl.g:6967:3: (enumLiteral_1= 'architecture' )
                    // InternalServiceDsl.g:6968:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:6975:3: (enumLiteral_2= 'public' )
                    {
                    // InternalServiceDsl.g:6975:3: (enumLiteral_2= 'public' )
                    // InternalServiceDsl.g:6976:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_2); 

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
    // InternalServiceDsl.g:6986:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:6992:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalServiceDsl.g:6993:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalServiceDsl.g:6993:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt141=3;
            switch ( input.LA(1) ) {
            case 132:
                {
                alt141=1;
                }
                break;
            case 133:
                {
                alt141=2;
                }
                break;
            case 59:
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
                    // InternalServiceDsl.g:6994:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalServiceDsl.g:6994:3: (enumLiteral_0= 'functional' )
                    // InternalServiceDsl.g:6995:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7002:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalServiceDsl.g:7002:3: (enumLiteral_1= 'utility' )
                    // InternalServiceDsl.g:7003:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7010:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalServiceDsl.g:7010:3: (enumLiteral_2= 'infrastructure' )
                    // InternalServiceDsl.g:7011:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

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
    // InternalServiceDsl.g:7021:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7027:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalServiceDsl.g:7028:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalServiceDsl.g:7028:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt142=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt142=1;
                }
                break;
            case 67:
                {
                alt142=2;
                }
                break;
            case 68:
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
                    // InternalServiceDsl.g:7029:3: (enumLiteral_0= 'in' )
                    {
                    // InternalServiceDsl.g:7029:3: (enumLiteral_0= 'in' )
                    // InternalServiceDsl.g:7030:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7037:3: (enumLiteral_1= 'out' )
                    {
                    // InternalServiceDsl.g:7037:3: (enumLiteral_1= 'out' )
                    // InternalServiceDsl.g:7038:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7045:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalServiceDsl.g:7045:3: (enumLiteral_2= 'inout' )
                    // InternalServiceDsl.g:7046:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_2); 

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
    // InternalServiceDsl.g:7056:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7062:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalServiceDsl.g:7063:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalServiceDsl.g:7063:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==69) ) {
                alt143=1;
            }
            else if ( (LA143_0==70) ) {
                alt143=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 143, 0, input);

                throw nvae;
            }
            switch (alt143) {
                case 1 :
                    // InternalServiceDsl.g:7064:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalServiceDsl.g:7064:3: (enumLiteral_0= 'sync' )
                    // InternalServiceDsl.g:7065:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7072:3: (enumLiteral_1= 'async' )
                    {
                    // InternalServiceDsl.g:7072:3: (enumLiteral_1= 'async' )
                    // InternalServiceDsl.g:7073:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_2); 

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
    // InternalServiceDsl.g:7083:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7089:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalServiceDsl.g:7090:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalServiceDsl.g:7090:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt144=3;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt144=1;
                }
                break;
            case 77:
                {
                alt144=2;
                }
                break;
            case 79:
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
                    // InternalServiceDsl.g:7091:3: (enumLiteral_0= '<-' )
                    {
                    // InternalServiceDsl.g:7091:3: (enumLiteral_0= '<-' )
                    // InternalServiceDsl.g:7092:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7099:3: (enumLiteral_1= '->' )
                    {
                    // InternalServiceDsl.g:7099:3: (enumLiteral_1= '->' )
                    // InternalServiceDsl.g:7100:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7107:3: (enumLiteral_2= '<->' )
                    {
                    // InternalServiceDsl.g:7107:3: (enumLiteral_2= '<->' )
                    // InternalServiceDsl.g:7108:4: enumLiteral_2= '<->'
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
    // InternalServiceDsl.g:7118:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7124:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalServiceDsl.g:7125:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalServiceDsl.g:7125:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==82) ) {
                alt145=1;
            }
            else if ( (LA145_0==83) ) {
                alt145=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }
            switch (alt145) {
                case 1 :
                    // InternalServiceDsl.g:7126:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalServiceDsl.g:7126:3: (enumLiteral_0= 'mandatory' )
                    // InternalServiceDsl.g:7127:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7134:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalServiceDsl.g:7134:3: (enumLiteral_1= 'singleval' )
                    // InternalServiceDsl.g:7135:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); 

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
    // InternalServiceDsl.g:7145:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) ;
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
            // InternalServiceDsl.g:7151:2: ( ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) )
            // InternalServiceDsl.g:7152:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            {
            // InternalServiceDsl.g:7152:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            int alt146=8;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt146=1;
                }
                break;
            case 85:
                {
                alt146=2;
                }
                break;
            case 135:
                {
                alt146=3;
                }
                break;
            case 136:
                {
                alt146=4;
                }
                break;
            case 26:
                {
                alt146=5;
                }
                break;
            case 29:
                {
                alt146=6;
                }
                break;
            case 30:
                {
                alt146=7;
                }
                break;
            case 84:
                {
                alt146=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }

            switch (alt146) {
                case 1 :
                    // InternalServiceDsl.g:7153:3: (enumLiteral_0= 'types' )
                    {
                    // InternalServiceDsl.g:7153:3: (enumLiteral_0= 'types' )
                    // InternalServiceDsl.g:7154:4: enumLiteral_0= 'types'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7161:3: (enumLiteral_1= 'fields' )
                    {
                    // InternalServiceDsl.g:7161:3: (enumLiteral_1= 'fields' )
                    // InternalServiceDsl.g:7162:4: enumLiteral_1= 'fields'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7169:3: (enumLiteral_2= 'domainOperations' )
                    {
                    // InternalServiceDsl.g:7169:3: (enumLiteral_2= 'domainOperations' )
                    // InternalServiceDsl.g:7170:4: enumLiteral_2= 'domainOperations'
                    {
                    enumLiteral_2=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:7177:3: (enumLiteral_3= 'domainParameters' )
                    {
                    // InternalServiceDsl.g:7177:3: (enumLiteral_3= 'domainParameters' )
                    // InternalServiceDsl.g:7178:4: enumLiteral_3= 'domainParameters'
                    {
                    enumLiteral_3=(Token)match(input,136,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalServiceDsl.g:7185:3: (enumLiteral_4= 'microservices' )
                    {
                    // InternalServiceDsl.g:7185:3: (enumLiteral_4= 'microservices' )
                    // InternalServiceDsl.g:7186:4: enumLiteral_4= 'microservices'
                    {
                    enumLiteral_4=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalServiceDsl.g:7193:3: (enumLiteral_5= 'interfaces' )
                    {
                    // InternalServiceDsl.g:7193:3: (enumLiteral_5= 'interfaces' )
                    // InternalServiceDsl.g:7194:4: enumLiteral_5= 'interfaces'
                    {
                    enumLiteral_5=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalServiceDsl.g:7201:3: (enumLiteral_6= 'operations' )
                    {
                    // InternalServiceDsl.g:7201:3: (enumLiteral_6= 'operations' )
                    // InternalServiceDsl.g:7202:4: enumLiteral_6= 'operations'
                    {
                    enumLiteral_6=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalServiceDsl.g:7209:3: (enumLiteral_7= 'parameters' )
                    {
                    // InternalServiceDsl.g:7209:3: (enumLiteral_7= 'parameters' )
                    // InternalServiceDsl.g:7210:4: enumLiteral_7= 'parameters'
                    {
                    enumLiteral_7=(Token)match(input,84,FOLLOW_2); 

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
    // InternalServiceDsl.g:7220:1: ruleAspectFeature returns [Enumerator current=null] : (enumLiteral_0= 'singleval' ) ;
    public final Enumerator ruleAspectFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7226:2: ( (enumLiteral_0= 'singleval' ) )
            // InternalServiceDsl.g:7227:2: (enumLiteral_0= 'singleval' )
            {
            // InternalServiceDsl.g:7227:2: (enumLiteral_0= 'singleval' )
            // InternalServiceDsl.g:7228:3: enumLiteral_0= 'singleval'
            {
            enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

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
    // InternalServiceDsl.g:7237:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7243:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalServiceDsl.g:7244:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalServiceDsl.g:7244:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==92) ) {
                alt147=1;
            }
            else if ( (LA147_0==59) ) {
                alt147=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 147, 0, input);

                throw nvae;
            }
            switch (alt147) {
                case 1 :
                    // InternalServiceDsl.g:7245:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalServiceDsl.g:7245:3: (enumLiteral_0= 'containers' )
                    // InternalServiceDsl.g:7246:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7253:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalServiceDsl.g:7253:3: (enumLiteral_1= 'infrastructure' )
                    // InternalServiceDsl.g:7254:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

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
    // InternalServiceDsl.g:7264:1: ruleComplexTypeFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
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
            // InternalServiceDsl.g:7270:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalServiceDsl.g:7271:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalServiceDsl.g:7271:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt148=11;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt148=1;
                }
                break;
            case 97:
                {
                alt148=2;
                }
                break;
            case 98:
                {
                alt148=3;
                }
                break;
            case 99:
                {
                alt148=4;
                }
                break;
            case 100:
                {
                alt148=5;
                }
                break;
            case 101:
                {
                alt148=6;
                }
                break;
            case 102:
                {
                alt148=7;
                }
                break;
            case 103:
                {
                alt148=8;
                }
                break;
            case 55:
                {
                alt148=9;
                }
                break;
            case 104:
                {
                alt148=10;
                }
                break;
            case 105:
                {
                alt148=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }

            switch (alt148) {
                case 1 :
                    // InternalServiceDsl.g:7272:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalServiceDsl.g:7272:3: (enumLiteral_0= 'aggregate' )
                    // InternalServiceDsl.g:7273:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7280:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalServiceDsl.g:7280:3: (enumLiteral_1= 'applicationService' )
                    // InternalServiceDsl.g:7281:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7288:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalServiceDsl.g:7288:3: (enumLiteral_2= 'domainEvent' )
                    // InternalServiceDsl.g:7289:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:7296:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalServiceDsl.g:7296:3: (enumLiteral_3= 'domainService' )
                    // InternalServiceDsl.g:7297:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalServiceDsl.g:7304:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalServiceDsl.g:7304:3: (enumLiteral_4= 'entity' )
                    // InternalServiceDsl.g:7305:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalServiceDsl.g:7312:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalServiceDsl.g:7312:3: (enumLiteral_5= 'factory' )
                    // InternalServiceDsl.g:7313:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalServiceDsl.g:7320:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalServiceDsl.g:7320:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalServiceDsl.g:7321:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalServiceDsl.g:7328:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalServiceDsl.g:7328:3: (enumLiteral_7= 'repository' )
                    // InternalServiceDsl.g:7329:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalServiceDsl.g:7336:3: (enumLiteral_8= 'service' )
                    {
                    // InternalServiceDsl.g:7336:3: (enumLiteral_8= 'service' )
                    // InternalServiceDsl.g:7337:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalServiceDsl.g:7344:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalServiceDsl.g:7344:3: (enumLiteral_9= 'specification' )
                    // InternalServiceDsl.g:7345:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalServiceDsl.g:7352:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalServiceDsl.g:7352:3: (enumLiteral_10= 'valueObject' )
                    // InternalServiceDsl.g:7353:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,105,FOLLOW_2); 

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
    // InternalServiceDsl.g:7363:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7369:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalServiceDsl.g:7370:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalServiceDsl.g:7370:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt149=3;
            switch ( input.LA(1) ) {
            case 107:
                {
                alt149=1;
                }
                break;
            case 108:
                {
                alt149=2;
                }
                break;
            case 109:
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
                    // InternalServiceDsl.g:7371:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalServiceDsl.g:7371:3: (enumLiteral_0= 'identifier' )
                    // InternalServiceDsl.g:7372:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7379:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalServiceDsl.g:7379:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalServiceDsl.g:7380:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7387:3: (enumLiteral_2= 'part' )
                    {
                    // InternalServiceDsl.g:7387:3: (enumLiteral_2= 'part' )
                    // InternalServiceDsl.g:7388:4: enumLiteral_2= 'part'
                    {
                    enumLiteral_2=(Token)match(input,109,FOLLOW_2); 

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
    // InternalServiceDsl.g:7398:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalServiceDsl.g:7404:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalServiceDsl.g:7405:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalServiceDsl.g:7405:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt150=4;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt150=1;
                }
                break;
            case 107:
                {
                alt150=2;
                }
                break;
            case 114:
                {
                alt150=3;
                }
                break;
            case 115:
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
                    // InternalServiceDsl.g:7406:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalServiceDsl.g:7406:3: (enumLiteral_0= 'closure' )
                    // InternalServiceDsl.g:7407:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:7414:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalServiceDsl.g:7414:3: (enumLiteral_1= 'identifier' )
                    // InternalServiceDsl.g:7415:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalServiceDsl.g:7422:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalServiceDsl.g:7422:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalServiceDsl.g:7423:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalServiceDsl.g:7430:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalServiceDsl.g:7430:3: (enumLiteral_3= 'validator' )
                    // InternalServiceDsl.g:7431:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,115,FOLLOW_2); 

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
    protected DFA116 dfa116 = new DFA116(this);
    static final String dfa_1s = "\161\uffff";
    static final String dfa_2s = "\1\5\1\uffff\1\5\1\uffff\1\42\3\22\5\5\3\42\1\5\1\4\5\5\3\23\4\22\1\5\2\4\1\5\1\4\2\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\6\23\1\22\1\23\1\5\1\22\1\23\1\42\1\33\1\22\1\23\1\42\1\33\1\5\2\23\2\22\1\33\1\5\1\4\1\5\1\33\1\5\1\4\1\5\1\22\1\5\1\22\1\33\1\5\1\22\1\33\1\5\2\4\1\42\1\5\1\4\1\5\1\4\1\5\6\23\1\5\1\22\1\23\1\22\1\23\1\24\1\23\1\22\2\33\1\5\1\4\1\5\1\22\1\23\1\5\1\23";
    static final String dfa_3s = "\1\u0082\1\uffff\1\106\1\uffff\1\42\2\22\1\24\4\5\1\u0082\3\42\1\5\1\7\4\5\1\u0082\3\23\1\41\3\55\1\u0082\2\7\1\5\1\4\1\u0082\1\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\3\33\3\23\1\55\1\23\1\106\1\55\1\23\1\42\1\50\1\55\1\23\1\42\1\50\1\5\1\33\1\23\2\22\1\54\1\5\1\4\1\25\1\54\1\5\1\4\1\23\1\41\1\5\1\55\1\50\1\u0082\1\55\1\50\1\u0082\2\7\1\42\1\5\1\4\1\5\1\4\1\21\3\33\3\23\1\5\1\55\1\23\1\55\1\23\1\24\1\33\1\55\2\54\1\5\1\4\1\u0082\1\55\1\23\1\21\1\23";
    static final String dfa_4s = "\1\uffff\1\2\1\uffff\1\1\155\uffff";
    static final String dfa_5s = "\161\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\12\uffff\1\2\13\uffff\1\1\6\uffff\1\1\1\uffff\1\1\3\uffff\1\3\126\uffff\3\1",
            "",
            "\1\4\13\uffff\1\7\63\uffff\1\5\1\6",
            "",
            "\1\10",
            "\1\11",
            "\1\11",
            "\1\13\1\uffff\1\12",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\1\12\uffff\1\22\1\uffff\1\21\20\uffff\1\1\5\uffff\1\3\3\uffff\1\20\122\uffff\3\1",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\31\1\32\1\30\1\27",
            "\1\4",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\1\12\uffff\1\22\1\uffff\1\21\20\uffff\1\1\5\uffff\1\3\3\uffff\1\20\122\uffff\3\1",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\40\16\uffff\1\37",
            "\1\42\1\43\31\uffff\1\41",
            "\1\45\10\uffff\1\46\20\uffff\1\47\1\44",
            "\1\51\10\uffff\1\52\20\uffff\1\53\1\50",
            "\1\1\12\uffff\1\22\22\uffff\1\1\5\uffff\1\3\126\uffff\3\1",
            "\1\56\1\uffff\1\55\1\54",
            "\1\61\1\uffff\1\60\1\57",
            "\1\62",
            "\1\63",
            "\1\1\12\uffff\1\64\22\uffff\1\1\5\uffff\1\3\126\uffff\3\1",
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
            "\1\4\13\uffff\1\7\63\uffff\1\100\1\101",
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
            "\1\16\17\uffff\1\116",
            "\1\52\20\uffff\1\53",
            "\1\117",
            "\1\120",
            "\1\17\15\uffff\1\121",
            "\1\123\16\uffff\1\122",
            "\1\124",
            "\1\126\10\uffff\1\46\20\uffff\1\47\1\125",
            "\1\104\14\uffff\1\105",
            "\1\1\12\uffff\1\22\22\uffff\1\1\5\uffff\1\3\126\uffff\3\1",
            "\1\130\10\uffff\1\52\20\uffff\1\53\1\127",
            "\1\110\14\uffff\1\111",
            "\1\1\12\uffff\1\131\22\uffff\1\1\5\uffff\1\3\126\uffff\3\1",
            "\1\134\1\uffff\1\133\1\132",
            "\1\137\1\uffff\1\136\1\135",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\4\13\uffff\1\145",
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
            "\1\1\12\uffff\1\157\22\uffff\1\1\5\uffff\1\3\126\uffff\3\1",
            "\1\153\1\154\31\uffff\1\152",
            "\1\160",
            "\1\4\13\uffff\1\7",
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
    static final String dfa_7s = "\21\uffff";
    static final String dfa_8s = "\1\113\1\5\1\30\1\5\1\uffff\13\5\1\uffff";
    static final String dfa_9s = "\1\113\1\5\1\30\1\u0086\1\uffff\13\34\1\uffff";
    static final String dfa_10s = "\4\uffff\1\1\13\uffff\1\2";
    static final String dfa_11s = "\21\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\150\uffff\2\4\6\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\6\uffff\1\17",
            "",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            "\1\4\26\uffff\1\20",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA116 extends DFA {

        public DFA116(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 116;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "5694:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0800000000012000L,0x0000000000000000L,0x0000000000000037L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0800000000010002L,0x0000000000000000L,0x0000000000000037L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000084000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0800000000010000L,0x0000000000000000L,0x0000000000000037L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001802010000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001812010000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008080000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001800010000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000022810010020L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002810010020L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xFFFFFF1FFFCFE1F0L,0xFFFFFFFFBFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000800010020L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000008090000L,0x0000000000000060L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000060L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000020000010000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000040000000020L,0x000000000000001CL});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000020L,0xFFC0000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000100008000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000010008000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xFFFFFF1FFFCFE1F2L,0xFFFFFFFFBFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x8000010008000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0xFFC0000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000008000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0080000010000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000010000000L,0xFFC0000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000410200000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000410000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000800008000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000003C00000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000400000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0008000064000000L,0x0000000000300000L,0x0000000000000180L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000010009000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000010000000L,0xFFC0000020000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0800000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000010000000L,0x0001000080001800L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000010000000L,0x0001000000001800L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000010000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0001000000001800L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000400001000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0080000000000000L,0x000003FF00000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000001000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000010000020L,0xFFF0C00000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000020L,0xFFF0C00000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000020L,0xFFC0C00000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000020L,0xFFC0800000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000400200000002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000380000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000400001000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0030000000000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000400000040002L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000008080020L,0xFFC0000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x000E080000000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000200000000002L});

}