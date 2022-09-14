package de.fhdo.lemma.technology.parser.antlr.internal;

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
import de.fhdo.lemma.technology.services.TechnologyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTechnologyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'technology'", "'{'", "'types'", "'compatibility'", "'matrix'", "'}'", "'protocols'", "'service'", "'aspects'", "'deployment'", "'technologies'", "'infrastructure'", "'operation'", "'import'", "'from'", "'as'", "'data'", "'formats'", "','", "'default'", "'with'", "'format'", "';'", "'primitive'", "'type'", "'based'", "'on'", "'collection'", "'structure'", "'::'", "'environments'", "'='", "'properties'", "'<'", "'>'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'selector'", "'('", "')'", "'aspect'", "'for'", "'datatypes'", "'version'", "'context'", "'extends'", "'hide'", "'immutable'", "'enum'", "'procedure'", "'function'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'unspecified'", "'.'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'->'", "'<->'", "'mandatory'", "'singleval'", "'fields'", "'domainOperations'", "'domainParameters'", "'microservices'", "'interfaces'", "'operations'", "'parameters'", "'containers'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'specification'", "'valueObject'", "'identifier'", "'neverEmpty'", "'part'", "'closure'", "'sideEffectFree'", "'validator'"
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
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
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


        public InternalTechnologyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTechnologyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTechnologyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTechnologyDsl.g"; }



     	private TechnologyDslGrammarAccess grammarAccess;

        public InternalTechnologyDslParser(TokenStream input, TechnologyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Technology";
       	}

       	@Override
       	protected TechnologyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTechnology"
    // InternalTechnologyDsl.g:65:1: entryRuleTechnology returns [EObject current=null] : iv_ruleTechnology= ruleTechnology EOF ;
    public final EObject entryRuleTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnology = null;


        try {
            // InternalTechnologyDsl.g:65:51: (iv_ruleTechnology= ruleTechnology EOF )
            // InternalTechnologyDsl.g:66:2: iv_ruleTechnology= ruleTechnology EOF
            {
             newCompositeNode(grammarAccess.getTechnologyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnology=ruleTechnology();

            state._fsp--;

             current =iv_ruleTechnology; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnology"


    // $ANTLR start "ruleTechnology"
    // InternalTechnologyDsl.g:72:1: ruleTechnology returns [EObject current=null] : ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' ) ;
    public final EObject ruleTechnology() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        EObject lv_imports_0_0 = null;

        EObject lv_primitiveTypes_6_0 = null;

        EObject lv_collectionTypes_7_0 = null;

        EObject lv_dataStructures_8_0 = null;

        EObject lv_compatibilityEntries_12_0 = null;

        EObject lv_protocols_17_0 = null;

        EObject lv_serviceAspects_22_0 = null;

        EObject lv_deploymentTechnologies_27_0 = null;

        EObject lv_infrastructureTechnologies_32_0 = null;

        EObject lv_operationAspects_37_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' ) )
            // InternalTechnologyDsl.g:79:2: ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' )
            {
            // InternalTechnologyDsl.g:79:2: ( ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}' )
            // InternalTechnologyDsl.g:80:3: ( (lv_imports_0_0= ruleTechnologyImport ) )* otherlv_1= 'technology' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )? (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )? (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )? (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )? (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )? (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )? otherlv_39= '}'
            {
            // InternalTechnologyDsl.g:80:3: ( (lv_imports_0_0= ruleTechnologyImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==26) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTechnologyDsl.g:81:4: (lv_imports_0_0= ruleTechnologyImport )
            	    {
            	    // InternalTechnologyDsl.g:81:4: (lv_imports_0_0= ruleTechnologyImport )
            	    // InternalTechnologyDsl.g:82:5: lv_imports_0_0= ruleTechnologyImport
            	    {

            	    					newCompositeNode(grammarAccess.getTechnologyAccess().getImportsTechnologyImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleTechnologyImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTechnologyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"de.fhdo.lemma.technology.TechnologyDsl.TechnologyImport");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyAccess().getTechnologyKeyword_1());
            		
            // InternalTechnologyDsl.g:103:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:104:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:104:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:105:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTechnologyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTechnologyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTechnologyDsl.g:125:3: (otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTechnologyDsl.g:126:4: otherlv_4= 'types' otherlv_5= '{' ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+ (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )? otherlv_14= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologyAccess().getTypesKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalTechnologyDsl.g:134:4: ( ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) ) | ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) ) | ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=4;
                        switch ( input.LA(1) ) {
                        case 36:
                            {
                            alt2=1;
                            }
                            break;
                        case 40:
                            {
                            alt2=2;
                            }
                            break;
                        case 41:
                            {
                            alt2=3;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:135:5: ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) )
                    	    {
                    	    // InternalTechnologyDsl.g:135:5: ( (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType ) )
                    	    // InternalTechnologyDsl.g:136:6: (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType )
                    	    {
                    	    // InternalTechnologyDsl.g:136:6: (lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType )
                    	    // InternalTechnologyDsl.g:137:7: lv_primitiveTypes_6_0= ruleTechnologySpecificPrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologyAccess().getPrimitiveTypesTechnologySpecificPrimitiveTypeParserRuleCall_4_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_primitiveTypes_6_0=ruleTechnologySpecificPrimitiveType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"primitiveTypes",
                    	    								lv_primitiveTypes_6_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificPrimitiveType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTechnologyDsl.g:155:5: ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) )
                    	    {
                    	    // InternalTechnologyDsl.g:155:5: ( (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType ) )
                    	    // InternalTechnologyDsl.g:156:6: (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType )
                    	    {
                    	    // InternalTechnologyDsl.g:156:6: (lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType )
                    	    // InternalTechnologyDsl.g:157:7: lv_collectionTypes_7_0= ruleTechnologySpecificCollectionType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologyAccess().getCollectionTypesTechnologySpecificCollectionTypeParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_collectionTypes_7_0=ruleTechnologySpecificCollectionType();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"collectionTypes",
                    	    								lv_collectionTypes_7_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificCollectionType");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalTechnologyDsl.g:175:5: ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) )
                    	    {
                    	    // InternalTechnologyDsl.g:175:5: ( (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure ) )
                    	    // InternalTechnologyDsl.g:176:6: (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure )
                    	    {
                    	    // InternalTechnologyDsl.g:176:6: (lv_dataStructures_8_0= ruleTechnologySpecificDataStructure )
                    	    // InternalTechnologyDsl.g:177:7: lv_dataStructures_8_0= ruleTechnologySpecificDataStructure
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologyAccess().getDataStructuresTechnologySpecificDataStructureParserRuleCall_4_2_2_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_dataStructures_8_0=ruleTechnologySpecificDataStructure();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataStructures",
                    	    								lv_dataStructures_8_0,
                    	    								"de.fhdo.lemma.technology.TechnologyDsl.TechnologySpecificDataStructure");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


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

                    // InternalTechnologyDsl.g:195:4: (otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==16) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalTechnologyDsl.g:196:5: otherlv_9= 'compatibility' otherlv_10= 'matrix' otherlv_11= '{' ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+ otherlv_13= '}'
                            {
                            otherlv_9=(Token)match(input,16,FOLLOW_9); 

                            					newLeafNode(otherlv_9, grammarAccess.getTechnologyAccess().getCompatibilityKeyword_4_3_0());
                            				
                            otherlv_10=(Token)match(input,17,FOLLOW_5); 

                            					newLeafNode(otherlv_10, grammarAccess.getTechnologyAccess().getMatrixKeyword_4_3_1());
                            				
                            otherlv_11=(Token)match(input,14,FOLLOW_4); 

                            					newLeafNode(otherlv_11, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_3_2());
                            				
                            // InternalTechnologyDsl.g:208:5: ( (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry ) )+
                            int cnt3=0;
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==RULE_ID) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // InternalTechnologyDsl.g:209:6: (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry )
                            	    {
                            	    // InternalTechnologyDsl.g:209:6: (lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry )
                            	    // InternalTechnologyDsl.g:210:7: lv_compatibilityEntries_12_0= ruleCompatibilityMatrixEntry
                            	    {

                            	    							newCompositeNode(grammarAccess.getTechnologyAccess().getCompatibilityEntriesCompatibilityMatrixEntryParserRuleCall_4_3_3_0());
                            	    						
                            	    pushFollow(FOLLOW_10);
                            	    lv_compatibilityEntries_12_0=ruleCompatibilityMatrixEntry();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getTechnologyRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"compatibilityEntries",
                            	    								lv_compatibilityEntries_12_0,
                            	    								"de.fhdo.lemma.technology.TechnologyDsl.CompatibilityMatrixEntry");
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

                            otherlv_13=(Token)match(input,18,FOLLOW_11); 

                            					newLeafNode(otherlv_13, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_3_4());
                            				

                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_14, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:237:3: (otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalTechnologyDsl.g:238:4: otherlv_15= 'protocols' otherlv_16= '{' ( (lv_protocols_17_0= ruleProtocol ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_5); 

                    				newLeafNode(otherlv_15, grammarAccess.getTechnologyAccess().getProtocolsKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_16, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalTechnologyDsl.g:246:4: ( (lv_protocols_17_0= ruleProtocol ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=81 && LA6_0<=82)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:247:5: (lv_protocols_17_0= ruleProtocol )
                    	    {
                    	    // InternalTechnologyDsl.g:247:5: (lv_protocols_17_0= ruleProtocol )
                    	    // InternalTechnologyDsl.g:248:6: lv_protocols_17_0= ruleProtocol
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getProtocolsProtocolParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_protocols_17_0=ruleProtocol();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"protocols",
                    	    							lv_protocols_17_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.Protocol");
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

                    otherlv_18=(Token)match(input,18,FOLLOW_15); 

                    				newLeafNode(otherlv_18, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:270:3: (otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTechnologyDsl.g:271:4: otherlv_19= 'service' otherlv_20= 'aspects' otherlv_21= '{' ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+ otherlv_23= '}'
                    {
                    otherlv_19=(Token)match(input,20,FOLLOW_16); 

                    				newLeafNode(otherlv_19, grammarAccess.getTechnologyAccess().getServiceKeyword_6_0());
                    			
                    otherlv_20=(Token)match(input,21,FOLLOW_5); 

                    				newLeafNode(otherlv_20, grammarAccess.getTechnologyAccess().getAspectsKeyword_6_1());
                    			
                    otherlv_21=(Token)match(input,14,FOLLOW_17); 

                    				newLeafNode(otherlv_21, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_6_2());
                    			
                    // InternalTechnologyDsl.g:283:4: ( (lv_serviceAspects_22_0= ruleServiceAspect ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==55) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:284:5: (lv_serviceAspects_22_0= ruleServiceAspect )
                    	    {
                    	    // InternalTechnologyDsl.g:284:5: (lv_serviceAspects_22_0= ruleServiceAspect )
                    	    // InternalTechnologyDsl.g:285:6: lv_serviceAspects_22_0= ruleServiceAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getServiceAspectsServiceAspectParserRuleCall_6_3_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_serviceAspects_22_0=ruleServiceAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"serviceAspects",
                    	    							lv_serviceAspects_22_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.ServiceAspect");
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

                    otherlv_23=(Token)match(input,18,FOLLOW_19); 

                    				newLeafNode(otherlv_23, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:307:3: (otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTechnologyDsl.g:308:4: otherlv_24= 'deployment' otherlv_25= 'technologies' otherlv_26= '{' ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+ otherlv_28= '}'
                    {
                    otherlv_24=(Token)match(input,22,FOLLOW_20); 

                    				newLeafNode(otherlv_24, grammarAccess.getTechnologyAccess().getDeploymentKeyword_7_0());
                    			
                    otherlv_25=(Token)match(input,23,FOLLOW_5); 

                    				newLeafNode(otherlv_25, grammarAccess.getTechnologyAccess().getTechnologiesKeyword_7_1());
                    			
                    otherlv_26=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_26, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_7_2());
                    			
                    // InternalTechnologyDsl.g:320:4: ( (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology ) )+
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
                    	    // InternalTechnologyDsl.g:321:5: (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology )
                    	    {
                    	    // InternalTechnologyDsl.g:321:5: (lv_deploymentTechnologies_27_0= ruleDeploymentTechnology )
                    	    // InternalTechnologyDsl.g:322:6: lv_deploymentTechnologies_27_0= ruleDeploymentTechnology
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesDeploymentTechnologyParserRuleCall_7_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_deploymentTechnologies_27_0=ruleDeploymentTechnology();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"deploymentTechnologies",
                    	    							lv_deploymentTechnologies_27_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.DeploymentTechnology");
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

                    otherlv_28=(Token)match(input,18,FOLLOW_21); 

                    				newLeafNode(otherlv_28, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_7_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:344:3: (otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTechnologyDsl.g:345:4: otherlv_29= 'infrastructure' otherlv_30= 'technologies' otherlv_31= '{' ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+ otherlv_33= '}'
                    {
                    otherlv_29=(Token)match(input,24,FOLLOW_20); 

                    				newLeafNode(otherlv_29, grammarAccess.getTechnologyAccess().getInfrastructureKeyword_8_0());
                    			
                    otherlv_30=(Token)match(input,23,FOLLOW_5); 

                    				newLeafNode(otherlv_30, grammarAccess.getTechnologyAccess().getTechnologiesKeyword_8_1());
                    			
                    otherlv_31=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_31, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalTechnologyDsl.g:357:4: ( (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology ) )+
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
                    	    // InternalTechnologyDsl.g:358:5: (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology )
                    	    {
                    	    // InternalTechnologyDsl.g:358:5: (lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology )
                    	    // InternalTechnologyDsl.g:359:6: lv_infrastructureTechnologies_32_0= ruleInfrastructureTechnology
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesInfrastructureTechnologyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_infrastructureTechnologies_32_0=ruleInfrastructureTechnology();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"infrastructureTechnologies",
                    	    							lv_infrastructureTechnologies_32_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.InfrastructureTechnology");
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

                    otherlv_33=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_33, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:381:3: (otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTechnologyDsl.g:382:4: otherlv_34= 'operation' otherlv_35= 'aspects' otherlv_36= '{' ( (lv_operationAspects_37_0= ruleOperationAspect ) )+ otherlv_38= '}'
                    {
                    otherlv_34=(Token)match(input,25,FOLLOW_16); 

                    				newLeafNode(otherlv_34, grammarAccess.getTechnologyAccess().getOperationKeyword_9_0());
                    			
                    otherlv_35=(Token)match(input,21,FOLLOW_5); 

                    				newLeafNode(otherlv_35, grammarAccess.getTechnologyAccess().getAspectsKeyword_9_1());
                    			
                    otherlv_36=(Token)match(input,14,FOLLOW_17); 

                    				newLeafNode(otherlv_36, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_9_2());
                    			
                    // InternalTechnologyDsl.g:394:4: ( (lv_operationAspects_37_0= ruleOperationAspect ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==55) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:395:5: (lv_operationAspects_37_0= ruleOperationAspect )
                    	    {
                    	    // InternalTechnologyDsl.g:395:5: (lv_operationAspects_37_0= ruleOperationAspect )
                    	    // InternalTechnologyDsl.g:396:6: lv_operationAspects_37_0= ruleOperationAspect
                    	    {

                    	    						newCompositeNode(grammarAccess.getTechnologyAccess().getOperationAspectsOperationAspectParserRuleCall_9_3_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_operationAspects_37_0=ruleOperationAspect();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTechnologyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"operationAspects",
                    	    							lv_operationAspects_37_0,
                    	    							"de.fhdo.lemma.technology.TechnologyDsl.OperationAspect");
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

                    otherlv_38=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_38, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_9_4());
                    			

                    }
                    break;

            }

            otherlv_39=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_39, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnology"


    // $ANTLR start "entryRuleTechnologyImport"
    // InternalTechnologyDsl.g:426:1: entryRuleTechnologyImport returns [EObject current=null] : iv_ruleTechnologyImport= ruleTechnologyImport EOF ;
    public final EObject entryRuleTechnologyImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologyImport = null;


        try {
            // InternalTechnologyDsl.g:426:57: (iv_ruleTechnologyImport= ruleTechnologyImport EOF )
            // InternalTechnologyDsl.g:427:2: iv_ruleTechnologyImport= ruleTechnologyImport EOF
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
    // InternalTechnologyDsl.g:433:1: ruleTechnologyImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalTechnologyDsl.g:439:2: ( (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:440:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:440:2: (otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:441:3: otherlv_0= 'import' otherlv_1= 'technology' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getTechnologyImportAccess().getFromKeyword_2());
            		
            // InternalTechnologyDsl.g:453:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:454:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:454:4: (lv_importURI_3_0= RULE_STRING )
            // InternalTechnologyDsl.g:455:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

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

            otherlv_4=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyImportAccess().getAsKeyword_4());
            		
            // InternalTechnologyDsl.g:475:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTechnologyDsl.g:476:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:476:4: (lv_name_5_0= RULE_ID )
            // InternalTechnologyDsl.g:477:5: lv_name_5_0= RULE_ID
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
    // InternalTechnologyDsl.g:497:1: entryRuleProtocol returns [EObject current=null] : iv_ruleProtocol= ruleProtocol EOF ;
    public final EObject entryRuleProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocol = null;


        try {
            // InternalTechnologyDsl.g:497:49: (iv_ruleProtocol= ruleProtocol EOF )
            // InternalTechnologyDsl.g:498:2: iv_ruleProtocol= ruleProtocol EOF
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
    // InternalTechnologyDsl.g:504:1: ruleProtocol returns [EObject current=null] : ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) ;
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
            // InternalTechnologyDsl.g:510:2: ( ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // InternalTechnologyDsl.g:511:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // InternalTechnologyDsl.g:511:2: ( ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';' )
            // InternalTechnologyDsl.g:512:3: ( (lv_communicationType_0_0= ruleCommunicationType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'data' otherlv_3= 'formats' ( (lv_dataFormats_4_0= ruleDataFormat ) ) (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )* ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // InternalTechnologyDsl.g:512:3: ( (lv_communicationType_0_0= ruleCommunicationType ) )
            // InternalTechnologyDsl.g:513:4: (lv_communicationType_0_0= ruleCommunicationType )
            {
            // InternalTechnologyDsl.g:513:4: (lv_communicationType_0_0= ruleCommunicationType )
            // InternalTechnologyDsl.g:514:5: lv_communicationType_0_0= ruleCommunicationType
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalTechnologyDsl.g:531:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:532:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:532:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:533:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

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

            otherlv_2=(Token)match(input,29,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getProtocolAccess().getFormatsKeyword_3());
            		
            // InternalTechnologyDsl.g:557:3: ( (lv_dataFormats_4_0= ruleDataFormat ) )
            // InternalTechnologyDsl.g:558:4: (lv_dataFormats_4_0= ruleDataFormat )
            {
            // InternalTechnologyDsl.g:558:4: (lv_dataFormats_4_0= ruleDataFormat )
            // InternalTechnologyDsl.g:559:5: lv_dataFormats_4_0= ruleDataFormat
            {

            					newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_29);
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

            // InternalTechnologyDsl.g:576:3: (otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTechnologyDsl.g:577:4: otherlv_5= ',' ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    {
            	    otherlv_5=(Token)match(input,31,FOLLOW_25); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProtocolAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTechnologyDsl.g:581:4: ( (lv_dataFormats_6_0= ruleDataFormat ) )
            	    // InternalTechnologyDsl.g:582:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    {
            	    // InternalTechnologyDsl.g:582:5: (lv_dataFormats_6_0= ruleDataFormat )
            	    // InternalTechnologyDsl.g:583:6: lv_dataFormats_6_0= ruleDataFormat
            	    {

            	    						newCompositeNode(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    break loop16;
                }
            } while (true);

            // InternalTechnologyDsl.g:601:3: ( ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTechnologyDsl.g:602:4: ( (lv_default_7_0= 'default' ) ) otherlv_8= 'with' otherlv_9= 'format' ( (otherlv_10= RULE_STRING ) )
                    {
                    // InternalTechnologyDsl.g:602:4: ( (lv_default_7_0= 'default' ) )
                    // InternalTechnologyDsl.g:603:5: (lv_default_7_0= 'default' )
                    {
                    // InternalTechnologyDsl.g:603:5: (lv_default_7_0= 'default' )
                    // InternalTechnologyDsl.g:604:6: lv_default_7_0= 'default'
                    {
                    lv_default_7_0=(Token)match(input,32,FOLLOW_30); 

                    						newLeafNode(lv_default_7_0, grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    						setWithLastConsumed(current, "default", lv_default_7_0 != null, "default");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,33,FOLLOW_31); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolAccess().getWithKeyword_6_1());
                    			
                    otherlv_9=(Token)match(input,34,FOLLOW_25); 

                    				newLeafNode(otherlv_9, grammarAccess.getProtocolAccess().getFormatKeyword_6_2());
                    			
                    // InternalTechnologyDsl.g:624:4: ( (otherlv_10= RULE_STRING ) )
                    // InternalTechnologyDsl.g:625:5: (otherlv_10= RULE_STRING )
                    {
                    // InternalTechnologyDsl.g:625:5: (otherlv_10= RULE_STRING )
                    // InternalTechnologyDsl.g:626:6: otherlv_10= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProtocolRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_STRING,FOLLOW_32); 

                    						newLeafNode(otherlv_10, grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:646:1: entryRuleDataFormat returns [EObject current=null] : iv_ruleDataFormat= ruleDataFormat EOF ;
    public final EObject entryRuleDataFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFormat = null;


        try {
            // InternalTechnologyDsl.g:646:51: (iv_ruleDataFormat= ruleDataFormat EOF )
            // InternalTechnologyDsl.g:647:2: iv_ruleDataFormat= ruleDataFormat EOF
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
    // InternalTechnologyDsl.g:653:1: ruleDataFormat returns [EObject current=null] : ( (lv_formatName_0_0= RULE_STRING ) ) ;
    public final EObject ruleDataFormat() throws RecognitionException {
        EObject current = null;

        Token lv_formatName_0_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:659:2: ( ( (lv_formatName_0_0= RULE_STRING ) ) )
            // InternalTechnologyDsl.g:660:2: ( (lv_formatName_0_0= RULE_STRING ) )
            {
            // InternalTechnologyDsl.g:660:2: ( (lv_formatName_0_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:661:3: (lv_formatName_0_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:661:3: (lv_formatName_0_0= RULE_STRING )
            // InternalTechnologyDsl.g:662:4: lv_formatName_0_0= RULE_STRING
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
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // InternalTechnologyDsl.g:681:1: entryRuleTechnologySpecificPrimitiveType returns [EObject current=null] : iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF ;
    public final EObject entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificPrimitiveType = null;


        try {
            // InternalTechnologyDsl.g:681:72: (iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF )
            // InternalTechnologyDsl.g:682:2: iv_ruleTechnologySpecificPrimitiveType= ruleTechnologySpecificPrimitiveType EOF
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
    // InternalTechnologyDsl.g:688:1: ruleTechnologySpecificPrimitiveType returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) ;
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
            // InternalTechnologyDsl.g:694:2: ( (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' ) )
            // InternalTechnologyDsl.g:695:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            {
            // InternalTechnologyDsl.g:695:2: (otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';' )
            // InternalTechnologyDsl.g:696:3: otherlv_0= 'primitive' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1());
            		
            // InternalTechnologyDsl.g:704:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:705:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:705:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:706:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            // InternalTechnologyDsl.g:722:3: (otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==38) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTechnologyDsl.g:723:4: otherlv_3= 'based' otherlv_4= 'on' ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) ) (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )* ( (lv_default_8_0= 'default' ) )?
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_35); 

                    				newLeafNode(otherlv_3, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,39,FOLLOW_36); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1());
                    			
                    // InternalTechnologyDsl.g:731:4: ( (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:732:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:732:5: (lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:733:6: lv_basicBuiltinPrimitiveTypes_5_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_29);
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

                    // InternalTechnologyDsl.g:750:4: (otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==31) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:751:5: otherlv_6= ',' ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_36); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalTechnologyDsl.g:755:5: ( (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType ) )
                    	    // InternalTechnologyDsl.g:756:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    {
                    	    // InternalTechnologyDsl.g:756:6: (lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType )
                    	    // InternalTechnologyDsl.g:757:7: lv_basicBuiltinPrimitiveTypes_7_0= rulePrimitiveType
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop18;
                        }
                    } while (true);

                    // InternalTechnologyDsl.g:775:4: ( (lv_default_8_0= 'default' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==32) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalTechnologyDsl.g:776:5: (lv_default_8_0= 'default' )
                            {
                            // InternalTechnologyDsl.g:776:5: (lv_default_8_0= 'default' )
                            // InternalTechnologyDsl.g:777:6: lv_default_8_0= 'default'
                            {
                            lv_default_8_0=(Token)match(input,32,FOLLOW_32); 

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

            otherlv_9=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:798:1: entryRuleTechnologySpecificCollectionType returns [EObject current=null] : iv_ruleTechnologySpecificCollectionType= ruleTechnologySpecificCollectionType EOF ;
    public final EObject entryRuleTechnologySpecificCollectionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificCollectionType = null;


        try {
            // InternalTechnologyDsl.g:798:73: (iv_ruleTechnologySpecificCollectionType= ruleTechnologySpecificCollectionType EOF )
            // InternalTechnologyDsl.g:799:2: iv_ruleTechnologySpecificCollectionType= ruleTechnologySpecificCollectionType EOF
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
    // InternalTechnologyDsl.g:805:1: ruleTechnologySpecificCollectionType returns [EObject current=null] : (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificCollectionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:811:2: ( (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalTechnologyDsl.g:812:2: (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalTechnologyDsl.g:812:2: (otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalTechnologyDsl.g:813:3: otherlv_0= 'collection' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificCollectionTypeAccess().getCollectionKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificCollectionTypeAccess().getTypeKeyword_1());
            		
            // InternalTechnologyDsl.g:821:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:822:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:822:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:823:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            otherlv_3=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:847:1: entryRuleTechnologySpecificDataStructure returns [EObject current=null] : iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF ;
    public final EObject entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificDataStructure = null;


        try {
            // InternalTechnologyDsl.g:847:72: (iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF )
            // InternalTechnologyDsl.g:848:2: iv_ruleTechnologySpecificDataStructure= ruleTechnologySpecificDataStructure EOF
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
    // InternalTechnologyDsl.g:854:1: ruleTechnologySpecificDataStructure returns [EObject current=null] : (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleTechnologySpecificDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:860:2: ( (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalTechnologyDsl.g:861:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalTechnologyDsl.g:861:2: (otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalTechnologyDsl.g:862:3: otherlv_0= 'structure' otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1());
            		
            // InternalTechnologyDsl.g:870:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTechnologyDsl.g:871:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:871:4: (lv_name_2_0= RULE_ID )
            // InternalTechnologyDsl.g:872:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            otherlv_3=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:896:1: entryRulePossiblyImportedTechnologySpecificType returns [EObject current=null] : iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF ;
    public final EObject entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedTechnologySpecificType = null;


        try {
            // InternalTechnologyDsl.g:896:79: (iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF )
            // InternalTechnologyDsl.g:897:2: iv_rulePossiblyImportedTechnologySpecificType= rulePossiblyImportedTechnologySpecificType EOF
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
    // InternalTechnologyDsl.g:903:1: rulePossiblyImportedTechnologySpecificType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:909:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalTechnologyDsl.g:910:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalTechnologyDsl.g:910:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:911:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:911:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==42) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalTechnologyDsl.g:912:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalTechnologyDsl.g:912:4: ( (otherlv_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:913:5: (otherlv_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:913:5: (otherlv_0= RULE_ID )
                    // InternalTechnologyDsl.g:914:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_37); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:930:3: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:931:4: ( ruleQualifiedName )
            {
            // InternalTechnologyDsl.g:931:4: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:932:5: ruleQualifiedName
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
    // InternalTechnologyDsl.g:950:1: entryRuleCompatibilityMatrixEntry returns [EObject current=null] : iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF ;
    public final EObject entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompatibilityMatrixEntry = null;


        try {
            // InternalTechnologyDsl.g:950:65: (iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF )
            // InternalTechnologyDsl.g:951:2: iv_ruleCompatibilityMatrixEntry= ruleCompatibilityMatrixEntry EOF
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
    // InternalTechnologyDsl.g:957:1: ruleCompatibilityMatrixEntry returns [EObject current=null] : ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) ;
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
            // InternalTechnologyDsl.g:963:2: ( ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' ) )
            // InternalTechnologyDsl.g:964:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            {
            // InternalTechnologyDsl.g:964:2: ( ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';' )
            // InternalTechnologyDsl.g:965:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) ) (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )* ( (lv_direction_3_0= ruleCompatibilityDirection ) ) ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) ) otherlv_5= ';'
            {
            // InternalTechnologyDsl.g:965:3: ( (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:966:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:966:4: (lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:967:5: lv_compatibleTypes_0_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalTechnologyDsl.g:984:3: (otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==31) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalTechnologyDsl.g:985:4: otherlv_1= ',' ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalTechnologyDsl.g:989:4: ( (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType ) )
            	    // InternalTechnologyDsl.g:990:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    {
            	    // InternalTechnologyDsl.g:990:5: (lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType )
            	    // InternalTechnologyDsl.g:991:6: lv_compatibleTypes_2_0= rulePossiblyImportedTechnologySpecificType
            	    {

            	    						newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_38);
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
            	    break loop22;
                }
            } while (true);

            // InternalTechnologyDsl.g:1009:3: ( (lv_direction_3_0= ruleCompatibilityDirection ) )
            // InternalTechnologyDsl.g:1010:4: (lv_direction_3_0= ruleCompatibilityDirection )
            {
            // InternalTechnologyDsl.g:1010:4: (lv_direction_3_0= ruleCompatibilityDirection )
            // InternalTechnologyDsl.g:1011:5: lv_direction_3_0= ruleCompatibilityDirection
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalTechnologyDsl.g:1028:3: ( (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:1029:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:1029:4: (lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:1030:5: lv_mappingType_4_0= rulePossiblyImportedTechnologySpecificType
            {

            					newCompositeNode(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_32);
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

            otherlv_5=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1055:1: entryRuleDeploymentTechnology returns [EObject current=null] : iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF ;
    public final EObject entryRuleDeploymentTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentTechnology = null;


        try {
            // InternalTechnologyDsl.g:1055:61: (iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF )
            // InternalTechnologyDsl.g:1056:2: iv_ruleDeploymentTechnology= ruleDeploymentTechnology EOF
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
    // InternalTechnologyDsl.g:1062:1: ruleDeploymentTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalTechnologyDsl.g:1068:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalTechnologyDsl.g:1069:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalTechnologyDsl.g:1069:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalTechnologyDsl.g:1070:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalTechnologyDsl.g:1070:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1071:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1071:4: (lv_name_0_0= RULE_ID )
            // InternalTechnologyDsl.g:1072:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

            otherlv_1=(Token)match(input,14,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,43,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,44,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalTechnologyDsl.g:1104:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:1105:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:1105:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalTechnologyDsl.g:1106:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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

            // InternalTechnologyDsl.g:1123:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==31) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1124:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,31,FOLLOW_25); 

            	    				newLeafNode(otherlv_6, grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTechnologyDsl.g:1128:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalTechnologyDsl.g:1129:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalTechnologyDsl.g:1129:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalTechnologyDsl.g:1130:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    break loop23;
                }
            } while (true);

            otherlv_8=(Token)match(input,35,FOLLOW_43); 

            			newLeafNode(otherlv_8, grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalTechnologyDsl.g:1152:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTechnologyDsl.g:1153:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,20,FOLLOW_44); 

                    				newLeafNode(otherlv_9, grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,45,FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_11, grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalTechnologyDsl.g:1165:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=66 && LA24_0<=76)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1166:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:1166:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:1167:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_45);
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
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    otherlv_13=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1197:1: entryRuleInfrastructureTechnology returns [EObject current=null] : iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF ;
    public final EObject entryRuleInfrastructureTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureTechnology = null;


        try {
            // InternalTechnologyDsl.g:1197:65: (iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF )
            // InternalTechnologyDsl.g:1198:2: iv_ruleInfrastructureTechnology= ruleInfrastructureTechnology EOF
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
    // InternalTechnologyDsl.g:1204:1: ruleInfrastructureTechnology returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) ;
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
            // InternalTechnologyDsl.g:1210:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' ) )
            // InternalTechnologyDsl.g:1211:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            {
            // InternalTechnologyDsl.g:1211:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}' )
            // InternalTechnologyDsl.g:1212:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' otherlv_2= 'operation' otherlv_3= 'environments' otherlv_4= '=' ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) ) (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )* otherlv_8= ';' (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )? otherlv_14= '}'
            {
            // InternalTechnologyDsl.g:1212:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1213:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1213:4: (lv_name_0_0= RULE_ID )
            // InternalTechnologyDsl.g:1214:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

            otherlv_1=(Token)match(input,14,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2());
            		
            otherlv_3=(Token)match(input,43,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3());
            		
            otherlv_4=(Token)match(input,44,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4());
            		
            // InternalTechnologyDsl.g:1246:3: ( (lv_operationEnvironments_5_0= ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:1247:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:1247:4: (lv_operationEnvironments_5_0= ruleOperationEnvironment )
            // InternalTechnologyDsl.g:1248:5: lv_operationEnvironments_5_0= ruleOperationEnvironment
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

            // InternalTechnologyDsl.g:1265:3: (otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==31) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1266:4: otherlv_6= ',' ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    {
            	    otherlv_6=(Token)match(input,31,FOLLOW_25); 

            	    				newLeafNode(otherlv_6, grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTechnologyDsl.g:1270:4: ( (lv_operationEnvironments_7_0= ruleOperationEnvironment ) )
            	    // InternalTechnologyDsl.g:1271:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    {
            	    // InternalTechnologyDsl.g:1271:5: (lv_operationEnvironments_7_0= ruleOperationEnvironment )
            	    // InternalTechnologyDsl.g:1272:6: lv_operationEnvironments_7_0= ruleOperationEnvironment
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
            	    break loop26;
                }
            } while (true);

            otherlv_8=(Token)match(input,35,FOLLOW_43); 

            			newLeafNode(otherlv_8, grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7());
            		
            // InternalTechnologyDsl.g:1294:3: (otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==20) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTechnologyDsl.g:1295:4: otherlv_9= 'service' otherlv_10= 'properties' otherlv_11= '{' ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+ otherlv_13= '}'
                    {
                    otherlv_9=(Token)match(input,20,FOLLOW_44); 

                    				newLeafNode(otherlv_9, grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,45,FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_11, grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2());
                    			
                    // InternalTechnologyDsl.g:1307:4: ( (lv_serviceProperties_12_0= ruleTechnologySpecificProperty ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=66 && LA27_0<=76)) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1308:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:1308:5: (lv_serviceProperties_12_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:1309:6: lv_serviceProperties_12_0= ruleTechnologySpecificProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_45);
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
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    otherlv_13=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1339:1: entryRuleOperationEnvironment returns [EObject current=null] : iv_ruleOperationEnvironment= ruleOperationEnvironment EOF ;
    public final EObject entryRuleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationEnvironment = null;


        try {
            // InternalTechnologyDsl.g:1339:61: (iv_ruleOperationEnvironment= ruleOperationEnvironment EOF )
            // InternalTechnologyDsl.g:1340:2: iv_ruleOperationEnvironment= ruleOperationEnvironment EOF
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
    // InternalTechnologyDsl.g:1346:1: ruleOperationEnvironment returns [EObject current=null] : ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) ;
    public final EObject ruleOperationEnvironment() throws RecognitionException {
        EObject current = null;

        Token lv_environmentName_0_0=null;
        Token lv_default_1_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:1352:2: ( ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? ) )
            // InternalTechnologyDsl.g:1353:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            {
            // InternalTechnologyDsl.g:1353:2: ( ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )? )
            // InternalTechnologyDsl.g:1354:3: ( (lv_environmentName_0_0= RULE_STRING ) ) ( (lv_default_1_0= 'default' ) )?
            {
            // InternalTechnologyDsl.g:1354:3: ( (lv_environmentName_0_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:1355:4: (lv_environmentName_0_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:1355:4: (lv_environmentName_0_0= RULE_STRING )
            // InternalTechnologyDsl.g:1356:5: lv_environmentName_0_0= RULE_STRING
            {
            lv_environmentName_0_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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

            // InternalTechnologyDsl.g:1372:3: ( (lv_default_1_0= 'default' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTechnologyDsl.g:1373:4: (lv_default_1_0= 'default' )
                    {
                    // InternalTechnologyDsl.g:1373:4: (lv_default_1_0= 'default' )
                    // InternalTechnologyDsl.g:1374:5: lv_default_1_0= 'default'
                    {
                    lv_default_1_0=(Token)match(input,32,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1390:1: entryRuleTechnologySpecificProperty returns [EObject current=null] : iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF ;
    public final EObject entryRuleTechnologySpecificProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnologySpecificProperty = null;


        try {
            // InternalTechnologyDsl.g:1390:67: (iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF )
            // InternalTechnologyDsl.g:1391:2: iv_ruleTechnologySpecificProperty= ruleTechnologySpecificProperty EOF
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
    // InternalTechnologyDsl.g:1397:1: ruleTechnologySpecificProperty returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
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
            // InternalTechnologyDsl.g:1403:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // InternalTechnologyDsl.g:1404:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // InternalTechnologyDsl.g:1404:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // InternalTechnologyDsl.g:1405:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )? (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            // InternalTechnologyDsl.g:1405:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalTechnologyDsl.g:1406:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:1406:4: (lv_type_0_0= rulePrimitiveType )
            // InternalTechnologyDsl.g:1407:5: lv_type_0_0= rulePrimitiveType
            {

            					newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalTechnologyDsl.g:1424:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1425:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1425:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:1426:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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

            // InternalTechnologyDsl.g:1442:3: (otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTechnologyDsl.g:1443:4: otherlv_2= '=' ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_48); 

                    				newLeafNode(otherlv_2, grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:1447:4: ( (lv_defaultValue_3_0= rulePrimitiveValue ) )
                    // InternalTechnologyDsl.g:1448:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    {
                    // InternalTechnologyDsl.g:1448:5: (lv_defaultValue_3_0= rulePrimitiveValue )
                    // InternalTechnologyDsl.g:1449:6: lv_defaultValue_3_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_49);
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

            // InternalTechnologyDsl.g:1467:3: (otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTechnologyDsl.g:1468:4: otherlv_4= '<' ( (lv_features_5_0= rulePropertyFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_50); 

                    				newLeafNode(otherlv_4, grammarAccess.getTechnologySpecificPropertyAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalTechnologyDsl.g:1472:4: ( (lv_features_5_0= rulePropertyFeature ) )
                    // InternalTechnologyDsl.g:1473:5: (lv_features_5_0= rulePropertyFeature )
                    {
                    // InternalTechnologyDsl.g:1473:5: (lv_features_5_0= rulePropertyFeature )
                    // InternalTechnologyDsl.g:1474:6: lv_features_5_0= rulePropertyFeature
                    {

                    						newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:1491:4: (otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==31) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1492:5: otherlv_6= ',' ( (lv_features_7_0= rulePropertyFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_50); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getTechnologySpecificPropertyAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:1496:5: ( (lv_features_7_0= rulePropertyFeature ) )
                    	    // InternalTechnologyDsl.g:1497:6: (lv_features_7_0= rulePropertyFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:1497:6: (lv_features_7_0= rulePropertyFeature )
                    	    // InternalTechnologyDsl.g:1498:7: lv_features_7_0= rulePropertyFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesPropertyFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,47,FOLLOW_32); 

                    				newLeafNode(otherlv_8, grammarAccess.getTechnologySpecificPropertyAccess().getGreaterThanSignKeyword_3_3());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1529:1: entryRuleServiceAspectPointcut returns [EObject current=null] : iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF ;
    public final EObject entryRuleServiceAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcut = null;


        try {
            // InternalTechnologyDsl.g:1529:62: (iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF )
            // InternalTechnologyDsl.g:1530:2: iv_ruleServiceAspectPointcut= ruleServiceAspectPointcut EOF
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
    // InternalTechnologyDsl.g:1536:1: ruleServiceAspectPointcut returns [EObject current=null] : ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) ;
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
            // InternalTechnologyDsl.g:1542:2: ( ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) ) )
            // InternalTechnologyDsl.g:1543:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            {
            // InternalTechnologyDsl.g:1543:2: ( ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) ) | ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) ) | ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) ) | ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt33=1;
                }
                break;
            case 49:
                {
                alt33=2;
                }
                break;
            case 50:
                {
                alt33=3;
                }
                break;
            case 51:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalTechnologyDsl.g:1544:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    {
                    // InternalTechnologyDsl.g:1544:3: ( ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) ) )
                    // InternalTechnologyDsl.g:1545:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) ) otherlv_1= '=' ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    {
                    // InternalTechnologyDsl.g:1545:4: ( (lv_forExchangePattern_0_0= 'exchange_pattern' ) )
                    // InternalTechnologyDsl.g:1546:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    {
                    // InternalTechnologyDsl.g:1546:5: (lv_forExchangePattern_0_0= 'exchange_pattern' )
                    // InternalTechnologyDsl.g:1547:6: lv_forExchangePattern_0_0= 'exchange_pattern'
                    {
                    lv_forExchangePattern_0_0=(Token)match(input,48,FOLLOW_41); 

                    						newLeafNode(lv_forExchangePattern_0_0, grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forExchangePattern", lv_forExchangePattern_0_0 != null, "exchange_pattern");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,44,FOLLOW_52); 

                    				newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalTechnologyDsl.g:1563:4: ( (lv_exchangePattern_2_0= ruleExchangePattern ) )
                    // InternalTechnologyDsl.g:1564:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    {
                    // InternalTechnologyDsl.g:1564:5: (lv_exchangePattern_2_0= ruleExchangePattern )
                    // InternalTechnologyDsl.g:1565:6: lv_exchangePattern_2_0= ruleExchangePattern
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
                    // InternalTechnologyDsl.g:1584:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    {
                    // InternalTechnologyDsl.g:1584:3: ( ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) ) )
                    // InternalTechnologyDsl.g:1585:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) ) otherlv_4= '=' ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    {
                    // InternalTechnologyDsl.g:1585:4: ( (lv_forCommunicationType_3_0= 'communication_type' ) )
                    // InternalTechnologyDsl.g:1586:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    {
                    // InternalTechnologyDsl.g:1586:5: (lv_forCommunicationType_3_0= 'communication_type' )
                    // InternalTechnologyDsl.g:1587:6: lv_forCommunicationType_3_0= 'communication_type'
                    {
                    lv_forCommunicationType_3_0=(Token)match(input,49,FOLLOW_41); 

                    						newLeafNode(lv_forCommunicationType_3_0, grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forCommunicationType", lv_forCommunicationType_3_0 != null, "communication_type");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,44,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalTechnologyDsl.g:1603:4: ( (lv_communicationType_5_0= ruleCommunicationType ) )
                    // InternalTechnologyDsl.g:1604:5: (lv_communicationType_5_0= ruleCommunicationType )
                    {
                    // InternalTechnologyDsl.g:1604:5: (lv_communicationType_5_0= ruleCommunicationType )
                    // InternalTechnologyDsl.g:1605:6: lv_communicationType_5_0= ruleCommunicationType
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
                    // InternalTechnologyDsl.g:1624:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    {
                    // InternalTechnologyDsl.g:1624:3: ( ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) ) )
                    // InternalTechnologyDsl.g:1625:4: ( (lv_forProtocol_6_0= 'protocol' ) ) otherlv_7= '=' ( (otherlv_8= RULE_ID ) )
                    {
                    // InternalTechnologyDsl.g:1625:4: ( (lv_forProtocol_6_0= 'protocol' ) )
                    // InternalTechnologyDsl.g:1626:5: (lv_forProtocol_6_0= 'protocol' )
                    {
                    // InternalTechnologyDsl.g:1626:5: (lv_forProtocol_6_0= 'protocol' )
                    // InternalTechnologyDsl.g:1627:6: lv_forProtocol_6_0= 'protocol'
                    {
                    lv_forProtocol_6_0=(Token)match(input,50,FOLLOW_41); 

                    						newLeafNode(lv_forProtocol_6_0, grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forProtocol", lv_forProtocol_6_0 != null, "protocol");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,44,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalTechnologyDsl.g:1643:4: ( (otherlv_8= RULE_ID ) )
                    // InternalTechnologyDsl.g:1644:5: (otherlv_8= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:1644:5: (otherlv_8= RULE_ID )
                    // InternalTechnologyDsl.g:1645:6: otherlv_8= RULE_ID
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
                    // InternalTechnologyDsl.g:1658:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    {
                    // InternalTechnologyDsl.g:1658:3: ( ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) ) )
                    // InternalTechnologyDsl.g:1659:4: ( (lv_forDataFormat_9_0= 'data_format' ) ) otherlv_10= '=' ( (otherlv_11= RULE_STRING ) )
                    {
                    // InternalTechnologyDsl.g:1659:4: ( (lv_forDataFormat_9_0= 'data_format' ) )
                    // InternalTechnologyDsl.g:1660:5: (lv_forDataFormat_9_0= 'data_format' )
                    {
                    // InternalTechnologyDsl.g:1660:5: (lv_forDataFormat_9_0= 'data_format' )
                    // InternalTechnologyDsl.g:1661:6: lv_forDataFormat_9_0= 'data_format'
                    {
                    lv_forDataFormat_9_0=(Token)match(input,51,FOLLOW_41); 

                    						newLeafNode(lv_forDataFormat_9_0, grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceAspectPointcutRule());
                    						}
                    						setWithLastConsumed(current, "forDataFormat", lv_forDataFormat_9_0 != null, "data_format");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,44,FOLLOW_25); 

                    				newLeafNode(otherlv_10, grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalTechnologyDsl.g:1677:4: ( (otherlv_11= RULE_STRING ) )
                    // InternalTechnologyDsl.g:1678:5: (otherlv_11= RULE_STRING )
                    {
                    // InternalTechnologyDsl.g:1678:5: (otherlv_11= RULE_STRING )
                    // InternalTechnologyDsl.g:1679:6: otherlv_11= RULE_STRING
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
    // InternalTechnologyDsl.g:1695:1: entryRuleServiceAspectPointcutSelector returns [EObject current=null] : iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF ;
    public final EObject entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspectPointcutSelector = null;


        try {
            // InternalTechnologyDsl.g:1695:70: (iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF )
            // InternalTechnologyDsl.g:1696:2: iv_ruleServiceAspectPointcutSelector= ruleServiceAspectPointcutSelector EOF
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
    // InternalTechnologyDsl.g:1702:1: ruleServiceAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalTechnologyDsl.g:1708:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalTechnologyDsl.g:1709:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalTechnologyDsl.g:1709:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalTechnologyDsl.g:1710:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_53); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,53,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTechnologyDsl.g:1718:3: ( (lv_pointcuts_2_0= ruleServiceAspectPointcut ) )
            // InternalTechnologyDsl.g:1719:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            {
            // InternalTechnologyDsl.g:1719:4: (lv_pointcuts_2_0= ruleServiceAspectPointcut )
            // InternalTechnologyDsl.g:1720:5: lv_pointcuts_2_0= ruleServiceAspectPointcut
            {

            					newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_55);
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

            // InternalTechnologyDsl.g:1737:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==31) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1738:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,31,FOLLOW_54); 

            	    				newLeafNode(otherlv_3, grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalTechnologyDsl.g:1742:4: ( (lv_pointcuts_4_0= ruleServiceAspectPointcut ) )
            	    // InternalTechnologyDsl.g:1743:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    {
            	    // InternalTechnologyDsl.g:1743:5: (lv_pointcuts_4_0= ruleServiceAspectPointcut )
            	    // InternalTechnologyDsl.g:1744:6: lv_pointcuts_4_0= ruleServiceAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
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
            	    break loop34;
                }
            } while (true);

            otherlv_5=(Token)match(input,54,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1774:1: entryRuleServiceAspect returns [EObject current=null] : iv_ruleServiceAspect= ruleServiceAspect EOF ;
    public final EObject entryRuleServiceAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceAspect = null;


        try {
            // InternalTechnologyDsl.g:1774:54: (iv_ruleServiceAspect= ruleServiceAspect EOF )
            // InternalTechnologyDsl.g:1775:2: iv_ruleServiceAspect= ruleServiceAspect EOF
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
    // InternalTechnologyDsl.g:1781:1: ruleServiceAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalTechnologyDsl.g:1787:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalTechnologyDsl.g:1788:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalTechnologyDsl.g:1788:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalTechnologyDsl.g:1789:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAspectAccess().getAspectKeyword_0());
            		
            // InternalTechnologyDsl.g:1793:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:1794:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:1794:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:1795:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_56); 

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

            // InternalTechnologyDsl.g:1811:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==46) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTechnologyDsl.g:1812:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:1816:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalTechnologyDsl.g:1817:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalTechnologyDsl.g:1817:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalTechnologyDsl.g:1818:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:1835:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==31) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1836:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_57); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:1840:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalTechnologyDsl.g:1841:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:1841:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalTechnologyDsl.g:1842:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop35;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_58); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,56,FOLLOW_59); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceAspectAccess().getForKeyword_3());
            		
            // InternalTechnologyDsl.g:1869:3: ( (lv_joinPoints_8_0= ruleServiceJoinPointType ) )
            // InternalTechnologyDsl.g:1870:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            {
            // InternalTechnologyDsl.g:1870:4: (lv_joinPoints_8_0= ruleServiceJoinPointType )
            // InternalTechnologyDsl.g:1871:5: lv_joinPoints_8_0= ruleServiceJoinPointType
            {

            					newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_60);
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

            // InternalTechnologyDsl.g:1888:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==31) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1889:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,31,FOLLOW_59); 

            	    				newLeafNode(otherlv_9, grammarAccess.getServiceAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTechnologyDsl.g:1893:4: ( (lv_joinPoints_10_0= ruleServiceJoinPointType ) )
            	    // InternalTechnologyDsl.g:1894:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    {
            	    // InternalTechnologyDsl.g:1894:5: (lv_joinPoints_10_0= ruleServiceJoinPointType )
            	    // InternalTechnologyDsl.g:1895:6: lv_joinPoints_10_0= ruleServiceJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
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
            	    break loop37;
                }
            } while (true);

            // InternalTechnologyDsl.g:1913:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==14) ) {
                alt40=1;
            }
            else if ( (LA40_0==35) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalTechnologyDsl.g:1914:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalTechnologyDsl.g:1914:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalTechnologyDsl.g:1915:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,14,FOLLOW_61); 

                    					newLeafNode(otherlv_11, grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalTechnologyDsl.g:1919:5: ( (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==52) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1920:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    {
                    	    // InternalTechnologyDsl.g:1920:6: (lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector )
                    	    // InternalTechnologyDsl.g:1921:7: lv_pointcutSelectors_12_0= ruleServiceAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop38;
                        }
                    } while (true);

                    // InternalTechnologyDsl.g:1938:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( ((LA39_0>=66 && LA39_0<=76)) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1939:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:1939:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:1940:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
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
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,18,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1963:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1972:1: entryRuleOperationAspectPointcut returns [EObject current=null] : iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF ;
    public final EObject entryRuleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcut = null;


        try {
            // InternalTechnologyDsl.g:1972:64: (iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF )
            // InternalTechnologyDsl.g:1973:2: iv_ruleOperationAspectPointcut= ruleOperationAspectPointcut EOF
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
    // InternalTechnologyDsl.g:1979:1: ruleOperationAspectPointcut returns [EObject current=null] : ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOperationAspectPointcut() throws RecognitionException {
        EObject current = null;

        Token lv_forTechnology_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:1985:2: ( ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:1986:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:1986:2: ( ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalTechnologyDsl.g:1987:3: ( (lv_forTechnology_0_0= 'technology' ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalTechnologyDsl.g:1987:3: ( (lv_forTechnology_0_0= 'technology' ) )
            // InternalTechnologyDsl.g:1988:4: (lv_forTechnology_0_0= 'technology' )
            {
            // InternalTechnologyDsl.g:1988:4: (lv_forTechnology_0_0= 'technology' )
            // InternalTechnologyDsl.g:1989:5: lv_forTechnology_0_0= 'technology'
            {
            lv_forTechnology_0_0=(Token)match(input,13,FOLLOW_41); 

            					newLeafNode(lv_forTechnology_0_0, grammarAccess.getOperationAspectPointcutAccess().getForTechnologyTechnologyKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationAspectPointcutRule());
            					}
            					setWithLastConsumed(current, "forTechnology", lv_forTechnology_0_0 != null, "technology");
            				

            }


            }

            otherlv_1=(Token)match(input,44,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutAccess().getEqualsSignKeyword_1());
            		
            // InternalTechnologyDsl.g:2005:3: ( (otherlv_2= RULE_ID ) )
            // InternalTechnologyDsl.g:2006:4: (otherlv_2= RULE_ID )
            {
            // InternalTechnologyDsl.g:2006:4: (otherlv_2= RULE_ID )
            // InternalTechnologyDsl.g:2007:5: otherlv_2= RULE_ID
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
    // InternalTechnologyDsl.g:2022:1: entryRuleOperationAspectPointcutSelector returns [EObject current=null] : iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF ;
    public final EObject entryRuleOperationAspectPointcutSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspectPointcutSelector = null;


        try {
            // InternalTechnologyDsl.g:2022:72: (iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF )
            // InternalTechnologyDsl.g:2023:2: iv_ruleOperationAspectPointcutSelector= ruleOperationAspectPointcutSelector EOF
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
    // InternalTechnologyDsl.g:2029:1: ruleOperationAspectPointcutSelector returns [EObject current=null] : (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalTechnologyDsl.g:2035:2: ( (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' ) )
            // InternalTechnologyDsl.g:2036:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalTechnologyDsl.g:2036:2: (otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';' )
            // InternalTechnologyDsl.g:2037:3: otherlv_0= 'selector' otherlv_1= '(' ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) ) (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )* otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_53); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectPointcutSelectorAccess().getSelectorKeyword_0());
            		
            otherlv_1=(Token)match(input,53,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTechnologyDsl.g:2045:3: ( (lv_pointcuts_2_0= ruleOperationAspectPointcut ) )
            // InternalTechnologyDsl.g:2046:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            {
            // InternalTechnologyDsl.g:2046:4: (lv_pointcuts_2_0= ruleOperationAspectPointcut )
            // InternalTechnologyDsl.g:2047:5: lv_pointcuts_2_0= ruleOperationAspectPointcut
            {

            					newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_55);
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

            // InternalTechnologyDsl.g:2064:3: (otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==31) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2065:4: otherlv_3= ',' ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    {
            	    otherlv_3=(Token)match(input,31,FOLLOW_23); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAspectPointcutSelectorAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalTechnologyDsl.g:2069:4: ( (lv_pointcuts_4_0= ruleOperationAspectPointcut ) )
            	    // InternalTechnologyDsl.g:2070:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    {
            	    // InternalTechnologyDsl.g:2070:5: (lv_pointcuts_4_0= ruleOperationAspectPointcut )
            	    // InternalTechnologyDsl.g:2071:6: lv_pointcuts_4_0= ruleOperationAspectPointcut
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsOperationAspectPointcutParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
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
            	    break loop41;
                }
            } while (true);

            otherlv_5=(Token)match(input,54,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationAspectPointcutSelectorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:2101:1: entryRuleOperationAspect returns [EObject current=null] : iv_ruleOperationAspect= ruleOperationAspect EOF ;
    public final EObject entryRuleOperationAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationAspect = null;


        try {
            // InternalTechnologyDsl.g:2101:56: (iv_ruleOperationAspect= ruleOperationAspect EOF )
            // InternalTechnologyDsl.g:2102:2: iv_ruleOperationAspect= ruleOperationAspect EOF
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
    // InternalTechnologyDsl.g:2108:1: ruleOperationAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) ;
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
            // InternalTechnologyDsl.g:2114:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) ) )
            // InternalTechnologyDsl.g:2115:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            {
            // InternalTechnologyDsl.g:2115:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' ) )
            // InternalTechnologyDsl.g:2116:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )? otherlv_7= 'for' ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) ) (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )* ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAspectAccess().getAspectKeyword_0());
            		
            // InternalTechnologyDsl.g:2120:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2121:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2121:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2122:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_56); 

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

            // InternalTechnologyDsl.g:2138:3: (otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==46) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalTechnologyDsl.g:2139:4: otherlv_2= '<' ( (lv_features_3_0= ruleAspectFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getOperationAspectAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:2143:4: ( (lv_features_3_0= ruleAspectFeature ) )
                    // InternalTechnologyDsl.g:2144:5: (lv_features_3_0= ruleAspectFeature )
                    {
                    // InternalTechnologyDsl.g:2144:5: (lv_features_3_0= ruleAspectFeature )
                    // InternalTechnologyDsl.g:2145:6: lv_features_3_0= ruleAspectFeature
                    {

                    						newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:2162:4: (otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==31) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2163:5: otherlv_4= ',' ( (lv_features_5_0= ruleAspectFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_57); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationAspectAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:2167:5: ( (lv_features_5_0= ruleAspectFeature ) )
                    	    // InternalTechnologyDsl.g:2168:6: (lv_features_5_0= ruleAspectFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:2168:6: (lv_features_5_0= ruleAspectFeature )
                    	    // InternalTechnologyDsl.g:2169:7: lv_features_5_0= ruleAspectFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getFeaturesAspectFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_58); 

                    				newLeafNode(otherlv_6, grammarAccess.getOperationAspectAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,56,FOLLOW_62); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAspectAccess().getForKeyword_3());
            		
            // InternalTechnologyDsl.g:2196:3: ( (lv_joinPoints_8_0= ruleOperationJoinPointType ) )
            // InternalTechnologyDsl.g:2197:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            {
            // InternalTechnologyDsl.g:2197:4: (lv_joinPoints_8_0= ruleOperationJoinPointType )
            // InternalTechnologyDsl.g:2198:5: lv_joinPoints_8_0= ruleOperationJoinPointType
            {

            					newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_60);
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

            // InternalTechnologyDsl.g:2215:3: (otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==31) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2216:4: otherlv_9= ',' ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    {
            	    otherlv_9=(Token)match(input,31,FOLLOW_62); 

            	    				newLeafNode(otherlv_9, grammarAccess.getOperationAspectAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTechnologyDsl.g:2220:4: ( (lv_joinPoints_10_0= ruleOperationJoinPointType ) )
            	    // InternalTechnologyDsl.g:2221:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    {
            	    // InternalTechnologyDsl.g:2221:5: (lv_joinPoints_10_0= ruleOperationJoinPointType )
            	    // InternalTechnologyDsl.g:2222:6: lv_joinPoints_10_0= ruleOperationJoinPointType
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
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
            	    break loop44;
                }
            } while (true);

            // InternalTechnologyDsl.g:2240:3: ( (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' ) | otherlv_15= ';' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==14) ) {
                alt47=1;
            }
            else if ( (LA47_0==35) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalTechnologyDsl.g:2241:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    {
                    // InternalTechnologyDsl.g:2241:4: (otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}' )
                    // InternalTechnologyDsl.g:2242:5: otherlv_11= '{' ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )* ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,14,FOLLOW_61); 

                    					newLeafNode(otherlv_11, grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_6_0_0());
                    				
                    // InternalTechnologyDsl.g:2246:5: ( (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==52) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2247:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    {
                    	    // InternalTechnologyDsl.g:2247:6: (lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector )
                    	    // InternalTechnologyDsl.g:2248:7: lv_pointcutSelectors_12_0= ruleOperationAspectPointcutSelector
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPointcutSelectorsOperationAspectPointcutSelectorParserRuleCall_6_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop45;
                        }
                    } while (true);

                    // InternalTechnologyDsl.g:2265:5: ( (lv_properties_13_0= ruleTechnologySpecificProperty ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( ((LA46_0>=66 && LA46_0<=76)) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2266:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    {
                    	    // InternalTechnologyDsl.g:2266:6: (lv_properties_13_0= ruleTechnologySpecificProperty )
                    	    // InternalTechnologyDsl.g:2267:7: lv_properties_13_0= ruleTechnologySpecificProperty
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_6_0_2_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
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
                    	    break loop46;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,18,FOLLOW_2); 

                    					newLeafNode(otherlv_14, grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_6_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2290:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,35,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:2299:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalTechnologyDsl.g:2299:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalTechnologyDsl.g:2300:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalTechnologyDsl.g:2306:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalTechnologyDsl.g:2312:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:2313:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:2313:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:2314:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_63); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,57,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalTechnologyDsl.g:2326:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalTechnologyDsl.g:2327:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalTechnologyDsl.g:2327:4: (lv_importURI_3_0= RULE_STRING )
            // InternalTechnologyDsl.g:2328:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

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

            otherlv_4=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalTechnologyDsl.g:2348:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2349:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2349:4: (lv_name_5_0= RULE_ID )
            // InternalTechnologyDsl.g:2350:5: lv_name_5_0= RULE_ID
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
    // InternalTechnologyDsl.g:2370:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalTechnologyDsl.g:2370:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalTechnologyDsl.g:2371:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalTechnologyDsl.g:2377:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalTechnologyDsl.g:2383:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalTechnologyDsl.g:2384:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalTechnologyDsl.g:2384:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalTechnologyDsl.g:2385:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalTechnologyDsl.g:2389:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2390:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2390:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2391:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_64); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTechnologyDsl.g:2411:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt50=3;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=40 && LA50_0<=41)||LA50_0==63) ) {
                alt50=1;
            }
            else if ( (LA50_0==59) ) {
                alt50=2;
            }
            switch (alt50) {
                case 1 :
                    // InternalTechnologyDsl.g:2412:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalTechnologyDsl.g:2412:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt48=0;
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( ((LA48_0>=40 && LA48_0<=41)||LA48_0==63) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2413:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalTechnologyDsl.g:2413:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalTechnologyDsl.g:2414:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_65);
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
                    	    if ( cnt48 >= 1 ) break loop48;
                                EarlyExitException eee =
                                    new EarlyExitException(48, input);
                                throw eee;
                        }
                        cnt48++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2432:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalTechnologyDsl.g:2432:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==59) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2433:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalTechnologyDsl.g:2433:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalTechnologyDsl.g:2434:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_66);
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
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:2460:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalTechnologyDsl.g:2460:48: (iv_ruleContext= ruleContext EOF )
            // InternalTechnologyDsl.g:2461:2: iv_ruleContext= ruleContext EOF
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
    // InternalTechnologyDsl.g:2467:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2473:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalTechnologyDsl.g:2474:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalTechnologyDsl.g:2474:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalTechnologyDsl.g:2475:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalTechnologyDsl.g:2479:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2480:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2480:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2481:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_67); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTechnologyDsl.g:2501:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=40 && LA51_0<=41)||LA51_0==63) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2502:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalTechnologyDsl.g:2502:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalTechnologyDsl.g:2503:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_65);
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
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:2528:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalTechnologyDsl.g:2528:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalTechnologyDsl.g:2529:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalTechnologyDsl.g:2535:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_CollectionType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:2541:2: ( (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration ) )
            // InternalTechnologyDsl.g:2542:2: (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalTechnologyDsl.g:2542:2: (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt52=1;
                }
                break;
            case 40:
                {
                alt52=2;
                }
                break;
            case 63:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalTechnologyDsl.g:2543:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalTechnologyDsl.g:2552:3: this_CollectionType_1= ruleCollectionType
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
                    // InternalTechnologyDsl.g:2561:3: this_Enumeration_2= ruleEnumeration
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
    // InternalTechnologyDsl.g:2573:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalTechnologyDsl.g:2573:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalTechnologyDsl.g:2574:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalTechnologyDsl.g:2580:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalTechnologyDsl.g:2586:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalTechnologyDsl.g:2587:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalTechnologyDsl.g:2587:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalTechnologyDsl.g:2588:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalTechnologyDsl.g:2592:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:2593:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:2593:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:2594:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_68); 

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

            // InternalTechnologyDsl.g:2610:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==46) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalTechnologyDsl.g:2611:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_69); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:2615:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalTechnologyDsl.g:2616:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalTechnologyDsl.g:2616:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalTechnologyDsl.g:2617:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:2634:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==31) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2635:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_69); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:2639:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalTechnologyDsl.g:2640:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:2640:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalTechnologyDsl.g:2641:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_70); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:2664:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==60) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTechnologyDsl.g:2665:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,60,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalTechnologyDsl.g:2669:4: ( ( ruleQualifiedName ) )
                    // InternalTechnologyDsl.g:2670:5: ( ruleQualifiedName )
                    {
                    // InternalTechnologyDsl.g:2670:5: ( ruleQualifiedName )
                    // InternalTechnologyDsl.g:2671:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_71); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalTechnologyDsl.g:2690:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID||(LA59_0>=61 && LA59_0<=62)||(LA59_0>=64 && LA59_0<=76)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalTechnologyDsl.g:2691:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalTechnologyDsl.g:2691:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt56=2;
                    switch ( input.LA(1) ) {
                    case 61:
                        {
                        int LA56_1 = input.LA(2);

                        if ( ((LA56_1>=64 && LA56_1<=65)) ) {
                            alt56=2;
                        }
                        else if ( (LA56_1==RULE_ID||LA56_1==62||(LA56_1>=66 && LA56_1<=76)) ) {
                            alt56=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 56, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 62:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                        {
                        alt56=1;
                        }
                        break;
                    case 64:
                    case 65:
                        {
                        alt56=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }

                    switch (alt56) {
                        case 1 :
                            // InternalTechnologyDsl.g:2692:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalTechnologyDsl.g:2692:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalTechnologyDsl.g:2693:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalTechnologyDsl.g:2693:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalTechnologyDsl.g:2694:7: lv_dataFields_10_0= ruleDataField
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0());
                            						
                            pushFollow(FOLLOW_72);
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
                            // InternalTechnologyDsl.g:2712:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalTechnologyDsl.g:2712:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalTechnologyDsl.g:2713:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalTechnologyDsl.g:2713:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalTechnologyDsl.g:2714:7: lv_operations_11_0= ruleDataOperation
                            {

                            							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0());
                            						
                            pushFollow(FOLLOW_72);
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

                    // InternalTechnologyDsl.g:2732:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==31) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2733:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,31,FOLLOW_73); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalTechnologyDsl.g:2737:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt57=2;
                    	    switch ( input.LA(1) ) {
                    	    case 61:
                    	        {
                    	        int LA57_1 = input.LA(2);

                    	        if ( ((LA57_1>=64 && LA57_1<=65)) ) {
                    	            alt57=2;
                    	        }
                    	        else if ( (LA57_1==RULE_ID||LA57_1==62||(LA57_1>=66 && LA57_1<=76)) ) {
                    	            alt57=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 57, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 62:
                    	    case 66:
                    	    case 67:
                    	    case 68:
                    	    case 69:
                    	    case 70:
                    	    case 71:
                    	    case 72:
                    	    case 73:
                    	    case 74:
                    	    case 75:
                    	    case 76:
                    	        {
                    	        alt57=1;
                    	        }
                    	        break;
                    	    case 64:
                    	    case 65:
                    	        {
                    	        alt57=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 57, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt57) {
                    	        case 1 :
                    	            // InternalTechnologyDsl.g:2738:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalTechnologyDsl.g:2738:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalTechnologyDsl.g:2739:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalTechnologyDsl.g:2739:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalTechnologyDsl.g:2740:8: lv_dataFields_13_0= ruleDataField
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_72);
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
                    	            // InternalTechnologyDsl.g:2758:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalTechnologyDsl.g:2758:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalTechnologyDsl.g:2759:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalTechnologyDsl.g:2759:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalTechnologyDsl.g:2760:8: lv_operations_14_0= ruleDataOperation
                    	            {

                    	            								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0());
                    	            							
                    	            pushFollow(FOLLOW_72);
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
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:2788:1: entryRuleCollectionType returns [EObject current=null] : iv_ruleCollectionType= ruleCollectionType EOF ;
    public final EObject entryRuleCollectionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionType = null;


        try {
            // InternalTechnologyDsl.g:2788:55: (iv_ruleCollectionType= ruleCollectionType EOF )
            // InternalTechnologyDsl.g:2789:2: iv_ruleCollectionType= ruleCollectionType EOF
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
    // InternalTechnologyDsl.g:2795:1: ruleCollectionType returns [EObject current=null] : ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalTechnologyDsl.g:2801:2: ( ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalTechnologyDsl.g:2802:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalTechnologyDsl.g:2802:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalTechnologyDsl.g:2803:3: (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalTechnologyDsl.g:2803:3: (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalTechnologyDsl.g:2804:4: otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,40,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getCollectionTypeAccess().getCollectionKeyword_0_0());
                    			
                    // InternalTechnologyDsl.g:2808:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:2809:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:2809:5: (lv_name_1_0= RULE_ID )
                    // InternalTechnologyDsl.g:2810:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

                    otherlv_2=(Token)match(input,14,FOLLOW_74); 

                    				newLeafNode(otherlv_2, grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalTechnologyDsl.g:2830:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalTechnologyDsl.g:2831:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalTechnologyDsl.g:2831:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalTechnologyDsl.g:2832:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_72);
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

                    // InternalTechnologyDsl.g:2849:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==31) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:2850:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_74); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getCollectionTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalTechnologyDsl.g:2854:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalTechnologyDsl.g:2855:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalTechnologyDsl.g:2855:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalTechnologyDsl.g:2856:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_72);
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
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:2880:3: (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalTechnologyDsl.g:2880:3: (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalTechnologyDsl.g:2881:4: otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,40,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getCollectionTypeAccess().getCollectionKeyword_1_0());
                    			
                    // InternalTechnologyDsl.g:2885:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalTechnologyDsl.g:2886:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalTechnologyDsl.g:2886:5: (lv_name_8_0= RULE_ID )
                    // InternalTechnologyDsl.g:2887:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

                    otherlv_9=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_9, grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalTechnologyDsl.g:2907:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:2908:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:2908:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:2909:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getCollectionTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    otherlv_11=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:2935:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalTechnologyDsl.g:2935:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalTechnologyDsl.g:2936:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalTechnologyDsl.g:2942:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
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
            // InternalTechnologyDsl.g:2948:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalTechnologyDsl.g:2949:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalTechnologyDsl.g:2949:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalTechnologyDsl.g:2950:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalTechnologyDsl.g:2950:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==61) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalTechnologyDsl.g:2951:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalTechnologyDsl.g:2951:4: (lv_hidden_0_0= 'hide' )
                    // InternalTechnologyDsl.g:2952:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,61,FOLLOW_75); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalTechnologyDsl.g:2964:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==62) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalTechnologyDsl.g:2965:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalTechnologyDsl.g:2965:4: (lv_immutable_1_0= 'immutable' )
                    // InternalTechnologyDsl.g:2966:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,62,FOLLOW_76); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", lv_immutable_1_0 != null, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalTechnologyDsl.g:2978:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt64=4;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=66 && LA64_0<=76)) ) {
                alt64=1;
            }
            else if ( (LA64_0==RULE_ID) ) {
                int LA64_2 = input.LA(2);

                if ( (LA64_2==RULE_ID||LA64_2==77) ) {
                    alt64=2;
                }
                else if ( (LA64_2==42) ) {
                    alt64=3;
                }
            }
            switch (alt64) {
                case 1 :
                    // InternalTechnologyDsl.g:2979:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalTechnologyDsl.g:2979:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:2980:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:2980:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:2981:6: lv_primitiveType_2_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_4);
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
                    // InternalTechnologyDsl.g:2999:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalTechnologyDsl.g:2999:4: ( ( ruleQualifiedName ) )
                    // InternalTechnologyDsl.g:3000:5: ( ruleQualifiedName )
                    {
                    // InternalTechnologyDsl.g:3000:5: ( ruleQualifiedName )
                    // InternalTechnologyDsl.g:3001:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataFieldRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3016:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalTechnologyDsl.g:3016:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalTechnologyDsl.g:3017:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalTechnologyDsl.g:3017:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalTechnologyDsl.g:3018:6: lv_importedComplexType_4_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_4);
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

            // InternalTechnologyDsl.g:3036:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalTechnologyDsl.g:3037:4: (lv_name_5_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:3037:4: (lv_name_5_0= RULE_ID )
            // InternalTechnologyDsl.g:3038:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_77); 

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

            // InternalTechnologyDsl.g:3054:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==44) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalTechnologyDsl.g:3055:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,44,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalTechnologyDsl.g:3059:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalTechnologyDsl.g:3060:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalTechnologyDsl.g:3060:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalTechnologyDsl.g:3061:6: lv_initializationValue_7_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_78);
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

            // InternalTechnologyDsl.g:3079:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==46) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalTechnologyDsl.g:3080:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,46,FOLLOW_79); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalTechnologyDsl.g:3084:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalTechnologyDsl.g:3085:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalTechnologyDsl.g:3085:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalTechnologyDsl.g:3086:6: lv_features_9_0= ruleDataFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:3103:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==31) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:3104:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,31,FOLLOW_79); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:3108:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalTechnologyDsl.g:3109:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:3109:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalTechnologyDsl.g:3110:7: lv_features_11_0= ruleDataFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop66;
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
    // InternalTechnologyDsl.g:3137:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalTechnologyDsl.g:3137:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalTechnologyDsl.g:3138:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalTechnologyDsl.g:3144:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) ;
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
            // InternalTechnologyDsl.g:3150:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) )
            // InternalTechnologyDsl.g:3151:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            {
            // InternalTechnologyDsl.g:3151:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            // InternalTechnologyDsl.g:3152:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalTechnologyDsl.g:3156:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTechnologyDsl.g:3157:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:3157:4: (lv_name_1_0= RULE_ID )
            // InternalTechnologyDsl.g:3158:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_80); 

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

            // InternalTechnologyDsl.g:3174:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==46) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalTechnologyDsl.g:3175:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_69); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalTechnologyDsl.g:3179:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalTechnologyDsl.g:3180:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalTechnologyDsl.g:3180:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalTechnologyDsl.g:3181:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:3198:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==31) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:3199:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_69); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:3203:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalTechnologyDsl.g:3204:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:3204:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalTechnologyDsl.g:3205:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,47,FOLLOW_5); 

                    				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTechnologyDsl.g:3232:3: ( (lv_fields_8_0= ruleEnumerationField ) )
            // InternalTechnologyDsl.g:3233:4: (lv_fields_8_0= ruleEnumerationField )
            {
            // InternalTechnologyDsl.g:3233:4: (lv_fields_8_0= ruleEnumerationField )
            // InternalTechnologyDsl.g:3234:5: lv_fields_8_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_72);
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

            // InternalTechnologyDsl.g:3251:3: (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==31) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3252:4: otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) )
            	    {
            	    otherlv_9=(Token)match(input,31,FOLLOW_4); 

            	    				newLeafNode(otherlv_9, grammarAccess.getEnumerationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTechnologyDsl.g:3256:4: ( (lv_fields_10_0= ruleEnumerationField ) )
            	    // InternalTechnologyDsl.g:3257:5: (lv_fields_10_0= ruleEnumerationField )
            	    {
            	    // InternalTechnologyDsl.g:3257:5: (lv_fields_10_0= ruleEnumerationField )
            	    // InternalTechnologyDsl.g:3258:6: lv_fields_10_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_72);
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
            	    break loop70;
                }
            } while (true);

            otherlv_11=(Token)match(input,18,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:3284:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalTechnologyDsl.g:3284:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalTechnologyDsl.g:3285:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalTechnologyDsl.g:3291:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:3297:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalTechnologyDsl.g:3298:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalTechnologyDsl.g:3298:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalTechnologyDsl.g:3299:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalTechnologyDsl.g:3299:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTechnologyDsl.g:3300:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:3300:4: (lv_name_0_0= RULE_ID )
            // InternalTechnologyDsl.g:3301:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_81); 

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

            // InternalTechnologyDsl.g:3317:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==53) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalTechnologyDsl.g:3318:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalTechnologyDsl.g:3322:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalTechnologyDsl.g:3323:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalTechnologyDsl.g:3323:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalTechnologyDsl.g:3324:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_82);
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

                    otherlv_3=(Token)match(input,54,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:3350:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalTechnologyDsl.g:3350:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalTechnologyDsl.g:3351:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalTechnologyDsl.g:3357:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalTechnologyDsl.g:3363:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalTechnologyDsl.g:3364:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalTechnologyDsl.g:3364:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalTechnologyDsl.g:3365:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalTechnologyDsl.g:3365:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==61) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalTechnologyDsl.g:3366:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalTechnologyDsl.g:3366:4: (lv_hidden_0_0= 'hide' )
                    // InternalTechnologyDsl.g:3367:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,61,FOLLOW_83); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalTechnologyDsl.g:3379:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==64) ) {
                alt74=1;
            }
            else if ( (LA74_0==65) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalTechnologyDsl.g:3380:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalTechnologyDsl.g:3380:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalTechnologyDsl.g:3381:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalTechnologyDsl.g:3381:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalTechnologyDsl.g:3382:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,64,FOLLOW_4); 

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
                    // InternalTechnologyDsl.g:3395:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalTechnologyDsl.g:3395:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalTechnologyDsl.g:3396:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_76); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalTechnologyDsl.g:3400:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt73=4;
                    int LA73_0 = input.LA(1);

                    if ( ((LA73_0>=66 && LA73_0<=76)) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==RULE_ID) ) {
                        int LA73_2 = input.LA(2);

                        if ( (LA73_2==RULE_ID||LA73_2==77) ) {
                            alt73=2;
                        }
                        else if ( (LA73_2==42) ) {
                            alt73=3;
                        }
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalTechnologyDsl.g:3401:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalTechnologyDsl.g:3401:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalTechnologyDsl.g:3402:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalTechnologyDsl.g:3402:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalTechnologyDsl.g:3403:8: lv_primitiveReturnType_3_0= rulePrimitiveType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypePrimitiveTypeParserRuleCall_1_1_1_0_0());
                            							
                            pushFollow(FOLLOW_4);
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
                            // InternalTechnologyDsl.g:3421:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalTechnologyDsl.g:3421:6: ( ( ruleQualifiedName ) )
                            // InternalTechnologyDsl.g:3422:7: ( ruleQualifiedName )
                            {
                            // InternalTechnologyDsl.g:3422:7: ( ruleQualifiedName )
                            // InternalTechnologyDsl.g:3423:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getDataOperationRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0());
                            							
                            pushFollow(FOLLOW_4);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalTechnologyDsl.g:3438:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalTechnologyDsl.g:3438:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalTechnologyDsl.g:3439:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalTechnologyDsl.g:3439:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalTechnologyDsl.g:3440:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeImportedComplexTypeParserRuleCall_1_1_1_2_0());
                            							
                            pushFollow(FOLLOW_4);
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

            // InternalTechnologyDsl.g:3460:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalTechnologyDsl.g:3461:4: (lv_name_6_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:3461:4: (lv_name_6_0= RULE_ID )
            // InternalTechnologyDsl.g:3462:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_84); 

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

            // InternalTechnologyDsl.g:3478:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==53) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalTechnologyDsl.g:3479:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,53,FOLLOW_85); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalTechnologyDsl.g:3483:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_ID||(LA75_0>=66 && LA75_0<=76)) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalTechnologyDsl.g:3484:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalTechnologyDsl.g:3484:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalTechnologyDsl.g:3485:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_55);
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

                    // InternalTechnologyDsl.g:3502:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==31) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:3503:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,31,FOLLOW_76); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:3507:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalTechnologyDsl.g:3508:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalTechnologyDsl.g:3508:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalTechnologyDsl.g:3509:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_55);
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
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,54,FOLLOW_78); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalTechnologyDsl.g:3532:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==46) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalTechnologyDsl.g:3533:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,46,FOLLOW_86); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalTechnologyDsl.g:3537:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalTechnologyDsl.g:3538:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalTechnologyDsl.g:3538:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalTechnologyDsl.g:3539:6: lv_features_13_0= ruleDataOperationFeature
                    {

                    						newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_51);
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

                    // InternalTechnologyDsl.g:3556:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==31) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:3557:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,31,FOLLOW_86); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalTechnologyDsl.g:3561:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalTechnologyDsl.g:3562:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalTechnologyDsl.g:3562:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalTechnologyDsl.g:3563:7: lv_features_15_0= ruleDataOperationFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop78;
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
    // InternalTechnologyDsl.g:3590:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalTechnologyDsl.g:3590:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalTechnologyDsl.g:3591:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalTechnologyDsl.g:3597:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalTechnologyDsl.g:3603:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalTechnologyDsl.g:3604:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalTechnologyDsl.g:3604:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalTechnologyDsl.g:3605:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalTechnologyDsl.g:3605:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=66 && LA80_0<=76)) ) {
                alt80=1;
            }
            else if ( (LA80_0==RULE_ID) ) {
                int LA80_2 = input.LA(2);

                if ( (LA80_2==42) ) {
                    alt80=3;
                }
                else if ( (LA80_2==RULE_ID||LA80_2==77) ) {
                    alt80=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalTechnologyDsl.g:3606:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalTechnologyDsl.g:3606:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalTechnologyDsl.g:3607:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalTechnologyDsl.g:3607:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalTechnologyDsl.g:3608:6: lv_primitiveType_0_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_4);
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
                    // InternalTechnologyDsl.g:3626:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalTechnologyDsl.g:3626:4: ( ( ruleQualifiedName ) )
                    // InternalTechnologyDsl.g:3627:5: ( ruleQualifiedName )
                    {
                    // InternalTechnologyDsl.g:3627:5: ( ruleQualifiedName )
                    // InternalTechnologyDsl.g:3628:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3643:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalTechnologyDsl.g:3643:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalTechnologyDsl.g:3644:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalTechnologyDsl.g:3644:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalTechnologyDsl.g:3645:6: lv_importedComplexType_2_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_4);
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

            // InternalTechnologyDsl.g:3663:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTechnologyDsl.g:3664:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:3664:4: (lv_name_3_0= RULE_ID )
            // InternalTechnologyDsl.g:3665:5: lv_name_3_0= RULE_ID
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
    // InternalTechnologyDsl.g:3685:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalTechnologyDsl.g:3685:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalTechnologyDsl.g:3686:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalTechnologyDsl.g:3692:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3698:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalTechnologyDsl.g:3699:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalTechnologyDsl.g:3699:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt81=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt81=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt81=2;
                }
                break;
            case RULE_STRING:
                {
                alt81=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalTechnologyDsl.g:3700:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalTechnologyDsl.g:3700:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalTechnologyDsl.g:3701:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalTechnologyDsl.g:3701:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalTechnologyDsl.g:3702:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalTechnologyDsl.g:3719:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalTechnologyDsl.g:3719:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalTechnologyDsl.g:3720:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalTechnologyDsl.g:3720:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalTechnologyDsl.g:3721:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalTechnologyDsl.g:3738:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalTechnologyDsl.g:3738:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalTechnologyDsl.g:3739:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalTechnologyDsl.g:3739:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalTechnologyDsl.g:3740:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalTechnologyDsl.g:3760:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalTechnologyDsl.g:3760:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalTechnologyDsl.g:3761:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalTechnologyDsl.g:3767:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3773:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalTechnologyDsl.g:3774:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalTechnologyDsl.g:3774:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:3775:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:3775:3: ( (otherlv_0= RULE_ID ) )
            // InternalTechnologyDsl.g:3776:4: (otherlv_0= RULE_ID )
            {
            // InternalTechnologyDsl.g:3776:4: (otherlv_0= RULE_ID )
            // InternalTechnologyDsl.g:3777:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalTechnologyDsl.g:3792:3: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:3793:4: ( ruleQualifiedName )
            {
            // InternalTechnologyDsl.g:3793:4: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:3794:5: ruleQualifiedName
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
    // InternalTechnologyDsl.g:3812:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalTechnologyDsl.g:3812:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalTechnologyDsl.g:3813:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalTechnologyDsl.g:3819:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
            // InternalTechnologyDsl.g:3825:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalTechnologyDsl.g:3826:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalTechnologyDsl.g:3826:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt82=11;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt82=1;
                }
                break;
            case 67:
                {
                alt82=2;
                }
                break;
            case 68:
                {
                alt82=3;
                }
                break;
            case 69:
                {
                alt82=4;
                }
                break;
            case 70:
                {
                alt82=5;
                }
                break;
            case 71:
                {
                alt82=6;
                }
                break;
            case 72:
                {
                alt82=7;
                }
                break;
            case 73:
                {
                alt82=8;
                }
                break;
            case 74:
                {
                alt82=9;
                }
                break;
            case 75:
                {
                alt82=10;
                }
                break;
            case 76:
                {
                alt82=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalTechnologyDsl.g:3827:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalTechnologyDsl.g:3827:3: ( () otherlv_1= 'boolean' )
                    // InternalTechnologyDsl.g:3828:4: () otherlv_1= 'boolean'
                    {
                    // InternalTechnologyDsl.g:3828:4: ()
                    // InternalTechnologyDsl.g:3829:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,66,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3841:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalTechnologyDsl.g:3841:3: ( () otherlv_3= 'byte' )
                    // InternalTechnologyDsl.g:3842:4: () otherlv_3= 'byte'
                    {
                    // InternalTechnologyDsl.g:3842:4: ()
                    // InternalTechnologyDsl.g:3843:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,67,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:3855:3: ( () otherlv_5= 'char' )
                    {
                    // InternalTechnologyDsl.g:3855:3: ( () otherlv_5= 'char' )
                    // InternalTechnologyDsl.g:3856:4: () otherlv_5= 'char'
                    {
                    // InternalTechnologyDsl.g:3856:4: ()
                    // InternalTechnologyDsl.g:3857:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,68,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:3869:3: ( () otherlv_7= 'date' )
                    {
                    // InternalTechnologyDsl.g:3869:3: ( () otherlv_7= 'date' )
                    // InternalTechnologyDsl.g:3870:4: () otherlv_7= 'date'
                    {
                    // InternalTechnologyDsl.g:3870:4: ()
                    // InternalTechnologyDsl.g:3871:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,69,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:3883:3: ( () otherlv_9= 'double' )
                    {
                    // InternalTechnologyDsl.g:3883:3: ( () otherlv_9= 'double' )
                    // InternalTechnologyDsl.g:3884:4: () otherlv_9= 'double'
                    {
                    // InternalTechnologyDsl.g:3884:4: ()
                    // InternalTechnologyDsl.g:3885:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,70,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTechnologyDsl.g:3897:3: ( () otherlv_11= 'float' )
                    {
                    // InternalTechnologyDsl.g:3897:3: ( () otherlv_11= 'float' )
                    // InternalTechnologyDsl.g:3898:4: () otherlv_11= 'float'
                    {
                    // InternalTechnologyDsl.g:3898:4: ()
                    // InternalTechnologyDsl.g:3899:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,71,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTechnologyDsl.g:3911:3: ( () otherlv_13= 'int' )
                    {
                    // InternalTechnologyDsl.g:3911:3: ( () otherlv_13= 'int' )
                    // InternalTechnologyDsl.g:3912:4: () otherlv_13= 'int'
                    {
                    // InternalTechnologyDsl.g:3912:4: ()
                    // InternalTechnologyDsl.g:3913:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,72,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalTechnologyDsl.g:3925:3: ( () otherlv_15= 'long' )
                    {
                    // InternalTechnologyDsl.g:3925:3: ( () otherlv_15= 'long' )
                    // InternalTechnologyDsl.g:3926:4: () otherlv_15= 'long'
                    {
                    // InternalTechnologyDsl.g:3926:4: ()
                    // InternalTechnologyDsl.g:3927:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,73,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalTechnologyDsl.g:3939:3: ( () otherlv_17= 'short' )
                    {
                    // InternalTechnologyDsl.g:3939:3: ( () otherlv_17= 'short' )
                    // InternalTechnologyDsl.g:3940:4: () otherlv_17= 'short'
                    {
                    // InternalTechnologyDsl.g:3940:4: ()
                    // InternalTechnologyDsl.g:3941:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,74,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalTechnologyDsl.g:3953:3: ( () otherlv_19= 'string' )
                    {
                    // InternalTechnologyDsl.g:3953:3: ( () otherlv_19= 'string' )
                    // InternalTechnologyDsl.g:3954:4: () otherlv_19= 'string'
                    {
                    // InternalTechnologyDsl.g:3954:4: ()
                    // InternalTechnologyDsl.g:3955:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,75,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalTechnologyDsl.g:3967:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalTechnologyDsl.g:3967:3: ( () otherlv_21= 'unspecified' )
                    // InternalTechnologyDsl.g:3968:4: () otherlv_21= 'unspecified'
                    {
                    // InternalTechnologyDsl.g:3968:4: ()
                    // InternalTechnologyDsl.g:3969:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0(),
                    						current);
                    				

                    }

                    otherlv_21=(Token)match(input,76,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:3984:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTechnologyDsl.g:3984:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTechnologyDsl.g:3985:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalTechnologyDsl.g:3991:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:3997:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTechnologyDsl.g:3998:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTechnologyDsl.g:3998:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTechnologyDsl.g:3999:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_87); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTechnologyDsl.g:4006:3: (kw= '.' this_ID_2= RULE_ID )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==77) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4007:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,77,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_87); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop83;
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


    // $ANTLR start "ruleExchangePattern"
    // InternalTechnologyDsl.g:4024:1: ruleExchangePattern returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) ;
    public final Enumerator ruleExchangePattern() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4030:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) ) )
            // InternalTechnologyDsl.g:4031:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            {
            // InternalTechnologyDsl.g:4031:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) )
            int alt84=3;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt84=1;
                }
                break;
            case 79:
                {
                alt84=2;
                }
                break;
            case 80:
                {
                alt84=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalTechnologyDsl.g:4032:3: (enumLiteral_0= 'in' )
                    {
                    // InternalTechnologyDsl.g:4032:3: (enumLiteral_0= 'in' )
                    // InternalTechnologyDsl.g:4033:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4040:3: (enumLiteral_1= 'out' )
                    {
                    // InternalTechnologyDsl.g:4040:3: (enumLiteral_1= 'out' )
                    // InternalTechnologyDsl.g:4041:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:4048:3: (enumLiteral_2= 'inout' )
                    {
                    // InternalTechnologyDsl.g:4048:3: (enumLiteral_2= 'inout' )
                    // InternalTechnologyDsl.g:4049:4: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,80,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4059:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4065:2: ( ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) ) )
            // InternalTechnologyDsl.g:4066:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            {
            // InternalTechnologyDsl.g:4066:2: ( (enumLiteral_0= 'sync' ) | (enumLiteral_1= 'async' ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==81) ) {
                alt85=1;
            }
            else if ( (LA85_0==82) ) {
                alt85=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalTechnologyDsl.g:4067:3: (enumLiteral_0= 'sync' )
                    {
                    // InternalTechnologyDsl.g:4067:3: (enumLiteral_0= 'sync' )
                    // InternalTechnologyDsl.g:4068:4: enumLiteral_0= 'sync'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4075:3: (enumLiteral_1= 'async' )
                    {
                    // InternalTechnologyDsl.g:4075:3: (enumLiteral_1= 'async' )
                    // InternalTechnologyDsl.g:4076:4: enumLiteral_1= 'async'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4086:1: ruleCompatibilityDirection returns [Enumerator current=null] : ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) ;
    public final Enumerator ruleCompatibilityDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4092:2: ( ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) ) )
            // InternalTechnologyDsl.g:4093:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            {
            // InternalTechnologyDsl.g:4093:2: ( (enumLiteral_0= '<-' ) | (enumLiteral_1= '->' ) | (enumLiteral_2= '<->' ) )
            int alt86=3;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt86=1;
                }
                break;
            case 84:
                {
                alt86=2;
                }
                break;
            case 85:
                {
                alt86=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // InternalTechnologyDsl.g:4094:3: (enumLiteral_0= '<-' )
                    {
                    // InternalTechnologyDsl.g:4094:3: (enumLiteral_0= '<-' )
                    // InternalTechnologyDsl.g:4095:4: enumLiteral_0= '<-'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4102:3: (enumLiteral_1= '->' )
                    {
                    // InternalTechnologyDsl.g:4102:3: (enumLiteral_1= '->' )
                    // InternalTechnologyDsl.g:4103:4: enumLiteral_1= '->'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:4110:3: (enumLiteral_2= '<->' )
                    {
                    // InternalTechnologyDsl.g:4110:3: (enumLiteral_2= '<->' )
                    // InternalTechnologyDsl.g:4111:4: enumLiteral_2= '<->'
                    {
                    enumLiteral_2=(Token)match(input,85,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4121:1: rulePropertyFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) ;
    public final Enumerator rulePropertyFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4127:2: ( ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) ) )
            // InternalTechnologyDsl.g:4128:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            {
            // InternalTechnologyDsl.g:4128:2: ( (enumLiteral_0= 'mandatory' ) | (enumLiteral_1= 'singleval' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==86) ) {
                alt87=1;
            }
            else if ( (LA87_0==87) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalTechnologyDsl.g:4129:3: (enumLiteral_0= 'mandatory' )
                    {
                    // InternalTechnologyDsl.g:4129:3: (enumLiteral_0= 'mandatory' )
                    // InternalTechnologyDsl.g:4130:4: enumLiteral_0= 'mandatory'
                    {
                    enumLiteral_0=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyFeatureAccess().getMANDATORYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4137:3: (enumLiteral_1= 'singleval' )
                    {
                    // InternalTechnologyDsl.g:4137:3: (enumLiteral_1= 'singleval' )
                    // InternalTechnologyDsl.g:4138:4: enumLiteral_1= 'singleval'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4148:1: ruleServiceJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) ;
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
            // InternalTechnologyDsl.g:4154:2: ( ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) ) )
            // InternalTechnologyDsl.g:4155:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            {
            // InternalTechnologyDsl.g:4155:2: ( (enumLiteral_0= 'types' ) | (enumLiteral_1= 'fields' ) | (enumLiteral_2= 'domainOperations' ) | (enumLiteral_3= 'domainParameters' ) | (enumLiteral_4= 'microservices' ) | (enumLiteral_5= 'interfaces' ) | (enumLiteral_6= 'operations' ) | (enumLiteral_7= 'parameters' ) )
            int alt88=8;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt88=1;
                }
                break;
            case 88:
                {
                alt88=2;
                }
                break;
            case 89:
                {
                alt88=3;
                }
                break;
            case 90:
                {
                alt88=4;
                }
                break;
            case 91:
                {
                alt88=5;
                }
                break;
            case 92:
                {
                alt88=6;
                }
                break;
            case 93:
                {
                alt88=7;
                }
                break;
            case 94:
                {
                alt88=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalTechnologyDsl.g:4156:3: (enumLiteral_0= 'types' )
                    {
                    // InternalTechnologyDsl.g:4156:3: (enumLiteral_0= 'types' )
                    // InternalTechnologyDsl.g:4157:4: enumLiteral_0= 'types'
                    {
                    enumLiteral_0=(Token)match(input,15,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4164:3: (enumLiteral_1= 'fields' )
                    {
                    // InternalTechnologyDsl.g:4164:3: (enumLiteral_1= 'fields' )
                    // InternalTechnologyDsl.g:4165:4: enumLiteral_1= 'fields'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:4172:3: (enumLiteral_2= 'domainOperations' )
                    {
                    // InternalTechnologyDsl.g:4172:3: (enumLiteral_2= 'domainOperations' )
                    // InternalTechnologyDsl.g:4173:4: enumLiteral_2= 'domainOperations'
                    {
                    enumLiteral_2=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATIONSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:4180:3: (enumLiteral_3= 'domainParameters' )
                    {
                    // InternalTechnologyDsl.g:4180:3: (enumLiteral_3= 'domainParameters' )
                    // InternalTechnologyDsl.g:4181:4: enumLiteral_3= 'domainParameters'
                    {
                    enumLiteral_3=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getServiceJoinPointTypeAccess().getDATA_OPERATION_PARAMETERSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:4188:3: (enumLiteral_4= 'microservices' )
                    {
                    // InternalTechnologyDsl.g:4188:3: (enumLiteral_4= 'microservices' )
                    // InternalTechnologyDsl.g:4189:4: enumLiteral_4= 'microservices'
                    {
                    enumLiteral_4=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTechnologyDsl.g:4196:3: (enumLiteral_5= 'interfaces' )
                    {
                    // InternalTechnologyDsl.g:4196:3: (enumLiteral_5= 'interfaces' )
                    // InternalTechnologyDsl.g:4197:4: enumLiteral_5= 'interfaces'
                    {
                    enumLiteral_5=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTechnologyDsl.g:4204:3: (enumLiteral_6= 'operations' )
                    {
                    // InternalTechnologyDsl.g:4204:3: (enumLiteral_6= 'operations' )
                    // InternalTechnologyDsl.g:4205:4: enumLiteral_6= 'operations'
                    {
                    enumLiteral_6=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalTechnologyDsl.g:4212:3: (enumLiteral_7= 'parameters' )
                    {
                    // InternalTechnologyDsl.g:4212:3: (enumLiteral_7= 'parameters' )
                    // InternalTechnologyDsl.g:4213:4: enumLiteral_7= 'parameters'
                    {
                    enumLiteral_7=(Token)match(input,94,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4223:1: ruleAspectFeature returns [Enumerator current=null] : (enumLiteral_0= 'singleval' ) ;
    public final Enumerator ruleAspectFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4229:2: ( (enumLiteral_0= 'singleval' ) )
            // InternalTechnologyDsl.g:4230:2: (enumLiteral_0= 'singleval' )
            {
            // InternalTechnologyDsl.g:4230:2: (enumLiteral_0= 'singleval' )
            // InternalTechnologyDsl.g:4231:3: enumLiteral_0= 'singleval'
            {
            enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4240:1: ruleOperationJoinPointType returns [Enumerator current=null] : ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) ;
    public final Enumerator ruleOperationJoinPointType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4246:2: ( ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) ) )
            // InternalTechnologyDsl.g:4247:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            {
            // InternalTechnologyDsl.g:4247:2: ( (enumLiteral_0= 'containers' ) | (enumLiteral_1= 'infrastructure' ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==95) ) {
                alt89=1;
            }
            else if ( (LA89_0==24) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalTechnologyDsl.g:4248:3: (enumLiteral_0= 'containers' )
                    {
                    // InternalTechnologyDsl.g:4248:3: (enumLiteral_0= 'containers' )
                    // InternalTechnologyDsl.g:4249:4: enumLiteral_0= 'containers'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4256:3: (enumLiteral_1= 'infrastructure' )
                    {
                    // InternalTechnologyDsl.g:4256:3: (enumLiteral_1= 'infrastructure' )
                    // InternalTechnologyDsl.g:4257:4: enumLiteral_1= 'infrastructure'
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4267:1: ruleComplexTypeFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
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
            // InternalTechnologyDsl.g:4273:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalTechnologyDsl.g:4274:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalTechnologyDsl.g:4274:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt90=11;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt90=1;
                }
                break;
            case 97:
                {
                alt90=2;
                }
                break;
            case 98:
                {
                alt90=3;
                }
                break;
            case 99:
                {
                alt90=4;
                }
                break;
            case 100:
                {
                alt90=5;
                }
                break;
            case 101:
                {
                alt90=6;
                }
                break;
            case 102:
                {
                alt90=7;
                }
                break;
            case 103:
                {
                alt90=8;
                }
                break;
            case 20:
                {
                alt90=9;
                }
                break;
            case 104:
                {
                alt90=10;
                }
                break;
            case 105:
                {
                alt90=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalTechnologyDsl.g:4275:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalTechnologyDsl.g:4275:3: (enumLiteral_0= 'aggregate' )
                    // InternalTechnologyDsl.g:4276:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4283:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalTechnologyDsl.g:4283:3: (enumLiteral_1= 'applicationService' )
                    // InternalTechnologyDsl.g:4284:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:4291:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalTechnologyDsl.g:4291:3: (enumLiteral_2= 'domainEvent' )
                    // InternalTechnologyDsl.g:4292:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:4299:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalTechnologyDsl.g:4299:3: (enumLiteral_3= 'domainService' )
                    // InternalTechnologyDsl.g:4300:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:4307:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalTechnologyDsl.g:4307:3: (enumLiteral_4= 'entity' )
                    // InternalTechnologyDsl.g:4308:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTechnologyDsl.g:4315:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalTechnologyDsl.g:4315:3: (enumLiteral_5= 'factory' )
                    // InternalTechnologyDsl.g:4316:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTechnologyDsl.g:4323:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalTechnologyDsl.g:4323:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalTechnologyDsl.g:4324:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalTechnologyDsl.g:4331:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalTechnologyDsl.g:4331:3: (enumLiteral_7= 'repository' )
                    // InternalTechnologyDsl.g:4332:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalTechnologyDsl.g:4339:3: (enumLiteral_8= 'service' )
                    {
                    // InternalTechnologyDsl.g:4339:3: (enumLiteral_8= 'service' )
                    // InternalTechnologyDsl.g:4340:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalTechnologyDsl.g:4347:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalTechnologyDsl.g:4347:3: (enumLiteral_9= 'specification' )
                    // InternalTechnologyDsl.g:4348:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalTechnologyDsl.g:4355:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalTechnologyDsl.g:4355:3: (enumLiteral_10= 'valueObject' )
                    // InternalTechnologyDsl.g:4356:4: enumLiteral_10= 'valueObject'
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
    // InternalTechnologyDsl.g:4366:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4372:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalTechnologyDsl.g:4373:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalTechnologyDsl.g:4373:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt91=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt91=1;
                }
                break;
            case 107:
                {
                alt91=2;
                }
                break;
            case 108:
                {
                alt91=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalTechnologyDsl.g:4374:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalTechnologyDsl.g:4374:3: (enumLiteral_0= 'identifier' )
                    // InternalTechnologyDsl.g:4375:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4382:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalTechnologyDsl.g:4382:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalTechnologyDsl.g:4383:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:4390:3: (enumLiteral_2= 'part' )
                    {
                    // InternalTechnologyDsl.g:4390:3: (enumLiteral_2= 'part' )
                    // InternalTechnologyDsl.g:4391:4: enumLiteral_2= 'part'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:4401:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTechnologyDsl.g:4407:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalTechnologyDsl.g:4408:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalTechnologyDsl.g:4408:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt92=4;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt92=1;
                }
                break;
            case 106:
                {
                alt92=2;
                }
                break;
            case 110:
                {
                alt92=3;
                }
                break;
            case 111:
                {
                alt92=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalTechnologyDsl.g:4409:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalTechnologyDsl.g:4409:3: (enumLiteral_0= 'closure' )
                    // InternalTechnologyDsl.g:4410:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:4417:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalTechnologyDsl.g:4417:3: (enumLiteral_1= 'identifier' )
                    // InternalTechnologyDsl.g:4418:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:4425:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalTechnologyDsl.g:4425:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalTechnologyDsl.g:4426:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:4433:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalTechnologyDsl.g:4433:3: (enumLiteral_3= 'validator' )
                    // InternalTechnologyDsl.g:4434:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,111,FOLLOW_2); 

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


    protected DFA61 dfa61 = new DFA61(this);
    static final String dfa_1s = "\21\uffff";
    static final String dfa_2s = "\1\50\1\4\1\16\1\4\1\uffff\13\4\1\uffff";
    static final String dfa_3s = "\1\50\1\4\1\16\1\114\1\uffff\13\22\1\uffff";
    static final String dfa_4s = "\4\uffff\1\1\13\uffff\1\2";
    static final String dfa_5s = "\21\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\70\uffff\2\4\3\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17",
            "",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            "\1\4\15\uffff\1\20",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2802:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000035C8000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000031000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000031000050000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000035C0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L,0x0000000000060000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003540000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0080000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000003440000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000980000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000080000000L,0x0000000000380000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000880000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000040000L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000500800000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000400800000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000800080000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x000000000001C000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000F000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0040000080000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0100400000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000008000L,0x000000007F000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000880004000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0010000000040000L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000001000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x8800030000040000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x8000030000040000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0800000000040000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x8000030000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x1000400000004000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000100000L,0x000003FF00000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x1000000000004000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x6000000000040010L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x6000000000000010L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x6000000000000010L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x4000000000000010L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000010L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000500000000002L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x00001C0000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000400000004000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0020400000000002L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0040000080000010L,0x0000000000001FFCL});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000E40000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});

}