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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BOOLEAN", "RULE_NUMBER_WITH_TRAILING_PERIOD", "RULE_BIG_DECIMAL", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'@'", "'technology'", "'('", "')'", "'container'", "'deployment'", "'with'", "'operation'", "'environment'", "'deploys'", "','", "'depends'", "'on'", "'nodes'", "'used'", "'by'", "'{'", "'aspects'", "'}'", "'default'", "'values'", "'basic'", "'endpoints'", "'::'", "'is'", "'services'", "':'", "';'", "'='", "'import'", "'from'", "'as'", "'({'", "'})'", "'microservice'", "'version'", "'required'", "'microservices'", "'interfaces'", "'operations'", "'typedef'", "'noimpl'", "'interface'", "'---'", "'@param'", "'@required'", "'@returned'", "'refers'", "'fault'", "'?'", "'.'", "'<'", "'>'", "'-'", "'--'", "'/'", "'types'", "'compatibility'", "'matrix'", "'protocols'", "'service'", "'technologies'", "'infrastructure'", "'data'", "'formats'", "'format'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'primitive'", "'type'", "'based'", "'collection'", "'structure'", "'->'", "'<-'", "'<->'", "'environments'", "'properties'", "'mandatory'", "'singleval'", "'parameters'", "'fields'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'aspect'", "'for'", "'containers'", "'selector'", "'datatypes'", "'context'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'extends'", "'identifier'", "'neverEmpty'", "'part'", "'hide'", "'immutable'", "'enum'", "'closure'", "'sideEffectFree'", "'validator'", "'function'", "'procedure'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'internal'", "'architecture'", "'public'", "'returned'", "'param'", "'functional'", "'utility'", "'unspecified'", "'domainOperations'", "'domainParameters'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
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
    public static final int T__150=150;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
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
    public static final int RULE_STRING=5;
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

                if ( (LA3_0==14) ) {
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
    // InternalOperationDsl.g:148:1: ruleContainer returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' ) ;
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
            // InternalOperationDsl.g:154:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' ) )
            // InternalOperationDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' )
            {
            // InternalOperationDsl.g:155:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}' )
            // InternalOperationDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ otherlv_5= 'container' ( (lv_name_6_0= RULE_ID ) ) otherlv_7= 'deployment' otherlv_8= 'technology' ( (lv_deploymentTechnology_9_0= ruleDeploymentTechnologyReference ) ) (otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) ) )? otherlv_14= 'deploys' ( (lv_deployedServices_15_0= ruleImportedMicroservice ) ) (otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) ) )* (otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )? ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )* otherlv_52= '}'
            {
            // InternalOperationDsl.g:156:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOperationDsl.g:157:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,14,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getContainerAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,15,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getContainerAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,16,FOLLOW_7); 

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

            	    otherlv_4=(Token)match(input,17,FOLLOW_9); 

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

            otherlv_5=(Token)match(input,18,FOLLOW_7); 

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

            otherlv_7=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getContainerAccess().getDeploymentKeyword_3());
            		
            otherlv_8=(Token)match(input,15,FOLLOW_7); 

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

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOperationDsl.g:237:4: otherlv_10= 'with' otherlv_11= 'operation' otherlv_12= 'environment' ( (otherlv_13= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_12); 

                    				newLeafNode(otherlv_10, grammarAccess.getContainerAccess().getWithKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_11, grammarAccess.getContainerAccess().getOperationKeyword_6_1());
                    			
                    otherlv_12=(Token)match(input,22,FOLLOW_14); 

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

            otherlv_14=(Token)match(input,23,FOLLOW_7); 

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

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOperationDsl.g:287:4: otherlv_16= ',' ( (lv_deployedServices_17_0= ruleImportedMicroservice ) )
            	    {
            	    otherlv_16=(Token)match(input,24,FOLLOW_7); 

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

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOperationDsl.g:312:4: otherlv_18= 'depends' otherlv_19= 'on' otherlv_20= 'nodes' ( (lv_dependsOnNodes_21_0= rulePossiblyImportedOperationNode ) ) (otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_18=(Token)match(input,25,FOLLOW_17); 

                    				newLeafNode(otherlv_18, grammarAccess.getContainerAccess().getDependsKeyword_10_0());
                    			
                    otherlv_19=(Token)match(input,26,FOLLOW_18); 

                    				newLeafNode(otherlv_19, grammarAccess.getContainerAccess().getOnKeyword_10_1());
                    			
                    otherlv_20=(Token)match(input,27,FOLLOW_7); 

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

                        if ( (LA7_0==24) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalOperationDsl.g:344:5: otherlv_22= ',' ( (lv_dependsOnNodes_23_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_22=(Token)match(input,24,FOLLOW_7); 

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

            // InternalOperationDsl.g:369:3: (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalOperationDsl.g:370:4: otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_24=(Token)match(input,28,FOLLOW_20); 

                    				newLeafNode(otherlv_24, grammarAccess.getContainerAccess().getUsedKeyword_11_0());
                    			
                    otherlv_25=(Token)match(input,29,FOLLOW_18); 

                    				newLeafNode(otherlv_25, grammarAccess.getContainerAccess().getByKeyword_11_1());
                    			
                    otherlv_26=(Token)match(input,27,FOLLOW_7); 

                    				newLeafNode(otherlv_26, grammarAccess.getContainerAccess().getNodesKeyword_11_2());
                    			
                    // InternalOperationDsl.g:382:4: ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )
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

                    // InternalOperationDsl.g:401:4: (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==24) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalOperationDsl.g:402:5: otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_28=(Token)match(input,24,FOLLOW_7); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getContainerAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalOperationDsl.g:406:5: ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    // InternalOperationDsl.g:407:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:407:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:408:7: lv_usedByNodes_29_0= rulePossiblyImportedOperationNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getContainerAccess().getUsedByNodesPossiblyImportedOperationNodeParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_30=(Token)match(input,30,FOLLOW_22); 

            			newLeafNode(otherlv_30, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_12());
            		
            // InternalOperationDsl.g:431:3: (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalOperationDsl.g:432:4: otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}'
                    {
                    otherlv_31=(Token)match(input,31,FOLLOW_23); 

                    				newLeafNode(otherlv_31, grammarAccess.getContainerAccess().getAspectsKeyword_13_0());
                    			
                    otherlv_32=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_13_1());
                    			
                    // InternalOperationDsl.g:440:4: ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+
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
                    	    // InternalOperationDsl.g:441:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:441:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:442:6: lv_aspects_33_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getContainerAccess().getAspectsImportedOperationAspectParserRuleCall_13_2_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
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
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    otherlv_34=(Token)match(input,32,FOLLOW_25); 

                    				newLeafNode(otherlv_34, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_13_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:464:3: (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOperationDsl.g:465:4: otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) ) otherlv_50= '}'
                    {
                    otherlv_35=(Token)match(input,33,FOLLOW_26); 

                    				newLeafNode(otherlv_35, grammarAccess.getContainerAccess().getDefaultKeyword_14_0());
                    			
                    otherlv_36=(Token)match(input,34,FOLLOW_23); 

                    				newLeafNode(otherlv_36, grammarAccess.getContainerAccess().getValuesKeyword_14_1());
                    			
                    otherlv_37=(Token)match(input,30,FOLLOW_27); 

                    				newLeafNode(otherlv_37, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_14_2());
                    			
                    // InternalOperationDsl.g:477:4: ( ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ | (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' ) | ( ( (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment ) )+ otherlv_45= 'basic' otherlv_46= 'endpoints' otherlv_47= '{' ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+ otherlv_49= '}' ) )
                    int alt17=3;
                    alt17 = dfa17.predict(input);
                    switch (alt17) {
                        case 1 :
                            // InternalOperationDsl.g:478:5: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
                            {
                            // InternalOperationDsl.g:478:5: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
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
                            	    // InternalOperationDsl.g:479:6: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:479:6: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:480:7: lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment
                            	    {

                            	    							newCompositeNode(grammarAccess.getContainerAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_14_3_0_0());
                            	    						
                            	    pushFollow(FOLLOW_24);
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
                            	    if ( cnt13 >= 1 ) break loop13;
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalOperationDsl.g:498:5: (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )
                            {
                            // InternalOperationDsl.g:498:5: (otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )
                            // InternalOperationDsl.g:499:6: otherlv_39= 'basic' otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}'
                            {
                            otherlv_39=(Token)match(input,35,FOLLOW_28); 

                            						newLeafNode(otherlv_39, grammarAccess.getContainerAccess().getBasicKeyword_14_3_1_0());
                            					
                            otherlv_40=(Token)match(input,36,FOLLOW_23); 

                            						newLeafNode(otherlv_40, grammarAccess.getContainerAccess().getEndpointsKeyword_14_3_1_1());
                            					
                            otherlv_41=(Token)match(input,30,FOLLOW_7); 

                            						newLeafNode(otherlv_41, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_14_3_1_2());
                            					
                            // InternalOperationDsl.g:511:6: ( (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint ) )+
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
                            	    // InternalOperationDsl.g:512:7: (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint )
                            	    {
                            	    // InternalOperationDsl.g:512:7: (lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint )
                            	    // InternalOperationDsl.g:513:8: lv_defaultBasicEndpoints_42_0= ruleBasicEndpoint
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultBasicEndpointsBasicEndpointParserRuleCall_14_3_1_3_0());
                            	    							
                            	    pushFollow(FOLLOW_24);
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
                            	    if ( cnt14 >= 1 ) break loop14;
                                        EarlyExitException eee =
                                            new EarlyExitException(14, input);
                                        throw eee;
                                }
                                cnt14++;
                            } while (true);

                            otherlv_43=(Token)match(input,32,FOLLOW_29); 

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
                            	    // InternalOperationDsl.g:538:7: (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:538:7: (lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:539:8: lv_defaultServicePropertyValues_44_0= rulePropertyValueAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_14_3_2_0_0());
                            	    							
                            	    pushFollow(FOLLOW_27);
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
                            	    if ( cnt15 >= 1 ) break loop15;
                                        EarlyExitException eee =
                                            new EarlyExitException(15, input);
                                        throw eee;
                                }
                                cnt15++;
                            } while (true);

                            otherlv_45=(Token)match(input,35,FOLLOW_28); 

                            						newLeafNode(otherlv_45, grammarAccess.getContainerAccess().getBasicKeyword_14_3_2_1());
                            					
                            otherlv_46=(Token)match(input,36,FOLLOW_23); 

                            						newLeafNode(otherlv_46, grammarAccess.getContainerAccess().getEndpointsKeyword_14_3_2_2());
                            					
                            otherlv_47=(Token)match(input,30,FOLLOW_7); 

                            						newLeafNode(otherlv_47, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_14_3_2_3());
                            					
                            // InternalOperationDsl.g:568:6: ( (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint ) )+
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
                            	    // InternalOperationDsl.g:569:7: (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint )
                            	    {
                            	    // InternalOperationDsl.g:569:7: (lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint )
                            	    // InternalOperationDsl.g:570:8: lv_defaultBasicEndpoints_48_0= ruleBasicEndpoint
                            	    {

                            	    								newCompositeNode(grammarAccess.getContainerAccess().getDefaultBasicEndpointsBasicEndpointParserRuleCall_14_3_2_4_0());
                            	    							
                            	    pushFollow(FOLLOW_24);
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
                            	    if ( cnt16 >= 1 ) break loop16;
                                        EarlyExitException eee =
                                            new EarlyExitException(16, input);
                                        throw eee;
                                }
                                cnt16++;
                            } while (true);

                            otherlv_49=(Token)match(input,32,FOLLOW_29); 

                            						newLeafNode(otherlv_49, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_14_3_2_5());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_50=(Token)match(input,32,FOLLOW_24); 

                    				newLeafNode(otherlv_50, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_14_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:598:3: ( (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalOperationDsl.g:599:4: (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:599:4: (lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:600:5: lv_deploymentSpecifications_51_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getContainerAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_15_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    break loop19;
                }
            } while (true);

            otherlv_52=(Token)match(input,32,FOLLOW_2); 

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
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getDeploymentTechnologyReferenceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

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
    // InternalOperationDsl.g:684:1: ruleInfrastructureNode returns [EObject current=null] : ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' ) ;
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
            // InternalOperationDsl.g:690:2: ( ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' ) )
            // InternalOperationDsl.g:691:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' )
            {
            // InternalOperationDsl.g:691:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}' )
            // InternalOperationDsl.g:692:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+ ( (lv_name_5_0= RULE_ID ) ) otherlv_6= 'is' ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) ) (otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) ) )? (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )? (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )? (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )? otherlv_30= '{' (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )? (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )? (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )? ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )* otherlv_45= '}'
            {
            // InternalOperationDsl.g:692:3: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==14) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOperationDsl.g:693:4: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            	    {
            	    otherlv_0=(Token)match(input,14,FOLLOW_5); 

            	    				newLeafNode(otherlv_0, grammarAccess.getInfrastructureNodeAccess().getCommercialAtKeyword_0_0());
            	    			
            	    otherlv_1=(Token)match(input,15,FOLLOW_6); 

            	    				newLeafNode(otherlv_1, grammarAccess.getInfrastructureNodeAccess().getTechnologyKeyword_0_1());
            	    			
            	    otherlv_2=(Token)match(input,16,FOLLOW_7); 

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

            	    otherlv_4=(Token)match(input,17,FOLLOW_31); 

            	    				newLeafNode(otherlv_4, grammarAccess.getInfrastructureNodeAccess().getRightParenthesisKeyword_0_4());
            	    			

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

            // InternalOperationDsl.g:723:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:724:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:724:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:725:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            otherlv_6=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getInfrastructureNodeAccess().getIsKeyword_2());
            		
            // InternalOperationDsl.g:745:3: ( (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference ) )
            // InternalOperationDsl.g:746:4: (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference )
            {
            // InternalOperationDsl.g:746:4: (lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference )
            // InternalOperationDsl.g:747:5: lv_infrastructureTechnology_7_0= ruleInfrastructureTechnologyReference
            {

            					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getInfrastructureTechnologyInfrastructureTechnologyReferenceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_33);
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
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOperationDsl.g:765:4: otherlv_8= 'with' otherlv_9= 'operation' otherlv_10= 'environment' ( (otherlv_11= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_12); 

                    				newLeafNode(otherlv_8, grammarAccess.getInfrastructureNodeAccess().getWithKeyword_4_0());
                    			
                    otherlv_9=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureNodeAccess().getOperationKeyword_4_1());
                    			
                    otherlv_10=(Token)match(input,22,FOLLOW_14); 

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
                    					
                    otherlv_11=(Token)match(input,RULE_STRING,FOLLOW_34); 

                    						newLeafNode(otherlv_11, grammarAccess.getInfrastructureNodeAccess().getOperationEnvironmentOperationEnvironmentCrossReference_4_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:791:3: (otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOperationDsl.g:792:4: otherlv_12= 'depends' otherlv_13= 'on' otherlv_14= 'nodes' ( (lv_dependsOnNodes_15_0= rulePossiblyImportedOperationNode ) ) (otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_12=(Token)match(input,25,FOLLOW_17); 

                    				newLeafNode(otherlv_12, grammarAccess.getInfrastructureNodeAccess().getDependsKeyword_5_0());
                    			
                    otherlv_13=(Token)match(input,26,FOLLOW_18); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureNodeAccess().getOnKeyword_5_1());
                    			
                    otherlv_14=(Token)match(input,27,FOLLOW_7); 

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
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==24) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalOperationDsl.g:824:5: otherlv_16= ',' ( (lv_dependsOnNodes_17_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_16=(Token)match(input,24,FOLLOW_7); 

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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:849:3: (otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==29) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==39) ) {
                        alt25=1;
                    }
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalOperationDsl.g:850:4: otherlv_18= 'used' otherlv_19= 'by' otherlv_20= 'services' ( (lv_deployedServices_21_0= ruleImportedMicroservice ) ) (otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) ) )*
                    {
                    otherlv_18=(Token)match(input,28,FOLLOW_20); 

                    				newLeafNode(otherlv_18, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_6_0());
                    			
                    otherlv_19=(Token)match(input,29,FOLLOW_35); 

                    				newLeafNode(otherlv_19, grammarAccess.getInfrastructureNodeAccess().getByKeyword_6_1());
                    			
                    otherlv_20=(Token)match(input,39,FOLLOW_7); 

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
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==24) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalOperationDsl.g:882:5: otherlv_22= ',' ( (lv_deployedServices_23_0= ruleImportedMicroservice ) )
                    	    {
                    	    otherlv_22=(Token)match(input,24,FOLLOW_7); 

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
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalOperationDsl.g:907:3: (otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==28) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOperationDsl.g:908:4: otherlv_24= 'used' otherlv_25= 'by' otherlv_26= 'nodes' ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) ) (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    {
                    otherlv_24=(Token)match(input,28,FOLLOW_20); 

                    				newLeafNode(otherlv_24, grammarAccess.getInfrastructureNodeAccess().getUsedKeyword_7_0());
                    			
                    otherlv_25=(Token)match(input,29,FOLLOW_18); 

                    				newLeafNode(otherlv_25, grammarAccess.getInfrastructureNodeAccess().getByKeyword_7_1());
                    			
                    otherlv_26=(Token)match(input,27,FOLLOW_7); 

                    				newLeafNode(otherlv_26, grammarAccess.getInfrastructureNodeAccess().getNodesKeyword_7_2());
                    			
                    // InternalOperationDsl.g:920:4: ( (lv_usedByNodes_27_0= rulePossiblyImportedOperationNode ) )
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

                    // InternalOperationDsl.g:939:4: (otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==24) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalOperationDsl.g:940:5: otherlv_28= ',' ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    {
                    	    otherlv_28=(Token)match(input,24,FOLLOW_7); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getInfrastructureNodeAccess().getCommaKeyword_7_4_0());
                    	    				
                    	    // InternalOperationDsl.g:944:5: ( (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode ) )
                    	    // InternalOperationDsl.g:945:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    {
                    	    // InternalOperationDsl.g:945:6: (lv_usedByNodes_29_0= rulePossiblyImportedOperationNode )
                    	    // InternalOperationDsl.g:946:7: lv_usedByNodes_29_0= rulePossiblyImportedOperationNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getUsedByNodesPossiblyImportedOperationNodeParserRuleCall_7_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_30=(Token)match(input,30,FOLLOW_36); 

            			newLeafNode(otherlv_30, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalOperationDsl.g:969:3: (otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalOperationDsl.g:970:4: otherlv_31= 'aspects' otherlv_32= '{' ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+ otherlv_34= '}'
                    {
                    otherlv_31=(Token)match(input,31,FOLLOW_23); 

                    				newLeafNode(otherlv_31, grammarAccess.getInfrastructureNodeAccess().getAspectsKeyword_9_0());
                    			
                    otherlv_32=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_32, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_9_1());
                    			
                    // InternalOperationDsl.g:978:4: ( (lv_aspects_33_0= ruleImportedOperationAspect ) )+
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
                    	    // InternalOperationDsl.g:979:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    {
                    	    // InternalOperationDsl.g:979:5: (lv_aspects_33_0= ruleImportedOperationAspect )
                    	    // InternalOperationDsl.g:980:6: lv_aspects_33_0= ruleImportedOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getAspectsImportedOperationAspectParserRuleCall_9_2_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
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
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    otherlv_34=(Token)match(input,32,FOLLOW_37); 

                    				newLeafNode(otherlv_34, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1002:3: (otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOperationDsl.g:1003:4: otherlv_35= 'default' otherlv_36= 'values' otherlv_37= '{' ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+ otherlv_39= '}'
                    {
                    otherlv_35=(Token)match(input,33,FOLLOW_26); 

                    				newLeafNode(otherlv_35, grammarAccess.getInfrastructureNodeAccess().getDefaultKeyword_10_0());
                    			
                    otherlv_36=(Token)match(input,34,FOLLOW_23); 

                    				newLeafNode(otherlv_36, grammarAccess.getInfrastructureNodeAccess().getValuesKeyword_10_1());
                    			
                    otherlv_37=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_37, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_10_2());
                    			
                    // InternalOperationDsl.g:1015:4: ( (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment ) )+
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
                    	    // InternalOperationDsl.g:1016:5: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                    	    {
                    	    // InternalOperationDsl.g:1016:5: (lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment )
                    	    // InternalOperationDsl.g:1017:6: lv_defaultServicePropertyValues_38_0= rulePropertyValueAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDefaultServicePropertyValuesPropertyValueAssignmentParserRuleCall_10_3_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
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
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    otherlv_39=(Token)match(input,32,FOLLOW_38); 

                    				newLeafNode(otherlv_39, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1039:3: (otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==36) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalOperationDsl.g:1040:4: otherlv_40= 'endpoints' otherlv_41= '{' ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+ otherlv_43= '}'
                    {
                    otherlv_40=(Token)match(input,36,FOLLOW_23); 

                    				newLeafNode(otherlv_40, grammarAccess.getInfrastructureNodeAccess().getEndpointsKeyword_11_0());
                    			
                    otherlv_41=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_41, grammarAccess.getInfrastructureNodeAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalOperationDsl.g:1048:4: ( (lv_endpoints_42_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1049:5: (lv_endpoints_42_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1049:5: (lv_endpoints_42_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:1050:6: lv_endpoints_42_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getEndpointsBasicEndpointParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
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
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);

                    otherlv_43=(Token)match(input,32,FOLLOW_24); 

                    				newLeafNode(otherlv_43, grammarAccess.getInfrastructureNodeAccess().getRightCurlyBracketKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1072:3: ( (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalOperationDsl.g:1073:4: (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification )
            	    {
            	    // InternalOperationDsl.g:1073:4: (lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification )
            	    // InternalOperationDsl.g:1074:5: lv_deploymentSpecifications_44_0= ruleServiceDeploymentSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getInfrastructureNodeAccess().getDeploymentSpecificationsServiceDeploymentSpecificationParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    break loop34;
                }
            } while (true);

            otherlv_45=(Token)match(input,32,FOLLOW_2); 

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
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getInfrastructureTechnologyReferenceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

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
    // InternalOperationDsl.g:1158:1: ruleProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1164:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? ) )
            // InternalOperationDsl.g:1165:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? )
            {
            // InternalOperationDsl.g:1165:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? )
            // InternalOperationDsl.g:1166:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )?
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
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getProtocolAndDataFormatAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

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
            				
            pushFollow(FOLLOW_39);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1199:3: (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOperationDsl.g:1200:4: otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_14); 

                    				newLeafNode(otherlv_3, grammarAccess.getProtocolAndDataFormatAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:1204:4: ( (otherlv_4= RULE_STRING ) )
                    // InternalOperationDsl.g:1205:5: (otherlv_4= RULE_STRING )
                    {
                    // InternalOperationDsl.g:1205:5: (otherlv_4= RULE_STRING )
                    // InternalOperationDsl.g:1206:6: otherlv_4= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolAndDataFormatRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_8); 

                    						newLeafNode(otherlv_4, grammarAccess.getProtocolAndDataFormatAccess().getDataFormatDataFormatCrossReference_3_1_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getProtocolAndDataFormatAccess().getRightParenthesisKeyword_3_2());
                    			

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
    // InternalOperationDsl.g:1226:1: entryRuleBasicEndpoint returns [EObject current=null] : iv_ruleBasicEndpoint= ruleBasicEndpoint EOF ;
    public final EObject entryRuleBasicEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicEndpoint = null;


        try {
            // InternalOperationDsl.g:1226:54: (iv_ruleBasicEndpoint= ruleBasicEndpoint EOF )
            // InternalOperationDsl.g:1227:2: iv_ruleBasicEndpoint= ruleBasicEndpoint EOF
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
    // InternalOperationDsl.g:1233:1: ruleBasicEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:1239:2: ( ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:1240:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:1240:2: ( ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:1241:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:1241:3: ( (lv_protocols_0_0= ruleProtocolAndDataFormat ) )
            // InternalOperationDsl.g:1242:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:1242:4: (lv_protocols_0_0= ruleProtocolAndDataFormat )
            // InternalOperationDsl.g:1243:5: lv_protocols_0_0= ruleProtocolAndDataFormat
            {

            					newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
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

            // InternalOperationDsl.g:1260:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==24) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOperationDsl.g:1261:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getBasicEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:1265:4: ( (lv_protocols_2_0= ruleProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:1266:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:1266:5: (lv_protocols_2_0= ruleProtocolAndDataFormat )
            	    // InternalOperationDsl.g:1267:6: lv_protocols_2_0= ruleProtocolAndDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getBasicEndpointAccess().getProtocolsProtocolAndDataFormatParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
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
            	    break loop36;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getBasicEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:1289:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:1290:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1290:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:1291:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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

            // InternalOperationDsl.g:1307:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==24) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOperationDsl.g:1308:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getBasicEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:1312:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:1313:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:1313:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:1314:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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
            	    break loop37;
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
    // InternalOperationDsl.g:1339:1: entryRuleServiceDeploymentSpecification returns [EObject current=null] : iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF ;
    public final EObject entryRuleServiceDeploymentSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceDeploymentSpecification = null;


        try {
            // InternalOperationDsl.g:1339:71: (iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF )
            // InternalOperationDsl.g:1340:2: iv_ruleServiceDeploymentSpecification= ruleServiceDeploymentSpecification EOF
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
    // InternalOperationDsl.g:1346:1: ruleServiceDeploymentSpecification returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) ;
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
            // InternalOperationDsl.g:1352:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' ) )
            // InternalOperationDsl.g:1353:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            {
            // InternalOperationDsl.g:1353:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}' )
            // InternalOperationDsl.g:1354:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) otherlv_3= '{' ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )* (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )? otherlv_10= '}'
            {
            // InternalOperationDsl.g:1354:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1355:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1355:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1356:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceDeploymentSpecificationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getServiceDeploymentSpecificationAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceDeploymentSpecificationAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1371:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1372:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1372:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1373:5: ruleQualifiedNameWithAtLeastOneLevel
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceDeploymentSpecificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServiceImportedMicroserviceCrossReference_2_0());
            				
            pushFollow(FOLLOW_23);
            ruleQualifiedNameWithAtLeastOneLevel();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:1391:3: ( (lv_servicePropertyValues_4_0= rulePropertyValueAssignment ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOperationDsl.g:1392:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    {
            	    // InternalOperationDsl.g:1392:4: (lv_servicePropertyValues_4_0= rulePropertyValueAssignment )
            	    // InternalOperationDsl.g:1393:5: lv_servicePropertyValues_4_0= rulePropertyValueAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getServicePropertyValuesPropertyValueAssignmentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_42);
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
            	    break loop38;
                }
            } while (true);

            // InternalOperationDsl.g:1410:3: (otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOperationDsl.g:1411:4: otherlv_5= 'basic' otherlv_6= 'endpoints' otherlv_7= '{' ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+ otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getServiceDeploymentSpecificationAccess().getBasicKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,36,FOLLOW_23); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceDeploymentSpecificationAccess().getEndpointsKeyword_5_1());
                    			
                    otherlv_7=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceDeploymentSpecificationAccess().getLeftCurlyBracketKeyword_5_2());
                    			
                    // InternalOperationDsl.g:1423:4: ( (lv_basicEndpoints_8_0= ruleBasicEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1424:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1424:5: (lv_basicEndpoints_8_0= ruleBasicEndpoint )
                    	    // InternalOperationDsl.g:1425:6: lv_basicEndpoints_8_0= ruleBasicEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getServiceDeploymentSpecificationAccess().getBasicEndpointsBasicEndpointParserRuleCall_5_3_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
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
                    	    if ( cnt39 >= 1 ) break loop39;
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);

                    otherlv_9=(Token)match(input,32,FOLLOW_29); 

                    				newLeafNode(otherlv_9, grammarAccess.getServiceDeploymentSpecificationAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:1455:1: entryRuleImportedMicroservice returns [EObject current=null] : iv_ruleImportedMicroservice= ruleImportedMicroservice EOF ;
    public final EObject entryRuleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:1455:61: (iv_ruleImportedMicroservice= ruleImportedMicroservice EOF )
            // InternalOperationDsl.g:1456:2: iv_ruleImportedMicroservice= ruleImportedMicroservice EOF
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
    // InternalOperationDsl.g:1462:1: ruleImportedMicroservice returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) ;
    public final EObject ruleImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1468:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) ) )
            // InternalOperationDsl.g:1469:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            {
            // InternalOperationDsl.g:1469:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) ) )
            // InternalOperationDsl.g:1470:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            {
            // InternalOperationDsl.g:1470:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1471:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1471:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1472:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedMicroserviceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedMicroserviceAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedMicroserviceAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1487:3: ( ( ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:1488:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:1488:4: ( ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:1489:5: ruleQualifiedNameWithAtLeastOneLevel
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
    // InternalOperationDsl.g:1507:1: entryRulePossiblyImportedOperationNode returns [EObject current=null] : iv_rulePossiblyImportedOperationNode= rulePossiblyImportedOperationNode EOF ;
    public final EObject entryRulePossiblyImportedOperationNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperationNode = null;


        try {
            // InternalOperationDsl.g:1507:70: (iv_rulePossiblyImportedOperationNode= rulePossiblyImportedOperationNode EOF )
            // InternalOperationDsl.g:1508:2: iv_rulePossiblyImportedOperationNode= rulePossiblyImportedOperationNode EOF
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
    // InternalOperationDsl.g:1514:1: rulePossiblyImportedOperationNode returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperationNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:1520:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:1521:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:1521:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:1522:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:1522:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==37) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // InternalOperationDsl.g:1523:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:1523:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:1524:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1524:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:1525:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationNodeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationNodeAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationNodeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1541:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1542:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1542:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1543:5: ruleQualifiedName
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
    // InternalOperationDsl.g:1561:1: entryRulePropertyValueAssignment returns [EObject current=null] : iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF ;
    public final EObject entryRulePropertyValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueAssignment = null;


        try {
            // InternalOperationDsl.g:1561:64: (iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF )
            // InternalOperationDsl.g:1562:2: iv_rulePropertyValueAssignment= rulePropertyValueAssignment EOF
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
    // InternalOperationDsl.g:1568:1: rulePropertyValueAssignment returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) ;
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
            // InternalOperationDsl.g:1574:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) ) )
            // InternalOperationDsl.g:1575:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            {
            // InternalOperationDsl.g:1575:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) ) | ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==16) ) {
                    alt42=2;
                }
                else if ( (LA42_1==42) ) {
                    alt42=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalOperationDsl.g:1576:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    {
                    // InternalOperationDsl.g:1576:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) ) )
                    // InternalOperationDsl.g:1577:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= rulePrimitiveValue ) )
                    {
                    // InternalOperationDsl.g:1577:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:1578:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:1578:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:1579:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_43); 

                    						newLeafNode(otherlv_0, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_44); 

                    				newLeafNode(otherlv_1, grammarAccess.getPropertyValueAssignmentAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:1594:4: ( (lv_value_2_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:1595:5: (lv_value_2_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:1595:5: (lv_value_2_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:1596:6: lv_value_2_0= rulePrimitiveValue
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
                    // InternalOperationDsl.g:1615:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    {
                    // InternalOperationDsl.g:1615:3: ( ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')' )
                    // InternalOperationDsl.g:1616:4: ( (otherlv_3= RULE_ID ) ) otherlv_4= '(' ( (lv_value_5_0= rulePrimitiveValue ) ) otherlv_6= ')'
                    {
                    // InternalOperationDsl.g:1616:4: ( (otherlv_3= RULE_ID ) )
                    // InternalOperationDsl.g:1617:5: (otherlv_3= RULE_ID )
                    {
                    // InternalOperationDsl.g:1617:5: (otherlv_3= RULE_ID )
                    // InternalOperationDsl.g:1618:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyValueAssignmentRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_3, grammarAccess.getPropertyValueAssignmentAccess().getPropertyTechnologySpecificPropertyCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,16,FOLLOW_44); 

                    				newLeafNode(otherlv_4, grammarAccess.getPropertyValueAssignmentAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOperationDsl.g:1633:4: ( (lv_value_5_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:1634:5: (lv_value_5_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:1634:5: (lv_value_5_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:1635:6: lv_value_5_0= rulePrimitiveValue
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

                    otherlv_6=(Token)match(input,17,FOLLOW_2); 

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
    // InternalOperationDsl.g:1661:1: entryRuleImportedOperationAspect returns [EObject current=null] : iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF ;
    public final EObject entryRuleImportedOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedOperationAspect = null;


        try {
            // InternalOperationDsl.g:1661:64: (iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF )
            // InternalOperationDsl.g:1662:2: iv_ruleImportedOperationAspect= ruleImportedOperationAspect EOF
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
    // InternalOperationDsl.g:1668:1: ruleImportedOperationAspect returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:1674:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:1675:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:1675:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';' )
            // InternalOperationDsl.g:1676:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )? otherlv_9= ';'
            {
            // InternalOperationDsl.g:1676:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:1677:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:1677:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:1678:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedOperationAspectAccess().getTechnologyImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedOperationAspectAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:1693:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:1694:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:1694:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:1695:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedOperationAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getAspectOperationAspectCrossReference_2_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:1709:3: (otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==16) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalOperationDsl.g:1710:4: otherlv_3= '(' ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_8= ')'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_46); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedOperationAspectAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:1714:4: ( ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) ) | ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_BOOLEAN)||LA44_0==RULE_BIG_DECIMAL) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==RULE_ID) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalOperationDsl.g:1715:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:1715:5: ( (lv_singlePropertyValue_4_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:1716:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:1716:6: (lv_singlePropertyValue_4_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:1717:7: lv_singlePropertyValue_4_0= rulePrimitiveValue
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
                            // InternalOperationDsl.g:1735:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:1735:5: ( ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:1736:6: ( (lv_values_5_0= rulePropertyValueAssignment ) ) (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:1736:6: ( (lv_values_5_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:1737:7: (lv_values_5_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:1737:7: (lv_values_5_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:1738:8: lv_values_5_0= rulePropertyValueAssignment
                            {

                            								newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_0_0());
                            							
                            pushFollow(FOLLOW_47);
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

                            // InternalOperationDsl.g:1755:6: (otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==24) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // InternalOperationDsl.g:1756:7: otherlv_6= ',' ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_6=(Token)match(input,24,FOLLOW_7); 

                            	    							newLeafNode(otherlv_6, grammarAccess.getImportedOperationAspectAccess().getCommaKeyword_3_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:1760:7: ( (lv_values_7_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:1761:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:1761:8: (lv_values_7_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:1762:9: lv_values_7_0= rulePropertyValueAssignment
                            	    {

                            	    									newCompositeNode(grammarAccess.getImportedOperationAspectAccess().getValuesPropertyValueAssignmentParserRuleCall_3_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_47);
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
                            	    break loop43;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,17,FOLLOW_48); 

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
    // InternalOperationDsl.g:1795:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalOperationDsl.g:1795:47: (iv_ruleImport= ruleImport EOF )
            // InternalOperationDsl.g:1796:2: iv_ruleImport= ruleImport EOF
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
    // InternalOperationDsl.g:1802:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:1808:2: ( (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:1809:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:1809:2: (otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:1810:3: otherlv_0= 'import' ( (lv_importType_1_0= ruleImportType ) ) otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalOperationDsl.g:1814:3: ( (lv_importType_1_0= ruleImportType ) )
            // InternalOperationDsl.g:1815:4: (lv_importType_1_0= ruleImportType )
            {
            // InternalOperationDsl.g:1815:4: (lv_importType_1_0= ruleImportType )
            // InternalOperationDsl.g:1816:5: lv_importType_1_0= ruleImportType
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
            						"de.fhdo.lemma.operationdsl.OperationDsl.ImportType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:1837:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:1838:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:1838:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:1839:5: lv_importURI_3_0= RULE_STRING
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
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:1859:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:1860:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:1860:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:1861:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:1881:1: entryRuleMicroservice returns [EObject current=null] : iv_ruleMicroservice= ruleMicroservice EOF ;
    public final EObject entryRuleMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMicroservice = null;


        try {
            // InternalOperationDsl.g:1881:53: (iv_ruleMicroservice= ruleMicroservice EOF )
            // InternalOperationDsl.g:1882:2: iv_ruleMicroservice= ruleMicroservice EOF
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
    // InternalOperationDsl.g:1888:1: ruleMicroservice returns [EObject current=null] : ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' ) ;
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
            // InternalOperationDsl.g:1894:2: ( ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' ) )
            // InternalOperationDsl.g:1895:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' )
            {
            // InternalOperationDsl.g:1895:2: ( ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}' )
            // InternalOperationDsl.g:1896:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )* ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_visibility_14_0= ruleVisibility ) )? ( (lv_type_15_0= ruleMicroserviceType ) ) otherlv_16= 'microservice' ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) ) (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )? otherlv_20= '{' (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )? (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )? (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )? ( (lv_interfaces_42_0= ruleInterface ) )+ otherlv_43= '}'
            {
            // InternalOperationDsl.g:1896:3: ( (lv_technologyReferences_0_0= ruleTechnologyReference ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==14) ) {
                    int LA46_1 = input.LA(2);

                    if ( (LA46_1==15) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // InternalOperationDsl.g:1897:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    {
            	    // InternalOperationDsl.g:1897:4: (lv_technologyReferences_0_0= ruleTechnologyReference )
            	    // InternalOperationDsl.g:1898:5: lv_technologyReferences_0_0= ruleTechnologyReference
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
            	    break loop46;
                }
            } while (true);

            // InternalOperationDsl.g:1915:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==14) ) {
                int LA48_1 = input.LA(2);

                if ( ((LA48_1>=83 && LA48_1<=84)) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalOperationDsl.g:1916:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:1916:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:1917:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:1917:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:1918:6: lv_protocols_1_0= ruleProtocolSpecification
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

                    // InternalOperationDsl.g:1935:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==14) ) {
                        int LA47_1 = input.LA(2);

                        if ( ((LA47_1>=83 && LA47_1<=84)) ) {
                            alt47=1;
                        }
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalOperationDsl.g:1936:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:1936:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:1937:6: lv_protocols_2_0= ruleProtocolSpecification
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

            // InternalOperationDsl.g:1955:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==36) ) {
                    int LA50_3 = input.LA(3);

                    if ( (LA50_3==16) ) {
                        alt50=1;
                    }
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalOperationDsl.g:1956:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,36,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getMicroserviceAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalOperationDsl.g:1968:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:1969:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:1969:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:1970:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_53);
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
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);

                    otherlv_7=(Token)match(input,17,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getMicroserviceAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:1992:3: (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==14) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==36) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalOperationDsl.g:1993:4: otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_8, grammarAccess.getMicroserviceAccess().getCommercialAtKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,36,FOLLOW_54); 

                    				newLeafNode(otherlv_9, grammarAccess.getMicroserviceAccess().getEndpointsKeyword_3_1());
                    			
                    otherlv_10=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getMicroserviceAccess().getLeftParenthesisLeftCurlyBracketKeyword_3_2());
                    			
                    // InternalOperationDsl.g:2005:4: ( (lv_endpoints_11_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2006:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2006:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2007:6: lv_endpoints_11_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getMicroserviceAccess().getEndpointsEndpointParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
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
                    	    if ( cnt51 >= 1 ) break loop51;
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
                    } while (true);

                    otherlv_12=(Token)match(input,47,FOLLOW_52); 

                    				newLeafNode(otherlv_12, grammarAccess.getMicroserviceAccess().getRightCurlyBracketRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2029:3: ( (lv_aspects_13_0= ruleImportedServiceAspect ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalOperationDsl.g:2030:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2030:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2031:5: lv_aspects_13_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getAspectsImportedServiceAspectParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_52);
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
            	    break loop53;
                }
            } while (true);

            // InternalOperationDsl.g:2048:3: ( (lv_visibility_14_0= ruleVisibility ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=141 && LA54_0<=143)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalOperationDsl.g:2049:4: (lv_visibility_14_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2049:4: (lv_visibility_14_0= ruleVisibility )
                    // InternalOperationDsl.g:2050:5: lv_visibility_14_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getMicroserviceAccess().getVisibilityVisibilityEnumRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_52);
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

            // InternalOperationDsl.g:2067:3: ( (lv_type_15_0= ruleMicroserviceType ) )
            // InternalOperationDsl.g:2068:4: (lv_type_15_0= ruleMicroserviceType )
            {
            // InternalOperationDsl.g:2068:4: (lv_type_15_0= ruleMicroserviceType )
            // InternalOperationDsl.g:2069:5: lv_type_15_0= ruleMicroserviceType
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getTypeMicroserviceTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_56);
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

            otherlv_16=(Token)match(input,48,FOLLOW_7); 

            			newLeafNode(otherlv_16, grammarAccess.getMicroserviceAccess().getMicroserviceKeyword_7());
            		
            // InternalOperationDsl.g:2090:3: ( (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel ) )
            // InternalOperationDsl.g:2091:4: (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel )
            {
            // InternalOperationDsl.g:2091:4: (lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel )
            // InternalOperationDsl.g:2092:5: lv_name_17_0= ruleQualifiedNameWithAtLeastOneLevel
            {

            					newCompositeNode(grammarAccess.getMicroserviceAccess().getNameQualifiedNameWithAtLeastOneLevelParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_57);
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

            // InternalOperationDsl.g:2109:3: (otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==49) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalOperationDsl.g:2110:4: otherlv_18= 'version' ( (lv_version_19_0= RULE_ID ) )
                    {
                    otherlv_18=(Token)match(input,49,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getMicroserviceAccess().getVersionKeyword_9_0());
                    			
                    // InternalOperationDsl.g:2114:4: ( (lv_version_19_0= RULE_ID ) )
                    // InternalOperationDsl.g:2115:5: (lv_version_19_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2115:5: (lv_version_19_0= RULE_ID )
                    // InternalOperationDsl.g:2116:6: lv_version_19_0= RULE_ID
                    {
                    lv_version_19_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_20=(Token)match(input,30,FOLLOW_58); 

            			newLeafNode(otherlv_20, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_10());
            		
            // InternalOperationDsl.g:2137:3: (otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==50) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==51) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalOperationDsl.g:2138:4: otherlv_21= 'required' otherlv_22= 'microservices' otherlv_23= '{' ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) ) (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )* otherlv_27= '}'
                    {
                    otherlv_21=(Token)match(input,50,FOLLOW_59); 

                    				newLeafNode(otherlv_21, grammarAccess.getMicroserviceAccess().getRequiredKeyword_11_0());
                    			
                    otherlv_22=(Token)match(input,51,FOLLOW_23); 

                    				newLeafNode(otherlv_22, grammarAccess.getMicroserviceAccess().getMicroservicesKeyword_11_1());
                    			
                    otherlv_23=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_23, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_11_2());
                    			
                    // InternalOperationDsl.g:2150:4: ( (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice ) )
                    // InternalOperationDsl.g:2151:5: (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice )
                    {
                    // InternalOperationDsl.g:2151:5: (lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice )
                    // InternalOperationDsl.g:2152:6: lv_requiredMicroservices_24_0= rulePossiblyImportedMicroservice
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_11_3_0());
                    					
                    pushFollow(FOLLOW_60);
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

                    // InternalOperationDsl.g:2169:4: (otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==24) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2170:5: otherlv_25= ',' ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) )
                    	    {
                    	    otherlv_25=(Token)match(input,24,FOLLOW_7); 

                    	    					newLeafNode(otherlv_25, grammarAccess.getMicroserviceAccess().getCommaKeyword_11_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2174:5: ( (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice ) )
                    	    // InternalOperationDsl.g:2175:6: (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice )
                    	    {
                    	    // InternalOperationDsl.g:2175:6: (lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice )
                    	    // InternalOperationDsl.g:2176:7: lv_requiredMicroservices_26_0= rulePossiblyImportedMicroservice
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredMicroservicesPossiblyImportedMicroserviceParserRuleCall_11_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,32,FOLLOW_58); 

                    				newLeafNode(otherlv_27, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_11_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2199:3: (otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==50) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==52) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalOperationDsl.g:2200:4: otherlv_28= 'required' otherlv_29= 'interfaces' otherlv_30= '{' ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) ) (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )* otherlv_34= '}'
                    {
                    otherlv_28=(Token)match(input,50,FOLLOW_61); 

                    				newLeafNode(otherlv_28, grammarAccess.getMicroserviceAccess().getRequiredKeyword_12_0());
                    			
                    otherlv_29=(Token)match(input,52,FOLLOW_23); 

                    				newLeafNode(otherlv_29, grammarAccess.getMicroserviceAccess().getInterfacesKeyword_12_1());
                    			
                    otherlv_30=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_30, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_12_2());
                    			
                    // InternalOperationDsl.g:2212:4: ( (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface ) )
                    // InternalOperationDsl.g:2213:5: (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface )
                    {
                    // InternalOperationDsl.g:2213:5: (lv_requiredInterfaces_31_0= rulePossiblyImportedInterface )
                    // InternalOperationDsl.g:2214:6: lv_requiredInterfaces_31_0= rulePossiblyImportedInterface
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_60);
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

                    // InternalOperationDsl.g:2231:4: (otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==24) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2232:5: otherlv_32= ',' ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) )
                    	    {
                    	    otherlv_32=(Token)match(input,24,FOLLOW_7); 

                    	    					newLeafNode(otherlv_32, grammarAccess.getMicroserviceAccess().getCommaKeyword_12_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2236:5: ( (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface ) )
                    	    // InternalOperationDsl.g:2237:6: (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface )
                    	    {
                    	    // InternalOperationDsl.g:2237:6: (lv_requiredInterfaces_33_0= rulePossiblyImportedInterface )
                    	    // InternalOperationDsl.g:2238:7: lv_requiredInterfaces_33_0= rulePossiblyImportedInterface
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredInterfacesPossiblyImportedInterfaceParserRuleCall_12_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
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
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_34=(Token)match(input,32,FOLLOW_58); 

                    				newLeafNode(otherlv_34, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_12_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2261:3: (otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==50) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalOperationDsl.g:2262:4: otherlv_35= 'required' otherlv_36= 'operations' otherlv_37= '{' ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) ) (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )* otherlv_41= '}'
                    {
                    otherlv_35=(Token)match(input,50,FOLLOW_62); 

                    				newLeafNode(otherlv_35, grammarAccess.getMicroserviceAccess().getRequiredKeyword_13_0());
                    			
                    otherlv_36=(Token)match(input,53,FOLLOW_23); 

                    				newLeafNode(otherlv_36, grammarAccess.getMicroserviceAccess().getOperationsKeyword_13_1());
                    			
                    otherlv_37=(Token)match(input,30,FOLLOW_7); 

                    				newLeafNode(otherlv_37, grammarAccess.getMicroserviceAccess().getLeftCurlyBracketKeyword_13_2());
                    			
                    // InternalOperationDsl.g:2274:4: ( (lv_requiredOperations_38_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:2275:5: (lv_requiredOperations_38_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:2275:5: (lv_requiredOperations_38_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:2276:6: lv_requiredOperations_38_0= rulePossiblyImportedOperation
                    {

                    						newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_13_3_0());
                    					
                    pushFollow(FOLLOW_60);
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

                    // InternalOperationDsl.g:2293:4: (otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==24) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalOperationDsl.g:2294:5: otherlv_39= ',' ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) )
                    	    {
                    	    otherlv_39=(Token)match(input,24,FOLLOW_7); 

                    	    					newLeafNode(otherlv_39, grammarAccess.getMicroserviceAccess().getCommaKeyword_13_4_0());
                    	    				
                    	    // InternalOperationDsl.g:2298:5: ( (lv_requiredOperations_40_0= rulePossiblyImportedOperation ) )
                    	    // InternalOperationDsl.g:2299:6: (lv_requiredOperations_40_0= rulePossiblyImportedOperation )
                    	    {
                    	    // InternalOperationDsl.g:2299:6: (lv_requiredOperations_40_0= rulePossiblyImportedOperation )
                    	    // InternalOperationDsl.g:2300:7: lv_requiredOperations_40_0= rulePossiblyImportedOperation
                    	    {

                    	    							newCompositeNode(grammarAccess.getMicroserviceAccess().getRequiredOperationsPossiblyImportedOperationParserRuleCall_13_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
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
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_41=(Token)match(input,32,FOLLOW_58); 

                    				newLeafNode(otherlv_41, grammarAccess.getMicroserviceAccess().getRightCurlyBracketKeyword_13_5());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2323:3: ( (lv_interfaces_42_0= ruleInterface ) )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==14||(LA62_0>=55 && LA62_0<=56)||(LA62_0>=141 && LA62_0<=143)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalOperationDsl.g:2324:4: (lv_interfaces_42_0= ruleInterface )
            	    {
            	    // InternalOperationDsl.g:2324:4: (lv_interfaces_42_0= ruleInterface )
            	    // InternalOperationDsl.g:2325:5: lv_interfaces_42_0= ruleInterface
            	    {

            	    					newCompositeNode(grammarAccess.getMicroserviceAccess().getInterfacesInterfaceParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_63);
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
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            otherlv_43=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:2350:1: entryRuleTechnologyReference returns [EObject current=null] : iv_ruleTechnologyReference= ruleTechnologyReference EOF ;
    public final EObject entryRuleTechnologyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyReference = null;


        try {
            // InternalOperationDsl.g:2350:60: (iv_ruleTechnologyReference= ruleTechnologyReference EOF )
            // InternalOperationDsl.g:2351:2: iv_ruleTechnologyReference= ruleTechnologyReference EOF
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
    // InternalOperationDsl.g:2357:1: ruleTechnologyReference returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) ;
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
            // InternalOperationDsl.g:2363:2: ( (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' ) )
            // InternalOperationDsl.g:2364:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            {
            // InternalOperationDsl.g:2364:2: (otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')' )
            // InternalOperationDsl.g:2365:3: otherlv_0= '@' otherlv_1= 'technology' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyReferenceAccess().getCommercialAtKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyReferenceAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOperationDsl.g:2377:3: ( (otherlv_3= RULE_ID ) )
            // InternalOperationDsl.g:2378:4: (otherlv_3= RULE_ID )
            {
            // InternalOperationDsl.g:2378:4: (otherlv_3= RULE_ID )
            // InternalOperationDsl.g:2379:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(otherlv_3, grammarAccess.getTechnologyReferenceAccess().getTechnologyImportCrossReference_3_0());
            				

            }


            }

            // InternalOperationDsl.g:2390:3: (otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==24) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalOperationDsl.g:2391:4: otherlv_4= ',' otherlv_5= 'typedef' otherlv_6= '=' ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    {
                    otherlv_4=(Token)match(input,24,FOLLOW_64); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyReferenceAccess().getCommaKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,54,FOLLOW_43); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyReferenceAccess().getTypedefKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,42,FOLLOW_65); 

                    				newLeafNode(otherlv_6, grammarAccess.getTechnologyReferenceAccess().getEqualsSignKeyword_4_2());
                    			
                    // InternalOperationDsl.g:2403:4: ( (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:2404:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:2404:5: (lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:2405:6: lv_isTypeDefinitionTechnology_7_0= RULE_BOOLEAN
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

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

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
    // InternalOperationDsl.g:2430:1: entryRulePossiblyImportedMicroservice returns [EObject current=null] : iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF ;
    public final EObject entryRulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedMicroservice = null;


        try {
            // InternalOperationDsl.g:2430:69: (iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF )
            // InternalOperationDsl.g:2431:2: iv_rulePossiblyImportedMicroservice= rulePossiblyImportedMicroservice EOF
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
    // InternalOperationDsl.g:2437:1: rulePossiblyImportedMicroservice returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedMicroservice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2443:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2444:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2444:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2445:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2445:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==37) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalOperationDsl.g:2446:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2446:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2447:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2447:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2448:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedMicroserviceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedMicroserviceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedMicroserviceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2464:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2465:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2465:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2466:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2484:1: entryRulePossiblyImportedInterface returns [EObject current=null] : iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF ;
    public final EObject entryRulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedInterface = null;


        try {
            // InternalOperationDsl.g:2484:66: (iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF )
            // InternalOperationDsl.g:2485:2: iv_rulePossiblyImportedInterface= rulePossiblyImportedInterface EOF
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
    // InternalOperationDsl.g:2491:1: rulePossiblyImportedInterface returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2497:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2498:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2498:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2499:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2499:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==37) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalOperationDsl.g:2500:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2500:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2501:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2501:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2502:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedInterfaceRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedInterfaceAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedInterfaceAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2518:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2519:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2519:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2520:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2538:1: entryRulePossiblyImportedOperation returns [EObject current=null] : iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF ;
    public final EObject entryRulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedOperation = null;


        try {
            // InternalOperationDsl.g:2538:66: (iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF )
            // InternalOperationDsl.g:2539:2: iv_rulePossiblyImportedOperation= rulePossiblyImportedOperation EOF
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
    // InternalOperationDsl.g:2545:1: rulePossiblyImportedOperation returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:2551:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:2552:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:2552:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:2553:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:2553:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==37) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalOperationDsl.g:2554:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:2554:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:2555:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2555:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:2556:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedOperationRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedOperationAccess().getImportImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedOperationAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2572:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:2573:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:2573:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:2574:5: ruleQualifiedName
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
    // InternalOperationDsl.g:2592:1: entryRuleInterface returns [EObject current=null] : iv_ruleInterface= ruleInterface EOF ;
    public final EObject entryRuleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface = null;


        try {
            // InternalOperationDsl.g:2592:50: (iv_ruleInterface= ruleInterface EOF )
            // InternalOperationDsl.g:2593:2: iv_ruleInterface= ruleInterface EOF
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
    // InternalOperationDsl.g:2599:1: ruleInterface returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' ) ;
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
            // InternalOperationDsl.g:2605:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' ) )
            // InternalOperationDsl.g:2606:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' )
            {
            // InternalOperationDsl.g:2606:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}' )
            // InternalOperationDsl.g:2607:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_13_0= 'noimpl' ) )? ( (lv_visibility_14_0= ruleVisibility ) )? otherlv_15= 'interface' ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )? otherlv_19= '{' ( (lv_referredOperations_20_0= ruleReferredOperation ) )* ( (lv_operations_21_0= ruleOperation ) )* otherlv_22= '}'
            {
            // InternalOperationDsl.g:2607:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==14) ) {
                int LA68_1 = input.LA(2);

                if ( ((LA68_1>=83 && LA68_1<=84)) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalOperationDsl.g:2608:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:2608:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:2609:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:2609:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:2610:6: lv_protocols_0_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_66);
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

                    // InternalOperationDsl.g:2627:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==14) ) {
                        int LA67_1 = input.LA(2);

                        if ( ((LA67_1>=83 && LA67_1<=84)) ) {
                            alt67=1;
                        }
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalOperationDsl.g:2628:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:2628:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:2629:6: lv_protocols_1_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getInterfaceAccess().getProtocolsProtocolSpecificationParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_66);
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

            // InternalOperationDsl.g:2647:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==14) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==36) ) {
                    int LA70_3 = input.LA(3);

                    if ( (LA70_3==16) ) {
                        alt70=1;
                    }
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalOperationDsl.g:2648:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,36,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getInterfaceAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:2660:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2661:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2661:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2662:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_53);
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

                    otherlv_6=(Token)match(input,17,FOLLOW_66); 

                    				newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2684:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==14) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==36) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalOperationDsl.g:2685:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_7, grammarAccess.getInterfaceAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,36,FOLLOW_54); 

                    				newLeafNode(otherlv_8, grammarAccess.getInterfaceAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getInterfaceAccess().getLeftParenthesisLeftCurlyBracketKeyword_2_2());
                    			
                    // InternalOperationDsl.g:2697:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
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
                    	    // InternalOperationDsl.g:2698:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:2698:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:2699:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getInterfaceAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
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
                    	    if ( cnt71 >= 1 ) break loop71;
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);

                    otherlv_11=(Token)match(input,47,FOLLOW_66); 

                    				newLeafNode(otherlv_11, grammarAccess.getInterfaceAccess().getRightCurlyBracketRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:2721:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==14) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalOperationDsl.g:2722:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:2722:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:2723:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    break loop73;
                }
            } while (true);

            // InternalOperationDsl.g:2740:3: ( (lv_notImplemented_13_0= 'noimpl' ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==55) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalOperationDsl.g:2741:4: (lv_notImplemented_13_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:2741:4: (lv_notImplemented_13_0= 'noimpl' )
                    // InternalOperationDsl.g:2742:5: lv_notImplemented_13_0= 'noimpl'
                    {
                    lv_notImplemented_13_0=(Token)match(input,55,FOLLOW_67); 

                    					newLeafNode(lv_notImplemented_13_0, grammarAccess.getInterfaceAccess().getNotImplementedNoimplKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInterfaceRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", lv_notImplemented_13_0 != null, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2754:3: ( (lv_visibility_14_0= ruleVisibility ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=141 && LA75_0<=143)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalOperationDsl.g:2755:4: (lv_visibility_14_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:2755:4: (lv_visibility_14_0= ruleVisibility )
                    // InternalOperationDsl.g:2756:5: lv_visibility_14_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getInterfaceAccess().getVisibilityVisibilityEnumRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_68);
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

            otherlv_15=(Token)match(input,56,FOLLOW_7); 

            			newLeafNode(otherlv_15, grammarAccess.getInterfaceAccess().getInterfaceKeyword_6());
            		
            // InternalOperationDsl.g:2777:3: ( (lv_name_16_0= RULE_ID ) )
            // InternalOperationDsl.g:2778:4: (lv_name_16_0= RULE_ID )
            {
            // InternalOperationDsl.g:2778:4: (lv_name_16_0= RULE_ID )
            // InternalOperationDsl.g:2779:5: lv_name_16_0= RULE_ID
            {
            lv_name_16_0=(Token)match(input,RULE_ID,FOLLOW_57); 

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

            // InternalOperationDsl.g:2795:3: (otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==49) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalOperationDsl.g:2796:4: otherlv_17= 'version' ( (lv_version_18_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,49,FOLLOW_7); 

                    				newLeafNode(otherlv_17, grammarAccess.getInterfaceAccess().getVersionKeyword_8_0());
                    			
                    // InternalOperationDsl.g:2800:4: ( (lv_version_18_0= RULE_ID ) )
                    // InternalOperationDsl.g:2801:5: (lv_version_18_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:2801:5: (lv_version_18_0= RULE_ID )
                    // InternalOperationDsl.g:2802:6: lv_version_18_0= RULE_ID
                    {
                    lv_version_18_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_19=(Token)match(input,30,FOLLOW_69); 

            			newLeafNode(otherlv_19, grammarAccess.getInterfaceAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalOperationDsl.g:2823:3: ( (lv_referredOperations_20_0= ruleReferredOperation ) )*
            loop77:
            do {
                int alt77=2;
                alt77 = dfa77.predict(input);
                switch (alt77) {
            	case 1 :
            	    // InternalOperationDsl.g:2824:4: (lv_referredOperations_20_0= ruleReferredOperation )
            	    {
            	    // InternalOperationDsl.g:2824:4: (lv_referredOperations_20_0= ruleReferredOperation )
            	    // InternalOperationDsl.g:2825:5: lv_referredOperations_20_0= ruleReferredOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getReferredOperationsReferredOperationParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_69);
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
            	    break loop77;
                }
            } while (true);

            // InternalOperationDsl.g:2842:3: ( (lv_operations_21_0= ruleOperation ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==14||LA78_0==55||LA78_0==57||(LA78_0>=141 && LA78_0<=143)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalOperationDsl.g:2843:4: (lv_operations_21_0= ruleOperation )
            	    {
            	    // InternalOperationDsl.g:2843:4: (lv_operations_21_0= ruleOperation )
            	    // InternalOperationDsl.g:2844:5: lv_operations_21_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getInterfaceAccess().getOperationsOperationParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_70);
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
            	    break loop78;
                }
            } while (true);

            otherlv_22=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:2869:1: entryRuleApiOperationComment returns [EObject current=null] : iv_ruleApiOperationComment= ruleApiOperationComment EOF ;
    public final EObject entryRuleApiOperationComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiOperationComment = null;


        try {
            // InternalOperationDsl.g:2869:60: (iv_ruleApiOperationComment= ruleApiOperationComment EOF )
            // InternalOperationDsl.g:2870:2: iv_ruleApiOperationComment= ruleApiOperationComment EOF
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
    // InternalOperationDsl.g:2876:1: ruleApiOperationComment returns [EObject current=null] : (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) ;
    public final EObject ruleApiOperationComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_comment_1_0 = null;

        EObject lv_parameterComments_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:2882:2: ( (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' ) )
            // InternalOperationDsl.g:2883:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            {
            // InternalOperationDsl.g:2883:2: (otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---' )
            // InternalOperationDsl.g:2884:3: otherlv_0= '---' ( (lv_comment_1_0= ruleAnything ) ) ( (lv_parameterComments_2_0= ruleApiParameterComment ) )* otherlv_3= '---'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_71); 

            			newLeafNode(otherlv_0, grammarAccess.getApiOperationCommentAccess().getHyphenMinusHyphenMinusHyphenMinusKeyword_0());
            		
            // InternalOperationDsl.g:2888:3: ( (lv_comment_1_0= ruleAnything ) )
            // InternalOperationDsl.g:2889:4: (lv_comment_1_0= ruleAnything )
            {
            // InternalOperationDsl.g:2889:4: (lv_comment_1_0= ruleAnything )
            // InternalOperationDsl.g:2890:5: lv_comment_1_0= ruleAnything
            {

            					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getCommentAnythingParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_72);
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

            // InternalOperationDsl.g:2907:3: ( (lv_parameterComments_2_0= ruleApiParameterComment ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=58 && LA79_0<=60)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalOperationDsl.g:2908:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    {
            	    // InternalOperationDsl.g:2908:4: (lv_parameterComments_2_0= ruleApiParameterComment )
            	    // InternalOperationDsl.g:2909:5: lv_parameterComments_2_0= ruleApiParameterComment
            	    {

            	    					newCompositeNode(grammarAccess.getApiOperationCommentAccess().getParameterCommentsApiParameterCommentParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_72);
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
            	    break loop79;
                }
            } while (true);

            otherlv_3=(Token)match(input,57,FOLLOW_2); 

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
    // InternalOperationDsl.g:2934:1: entryRuleApiParameterComment returns [EObject current=null] : iv_ruleApiParameterComment= ruleApiParameterComment EOF ;
    public final EObject entryRuleApiParameterComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApiParameterComment = null;


        try {
            // InternalOperationDsl.g:2934:60: (iv_ruleApiParameterComment= ruleApiParameterComment EOF )
            // InternalOperationDsl.g:2935:2: iv_ruleApiParameterComment= ruleApiParameterComment EOF
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
    // InternalOperationDsl.g:2941:1: ruleApiParameterComment returns [EObject current=null] : ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) | ( (lv_returned_2_0= '@returned' ) ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_comment_4_0= ruleAnything ) ) ) ;
    public final EObject ruleApiParameterComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_required_1_0=null;
        Token lv_returned_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_comment_4_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:2947:2: ( ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) | ( (lv_returned_2_0= '@returned' ) ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_comment_4_0= ruleAnything ) ) ) )
            // InternalOperationDsl.g:2948:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) | ( (lv_returned_2_0= '@returned' ) ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_comment_4_0= ruleAnything ) ) )
            {
            // InternalOperationDsl.g:2948:2: ( (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) | ( (lv_returned_2_0= '@returned' ) ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_comment_4_0= ruleAnything ) ) )
            // InternalOperationDsl.g:2949:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) | ( (lv_returned_2_0= '@returned' ) ) ) ( (otherlv_3= RULE_ID ) ) ( (lv_comment_4_0= ruleAnything ) )
            {
            // InternalOperationDsl.g:2949:3: (otherlv_0= '@param' | ( (lv_required_1_0= '@required' ) ) | ( (lv_returned_2_0= '@returned' ) ) )
            int alt80=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt80=1;
                }
                break;
            case 59:
                {
                alt80=2;
                }
                break;
            case 60:
                {
                alt80=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalOperationDsl.g:2950:4: otherlv_0= '@param'
                    {
                    otherlv_0=(Token)match(input,58,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getApiParameterCommentAccess().getParamKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:2955:4: ( (lv_required_1_0= '@required' ) )
                    {
                    // InternalOperationDsl.g:2955:4: ( (lv_required_1_0= '@required' ) )
                    // InternalOperationDsl.g:2956:5: (lv_required_1_0= '@required' )
                    {
                    // InternalOperationDsl.g:2956:5: (lv_required_1_0= '@required' )
                    // InternalOperationDsl.g:2957:6: lv_required_1_0= '@required'
                    {
                    lv_required_1_0=(Token)match(input,59,FOLLOW_7); 

                    						newLeafNode(lv_required_1_0, grammarAccess.getApiParameterCommentAccess().getRequiredRequiredKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getApiParameterCommentRule());
                    						}
                    						setWithLastConsumed(current, "required", lv_required_1_0 != null, "@required");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:2970:4: ( (lv_returned_2_0= '@returned' ) )
                    {
                    // InternalOperationDsl.g:2970:4: ( (lv_returned_2_0= '@returned' ) )
                    // InternalOperationDsl.g:2971:5: (lv_returned_2_0= '@returned' )
                    {
                    // InternalOperationDsl.g:2971:5: (lv_returned_2_0= '@returned' )
                    // InternalOperationDsl.g:2972:6: lv_returned_2_0= '@returned'
                    {
                    lv_returned_2_0=(Token)match(input,60,FOLLOW_7); 

                    						newLeafNode(lv_returned_2_0, grammarAccess.getApiParameterCommentAccess().getReturnedReturnedKeyword_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getApiParameterCommentRule());
                    						}
                    						setWithLastConsumed(current, "returned", lv_returned_2_0 != null, "@returned");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:2985:3: ( (otherlv_3= RULE_ID ) )
            // InternalOperationDsl.g:2986:4: (otherlv_3= RULE_ID )
            {
            // InternalOperationDsl.g:2986:4: (otherlv_3= RULE_ID )
            // InternalOperationDsl.g:2987:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApiParameterCommentRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_71); 

            					newLeafNode(otherlv_3, grammarAccess.getApiParameterCommentAccess().getParameterParameterCrossReference_1_0());
            				

            }


            }

            // InternalOperationDsl.g:2998:3: ( (lv_comment_4_0= ruleAnything ) )
            // InternalOperationDsl.g:2999:4: (lv_comment_4_0= ruleAnything )
            {
            // InternalOperationDsl.g:2999:4: (lv_comment_4_0= ruleAnything )
            // InternalOperationDsl.g:3000:5: lv_comment_4_0= ruleAnything
            {

            					newCompositeNode(grammarAccess.getApiParameterCommentAccess().getCommentAnythingParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_comment_4_0=ruleAnything();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getApiParameterCommentRule());
            					}
            					set(
            						current,
            						"comment",
            						lv_comment_4_0,
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
    // InternalOperationDsl.g:3021:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalOperationDsl.g:3021:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalOperationDsl.g:3022:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalOperationDsl.g:3028:1: ruleOperation returns [EObject current=null] : ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' ) ;
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
            // InternalOperationDsl.g:3034:2: ( ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' ) )
            // InternalOperationDsl.g:3035:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' )
            {
            // InternalOperationDsl.g:3035:2: ( ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';' )
            // InternalOperationDsl.g:3036:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )? ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )? (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )? (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )? ( (lv_aspects_13_0= ruleImportedServiceAspect ) )* ( (lv_notImplemented_14_0= 'noimpl' ) )? ( (lv_visibility_15_0= ruleVisibility ) )? ( (lv_name_16_0= RULE_ID ) ) otherlv_17= '(' ( (lv_parameters_18_0= ruleParameter ) )? (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )* otherlv_21= ')' otherlv_22= ';'
            {
            // InternalOperationDsl.g:3036:3: ( (lv_apiOperationComment_0_0= ruleApiOperationComment ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==57) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalOperationDsl.g:3037:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    {
                    // InternalOperationDsl.g:3037:4: (lv_apiOperationComment_0_0= ruleApiOperationComment )
                    // InternalOperationDsl.g:3038:5: lv_apiOperationComment_0_0= ruleApiOperationComment
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getApiOperationCommentApiOperationCommentParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_73);
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

            // InternalOperationDsl.g:3055:3: ( ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )? )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==14) ) {
                int LA83_1 = input.LA(2);

                if ( ((LA83_1>=83 && LA83_1<=84)) ) {
                    alt83=1;
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalOperationDsl.g:3056:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) ) ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:3056:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:3057:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:3057:5: (lv_protocols_1_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:3058:6: lv_protocols_1_0= ruleProtocolSpecification
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_0_0());
                    					
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

                    // InternalOperationDsl.g:3075:4: ( (lv_protocols_2_0= ruleProtocolSpecification ) )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==14) ) {
                        int LA82_1 = input.LA(2);

                        if ( ((LA82_1>=83 && LA82_1<=84)) ) {
                            alt82=1;
                        }
                    }
                    switch (alt82) {
                        case 1 :
                            // InternalOperationDsl.g:3076:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:3076:5: (lv_protocols_2_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:3077:6: lv_protocols_2_0= ruleProtocolSpecification
                            {

                            						newCompositeNode(grammarAccess.getOperationAccess().getProtocolsProtocolSpecificationParserRuleCall_1_1_0());
                            					
                            pushFollow(FOLLOW_73);
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

            // InternalOperationDsl.g:3095:3: (otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==14) ) {
                int LA85_1 = input.LA(2);

                if ( (LA85_1==36) ) {
                    int LA85_3 = input.LA(3);

                    if ( (LA85_3==16) ) {
                        alt85=1;
                    }
                }
            }
            switch (alt85) {
                case 1 :
                    // InternalOperationDsl.g:3096:4: otherlv_3= '@' otherlv_4= 'endpoints' otherlv_5= '(' ( (lv_endpoints_6_0= ruleEndpoint ) )+ otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_4=(Token)match(input,36,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_5=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalOperationDsl.g:3108:4: ( (lv_endpoints_6_0= ruleEndpoint ) )+
                    int cnt84=0;
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==RULE_ID) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // InternalOperationDsl.g:3109:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:3109:5: (lv_endpoints_6_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:3110:6: lv_endpoints_6_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_53);
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
                    	    if ( cnt84 >= 1 ) break loop84;
                                EarlyExitException eee =
                                    new EarlyExitException(84, input);
                                throw eee;
                        }
                        cnt84++;
                    } while (true);

                    otherlv_7=(Token)match(input,17,FOLLOW_73); 

                    				newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:3132:3: (otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==14) ) {
                int LA87_1 = input.LA(2);

                if ( (LA87_1==36) ) {
                    alt87=1;
                }
            }
            switch (alt87) {
                case 1 :
                    // InternalOperationDsl.g:3133:4: otherlv_8= '@' otherlv_9= 'endpoints' otherlv_10= '({' ( (lv_endpoints_11_0= ruleEndpoint ) )+ otherlv_12= '})'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getCommercialAtKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,36,FOLLOW_54); 

                    				newLeafNode(otherlv_9, grammarAccess.getOperationAccess().getEndpointsKeyword_3_1());
                    			
                    otherlv_10=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationAccess().getLeftParenthesisLeftCurlyBracketKeyword_3_2());
                    			
                    // InternalOperationDsl.g:3145:4: ( (lv_endpoints_11_0= ruleEndpoint ) )+
                    int cnt86=0;
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==RULE_ID) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalOperationDsl.g:3146:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:3146:5: (lv_endpoints_11_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:3147:6: lv_endpoints_11_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getOperationAccess().getEndpointsEndpointParserRuleCall_3_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
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
                    	    if ( cnt86 >= 1 ) break loop86;
                                EarlyExitException eee =
                                    new EarlyExitException(86, input);
                                throw eee;
                        }
                        cnt86++;
                    } while (true);

                    otherlv_12=(Token)match(input,47,FOLLOW_73); 

                    				newLeafNode(otherlv_12, grammarAccess.getOperationAccess().getRightCurlyBracketRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:3169:3: ( (lv_aspects_13_0= ruleImportedServiceAspect ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==14) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalOperationDsl.g:3170:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:3170:4: (lv_aspects_13_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:3171:5: lv_aspects_13_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getOperationAccess().getAspectsImportedServiceAspectParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_73);
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
            	    break loop88;
                }
            } while (true);

            // InternalOperationDsl.g:3188:3: ( (lv_notImplemented_14_0= 'noimpl' ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==55) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalOperationDsl.g:3189:4: (lv_notImplemented_14_0= 'noimpl' )
                    {
                    // InternalOperationDsl.g:3189:4: (lv_notImplemented_14_0= 'noimpl' )
                    // InternalOperationDsl.g:3190:5: lv_notImplemented_14_0= 'noimpl'
                    {
                    lv_notImplemented_14_0=(Token)match(input,55,FOLLOW_74); 

                    					newLeafNode(lv_notImplemented_14_0, grammarAccess.getOperationAccess().getNotImplementedNoimplKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperationRule());
                    					}
                    					setWithLastConsumed(current, "notImplemented", lv_notImplemented_14_0 != null, "noimpl");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:3202:3: ( (lv_visibility_15_0= ruleVisibility ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=141 && LA90_0<=143)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalOperationDsl.g:3203:4: (lv_visibility_15_0= ruleVisibility )
                    {
                    // InternalOperationDsl.g:3203:4: (lv_visibility_15_0= ruleVisibility )
                    // InternalOperationDsl.g:3204:5: lv_visibility_15_0= ruleVisibility
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_7);
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

            // InternalOperationDsl.g:3221:3: ( (lv_name_16_0= RULE_ID ) )
            // InternalOperationDsl.g:3222:4: (lv_name_16_0= RULE_ID )
            {
            // InternalOperationDsl.g:3222:4: (lv_name_16_0= RULE_ID )
            // InternalOperationDsl.g:3223:5: lv_name_16_0= RULE_ID
            {
            lv_name_16_0=(Token)match(input,RULE_ID,FOLLOW_6); 

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

            otherlv_17=(Token)match(input,16,FOLLOW_75); 

            			newLeafNode(otherlv_17, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_8());
            		
            // InternalOperationDsl.g:3243:3: ( (lv_parameters_18_0= ruleParameter ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==14||(LA91_0>=83 && LA91_0<=84)) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalOperationDsl.g:3244:4: (lv_parameters_18_0= ruleParameter )
                    {
                    // InternalOperationDsl.g:3244:4: (lv_parameters_18_0= ruleParameter )
                    // InternalOperationDsl.g:3245:5: lv_parameters_18_0= ruleParameter
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_9_0());
                    				
                    pushFollow(FOLLOW_47);
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

            // InternalOperationDsl.g:3262:3: (otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==24) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalOperationDsl.g:3263:4: otherlv_19= ',' ( (lv_parameters_20_0= ruleParameter ) )
            	    {
            	    otherlv_19=(Token)match(input,24,FOLLOW_76); 

            	    				newLeafNode(otherlv_19, grammarAccess.getOperationAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalOperationDsl.g:3267:4: ( (lv_parameters_20_0= ruleParameter ) )
            	    // InternalOperationDsl.g:3268:5: (lv_parameters_20_0= ruleParameter )
            	    {
            	    // InternalOperationDsl.g:3268:5: (lv_parameters_20_0= ruleParameter )
            	    // InternalOperationDsl.g:3269:6: lv_parameters_20_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
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
            	    break loop92;
                }
            } while (true);

            otherlv_21=(Token)match(input,17,FOLLOW_48); 

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
    // InternalOperationDsl.g:3299:1: entryRuleReferredOperation returns [EObject current=null] : iv_ruleReferredOperation= ruleReferredOperation EOF ;
    public final EObject entryRuleReferredOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferredOperation = null;


        try {
            // InternalOperationDsl.g:3299:58: (iv_ruleReferredOperation= ruleReferredOperation EOF )
            // InternalOperationDsl.g:3300:2: iv_ruleReferredOperation= ruleReferredOperation EOF
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
    // InternalOperationDsl.g:3306:1: ruleReferredOperation returns [EObject current=null] : ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' ) ;
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
            // InternalOperationDsl.g:3312:2: ( ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' ) )
            // InternalOperationDsl.g:3313:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' )
            {
            // InternalOperationDsl.g:3313:2: ( ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';' )
            // InternalOperationDsl.g:3314:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )? (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )? (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )? ( (lv_aspects_12_0= ruleImportedServiceAspect ) )* otherlv_13= 'refers' ( ( ruleQualifiedName ) ) otherlv_15= ';'
            {
            // InternalOperationDsl.g:3314:3: ( ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )? )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==14) ) {
                int LA94_1 = input.LA(2);

                if ( ((LA94_1>=83 && LA94_1<=84)) ) {
                    alt94=1;
                }
            }
            switch (alt94) {
                case 1 :
                    // InternalOperationDsl.g:3315:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) ) ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    {
                    // InternalOperationDsl.g:3315:4: ( (lv_protocols_0_0= ruleProtocolSpecification ) )
                    // InternalOperationDsl.g:3316:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    {
                    // InternalOperationDsl.g:3316:5: (lv_protocols_0_0= ruleProtocolSpecification )
                    // InternalOperationDsl.g:3317:6: lv_protocols_0_0= ruleProtocolSpecification
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

                    // InternalOperationDsl.g:3334:4: ( (lv_protocols_1_0= ruleProtocolSpecification ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==14) ) {
                        int LA93_1 = input.LA(2);

                        if ( ((LA93_1>=83 && LA93_1<=84)) ) {
                            alt93=1;
                        }
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalOperationDsl.g:3335:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            {
                            // InternalOperationDsl.g:3335:5: (lv_protocols_1_0= ruleProtocolSpecification )
                            // InternalOperationDsl.g:3336:6: lv_protocols_1_0= ruleProtocolSpecification
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

            // InternalOperationDsl.g:3354:3: (otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==14) ) {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==36) ) {
                    int LA96_3 = input.LA(3);

                    if ( (LA96_3==16) ) {
                        alt96=1;
                    }
                }
            }
            switch (alt96) {
                case 1 :
                    // InternalOperationDsl.g:3355:4: otherlv_2= '@' otherlv_3= 'endpoints' otherlv_4= '(' ( (lv_endpoints_5_0= ruleEndpoint ) )+ otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,36,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_1_1());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getReferredOperationAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalOperationDsl.g:3367:4: ( (lv_endpoints_5_0= ruleEndpoint ) )+
                    int cnt95=0;
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==RULE_ID) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalOperationDsl.g:3368:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:3368:5: (lv_endpoints_5_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:3369:6: lv_endpoints_5_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_53);
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
                    	    if ( cnt95 >= 1 ) break loop95;
                                EarlyExitException eee =
                                    new EarlyExitException(95, input);
                                throw eee;
                        }
                        cnt95++;
                    } while (true);

                    otherlv_6=(Token)match(input,17,FOLLOW_77); 

                    				newLeafNode(otherlv_6, grammarAccess.getReferredOperationAccess().getRightParenthesisKeyword_1_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:3391:3: (otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==14) ) {
                int LA98_1 = input.LA(2);

                if ( (LA98_1==36) ) {
                    alt98=1;
                }
            }
            switch (alt98) {
                case 1 :
                    // InternalOperationDsl.g:3392:4: otherlv_7= '@' otherlv_8= 'endpoints' otherlv_9= '({' ( (lv_endpoints_10_0= ruleEndpoint ) )+ otherlv_11= '})'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_7, grammarAccess.getReferredOperationAccess().getCommercialAtKeyword_2_0());
                    			
                    otherlv_8=(Token)match(input,36,FOLLOW_54); 

                    				newLeafNode(otherlv_8, grammarAccess.getReferredOperationAccess().getEndpointsKeyword_2_1());
                    			
                    otherlv_9=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getReferredOperationAccess().getLeftParenthesisLeftCurlyBracketKeyword_2_2());
                    			
                    // InternalOperationDsl.g:3404:4: ( (lv_endpoints_10_0= ruleEndpoint ) )+
                    int cnt97=0;
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==RULE_ID) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalOperationDsl.g:3405:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    {
                    	    // InternalOperationDsl.g:3405:5: (lv_endpoints_10_0= ruleEndpoint )
                    	    // InternalOperationDsl.g:3406:6: lv_endpoints_10_0= ruleEndpoint
                    	    {

                    	    						newCompositeNode(grammarAccess.getReferredOperationAccess().getEndpointsEndpointParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
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
                    	    if ( cnt97 >= 1 ) break loop97;
                                EarlyExitException eee =
                                    new EarlyExitException(97, input);
                                throw eee;
                        }
                        cnt97++;
                    } while (true);

                    otherlv_11=(Token)match(input,47,FOLLOW_77); 

                    				newLeafNode(otherlv_11, grammarAccess.getReferredOperationAccess().getRightCurlyBracketRightParenthesisKeyword_2_4());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:3428:3: ( (lv_aspects_12_0= ruleImportedServiceAspect ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==14) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalOperationDsl.g:3429:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:3429:4: (lv_aspects_12_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:3430:5: lv_aspects_12_0= ruleImportedServiceAspect
            	    {

            	    					newCompositeNode(grammarAccess.getReferredOperationAccess().getAspectsImportedServiceAspectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_77);
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
            	    break loop99;
                }
            } while (true);

            otherlv_13=(Token)match(input,61,FOLLOW_7); 

            			newLeafNode(otherlv_13, grammarAccess.getReferredOperationAccess().getRefersKeyword_4());
            		
            // InternalOperationDsl.g:3451:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3452:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3452:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3453:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferredOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferredOperationAccess().getOperationOperationCrossReference_5_0());
            				
            pushFollow(FOLLOW_48);
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
    // InternalOperationDsl.g:3475:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalOperationDsl.g:3475:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalOperationDsl.g:3476:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalOperationDsl.g:3482:1: ruleParameter returns [EObject current=null] : ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) ;
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
            // InternalOperationDsl.g:3488:2: ( ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? ) )
            // InternalOperationDsl.g:3489:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            {
            // InternalOperationDsl.g:3489:2: ( ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )? )
            // InternalOperationDsl.g:3490:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )* ( (lv_communicationType_1_0= ruleCommunicationType ) ) ( (lv_exchangePattern_2_0= ruleExchangePattern ) )? ( (lv_communicatesFault_3_0= 'fault' ) )? ( (lv_name_4_0= RULE_ID ) ) ( (lv_optional_5_0= '?' ) )? otherlv_6= ':' ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) ) (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            {
            // InternalOperationDsl.g:3490:3: ( (lv_aspects_0_0= ruleImportedServiceAspect ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==14) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalOperationDsl.g:3491:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    {
            	    // InternalOperationDsl.g:3491:4: (lv_aspects_0_0= ruleImportedServiceAspect )
            	    // InternalOperationDsl.g:3492:5: lv_aspects_0_0= ruleImportedServiceAspect
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
            	    break loop100;
                }
            } while (true);

            // InternalOperationDsl.g:3509:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3510:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3510:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:3511:5: lv_communicationType_1_0= ruleCommunicationType
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

            // InternalOperationDsl.g:3528:3: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( ((LA101_0>=80 && LA101_0<=82)) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalOperationDsl.g:3529:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:3529:4: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:3530:5: lv_exchangePattern_2_0= ruleExchangePattern
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

            // InternalOperationDsl.g:3547:3: ( (lv_communicatesFault_3_0= 'fault' ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==62) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalOperationDsl.g:3548:4: (lv_communicatesFault_3_0= 'fault' )
                    {
                    // InternalOperationDsl.g:3548:4: (lv_communicatesFault_3_0= 'fault' )
                    // InternalOperationDsl.g:3549:5: lv_communicatesFault_3_0= 'fault'
                    {
                    lv_communicatesFault_3_0=(Token)match(input,62,FOLLOW_7); 

                    					newLeafNode(lv_communicatesFault_3_0, grammarAccess.getParameterAccess().getCommunicatesFaultFaultKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "communicatesFault", lv_communicatesFault_3_0 != null, "fault");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:3561:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalOperationDsl.g:3562:4: (lv_name_4_0= RULE_ID )
            {
            // InternalOperationDsl.g:3562:4: (lv_name_4_0= RULE_ID )
            // InternalOperationDsl.g:3563:5: lv_name_4_0= RULE_ID
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

            // InternalOperationDsl.g:3579:3: ( (lv_optional_5_0= '?' ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==63) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalOperationDsl.g:3580:4: (lv_optional_5_0= '?' )
                    {
                    // InternalOperationDsl.g:3580:4: (lv_optional_5_0= '?' )
                    // InternalOperationDsl.g:3581:5: lv_optional_5_0= '?'
                    {
                    lv_optional_5_0=(Token)match(input,63,FOLLOW_81); 

                    					newLeafNode(lv_optional_5_0, grammarAccess.getParameterAccess().getOptionalQuestionMarkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterRule());
                    					}
                    					setWithLastConsumed(current, "optional", lv_optional_5_0 != null, "?");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,40,FOLLOW_82); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getColonKeyword_6());
            		
            // InternalOperationDsl.g:3597:3: ( ( (lv_primitiveType_7_0= rulePrimitiveType ) ) | ( (lv_importedType_8_0= ruleImportedType ) ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( ((LA104_0>=131 && LA104_0<=140)||LA104_0==148) ) {
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
                    // InternalOperationDsl.g:3598:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:3598:4: ( (lv_primitiveType_7_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:3599:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:3599:5: (lv_primitiveType_7_0= rulePrimitiveType )
                    // InternalOperationDsl.g:3600:6: lv_primitiveType_7_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_83);
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
                    // InternalOperationDsl.g:3618:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    {
                    // InternalOperationDsl.g:3618:4: ( (lv_importedType_8_0= ruleImportedType ) )
                    // InternalOperationDsl.g:3619:5: (lv_importedType_8_0= ruleImportedType )
                    {
                    // InternalOperationDsl.g:3619:5: (lv_importedType_8_0= ruleImportedType )
                    // InternalOperationDsl.g:3620:6: lv_importedType_8_0= ruleImportedType
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getImportedTypeImportedTypeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_83);
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

            // InternalOperationDsl.g:3638:3: (otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==42) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalOperationDsl.g:3639:4: otherlv_9= '=' ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    {
                    otherlv_9=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getEqualsSignKeyword_8_0());
                    			
                    // InternalOperationDsl.g:3643:4: ( (lv_initializedByOperation_10_0= rulePossiblyImportedOperation ) )
                    // InternalOperationDsl.g:3644:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    {
                    // InternalOperationDsl.g:3644:5: (lv_initializedByOperation_10_0= rulePossiblyImportedOperation )
                    // InternalOperationDsl.g:3645:6: lv_initializedByOperation_10_0= rulePossiblyImportedOperation
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
    // InternalOperationDsl.g:3667:1: entryRuleImportedType returns [EObject current=null] : iv_ruleImportedType= ruleImportedType EOF ;
    public final EObject entryRuleImportedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedType = null;


        try {
            // InternalOperationDsl.g:3667:53: (iv_ruleImportedType= ruleImportedType EOF )
            // InternalOperationDsl.g:3668:2: iv_ruleImportedType= ruleImportedType EOF
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
    // InternalOperationDsl.g:3674:1: ruleImportedType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3680:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:3681:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:3681:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:3682:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:3682:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3683:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3683:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3684:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedTypeAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedTypeAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:3699:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3700:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3700:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3701:5: ruleQualifiedName
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
    // InternalOperationDsl.g:3719:1: entryRuleProtocolSpecification returns [EObject current=null] : iv_ruleProtocolSpecification= ruleProtocolSpecification EOF ;
    public final EObject entryRuleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSpecification = null;


        try {
            // InternalOperationDsl.g:3719:62: (iv_ruleProtocolSpecification= ruleProtocolSpecification EOF )
            // InternalOperationDsl.g:3720:2: iv_ruleProtocolSpecification= ruleProtocolSpecification EOF
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
    // InternalOperationDsl.g:3726:1: ruleProtocolSpecification returns [EObject current=null] : (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) ;
    public final EObject ruleProtocolSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_communicationType_1_0 = null;

        EObject lv_protocol_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:3732:2: ( (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' ) )
            // InternalOperationDsl.g:3733:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            {
            // InternalOperationDsl.g:3733:2: (otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')' )
            // InternalOperationDsl.g:3734:3: otherlv_0= '@' ( (lv_communicationType_1_0= ruleCommunicationType ) ) otherlv_2= '(' ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_76); 

            			newLeafNode(otherlv_0, grammarAccess.getProtocolSpecificationAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3738:3: ( (lv_communicationType_1_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:3739:4: (lv_communicationType_1_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:3739:4: (lv_communicationType_1_0= ruleCommunicationType )
            // InternalOperationDsl.g:3740:5: lv_communicationType_1_0= ruleCommunicationType
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

            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSpecificationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOperationDsl.g:3761:3: ( (lv_protocol_3_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3762:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3762:4: (lv_protocol_3_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3763:5: lv_protocol_3_0= ruleImportedProtocolAndDataFormat
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

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

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
    // InternalOperationDsl.g:3788:1: entryRuleImportedProtocolAndDataFormat returns [EObject current=null] : iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF ;
    public final EObject entryRuleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedProtocolAndDataFormat = null;


        try {
            // InternalOperationDsl.g:3788:70: (iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF )
            // InternalOperationDsl.g:3789:2: iv_ruleImportedProtocolAndDataFormat= ruleImportedProtocolAndDataFormat EOF
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
    // InternalOperationDsl.g:3795:1: ruleImportedProtocolAndDataFormat returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleImportedProtocolAndDataFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:3801:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? ) )
            // InternalOperationDsl.g:3802:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? )
            {
            // InternalOperationDsl.g:3802:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )? )
            // InternalOperationDsl.g:3803:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )?
            {
            // InternalOperationDsl.g:3803:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:3804:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:3804:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:3805:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedProtocolAndDataFormatAccess().getImportImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedProtocolAndDataFormatAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:3820:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:3821:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:3821:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:3822:5: ruleQualifiedName
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

            // InternalOperationDsl.g:3836:3: (otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==16) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalOperationDsl.g:3837:4: otherlv_3= '(' ( (otherlv_4= RULE_STRING ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_14); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportedProtocolAndDataFormatAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:3841:4: ( (otherlv_4= RULE_STRING ) )
                    // InternalOperationDsl.g:3842:5: (otherlv_4= RULE_STRING )
                    {
                    // InternalOperationDsl.g:3842:5: (otherlv_4= RULE_STRING )
                    // InternalOperationDsl.g:3843:6: otherlv_4= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getImportedProtocolAndDataFormatRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_8); 

                    						newLeafNode(otherlv_4, grammarAccess.getImportedProtocolAndDataFormatAccess().getDataFormatDataFormatCrossReference_3_1_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,17,FOLLOW_2); 

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
    // InternalOperationDsl.g:3863:1: entryRuleEndpoint returns [EObject current=null] : iv_ruleEndpoint= ruleEndpoint EOF ;
    public final EObject entryRuleEndpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpoint = null;


        try {
            // InternalOperationDsl.g:3863:49: (iv_ruleEndpoint= ruleEndpoint EOF )
            // InternalOperationDsl.g:3864:2: iv_ruleEndpoint= ruleEndpoint EOF
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
    // InternalOperationDsl.g:3870:1: ruleEndpoint returns [EObject current=null] : ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) ;
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
            // InternalOperationDsl.g:3876:2: ( ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' ) )
            // InternalOperationDsl.g:3877:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            {
            // InternalOperationDsl.g:3877:2: ( ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';' )
            // InternalOperationDsl.g:3878:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) ) (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )* otherlv_3= ':' ( (lv_addresses_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )* otherlv_7= ';'
            {
            // InternalOperationDsl.g:3878:3: ( (lv_protocols_0_0= ruleImportedProtocolAndDataFormat ) )
            // InternalOperationDsl.g:3879:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            {
            // InternalOperationDsl.g:3879:4: (lv_protocols_0_0= ruleImportedProtocolAndDataFormat )
            // InternalOperationDsl.g:3880:5: lv_protocols_0_0= ruleImportedProtocolAndDataFormat
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
            						"de.fhdo.lemma.ServiceDsl.ImportedProtocolAndDataFormat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:3897:3: (otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==24) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalOperationDsl.g:3898:4: otherlv_1= ',' ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getEndpointAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:3902:4: ( (lv_protocols_2_0= ruleImportedProtocolAndDataFormat ) )
            	    // InternalOperationDsl.g:3903:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    {
            	    // InternalOperationDsl.g:3903:5: (lv_protocols_2_0= ruleImportedProtocolAndDataFormat )
            	    // InternalOperationDsl.g:3904:6: lv_protocols_2_0= ruleImportedProtocolAndDataFormat
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
            	    							"de.fhdo.lemma.ServiceDsl.ImportedProtocolAndDataFormat");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getEndpointAccess().getColonKeyword_2());
            		
            // InternalOperationDsl.g:3926:3: ( (lv_addresses_4_0= RULE_STRING ) )
            // InternalOperationDsl.g:3927:4: (lv_addresses_4_0= RULE_STRING )
            {
            // InternalOperationDsl.g:3927:4: (lv_addresses_4_0= RULE_STRING )
            // InternalOperationDsl.g:3928:5: lv_addresses_4_0= RULE_STRING
            {
            lv_addresses_4_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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

            // InternalOperationDsl.g:3944:3: (otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==24) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalOperationDsl.g:3945:4: otherlv_5= ',' ( (lv_addresses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEndpointAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalOperationDsl.g:3949:4: ( (lv_addresses_6_0= RULE_STRING ) )
            	    // InternalOperationDsl.g:3950:5: (lv_addresses_6_0= RULE_STRING )
            	    {
            	    // InternalOperationDsl.g:3950:5: (lv_addresses_6_0= RULE_STRING )
            	    // InternalOperationDsl.g:3951:6: lv_addresses_6_0= RULE_STRING
            	    {
            	    lv_addresses_6_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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
            	    break loop108;
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
    // InternalOperationDsl.g:3976:1: entryRuleImportedServiceAspect returns [EObject current=null] : iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF ;
    public final EObject entryRuleImportedServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedServiceAspect = null;


        try {
            // InternalOperationDsl.g:3976:62: (iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF )
            // InternalOperationDsl.g:3977:2: iv_ruleImportedServiceAspect= ruleImportedServiceAspect EOF
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
    // InternalOperationDsl.g:3983:1: ruleImportedServiceAspect returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) ;
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
            // InternalOperationDsl.g:3989:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? ) )
            // InternalOperationDsl.g:3990:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            {
            // InternalOperationDsl.g:3990:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )? )
            // InternalOperationDsl.g:3991:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportedServiceAspectAccess().getCommercialAtKeyword_0());
            		
            // InternalOperationDsl.g:3995:3: ( (otherlv_1= RULE_ID ) )
            // InternalOperationDsl.g:3996:4: (otherlv_1= RULE_ID )
            {
            // InternalOperationDsl.g:3996:4: (otherlv_1= RULE_ID )
            // InternalOperationDsl.g:3997:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_1, grammarAccess.getImportedServiceAspectAccess().getImportImportCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportedServiceAspectAccess().getColonColonKeyword_2());
            		
            // InternalOperationDsl.g:4012:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:4013:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:4013:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:4014:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedServiceAspectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportedServiceAspectAccess().getImportedAspectServiceAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_39);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOperationDsl.g:4028:3: (otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')' )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==16) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalOperationDsl.g:4029:4: otherlv_4= '(' ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,16,FOLLOW_46); 

                    				newLeafNode(otherlv_4, grammarAccess.getImportedServiceAspectAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalOperationDsl.g:4033:4: ( ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) ) | ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* ) )
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( ((LA110_0>=RULE_STRING && LA110_0<=RULE_BOOLEAN)||LA110_0==RULE_BIG_DECIMAL) ) {
                        alt110=1;
                    }
                    else if ( (LA110_0==RULE_ID) ) {
                        alt110=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 110, 0, input);

                        throw nvae;
                    }
                    switch (alt110) {
                        case 1 :
                            // InternalOperationDsl.g:4034:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            {
                            // InternalOperationDsl.g:4034:5: ( (lv_singlePropertyValue_5_0= rulePrimitiveValue ) )
                            // InternalOperationDsl.g:4035:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            {
                            // InternalOperationDsl.g:4035:6: (lv_singlePropertyValue_5_0= rulePrimitiveValue )
                            // InternalOperationDsl.g:4036:7: lv_singlePropertyValue_5_0= rulePrimitiveValue
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
                            // InternalOperationDsl.g:4054:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            {
                            // InternalOperationDsl.g:4054:5: ( ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )* )
                            // InternalOperationDsl.g:4055:6: ( (lv_values_6_0= rulePropertyValueAssignment ) ) (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            {
                            // InternalOperationDsl.g:4055:6: ( (lv_values_6_0= rulePropertyValueAssignment ) )
                            // InternalOperationDsl.g:4056:7: (lv_values_6_0= rulePropertyValueAssignment )
                            {
                            // InternalOperationDsl.g:4056:7: (lv_values_6_0= rulePropertyValueAssignment )
                            // InternalOperationDsl.g:4057:8: lv_values_6_0= rulePropertyValueAssignment
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
                            									"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalOperationDsl.g:4074:6: (otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) ) )*
                            loop109:
                            do {
                                int alt109=2;
                                int LA109_0 = input.LA(1);

                                if ( (LA109_0==24) ) {
                                    alt109=1;
                                }


                                switch (alt109) {
                            	case 1 :
                            	    // InternalOperationDsl.g:4075:7: otherlv_7= ',' ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    {
                            	    otherlv_7=(Token)match(input,24,FOLLOW_7); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getImportedServiceAspectAccess().getCommaKeyword_4_1_1_1_0());
                            	    						
                            	    // InternalOperationDsl.g:4079:7: ( (lv_values_8_0= rulePropertyValueAssignment ) )
                            	    // InternalOperationDsl.g:4080:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    {
                            	    // InternalOperationDsl.g:4080:8: (lv_values_8_0= rulePropertyValueAssignment )
                            	    // InternalOperationDsl.g:4081:9: lv_values_8_0= rulePropertyValueAssignment
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
                            	    										"de.fhdo.lemma.operationdsl.OperationDsl.PropertyValueAssignment");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop109;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_2); 

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
    // InternalOperationDsl.g:4110:1: entryRuleQualifiedNameWithAtLeastOneLevel returns [String current=null] : iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF ;
    public final String entryRuleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithAtLeastOneLevel = null;


        try {
            // InternalOperationDsl.g:4110:72: (iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF )
            // InternalOperationDsl.g:4111:2: iv_ruleQualifiedNameWithAtLeastOneLevel= ruleQualifiedNameWithAtLeastOneLevel EOF
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
    // InternalOperationDsl.g:4117:1: ruleQualifiedNameWithAtLeastOneLevel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithAtLeastOneLevel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:4123:2: ( (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName ) )
            // InternalOperationDsl.g:4124:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            {
            // InternalOperationDsl.g:4124:2: (this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName )
            // InternalOperationDsl.g:4125:3: this_ID_0= RULE_ID kw= '.' this_QualifiedName_2= ruleQualifiedName
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_84); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameWithAtLeastOneLevelAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,64,FOLLOW_7); 

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
    // InternalOperationDsl.g:4151:1: entryRuleAnything returns [String current=null] : iv_ruleAnything= ruleAnything EOF ;
    public final String entryRuleAnything() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnything = null;


        try {
            // InternalOperationDsl.g:4151:48: (iv_ruleAnything= ruleAnything EOF )
            // InternalOperationDsl.g:4152:2: iv_ruleAnything= ruleAnything EOF
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
    // InternalOperationDsl.g:4158:1: ruleAnything returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'returned' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+ ;
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
            // InternalOperationDsl.g:4164:2: ( (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'returned' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+ )
            // InternalOperationDsl.g:4165:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'returned' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+
            {
            // InternalOperationDsl.g:4165:2: (kw= '{' | kw= '}' | kw= '<' | kw= '>' | kw= ',' | kw= '(' | kw= ')' | kw= '::' | kw= '.' | kw= '-' | kw= '--' | kw= '/' | kw= '?' | kw= ':' | kw= '@' | kw= '=' | kw= ';' | kw= 'technology' | kw= 'types' | kw= 'compatibility' | kw= 'matrix' | kw= 'protocols' | kw= 'service' | kw= 'aspects' | kw= 'deployment' | kw= 'technologies' | kw= 'infrastructure' | kw= 'operation' | kw= 'import' | kw= 'from' | kw= 'as' | kw= 'data' | kw= 'formats' | kw= 'default' | kw= 'with' | kw= 'format' | kw= 'in' | kw= 'out' | kw= 'inout' | kw= 'sync' | kw= 'async' | kw= 'primitive' | kw= 'type' | kw= 'based' | kw= 'on' | kw= 'collection' | kw= 'structure' | kw= '->' | kw= '<-' | kw= '<->' | kw= 'environments' | kw= 'properties' | kw= 'mandatory' | kw= 'singleval' | kw= 'microservices' | kw= 'interfaces' | kw= 'operations' | kw= 'parameters' | kw= 'fields' | kw= 'exchange_pattern' | kw= 'communication_type' | kw= 'protocol' | kw= 'data_format' | kw= 'aspect' | kw= 'for' | kw= 'containers' | (kw= 'selector' kw= 'datatypes' ) | kw= 'version' | kw= 'context' | kw= 'aggregate' | kw= 'applicationService' | kw= 'domainEvent' | kw= 'domainService' | kw= 'entity' | kw= 'factory' | kw= 'infrastructureService' | kw= 'repository' | kw= 'specification' | kw= 'valueObject' | kw= 'extends' | kw= 'identifier' | kw= 'neverEmpty' | kw= 'part' | kw= 'hide' | kw= 'immutable' | kw= 'enum' | kw= 'closure' | kw= 'sideEffectFree' | kw= 'validator' | kw= 'function' | kw= 'procedure' | kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'date' | kw= 'double' | kw= 'float' | kw= 'int' | kw= 'long' | kw= 'short' | kw= 'string' | kw= 'internal' | kw= 'architecture' | kw= 'public' | kw= 'endpoints' | kw= 'microservice' | kw= 'required' | kw= 'returned' | kw= 'typedef' | kw= 'noimpl' | kw= 'interface' | kw= 'param' | kw= 'refers' | kw= 'fault' | kw= 'functional' | kw= 'utility' | this_BOOLEAN_117= RULE_BOOLEAN | this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD | this_BIG_DECIMAL_119= RULE_BIG_DECIMAL | this_ID_120= RULE_ID | this_STRING_121= RULE_STRING | this_ANY_OTHER_122= RULE_ANY_OTHER )+
            int cnt112=0;
            loop112:
            do {
                int alt112=123;
                switch ( input.LA(1) ) {
                case 30:
                    {
                    alt112=1;
                    }
                    break;
                case 32:
                    {
                    alt112=2;
                    }
                    break;
                case 65:
                    {
                    alt112=3;
                    }
                    break;
                case 66:
                    {
                    alt112=4;
                    }
                    break;
                case 24:
                    {
                    alt112=5;
                    }
                    break;
                case 16:
                    {
                    alt112=6;
                    }
                    break;
                case 17:
                    {
                    alt112=7;
                    }
                    break;
                case 37:
                    {
                    alt112=8;
                    }
                    break;
                case 64:
                    {
                    alt112=9;
                    }
                    break;
                case 67:
                    {
                    alt112=10;
                    }
                    break;
                case 68:
                    {
                    alt112=11;
                    }
                    break;
                case 69:
                    {
                    alt112=12;
                    }
                    break;
                case 63:
                    {
                    alt112=13;
                    }
                    break;
                case 40:
                    {
                    alt112=14;
                    }
                    break;
                case 14:
                    {
                    alt112=15;
                    }
                    break;
                case 42:
                    {
                    alt112=16;
                    }
                    break;
                case 41:
                    {
                    alt112=17;
                    }
                    break;
                case 15:
                    {
                    alt112=18;
                    }
                    break;
                case 70:
                    {
                    alt112=19;
                    }
                    break;
                case 71:
                    {
                    alt112=20;
                    }
                    break;
                case 72:
                    {
                    alt112=21;
                    }
                    break;
                case 73:
                    {
                    alt112=22;
                    }
                    break;
                case 74:
                    {
                    alt112=23;
                    }
                    break;
                case 31:
                    {
                    alt112=24;
                    }
                    break;
                case 19:
                    {
                    alt112=25;
                    }
                    break;
                case 75:
                    {
                    alt112=26;
                    }
                    break;
                case 76:
                    {
                    alt112=27;
                    }
                    break;
                case 21:
                    {
                    alt112=28;
                    }
                    break;
                case 43:
                    {
                    alt112=29;
                    }
                    break;
                case 44:
                    {
                    alt112=30;
                    }
                    break;
                case 45:
                    {
                    alt112=31;
                    }
                    break;
                case 77:
                    {
                    alt112=32;
                    }
                    break;
                case 78:
                    {
                    alt112=33;
                    }
                    break;
                case 33:
                    {
                    alt112=34;
                    }
                    break;
                case 20:
                    {
                    alt112=35;
                    }
                    break;
                case 79:
                    {
                    alt112=36;
                    }
                    break;
                case 80:
                    {
                    alt112=37;
                    }
                    break;
                case 81:
                    {
                    alt112=38;
                    }
                    break;
                case 82:
                    {
                    alt112=39;
                    }
                    break;
                case 83:
                    {
                    alt112=40;
                    }
                    break;
                case 84:
                    {
                    alt112=41;
                    }
                    break;
                case 85:
                    {
                    alt112=42;
                    }
                    break;
                case 86:
                    {
                    alt112=43;
                    }
                    break;
                case 87:
                    {
                    alt112=44;
                    }
                    break;
                case 26:
                    {
                    alt112=45;
                    }
                    break;
                case 88:
                    {
                    alt112=46;
                    }
                    break;
                case 89:
                    {
                    alt112=47;
                    }
                    break;
                case 90:
                    {
                    alt112=48;
                    }
                    break;
                case 91:
                    {
                    alt112=49;
                    }
                    break;
                case 92:
                    {
                    alt112=50;
                    }
                    break;
                case 93:
                    {
                    alt112=51;
                    }
                    break;
                case 94:
                    {
                    alt112=52;
                    }
                    break;
                case 95:
                    {
                    alt112=53;
                    }
                    break;
                case 96:
                    {
                    alt112=54;
                    }
                    break;
                case 51:
                    {
                    alt112=55;
                    }
                    break;
                case 52:
                    {
                    alt112=56;
                    }
                    break;
                case 53:
                    {
                    alt112=57;
                    }
                    break;
                case 97:
                    {
                    alt112=58;
                    }
                    break;
                case 98:
                    {
                    alt112=59;
                    }
                    break;
                case 99:
                    {
                    alt112=60;
                    }
                    break;
                case 100:
                    {
                    alt112=61;
                    }
                    break;
                case 101:
                    {
                    alt112=62;
                    }
                    break;
                case 102:
                    {
                    alt112=63;
                    }
                    break;
                case 103:
                    {
                    alt112=64;
                    }
                    break;
                case 104:
                    {
                    alt112=65;
                    }
                    break;
                case 105:
                    {
                    alt112=66;
                    }
                    break;
                case 106:
                    {
                    alt112=67;
                    }
                    break;
                case 49:
                    {
                    alt112=68;
                    }
                    break;
                case 108:
                    {
                    alt112=69;
                    }
                    break;
                case 109:
                    {
                    alt112=70;
                    }
                    break;
                case 110:
                    {
                    alt112=71;
                    }
                    break;
                case 111:
                    {
                    alt112=72;
                    }
                    break;
                case 112:
                    {
                    alt112=73;
                    }
                    break;
                case 113:
                    {
                    alt112=74;
                    }
                    break;
                case 114:
                    {
                    alt112=75;
                    }
                    break;
                case 115:
                    {
                    alt112=76;
                    }
                    break;
                case 116:
                    {
                    alt112=77;
                    }
                    break;
                case 117:
                    {
                    alt112=78;
                    }
                    break;
                case 118:
                    {
                    alt112=79;
                    }
                    break;
                case 119:
                    {
                    alt112=80;
                    }
                    break;
                case 120:
                    {
                    alt112=81;
                    }
                    break;
                case 121:
                    {
                    alt112=82;
                    }
                    break;
                case 122:
                    {
                    alt112=83;
                    }
                    break;
                case 123:
                    {
                    alt112=84;
                    }
                    break;
                case 124:
                    {
                    alt112=85;
                    }
                    break;
                case 125:
                    {
                    alt112=86;
                    }
                    break;
                case 126:
                    {
                    alt112=87;
                    }
                    break;
                case 127:
                    {
                    alt112=88;
                    }
                    break;
                case 128:
                    {
                    alt112=89;
                    }
                    break;
                case 129:
                    {
                    alt112=90;
                    }
                    break;
                case 130:
                    {
                    alt112=91;
                    }
                    break;
                case 131:
                    {
                    alt112=92;
                    }
                    break;
                case 132:
                    {
                    alt112=93;
                    }
                    break;
                case 133:
                    {
                    alt112=94;
                    }
                    break;
                case 134:
                    {
                    alt112=95;
                    }
                    break;
                case 135:
                    {
                    alt112=96;
                    }
                    break;
                case 136:
                    {
                    alt112=97;
                    }
                    break;
                case 137:
                    {
                    alt112=98;
                    }
                    break;
                case 138:
                    {
                    alt112=99;
                    }
                    break;
                case 139:
                    {
                    alt112=100;
                    }
                    break;
                case 140:
                    {
                    alt112=101;
                    }
                    break;
                case 141:
                    {
                    alt112=102;
                    }
                    break;
                case 142:
                    {
                    alt112=103;
                    }
                    break;
                case 143:
                    {
                    alt112=104;
                    }
                    break;
                case 36:
                    {
                    alt112=105;
                    }
                    break;
                case 48:
                    {
                    alt112=106;
                    }
                    break;
                case 50:
                    {
                    alt112=107;
                    }
                    break;
                case 144:
                    {
                    alt112=108;
                    }
                    break;
                case 54:
                    {
                    alt112=109;
                    }
                    break;
                case 55:
                    {
                    alt112=110;
                    }
                    break;
                case 56:
                    {
                    alt112=111;
                    }
                    break;
                case 145:
                    {
                    alt112=112;
                    }
                    break;
                case 61:
                    {
                    alt112=113;
                    }
                    break;
                case 62:
                    {
                    alt112=114;
                    }
                    break;
                case 146:
                    {
                    alt112=115;
                    }
                    break;
                case 147:
                    {
                    alt112=116;
                    }
                    break;
                case RULE_BOOLEAN:
                    {
                    alt112=117;
                    }
                    break;
                case RULE_NUMBER_WITH_TRAILING_PERIOD:
                    {
                    alt112=118;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt112=119;
                    }
                    break;
                case RULE_ID:
                    {
                    alt112=120;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt112=121;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt112=122;
                    }
                    break;

                }

                switch (alt112) {
            	case 1 :
            	    // InternalOperationDsl.g:4166:3: kw= '{'
            	    {
            	    kw=(Token)match(input,30,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftCurlyBracketKeyword_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalOperationDsl.g:4172:3: kw= '}'
            	    {
            	    kw=(Token)match(input,32,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightCurlyBracketKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalOperationDsl.g:4178:3: kw= '<'
            	    {
            	    kw=(Token)match(input,65,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignKeyword_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalOperationDsl.g:4184:3: kw= '>'
            	    {
            	    kw=(Token)match(input,66,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getGreaterThanSignKeyword_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalOperationDsl.g:4190:3: kw= ','
            	    {
            	    kw=(Token)match(input,24,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommaKeyword_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalOperationDsl.g:4196:3: kw= '('
            	    {
            	    kw=(Token)match(input,16,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLeftParenthesisKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalOperationDsl.g:4202:3: kw= ')'
            	    {
            	    kw=(Token)match(input,17,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRightParenthesisKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalOperationDsl.g:4208:3: kw= '::'
            	    {
            	    kw=(Token)match(input,37,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonColonKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalOperationDsl.g:4214:3: kw= '.'
            	    {
            	    kw=(Token)match(input,64,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFullStopKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalOperationDsl.g:4220:3: kw= '-'
            	    {
            	    kw=(Token)match(input,67,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalOperationDsl.g:4226:3: kw= '--'
            	    {
            	    kw=(Token)match(input,68,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusHyphenMinusKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalOperationDsl.g:4232:3: kw= '/'
            	    {
            	    kw=(Token)match(input,69,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSolidusKeyword_11());
            	    		

            	    }
            	    break;
            	case 13 :
            	    // InternalOperationDsl.g:4238:3: kw= '?'
            	    {
            	    kw=(Token)match(input,63,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getQuestionMarkKeyword_12());
            	    		

            	    }
            	    break;
            	case 14 :
            	    // InternalOperationDsl.g:4244:3: kw= ':'
            	    {
            	    kw=(Token)match(input,40,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getColonKeyword_13());
            	    		

            	    }
            	    break;
            	case 15 :
            	    // InternalOperationDsl.g:4250:3: kw= '@'
            	    {
            	    kw=(Token)match(input,14,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommercialAtKeyword_14());
            	    		

            	    }
            	    break;
            	case 16 :
            	    // InternalOperationDsl.g:4256:3: kw= '='
            	    {
            	    kw=(Token)match(input,42,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEqualsSignKeyword_15());
            	    		

            	    }
            	    break;
            	case 17 :
            	    // InternalOperationDsl.g:4262:3: kw= ';'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSemicolonKeyword_16());
            	    		

            	    }
            	    break;
            	case 18 :
            	    // InternalOperationDsl.g:4268:3: kw= 'technology'
            	    {
            	    kw=(Token)match(input,15,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologyKeyword_17());
            	    		

            	    }
            	    break;
            	case 19 :
            	    // InternalOperationDsl.g:4274:3: kw= 'types'
            	    {
            	    kw=(Token)match(input,70,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypesKeyword_18());
            	    		

            	    }
            	    break;
            	case 20 :
            	    // InternalOperationDsl.g:4280:3: kw= 'compatibility'
            	    {
            	    kw=(Token)match(input,71,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCompatibilityKeyword_19());
            	    		

            	    }
            	    break;
            	case 21 :
            	    // InternalOperationDsl.g:4286:3: kw= 'matrix'
            	    {
            	    kw=(Token)match(input,72,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMatrixKeyword_20());
            	    		

            	    }
            	    break;
            	case 22 :
            	    // InternalOperationDsl.g:4292:3: kw= 'protocols'
            	    {
            	    kw=(Token)match(input,73,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolsKeyword_21());
            	    		

            	    }
            	    break;
            	case 23 :
            	    // InternalOperationDsl.g:4298:3: kw= 'service'
            	    {
            	    kw=(Token)match(input,74,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getServiceKeyword_22());
            	    		

            	    }
            	    break;
            	case 24 :
            	    // InternalOperationDsl.g:4304:3: kw= 'aspects'
            	    {
            	    kw=(Token)match(input,31,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectsKeyword_23());
            	    		

            	    }
            	    break;
            	case 25 :
            	    // InternalOperationDsl.g:4310:3: kw= 'deployment'
            	    {
            	    kw=(Token)match(input,19,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDeploymentKeyword_24());
            	    		

            	    }
            	    break;
            	case 26 :
            	    // InternalOperationDsl.g:4316:3: kw= 'technologies'
            	    {
            	    kw=(Token)match(input,75,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTechnologiesKeyword_25());
            	    		

            	    }
            	    break;
            	case 27 :
            	    // InternalOperationDsl.g:4322:3: kw= 'infrastructure'
            	    {
            	    kw=(Token)match(input,76,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureKeyword_26());
            	    		

            	    }
            	    break;
            	case 28 :
            	    // InternalOperationDsl.g:4328:3: kw= 'operation'
            	    {
            	    kw=(Token)match(input,21,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationKeyword_27());
            	    		

            	    }
            	    break;
            	case 29 :
            	    // InternalOperationDsl.g:4334:3: kw= 'import'
            	    {
            	    kw=(Token)match(input,43,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImportKeyword_28());
            	    		

            	    }
            	    break;
            	case 30 :
            	    // InternalOperationDsl.g:4340:3: kw= 'from'
            	    {
            	    kw=(Token)match(input,44,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFromKeyword_29());
            	    		

            	    }
            	    break;
            	case 31 :
            	    // InternalOperationDsl.g:4346:3: kw= 'as'
            	    {
            	    kw=(Token)match(input,45,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsKeyword_30());
            	    		

            	    }
            	    break;
            	case 32 :
            	    // InternalOperationDsl.g:4352:3: kw= 'data'
            	    {
            	    kw=(Token)match(input,77,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDataKeyword_31());
            	    		

            	    }
            	    break;
            	case 33 :
            	    // InternalOperationDsl.g:4358:3: kw= 'formats'
            	    {
            	    kw=(Token)match(input,78,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatsKeyword_32());
            	    		

            	    }
            	    break;
            	case 34 :
            	    // InternalOperationDsl.g:4364:3: kw= 'default'
            	    {
            	    kw=(Token)match(input,33,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDefaultKeyword_33());
            	    		

            	    }
            	    break;
            	case 35 :
            	    // InternalOperationDsl.g:4370:3: kw= 'with'
            	    {
            	    kw=(Token)match(input,20,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getWithKeyword_34());
            	    		

            	    }
            	    break;
            	case 36 :
            	    // InternalOperationDsl.g:4376:3: kw= 'format'
            	    {
            	    kw=(Token)match(input,79,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFormatKeyword_35());
            	    		

            	    }
            	    break;
            	case 37 :
            	    // InternalOperationDsl.g:4382:3: kw= 'in'
            	    {
            	    kw=(Token)match(input,80,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInKeyword_36());
            	    		

            	    }
            	    break;
            	case 38 :
            	    // InternalOperationDsl.g:4388:3: kw= 'out'
            	    {
            	    kw=(Token)match(input,81,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOutKeyword_37());
            	    		

            	    }
            	    break;
            	case 39 :
            	    // InternalOperationDsl.g:4394:3: kw= 'inout'
            	    {
            	    kw=(Token)match(input,82,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInoutKeyword_38());
            	    		

            	    }
            	    break;
            	case 40 :
            	    // InternalOperationDsl.g:4400:3: kw= 'sync'
            	    {
            	    kw=(Token)match(input,83,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSyncKeyword_39());
            	    		

            	    }
            	    break;
            	case 41 :
            	    // InternalOperationDsl.g:4406:3: kw= 'async'
            	    {
            	    kw=(Token)match(input,84,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAsyncKeyword_40());
            	    		

            	    }
            	    break;
            	case 42 :
            	    // InternalOperationDsl.g:4412:3: kw= 'primitive'
            	    {
            	    kw=(Token)match(input,85,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPrimitiveKeyword_41());
            	    		

            	    }
            	    break;
            	case 43 :
            	    // InternalOperationDsl.g:4418:3: kw= 'type'
            	    {
            	    kw=(Token)match(input,86,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypeKeyword_42());
            	    		

            	    }
            	    break;
            	case 44 :
            	    // InternalOperationDsl.g:4424:3: kw= 'based'
            	    {
            	    kw=(Token)match(input,87,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBasedKeyword_43());
            	    		

            	    }
            	    break;
            	case 45 :
            	    // InternalOperationDsl.g:4430:3: kw= 'on'
            	    {
            	    kw=(Token)match(input,26,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOnKeyword_44());
            	    		

            	    }
            	    break;
            	case 46 :
            	    // InternalOperationDsl.g:4436:3: kw= 'collection'
            	    {
            	    kw=(Token)match(input,88,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCollectionKeyword_45());
            	    		

            	    }
            	    break;
            	case 47 :
            	    // InternalOperationDsl.g:4442:3: kw= 'structure'
            	    {
            	    kw=(Token)match(input,89,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStructureKeyword_46());
            	    		

            	    }
            	    break;
            	case 48 :
            	    // InternalOperationDsl.g:4448:3: kw= '->'
            	    {
            	    kw=(Token)match(input,90,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHyphenMinusGreaterThanSignKeyword_47());
            	    		

            	    }
            	    break;
            	case 49 :
            	    // InternalOperationDsl.g:4454:3: kw= '<-'
            	    {
            	    kw=(Token)match(input,91,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusKeyword_48());
            	    		

            	    }
            	    break;
            	case 50 :
            	    // InternalOperationDsl.g:4460:3: kw= '<->'
            	    {
            	    kw=(Token)match(input,92,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_49());
            	    		

            	    }
            	    break;
            	case 51 :
            	    // InternalOperationDsl.g:4466:3: kw= 'environments'
            	    {
            	    kw=(Token)match(input,93,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnvironmentsKeyword_50());
            	    		

            	    }
            	    break;
            	case 52 :
            	    // InternalOperationDsl.g:4472:3: kw= 'properties'
            	    {
            	    kw=(Token)match(input,94,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPropertiesKeyword_51());
            	    		

            	    }
            	    break;
            	case 53 :
            	    // InternalOperationDsl.g:4478:3: kw= 'mandatory'
            	    {
            	    kw=(Token)match(input,95,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMandatoryKeyword_52());
            	    		

            	    }
            	    break;
            	case 54 :
            	    // InternalOperationDsl.g:4484:3: kw= 'singleval'
            	    {
            	    kw=(Token)match(input,96,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSinglevalKeyword_53());
            	    		

            	    }
            	    break;
            	case 55 :
            	    // InternalOperationDsl.g:4490:3: kw= 'microservices'
            	    {
            	    kw=(Token)match(input,51,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroservicesKeyword_54());
            	    		

            	    }
            	    break;
            	case 56 :
            	    // InternalOperationDsl.g:4496:3: kw= 'interfaces'
            	    {
            	    kw=(Token)match(input,52,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfacesKeyword_55());
            	    		

            	    }
            	    break;
            	case 57 :
            	    // InternalOperationDsl.g:4502:3: kw= 'operations'
            	    {
            	    kw=(Token)match(input,53,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getOperationsKeyword_56());
            	    		

            	    }
            	    break;
            	case 58 :
            	    // InternalOperationDsl.g:4508:3: kw= 'parameters'
            	    {
            	    kw=(Token)match(input,97,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParametersKeyword_57());
            	    		

            	    }
            	    break;
            	case 59 :
            	    // InternalOperationDsl.g:4514:3: kw= 'fields'
            	    {
            	    kw=(Token)match(input,98,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFieldsKeyword_58());
            	    		

            	    }
            	    break;
            	case 60 :
            	    // InternalOperationDsl.g:4520:3: kw= 'exchange_pattern'
            	    {
            	    kw=(Token)match(input,99,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExchange_patternKeyword_59());
            	    		

            	    }
            	    break;
            	case 61 :
            	    // InternalOperationDsl.g:4526:3: kw= 'communication_type'
            	    {
            	    kw=(Token)match(input,100,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCommunication_typeKeyword_60());
            	    		

            	    }
            	    break;
            	case 62 :
            	    // InternalOperationDsl.g:4532:3: kw= 'protocol'
            	    {
            	    kw=(Token)match(input,101,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProtocolKeyword_61());
            	    		

            	    }
            	    break;
            	case 63 :
            	    // InternalOperationDsl.g:4538:3: kw= 'data_format'
            	    {
            	    kw=(Token)match(input,102,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getData_formatKeyword_62());
            	    		

            	    }
            	    break;
            	case 64 :
            	    // InternalOperationDsl.g:4544:3: kw= 'aspect'
            	    {
            	    kw=(Token)match(input,103,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAspectKeyword_63());
            	    		

            	    }
            	    break;
            	case 65 :
            	    // InternalOperationDsl.g:4550:3: kw= 'for'
            	    {
            	    kw=(Token)match(input,104,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getForKeyword_64());
            	    		

            	    }
            	    break;
            	case 66 :
            	    // InternalOperationDsl.g:4556:3: kw= 'containers'
            	    {
            	    kw=(Token)match(input,105,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContainersKeyword_65());
            	    		

            	    }
            	    break;
            	case 67 :
            	    // InternalOperationDsl.g:4562:3: (kw= 'selector' kw= 'datatypes' )
            	    {
            	    // InternalOperationDsl.g:4562:3: (kw= 'selector' kw= 'datatypes' )
            	    // InternalOperationDsl.g:4563:4: kw= 'selector' kw= 'datatypes'
            	    {
            	    kw=(Token)match(input,106,FOLLOW_86); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getSelectorKeyword_66_0());
            	    			
            	    kw=(Token)match(input,107,FOLLOW_85); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAnythingAccess().getDatatypesKeyword_66_1());
            	    			

            	    }


            	    }
            	    break;
            	case 68 :
            	    // InternalOperationDsl.g:4575:3: kw= 'version'
            	    {
            	    kw=(Token)match(input,49,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getVersionKeyword_67());
            	    		

            	    }
            	    break;
            	case 69 :
            	    // InternalOperationDsl.g:4581:3: kw= 'context'
            	    {
            	    kw=(Token)match(input,108,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getContextKeyword_68());
            	    		

            	    }
            	    break;
            	case 70 :
            	    // InternalOperationDsl.g:4587:3: kw= 'aggregate'
            	    {
            	    kw=(Token)match(input,109,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getAggregateKeyword_69());
            	    		

            	    }
            	    break;
            	case 71 :
            	    // InternalOperationDsl.g:4593:3: kw= 'applicationService'
            	    {
            	    kw=(Token)match(input,110,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getApplicationServiceKeyword_70());
            	    		

            	    }
            	    break;
            	case 72 :
            	    // InternalOperationDsl.g:4599:3: kw= 'domainEvent'
            	    {
            	    kw=(Token)match(input,111,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainEventKeyword_71());
            	    		

            	    }
            	    break;
            	case 73 :
            	    // InternalOperationDsl.g:4605:3: kw= 'domainService'
            	    {
            	    kw=(Token)match(input,112,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDomainServiceKeyword_72());
            	    		

            	    }
            	    break;
            	case 74 :
            	    // InternalOperationDsl.g:4611:3: kw= 'entity'
            	    {
            	    kw=(Token)match(input,113,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEntityKeyword_73());
            	    		

            	    }
            	    break;
            	case 75 :
            	    // InternalOperationDsl.g:4617:3: kw= 'factory'
            	    {
            	    kw=(Token)match(input,114,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFactoryKeyword_74());
            	    		

            	    }
            	    break;
            	case 76 :
            	    // InternalOperationDsl.g:4623:3: kw= 'infrastructureService'
            	    {
            	    kw=(Token)match(input,115,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInfrastructureServiceKeyword_75());
            	    		

            	    }
            	    break;
            	case 77 :
            	    // InternalOperationDsl.g:4629:3: kw= 'repository'
            	    {
            	    kw=(Token)match(input,116,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRepositoryKeyword_76());
            	    		

            	    }
            	    break;
            	case 78 :
            	    // InternalOperationDsl.g:4635:3: kw= 'specification'
            	    {
            	    kw=(Token)match(input,117,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSpecificationKeyword_77());
            	    		

            	    }
            	    break;
            	case 79 :
            	    // InternalOperationDsl.g:4641:3: kw= 'valueObject'
            	    {
            	    kw=(Token)match(input,118,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValueObjectKeyword_78());
            	    		

            	    }
            	    break;
            	case 80 :
            	    // InternalOperationDsl.g:4647:3: kw= 'extends'
            	    {
            	    kw=(Token)match(input,119,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getExtendsKeyword_79());
            	    		

            	    }
            	    break;
            	case 81 :
            	    // InternalOperationDsl.g:4653:3: kw= 'identifier'
            	    {
            	    kw=(Token)match(input,120,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIdentifierKeyword_80());
            	    		

            	    }
            	    break;
            	case 82 :
            	    // InternalOperationDsl.g:4659:3: kw= 'neverEmpty'
            	    {
            	    kw=(Token)match(input,121,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNeverEmptyKeyword_81());
            	    		

            	    }
            	    break;
            	case 83 :
            	    // InternalOperationDsl.g:4665:3: kw= 'part'
            	    {
            	    kw=(Token)match(input,122,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPartKeyword_82());
            	    		

            	    }
            	    break;
            	case 84 :
            	    // InternalOperationDsl.g:4671:3: kw= 'hide'
            	    {
            	    kw=(Token)match(input,123,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getHideKeyword_83());
            	    		

            	    }
            	    break;
            	case 85 :
            	    // InternalOperationDsl.g:4677:3: kw= 'immutable'
            	    {
            	    kw=(Token)match(input,124,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getImmutableKeyword_84());
            	    		

            	    }
            	    break;
            	case 86 :
            	    // InternalOperationDsl.g:4683:3: kw= 'enum'
            	    {
            	    kw=(Token)match(input,125,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEnumKeyword_85());
            	    		

            	    }
            	    break;
            	case 87 :
            	    // InternalOperationDsl.g:4689:3: kw= 'closure'
            	    {
            	    kw=(Token)match(input,126,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getClosureKeyword_86());
            	    		

            	    }
            	    break;
            	case 88 :
            	    // InternalOperationDsl.g:4695:3: kw= 'sideEffectFree'
            	    {
            	    kw=(Token)match(input,127,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getSideEffectFreeKeyword_87());
            	    		

            	    }
            	    break;
            	case 89 :
            	    // InternalOperationDsl.g:4701:3: kw= 'validator'
            	    {
            	    kw=(Token)match(input,128,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getValidatorKeyword_88());
            	    		

            	    }
            	    break;
            	case 90 :
            	    // InternalOperationDsl.g:4707:3: kw= 'function'
            	    {
            	    kw=(Token)match(input,129,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionKeyword_89());
            	    		

            	    }
            	    break;
            	case 91 :
            	    // InternalOperationDsl.g:4713:3: kw= 'procedure'
            	    {
            	    kw=(Token)match(input,130,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getProcedureKeyword_90());
            	    		

            	    }
            	    break;
            	case 92 :
            	    // InternalOperationDsl.g:4719:3: kw= 'boolean'
            	    {
            	    kw=(Token)match(input,131,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getBooleanKeyword_91());
            	    		

            	    }
            	    break;
            	case 93 :
            	    // InternalOperationDsl.g:4725:3: kw= 'byte'
            	    {
            	    kw=(Token)match(input,132,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getByteKeyword_92());
            	    		

            	    }
            	    break;
            	case 94 :
            	    // InternalOperationDsl.g:4731:3: kw= 'char'
            	    {
            	    kw=(Token)match(input,133,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getCharKeyword_93());
            	    		

            	    }
            	    break;
            	case 95 :
            	    // InternalOperationDsl.g:4737:3: kw= 'date'
            	    {
            	    kw=(Token)match(input,134,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDateKeyword_94());
            	    		

            	    }
            	    break;
            	case 96 :
            	    // InternalOperationDsl.g:4743:3: kw= 'double'
            	    {
            	    kw=(Token)match(input,135,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getDoubleKeyword_95());
            	    		

            	    }
            	    break;
            	case 97 :
            	    // InternalOperationDsl.g:4749:3: kw= 'float'
            	    {
            	    kw=(Token)match(input,136,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFloatKeyword_96());
            	    		

            	    }
            	    break;
            	case 98 :
            	    // InternalOperationDsl.g:4755:3: kw= 'int'
            	    {
            	    kw=(Token)match(input,137,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getIntKeyword_97());
            	    		

            	    }
            	    break;
            	case 99 :
            	    // InternalOperationDsl.g:4761:3: kw= 'long'
            	    {
            	    kw=(Token)match(input,138,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getLongKeyword_98());
            	    		

            	    }
            	    break;
            	case 100 :
            	    // InternalOperationDsl.g:4767:3: kw= 'short'
            	    {
            	    kw=(Token)match(input,139,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getShortKeyword_99());
            	    		

            	    }
            	    break;
            	case 101 :
            	    // InternalOperationDsl.g:4773:3: kw= 'string'
            	    {
            	    kw=(Token)match(input,140,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getStringKeyword_100());
            	    		

            	    }
            	    break;
            	case 102 :
            	    // InternalOperationDsl.g:4779:3: kw= 'internal'
            	    {
            	    kw=(Token)match(input,141,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInternalKeyword_101());
            	    		

            	    }
            	    break;
            	case 103 :
            	    // InternalOperationDsl.g:4785:3: kw= 'architecture'
            	    {
            	    kw=(Token)match(input,142,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getArchitectureKeyword_102());
            	    		

            	    }
            	    break;
            	case 104 :
            	    // InternalOperationDsl.g:4791:3: kw= 'public'
            	    {
            	    kw=(Token)match(input,143,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getPublicKeyword_103());
            	    		

            	    }
            	    break;
            	case 105 :
            	    // InternalOperationDsl.g:4797:3: kw= 'endpoints'
            	    {
            	    kw=(Token)match(input,36,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getEndpointsKeyword_104());
            	    		

            	    }
            	    break;
            	case 106 :
            	    // InternalOperationDsl.g:4803:3: kw= 'microservice'
            	    {
            	    kw=(Token)match(input,48,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getMicroserviceKeyword_105());
            	    		

            	    }
            	    break;
            	case 107 :
            	    // InternalOperationDsl.g:4809:3: kw= 'required'
            	    {
            	    kw=(Token)match(input,50,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRequiredKeyword_106());
            	    		

            	    }
            	    break;
            	case 108 :
            	    // InternalOperationDsl.g:4815:3: kw= 'returned'
            	    {
            	    kw=(Token)match(input,144,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getReturnedKeyword_107());
            	    		

            	    }
            	    break;
            	case 109 :
            	    // InternalOperationDsl.g:4821:3: kw= 'typedef'
            	    {
            	    kw=(Token)match(input,54,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getTypedefKeyword_108());
            	    		

            	    }
            	    break;
            	case 110 :
            	    // InternalOperationDsl.g:4827:3: kw= 'noimpl'
            	    {
            	    kw=(Token)match(input,55,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getNoimplKeyword_109());
            	    		

            	    }
            	    break;
            	case 111 :
            	    // InternalOperationDsl.g:4833:3: kw= 'interface'
            	    {
            	    kw=(Token)match(input,56,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getInterfaceKeyword_110());
            	    		

            	    }
            	    break;
            	case 112 :
            	    // InternalOperationDsl.g:4839:3: kw= 'param'
            	    {
            	    kw=(Token)match(input,145,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getParamKeyword_111());
            	    		

            	    }
            	    break;
            	case 113 :
            	    // InternalOperationDsl.g:4845:3: kw= 'refers'
            	    {
            	    kw=(Token)match(input,61,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getRefersKeyword_112());
            	    		

            	    }
            	    break;
            	case 114 :
            	    // InternalOperationDsl.g:4851:3: kw= 'fault'
            	    {
            	    kw=(Token)match(input,62,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFaultKeyword_113());
            	    		

            	    }
            	    break;
            	case 115 :
            	    // InternalOperationDsl.g:4857:3: kw= 'functional'
            	    {
            	    kw=(Token)match(input,146,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getFunctionalKeyword_114());
            	    		

            	    }
            	    break;
            	case 116 :
            	    // InternalOperationDsl.g:4863:3: kw= 'utility'
            	    {
            	    kw=(Token)match(input,147,FOLLOW_85); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getAnythingAccess().getUtilityKeyword_115());
            	    		

            	    }
            	    break;
            	case 117 :
            	    // InternalOperationDsl.g:4869:3: this_BOOLEAN_117= RULE_BOOLEAN
            	    {
            	    this_BOOLEAN_117=(Token)match(input,RULE_BOOLEAN,FOLLOW_85); 

            	    			current.merge(this_BOOLEAN_117);
            	    		

            	    			newLeafNode(this_BOOLEAN_117, grammarAccess.getAnythingAccess().getBOOLEANTerminalRuleCall_116());
            	    		

            	    }
            	    break;
            	case 118 :
            	    // InternalOperationDsl.g:4877:3: this_NUMBER_WITH_TRAILING_PERIOD_118= RULE_NUMBER_WITH_TRAILING_PERIOD
            	    {
            	    this_NUMBER_WITH_TRAILING_PERIOD_118=(Token)match(input,RULE_NUMBER_WITH_TRAILING_PERIOD,FOLLOW_85); 

            	    			current.merge(this_NUMBER_WITH_TRAILING_PERIOD_118);
            	    		

            	    			newLeafNode(this_NUMBER_WITH_TRAILING_PERIOD_118, grammarAccess.getAnythingAccess().getNUMBER_WITH_TRAILING_PERIODTerminalRuleCall_117());
            	    		

            	    }
            	    break;
            	case 119 :
            	    // InternalOperationDsl.g:4885:3: this_BIG_DECIMAL_119= RULE_BIG_DECIMAL
            	    {
            	    this_BIG_DECIMAL_119=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_85); 

            	    			current.merge(this_BIG_DECIMAL_119);
            	    		

            	    			newLeafNode(this_BIG_DECIMAL_119, grammarAccess.getAnythingAccess().getBIG_DECIMALTerminalRuleCall_118());
            	    		

            	    }
            	    break;
            	case 120 :
            	    // InternalOperationDsl.g:4893:3: this_ID_120= RULE_ID
            	    {
            	    this_ID_120=(Token)match(input,RULE_ID,FOLLOW_85); 

            	    			current.merge(this_ID_120);
            	    		

            	    			newLeafNode(this_ID_120, grammarAccess.getAnythingAccess().getIDTerminalRuleCall_119());
            	    		

            	    }
            	    break;
            	case 121 :
            	    // InternalOperationDsl.g:4901:3: this_STRING_121= RULE_STRING
            	    {
            	    this_STRING_121=(Token)match(input,RULE_STRING,FOLLOW_85); 

            	    			current.merge(this_STRING_121);
            	    		

            	    			newLeafNode(this_STRING_121, grammarAccess.getAnythingAccess().getSTRINGTerminalRuleCall_120());
            	    		

            	    }
            	    break;
            	case 122 :
            	    // InternalOperationDsl.g:4909:3: this_ANY_OTHER_122= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_122=(Token)match(input,RULE_ANY_OTHER,FOLLOW_85); 

            	    			current.merge(this_ANY_OTHER_122);
            	    		

            	    			newLeafNode(this_ANY_OTHER_122, grammarAccess.getAnythingAccess().getANY_OTHERTerminalRuleCall_121());
            	    		

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


            }


            	leaveRule();

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
    // InternalOperationDsl.g:4920:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalOperationDsl.g:4920:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalOperationDsl.g:4921:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalOperationDsl.g:4927:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:4933:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:4934:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:4934:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:4935:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:4947:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:4948:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:4948:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:4949:5: lv_importURI_3_0= RULE_STRING
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
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:4969:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:4970:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:4970:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:4971:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:4991:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalOperationDsl.g:4991:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalOperationDsl.g:4992:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalOperationDsl.g:4998:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) ;
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
            // InternalOperationDsl.g:5004:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // InternalOperationDsl.g:5005:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // InternalOperationDsl.g:5005:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            // InternalOperationDsl.g:5006:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // InternalOperationDsl.g:5006:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalOperationDsl.g:5007:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalOperationDsl.g:5007:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalOperationDsl.g:5008:5: lv_communicationType_0_0= ruleCommunicationType
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

            // InternalOperationDsl.g:5025:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5026:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5026:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5027:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,77,FOLLOW_88); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,78,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalOperationDsl.g:5051:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalOperationDsl.g:5052:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalOperationDsl.g:5052:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalOperationDsl.g:5053:5: lv_dataFormats_4_0= ruleDataFormat
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

            // InternalOperationDsl.g:5070:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==24) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalOperationDsl.g:5071:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:5075:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalOperationDsl.g:5076:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalOperationDsl.g:5076:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalOperationDsl.g:5077:6: lv_dataFormats_6_0= ruleDataFormat
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
            	    break loop113;
                }
            } while (true);

            // InternalOperationDsl.g:5095:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==33) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalOperationDsl.g:5096:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) )
                    {
                    // InternalOperationDsl.g:5096:4: ( (lv_default_7_0= 'default' ) )
                    // InternalOperationDsl.g:5097:5: (lv_default_7_0= 'default' )
                    {
                    // InternalOperationDsl.g:5097:5: (lv_default_7_0= 'default' )
                    // InternalOperationDsl.g:5098:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,33,FOLLOW_90); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", lv_default_7_0 != null, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,20,FOLLOW_91); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,79,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalOperationDsl.g:5118:4: ( (otherlv_10= RULE_STRING ) )
                    // InternalOperationDsl.g:5119:5: (otherlv_10= RULE_STRING )
                    {
                    // InternalOperationDsl.g:5119:5: (otherlv_10= RULE_STRING )
                    // InternalOperationDsl.g:5120:6: otherlv_10= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_STRING,FOLLOW_48); 

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
    // InternalOperationDsl.g:5140:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalOperationDsl.g:5140:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalOperationDsl.g:5141:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalOperationDsl.g:5147:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_STRING ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5153:2: ( ( (lv_formatName_0_0= RULE_STRING ) ) )
            // InternalOperationDsl.g:5154:2: ( (lv_formatName_0_0= RULE_STRING ) )
            {
            // InternalOperationDsl.g:5154:2: ( (lv_formatName_0_0= RULE_STRING ) )
            // InternalOperationDsl.g:5155:3: (lv_formatName_0_0= RULE_STRING )
            {
            // InternalOperationDsl.g:5155:3: (lv_formatName_0_0= RULE_STRING )
            // InternalOperationDsl.g:5156:4: lv_formatName_0_0= RULE_STRING
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
            					"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            			

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
    // InternalOperationDsl.g:5175:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalOperationDsl.g:5175:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalOperationDsl.g:5176:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalOperationDsl.g:5182:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:5188:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:5189:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:5189:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalOperationDsl.g:5190:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,86,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:5198:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:5199:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:5199:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:5200:5: lv_name_2_0= RULE_ID
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

            // InternalOperationDsl.g:5216:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==87) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalOperationDsl.g:5217:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_17); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,26,FOLLOW_94); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalOperationDsl.g:5225:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:5226:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:5226:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalOperationDsl.g:5227:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
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

                    // InternalOperationDsl.g:5244:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==24) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5245:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_94); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalOperationDsl.g:5249:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalOperationDsl.g:5250:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalOperationDsl.g:5250:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalOperationDsl.g:5251:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
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
                    	    break loop115;
                        }
                    } while (true);

                    // InternalOperationDsl.g:5269:4: ( (lv_default_8_0= 'default' ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==33) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalOperationDsl.g:5270:5: (lv_default_8_0= 'default' )
                            {
                            // InternalOperationDsl.g:5270:5: (lv_default_8_0= 'default' )
                            // InternalOperationDsl.g:5271:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,33,FOLLOW_48); 

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


    // $ANTLR start "entryRuleTechnologySpecificCollectionType"
    // InternalOperationDsl.g:5292:1: entryRuleTechnologySpecificCollectionType returns [EObject current=null] : iv_ruleTechnologySpecificCollectionType= ruleTechnologySpecificCollectionType EOF ;
    public final EObject entryRuleTechnologySpecificCollectionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificCollectionType = null;


        try {
            // InternalOperationDsl.g:5292:73: (iv_ruleTechnologySpecificCollectionType= ruleTechnologySpecificCollectionType EOF )
            // InternalOperationDsl.g:5293:2: iv_ruleTechnologySpecificCollectionType= ruleTechnologySpecificCollectionType EOF
            {
             newCompositeNode(grammarAccess.getTechnologySpecificCollectionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnologySpecificCollectionType=ruleTechnologySpecificCollectionType();

            state._fsp--;

             current =iv_ruleTechnologySpecificCollectionType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnologySpecificCollectionType"


    // $ANTLR start "ruleTechnologySpecificCollectionType"
    // InternalOperationDsl.g:5299:1: ruleTechnologySpecificCollectionType returns [EObject current=null] : (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificCollectionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5305:2: ( (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:5306:2: (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:5306:2: (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:5307:3: otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificCollectionTypeAccess().getCollectionKeyword_0());
            		
            otherlv_1=(Token)match(input,86,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificCollectionTypeAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:5315:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:5316:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:5316:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:5317:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTechnologySpecificCollectionTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologySpecificCollectionTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificCollectionTypeAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnologySpecificCollectionType"


    // $ANTLR start "entryRuleTechnologySpecificDataStructure"
    // InternalOperationDsl.g:5341:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalOperationDsl.g:5341:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalOperationDsl.g:5342:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalOperationDsl.g:5348:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5354:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalOperationDsl.g:5355:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalOperationDsl.g:5355:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalOperationDsl.g:5356:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,86,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalOperationDsl.g:5364:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOperationDsl.g:5365:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOperationDsl.g:5365:4: (lv_name_2_0= RULE_ID )
            // InternalOperationDsl.g:5366:5: lv_name_2_0= RULE_ID
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
    // InternalOperationDsl.g:5390:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalOperationDsl.g:5390:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalOperationDsl.g:5391:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalOperationDsl.g:5397:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5403:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:5404:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:5404:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:5405:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:5405:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==RULE_ID) ) {
                int LA118_1 = input.LA(2);

                if ( (LA118_1==37) ) {
                    alt118=1;
                }
            }
            switch (alt118) {
                case 1 :
                    // InternalOperationDsl.g:5406:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalOperationDsl.g:5406:4: ( (otherlv_0= RULE_ID ) )
                    // InternalOperationDsl.g:5407:5: (otherlv_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:5407:5: (otherlv_0= RULE_ID )
                    // InternalOperationDsl.g:5408:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:5424:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:5425:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:5425:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:5426:5: ruleQualifiedName
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
    // InternalOperationDsl.g:5444:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalOperationDsl.g:5444:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalOperationDsl.g:5445:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalOperationDsl.g:5451:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalOperationDsl.g:5457:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalOperationDsl.g:5458:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalOperationDsl.g:5458:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalOperationDsl.g:5459:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalOperationDsl.g:5459:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:5460:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:5460:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:5461:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
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

            // InternalOperationDsl.g:5478:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==24) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalOperationDsl.g:5479:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_7); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOperationDsl.g:5483:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalOperationDsl.g:5484:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalOperationDsl.g:5484:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalOperationDsl.g:5485:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
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
            	    break loop119;
                }
            } while (true);

            // InternalOperationDsl.g:5503:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalOperationDsl.g:5504:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalOperationDsl.g:5504:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalOperationDsl.g:5505:5: lv_direction_3_0= ruleCompatibilityDirection
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

            // InternalOperationDsl.g:5522:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalOperationDsl.g:5523:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalOperationDsl.g:5523:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalOperationDsl.g:5524:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
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
    // InternalOperationDsl.g:5549:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalOperationDsl.g:5549:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalOperationDsl.g:5550:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalOperationDsl.g:5556:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:5562:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:5563:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:5563:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:5564:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:5564:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:5565:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:5565:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:5566:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_1=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,93,FOLLOW_43); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:5598:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:5599:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:5599:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:5600:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalOperationDsl.g:5617:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==24) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalOperationDsl.g:5618:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,24,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:5622:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:5623:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:5623:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:5624:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
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
            	    break loop120;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_97); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:5646:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==74) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalOperationDsl.g:5647:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,74,FOLLOW_98); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,94,FOLLOW_23); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,30,FOLLOW_94); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:5659:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt121=0;
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( ((LA121_0>=131 && LA121_0<=140)||LA121_0==148) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5660:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5660:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5661:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
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
                    	    if ( cnt121 >= 1 ) break loop121;
                                EarlyExitException eee =
                                    new EarlyExitException(121, input);
                                throw eee;
                        }
                        cnt121++;
                    } while (true);

                    otherlv_13=(Token)match(input,32,FOLLOW_29); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:5691:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalOperationDsl.g:5691:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalOperationDsl.g:5692:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalOperationDsl.g:5698:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalOperationDsl.g:5704:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalOperationDsl.g:5705:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalOperationDsl.g:5705:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalOperationDsl.g:5706:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalOperationDsl.g:5706:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:5707:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:5707:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:5708:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_1=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,93,FOLLOW_43); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalOperationDsl.g:5740:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalOperationDsl.g:5741:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalOperationDsl.g:5741:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalOperationDsl.g:5742:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
            {

            					newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalOperationDsl.g:5759:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==24) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // InternalOperationDsl.g:5760:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,24,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalOperationDsl.g:5764:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalOperationDsl.g:5765:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalOperationDsl.g:5765:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalOperationDsl.g:5766:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
            	    {

            	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
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
            	    break loop123;
                }
            } while (true);

            otherlv_8=(Token)match(input,41,FOLLOW_97); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalOperationDsl.g:5788:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==74) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalOperationDsl.g:5789:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,74,FOLLOW_98); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,94,FOLLOW_23); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,30,FOLLOW_94); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalOperationDsl.g:5801:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt124=0;
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( ((LA124_0>=131 && LA124_0<=140)||LA124_0==148) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5802:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:5802:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:5803:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
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
                    	    if ( cnt124 >= 1 ) break loop124;
                                EarlyExitException eee =
                                    new EarlyExitException(124, input);
                                throw eee;
                        }
                        cnt124++;
                    } while (true);

                    otherlv_13=(Token)match(input,32,FOLLOW_29); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:5833:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalOperationDsl.g:5833:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalOperationDsl.g:5834:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalOperationDsl.g:5840:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:5846:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalOperationDsl.g:5847:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalOperationDsl.g:5847:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalOperationDsl.g:5848:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalOperationDsl.g:5848:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalOperationDsl.g:5849:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalOperationDsl.g:5849:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalOperationDsl.g:5850:5: lv_environmentName_0_0= RULE_STRING
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

            // InternalOperationDsl.g:5866:3: ( (lv_default_1_0= 'default' ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==33) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalOperationDsl.g:5867:4: (lv_default_1_0= 'default' )
                    {
                    // InternalOperationDsl.g:5867:4: (lv_default_1_0= 'default' )
                    // InternalOperationDsl.g:5868:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,33,FOLLOW_2); 

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
    // InternalOperationDsl.g:5884:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalOperationDsl.g:5884:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalOperationDsl.g:5885:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalOperationDsl.g:5891:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalOperationDsl.g:5897:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalOperationDsl.g:5898:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalOperationDsl.g:5898:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalOperationDsl.g:5899:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalOperationDsl.g:5899:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalOperationDsl.g:5900:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalOperationDsl.g:5900:4: (lv_type_0_0= rulePrimitiveType )
            // InternalOperationDsl.g:5901:5: lv_type_0_0= rulePrimitiveType
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

            // InternalOperationDsl.g:5918:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:5919:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:5919:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:5920:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:5936:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==42) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalOperationDsl.g:5937:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_44); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:5941:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:5942:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:5942:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:5943:6: lv_defaultValue_3_0= rulePrimitiveValue
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

            // InternalOperationDsl.g:5961:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==65) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalOperationDsl.g:5962:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_103); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalOperationDsl.g:5966:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalOperationDsl.g:5967:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalOperationDsl.g:5967:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalOperationDsl.g:5968:6: lv_features_5_0= rulePropertyFeature
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

                    // InternalOperationDsl.g:5985:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==24) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // InternalOperationDsl.g:5986:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_103); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalOperationDsl.g:5990:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalOperationDsl.g:5991:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalOperationDsl.g:5991:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalOperationDsl.g:5992:7: lv_features_7_0= rulePropertyFeature
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
                    	    break loop128;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,66,FOLLOW_48); 

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
    // InternalOperationDsl.g:6023:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalOperationDsl.g:6023:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalOperationDsl.g:6024:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalOperationDsl.g:6030:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) ;
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
            // InternalOperationDsl.g:6036:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) )
            // InternalOperationDsl.g:6037:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            {
            // InternalOperationDsl.g:6037:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            int alt130=4;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt130=1;
                }
                break;
            case 100:
                {
                alt130=2;
                }
                break;
            case 101:
                {
                alt130=3;
                }
                break;
            case 102:
                {
                alt130=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // InternalOperationDsl.g:6038:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalOperationDsl.g:6038:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalOperationDsl.g:6039:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalOperationDsl.g:6039:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalOperationDsl.g:6040:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalOperationDsl.g:6040:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalOperationDsl.g:6041:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,99,FOLLOW_43); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", lv_forExchangePattern_0_0 != null, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_105); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalOperationDsl.g:6057:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalOperationDsl.g:6058:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalOperationDsl.g:6058:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalOperationDsl.g:6059:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalOperationDsl.g:6078:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalOperationDsl.g:6078:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalOperationDsl.g:6079:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalOperationDsl.g:6079:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalOperationDsl.g:6080:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalOperationDsl.g:6080:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalOperationDsl.g:6081:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,100,FOLLOW_43); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", lv_forCommunicationType_3_0 != null, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,42,FOLLOW_76); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalOperationDsl.g:6097:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalOperationDsl.g:6098:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalOperationDsl.g:6098:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalOperationDsl.g:6099:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalOperationDsl.g:6118:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalOperationDsl.g:6118:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalOperationDsl.g:6119:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalOperationDsl.g:6119:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalOperationDsl.g:6120:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalOperationDsl.g:6120:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalOperationDsl.g:6121:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,101,FOLLOW_43); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", lv_forProtocol_6_0 != null, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalOperationDsl.g:6137:4: ( (otherlv_8= RULE_ID ) )
                    // InternalOperationDsl.g:6138:5: (otherlv_8= RULE_ID )
                    {
                    // InternalOperationDsl.g:6138:5: (otherlv_8= RULE_ID )
                    // InternalOperationDsl.g:6139:6: otherlv_8= RULE_ID
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
                    // InternalOperationDsl.g:6152:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    {
                    // InternalOperationDsl.g:6152:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    // InternalOperationDsl.g:6153:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) )
                    {
                    // InternalOperationDsl.g:6153:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalOperationDsl.g:6154:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalOperationDsl.g:6154:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalOperationDsl.g:6155:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,102,FOLLOW_43); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", lv_forDataFormat_9_0 != null, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,42,FOLLOW_14); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalOperationDsl.g:6171:4: ( (otherlv_11= RULE_STRING ) )
                    // InternalOperationDsl.g:6172:5: (otherlv_11= RULE_STRING )
                    {
                    // InternalOperationDsl.g:6172:5: (otherlv_11= RULE_STRING )
                    // InternalOperationDsl.g:6173:6: otherlv_11= RULE_STRING
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
    // InternalOperationDsl.g:6189:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:6189:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalOperationDsl.g:6190:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:6196:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:6202:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:6203:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:6203:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:6204:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_106); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:6212:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalOperationDsl.g:6213:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalOperationDsl.g:6213:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalOperationDsl.g:6214:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
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

            // InternalOperationDsl.g:6231:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==24) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // InternalOperationDsl.g:6232:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FOLLOW_106); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:6236:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalOperationDsl.g:6237:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:6237:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalOperationDsl.g:6238:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
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
            	    break loop131;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_48); 

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
    // InternalOperationDsl.g:6268:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalOperationDsl.g:6268:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalOperationDsl.g:6269:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalOperationDsl.g:6275:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalOperationDsl.g:6281:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalOperationDsl.g:6282:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalOperationDsl.g:6282:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalOperationDsl.g:6283:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,103,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:6287:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6288:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6288:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6289:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:6305:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==65) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // InternalOperationDsl.g:6306:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_108); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:6310:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalOperationDsl.g:6311:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalOperationDsl.g:6311:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalOperationDsl.g:6312:6: lv_features_3_0= ruleAspectFeature
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

                    // InternalOperationDsl.g:6329:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop132:
                    do {
                        int alt132=2;
                        int LA132_0 = input.LA(1);

                        if ( (LA132_0==24) ) {
                            alt132=1;
                        }


                        switch (alt132) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6330:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_108); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6334:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalOperationDsl.g:6335:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalOperationDsl.g:6335:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalOperationDsl.g:6336:7: lv_features_5_0= ruleAspectFeature
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
                    	    break loop132;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,66,FOLLOW_109); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,104,FOLLOW_110); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceAspectAccess().getForKeyword_3());
            		
            // InternalOperationDsl.g:6363:3: ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) )
            // InternalOperationDsl.g:6364:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            {
            // InternalOperationDsl.g:6364:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            // InternalOperationDsl.g:6365:5: lv_joinPoints_8_0= ruleServiceJoinPointType
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

            // InternalOperationDsl.g:6382:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==24) ) {
                    alt134=1;
                }


                switch (alt134) {
            	case 1 :
            	    // InternalOperationDsl.g:6383:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,24,FOLLOW_110); 

            	    				newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:6387:4: ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    // InternalOperationDsl.g:6388:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    {
            	    // InternalOperationDsl.g:6388:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    // InternalOperationDsl.g:6389:6: lv_joinPoints_10_0= ruleServiceJoinPointType
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
            	    break loop134;
                }
            } while (true);

            // InternalOperationDsl.g:6407:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==30) ) {
                alt137=1;
            }
            else if ( (LA137_0==41) ) {
                alt137=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }
            switch (alt137) {
                case 1 :
                    // InternalOperationDsl.g:6408:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalOperationDsl.g:6408:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalOperationDsl.g:6409:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,30,FOLLOW_112); 

                    					newLeafNode(otherlv_11, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalOperationDsl.g:6413:5: ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( (LA135_0==106) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6414:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:6414:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    // InternalOperationDsl.g:6415:7: lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector
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
                    	    break loop135;
                        }
                    } while (true);

                    // InternalOperationDsl.g:6432:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( ((LA136_0>=131 && LA136_0<=140)||LA136_0==148) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6433:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:6433:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:6434:7: lv_properties_13_0= ruleTechnologySpecificProperty
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
                    	    break loop136;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6457:4: otherlv_15= ';'
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
    // InternalOperationDsl.g:6466:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalOperationDsl.g:6466:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalOperationDsl.g:6467:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalOperationDsl.g:6473:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:6479:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalOperationDsl.g:6480:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:6480:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalOperationDsl.g:6481:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalOperationDsl.g:6481:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalOperationDsl.g:6482:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalOperationDsl.g:6482:4: (lv_forTechnology_0_0= 'technology' )
            // InternalOperationDsl.g:6483:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,15,FOLLOW_43); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", lv_forTechnology_0_0 != null, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalOperationDsl.g:6499:3: ( (otherlv_2= RULE_ID ) )
            // InternalOperationDsl.g:6500:4: (otherlv_2= RULE_ID )
            {
            // InternalOperationDsl.g:6500:4: (otherlv_2= RULE_ID )
            // InternalOperationDsl.g:6501:5: otherlv_2= RULE_ID
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
    // InternalOperationDsl.g:6516:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalOperationDsl.g:6516:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalOperationDsl.g:6517:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalOperationDsl.g:6523:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalOperationDsl.g:6529:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalOperationDsl.g:6530:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalOperationDsl.g:6530:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalOperationDsl.g:6531:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOperationDsl.g:6539:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalOperationDsl.g:6540:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalOperationDsl.g:6540:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalOperationDsl.g:6541:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
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

            // InternalOperationDsl.g:6558:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( (LA138_0==24) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // InternalOperationDsl.g:6559:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalOperationDsl.g:6563:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalOperationDsl.g:6564:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalOperationDsl.g:6564:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalOperationDsl.g:6565:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
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

            otherlv_5=(Token)match(input,17,FOLLOW_48); 

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
    // InternalOperationDsl.g:6595:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalOperationDsl.g:6595:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalOperationDsl.g:6596:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalOperationDsl.g:6602:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalOperationDsl.g:6608:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalOperationDsl.g:6609:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalOperationDsl.g:6609:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalOperationDsl.g:6610:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,103,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalOperationDsl.g:6614:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6615:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6615:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6616:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:6632:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==65) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // InternalOperationDsl.g:6633:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_108); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:6637:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalOperationDsl.g:6638:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalOperationDsl.g:6638:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalOperationDsl.g:6639:6: lv_features_3_0= ruleAspectFeature
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

                    // InternalOperationDsl.g:6656:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop139:
                    do {
                        int alt139=2;
                        int LA139_0 = input.LA(1);

                        if ( (LA139_0==24) ) {
                            alt139=1;
                        }


                        switch (alt139) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6657:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_108); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:6661:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalOperationDsl.g:6662:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalOperationDsl.g:6662:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalOperationDsl.g:6663:7: lv_features_5_0= ruleAspectFeature
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
                    	    break loop139;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,66,FOLLOW_109); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,104,FOLLOW_113); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAspectAccess().getForKeyword_3());
            		
            // InternalOperationDsl.g:6690:3: ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) )
            // InternalOperationDsl.g:6691:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            {
            // InternalOperationDsl.g:6691:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            // InternalOperationDsl.g:6692:5: lv_joinPoints_8_0= ruleOperationJoinPointType
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

            // InternalOperationDsl.g:6709:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )*
            loop141:
            do {
                int alt141=2;
                int LA141_0 = input.LA(1);

                if ( (LA141_0==24) ) {
                    alt141=1;
                }


                switch (alt141) {
            	case 1 :
            	    // InternalOperationDsl.g:6710:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,24,FOLLOW_113); 

            	    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:6714:4: ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    // InternalOperationDsl.g:6715:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    {
            	    // InternalOperationDsl.g:6715:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    // InternalOperationDsl.g:6716:6: lv_joinPoints_10_0= ruleOperationJoinPointType
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
            	    break loop141;
                }
            } while (true);

            // InternalOperationDsl.g:6734:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==30) ) {
                alt144=1;
            }
            else if ( (LA144_0==41) ) {
                alt144=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 144, 0, input);

                throw nvae;
            }
            switch (alt144) {
                case 1 :
                    // InternalOperationDsl.g:6735:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalOperationDsl.g:6735:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalOperationDsl.g:6736:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,30,FOLLOW_112); 

                    					newLeafNode(otherlv_11, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalOperationDsl.g:6740:5: ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )*
                    loop142:
                    do {
                        int alt142=2;
                        int LA142_0 = input.LA(1);

                        if ( (LA142_0==106) ) {
                            alt142=1;
                        }


                        switch (alt142) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6741:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalOperationDsl.g:6741:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    // InternalOperationDsl.g:6742:7: lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector
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
                    	    break loop142;
                        }
                    } while (true);

                    // InternalOperationDsl.g:6759:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);

                        if ( ((LA143_0>=131 && LA143_0<=140)||LA143_0==148) ) {
                            alt143=1;
                        }


                        switch (alt143) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6760:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalOperationDsl.g:6760:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalOperationDsl.g:6761:7: lv_properties_13_0= ruleTechnologySpecificProperty
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
                    	    break loop143;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6784:4: otherlv_15= ';'
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
    // InternalOperationDsl.g:6793:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalOperationDsl.g:6793:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalOperationDsl.g:6794:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalOperationDsl.g:6800:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalOperationDsl.g:6806:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:6807:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:6807:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalOperationDsl.g:6808:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_86); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,107,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,44,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalOperationDsl.g:6820:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalOperationDsl.g:6821:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalOperationDsl.g:6821:4: (lv_importURI_3_0= RULE_STRING )
            // InternalOperationDsl.g:6822:5: lv_importURI_3_0= RULE_STRING
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
            						"de.fhdo.lemma.operationdsl.OperationDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalOperationDsl.g:6842:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:6843:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:6843:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:6844:5: lv_name_5_0= RULE_ID
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
    // InternalOperationDsl.g:6864:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalOperationDsl.g:6864:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalOperationDsl.g:6865:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalOperationDsl.g:6871:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalOperationDsl.g:6877:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalOperationDsl.g:6878:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalOperationDsl.g:6878:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalOperationDsl.g:6879:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalOperationDsl.g:6883:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6884:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6884:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6885:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_2=(Token)match(input,30,FOLLOW_114); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:6905:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt147=3;
            int LA147_0 = input.LA(1);

            if ( ((LA147_0>=88 && LA147_0<=89)||LA147_0==125) ) {
                alt147=1;
            }
            else if ( (LA147_0==108) ) {
                alt147=2;
            }
            switch (alt147) {
                case 1 :
                    // InternalOperationDsl.g:6906:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalOperationDsl.g:6906:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt145=0;
                    loop145:
                    do {
                        int alt145=2;
                        int LA145_0 = input.LA(1);

                        if ( ((LA145_0>=88 && LA145_0<=89)||LA145_0==125) ) {
                            alt145=1;
                        }


                        switch (alt145) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6907:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalOperationDsl.g:6907:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalOperationDsl.g:6908:6: lv_complexTypes_3_0= ruleComplexType
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
                    	    if ( cnt145 >= 1 ) break loop145;
                                EarlyExitException eee =
                                    new EarlyExitException(145, input);
                                throw eee;
                        }
                        cnt145++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6926:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalOperationDsl.g:6926:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt146=0;
                    loop146:
                    do {
                        int alt146=2;
                        int LA146_0 = input.LA(1);

                        if ( (LA146_0==108) ) {
                            alt146=1;
                        }


                        switch (alt146) {
                    	case 1 :
                    	    // InternalOperationDsl.g:6927:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalOperationDsl.g:6927:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalOperationDsl.g:6928:6: lv_contexts_4_0= ruleContext
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
                    	    if ( cnt146 >= 1 ) break loop146;
                                EarlyExitException eee =
                                    new EarlyExitException(146, input);
                                throw eee;
                        }
                        cnt146++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:6954:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalOperationDsl.g:6954:48: (iv_ruleContext= ruleContext EOF )
            // InternalOperationDsl.g:6955:2: iv_ruleContext= ruleContext EOF
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
    // InternalOperationDsl.g:6961:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:6967:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalOperationDsl.g:6968:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalOperationDsl.g:6968:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalOperationDsl.g:6969:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,108,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalOperationDsl.g:6973:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:6974:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:6974:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:6975:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_2=(Token)match(input,30,FOLLOW_117); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOperationDsl.g:6995:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt148=0;
            loop148:
            do {
                int alt148=2;
                int LA148_0 = input.LA(1);

                if ( ((LA148_0>=88 && LA148_0<=89)||LA148_0==125) ) {
                    alt148=1;
                }


                switch (alt148) {
            	case 1 :
            	    // InternalOperationDsl.g:6996:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalOperationDsl.g:6996:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalOperationDsl.g:6997:5: lv_complexTypes_3_0= ruleComplexType
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
            	    if ( cnt148 >= 1 ) break loop148;
                        EarlyExitException eee =
                            new EarlyExitException(148, input);
                        throw eee;
                }
                cnt148++;
            } while (true);

            otherlv_4=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:7022:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalOperationDsl.g:7022:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalOperationDsl.g:7023:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalOperationDsl.g:7029:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_CollectionType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:7035:2: ( (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration ) )
            // InternalOperationDsl.g:7036:2: (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalOperationDsl.g:7036:2: (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration )
            int alt149=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt149=1;
                }
                break;
            case 88:
                {
                alt149=2;
                }
                break;
            case 125:
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
                    // InternalOperationDsl.g:7037:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalOperationDsl.g:7046:3: this_CollectionType_1= ruleCollectionType
                    {

                    			newCompositeNode(grammarAccess.getComplexTypeAccess().getCollectionTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectionType_1=ruleCollectionType();

                    state._fsp--;


                    			current = this_CollectionType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:7055:3: this_Enumeration_2= ruleEnumeration
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
    // InternalOperationDsl.g:7067:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalOperationDsl.g:7067:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalOperationDsl.g:7068:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalOperationDsl.g:7074:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalOperationDsl.g:7080:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalOperationDsl.g:7081:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalOperationDsl.g:7081:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalOperationDsl.g:7082:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalOperationDsl.g:7086:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:7087:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:7087:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:7088:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:7104:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==65) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalOperationDsl.g:7105:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_119); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:7109:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalOperationDsl.g:7110:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalOperationDsl.g:7110:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalOperationDsl.g:7111:6: lv_features_3_0= ruleComplexTypeFeature
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

                    // InternalOperationDsl.g:7128:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop150:
                    do {
                        int alt150=2;
                        int LA150_0 = input.LA(1);

                        if ( (LA150_0==24) ) {
                            alt150=1;
                        }


                        switch (alt150) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7129:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_119); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7133:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalOperationDsl.g:7134:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalOperationDsl.g:7134:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalOperationDsl.g:7135:7: lv_features_5_0= ruleComplexTypeFeature
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
                    	    break loop150;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,66,FOLLOW_120); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:7158:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==119) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // InternalOperationDsl.g:7159:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,119,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalOperationDsl.g:7163:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:7164:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:7164:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:7165:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,30,FOLLOW_121); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOperationDsl.g:7184:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==RULE_ID||(LA156_0>=123 && LA156_0<=124)||(LA156_0>=129 && LA156_0<=140)||LA156_0==148) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalOperationDsl.g:7185:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalOperationDsl.g:7185:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt153=2;
                    switch ( input.LA(1) ) {
                    case 123:
                        {
                        int LA153_1 = input.LA(2);

                        if ( (LA153_1==RULE_ID||LA153_1==124||(LA153_1>=131 && LA153_1<=140)||LA153_1==148) ) {
                            alt153=1;
                        }
                        else if ( ((LA153_1>=129 && LA153_1<=130)) ) {
                            alt153=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 153, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 124:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                    case 136:
                    case 137:
                    case 138:
                    case 139:
                    case 140:
                    case 148:
                        {
                        alt153=1;
                        }
                        break;
                    case 129:
                    case 130:
                        {
                        alt153=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 153, 0, input);

                        throw nvae;
                    }

                    switch (alt153) {
                        case 1 :
                            // InternalOperationDsl.g:7186:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalOperationDsl.g:7186:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalOperationDsl.g:7187:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalOperationDsl.g:7187:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalOperationDsl.g:7188:7: lv_dataFields_10_0= ruleDataField
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0());
                            						
                            pushFollow(FOLLOW_60);
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
                            // InternalOperationDsl.g:7206:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalOperationDsl.g:7206:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalOperationDsl.g:7207:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalOperationDsl.g:7207:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalOperationDsl.g:7208:7: lv_operations_11_0= ruleDataOperation
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0());
                            						
                            pushFollow(FOLLOW_60);
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

                    // InternalOperationDsl.g:7226:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop155:
                    do {
                        int alt155=2;
                        int LA155_0 = input.LA(1);

                        if ( (LA155_0==24) ) {
                            alt155=1;
                        }


                        switch (alt155) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7227:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,24,FOLLOW_122); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalOperationDsl.g:7231:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt154=2;
                    	    switch ( input.LA(1) ) {
                    	    case 123:
                    	        {
                    	        int LA154_1 = input.LA(2);

                    	        if ( ((LA154_1>=129 && LA154_1<=130)) ) {
                    	            alt154=2;
                    	        }
                    	        else if ( (LA154_1==RULE_ID||LA154_1==124||(LA154_1>=131 && LA154_1<=140)||LA154_1==148) ) {
                    	            alt154=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 154, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 124:
                    	    case 131:
                    	    case 132:
                    	    case 133:
                    	    case 134:
                    	    case 135:
                    	    case 136:
                    	    case 137:
                    	    case 138:
                    	    case 139:
                    	    case 140:
                    	    case 148:
                    	        {
                    	        alt154=1;
                    	        }
                    	        break;
                    	    case 129:
                    	    case 130:
                    	        {
                    	        alt154=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 154, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt154) {
                    	        case 1 :
                    	            // InternalOperationDsl.g:7232:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalOperationDsl.g:7232:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalOperationDsl.g:7233:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalOperationDsl.g:7233:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalOperationDsl.g:7234:8: lv_dataFields_13_0= ruleDataField
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_60);
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
                    	            // InternalOperationDsl.g:7252:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalOperationDsl.g:7252:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalOperationDsl.g:7253:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalOperationDsl.g:7253:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalOperationDsl.g:7254:8: lv_operations_14_0= ruleDataOperation
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_60);
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
                    	    break loop155;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,32,FOLLOW_2); 

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


    // $ANTLR start "entryRuleCollectionType"
    // InternalOperationDsl.g:7282:1: entryRuleCollectionType returns [EObject current=null] : iv_ruleCollectionType= ruleCollectionType EOF ;
    public final EObject entryRuleCollectionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionType = null;


        try {
            // InternalOperationDsl.g:7282:55: (iv_ruleCollectionType= ruleCollectionType EOF )
            // InternalOperationDsl.g:7283:2: iv_ruleCollectionType= ruleCollectionType EOF
            {
             newCompositeNode(grammarAccess.getCollectionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionType=ruleCollectionType();

            state._fsp--;

             current =iv_ruleCollectionType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionType"


    // $ANTLR start "ruleCollectionType"
    // InternalOperationDsl.g:7289:1: ruleCollectionType returns [EObject current=null] : ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
    public final EObject ruleCollectionType() throws RecognitionException {
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
            // InternalOperationDsl.g:7295:2: ( ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalOperationDsl.g:7296:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalOperationDsl.g:7296:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt158=2;
            alt158 = dfa158.predict(input);
            switch (alt158) {
                case 1 :
                    // InternalOperationDsl.g:7297:3: (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalOperationDsl.g:7297:3: (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalOperationDsl.g:7298:4: otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,88,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getCollectionTypeAccess().getCollectionKeyword_0_0());
                    			
                    // InternalOperationDsl.g:7302:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalOperationDsl.g:7303:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:7303:5: (lv_name_1_0= RULE_ID )
                    // InternalOperationDsl.g:7304:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_23); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getCollectionTypeAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCollectionTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,30,FOLLOW_123); 

                    				newLeafNode(otherlv_2, grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalOperationDsl.g:7324:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalOperationDsl.g:7325:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalOperationDsl.g:7325:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalOperationDsl.g:7326:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_60);
                    lv_dataFields_3_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_3_0,
                    							"de.fhdo.lemma.data.DataDsl.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOperationDsl.g:7343:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop157:
                    do {
                        int alt157=2;
                        int LA157_0 = input.LA(1);

                        if ( (LA157_0==24) ) {
                            alt157=1;
                        }


                        switch (alt157) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7344:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_123); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getCollectionTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalOperationDsl.g:7348:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalOperationDsl.g:7349:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalOperationDsl.g:7349:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalOperationDsl.g:7350:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
                    	    lv_dataFields_5_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
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
                    	    break loop157;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,32,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:7374:3: (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalOperationDsl.g:7374:3: (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalOperationDsl.g:7375:4: otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,88,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getCollectionTypeAccess().getCollectionKeyword_1_0());
                    			
                    // InternalOperationDsl.g:7379:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalOperationDsl.g:7380:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalOperationDsl.g:7380:5: (lv_name_8_0= RULE_ID )
                    // InternalOperationDsl.g:7381:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_23); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getCollectionTypeAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCollectionTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_8_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,30,FOLLOW_94); 

                    				newLeafNode(otherlv_9, grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalOperationDsl.g:7401:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:7402:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:7402:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalOperationDsl.g:7403:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getCollectionTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_primitiveType_10_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_10_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_1_4());
                    			

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
    // $ANTLR end "ruleCollectionType"


    // $ANTLR start "entryRuleDataField"
    // InternalOperationDsl.g:7429:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalOperationDsl.g:7429:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalOperationDsl.g:7430:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalOperationDsl.g:7436:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
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
            // InternalOperationDsl.g:7442:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalOperationDsl.g:7443:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalOperationDsl.g:7443:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalOperationDsl.g:7444:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalOperationDsl.g:7444:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==123) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // InternalOperationDsl.g:7445:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:7445:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:7446:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,123,FOLLOW_124); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:7458:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==124) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalOperationDsl.g:7459:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalOperationDsl.g:7459:4: (lv_immutable_1_0= 'immutable' )
                    // InternalOperationDsl.g:7460:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,124,FOLLOW_82); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", lv_immutable_1_0 != null, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:7472:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt161=4;
            int LA161_0 = input.LA(1);

            if ( ((LA161_0>=131 && LA161_0<=140)||LA161_0==148) ) {
                alt161=1;
            }
            else if ( (LA161_0==RULE_ID) ) {
                int LA161_2 = input.LA(2);

                if ( (LA161_2==37) ) {
                    alt161=3;
                }
                else if ( (LA161_2==RULE_ID||LA161_2==64) ) {
                    alt161=2;
                }
            }
            switch (alt161) {
                case 1 :
                    // InternalOperationDsl.g:7473:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:7473:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:7474:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:7474:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalOperationDsl.g:7475:6: lv_primitiveType_2_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:7493:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalOperationDsl.g:7493:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:7494:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:7494:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:7495:6: ruleQualifiedName
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
                    // InternalOperationDsl.g:7510:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:7510:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalOperationDsl.g:7511:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalOperationDsl.g:7511:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalOperationDsl.g:7512:6: lv_importedComplexType_4_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:7530:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalOperationDsl.g:7531:4: (lv_name_5_0= RULE_ID )
            {
            // InternalOperationDsl.g:7531:4: (lv_name_5_0= RULE_ID )
            // InternalOperationDsl.g:7532:5: lv_name_5_0= RULE_ID
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

            // InternalOperationDsl.g:7548:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==42) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // InternalOperationDsl.g:7549:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,42,FOLLOW_44); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalOperationDsl.g:7553:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:7554:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:7554:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:7555:6: lv_initializationValue_7_0= rulePrimitiveValue
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

            // InternalOperationDsl.g:7573:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==65) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // InternalOperationDsl.g:7574:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,65,FOLLOW_127); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalOperationDsl.g:7578:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalOperationDsl.g:7579:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalOperationDsl.g:7579:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalOperationDsl.g:7580:6: lv_features_9_0= ruleDataFieldFeature
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

                    // InternalOperationDsl.g:7597:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop163:
                    do {
                        int alt163=2;
                        int LA163_0 = input.LA(1);

                        if ( (LA163_0==24) ) {
                            alt163=1;
                        }


                        switch (alt163) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7598:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,24,FOLLOW_127); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7602:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalOperationDsl.g:7603:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalOperationDsl.g:7603:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalOperationDsl.g:7604:7: lv_features_11_0= ruleDataFieldFeature
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
                    	    break loop163;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,66,FOLLOW_2); 

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
    // InternalOperationDsl.g:7631:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalOperationDsl.g:7631:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalOperationDsl.g:7632:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalOperationDsl.g:7638:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) ;
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
            // InternalOperationDsl.g:7644:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) )
            // InternalOperationDsl.g:7645:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            {
            // InternalOperationDsl.g:7645:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            // InternalOperationDsl.g:7646:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,125,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalOperationDsl.g:7650:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOperationDsl.g:7651:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOperationDsl.g:7651:4: (lv_name_1_0= RULE_ID )
            // InternalOperationDsl.g:7652:5: lv_name_1_0= RULE_ID
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

            // InternalOperationDsl.g:7668:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==65) ) {
                alt166=1;
            }
            switch (alt166) {
                case 1 :
                    // InternalOperationDsl.g:7669:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_119); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalOperationDsl.g:7673:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalOperationDsl.g:7674:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalOperationDsl.g:7674:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalOperationDsl.g:7675:6: lv_features_3_0= ruleComplexTypeFeature
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

                    // InternalOperationDsl.g:7692:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop165:
                    do {
                        int alt165=2;
                        int LA165_0 = input.LA(1);

                        if ( (LA165_0==24) ) {
                            alt165=1;
                        }


                        switch (alt165) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7693:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_119); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalOperationDsl.g:7697:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalOperationDsl.g:7698:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalOperationDsl.g:7698:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalOperationDsl.g:7699:7: lv_features_5_0= ruleComplexTypeFeature
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
                    	    break loop165;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,66,FOLLOW_23); 

                    				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOperationDsl.g:7726:3: ( (lv_fields_8_0= ruleEnumerationField ) )
            // InternalOperationDsl.g:7727:4: (lv_fields_8_0= ruleEnumerationField )
            {
            // InternalOperationDsl.g:7727:4: (lv_fields_8_0= ruleEnumerationField )
            // InternalOperationDsl.g:7728:5: lv_fields_8_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_60);
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

            // InternalOperationDsl.g:7745:3: (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )*
            loop167:
            do {
                int alt167=2;
                int LA167_0 = input.LA(1);

                if ( (LA167_0==24) ) {
                    alt167=1;
                }


                switch (alt167) {
            	case 1 :
            	    // InternalOperationDsl.g:7746:4: otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) )
            	    {
            	    otherlv_9=(Token)match(input,24,FOLLOW_7); 

            	    				newLeafNode(otherlv_9, grammarAccess.getEnumerationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalOperationDsl.g:7750:4: ( (lv_fields_10_0= ruleEnumerationField ) )
            	    // InternalOperationDsl.g:7751:5: (lv_fields_10_0= ruleEnumerationField )
            	    {
            	    // InternalOperationDsl.g:7751:5: (lv_fields_10_0= ruleEnumerationField )
            	    // InternalOperationDsl.g:7752:6: lv_fields_10_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
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
            	    break loop167;
                }
            } while (true);

            otherlv_11=(Token)match(input,32,FOLLOW_2); 

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
    // InternalOperationDsl.g:7778:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalOperationDsl.g:7778:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalOperationDsl.g:7779:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalOperationDsl.g:7785:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:7791:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalOperationDsl.g:7792:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalOperationDsl.g:7792:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalOperationDsl.g:7793:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalOperationDsl.g:7793:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalOperationDsl.g:7794:4: (lv_name_0_0= RULE_ID )
            {
            // InternalOperationDsl.g:7794:4: (lv_name_0_0= RULE_ID )
            // InternalOperationDsl.g:7795:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_39); 

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

            // InternalOperationDsl.g:7811:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==16) ) {
                alt168=1;
            }
            switch (alt168) {
                case 1 :
                    // InternalOperationDsl.g:7812:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_44); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalOperationDsl.g:7816:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalOperationDsl.g:7817:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalOperationDsl.g:7817:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalOperationDsl.g:7818:6: lv_initializationValue_2_0= rulePrimitiveValue
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

                    otherlv_3=(Token)match(input,17,FOLLOW_2); 

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
    // InternalOperationDsl.g:7844:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalOperationDsl.g:7844:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalOperationDsl.g:7845:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalOperationDsl.g:7851:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalOperationDsl.g:7857:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalOperationDsl.g:7858:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalOperationDsl.g:7858:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalOperationDsl.g:7859:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalOperationDsl.g:7859:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==123) ) {
                alt169=1;
            }
            switch (alt169) {
                case 1 :
                    // InternalOperationDsl.g:7860:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalOperationDsl.g:7860:4: (lv_hidden_0_0= 'hide' )
                    // InternalOperationDsl.g:7861:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,123,FOLLOW_129); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalOperationDsl.g:7873:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==130) ) {
                alt171=1;
            }
            else if ( (LA171_0==129) ) {
                alt171=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 171, 0, input);

                throw nvae;
            }
            switch (alt171) {
                case 1 :
                    // InternalOperationDsl.g:7874:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalOperationDsl.g:7874:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalOperationDsl.g:7875:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalOperationDsl.g:7875:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalOperationDsl.g:7876:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,130,FOLLOW_7); 

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
                    // InternalOperationDsl.g:7889:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalOperationDsl.g:7889:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalOperationDsl.g:7890:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,129,FOLLOW_82); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalOperationDsl.g:7894:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt170=4;
                    int LA170_0 = input.LA(1);

                    if ( ((LA170_0>=131 && LA170_0<=140)||LA170_0==148) ) {
                        alt170=1;
                    }
                    else if ( (LA170_0==RULE_ID) ) {
                        int LA170_2 = input.LA(2);

                        if ( (LA170_2==37) ) {
                            alt170=3;
                        }
                        else if ( (LA170_2==RULE_ID||LA170_2==64) ) {
                            alt170=2;
                        }
                    }
                    switch (alt170) {
                        case 1 :
                            // InternalOperationDsl.g:7895:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalOperationDsl.g:7895:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalOperationDsl.g:7896:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalOperationDsl.g:7896:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalOperationDsl.g:7897:8: lv_primitiveReturnType_3_0= rulePrimitiveType
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
                            // InternalOperationDsl.g:7915:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalOperationDsl.g:7915:6: ( ( ruleQualifiedName ) )
                            // InternalOperationDsl.g:7916:7: ( ruleQualifiedName )
                            {
                            // InternalOperationDsl.g:7916:7: ( ruleQualifiedName )
                            // InternalOperationDsl.g:7917:8: ruleQualifiedName
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
                            // InternalOperationDsl.g:7932:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalOperationDsl.g:7932:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalOperationDsl.g:7933:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalOperationDsl.g:7933:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalOperationDsl.g:7934:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:7954:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalOperationDsl.g:7955:4: (lv_name_6_0= RULE_ID )
            {
            // InternalOperationDsl.g:7955:4: (lv_name_6_0= RULE_ID )
            // InternalOperationDsl.g:7956:5: lv_name_6_0= RULE_ID
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

            // InternalOperationDsl.g:7972:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==16) ) {
                alt174=1;
            }
            switch (alt174) {
                case 1 :
                    // InternalOperationDsl.g:7973:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_131); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalOperationDsl.g:7977:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt172=2;
                    int LA172_0 = input.LA(1);

                    if ( (LA172_0==RULE_ID||(LA172_0>=131 && LA172_0<=140)||LA172_0==148) ) {
                        alt172=1;
                    }
                    switch (alt172) {
                        case 1 :
                            // InternalOperationDsl.g:7978:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalOperationDsl.g:7978:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalOperationDsl.g:7979:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_47);
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

                    // InternalOperationDsl.g:7996:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop173:
                    do {
                        int alt173=2;
                        int LA173_0 = input.LA(1);

                        if ( (LA173_0==24) ) {
                            alt173=1;
                        }


                        switch (alt173) {
                    	case 1 :
                    	    // InternalOperationDsl.g:7997:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,24,FOLLOW_82); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalOperationDsl.g:8001:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalOperationDsl.g:8002:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalOperationDsl.g:8002:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalOperationDsl.g:8003:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_47);
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
                    	    break loop173;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,17,FOLLOW_126); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalOperationDsl.g:8026:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt176=2;
            int LA176_0 = input.LA(1);

            if ( (LA176_0==65) ) {
                alt176=1;
            }
            switch (alt176) {
                case 1 :
                    // InternalOperationDsl.g:8027:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,65,FOLLOW_132); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalOperationDsl.g:8031:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalOperationDsl.g:8032:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalOperationDsl.g:8032:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalOperationDsl.g:8033:6: lv_features_13_0= ruleDataOperationFeature
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

                    // InternalOperationDsl.g:8050:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop175:
                    do {
                        int alt175=2;
                        int LA175_0 = input.LA(1);

                        if ( (LA175_0==24) ) {
                            alt175=1;
                        }


                        switch (alt175) {
                    	case 1 :
                    	    // InternalOperationDsl.g:8051:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,24,FOLLOW_132); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalOperationDsl.g:8055:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalOperationDsl.g:8056:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalOperationDsl.g:8056:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalOperationDsl.g:8057:7: lv_features_15_0= ruleDataOperationFeature
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
                    	    break loop175;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,66,FOLLOW_2); 

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
    // InternalOperationDsl.g:8084:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalOperationDsl.g:8084:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalOperationDsl.g:8085:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalOperationDsl.g:8091:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalOperationDsl.g:8097:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalOperationDsl.g:8098:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalOperationDsl.g:8098:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalOperationDsl.g:8099:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalOperationDsl.g:8099:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt177=3;
            int LA177_0 = input.LA(1);

            if ( ((LA177_0>=131 && LA177_0<=140)||LA177_0==148) ) {
                alt177=1;
            }
            else if ( (LA177_0==RULE_ID) ) {
                int LA177_2 = input.LA(2);

                if ( (LA177_2==RULE_ID||LA177_2==64) ) {
                    alt177=2;
                }
                else if ( (LA177_2==37) ) {
                    alt177=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 177, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 177, 0, input);

                throw nvae;
            }
            switch (alt177) {
                case 1 :
                    // InternalOperationDsl.g:8100:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalOperationDsl.g:8100:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalOperationDsl.g:8101:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalOperationDsl.g:8101:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalOperationDsl.g:8102:6: lv_primitiveType_0_0= rulePrimitiveType
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
                    // InternalOperationDsl.g:8120:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalOperationDsl.g:8120:4: ( ( ruleQualifiedName ) )
                    // InternalOperationDsl.g:8121:5: ( ruleQualifiedName )
                    {
                    // InternalOperationDsl.g:8121:5: ( ruleQualifiedName )
                    // InternalOperationDsl.g:8122:6: ruleQualifiedName
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
                    // InternalOperationDsl.g:8137:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalOperationDsl.g:8137:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalOperationDsl.g:8138:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalOperationDsl.g:8138:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalOperationDsl.g:8139:6: lv_importedComplexType_2_0= ruleImportedComplexType
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

            // InternalOperationDsl.g:8157:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOperationDsl.g:8158:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOperationDsl.g:8158:4: (lv_name_3_0= RULE_ID )
            // InternalOperationDsl.g:8159:5: lv_name_3_0= RULE_ID
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
    // InternalOperationDsl.g:8179:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalOperationDsl.g:8179:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalOperationDsl.g:8180:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalOperationDsl.g:8186:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8192:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalOperationDsl.g:8193:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalOperationDsl.g:8193:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt178=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt178=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt178=2;
                }
                break;
            case RULE_STRING:
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
                    // InternalOperationDsl.g:8194:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalOperationDsl.g:8194:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalOperationDsl.g:8195:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalOperationDsl.g:8195:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalOperationDsl.g:8196:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalOperationDsl.g:8213:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalOperationDsl.g:8213:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalOperationDsl.g:8214:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalOperationDsl.g:8214:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalOperationDsl.g:8215:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalOperationDsl.g:8232:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalOperationDsl.g:8232:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalOperationDsl.g:8233:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalOperationDsl.g:8233:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalOperationDsl.g:8234:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalOperationDsl.g:8254:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalOperationDsl.g:8254:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalOperationDsl.g:8255:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalOperationDsl.g:8261:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8267:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalOperationDsl.g:8268:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalOperationDsl.g:8268:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalOperationDsl.g:8269:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalOperationDsl.g:8269:3: ( (otherlv_0= RULE_ID ) )
            // InternalOperationDsl.g:8270:4: (otherlv_0= RULE_ID )
            {
            // InternalOperationDsl.g:8270:4: (otherlv_0= RULE_ID )
            // InternalOperationDsl.g:8271:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalOperationDsl.g:8286:3: ( ( ruleQualifiedName ) )
            // InternalOperationDsl.g:8287:4: ( ruleQualifiedName )
            {
            // InternalOperationDsl.g:8287:4: ( ruleQualifiedName )
            // InternalOperationDsl.g:8288:5: ruleQualifiedName
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
    // InternalOperationDsl.g:8306:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalOperationDsl.g:8306:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalOperationDsl.g:8307:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalOperationDsl.g:8313:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
            // InternalOperationDsl.g:8319:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalOperationDsl.g:8320:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalOperationDsl.g:8320:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt179=11;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt179=1;
                }
                break;
            case 132:
                {
                alt179=2;
                }
                break;
            case 133:
                {
                alt179=3;
                }
                break;
            case 134:
                {
                alt179=4;
                }
                break;
            case 135:
                {
                alt179=5;
                }
                break;
            case 136:
                {
                alt179=6;
                }
                break;
            case 137:
                {
                alt179=7;
                }
                break;
            case 138:
                {
                alt179=8;
                }
                break;
            case 139:
                {
                alt179=9;
                }
                break;
            case 140:
                {
                alt179=10;
                }
                break;
            case 148:
                {
                alt179=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 179, 0, input);

                throw nvae;
            }

            switch (alt179) {
                case 1 :
                    // InternalOperationDsl.g:8321:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalOperationDsl.g:8321:3: ( () otherlv_1= 'boolean' )
                    // InternalOperationDsl.g:8322:4: () otherlv_1= 'boolean'
                    {
                    // InternalOperationDsl.g:8322:4: ()
                    // InternalOperationDsl.g:8323:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,131,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8335:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalOperationDsl.g:8335:3: ( () otherlv_3= 'byte' )
                    // InternalOperationDsl.g:8336:4: () otherlv_3= 'byte'
                    {
                    // InternalOperationDsl.g:8336:4: ()
                    // InternalOperationDsl.g:8337:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,132,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8349:3: ( () otherlv_5= 'char' )
                    {
                    // InternalOperationDsl.g:8349:3: ( () otherlv_5= 'char' )
                    // InternalOperationDsl.g:8350:4: () otherlv_5= 'char'
                    {
                    // InternalOperationDsl.g:8350:4: ()
                    // InternalOperationDsl.g:8351:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,133,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8363:3: ( () otherlv_7= 'date' )
                    {
                    // InternalOperationDsl.g:8363:3: ( () otherlv_7= 'date' )
                    // InternalOperationDsl.g:8364:4: () otherlv_7= 'date'
                    {
                    // InternalOperationDsl.g:8364:4: ()
                    // InternalOperationDsl.g:8365:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,134,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:8377:3: ( () otherlv_9= 'double' )
                    {
                    // InternalOperationDsl.g:8377:3: ( () otherlv_9= 'double' )
                    // InternalOperationDsl.g:8378:4: () otherlv_9= 'double'
                    {
                    // InternalOperationDsl.g:8378:4: ()
                    // InternalOperationDsl.g:8379:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,135,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:8391:3: ( () otherlv_11= 'float' )
                    {
                    // InternalOperationDsl.g:8391:3: ( () otherlv_11= 'float' )
                    // InternalOperationDsl.g:8392:4: () otherlv_11= 'float'
                    {
                    // InternalOperationDsl.g:8392:4: ()
                    // InternalOperationDsl.g:8393:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,136,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:8405:3: ( () otherlv_13= 'int' )
                    {
                    // InternalOperationDsl.g:8405:3: ( () otherlv_13= 'int' )
                    // InternalOperationDsl.g:8406:4: () otherlv_13= 'int'
                    {
                    // InternalOperationDsl.g:8406:4: ()
                    // InternalOperationDsl.g:8407:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,137,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:8419:3: ( () otherlv_15= 'long' )
                    {
                    // InternalOperationDsl.g:8419:3: ( () otherlv_15= 'long' )
                    // InternalOperationDsl.g:8420:4: () otherlv_15= 'long'
                    {
                    // InternalOperationDsl.g:8420:4: ()
                    // InternalOperationDsl.g:8421:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,138,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:8433:3: ( () otherlv_17= 'short' )
                    {
                    // InternalOperationDsl.g:8433:3: ( () otherlv_17= 'short' )
                    // InternalOperationDsl.g:8434:4: () otherlv_17= 'short'
                    {
                    // InternalOperationDsl.g:8434:4: ()
                    // InternalOperationDsl.g:8435:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,139,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:8447:3: ( () otherlv_19= 'string' )
                    {
                    // InternalOperationDsl.g:8447:3: ( () otherlv_19= 'string' )
                    // InternalOperationDsl.g:8448:4: () otherlv_19= 'string'
                    {
                    // InternalOperationDsl.g:8448:4: ()
                    // InternalOperationDsl.g:8449:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,140,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalOperationDsl.g:8461:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalOperationDsl.g:8461:3: ( () otherlv_21= 'unspecified' )
                    // InternalOperationDsl.g:8462:4: () otherlv_21= 'unspecified'
                    {
                    // InternalOperationDsl.g:8462:4: ()
                    // InternalOperationDsl.g:8463:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0(),
                    						current);
                    				

                    }

                    otherlv_21=(Token)match(input,148,FOLLOW_2); 

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
    // InternalOperationDsl.g:8478:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOperationDsl.g:8478:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOperationDsl.g:8479:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalOperationDsl.g:8485:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8491:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOperationDsl.g:8492:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOperationDsl.g:8492:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOperationDsl.g:8493:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_133); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOperationDsl.g:8500:3: (kw= '.' this_ID_2= RULE_ID )*
            loop180:
            do {
                int alt180=2;
                int LA180_0 = input.LA(1);

                if ( (LA180_0==64) ) {
                    alt180=1;
                }


                switch (alt180) {
            	case 1 :
            	    // InternalOperationDsl.g:8501:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,64,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_133); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop180;
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
    // InternalOperationDsl.g:8518:1: ruleImportType returns [Enumerator current=null] : ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) ) ;
    public final Enumerator ruleImportType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8524:2: ( ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) ) )
            // InternalOperationDsl.g:8525:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) )
            {
            // InternalOperationDsl.g:8525:2: ( (enumLiteral_0= 'technology' ) | (enumLiteral_1= 'microservices' ) | (enumLiteral_2= 'nodes' ) )
            int alt181=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt181=1;
                }
                break;
            case 51:
                {
                alt181=2;
                }
                break;
            case 27:
                {
                alt181=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 181, 0, input);

                throw nvae;
            }

            switch (alt181) {
                case 1 :
                    // InternalOperationDsl.g:8526:3: (enumLiteral_0= 'technology' )
                    {
                    // InternalOperationDsl.g:8526:3: (enumLiteral_0= 'technology' )
                    // InternalOperationDsl.g:8527:4: enumLiteral_0= 'technology'
                    {
                    enumLiteral_0=(Token)match(input,15,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportTypeAccess().getTECHNOLOGYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8534:3: (enumLiteral_1= 'microservices' )
                    {
                    // InternalOperationDsl.g:8534:3: (enumLiteral_1= 'microservices' )
                    // InternalOperationDsl.g:8535:4: enumLiteral_1= 'microservices'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportTypeAccess().getMICROSERVICESEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8542:3: (enumLiteral_2= 'nodes' )
                    {
                    // InternalOperationDsl.g:8542:3: (enumLiteral_2= 'nodes' )
                    // InternalOperationDsl.g:8543:4: enumLiteral_2= 'nodes'
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_2); 

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
    // InternalOperationDsl.g:8553:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8559:2: ( ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) ) )
            // InternalOperationDsl.g:8560:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            {
            // InternalOperationDsl.g:8560:2: ( (enumLiteral_0= 'internal' ) | (enumLiteral_1= 'architecture' ) | (enumLiteral_2= 'public' ) )
            int alt182=3;
            switch ( input.LA(1) ) {
            case 141:
                {
                alt182=1;
                }
                break;
            case 142:
                {
                alt182=2;
                }
                break;
            case 143:
                {
                alt182=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 182, 0, input);

                throw nvae;
            }

            switch (alt182) {
                case 1 :
                    // InternalOperationDsl.g:8561:3: (enumLiteral_0= 'internal' )
                    {
                    // InternalOperationDsl.g:8561:3: (enumLiteral_0= 'internal' )
                    // InternalOperationDsl.g:8562:4: enumLiteral_0= 'internal'
                    {
                    enumLiteral_0=(Token)match(input,141,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8569:3: (enumLiteral_1= 'architecture' )
                    {
                    // InternalOperationDsl.g:8569:3: (enumLiteral_1= 'architecture' )
                    // InternalOperationDsl.g:8570:4: enumLiteral_1= 'architecture'
                    {
                    enumLiteral_1=(Token)match(input,142,FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getARCHITECTUREEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8577:3: (enumLiteral_2= 'public' )
                    {
                    // InternalOperationDsl.g:8577:3: (enumLiteral_2= 'public' )
                    // InternalOperationDsl.g:8578:4: enumLiteral_2= 'public'
                    {
                    enumLiteral_2=(Token)match(input,143,FOLLOW_2); 

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
    // InternalOperationDsl.g:8588:1: ruleMicroserviceType returns [Enumerator current=null] : ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) ;
    public final Enumerator ruleMicroserviceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8594:2: ( ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) ) )
            // InternalOperationDsl.g:8595:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:8595:2: ( (enumLiteral_0= 'functional' ) | (enumLiteral_1= 'utility' ) | (enumLiteral_2= 'infrastructure' ) )
            int alt183=3;
            switch ( input.LA(1) ) {
            case 146:
                {
                alt183=1;
                }
                break;
            case 147:
                {
                alt183=2;
                }
                break;
            case 76:
                {
                alt183=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 183, 0, input);

                throw nvae;
            }

            switch (alt183) {
                case 1 :
                    // InternalOperationDsl.g:8596:3: (enumLiteral_0= 'functional' )
                    {
                    // InternalOperationDsl.g:8596:3: (enumLiteral_0= 'functional' )
                    // InternalOperationDsl.g:8597:4: enumLiteral_0= 'functional'
                    {
                    enumLiteral_0=(Token)match(input,146,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMicroserviceTypeAccess().getFUNCTIONALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8604:3: (enumLiteral_1= 'utility' )
                    {
                    // InternalOperationDsl.g:8604:3: (enumLiteral_1= 'utility' )
                    // InternalOperationDsl.g:8605:4: enumLiteral_1= 'utility'
                    {
                    enumLiteral_1=(Token)match(input,147,FOLLOW_2); 

                    				current = grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMicroserviceTypeAccess().getUTILITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8612:3: (enumLiteral_2= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:8612:3: (enumLiteral_2= 'infrastructure' )
                    // InternalOperationDsl.g:8613:4: enumLiteral_2= 'infrastructure'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); 

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
    // InternalOperationDsl.g:8623:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8629:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalOperationDsl.g:8630:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalOperationDsl.g:8630:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt184=3;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt184=1;
                }
                break;
            case 81:
                {
                alt184=2;
                }
                break;
            case 82:
                {
                alt184=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 184, 0, input);

                throw nvae;
            }

            switch (alt184) {
                case 1 :
                    // InternalOperationDsl.g:8631:3: (enumLiteral_0= 'in' )
                    {
                    // InternalOperationDsl.g:8631:3: (enumLiteral_0= 'in' )
                    // InternalOperationDsl.g:8632:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8639:3: (enumLiteral_1= 'out' )
                    {
                    // InternalOperationDsl.g:8639:3: (enumLiteral_1= 'out' )
                    // InternalOperationDsl.g:8640:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8647:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalOperationDsl.g:8647:3: (enumLiteral_2= 'inout' )
                    // InternalOperationDsl.g:8648:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,82,FOLLOW_2); 

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
    // InternalOperationDsl.g:8658:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8664:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalOperationDsl.g:8665:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalOperationDsl.g:8665:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==83) ) {
                alt185=1;
            }
            else if ( (LA185_0==84) ) {
                alt185=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 185, 0, input);

                throw nvae;
            }
            switch (alt185) {
                case 1 :
                    // InternalOperationDsl.g:8666:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalOperationDsl.g:8666:3: (enumLiteral_0= 'sync' )
                    // InternalOperationDsl.g:8667:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8674:3: (enumLiteral_1= 'async' )
                    {
                    // InternalOperationDsl.g:8674:3: (enumLiteral_1= 'async' )
                    // InternalOperationDsl.g:8675:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); 

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
    // InternalOperationDsl.g:8685:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8691:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalOperationDsl.g:8692:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalOperationDsl.g:8692:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt186=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt186=1;
                }
                break;
            case 90:
                {
                alt186=2;
                }
                break;
            case 92:
                {
                alt186=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 186, 0, input);

                throw nvae;
            }

            switch (alt186) {
                case 1 :
                    // InternalOperationDsl.g:8693:3: (enumLiteral_0= '<-' )
                    {
                    // InternalOperationDsl.g:8693:3: (enumLiteral_0= '<-' )
                    // InternalOperationDsl.g:8694:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8701:3: (enumLiteral_1= '->' )
                    {
                    // InternalOperationDsl.g:8701:3: (enumLiteral_1= '->' )
                    // InternalOperationDsl.g:8702:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8709:3: (enumLiteral_2= '<->' )
                    {
                    // InternalOperationDsl.g:8709:3: (enumLiteral_2= '<->' )
                    // InternalOperationDsl.g:8710:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,92,FOLLOW_2); 

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
    // InternalOperationDsl.g:8720:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8726:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalOperationDsl.g:8727:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalOperationDsl.g:8727:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt187=2;
            int LA187_0 = input.LA(1);

            if ( (LA187_0==95) ) {
                alt187=1;
            }
            else if ( (LA187_0==96) ) {
                alt187=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 187, 0, input);

                throw nvae;
            }
            switch (alt187) {
                case 1 :
                    // InternalOperationDsl.g:8728:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalOperationDsl.g:8728:3: (enumLiteral_0= 'mandatory' )
                    // InternalOperationDsl.g:8729:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8736:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalOperationDsl.g:8736:3: (enumLiteral_1= 'singleval' )
                    // InternalOperationDsl.g:8737:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,96,FOLLOW_2); 

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
    // InternalOperationDsl.g:8747:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) ;
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
            // InternalOperationDsl.g:8753:2: ( ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) )
            // InternalOperationDsl.g:8754:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            {
            // InternalOperationDsl.g:8754:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            int alt188=8;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt188=1;
                }
                break;
            case 98:
                {
                alt188=2;
                }
                break;
            case 149:
                {
                alt188=3;
                }
                break;
            case 150:
                {
                alt188=4;
                }
                break;
            case 51:
                {
                alt188=5;
                }
                break;
            case 52:
                {
                alt188=6;
                }
                break;
            case 53:
                {
                alt188=7;
                }
                break;
            case 97:
                {
                alt188=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 188, 0, input);

                throw nvae;
            }

            switch (alt188) {
                case 1 :
                    // InternalOperationDsl.g:8755:3: (enumLiteral_0= 'types' )
                    {
                    // InternalOperationDsl.g:8755:3: (enumLiteral_0= 'types' )
                    // InternalOperationDsl.g:8756:4: enumLiteral_0= 'types'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8763:3: (enumLiteral_1= 'fields' )
                    {
                    // InternalOperationDsl.g:8763:3: (enumLiteral_1= 'fields' )
                    // InternalOperationDsl.g:8764:4: enumLiteral_1= 'fields'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8771:3: (enumLiteral_2= 'domainOperations' )
                    {
                    // InternalOperationDsl.g:8771:3: (enumLiteral_2= 'domainOperations' )
                    // InternalOperationDsl.g:8772:4: enumLiteral_2= 'domainOperations'
                    {
                    enumLiteral_2=(Token)match(input,149,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8779:3: (enumLiteral_3= 'domainParameters' )
                    {
                    // InternalOperationDsl.g:8779:3: (enumLiteral_3= 'domainParameters' )
                    // InternalOperationDsl.g:8780:4: enumLiteral_3= 'domainParameters'
                    {
                    enumLiteral_3=(Token)match(input,150,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:8787:3: (enumLiteral_4= 'microservices' )
                    {
                    // InternalOperationDsl.g:8787:3: (enumLiteral_4= 'microservices' )
                    // InternalOperationDsl.g:8788:4: enumLiteral_4= 'microservices'
                    {
                    enumLiteral_4=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:8795:3: (enumLiteral_5= 'interfaces' )
                    {
                    // InternalOperationDsl.g:8795:3: (enumLiteral_5= 'interfaces' )
                    // InternalOperationDsl.g:8796:4: enumLiteral_5= 'interfaces'
                    {
                    enumLiteral_5=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:8803:3: (enumLiteral_6= 'operations' )
                    {
                    // InternalOperationDsl.g:8803:3: (enumLiteral_6= 'operations' )
                    // InternalOperationDsl.g:8804:4: enumLiteral_6= 'operations'
                    {
                    enumLiteral_6=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:8811:3: (enumLiteral_7= 'parameters' )
                    {
                    // InternalOperationDsl.g:8811:3: (enumLiteral_7= 'parameters' )
                    // InternalOperationDsl.g:8812:4: enumLiteral_7= 'parameters'
                    {
                    enumLiteral_7=(Token)match(input,97,FOLLOW_2); 

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
    // InternalOperationDsl.g:8822:1: ruleAspectFeature returns [Enumerator current=null] : (enumLiteral_0= 'singleval' ) ;
    public final Enumerator ruleAspectFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8828:2: ( (enumLiteral_0= 'singleval' ) )
            // InternalOperationDsl.g:8829:2: (enumLiteral_0= 'singleval' )
            {
            // InternalOperationDsl.g:8829:2: (enumLiteral_0= 'singleval' )
            // InternalOperationDsl.g:8830:3: enumLiteral_0= 'singleval'
            {
            enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

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
    // InternalOperationDsl.g:8839:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8845:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalOperationDsl.g:8846:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalOperationDsl.g:8846:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt189=2;
            int LA189_0 = input.LA(1);

            if ( (LA189_0==105) ) {
                alt189=1;
            }
            else if ( (LA189_0==76) ) {
                alt189=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 189, 0, input);

                throw nvae;
            }
            switch (alt189) {
                case 1 :
                    // InternalOperationDsl.g:8847:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalOperationDsl.g:8847:3: (enumLiteral_0= 'containers' )
                    // InternalOperationDsl.g:8848:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8855:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalOperationDsl.g:8855:3: (enumLiteral_1= 'infrastructure' )
                    // InternalOperationDsl.g:8856:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); 

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
    // InternalOperationDsl.g:8866:1: ruleComplexTypeFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
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
            // InternalOperationDsl.g:8872:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalOperationDsl.g:8873:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalOperationDsl.g:8873:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt190=11;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt190=1;
                }
                break;
            case 110:
                {
                alt190=2;
                }
                break;
            case 111:
                {
                alt190=3;
                }
                break;
            case 112:
                {
                alt190=4;
                }
                break;
            case 113:
                {
                alt190=5;
                }
                break;
            case 114:
                {
                alt190=6;
                }
                break;
            case 115:
                {
                alt190=7;
                }
                break;
            case 116:
                {
                alt190=8;
                }
                break;
            case 74:
                {
                alt190=9;
                }
                break;
            case 117:
                {
                alt190=10;
                }
                break;
            case 118:
                {
                alt190=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 190, 0, input);

                throw nvae;
            }

            switch (alt190) {
                case 1 :
                    // InternalOperationDsl.g:8874:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalOperationDsl.g:8874:3: (enumLiteral_0= 'aggregate' )
                    // InternalOperationDsl.g:8875:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8882:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalOperationDsl.g:8882:3: (enumLiteral_1= 'applicationService' )
                    // InternalOperationDsl.g:8883:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8890:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalOperationDsl.g:8890:3: (enumLiteral_2= 'domainEvent' )
                    // InternalOperationDsl.g:8891:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:8898:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalOperationDsl.g:8898:3: (enumLiteral_3= 'domainService' )
                    // InternalOperationDsl.g:8899:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOperationDsl.g:8906:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalOperationDsl.g:8906:3: (enumLiteral_4= 'entity' )
                    // InternalOperationDsl.g:8907:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOperationDsl.g:8914:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalOperationDsl.g:8914:3: (enumLiteral_5= 'factory' )
                    // InternalOperationDsl.g:8915:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalOperationDsl.g:8922:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalOperationDsl.g:8922:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalOperationDsl.g:8923:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalOperationDsl.g:8930:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalOperationDsl.g:8930:3: (enumLiteral_7= 'repository' )
                    // InternalOperationDsl.g:8931:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalOperationDsl.g:8938:3: (enumLiteral_8= 'service' )
                    {
                    // InternalOperationDsl.g:8938:3: (enumLiteral_8= 'service' )
                    // InternalOperationDsl.g:8939:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalOperationDsl.g:8946:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalOperationDsl.g:8946:3: (enumLiteral_9= 'specification' )
                    // InternalOperationDsl.g:8947:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalOperationDsl.g:8954:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalOperationDsl.g:8954:3: (enumLiteral_10= 'valueObject' )
                    // InternalOperationDsl.g:8955:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,118,FOLLOW_2); 

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
    // InternalOperationDsl.g:8965:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:8971:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalOperationDsl.g:8972:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalOperationDsl.g:8972:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt191=3;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt191=1;
                }
                break;
            case 121:
                {
                alt191=2;
                }
                break;
            case 122:
                {
                alt191=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 191, 0, input);

                throw nvae;
            }

            switch (alt191) {
                case 1 :
                    // InternalOperationDsl.g:8973:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalOperationDsl.g:8973:3: (enumLiteral_0= 'identifier' )
                    // InternalOperationDsl.g:8974:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:8981:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalOperationDsl.g:8981:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalOperationDsl.g:8982:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:8989:3: (enumLiteral_2= 'part' )
                    {
                    // InternalOperationDsl.g:8989:3: (enumLiteral_2= 'part' )
                    // InternalOperationDsl.g:8990:4: enumLiteral_2= 'part'
                    {
                    enumLiteral_2=(Token)match(input,122,FOLLOW_2); 

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
    // InternalOperationDsl.g:9000:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalOperationDsl.g:9006:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalOperationDsl.g:9007:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalOperationDsl.g:9007:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt192=4;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt192=1;
                }
                break;
            case 120:
                {
                alt192=2;
                }
                break;
            case 127:
                {
                alt192=3;
                }
                break;
            case 128:
                {
                alt192=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 192, 0, input);

                throw nvae;
            }

            switch (alt192) {
                case 1 :
                    // InternalOperationDsl.g:9008:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalOperationDsl.g:9008:3: (enumLiteral_0= 'closure' )
                    // InternalOperationDsl.g:9009:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:9016:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalOperationDsl.g:9016:3: (enumLiteral_1= 'identifier' )
                    // InternalOperationDsl.g:9017:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOperationDsl.g:9024:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalOperationDsl.g:9024:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalOperationDsl.g:9025:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOperationDsl.g:9032:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalOperationDsl.g:9032:3: (enumLiteral_3= 'validator' )
                    // InternalOperationDsl.g:9033:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,128,FOLLOW_2); 

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
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA158 dfa158 = new DFA158(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\1\2\7\uffff";
    static final String dfa_3s = "\1\16\1\17\1\uffff\1\20\1\4\1\21\1\4\1\uffff";
    static final String dfa_4s = "\1\16\1\17\1\uffff\1\20\1\4\1\21\1\22\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\4\uffff\1\1";
    static final String dfa_6s = "\10\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\2\11\uffff\1\1\3\uffff\1\7",
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
    static final String dfa_9s = "\1\4\1\20\1\uffff\2\5\3\21\4\4\2\uffff";
    static final String dfa_10s = "\1\43\1\52\1\uffff\2\10\3\21\4\43\2\uffff";
    static final String dfa_11s = "\2\uffff\1\2\11\uffff\1\1\1\3";
    static final String dfa_12s = "\16\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\36\uffff\1\2",
            "\1\3\31\uffff\1\4",
            "",
            "\1\7\1\6\1\uffff\1\5",
            "\1\12\1\11\1\uffff\1\10",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\1\33\uffff\1\14\2\uffff\1\15",
            "\1\1\33\uffff\1\14\2\uffff\1\15",
            "\1\1\33\uffff\1\14\2\uffff\1\15",
            "\1\1\33\uffff\1\14\2\uffff\1\15",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
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
    static final String dfa_14s = "\161\uffff";
    static final String dfa_15s = "\1\4\1\uffff\1\4\1\uffff\1\45\3\20\5\4\3\45\7\4\3\21\4\20\1\4\2\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\6\21\1\20\1\21\1\45\1\30\1\20\1\21\1\45\1\30\1\20\1\21\2\4\1\21\1\30\1\4\1\5\1\4\1\30\1\4\1\5\1\4\1\21\4\20\1\30\1\4\1\20\1\30\2\4\2\5\1\4\1\5\1\4\1\5\1\4\1\45\6\21\1\20\1\21\1\20\1\21\1\56\1\4\1\21\2\30\1\20\1\4\1\5\1\4\1\20\1\21\1\4\1\21";
    static final String dfa_16s = "\1\u008f\1\uffff\1\124\1\uffff\1\45\1\56\2\20\4\4\1\u008f\3\45\1\4\1\10\4\4\1\u008f\3\21\1\52\3\100\1\u008f\2\10\1\4\1\5\1\4\1\5\1\4\1\5\1\4\1\5\1\4\1\5\1\u008f\3\30\3\21\1\100\1\21\1\45\1\51\1\100\1\21\1\45\1\51\1\100\1\21\1\124\1\4\1\30\1\50\1\4\1\5\1\57\1\50\1\4\1\5\2\21\2\20\1\52\1\100\1\51\1\u008f\1\100\1\51\1\u008f\1\4\2\10\1\4\1\5\1\4\1\5\1\44\1\45\3\30\3\21\1\100\1\21\1\100\1\21\1\56\1\4\1\30\2\50\1\100\1\4\1\5\1\u008f\1\100\1\21\1\44\1\21";
    static final String dfa_17s = "\1\uffff\1\2\1\uffff\1\1\155\uffff";
    static final String dfa_18s = "\161\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\11\uffff\1\2\21\uffff\1\1\26\uffff\1\1\1\uffff\1\1\3\uffff\1\3\117\uffff\3\1",
            "",
            "\1\4\37\uffff\1\5\56\uffff\1\6\1\7",
            "",
            "\1\10",
            "\1\12\35\uffff\1\11",
            "\1\13",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\1\11\uffff\1\22\1\uffff\1\21\46\uffff\1\1\5\uffff\1\3\2\uffff\1\20\114\uffff\3\1",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\32\1\31\1\30\1\uffff\1\27",
            "\1\4",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\1\11\uffff\1\22\1\uffff\1\21\46\uffff\1\1\5\uffff\1\3\2\uffff\1\20\114\uffff\3\1",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\40\31\uffff\1\37",
            "\1\42\7\uffff\1\43\17\uffff\1\44\27\uffff\1\41",
            "\1\46\7\uffff\1\47\17\uffff\1\50\27\uffff\1\45",
            "\1\52\1\53\56\uffff\1\51",
            "\1\1\11\uffff\1\22\50\uffff\1\1\5\uffff\1\3\117\uffff\3\1",
            "\1\56\1\55\1\uffff\1\54",
            "\1\61\1\60\1\uffff\1\57",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\1\11\uffff\1\74\50\uffff\1\1\5\uffff\1\3\117\uffff\3\1",
            "\1\36\6\uffff\1\75",
            "\1\36\6\uffff\1\75",
            "\1\36\6\uffff\1\75",
            "\1\76",
            "\1\76",
            "\1\76",
            "\1\42\7\uffff\1\43\17\uffff\1\44\27\uffff\1\41",
            "\1\77",
            "\1\100",
            "\1\101\20\uffff\1\102",
            "\1\46\7\uffff\1\47\17\uffff\1\50\27\uffff\1\45",
            "\1\103",
            "\1\104",
            "\1\105\20\uffff\1\106",
            "\1\52\1\53\56\uffff\1\51",
            "\1\107",
            "\1\4\37\uffff\1\5\56\uffff\1\110\1\111",
            "\1\112",
            "\1\36\6\uffff\1\75",
            "\1\43\17\uffff\1\44",
            "\1\113",
            "\1\114",
            "\1\15\52\uffff\1\115",
            "\1\47\17\uffff\1\50",
            "\1\116",
            "\1\117",
            "\1\16\14\uffff\1\120",
            "\1\53",
            "\1\121",
            "\1\121",
            "\1\123\31\uffff\1\122",
            "\1\125\7\uffff\1\43\17\uffff\1\44\27\uffff\1\124",
            "\1\101\20\uffff\1\102",
            "\1\1\11\uffff\1\22\50\uffff\1\1\5\uffff\1\3\117\uffff\3\1",
            "\1\127\7\uffff\1\47\17\uffff\1\50\27\uffff\1\126",
            "\1\105\20\uffff\1\106",
            "\1\1\11\uffff\1\130\50\uffff\1\1\5\uffff\1\3\117\uffff\3\1",
            "\1\131",
            "\1\134\1\133\1\uffff\1\132",
            "\1\137\1\136\1\uffff\1\135",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\4\37\uffff\1\144",
            "\1\145",
            "\1\36\6\uffff\1\75",
            "\1\36\6\uffff\1\75",
            "\1\36\6\uffff\1\75",
            "\1\146",
            "\1\146",
            "\1\146",
            "\1\125\7\uffff\1\43\17\uffff\1\44\27\uffff\1\124",
            "\1\147",
            "\1\127\7\uffff\1\47\17\uffff\1\50\27\uffff\1\126",
            "\1\150",
            "\1\11",
            "\1\151",
            "\1\36\6\uffff\1\75",
            "\1\43\17\uffff\1\44",
            "\1\47\17\uffff\1\50",
            "\1\153\1\154\56\uffff\1\152",
            "\1\155",
            "\1\156",
            "\1\1\11\uffff\1\157\50\uffff\1\1\5\uffff\1\3\117\uffff\3\1",
            "\1\153\1\154\56\uffff\1\152",
            "\1\160",
            "\1\4\37\uffff\1\5",
            "\1\154"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()* loopback of 2823:3: ( (lv_referredOperations_20_0= ruleReferredOperation ) )*";
        }
    }
    static final String dfa_20s = "\21\uffff";
    static final String dfa_21s = "\1\130\1\4\1\36\1\4\1\uffff\13\4\1\uffff";
    static final String dfa_22s = "\1\130\1\4\1\36\1\u0094\1\uffff\13\40\1\uffff";
    static final String dfa_23s = "\4\uffff\1\1\13\uffff\1\2";
    static final String dfa_24s = "\21\uffff}>";
    static final String[] dfa_25s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\166\uffff\2\4\6\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\7\uffff\1\17",
            "",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            "\1\4\33\uffff\1\20",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA158 extends DFA {

        public DFA158(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 158;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "7296:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000080000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000053000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000051000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000380000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000300000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000052100000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000052000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001380000010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001300000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001100000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000020001000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000900000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000160L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000010000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000170L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0008000008008000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000004000L,0x0000000000001000L,0x00000000000CE000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0002000040000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0184000000004000L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0184000100004000L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0180000000004000L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x2280000100004010L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0280000100004010L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xE1FF3F33C53BC3F0L,0xFFFFF7FFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x1E00000000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0080000000004010L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000001024000L,0x0000000000180000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000004000L,0x0000000000180000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x2000000000004000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x4000000000000010L,0x0000000000070000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x4000000000000010L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x8000010000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0xE1FF3F33C53BC3F2L,0xFFFFF7FFFFFFFFFFL,0x00000000000FFFFFL});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000020201000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000020000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000001000000L,0x000000001C000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000060000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000180000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000070000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000002L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0038000000000000L,0x0000000600000040L,0x0000000000600000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000020041000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000100000000L,0x0000040000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x0000020000001000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000100000000L,0x2000100003000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000100000000L,0x2000000003000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000100000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x2000000003000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000040000000L,0x0080000000000002L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x007FE00000000400L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000040000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000100000010L,0x1800000000000000L,0x0000000000101FFEL});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000000010L,0x1800000000000000L,0x0000000000101FFEL});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000010L,0x1800000000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000010L,0x1000000000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000000000000L,0x0700000000000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000010002L,0x0000000000000002L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000001020010L,0x0000000000000000L,0x0000000000101FF8L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000000000L,0xC100000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});

}