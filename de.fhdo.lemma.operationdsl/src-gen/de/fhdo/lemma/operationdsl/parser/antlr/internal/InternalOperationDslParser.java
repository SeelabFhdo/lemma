package de.fhdo.lemma.operationdsl.parser.antlr.internal;

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
import de.fhdo.lemma.operationdsl.services.OperationDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOperationDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BOOLEAN", "RULE_BIG_DECIMAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'technology'", "'('", "')'", "'container'", "'deployment'", "'with'", "'operation'", "'environment'", "'deploys'", "','", "'{'", "'aspects'", "'}'", "'default'", "'values'", "'basic'", "'endpoints'", "'::'", "'is'", "'depends'", "'on'", "'nodes'", "'used'", "'by'", "'services'", "'/'", "':'", "';'", "'='", "'import'", "'from'", "'as'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'typedef'", "'noimpl'", "'interface'", "'refers'", "'fault'", "'?'", "'.'", "'data'", "'formats'", "'format'", "'primitive'", "'type'", "'based'", "'list'", "'structure'", "'environments'", "'service'", "'properties'", "'<'", "'>'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'aspect'", "'for'", "'datatypes'", "'context'", "'extends'", "'hide'", "'immutable'", "'enum'", "'procedure'", "'function'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'functional'", "'utility'", "'infrastructure'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'->'", "'<->'", "'mandatory'", "'singleval'", "'parameters'", "'types'", "'fields'", "'containers'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'identifier'", "'part'", "'closure'", "'sideEffectFree'", "'validator'"
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
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
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
    public static final int RULE_SL_COMMENT=10;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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


        public InternalOperationDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOperationDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOperationDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOperationDsl.g"; }



     	private OperationDslGrammarAccess grammarAccess;

        public InternalOperationDslParser(TokenStream input, OperationDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "OperationModel";
       	}

       	@Override
       	protected OperationDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleOperationModel"
    // InternalOperationDsl.g:65:1: entryRuleOperationModel returns [EObject current=null] : iv_ruleOperationModel= ruleOperationModel EOF ;
    public final EObject entryRuleOperationModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationModel = null;


        try {
            // InternalOperationDsl.g:65:55: (iv_ruleOperationModel= ruleOperationModel EOF )
            // InternalOperationDsl.g:66:2: iv_ruleOperationModel= ruleOperationModel EOF
            {
             newCompositeNode(grammarAccess.getOperationModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationModel=ruleOperationModel();

            state._fsp--;

             current =iv_ruleOperationModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationModel"


    // $ANTLR start "ruleOperationModel"
    // InternalOperationDsl.g:72:1: ruleOperationModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_containers_1_0= ruleContainer ) )* ( (lv_infrastructureNodes_2_0= ruleInfrastructureNode ) )* ) ;
    public final EObject ruleOperationModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_containers_1_0 = null;

        EObject lv_infrastructureNodes_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_containers_1_0= ruleContainer ) )* ( (lv_infrastructureNodes_2_0= ruleInfrastructureNode ) )* ) )
            // InternalOperationDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_containers_1_0= ruleContainer ) )* ( (lv_infrastructureNodes_2_0= ruleInfrastructureNode ) )* )
            {
            // InternalOperationDsl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )+ ( (lv_containers_1_0= ruleContainer ) )* ( (lv_infrastructureNodes_2_0= ruleInfrastructureNode ) )* )
            // InternalOperationDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+ ( (lv_containers_1_0= ruleContainer ) )* ( (lv_infrastructureNodes_2_0= ruleInfrastructureNode ) )*
            {
            // InternalOperationDsl.g:80:3: ( (lv_imports_0_0= ruleImport ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==43) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOperationDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalOperationDsl.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalOperationDsl.g:82:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getOperationModelAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationModelRule());
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

            // InternalOperationDsl.g:99:3: ( (lv_containers_1_0= ruleContainer ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalOperationDsl.g:100:4: (lv_containers_1_0= ruleContainer )
            	    {
            	    // InternalOperationDsl.g:100:4: (lv_containers_1_0= ruleContainer )
            	    // InternalOperationDsl.g:101:5: lv_containers_1_0= ruleContainer
            	    {

            	    					newCompositeNode(grammarAccess.getOperationModelAccess().getContainersContainerParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_containers_1_0=ruleContainer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"containers",
            	    						lv_containers_1_0,
            	    						"de.fhdo.lemma.operationdsl.OperationDsl.Container");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalOperationDsl.g:118:3: ( (lv_infrastructureNodes_2_0= ruleInfrastructureNode ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOperationDsl.g:119:4: (lv_infrastructureNodes_2_0= ruleInfrastructureNode )
            	    {
            	    // InternalOperationDsl.g:119:4: (lv_infrastructureNodes_2_0= ruleInfrastructureNode )
            	    // InternalOperationDsl.g:120:5: lv_infrastructureNodes_2_0= ruleInfrastructureNode
            	    {

            	    					newCompositeNode(grammarAccess.getOperationModelAccess().getInfrastructureNodesInfrastructureNodeParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_infrastructureNodes_2_0=ruleInfrastructureNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"infrastructureNodes",
            	    						lv_infrastructureNodes_2_0,
            	    						"de.fhdo.lemma.operationdsl.OperationDsl.InfrastructureNode");
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
    // $ANTLR end "ruleOperationModel"


    // $ANTLR start "entryRuleContainer"
    // InternalOperationDsl.g:141:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // InternalOperationDsl.g:141:50: (iv_ruleContainer= ruleContainer EOF )
            // InternalOperationDsl.g:142:2: iv_ruleContainer= ruleContainer EOF
            {
             newCompositeNode(grammarAccess.getContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainer=ruleContainer();

            state._fsp--;

             current =iv_ruleContainer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainer"


    // $ANTLR start "ruleContainer"
    // InternalOperationDsl.g:148:1: ruleContainer returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* otherlv_18= '{' (otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}' )? (otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}' )? ( (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification ) )* otherlv_40= '}' ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        EObject lv_deploymentTechnology_9_0 = null;

        EObject lv_deployedServices_15_0 = null;

        EObject lv_deployedServices_17_0 = null;

        EObject lv_aspects_21_0 = null;

        EObject lv_defaultServicePropertyValues_26_0 = null;

        EObject lv_defaultBasicEndpoints_30_0 = null;

        EObject lv_defaultServicePropertyValues_32_0 = null;

        EObject lv_defaultBasicEndpoints_36_0 = null;

        EObject lv_deploymentSpecifications_39_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:154:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* otherlv_18= '{' (otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}' )? (otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}' )? ( (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification ) )* otherlv_40= '}' ) )
            // InternalOperationDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* otherlv_18= '{' (otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}' )? (otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}' )? ( (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification ) )* otherlv_40= '}' )
            {
            // InternalOperationDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* otherlv_18= '{' (otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}' )? (otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}' )? ( (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification ) )* otherlv_40= '}' )
            // InternalOperationDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* otherlv_18= '{' (otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}' )? (otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}' )? ( (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification ) )* otherlv_40= '}'
            {
            // InternalOperationDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
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
            	    // InternalOperationDsl.g:157:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getContainerAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getContainerAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getContainerAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalOperationDsl.g:169:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalOperationDsl.g:170:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalOperationDsl.g:170:5: (otherlv_3= RULE_ID )
            	    // InternalOperationDsl.g:171:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContainerRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_3, grammarAccess.getContainerAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_9); 

            	    				newLeafNode(otherlv_4, grammarAccess.getContainerAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            otherlv_5=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getContainerAccess().getContainerKeyword_1());
            		
            // InternalOperationDsl.g:191:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalOperationDsl.g:192:4: (lv_name_6_0= RULE_ID )
            {
            // InternalOperationDsl.g:192:4: (lv_name_6_0= RULE_ID )
            // InternalOperationDsl.g:193:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_6_0, grammarAccess.getContainerAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getContainerAccess().getDeploymentKeyword_3());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getContainerAccess().getTechnologyKeyword_4());
            		
            // InternalOperationDsl.g:217:3: ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) )
            // InternalOperationDsl.g:218:4: (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference )
            {
            // InternalOperationDsl.g:218:4: (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference )
            // InternalOperationDsl.g:219:5: lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference
            {

            					newCompositeNode(grammarAccess.getContainerAccess().getDeploymentTechnologyDeploymentTechnologyReferenceParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_deploymentTechnology_9_0=ruleDeploymentTechnologyReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContainerRule());
            					}
            					set(
            						current,
            						"deploymentTechnology",
            						lv_deploymentTechnology_9_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.DeploymentTechnologyReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:236:3: (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOperationDsl.g:237:4: otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_10, grammarAccess.getContainerAccess().getWithKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_11, grammarAccess.getContainerAccess().getOperationKeyword_6_1());
                    			
                    otherlv_12=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_12, grammarAccess.getContainerAccess().getEnvironmentKeyword_6_2());
                    			
                    // InternalOperationDsl.g:249:4: ( (otherlv_13= RULE_STRING ) )
                    // InternalOperationDsl.g:250:5: (otherlv_13= RULE_STRING )
                    {
                    // InternalOperationDsl.g:250:5: (otherlv_13= RULE_STRING )
                    // InternalOperationDsl.g:251:6: otherlv_13= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContainerRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_STRING,FOLLOW_15); 

                    						newLeafNode(otherlv_13, grammarAccess.getContainerAccess().getOperationEnvironmentOperationEnvironmentCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_14, grammarAccess.getContainerAccess().getDeploysKeyword_7());
            		
            // InternalOperationDsl.g:267:3: ( (lv_deployedServices_15_0= ruleImportedMicroservice ) )
            // InternalOperationDsl.g:268:4: (lv_deployedServices_15_0= ruleImportedMicroservice )
            {
            // InternalOperationDsl.g:268:4: (lv_deployedServices_15_0= ruleImportedMicroservice )
            // InternalOperationDsl.g:269:5: lv_deployedServices_15_0= ruleImportedMicroservice
            {

            					newCompositeNode(grammarAccess.getContainerAccess().getDeployedServicesImportedMicroserviceParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_16);
            lv_deployedServices_15_0=ruleImportedMicroservice();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContainerRule());
            					}
            					add(
            						current,
            						"deployedServices",
            						lv_deployedServices_15_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.ImportedMicroservice");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:286:3: (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOperationDsl.g:287:4: otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) )
            	    {
            	    otherlv_16=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_16, grammarAccess.getContainerAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalOperationDsl.g:291:4: ( (lv_deployedServices_17_0= ruleImportedMicroservice ) )
            	    // InternalOperationDsl.g:292:5: (lv_deployedServices_17_0= ruleImportedMicroservice )
            	    {
            	    // InternalOperationDsl.g:292:5: (lv_deployedServices_17_0= ruleImportedMicroservice )
            	    // InternalOperationDsl.g:293:6: lv_deployedServices_17_0= ruleImportedMicroservice
            	    {

            	    						newCompositeNode(grammarAccess.getContainerAccess().getDeployedServicesImportedMicroserviceParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_deployedServices_17_0=ruleImportedMicroservice();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContainerRule());
            	    						}
            	    						add(
            	    							current,
            	    							"deployedServices",
            	    							lv_deployedServices_17_0,
            	    							"de.fhdo.lemma.operationdsl.OperationDsl.ImportedMicroservice");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_18=(Token)match(input,24,FOLLOW_17); 

            			newLeafNode(otherlv_18, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalOperationDsl.g:315:3: (otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOperationDsl.g:316:4: otherlv_19= 'aspects' otherlv_20= '{' ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,25,FOLLOW_18); 

                    				newLeafNode(otherlv_19, grammarAccess.getContainerAccess().getAspectsKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_20, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalOperationDsl.g:324:4: ( (lv_aspects_21_0= ruleImportedOperationAspect ) )+
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
                    	    // InternalOperationDsl.g:325:5: (lv_aspects_21_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:325:5: (lv_aspects_21_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:326:6: lv_aspects_21_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getContainerAccess().getAspectsImportedOperationAspectParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_aspects_21_0=ruleImportedOperationAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContainerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_21_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.ImportedOperationAspect");
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

                    otherlv_22=(Token)match(input,26,FOLLOW_20); 

                    				newLeafNode(otherlv_22, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:348:3: (otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOperationDsl.g:349:4: otherlv_23= 'default' otherlv_24= 'values' otherlv_25= '{' ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) ) otherlv_38= '}'
                    {
                    otherlv_23=(Token)match(input,27,FOLLOW_21); 

                    				newLeafNode(otherlv_23, grammarAccess.getContainerAccess().getDefaultKeyword_12_0());
                    			
                    otherlv_24=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_24, grammarAccess.getContainerAccess().getValuesKeyword_12_1());
                    			
                    otherlv_25=(Token)match(input,24,FOLLOW_22); 

                    				newLeafNode(otherlv_25, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalOperationDsl.g:361:4: ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) )
                    int alt13=3;
                    alt13 = dfa13.predict(input);
                    switch (alt13) {
                        case 1 :
                            // InternalOperationDsl.g:362:5: ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+
                            {
                            // InternalOperationDsl.g:362:5: ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+
                            int cnt9=0;
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==RULE_ID) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // InternalOperationDsl.g:363:6: (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:363:6: (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:364:7: lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment
                            	    {

                            	    							newCompositeNode(grammarAccess.getContainerAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_12_3_0_0());
                            	    						
                            	    pushFollow(FOLLOW_19);
                            	    lv_defaultServicePropertyValues_26_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"defaultServicePropertyValues",
                            	    								lv_defaultServicePropertyValues_26_0,
                            	    								"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
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


                            }
                            break;
                        case 2 :
                            // InternalOperationDsl.g:382:5: (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' )
                            {
                            // InternalOperationDsl.g:382:5: (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' )
                            // InternalOperationDsl.g:383:6: otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}'
                            {
                            otherlv_27=(Token)match(input,29,FOLLOW_23); 

                            						newLeafNode(otherlv_27, grammarAccess.getContainerAccess().getBasicKeyword_12_3_1_0());
                            					
                            otherlv_28=(Token)match(input,30,FOLLOW_18); 

                            						newLeafNode(otherlv_28, grammarAccess.getContainerAccess().getEndpointsKeyword_12_3_1_1());
                            					
                            otherlv_29=(Token)match(input,24,FOLLOW_7); 

                            						newLeafNode(otherlv_29, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_12_3_1_2());
                            					
                            // InternalOperationDsl.g:395:6: ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+
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
                            	    // InternalOperationDsl.g:396:7: (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint )
                            	    {
                            	    // InternalOperationDsl.g:396:7: (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint )
                            	    // InternalOperationDsl.g:397:8: lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultBasicEndpointsBasicEndpointParserRuleCall_12_3_1_3_0());
                            	    							
                            	    pushFollow(FOLLOW_19);
                            	    lv_defaultBasicEndpoints_30_0=ruleBasicEndpoint();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"defaultBasicEndpoints",
                            	    									lv_defaultBasicEndpoints_30_0,
                            	    									"de.fhdo.lemma.operationdsl.OperationDsl.BasicEndpoint");
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

                            otherlv_31=(Token)match(input,26,FOLLOW_24); 

                            						newLeafNode(otherlv_31, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_12_3_1_4());
                            					

                            }


                            }
                            break;
                        case 3 :
                            // InternalOperationDsl.g:420:5: ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' )
                            {
                            // InternalOperationDsl.g:420:5: ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' )
                            // InternalOperationDsl.g:421:6: ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}'
                            {
                            // InternalOperationDsl.g:421:6: ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+
                            int cnt11=0;
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==RULE_ID) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // InternalOperationDsl.g:422:7: (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:422:7: (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:423:8: lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_12_3_2_0_0());
                            	    							
                            	    pushFollow(FOLLOW_22);
                            	    lv_defaultServicePropertyValues_32_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"defaultServicePropertyValues",
                            	    									lv_defaultServicePropertyValues_32_0,
                            	    									"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt11 >= 1 ) break loop11;
                                        EarlyExitException eee =
                                            new EarlyExitException(11, input);
                                        throw eee;
                                }
                                cnt11++;
                            } while (true);

                            otherlv_33=(Token)match(input,29,FOLLOW_23); 

                            						newLeafNode(otherlv_33, grammarAccess.getContainerAccess().getBasicKeyword_12_3_2_1());
                            					
                            otherlv_34=(Token)match(input,30,FOLLOW_18); 

                            						newLeafNode(otherlv_34, grammarAccess.getContainerAccess().getEndpointsKeyword_12_3_2_2());
                            					
                            otherlv_35=(Token)match(input,24,FOLLOW_7); 

                            						newLeafNode(otherlv_35, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_12_3_2_3());
                            					
                            // InternalOperationDsl.g:452:6: ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+
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
                            	    // InternalOperationDsl.g:453:7: (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint )
                            	    {
                            	    // InternalOperationDsl.g:453:7: (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint )
                            	    // InternalOperationDsl.g:454:8: lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultBasicEndpointsBasicEndpointParserRuleCall_12_3_2_4_0());
                            	    							
                            	    pushFollow(FOLLOW_19);
                            	    lv_defaultBasicEndpoints_36_0=ruleBasicEndpoint();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"defaultBasicEndpoints",
                            	    									lv_defaultBasicEndpoints_36_0,
                            	    									"de.fhdo.lemma.operationdsl.OperationDsl.BasicEndpoint");
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

                            otherlv_37=(Token)match(input,26,FOLLOW_24); 

                            						newLeafNode(otherlv_37, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_12_3_2_5());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_38=(Token)match(input,26,FOLLOW_19); 

                    				newLeafNode(otherlv_38, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_12_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:482:3: ( (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalOperationDsl.g:483:4: (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:483:4: (lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:484:5: lv_deploymentSpecifications_39_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getContainerAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_deploymentSpecifications_39_0=ruleServiceDeploymentSpecification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContainerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deploymentSpecifications",
            	    						lv_deploymentSpecifications_39_0,
            	    						"de.fhdo.lemma.operationdsl.OperationDsl.ServiceDeploymentSpecification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_40=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_40, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainer"


    // $ANTLR start "entryRuleDeploymentTechnologyReference"
    // InternalOperationDsl.g:509:1: entryRuleDeploymentTechnologyReference returns [EObject current=null] : iv_ruleDeploymentTechnologyReference= ruleDeploymentTechnologyReference EOF ;
    public final EObject entryRuleDeploymentTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnologyReference = null;


        try {
            // InternalOperationDsl.g:509:70: (iv_ruleDeploymentTechnologyReference= ruleDeploymentTechnologyReference EOF )
            // InternalOperationDsl.g:510:2: iv_ruleDeploymentTechnologyReference= ruleDeploymentTechnologyReference EOF
            {
             newCompositeNode(grammarAccess.getDeploymentTechnologyReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeploymentTechnologyReference=ruleDeploymentTechnologyReference();

            state._fsp--;

             current =iv_ruleDeploymentTechnologyReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeploymentTechnologyReference"


    // $ANTLR start "ruleDeploymentTechnologyReference"
    // InternalOperationDsl.g:516:1: ruleDeploymentTechnologyReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDeploymentTechnologyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:522:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:523:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:523:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:524:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:524:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:525:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:525:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:526:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeploymentTechnologyReferenceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getDeploymentTechnologyReferenceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyReferenceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:541:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:542:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:542:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:543:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeploymentTechnologyReferenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDeploymentTechnologyReferenceAccess().getDeploymentTechnologyDeploymentTechnologyCrossReference_2_0());
            				
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
    // $ANTLR end "ruleDeploymentTechnologyReference"


    // $ANTLR start "entryRuleInfrastructureNode"
    // InternalOperationDsl.g:561:1: entryRuleInfrastructureNode returns [EObject current=null] : iv_ruleInfrastructureNode= ruleInfrastructureNode EOF ;
    public final EObject entryRuleInfrastructureNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureNode = null;


        try {
            // InternalOperationDsl.g:561:59: (iv_ruleInfrastructureNode= ruleInfrastructureNode EOF )
            // InternalOperationDsl.g:562:2: iv_ruleInfrastructureNode= ruleInfrastructureNode EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfrastructureNode=ruleInfrastructureNode();

            state._fsp--;

             current =iv_ruleInfrastructureNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfrastructureNode"


    // $ANTLR start "ruleInfrastructureNode"
    // InternalOperationDsl.g:568:1: ruleInfrastructureNode returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' ) ;
    public final EObject ruleInfrastructureNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        EObject lv_infrastructureTechnology_7_0 = null;

        EObject lv_deployedServices_21_0 = null;

        EObject lv_deployedServices_23_0 = null;

        EObject lv_aspects_33_0 = null;

        EObject lv_defaultServicePropertyValues_38_0 = null;

        EObject lv_endpoints_42_0 = null;

        EObject lv_deploymentSpecifications_44_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:574:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' ) )
            // InternalOperationDsl.g:575:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' )
            {
            // InternalOperationDsl.g:575:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' )
            // InternalOperationDsl.g:576:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}'
            {
            // InternalOperationDsl.g:576:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==13) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalOperationDsl.g:577:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getInfrastructureNodeAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getInfrastructureNodeAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInfrastructureNodeAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalOperationDsl.g:589:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalOperationDsl.g:590:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalOperationDsl.g:590:5: (otherlv_3= RULE_ID )
            	    // InternalOperationDsl.g:591:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getInfrastructureNodeRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_3, grammarAccess.getInfrastructureNodeAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_26); 

            	    				newLeafNode(otherlv_4, grammarAccess.getInfrastructureNodeAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            // InternalOperationDsl.g:607:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:608:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:608:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:609:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_5_0, grammarAccess.getInfrastructureNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfrastructureNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_6=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getInfrastructureNodeAccess().getIsKeyword_2());
            		
            // InternalOperationDsl.g:629:3: ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) )
            // InternalOperationDsl.g:630:4: (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference )
            {
            // InternalOperationDsl.g:630:4: (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference )
            // InternalOperationDsl.g:631:5: lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference
            {

            					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getInfrastructureTechnologyInfrastructureTechnologyReferenceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_28);
            lv_infrastructureTechnology_7_0=ruleInfrastructureTechnologyReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
            					}
            					set(
            						current,
            						"infrastructureTechnology",
            						lv_infrastructureTechnology_7_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.InfrastructureTechnologyReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:648:3: (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalOperationDsl.g:649:4: otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_8, grammarAccess.getInfrastructureNodeAccess().getWithKeyword_4_0());
                    			
                    otherlv_9=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureNodeAccess().getOperationKeyword_4_1());
                    			
                    otherlv_10=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureNodeAccess().getEnvironmentKeyword_4_2());
                    			
                    // InternalOperationDsl.g:661:4: ( (otherlv_11= RULE_STRING ) )
                    // InternalOperationDsl.g:662:5: (otherlv_11= RULE_STRING )
                    {
                    // InternalOperationDsl.g:662:5: (otherlv_11= RULE_STRING )
                    // InternalOperationDsl.g:663:6: otherlv_11= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInfrastructureNodeRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_STRING,FOLLOW_29); 

                    						newLeafNode(otherlv_11, grammarAccess.getInfrastructureNodeAccess().getOperationEnvironmentOperationEnvironmentCrossReference_4_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:675:3: (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOperationDsl.g:676:4: otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )*
                    {
                    otherlv_12=(Token)match(input,33,FOLLOW_30); 

                    				newLeafNode(otherlv_12, grammarAccess.getInfrastructureNodeAccess().getDependsKeyword_5_0());
                    			
                    otherlv_13=(Token)match(input,34,FOLLOW_31); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureNodeAccess().getOnKeyword_5_1());
                    			
                    otherlv_14=(Token)match(input,35,FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getInfrastructureNodeAccess().getNodesKeyword_5_2());
                    			
                    // InternalOperationDsl.g:688:4: ( (otherlv_15= RULE_ID ) )
                    // InternalOperationDsl.g:689:5: (otherlv_15= RULE_ID )
                    {
                    // InternalOperationDsl.g:689:5: (otherlv_15= RULE_ID )
                    // InternalOperationDsl.g:690:6: otherlv_15= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInfrastructureNodeRule());
                    						}
                    					
                    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_15, grammarAccess.getInfrastructureNodeAccess().getDependsOnNodesOperationNodeCrossReference_5_3_0());
                    					

                    }


                    }

                    // InternalOperationDsl.g:701:4: (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==23) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalOperationDsl.g:702:5: otherlv_16= ',' ( (otherlv_17= RULE_ID ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_5_4_0());
                    	    				
                    	    // InternalOperationDsl.g:706:5: ( (otherlv_17= RULE_ID ) )
                    	    // InternalOperationDsl.g:707:6: (otherlv_17= RULE_ID )
                    	    {
                    	    // InternalOperationDsl.g:707:6: (otherlv_17= RULE_ID )
                    	    // InternalOperationDsl.g:708:7: otherlv_17= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getInfrastructureNodeRule());
                    	    							}
                    	    						
                    	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_32); 

                    	    							newLeafNode(otherlv_17, grammarAccess.getInfrastructureNodeAccess().getDependsOnNodesOperationNodeCrossReference_5_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:721:3: (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==36) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==37) ) {
                    int LA21_3 = input.LA(3);

                    if ( (LA21_3==38) ) {
                        alt21=1;
                    }
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalOperationDsl.g:722:4: otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )*
                    {
                    otherlv_18=(Token)match(input,36,FOLLOW_33); 

                    				newLeafNode(otherlv_18, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_6_0());
                    			
                    otherlv_19=(Token)match(input,37,FOLLOW_34); 

                    				newLeafNode(otherlv_19, grammarAccess.getInfrastructureNodeAccess().getByKeyword_6_1());
                    			
                    otherlv_20=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_20, grammarAccess.getInfrastructureNodeAccess().getServicesKeyword_6_2());
                    			
                    // InternalOperationDsl.g:734:4: ( (lv_deployedServices_21_0= ruleImportedMicroservice ) )
                    // InternalOperationDsl.g:735:5: (lv_deployedServices_21_0= ruleImportedMicroservice )
                    {
                    // InternalOperationDsl.g:735:5: (lv_deployedServices_21_0= ruleImportedMicroservice )
                    // InternalOperationDsl.g:736:6: lv_deployedServices_21_0= ruleImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeployedServicesImportedMicroserviceParserRuleCall_6_3_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_deployedServices_21_0=ruleImportedMicroservice();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    						}
                    						add(
                    							current,
                    							"deployedServices",
                    							lv_deployedServices_21_0,
                    							"de.fhdo.lemma.operationdsl.OperationDsl.ImportedMicroservice");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOperationDsl.g:753:4: (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==23) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalOperationDsl.g:754:5: otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) )
                    	    {
                    	    otherlv_22=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_6_4_0());
                    	    				
                    	    // InternalOperationDsl.g:758:5: ( (lv_deployedServices_23_0= ruleImportedMicroservice ) )
                    	    // InternalOperationDsl.g:759:6: (lv_deployedServices_23_0= ruleImportedMicroservice )
                    	    {
                    	    // InternalOperationDsl.g:759:6: (lv_deployedServices_23_0= ruleImportedMicroservice )
                    	    // InternalOperationDsl.g:760:7: lv_deployedServices_23_0= ruleImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeployedServicesImportedMicroserviceParserRuleCall_6_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    lv_deployedServices_23_0=ruleImportedMicroservice();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"deployedServices",
                    	    								lv_deployedServices_23_0,
                    	    								"de.fhdo.lemma.operationdsl.OperationDsl.ImportedMicroservice");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:779:3: (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOperationDsl.g:780:4: otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (otherlv_27= RULE_ID ) ) (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )*
                    {
                    otherlv_24=(Token)match(input,36,FOLLOW_33); 

                    				newLeafNode(otherlv_24, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_7_0());
                    			
                    otherlv_25=(Token)match(input,37,FOLLOW_31); 

                    				newLeafNode(otherlv_25, grammarAccess.getInfrastructureNodeAccess().getByKeyword_7_1());
                    			
                    otherlv_26=(Token)match(input,35,FOLLOW_7); 

                    				newLeafNode(otherlv_26, grammarAccess.getInfrastructureNodeAccess().getNodesKeyword_7_2());
                    			
                    // InternalOperationDsl.g:792:4: ( (otherlv_27= RULE_ID ) )
                    // InternalOperationDsl.g:793:5: (otherlv_27= RULE_ID )
                    {
                    // InternalOperationDsl.g:793:5: (otherlv_27= RULE_ID )
                    // InternalOperationDsl.g:794:6: otherlv_27= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInfrastructureNodeRule());
                    						}
                    					
                    otherlv_27=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_27, grammarAccess.getInfrastructureNodeAccess().getUsedByNodesOperationNodeCrossReference_7_3_0());
                    					

                    }


                    }

                    // InternalOperationDsl.g:805:4: (otherlv_28= ',' ( (otherlv_29= RULE_ID ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==23) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalOperationDsl.g:806:5: otherlv_28= ',' ( (otherlv_29= RULE_ID ) )
                    	    {
                    	    otherlv_28=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_7_4_0());
                    	    				
                    	    // InternalOperationDsl.g:810:5: ( (otherlv_29= RULE_ID ) )
                    	    // InternalOperationDsl.g:811:6: (otherlv_29= RULE_ID )
                    	    {
                    	    // InternalOperationDsl.g:811:6: (otherlv_29= RULE_ID )
                    	    // InternalOperationDsl.g:812:7: otherlv_29= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getInfrastructureNodeRule());
                    	    							}
                    	    						
                    	    otherlv_29=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    							newLeafNode(otherlv_29, grammarAccess.getInfrastructureNodeAccess().getUsedByNodesOperationNodeCrossReference_7_4_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_30=(Token)match(input,24,FOLLOW_35); 

            			newLeafNode(otherlv_30, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalOperationDsl.g:829:3: (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==25) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOperationDsl.g:830:4: otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}'
                    {
                    otherlv_31=(Token)match(input,25,FOLLOW_18); 

                    				newLeafNode(otherlv_31, grammarAccess.getInfrastructureNodeAccess().getAspectsKeyword_9_0());
                    			
                    otherlv_32=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_9_1());
                    			
                    // InternalOperationDsl.g:838:4: ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalOperationDsl.g:839:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:839:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:840:6: lv_aspects_33_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getAspectsImportedOperationAspectParserRuleCall_9_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_aspects_33_0=ruleImportedOperationAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_33_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.ImportedOperationAspect");
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

                    otherlv_34=(Token)match(input,26,FOLLOW_36); 

                    				newLeafNode(otherlv_34, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:862:3: (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==27) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOperationDsl.g:863:4: otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}'
                    {
                    otherlv_35=(Token)match(input,27,FOLLOW_21); 

                    				newLeafNode(otherlv_35, grammarAccess.getInfrastructureNodeAccess().getDefaultKeyword_10_0());
                    			
                    otherlv_36=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_36, grammarAccess.getInfrastructureNodeAccess().getValuesKeyword_10_1());
                    			
                    otherlv_37=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_37, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalOperationDsl.g:875:4: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
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
                    	    // InternalOperationDsl.g:876:5: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                    	    {
                    	    // InternalOperationDsl.g:876:5: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                    	    // InternalOperationDsl.g:877:6: lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_10_3_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_defaultServicePropertyValues_38_0=rulePropertyValueAssignment();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"defaultServicePropertyValues",
                    	    							lv_defaultServicePropertyValues_38_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
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

                    otherlv_39=(Token)match(input,26,FOLLOW_37); 

                    				newLeafNode(otherlv_39, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:899:3: (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalOperationDsl.g:900:4: otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}'
                    {
                    otherlv_40=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_40, grammarAccess.getInfrastructureNodeAccess().getEndpointsKeyword_11_0());
                    			
                    otherlv_41=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_41, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalOperationDsl.g:908:4: ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:909:5: (lv_endpoints_42_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:909:5: (lv_endpoints_42_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:910:6: lv_endpoints_42_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getEndpointsBasicEndpointParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_endpoints_42_0=ruleBasicEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_42_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.BasicEndpoint");
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

                    otherlv_43=(Token)match(input,26,FOLLOW_19); 

                    				newLeafNode(otherlv_43, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:932:3: ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOperationDsl.g:933:4: (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:933:4: (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:934:5: lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_deploymentSpecifications_44_0=ruleServiceDeploymentSpecification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deploymentSpecifications",
            	    						lv_deploymentSpecifications_44_0,
            	    						"de.fhdo.lemma.operationdsl.OperationDsl.ServiceDeploymentSpecification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_45=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_45, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfrastructureNode"


    // $ANTLR start "entryRuleInfrastructureTechnologyReference"
    // InternalOperationDsl.g:959:1: entryRuleInfrastructureTechnologyReference returns [EObject current=null] : iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF ;
    public final EObject entryRuleInfrastructureTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnologyReference = null;


        try {
            // InternalOperationDsl.g:959:74: (iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF )
            // InternalOperationDsl.g:960:2: iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureTechnologyReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfrastructureTechnologyReference=ruleInfrastructureTechnologyReference();

            state._fsp--;

             current =iv_ruleInfrastructureTechnologyReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfrastructureTechnologyReference"


    // $ANTLR start "ruleInfrastructureTechnologyReference"
    // InternalOperationDsl.g:966:1: ruleInfrastructureTechnologyReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleInfrastructureTechnologyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:972:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:973:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:973:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:974:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:974:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:975:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:975:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:976:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfrastructureTechnologyReferenceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getInfrastructureTechnologyReferenceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyReferenceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:991:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:992:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:992:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:993:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfrastructureTechnologyReferenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyReferenceAccess().getInfrastructureTechnologyInfrastructureTechnologyCrossReference_2_0());
            				
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
    // $ANTLR end "ruleInfrastructureTechnologyReference"


    // $ANTLR start "entryRuleProtocolAndDataFormat"
    // InternalOperationDsl.g:1011:1: entryRuleProtocolAndDataFormat returns [EObject current=null] : iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF ;
    public final EObject entryRuleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:1011:62: (iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:1012:2: iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF
            {
             newCompositeNode(grammarAccess.getProtocolAndDataFormatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProtocolAndDataFormat=ruleProtocolAndDataFormat();

            state._fsp--;

             current =iv_ruleProtocolAndDataFormat; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProtocolAndDataFormat"


    // $ANTLR start "ruleProtocolAndDataFormat"
    // InternalOperationDsl.g:1018:1: ruleProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1024:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalOperationDsl.g:1025:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalOperationDsl.g:1025:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalOperationDsl.g:1026:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalOperationDsl.g:1026:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1027:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1027:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1028:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getProtocolAndDataFormatAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1043:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1044:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1044:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1045:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getProtocolAndDataFormatAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_38);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1059:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOperationDsl.g:1060:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalOperationDsl.g:1064:4: ( (otherlv_4= RULE_ID ) )
                    // InternalOperationDsl.g:1065:5: (otherlv_4= RULE_ID )
                    {
                    // InternalOperationDsl.g:1065:5: (otherlv_4= RULE_ID )
                    // InternalOperationDsl.g:1066:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_4, grammarAccess.getProtocolAndDataFormatAccess().getDataFormatDataFormatCrossReference_3_1_0());
                    					

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
    // $ANTLR end "ruleProtocolAndDataFormat"


    // $ANTLR start "entryRuleBasicEndpoint"
    // InternalOperationDsl.g:1082:1: entryRuleBasicEndpoint returns [EObject current=null] : iv_ruleBasicEndpoint= ruleBasicEndpoint EOF ;
    public final EObject entryRuleBasicEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicEndpoint = null;


        try {
            // InternalOperationDsl.g:1082:54: (iv_ruleBasicEndpoint= ruleBasicEndpoint EOF )
            // InternalOperationDsl.g:1083:2: iv_ruleBasicEndpoint= ruleBasicEndpoint EOF
            {
             newCompositeNode(grammarAccess.getBasicEndpointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasicEndpoint=ruleBasicEndpoint();

            state._fsp--;

             current =iv_ruleBasicEndpoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicEndpoint"


    // $ANTLR start "ruleBasicEndpoint"
    // InternalOperationDsl.g:1089:1: ruleBasicEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
    public final EObject ruleBasicEndpoint() throws RecognitionException {
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
            // InternalOperationDsl.g:1095:2: ( ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:1096:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:1096:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:1097:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:1097:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) )
            // InternalOperationDsl.g:1098:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:1098:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            // InternalOperationDsl.g:1099:5: lv_protocols_0_0= ruleProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
            lv_protocols_0_0=ruleProtocolAndDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBasicEndpointRule());
            					}
            					add(
            						current,
            						"protocols",
            						lv_protocols_0_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.ProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1116:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==23) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOperationDsl.g:1117:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getBasicEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:1121:4: ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:1122:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:1122:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    // InternalOperationDsl.g:1123:6: lv_protocols_2_0= ruleProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_protocols_2_0=ruleProtocolAndDataFormat();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBasicEndpointRule());
            	    						}
            	    						add(
            	    							current,
            	    							"protocols",
            	    							lv_protocols_2_0,
            	    							"de.fhdo.lemma.operationdsl.OperationDsl.ProtocolAndDataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getBasicEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:1145:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:1146:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1146:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:1147:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getBasicEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBasicEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalOperationDsl.g:1163:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==23) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOperationDsl.g:1164:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getBasicEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:1168:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:1169:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:1169:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:1170:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getBasicEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBasicEndpointRule());
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
            	    break loop33;
                }
            } while (true);

            otherlv_7=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getBasicEndpointAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicEndpoint"


    // $ANTLR start "entryRuleServiceDeploymentSpecification"
    // InternalOperationDsl.g:1195:1: entryRuleServiceDeploymentSpecification returns [EObject current=null] : iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF ;
    public final EObject entryRuleServiceDeploymentSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceDeploymentSpecification = null;


        try {
            // InternalOperationDsl.g:1195:71: (iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF )
            // InternalOperationDsl.g:1196:2: iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF
            {
             newCompositeNode(grammarAccess.getServiceDeploymentSpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceDeploymentSpecification=ruleServiceDeploymentSpecification();

            state._fsp--;

             current =iv_ruleServiceDeploymentSpecification; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceDeploymentSpecification"


    // $ANTLR start "ruleServiceDeploymentSpecification"
    // InternalOperationDsl.g:1202:1: ruleServiceDeploymentSpecification returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject ruleServiceDeploymentSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_servicePropertyValues_4_0 = null;

        EObject lv_basicEndpoints_8_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:1208:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) )
            // InternalOperationDsl.g:1209:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            {
            // InternalOperationDsl.g:1209:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            // InternalOperationDsl.g:1210:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}'
            {
            // InternalOperationDsl.g:1210:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1211:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1211:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1212:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceDeploymentSpecificationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getServiceDeploymentSpecificationAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceDeploymentSpecificationAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1227:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1228:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1228:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1229:5: ruleQualifiedNameWithAtLeastOneLevel
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceDeploymentSpecificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServiceImportedMicroserviceCrossReference_2_0());
            				
            pushFollow(FOLLOW_18);
            ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:1247:3: ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalOperationDsl.g:1248:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    {
            	    // InternalOperationDsl.g:1248:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    // InternalOperationDsl.g:1249:5: lv_servicePropertyValues_4_0= rulePropertyValueAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServicePropertyValuesPropertyValueAssignmentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_41);
            	    lv_servicePropertyValues_4_0=rulePropertyValueAssignment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getServiceDeploymentSpecificationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"servicePropertyValues",
            	    						lv_servicePropertyValues_4_0,
            	    						"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalOperationDsl.g:1266:3: (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==29) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalOperationDsl.g:1267:4: otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,29,FOLLOW_23); 

                    				newLeafNode(otherlv_5, grammarAccess.getServiceDeploymentSpecificationAccess().getBasicKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceDeploymentSpecificationAccess().getEndpointsKeyword_5_1());
                    			
                    otherlv_7=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_5_2());
                    			
                    // InternalOperationDsl.g:1279:4: ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1280:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1280:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:1281:6: lv_basicEndpoints_8_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getBasicEndpointsBasicEndpointParserRuleCall_5_3_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_basicEndpoints_8_0=ruleBasicEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getServiceDeploymentSpecificationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"basicEndpoints",
                    	    							lv_basicEndpoints_8_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.BasicEndpoint");
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

                    otherlv_9=(Token)match(input,26,FOLLOW_24); 

                    				newLeafNode(otherlv_9, grammarAccess.getServiceDeploymentSpecificationAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getServiceDeploymentSpecificationAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceDeploymentSpecification"


    // $ANTLR start "entryRuleImportedMicroservice"
    // InternalOperationDsl.g:1311:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:1311:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalOperationDsl.g:1312:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalOperationDsl.g:1318:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1324:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalOperationDsl.g:1325:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalOperationDsl.g:1325:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalOperationDsl.g:1326:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalOperationDsl.g:1326:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1327:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1327:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1328:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1343:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1344:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1344:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1345:5: ruleQualifiedNameWithAtLeastOneLevel
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


    // $ANTLR start "entryRulePropertyValueAssignment"
    // InternalOperationDsl.g:1363:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalOperationDsl.g:1363:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalOperationDsl.g:1364:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalOperationDsl.g:1370:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) ;
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
            // InternalOperationDsl.g:1376:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) )
            // InternalOperationDsl.g:1377:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            {
            // InternalOperationDsl.g:1377:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==42) ) {
                    alt37=1;
                }
                else if ( (LA37_1==15) ) {
                    alt37=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalOperationDsl.g:1378:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    {
                    // InternalOperationDsl.g:1378:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    // InternalOperationDsl.g:1379:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
                    {
                    // InternalOperationDsl.g:1379:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:1380:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1380:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:1381:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_43); 

                    				newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:1396:4: ( (lv_value_2_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:1397:5: (lv_value_2_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:1397:5: (lv_value_2_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:1398:6: lv_value_2_0= rulePrimitiveValue
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
                    // InternalOperationDsl.g:1417:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    {
                    // InternalOperationDsl.g:1417:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    // InternalOperationDsl.g:1418:4: ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')'
                    {
                    // InternalOperationDsl.g:1418:4: ( (otherlv_3= RULE_ID ) )
                    // InternalOperationDsl.g:1419:5: (otherlv_3= RULE_ID )
                    {
                    // InternalOperationDsl.g:1419:5: (otherlv_3= RULE_ID )
                    // InternalOperationDsl.g:1420:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_3, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_43); 

                    				newLeafNode(otherlv_4, grammarAccess.getPropertyValueAssignmentAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOperationDsl.g:1435:4: ( (lv_value_5_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:1436:5: (lv_value_5_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:1436:5: (lv_value_5_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:1437:6: lv_value_5_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getPropertyValueAssignmentAccess().getValuePrimitiveValueParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_8);
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

                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

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


    // $ANTLR start "entryRuleImportedOperationAspect"
    // InternalOperationDsl.g:1463:1: entryRuleImportedOperationAspect returns [EObject current=null] : iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF ;
    public final EObject entryRuleImportedOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedOperationAspect = null;


        try {
            // InternalOperationDsl.g:1463:64: (iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF )
            // InternalOperationDsl.g:1464:2: iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF
            {
             newCompositeNode(grammarAccess.getImportedOperationAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedOperationAspect=ruleImportedOperationAspect();

            state._fsp--;

             current =iv_ruleImportedOperationAspect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedOperationAspect"


    // $ANTLR start "ruleImportedOperationAspect"
    // InternalOperationDsl.g:1470:1: ruleImportedOperationAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) ;
    public final EObject ruleImportedOperationAspect() throws RecognitionException {
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
            // InternalOperationDsl.g:1476:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:1477:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:1477:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            // InternalOperationDsl.g:1478:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';'
            {
            // InternalOperationDsl.g:1478:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1479:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1479:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1480:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedOperationAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedOperationAspectAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1495:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1496:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1496:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1497:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getAspectOperationAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_44);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1511:3: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==15) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOperationDsl.g:1512:4: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_45); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedOperationAspectAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:1516:4: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_BIG_DECIMAL)) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==RULE_ID) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalOperationDsl.g:1517:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:1517:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:1518:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:1518:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:1519:7: lv_singlePropertyValue_4_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_8);
                            lv_singlePropertyValue_4_0=rulePrimitiveValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getImportedOperationAspectRule());
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
                            // InternalOperationDsl.g:1537:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:1537:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:1538:6: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:1538:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:1539:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:1539:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:1540:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_0_0());
                            							
                            pushFollow(FOLLOW_46);
                            lv_values_5_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getImportedOperationAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_5_0,
                            									"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalOperationDsl.g:1557:6: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==23) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // InternalOperationDsl.g:1558:7: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,23,FOLLOW_7); 

                            	    							newLeafNode(otherlv_6, grammarAccess.getImportedOperationAspectAccess().getCommaKeyword_3_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:1562:7: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:1563:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:1563:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:1564:9: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_46);
                            	    lv_values_7_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getImportedOperationAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_7_0,
                            	    										"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop38;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,16,FOLLOW_47); 

                    				newLeafNode(otherlv_8, grammarAccess.getImportedOperationAspectAccess().getRightParenthesisKeyword_3_2());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getImportedOperationAspectAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedOperationAspect"


    // $ANTLR start "entryRuleImport"
    // InternalOperationDsl.g:1597:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalOperationDsl.g:1597:47: (iv_ruleImport= ruleImport EOF )
            // InternalOperationDsl.g:1598:2: iv_ruleImport= ruleImport EOF
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
    // InternalOperationDsl.g:1604:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:1610:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:1611:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:1611:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:1612:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalOperationDsl.g:1616:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalOperationDsl.g:1617:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalOperationDsl.g:1617:4: (lv_importType_1_0= ruleImportType )
            // InternalOperationDsl.g:1618:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_49);
            lv_importType_1_0=ruleImportType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importType",
            						lv_importType_1_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.ImportType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:1639:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:1640:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1640:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:1641:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_50); 

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

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:1661:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:1662:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:1662:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:1663:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:1683:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalOperationDsl.g:1683:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalOperationDsl.g:1684:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalOperationDsl.g:1690:1: ruleMicroservice returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) ;
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
            // InternalOperationDsl.g:1696:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) )
            // InternalOperationDsl.g:1697:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            {
            // InternalOperationDsl.g:1697:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            // InternalOperationDsl.g:1698:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}'
            {
            // InternalOperationDsl.g:1698:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==13) ) {
                    int LA41_1 = input.LA(2);

                    if ( (LA41_1==14) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // InternalOperationDsl.g:1699:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalOperationDsl.g:1699:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalOperationDsl.g:1700:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_51);
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
            	    break loop41;
                }
            } while (true);

            // InternalOperationDsl.g:1717:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==13) ) {
                int LA43_1 = input.LA(2);

                if ( ((LA43_1>=106 && LA43_1<=107)) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalOperationDsl.g:1718:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:1718:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:1719:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:1719:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:1720:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalOperationDsl.g:1737:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==13) ) {
                        int LA42_1 = input.LA(2);

                        if ( ((LA42_1>=106 && LA42_1<=107)) ) {
                            alt42=1;
                        }
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalOperationDsl.g:1738:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:1738:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:1739:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_51);
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

            // InternalOperationDsl.g:1757:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==13) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==30) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalOperationDsl.g:1758:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalOperationDsl.g:1770:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1771:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1771:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:1772:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
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
                    	    if ( cnt44 >= 1 ) break loop44;
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
                    } while (true);

                    otherlv_7=(Token)match(input,16,FOLLOW_51); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1794:3: ( (lv_aspects_8_0= ruleImportedServiceAspect ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==13) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalOperationDsl.g:1795:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:1795:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:1796:5: lv_aspects_8_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_51);
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
            	    break loop46;
                }
            } while (true);

            // InternalOperationDsl.g:1813:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=97 && LA47_0<=99)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalOperationDsl.g:1814:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:1814:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:1815:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_51);
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

            // InternalOperationDsl.g:1832:3: ( (lv_type_10_0= ruleMicroserviceType ) )
            // InternalOperationDsl.g:1833:4: (lv_type_10_0= ruleMicroserviceType )
            {
            // InternalOperationDsl.g:1833:4: (lv_type_10_0= ruleMicroserviceType )
            // InternalOperationDsl.g:1834:5: lv_type_10_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_53);
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

            otherlv_11=(Token)match(input,46,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_6());
            		
            // InternalOperationDsl.g:1855:3: ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1856:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1856:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1857:5: lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_54);
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

            // InternalOperationDsl.g:1874:3: (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==47) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalOperationDsl.g:1875:4: otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) )
                    {
                    otherlv_13=(Token)match(input,47,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalOperationDsl.g:1879:4: ( (lv_version_14_0= RULE_ID ) )
                    // InternalOperationDsl.g:1880:5: (lv_version_14_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1880:5: (lv_version_14_0= RULE_ID )
                    // InternalOperationDsl.g:1881:6: lv_version_14_0= RULE_ID
                    {
                    lv_version_14_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_15=(Token)match(input,24,FOLLOW_55); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalOperationDsl.g:1902:3: (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==48) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==49) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalOperationDsl.g:1903:4: otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}'
                    {
                    otherlv_16=(Token)match(input,48,FOLLOW_56); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_17=(Token)match(input,49,FOLLOW_18); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_18=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalOperationDsl.g:1915:4: ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) )
                    // InternalOperationDsl.g:1916:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalOperationDsl.g:1916:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    // InternalOperationDsl.g:1917:6: lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_57);
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

                    // InternalOperationDsl.g:1934:4: (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==23) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalOperationDsl.g:1935:5: otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_20=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalOperationDsl.g:1939:5: ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalOperationDsl.g:1940:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalOperationDsl.g:1940:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    // InternalOperationDsl.g:1941:7: lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_57);
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
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,26,FOLLOW_55); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1964:3: (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==48) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==50) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalOperationDsl.g:1965:4: otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}'
                    {
                    otherlv_23=(Token)match(input,48,FOLLOW_58); 

                    				newLeafNode(otherlv_23, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_24=(Token)match(input,50,FOLLOW_18); 

                    				newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_25=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalOperationDsl.g:1977:4: ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) )
                    // InternalOperationDsl.g:1978:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    {
                    // InternalOperationDsl.g:1978:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    // InternalOperationDsl.g:1979:6: lv_requiredInterfaces_26_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_57);
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

                    // InternalOperationDsl.g:1996:4: (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==23) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalOperationDsl.g:1997:5: otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_27=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2001:5: ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    // InternalOperationDsl.g:2002:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalOperationDsl.g:2002:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    // InternalOperationDsl.g:2003:7: lv_requiredInterfaces_28_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_57);
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
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,26,FOLLOW_55); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2026:3: (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==48) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalOperationDsl.g:2027:4: otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}'
                    {
                    otherlv_30=(Token)match(input,48,FOLLOW_59); 

                    				newLeafNode(otherlv_30, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_31=(Token)match(input,51,FOLLOW_18); 

                    				newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_32=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalOperationDsl.g:2039:4: ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:2040:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:2040:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:2041:6: lv_requiredOperations_33_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_57);
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

                    // InternalOperationDsl.g:2058:4: (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==23) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2059:5: otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_34=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2063:5: ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    // InternalOperationDsl.g:2064:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalOperationDsl.g:2064:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    // InternalOperationDsl.g:2065:7: lv_requiredOperations_35_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_57);
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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,26,FOLLOW_55); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2088:3: ( (lv_interfaces_37_0= ruleInterface ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==13||(LA55_0>=53 && LA55_0<=54)||(LA55_0>=97 && LA55_0<=99)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalOperationDsl.g:2089:4: (lv_interfaces_37_0= ruleInterface )
            	    {
            	    // InternalOperationDsl.g:2089:4: (lv_interfaces_37_0= ruleInterface )
            	    // InternalOperationDsl.g:2090:5: lv_interfaces_37_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_60);
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
            	    if ( cnt55 >= 1 ) break loop55;
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);

            otherlv_38=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:2115:1: entryRuleTechnologyReference returns [EObject current=null] : iv_ruleTechnologyReference= ruleTechnologyReference EOF ;
    public final EObject entryRuleTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyReference = null;


        try {
            // InternalOperationDsl.g:2115:60: (iv_ruleTechnologyReference= ruleTechnologyReference EOF )
            // InternalOperationDsl.g:2116:2: iv_ruleTechnologyReference= ruleTechnologyReference EOF
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
    // InternalOperationDsl.g:2122:1: ruleTechnologyReference returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) ;
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
            // InternalOperationDsl.g:2128:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) )
            // InternalOperationDsl.g:2129:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            {
            // InternalOperationDsl.g:2129:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            // InternalOperationDsl.g:2130:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOperationDsl.g:2142:3: ( (otherlv_3= RULE_ID ) )
            // InternalOperationDsl.g:2143:4: (otherlv_3= RULE_ID )
            {
            // InternalOperationDsl.g:2143:4: (otherlv_3= RULE_ID )
            // InternalOperationDsl.g:2144:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(otherlv_3, grammarAccess.getTechnologyReferenceAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            // InternalOperationDsl.g:2155:3: (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==23) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalOperationDsl.g:2156:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_61); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,52,FOLLOW_42); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,42,FOLLOW_62); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologyReferenceAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalOperationDsl.g:2168:4: ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:2169:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:2169:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:2170:6: lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN
                    {
                    lv_isTypeDefinitionTechnology_7_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_8); 

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

            otherlv_8=(Token)match(input,16,FOLLOW_2); 

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
    // InternalOperationDsl.g:2195:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:2195:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalOperationDsl.g:2196:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalOperationDsl.g:2202:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2208:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2209:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2209:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2210:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2210:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==31) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalOperationDsl.g:2211:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2211:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2212:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2212:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2213:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2229:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2230:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2230:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2231:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2249:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalOperationDsl.g:2249:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalOperationDsl.g:2250:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalOperationDsl.g:2256:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2262:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2263:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2263:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2264:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2264:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==31) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // InternalOperationDsl.g:2265:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2265:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2266:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2266:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2267:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2283:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2284:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2284:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2285:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2303:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalOperationDsl.g:2303:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalOperationDsl.g:2304:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalOperationDsl.g:2310:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2316:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2317:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2317:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2318:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2318:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==31) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalOperationDsl.g:2319:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2319:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2320:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2320:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2321:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2337:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2338:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2338:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2339:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2357:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalOperationDsl.g:2357:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalOperationDsl.g:2358:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalOperationDsl.g:2364:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) ;
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
            // InternalOperationDsl.g:2370:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) )
            // InternalOperationDsl.g:2371:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            {
            // InternalOperationDsl.g:2371:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            // InternalOperationDsl.g:2372:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}'
            {
            // InternalOperationDsl.g:2372:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==13) ) {
                int LA61_1 = input.LA(2);

                if ( ((LA61_1>=106 && LA61_1<=107)) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalOperationDsl.g:2373:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2373:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2374:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2374:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2375:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_63);
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

                    // InternalOperationDsl.g:2392:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==13) ) {
                        int LA60_1 = input.LA(2);

                        if ( ((LA60_1>=106 && LA60_1<=107)) ) {
                            alt60=1;
                        }
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalOperationDsl.g:2393:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2393:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2394:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_63);
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

            // InternalOperationDsl.g:2412:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==13) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==30) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalOperationDsl.g:2413:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2425:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2426:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2426:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2427:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
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
                    	    if ( cnt62 >= 1 ) break loop62;
                                EarlyExitException eee =
                                    new EarlyExitException(62, input);
                                throw eee;
                        }
                        cnt62++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_63); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2449:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==13) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalOperationDsl.g:2450:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2450:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2451:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_63);
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
            	    break loop64;
                }
            } while (true);

            // InternalOperationDsl.g:2468:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==53) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalOperationDsl.g:2469:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:2469:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalOperationDsl.g:2470:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,53,FOLLOW_64); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2482:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=97 && LA66_0<=99)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalOperationDsl.g:2483:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2483:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:2484:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_65);
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

            otherlv_10=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_10, grammarAccess.getInterfaceAccess().getInterfaceKeyword_5());
            		
            // InternalOperationDsl.g:2505:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalOperationDsl.g:2506:4: (lv_name_11_0= RULE_ID )
            {
            // InternalOperationDsl.g:2506:4: (lv_name_11_0= RULE_ID )
            // InternalOperationDsl.g:2507:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_12=(Token)match(input,24,FOLLOW_66); 

            			newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalOperationDsl.g:2527:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*
            loop67:
            do {
                int alt67=2;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // InternalOperationDsl.g:2528:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    {
            	    // InternalOperationDsl.g:2528:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    // InternalOperationDsl.g:2529:5: lv_referredOperations_13_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    break loop67;
                }
            } while (true);

            // InternalOperationDsl.g:2546:3: ( (lv_operations_14_0= ruleOperation ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID||LA68_0==13||LA68_0==53||(LA68_0>=97 && LA68_0<=99)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalOperationDsl.g:2547:4: (lv_operations_14_0= ruleOperation )
            	    {
            	    // InternalOperationDsl.g:2547:4: (lv_operations_14_0= ruleOperation )
            	    // InternalOperationDsl.g:2548:5: lv_operations_14_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_67);
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
            	    break loop68;
                }
            } while (true);

            otherlv_15=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:2573:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalOperationDsl.g:2573:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalOperationDsl.g:2574:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalOperationDsl.g:2580:1: ruleOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) ;
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
            // InternalOperationDsl.g:2586:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) )
            // InternalOperationDsl.g:2587:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            {
            // InternalOperationDsl.g:2587:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            // InternalOperationDsl.g:2588:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';'
            {
            // InternalOperationDsl.g:2588:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==13) ) {
                int LA70_1 = input.LA(2);

                if ( ((LA70_1>=106 && LA70_1<=107)) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalOperationDsl.g:2589:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2589:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2590:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2590:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2591:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_68);
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

                    // InternalOperationDsl.g:2608:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==13) ) {
                        int LA69_1 = input.LA(2);

                        if ( ((LA69_1>=106 && LA69_1<=107)) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalOperationDsl.g:2609:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2609:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2610:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_68);
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

            // InternalOperationDsl.g:2628:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==13) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==30) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalOperationDsl.g:2629:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2641:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==RULE_ID) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2642:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2642:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2643:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
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
                    	    if ( cnt71 >= 1 ) break loop71;
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_68); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2665:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==13) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalOperationDsl.g:2666:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2666:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2667:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_68);
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
            	    break loop73;
                }
            } while (true);

            // InternalOperationDsl.g:2684:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==53) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalOperationDsl.g:2685:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:2685:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalOperationDsl.g:2686:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,53,FOLLOW_69); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2698:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=97 && LA75_0<=99)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalOperationDsl.g:2699:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2699:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:2700:5: lv_visibility_9_0= ruleVisibility
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

            // InternalOperationDsl.g:2717:3: ( (lv_name_10_0= RULE_ID ) )
            // InternalOperationDsl.g:2718:4: (lv_name_10_0= RULE_ID )
            {
            // InternalOperationDsl.g:2718:4: (lv_name_10_0= RULE_ID )
            // InternalOperationDsl.g:2719:5: lv_name_10_0= RULE_ID
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

            otherlv_11=(Token)match(input,15,FOLLOW_70); 

            			newLeafNode(otherlv_11, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_6());
            		
            // InternalOperationDsl.g:2739:3: ( (lv_parameters_12_0= ruleParameter ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==13||(LA76_0>=106 && LA76_0<=107)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalOperationDsl.g:2740:4: (lv_parameters_12_0= ruleParameter )
                    {
                    // InternalOperationDsl.g:2740:4: (lv_parameters_12_0= ruleParameter )
                    // InternalOperationDsl.g:2741:5: lv_parameters_12_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_46);
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

            // InternalOperationDsl.g:2758:3: (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==23) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalOperationDsl.g:2759:4: otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) )
            	    {
            	    otherlv_13=(Token)match(input,23,FOLLOW_71); 

            	    				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalOperationDsl.g:2763:4: ( (lv_parameters_14_0= ruleParameter ) )
            	    // InternalOperationDsl.g:2764:5: (lv_parameters_14_0= ruleParameter )
            	    {
            	    // InternalOperationDsl.g:2764:5: (lv_parameters_14_0= ruleParameter )
            	    // InternalOperationDsl.g:2765:6: lv_parameters_14_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop77;
                }
            } while (true);

            otherlv_15=(Token)match(input,16,FOLLOW_47); 

            			newLeafNode(otherlv_15, grammarAccess.getOperationAccess().getRightParenthesisKeyword_9());
            		
            otherlv_16=(Token)match(input,41,FOLLOW_2); 

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
    // InternalOperationDsl.g:2795:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalOperationDsl.g:2795:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalOperationDsl.g:2796:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalOperationDsl.g:2802:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalOperationDsl.g:2808:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalOperationDsl.g:2809:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalOperationDsl.g:2809:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalOperationDsl.g:2810:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalOperationDsl.g:2810:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==13) ) {
                int LA79_1 = input.LA(2);

                if ( ((LA79_1>=106 && LA79_1<=107)) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // InternalOperationDsl.g:2811:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2811:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2812:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2812:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2813:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_72);
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

                    // InternalOperationDsl.g:2830:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==13) ) {
                        int LA78_1 = input.LA(2);

                        if ( ((LA78_1>=106 && LA78_1<=107)) ) {
                            alt78=1;
                        }
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalOperationDsl.g:2831:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2831:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2832:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_72);
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

            // InternalOperationDsl.g:2850:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==13) ) {
                int LA81_1 = input.LA(2);

                if ( (LA81_1==30) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // InternalOperationDsl.g:2851:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2863:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2864:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2864:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2865:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
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
                    	    if ( cnt80 >= 1 ) break loop80;
                                EarlyExitException eee =
                                    new EarlyExitException(80, input);
                                throw eee;
                        }
                        cnt80++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_72); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2887:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==13) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalOperationDsl.g:2888:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2888:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2889:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_72);
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
            	    break loop82;
                }
            } while (true);

            otherlv_8=(Token)match(input,55,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalOperationDsl.g:2910:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2911:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2911:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2912:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_47);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,41,FOLLOW_2); 

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
    // InternalOperationDsl.g:2934:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalOperationDsl.g:2934:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalOperationDsl.g:2935:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalOperationDsl.g:2941:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalOperationDsl.g:2947:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalOperationDsl.g:2948:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalOperationDsl.g:2948:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalOperationDsl.g:2949:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalOperationDsl.g:2949:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==13) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalOperationDsl.g:2950:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2950:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2951:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_71);
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
            	    break loop83;
                }
            } while (true);

            // InternalOperationDsl.g:2968:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:2969:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:2969:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:2970:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_73);
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

            // InternalOperationDsl.g:2987:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=103 && LA84_0<=105)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalOperationDsl.g:2988:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:2988:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:2989:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_74);
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

            // InternalOperationDsl.g:3006:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==56) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalOperationDsl.g:3007:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalOperationDsl.g:3007:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalOperationDsl.g:3008:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,56,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:3020:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalOperationDsl.g:3021:4: (lv_name_4_0= RULE_ID )
            {
            // InternalOperationDsl.g:3021:4: (lv_name_4_0= RULE_ID )
            // InternalOperationDsl.g:3022:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_75); 

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

            // InternalOperationDsl.g:3038:3: ( (lv_optional_5_0= '?' ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==57) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalOperationDsl.g:3039:4: (lv_optional_5_0= '?' )
                    {
                    // InternalOperationDsl.g:3039:4: (lv_optional_5_0= '?' )
                    // InternalOperationDsl.g:3040:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,57,FOLLOW_76); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,40,FOLLOW_77); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalOperationDsl.g:3056:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( ((LA87_0>=87 && LA87_0<=96)) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_ID) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalOperationDsl.g:3057:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:3057:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:3058:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:3058:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalOperationDsl.g:3059:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_78);
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
                    // InternalOperationDsl.g:3077:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalOperationDsl.g:3077:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalOperationDsl.g:3078:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalOperationDsl.g:3078:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalOperationDsl.g:3079:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_78);
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

            // InternalOperationDsl.g:3097:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==42) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalOperationDsl.g:3098:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalOperationDsl.g:3102:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:3103:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:3103:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:3104:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalOperationDsl.g:3126:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalOperationDsl.g:3126:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalOperationDsl.g:3127:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalOperationDsl.g:3133:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3139:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:3140:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:3140:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:3141:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:3141:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3142:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3142:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3143:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:3158:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3159:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3159:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3160:5: ruleQualifiedName
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
    // InternalOperationDsl.g:3178:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalOperationDsl.g:3178:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalOperationDsl.g:3179:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalOperationDsl.g:3185:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3191:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalOperationDsl.g:3192:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalOperationDsl.g:3192:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalOperationDsl.g:3193:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_71); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3197:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3198:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3198:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:3199:5: lv_communicationType_1_0= ruleCommunicationType
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
            						"de.fhdo.lemma.technology.TechnologyDsl.CommunicationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOperationDsl.g:3220:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3221:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3221:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3222:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
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
            						"de.fhdo.lemma.ServiceDsl.ImportedProtocolAndDataFormat");
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
    // InternalOperationDsl.g:3247:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:3247:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:3248:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalOperationDsl.g:3254:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3260:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalOperationDsl.g:3261:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalOperationDsl.g:3261:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalOperationDsl.g:3262:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalOperationDsl.g:3262:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3263:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3263:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3264:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:3279:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3280:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3280:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3281:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_38);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:3295:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==39) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalOperationDsl.g:3296:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalOperationDsl.g:3300:4: ( (otherlv_4= RULE_ID ) )
                    // InternalOperationDsl.g:3301:5: (otherlv_4= RULE_ID )
                    {
                    // InternalOperationDsl.g:3301:5: (otherlv_4= RULE_ID )
                    // InternalOperationDsl.g:3302:6: otherlv_4= RULE_ID
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
    // InternalOperationDsl.g:3318:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalOperationDsl.g:3318:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalOperationDsl.g:3319:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalOperationDsl.g:3325:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:3331:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:3332:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:3332:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:3333:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:3333:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3334:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3334:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3335:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
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

            // InternalOperationDsl.g:3352:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==23) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalOperationDsl.g:3353:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:3357:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:3358:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:3358:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalOperationDsl.g:3359:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_39);
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
            	    break loop90;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:3381:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:3382:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:3382:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:3383:5: lv_addresses_4_0= RULE_STRING
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

            // InternalOperationDsl.g:3399:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==23) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalOperationDsl.g:3400:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:3404:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:3405:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:3405:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:3406:6: lv_addresses_6_0= RULE_STRING
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
            	    break loop91;
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
    // InternalOperationDsl.g:3431:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalOperationDsl.g:3431:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalOperationDsl.g:3432:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalOperationDsl.g:3438:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalOperationDsl.g:3444:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalOperationDsl.g:3445:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalOperationDsl.g:3445:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalOperationDsl.g:3446:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3450:3: ( (otherlv_1= RULE_ID ) )
            // InternalOperationDsl.g:3451:4: (otherlv_1= RULE_ID )
            {
            // InternalOperationDsl.g:3451:4: (otherlv_1= RULE_ID )
            // InternalOperationDsl.g:3452:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalOperationDsl.g:3467:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3468:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3468:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3469:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_79);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:3483:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==15) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalOperationDsl.g:3484:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_45); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalOperationDsl.g:3488:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( ((LA93_0>=RULE_STRING && LA93_0<=RULE_BIG_DECIMAL)) ) {
                        alt93=1;
                    }
                    else if ( (LA93_0==RULE_ID) ) {
                        alt93=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 0, input);

                        throw nvae;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalOperationDsl.g:3489:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:3489:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:3490:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:3490:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:3491:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
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
                            								"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalOperationDsl.g:3509:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:3509:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:3510:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:3510:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:3511:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:3511:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:3512:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_46);
                            lv_values_6_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_6_0,
                            									"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalOperationDsl.g:3529:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop92:
                            do {
                                int alt92=2;
                                int LA92_0 = input.LA(1);

                                if ( (LA92_0==23) ) {
                                    alt92=1;
                                }


                                switch (alt92) {
                            	case 1 :
                            	    // InternalOperationDsl.g:3530:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,23,FOLLOW_7); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:3534:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:3535:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:3535:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:3536:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_46);
                            	    lv_values_8_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_8_0,
                            	    										"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop92;
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


    // $ANTLR start "entryRuleQualifiedNameWithAtLeastOneLevel"
    // InternalOperationDsl.g:3565:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalOperationDsl.g:3565:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalOperationDsl.g:3566:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalOperationDsl.g:3572:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3578:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalOperationDsl.g:3579:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalOperationDsl.g:3579:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalOperationDsl.g:3580:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_80); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,58,FOLLOW_7); 

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
    // InternalOperationDsl.g:3606:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalOperationDsl.g:3606:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalOperationDsl.g:3607:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalOperationDsl.g:3613:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:3619:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:3620:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:3620:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:3621:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:3633:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:3634:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:3634:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:3635:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_50); 

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

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:3655:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:3656:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:3656:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:3657:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:3677:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalOperationDsl.g:3677:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalOperationDsl.g:3678:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalOperationDsl.g:3684:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalOperationDsl.g:3690:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalOperationDsl.g:3691:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalOperationDsl.g:3691:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalOperationDsl.g:3692:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalOperationDsl.g:3692:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3693:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3693:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalOperationDsl.g:3694:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalOperationDsl.g:3711:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:3712:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:3712:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:3713:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_81); 

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

            otherlv_2=(Token)match(input,59,FOLLOW_82); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,60,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalOperationDsl.g:3737:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalOperationDsl.g:3738:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalOperationDsl.g:3738:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalOperationDsl.g:3739:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_83);
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

            // InternalOperationDsl.g:3756:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==23) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalOperationDsl.g:3757:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:3761:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalOperationDsl.g:3762:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalOperationDsl.g:3762:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalOperationDsl.g:3763:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_83);
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
            	    break loop95;
                }
            } while (true);

            // InternalOperationDsl.g:3781:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==27) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalOperationDsl.g:3782:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:3782:4: ( (lv_default_7_0= 'default' ) )
                    // InternalOperationDsl.g:3783:5: (lv_default_7_0= 'default' )
                    {
                    // InternalOperationDsl.g:3783:5: (lv_default_7_0= 'default' )
                    // InternalOperationDsl.g:3784:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,27,FOLLOW_84); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_85); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,61,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalOperationDsl.g:3804:4: ( (otherlv_10= RULE_ID ) )
                    // InternalOperationDsl.g:3805:5: (otherlv_10= RULE_ID )
                    {
                    // InternalOperationDsl.g:3805:5: (otherlv_10= RULE_ID )
                    // InternalOperationDsl.g:3806:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_47); 

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
    // InternalOperationDsl.g:3826:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalOperationDsl.g:3826:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalOperationDsl.g:3827:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalOperationDsl.g:3833:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3839:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalOperationDsl.g:3840:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:3840:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalOperationDsl.g:3841:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:3841:3: (lv_formatName_0_0= RULE_ID )
            // InternalOperationDsl.g:3842:4: lv_formatName_0_0= RULE_ID
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
    // InternalOperationDsl.g:3861:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalOperationDsl.g:3861:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalOperationDsl.g:3862:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalOperationDsl.g:3868:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:3874:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:3875:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:3875:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalOperationDsl.g:3876:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_86); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:3884:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:3885:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:3885:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:3886:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_87); 

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

            // InternalOperationDsl.g:3902:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==64) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalOperationDsl.g:3903:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,64,FOLLOW_30); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,34,FOLLOW_88); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalOperationDsl.g:3911:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:3912:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:3912:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalOperationDsl.g:3913:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_83);
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

                    // InternalOperationDsl.g:3930:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==23) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalOperationDsl.g:3931:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_88); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalOperationDsl.g:3935:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalOperationDsl.g:3936:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalOperationDsl.g:3936:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalOperationDsl.g:3937:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_83);
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
                    	    break loop97;
                        }
                    } while (true);

                    // InternalOperationDsl.g:3955:4: ( (lv_default_8_0= 'default' ) )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==27) ) {
                        alt98=1;
                    }
                    switch (alt98) {
                        case 1 :
                            // InternalOperationDsl.g:3956:5: (lv_default_8_0= 'default' )
                            {
                            // InternalOperationDsl.g:3956:5: (lv_default_8_0= 'default' )
                            // InternalOperationDsl.g:3957:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,27,FOLLOW_47); 

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
    // InternalOperationDsl.g:3978:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalOperationDsl.g:3978:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalOperationDsl.g:3979:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalOperationDsl.g:3985:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3991:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:3992:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:3992:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:3993:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_86); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:4001:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:4002:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:4002:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:4003:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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

            otherlv_3=(Token)match(input,41,FOLLOW_2); 

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
    // InternalOperationDsl.g:4027:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalOperationDsl.g:4027:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalOperationDsl.g:4028:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalOperationDsl.g:4034:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:4040:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:4041:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:4041:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:4042:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_86); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:4050:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:4051:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:4051:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:4052:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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
    // InternalOperationDsl.g:4076:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalOperationDsl.g:4076:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalOperationDsl.g:4077:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalOperationDsl.g:4083:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:4089:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:4090:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:4090:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:4091:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:4091:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==RULE_ID) ) {
                int LA100_1 = input.LA(2);

                if ( (LA100_1==31) ) {
                    alt100=1;
                }
            }
            switch (alt100) {
                case 1 :
                    // InternalOperationDsl.g:4092:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:4092:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:4093:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:4093:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:4094:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:4110:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:4111:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:4111:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:4112:5: ruleQualifiedName
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
    // InternalOperationDsl.g:4130:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalOperationDsl.g:4130:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalOperationDsl.g:4131:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalOperationDsl.g:4137:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalOperationDsl.g:4143:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalOperationDsl.g:4144:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalOperationDsl.g:4144:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalOperationDsl.g:4145:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalOperationDsl.g:4145:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:4146:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:4146:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:4147:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_89);
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

            // InternalOperationDsl.g:4164:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==23) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalOperationDsl.g:4165:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:4169:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalOperationDsl.g:4170:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalOperationDsl.g:4170:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalOperationDsl.g:4171:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_89);
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
            	    break loop101;
                }
            } while (true);

            // InternalOperationDsl.g:4189:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalOperationDsl.g:4190:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalOperationDsl.g:4190:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalOperationDsl.g:4191:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalOperationDsl.g:4208:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:4209:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:4209:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:4210:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_47);
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
    // InternalOperationDsl.g:4235:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalOperationDsl.g:4235:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalOperationDsl.g:4236:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalOperationDsl.g:4242:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:4248:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:4249:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:4249:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:4250:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:4250:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:4251:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:4251:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:4252:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,24,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_90); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,67,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:4284:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:4285:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:4285:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:4286:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:4303:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==23) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalOperationDsl.g:4304:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:4308:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:4309:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:4309:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:4310:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_91); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:4332:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==68) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalOperationDsl.g:4333:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,68,FOLLOW_92); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,69,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,24,FOLLOW_88); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:4345:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt103=0;
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( ((LA103_0>=87 && LA103_0<=96)) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4346:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:4346:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:4347:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_93);
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
                    	    if ( cnt103 >= 1 ) break loop103;
                                EarlyExitException eee =
                                    new EarlyExitException(103, input);
                                throw eee;
                        }
                        cnt103++;
                    } while (true);

                    otherlv_13=(Token)match(input,26,FOLLOW_24); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:4377:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalOperationDsl.g:4377:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalOperationDsl.g:4378:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalOperationDsl.g:4384:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:4390:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:4391:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:4391:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:4392:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:4392:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:4393:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:4393:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:4394:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,24,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_90); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,67,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:4426:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:4427:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:4427:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:4428:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:4445:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==23) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalOperationDsl.g:4446:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:4450:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:4451:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:4451:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:4452:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_91); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:4474:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==68) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalOperationDsl.g:4475:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,68,FOLLOW_92); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,69,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,24,FOLLOW_88); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:4487:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt106=0;
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( ((LA106_0>=87 && LA106_0<=96)) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4488:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:4488:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:4489:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_93);
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
                    	    if ( cnt106 >= 1 ) break loop106;
                                EarlyExitException eee =
                                    new EarlyExitException(106, input);
                                throw eee;
                        }
                        cnt106++;
                    } while (true);

                    otherlv_13=(Token)match(input,26,FOLLOW_24); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:4519:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalOperationDsl.g:4519:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalOperationDsl.g:4520:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalOperationDsl.g:4526:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:4532:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalOperationDsl.g:4533:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalOperationDsl.g:4533:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalOperationDsl.g:4534:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalOperationDsl.g:4534:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalOperationDsl.g:4535:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalOperationDsl.g:4535:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalOperationDsl.g:4536:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_94); 

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

            // InternalOperationDsl.g:4552:3: ( (lv_default_1_0= 'default' ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==27) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalOperationDsl.g:4553:4: (lv_default_1_0= 'default' )
                    {
                    // InternalOperationDsl.g:4553:4: (lv_default_1_0= 'default' )
                    // InternalOperationDsl.g:4554:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,27,FOLLOW_2); 

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
    // InternalOperationDsl.g:4570:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalOperationDsl.g:4570:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalOperationDsl.g:4571:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalOperationDsl.g:4577:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:4583:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:4584:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:4584:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalOperationDsl.g:4585:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalOperationDsl.g:4585:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalOperationDsl.g:4586:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalOperationDsl.g:4586:4: (lv_type_0_0= rulePrimitiveType )
            // InternalOperationDsl.g:4587:5: lv_type_0_0= rulePrimitiveType
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

            // InternalOperationDsl.g:4604:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:4605:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:4605:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:4606:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_95); 

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

            // InternalOperationDsl.g:4622:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==42) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalOperationDsl.g:4623:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_43); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:4627:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:4628:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:4628:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:4629:6: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_96);
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

            // InternalOperationDsl.g:4647:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==70) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalOperationDsl.g:4648:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,70,FOLLOW_97); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalOperationDsl.g:4652:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalOperationDsl.g:4653:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalOperationDsl.g:4653:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalOperationDsl.g:4654:6: lv_features_5_0= rulePropertyFeature
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_98);
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

                    // InternalOperationDsl.g:4671:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop110:
                    do {
                        int alt110=2;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==23) ) {
                            alt110=1;
                        }


                        switch (alt110) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4672:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_97); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalOperationDsl.g:4676:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalOperationDsl.g:4677:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalOperationDsl.g:4677:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalOperationDsl.g:4678:7: lv_features_7_0= rulePropertyFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_98);
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
                    	    break loop110;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,71,FOLLOW_47); 

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
    // InternalOperationDsl.g:4709:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalOperationDsl.g:4709:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalOperationDsl.g:4710:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalOperationDsl.g:4716:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalOperationDsl.g:4722:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalOperationDsl.g:4723:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalOperationDsl.g:4723:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt112=4;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt112=1;
                }
                break;
            case 73:
                {
                alt112=2;
                }
                break;
            case 74:
                {
                alt112=3;
                }
                break;
            case 75:
                {
                alt112=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // InternalOperationDsl.g:4724:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalOperationDsl.g:4724:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalOperationDsl.g:4725:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalOperationDsl.g:4725:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalOperationDsl.g:4726:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalOperationDsl.g:4726:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalOperationDsl.g:4727:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,72,FOLLOW_42); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_99); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:4743:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalOperationDsl.g:4744:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:4744:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:4745:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalOperationDsl.g:4764:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalOperationDsl.g:4764:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalOperationDsl.g:4765:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalOperationDsl.g:4765:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalOperationDsl.g:4766:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalOperationDsl.g:4766:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalOperationDsl.g:4767:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,73,FOLLOW_42); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,42,FOLLOW_71); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalOperationDsl.g:4783:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalOperationDsl.g:4784:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalOperationDsl.g:4784:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalOperationDsl.g:4785:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalOperationDsl.g:4804:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:4804:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalOperationDsl.g:4805:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:4805:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalOperationDsl.g:4806:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalOperationDsl.g:4806:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalOperationDsl.g:4807:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,74,FOLLOW_42); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalOperationDsl.g:4823:4: ( (otherlv_8= RULE_ID ) )
                    // InternalOperationDsl.g:4824:5: (otherlv_8= RULE_ID )
                    {
                    // InternalOperationDsl.g:4824:5: (otherlv_8= RULE_ID )
                    // InternalOperationDsl.g:4825:6: otherlv_8= RULE_ID
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
                    // InternalOperationDsl.g:4838:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:4838:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalOperationDsl.g:4839:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:4839:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalOperationDsl.g:4840:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalOperationDsl.g:4840:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalOperationDsl.g:4841:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,75,FOLLOW_42); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalOperationDsl.g:4857:4: ( (otherlv_11= RULE_ID ) )
                    // InternalOperationDsl.g:4858:5: (otherlv_11= RULE_ID )
                    {
                    // InternalOperationDsl.g:4858:5: (otherlv_11= RULE_ID )
                    // InternalOperationDsl.g:4859:6: otherlv_11= RULE_ID
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
    // InternalOperationDsl.g:4875:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:4875:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalOperationDsl.g:4876:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:4882:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:4888:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:4889:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:4889:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:4890:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_100); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:4898:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalOperationDsl.g:4899:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalOperationDsl.g:4899:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalOperationDsl.g:4900:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_46);
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

            // InternalOperationDsl.g:4917:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==23) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalOperationDsl.g:4918:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_100); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:4922:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalOperationDsl.g:4923:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:4923:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalOperationDsl.g:4924:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop113;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_47); 

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
    // InternalOperationDsl.g:4954:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalOperationDsl.g:4954:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalOperationDsl.g:4955:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalOperationDsl.g:4961:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalOperationDsl.g:4967:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalOperationDsl.g:4968:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalOperationDsl.g:4968:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalOperationDsl.g:4969:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:4973:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:4974:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:4974:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:4975:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_101); 

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

            otherlv_2=(Token)match(input,78,FOLLOW_102); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalOperationDsl.g:4995:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalOperationDsl.g:4996:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalOperationDsl.g:4996:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalOperationDsl.g:4997:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_103);
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

            // InternalOperationDsl.g:5014:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==23) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalOperationDsl.g:5015:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_102); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:5019:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalOperationDsl.g:5020:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalOperationDsl.g:5020:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalOperationDsl.g:5021:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_103);
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
            	    break loop114;
                }
            } while (true);

            // InternalOperationDsl.g:5039:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==24) ) {
                alt117=1;
            }
            else if ( (LA117_0==41) ) {
                alt117=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // InternalOperationDsl.g:5040:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalOperationDsl.g:5040:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalOperationDsl.g:5041:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_104); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalOperationDsl.g:5045:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==76) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5046:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:5046:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalOperationDsl.g:5047:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop115;
                        }
                    } while (true);

                    // InternalOperationDsl.g:5064:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( ((LA116_0>=87 && LA116_0<=96)) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5065:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5065:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5066:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_93);
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
                    	    break loop116;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5089:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,41,FOLLOW_2); 

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
    // InternalOperationDsl.g:5098:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalOperationDsl.g:5098:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalOperationDsl.g:5099:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalOperationDsl.g:5105:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5111:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalOperationDsl.g:5112:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:5112:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalOperationDsl.g:5113:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalOperationDsl.g:5113:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalOperationDsl.g:5114:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalOperationDsl.g:5114:4: (lv_forTechnology_0_0= 'technology' )
            // InternalOperationDsl.g:5115:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,14,FOLLOW_42); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", true, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalOperationDsl.g:5131:3: ( (otherlv_2= RULE_ID ) )
            // InternalOperationDsl.g:5132:4: (otherlv_2= RULE_ID )
            {
            // InternalOperationDsl.g:5132:4: (otherlv_2= RULE_ID )
            // InternalOperationDsl.g:5133:5: otherlv_2= RULE_ID
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
    // InternalOperationDsl.g:5148:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:5148:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalOperationDsl.g:5149:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:5155:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:5161:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:5162:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:5162:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:5163:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:5171:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalOperationDsl.g:5172:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalOperationDsl.g:5172:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalOperationDsl.g:5173:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
            {

            					newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_46);
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

            // InternalOperationDsl.g:5190:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==23) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalOperationDsl.g:5191:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:5195:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalOperationDsl.g:5196:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:5196:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalOperationDsl.g:5197:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop118;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_47); 

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
    // InternalOperationDsl.g:5227:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalOperationDsl.g:5227:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalOperationDsl.g:5228:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalOperationDsl.g:5234:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalOperationDsl.g:5240:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalOperationDsl.g:5241:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalOperationDsl.g:5241:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalOperationDsl.g:5242:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:5246:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5247:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5247:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5248:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_101); 

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

            otherlv_2=(Token)match(input,78,FOLLOW_105); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalOperationDsl.g:5268:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalOperationDsl.g:5269:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalOperationDsl.g:5269:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalOperationDsl.g:5270:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_103);
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

            // InternalOperationDsl.g:5287:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==23) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalOperationDsl.g:5288:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_105); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:5292:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalOperationDsl.g:5293:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalOperationDsl.g:5293:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalOperationDsl.g:5294:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_103);
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
            	    break loop119;
                }
            } while (true);

            // InternalOperationDsl.g:5312:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==24) ) {
                alt122=1;
            }
            else if ( (LA122_0==41) ) {
                alt122=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // InternalOperationDsl.g:5313:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalOperationDsl.g:5313:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalOperationDsl.g:5314:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_104); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalOperationDsl.g:5318:5: ( (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector ) )*
                    loop120:
                    do {
                        int alt120=2;
                        int LA120_0 = input.LA(1);

                        if ( (LA120_0==76) ) {
                            alt120=1;
                        }


                        switch (alt120) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5319:6: (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:5319:6: (lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector )
                    	    // InternalOperationDsl.g:5320:7: lv_pointcutSelectors_7_0= ruleOperationAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPointcutSelectorsOperationAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop120;
                        }
                    } while (true);

                    // InternalOperationDsl.g:5337:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( ((LA121_0>=87 && LA121_0<=96)) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5338:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5338:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5339:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_93);
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
                    	    break loop121;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5362:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,41,FOLLOW_2); 

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
    // InternalOperationDsl.g:5371:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalOperationDsl.g:5371:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalOperationDsl.g:5372:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalOperationDsl.g:5378:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:5384:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:5385:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:5385:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:5386:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_106); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,79,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:5398:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:5399:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:5399:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:5400:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_50); 

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

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:5420:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:5421:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:5421:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:5422:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:5442:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalOperationDsl.g:5442:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalOperationDsl.g:5443:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalOperationDsl.g:5449:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalOperationDsl.g:5455:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalOperationDsl.g:5456:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalOperationDsl.g:5456:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalOperationDsl.g:5457:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalOperationDsl.g:5461:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5462:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5462:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5463:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,24,FOLLOW_107); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:5483:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt125=3;
            int LA125_0 = input.LA(1);

            if ( ((LA125_0>=65 && LA125_0<=66)||LA125_0==84) ) {
                alt125=1;
            }
            else if ( (LA125_0==80) ) {
                alt125=2;
            }
            switch (alt125) {
                case 1 :
                    // InternalOperationDsl.g:5484:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalOperationDsl.g:5484:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt123=0;
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( ((LA123_0>=65 && LA123_0<=66)||LA123_0==84) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5485:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalOperationDsl.g:5485:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalOperationDsl.g:5486:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_108);
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
                    	    if ( cnt123 >= 1 ) break loop123;
                                EarlyExitException eee =
                                    new EarlyExitException(123, input);
                                throw eee;
                        }
                        cnt123++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5504:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalOperationDsl.g:5504:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt124=0;
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==80) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5505:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalOperationDsl.g:5505:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalOperationDsl.g:5506:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_109);
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
                    	    if ( cnt124 >= 1 ) break loop124;
                                EarlyExitException eee =
                                    new EarlyExitException(124, input);
                                throw eee;
                        }
                        cnt124++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:5532:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalOperationDsl.g:5532:48: (iv_ruleContext= ruleContext EOF )
            // InternalOperationDsl.g:5533:2: iv_ruleContext= ruleContext EOF
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
    // InternalOperationDsl.g:5539:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:5545:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalOperationDsl.g:5546:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalOperationDsl.g:5546:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalOperationDsl.g:5547:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalOperationDsl.g:5551:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5552:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5552:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5553:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,24,FOLLOW_110); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:5573:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt126=0;
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( ((LA126_0>=65 && LA126_0<=66)||LA126_0==84) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // InternalOperationDsl.g:5574:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalOperationDsl.g:5574:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalOperationDsl.g:5575:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_108);
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
            	    if ( cnt126 >= 1 ) break loop126;
                        EarlyExitException eee =
                            new EarlyExitException(126, input);
                        throw eee;
                }
                cnt126++;
            } while (true);

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:5600:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalOperationDsl.g:5600:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalOperationDsl.g:5601:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalOperationDsl.g:5607:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:5613:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalOperationDsl.g:5614:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalOperationDsl.g:5614:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt127=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt127=1;
                }
                break;
            case 65:
                {
                alt127=2;
                }
                break;
            case 84:
                {
                alt127=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // InternalOperationDsl.g:5615:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalOperationDsl.g:5624:3: this_ListType_1= ruleListType
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
                    // InternalOperationDsl.g:5633:3: this_Enumeration_2= ruleEnumeration
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
    // InternalOperationDsl.g:5645:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalOperationDsl.g:5645:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalOperationDsl.g:5646:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalOperationDsl.g:5652:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalOperationDsl.g:5658:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalOperationDsl.g:5659:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalOperationDsl.g:5659:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalOperationDsl.g:5660:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalOperationDsl.g:5664:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5665:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5665:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5666:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_111); 

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

            // InternalOperationDsl.g:5682:3: (otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>' )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==70) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalOperationDsl.g:5683:4: otherlv_2= '<' ( (lv_features_3_0= ruleDataStructureFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,70,FOLLOW_112); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:5687:4: ( (lv_features_3_0= ruleDataStructureFeature ) )
                    // InternalOperationDsl.g:5688:5: (lv_features_3_0= ruleDataStructureFeature )
                    {
                    // InternalOperationDsl.g:5688:5: (lv_features_3_0= ruleDataStructureFeature )
                    // InternalOperationDsl.g:5689:6: lv_features_3_0= ruleDataStructureFeature
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_98);
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

                    // InternalOperationDsl.g:5706:4: (otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) ) )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==23) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5707:5: otherlv_4= ',' ( (lv_features_5_0= ruleDataStructureFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_112); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:5711:5: ( (lv_features_5_0= ruleDataStructureFeature ) )
                    	    // InternalOperationDsl.g:5712:6: (lv_features_5_0= ruleDataStructureFeature )
                    	    {
                    	    // InternalOperationDsl.g:5712:6: (lv_features_5_0= ruleDataStructureFeature )
                    	    // InternalOperationDsl.g:5713:7: lv_features_5_0= ruleDataStructureFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_98);
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
                    	    break loop128;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,71,FOLLOW_113); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:5736:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==81) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalOperationDsl.g:5737:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,81,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalOperationDsl.g:5741:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:5742:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:5742:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:5743:6: ruleQualifiedName
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

            otherlv_9=(Token)match(input,24,FOLLOW_114); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOperationDsl.g:5762:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==RULE_ID||(LA134_0>=82 && LA134_0<=83)||(LA134_0>=85 && LA134_0<=96)) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalOperationDsl.g:5763:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalOperationDsl.g:5763:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt131=2;
                    switch ( input.LA(1) ) {
                    case 82:
                        {
                        int LA131_1 = input.LA(2);

                        if ( ((LA131_1>=85 && LA131_1<=86)) ) {
                            alt131=2;
                        }
                        else if ( (LA131_1==RULE_ID||LA131_1==83||(LA131_1>=87 && LA131_1<=96)) ) {
                            alt131=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 131, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 83:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                        {
                        alt131=1;
                        }
                        break;
                    case 85:
                    case 86:
                        {
                        alt131=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 0, input);

                        throw nvae;
                    }

                    switch (alt131) {
                        case 1 :
                            // InternalOperationDsl.g:5764:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalOperationDsl.g:5764:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalOperationDsl.g:5765:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalOperationDsl.g:5765:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalOperationDsl.g:5766:7: lv_dataFields_10_0= ruleDataField
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0());
                            						
                            pushFollow(FOLLOW_57);
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
                            // InternalOperationDsl.g:5784:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalOperationDsl.g:5784:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalOperationDsl.g:5785:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalOperationDsl.g:5785:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalOperationDsl.g:5786:7: lv_operations_11_0= ruleDataOperation
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0());
                            						
                            pushFollow(FOLLOW_57);
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

                    // InternalOperationDsl.g:5804:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==23) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5805:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_115); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalOperationDsl.g:5809:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt132=2;
                    	    switch ( input.LA(1) ) {
                    	    case 82:
                    	        {
                    	        int LA132_1 = input.LA(2);

                    	        if ( (LA132_1==RULE_ID||LA132_1==83||(LA132_1>=87 && LA132_1<=96)) ) {
                    	            alt132=1;
                    	        }
                    	        else if ( ((LA132_1>=85 && LA132_1<=86)) ) {
                    	            alt132=2;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 132, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 83:
                    	    case 87:
                    	    case 88:
                    	    case 89:
                    	    case 90:
                    	    case 91:
                    	    case 92:
                    	    case 93:
                    	    case 94:
                    	    case 95:
                    	    case 96:
                    	        {
                    	        alt132=1;
                    	        }
                    	        break;
                    	    case 85:
                    	    case 86:
                    	        {
                    	        alt132=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 132, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt132) {
                    	        case 1 :
                    	            // InternalOperationDsl.g:5810:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalOperationDsl.g:5810:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalOperationDsl.g:5811:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalOperationDsl.g:5811:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalOperationDsl.g:5812:8: lv_dataFields_13_0= ruleDataField
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_57);
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
                    	            // InternalOperationDsl.g:5830:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalOperationDsl.g:5830:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalOperationDsl.g:5831:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalOperationDsl.g:5831:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalOperationDsl.g:5832:8: lv_operations_14_0= ruleDataOperation
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_57);
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
                    	    break loop133;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:5860:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalOperationDsl.g:5860:49: (iv_ruleListType= ruleListType EOF )
            // InternalOperationDsl.g:5861:2: iv_ruleListType= ruleListType EOF
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
    // InternalOperationDsl.g:5867:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalOperationDsl.g:5873:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalOperationDsl.g:5874:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalOperationDsl.g:5874:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt136=2;
            alt136 = dfa136.predict(input);
            switch (alt136) {
                case 1 :
                    // InternalOperationDsl.g:5875:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalOperationDsl.g:5875:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalOperationDsl.g:5876:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,65,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalOperationDsl.g:5880:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalOperationDsl.g:5881:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5881:5: (lv_name_1_0= RULE_ID )
                    // InternalOperationDsl.g:5882:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,24,FOLLOW_116); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalOperationDsl.g:5902:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalOperationDsl.g:5903:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalOperationDsl.g:5903:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalOperationDsl.g:5904:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_57);
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

                    // InternalOperationDsl.g:5921:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( (LA135_0==23) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5922:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_116); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalOperationDsl.g:5926:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalOperationDsl.g:5927:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalOperationDsl.g:5927:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalOperationDsl.g:5928:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_57);
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
                    	    break loop135;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5952:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalOperationDsl.g:5952:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalOperationDsl.g:5953:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,65,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalOperationDsl.g:5957:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalOperationDsl.g:5958:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5958:5: (lv_name_8_0= RULE_ID )
                    // InternalOperationDsl.g:5959:6: lv_name_8_0= RULE_ID
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

                    otherlv_9=(Token)match(input,24,FOLLOW_88); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalOperationDsl.g:5979:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:5980:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:5980:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalOperationDsl.g:5981:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_24);
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

                    otherlv_11=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:6007:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalOperationDsl.g:6007:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalOperationDsl.g:6008:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalOperationDsl.g:6014:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>' )? ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_immutable_1_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_primitiveType_2_0 = null;

        EObject lv_importedComplexType_4_0 = null;

        Enumerator lv_features_7_0 = null;

        Enumerator lv_features_9_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:6020:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>' )? ) )
            // InternalOperationDsl.g:6021:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>' )? )
            {
            // InternalOperationDsl.g:6021:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>' )? )
            // InternalOperationDsl.g:6022:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>' )?
            {
            // InternalOperationDsl.g:6022:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==82) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalOperationDsl.g:6023:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:6023:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:6024:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,82,FOLLOW_117); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:6036:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==83) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalOperationDsl.g:6037:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalOperationDsl.g:6037:4: (lv_immutable_1_0= 'immutable' )
                    // InternalOperationDsl.g:6038:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,83,FOLLOW_77); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", true, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:6050:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt139=4;
            int LA139_0 = input.LA(1);

            if ( ((LA139_0>=87 && LA139_0<=96)) ) {
                alt139=1;
            }
            else if ( (LA139_0==RULE_ID) ) {
                int LA139_2 = input.LA(2);

                if ( (LA139_2==RULE_ID||LA139_2==58) ) {
                    alt139=2;
                }
                else if ( (LA139_2==31) ) {
                    alt139=3;
                }
            }
            switch (alt139) {
                case 1 :
                    // InternalOperationDsl.g:6051:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:6051:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:6052:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:6052:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalOperationDsl.g:6053:6: lv_primitiveType_2_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:6071:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalOperationDsl.g:6071:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:6072:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:6072:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:6073:6: ruleQualifiedName
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
                    // InternalOperationDsl.g:6088:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:6088:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalOperationDsl.g:6089:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalOperationDsl.g:6089:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalOperationDsl.g:6090:6: lv_importedComplexType_4_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:6108:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:6109:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:6109:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:6110:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_118); 

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

            // InternalOperationDsl.g:6126:3: (otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>' )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==70) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // InternalOperationDsl.g:6127:4: otherlv_6= '<' ( (lv_features_7_0= ruleDataFieldFeature ) ) (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )* otherlv_10= '>'
                    {
                    otherlv_6=(Token)match(input,70,FOLLOW_119); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalOperationDsl.g:6131:4: ( (lv_features_7_0= ruleDataFieldFeature ) )
                    // InternalOperationDsl.g:6132:5: (lv_features_7_0= ruleDataFieldFeature )
                    {
                    // InternalOperationDsl.g:6132:5: (lv_features_7_0= ruleDataFieldFeature )
                    // InternalOperationDsl.g:6133:6: lv_features_7_0= ruleDataFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_features_7_0=ruleDataFieldFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_7_0,
                    							"de.fhdo.lemma.data.DataDsl.DataFieldFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOperationDsl.g:6150:4: (otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) ) )*
                    loop140:
                    do {
                        int alt140=2;
                        int LA140_0 = input.LA(1);

                        if ( (LA140_0==23) ) {
                            alt140=1;
                        }


                        switch (alt140) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6151:5: otherlv_8= ',' ( (lv_features_9_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_119); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6155:5: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    	    // InternalOperationDsl.g:6156:6: (lv_features_9_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalOperationDsl.g:6156:6: (lv_features_9_0= ruleDataFieldFeature )
                    	    // InternalOperationDsl.g:6157:7: lv_features_9_0= ruleDataFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_98);
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


                    	    }
                    	    break;

                    	default :
                    	    break loop140;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,71,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_4_3());
                    			

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
    // InternalOperationDsl.g:6184:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalOperationDsl.g:6184:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalOperationDsl.g:6185:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalOperationDsl.g:6191:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
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
            // InternalOperationDsl.g:6197:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalOperationDsl.g:6198:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalOperationDsl.g:6198:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalOperationDsl.g:6199:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalOperationDsl.g:6203:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6204:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6204:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6205:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:6225:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalOperationDsl.g:6226:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalOperationDsl.g:6226:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalOperationDsl.g:6227:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_57);
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

            // InternalOperationDsl.g:6244:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( (LA142_0==23) ) {
                    alt142=1;
                }


                switch (alt142) {
            	case 1 :
            	    // InternalOperationDsl.g:6245:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:6249:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalOperationDsl.g:6250:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalOperationDsl.g:6250:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalOperationDsl.g:6251:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_57);
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
            	    break loop142;
                }
            } while (true);

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:6277:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalOperationDsl.g:6277:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalOperationDsl.g:6278:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalOperationDsl.g:6284:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:6290:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalOperationDsl.g:6291:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalOperationDsl.g:6291:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalOperationDsl.g:6292:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalOperationDsl.g:6292:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:6293:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:6293:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:6294:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_79); 

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

            // InternalOperationDsl.g:6310:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==15) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // InternalOperationDsl.g:6311:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_43); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalOperationDsl.g:6315:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:6316:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:6316:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:6317:6: lv_initializationValue_2_0= rulePrimitiveValue
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
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveValue");
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


    // $ANTLR start "entryRuleDataOperation"
    // InternalOperationDsl.g:6343:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalOperationDsl.g:6343:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalOperationDsl.g:6344:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalOperationDsl.g:6350:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalOperationDsl.g:6356:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalOperationDsl.g:6357:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalOperationDsl.g:6357:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalOperationDsl.g:6358:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalOperationDsl.g:6358:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==82) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // InternalOperationDsl.g:6359:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:6359:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:6360:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,82,FOLLOW_120); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:6372:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==85) ) {
                alt146=1;
            }
            else if ( (LA146_0==86) ) {
                alt146=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }
            switch (alt146) {
                case 1 :
                    // InternalOperationDsl.g:6373:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalOperationDsl.g:6373:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalOperationDsl.g:6374:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalOperationDsl.g:6374:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalOperationDsl.g:6375:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,85,FOLLOW_7); 

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
                    // InternalOperationDsl.g:6388:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalOperationDsl.g:6388:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalOperationDsl.g:6389:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,86,FOLLOW_77); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalOperationDsl.g:6393:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt145=4;
                    int LA145_0 = input.LA(1);

                    if ( ((LA145_0>=87 && LA145_0<=96)) ) {
                        alt145=1;
                    }
                    else if ( (LA145_0==RULE_ID) ) {
                        int LA145_2 = input.LA(2);

                        if ( (LA145_2==RULE_ID||LA145_2==58) ) {
                            alt145=2;
                        }
                        else if ( (LA145_2==31) ) {
                            alt145=3;
                        }
                    }
                    switch (alt145) {
                        case 1 :
                            // InternalOperationDsl.g:6394:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalOperationDsl.g:6394:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalOperationDsl.g:6395:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalOperationDsl.g:6395:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalOperationDsl.g:6396:8: lv_primitiveReturnType_3_0= rulePrimitiveType
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
                            // InternalOperationDsl.g:6414:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalOperationDsl.g:6414:6: ( ( ruleQualifiedName ) )
                            // InternalOperationDsl.g:6415:7: ( ruleQualifiedName )
                            {
                            // InternalOperationDsl.g:6415:7: ( ruleQualifiedName )
                            // InternalOperationDsl.g:6416:8: ruleQualifiedName
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
                            // InternalOperationDsl.g:6431:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalOperationDsl.g:6431:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalOperationDsl.g:6432:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalOperationDsl.g:6432:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalOperationDsl.g:6433:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:6453:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalOperationDsl.g:6454:4: (lv_name_6_0= RULE_ID )
            {
            // InternalOperationDsl.g:6454:4: (lv_name_6_0= RULE_ID )
            // InternalOperationDsl.g:6455:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_121); 

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

            // InternalOperationDsl.g:6471:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==15) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalOperationDsl.g:6472:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_122); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:6476:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt147=2;
                    int LA147_0 = input.LA(1);

                    if ( (LA147_0==RULE_ID||(LA147_0>=87 && LA147_0<=96)) ) {
                        alt147=1;
                    }
                    switch (alt147) {
                        case 1 :
                            // InternalOperationDsl.g:6477:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalOperationDsl.g:6477:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalOperationDsl.g:6478:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_46);
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

                    // InternalOperationDsl.g:6495:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop148:
                    do {
                        int alt148=2;
                        int LA148_0 = input.LA(1);

                        if ( (LA148_0==23) ) {
                            alt148=1;
                        }


                        switch (alt148) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6496:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_77); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6500:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalOperationDsl.g:6501:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalOperationDsl.g:6501:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalOperationDsl.g:6502:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_46);
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
                    	    break loop148;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_118); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:6525:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==70) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalOperationDsl.g:6526:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,70,FOLLOW_123); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalOperationDsl.g:6530:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalOperationDsl.g:6531:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalOperationDsl.g:6531:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalOperationDsl.g:6532:6: lv_features_13_0= ruleDataOperationFeature
                    {

                    						newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_98);
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

                    // InternalOperationDsl.g:6549:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop150:
                    do {
                        int alt150=2;
                        int LA150_0 = input.LA(1);

                        if ( (LA150_0==23) ) {
                            alt150=1;
                        }


                        switch (alt150) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6550:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,23,FOLLOW_123); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6554:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalOperationDsl.g:6555:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalOperationDsl.g:6555:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalOperationDsl.g:6556:7: lv_features_15_0= ruleDataOperationFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_98);
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
                    	    break loop150;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,71,FOLLOW_2); 

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
    // InternalOperationDsl.g:6583:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalOperationDsl.g:6583:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalOperationDsl.g:6584:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalOperationDsl.g:6590:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:6596:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:6597:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:6597:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalOperationDsl.g:6598:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:6598:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt152=3;
            int LA152_0 = input.LA(1);

            if ( ((LA152_0>=87 && LA152_0<=96)) ) {
                alt152=1;
            }
            else if ( (LA152_0==RULE_ID) ) {
                int LA152_2 = input.LA(2);

                if ( (LA152_2==RULE_ID||LA152_2==58) ) {
                    alt152=2;
                }
                else if ( (LA152_2==31) ) {
                    alt152=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 152, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }
            switch (alt152) {
                case 1 :
                    // InternalOperationDsl.g:6599:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:6599:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:6600:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:6600:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalOperationDsl.g:6601:6: lv_primitiveType_0_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:6619:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalOperationDsl.g:6619:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:6620:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:6620:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:6621:6: ruleQualifiedName
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
                    // InternalOperationDsl.g:6636:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:6636:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalOperationDsl.g:6637:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalOperationDsl.g:6637:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalOperationDsl.g:6638:6: lv_importedComplexType_2_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:6656:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOperationDsl.g:6657:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOperationDsl.g:6657:4: (lv_name_3_0= RULE_ID )
            // InternalOperationDsl.g:6658:5: lv_name_3_0= RULE_ID
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
    // InternalOperationDsl.g:6678:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalOperationDsl.g:6678:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalOperationDsl.g:6679:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalOperationDsl.g:6685:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6691:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalOperationDsl.g:6692:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalOperationDsl.g:6692:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt153=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt153=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt153=2;
                }
                break;
            case RULE_STRING:
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
                    // InternalOperationDsl.g:6693:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalOperationDsl.g:6693:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalOperationDsl.g:6694:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalOperationDsl.g:6694:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalOperationDsl.g:6695:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalOperationDsl.g:6712:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalOperationDsl.g:6712:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:6713:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:6713:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:6714:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalOperationDsl.g:6731:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalOperationDsl.g:6731:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalOperationDsl.g:6732:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalOperationDsl.g:6732:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalOperationDsl.g:6733:5: lv_stringValue_2_0= RULE_STRING
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


    // $ANTLR start "entryRuleImportedComplexType"
    // InternalOperationDsl.g:6753:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalOperationDsl.g:6753:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalOperationDsl.g:6754:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalOperationDsl.g:6760:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6766:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:6767:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:6767:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:6768:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:6768:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:6769:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:6769:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:6770:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:6785:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:6786:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:6786:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:6787:5: ruleQualifiedName
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
    // InternalOperationDsl.g:6805:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalOperationDsl.g:6805:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalOperationDsl.g:6806:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalOperationDsl.g:6812:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalOperationDsl.g:6818:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalOperationDsl.g:6819:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalOperationDsl.g:6819:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt154=10;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt154=1;
                }
                break;
            case 88:
                {
                alt154=2;
                }
                break;
            case 89:
                {
                alt154=3;
                }
                break;
            case 90:
                {
                alt154=4;
                }
                break;
            case 91:
                {
                alt154=5;
                }
                break;
            case 92:
                {
                alt154=6;
                }
                break;
            case 93:
                {
                alt154=7;
                }
                break;
            case 94:
                {
                alt154=8;
                }
                break;
            case 95:
                {
                alt154=9;
                }
                break;
            case 96:
                {
                alt154=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);

                throw nvae;
            }

            switch (alt154) {
                case 1 :
                    // InternalOperationDsl.g:6820:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalOperationDsl.g:6820:3: ( () otherlv_1= 'boolean' )
                    // InternalOperationDsl.g:6821:4: () otherlv_1= 'boolean'
                    {
                    // InternalOperationDsl.g:6821:4: ()
                    // InternalOperationDsl.g:6822:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,87,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6834:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalOperationDsl.g:6834:3: ( () otherlv_3= 'byte' )
                    // InternalOperationDsl.g:6835:4: () otherlv_3= 'byte'
                    {
                    // InternalOperationDsl.g:6835:4: ()
                    // InternalOperationDsl.g:6836:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,88,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:6848:3: ( () otherlv_5= 'char' )
                    {
                    // InternalOperationDsl.g:6848:3: ( () otherlv_5= 'char' )
                    // InternalOperationDsl.g:6849:4: () otherlv_5= 'char'
                    {
                    // InternalOperationDsl.g:6849:4: ()
                    // InternalOperationDsl.g:6850:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,89,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:6862:3: ( () otherlv_7= 'date' )
                    {
                    // InternalOperationDsl.g:6862:3: ( () otherlv_7= 'date' )
                    // InternalOperationDsl.g:6863:4: () otherlv_7= 'date'
                    {
                    // InternalOperationDsl.g:6863:4: ()
                    // InternalOperationDsl.g:6864:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,90,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:6876:3: ( () otherlv_9= 'double' )
                    {
                    // InternalOperationDsl.g:6876:3: ( () otherlv_9= 'double' )
                    // InternalOperationDsl.g:6877:4: () otherlv_9= 'double'
                    {
                    // InternalOperationDsl.g:6877:4: ()
                    // InternalOperationDsl.g:6878:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,91,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:6890:3: ( () otherlv_11= 'float' )
                    {
                    // InternalOperationDsl.g:6890:3: ( () otherlv_11= 'float' )
                    // InternalOperationDsl.g:6891:4: () otherlv_11= 'float'
                    {
                    // InternalOperationDsl.g:6891:4: ()
                    // InternalOperationDsl.g:6892:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,92,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:6904:3: ( () otherlv_13= 'int' )
                    {
                    // InternalOperationDsl.g:6904:3: ( () otherlv_13= 'int' )
                    // InternalOperationDsl.g:6905:4: () otherlv_13= 'int'
                    {
                    // InternalOperationDsl.g:6905:4: ()
                    // InternalOperationDsl.g:6906:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,93,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:6918:3: ( () otherlv_15= 'long' )
                    {
                    // InternalOperationDsl.g:6918:3: ( () otherlv_15= 'long' )
                    // InternalOperationDsl.g:6919:4: () otherlv_15= 'long'
                    {
                    // InternalOperationDsl.g:6919:4: ()
                    // InternalOperationDsl.g:6920:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,94,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:6932:3: ( () otherlv_17= 'short' )
                    {
                    // InternalOperationDsl.g:6932:3: ( () otherlv_17= 'short' )
                    // InternalOperationDsl.g:6933:4: () otherlv_17= 'short'
                    {
                    // InternalOperationDsl.g:6933:4: ()
                    // InternalOperationDsl.g:6934:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,95,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:6946:3: ( () otherlv_19= 'string' )
                    {
                    // InternalOperationDsl.g:6946:3: ( () otherlv_19= 'string' )
                    // InternalOperationDsl.g:6947:4: () otherlv_19= 'string'
                    {
                    // InternalOperationDsl.g:6947:4: ()
                    // InternalOperationDsl.g:6948:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,96,FOLLOW_2); 

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
    // InternalOperationDsl.g:6963:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOperationDsl.g:6963:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOperationDsl.g:6964:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalOperationDsl.g:6970:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6976:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOperationDsl.g:6977:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOperationDsl.g:6977:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOperationDsl.g:6978:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_124); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOperationDsl.g:6985:3: (kw= '.' this_ID_2= RULE_ID )*
            loop155:
            do {
                int alt155=2;
                int LA155_0 = input.LA(1);

                if ( (LA155_0==58) ) {
                    alt155=1;
                }


                switch (alt155) {
            	case 1 :
            	    // InternalOperationDsl.g:6986:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,58,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_124); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop155;
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
    // InternalOperationDsl.g:7003:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7009:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalOperationDsl.g:7010:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalOperationDsl.g:7010:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==14) ) {
                alt156=1;
            }
            else if ( (LA156_0==49) ) {
                alt156=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 156, 0, input);

                throw nvae;
            }
            switch (alt156) {
                case 1 :
                    // InternalOperationDsl.g:7011:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalOperationDsl.g:7011:3: (enumLiteral_0= 'technology' )
                    // InternalOperationDsl.g:7012:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,14,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7019:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalOperationDsl.g:7019:3: (enumLiteral_1= 'microservices' )
                    // InternalOperationDsl.g:7020:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

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
    // InternalOperationDsl.g:7030:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7036:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalOperationDsl.g:7037:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalOperationDsl.g:7037:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt157=3;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt157=1;
                }
                break;
            case 98:
                {
                alt157=2;
                }
                break;
            case 99:
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
                    // InternalOperationDsl.g:7038:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalOperationDsl.g:7038:3: (enumLiteral_0= 'internal' )
                    // InternalOperationDsl.g:7039:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7046:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalOperationDsl.g:7046:3: (enumLiteral_1= 'architecture' )
                    // InternalOperationDsl.g:7047:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7054:3: (enumLiteral_2= 'public' )
                    {
                    // InternalOperationDsl.g:7054:3: (enumLiteral_2= 'public' )
                    // InternalOperationDsl.g:7055:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,99,FOLLOW_2); 

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
    // InternalOperationDsl.g:7065:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7071:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalOperationDsl.g:7072:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:7072:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt158=3;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt158=1;
                }
                break;
            case 101:
                {
                alt158=2;
                }
                break;
            case 102:
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
                    // InternalOperationDsl.g:7073:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalOperationDsl.g:7073:3: (enumLiteral_0= 'functional' )
                    // InternalOperationDsl.g:7074:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7081:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalOperationDsl.g:7081:3: (enumLiteral_1= 'utility' )
                    // InternalOperationDsl.g:7082:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7089:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:7089:3: (enumLiteral_2= 'infrastructure' )
                    // InternalOperationDsl.g:7090:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,102,FOLLOW_2); 

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
    // InternalOperationDsl.g:7100:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7106:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalOperationDsl.g:7107:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalOperationDsl.g:7107:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt159=3;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt159=1;
                }
                break;
            case 104:
                {
                alt159=2;
                }
                break;
            case 105:
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
                    // InternalOperationDsl.g:7108:3: (enumLiteral_0= 'in' )
                    {
                    // InternalOperationDsl.g:7108:3: (enumLiteral_0= 'in' )
                    // InternalOperationDsl.g:7109:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7116:3: (enumLiteral_1= 'out' )
                    {
                    // InternalOperationDsl.g:7116:3: (enumLiteral_1= 'out' )
                    // InternalOperationDsl.g:7117:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7124:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalOperationDsl.g:7124:3: (enumLiteral_2= 'inout' )
                    // InternalOperationDsl.g:7125:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,105,FOLLOW_2); 

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
    // InternalOperationDsl.g:7135:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7141:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalOperationDsl.g:7142:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalOperationDsl.g:7142:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==106) ) {
                alt160=1;
            }
            else if ( (LA160_0==107) ) {
                alt160=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;
            }
            switch (alt160) {
                case 1 :
                    // InternalOperationDsl.g:7143:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalOperationDsl.g:7143:3: (enumLiteral_0= 'sync' )
                    // InternalOperationDsl.g:7144:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7151:3: (enumLiteral_1= 'async' )
                    {
                    // InternalOperationDsl.g:7151:3: (enumLiteral_1= 'async' )
                    // InternalOperationDsl.g:7152:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

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
    // InternalOperationDsl.g:7162:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7168:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalOperationDsl.g:7169:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalOperationDsl.g:7169:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt161=3;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt161=1;
                }
                break;
            case 109:
                {
                alt161=2;
                }
                break;
            case 110:
                {
                alt161=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 161, 0, input);

                throw nvae;
            }

            switch (alt161) {
                case 1 :
                    // InternalOperationDsl.g:7170:3: (enumLiteral_0= '<-' )
                    {
                    // InternalOperationDsl.g:7170:3: (enumLiteral_0= '<-' )
                    // InternalOperationDsl.g:7171:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7178:3: (enumLiteral_1= '->' )
                    {
                    // InternalOperationDsl.g:7178:3: (enumLiteral_1= '->' )
                    // InternalOperationDsl.g:7179:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7186:3: (enumLiteral_2= '<->' )
                    {
                    // InternalOperationDsl.g:7186:3: (enumLiteral_2= '<->' )
                    // InternalOperationDsl.g:7187:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,110,FOLLOW_2); 

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
    // InternalOperationDsl.g:7197:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7203:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalOperationDsl.g:7204:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalOperationDsl.g:7204:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==111) ) {
                alt162=1;
            }
            else if ( (LA162_0==112) ) {
                alt162=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 162, 0, input);

                throw nvae;
            }
            switch (alt162) {
                case 1 :
                    // InternalOperationDsl.g:7205:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalOperationDsl.g:7205:3: (enumLiteral_0= 'mandatory' )
                    // InternalOperationDsl.g:7206:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7213:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalOperationDsl.g:7213:3: (enumLiteral_1= 'singleval' )
                    // InternalOperationDsl.g:7214:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

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
    // InternalOperationDsl.g:7224:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) ;
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
            // InternalOperationDsl.g:7230:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) ) )
            // InternalOperationDsl.g:7231:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            {
            // InternalOperationDsl.g:7231:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'types' ) | (enumLiteral_5= 'fields' ) )
            int alt163=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt163=1;
                }
                break;
            case 50:
                {
                alt163=2;
                }
                break;
            case 51:
                {
                alt163=3;
                }
                break;
            case 113:
                {
                alt163=4;
                }
                break;
            case 114:
                {
                alt163=5;
                }
                break;
            case 115:
                {
                alt163=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 163, 0, input);

                throw nvae;
            }

            switch (alt163) {
                case 1 :
                    // InternalOperationDsl.g:7232:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalOperationDsl.g:7232:3: (enumLiteral_0= 'microservices' )
                    // InternalOperationDsl.g:7233:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7240:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalOperationDsl.g:7240:3: (enumLiteral_1= 'interfaces' )
                    // InternalOperationDsl.g:7241:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7248:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalOperationDsl.g:7248:3: (enumLiteral_2= 'operations' )
                    // InternalOperationDsl.g:7249:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:7256:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalOperationDsl.g:7256:3: (enumLiteral_3= 'parameters' )
                    // InternalOperationDsl.g:7257:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:7264:3: (enumLiteral_4= 'types' )
                    {
                    // InternalOperationDsl.g:7264:3: (enumLiteral_4= 'types' )
                    // InternalOperationDsl.g:7265:4: enumLiteral_4= 'types'
                    {
                    enumLiteral_4=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:7272:3: (enumLiteral_5= 'fields' )
                    {
                    // InternalOperationDsl.g:7272:3: (enumLiteral_5= 'fields' )
                    // InternalOperationDsl.g:7273:4: enumLiteral_5= 'fields'
                    {
                    enumLiteral_5=(Token)match(input,115,FOLLOW_2); 

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
    // InternalOperationDsl.g:7283:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7289:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalOperationDsl.g:7290:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:7290:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==116) ) {
                alt164=1;
            }
            else if ( (LA164_0==102) ) {
                alt164=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 164, 0, input);

                throw nvae;
            }
            switch (alt164) {
                case 1 :
                    // InternalOperationDsl.g:7291:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalOperationDsl.g:7291:3: (enumLiteral_0= 'containers' )
                    // InternalOperationDsl.g:7292:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7299:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:7299:3: (enumLiteral_1= 'infrastructure' )
                    // InternalOperationDsl.g:7300:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_2); 

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
    // InternalOperationDsl.g:7310:1: ruleDataStructureFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
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
            // InternalOperationDsl.g:7316:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalOperationDsl.g:7317:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalOperationDsl.g:7317:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt165=11;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt165=1;
                }
                break;
            case 118:
                {
                alt165=2;
                }
                break;
            case 119:
                {
                alt165=3;
                }
                break;
            case 120:
                {
                alt165=4;
                }
                break;
            case 121:
                {
                alt165=5;
                }
                break;
            case 122:
                {
                alt165=6;
                }
                break;
            case 123:
                {
                alt165=7;
                }
                break;
            case 124:
                {
                alt165=8;
                }
                break;
            case 68:
                {
                alt165=9;
                }
                break;
            case 125:
                {
                alt165=10;
                }
                break;
            case 126:
                {
                alt165=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 165, 0, input);

                throw nvae;
            }

            switch (alt165) {
                case 1 :
                    // InternalOperationDsl.g:7318:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalOperationDsl.g:7318:3: (enumLiteral_0= 'aggregate' )
                    // InternalOperationDsl.g:7319:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataStructureFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7326:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalOperationDsl.g:7326:3: (enumLiteral_1= 'applicationService' )
                    // InternalOperationDsl.g:7327:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataStructureFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7334:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalOperationDsl.g:7334:3: (enumLiteral_2= 'domainEvent' )
                    // InternalOperationDsl.g:7335:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataStructureFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:7342:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalOperationDsl.g:7342:3: (enumLiteral_3= 'domainService' )
                    // InternalOperationDsl.g:7343:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataStructureFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:7350:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalOperationDsl.g:7350:3: (enumLiteral_4= 'entity' )
                    // InternalOperationDsl.g:7351:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataStructureFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:7358:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalOperationDsl.g:7358:3: (enumLiteral_5= 'factory' )
                    // InternalOperationDsl.g:7359:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDataStructureFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:7366:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalOperationDsl.g:7366:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalOperationDsl.g:7367:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getDataStructureFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:7374:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalOperationDsl.g:7374:3: (enumLiteral_7= 'repository' )
                    // InternalOperationDsl.g:7375:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getDataStructureFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:7382:3: (enumLiteral_8= 'service' )
                    {
                    // InternalOperationDsl.g:7382:3: (enumLiteral_8= 'service' )
                    // InternalOperationDsl.g:7383:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getDataStructureFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:7390:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalOperationDsl.g:7390:3: (enumLiteral_9= 'specification' )
                    // InternalOperationDsl.g:7391:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getDataStructureFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getDataStructureFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalOperationDsl.g:7398:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalOperationDsl.g:7398:3: (enumLiteral_10= 'valueObject' )
                    // InternalOperationDsl.g:7399:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,126,FOLLOW_2); 

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
    // InternalOperationDsl.g:7409:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7415:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'part' ) ) )
            // InternalOperationDsl.g:7416:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'part' ) )
            {
            // InternalOperationDsl.g:7416:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'part' ) )
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==127) ) {
                alt166=1;
            }
            else if ( (LA166_0==128) ) {
                alt166=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 166, 0, input);

                throw nvae;
            }
            switch (alt166) {
                case 1 :
                    // InternalOperationDsl.g:7417:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalOperationDsl.g:7417:3: (enumLiteral_0= 'identifier' )
                    // InternalOperationDsl.g:7418:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7425:3: (enumLiteral_1= 'part' )
                    {
                    // InternalOperationDsl.g:7425:3: (enumLiteral_1= 'part' )
                    // InternalOperationDsl.g:7426:4: enumLiteral_1= 'part'
                    {
                    enumLiteral_1=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_1());
                    			

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
    // InternalOperationDsl.g:7436:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:7442:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalOperationDsl.g:7443:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalOperationDsl.g:7443:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt167=4;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt167=1;
                }
                break;
            case 127:
                {
                alt167=2;
                }
                break;
            case 130:
                {
                alt167=3;
                }
                break;
            case 131:
                {
                alt167=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 167, 0, input);

                throw nvae;
            }

            switch (alt167) {
                case 1 :
                    // InternalOperationDsl.g:7444:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalOperationDsl.g:7444:3: (enumLiteral_0= 'closure' )
                    // InternalOperationDsl.g:7445:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7452:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalOperationDsl.g:7452:3: (enumLiteral_1= 'identifier' )
                    // InternalOperationDsl.g:7453:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7460:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalOperationDsl.g:7460:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalOperationDsl.g:7461:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:7468:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalOperationDsl.g:7468:3: (enumLiteral_3= 'validator' )
                    // InternalOperationDsl.g:7469:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,131,FOLLOW_2); 

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
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA136 dfa136 = new DFA136(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\1\2\7\uffff";
    static final String dfa_3s = "\1\15\1\16\1\uffff\1\17\1\4\1\20\1\4\1\uffff";
    static final String dfa_4s = "\1\15\1\16\1\uffff\1\17\1\4\1\20\1\21\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\4\uffff\1\1";
    static final String dfa_6s = "\10\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\2\10\uffff\1\1\3\uffff\1\7",
            ""
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
            return "()* loopback of 99:3: ( (lv_containers_1_0= ruleContainer ) )*";
        }
    }
    static final String dfa_8s = "\16\uffff";
    static final String dfa_9s = "\1\4\1\17\1\uffff\2\5\3\20\4\4\2\uffff";
    static final String dfa_10s = "\1\35\1\52\1\uffff\2\7\3\20\4\35\2\uffff";
    static final String dfa_11s = "\2\uffff\1\2\11\uffff\1\3\1\1";
    static final String dfa_12s = "\16\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\30\uffff\1\2",
            "\1\3\32\uffff\1\4",
            "",
            "\1\7\1\6\1\5",
            "\1\12\1\11\1\10",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\1\25\uffff\1\15\2\uffff\1\14",
            "\1\1\25\uffff\1\15\2\uffff\1\14",
            "\1\1\25\uffff\1\15\2\uffff\1\14",
            "\1\1\25\uffff\1\15\2\uffff\1\14",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "361:4: ( ( (lv_defaultServicePropertyValues_26_0= rulePropertyValueAssignment ) )+ | (otherlv_27= 'basic' otherlv_28= 'endpoints' otherlv_29= '{' ( (lv_defaultBasicEndpoints_30_0= ruleBasicEndpoint ) )+ otherlv_31= '}' ) | ( ( (lv_defaultServicePropertyValues_32_0= rulePropertyValueAssignment ) )+ otherlv_33= 'basic' otherlv_34= 'endpoints' otherlv_35= '{' ( (lv_defaultBasicEndpoints_36_0= ruleBasicEndpoint ) )+ otherlv_37= '}' ) )";
        }
    }
    static final String dfa_14s = "\123\uffff";
    static final String dfa_15s = "\2\4\2\uffff\2\17\1\37\1\17\3\4\1\37\1\4\1\37\5\4\1\20\1\4\3\20\1\17\1\27\4\4\2\5\3\4\1\5\2\20\1\4\6\20\2\27\1\37\1\27\2\17\1\4\1\20\1\4\1\5\2\4\1\17\2\27\1\4\1\37\2\5\3\4\6\20\2\27\2\20\3\4\2\20\1\4";
    static final String dfa_16s = "\1\143\1\153\2\uffff\2\17\1\37\1\17\3\4\1\37\1\143\1\37\2\4\1\7\2\4\1\72\1\143\3\20\1\52\1\72\2\4\2\143\2\7\3\4\1\5\1\72\1\20\1\153\3\27\3\20\1\72\1\50\1\37\1\51\2\17\1\4\1\27\1\4\1\5\1\20\1\4\1\52\1\72\1\51\1\143\1\37\2\7\3\4\3\27\3\20\1\72\1\50\1\72\1\27\2\4\1\143\1\72\1\20\1\36";
    static final String dfa_17s = "\2\uffff\1\2\1\1\117\uffff";
    static final String dfa_18s = "\123\uffff}>";
    static final String[] dfa_19s = {
            "\1\2\10\uffff\1\1\14\uffff\1\2\32\uffff\1\2\1\uffff\1\3\51\uffff\3\2",
            "\1\6\31\uffff\1\7\113\uffff\1\4\1\5",
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
            "\1\2\10\uffff\1\21\1\uffff\1\20\45\uffff\1\2\1\uffff\1\3\2\uffff\1\17\46\uffff\3\2",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\30\1\27\1\26\1\25",
            "\1\6",
            "\1\31",
            "\1\34\26\uffff\1\33\22\uffff\1\32",
            "\1\2\10\uffff\1\21\1\uffff\1\20\45\uffff\1\2\1\uffff\1\3\2\uffff\1\17\46\uffff\3\2",
            "\1\35",
            "\1\35",
            "\1\35",
            "\1\37\32\uffff\1\36",
            "\1\42\17\uffff\1\41\1\43\21\uffff\1\40",
            "\1\44",
            "\1\45",
            "\1\2\10\uffff\1\46\47\uffff\1\2\1\uffff\1\3\51\uffff\3\2",
            "\1\2\10\uffff\1\21\47\uffff\1\2\1\uffff\1\3\51\uffff\3\2",
            "\1\51\1\50\1\47",
            "\1\54\1\53\1\52",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\34\26\uffff\1\33\22\uffff\1\32",
            "\1\34",
            "\1\6\31\uffff\1\7\113\uffff\1\61\1\62",
            "\1\35\6\uffff\1\63",
            "\1\35\6\uffff\1\63",
            "\1\35\6\uffff\1\63",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\42\17\uffff\1\41\1\43\21\uffff\1\40",
            "\1\42\20\uffff\1\43",
            "\1\65",
            "\1\66\21\uffff\1\67",
            "\1\70",
            "\1\70",
            "\1\71",
            "\1\35\6\uffff\1\63",
            "\1\72",
            "\1\73",
            "\1\15\13\uffff\1\74",
            "\1\75",
            "\1\77\32\uffff\1\76",
            "\1\42\17\uffff\1\101\1\43\21\uffff\1\100",
            "\1\66\21\uffff\1\67",
            "\1\2\10\uffff\1\21\47\uffff\1\2\1\uffff\1\3\51\uffff\3\2",
            "\1\102",
            "\1\105\1\104\1\103",
            "\1\110\1\107\1\106",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\35\6\uffff\1\63",
            "\1\35\6\uffff\1\63",
            "\1\35\6\uffff\1\63",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\42\17\uffff\1\101\1\43\21\uffff\1\100",
            "\1\42\20\uffff\1\43",
            "\1\117\26\uffff\1\116\22\uffff\1\115",
            "\1\35\6\uffff\1\63",
            "\1\120",
            "\1\121",
            "\1\2\10\uffff\1\122\47\uffff\1\2\1\uffff\1\3\51\uffff\3\2",
            "\1\117\26\uffff\1\116\22\uffff\1\115",
            "\1\117",
            "\1\6\31\uffff\1\7"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 2527:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_20s = "\20\uffff";
    static final String dfa_21s = "\1\101\1\4\1\30\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_22s = "\1\101\1\4\1\30\1\140\1\uffff\12\32\1\uffff";
    static final String dfa_23s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_24s = "\20\uffff}>";
    static final String[] dfa_25s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\115\uffff\2\4\3\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
            "",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            "\1\4\25\uffff\1\17",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA136 extends DFA {

        public DFA136(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 136;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "5874:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000080000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000E000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000C000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001201080000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001201000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001001800000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000004E000010L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000004C000010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000044000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010000800000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000024000010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000020000008000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0002000000004000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000002000L,0x0000007E00000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000800001000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0061000000002000L,0x0000000E00000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0061000004002000L,0x0000000E00000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0060000000002000L,0x0000000E00000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0040000000000000L,0x0000000E00000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x00A0000004002010L,0x0000000E00000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0020000004002010L,0x0000000E00000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0020000000002010L,0x0000000E00000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000010L,0x0000000E00000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000812000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000002000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0100000000000010L,0x0000038000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0200010000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000010L,0x00000001FF800000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000020008800000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x00000001FF800000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000800000L,0x0000700000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000004000000L,0x00000001FF800000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000060000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000080L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000038000000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x000E000000000000L,0x000E000000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000020001800000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000004000000L,0x00000001FF801000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0010004000000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000004000000L,0x0000000000110006L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000004000000L,0x0000000000100006L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000004000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100006L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000001000000L,0x0000000000020040L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000000L,0x7FE0000000000010L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000001000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000004000010L,0x00000001FFEC0000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000000000010L,0x00000001FFEC0000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000000010L,0x00000001FF8C0000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000010L,0x00000001FF880000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000008002L,0x0000000000000040L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000810010L,0x00000001FF800000L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0400000000000002L});

}