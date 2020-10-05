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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BOOLEAN", "RULE_BIG_DECIMAL", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'@'", "'technology'", "'('", "')'", "'container'", "'deployment'", "'with'", "'operation'", "'environment'", "'deploys'", "','", "'depends'", "'on'", "'nodes'", "'used'", "'by'", "'{'", "'aspects'", "'}'", "'default'", "'values'", "'basic'", "'endpoints'", "'::'", "'is'", "'services'", "'/'", "':'", "';'", "'='", "'import'", "'from'", "'as'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'typedef'", "'noimpl'", "'interface'", "'---'", "'@param'", "'@required'", "'refers'", "'fault'", "'?'", "'.'", "'<'", "'>'", "'-'", "'--'", "'types'", "'compatibility'", "'matrix'", "'protocols'", "'service'", "'technologies'", "'infrastructure'", "'data'", "'formats'", "'format'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'primitive'", "'type'", "'based'", "'list'", "'structure'", "'->'", "'<-'", "'<->'", "'environments'", "'properties'", "'mandatory'", "'singleval'", "'parameters'", "'fields'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'aspect'", "'for'", "'containers'", "'selector'", "'datatypes'", "'context'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'extends'", "'identifier'", "'neverEmpty'", "'part'", "'hide'", "'immutable'", "'enum'", "'closure'", "'sideEffectFree'", "'validator'", "'function'", "'procedure'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'param'", "'functional'", "'utility'", "'unspecified'", "'domainOperations'", "'domainParameters'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
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
    public static final int T__139=139;
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
    // InternalOperationDsl.g:148:1: ruleContainer returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' ) ;
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
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
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
        Token otherlv_46=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        EObject lv_deploymentTechnology_9_0 = null;

        EObject lv_deployedServices_15_0 = null;

        EObject lv_deployedServices_17_0 = null;

        EObject lv_dependsOnNodes_21_0 = null;

        EObject lv_dependsOnNodes_23_0 = null;

        EObject lv_usedByNodes_27_0 = null;

        EObject lv_usedByNodes_29_0 = null;

        EObject lv_aspects_33_0 = null;

        EObject lv_defaultServicePropertyValues_38_0 = null;

        EObject lv_defaultBasicEndpoints_42_0 = null;

        EObject lv_defaultServicePropertyValues_44_0 = null;

        EObject lv_defaultBasicEndpoints_48_0 = null;

        EObject lv_deploymentSpecifications_51_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:154:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' ) )
            // InternalOperationDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' )
            {
            // InternalOperationDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' )
            // InternalOperationDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}'
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

            // InternalOperationDsl.g:311:3: (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOperationDsl.g:312:4: otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_18=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_18, grammarAccess.getContainerAccess().getDependsKeyword_10_0());
                    			
                    otherlv_19=(Token)match(input,25,FOLLOW_18); 

                    				newLeafNode(otherlv_19, grammarAccess.getContainerAccess().getOnKeyword_10_1());
                    			
                    otherlv_20=(Token)match(input,26,FOLLOW_7); 

                    				newLeafNode(otherlv_20, grammarAccess.getContainerAccess().getNodesKeyword_10_2());
                    			
                    // InternalOperationDsl.g:324:4: ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) )
                    // InternalOperationDsl.g:325:5: (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode )
                    {
                    // InternalOperationDsl.g:325:5: (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode )
                    // InternalOperationDsl.g:326:6: lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode
                    {

                    						newCompositeNode(grammarAccess.getContainerAccess().getDependsOnNodesPossiblyImportedOperationNodeParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_dependsOnNodes_21_0=rulePossiblyImportedOperationNode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContainerRule());
                    						}
                    						add(
                    							current,
                    							"dependsOnNodes",
                    							lv_dependsOnNodes_21_0,
                    							"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOperationDsl.g:343:4: (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==23) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalOperationDsl.g:344:5: otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_22=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getContainerAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalOperationDsl.g:348:5: ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) )
                    	    // InternalOperationDsl.g:349:6: (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:349:6: (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:350:7: lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getContainerAccess().getDependsOnNodesPossiblyImportedOperationNodeParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_dependsOnNodes_23_0=rulePossiblyImportedOperationNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContainerRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependsOnNodes",
                    	    								lv_dependsOnNodes_23_0,
                    	    								"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:369:3: (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOperationDsl.g:370:4: otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_24=(Token)match(input,27,FOLLOW_20); 

                    				newLeafNode(otherlv_24, grammarAccess.getContainerAccess().getUsedKeyword_11_0());
                    			
                    otherlv_25=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_25, grammarAccess.getContainerAccess().getByKeyword_11_1());
                    			
                    otherlv_26=(Token)match(input,26,FOLLOW_21); 

                    				newLeafNode(otherlv_26, grammarAccess.getContainerAccess().getNodesKeyword_11_2());
                    			
                    // InternalOperationDsl.g:382:4: ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalOperationDsl.g:383:5: (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:383:5: (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:384:6: lv_usedByNodes_27_0= rulePossiblyImportedOperationNode
                    	    {

                    	    						newCompositeNode(grammarAccess.getContainerAccess().getUsedByNodesPossiblyImportedOperationNodeParserRuleCall_11_3_0());
                    	    					
                    	    pushFollow(FOLLOW_21);
                    	    lv_usedByNodes_27_0=rulePossiblyImportedOperationNode();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContainerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"usedByNodes",
                    	    							lv_usedByNodes_27_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // InternalOperationDsl.g:401:4: (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==23) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalOperationDsl.g:402:5: otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_28=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getContainerAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalOperationDsl.g:406:5: ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    // InternalOperationDsl.g:407:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:407:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:408:7: lv_usedByNodes_29_0= rulePossiblyImportedOperationNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getContainerAccess().getUsedByNodesPossiblyImportedOperationNodeParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_usedByNodes_29_0=rulePossiblyImportedOperationNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContainerRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"usedByNodes",
                    	    								lv_usedByNodes_29_0,
                    	    								"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_30=(Token)match(input,29,FOLLOW_23); 

            			newLeafNode(otherlv_30, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_12());
            		
            // InternalOperationDsl.g:431:3: (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOperationDsl.g:432:4: otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}'
                    {
                    otherlv_31=(Token)match(input,30,FOLLOW_24); 

                    				newLeafNode(otherlv_31, grammarAccess.getContainerAccess().getAspectsKeyword_13_0());
                    			
                    otherlv_32=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_13_1());
                    			
                    // InternalOperationDsl.g:440:4: ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+
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
                    	    // InternalOperationDsl.g:441:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:441:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:442:6: lv_aspects_33_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getContainerAccess().getAspectsImportedOperationAspectParserRuleCall_13_2_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_aspects_33_0=ruleImportedOperationAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContainerRule());
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
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_34=(Token)match(input,31,FOLLOW_26); 

                    				newLeafNode(otherlv_34, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_13_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:464:3: (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOperationDsl.g:465:4: otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}'
                    {
                    otherlv_35=(Token)match(input,32,FOLLOW_27); 

                    				newLeafNode(otherlv_35, grammarAccess.getContainerAccess().getDefaultKeyword_14_0());
                    			
                    otherlv_36=(Token)match(input,33,FOLLOW_24); 

                    				newLeafNode(otherlv_36, grammarAccess.getContainerAccess().getValuesKeyword_14_1());
                    			
                    otherlv_37=(Token)match(input,29,FOLLOW_28); 

                    				newLeafNode(otherlv_37, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_14_2());
                    			
                    // InternalOperationDsl.g:477:4: ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) )
                    int alt18=3;
                    alt18 = dfa18.predict(input);
                    switch (alt18) {
                        case 1 :
                            // InternalOperationDsl.g:478:5: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
                            {
                            // InternalOperationDsl.g:478:5: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
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
                            	    // InternalOperationDsl.g:479:6: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:479:6: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:480:7: lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment
                            	    {

                            	    							newCompositeNode(grammarAccess.getContainerAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_14_3_0_0());
                            	    						
                            	    pushFollow(FOLLOW_25);
                            	    lv_defaultServicePropertyValues_38_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getContainerRule());
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
                            	    if ( cnt14 >= 1 ) break loop14;
                                        EarlyExitException eee =
                                            new EarlyExitException(14, input);
                                        throw eee;
                                }
                                cnt14++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalOperationDsl.g:498:5: (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )
                            {
                            // InternalOperationDsl.g:498:5: (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )
                            // InternalOperationDsl.g:499:6: otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}'
                            {
                            otherlv_39=(Token)match(input,34,FOLLOW_29); 

                            						newLeafNode(otherlv_39, grammarAccess.getContainerAccess().getBasicKeyword_14_3_1_0());
                            					
                            otherlv_40=(Token)match(input,35,FOLLOW_24); 

                            						newLeafNode(otherlv_40, grammarAccess.getContainerAccess().getEndpointsKeyword_14_3_1_1());
                            					
                            otherlv_41=(Token)match(input,29,FOLLOW_7); 

                            						newLeafNode(otherlv_41, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_14_3_1_2());
                            					
                            // InternalOperationDsl.g:511:6: ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+
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
                            	    // InternalOperationDsl.g:512:7: (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint )
                            	    {
                            	    // InternalOperationDsl.g:512:7: (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint )
                            	    // InternalOperationDsl.g:513:8: lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultBasicEndpointsBasicEndpointParserRuleCall_14_3_1_3_0());
                            	    							
                            	    pushFollow(FOLLOW_25);
                            	    lv_defaultBasicEndpoints_42_0=ruleBasicEndpoint();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"defaultBasicEndpoints",
                            	    									lv_defaultBasicEndpoints_42_0,
                            	    									"de.fhdo.lemma.operationdsl.OperationDsl.BasicEndpoint");
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

                            otherlv_43=(Token)match(input,31,FOLLOW_30); 

                            						newLeafNode(otherlv_43, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_14_3_1_4());
                            					

                            }


                            }
                            break;
                        case 3 :
                            // InternalOperationDsl.g:536:5: ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' )
                            {
                            // InternalOperationDsl.g:536:5: ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' )
                            // InternalOperationDsl.g:537:6: ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}'
                            {
                            // InternalOperationDsl.g:537:6: ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+
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
                            	    // InternalOperationDsl.g:538:7: (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:538:7: (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:539:8: lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_14_3_2_0_0());
                            	    							
                            	    pushFollow(FOLLOW_28);
                            	    lv_defaultServicePropertyValues_44_0=rulePropertyValueAssignment();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"defaultServicePropertyValues",
                            	    									lv_defaultServicePropertyValues_44_0,
                            	    									"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
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

                            otherlv_45=(Token)match(input,34,FOLLOW_29); 

                            						newLeafNode(otherlv_45, grammarAccess.getContainerAccess().getBasicKeyword_14_3_2_1());
                            					
                            otherlv_46=(Token)match(input,35,FOLLOW_24); 

                            						newLeafNode(otherlv_46, grammarAccess.getContainerAccess().getEndpointsKeyword_14_3_2_2());
                            					
                            otherlv_47=(Token)match(input,29,FOLLOW_7); 

                            						newLeafNode(otherlv_47, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_14_3_2_3());
                            					
                            // InternalOperationDsl.g:568:6: ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+
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
                            	    // InternalOperationDsl.g:569:7: (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint )
                            	    {
                            	    // InternalOperationDsl.g:569:7: (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint )
                            	    // InternalOperationDsl.g:570:8: lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultBasicEndpointsBasicEndpointParserRuleCall_14_3_2_4_0());
                            	    							
                            	    pushFollow(FOLLOW_25);
                            	    lv_defaultBasicEndpoints_48_0=ruleBasicEndpoint();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getContainerRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"defaultBasicEndpoints",
                            	    									lv_defaultBasicEndpoints_48_0,
                            	    									"de.fhdo.lemma.operationdsl.OperationDsl.BasicEndpoint");
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

                            otherlv_49=(Token)match(input,31,FOLLOW_30); 

                            						newLeafNode(otherlv_49, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_14_3_2_5());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_50=(Token)match(input,31,FOLLOW_25); 

                    				newLeafNode(otherlv_50, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_14_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:598:3: ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOperationDsl.g:599:4: (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:599:4: (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:600:5: lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getContainerAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_15_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_deploymentSpecifications_51_0=ruleServiceDeploymentSpecification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContainerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deploymentSpecifications",
            	    						lv_deploymentSpecifications_51_0,
            	    						"de.fhdo.lemma.operationdsl.OperationDsl.ServiceDeploymentSpecification");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_52=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_52, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_16());
            		

            }


            }


            	leaveRule();

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
    // InternalOperationDsl.g:625:1: entryRuleDeploymentTechnologyReference returns [EObject current=null] : iv_ruleDeploymentTechnologyReference= ruleDeploymentTechnologyReference EOF ;
    public final EObject entryRuleDeploymentTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnologyReference = null;


        try {
            // InternalOperationDsl.g:625:70: (iv_ruleDeploymentTechnologyReference= ruleDeploymentTechnologyReference EOF )
            // InternalOperationDsl.g:626:2: iv_ruleDeploymentTechnologyReference= ruleDeploymentTechnologyReference EOF
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
    // InternalOperationDsl.g:632:1: ruleDeploymentTechnologyReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDeploymentTechnologyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:638:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:639:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:639:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:640:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:640:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:641:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:641:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:642:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeploymentTechnologyReferenceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getDeploymentTechnologyReferenceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyReferenceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:657:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:658:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:658:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:659:5: ruleQualifiedName
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
    // InternalOperationDsl.g:677:1: entryRuleInfrastructureNode returns [EObject current=null] : iv_ruleInfrastructureNode= ruleInfrastructureNode EOF ;
    public final EObject entryRuleInfrastructureNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureNode = null;


        try {
            // InternalOperationDsl.g:677:59: (iv_ruleInfrastructureNode= ruleInfrastructureNode EOF )
            // InternalOperationDsl.g:678:2: iv_ruleInfrastructureNode= ruleInfrastructureNode EOF
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
    // InternalOperationDsl.g:684:1: ruleInfrastructureNode returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' ) ;
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
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

        EObject lv_dependsOnNodes_15_0 = null;

        EObject lv_dependsOnNodes_17_0 = null;

        EObject lv_deployedServices_21_0 = null;

        EObject lv_deployedServices_23_0 = null;

        EObject lv_usedByNodes_27_0 = null;

        EObject lv_usedByNodes_29_0 = null;

        EObject lv_aspects_33_0 = null;

        EObject lv_defaultServicePropertyValues_38_0 = null;

        EObject lv_endpoints_42_0 = null;

        EObject lv_deploymentSpecifications_44_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:690:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' ) )
            // InternalOperationDsl.g:691:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' )
            {
            // InternalOperationDsl.g:691:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' )
            // InternalOperationDsl.g:692:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}'
            {
            // InternalOperationDsl.g:692:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==13) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalOperationDsl.g:693:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getInfrastructureNodeAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getInfrastructureNodeAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInfrastructureNodeAccess().getLeftParenthesisKeyword_0_2());
            	    			
            	    // InternalOperationDsl.g:705:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalOperationDsl.g:706:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalOperationDsl.g:706:5: (otherlv_3= RULE_ID )
            	    // InternalOperationDsl.g:707:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getInfrastructureNodeRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_3, grammarAccess.getInfrastructureNodeAccess().getTechnologiesImportCrossReference_0_3_0());
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,16,FOLLOW_32); 

            	    				newLeafNode(otherlv_4, grammarAccess.getInfrastructureNodeAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            // InternalOperationDsl.g:723:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:724:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:724:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:725:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            otherlv_6=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getInfrastructureNodeAccess().getIsKeyword_2());
            		
            // InternalOperationDsl.g:745:3: ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) )
            // InternalOperationDsl.g:746:4: (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference )
            {
            // InternalOperationDsl.g:746:4: (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference )
            // InternalOperationDsl.g:747:5: lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference
            {

            					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getInfrastructureTechnologyInfrastructureTechnologyReferenceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_34);
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

            // InternalOperationDsl.g:764:3: (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOperationDsl.g:765:4: otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_8, grammarAccess.getInfrastructureNodeAccess().getWithKeyword_4_0());
                    			
                    otherlv_9=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureNodeAccess().getOperationKeyword_4_1());
                    			
                    otherlv_10=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureNodeAccess().getEnvironmentKeyword_4_2());
                    			
                    // InternalOperationDsl.g:777:4: ( (otherlv_11= RULE_STRING ) )
                    // InternalOperationDsl.g:778:5: (otherlv_11= RULE_STRING )
                    {
                    // InternalOperationDsl.g:778:5: (otherlv_11= RULE_STRING )
                    // InternalOperationDsl.g:779:6: otherlv_11= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInfrastructureNodeRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_STRING,FOLLOW_35); 

                    						newLeafNode(otherlv_11, grammarAccess.getInfrastructureNodeAccess().getOperationEnvironmentOperationEnvironmentCrossReference_4_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:791:3: (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalOperationDsl.g:792:4: otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_12=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_12, grammarAccess.getInfrastructureNodeAccess().getDependsKeyword_5_0());
                    			
                    otherlv_13=(Token)match(input,25,FOLLOW_18); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureNodeAccess().getOnKeyword_5_1());
                    			
                    otherlv_14=(Token)match(input,26,FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getInfrastructureNodeAccess().getNodesKeyword_5_2());
                    			
                    // InternalOperationDsl.g:804:4: ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) )
                    // InternalOperationDsl.g:805:5: (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode )
                    {
                    // InternalOperationDsl.g:805:5: (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode )
                    // InternalOperationDsl.g:806:6: lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode
                    {

                    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDependsOnNodesPossiblyImportedOperationNodeParserRuleCall_5_3_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_dependsOnNodes_15_0=rulePossiblyImportedOperationNode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    						}
                    						add(
                    							current,
                    							"dependsOnNodes",
                    							lv_dependsOnNodes_15_0,
                    							"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOperationDsl.g:823:4: (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==23) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalOperationDsl.g:824:5: otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_5_4_0());
                    	    				
                    	    // InternalOperationDsl.g:828:5: ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) )
                    	    // InternalOperationDsl.g:829:6: (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:829:6: (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:830:7: lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDependsOnNodesPossiblyImportedOperationNodeParserRuleCall_5_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_dependsOnNodes_17_0=rulePossiblyImportedOperationNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependsOnNodes",
                    	    								lv_dependsOnNodes_17_0,
                    	    								"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:849:3: (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==27) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==28) ) {
                    int LA26_3 = input.LA(3);

                    if ( (LA26_3==38) ) {
                        alt26=1;
                    }
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalOperationDsl.g:850:4: otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )*
                    {
                    otherlv_18=(Token)match(input,27,FOLLOW_20); 

                    				newLeafNode(otherlv_18, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_6_0());
                    			
                    otherlv_19=(Token)match(input,28,FOLLOW_36); 

                    				newLeafNode(otherlv_19, grammarAccess.getInfrastructureNodeAccess().getByKeyword_6_1());
                    			
                    otherlv_20=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_20, grammarAccess.getInfrastructureNodeAccess().getServicesKeyword_6_2());
                    			
                    // InternalOperationDsl.g:862:4: ( (lv_deployedServices_21_0= ruleImportedMicroservice ) )
                    // InternalOperationDsl.g:863:5: (lv_deployedServices_21_0= ruleImportedMicroservice )
                    {
                    // InternalOperationDsl.g:863:5: (lv_deployedServices_21_0= ruleImportedMicroservice )
                    // InternalOperationDsl.g:864:6: lv_deployedServices_21_0= ruleImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeployedServicesImportedMicroserviceParserRuleCall_6_3_0());
                    					
                    pushFollow(FOLLOW_19);
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

                    // InternalOperationDsl.g:881:4: (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==23) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalOperationDsl.g:882:5: otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) )
                    	    {
                    	    otherlv_22=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_6_4_0());
                    	    				
                    	    // InternalOperationDsl.g:886:5: ( (lv_deployedServices_23_0= ruleImportedMicroservice ) )
                    	    // InternalOperationDsl.g:887:6: (lv_deployedServices_23_0= ruleImportedMicroservice )
                    	    {
                    	    // InternalOperationDsl.g:887:6: (lv_deployedServices_23_0= ruleImportedMicroservice )
                    	    // InternalOperationDsl.g:888:7: lv_deployedServices_23_0= ruleImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeployedServicesImportedMicroserviceParserRuleCall_6_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
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
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:907:3: (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalOperationDsl.g:908:4: otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )* (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_24=(Token)match(input,27,FOLLOW_20); 

                    				newLeafNode(otherlv_24, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_7_0());
                    			
                    otherlv_25=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_25, grammarAccess.getInfrastructureNodeAccess().getByKeyword_7_1());
                    			
                    otherlv_26=(Token)match(input,26,FOLLOW_21); 

                    				newLeafNode(otherlv_26, grammarAccess.getInfrastructureNodeAccess().getNodesKeyword_7_2());
                    			
                    // InternalOperationDsl.g:920:4: ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_ID) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalOperationDsl.g:921:5: (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:921:5: (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:922:6: lv_usedByNodes_27_0= rulePossiblyImportedOperationNode
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getUsedByNodesPossiblyImportedOperationNodeParserRuleCall_7_3_0());
                    	    					
                    	    pushFollow(FOLLOW_21);
                    	    lv_usedByNodes_27_0=rulePossiblyImportedOperationNode();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"usedByNodes",
                    	    							lv_usedByNodes_27_0,
                    	    							"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    // InternalOperationDsl.g:939:4: (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==23) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalOperationDsl.g:940:5: otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_28=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_7_4_0());
                    	    				
                    	    // InternalOperationDsl.g:944:5: ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    // InternalOperationDsl.g:945:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:945:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:946:7: lv_usedByNodes_29_0= rulePossiblyImportedOperationNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getUsedByNodesPossiblyImportedOperationNodeParserRuleCall_7_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_usedByNodes_29_0=rulePossiblyImportedOperationNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getInfrastructureNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"usedByNodes",
                    	    								lv_usedByNodes_29_0,
                    	    								"de.fhdo.lemma.operationdsl.OperationDsl.PossiblyImportedOperationNode");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_30=(Token)match(input,29,FOLLOW_37); 

            			newLeafNode(otherlv_30, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalOperationDsl.g:969:3: (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==30) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOperationDsl.g:970:4: otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}'
                    {
                    otherlv_31=(Token)match(input,30,FOLLOW_24); 

                    				newLeafNode(otherlv_31, grammarAccess.getInfrastructureNodeAccess().getAspectsKeyword_9_0());
                    			
                    otherlv_32=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_9_1());
                    			
                    // InternalOperationDsl.g:978:4: ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+
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
                    	    // InternalOperationDsl.g:979:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:979:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:980:6: lv_aspects_33_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getAspectsImportedOperationAspectParserRuleCall_9_2_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
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
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    otherlv_34=(Token)match(input,31,FOLLOW_38); 

                    				newLeafNode(otherlv_34, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1002:3: (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalOperationDsl.g:1003:4: otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}'
                    {
                    otherlv_35=(Token)match(input,32,FOLLOW_27); 

                    				newLeafNode(otherlv_35, grammarAccess.getInfrastructureNodeAccess().getDefaultKeyword_10_0());
                    			
                    otherlv_36=(Token)match(input,33,FOLLOW_24); 

                    				newLeafNode(otherlv_36, grammarAccess.getInfrastructureNodeAccess().getValuesKeyword_10_1());
                    			
                    otherlv_37=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_37, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalOperationDsl.g:1015:4: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
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
                    	    // InternalOperationDsl.g:1016:5: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                    	    {
                    	    // InternalOperationDsl.g:1016:5: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                    	    // InternalOperationDsl.g:1017:6: lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_10_3_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
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
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);

                    otherlv_39=(Token)match(input,31,FOLLOW_39); 

                    				newLeafNode(otherlv_39, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1039:3: (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==35) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOperationDsl.g:1040:4: otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}'
                    {
                    otherlv_40=(Token)match(input,35,FOLLOW_24); 

                    				newLeafNode(otherlv_40, grammarAccess.getInfrastructureNodeAccess().getEndpointsKeyword_11_0());
                    			
                    otherlv_41=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_41, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalOperationDsl.g:1048:4: ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1049:5: (lv_endpoints_42_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1049:5: (lv_endpoints_42_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:1050:6: lv_endpoints_42_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getEndpointsBasicEndpointParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
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
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    otherlv_43=(Token)match(input,31,FOLLOW_25); 

                    				newLeafNode(otherlv_43, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1072:3: ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOperationDsl.g:1073:4: (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:1073:4: (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:1074:5: lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_25);
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
            	    break loop36;
                }
            } while (true);

            otherlv_45=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:1099:1: entryRuleInfrastructureTechnologyReference returns [EObject current=null] : iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF ;
    public final EObject entryRuleInfrastructureTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnologyReference = null;


        try {
            // InternalOperationDsl.g:1099:74: (iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF )
            // InternalOperationDsl.g:1100:2: iv_ruleInfrastructureTechnologyReference= ruleInfrastructureTechnologyReference EOF
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
    // InternalOperationDsl.g:1106:1: ruleInfrastructureTechnologyReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleInfrastructureTechnologyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1112:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:1113:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:1113:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:1114:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:1114:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1115:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1115:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1116:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfrastructureTechnologyReferenceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getInfrastructureTechnologyReferenceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyReferenceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1131:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1132:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1132:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1133:5: ruleQualifiedName
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
    // InternalOperationDsl.g:1151:1: entryRuleProtocolAndDataFormat returns [EObject current=null] : iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF ;
    public final EObject entryRuleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:1151:62: (iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:1152:2: iv_ruleProtocolAndDataFormat= ruleProtocolAndDataFormat EOF
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
    // InternalOperationDsl.g:1158:1: ruleProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1164:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalOperationDsl.g:1165:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalOperationDsl.g:1165:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalOperationDsl.g:1166:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalOperationDsl.g:1166:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1167:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1167:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1168:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getProtocolAndDataFormatAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1183:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1184:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1184:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1185:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getProtocolAndDataFormatAccess().getProtocolProtocolCrossReference_2_0());
            				
            pushFollow(FOLLOW_40);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1199:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==39) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalOperationDsl.g:1200:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalOperationDsl.g:1204:4: ( (otherlv_4= RULE_ID ) )
                    // InternalOperationDsl.g:1205:5: (otherlv_4= RULE_ID )
                    {
                    // InternalOperationDsl.g:1205:5: (otherlv_4= RULE_ID )
                    // InternalOperationDsl.g:1206:6: otherlv_4= RULE_ID
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
    // InternalOperationDsl.g:1222:1: entryRuleBasicEndpoint returns [EObject current=null] : iv_ruleBasicEndpoint= ruleBasicEndpoint EOF ;
    public final EObject entryRuleBasicEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicEndpoint = null;


        try {
            // InternalOperationDsl.g:1222:54: (iv_ruleBasicEndpoint= ruleBasicEndpoint EOF )
            // InternalOperationDsl.g:1223:2: iv_ruleBasicEndpoint= ruleBasicEndpoint EOF
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
    // InternalOperationDsl.g:1229:1: ruleBasicEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:1235:2: ( ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:1236:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:1236:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:1237:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:1237:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) )
            // InternalOperationDsl.g:1238:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:1238:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            // InternalOperationDsl.g:1239:5: lv_protocols_0_0= ruleProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalOperationDsl.g:1256:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==23) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOperationDsl.g:1257:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getBasicEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:1261:4: ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:1262:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:1262:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    // InternalOperationDsl.g:1263:6: lv_protocols_2_0= ruleProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
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
            	    break loop38;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getBasicEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:1285:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:1286:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1286:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:1287:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            					newLeafNode(lv_addresses_4_0, grammarAccess.getBasicEndpointAccess().getAddressesSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBasicEndpointRule());
            					}
            					addWithLastConsumed(
            						current,
            						"addresses",
            						lv_addresses_4_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            // InternalOperationDsl.g:1303:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==23) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalOperationDsl.g:1304:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getBasicEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:1308:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:1309:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:1309:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:1310:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            	    						newLeafNode(lv_addresses_6_0, grammarAccess.getBasicEndpointAccess().getAddressesSTRINGTerminalRuleCall_4_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBasicEndpointRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"addresses",
            	    							lv_addresses_6_0,
            	    							"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalOperationDsl.g:1335:1: entryRuleServiceDeploymentSpecification returns [EObject current=null] : iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF ;
    public final EObject entryRuleServiceDeploymentSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceDeploymentSpecification = null;


        try {
            // InternalOperationDsl.g:1335:71: (iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF )
            // InternalOperationDsl.g:1336:2: iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF
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
    // InternalOperationDsl.g:1342:1: ruleServiceDeploymentSpecification returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) ;
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
            // InternalOperationDsl.g:1348:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) )
            // InternalOperationDsl.g:1349:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            {
            // InternalOperationDsl.g:1349:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            // InternalOperationDsl.g:1350:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}'
            {
            // InternalOperationDsl.g:1350:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1351:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1351:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1352:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceDeploymentSpecificationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getServiceDeploymentSpecificationAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceDeploymentSpecificationAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1367:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1368:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1368:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1369:5: ruleQualifiedNameWithAtLeastOneLevel
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceDeploymentSpecificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServiceImportedMicroserviceCrossReference_2_0());
            				
            pushFollow(FOLLOW_24);
            ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_43); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:1387:3: ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalOperationDsl.g:1388:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    {
            	    // InternalOperationDsl.g:1388:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    // InternalOperationDsl.g:1389:5: lv_servicePropertyValues_4_0= rulePropertyValueAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServicePropertyValuesPropertyValueAssignmentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_43);
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
            	    break loop40;
                }
            } while (true);

            // InternalOperationDsl.g:1406:3: (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalOperationDsl.g:1407:4: otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_5, grammarAccess.getServiceDeploymentSpecificationAccess().getBasicKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,35,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceDeploymentSpecificationAccess().getEndpointsKeyword_5_1());
                    			
                    otherlv_7=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_5_2());
                    			
                    // InternalOperationDsl.g:1419:4: ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1420:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1420:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:1421:6: lv_basicEndpoints_8_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getBasicEndpointsBasicEndpointParserRuleCall_5_3_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
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
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_9=(Token)match(input,31,FOLLOW_30); 

                    				newLeafNode(otherlv_9, grammarAccess.getServiceDeploymentSpecificationAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:1451:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:1451:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalOperationDsl.g:1452:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalOperationDsl.g:1458:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1464:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalOperationDsl.g:1465:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalOperationDsl.g:1465:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalOperationDsl.g:1466:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalOperationDsl.g:1466:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1467:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1467:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1468:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1483:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1484:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1484:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1485:5: ruleQualifiedNameWithAtLeastOneLevel
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


    // $ANTLR start "entryRulePossiblyImportedOperationNode"
    // InternalOperationDsl.g:1503:1: entryRulePossiblyImportedOperationNode returns [EObject current=null] : iv_rulePossiblyImportedOperationNode= rulePossiblyImportedOperationNode EOF ;
    public final EObject entryRulePossiblyImportedOperationNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperationNode = null;


        try {
            // InternalOperationDsl.g:1503:70: (iv_rulePossiblyImportedOperationNode= rulePossiblyImportedOperationNode EOF )
            // InternalOperationDsl.g:1504:2: iv_rulePossiblyImportedOperationNode= rulePossiblyImportedOperationNode EOF
            {
             newCompositeNode(grammarAccess.getPossiblyImportedOperationNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePossiblyImportedOperationNode=rulePossiblyImportedOperationNode();

            state._fsp--;

             current =iv_rulePossiblyImportedOperationNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePossiblyImportedOperationNode"


    // $ANTLR start "rulePossiblyImportedOperationNode"
    // InternalOperationDsl.g:1510:1: rulePossiblyImportedOperationNode returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperationNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1516:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:1517:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:1517:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:1518:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:1518:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==36) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalOperationDsl.g:1519:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:1519:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:1520:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1520:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:1521:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationNodeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationNodeAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationNodeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1537:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1538:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1538:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1539:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPossiblyImportedOperationNodeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPossiblyImportedOperationNodeAccess().getNodeOperationNodeCrossReference_1_0());
            				
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
    // $ANTLR end "rulePossiblyImportedOperationNode"


    // $ANTLR start "entryRulePropertyValueAssignment"
    // InternalOperationDsl.g:1557:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalOperationDsl.g:1557:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalOperationDsl.g:1558:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalOperationDsl.g:1564:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) ;
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
            // InternalOperationDsl.g:1570:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) )
            // InternalOperationDsl.g:1571:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            {
            // InternalOperationDsl.g:1571:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==15) ) {
                    alt44=2;
                }
                else if ( (LA44_1==42) ) {
                    alt44=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalOperationDsl.g:1572:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    {
                    // InternalOperationDsl.g:1572:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    // InternalOperationDsl.g:1573:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
                    {
                    // InternalOperationDsl.g:1573:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:1574:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1574:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:1575:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_44); 

                    						newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_45); 

                    				newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:1590:4: ( (lv_value_2_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:1591:5: (lv_value_2_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:1591:5: (lv_value_2_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:1592:6: lv_value_2_0= rulePrimitiveValue
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
                    // InternalOperationDsl.g:1611:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    {
                    // InternalOperationDsl.g:1611:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    // InternalOperationDsl.g:1612:4: ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')'
                    {
                    // InternalOperationDsl.g:1612:4: ( (otherlv_3= RULE_ID ) )
                    // InternalOperationDsl.g:1613:5: (otherlv_3= RULE_ID )
                    {
                    // InternalOperationDsl.g:1613:5: (otherlv_3= RULE_ID )
                    // InternalOperationDsl.g:1614:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_3, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_45); 

                    				newLeafNode(otherlv_4, grammarAccess.getPropertyValueAssignmentAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOperationDsl.g:1629:4: ( (lv_value_5_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:1630:5: (lv_value_5_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:1630:5: (lv_value_5_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:1631:6: lv_value_5_0= rulePrimitiveValue
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
    // InternalOperationDsl.g:1657:1: entryRuleImportedOperationAspect returns [EObject current=null] : iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF ;
    public final EObject entryRuleImportedOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedOperationAspect = null;


        try {
            // InternalOperationDsl.g:1657:64: (iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF )
            // InternalOperationDsl.g:1658:2: iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF
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
    // InternalOperationDsl.g:1664:1: ruleImportedOperationAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:1670:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:1671:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:1671:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            // InternalOperationDsl.g:1672:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';'
            {
            // InternalOperationDsl.g:1672:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1673:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1673:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1674:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedOperationAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedOperationAspectAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1689:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1690:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1690:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1691:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getAspectOperationAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_46);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1705:3: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==15) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalOperationDsl.g:1706:4: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_47); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedOperationAspectAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:1710:4: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_BIG_DECIMAL)) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==RULE_ID) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalOperationDsl.g:1711:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:1711:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:1712:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:1712:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:1713:7: lv_singlePropertyValue_4_0= rulePrimitiveValue
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
                            // InternalOperationDsl.g:1731:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:1731:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:1732:6: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:1732:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:1733:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:1733:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:1734:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_0_0());
                            							
                            pushFollow(FOLLOW_48);
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

                            // InternalOperationDsl.g:1751:6: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==23) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // InternalOperationDsl.g:1752:7: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,23,FOLLOW_7); 

                            	    							newLeafNode(otherlv_6, grammarAccess.getImportedOperationAspectAccess().getCommaKeyword_3_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:1756:7: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:1757:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:1757:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:1758:9: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_48);
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
                            	    break loop45;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,16,FOLLOW_49); 

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
    // InternalOperationDsl.g:1791:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalOperationDsl.g:1791:47: (iv_ruleImport= ruleImport EOF )
            // InternalOperationDsl.g:1792:2: iv_ruleImport= ruleImport EOF
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
    // InternalOperationDsl.g:1798:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:1804:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:1805:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:1805:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:1806:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalOperationDsl.g:1810:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalOperationDsl.g:1811:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalOperationDsl.g:1811:4: (lv_importType_1_0= ruleImportType )
            // InternalOperationDsl.g:1812:5: lv_importType_1_0= ruleImportType
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportTypeImportTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_51);
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
            		
            // InternalOperationDsl.g:1833:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:1834:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1834:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:1835:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_52); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:1855:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:1856:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:1856:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:1857:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:1877:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalOperationDsl.g:1877:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalOperationDsl.g:1878:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalOperationDsl.g:1884:1: ruleMicroservice returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) ;
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
            // InternalOperationDsl.g:1890:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' ) )
            // InternalOperationDsl.g:1891:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            {
            // InternalOperationDsl.g:1891:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}' )
            // InternalOperationDsl.g:1892:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_visibility_9_0= ruleVisibility ) )? ( (lv_type_10_0= ruleMicroserviceType ) ) otherlv_11= 'microservice' ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )? otherlv_15= '{' (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )? (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )? (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )? ( (lv_interfaces_37_0= ruleInterface ) )+ otherlv_38= '}'
            {
            // InternalOperationDsl.g:1892:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==13) ) {
                    int LA48_1 = input.LA(2);

                    if ( (LA48_1==14) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalOperationDsl.g:1893:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalOperationDsl.g:1893:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalOperationDsl.g:1894:5: lv_technologyReferences_0_0= ruleTechnologyReference
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getTechnologyReferencesTechnologyReferenceParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
            	    break loop48;
                }
            } while (true);

            // InternalOperationDsl.g:1911:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==13) ) {
                int LA50_1 = input.LA(2);

                if ( ((LA50_1>=79 && LA50_1<=80)) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalOperationDsl.g:1912:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:1912:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:1913:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:1913:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:1914:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_53);
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

                    // InternalOperationDsl.g:1931:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==13) ) {
                        int LA49_1 = input.LA(2);

                        if ( ((LA49_1>=79 && LA49_1<=80)) ) {
                            alt49=1;
                        }
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalOperationDsl.g:1932:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:1932:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:1933:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getMicroserviceAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_53);
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

            // InternalOperationDsl.g:1951:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==13) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==35) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalOperationDsl.g:1952:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalOperationDsl.g:1964:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1965:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1965:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:1966:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_54);
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
                    	    if ( cnt51 >= 1 ) break loop51;
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
                    } while (true);

                    otherlv_7=(Token)match(input,16,FOLLOW_53); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1988:3: ( (lv_aspects_8_0= ruleImportedServiceAspect ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==13) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalOperationDsl.g:1989:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:1989:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:1990:5: lv_aspects_8_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
            	    break loop53;
                }
            } while (true);

            // InternalOperationDsl.g:2007:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=137 && LA54_0<=139)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalOperationDsl.g:2008:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2008:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:2009:5: lv_visibility_9_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_53);
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

            // InternalOperationDsl.g:2026:3: ( (lv_type_10_0= ruleMicroserviceType ) )
            // InternalOperationDsl.g:2027:4: (lv_type_10_0= ruleMicroserviceType )
            {
            // InternalOperationDsl.g:2027:4: (lv_type_10_0= ruleMicroserviceType )
            // InternalOperationDsl.g:2028:5: lv_type_10_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_55);
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
            		
            // InternalOperationDsl.g:2049:3: ( (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:2050:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:2050:4: (lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:2051:5: lv_name_12_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_56);
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

            // InternalOperationDsl.g:2068:3: (otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==47) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalOperationDsl.g:2069:4: otherlv_13= 'version' ( (lv_version_14_0= RULE_ID ) )
                    {
                    otherlv_13=(Token)match(input,47,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getMicroserviceAccess().getVersionKeyword_8_0());
                    			
                    // InternalOperationDsl.g:2073:4: ( (lv_version_14_0= RULE_ID ) )
                    // InternalOperationDsl.g:2074:5: (lv_version_14_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2074:5: (lv_version_14_0= RULE_ID )
                    // InternalOperationDsl.g:2075:6: lv_version_14_0= RULE_ID
                    {
                    lv_version_14_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_15=(Token)match(input,29,FOLLOW_57); 

            			newLeafNode(otherlv_15, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalOperationDsl.g:2096:3: (otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==48) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==49) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalOperationDsl.g:2097:4: otherlv_16= 'required' otherlv_17= 'microservices' otherlv_18= '{' ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) ) (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )* otherlv_22= '}'
                    {
                    otherlv_16=(Token)match(input,48,FOLLOW_58); 

                    				newLeafNode(otherlv_16, grammarAccess.getMicroserviceAccess().getRequiredKeyword_10_0());
                    			
                    otherlv_17=(Token)match(input,49,FOLLOW_24); 

                    				newLeafNode(otherlv_17, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_10_1());
                    			
                    otherlv_18=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalOperationDsl.g:2109:4: ( (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice ) )
                    // InternalOperationDsl.g:2110:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalOperationDsl.g:2110:5: (lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice )
                    // InternalOperationDsl.g:2111:6: lv_requiredMicroservices_19_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_3_0());
                    					
                    pushFollow(FOLLOW_59);
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

                    // InternalOperationDsl.g:2128:4: (otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==23) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2129:5: otherlv_20= ',' ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_20=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getCommaKeyword_10_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2133:5: ( (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalOperationDsl.g:2134:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalOperationDsl.g:2134:6: (lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice )
                    	    // InternalOperationDsl.g:2135:7: lv_requiredMicroservices_21_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_10_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_59);
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,31,FOLLOW_57); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_10_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2158:3: (otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==48) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==50) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalOperationDsl.g:2159:4: otherlv_23= 'required' otherlv_24= 'interfaces' otherlv_25= '{' ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) ) (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )* otherlv_29= '}'
                    {
                    otherlv_23=(Token)match(input,48,FOLLOW_60); 

                    				newLeafNode(otherlv_23, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_24=(Token)match(input,50,FOLLOW_24); 

                    				newLeafNode(otherlv_24, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_11_1());
                    			
                    otherlv_25=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalOperationDsl.g:2171:4: ( (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface ) )
                    // InternalOperationDsl.g:2172:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    {
                    // InternalOperationDsl.g:2172:5: (lv_requiredInterfaces_26_0= rulePossiblyImportedInterface )
                    // InternalOperationDsl.g:2173:6: lv_requiredInterfaces_26_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_59);
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

                    // InternalOperationDsl.g:2190:4: (otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==23) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2191:5: otherlv_27= ',' ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_27=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2195:5: ( (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface ) )
                    	    // InternalOperationDsl.g:2196:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalOperationDsl.g:2196:6: (lv_requiredInterfaces_28_0= rulePossiblyImportedInterface )
                    	    // InternalOperationDsl.g:2197:7: lv_requiredInterfaces_28_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_59);
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
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,31,FOLLOW_57); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2220:3: (otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==48) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalOperationDsl.g:2221:4: otherlv_30= 'required' otherlv_31= 'operations' otherlv_32= '{' ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) ) (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )* otherlv_36= '}'
                    {
                    otherlv_30=(Token)match(input,48,FOLLOW_61); 

                    				newLeafNode(otherlv_30, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_31=(Token)match(input,51,FOLLOW_24); 

                    				newLeafNode(otherlv_31, grammarAccess.getMicroserviceAccess().getOperationsKeyword_12_1());
                    			
                    otherlv_32=(Token)match(input,29,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalOperationDsl.g:2233:4: ( (lv_requiredOperations_33_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:2234:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:2234:5: (lv_requiredOperations_33_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:2235:6: lv_requiredOperations_33_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_59);
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

                    // InternalOperationDsl.g:2252:4: (otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==23) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2253:5: otherlv_34= ',' ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_34=(Token)match(input,23,FOLLOW_7); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2257:5: ( (lv_requiredOperations_35_0= rulePossiblyImportedOperation ) )
                    	    // InternalOperationDsl.g:2258:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalOperationDsl.g:2258:6: (lv_requiredOperations_35_0= rulePossiblyImportedOperation )
                    	    // InternalOperationDsl.g:2259:7: lv_requiredOperations_35_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_59);
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
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,31,FOLLOW_57); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2282:3: ( (lv_interfaces_37_0= ruleInterface ) )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==13||(LA62_0>=53 && LA62_0<=54)||(LA62_0>=137 && LA62_0<=139)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalOperationDsl.g:2283:4: (lv_interfaces_37_0= ruleInterface )
            	    {
            	    // InternalOperationDsl.g:2283:4: (lv_interfaces_37_0= ruleInterface )
            	    // InternalOperationDsl.g:2284:5: lv_interfaces_37_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_62);
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
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            otherlv_38=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:2309:1: entryRuleTechnologyReference returns [EObject current=null] : iv_ruleTechnologyReference= ruleTechnologyReference EOF ;
    public final EObject entryRuleTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyReference = null;


        try {
            // InternalOperationDsl.g:2309:60: (iv_ruleTechnologyReference= ruleTechnologyReference EOF )
            // InternalOperationDsl.g:2310:2: iv_ruleTechnologyReference= ruleTechnologyReference EOF
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
    // InternalOperationDsl.g:2316:1: ruleTechnologyReference returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) ;
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
            // InternalOperationDsl.g:2322:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) )
            // InternalOperationDsl.g:2323:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            {
            // InternalOperationDsl.g:2323:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            // InternalOperationDsl.g:2324:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOperationDsl.g:2336:3: ( (otherlv_3= RULE_ID ) )
            // InternalOperationDsl.g:2337:4: (otherlv_3= RULE_ID )
            {
            // InternalOperationDsl.g:2337:4: (otherlv_3= RULE_ID )
            // InternalOperationDsl.g:2338:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(otherlv_3, grammarAccess.getTechnologyReferenceAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            // InternalOperationDsl.g:2349:3: (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==23) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalOperationDsl.g:2350:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_63); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,52,FOLLOW_44); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,42,FOLLOW_64); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologyReferenceAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalOperationDsl.g:2362:4: ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:2363:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:2363:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:2364:6: lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN
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
    // InternalOperationDsl.g:2389:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:2389:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalOperationDsl.g:2390:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalOperationDsl.g:2396:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2402:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2403:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2403:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2404:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2404:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==36) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalOperationDsl.g:2405:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2405:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2406:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2406:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2407:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2423:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2424:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2424:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2425:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2443:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalOperationDsl.g:2443:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalOperationDsl.g:2444:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalOperationDsl.g:2450:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2456:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2457:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2457:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2458:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2458:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==36) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalOperationDsl.g:2459:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2459:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2460:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2460:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2461:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2477:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2478:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2478:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2479:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2497:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalOperationDsl.g:2497:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalOperationDsl.g:2498:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalOperationDsl.g:2504:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2510:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2511:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2511:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2512:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2512:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==36) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalOperationDsl.g:2513:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2513:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2514:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2514:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2515:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2531:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2532:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2532:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2533:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2551:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalOperationDsl.g:2551:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalOperationDsl.g:2552:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalOperationDsl.g:2558:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' ) ;
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
            // InternalOperationDsl.g:2564:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' ) )
            // InternalOperationDsl.g:2565:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' )
            {
            // InternalOperationDsl.g:2565:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}' )
            // InternalOperationDsl.g:2566:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_8_0= 'noimpl' ) )? ( (lv_visibility_9_0= ruleVisibility ) )? otherlv_10= 'interface' ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )? otherlv_14= '{' ( (lv_referredOperations_15_0= ruleReferredOperation ) )* ( (lv_operations_16_0= ruleOperation ) )* otherlv_17= '}'
            {
            // InternalOperationDsl.g:2566:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==13) ) {
                int LA68_1 = input.LA(2);

                if ( ((LA68_1>=79 && LA68_1<=80)) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalOperationDsl.g:2567:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2567:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2568:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2568:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2569:6: lv_protocols_0_0= ruleProtocolSpecification
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
                    							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOperationDsl.g:2586:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==13) ) {
                        int LA67_1 = input.LA(2);

                        if ( ((LA67_1>=79 && LA67_1<=80)) ) {
                            alt67=1;
                        }
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalOperationDsl.g:2587:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2587:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2588:6: lv_protocols_1_0= ruleProtocolSpecification
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
                            							"de.fhdo.lemma.ServiceDsl.ProtocolSpecification");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2606:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==13) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==35) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalOperationDsl.g:2607:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2619:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==RULE_ID) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2620:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2620:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2621:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_54);
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
                    	    if ( cnt69 >= 1 ) break loop69;
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_65); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2643:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==13) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalOperationDsl.g:2644:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2644:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2645:5: lv_aspects_7_0= ruleImportedServiceAspect
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
            	    						"de.fhdo.lemma.ServiceDsl.ImportedServiceAspect");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            // InternalOperationDsl.g:2662:3: ( (lv_notImplemented_8_0= 'noimpl' ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==53) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalOperationDsl.g:2663:4: (lv_notImplemented_8_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:2663:4: (lv_notImplemented_8_0= 'noimpl' )
                    // InternalOperationDsl.g:2664:5: lv_notImplemented_8_0= 'noimpl'
                    {
                    lv_notImplemented_8_0=(Token)match(input,53,FOLLOW_66); 

                    					newLeafNode(lv_notImplemented_8_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2676:3: ( (lv_visibility_9_0= ruleVisibility ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=137 && LA73_0<=139)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalOperationDsl.g:2677:4: (lv_visibility_9_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2677:4: (lv_visibility_9_0= ruleVisibility )
                    // InternalOperationDsl.g:2678:5: lv_visibility_9_0= ruleVisibility
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
                    						"de.fhdo.lemma.ServiceDsl.Visibility");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_10, grammarAccess.getInterfaceAccess().getInterfaceKeyword_5());
            		
            // InternalOperationDsl.g:2699:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalOperationDsl.g:2700:4: (lv_name_11_0= RULE_ID )
            {
            // InternalOperationDsl.g:2700:4: (lv_name_11_0= RULE_ID )
            // InternalOperationDsl.g:2701:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_56); 

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

            // InternalOperationDsl.g:2717:3: (otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==47) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalOperationDsl.g:2718:4: otherlv_12= 'version' ( (lv_version_13_0= RULE_ID ) )
                    {
                    otherlv_12=(Token)match(input,47,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getInterfaceAccess().getVersionKeyword_7_0());
                    			
                    // InternalOperationDsl.g:2722:4: ( (lv_version_13_0= RULE_ID ) )
                    // InternalOperationDsl.g:2723:5: (lv_version_13_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2723:5: (lv_version_13_0= RULE_ID )
                    // InternalOperationDsl.g:2724:6: lv_version_13_0= RULE_ID
                    {
                    lv_version_13_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_14=(Token)match(input,29,FOLLOW_68); 

            			newLeafNode(otherlv_14, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalOperationDsl.g:2745:3: ( (lv_referredOperations_15_0= ruleReferredOperation ) )*
            loop75:
            do {
                int alt75=2;
                alt75 = dfa75.predict(input);
                switch (alt75) {
            	case 1 :
            	    // InternalOperationDsl.g:2746:4: (lv_referredOperations_15_0= ruleReferredOperation )
            	    {
            	    // InternalOperationDsl.g:2746:4: (lv_referredOperations_15_0= ruleReferredOperation )
            	    // InternalOperationDsl.g:2747:5: lv_referredOperations_15_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_68);
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
            	    break loop75;
                }
            } while (true);

            // InternalOperationDsl.g:2764:3: ( (lv_operations_16_0= ruleOperation ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID||LA76_0==13||LA76_0==53||LA76_0==55||(LA76_0>=137 && LA76_0<=139)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalOperationDsl.g:2765:4: (lv_operations_16_0= ruleOperation )
            	    {
            	    // InternalOperationDsl.g:2765:4: (lv_operations_16_0= ruleOperation )
            	    // InternalOperationDsl.g:2766:5: lv_operations_16_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_69);
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
            	    break loop76;
                }
            } while (true);

            otherlv_17=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:2791:1: entryRuleApiOperationComment returns [EObject current=null] : iv_ruleApiOperationComment= ruleApiOperationComment EOF ;
    public final EObject entryRuleApiOperationComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiOperationComment = null;


        try {
            // InternalOperationDsl.g:2791:60: (iv_ruleApiOperationComment= ruleApiOperationComment EOF )
            // InternalOperationDsl.g:2792:2: iv_ruleApiOperationComment= ruleApiOperationComment EOF
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
    // InternalOperationDsl.g:2798:1: ruleApiOperationComment returns [EObject current=null] : (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) ;
    public final EObject ruleApiOperationComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_comment_1_0 = null;

        EObject lv_parameterComments_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:2804:2: ( (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) )
            // InternalOperationDsl.g:2805:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            {
            // InternalOperationDsl.g:2805:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            // InternalOperationDsl.g:2806:3: otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getApiOperationCommentAccess().getHyphenMinusHyphenMinusHyphenMinusKeyword_0());
            		
            // InternalOperationDsl.g:2810:3: ( (lv_comment_1_0= ruleAnything ) )
            // InternalOperationDsl.g:2811:4: (lv_comment_1_0= ruleAnything )
            {
            // InternalOperationDsl.g:2811:4: (lv_comment_1_0= ruleAnything )
            // InternalOperationDsl.g:2812:5: lv_comment_1_0= ruleAnything
            {

            					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getCommentAnythingParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_71);
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

            // InternalOperationDsl.g:2829:3: ( (lv_parameterComments_2_0= ruleApiParameterComment ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=56 && LA77_0<=57)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalOperationDsl.g:2830:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    {
            	    // InternalOperationDsl.g:2830:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    // InternalOperationDsl.g:2831:5: lv_parameterComments_2_0= ruleApiParameterComment
            	    {

            	    					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getParameterCommentsApiParameterCommentParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_71);
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
            	    break loop77;
                }
            } while (true);

            otherlv_3=(Token)match(input,55,FOLLOW_2); 

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
    // InternalOperationDsl.g:2856:1: entryRuleApiParameterComment returns [EObject current=null] : iv_ruleApiParameterComment= ruleApiParameterComment EOF ;
    public final EObject entryRuleApiParameterComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiParameterComment = null;


        try {
            // InternalOperationDsl.g:2856:60: (iv_ruleApiParameterComment= ruleApiParameterComment EOF )
            // InternalOperationDsl.g:2857:2: iv_ruleApiParameterComment= ruleApiParameterComment EOF
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
    // InternalOperationDsl.g:2863:1: ruleApiParameterComment returns [EObject current=null] : ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) ) ;
    public final EObject ruleApiParameterComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_required_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_comment_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:2869:2: ( ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) ) )
            // InternalOperationDsl.g:2870:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) )
            {
            // InternalOperationDsl.g:2870:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) ) )
            // InternalOperationDsl.g:2871:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) ) ( (otherlv_2= RULE_ID ) ) ( (lv_comment_3_0= ruleAnything ) )
            {
            // InternalOperationDsl.g:2871:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==56) ) {
                alt78=1;
            }
            else if ( (LA78_0==57) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalOperationDsl.g:2872:4: otherlv_0= '@param'
                    {
                    otherlv_0=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getApiParameterCommentAccess().getParamKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:2877:4: ( (lv_required_1_0= '@required' ) )
                    {
                    // InternalOperationDsl.g:2877:4: ( (lv_required_1_0= '@required' ) )
                    // InternalOperationDsl.g:2878:5: (lv_required_1_0= '@required' )
                    {
                    // InternalOperationDsl.g:2878:5: (lv_required_1_0= '@required' )
                    // InternalOperationDsl.g:2879:6: lv_required_1_0= '@required'
                    {
                    lv_required_1_0=(Token)match(input,57,FOLLOW_7); 

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

            // InternalOperationDsl.g:2892:3: ( (otherlv_2= RULE_ID ) )
            // InternalOperationDsl.g:2893:4: (otherlv_2= RULE_ID )
            {
            // InternalOperationDsl.g:2893:4: (otherlv_2= RULE_ID )
            // InternalOperationDsl.g:2894:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApiParameterCommentRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_70); 

            					newLeafNode(otherlv_2, grammarAccess.getApiParameterCommentAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalOperationDsl.g:2905:3: ( (lv_comment_3_0= ruleAnything ) )
            // InternalOperationDsl.g:2906:4: (lv_comment_3_0= ruleAnything )
            {
            // InternalOperationDsl.g:2906:4: (lv_comment_3_0= ruleAnything )
            // InternalOperationDsl.g:2907:5: lv_comment_3_0= ruleAnything
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
    // InternalOperationDsl.g:2928:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalOperationDsl.g:2928:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalOperationDsl.g:2929:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalOperationDsl.g:2935:1: ruleOperation returns [EObject current=null] : ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' ) ;
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
            // InternalOperationDsl.g:2941:2: ( ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' ) )
            // InternalOperationDsl.g:2942:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' )
            {
            // InternalOperationDsl.g:2942:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';' )
            // InternalOperationDsl.g:2943:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? ( (lv_aspects_8_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_9_0= 'noimpl' ) )? ( (lv_visibility_10_0= ruleVisibility ) )? ( (lv_name_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_parameters_13_0= ruleParameter ) )? (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )* otherlv_16= ')' otherlv_17= ';'
            {
            // InternalOperationDsl.g:2943:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==55) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalOperationDsl.g:2944:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    {
                    // InternalOperationDsl.g:2944:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    // InternalOperationDsl.g:2945:5: lv_apiOperationComment_0_0= ruleApiOperationComment
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getApiOperationCommentApiOperationCommentParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_72);
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

            // InternalOperationDsl.g:2962:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==13) ) {
                int LA81_1 = input.LA(2);

                if ( ((LA81_1>=79 && LA81_1<=80)) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // InternalOperationDsl.g:2963:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2963:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2964:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2964:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2965:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_72);
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

                    // InternalOperationDsl.g:2982:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==13) ) {
                        int LA80_1 = input.LA(2);

                        if ( ((LA80_1>=79 && LA80_1<=80)) ) {
                            alt80=1;
                        }
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalOperationDsl.g:2983:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2983:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2984:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_72);
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

            // InternalOperationDsl.g:3002:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==13) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==35) ) {
                    alt83=1;
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalOperationDsl.g:3003:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalOperationDsl.g:3015:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:3016:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:3016:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:3017:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_54);
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
                    	    if ( cnt82 >= 1 ) break loop82;
                                EarlyExitException eee =
                                    new EarlyExitException(82, input);
                                throw eee;
                        }
                        cnt82++;
                    } while (true);

                    otherlv_7=(Token)match(input,16,FOLLOW_72); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:3039:3: ( (lv_aspects_8_0= ruleImportedServiceAspect ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==13) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalOperationDsl.g:3040:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:3040:4: (lv_aspects_8_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:3041:5: lv_aspects_8_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_72);
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
            	    break loop84;
                }
            } while (true);

            // InternalOperationDsl.g:3058:3: ( (lv_notImplemented_9_0= 'noimpl' ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==53) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalOperationDsl.g:3059:4: (lv_notImplemented_9_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:3059:4: (lv_notImplemented_9_0= 'noimpl' )
                    // InternalOperationDsl.g:3060:5: lv_notImplemented_9_0= 'noimpl'
                    {
                    lv_notImplemented_9_0=(Token)match(input,53,FOLLOW_73); 

                    					newLeafNode(lv_notImplemented_9_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", true, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:3072:3: ( (lv_visibility_10_0= ruleVisibility ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( ((LA86_0>=137 && LA86_0<=139)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalOperationDsl.g:3073:4: (lv_visibility_10_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:3073:4: (lv_visibility_10_0= ruleVisibility )
                    // InternalOperationDsl.g:3074:5: lv_visibility_10_0= ruleVisibility
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

            // InternalOperationDsl.g:3091:3: ( (lv_name_11_0= RULE_ID ) )
            // InternalOperationDsl.g:3092:4: (lv_name_11_0= RULE_ID )
            {
            // InternalOperationDsl.g:3092:4: (lv_name_11_0= RULE_ID )
            // InternalOperationDsl.g:3093:5: lv_name_11_0= RULE_ID
            {
            lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_6); 

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

            otherlv_12=(Token)match(input,15,FOLLOW_74); 

            			newLeafNode(otherlv_12, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_7());
            		
            // InternalOperationDsl.g:3113:3: ( (lv_parameters_13_0= ruleParameter ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==13||(LA87_0>=79 && LA87_0<=80)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalOperationDsl.g:3114:4: (lv_parameters_13_0= ruleParameter )
                    {
                    // InternalOperationDsl.g:3114:4: (lv_parameters_13_0= ruleParameter )
                    // InternalOperationDsl.g:3115:5: lv_parameters_13_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_48);
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

            // InternalOperationDsl.g:3132:3: (otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==23) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalOperationDsl.g:3133:4: otherlv_14= ',' ( (lv_parameters_15_0= ruleParameter ) )
            	    {
            	    otherlv_14=(Token)match(input,23,FOLLOW_75); 

            	    				newLeafNode(otherlv_14, grammarAccess.getOperationAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalOperationDsl.g:3137:4: ( (lv_parameters_15_0= ruleParameter ) )
            	    // InternalOperationDsl.g:3138:5: (lv_parameters_15_0= ruleParameter )
            	    {
            	    // InternalOperationDsl.g:3138:5: (lv_parameters_15_0= ruleParameter )
            	    // InternalOperationDsl.g:3139:6: lv_parameters_15_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop88;
                }
            } while (true);

            otherlv_16=(Token)match(input,16,FOLLOW_49); 

            			newLeafNode(otherlv_16, grammarAccess.getOperationAccess().getRightParenthesisKeyword_10());
            		
            otherlv_17=(Token)match(input,41,FOLLOW_2); 

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
    // InternalOperationDsl.g:3169:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalOperationDsl.g:3169:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalOperationDsl.g:3170:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalOperationDsl.g:3176:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) ;
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
            // InternalOperationDsl.g:3182:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' ) )
            // InternalOperationDsl.g:3183:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            {
            // InternalOperationDsl.g:3183:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';' )
            // InternalOperationDsl.g:3184:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? ( (lv_aspects_7_0= ruleImportedServiceAspect ) )* otherlv_8= 'refers' ( ( ruleQualifiedName ) ) otherlv_10= ';'
            {
            // InternalOperationDsl.g:3184:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==13) ) {
                int LA90_1 = input.LA(2);

                if ( ((LA90_1>=79 && LA90_1<=80)) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalOperationDsl.g:3185:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:3185:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:3186:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:3186:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:3187:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_76);
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

                    // InternalOperationDsl.g:3204:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==13) ) {
                        int LA89_1 = input.LA(2);

                        if ( ((LA89_1>=79 && LA89_1<=80)) ) {
                            alt89=1;
                        }
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalOperationDsl.g:3205:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:3205:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:3206:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getReferredOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_76);
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

            // InternalOperationDsl.g:3224:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==13) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==35) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // InternalOperationDsl.g:3225:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:3237:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:3238:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:3238:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:3239:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_54);
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
                    	    if ( cnt91 >= 1 ) break loop91;
                                EarlyExitException eee =
                                    new EarlyExitException(91, input);
                                throw eee;
                        }
                        cnt91++;
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_76); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:3261:3: ( (lv_aspects_7_0= ruleImportedServiceAspect ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==13) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalOperationDsl.g:3262:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:3262:4: (lv_aspects_7_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:3263:5: lv_aspects_7_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_76);
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
            	    break loop93;
                }
            } while (true);

            otherlv_8=(Token)match(input,58,FOLLOW_7); 

            			newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getRefersKeyword_3());
            		
            // InternalOperationDsl.g:3284:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3285:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3285:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3286:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_4_0());
            				
            pushFollow(FOLLOW_49);
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
    // InternalOperationDsl.g:3308:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalOperationDsl.g:3308:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalOperationDsl.g:3309:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalOperationDsl.g:3315:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalOperationDsl.g:3321:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalOperationDsl.g:3322:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalOperationDsl.g:3322:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalOperationDsl.g:3323:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalOperationDsl.g:3323:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==13) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalOperationDsl.g:3324:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:3324:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:3325:5: lv_aspects_0_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getParameterAccess().getAspectsImportedServiceAspectParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_75);
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
            	    break loop94;
                }
            } while (true);

            // InternalOperationDsl.g:3342:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3343:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3343:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:3344:5: lv_communicationType_1_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_77);
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

            // InternalOperationDsl.g:3361:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=76 && LA95_0<=78)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalOperationDsl.g:3362:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:3362:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:3363:5: lv_exchangePattern_2_0= ruleExchangePattern
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getExchangePatternExchangePatternEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_78);
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

            // InternalOperationDsl.g:3380:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==59) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalOperationDsl.g:3381:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalOperationDsl.g:3381:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalOperationDsl.g:3382:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,59,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", true, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:3394:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalOperationDsl.g:3395:4: (lv_name_4_0= RULE_ID )
            {
            // InternalOperationDsl.g:3395:4: (lv_name_4_0= RULE_ID )
            // InternalOperationDsl.g:3396:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_79); 

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

            // InternalOperationDsl.g:3412:3: ( (lv_optional_5_0= '?' ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==60) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalOperationDsl.g:3413:4: (lv_optional_5_0= '?' )
                    {
                    // InternalOperationDsl.g:3413:4: (lv_optional_5_0= '?' )
                    // InternalOperationDsl.g:3414:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,60,FOLLOW_80); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,40,FOLLOW_81); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalOperationDsl.g:3430:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( ((LA98_0>=127 && LA98_0<=136)||LA98_0==143) ) {
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
                    // InternalOperationDsl.g:3431:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:3431:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:3432:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:3432:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalOperationDsl.g:3433:6: lv_primitiveType_7_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:3451:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalOperationDsl.g:3451:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalOperationDsl.g:3452:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalOperationDsl.g:3452:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalOperationDsl.g:3453:6: lv_importedType_8_0= ruleImportedType
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

            // InternalOperationDsl.g:3471:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==42) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalOperationDsl.g:3472:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalOperationDsl.g:3476:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:3477:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:3477:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:3478:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalOperationDsl.g:3500:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalOperationDsl.g:3500:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalOperationDsl.g:3501:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalOperationDsl.g:3507:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3513:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:3514:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:3514:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:3515:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:3515:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3516:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3516:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3517:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:3532:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3533:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3533:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3534:5: ruleQualifiedName
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
    // InternalOperationDsl.g:3552:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalOperationDsl.g:3552:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalOperationDsl.g:3553:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalOperationDsl.g:3559:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3565:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalOperationDsl.g:3566:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalOperationDsl.g:3566:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalOperationDsl.g:3567:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_75); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3571:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3572:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3572:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:3573:5: lv_communicationType_1_0= ruleCommunicationType
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
            		
            // InternalOperationDsl.g:3594:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3595:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3595:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3596:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
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
    // InternalOperationDsl.g:3621:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:3621:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:3622:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalOperationDsl.g:3628:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3634:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalOperationDsl.g:3635:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalOperationDsl.g:3635:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalOperationDsl.g:3636:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalOperationDsl.g:3636:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3637:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3637:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3638:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:3653:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3654:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3654:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3655:5: ruleQualifiedName
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

            // InternalOperationDsl.g:3669:3: (otherlv_3= '/' ( (otherlv_4= RULE_ID ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==39) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalOperationDsl.g:3670:4: otherlv_3= '/' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getSolidusKeyword_3_0());
                    			
                    // InternalOperationDsl.g:3674:4: ( (otherlv_4= RULE_ID ) )
                    // InternalOperationDsl.g:3675:5: (otherlv_4= RULE_ID )
                    {
                    // InternalOperationDsl.g:3675:5: (otherlv_4= RULE_ID )
                    // InternalOperationDsl.g:3676:6: otherlv_4= RULE_ID
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
    // InternalOperationDsl.g:3692:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalOperationDsl.g:3692:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalOperationDsl.g:3693:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalOperationDsl.g:3699:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:3705:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:3706:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:3706:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:3707:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:3707:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3708:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3708:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3709:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
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

            // InternalOperationDsl.g:3726:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==23) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalOperationDsl.g:3727:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:3731:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:3732:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:3732:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalOperationDsl.g:3733:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
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
            	    break loop101;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:3755:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:3756:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:3756:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:3757:5: lv_addresses_4_0= RULE_STRING
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
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            // InternalOperationDsl.g:3773:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==23) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalOperationDsl.g:3774:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:3778:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:3779:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:3779:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:3780:6: lv_addresses_6_0= RULE_STRING
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
            	    							"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
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
    // InternalOperationDsl.g:3805:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalOperationDsl.g:3805:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalOperationDsl.g:3806:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalOperationDsl.g:3812:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalOperationDsl.g:3818:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalOperationDsl.g:3819:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalOperationDsl.g:3819:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalOperationDsl.g:3820:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3824:3: ( (otherlv_1= RULE_ID ) )
            // InternalOperationDsl.g:3825:4: (otherlv_1= RULE_ID )
            {
            // InternalOperationDsl.g:3825:4: (otherlv_1= RULE_ID )
            // InternalOperationDsl.g:3826:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalOperationDsl.g:3841:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3842:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3842:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3843:5: ruleQualifiedName
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

            // InternalOperationDsl.g:3857:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==15) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalOperationDsl.g:3858:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_47); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalOperationDsl.g:3862:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( ((LA104_0>=RULE_STRING && LA104_0<=RULE_BIG_DECIMAL)) ) {
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
                            // InternalOperationDsl.g:3863:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:3863:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:3864:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:3864:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:3865:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
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
                            // InternalOperationDsl.g:3883:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:3883:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:3884:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:3884:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:3885:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:3885:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:3886:8: lv_values_6_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_48);
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

                            // InternalOperationDsl.g:3903:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop103:
                            do {
                                int alt103=2;
                                int LA103_0 = input.LA(1);

                                if ( (LA103_0==23) ) {
                                    alt103=1;
                                }


                                switch (alt103) {
                            	case 1 :
                            	    // InternalOperationDsl.g:3904:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,23,FOLLOW_7); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:3908:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:3909:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:3909:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:3910:9: lv_values_8_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_48);
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


    // $ANTLR start "entryRuleQualifiedNameWithAtLeastOneLevel"
    // InternalOperationDsl.g:3939:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalOperationDsl.g:3939:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalOperationDsl.g:3940:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalOperationDsl.g:3946:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3952:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalOperationDsl.g:3953:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalOperationDsl.g:3953:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalOperationDsl.g:3954:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_84); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,61,FOLLOW_7); 

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
    // InternalOperationDsl.g:3980:1: entryRuleAnything returns [String current=null] : iv_ruleAnything= ruleAnything EOF ;
    public final String entryRuleAnything() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnything = null;


        try {
            // InternalOperationDsl.g:3980:48: (iv_ruleAnything= ruleAnything EOF )
            // InternalOperationDsl.g:3981:2: iv_ruleAnything= ruleAnything EOF
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
    // InternalOperationDsl.g:3987:1: ruleAnything returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+ ;
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
            // InternalOperationDsl.g:3993:2: ( (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+ )
            // InternalOperationDsl.g:3994:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+
            {
            // InternalOperationDsl.g:3994:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'list' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_116= RULE_BOOLEAN | this_BIG_DECIMAL_117= RULE_BIG_DECIMAL | this_ID_118= RULE_ID | this_STRING_119= RULE_STRING | this_ANY_OTHER_120= RULE_ANY_OTHER )+
            int cnt106=0;
            loop106:
            do {
                int alt106=121;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    alt106=1;
                    }
                    break;
                case 31:
                    {
                    alt106=2;
                    }
                    break;
                case 62:
                    {
                    alt106=3;
                    }
                    break;
                case 63:
                    {
                    alt106=4;
                    }
                    break;
                case 23:
                    {
                    alt106=5;
                    }
                    break;
                case 15:
                    {
                    alt106=6;
                    }
                    break;
                case 16:
                    {
                    alt106=7;
                    }
                    break;
                case 36:
                    {
                    alt106=8;
                    }
                    break;
                case 61:
                    {
                    alt106=9;
                    }
                    break;
                case 64:
                    {
                    alt106=10;
                    }
                    break;
                case 65:
                    {
                    alt106=11;
                    }
                    break;
                case 39:
                    {
                    alt106=12;
                    }
                    break;
                case 60:
                    {
                    alt106=13;
                    }
                    break;
                case 40:
                    {
                    alt106=14;
                    }
                    break;
                case 13:
                    {
                    alt106=15;
                    }
                    break;
                case 42:
                    {
                    alt106=16;
                    }
                    break;
                case 41:
                    {
                    alt106=17;
                    }
                    break;
                case 14:
                    {
                    alt106=18;
                    }
                    break;
                case 66:
                    {
                    alt106=19;
                    }
                    break;
                case 67:
                    {
                    alt106=20;
                    }
                    break;
                case 68:
                    {
                    alt106=21;
                    }
                    break;
                case 69:
                    {
                    alt106=22;
                    }
                    break;
                case 70:
                    {
                    alt106=23;
                    }
                    break;
                case 30:
                    {
                    alt106=24;
                    }
                    break;
                case 18:
                    {
                    alt106=25;
                    }
                    break;
                case 71:
                    {
                    alt106=26;
                    }
                    break;
                case 72:
                    {
                    alt106=27;
                    }
                    break;
                case 20:
                    {
                    alt106=28;
                    }
                    break;
                case 43:
                    {
                    alt106=29;
                    }
                    break;
                case 44:
                    {
                    alt106=30;
                    }
                    break;
                case 45:
                    {
                    alt106=31;
                    }
                    break;
                case 73:
                    {
                    alt106=32;
                    }
                    break;
                case 74:
                    {
                    alt106=33;
                    }
                    break;
                case 32:
                    {
                    alt106=34;
                    }
                    break;
                case 19:
                    {
                    alt106=35;
                    }
                    break;
                case 75:
                    {
                    alt106=36;
                    }
                    break;
                case 76:
                    {
                    alt106=37;
                    }
                    break;
                case 77:
                    {
                    alt106=38;
                    }
                    break;
                case 78:
                    {
                    alt106=39;
                    }
                    break;
                case 79:
                    {
                    alt106=40;
                    }
                    break;
                case 80:
                    {
                    alt106=41;
                    }
                    break;
                case 81:
                    {
                    alt106=42;
                    }
                    break;
                case 82:
                    {
                    alt106=43;
                    }
                    break;
                case 83:
                    {
                    alt106=44;
                    }
                    break;
                case 25:
                    {
                    alt106=45;
                    }
                    break;
                case 84:
                    {
                    alt106=46;
                    }
                    break;
                case 85:
                    {
                    alt106=47;
                    }
                    break;
                case 86:
                    {
                    alt106=48;
                    }
                    break;
                case 87:
                    {
                    alt106=49;
                    }
                    break;
                case 88:
                    {
                    alt106=50;
                    }
                    break;
                case 89:
                    {
                    alt106=51;
                    }
                    break;
                case 90:
                    {
                    alt106=52;
                    }
                    break;
                case 91:
                    {
                    alt106=53;
                    }
                    break;
                case 92:
                    {
                    alt106=54;
                    }
                    break;
                case 49:
                    {
                    alt106=55;
                    }
                    break;
                case 50:
                    {
                    alt106=56;
                    }
                    break;
                case 51:
                    {
                    alt106=57;
                    }
                    break;
                case 93:
                    {
                    alt106=58;
                    }
                    break;
                case 94:
                    {
                    alt106=59;
                    }
                    break;
                case 95:
                    {
                    alt106=60;
                    }
                    break;
                case 96:
                    {
                    alt106=61;
                    }
                    break;
                case 97:
                    {
                    alt106=62;
                    }
                    break;
                case 98:
                    {
                    alt106=63;
                    }
                    break;
                case 99:
                    {
                    alt106=64;
                    }
                    break;
                case 100:
                    {
                    alt106=65;
                    }
                    break;
                case 101:
                    {
                    alt106=66;
                    }
                    break;
                case 102:
                    {
                    alt106=67;
                    }
                    break;
                case 47:
                    {
                    alt106=68;
                    }
                    break;
                case 104:
                    {
                    alt106=69;
                    }
                    break;
                case 105:
                    {
                    alt106=70;
                    }
                    break;
                case 106:
                    {
                    alt106=71;
                    }
                    break;
                case 107:
                    {
                    alt106=72;
                    }
                    break;
                case 108:
                    {
                    alt106=73;
                    }
                    break;
                case 109:
                    {
                    alt106=74;
                    }
                    break;
                case 110:
                    {
                    alt106=75;
                    }
                    break;
                case 111:
                    {
                    alt106=76;
                    }
                    break;
                case 112:
                    {
                    alt106=77;
                    }
                    break;
                case 113:
                    {
                    alt106=78;
                    }
                    break;
                case 114:
                    {
                    alt106=79;
                    }
                    break;
                case 115:
                    {
                    alt106=80;
                    }
                    break;
                case 116:
                    {
                    alt106=81;
                    }
                    break;
                case 117:
                    {
                    alt106=82;
                    }
                    break;
                case 118:
                    {
                    alt106=83;
                    }
                    break;
                case 119:
                    {
                    alt106=84;
                    }
                    break;
                case 120:
                    {
                    alt106=85;
                    }
                    break;
                case 121:
                    {
                    alt106=86;
                    }
                    break;
                case 122:
                    {
                    alt106=87;
                    }
                    break;
                case 123:
                    {
                    alt106=88;
                    }
                    break;
                case 124:
                    {
                    alt106=89;
                    }
                    break;
                case 125:
                    {
                    alt106=90;
                    }
                    break;
                case 126:
                    {
                    alt106=91;
                    }
                    break;
                case 127:
                    {
                    alt106=92;
                    }
                    break;
                case 128:
                    {
                    alt106=93;
                    }
                    break;
                case 129:
                    {
                    alt106=94;
                    }
                    break;
                case 130:
                    {
                    alt106=95;
                    }
                    break;
                case 131:
                    {
                    alt106=96;
                    }
                    break;
                case 132:
                    {
                    alt106=97;
                    }
                    break;
                case 133:
                    {
                    alt106=98;
                    }
                    break;
                case 134:
                    {
                    alt106=99;
                    }
                    break;
                case 135:
                    {
                    alt106=100;
                    }
                    break;
                case 136:
                    {
                    alt106=101;
                    }
                    break;
                case 137:
                    {
                    alt106=102;
                    }
                    break;
                case 138:
                    {
                    alt106=103;
                    }
                    break;
                case 139:
                    {
                    alt106=104;
                    }
                    break;
                case 35:
                    {
                    alt106=105;
                    }
                    break;
                case 46:
                    {
                    alt106=106;
                    }
                    break;
                case 48:
                    {
                    alt106=107;
                    }
                    break;
                case 52:
                    {
                    alt106=108;
                    }
                    break;
                case 53:
                    {
                    alt106=109;
                    }
                    break;
                case 54:
                    {
                    alt106=110;
                    }
                    break;
                case 140:
                    {
                    alt106=111;
                    }
                    break;
                case 58:
                    {
                    alt106=112;
                    }
                    break;
                case 59:
                    {
                    alt106=113;
                    }
                    break;
                case 141:
                    {
                    alt106=114;
                    }
                    break;
                case 142:
                    {
                    alt106=115;
                    }
                    break;
                case RULE_BOOLEAN:
                    {
                    alt106=116;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt106=117;
                    }
                    break;
                case RULE_ID:
                    {
                    alt106=118;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt106=119;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt106=120;
                    }
                    break;

                }

                switch (alt106) {
            	case 1 :
            	    // InternalOperationDsl.g:3995:3: kw= '{'
            	    {
            	    kw=(Token)match(input,29,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftCurlyBracketKeyword_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalOperationDsl.g:4001:3: kw= '}'
            	    {
            	    kw=(Token)match(input,31,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightCurlyBracketKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalOperationDsl.g:4007:3: kw= '<'
            	    {
            	    kw=(Token)match(input,62,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignKeyword_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalOperationDsl.g:4013:3: kw= '>'
            	    {
            	    kw=(Token)match(input,63,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getGreaterThanSignKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalOperationDsl.g:4019:3: kw= ','
            	    {
            	    kw=(Token)match(input,23,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommaKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalOperationDsl.g:4025:3: kw= '('
            	    {
            	    kw=(Token)match(input,15,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftParenthesisKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalOperationDsl.g:4031:3: kw= ')'
            	    {
            	    kw=(Token)match(input,16,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightParenthesisKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalOperationDsl.g:4037:3: kw= '::'
            	    {
            	    kw=(Token)match(input,36,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonColonKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalOperationDsl.g:4043:3: kw= '.'
            	    {
            	    kw=(Token)match(input,61,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFullStopKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalOperationDsl.g:4049:3: kw= '-'
            	    {
            	    kw=(Token)match(input,64,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalOperationDsl.g:4055:3: kw= '--'
            	    {
            	    kw=(Token)match(input,65,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusHyphenMinusKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalOperationDsl.g:4061:3: kw= '/'
            	    {
            	    kw=(Token)match(input,39,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSolidusKeyword_11());
            	    		

            	    }
            	    break;
            	case 13 :
            	    // InternalOperationDsl.g:4067:3: kw= '?'
            	    {
            	    kw=(Token)match(input,60,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getQuestionMarkKeyword_12());
            	    		

            	    }
            	    break;
            	case 14 :
            	    // InternalOperationDsl.g:4073:3: kw= ':'
            	    {
            	    kw=(Token)match(input,40,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonKeyword_13());
            	    		

            	    }
            	    break;
            	case 15 :
            	    // InternalOperationDsl.g:4079:3: kw= '@'
            	    {
            	    kw=(Token)match(input,13,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommercialAtKeyword_14());
            	    		

            	    }
            	    break;
            	case 16 :
            	    // InternalOperationDsl.g:4085:3: kw= '='
            	    {
            	    kw=(Token)match(input,42,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEqualsSignKeyword_15());
            	    		

            	    }
            	    break;
            	case 17 :
            	    // InternalOperationDsl.g:4091:3: kw= ';'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSemicolonKeyword_16());
            	    		

            	    }
            	    break;
            	case 18 :
            	    // InternalOperationDsl.g:4097:3: kw= 'technology'
            	    {
            	    kw=(Token)match(input,14,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologyKeyword_17());
            	    		

            	    }
            	    break;
            	case 19 :
            	    // InternalOperationDsl.g:4103:3: kw= 'types'
            	    {
            	    kw=(Token)match(input,66,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypesKeyword_18());
            	    		

            	    }
            	    break;
            	case 20 :
            	    // InternalOperationDsl.g:4109:3: kw= 'compatibility'
            	    {
            	    kw=(Token)match(input,67,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCompatibilityKeyword_19());
            	    		

            	    }
            	    break;
            	case 21 :
            	    // InternalOperationDsl.g:4115:3: kw= 'matrix'
            	    {
            	    kw=(Token)match(input,68,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMatrixKeyword_20());
            	    		

            	    }
            	    break;
            	case 22 :
            	    // InternalOperationDsl.g:4121:3: kw= 'protocols'
            	    {
            	    kw=(Token)match(input,69,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolsKeyword_21());
            	    		

            	    }
            	    break;
            	case 23 :
            	    // InternalOperationDsl.g:4127:3: kw= 'service'
            	    {
            	    kw=(Token)match(input,70,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getServiceKeyword_22());
            	    		

            	    }
            	    break;
            	case 24 :
            	    // InternalOperationDsl.g:4133:3: kw= 'aspects'
            	    {
            	    kw=(Token)match(input,30,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectsKeyword_23());
            	    		

            	    }
            	    break;
            	case 25 :
            	    // InternalOperationDsl.g:4139:3: kw= 'deployment'
            	    {
            	    kw=(Token)match(input,18,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDeploymentKeyword_24());
            	    		

            	    }
            	    break;
            	case 26 :
            	    // InternalOperationDsl.g:4145:3: kw= 'technologies'
            	    {
            	    kw=(Token)match(input,71,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologiesKeyword_25());
            	    		

            	    }
            	    break;
            	case 27 :
            	    // InternalOperationDsl.g:4151:3: kw= 'infrastructure'
            	    {
            	    kw=(Token)match(input,72,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureKeyword_26());
            	    		

            	    }
            	    break;
            	case 28 :
            	    // InternalOperationDsl.g:4157:3: kw= 'operation'
            	    {
            	    kw=(Token)match(input,20,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationKeyword_27());
            	    		

            	    }
            	    break;
            	case 29 :
            	    // InternalOperationDsl.g:4163:3: kw= 'import'
            	    {
            	    kw=(Token)match(input,43,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImportKeyword_28());
            	    		

            	    }
            	    break;
            	case 30 :
            	    // InternalOperationDsl.g:4169:3: kw= 'from'
            	    {
            	    kw=(Token)match(input,44,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFromKeyword_29());
            	    		

            	    }
            	    break;
            	case 31 :
            	    // InternalOperationDsl.g:4175:3: kw= 'as'
            	    {
            	    kw=(Token)match(input,45,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsKeyword_30());
            	    		

            	    }
            	    break;
            	case 32 :
            	    // InternalOperationDsl.g:4181:3: kw= 'data'
            	    {
            	    kw=(Token)match(input,73,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDataKeyword_31());
            	    		

            	    }
            	    break;
            	case 33 :
            	    // InternalOperationDsl.g:4187:3: kw= 'formats'
            	    {
            	    kw=(Token)match(input,74,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatsKeyword_32());
            	    		

            	    }
            	    break;
            	case 34 :
            	    // InternalOperationDsl.g:4193:3: kw= 'default'
            	    {
            	    kw=(Token)match(input,32,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDefaultKeyword_33());
            	    		

            	    }
            	    break;
            	case 35 :
            	    // InternalOperationDsl.g:4199:3: kw= 'with'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getWithKeyword_34());
            	    		

            	    }
            	    break;
            	case 36 :
            	    // InternalOperationDsl.g:4205:3: kw= 'format'
            	    {
            	    kw=(Token)match(input,75,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatKeyword_35());
            	    		

            	    }
            	    break;
            	case 37 :
            	    // InternalOperationDsl.g:4211:3: kw= 'in'
            	    {
            	    kw=(Token)match(input,76,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInKeyword_36());
            	    		

            	    }
            	    break;
            	case 38 :
            	    // InternalOperationDsl.g:4217:3: kw= 'out'
            	    {
            	    kw=(Token)match(input,77,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOutKeyword_37());
            	    		

            	    }
            	    break;
            	case 39 :
            	    // InternalOperationDsl.g:4223:3: kw= 'inout'
            	    {
            	    kw=(Token)match(input,78,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInoutKeyword_38());
            	    		

            	    }
            	    break;
            	case 40 :
            	    // InternalOperationDsl.g:4229:3: kw= 'sync'
            	    {
            	    kw=(Token)match(input,79,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSyncKeyword_39());
            	    		

            	    }
            	    break;
            	case 41 :
            	    // InternalOperationDsl.g:4235:3: kw= 'async'
            	    {
            	    kw=(Token)match(input,80,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsyncKeyword_40());
            	    		

            	    }
            	    break;
            	case 42 :
            	    // InternalOperationDsl.g:4241:3: kw= 'primitive'
            	    {
            	    kw=(Token)match(input,81,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPrimitiveKeyword_41());
            	    		

            	    }
            	    break;
            	case 43 :
            	    // InternalOperationDsl.g:4247:3: kw= 'type'
            	    {
            	    kw=(Token)match(input,82,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypeKeyword_42());
            	    		

            	    }
            	    break;
            	case 44 :
            	    // InternalOperationDsl.g:4253:3: kw= 'based'
            	    {
            	    kw=(Token)match(input,83,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBasedKeyword_43());
            	    		

            	    }
            	    break;
            	case 45 :
            	    // InternalOperationDsl.g:4259:3: kw= 'on'
            	    {
            	    kw=(Token)match(input,25,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOnKeyword_44());
            	    		

            	    }
            	    break;
            	case 46 :
            	    // InternalOperationDsl.g:4265:3: kw= 'list'
            	    {
            	    kw=(Token)match(input,84,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getListKeyword_45());
            	    		

            	    }
            	    break;
            	case 47 :
            	    // InternalOperationDsl.g:4271:3: kw= 'structure'
            	    {
            	    kw=(Token)match(input,85,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStructureKeyword_46());
            	    		

            	    }
            	    break;
            	case 48 :
            	    // InternalOperationDsl.g:4277:3: kw= '->'
            	    {
            	    kw=(Token)match(input,86,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusGreaterThanSignKeyword_47());
            	    		

            	    }
            	    break;
            	case 49 :
            	    // InternalOperationDsl.g:4283:3: kw= '<-'
            	    {
            	    kw=(Token)match(input,87,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusKeyword_48());
            	    		

            	    }
            	    break;
            	case 50 :
            	    // InternalOperationDsl.g:4289:3: kw= '<->'
            	    {
            	    kw=(Token)match(input,88,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_49());
            	    		

            	    }
            	    break;
            	case 51 :
            	    // InternalOperationDsl.g:4295:3: kw= 'environments'
            	    {
            	    kw=(Token)match(input,89,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnvironmentsKeyword_50());
            	    		

            	    }
            	    break;
            	case 52 :
            	    // InternalOperationDsl.g:4301:3: kw= 'properties'
            	    {
            	    kw=(Token)match(input,90,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPropertiesKeyword_51());
            	    		

            	    }
            	    break;
            	case 53 :
            	    // InternalOperationDsl.g:4307:3: kw= 'mandatory'
            	    {
            	    kw=(Token)match(input,91,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMandatoryKeyword_52());
            	    		

            	    }
            	    break;
            	case 54 :
            	    // InternalOperationDsl.g:4313:3: kw= 'singleval'
            	    {
            	    kw=(Token)match(input,92,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSinglevalKeyword_53());
            	    		

            	    }
            	    break;
            	case 55 :
            	    // InternalOperationDsl.g:4319:3: kw= 'microservices'
            	    {
            	    kw=(Token)match(input,49,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroservicesKeyword_54());
            	    		

            	    }
            	    break;
            	case 56 :
            	    // InternalOperationDsl.g:4325:3: kw= 'interfaces'
            	    {
            	    kw=(Token)match(input,50,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfacesKeyword_55());
            	    		

            	    }
            	    break;
            	case 57 :
            	    // InternalOperationDsl.g:4331:3: kw= 'operations'
            	    {
            	    kw=(Token)match(input,51,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationsKeyword_56());
            	    		

            	    }
            	    break;
            	case 58 :
            	    // InternalOperationDsl.g:4337:3: kw= 'parameters'
            	    {
            	    kw=(Token)match(input,93,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParametersKeyword_57());
            	    		

            	    }
            	    break;
            	case 59 :
            	    // InternalOperationDsl.g:4343:3: kw= 'fields'
            	    {
            	    kw=(Token)match(input,94,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFieldsKeyword_58());
            	    		

            	    }
            	    break;
            	case 60 :
            	    // InternalOperationDsl.g:4349:3: kw= 'exchange_pattern'
            	    {
            	    kw=(Token)match(input,95,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExchange_patternKeyword_59());
            	    		

            	    }
            	    break;
            	case 61 :
            	    // InternalOperationDsl.g:4355:3: kw= 'communication_type'
            	    {
            	    kw=(Token)match(input,96,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommunication_typeKeyword_60());
            	    		

            	    }
            	    break;
            	case 62 :
            	    // InternalOperationDsl.g:4361:3: kw= 'protocol'
            	    {
            	    kw=(Token)match(input,97,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolKeyword_61());
            	    		

            	    }
            	    break;
            	case 63 :
            	    // InternalOperationDsl.g:4367:3: kw= 'data_format'
            	    {
            	    kw=(Token)match(input,98,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getData_formatKeyword_62());
            	    		

            	    }
            	    break;
            	case 64 :
            	    // InternalOperationDsl.g:4373:3: kw= 'aspect'
            	    {
            	    kw=(Token)match(input,99,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectKeyword_63());
            	    		

            	    }
            	    break;
            	case 65 :
            	    // InternalOperationDsl.g:4379:3: kw= 'for'
            	    {
            	    kw=(Token)match(input,100,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getForKeyword_64());
            	    		

            	    }
            	    break;
            	case 66 :
            	    // InternalOperationDsl.g:4385:3: kw= 'containers'
            	    {
            	    kw=(Token)match(input,101,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContainersKeyword_65());
            	    		

            	    }
            	    break;
            	case 67 :
            	    // InternalOperationDsl.g:4391:3: (kw= 'selector' kw= 'datatypes' )
            	    {
            	    // InternalOperationDsl.g:4391:3: (kw= 'selector' kw= 'datatypes' )
            	    // InternalOperationDsl.g:4392:4: kw= 'selector' kw= 'datatypes'
            	    {
            	    kw=(Token)match(input,102,FOLLOW_86); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getSelectorKeyword_66_0());
            	    			
            	    kw=(Token)match(input,103,FOLLOW_85); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getDatatypesKeyword_66_1());
            	    			

            	    }


            	    }
            	    break;
            	case 68 :
            	    // InternalOperationDsl.g:4404:3: kw= 'version'
            	    {
            	    kw=(Token)match(input,47,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getVersionKeyword_67());
            	    		

            	    }
            	    break;
            	case 69 :
            	    // InternalOperationDsl.g:4410:3: kw= 'context'
            	    {
            	    kw=(Token)match(input,104,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContextKeyword_68());
            	    		

            	    }
            	    break;
            	case 70 :
            	    // InternalOperationDsl.g:4416:3: kw= 'aggregate'
            	    {
            	    kw=(Token)match(input,105,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAggregateKeyword_69());
            	    		

            	    }
            	    break;
            	case 71 :
            	    // InternalOperationDsl.g:4422:3: kw= 'applicationService'
            	    {
            	    kw=(Token)match(input,106,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getApplicationServiceKeyword_70());
            	    		

            	    }
            	    break;
            	case 72 :
            	    // InternalOperationDsl.g:4428:3: kw= 'domainEvent'
            	    {
            	    kw=(Token)match(input,107,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainEventKeyword_71());
            	    		

            	    }
            	    break;
            	case 73 :
            	    // InternalOperationDsl.g:4434:3: kw= 'domainService'
            	    {
            	    kw=(Token)match(input,108,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainServiceKeyword_72());
            	    		

            	    }
            	    break;
            	case 74 :
            	    // InternalOperationDsl.g:4440:3: kw= 'entity'
            	    {
            	    kw=(Token)match(input,109,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEntityKeyword_73());
            	    		

            	    }
            	    break;
            	case 75 :
            	    // InternalOperationDsl.g:4446:3: kw= 'factory'
            	    {
            	    kw=(Token)match(input,110,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFactoryKeyword_74());
            	    		

            	    }
            	    break;
            	case 76 :
            	    // InternalOperationDsl.g:4452:3: kw= 'infrastructureService'
            	    {
            	    kw=(Token)match(input,111,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureServiceKeyword_75());
            	    		

            	    }
            	    break;
            	case 77 :
            	    // InternalOperationDsl.g:4458:3: kw= 'repository'
            	    {
            	    kw=(Token)match(input,112,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRepositoryKeyword_76());
            	    		

            	    }
            	    break;
            	case 78 :
            	    // InternalOperationDsl.g:4464:3: kw= 'specification'
            	    {
            	    kw=(Token)match(input,113,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSpecificationKeyword_77());
            	    		

            	    }
            	    break;
            	case 79 :
            	    // InternalOperationDsl.g:4470:3: kw= 'valueObject'
            	    {
            	    kw=(Token)match(input,114,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValueObjectKeyword_78());
            	    		

            	    }
            	    break;
            	case 80 :
            	    // InternalOperationDsl.g:4476:3: kw= 'extends'
            	    {
            	    kw=(Token)match(input,115,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExtendsKeyword_79());
            	    		

            	    }
            	    break;
            	case 81 :
            	    // InternalOperationDsl.g:4482:3: kw= 'identifier'
            	    {
            	    kw=(Token)match(input,116,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIdentifierKeyword_80());
            	    		

            	    }
            	    break;
            	case 82 :
            	    // InternalOperationDsl.g:4488:3: kw= 'neverEmpty'
            	    {
            	    kw=(Token)match(input,117,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNeverEmptyKeyword_81());
            	    		

            	    }
            	    break;
            	case 83 :
            	    // InternalOperationDsl.g:4494:3: kw= 'part'
            	    {
            	    kw=(Token)match(input,118,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPartKeyword_82());
            	    		

            	    }
            	    break;
            	case 84 :
            	    // InternalOperationDsl.g:4500:3: kw= 'hide'
            	    {
            	    kw=(Token)match(input,119,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHideKeyword_83());
            	    		

            	    }
            	    break;
            	case 85 :
            	    // InternalOperationDsl.g:4506:3: kw= 'immutable'
            	    {
            	    kw=(Token)match(input,120,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImmutableKeyword_84());
            	    		

            	    }
            	    break;
            	case 86 :
            	    // InternalOperationDsl.g:4512:3: kw= 'enum'
            	    {
            	    kw=(Token)match(input,121,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnumKeyword_85());
            	    		

            	    }
            	    break;
            	case 87 :
            	    // InternalOperationDsl.g:4518:3: kw= 'closure'
            	    {
            	    kw=(Token)match(input,122,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getClosureKeyword_86());
            	    		

            	    }
            	    break;
            	case 88 :
            	    // InternalOperationDsl.g:4524:3: kw= 'sideEffectFree'
            	    {
            	    kw=(Token)match(input,123,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSideEffectFreeKeyword_87());
            	    		

            	    }
            	    break;
            	case 89 :
            	    // InternalOperationDsl.g:4530:3: kw= 'validator'
            	    {
            	    kw=(Token)match(input,124,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValidatorKeyword_88());
            	    		

            	    }
            	    break;
            	case 90 :
            	    // InternalOperationDsl.g:4536:3: kw= 'function'
            	    {
            	    kw=(Token)match(input,125,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionKeyword_89());
            	    		

            	    }
            	    break;
            	case 91 :
            	    // InternalOperationDsl.g:4542:3: kw= 'procedure'
            	    {
            	    kw=(Token)match(input,126,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProcedureKeyword_90());
            	    		

            	    }
            	    break;
            	case 92 :
            	    // InternalOperationDsl.g:4548:3: kw= 'boolean'
            	    {
            	    kw=(Token)match(input,127,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBooleanKeyword_91());
            	    		

            	    }
            	    break;
            	case 93 :
            	    // InternalOperationDsl.g:4554:3: kw= 'byte'
            	    {
            	    kw=(Token)match(input,128,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getByteKeyword_92());
            	    		

            	    }
            	    break;
            	case 94 :
            	    // InternalOperationDsl.g:4560:3: kw= 'char'
            	    {
            	    kw=(Token)match(input,129,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCharKeyword_93());
            	    		

            	    }
            	    break;
            	case 95 :
            	    // InternalOperationDsl.g:4566:3: kw= 'date'
            	    {
            	    kw=(Token)match(input,130,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDateKeyword_94());
            	    		

            	    }
            	    break;
            	case 96 :
            	    // InternalOperationDsl.g:4572:3: kw= 'double'
            	    {
            	    kw=(Token)match(input,131,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDoubleKeyword_95());
            	    		

            	    }
            	    break;
            	case 97 :
            	    // InternalOperationDsl.g:4578:3: kw= 'float'
            	    {
            	    kw=(Token)match(input,132,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFloatKeyword_96());
            	    		

            	    }
            	    break;
            	case 98 :
            	    // InternalOperationDsl.g:4584:3: kw= 'int'
            	    {
            	    kw=(Token)match(input,133,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIntKeyword_97());
            	    		

            	    }
            	    break;
            	case 99 :
            	    // InternalOperationDsl.g:4590:3: kw= 'long'
            	    {
            	    kw=(Token)match(input,134,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLongKeyword_98());
            	    		

            	    }
            	    break;
            	case 100 :
            	    // InternalOperationDsl.g:4596:3: kw= 'short'
            	    {
            	    kw=(Token)match(input,135,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getShortKeyword_99());
            	    		

            	    }
            	    break;
            	case 101 :
            	    // InternalOperationDsl.g:4602:3: kw= 'string'
            	    {
            	    kw=(Token)match(input,136,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStringKeyword_100());
            	    		

            	    }
            	    break;
            	case 102 :
            	    // InternalOperationDsl.g:4608:3: kw= 'internal'
            	    {
            	    kw=(Token)match(input,137,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInternalKeyword_101());
            	    		

            	    }
            	    break;
            	case 103 :
            	    // InternalOperationDsl.g:4614:3: kw= 'architecture'
            	    {
            	    kw=(Token)match(input,138,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getArchitectureKeyword_102());
            	    		

            	    }
            	    break;
            	case 104 :
            	    // InternalOperationDsl.g:4620:3: kw= 'public'
            	    {
            	    kw=(Token)match(input,139,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPublicKeyword_103());
            	    		

            	    }
            	    break;
            	case 105 :
            	    // InternalOperationDsl.g:4626:3: kw= 'endpoints'
            	    {
            	    kw=(Token)match(input,35,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEndpointsKeyword_104());
            	    		

            	    }
            	    break;
            	case 106 :
            	    // InternalOperationDsl.g:4632:3: kw= 'microservice'
            	    {
            	    kw=(Token)match(input,46,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroserviceKeyword_105());
            	    		

            	    }
            	    break;
            	case 107 :
            	    // InternalOperationDsl.g:4638:3: kw= 'required'
            	    {
            	    kw=(Token)match(input,48,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRequiredKeyword_106());
            	    		

            	    }
            	    break;
            	case 108 :
            	    // InternalOperationDsl.g:4644:3: kw= 'typedef'
            	    {
            	    kw=(Token)match(input,52,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypedefKeyword_107());
            	    		

            	    }
            	    break;
            	case 109 :
            	    // InternalOperationDsl.g:4650:3: kw= 'noimpl'
            	    {
            	    kw=(Token)match(input,53,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNoimplKeyword_108());
            	    		

            	    }
            	    break;
            	case 110 :
            	    // InternalOperationDsl.g:4656:3: kw= 'interface'
            	    {
            	    kw=(Token)match(input,54,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfaceKeyword_109());
            	    		

            	    }
            	    break;
            	case 111 :
            	    // InternalOperationDsl.g:4662:3: kw= 'param'
            	    {
            	    kw=(Token)match(input,140,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParamKeyword_110());
            	    		

            	    }
            	    break;
            	case 112 :
            	    // InternalOperationDsl.g:4668:3: kw= 'refers'
            	    {
            	    kw=(Token)match(input,58,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRefersKeyword_111());
            	    		

            	    }
            	    break;
            	case 113 :
            	    // InternalOperationDsl.g:4674:3: kw= 'fault'
            	    {
            	    kw=(Token)match(input,59,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFaultKeyword_112());
            	    		

            	    }
            	    break;
            	case 114 :
            	    // InternalOperationDsl.g:4680:3: kw= 'functional'
            	    {
            	    kw=(Token)match(input,141,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionalKeyword_113());
            	    		

            	    }
            	    break;
            	case 115 :
            	    // InternalOperationDsl.g:4686:3: kw= 'utility'
            	    {
            	    kw=(Token)match(input,142,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getUtilityKeyword_114());
            	    		

            	    }
            	    break;
            	case 116 :
            	    // InternalOperationDsl.g:4692:3: this_BOOLEAN_116= RULE_BOOLEAN
            	    {
            	    this_BOOLEAN_116=(Token)match(input,RULE_BOOLEAN,FOLLOW_85); 

            	    			current.merge(this_BOOLEAN_116);
            	    		

            	    			newLeafNode(this_BOOLEAN_116, grammarAccess.getAnythingAccess().getBOOLEANTerminalRuleCall_115());
            	    		

            	    }
            	    break;
            	case 117 :
            	    // InternalOperationDsl.g:4700:3: this_BIG_DECIMAL_117= RULE_BIG_DECIMAL
            	    {
            	    this_BIG_DECIMAL_117=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_85); 

            	    			current.merge(this_BIG_DECIMAL_117);
            	    		

            	    			newLeafNode(this_BIG_DECIMAL_117, grammarAccess.getAnythingAccess().getBIG_DECIMALTerminalRuleCall_116());
            	    		

            	    }
            	    break;
            	case 118 :
            	    // InternalOperationDsl.g:4708:3: this_ID_118= RULE_ID
            	    {
            	    this_ID_118=(Token)match(input,RULE_ID,FOLLOW_85); 

            	    			current.merge(this_ID_118);
            	    		

            	    			newLeafNode(this_ID_118, grammarAccess.getAnythingAccess().getIDTerminalRuleCall_117());
            	    		

            	    }
            	    break;
            	case 119 :
            	    // InternalOperationDsl.g:4716:3: this_STRING_119= RULE_STRING
            	    {
            	    this_STRING_119=(Token)match(input,RULE_STRING,FOLLOW_85); 

            	    			current.merge(this_STRING_119);
            	    		

            	    			newLeafNode(this_STRING_119, grammarAccess.getAnythingAccess().getSTRINGTerminalRuleCall_118());
            	    		

            	    }
            	    break;
            	case 120 :
            	    // InternalOperationDsl.g:4724:3: this_ANY_OTHER_120= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_120=(Token)match(input,RULE_ANY_OTHER,FOLLOW_85); 

            	    			current.merge(this_ANY_OTHER_120);
            	    		

            	    			newLeafNode(this_ANY_OTHER_120, grammarAccess.getAnythingAccess().getANY_OTHERTerminalRuleCall_119());
            	    		

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


            }


            	leaveRule();

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
    // InternalOperationDsl.g:4735:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalOperationDsl.g:4735:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalOperationDsl.g:4736:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalOperationDsl.g:4742:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:4748:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:4749:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:4749:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:4750:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:4762:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:4763:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:4763:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:4764:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_52); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getTechnologyImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:4784:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:4785:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:4785:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:4786:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:4806:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalOperationDsl.g:4806:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalOperationDsl.g:4807:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalOperationDsl.g:4813:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) ;
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
            // InternalOperationDsl.g:4819:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' ) )
            // InternalOperationDsl.g:4820:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            {
            // InternalOperationDsl.g:4820:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';' )
            // InternalOperationDsl.g:4821:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )? otherlv_11= ';'
            {
            // InternalOperationDsl.g:4821:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:4822:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:4822:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalOperationDsl.g:4823:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalOperationDsl.g:4840:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:4841:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:4841:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:4842:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_87); 

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

            otherlv_2=(Token)match(input,73,FOLLOW_88); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,74,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalOperationDsl.g:4866:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalOperationDsl.g:4867:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalOperationDsl.g:4867:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalOperationDsl.g:4868:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_89);
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

            // InternalOperationDsl.g:4885:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==23) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalOperationDsl.g:4886:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:4890:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalOperationDsl.g:4891:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalOperationDsl.g:4891:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalOperationDsl.g:4892:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_89);
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
            	    break loop107;
                }
            } while (true);

            // InternalOperationDsl.g:4910:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==32) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalOperationDsl.g:4911:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:4911:4: ( (lv_default_7_0= 'default' ) )
                    // InternalOperationDsl.g:4912:5: (lv_default_7_0= 'default' )
                    {
                    // InternalOperationDsl.g:4912:5: (lv_default_7_0= 'default' )
                    // InternalOperationDsl.g:4913:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,32,FOLLOW_90); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", true, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_91); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,75,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalOperationDsl.g:4933:4: ( (otherlv_10= RULE_ID ) )
                    // InternalOperationDsl.g:4934:5: (otherlv_10= RULE_ID )
                    {
                    // InternalOperationDsl.g:4934:5: (otherlv_10= RULE_ID )
                    // InternalOperationDsl.g:4935:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_49); 

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
    // InternalOperationDsl.g:4955:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalOperationDsl.g:4955:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalOperationDsl.g:4956:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalOperationDsl.g:4962:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_ID ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:4968:2: ( ( (lv_formatName_0_0= RULE_ID ) ) )
            // InternalOperationDsl.g:4969:2: ( (lv_formatName_0_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:4969:2: ( (lv_formatName_0_0= RULE_ID ) )
            // InternalOperationDsl.g:4970:3: (lv_formatName_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:4970:3: (lv_formatName_0_0= RULE_ID )
            // InternalOperationDsl.g:4971:4: lv_formatName_0_0= RULE_ID
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
    // InternalOperationDsl.g:4990:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalOperationDsl.g:4990:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalOperationDsl.g:4991:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalOperationDsl.g:4997:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:5003:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:5004:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:5004:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalOperationDsl.g:5005:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,82,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:5013:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:5014:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:5014:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:5015:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_93); 

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

            // InternalOperationDsl.g:5031:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==83) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalOperationDsl.g:5032:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,83,FOLLOW_17); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,25,FOLLOW_94); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalOperationDsl.g:5040:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:5041:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:5041:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalOperationDsl.g:5042:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_89);
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

                    // InternalOperationDsl.g:5059:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop109:
                    do {
                        int alt109=2;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==23) ) {
                            alt109=1;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5060:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_94); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalOperationDsl.g:5064:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalOperationDsl.g:5065:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalOperationDsl.g:5065:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalOperationDsl.g:5066:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_89);
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
                    	    break loop109;
                        }
                    } while (true);

                    // InternalOperationDsl.g:5084:4: ( (lv_default_8_0= 'default' ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==32) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // InternalOperationDsl.g:5085:5: (lv_default_8_0= 'default' )
                            {
                            // InternalOperationDsl.g:5085:5: (lv_default_8_0= 'default' )
                            // InternalOperationDsl.g:5086:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,32,FOLLOW_49); 

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
    // InternalOperationDsl.g:5107:1: entryRuleTechnologySpecificListType returns [EObject current=null] : iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF ;
    public final EObject entryRuleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificListType = null;


        try {
            // InternalOperationDsl.g:5107:67: (iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF )
            // InternalOperationDsl.g:5108:2: iv_ruleTechnologySpecificListType= ruleTechnologySpecificListType EOF
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
    // InternalOperationDsl.g:5114:1: ruleTechnologySpecificListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5120:2: ( (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:5121:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:5121:2: (otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:5122:3: otherlv_0= 'list' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0());
            		
            otherlv_1=(Token)match(input,82,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:5130:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:5131:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:5131:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:5132:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_49); 

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
    // InternalOperationDsl.g:5156:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalOperationDsl.g:5156:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalOperationDsl.g:5157:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalOperationDsl.g:5163:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5169:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:5170:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:5170:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:5171:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,82,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:5179:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:5180:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:5180:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:5181:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_49); 

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
    // InternalOperationDsl.g:5205:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalOperationDsl.g:5205:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalOperationDsl.g:5206:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalOperationDsl.g:5212:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5218:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:5219:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:5219:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:5220:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:5220:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_ID) ) {
                int LA112_1 = input.LA(2);

                if ( (LA112_1==36) ) {
                    alt112=1;
                }
            }
            switch (alt112) {
                case 1 :
                    // InternalOperationDsl.g:5221:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:5221:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:5222:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5222:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:5223:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:5239:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:5240:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:5240:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:5241:5: ruleQualifiedName
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
    // InternalOperationDsl.g:5259:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalOperationDsl.g:5259:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalOperationDsl.g:5260:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalOperationDsl.g:5266:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalOperationDsl.g:5272:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalOperationDsl.g:5273:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalOperationDsl.g:5273:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalOperationDsl.g:5274:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalOperationDsl.g:5274:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:5275:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:5275:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:5276:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
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

            // InternalOperationDsl.g:5293:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==23) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalOperationDsl.g:5294:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:5298:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalOperationDsl.g:5299:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalOperationDsl.g:5299:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalOperationDsl.g:5300:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
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
            	    break loop113;
                }
            } while (true);

            // InternalOperationDsl.g:5318:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalOperationDsl.g:5319:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalOperationDsl.g:5319:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalOperationDsl.g:5320:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalOperationDsl.g:5337:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:5338:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:5338:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:5339:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_49);
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
    // InternalOperationDsl.g:5364:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalOperationDsl.g:5364:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalOperationDsl.g:5365:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalOperationDsl.g:5371:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:5377:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:5378:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:5378:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:5379:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:5379:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:5380:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:5380:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:5381:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_1=(Token)match(input,29,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,89,FOLLOW_44); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:5413:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:5414:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:5414:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:5415:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:5432:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==23) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalOperationDsl.g:5433:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:5437:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:5438:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:5438:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:5439:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_97); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:5461:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==70) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalOperationDsl.g:5462:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,70,FOLLOW_98); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,90,FOLLOW_24); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,29,FOLLOW_94); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:5474:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt115=0;
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( ((LA115_0>=127 && LA115_0<=136)||LA115_0==143) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5475:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5475:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5476:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
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
                    	    if ( cnt115 >= 1 ) break loop115;
                                EarlyExitException eee =
                                    new EarlyExitException(115, input);
                                throw eee;
                        }
                        cnt115++;
                    } while (true);

                    otherlv_13=(Token)match(input,31,FOLLOW_30); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:5506:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalOperationDsl.g:5506:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalOperationDsl.g:5507:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalOperationDsl.g:5513:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:5519:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:5520:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:5520:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:5521:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:5521:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:5522:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:5522:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:5523:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_1=(Token)match(input,29,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,89,FOLLOW_44); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:5555:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:5556:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:5556:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:5557:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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
            						"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:5574:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==23) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // InternalOperationDsl.g:5575:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:5579:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:5580:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:5580:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:5581:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationEnvironment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop117;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_97); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:5603:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==70) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalOperationDsl.g:5604:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,70,FOLLOW_98); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,90,FOLLOW_24); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,29,FOLLOW_94); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:5616:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt118=0;
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( ((LA118_0>=127 && LA118_0<=136)||LA118_0==143) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5617:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5617:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5618:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
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
                    	    if ( cnt118 >= 1 ) break loop118;
                                EarlyExitException eee =
                                    new EarlyExitException(118, input);
                                throw eee;
                        }
                        cnt118++;
                    } while (true);

                    otherlv_13=(Token)match(input,31,FOLLOW_30); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:5648:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalOperationDsl.g:5648:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalOperationDsl.g:5649:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalOperationDsl.g:5655:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5661:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalOperationDsl.g:5662:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalOperationDsl.g:5662:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalOperationDsl.g:5663:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalOperationDsl.g:5663:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalOperationDsl.g:5664:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalOperationDsl.g:5664:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalOperationDsl.g:5665:5: lv_environmentName_0_0= RULE_STRING
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
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            // InternalOperationDsl.g:5681:3: ( (lv_default_1_0= 'default' ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==32) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalOperationDsl.g:5682:4: (lv_default_1_0= 'default' )
                    {
                    // InternalOperationDsl.g:5682:4: (lv_default_1_0= 'default' )
                    // InternalOperationDsl.g:5683:5: lv_default_1_0= 'default'
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
    // InternalOperationDsl.g:5699:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalOperationDsl.g:5699:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalOperationDsl.g:5700:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalOperationDsl.g:5706:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:5712:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:5713:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:5713:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalOperationDsl.g:5714:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalOperationDsl.g:5714:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalOperationDsl.g:5715:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalOperationDsl.g:5715:4: (lv_type_0_0= rulePrimitiveType )
            // InternalOperationDsl.g:5716:5: lv_type_0_0= rulePrimitiveType
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

            // InternalOperationDsl.g:5733:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5734:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5734:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5735:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:5751:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==42) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalOperationDsl.g:5752:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_45); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:5756:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:5757:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:5757:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:5758:6: lv_defaultValue_3_0= rulePrimitiveValue
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

            // InternalOperationDsl.g:5776:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==62) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalOperationDsl.g:5777:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,62,FOLLOW_103); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalOperationDsl.g:5781:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalOperationDsl.g:5782:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalOperationDsl.g:5782:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalOperationDsl.g:5783:6: lv_features_5_0= rulePropertyFeature
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

                    // InternalOperationDsl.g:5800:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop122:
                    do {
                        int alt122=2;
                        int LA122_0 = input.LA(1);

                        if ( (LA122_0==23) ) {
                            alt122=1;
                        }


                        switch (alt122) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5801:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_103); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalOperationDsl.g:5805:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalOperationDsl.g:5806:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalOperationDsl.g:5806:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalOperationDsl.g:5807:7: lv_features_7_0= rulePropertyFeature
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
                    	    break loop122;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,63,FOLLOW_49); 

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
    // InternalOperationDsl.g:5838:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalOperationDsl.g:5838:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalOperationDsl.g:5839:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalOperationDsl.g:5845:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) ;
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
            // InternalOperationDsl.g:5851:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) ) )
            // InternalOperationDsl.g:5852:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            {
            // InternalOperationDsl.g:5852:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) ) )
            int alt124=4;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt124=1;
                }
                break;
            case 96:
                {
                alt124=2;
                }
                break;
            case 97:
                {
                alt124=3;
                }
                break;
            case 98:
                {
                alt124=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalOperationDsl.g:5853:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalOperationDsl.g:5853:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalOperationDsl.g:5854:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalOperationDsl.g:5854:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalOperationDsl.g:5855:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalOperationDsl.g:5855:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalOperationDsl.g:5856:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,95,FOLLOW_44); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", true, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_105); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:5872:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalOperationDsl.g:5873:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:5873:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:5874:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalOperationDsl.g:5893:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalOperationDsl.g:5893:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalOperationDsl.g:5894:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalOperationDsl.g:5894:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalOperationDsl.g:5895:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalOperationDsl.g:5895:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalOperationDsl.g:5896:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,96,FOLLOW_44); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", true, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,42,FOLLOW_75); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalOperationDsl.g:5912:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalOperationDsl.g:5913:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalOperationDsl.g:5913:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalOperationDsl.g:5914:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalOperationDsl.g:5933:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:5933:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalOperationDsl.g:5934:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:5934:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalOperationDsl.g:5935:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalOperationDsl.g:5935:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalOperationDsl.g:5936:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,97,FOLLOW_44); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", true, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalOperationDsl.g:5952:4: ( (otherlv_8= RULE_ID ) )
                    // InternalOperationDsl.g:5953:5: (otherlv_8= RULE_ID )
                    {
                    // InternalOperationDsl.g:5953:5: (otherlv_8= RULE_ID )
                    // InternalOperationDsl.g:5954:6: otherlv_8= RULE_ID
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
                    // InternalOperationDsl.g:5967:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:5967:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) ) )
                    // InternalOperationDsl.g:5968:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:5968:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalOperationDsl.g:5969:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalOperationDsl.g:5969:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalOperationDsl.g:5970:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,98,FOLLOW_44); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", true, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalOperationDsl.g:5986:4: ( (otherlv_11= RULE_ID ) )
                    // InternalOperationDsl.g:5987:5: (otherlv_11= RULE_ID )
                    {
                    // InternalOperationDsl.g:5987:5: (otherlv_11= RULE_ID )
                    // InternalOperationDsl.g:5988:6: otherlv_11= RULE_ID
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
    // InternalOperationDsl.g:6004:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:6004:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalOperationDsl.g:6005:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:6011:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:6017:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:6018:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:6018:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:6019:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,102,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_106); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:6027:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalOperationDsl.g:6028:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalOperationDsl.g:6028:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalOperationDsl.g:6029:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_48);
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

            // InternalOperationDsl.g:6046:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==23) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // InternalOperationDsl.g:6047:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_106); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:6051:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalOperationDsl.g:6052:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:6052:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalOperationDsl.g:6053:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop125;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_49); 

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
    // InternalOperationDsl.g:6083:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalOperationDsl.g:6083:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalOperationDsl.g:6084:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalOperationDsl.g:6090:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalOperationDsl.g:6096:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalOperationDsl.g:6097:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalOperationDsl.g:6097:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalOperationDsl.g:6098:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,99,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:6102:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6103:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6103:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6104:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:6120:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==62) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalOperationDsl.g:6121:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_108); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:6125:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalOperationDsl.g:6126:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalOperationDsl.g:6126:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalOperationDsl.g:6127:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_104);
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

                    // InternalOperationDsl.g:6144:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==23) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6145:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_108); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6149:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalOperationDsl.g:6150:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalOperationDsl.g:6150:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalOperationDsl.g:6151:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop126;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,63,FOLLOW_109); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,100,FOLLOW_110); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceAspectAccess().getForKeyword_3());
            		
            // InternalOperationDsl.g:6178:3: ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) )
            // InternalOperationDsl.g:6179:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            {
            // InternalOperationDsl.g:6179:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            // InternalOperationDsl.g:6180:5: lv_joinPoints_8_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_111);
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

            // InternalOperationDsl.g:6197:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==23) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // InternalOperationDsl.g:6198:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,23,FOLLOW_110); 

            	    				newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:6202:4: ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    // InternalOperationDsl.g:6203:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    {
            	    // InternalOperationDsl.g:6203:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    // InternalOperationDsl.g:6204:6: lv_joinPoints_10_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_111);
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
            	    break loop128;
                }
            } while (true);

            // InternalOperationDsl.g:6222:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==29) ) {
                alt131=1;
            }
            else if ( (LA131_0==41) ) {
                alt131=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // InternalOperationDsl.g:6223:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalOperationDsl.g:6223:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalOperationDsl.g:6224:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,29,FOLLOW_112); 

                    					newLeafNode(otherlv_11, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalOperationDsl.g:6228:5: ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==102) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6229:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:6229:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    // InternalOperationDsl.g:6230:7: lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
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
                    	    break loop129;
                        }
                    } while (true);

                    // InternalOperationDsl.g:6247:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( ((LA130_0>=127 && LA130_0<=136)||LA130_0==143) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6248:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:6248:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:6249:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_99);
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
                    	    break loop130;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6272:4: otherlv_15= ';'
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
    // InternalOperationDsl.g:6281:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalOperationDsl.g:6281:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalOperationDsl.g:6282:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalOperationDsl.g:6288:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6294:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalOperationDsl.g:6295:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:6295:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalOperationDsl.g:6296:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalOperationDsl.g:6296:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalOperationDsl.g:6297:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalOperationDsl.g:6297:4: (lv_forTechnology_0_0= 'technology' )
            // InternalOperationDsl.g:6298:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,14,FOLLOW_44); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", true, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalOperationDsl.g:6314:3: ( (otherlv_2= RULE_ID ) )
            // InternalOperationDsl.g:6315:4: (otherlv_2= RULE_ID )
            {
            // InternalOperationDsl.g:6315:4: (otherlv_2= RULE_ID )
            // InternalOperationDsl.g:6316:5: otherlv_2= RULE_ID
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
    // InternalOperationDsl.g:6331:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:6331:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalOperationDsl.g:6332:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:6338:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:6344:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:6345:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:6345:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:6346:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,102,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:6354:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalOperationDsl.g:6355:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalOperationDsl.g:6355:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalOperationDsl.g:6356:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
            {

            					newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_48);
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

            // InternalOperationDsl.g:6373:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==23) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // InternalOperationDsl.g:6374:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:6378:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalOperationDsl.g:6379:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:6379:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalOperationDsl.g:6380:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop132;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_49); 

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
    // InternalOperationDsl.g:6410:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalOperationDsl.g:6410:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalOperationDsl.g:6411:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalOperationDsl.g:6417:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalOperationDsl.g:6423:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalOperationDsl.g:6424:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalOperationDsl.g:6424:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalOperationDsl.g:6425:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,99,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:6429:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6430:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6430:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6431:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:6447:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==62) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalOperationDsl.g:6448:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_108); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:6452:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalOperationDsl.g:6453:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalOperationDsl.g:6453:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalOperationDsl.g:6454:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_104);
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

                    // InternalOperationDsl.g:6471:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==23) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6472:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_108); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6476:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalOperationDsl.g:6477:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalOperationDsl.g:6477:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalOperationDsl.g:6478:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop133;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,63,FOLLOW_109); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,100,FOLLOW_113); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAspectAccess().getForKeyword_3());
            		
            // InternalOperationDsl.g:6505:3: ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) )
            // InternalOperationDsl.g:6506:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            {
            // InternalOperationDsl.g:6506:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            // InternalOperationDsl.g:6507:5: lv_joinPoints_8_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_111);
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

            // InternalOperationDsl.g:6524:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )*
            loop135:
            do {
                int alt135=2;
                int LA135_0 = input.LA(1);

                if ( (LA135_0==23) ) {
                    alt135=1;
                }


                switch (alt135) {
            	case 1 :
            	    // InternalOperationDsl.g:6525:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,23,FOLLOW_113); 

            	    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:6529:4: ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    // InternalOperationDsl.g:6530:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    {
            	    // InternalOperationDsl.g:6530:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    // InternalOperationDsl.g:6531:6: lv_joinPoints_10_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_111);
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
            	    break loop135;
                }
            } while (true);

            // InternalOperationDsl.g:6549:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==29) ) {
                alt138=1;
            }
            else if ( (LA138_0==41) ) {
                alt138=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // InternalOperationDsl.g:6550:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalOperationDsl.g:6550:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalOperationDsl.g:6551:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,29,FOLLOW_112); 

                    					newLeafNode(otherlv_11, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalOperationDsl.g:6555:5: ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==102) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6556:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:6556:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    // InternalOperationDsl.g:6557:7: lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPointcutSelectorsOperationAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_112);
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
                    	    break loop136;
                        }
                    } while (true);

                    // InternalOperationDsl.g:6574:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop137:
                    do {
                        int alt137=2;
                        int LA137_0 = input.LA(1);

                        if ( ((LA137_0>=127 && LA137_0<=136)||LA137_0==143) ) {
                            alt137=1;
                        }


                        switch (alt137) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6575:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:6575:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:6576:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_99);
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
                    	    break loop137;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6599:4: otherlv_15= ';'
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
    // InternalOperationDsl.g:6608:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalOperationDsl.g:6608:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalOperationDsl.g:6609:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalOperationDsl.g:6615:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:6621:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:6622:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:6622:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:6623:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_86); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,103,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:6635:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:6636:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:6636:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:6637:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_52); 

            					newLeafNode(lv_importURI_3_0, grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComplexTypeImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_3_0,
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:6657:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:6658:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:6658:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:6659:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:6679:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalOperationDsl.g:6679:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalOperationDsl.g:6680:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalOperationDsl.g:6686:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalOperationDsl.g:6692:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalOperationDsl.g:6693:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalOperationDsl.g:6693:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalOperationDsl.g:6694:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalOperationDsl.g:6698:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6699:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6699:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6700:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_2=(Token)match(input,29,FOLLOW_114); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:6720:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt141=3;
            int LA141_0 = input.LA(1);

            if ( ((LA141_0>=84 && LA141_0<=85)||LA141_0==121) ) {
                alt141=1;
            }
            else if ( (LA141_0==104) ) {
                alt141=2;
            }
            switch (alt141) {
                case 1 :
                    // InternalOperationDsl.g:6721:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalOperationDsl.g:6721:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt139=0;
                    loop139:
                    do {
                        int alt139=2;
                        int LA139_0 = input.LA(1);

                        if ( ((LA139_0>=84 && LA139_0<=85)||LA139_0==121) ) {
                            alt139=1;
                        }


                        switch (alt139) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6722:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalOperationDsl.g:6722:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalOperationDsl.g:6723:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_115);
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
                    	    if ( cnt139 >= 1 ) break loop139;
                                EarlyExitException eee =
                                    new EarlyExitException(139, input);
                                throw eee;
                        }
                        cnt139++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6741:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalOperationDsl.g:6741:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt140=0;
                    loop140:
                    do {
                        int alt140=2;
                        int LA140_0 = input.LA(1);

                        if ( (LA140_0==104) ) {
                            alt140=1;
                        }


                        switch (alt140) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6742:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalOperationDsl.g:6742:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalOperationDsl.g:6743:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_116);
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
                    	    if ( cnt140 >= 1 ) break loop140;
                                EarlyExitException eee =
                                    new EarlyExitException(140, input);
                                throw eee;
                        }
                        cnt140++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:6769:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalOperationDsl.g:6769:48: (iv_ruleContext= ruleContext EOF )
            // InternalOperationDsl.g:6770:2: iv_ruleContext= ruleContext EOF
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
    // InternalOperationDsl.g:6776:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:6782:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalOperationDsl.g:6783:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalOperationDsl.g:6783:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalOperationDsl.g:6784:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,104,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalOperationDsl.g:6788:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6789:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6789:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6790:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_2=(Token)match(input,29,FOLLOW_117); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:6810:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt142=0;
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( ((LA142_0>=84 && LA142_0<=85)||LA142_0==121) ) {
                    alt142=1;
                }


                switch (alt142) {
            	case 1 :
            	    // InternalOperationDsl.g:6811:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalOperationDsl.g:6811:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalOperationDsl.g:6812:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_115);
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
            	    if ( cnt142 >= 1 ) break loop142;
                        EarlyExitException eee =
                            new EarlyExitException(142, input);
                        throw eee;
                }
                cnt142++;
            } while (true);

            otherlv_4=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:6837:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalOperationDsl.g:6837:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalOperationDsl.g:6838:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalOperationDsl.g:6844:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:6850:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalOperationDsl.g:6851:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalOperationDsl.g:6851:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt143=3;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt143=1;
                }
                break;
            case 84:
                {
                alt143=2;
                }
                break;
            case 121:
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
                    // InternalOperationDsl.g:6852:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalOperationDsl.g:6861:3: this_ListType_1= ruleListType
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
                    // InternalOperationDsl.g:6870:3: this_Enumeration_2= ruleEnumeration
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
    // InternalOperationDsl.g:6882:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalOperationDsl.g:6882:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalOperationDsl.g:6883:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalOperationDsl.g:6889:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalOperationDsl.g:6895:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalOperationDsl.g:6896:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalOperationDsl.g:6896:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalOperationDsl.g:6897:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalOperationDsl.g:6901:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6902:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6902:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6903:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_118); 

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

            // InternalOperationDsl.g:6919:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==62) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalOperationDsl.g:6920:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_119); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:6924:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalOperationDsl.g:6925:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalOperationDsl.g:6925:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalOperationDsl.g:6926:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_104);
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

                    // InternalOperationDsl.g:6943:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop144:
                    do {
                        int alt144=2;
                        int LA144_0 = input.LA(1);

                        if ( (LA144_0==23) ) {
                            alt144=1;
                        }


                        switch (alt144) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6944:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_119); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6948:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalOperationDsl.g:6949:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalOperationDsl.g:6949:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalOperationDsl.g:6950:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop144;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,63,FOLLOW_120); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:6973:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==115) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalOperationDsl.g:6974:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,115,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalOperationDsl.g:6978:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:6979:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:6979:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:6980:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_24);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,29,FOLLOW_121); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOperationDsl.g:6999:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==RULE_ID||(LA150_0>=119 && LA150_0<=120)||(LA150_0>=125 && LA150_0<=136)||LA150_0==143) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalOperationDsl.g:7000:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalOperationDsl.g:7000:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt147=2;
                    switch ( input.LA(1) ) {
                    case 119:
                        {
                        int LA147_1 = input.LA(2);

                        if ( (LA147_1==RULE_ID||LA147_1==120||(LA147_1>=127 && LA147_1<=136)||LA147_1==143) ) {
                            alt147=1;
                        }
                        else if ( ((LA147_1>=125 && LA147_1<=126)) ) {
                            alt147=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 147, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 120:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                    case 136:
                    case 143:
                        {
                        alt147=1;
                        }
                        break;
                    case 125:
                    case 126:
                        {
                        alt147=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 147, 0, input);

                        throw nvae;
                    }

                    switch (alt147) {
                        case 1 :
                            // InternalOperationDsl.g:7001:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalOperationDsl.g:7001:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalOperationDsl.g:7002:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalOperationDsl.g:7002:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalOperationDsl.g:7003:7: lv_dataFields_10_0= ruleDataField
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0());
                            						
                            pushFollow(FOLLOW_59);
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
                            // InternalOperationDsl.g:7021:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalOperationDsl.g:7021:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalOperationDsl.g:7022:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalOperationDsl.g:7022:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalOperationDsl.g:7023:7: lv_operations_11_0= ruleDataOperation
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0());
                            						
                            pushFollow(FOLLOW_59);
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

                    // InternalOperationDsl.g:7041:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop149:
                    do {
                        int alt149=2;
                        int LA149_0 = input.LA(1);

                        if ( (LA149_0==23) ) {
                            alt149=1;
                        }


                        switch (alt149) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7042:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_122); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalOperationDsl.g:7046:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt148=2;
                    	    switch ( input.LA(1) ) {
                    	    case 119:
                    	        {
                    	        int LA148_1 = input.LA(2);

                    	        if ( ((LA148_1>=125 && LA148_1<=126)) ) {
                    	            alt148=2;
                    	        }
                    	        else if ( (LA148_1==RULE_ID||LA148_1==120||(LA148_1>=127 && LA148_1<=136)||LA148_1==143) ) {
                    	            alt148=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 148, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 120:
                    	    case 127:
                    	    case 128:
                    	    case 129:
                    	    case 130:
                    	    case 131:
                    	    case 132:
                    	    case 133:
                    	    case 134:
                    	    case 135:
                    	    case 136:
                    	    case 143:
                    	        {
                    	        alt148=1;
                    	        }
                    	        break;
                    	    case 125:
                    	    case 126:
                    	        {
                    	        alt148=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 148, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt148) {
                    	        case 1 :
                    	            // InternalOperationDsl.g:7047:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalOperationDsl.g:7047:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalOperationDsl.g:7048:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalOperationDsl.g:7048:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalOperationDsl.g:7049:8: lv_dataFields_13_0= ruleDataField
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_59);
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
                    	            // InternalOperationDsl.g:7067:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalOperationDsl.g:7067:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalOperationDsl.g:7068:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalOperationDsl.g:7068:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalOperationDsl.g:7069:8: lv_operations_14_0= ruleDataOperation
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_59);
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
                    	    break loop149;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:7097:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalOperationDsl.g:7097:49: (iv_ruleListType= ruleListType EOF )
            // InternalOperationDsl.g:7098:2: iv_ruleListType= ruleListType EOF
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
    // InternalOperationDsl.g:7104:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalOperationDsl.g:7110:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalOperationDsl.g:7111:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalOperationDsl.g:7111:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt152=2;
            alt152 = dfa152.predict(input);
            switch (alt152) {
                case 1 :
                    // InternalOperationDsl.g:7112:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalOperationDsl.g:7112:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalOperationDsl.g:7113:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,84,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalOperationDsl.g:7117:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalOperationDsl.g:7118:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:7118:5: (lv_name_1_0= RULE_ID )
                    // InternalOperationDsl.g:7119:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

                    otherlv_2=(Token)match(input,29,FOLLOW_123); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalOperationDsl.g:7139:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalOperationDsl.g:7140:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalOperationDsl.g:7140:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalOperationDsl.g:7141:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_59);
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

                    // InternalOperationDsl.g:7158:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop151:
                    do {
                        int alt151=2;
                        int LA151_0 = input.LA(1);

                        if ( (LA151_0==23) ) {
                            alt151=1;
                        }


                        switch (alt151) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7159:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_123); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalOperationDsl.g:7163:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalOperationDsl.g:7164:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalOperationDsl.g:7164:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalOperationDsl.g:7165:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_59);
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

                    otherlv_6=(Token)match(input,31,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7189:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalOperationDsl.g:7189:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalOperationDsl.g:7190:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,84,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalOperationDsl.g:7194:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalOperationDsl.g:7195:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:7195:5: (lv_name_8_0= RULE_ID )
                    // InternalOperationDsl.g:7196:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

                    otherlv_9=(Token)match(input,29,FOLLOW_94); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalOperationDsl.g:7216:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:7217:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:7217:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalOperationDsl.g:7218:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_30);
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

                    otherlv_11=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:7244:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalOperationDsl.g:7244:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalOperationDsl.g:7245:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalOperationDsl.g:7251:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
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
            // InternalOperationDsl.g:7257:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalOperationDsl.g:7258:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalOperationDsl.g:7258:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalOperationDsl.g:7259:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalOperationDsl.g:7259:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==119) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // InternalOperationDsl.g:7260:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:7260:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:7261:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,119,FOLLOW_124); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:7273:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==120) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // InternalOperationDsl.g:7274:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalOperationDsl.g:7274:4: (lv_immutable_1_0= 'immutable' )
                    // InternalOperationDsl.g:7275:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,120,FOLLOW_81); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", true, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:7287:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt155=4;
            int LA155_0 = input.LA(1);

            if ( ((LA155_0>=127 && LA155_0<=136)||LA155_0==143) ) {
                alt155=1;
            }
            else if ( (LA155_0==RULE_ID) ) {
                int LA155_2 = input.LA(2);

                if ( (LA155_2==36) ) {
                    alt155=3;
                }
                else if ( (LA155_2==RULE_ID||LA155_2==61) ) {
                    alt155=2;
                }
            }
            switch (alt155) {
                case 1 :
                    // InternalOperationDsl.g:7288:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:7288:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:7289:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:7289:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalOperationDsl.g:7290:6: lv_primitiveType_2_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:7308:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalOperationDsl.g:7308:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:7309:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:7309:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:7310:6: ruleQualifiedName
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
                    // InternalOperationDsl.g:7325:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:7325:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalOperationDsl.g:7326:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalOperationDsl.g:7326:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalOperationDsl.g:7327:6: lv_importedComplexType_4_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:7345:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:7346:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:7346:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:7347:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_125); 

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

            // InternalOperationDsl.g:7363:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==42) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalOperationDsl.g:7364:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,42,FOLLOW_45); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalOperationDsl.g:7368:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:7369:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:7369:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:7370:6: lv_initializationValue_7_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_126);
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

            // InternalOperationDsl.g:7388:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==62) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // InternalOperationDsl.g:7389:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,62,FOLLOW_127); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalOperationDsl.g:7393:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalOperationDsl.g:7394:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalOperationDsl.g:7394:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalOperationDsl.g:7395:6: lv_features_9_0= ruleDataFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_104);
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

                    // InternalOperationDsl.g:7412:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop157:
                    do {
                        int alt157=2;
                        int LA157_0 = input.LA(1);

                        if ( (LA157_0==23) ) {
                            alt157=1;
                        }


                        switch (alt157) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7413:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_127); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7417:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalOperationDsl.g:7418:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalOperationDsl.g:7418:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalOperationDsl.g:7419:7: lv_features_11_0= ruleDataFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop157;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,63,FOLLOW_2); 

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
    // InternalOperationDsl.g:7446:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalOperationDsl.g:7446:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalOperationDsl.g:7447:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalOperationDsl.g:7453:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) ;
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
            // InternalOperationDsl.g:7459:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) )
            // InternalOperationDsl.g:7460:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            {
            // InternalOperationDsl.g:7460:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            // InternalOperationDsl.g:7461:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,121,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalOperationDsl.g:7465:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:7466:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:7466:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:7467:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_128); 

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

            // InternalOperationDsl.g:7483:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==62) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalOperationDsl.g:7484:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_119); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:7488:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalOperationDsl.g:7489:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalOperationDsl.g:7489:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalOperationDsl.g:7490:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_104);
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

                    // InternalOperationDsl.g:7507:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop159:
                    do {
                        int alt159=2;
                        int LA159_0 = input.LA(1);

                        if ( (LA159_0==23) ) {
                            alt159=1;
                        }


                        switch (alt159) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7508:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_119); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7512:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalOperationDsl.g:7513:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalOperationDsl.g:7513:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalOperationDsl.g:7514:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop159;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,63,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:7541:3: ( (lv_fields_8_0= ruleEnumerationField ) )
            // InternalOperationDsl.g:7542:4: (lv_fields_8_0= ruleEnumerationField )
            {
            // InternalOperationDsl.g:7542:4: (lv_fields_8_0= ruleEnumerationField )
            // InternalOperationDsl.g:7543:5: lv_fields_8_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_59);
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

            // InternalOperationDsl.g:7560:3: (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )*
            loop161:
            do {
                int alt161=2;
                int LA161_0 = input.LA(1);

                if ( (LA161_0==23) ) {
                    alt161=1;
                }


                switch (alt161) {
            	case 1 :
            	    // InternalOperationDsl.g:7561:4: otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) )
            	    {
            	    otherlv_9=(Token)match(input,23,FOLLOW_7); 

            	    				newLeafNode(otherlv_9, grammarAccess.getEnumerationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:7565:4: ( (lv_fields_10_0= ruleEnumerationField ) )
            	    // InternalOperationDsl.g:7566:5: (lv_fields_10_0= ruleEnumerationField )
            	    {
            	    // InternalOperationDsl.g:7566:5: (lv_fields_10_0= ruleEnumerationField )
            	    // InternalOperationDsl.g:7567:6: lv_fields_10_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
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
            	    break loop161;
                }
            } while (true);

            otherlv_11=(Token)match(input,31,FOLLOW_2); 

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
    // InternalOperationDsl.g:7593:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalOperationDsl.g:7593:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalOperationDsl.g:7594:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalOperationDsl.g:7600:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:7606:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalOperationDsl.g:7607:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalOperationDsl.g:7607:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalOperationDsl.g:7608:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalOperationDsl.g:7608:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:7609:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:7609:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:7610:5: lv_name_0_0= RULE_ID
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

            // InternalOperationDsl.g:7626:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==15) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // InternalOperationDsl.g:7627:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_45); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalOperationDsl.g:7631:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:7632:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:7632:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:7633:6: lv_initializationValue_2_0= rulePrimitiveValue
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
    // InternalOperationDsl.g:7659:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalOperationDsl.g:7659:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalOperationDsl.g:7660:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalOperationDsl.g:7666:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalOperationDsl.g:7672:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalOperationDsl.g:7673:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalOperationDsl.g:7673:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalOperationDsl.g:7674:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalOperationDsl.g:7674:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==119) ) {
                alt163=1;
            }
            switch (alt163) {
                case 1 :
                    // InternalOperationDsl.g:7675:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:7675:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:7676:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,119,FOLLOW_129); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:7688:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==126) ) {
                alt165=1;
            }
            else if ( (LA165_0==125) ) {
                alt165=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 165, 0, input);

                throw nvae;
            }
            switch (alt165) {
                case 1 :
                    // InternalOperationDsl.g:7689:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalOperationDsl.g:7689:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalOperationDsl.g:7690:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalOperationDsl.g:7690:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalOperationDsl.g:7691:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,126,FOLLOW_7); 

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
                    // InternalOperationDsl.g:7704:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalOperationDsl.g:7704:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalOperationDsl.g:7705:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,125,FOLLOW_81); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalOperationDsl.g:7709:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt164=4;
                    int LA164_0 = input.LA(1);

                    if ( ((LA164_0>=127 && LA164_0<=136)||LA164_0==143) ) {
                        alt164=1;
                    }
                    else if ( (LA164_0==RULE_ID) ) {
                        int LA164_2 = input.LA(2);

                        if ( (LA164_2==RULE_ID||LA164_2==61) ) {
                            alt164=2;
                        }
                        else if ( (LA164_2==36) ) {
                            alt164=3;
                        }
                    }
                    switch (alt164) {
                        case 1 :
                            // InternalOperationDsl.g:7710:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalOperationDsl.g:7710:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalOperationDsl.g:7711:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalOperationDsl.g:7711:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalOperationDsl.g:7712:8: lv_primitiveReturnType_3_0= rulePrimitiveType
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
                            // InternalOperationDsl.g:7730:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalOperationDsl.g:7730:6: ( ( ruleQualifiedName ) )
                            // InternalOperationDsl.g:7731:7: ( ruleQualifiedName )
                            {
                            // InternalOperationDsl.g:7731:7: ( ruleQualifiedName )
                            // InternalOperationDsl.g:7732:8: ruleQualifiedName
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
                            // InternalOperationDsl.g:7747:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalOperationDsl.g:7747:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalOperationDsl.g:7748:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalOperationDsl.g:7748:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalOperationDsl.g:7749:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:7769:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalOperationDsl.g:7770:4: (lv_name_6_0= RULE_ID )
            {
            // InternalOperationDsl.g:7770:4: (lv_name_6_0= RULE_ID )
            // InternalOperationDsl.g:7771:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_130); 

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

            // InternalOperationDsl.g:7787:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==15) ) {
                alt168=1;
            }
            switch (alt168) {
                case 1 :
                    // InternalOperationDsl.g:7788:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_131); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:7792:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt166=2;
                    int LA166_0 = input.LA(1);

                    if ( (LA166_0==RULE_ID||(LA166_0>=127 && LA166_0<=136)||LA166_0==143) ) {
                        alt166=1;
                    }
                    switch (alt166) {
                        case 1 :
                            // InternalOperationDsl.g:7793:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalOperationDsl.g:7793:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalOperationDsl.g:7794:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_48);
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

                    // InternalOperationDsl.g:7811:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop167:
                    do {
                        int alt167=2;
                        int LA167_0 = input.LA(1);

                        if ( (LA167_0==23) ) {
                            alt167=1;
                        }


                        switch (alt167) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7812:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_81); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7816:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalOperationDsl.g:7817:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalOperationDsl.g:7817:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalOperationDsl.g:7818:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_48);
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
                    	    break loop167;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_126); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:7841:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==62) ) {
                alt170=1;
            }
            switch (alt170) {
                case 1 :
                    // InternalOperationDsl.g:7842:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,62,FOLLOW_132); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalOperationDsl.g:7846:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalOperationDsl.g:7847:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalOperationDsl.g:7847:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalOperationDsl.g:7848:6: lv_features_13_0= ruleDataOperationFeature
                    {

                    						newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_104);
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

                    // InternalOperationDsl.g:7865:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop169:
                    do {
                        int alt169=2;
                        int LA169_0 = input.LA(1);

                        if ( (LA169_0==23) ) {
                            alt169=1;
                        }


                        switch (alt169) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7866:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,23,FOLLOW_132); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7870:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalOperationDsl.g:7871:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalOperationDsl.g:7871:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalOperationDsl.g:7872:7: lv_features_15_0= ruleDataOperationFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_104);
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
                    	    break loop169;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,63,FOLLOW_2); 

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
    // InternalOperationDsl.g:7899:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalOperationDsl.g:7899:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalOperationDsl.g:7900:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalOperationDsl.g:7906:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:7912:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:7913:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:7913:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalOperationDsl.g:7914:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:7914:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt171=3;
            int LA171_0 = input.LA(1);

            if ( ((LA171_0>=127 && LA171_0<=136)||LA171_0==143) ) {
                alt171=1;
            }
            else if ( (LA171_0==RULE_ID) ) {
                int LA171_2 = input.LA(2);

                if ( (LA171_2==RULE_ID||LA171_2==61) ) {
                    alt171=2;
                }
                else if ( (LA171_2==36) ) {
                    alt171=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 171, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 171, 0, input);

                throw nvae;
            }
            switch (alt171) {
                case 1 :
                    // InternalOperationDsl.g:7915:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:7915:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:7916:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:7916:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalOperationDsl.g:7917:6: lv_primitiveType_0_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:7935:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalOperationDsl.g:7935:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:7936:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:7936:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:7937:6: ruleQualifiedName
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
                    // InternalOperationDsl.g:7952:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:7952:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalOperationDsl.g:7953:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalOperationDsl.g:7953:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalOperationDsl.g:7954:6: lv_importedComplexType_2_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:7972:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOperationDsl.g:7973:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOperationDsl.g:7973:4: (lv_name_3_0= RULE_ID )
            // InternalOperationDsl.g:7974:5: lv_name_3_0= RULE_ID
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
    // InternalOperationDsl.g:7994:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalOperationDsl.g:7994:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalOperationDsl.g:7995:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalOperationDsl.g:8001:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8007:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalOperationDsl.g:8008:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalOperationDsl.g:8008:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt172=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt172=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt172=2;
                }
                break;
            case RULE_STRING:
                {
                alt172=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 172, 0, input);

                throw nvae;
            }

            switch (alt172) {
                case 1 :
                    // InternalOperationDsl.g:8009:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalOperationDsl.g:8009:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalOperationDsl.g:8010:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalOperationDsl.g:8010:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalOperationDsl.g:8011:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalOperationDsl.g:8028:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalOperationDsl.g:8028:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:8029:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:8029:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:8030:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalOperationDsl.g:8047:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalOperationDsl.g:8047:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalOperationDsl.g:8048:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalOperationDsl.g:8048:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalOperationDsl.g:8049:5: lv_stringValue_2_0= RULE_STRING
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
                    						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
                    				

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
    // InternalOperationDsl.g:8069:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalOperationDsl.g:8069:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalOperationDsl.g:8070:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalOperationDsl.g:8076:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8082:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:8083:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:8083:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:8084:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:8084:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:8085:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:8085:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:8086:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:8101:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:8102:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:8102:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:8103:5: ruleQualifiedName
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
    // InternalOperationDsl.g:8121:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalOperationDsl.g:8121:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalOperationDsl.g:8122:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalOperationDsl.g:8128:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
            // InternalOperationDsl.g:8134:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalOperationDsl.g:8135:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalOperationDsl.g:8135:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt173=11;
            switch ( input.LA(1) ) {
            case 127:
                {
                alt173=1;
                }
                break;
            case 128:
                {
                alt173=2;
                }
                break;
            case 129:
                {
                alt173=3;
                }
                break;
            case 130:
                {
                alt173=4;
                }
                break;
            case 131:
                {
                alt173=5;
                }
                break;
            case 132:
                {
                alt173=6;
                }
                break;
            case 133:
                {
                alt173=7;
                }
                break;
            case 134:
                {
                alt173=8;
                }
                break;
            case 135:
                {
                alt173=9;
                }
                break;
            case 136:
                {
                alt173=10;
                }
                break;
            case 143:
                {
                alt173=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 173, 0, input);

                throw nvae;
            }

            switch (alt173) {
                case 1 :
                    // InternalOperationDsl.g:8136:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalOperationDsl.g:8136:3: ( () otherlv_1= 'boolean' )
                    // InternalOperationDsl.g:8137:4: () otherlv_1= 'boolean'
                    {
                    // InternalOperationDsl.g:8137:4: ()
                    // InternalOperationDsl.g:8138:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,127,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8150:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalOperationDsl.g:8150:3: ( () otherlv_3= 'byte' )
                    // InternalOperationDsl.g:8151:4: () otherlv_3= 'byte'
                    {
                    // InternalOperationDsl.g:8151:4: ()
                    // InternalOperationDsl.g:8152:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,128,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8164:3: ( () otherlv_5= 'char' )
                    {
                    // InternalOperationDsl.g:8164:3: ( () otherlv_5= 'char' )
                    // InternalOperationDsl.g:8165:4: () otherlv_5= 'char'
                    {
                    // InternalOperationDsl.g:8165:4: ()
                    // InternalOperationDsl.g:8166:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,129,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8178:3: ( () otherlv_7= 'date' )
                    {
                    // InternalOperationDsl.g:8178:3: ( () otherlv_7= 'date' )
                    // InternalOperationDsl.g:8179:4: () otherlv_7= 'date'
                    {
                    // InternalOperationDsl.g:8179:4: ()
                    // InternalOperationDsl.g:8180:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,130,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:8192:3: ( () otherlv_9= 'double' )
                    {
                    // InternalOperationDsl.g:8192:3: ( () otherlv_9= 'double' )
                    // InternalOperationDsl.g:8193:4: () otherlv_9= 'double'
                    {
                    // InternalOperationDsl.g:8193:4: ()
                    // InternalOperationDsl.g:8194:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,131,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:8206:3: ( () otherlv_11= 'float' )
                    {
                    // InternalOperationDsl.g:8206:3: ( () otherlv_11= 'float' )
                    // InternalOperationDsl.g:8207:4: () otherlv_11= 'float'
                    {
                    // InternalOperationDsl.g:8207:4: ()
                    // InternalOperationDsl.g:8208:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,132,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:8220:3: ( () otherlv_13= 'int' )
                    {
                    // InternalOperationDsl.g:8220:3: ( () otherlv_13= 'int' )
                    // InternalOperationDsl.g:8221:4: () otherlv_13= 'int'
                    {
                    // InternalOperationDsl.g:8221:4: ()
                    // InternalOperationDsl.g:8222:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,133,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:8234:3: ( () otherlv_15= 'long' )
                    {
                    // InternalOperationDsl.g:8234:3: ( () otherlv_15= 'long' )
                    // InternalOperationDsl.g:8235:4: () otherlv_15= 'long'
                    {
                    // InternalOperationDsl.g:8235:4: ()
                    // InternalOperationDsl.g:8236:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,134,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:8248:3: ( () otherlv_17= 'short' )
                    {
                    // InternalOperationDsl.g:8248:3: ( () otherlv_17= 'short' )
                    // InternalOperationDsl.g:8249:4: () otherlv_17= 'short'
                    {
                    // InternalOperationDsl.g:8249:4: ()
                    // InternalOperationDsl.g:8250:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,135,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:8262:3: ( () otherlv_19= 'string' )
                    {
                    // InternalOperationDsl.g:8262:3: ( () otherlv_19= 'string' )
                    // InternalOperationDsl.g:8263:4: () otherlv_19= 'string'
                    {
                    // InternalOperationDsl.g:8263:4: ()
                    // InternalOperationDsl.g:8264:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,136,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalOperationDsl.g:8276:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalOperationDsl.g:8276:3: ( () otherlv_21= 'unspecified' )
                    // InternalOperationDsl.g:8277:4: () otherlv_21= 'unspecified'
                    {
                    // InternalOperationDsl.g:8277:4: ()
                    // InternalOperationDsl.g:8278:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0(),
                    						current);
                    				

                    }

                    otherlv_21=(Token)match(input,143,FOLLOW_2); 

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
    // InternalOperationDsl.g:8293:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOperationDsl.g:8293:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOperationDsl.g:8294:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalOperationDsl.g:8300:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8306:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOperationDsl.g:8307:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOperationDsl.g:8307:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOperationDsl.g:8308:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_133); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOperationDsl.g:8315:3: (kw= '.' this_ID_2= RULE_ID )*
            loop174:
            do {
                int alt174=2;
                int LA174_0 = input.LA(1);

                if ( (LA174_0==61) ) {
                    alt174=1;
                }


                switch (alt174) {
            	case 1 :
            	    // InternalOperationDsl.g:8316:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,61,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_133); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop174;
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
    // InternalOperationDsl.g:8333:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8339:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) ) )
            // InternalOperationDsl.g:8340:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) )
            {
            // InternalOperationDsl.g:8340:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) )
            int alt175=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt175=1;
                }
                break;
            case 49:
                {
                alt175=2;
                }
                break;
            case 26:
                {
                alt175=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 175, 0, input);

                throw nvae;
            }

            switch (alt175) {
                case 1 :
                    // InternalOperationDsl.g:8341:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalOperationDsl.g:8341:3: (enumLiteral_0= 'technology' )
                    // InternalOperationDsl.g:8342:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,14,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8349:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalOperationDsl.g:8349:3: (enumLiteral_1= 'microservices' )
                    // InternalOperationDsl.g:8350:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8357:3: (enumLiteral_2= 'nodes' )
                    {
                    // InternalOperationDsl.g:8357:3: (enumLiteral_2= 'nodes' )
                    // InternalOperationDsl.g:8358:4: enumLiteral_2= 'nodes'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getOPERATION_NODESEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImportTypeAccess().getOPERATION_NODESEnumLiteralDeclaration_2());
                    			

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
    // InternalOperationDsl.g:8368:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8374:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalOperationDsl.g:8375:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalOperationDsl.g:8375:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt176=3;
            switch ( input.LA(1) ) {
            case 137:
                {
                alt176=1;
                }
                break;
            case 138:
                {
                alt176=2;
                }
                break;
            case 139:
                {
                alt176=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 176, 0, input);

                throw nvae;
            }

            switch (alt176) {
                case 1 :
                    // InternalOperationDsl.g:8376:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalOperationDsl.g:8376:3: (enumLiteral_0= 'internal' )
                    // InternalOperationDsl.g:8377:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,137,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8384:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalOperationDsl.g:8384:3: (enumLiteral_1= 'architecture' )
                    // InternalOperationDsl.g:8385:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8392:3: (enumLiteral_2= 'public' )
                    {
                    // InternalOperationDsl.g:8392:3: (enumLiteral_2= 'public' )
                    // InternalOperationDsl.g:8393:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,139,FOLLOW_2); 

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
    // InternalOperationDsl.g:8403:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8409:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalOperationDsl.g:8410:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:8410:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt177=3;
            switch ( input.LA(1) ) {
            case 141:
                {
                alt177=1;
                }
                break;
            case 142:
                {
                alt177=2;
                }
                break;
            case 72:
                {
                alt177=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 177, 0, input);

                throw nvae;
            }

            switch (alt177) {
                case 1 :
                    // InternalOperationDsl.g:8411:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalOperationDsl.g:8411:3: (enumLiteral_0= 'functional' )
                    // InternalOperationDsl.g:8412:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,141,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8419:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalOperationDsl.g:8419:3: (enumLiteral_1= 'utility' )
                    // InternalOperationDsl.g:8420:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,142,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8427:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:8427:3: (enumLiteral_2= 'infrastructure' )
                    // InternalOperationDsl.g:8428:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_2); 

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
    // InternalOperationDsl.g:8438:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8444:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalOperationDsl.g:8445:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalOperationDsl.g:8445:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt178=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt178=1;
                }
                break;
            case 77:
                {
                alt178=2;
                }
                break;
            case 78:
                {
                alt178=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 178, 0, input);

                throw nvae;
            }

            switch (alt178) {
                case 1 :
                    // InternalOperationDsl.g:8446:3: (enumLiteral_0= 'in' )
                    {
                    // InternalOperationDsl.g:8446:3: (enumLiteral_0= 'in' )
                    // InternalOperationDsl.g:8447:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8454:3: (enumLiteral_1= 'out' )
                    {
                    // InternalOperationDsl.g:8454:3: (enumLiteral_1= 'out' )
                    // InternalOperationDsl.g:8455:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8462:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalOperationDsl.g:8462:3: (enumLiteral_2= 'inout' )
                    // InternalOperationDsl.g:8463:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_2); 

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
    // InternalOperationDsl.g:8473:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8479:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalOperationDsl.g:8480:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalOperationDsl.g:8480:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt179=2;
            int LA179_0 = input.LA(1);

            if ( (LA179_0==79) ) {
                alt179=1;
            }
            else if ( (LA179_0==80) ) {
                alt179=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 179, 0, input);

                throw nvae;
            }
            switch (alt179) {
                case 1 :
                    // InternalOperationDsl.g:8481:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalOperationDsl.g:8481:3: (enumLiteral_0= 'sync' )
                    // InternalOperationDsl.g:8482:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8489:3: (enumLiteral_1= 'async' )
                    {
                    // InternalOperationDsl.g:8489:3: (enumLiteral_1= 'async' )
                    // InternalOperationDsl.g:8490:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); 

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
    // InternalOperationDsl.g:8500:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8506:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalOperationDsl.g:8507:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalOperationDsl.g:8507:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt180=3;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt180=1;
                }
                break;
            case 86:
                {
                alt180=2;
                }
                break;
            case 88:
                {
                alt180=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 180, 0, input);

                throw nvae;
            }

            switch (alt180) {
                case 1 :
                    // InternalOperationDsl.g:8508:3: (enumLiteral_0= '<-' )
                    {
                    // InternalOperationDsl.g:8508:3: (enumLiteral_0= '<-' )
                    // InternalOperationDsl.g:8509:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8516:3: (enumLiteral_1= '->' )
                    {
                    // InternalOperationDsl.g:8516:3: (enumLiteral_1= '->' )
                    // InternalOperationDsl.g:8517:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8524:3: (enumLiteral_2= '<->' )
                    {
                    // InternalOperationDsl.g:8524:3: (enumLiteral_2= '<->' )
                    // InternalOperationDsl.g:8525:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,88,FOLLOW_2); 

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
    // InternalOperationDsl.g:8535:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8541:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalOperationDsl.g:8542:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalOperationDsl.g:8542:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt181=2;
            int LA181_0 = input.LA(1);

            if ( (LA181_0==91) ) {
                alt181=1;
            }
            else if ( (LA181_0==92) ) {
                alt181=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 181, 0, input);

                throw nvae;
            }
            switch (alt181) {
                case 1 :
                    // InternalOperationDsl.g:8543:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalOperationDsl.g:8543:3: (enumLiteral_0= 'mandatory' )
                    // InternalOperationDsl.g:8544:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8551:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalOperationDsl.g:8551:3: (enumLiteral_1= 'singleval' )
                    // InternalOperationDsl.g:8552:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

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
    // InternalOperationDsl.g:8562:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) ;
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
            // InternalOperationDsl.g:8568:2: ( ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) )
            // InternalOperationDsl.g:8569:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            {
            // InternalOperationDsl.g:8569:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            int alt182=8;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt182=1;
                }
                break;
            case 94:
                {
                alt182=2;
                }
                break;
            case 144:
                {
                alt182=3;
                }
                break;
            case 145:
                {
                alt182=4;
                }
                break;
            case 49:
                {
                alt182=5;
                }
                break;
            case 50:
                {
                alt182=6;
                }
                break;
            case 51:
                {
                alt182=7;
                }
                break;
            case 93:
                {
                alt182=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 182, 0, input);

                throw nvae;
            }

            switch (alt182) {
                case 1 :
                    // InternalOperationDsl.g:8570:3: (enumLiteral_0= 'types' )
                    {
                    // InternalOperationDsl.g:8570:3: (enumLiteral_0= 'types' )
                    // InternalOperationDsl.g:8571:4: enumLiteral_0= 'types'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8578:3: (enumLiteral_1= 'fields' )
                    {
                    // InternalOperationDsl.g:8578:3: (enumLiteral_1= 'fields' )
                    // InternalOperationDsl.g:8579:4: enumLiteral_1= 'fields'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8586:3: (enumLiteral_2= 'domainOperations' )
                    {
                    // InternalOperationDsl.g:8586:3: (enumLiteral_2= 'domainOperations' )
                    // InternalOperationDsl.g:8587:4: enumLiteral_2= 'domainOperations'
                    {
                    enumLiteral_2=(Token)match(input,144,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8594:3: (enumLiteral_3= 'domainParameters' )
                    {
                    // InternalOperationDsl.g:8594:3: (enumLiteral_3= 'domainParameters' )
                    // InternalOperationDsl.g:8595:4: enumLiteral_3= 'domainParameters'
                    {
                    enumLiteral_3=(Token)match(input,145,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:8602:3: (enumLiteral_4= 'microservices' )
                    {
                    // InternalOperationDsl.g:8602:3: (enumLiteral_4= 'microservices' )
                    // InternalOperationDsl.g:8603:4: enumLiteral_4= 'microservices'
                    {
                    enumLiteral_4=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:8610:3: (enumLiteral_5= 'interfaces' )
                    {
                    // InternalOperationDsl.g:8610:3: (enumLiteral_5= 'interfaces' )
                    // InternalOperationDsl.g:8611:4: enumLiteral_5= 'interfaces'
                    {
                    enumLiteral_5=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:8618:3: (enumLiteral_6= 'operations' )
                    {
                    // InternalOperationDsl.g:8618:3: (enumLiteral_6= 'operations' )
                    // InternalOperationDsl.g:8619:4: enumLiteral_6= 'operations'
                    {
                    enumLiteral_6=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:8626:3: (enumLiteral_7= 'parameters' )
                    {
                    // InternalOperationDsl.g:8626:3: (enumLiteral_7= 'parameters' )
                    // InternalOperationDsl.g:8627:4: enumLiteral_7= 'parameters'
                    {
                    enumLiteral_7=(Token)match(input,93,FOLLOW_2); 

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
    // InternalOperationDsl.g:8637:1: ruleAspectFeature returns [Enumerator current=null] : (enumLiteral_0= 'singleval' ) ;
    public final Enumerator ruleAspectFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8643:2: ( (enumLiteral_0= 'singleval' ) )
            // InternalOperationDsl.g:8644:2: (enumLiteral_0= 'singleval' )
            {
            // InternalOperationDsl.g:8644:2: (enumLiteral_0= 'singleval' )
            // InternalOperationDsl.g:8645:3: enumLiteral_0= 'singleval'
            {
            enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

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
    // InternalOperationDsl.g:8654:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8660:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalOperationDsl.g:8661:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:8661:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt183=2;
            int LA183_0 = input.LA(1);

            if ( (LA183_0==101) ) {
                alt183=1;
            }
            else if ( (LA183_0==72) ) {
                alt183=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 183, 0, input);

                throw nvae;
            }
            switch (alt183) {
                case 1 :
                    // InternalOperationDsl.g:8662:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalOperationDsl.g:8662:3: (enumLiteral_0= 'containers' )
                    // InternalOperationDsl.g:8663:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8670:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:8670:3: (enumLiteral_1= 'infrastructure' )
                    // InternalOperationDsl.g:8671:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); 

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
    // InternalOperationDsl.g:8681:1: ruleComplexTypeFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
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
            // InternalOperationDsl.g:8687:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalOperationDsl.g:8688:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalOperationDsl.g:8688:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt184=11;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt184=1;
                }
                break;
            case 106:
                {
                alt184=2;
                }
                break;
            case 107:
                {
                alt184=3;
                }
                break;
            case 108:
                {
                alt184=4;
                }
                break;
            case 109:
                {
                alt184=5;
                }
                break;
            case 110:
                {
                alt184=6;
                }
                break;
            case 111:
                {
                alt184=7;
                }
                break;
            case 112:
                {
                alt184=8;
                }
                break;
            case 70:
                {
                alt184=9;
                }
                break;
            case 113:
                {
                alt184=10;
                }
                break;
            case 114:
                {
                alt184=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 184, 0, input);

                throw nvae;
            }

            switch (alt184) {
                case 1 :
                    // InternalOperationDsl.g:8689:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalOperationDsl.g:8689:3: (enumLiteral_0= 'aggregate' )
                    // InternalOperationDsl.g:8690:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8697:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalOperationDsl.g:8697:3: (enumLiteral_1= 'applicationService' )
                    // InternalOperationDsl.g:8698:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8705:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalOperationDsl.g:8705:3: (enumLiteral_2= 'domainEvent' )
                    // InternalOperationDsl.g:8706:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8713:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalOperationDsl.g:8713:3: (enumLiteral_3= 'domainService' )
                    // InternalOperationDsl.g:8714:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:8721:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalOperationDsl.g:8721:3: (enumLiteral_4= 'entity' )
                    // InternalOperationDsl.g:8722:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:8729:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalOperationDsl.g:8729:3: (enumLiteral_5= 'factory' )
                    // InternalOperationDsl.g:8730:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:8737:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalOperationDsl.g:8737:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalOperationDsl.g:8738:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:8745:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalOperationDsl.g:8745:3: (enumLiteral_7= 'repository' )
                    // InternalOperationDsl.g:8746:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:8753:3: (enumLiteral_8= 'service' )
                    {
                    // InternalOperationDsl.g:8753:3: (enumLiteral_8= 'service' )
                    // InternalOperationDsl.g:8754:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:8761:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalOperationDsl.g:8761:3: (enumLiteral_9= 'specification' )
                    // InternalOperationDsl.g:8762:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalOperationDsl.g:8769:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalOperationDsl.g:8769:3: (enumLiteral_10= 'valueObject' )
                    // InternalOperationDsl.g:8770:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,114,FOLLOW_2); 

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
    // InternalOperationDsl.g:8780:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8786:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalOperationDsl.g:8787:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalOperationDsl.g:8787:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt185=3;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt185=1;
                }
                break;
            case 117:
                {
                alt185=2;
                }
                break;
            case 118:
                {
                alt185=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 185, 0, input);

                throw nvae;
            }

            switch (alt185) {
                case 1 :
                    // InternalOperationDsl.g:8788:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalOperationDsl.g:8788:3: (enumLiteral_0= 'identifier' )
                    // InternalOperationDsl.g:8789:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8796:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalOperationDsl.g:8796:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalOperationDsl.g:8797:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8804:3: (enumLiteral_2= 'part' )
                    {
                    // InternalOperationDsl.g:8804:3: (enumLiteral_2= 'part' )
                    // InternalOperationDsl.g:8805:4: enumLiteral_2= 'part'
                    {
                    enumLiteral_2=(Token)match(input,118,FOLLOW_2); 

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
    // InternalOperationDsl.g:8815:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8821:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalOperationDsl.g:8822:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalOperationDsl.g:8822:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt186=4;
            switch ( input.LA(1) ) {
            case 122:
                {
                alt186=1;
                }
                break;
            case 116:
                {
                alt186=2;
                }
                break;
            case 123:
                {
                alt186=3;
                }
                break;
            case 124:
                {
                alt186=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 186, 0, input);

                throw nvae;
            }

            switch (alt186) {
                case 1 :
                    // InternalOperationDsl.g:8823:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalOperationDsl.g:8823:3: (enumLiteral_0= 'closure' )
                    // InternalOperationDsl.g:8824:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8831:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalOperationDsl.g:8831:3: (enumLiteral_1= 'identifier' )
                    // InternalOperationDsl.g:8832:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8839:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalOperationDsl.g:8839:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalOperationDsl.g:8840:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8847:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalOperationDsl.g:8847:3: (enumLiteral_3= 'validator' )
                    // InternalOperationDsl.g:8848:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,124,FOLLOW_2); 

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
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA152 dfa152 = new DFA152(this);
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
    static final String dfa_10s = "\1\42\1\52\1\uffff\2\7\3\20\4\42\2\uffff";
    static final String dfa_11s = "\2\uffff\1\2\11\uffff\1\1\1\3";
    static final String dfa_12s = "\16\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\35\uffff\1\2",
            "\1\3\32\uffff\1\4",
            "",
            "\1\7\1\6\1\5",
            "\1\12\1\11\1\10",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\1\32\uffff\1\14\2\uffff\1\15",
            "\1\1\32\uffff\1\14\2\uffff\1\15",
            "\1\1\32\uffff\1\14\2\uffff\1\15",
            "\1\1\32\uffff\1\14\2\uffff\1\15",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "477:4: ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) )";
        }
    }
    static final String dfa_14s = "\123\uffff";
    static final String dfa_15s = "\1\4\1\uffff\1\4\1\uffff\2\17\1\44\1\17\3\4\1\44\1\4\1\44\5\4\1\20\1\4\3\20\1\17\1\27\4\4\2\5\3\4\1\5\2\20\1\4\6\20\2\27\1\44\1\27\2\17\1\20\2\4\1\5\2\4\1\17\2\27\1\4\1\44\2\5\3\4\6\20\2\27\2\20\3\4\2\20\1\4";
    static final String dfa_16s = "\1\u008b\1\uffff\1\120\1\uffff\2\17\1\44\1\17\3\4\1\44\1\u008b\1\44\2\4\1\7\2\4\1\75\1\u008b\3\20\1\52\1\75\2\4\2\u008b\2\7\3\4\1\5\1\75\1\20\1\120\3\20\3\27\1\75\1\50\1\44\1\51\2\17\1\27\2\4\1\5\1\20\1\4\1\52\1\75\1\51\1\u008b\1\44\2\7\3\4\3\27\3\20\1\75\1\50\1\75\1\27\2\4\1\u008b\1\75\1\20\1\43";
    static final String dfa_17s = "\1\uffff\1\2\1\uffff\1\1\117\uffff";
    static final String dfa_18s = "\123\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\10\uffff\1\2\21\uffff\1\1\25\uffff\1\1\1\uffff\1\1\2\uffff\1\3\116\uffff\3\1",
            "",
            "\1\6\36\uffff\1\7\53\uffff\1\4\1\5",
            "",
            "\1\10",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\1\10\uffff\1\21\1\uffff\1\20\45\uffff\1\1\4\uffff\1\3\2\uffff\1\17\113\uffff\3\1",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\30\1\27\1\26\1\25",
            "\1\6",
            "\1\31",
            "\1\34\26\uffff\1\33\25\uffff\1\32",
            "\1\1\10\uffff\1\21\1\uffff\1\20\45\uffff\1\1\4\uffff\1\3\2\uffff\1\17\113\uffff\3\1",
            "\1\35",
            "\1\35",
            "\1\35",
            "\1\36\32\uffff\1\37",
            "\1\42\17\uffff\1\41\1\43\24\uffff\1\40",
            "\1\44",
            "\1\45",
            "\1\1\10\uffff\1\46\47\uffff\1\1\4\uffff\1\3\116\uffff\3\1",
            "\1\1\10\uffff\1\21\47\uffff\1\1\4\uffff\1\3\116\uffff\3\1",
            "\1\51\1\50\1\47",
            "\1\54\1\53\1\52",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\34\26\uffff\1\33\25\uffff\1\32",
            "\1\34",
            "\1\6\36\uffff\1\7\53\uffff\1\61\1\62",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\35\6\uffff\1\64",
            "\1\35\6\uffff\1\64",
            "\1\35\6\uffff\1\64",
            "\1\42\17\uffff\1\41\1\43\24\uffff\1\40",
            "\1\42\20\uffff\1\43",
            "\1\65",
            "\1\66\21\uffff\1\67",
            "\1\70",
            "\1\70",
            "\1\35\6\uffff\1\64",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\15\13\uffff\1\74",
            "\1\75",
            "\1\77\32\uffff\1\76",
            "\1\42\17\uffff\1\101\1\43\24\uffff\1\100",
            "\1\66\21\uffff\1\67",
            "\1\1\10\uffff\1\21\47\uffff\1\1\4\uffff\1\3\116\uffff\3\1",
            "\1\102",
            "\1\105\1\104\1\103",
            "\1\110\1\107\1\106",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\35\6\uffff\1\64",
            "\1\35\6\uffff\1\64",
            "\1\35\6\uffff\1\64",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\42\17\uffff\1\101\1\43\24\uffff\1\100",
            "\1\42\20\uffff\1\43",
            "\1\117\26\uffff\1\116\25\uffff\1\115",
            "\1\35\6\uffff\1\64",
            "\1\120",
            "\1\121",
            "\1\1\10\uffff\1\122\47\uffff\1\1\4\uffff\1\3\116\uffff\3\1",
            "\1\117\26\uffff\1\116\25\uffff\1\115",
            "\1\117",
            "\1\6\36\uffff\1\7"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 2745:3: ( (lv_referredOperations_15_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_20s = "\21\uffff";
    static final String dfa_21s = "\1\124\1\4\1\35\1\4\1\uffff\13\4\1\uffff";
    static final String dfa_22s = "\1\124\1\4\1\35\1\u008f\1\uffff\13\37\1\uffff";
    static final String dfa_23s = "\4\uffff\1\1\13\uffff\1\2";
    static final String dfa_24s = "\21\uffff}>";
    static final String[] dfa_25s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\162\uffff\2\4\6\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\6\uffff\1\17",
            "",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            "\1\4\32\uffff\1\20",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA152 extends DFA {

        public DFA152(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 152;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "7111:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
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
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000029800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000028800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020800010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000001C0000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000180000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000029080000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000029000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000009C0000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000980000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000880000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010000800000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000480000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000020000008000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000810000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000004004000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000100L,0x0000000000006E00L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0061000000002000L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0061000080002000L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0060000000002000L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x04A0000080002010L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x00A0000080002010L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xFC7FFF99E29DE1F0L,0xFFFFFF7FFFFFFFFFL,0x0000000000007FFFL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0380000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0020000000002010L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000812000L,0x0000000000018000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000002000L,0x0000000000018000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0400000000002000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0800000000000010L,0x0000000000007000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x1000010000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000010L,0x8000000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0xFC7FFF99E29DE1F2L,0xFFFFFF7FFFFFFFFFL,0x0000000000007FFFL});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000020100800000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000020000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000800000L,0x0000000001C00000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000080000000L,0x8000000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x4000060000000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x4000020000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x8000000000800000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000780000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x000E000000000000L,0x0000000060000004L,0x0000000000030000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000020020800000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000080000000L,0x8000004000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000100L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000080000000L,0x0200010000300000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000080000000L,0x0200000000300000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000080000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x0200000000300000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x4000000020000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0007FE0000000040L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000020000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000080000010L,0xE180000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000000010L,0xE180000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000010L,0x8180000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000010L,0x8100000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x4000040000000002L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000000000000L,0x0070000000000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x4000000020000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000000000L,0x6000000000000000L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x4000000000008002L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000810010L,0x8000000000000000L,0x00000000000081FFL});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000000000L,0x1C10000000000000L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x2000000000000002L});

}