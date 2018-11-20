package de.fhdo.ddmm.operationdsl.parser.antlr.internal;

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
import de.fhdo.ddmm.operationdsl.services.OperationDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOperationDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'technology'", "'('", "')'", "'container'", "'deployment'", "'with'", "'operation'", "'environment'", "'deploys'", "','", "'{'", "'aspects'", "'}'", "'default'", "'values'", "'basic'", "'endpoints'", "'::'", "'is'", "'used'", "'by'", "'/'", "':'", "';'", "'='", "'import'", "'from'", "'as'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'noimpl'", "'interface'", "'refers'", "'fault'", "'?'", "'.'", "'data'", "'formats'", "'format'", "'primitive'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'environments'", "'service'", "'properties'", "'mandatory'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'aspect'", "'for'", "'datatypes'", "'context'", "'extends'", "'hide'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'functional'", "'utility'", "'infrastructure'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'->'", "'<->'", "'parameters'", "'fields'", "'containers'"
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
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__87=87;

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

                if ( (LA1_0==39) ) {
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
            	    						"de.fhdo.ddmm.operationdsl.OperationDsl.Container");
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
            	    						"de.fhdo.ddmm.operationdsl.OperationDsl.InfrastructureNode");
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
            						"de.fhdo.ddmm.operationdsl.OperationDsl.DeploymentTechnologyReference");
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
            						"de.fhdo.ddmm.operationdsl.OperationDsl.ImportedMicroservice");
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
            	    							"de.fhdo.ddmm.operationdsl.OperationDsl.ImportedMicroservice");
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
                    	    							"de.fhdo.ddmm.operationdsl.OperationDsl.ImportedOperationAspect");
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
                            	    								"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
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
                            	    									"de.fhdo.ddmm.operationdsl.OperationDsl.BasicEndpoint");
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
                            	    									"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
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
                            	    									"de.fhdo.ddmm.operationdsl.OperationDsl.BasicEndpoint");
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
            	    						"de.fhdo.ddmm.operationdsl.OperationDsl.ServiceDeploymentSpecification");
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
    // InternalOperationDsl.g:568:1: ruleInfrastructureNode returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? otherlv_12= 'used' otherlv_13= 'by' ( (lv_deployedServices_14_0= ruleImportedMicroservice ) ) (otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) ) )* otherlv_17= '{' (otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}' )? (otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}' )? (otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}' )? ( (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification ) )* otherlv_32= '}' ) ;
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
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_infrastructureTechnology_7_0 = null;

        EObject lv_deployedServices_14_0 = null;

        EObject lv_deployedServices_16_0 = null;

        EObject lv_aspects_20_0 = null;

        EObject lv_defaultServicePropertyValues_25_0 = null;

        EObject lv_endpoints_29_0 = null;

        EObject lv_deploymentSpecifications_31_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:574:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? otherlv_12= 'used' otherlv_13= 'by' ( (lv_deployedServices_14_0= ruleImportedMicroservice ) ) (otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) ) )* otherlv_17= '{' (otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}' )? (otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}' )? (otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}' )? ( (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification ) )* otherlv_32= '}' ) )
            // InternalOperationDsl.g:575:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? otherlv_12= 'used' otherlv_13= 'by' ( (lv_deployedServices_14_0= ruleImportedMicroservice ) ) (otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) ) )* otherlv_17= '{' (otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}' )? (otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}' )? (otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}' )? ( (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification ) )* otherlv_32= '}' )
            {
            // InternalOperationDsl.g:575:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? otherlv_12= 'used' otherlv_13= 'by' ( (lv_deployedServices_14_0= ruleImportedMicroservice ) ) (otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) ) )* otherlv_17= '{' (otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}' )? (otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}' )? (otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}' )? ( (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification ) )* otherlv_32= '}' )
            // InternalOperationDsl.g:576:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? otherlv_12= 'used' otherlv_13= 'by' ( (lv_deployedServices_14_0= ruleImportedMicroservice ) ) (otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) ) )* otherlv_17= '{' (otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}' )? (otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}' )? (otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}' )? ( (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification ) )* otherlv_32= '}'
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
            						"de.fhdo.ddmm.operationdsl.OperationDsl.InfrastructureTechnologyReference");
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

            otherlv_12=(Token)match(input,33,FOLLOW_30); 

            			newLeafNode(otherlv_12, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_5());
            		
            otherlv_13=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_13, grammarAccess.getInfrastructureNodeAccess().getByKeyword_6());
            		
            // InternalOperationDsl.g:683:3: ( (lv_deployedServices_14_0= ruleImportedMicroservice ) )
            // InternalOperationDsl.g:684:4: (lv_deployedServices_14_0= ruleImportedMicroservice )
            {
            // InternalOperationDsl.g:684:4: (lv_deployedServices_14_0= ruleImportedMicroservice )
            // InternalOperationDsl.g:685:5: lv_deployedServices_14_0= ruleImportedMicroservice
            {

            					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeployedServicesImportedMicroserviceParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_16);
            lv_deployedServices_14_0=ruleImportedMicroservice();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
            					}
            					add(
            						current,
            						"deployedServices",
            						lv_deployedServices_14_0,
            						"de.fhdo.ddmm.operationdsl.OperationDsl.ImportedMicroservice");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:702:3: (otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalOperationDsl.g:703:4: otherlv_15= ',' ( (lv_deployedServices_16_0= ruleImportedMicroservice ) )
            	    {
            	    otherlv_15=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_15, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalOperationDsl.g:707:4: ( (lv_deployedServices_16_0= ruleImportedMicroservice ) )
            	    // InternalOperationDsl.g:708:5: (lv_deployedServices_16_0= ruleImportedMicroservice )
            	    {
            	    // InternalOperationDsl.g:708:5: (lv_deployedServices_16_0= ruleImportedMicroservice )
            	    // InternalOperationDsl.g:709:6: lv_deployedServices_16_0= ruleImportedMicroservice
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeployedServicesImportedMicroserviceParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_deployedServices_16_0=ruleImportedMicroservice();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"deployedServices",
            	    							lv_deployedServices_16_0,
            	    							"de.fhdo.ddmm.operationdsl.OperationDsl.ImportedMicroservice");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_17=(Token)match(input,24,FOLLOW_31); 

            			newLeafNode(otherlv_17, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalOperationDsl.g:731:3: (otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOperationDsl.g:732:4: otherlv_18= 'aspects' otherlv_19= '{' ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+ otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,25,FOLLOW_18); 

                    				newLeafNode(otherlv_18, grammarAccess.getInfrastructureNodeAccess().getAspectsKeyword_10_0());
                    			
                    otherlv_19=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_10_1());
                    			
                    // InternalOperationDsl.g:740:4: ( (lv_aspects_20_0= ruleImportedOperationAspect ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalOperationDsl.g:741:5: (lv_aspects_20_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:741:5: (lv_aspects_20_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:742:6: lv_aspects_20_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getAspectsImportedOperationAspectParserRuleCall_10_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_aspects_20_0=ruleImportedOperationAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aspects",
                    	    							lv_aspects_20_0,
                    	    							"de.fhdo.ddmm.operationdsl.OperationDsl.ImportedOperationAspect");
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

                    otherlv_21=(Token)match(input,26,FOLLOW_32); 

                    				newLeafNode(otherlv_21, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_10_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:764:3: (otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOperationDsl.g:765:4: otherlv_22= 'default' otherlv_23= 'values' otherlv_24= '{' ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+ otherlv_26= '}'
                    {
                    otherlv_22=(Token)match(input,27,FOLLOW_21); 

                    				newLeafNode(otherlv_22, grammarAccess.getInfrastructureNodeAccess().getDefaultKeyword_11_0());
                    			
                    otherlv_23=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_23, grammarAccess.getInfrastructureNodeAccess().getValuesKeyword_11_1());
                    			
                    otherlv_24=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_24, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalOperationDsl.g:777:4: ( (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment ) )+
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
                    	    // InternalOperationDsl.g:778:5: (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment )
                    	    {
                    	    // InternalOperationDsl.g:778:5: (lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment )
                    	    // InternalOperationDsl.g:779:6: lv_defaultServicePropertyValues_25_0= rulePropertyValueAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_11_3_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_defaultServicePropertyValues_25_0=rulePropertyValueAssignment();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"defaultServicePropertyValues",
                    	    							lv_defaultServicePropertyValues_25_0,
                    	    							"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
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

                    otherlv_26=(Token)match(input,26,FOLLOW_33); 

                    				newLeafNode(otherlv_26, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_11_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:801:3: (otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==30) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalOperationDsl.g:802:4: otherlv_27= 'endpoints' otherlv_28= '{' ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+ otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_27, grammarAccess.getInfrastructureNodeAccess().getEndpointsKeyword_12_0());
                    			
                    otherlv_28=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_28, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_12_1());
                    			
                    // InternalOperationDsl.g:810:4: ( (lv_endpoints_29_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:811:5: (lv_endpoints_29_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:811:5: (lv_endpoints_29_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:812:6: lv_endpoints_29_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getEndpointsBasicEndpointParserRuleCall_12_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    lv_endpoints_29_0=ruleBasicEndpoint();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"endpoints",
                    	    							lv_endpoints_29_0,
                    	    							"de.fhdo.ddmm.operationdsl.OperationDsl.BasicEndpoint");
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

                    otherlv_30=(Token)match(input,26,FOLLOW_19); 

                    				newLeafNode(otherlv_30, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_12_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:834:3: ( (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOperationDsl.g:835:4: (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:835:4: (lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:836:5: lv_deploymentSpecifications_31_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_deploymentSpecifications_31_0=ruleServiceDeploymentSpecification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deploymentSpecifications",
            	    						lv_deploymentSpecifications_31_0,
            	    						"de.fhdo.ddmm.operationdsl.OperationDsl.ServiceDeploymentSpecification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_32=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_32, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

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
    // InternalOperationDsl.g:861:1: entryRuleInfrastructureTechnologyReference returns [EObject current=null] : iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF ;
    public final EObject entryRuleInfrastructureTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnologyReference = null;


        try {
            // InternalOperationDsl.g:861:74: (iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF )
            // InternalOperationDsl.g:862:2: iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF
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
    // InternalOperationDsl.g:868:1: ruleInfrastructureTechnologyReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleInfrastructureTechnologyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:874:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:875:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:875:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:876:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:876:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:877:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:877:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:878:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:893:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:894:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:894:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:895:5: ruleQualifiedName
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
    // InternalOperationDsl.g:913:1: entryRuleProtocolAndDataFormat returns [EObject current=null] : iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF ;
    public final EObject entryRuleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:913:62: (iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:914:2: iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF
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
    // InternalOperationDsl.g:920:1: ruleProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:926:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalOperationDsl.g:927:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalOperationDsl.g:927:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalOperationDsl.g:928:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalOperationDsl.g:928:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:929:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:929:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:930:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:945:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:946:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:946:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:947:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getProtocolAndDataFormatAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_34);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:961:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalOperationDsl.g:962:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalOperationDsl.g:966:4: ( (otherlv_4= RULE_ID ) )
                    // InternalOperationDsl.g:967:5: (otherlv_4= RULE_ID )
                    {
                    // InternalOperationDsl.g:967:5: (otherlv_4= RULE_ID )
                    // InternalOperationDsl.g:968:6: otherlv_4= RULE_ID
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
    // InternalOperationDsl.g:984:1: entryRuleBasicEndpoint returns [EObject current=null] : iv_ruleBasicEndpoint= ruleBasicEndpoint EOF ;
    public final EObject entryRuleBasicEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicEndpoint = null;


        try {
            // InternalOperationDsl.g:984:54: (iv_ruleBasicEndpoint= ruleBasicEndpoint EOF )
            // InternalOperationDsl.g:985:2: iv_ruleBasicEndpoint= ruleBasicEndpoint EOF
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
    // InternalOperationDsl.g:991:1: ruleBasicEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:997:2: ( ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:998:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:998:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:999:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:999:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) )
            // InternalOperationDsl.g:1000:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:1000:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            // InternalOperationDsl.g:1001:5: lv_protocols_0_0= ruleProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_35);
            lv_protocols_0_0=ruleProtocolAndDataFormat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBasicEndpointRule());
            					}
            					add(
            						current,
            						"protocols",
            						lv_protocols_0_0,
            						"de.fhdo.ddmm.operationdsl.OperationDsl.ProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1018:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==23) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOperationDsl.g:1019:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getBasicEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:1023:4: ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:1024:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:1024:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    // InternalOperationDsl.g:1025:6: lv_protocols_2_0= ruleProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    lv_protocols_2_0=ruleProtocolAndDataFormat();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBasicEndpointRule());
            	    						}
            	    						add(
            	    							current,
            	    							"protocols",
            	    							lv_protocols_2_0,
            	    							"de.fhdo.ddmm.operationdsl.OperationDsl.ProtocolAndDataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_3=(Token)match(input,36,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getBasicEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:1047:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:1048:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1048:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:1049:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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

            // InternalOperationDsl.g:1065:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==23) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOperationDsl.g:1066:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getBasicEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:1070:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:1071:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:1071:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:1072:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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
            	    break loop28;
                }
            } while (true);

            otherlv_7=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:1097:1: entryRuleServiceDeploymentSpecification returns [EObject current=null] : iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF ;
    public final EObject entryRuleServiceDeploymentSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceDeploymentSpecification = null;


        try {
            // InternalOperationDsl.g:1097:71: (iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF )
            // InternalOperationDsl.g:1098:2: iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF
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
    // InternalOperationDsl.g:1104:1: ruleServiceDeploymentSpecification returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) ;
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
            // InternalOperationDsl.g:1110:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) )
            // InternalOperationDsl.g:1111:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            {
            // InternalOperationDsl.g:1111:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            // InternalOperationDsl.g:1112:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}'
            {
            // InternalOperationDsl.g:1112:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1113:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1113:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1114:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:1129:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1130:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1130:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1131:5: ruleQualifiedNameWithAtLeastOneLevel
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

            otherlv_3=(Token)match(input,24,FOLLOW_37); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:1149:3: ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOperationDsl.g:1150:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    {
            	    // InternalOperationDsl.g:1150:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    // InternalOperationDsl.g:1151:5: lv_servicePropertyValues_4_0= rulePropertyValueAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServicePropertyValuesPropertyValueAssignmentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_servicePropertyValues_4_0=rulePropertyValueAssignment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getServiceDeploymentSpecificationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"servicePropertyValues",
            	    						lv_servicePropertyValues_4_0,
            	    						"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalOperationDsl.g:1168:3: (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOperationDsl.g:1169:4: otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,29,FOLLOW_23); 

                    				newLeafNode(otherlv_5, grammarAccess.getServiceDeploymentSpecificationAccess().getBasicKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,30,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceDeploymentSpecificationAccess().getEndpointsKeyword_5_1());
                    			
                    otherlv_7=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_5_2());
                    			
                    // InternalOperationDsl.g:1181:4: ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1182:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1182:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:1183:6: lv_basicEndpoints_8_0= ruleBasicEndpoint
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
                    	    							"de.fhdo.ddmm.operationdsl.OperationDsl.BasicEndpoint");
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
    // InternalOperationDsl.g:1213:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:1213:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalOperationDsl.g:1214:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalOperationDsl.g:1220:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1226:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalOperationDsl.g:1227:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalOperationDsl.g:1227:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalOperationDsl.g:1228:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalOperationDsl.g:1228:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1229:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1229:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1230:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:1245:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1246:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1246:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1247:5: ruleQualifiedNameWithAtLeastOneLevel
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
    // InternalOperationDsl.g:1265:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalOperationDsl.g:1265:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalOperationDsl.g:1266:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalOperationDsl.g:1272:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject rulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:1278:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalOperationDsl.g:1279:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalOperationDsl.g:1279:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalOperationDsl.g:1280:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalOperationDsl.g:1280:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1281:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1281:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1282:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalOperationDsl.g:1297:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalOperationDsl.g:1298:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalOperationDsl.g:1298:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalOperationDsl.g:1299:5: lv_value_2_0= rulePrimitiveValue
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
            						"de.fhdo.ddmm.operationdsl.OperationDsl.PrimitiveValue");
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


    // $ANTLR start "entryRuleImportedOperationAspect"
    // InternalOperationDsl.g:1320:1: entryRuleImportedOperationAspect returns [EObject current=null] : iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF ;
    public final EObject entryRuleImportedOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedOperationAspect = null;


        try {
            // InternalOperationDsl.g:1320:64: (iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF )
            // InternalOperationDsl.g:1321:2: iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF
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
    // InternalOperationDsl.g:1327:1: ruleImportedOperationAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' ) | otherlv_9= ';' ) ) ;
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
            // InternalOperationDsl.g:1333:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' ) | otherlv_9= ';' ) ) )
            // InternalOperationDsl.g:1334:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' ) | otherlv_9= ';' ) )
            {
            // InternalOperationDsl.g:1334:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' ) | otherlv_9= ';' ) )
            // InternalOperationDsl.g:1335:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' ) | otherlv_9= ';' )
            {
            // InternalOperationDsl.g:1335:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1336:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1336:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1337:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:1352:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1353:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1353:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1354:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getAspectOperationAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_40);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1368:3: ( (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' ) | otherlv_9= ';' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            else if ( (LA34_0==37) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalOperationDsl.g:1369:4: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )
                    {
                    // InternalOperationDsl.g:1369:4: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )
                    // InternalOperationDsl.g:1370:5: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_41); 

                    					newLeafNode(otherlv_3, grammarAccess.getImportedOperationAspectAccess().getLeftParenthesisKeyword_3_0_0());
                    				
                    // InternalOperationDsl.g:1374:5: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_BOOLEAN)) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==RULE_ID) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalOperationDsl.g:1375:6: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:1375:6: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:1376:7: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:1376:7: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:1377:8: lv_singlePropertyValue_4_0= rulePrimitiveValue
                            {

                            								newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getSinglePropertyValuePrimitiveValueParserRuleCall_3_0_1_0_0());
                            							
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
                            									"de.fhdo.ddmm.operationdsl.OperationDsl.PrimitiveValue");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalOperationDsl.g:1395:6: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:1395:6: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:1396:7: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:1396:7: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:1397:8: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:1397:8: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:1398:9: lv_values_5_0= rulePropertyValueAssignment
                            {

                            									newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_0_1_1_0_0());
                            								
                            pushFollow(FOLLOW_42);
                            lv_values_5_0=rulePropertyValueAssignment();

                            state._fsp--;


                            									if (current==null) {
                            										current = createModelElementForParent(grammarAccess.getImportedOperationAspectRule());
                            									}
                            									add(
                            										current,
                            										"values",
                            										lv_values_5_0,
                            										"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
                            									afterParserOrEnumRuleCall();
                            								

                            }


                            }

                            // InternalOperationDsl.g:1415:7: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==23) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // InternalOperationDsl.g:1416:8: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,23,FOLLOW_7); 

                            	    								newLeafNode(otherlv_6, grammarAccess.getImportedOperationAspectAccess().getCommaKeyword_3_0_1_1_1_0());
                            	    							
                            	    // InternalOperationDsl.g:1420:8: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:1421:9: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:1421:9: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:1422:10: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    										newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_0_1_1_1_1_0());
                            	    									
                            	    pushFollow(FOLLOW_42);
                            	    lv_values_7_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    										if (current==null) {
                            	    											current = createModelElementForParent(grammarAccess.getImportedOperationAspectRule());
                            	    										}
                            	    										add(
                            	    											current,
                            	    											"values",
                            	    											lv_values_7_0,
                            	    											"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
                            	    										afterParserOrEnumRuleCall();
                            	    									

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop32;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getImportedOperationAspectAccess().getRightParenthesisKeyword_3_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:1448:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,37,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getImportedOperationAspectAccess().getSemicolonKeyword_3_1());
                    			

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
    // $ANTLR end "ruleImportedOperationAspect"


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalOperationDsl.g:1457:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalOperationDsl.g:1457:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalOperationDsl.g:1458:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalOperationDsl.g:1464:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1470:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalOperationDsl.g:1471:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalOperationDsl.g:1471:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt35=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt35=2;
                }
                break;
            case RULE_STRING:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalOperationDsl.g:1472:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalOperationDsl.g:1472:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalOperationDsl.g:1473:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalOperationDsl.g:1473:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalOperationDsl.g:1474:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalOperationDsl.g:1491:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalOperationDsl.g:1491:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:1492:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:1492:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:1493:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalOperationDsl.g:1510:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalOperationDsl.g:1510:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalOperationDsl.g:1511:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalOperationDsl.g:1511:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalOperationDsl.g:1512:5: lv_stringValue_2_0= RULE_STRING
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


    // $ANTLR start "entryRuleImport"
    // InternalOperationDsl.g:1532:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalOperationDsl.g:1532:47: (iv_ruleImport= ruleImport EOF )
            // InternalOperationDsl.g:1533:2: iv_ruleImport= ruleImport EOF
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
    // InternalOperationDsl.g:1539:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:1545:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:1546:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:1546:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:1547:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalOperationDsl.g:1551:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalOperationDsl.g:1552:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalOperationDsl.g:1552:4: (lv_importType_1_0= ruleImportType )
            // InternalOperationDsl.g:1553:5: lv_importType_1_0= ruleImportType
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
            						"de.fhdo.ddmm.operationdsl.OperationDsl.ImportType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:1574:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:1575:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1575:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:1576:5: lv_importURI_3_0= RULE_STRING
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

            otherlv_4=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:1596:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:1597:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:1597:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:1598:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:1618:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalOperationDsl.g:1618:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalOperationDsl.g:1619:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalOperationDsl.g:1625:1: ruleMicroservice returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) ;
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
            // InternalOperationDsl.g:1631:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' ) )
            // InternalOperationDsl.g:1632:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            {
            // InternalOperationDsl.g:1632:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}' )
            // InternalOperationDsl.g:1633:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )* ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_visibility_13_0= ruleVisibility ) )? ( (lv_type_14_0= ruleMicroserviceType ) ) otherlv_15= 'microservice' ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )? (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )? (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )? ( (lv_interfaces_41_0= ruleInterface ) )+ otherlv_42= '}'
            {
            // InternalOperationDsl.g:1633:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==13) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==14) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // InternalOperationDsl.g:1634:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMicroserviceAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalOperationDsl.g:1646:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalOperationDsl.g:1647:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalOperationDsl.g:1647:5: (otherlv_3= RULE_ID )
            	    // InternalOperationDsl.g:1648:6: otherlv_3= RULE_ID
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
            	    break loop36;
                }
            } while (true);

            // InternalOperationDsl.g:1664:3: ( ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )? )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==13) ) {
                int LA38_1 = input.LA(2);

                if ( ((LA38_1>=97 && LA38_1<=98)) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalOperationDsl.g:1665:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) ) ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:1665:4: ( (lv_protocols_5_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:1666:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:1666:5: (lv_protocols_5_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:1667:6: lv_protocols_5_0= ruleProtocolSpecification
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

                    // InternalOperationDsl.g:1684:4: ( (lv_protocols_6_0= ruleProtocolSpecification ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==13) ) {
                        int LA37_1 = input.LA(2);

                        if ( ((LA37_1>=97 && LA37_1<=98)) ) {
                            alt37=1;
                        }
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalOperationDsl.g:1685:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:1685:5: (lv_protocols_6_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:1686:6: lv_protocols_6_0= ruleProtocolSpecification
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

            // InternalOperationDsl.g:1704:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==13) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==30) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalOperationDsl.g:1705:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '(' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalOperationDsl.g:1717:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1718:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1718:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:1719:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
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
                    	    if ( cnt39 >= 1 ) break loop39;
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_46); 

                    				newLeafNode(otherlv_11, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1741:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==13) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalOperationDsl.g:1742:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:1742:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:1743:5: lv_aspects_12_0= ruleImportedServiceAspect
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
            	    break loop41;
                }
            } while (true);

            // InternalOperationDsl.g:1760:3: ( (lv_visibility_13_0= ruleVisibility ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=88 && LA42_0<=90)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalOperationDsl.g:1761:4: (lv_visibility_13_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:1761:4: (lv_visibility_13_0= ruleVisibility )
                    // InternalOperationDsl.g:1762:5: lv_visibility_13_0= ruleVisibility
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

            // InternalOperationDsl.g:1779:3: ( (lv_type_14_0= ruleMicroserviceType ) )
            // InternalOperationDsl.g:1780:4: (lv_type_14_0= ruleMicroserviceType )
            {
            // InternalOperationDsl.g:1780:4: (lv_type_14_0= ruleMicroserviceType )
            // InternalOperationDsl.g:1781:5: lv_type_14_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_48);
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

            otherlv_15=(Token)match(input,42,FOLLOW_7); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_6());
            		
            // InternalOperationDsl.g:1802:3: ( (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1803:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1803:4: (lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1804:5: lv_name_16_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_49);
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

            // InternalOperationDsl.g:1821:3: (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==43) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalOperationDsl.g:1822:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,43,FOLLOW_7); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalOperationDsl.g:1826:4: ( (lv_version_18_0= RULE_ID ) )
                    // InternalOperationDsl.g:1827:5: (lv_version_18_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1827:5: (lv_version_18_0= RULE_ID )
                    // InternalOperationDsl.g:1828:6: lv_version_18_0= RULE_ID
                    {
                    lv_version_18_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_19=(Token)match(input,24,FOLLOW_50); 

            			newLeafNode(otherlv_19, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalOperationDsl.g:1849:3: (otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==44) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==45) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalOperationDsl.g:1850:4: otherlv_20= 'required' otherlv_21= 'microservices' otherlv_22= '{' ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) ) (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )* otherlv_26= '}'
                    {
                    otherlv_20=(Token)match(input,44,FOLLOW_51); 

                    				newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_21=(Token)match(input,45,FOLLOW_18); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_22=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalOperationDsl.g:1862:4: ( (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice ) )
                    // InternalOperationDsl.g:1863:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalOperationDsl.g:1863:5: (lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice )
                    // InternalOperationDsl.g:1864:6: lv_requiredMicroservices_23_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_52);
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

                    // InternalOperationDsl.g:1881:4: (otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==23) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalOperationDsl.g:1882:5: otherlv_24= ',' ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_24=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalOperationDsl.g:1886:5: ( (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalOperationDsl.g:1887:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalOperationDsl.g:1887:6: (lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice )
                    	    // InternalOperationDsl.g:1888:7: lv_requiredMicroservices_25_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_52);
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
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,26,FOLLOW_50); 

                    				newLeafNode(otherlv_26, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1911:3: (otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==44) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==46) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalOperationDsl.g:1912:4: otherlv_27= 'required' otherlv_28= 'interfaces' otherlv_29= '{' ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) ) (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )* otherlv_33= '}'
                    {
                    otherlv_27=(Token)match(input,44,FOLLOW_53); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_28=(Token)match(input,46,FOLLOW_18); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_29=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalOperationDsl.g:1924:4: ( (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface ) )
                    // InternalOperationDsl.g:1925:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    {
                    // InternalOperationDsl.g:1925:5: (lv_requiredInterfaces_30_0= rulePossiblyImportedInterface )
                    // InternalOperationDsl.g:1926:6: lv_requiredInterfaces_30_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_52);
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

                    // InternalOperationDsl.g:1943:4: (otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==23) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalOperationDsl.g:1944:5: otherlv_31= ',' ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_31=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalOperationDsl.g:1948:5: ( (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface ) )
                    	    // InternalOperationDsl.g:1949:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalOperationDsl.g:1949:6: (lv_requiredInterfaces_32_0= rulePossiblyImportedInterface )
                    	    // InternalOperationDsl.g:1950:7: lv_requiredInterfaces_32_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_52);
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
                    	    break loop46;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,26,FOLLOW_50); 

                    				newLeafNode(otherlv_33, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1973:3: (otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==44) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalOperationDsl.g:1974:4: otherlv_34= 'required' otherlv_35= 'operations' otherlv_36= '{' ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) ) (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )* otherlv_40= '}'
                    {
                    otherlv_34=(Token)match(input,44,FOLLOW_54); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_35=(Token)match(input,47,FOLLOW_18); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_36=(Token)match(input,24,FOLLOW_7); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalOperationDsl.g:1986:4: ( (lv_requiredOperations_37_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:1987:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:1987:5: (lv_requiredOperations_37_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:1988:6: lv_requiredOperations_37_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_52);
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

                    // InternalOperationDsl.g:2005:4: (otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==23) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2006:5: otherlv_38= ',' ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_38=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_38, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2010:5: ( (lv_requiredOperations_39_0= rulePossiblyImportedOperation ) )
                    	    // InternalOperationDsl.g:2011:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalOperationDsl.g:2011:6: (lv_requiredOperations_39_0= rulePossiblyImportedOperation )
                    	    // InternalOperationDsl.g:2012:7: lv_requiredOperations_39_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_52);
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
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_40=(Token)match(input,26,FOLLOW_50); 

                    				newLeafNode(otherlv_40, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2035:3: ( (lv_interfaces_41_0= ruleInterface ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==13||(LA50_0>=48 && LA50_0<=49)||(LA50_0>=88 && LA50_0<=90)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalOperationDsl.g:2036:4: (lv_interfaces_41_0= ruleInterface )
            	    {
            	    // InternalOperationDsl.g:2036:4: (lv_interfaces_41_0= ruleInterface )
            	    // InternalOperationDsl.g:2037:5: lv_interfaces_41_0= ruleInterface
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
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            otherlv_42=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:2062:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:2062:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalOperationDsl.g:2063:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalOperationDsl.g:2069:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2075:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2076:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2076:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2077:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2077:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==31) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // InternalOperationDsl.g:2078:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2078:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2079:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2079:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2080:6: otherlv_0= RULE_ID
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

            // InternalOperationDsl.g:2096:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2097:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2097:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2098:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2116:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalOperationDsl.g:2116:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalOperationDsl.g:2117:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalOperationDsl.g:2123:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2129:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2130:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2130:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2131:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2131:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==31) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalOperationDsl.g:2132:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2132:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2133:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2133:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2134:6: otherlv_0= RULE_ID
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

            // InternalOperationDsl.g:2150:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2151:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2151:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2152:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2170:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalOperationDsl.g:2170:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalOperationDsl.g:2171:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalOperationDsl.g:2177:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2183:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2184:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2184:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2185:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2185:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==31) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalOperationDsl.g:2186:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2186:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2187:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2187:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2188:6: otherlv_0= RULE_ID
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

            // InternalOperationDsl.g:2204:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2205:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2205:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2206:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2224:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalOperationDsl.g:2224:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalOperationDsl.g:2225:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalOperationDsl.g:2231:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) ;
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
            // InternalOperationDsl.g:2237:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' ) )
            // InternalOperationDsl.g:2238:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            {
            // InternalOperationDsl.g:2238:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}' )
            // InternalOperationDsl.g:2239:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '{' ( (lv_referredOperations_13_0= ruleReferredOperation ) )* ( (lv_operations_14_0= ruleOperation ) )* otherlv_15= '}'
            {
            // InternalOperationDsl.g:2239:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==13) ) {
                int LA55_1 = input.LA(2);

                if ( ((LA55_1>=97 && LA55_1<=98)) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalOperationDsl.g:2240:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2240:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2241:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2241:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2242:6: lv_protocols_0_0= ruleProtocolSpecification
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

                    // InternalOperationDsl.g:2259:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==13) ) {
                        int LA54_1 = input.LA(2);

                        if ( ((LA54_1>=97 && LA54_1<=98)) ) {
                            alt54=1;
                        }
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalOperationDsl.g:2260:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2260:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2261:6: lv_protocols_1_0= ruleProtocolSpecification
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

            // InternalOperationDsl.g:2279:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==13) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==30) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalOperationDsl.g:2280:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2292:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2293:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2293:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2294:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
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
                    	    if ( cnt56 >= 1 ) break loop56;
                                EarlyExitException eee =
                                    new EarlyExitException(56, input);
                                throw eee;
                        }
                        cnt56++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_56); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2316:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==13) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalOperationDsl.g:2317:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2317:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2318:5: lv_aspects_7_0= ruleImportedServiceAspect
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
            	    break loop58;
                }
            } while (true);

            // InternalOperationDsl.g:2335:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==48) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalOperationDsl.g:2336:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:2336:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalOperationDsl.g:2337:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,48,FOLLOW_57); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2349:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=88 && LA60_0<=90)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalOperationDsl.g:2350:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2350:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:2351:5: lv_visibility_9_0= ruleVisibility
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

            otherlv_10=(Token)match(input,49,FOLLOW_7); 

            			newLeafNode(otherlv_10, grammarAccess.getInterfaceAccess().getInterfaceKeyword_5());
            		
            // InternalOperationDsl.g:2372:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalOperationDsl.g:2373:4: (lv_name_11_0= RULE_ID )
            {
            // InternalOperationDsl.g:2373:4: (lv_name_11_0= RULE_ID )
            // InternalOperationDsl.g:2374:5: lv_name_11_0= RULE_ID
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

            otherlv_12=(Token)match(input,24,FOLLOW_59); 

            			newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalOperationDsl.g:2394:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*
            loop61:
            do {
                int alt61=2;
                alt61 = dfa61.predict(input);
                switch (alt61) {
            	case 1 :
            	    // InternalOperationDsl.g:2395:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    {
            	    // InternalOperationDsl.g:2395:4: (lv_referredOperations_13_0= ruleReferredOperation )
            	    // InternalOperationDsl.g:2396:5: lv_referredOperations_13_0= ruleReferredOperation
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
            	    break loop61;
                }
            } while (true);

            // InternalOperationDsl.g:2413:3: ( (lv_operations_14_0= ruleOperation ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID||LA62_0==13||LA62_0==48||(LA62_0>=88 && LA62_0<=90)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalOperationDsl.g:2414:4: (lv_operations_14_0= ruleOperation )
            	    {
            	    // InternalOperationDsl.g:2414:4: (lv_operations_14_0= ruleOperation )
            	    // InternalOperationDsl.g:2415:5: lv_operations_14_0= ruleOperation
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
            	    break loop62;
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
    // InternalOperationDsl.g:2440:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalOperationDsl.g:2440:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalOperationDsl.g:2441:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalOperationDsl.g:2447:1: ruleOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) ;
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
            // InternalOperationDsl.g:2453:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' ) )
            // InternalOperationDsl.g:2454:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            {
            // InternalOperationDsl.g:2454:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';' )
            // InternalOperationDsl.g:2455:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_name_10_0= RULE_ID ) ) otherlv_11= '(' ( (lv_parameters_12_0= ruleParameter ) )? (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )* otherlv_15= ')' otherlv_16= ';'
            {
            // InternalOperationDsl.g:2455:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==13) ) {
                int LA64_1 = input.LA(2);

                if ( ((LA64_1>=97 && LA64_1<=98)) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalOperationDsl.g:2456:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2456:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2457:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2457:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2458:6: lv_protocols_0_0= ruleProtocolSpecification
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

                    // InternalOperationDsl.g:2475:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==13) ) {
                        int LA63_1 = input.LA(2);

                        if ( ((LA63_1>=97 && LA63_1<=98)) ) {
                            alt63=1;
                        }
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalOperationDsl.g:2476:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2476:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2477:6: lv_protocols_1_0= ruleProtocolSpecification
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

            // InternalOperationDsl.g:2495:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==13) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==30) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalOperationDsl.g:2496:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2508:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2509:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2509:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2510:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
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
                    	    if ( cnt65 >= 1 ) break loop65;
                                EarlyExitException eee =
                                    new EarlyExitException(65, input);
                                throw eee;
                        }
                        cnt65++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_61); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2532:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==13) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalOperationDsl.g:2533:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2533:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2534:5: lv_aspects_7_0= ruleImportedServiceAspect
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
            	    break loop67;
                }
            } while (true);

            // InternalOperationDsl.g:2551:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==48) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalOperationDsl.g:2552:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:2552:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalOperationDsl.g:2553:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,48,FOLLOW_62); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2565:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=88 && LA69_0<=90)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalOperationDsl.g:2566:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2566:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:2567:5: lv_visibility_9_0= ruleVisibility
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

            // InternalOperationDsl.g:2584:3: ( (lv_name_10_0= RULE_ID ) )
            // InternalOperationDsl.g:2585:4: (lv_name_10_0= RULE_ID )
            {
            // InternalOperationDsl.g:2585:4: (lv_name_10_0= RULE_ID )
            // InternalOperationDsl.g:2586:5: lv_name_10_0= RULE_ID
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
            		
            // InternalOperationDsl.g:2606:3: ( (lv_parameters_12_0= ruleParameter ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==13||(LA70_0>=97 && LA70_0<=98)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalOperationDsl.g:2607:4: (lv_parameters_12_0= ruleParameter )
                    {
                    // InternalOperationDsl.g:2607:4: (lv_parameters_12_0= ruleParameter )
                    // InternalOperationDsl.g:2608:5: lv_parameters_12_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_42);
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

            // InternalOperationDsl.g:2625:3: (otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==23) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalOperationDsl.g:2626:4: otherlv_13= ',' ( (lv_parameters_14_0= ruleParameter ) )
            	    {
            	    otherlv_13=(Token)match(input,23,FOLLOW_64); 

            	    				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalOperationDsl.g:2630:4: ( (lv_parameters_14_0= ruleParameter ) )
            	    // InternalOperationDsl.g:2631:5: (lv_parameters_14_0= ruleParameter )
            	    {
            	    // InternalOperationDsl.g:2631:5: (lv_parameters_14_0= ruleParameter )
            	    // InternalOperationDsl.g:2632:6: lv_parameters_14_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
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
            	    break loop71;
                }
            } while (true);

            otherlv_15=(Token)match(input,16,FOLLOW_65); 

            			newLeafNode(otherlv_15, grammarAccess.getOperationAccess().getRightParenthesisKeyword_9());
            		
            otherlv_16=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:2662:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalOperationDsl.g:2662:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalOperationDsl.g:2663:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalOperationDsl.g:2669:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalOperationDsl.g:2675:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalOperationDsl.g:2676:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalOperationDsl.g:2676:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalOperationDsl.g:2677:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalOperationDsl.g:2677:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==13) ) {
                int LA73_1 = input.LA(2);

                if ( ((LA73_1>=97 && LA73_1<=98)) ) {
                    alt73=1;
                }
            }
            switch (alt73) {
                case 1 :
                    // InternalOperationDsl.g:2678:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2678:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2679:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2679:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2680:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_66);
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

                    // InternalOperationDsl.g:2697:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==13) ) {
                        int LA72_1 = input.LA(2);

                        if ( ((LA72_1>=97 && LA72_1<=98)) ) {
                            alt72=1;
                        }
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalOperationDsl.g:2698:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2698:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2699:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_66);
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

            // InternalOperationDsl.g:2717:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==13) ) {
                int LA75_1 = input.LA(2);

                if ( (LA75_1==30) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // InternalOperationDsl.g:2718:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,30,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2730:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt74=0;
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==RULE_ID) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2731:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2731:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2732:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
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
                    	    if ( cnt74 >= 1 ) break loop74;
                                EarlyExitException eee =
                                    new EarlyExitException(74, input);
                                throw eee;
                        }
                        cnt74++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_66); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2754:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==13) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalOperationDsl.g:2755:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2755:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2756:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    break loop76;
                }
            } while (true);

            otherlv_8=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalOperationDsl.g:2777:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2778:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2778:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2779:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_65);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:2801:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalOperationDsl.g:2801:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalOperationDsl.g:2802:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalOperationDsl.g:2808:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalOperationDsl.g:2814:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalOperationDsl.g:2815:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalOperationDsl.g:2815:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalOperationDsl.g:2816:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalOperationDsl.g:2816:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==13) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalOperationDsl.g:2817:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2817:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2818:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_64);
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
            	    break loop77;
                }
            } while (true);

            // InternalOperationDsl.g:2835:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:2836:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:2836:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:2837:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_67);
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

            // InternalOperationDsl.g:2854:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=94 && LA78_0<=96)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalOperationDsl.g:2855:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:2855:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:2856:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_68);
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

            // InternalOperationDsl.g:2873:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==51) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalOperationDsl.g:2874:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalOperationDsl.g:2874:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalOperationDsl.g:2875:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,51,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2887:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalOperationDsl.g:2888:4: (lv_name_4_0= RULE_ID )
            {
            // InternalOperationDsl.g:2888:4: (lv_name_4_0= RULE_ID )
            // InternalOperationDsl.g:2889:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_69); 

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

            // InternalOperationDsl.g:2905:3: ( (lv_optional_5_0= '?' ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==52) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalOperationDsl.g:2906:4: (lv_optional_5_0= '?' )
                    {
                    // InternalOperationDsl.g:2906:4: (lv_optional_5_0= '?' )
                    // InternalOperationDsl.g:2907:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,52,FOLLOW_70); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,36,FOLLOW_71); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalOperationDsl.g:2923:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=78 && LA81_0<=87)) ) {
                alt81=1;
            }
            else if ( (LA81_0==RULE_ID) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalOperationDsl.g:2924:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:2924:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:2925:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:2925:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalOperationDsl.g:2926:6: lv_primitiveType_7_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:2944:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalOperationDsl.g:2944:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalOperationDsl.g:2945:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalOperationDsl.g:2945:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalOperationDsl.g:2946:6: lv_importedType_8_0= ruleImportedType
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

            // InternalOperationDsl.g:2964:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==38) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalOperationDsl.g:2965:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalOperationDsl.g:2969:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:2970:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:2970:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:2971:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalOperationDsl.g:2993:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalOperationDsl.g:2993:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalOperationDsl.g:2994:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalOperationDsl.g:3000:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3006:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:3007:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:3007:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:3008:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:3008:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3009:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3009:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3010:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:3025:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3026:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3026:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3027:5: ruleQualifiedName
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
    // InternalOperationDsl.g:3045:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalOperationDsl.g:3045:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalOperationDsl.g:3046:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalOperationDsl.g:3052:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3058:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalOperationDsl.g:3059:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalOperationDsl.g:3059:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalOperationDsl.g:3060:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3064:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3065:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3065:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:3066:5: lv_communicationType_1_0= ruleCommunicationType
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
            		
            // InternalOperationDsl.g:3087:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3088:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3088:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3089:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
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
    // InternalOperationDsl.g:3114:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:3114:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:3115:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalOperationDsl.g:3121:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3127:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalOperationDsl.g:3128:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalOperationDsl.g:3128:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalOperationDsl.g:3129:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalOperationDsl.g:3129:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3130:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3130:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3131:5: otherlv_0= RULE_ID
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
            		
            // InternalOperationDsl.g:3146:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3147:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3147:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3148:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedProtocolAndDataFormatAccess().getImportedProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_34);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:3162:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==35) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalOperationDsl.g:3163:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalOperationDsl.g:3167:4: ( (otherlv_4= RULE_ID ) )
                    // InternalOperationDsl.g:3168:5: (otherlv_4= RULE_ID )
                    {
                    // InternalOperationDsl.g:3168:5: (otherlv_4= RULE_ID )
                    // InternalOperationDsl.g:3169:6: otherlv_4= RULE_ID
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
    // InternalOperationDsl.g:3185:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalOperationDsl.g:3185:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalOperationDsl.g:3186:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalOperationDsl.g:3192:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:3198:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:3199:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:3199:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:3200:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:3200:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3201:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3201:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3202:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_35);
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

            // InternalOperationDsl.g:3219:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==23) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalOperationDsl.g:3220:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:3224:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:3225:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:3225:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalOperationDsl.g:3226:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getEndpointAccess().getProtocolsImportedProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_35);
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
            	    break loop84;
                }
            } while (true);

            otherlv_3=(Token)match(input,36,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:3248:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:3249:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:3249:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:3250:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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

            // InternalOperationDsl.g:3266:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==23) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalOperationDsl.g:3267:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:3271:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:3272:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:3272:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:3273:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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
            	    break loop85;
                }
            } while (true);

            otherlv_7=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:3298:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalOperationDsl.g:3298:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalOperationDsl.g:3299:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalOperationDsl.g:3305:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalOperationDsl.g:3311:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalOperationDsl.g:3312:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalOperationDsl.g:3312:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalOperationDsl.g:3313:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3317:3: ( (otherlv_1= RULE_ID ) )
            // InternalOperationDsl.g:3318:4: (otherlv_1= RULE_ID )
            {
            // InternalOperationDsl.g:3318:4: (otherlv_1= RULE_ID )
            // InternalOperationDsl.g:3319:5: otherlv_1= RULE_ID
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
            		
            // InternalOperationDsl.g:3334:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3335:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3335:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3336:5: ruleQualifiedName
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

            // InternalOperationDsl.g:3350:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==15) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalOperationDsl.g:3351:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_41); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalOperationDsl.g:3355:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( ((LA87_0>=RULE_STRING && LA87_0<=RULE_BOOLEAN)) ) {
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
                            // InternalOperationDsl.g:3356:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:3356:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:3357:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:3357:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:3358:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
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
                            								"de.fhdo.ddmm.operationdsl.OperationDsl.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalOperationDsl.g:3376:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:3376:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:3377:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:3377:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:3378:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:3378:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:3379:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_42);
                            lv_values_6_0=rulePropertyValueAssignment();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            								}
                            								add(
                            									current,
                            									"values",
                            									lv_values_6_0,
                            									"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalOperationDsl.g:3396:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop86:
                            do {
                                int alt86=2;
                                int LA86_0 = input.LA(1);

                                if ( (LA86_0==23) ) {
                                    alt86=1;
                                }


                                switch (alt86) {
                            	case 1 :
                            	    // InternalOperationDsl.g:3397:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,23,FOLLOW_7); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:3401:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:3402:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:3402:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:3403:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_42);
                            	    lv_values_8_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getImportedServiceAspectRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"values",
                            	    										lv_values_8_0,
                            	    										"de.fhdo.ddmm.operationdsl.OperationDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop86;
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
    // InternalOperationDsl.g:3432:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalOperationDsl.g:3432:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalOperationDsl.g:3433:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalOperationDsl.g:3439:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3445:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalOperationDsl.g:3446:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalOperationDsl.g:3446:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalOperationDsl.g:3447:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_74); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,53,FOLLOW_7); 

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
    // InternalOperationDsl.g:3473:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalOperationDsl.g:3473:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalOperationDsl.g:3474:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalOperationDsl.g:3480:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:3486:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:3487:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:3487:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:3488:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:3500:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:3501:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:3501:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:3502:5: lv_importURI_3_0= RULE_STRING
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

            otherlv_4=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:3522:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:3523:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:3523:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:3524:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:3544:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalOperationDsl.g:3544:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalOperationDsl.g:3545:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalOperationDsl.g:3551:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalOperationDsl.g:3557:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalOperationDsl.g:3558:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalOperationDsl.g:3558:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalOperationDsl.g:3559:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalOperationDsl.g:3559:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3560:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3560:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalOperationDsl.g:3561:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalOperationDsl.g:3578:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:3579:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:3579:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:3580:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_75); 

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

            otherlv_2=(Token)match(input,54,FOLLOW_76); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,55,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalOperationDsl.g:3604:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalOperationDsl.g:3605:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalOperationDsl.g:3605:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalOperationDsl.g:3606:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_77);
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

            // InternalOperationDsl.g:3623:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==23) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalOperationDsl.g:3624:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:3628:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalOperationDsl.g:3629:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalOperationDsl.g:3629:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalOperationDsl.g:3630:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_77);
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
            	    break loop89;
                }
            } while (true);

            // InternalOperationDsl.g:3648:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==27) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalOperationDsl.g:3649:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:3649:4: ( (lv_default_7_0= 'default' ) )
                    // InternalOperationDsl.g:3650:5: (lv_default_7_0= 'default' )
                    {
                    // InternalOperationDsl.g:3650:5: (lv_default_7_0= 'default' )
                    // InternalOperationDsl.g:3651:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,27,FOLLOW_78); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_79); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalOperationDsl.g:3671:4: ( (otherlv_10= RULE_ID ) )
                    // InternalOperationDsl.g:3672:5: (otherlv_10= RULE_ID )
                    {
                    // InternalOperationDsl.g:3672:5: (otherlv_10= RULE_ID )
                    // InternalOperationDsl.g:3673:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_65); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:3693:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalOperationDsl.g:3693:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalOperationDsl.g:3694:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalOperationDsl.g:3700:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3706:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalOperationDsl.g:3707:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:3707:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalOperationDsl.g:3708:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:3708:3: (lv_formatName_0_0= RULE_ID )
            // InternalOperationDsl.g:3709:4: lv_formatName_0_0= RULE_ID
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
    // InternalOperationDsl.g:3728:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalOperationDsl.g:3728:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalOperationDsl.g:3729:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalOperationDsl.g:3735:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:3741:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:3742:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:3742:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalOperationDsl.g:3743:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_80); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,58,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:3751:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:3752:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:3752:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:3753:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_81); 

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

            // InternalOperationDsl.g:3769:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==59) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalOperationDsl.g:3770:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,59,FOLLOW_82); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,60,FOLLOW_83); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalOperationDsl.g:3778:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:3779:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:3779:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalOperationDsl.g:3780:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_77);
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

                    // InternalOperationDsl.g:3797:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==23) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalOperationDsl.g:3798:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_83); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalOperationDsl.g:3802:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalOperationDsl.g:3803:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalOperationDsl.g:3803:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalOperationDsl.g:3804:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_77);
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
                    	    break loop91;
                        }
                    } while (true);

                    // InternalOperationDsl.g:3822:4: ( (lv_default_8_0= 'default' ) )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==27) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // InternalOperationDsl.g:3823:5: (lv_default_8_0= 'default' )
                            {
                            // InternalOperationDsl.g:3823:5: (lv_default_8_0= 'default' )
                            // InternalOperationDsl.g:3824:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,27,FOLLOW_65); 

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

            otherlv_9=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:3845:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalOperationDsl.g:3845:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalOperationDsl.g:3846:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalOperationDsl.g:3852:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3858:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:3859:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:3859:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:3860:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_80); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,58,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:3868:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:3869:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:3869:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:3870:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_65); 

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

            otherlv_3=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:3894:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalOperationDsl.g:3894:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalOperationDsl.g:3895:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalOperationDsl.g:3901:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3907:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:3908:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:3908:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:3909:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_80); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,58,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:3917:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:3918:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:3918:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:3919:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_65); 

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

            otherlv_3=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:3943:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalOperationDsl.g:3943:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalOperationDsl.g:3944:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalOperationDsl.g:3950:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3956:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:3957:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:3957:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:3958:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:3958:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID) ) {
                int LA94_1 = input.LA(2);

                if ( (LA94_1==31) ) {
                    alt94=1;
                }
            }
            switch (alt94) {
                case 1 :
                    // InternalOperationDsl.g:3959:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:3959:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:3960:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:3960:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:3961:6: otherlv_0= RULE_ID
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

            // InternalOperationDsl.g:3977:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3978:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3978:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3979:5: ruleQualifiedName
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
    // InternalOperationDsl.g:3997:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalOperationDsl.g:3997:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalOperationDsl.g:3998:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalOperationDsl.g:4004:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalOperationDsl.g:4010:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalOperationDsl.g:4011:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalOperationDsl.g:4011:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalOperationDsl.g:4012:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalOperationDsl.g:4012:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:4013:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:4013:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:4014:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_84);
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

            // InternalOperationDsl.g:4031:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==23) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalOperationDsl.g:4032:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:4036:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalOperationDsl.g:4037:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalOperationDsl.g:4037:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalOperationDsl.g:4038:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_84);
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
            	    break loop95;
                }
            } while (true);

            // InternalOperationDsl.g:4056:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalOperationDsl.g:4057:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalOperationDsl.g:4057:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalOperationDsl.g:4058:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalOperationDsl.g:4075:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:4076:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:4076:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:4077:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_65);
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

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:4102:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalOperationDsl.g:4102:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalOperationDsl.g:4103:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalOperationDsl.g:4109:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:4115:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:4116:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:4116:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:4117:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:4117:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:4118:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:4118:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:4119:5: lv_name_0_0= RULE_ID
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
            		
            otherlv_2=(Token)match(input,20,FOLLOW_85); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,63,FOLLOW_38); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,38,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:4151:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:4152:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:4152:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:4153:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_36);
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

            // InternalOperationDsl.g:4170:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==23) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalOperationDsl.g:4171:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:4175:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:4176:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:4176:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:4177:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_36);
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
            	    break loop96;
                }
            } while (true);

            otherlv_8=(Token)match(input,37,FOLLOW_86); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:4199:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==64) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalOperationDsl.g:4200:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,64,FOLLOW_87); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,65,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,24,FOLLOW_83); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:4212:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt97=0;
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( ((LA97_0>=78 && LA97_0<=87)) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4213:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:4213:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:4214:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_88);
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
                    	    if ( cnt97 >= 1 ) break loop97;
                                EarlyExitException eee =
                                    new EarlyExitException(97, input);
                                throw eee;
                        }
                        cnt97++;
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
    // InternalOperationDsl.g:4244:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalOperationDsl.g:4244:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalOperationDsl.g:4245:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalOperationDsl.g:4251:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:4257:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:4258:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:4258:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:4259:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:4259:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:4260:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:4260:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:4261:5: lv_name_0_0= RULE_ID
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
            		
            otherlv_2=(Token)match(input,20,FOLLOW_85); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,63,FOLLOW_38); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,38,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:4293:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:4294:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:4294:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:4295:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_36);
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

            // InternalOperationDsl.g:4312:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==23) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalOperationDsl.g:4313:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:4317:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:4318:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:4318:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:4319:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_36);
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
            	    break loop99;
                }
            } while (true);

            otherlv_8=(Token)match(input,37,FOLLOW_86); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:4341:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==64) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalOperationDsl.g:4342:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,64,FOLLOW_87); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,65,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,24,FOLLOW_83); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:4354:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt100=0;
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( ((LA100_0>=78 && LA100_0<=87)) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4355:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:4355:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:4356:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_88);
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
                    	    if ( cnt100 >= 1 ) break loop100;
                                EarlyExitException eee =
                                    new EarlyExitException(100, input);
                                throw eee;
                        }
                        cnt100++;
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
    // InternalOperationDsl.g:4386:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalOperationDsl.g:4386:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalOperationDsl.g:4387:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalOperationDsl.g:4393:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:4399:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalOperationDsl.g:4400:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalOperationDsl.g:4400:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalOperationDsl.g:4401:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalOperationDsl.g:4401:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalOperationDsl.g:4402:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalOperationDsl.g:4402:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalOperationDsl.g:4403:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_89); 

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

            // InternalOperationDsl.g:4419:3: ( (lv_default_1_0= 'default' ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==27) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalOperationDsl.g:4420:4: (lv_default_1_0= 'default' )
                    {
                    // InternalOperationDsl.g:4420:4: (lv_default_1_0= 'default' )
                    // InternalOperationDsl.g:4421:5: lv_default_1_0= 'default'
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
    // InternalOperationDsl.g:4437:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalOperationDsl.g:4437:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalOperationDsl.g:4438:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalOperationDsl.g:4444:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) ;
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
            // InternalOperationDsl.g:4450:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' ) )
            // InternalOperationDsl.g:4451:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            {
            // InternalOperationDsl.g:4451:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';' )
            // InternalOperationDsl.g:4452:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )? otherlv_5= ';'
            {
            // InternalOperationDsl.g:4452:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalOperationDsl.g:4453:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalOperationDsl.g:4453:4: (lv_type_0_0= rulePrimitiveType )
            // InternalOperationDsl.g:4454:5: lv_type_0_0= rulePrimitiveType
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

            // InternalOperationDsl.g:4471:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:4472:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:4472:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:4473:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_90); 

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

            // InternalOperationDsl.g:4489:3: ( (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) ) | ( (lv_mandatory_4_0= 'mandatory' ) ) )?
            int alt103=3;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==38) ) {
                alt103=1;
            }
            else if ( (LA103_0==66) ) {
                alt103=2;
            }
            switch (alt103) {
                case 1 :
                    // InternalOperationDsl.g:4490:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    {
                    // InternalOperationDsl.g:4490:4: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )
                    // InternalOperationDsl.g:4491:5: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_39); 

                    					newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0_0());
                    				
                    // InternalOperationDsl.g:4495:5: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:4496:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:4496:6: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:4497:7: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_65);
                    lv_defaultValue_3_0=rulePrimitiveValue();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTechnologySpecificPropertyRule());
                    							}
                    							set(
                    								current,
                    								"defaultValue",
                    								lv_defaultValue_3_0,
                    								"de.fhdo.ddmm.operationdsl.OperationDsl.PrimitiveValue");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:4516:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    {
                    // InternalOperationDsl.g:4516:4: ( (lv_mandatory_4_0= 'mandatory' ) )
                    // InternalOperationDsl.g:4517:5: (lv_mandatory_4_0= 'mandatory' )
                    {
                    // InternalOperationDsl.g:4517:5: (lv_mandatory_4_0= 'mandatory' )
                    // InternalOperationDsl.g:4518:6: lv_mandatory_4_0= 'mandatory'
                    {
                    lv_mandatory_4_0=(Token)match(input,66,FOLLOW_65); 

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

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:4539:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalOperationDsl.g:4539:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalOperationDsl.g:4540:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalOperationDsl.g:4546:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalOperationDsl.g:4552:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalOperationDsl.g:4553:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalOperationDsl.g:4553:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt104=4;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt104=1;
                }
                break;
            case 68:
                {
                alt104=2;
                }
                break;
            case 69:
                {
                alt104=3;
                }
                break;
            case 70:
                {
                alt104=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalOperationDsl.g:4554:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalOperationDsl.g:4554:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalOperationDsl.g:4555:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalOperationDsl.g:4555:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalOperationDsl.g:4556:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalOperationDsl.g:4556:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalOperationDsl.g:4557:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,67,FOLLOW_38); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,38,FOLLOW_91); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:4573:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalOperationDsl.g:4574:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:4574:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:4575:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalOperationDsl.g:4594:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalOperationDsl.g:4594:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalOperationDsl.g:4595:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalOperationDsl.g:4595:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalOperationDsl.g:4596:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalOperationDsl.g:4596:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalOperationDsl.g:4597:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,68,FOLLOW_38); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,38,FOLLOW_64); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalOperationDsl.g:4613:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalOperationDsl.g:4614:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalOperationDsl.g:4614:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalOperationDsl.g:4615:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalOperationDsl.g:4634:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:4634:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalOperationDsl.g:4635:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:4635:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalOperationDsl.g:4636:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalOperationDsl.g:4636:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalOperationDsl.g:4637:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,69,FOLLOW_38); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalOperationDsl.g:4653:4: ( (otherlv_8= RULE_ID ) )
                    // InternalOperationDsl.g:4654:5: (otherlv_8= RULE_ID )
                    {
                    // InternalOperationDsl.g:4654:5: (otherlv_8= RULE_ID )
                    // InternalOperationDsl.g:4655:6: otherlv_8= RULE_ID
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
                    // InternalOperationDsl.g:4668:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:4668:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalOperationDsl.g:4669:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:4669:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalOperationDsl.g:4670:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalOperationDsl.g:4670:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalOperationDsl.g:4671:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,70,FOLLOW_38); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalOperationDsl.g:4687:4: ( (otherlv_11= RULE_ID ) )
                    // InternalOperationDsl.g:4688:5: (otherlv_11= RULE_ID )
                    {
                    // InternalOperationDsl.g:4688:5: (otherlv_11= RULE_ID )
                    // InternalOperationDsl.g:4689:6: otherlv_11= RULE_ID
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
    // InternalOperationDsl.g:4705:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:4705:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalOperationDsl.g:4706:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:4712:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:4718:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:4719:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:4719:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:4720:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_92); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:4728:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalOperationDsl.g:4729:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalOperationDsl.g:4729:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalOperationDsl.g:4730:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_42);
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

            // InternalOperationDsl.g:4747:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==23) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalOperationDsl.g:4748:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_92); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:4752:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalOperationDsl.g:4753:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:4753:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalOperationDsl.g:4754:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
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
            	    break loop105;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_65); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:4784:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalOperationDsl.g:4784:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalOperationDsl.g:4785:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalOperationDsl.g:4791:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) ;
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
            // InternalOperationDsl.g:4797:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) ) )
            // InternalOperationDsl.g:4798:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            {
            // InternalOperationDsl.g:4798:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' ) )
            // InternalOperationDsl.g:4799:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:4803:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:4804:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:4804:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:4805:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_93); 

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

            otherlv_2=(Token)match(input,73,FOLLOW_94); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getForKeyword_2());
            		
            // InternalOperationDsl.g:4825:3: ( (lv_joinPoints_3_0= ruleServiceJoinPointType ) )
            // InternalOperationDsl.g:4826:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            {
            // InternalOperationDsl.g:4826:4: (lv_joinPoints_3_0= ruleServiceJoinPointType )
            // InternalOperationDsl.g:4827:5: lv_joinPoints_3_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_95);
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

            // InternalOperationDsl.g:4844:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) ) )*
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==23) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // InternalOperationDsl.g:4845:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_94); 

            	    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:4849:4: ( (lv_joinPoints_5_0= ruleServiceJoinPointType ) )
            	    // InternalOperationDsl.g:4850:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    {
            	    // InternalOperationDsl.g:4850:5: (lv_joinPoints_5_0= ruleServiceJoinPointType )
            	    // InternalOperationDsl.g:4851:6: lv_joinPoints_5_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_95);
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
            	    break loop106;
                }
            } while (true);

            // InternalOperationDsl.g:4869:3: ( (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' ) | otherlv_10= ';' )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==24) ) {
                alt109=1;
            }
            else if ( (LA109_0==37) ) {
                alt109=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // InternalOperationDsl.g:4870:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    {
                    // InternalOperationDsl.g:4870:4: (otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}' )
                    // InternalOperationDsl.g:4871:5: otherlv_6= '{' ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_96); 

                    					newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalOperationDsl.g:4875:5: ( (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==71) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4876:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:4876:6: (lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector )
                    	    // InternalOperationDsl.g:4877:7: lv_pointcutSelectors_7_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_96);
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
                    	    break loop107;
                        }
                    } while (true);

                    // InternalOperationDsl.g:4894:5: ( (lv_properties_8_0= ruleTechnologySpecificProperty ) )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( ((LA108_0>=78 && LA108_0<=87)) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // InternalOperationDsl.g:4895:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:4895:6: (lv_properties_8_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:4896:7: lv_properties_8_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_88);
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
                    	    break loop108;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:4919:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:4928:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalOperationDsl.g:4928:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalOperationDsl.g:4929:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalOperationDsl.g:4935:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) ;
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
            // InternalOperationDsl.g:4941:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) ) )
            // InternalOperationDsl.g:4942:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            {
            // InternalOperationDsl.g:4942:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' ) )
            // InternalOperationDsl.g:4943:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) ) (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )* ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:4947:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:4948:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:4948:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:4949:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_93); 

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

            otherlv_2=(Token)match(input,73,FOLLOW_97); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getForKeyword_2());
            		
            // InternalOperationDsl.g:4969:3: ( (lv_joinPoints_3_0= ruleOperationJoinPointType ) )
            // InternalOperationDsl.g:4970:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            {
            // InternalOperationDsl.g:4970:4: (lv_joinPoints_3_0= ruleOperationJoinPointType )
            // InternalOperationDsl.g:4971:5: lv_joinPoints_3_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_95);
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

            // InternalOperationDsl.g:4988:3: (otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==23) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalOperationDsl.g:4989:4: otherlv_4= ',' ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_97); 

            	    				newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:4993:4: ( (lv_joinPoints_5_0= ruleOperationJoinPointType ) )
            	    // InternalOperationDsl.g:4994:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    {
            	    // InternalOperationDsl.g:4994:5: (lv_joinPoints_5_0= ruleOperationJoinPointType )
            	    // InternalOperationDsl.g:4995:6: lv_joinPoints_5_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_95);
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
            	    break loop110;
                }
            } while (true);

            // InternalOperationDsl.g:5013:3: ( (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' ) | otherlv_9= ';' )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==24) ) {
                alt112=1;
            }
            else if ( (LA112_0==37) ) {
                alt112=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalOperationDsl.g:5014:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    {
                    // InternalOperationDsl.g:5014:4: (otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}' )
                    // InternalOperationDsl.g:5015:5: otherlv_6= '{' ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_88); 

                    					newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0());
                    				
                    // InternalOperationDsl.g:5019:5: ( (lv_properties_7_0= ruleTechnologySpecificProperty ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( ((LA111_0>=78 && LA111_0<=87)) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5020:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5020:6: (lv_properties_7_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5021:7: lv_properties_7_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_88);
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
                    	    break loop111;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5044:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOperationDsl.g:5053:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalOperationDsl.g:5053:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalOperationDsl.g:5054:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalOperationDsl.g:5060:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:5066:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:5067:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:5067:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:5068:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_98); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,74,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:5080:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:5081:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:5081:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:5082:5: lv_importURI_3_0= RULE_STRING
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

            otherlv_4=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:5102:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:5103:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:5103:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:5104:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:5124:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalOperationDsl.g:5124:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalOperationDsl.g:5125:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalOperationDsl.g:5131:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalOperationDsl.g:5137:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalOperationDsl.g:5138:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalOperationDsl.g:5138:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalOperationDsl.g:5139:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalOperationDsl.g:5143:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5144:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5144:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5145:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,24,FOLLOW_99); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:5165:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt115=3;
            int LA115_0 = input.LA(1);

            if ( ((LA115_0>=61 && LA115_0<=62)) ) {
                alt115=1;
            }
            else if ( (LA115_0==75) ) {
                alt115=2;
            }
            switch (alt115) {
                case 1 :
                    // InternalOperationDsl.g:5166:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalOperationDsl.g:5166:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt113=0;
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( ((LA113_0>=61 && LA113_0<=62)) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5167:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalOperationDsl.g:5167:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalOperationDsl.g:5168:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_100);
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
                    	    if ( cnt113 >= 1 ) break loop113;
                                EarlyExitException eee =
                                    new EarlyExitException(113, input);
                                throw eee;
                        }
                        cnt113++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5186:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalOperationDsl.g:5186:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt114=0;
                    loop114:
                    do {
                        int alt114=2;
                        int LA114_0 = input.LA(1);

                        if ( (LA114_0==75) ) {
                            alt114=1;
                        }


                        switch (alt114) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5187:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalOperationDsl.g:5187:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalOperationDsl.g:5188:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_101);
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
                    	    if ( cnt114 >= 1 ) break loop114;
                                EarlyExitException eee =
                                    new EarlyExitException(114, input);
                                throw eee;
                        }
                        cnt114++;
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
    // InternalOperationDsl.g:5214:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalOperationDsl.g:5214:48: (iv_ruleContext= ruleContext EOF )
            // InternalOperationDsl.g:5215:2: iv_ruleContext= ruleContext EOF
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
    // InternalOperationDsl.g:5221:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:5227:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalOperationDsl.g:5228:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalOperationDsl.g:5228:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalOperationDsl.g:5229:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalOperationDsl.g:5233:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5234:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5234:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5235:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,24,FOLLOW_102); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:5255:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt116=0;
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( ((LA116_0>=61 && LA116_0<=62)) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalOperationDsl.g:5256:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalOperationDsl.g:5256:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalOperationDsl.g:5257:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_100);
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
            	    if ( cnt116 >= 1 ) break loop116;
                        EarlyExitException eee =
                            new EarlyExitException(116, input);
                        throw eee;
                }
                cnt116++;
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
    // InternalOperationDsl.g:5282:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalOperationDsl.g:5282:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalOperationDsl.g:5283:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalOperationDsl.g:5289:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:5295:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType ) )
            // InternalOperationDsl.g:5296:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType )
            {
            // InternalOperationDsl.g:5296:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==62) ) {
                alt117=1;
            }
            else if ( (LA117_0==61) ) {
                alt117=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // InternalOperationDsl.g:5297:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalOperationDsl.g:5306:3: this_ListType_1= ruleListType
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
    // InternalOperationDsl.g:5318:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalOperationDsl.g:5318:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalOperationDsl.g:5319:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalOperationDsl.g:5325:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) ;
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
            // InternalOperationDsl.g:5331:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' ) )
            // InternalOperationDsl.g:5332:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            {
            // InternalOperationDsl.g:5332:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}' )
            // InternalOperationDsl.g:5333:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalOperationDsl.g:5337:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5338:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5338:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5339:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_103); 

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

            // InternalOperationDsl.g:5355:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==76) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalOperationDsl.g:5356:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalOperationDsl.g:5360:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:5361:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:5361:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:5362:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,24,FOLLOW_104); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:5381:3: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==RULE_ID||(LA120_0>=77 && LA120_0<=87)) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalOperationDsl.g:5382:4: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalOperationDsl.g:5382:4: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalOperationDsl.g:5383:5: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalOperationDsl.g:5383:5: (lv_dataFields_5_0= ruleDataField )
                    // InternalOperationDsl.g:5384:6: lv_dataFields_5_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_52);
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

                    // InternalOperationDsl.g:5401:4: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==23) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5402:5: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_105); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalOperationDsl.g:5406:5: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalOperationDsl.g:5407:6: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalOperationDsl.g:5407:6: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalOperationDsl.g:5408:7: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_52);
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
                    	    break loop119;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOperationDsl.g:5435:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalOperationDsl.g:5435:49: (iv_ruleListType= ruleListType EOF )
            // InternalOperationDsl.g:5436:2: iv_ruleListType= ruleListType EOF
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
    // InternalOperationDsl.g:5442:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalOperationDsl.g:5448:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalOperationDsl.g:5449:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalOperationDsl.g:5449:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt122=2;
            alt122 = dfa122.predict(input);
            switch (alt122) {
                case 1 :
                    // InternalOperationDsl.g:5450:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalOperationDsl.g:5450:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalOperationDsl.g:5451:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,61,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalOperationDsl.g:5455:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalOperationDsl.g:5456:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5456:5: (lv_name_1_0= RULE_ID )
                    // InternalOperationDsl.g:5457:6: lv_name_1_0= RULE_ID
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

                    otherlv_2=(Token)match(input,24,FOLLOW_105); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalOperationDsl.g:5477:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalOperationDsl.g:5478:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalOperationDsl.g:5478:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalOperationDsl.g:5479:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_52);
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

                    // InternalOperationDsl.g:5496:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( (LA121_0==23) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5497:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_105); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalOperationDsl.g:5501:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalOperationDsl.g:5502:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalOperationDsl.g:5502:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalOperationDsl.g:5503:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_52);
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
                    	    break loop121;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5527:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalOperationDsl.g:5527:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalOperationDsl.g:5528:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,61,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalOperationDsl.g:5532:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalOperationDsl.g:5533:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5533:5: (lv_name_8_0= RULE_ID )
                    // InternalOperationDsl.g:5534:6: lv_name_8_0= RULE_ID
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

                    otherlv_9=(Token)match(input,24,FOLLOW_83); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalOperationDsl.g:5554:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:5555:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:5555:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalOperationDsl.g:5556:6: lv_primitiveType_10_0= rulePrimitiveType
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
                    							"de.fhdo.ddmm.data.DataDsl.PrimitiveType");
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
    // InternalOperationDsl.g:5582:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalOperationDsl.g:5582:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalOperationDsl.g:5583:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalOperationDsl.g:5589:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:5595:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:5596:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:5596:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalOperationDsl.g:5597:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:5597:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==77) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalOperationDsl.g:5598:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:5598:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:5599:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,77,FOLLOW_71); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:5611:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt124=3;
            int LA124_0 = input.LA(1);

            if ( ((LA124_0>=78 && LA124_0<=87)) ) {
                alt124=1;
            }
            else if ( (LA124_0==RULE_ID) ) {
                int LA124_2 = input.LA(2);

                if ( (LA124_2==RULE_ID||LA124_2==31||LA124_2==53) ) {
                    alt124=2;
                }
            }
            switch (alt124) {
                case 1 :
                    // InternalOperationDsl.g:5612:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:5612:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:5613:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:5613:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalOperationDsl.g:5614:6: lv_primitiveType_1_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:5632:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:5632:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalOperationDsl.g:5633:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalOperationDsl.g:5633:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalOperationDsl.g:5634:6: lv_complexType_2_0= rulePossiblyImportedComplexType
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

            // InternalOperationDsl.g:5652:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOperationDsl.g:5653:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOperationDsl.g:5653:4: (lv_name_3_0= RULE_ID )
            // InternalOperationDsl.g:5654:5: lv_name_3_0= RULE_ID
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
    // InternalOperationDsl.g:5674:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalOperationDsl.g:5674:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalOperationDsl.g:5675:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
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
    // InternalOperationDsl.g:5681:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5687:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:5688:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:5688:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:5689:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:5689:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_ID) ) {
                int LA125_1 = input.LA(2);

                if ( (LA125_1==31) ) {
                    alt125=1;
                }
            }
            switch (alt125) {
                case 1 :
                    // InternalOperationDsl.g:5690:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:5690:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:5691:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5691:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:5692:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:5708:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:5709:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:5709:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:5710:5: ruleQualifiedName
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
    // InternalOperationDsl.g:5728:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalOperationDsl.g:5728:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalOperationDsl.g:5729:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalOperationDsl.g:5735:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalOperationDsl.g:5741:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalOperationDsl.g:5742:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalOperationDsl.g:5742:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt126=10;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt126=1;
                }
                break;
            case 79:
                {
                alt126=2;
                }
                break;
            case 80:
                {
                alt126=3;
                }
                break;
            case 81:
                {
                alt126=4;
                }
                break;
            case 82:
                {
                alt126=5;
                }
                break;
            case 83:
                {
                alt126=6;
                }
                break;
            case 84:
                {
                alt126=7;
                }
                break;
            case 85:
                {
                alt126=8;
                }
                break;
            case 86:
                {
                alt126=9;
                }
                break;
            case 87:
                {
                alt126=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // InternalOperationDsl.g:5743:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalOperationDsl.g:5743:3: ( () otherlv_1= 'boolean' )
                    // InternalOperationDsl.g:5744:4: () otherlv_1= 'boolean'
                    {
                    // InternalOperationDsl.g:5744:4: ()
                    // InternalOperationDsl.g:5745:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,78,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5757:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalOperationDsl.g:5757:3: ( () otherlv_3= 'byte' )
                    // InternalOperationDsl.g:5758:4: () otherlv_3= 'byte'
                    {
                    // InternalOperationDsl.g:5758:4: ()
                    // InternalOperationDsl.g:5759:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,79,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:5771:3: ( () otherlv_5= 'char' )
                    {
                    // InternalOperationDsl.g:5771:3: ( () otherlv_5= 'char' )
                    // InternalOperationDsl.g:5772:4: () otherlv_5= 'char'
                    {
                    // InternalOperationDsl.g:5772:4: ()
                    // InternalOperationDsl.g:5773:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,80,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:5785:3: ( () otherlv_7= 'date' )
                    {
                    // InternalOperationDsl.g:5785:3: ( () otherlv_7= 'date' )
                    // InternalOperationDsl.g:5786:4: () otherlv_7= 'date'
                    {
                    // InternalOperationDsl.g:5786:4: ()
                    // InternalOperationDsl.g:5787:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,81,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:5799:3: ( () otherlv_9= 'double' )
                    {
                    // InternalOperationDsl.g:5799:3: ( () otherlv_9= 'double' )
                    // InternalOperationDsl.g:5800:4: () otherlv_9= 'double'
                    {
                    // InternalOperationDsl.g:5800:4: ()
                    // InternalOperationDsl.g:5801:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,82,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:5813:3: ( () otherlv_11= 'float' )
                    {
                    // InternalOperationDsl.g:5813:3: ( () otherlv_11= 'float' )
                    // InternalOperationDsl.g:5814:4: () otherlv_11= 'float'
                    {
                    // InternalOperationDsl.g:5814:4: ()
                    // InternalOperationDsl.g:5815:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,83,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:5827:3: ( () otherlv_13= 'int' )
                    {
                    // InternalOperationDsl.g:5827:3: ( () otherlv_13= 'int' )
                    // InternalOperationDsl.g:5828:4: () otherlv_13= 'int'
                    {
                    // InternalOperationDsl.g:5828:4: ()
                    // InternalOperationDsl.g:5829:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,84,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:5841:3: ( () otherlv_15= 'long' )
                    {
                    // InternalOperationDsl.g:5841:3: ( () otherlv_15= 'long' )
                    // InternalOperationDsl.g:5842:4: () otherlv_15= 'long'
                    {
                    // InternalOperationDsl.g:5842:4: ()
                    // InternalOperationDsl.g:5843:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,85,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:5855:3: ( () otherlv_17= 'short' )
                    {
                    // InternalOperationDsl.g:5855:3: ( () otherlv_17= 'short' )
                    // InternalOperationDsl.g:5856:4: () otherlv_17= 'short'
                    {
                    // InternalOperationDsl.g:5856:4: ()
                    // InternalOperationDsl.g:5857:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,86,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:5869:3: ( () otherlv_19= 'string' )
                    {
                    // InternalOperationDsl.g:5869:3: ( () otherlv_19= 'string' )
                    // InternalOperationDsl.g:5870:4: () otherlv_19= 'string'
                    {
                    // InternalOperationDsl.g:5870:4: ()
                    // InternalOperationDsl.g:5871:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,87,FOLLOW_2); 

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
    // InternalOperationDsl.g:5886:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOperationDsl.g:5886:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOperationDsl.g:5887:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalOperationDsl.g:5893:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5899:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOperationDsl.g:5900:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOperationDsl.g:5900:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOperationDsl.g:5901:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_106); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOperationDsl.g:5908:3: (kw= '.' this_ID_2= RULE_ID )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==53) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // InternalOperationDsl.g:5909:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,53,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_106); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop127;
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
    // InternalOperationDsl.g:5926:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5932:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) ) )
            // InternalOperationDsl.g:5933:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            {
            // InternalOperationDsl.g:5933:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==14) ) {
                alt128=1;
            }
            else if ( (LA128_0==45) ) {
                alt128=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // InternalOperationDsl.g:5934:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalOperationDsl.g:5934:3: (enumLiteral_0= 'technology' )
                    // InternalOperationDsl.g:5935:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,14,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5942:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalOperationDsl.g:5942:3: (enumLiteral_1= 'microservices' )
                    // InternalOperationDsl.g:5943:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

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
    // InternalOperationDsl.g:5953:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5959:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalOperationDsl.g:5960:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalOperationDsl.g:5960:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt129=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt129=1;
                }
                break;
            case 89:
                {
                alt129=2;
                }
                break;
            case 90:
                {
                alt129=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }

            switch (alt129) {
                case 1 :
                    // InternalOperationDsl.g:5961:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalOperationDsl.g:5961:3: (enumLiteral_0= 'internal' )
                    // InternalOperationDsl.g:5962:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:5969:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalOperationDsl.g:5969:3: (enumLiteral_1= 'architecture' )
                    // InternalOperationDsl.g:5970:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:5977:3: (enumLiteral_2= 'public' )
                    {
                    // InternalOperationDsl.g:5977:3: (enumLiteral_2= 'public' )
                    // InternalOperationDsl.g:5978:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,90,FOLLOW_2); 

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
    // InternalOperationDsl.g:5988:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5994:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalOperationDsl.g:5995:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:5995:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt130=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt130=1;
                }
                break;
            case 92:
                {
                alt130=2;
                }
                break;
            case 93:
                {
                alt130=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // InternalOperationDsl.g:5996:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalOperationDsl.g:5996:3: (enumLiteral_0= 'functional' )
                    // InternalOperationDsl.g:5997:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6004:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalOperationDsl.g:6004:3: (enumLiteral_1= 'utility' )
                    // InternalOperationDsl.g:6005:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:6012:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:6012:3: (enumLiteral_2= 'infrastructure' )
                    // InternalOperationDsl.g:6013:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,93,FOLLOW_2); 

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
    // InternalOperationDsl.g:6023:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6029:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalOperationDsl.g:6030:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalOperationDsl.g:6030:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt131=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt131=1;
                }
                break;
            case 95:
                {
                alt131=2;
                }
                break;
            case 96:
                {
                alt131=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }

            switch (alt131) {
                case 1 :
                    // InternalOperationDsl.g:6031:3: (enumLiteral_0= 'in' )
                    {
                    // InternalOperationDsl.g:6031:3: (enumLiteral_0= 'in' )
                    // InternalOperationDsl.g:6032:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6039:3: (enumLiteral_1= 'out' )
                    {
                    // InternalOperationDsl.g:6039:3: (enumLiteral_1= 'out' )
                    // InternalOperationDsl.g:6040:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:6047:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalOperationDsl.g:6047:3: (enumLiteral_2= 'inout' )
                    // InternalOperationDsl.g:6048:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); 

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
    // InternalOperationDsl.g:6058:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6064:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalOperationDsl.g:6065:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalOperationDsl.g:6065:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==97) ) {
                alt132=1;
            }
            else if ( (LA132_0==98) ) {
                alt132=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // InternalOperationDsl.g:6066:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalOperationDsl.g:6066:3: (enumLiteral_0= 'sync' )
                    // InternalOperationDsl.g:6067:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6074:3: (enumLiteral_1= 'async' )
                    {
                    // InternalOperationDsl.g:6074:3: (enumLiteral_1= 'async' )
                    // InternalOperationDsl.g:6075:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); 

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
    // InternalOperationDsl.g:6085:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6091:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalOperationDsl.g:6092:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalOperationDsl.g:6092:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt133=3;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt133=1;
                }
                break;
            case 100:
                {
                alt133=2;
                }
                break;
            case 101:
                {
                alt133=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalOperationDsl.g:6093:3: (enumLiteral_0= '<-' )
                    {
                    // InternalOperationDsl.g:6093:3: (enumLiteral_0= '<-' )
                    // InternalOperationDsl.g:6094:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6101:3: (enumLiteral_1= '->' )
                    {
                    // InternalOperationDsl.g:6101:3: (enumLiteral_1= '->' )
                    // InternalOperationDsl.g:6102:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:6109:3: (enumLiteral_2= '<->' )
                    {
                    // InternalOperationDsl.g:6109:3: (enumLiteral_2= '<->' )
                    // InternalOperationDsl.g:6110:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,101,FOLLOW_2); 

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
    // InternalOperationDsl.g:6120:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) ) ;
    public final Enumerator ruleServiceJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6126:2: ( ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) ) )
            // InternalOperationDsl.g:6127:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) )
            {
            // InternalOperationDsl.g:6127:2: ( (enumLiteral_0= 'microservices' ) | (enumLiteral_1= 'interfaces' ) | (enumLiteral_2= 'operations' ) | (enumLiteral_3= 'parameters' ) | (enumLiteral_4= 'fields' ) )
            int alt134=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt134=1;
                }
                break;
            case 46:
                {
                alt134=2;
                }
                break;
            case 47:
                {
                alt134=3;
                }
                break;
            case 102:
                {
                alt134=4;
                }
                break;
            case 103:
                {
                alt134=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // InternalOperationDsl.g:6128:3: (enumLiteral_0= 'microservices' )
                    {
                    // InternalOperationDsl.g:6128:3: (enumLiteral_0= 'microservices' )
                    // InternalOperationDsl.g:6129:4: enumLiteral_0= 'microservices'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6136:3: (enumLiteral_1= 'interfaces' )
                    {
                    // InternalOperationDsl.g:6136:3: (enumLiteral_1= 'interfaces' )
                    // InternalOperationDsl.g:6137:4: enumLiteral_1= 'interfaces'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:6144:3: (enumLiteral_2= 'operations' )
                    {
                    // InternalOperationDsl.g:6144:3: (enumLiteral_2= 'operations' )
                    // InternalOperationDsl.g:6145:4: enumLiteral_2= 'operations'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:6152:3: (enumLiteral_3= 'parameters' )
                    {
                    // InternalOperationDsl.g:6152:3: (enumLiteral_3= 'parameters' )
                    // InternalOperationDsl.g:6153:4: enumLiteral_3= 'parameters'
                    {
                    enumLiteral_3=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:6160:3: (enumLiteral_4= 'fields' )
                    {
                    // InternalOperationDsl.g:6160:3: (enumLiteral_4= 'fields' )
                    // InternalOperationDsl.g:6161:4: enumLiteral_4= 'fields'
                    {
                    enumLiteral_4=(Token)match(input,103,FOLLOW_2); 

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
    // InternalOperationDsl.g:6171:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6177:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalOperationDsl.g:6178:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:6178:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==104) ) {
                alt135=1;
            }
            else if ( (LA135_0==93) ) {
                alt135=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }
            switch (alt135) {
                case 1 :
                    // InternalOperationDsl.g:6179:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalOperationDsl.g:6179:3: (enumLiteral_0= 'containers' )
                    // InternalOperationDsl.g:6180:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6187:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:6187:3: (enumLiteral_1= 'infrastructure' )
                    // InternalOperationDsl.g:6188:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); 

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
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA122 dfa122 = new DFA122(this);
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
    static final String dfa_8s = "\11\uffff";
    static final String dfa_9s = "\1\4\1\46\1\uffff\1\5\3\4\2\uffff";
    static final String dfa_10s = "\1\35\1\46\1\uffff\1\7\3\35\2\uffff";
    static final String dfa_11s = "\2\uffff\1\2\4\uffff\1\3\1\1";
    static final String dfa_12s = "\11\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\30\uffff\1\2",
            "\1\3",
            "",
            "\1\6\1\4\1\5",
            "\1\1\25\uffff\1\10\2\uffff\1\7",
            "\1\1\25\uffff\1\10\2\uffff\1\7",
            "\1\1\25\uffff\1\10\2\uffff\1\7",
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
    static final String dfa_14s = "\111\uffff";
    static final String dfa_15s = "\2\4\2\uffff\1\37\3\17\4\4\2\37\6\4\3\20\1\46\1\20\1\27\1\4\1\5\6\4\1\5\5\20\1\4\2\27\1\37\1\27\1\4\2\17\1\4\1\5\1\4\1\46\1\4\2\27\1\4\1\5\1\37\2\4\3\20\1\4\2\27\1\20\3\4\2\20\1\4";
    static final String dfa_16s = "\1\132\1\142\2\uffff\1\37\3\17\3\4\1\132\2\37\1\4\1\7\3\4\1\132\3\20\1\46\2\65\1\132\1\7\2\4\1\132\3\4\1\5\3\27\1\65\1\20\1\142\1\65\1\44\1\37\1\45\1\4\2\17\1\4\1\5\1\20\1\46\1\4\1\65\1\45\1\132\1\7\1\37\2\4\3\27\1\4\1\65\1\44\1\65\2\4\1\132\1\65\1\20\1\36";
    static final String dfa_17s = "\2\uffff\1\2\1\1\105\uffff";
    static final String dfa_18s = "\111\uffff}>";
    static final String[] dfa_19s = {
            "\1\2\10\uffff\1\1\14\uffff\1\2\25\uffff\1\2\1\uffff\1\3\45\uffff\3\2",
            "\1\4\31\uffff\1\7\102\uffff\1\5\1\6",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\2\10\uffff\1\20\1\uffff\1\17\40\uffff\1\2\1\uffff\1\3\2\uffff\1\16\42\uffff\3\2",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\27\1\26\1\24\1\25",
            "\1\4",
            "\1\30",
            "\1\31",
            "\1\2\10\uffff\1\20\1\uffff\1\17\40\uffff\1\2\1\uffff\1\3\2\uffff\1\16\42\uffff\3\2",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\33",
            "\1\36\22\uffff\1\35\21\uffff\1\34",
            "\1\41\13\uffff\1\40\1\42\20\uffff\1\37",
            "\1\2\10\uffff\1\20\42\uffff\1\2\1\uffff\1\3\45\uffff\3\2",
            "\1\45\1\43\1\44",
            "\1\46",
            "\1\47",
            "\1\2\10\uffff\1\50\42\uffff\1\2\1\uffff\1\3\45\uffff\3\2",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\32\6\uffff\1\55",
            "\1\32\6\uffff\1\55",
            "\1\32\6\uffff\1\55",
            "\1\36\22\uffff\1\35\21\uffff\1\34",
            "\1\36",
            "\1\4\31\uffff\1\7\102\uffff\1\56\1\57",
            "\1\41\13\uffff\1\40\1\42\20\uffff\1\37",
            "\1\41\14\uffff\1\42",
            "\1\60",
            "\1\61\15\uffff\1\62",
            "\1\63",
            "\1\64",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\15\13\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\41\13\uffff\1\73\1\42\20\uffff\1\72",
            "\1\61\15\uffff\1\62",
            "\1\2\10\uffff\1\20\42\uffff\1\2\1\uffff\1\3\45\uffff\3\2",
            "\1\76\1\74\1\75",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\32\6\uffff\1\55",
            "\1\32\6\uffff\1\55",
            "\1\32\6\uffff\1\55",
            "\1\102",
            "\1\41\13\uffff\1\73\1\42\20\uffff\1\72",
            "\1\41\14\uffff\1\42",
            "\1\105\22\uffff\1\104\21\uffff\1\103",
            "\1\106",
            "\1\107",
            "\1\2\10\uffff\1\110\42\uffff\1\2\1\uffff\1\3\45\uffff\3\2",
            "\1\105\22\uffff\1\104\21\uffff\1\103",
            "\1\105",
            "\1\4\31\uffff\1\7"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 2394:3: ( (lv_referredOperations_13_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_20s = "\20\uffff";
    static final String dfa_21s = "\1\75\1\4\1\30\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_22s = "\1\75\1\4\1\30\1\127\1\uffff\12\32\1\uffff";
    static final String dfa_23s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_24s = "\20\uffff}>";
    static final String[] dfa_25s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\110\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
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

    class DFA122 extends DFA {

        public DFA122(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 122;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "5449:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000008000002002L});
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
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000000004E000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000004C000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000044000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000800000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000800000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000024000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000200000004000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000002000L,0x000000003F000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000080001000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0003100000002000L,0x0000000007000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0003100004002000L,0x0000000007000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0003000000002000L,0x0000000007000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0002000000000000L,0x0000000007000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0005000004002010L,0x0000000007000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0001000004002010L,0x0000000007000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0001000000002010L,0x0000000007000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000010L,0x0000000007000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000812000L,0x0000000600000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000002000L,0x0000000600000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0004000000002000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0008000000000010L,0x00000001C0000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0008000000000010L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0010001000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000010L,0x0000000000FFC000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000002008800000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0800002000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000FFC000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000800000L,0x0000003800000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000004000000L,0x0000000000FFC000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000006000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x00000001C0000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000078L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000E00000000000L,0x000000C000000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000002001800000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000004000000L,0x0000000000FFC080L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000010020000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x6000000004000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x6000000004000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000001000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000004000010L,0x0000000000FFE000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000010L,0x0000000000FFE000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0020000000000002L});

}