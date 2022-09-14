package de.fhdo.lemma.data.parser.antlr.internal;

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
import de.fhdo.lemma.data.services.DataDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDataDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'datatypes'", "'from'", "'as'", "'version'", "'{'", "'}'", "'context'", "'structure'", "'<'", "','", "'>'", "'extends'", "'collection'", "'hide'", "'immutable'", "'='", "'enum'", "'('", "')'", "'procedure'", "'function'", "'::'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'unspecified'", "'.'", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'service'", "'specification'", "'valueObject'", "'identifier'", "'neverEmpty'", "'part'", "'closure'", "'sideEffectFree'", "'validator'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_BIG_DECIMAL=6;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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

    // delegates
    // delegators


        public InternalDataDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDataDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDataDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDataDsl.g"; }



     	private DataDslGrammarAccess grammarAccess;

        public InternalDataDslParser(TokenStream input, DataDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "DataModel";
       	}

       	@Override
       	protected DataDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDataModel"
    // InternalDataDsl.g:65:1: entryRuleDataModel returns [EObject current=null] : iv_ruleDataModel= ruleDataModel EOF ;
    public final EObject entryRuleDataModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataModel = null;


        try {
            // InternalDataDsl.g:65:50: (iv_ruleDataModel= ruleDataModel EOF )
            // InternalDataDsl.g:66:2: iv_ruleDataModel= ruleDataModel EOF
            {
             newCompositeNode(grammarAccess.getDataModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataModel=ruleDataModel();

            state._fsp--;

             current =iv_ruleDataModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataModel"


    // $ANTLR start "ruleDataModel"
    // InternalDataDsl.g:72:1: ruleDataModel returns [EObject current=null] : ( ( (lv_complexTypeImports_0_0= ruleComplexTypeImport ) )* ( ( (lv_versions_1_0= ruleVersion ) )+ | ( (lv_contexts_2_0= ruleContext ) )+ | ( (lv_complexTypes_3_0= ruleComplexType ) )+ ) ) ;
    public final EObject ruleDataModel() throws RecognitionException {
        EObject current = null;

        EObject lv_complexTypeImports_0_0 = null;

        EObject lv_versions_1_0 = null;

        EObject lv_contexts_2_0 = null;

        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:78:2: ( ( ( (lv_complexTypeImports_0_0= ruleComplexTypeImport ) )* ( ( (lv_versions_1_0= ruleVersion ) )+ | ( (lv_contexts_2_0= ruleContext ) )+ | ( (lv_complexTypes_3_0= ruleComplexType ) )+ ) ) )
            // InternalDataDsl.g:79:2: ( ( (lv_complexTypeImports_0_0= ruleComplexTypeImport ) )* ( ( (lv_versions_1_0= ruleVersion ) )+ | ( (lv_contexts_2_0= ruleContext ) )+ | ( (lv_complexTypes_3_0= ruleComplexType ) )+ ) )
            {
            // InternalDataDsl.g:79:2: ( ( (lv_complexTypeImports_0_0= ruleComplexTypeImport ) )* ( ( (lv_versions_1_0= ruleVersion ) )+ | ( (lv_contexts_2_0= ruleContext ) )+ | ( (lv_complexTypes_3_0= ruleComplexType ) )+ ) )
            // InternalDataDsl.g:80:3: ( (lv_complexTypeImports_0_0= ruleComplexTypeImport ) )* ( ( (lv_versions_1_0= ruleVersion ) )+ | ( (lv_contexts_2_0= ruleContext ) )+ | ( (lv_complexTypes_3_0= ruleComplexType ) )+ )
            {
            // InternalDataDsl.g:80:3: ( (lv_complexTypeImports_0_0= ruleComplexTypeImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDataDsl.g:81:4: (lv_complexTypeImports_0_0= ruleComplexTypeImport )
            	    {
            	    // InternalDataDsl.g:81:4: (lv_complexTypeImports_0_0= ruleComplexTypeImport )
            	    // InternalDataDsl.g:82:5: lv_complexTypeImports_0_0= ruleComplexTypeImport
            	    {

            	    					newCompositeNode(grammarAccess.getDataModelAccess().getComplexTypeImportsComplexTypeImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_complexTypeImports_0_0=ruleComplexTypeImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"complexTypeImports",
            	    						lv_complexTypeImports_0_0,
            	    						"de.fhdo.lemma.data.DataDsl.ComplexTypeImport");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDataDsl.g:99:3: ( ( (lv_versions_1_0= ruleVersion ) )+ | ( (lv_contexts_2_0= ruleContext ) )+ | ( (lv_complexTypes_3_0= ruleComplexType ) )+ )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case 21:
            case 26:
            case 30:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDataDsl.g:100:4: ( (lv_versions_1_0= ruleVersion ) )+
                    {
                    // InternalDataDsl.g:100:4: ( (lv_versions_1_0= ruleVersion ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDsl.g:101:5: (lv_versions_1_0= ruleVersion )
                    	    {
                    	    // InternalDataDsl.g:101:5: (lv_versions_1_0= ruleVersion )
                    	    // InternalDataDsl.g:102:6: lv_versions_1_0= ruleVersion
                    	    {

                    	    						newCompositeNode(grammarAccess.getDataModelAccess().getVersionsVersionParserRuleCall_1_0_0());
                    	    					
                    	    pushFollow(FOLLOW_4);
                    	    lv_versions_1_0=ruleVersion();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDataModelRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"versions",
                    	    							lv_versions_1_0,
                    	    							"de.fhdo.lemma.data.DataDsl.Version");
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
                    break;
                case 2 :
                    // InternalDataDsl.g:120:4: ( (lv_contexts_2_0= ruleContext ) )+
                    {
                    // InternalDataDsl.g:120:4: ( (lv_contexts_2_0= ruleContext ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==20) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalDataDsl.g:121:5: (lv_contexts_2_0= ruleContext )
                    	    {
                    	    // InternalDataDsl.g:121:5: (lv_contexts_2_0= ruleContext )
                    	    // InternalDataDsl.g:122:6: lv_contexts_2_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getDataModelAccess().getContextsContextParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_5);
                    	    lv_contexts_2_0=ruleContext();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDataModelRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"contexts",
                    	    							lv_contexts_2_0,
                    	    							"de.fhdo.lemma.data.DataDsl.Context");
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
                    break;
                case 3 :
                    // InternalDataDsl.g:140:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalDataDsl.g:140:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==21||LA4_0==26||LA4_0==30) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalDataDsl.g:141:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalDataDsl.g:141:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalDataDsl.g:142:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getDataModelAccess().getComplexTypesComplexTypeParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_complexTypes_3_0=ruleComplexType();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDataModelRule());
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
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


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
    // $ANTLR end "ruleDataModel"


    // $ANTLR start "entryRuleComplexTypeImport"
    // InternalDataDsl.g:164:1: entryRuleComplexTypeImport returns [EObject current=null] : iv_ruleComplexTypeImport= ruleComplexTypeImport EOF ;
    public final EObject entryRuleComplexTypeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeImport = null;


        try {
            // InternalDataDsl.g:164:58: (iv_ruleComplexTypeImport= ruleComplexTypeImport EOF )
            // InternalDataDsl.g:165:2: iv_ruleComplexTypeImport= ruleComplexTypeImport EOF
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
    // InternalDataDsl.g:171:1: ruleComplexTypeImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) ;
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
            // InternalDataDsl.g:177:2: ( (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) ) )
            // InternalDataDsl.g:178:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            {
            // InternalDataDsl.g:178:2: (otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) ) )
            // InternalDataDsl.g:179:3: otherlv_0= 'import' otherlv_1= 'datatypes' otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) otherlv_4= 'as' ( (lv_name_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexTypeImportAccess().getImportKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexTypeImportAccess().getFromKeyword_2());
            		
            // InternalDataDsl.g:191:3: ( (lv_importURI_3_0= RULE_STRING ) )
            // InternalDataDsl.g:192:4: (lv_importURI_3_0= RULE_STRING )
            {
            // InternalDataDsl.g:192:4: (lv_importURI_3_0= RULE_STRING )
            // InternalDataDsl.g:193:5: lv_importURI_3_0= RULE_STRING
            {
            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

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

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getComplexTypeImportAccess().getAsKeyword_4());
            		
            // InternalDataDsl.g:213:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalDataDsl.g:214:4: (lv_name_5_0= RULE_ID )
            {
            // InternalDataDsl.g:214:4: (lv_name_5_0= RULE_ID )
            // InternalDataDsl.g:215:5: lv_name_5_0= RULE_ID
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
    // InternalDataDsl.g:235:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalDataDsl.g:235:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalDataDsl.g:236:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalDataDsl.g:242:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) ;
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
            // InternalDataDsl.g:248:2: ( (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' ) )
            // InternalDataDsl.g:249:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            {
            // InternalDataDsl.g:249:2: (otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}' )
            // InternalDataDsl.g:250:3: otherlv_0= 'version' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
            		
            // InternalDataDsl.g:254:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDataDsl.g:255:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDataDsl.g:255:4: (lv_name_1_0= RULE_ID )
            // InternalDataDsl.g:256:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDataDsl.g:276:3: ( ( (lv_complexTypes_3_0= ruleComplexType ) )+ | ( (lv_contexts_4_0= ruleContext ) )+ )?
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21||LA8_0==26||LA8_0==30) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            switch (alt8) {
                case 1 :
                    // InternalDataDsl.g:277:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    {
                    // InternalDataDsl.g:277:4: ( (lv_complexTypes_3_0= ruleComplexType ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==21||LA6_0==26||LA6_0==30) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDsl.g:278:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    {
                    	    // InternalDataDsl.g:278:5: (lv_complexTypes_3_0= ruleComplexType )
                    	    // InternalDataDsl.g:279:6: lv_complexTypes_3_0= ruleComplexType
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:297:4: ( (lv_contexts_4_0= ruleContext ) )+
                    {
                    // InternalDataDsl.g:297:4: ( (lv_contexts_4_0= ruleContext ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalDataDsl.g:298:5: (lv_contexts_4_0= ruleContext )
                    	    {
                    	    // InternalDataDsl.g:298:5: (lv_contexts_4_0= ruleContext )
                    	    // InternalDataDsl.g:299:6: lv_contexts_4_0= ruleContext
                    	    {

                    	    						newCompositeNode(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
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
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:325:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalDataDsl.g:325:48: (iv_ruleContext= ruleContext EOF )
            // InternalDataDsl.g:326:2: iv_ruleContext= ruleContext EOF
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
    // InternalDataDsl.g:332:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_complexTypes_3_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:338:2: ( (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' ) )
            // InternalDataDsl.g:339:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            {
            // InternalDataDsl.g:339:2: (otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}' )
            // InternalDataDsl.g:340:3: otherlv_0= 'context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_complexTypes_3_0= ruleComplexType ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalDataDsl.g:344:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDataDsl.g:345:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDataDsl.g:345:4: (lv_name_1_0= RULE_ID )
            // InternalDataDsl.g:346:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDataDsl.g:366:3: ( (lv_complexTypes_3_0= ruleComplexType ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21||LA9_0==26||LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDataDsl.g:367:4: (lv_complexTypes_3_0= ruleComplexType )
            	    {
            	    // InternalDataDsl.g:367:4: (lv_complexTypes_3_0= ruleComplexType )
            	    // InternalDataDsl.g:368:5: lv_complexTypes_3_0= ruleComplexType
            	    {

            	    					newCompositeNode(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_13);
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:393:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalDataDsl.g:393:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalDataDsl.g:394:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalDataDsl.g:400:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_CollectionType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:406:2: ( (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration ) )
            // InternalDataDsl.g:407:2: (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalDataDsl.g:407:2: (this_DataStructure_0= ruleDataStructure | this_CollectionType_1= ruleCollectionType | this_Enumeration_2= ruleEnumeration )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt10=1;
                }
                break;
            case 26:
                {
                alt10=2;
                }
                break;
            case 30:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalDataDsl.g:408:3: this_DataStructure_0= ruleDataStructure
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
                    // InternalDataDsl.g:417:3: this_CollectionType_1= ruleCollectionType
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
                    // InternalDataDsl.g:426:3: this_Enumeration_2= ruleEnumeration
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
    // InternalDataDsl.g:438:1: entryRuleDataStructure returns [EObject current=null] : iv_ruleDataStructure= ruleDataStructure EOF ;
    public final EObject entryRuleDataStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataStructure = null;


        try {
            // InternalDataDsl.g:438:54: (iv_ruleDataStructure= ruleDataStructure EOF )
            // InternalDataDsl.g:439:2: iv_ruleDataStructure= ruleDataStructure EOF
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
    // InternalDataDsl.g:445:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) ;
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
            // InternalDataDsl.g:451:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' ) )
            // InternalDataDsl.g:452:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            {
            // InternalDataDsl.g:452:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}' )
            // InternalDataDsl.g:453:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_9= '{' ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getDataStructureAccess().getStructureKeyword_0());
            		
            // InternalDataDsl.g:457:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDataDsl.g:458:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDataDsl.g:458:4: (lv_name_1_0= RULE_ID )
            // InternalDataDsl.g:459:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

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

            // InternalDataDsl.g:475:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDataDsl.g:476:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalDataDsl.g:480:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalDataDsl.g:481:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalDataDsl.g:481:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalDataDsl.g:482:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalDataDsl.g:499:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==23) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalDataDsl.g:500:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_17); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalDataDsl.g:504:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalDataDsl.g:505:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalDataDsl.g:505:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalDataDsl.g:506:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,24,FOLLOW_19); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalDataDsl.g:529:3: (otherlv_7= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDsl.g:530:4: otherlv_7= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0());
                    			
                    // InternalDataDsl.g:534:4: ( ( ruleQualifiedName ) )
                    // InternalDataDsl.g:535:5: ( ruleQualifiedName )
                    {
                    // InternalDataDsl.g:535:5: ( ruleQualifiedName )
                    // InternalDataDsl.g:536:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_20); 

            			newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDataDsl.g:555:3: ( ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||(LA17_0>=27 && LA17_0<=28)||(LA17_0>=33 && LA17_0<=34)||(LA17_0>=36 && LA17_0<=46)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDataDsl.g:556:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) ) (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    {
                    // InternalDataDsl.g:556:4: ( ( (lv_dataFields_10_0= ruleDataField ) ) | ( (lv_operations_11_0= ruleDataOperation ) ) )
                    int alt14=2;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        int LA14_1 = input.LA(2);

                        if ( ((LA14_1>=33 && LA14_1<=34)) ) {
                            alt14=2;
                        }
                        else if ( (LA14_1==RULE_ID||LA14_1==28||(LA14_1>=36 && LA14_1<=46)) ) {
                            alt14=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case 28:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                        {
                        alt14=1;
                        }
                        break;
                    case 33:
                    case 34:
                        {
                        alt14=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }

                    switch (alt14) {
                        case 1 :
                            // InternalDataDsl.g:557:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            {
                            // InternalDataDsl.g:557:5: ( (lv_dataFields_10_0= ruleDataField ) )
                            // InternalDataDsl.g:558:6: (lv_dataFields_10_0= ruleDataField )
                            {
                            // InternalDataDsl.g:558:6: (lv_dataFields_10_0= ruleDataField )
                            // InternalDataDsl.g:559:7: lv_dataFields_10_0= ruleDataField
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
                            // InternalDataDsl.g:577:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            {
                            // InternalDataDsl.g:577:5: ( (lv_operations_11_0= ruleDataOperation ) )
                            // InternalDataDsl.g:578:6: (lv_operations_11_0= ruleDataOperation )
                            {
                            // InternalDataDsl.g:578:6: (lv_operations_11_0= ruleDataOperation )
                            // InternalDataDsl.g:579:7: lv_operations_11_0= ruleDataOperation
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

                    // InternalDataDsl.g:597:4: (otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==23) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalDataDsl.g:598:5: otherlv_12= ',' ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_22); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalDataDsl.g:602:5: ( ( (lv_dataFields_13_0= ruleDataField ) ) | ( (lv_operations_14_0= ruleDataOperation ) ) )
                    	    int alt15=2;
                    	    switch ( input.LA(1) ) {
                    	    case 27:
                    	        {
                    	        int LA15_1 = input.LA(2);

                    	        if ( ((LA15_1>=33 && LA15_1<=34)) ) {
                    	            alt15=2;
                    	        }
                    	        else if ( (LA15_1==RULE_ID||LA15_1==28||(LA15_1>=36 && LA15_1<=46)) ) {
                    	            alt15=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 15, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case RULE_ID:
                    	    case 28:
                    	    case 36:
                    	    case 37:
                    	    case 38:
                    	    case 39:
                    	    case 40:
                    	    case 41:
                    	    case 42:
                    	    case 43:
                    	    case 44:
                    	    case 45:
                    	    case 46:
                    	        {
                    	        alt15=1;
                    	        }
                    	        break;
                    	    case 33:
                    	    case 34:
                    	        {
                    	        alt15=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 15, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt15) {
                    	        case 1 :
                    	            // InternalDataDsl.g:603:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            {
                    	            // InternalDataDsl.g:603:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	            // InternalDataDsl.g:604:7: (lv_dataFields_13_0= ruleDataField )
                    	            {
                    	            // InternalDataDsl.g:604:7: (lv_dataFields_13_0= ruleDataField )
                    	            // InternalDataDsl.g:605:8: lv_dataFields_13_0= ruleDataField
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
                    	            // InternalDataDsl.g:623:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            {
                    	            // InternalDataDsl.g:623:6: ( (lv_operations_14_0= ruleDataOperation ) )
                    	            // InternalDataDsl.g:624:7: (lv_operations_14_0= ruleDataOperation )
                    	            {
                    	            // InternalDataDsl.g:624:7: (lv_operations_14_0= ruleDataOperation )
                    	            // InternalDataDsl.g:625:8: lv_operations_14_0= ruleDataOperation
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
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:653:1: entryRuleCollectionType returns [EObject current=null] : iv_ruleCollectionType= ruleCollectionType EOF ;
    public final EObject entryRuleCollectionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionType = null;


        try {
            // InternalDataDsl.g:653:55: (iv_ruleCollectionType= ruleCollectionType EOF )
            // InternalDataDsl.g:654:2: iv_ruleCollectionType= ruleCollectionType EOF
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
    // InternalDataDsl.g:660:1: ruleCollectionType returns [EObject current=null] : ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalDataDsl.g:666:2: ( ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalDataDsl.g:667:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalDataDsl.g:667:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalDataDsl.g:668:3: (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalDataDsl.g:668:3: (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalDataDsl.g:669:4: otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,26,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getCollectionTypeAccess().getCollectionKeyword_0_0());
                    			
                    // InternalDataDsl.g:673:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalDataDsl.g:674:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalDataDsl.g:674:5: (lv_name_1_0= RULE_ID )
                    // InternalDataDsl.g:675:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

                    otherlv_2=(Token)match(input,18,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalDataDsl.g:695:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalDataDsl.g:696:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalDataDsl.g:696:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalDataDsl.g:697:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_21);
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

                    // InternalDataDsl.g:714:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==23) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalDataDsl.g:715:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_23); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getCollectionTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalDataDsl.g:719:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalDataDsl.g:720:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalDataDsl.g:720:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalDataDsl.g:721:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:745:3: (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalDataDsl.g:745:3: (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalDataDsl.g:746:4: otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,26,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getCollectionTypeAccess().getCollectionKeyword_1_0());
                    			
                    // InternalDataDsl.g:750:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalDataDsl.g:751:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalDataDsl.g:751:5: (lv_name_8_0= RULE_ID )
                    // InternalDataDsl.g:752:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

                    otherlv_9=(Token)match(input,18,FOLLOW_24); 

                    				newLeafNode(otherlv_9, grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalDataDsl.g:772:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalDataDsl.g:773:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalDataDsl.g:773:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalDataDsl.g:774:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getCollectionTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_25);
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

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:800:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalDataDsl.g:800:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalDataDsl.g:801:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalDataDsl.g:807:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) ;
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
            // InternalDataDsl.g:813:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? ) )
            // InternalDataDsl.g:814:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            {
            // InternalDataDsl.g:814:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )? )
            // InternalDataDsl.g:815:3: ( (lv_hidden_0_0= 'hide' ) )? ( (lv_immutable_1_0= 'immutable' ) )? ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )? (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            {
            // InternalDataDsl.g:815:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDataDsl.g:816:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalDataDsl.g:816:4: (lv_hidden_0_0= 'hide' )
                    // InternalDataDsl.g:817:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,27,FOLLOW_26); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalDataDsl.g:829:3: ( (lv_immutable_1_0= 'immutable' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDsl.g:830:4: (lv_immutable_1_0= 'immutable' )
                    {
                    // InternalDataDsl.g:830:4: (lv_immutable_1_0= 'immutable' )
                    // InternalDataDsl.g:831:5: lv_immutable_1_0= 'immutable'
                    {
                    lv_immutable_1_0=(Token)match(input,28,FOLLOW_27); 

                    					newLeafNode(lv_immutable_1_0, grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "immutable", lv_immutable_1_0 != null, "immutable");
                    				

                    }


                    }
                    break;

            }

            // InternalDataDsl.g:843:3: ( ( (lv_primitiveType_2_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_4_0= ruleImportedComplexType ) ) )?
            int alt22=4;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=36 && LA22_0<=46)) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ID) ) {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==RULE_ID||LA22_2==47) ) {
                    alt22=2;
                }
                else if ( (LA22_2==35) ) {
                    alt22=3;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDsl.g:844:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    {
                    // InternalDataDsl.g:844:4: ( (lv_primitiveType_2_0= rulePrimitiveType ) )
                    // InternalDataDsl.g:845:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    {
                    // InternalDataDsl.g:845:5: (lv_primitiveType_2_0= rulePrimitiveType )
                    // InternalDataDsl.g:846:6: lv_primitiveType_2_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_11);
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
                    // InternalDataDsl.g:864:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalDataDsl.g:864:4: ( ( ruleQualifiedName ) )
                    // InternalDataDsl.g:865:5: ( ruleQualifiedName )
                    {
                    // InternalDataDsl.g:865:5: ( ruleQualifiedName )
                    // InternalDataDsl.g:866:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataFieldRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:881:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    {
                    // InternalDataDsl.g:881:4: ( (lv_importedComplexType_4_0= ruleImportedComplexType ) )
                    // InternalDataDsl.g:882:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    {
                    // InternalDataDsl.g:882:5: (lv_importedComplexType_4_0= ruleImportedComplexType )
                    // InternalDataDsl.g:883:6: lv_importedComplexType_4_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_11);
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

            // InternalDataDsl.g:901:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalDataDsl.g:902:4: (lv_name_5_0= RULE_ID )
            {
            // InternalDataDsl.g:902:4: (lv_name_5_0= RULE_ID )
            // InternalDataDsl.g:903:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_28); 

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

            // InternalDataDsl.g:919:3: (otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDataDsl.g:920:4: otherlv_6= '=' ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_29); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0());
                    			
                    // InternalDataDsl.g:924:4: ( (lv_initializationValue_7_0= rulePrimitiveValue ) )
                    // InternalDataDsl.g:925:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    {
                    // InternalDataDsl.g:925:5: (lv_initializationValue_7_0= rulePrimitiveValue )
                    // InternalDataDsl.g:926:6: lv_initializationValue_7_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_30);
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

            // InternalDataDsl.g:944:3: (otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==22) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDsl.g:945:4: otherlv_8= '<' ( (lv_features_9_0= ruleDataFieldFeature ) ) (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )* otherlv_12= '>'
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_31); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0());
                    			
                    // InternalDataDsl.g:949:4: ( (lv_features_9_0= ruleDataFieldFeature ) )
                    // InternalDataDsl.g:950:5: (lv_features_9_0= ruleDataFieldFeature )
                    {
                    // InternalDataDsl.g:950:5: (lv_features_9_0= ruleDataFieldFeature )
                    // InternalDataDsl.g:951:6: lv_features_9_0= ruleDataFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalDataDsl.g:968:4: (otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==23) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalDataDsl.g:969:5: otherlv_10= ',' ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_31); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalDataDsl.g:973:5: ( (lv_features_11_0= ruleDataFieldFeature ) )
                    	    // InternalDataDsl.g:974:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    {
                    	    // InternalDataDsl.g:974:6: (lv_features_11_0= ruleDataFieldFeature )
                    	    // InternalDataDsl.g:975:7: lv_features_11_0= ruleDataFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,24,FOLLOW_2); 

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
    // InternalDataDsl.g:1002:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalDataDsl.g:1002:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalDataDsl.g:1003:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalDataDsl.g:1009:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) ;
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
            // InternalDataDsl.g:1015:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' ) )
            // InternalDataDsl.g:1016:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            {
            // InternalDataDsl.g:1016:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}' )
            // InternalDataDsl.g:1017:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )? otherlv_7= '{' ( (lv_fields_8_0= ruleEnumerationField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalDataDsl.g:1021:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDataDsl.g:1022:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDataDsl.g:1022:4: (lv_name_1_0= RULE_ID )
            // InternalDataDsl.g:1023:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            // InternalDataDsl.g:1039:3: (otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==22) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDsl.g:1040:4: otherlv_2= '<' ( (lv_features_3_0= ruleComplexTypeFeature ) ) (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalDataDsl.g:1044:4: ( (lv_features_3_0= ruleComplexTypeFeature ) )
                    // InternalDataDsl.g:1045:5: (lv_features_3_0= ruleComplexTypeFeature )
                    {
                    // InternalDataDsl.g:1045:5: (lv_features_3_0= ruleComplexTypeFeature )
                    // InternalDataDsl.g:1046:6: lv_features_3_0= ruleComplexTypeFeature
                    {

                    						newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalDataDsl.g:1063:4: (otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==23) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalDataDsl.g:1064:5: otherlv_4= ',' ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_17); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalDataDsl.g:1068:5: ( (lv_features_5_0= ruleComplexTypeFeature ) )
                    	    // InternalDataDsl.g:1069:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    {
                    	    // InternalDataDsl.g:1069:6: (lv_features_5_0= ruleComplexTypeFeature )
                    	    // InternalDataDsl.g:1070:7: lv_features_5_0= ruleComplexTypeFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,24,FOLLOW_12); 

                    				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalDataDsl.g:1097:3: ( (lv_fields_8_0= ruleEnumerationField ) )
            // InternalDataDsl.g:1098:4: (lv_fields_8_0= ruleEnumerationField )
            {
            // InternalDataDsl.g:1098:4: (lv_fields_8_0= ruleEnumerationField )
            // InternalDataDsl.g:1099:5: lv_fields_8_0= ruleEnumerationField
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

            // InternalDataDsl.g:1116:3: (otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==23) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDsl.g:1117:4: otherlv_9= ',' ( (lv_fields_10_0= ruleEnumerationField ) )
            	    {
            	    otherlv_9=(Token)match(input,23,FOLLOW_11); 

            	    				newLeafNode(otherlv_9, grammarAccess.getEnumerationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalDataDsl.g:1121:4: ( (lv_fields_10_0= ruleEnumerationField ) )
            	    // InternalDataDsl.g:1122:5: (lv_fields_10_0= ruleEnumerationField )
            	    {
            	    // InternalDataDsl.g:1122:5: (lv_fields_10_0= ruleEnumerationField )
            	    // InternalDataDsl.g:1123:6: lv_fields_10_0= ruleEnumerationField
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
            	    break loop28;
                }
            } while (true);

            otherlv_11=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:1149:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalDataDsl.g:1149:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalDataDsl.g:1150:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalDataDsl.g:1156:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:1162:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalDataDsl.g:1163:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalDataDsl.g:1163:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalDataDsl.g:1164:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalDataDsl.g:1164:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDataDsl.g:1165:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDataDsl.g:1165:4: (lv_name_0_0= RULE_ID )
            // InternalDataDsl.g:1166:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            // InternalDataDsl.g:1182:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDataDsl.g:1183:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_29); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalDataDsl.g:1187:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalDataDsl.g:1188:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalDataDsl.g:1188:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalDataDsl.g:1189:6: lv_initializationValue_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    otherlv_3=(Token)match(input,32,FOLLOW_2); 

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
    // InternalDataDsl.g:1215:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalDataDsl.g:1215:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalDataDsl.g:1216:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalDataDsl.g:1222:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) ;
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
            // InternalDataDsl.g:1228:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? ) )
            // InternalDataDsl.g:1229:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            {
            // InternalDataDsl.g:1229:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )? )
            // InternalDataDsl.g:1230:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )? (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            {
            // InternalDataDsl.g:1230:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDataDsl.g:1231:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalDataDsl.g:1231:4: (lv_hidden_0_0= 'hide' )
                    // InternalDataDsl.g:1232:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,27,FOLLOW_35); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", lv_hidden_0_0 != null, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalDataDsl.g:1244:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==33) ) {
                alt32=1;
            }
            else if ( (LA32_0==34) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDsl.g:1245:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalDataDsl.g:1245:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalDataDsl.g:1246:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalDataDsl.g:1246:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalDataDsl.g:1247:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,33,FOLLOW_11); 

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
                    // InternalDataDsl.g:1260:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    {
                    // InternalDataDsl.g:1260:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )? )
                    // InternalDataDsl.g:1261:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_27); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalDataDsl.g:1265:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) ) )?
                    int alt31=4;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=36 && LA31_0<=46)) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_ID) ) {
                        int LA31_2 = input.LA(2);

                        if ( (LA31_2==35) ) {
                            alt31=3;
                        }
                        else if ( (LA31_2==RULE_ID||LA31_2==47) ) {
                            alt31=2;
                        }
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalDataDsl.g:1266:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalDataDsl.g:1266:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalDataDsl.g:1267:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalDataDsl.g:1267:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalDataDsl.g:1268:8: lv_primitiveReturnType_3_0= rulePrimitiveType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypePrimitiveTypeParserRuleCall_1_1_1_0_0());
                            							
                            pushFollow(FOLLOW_11);
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
                            // InternalDataDsl.g:1286:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalDataDsl.g:1286:6: ( ( ruleQualifiedName ) )
                            // InternalDataDsl.g:1287:7: ( ruleQualifiedName )
                            {
                            // InternalDataDsl.g:1287:7: ( ruleQualifiedName )
                            // InternalDataDsl.g:1288:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getDataOperationRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0());
                            							
                            pushFollow(FOLLOW_11);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalDataDsl.g:1303:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            {
                            // InternalDataDsl.g:1303:6: ( (lv_importedComplexReturnType_5_0= ruleImportedComplexType ) )
                            // InternalDataDsl.g:1304:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            {
                            // InternalDataDsl.g:1304:7: (lv_importedComplexReturnType_5_0= ruleImportedComplexType )
                            // InternalDataDsl.g:1305:8: lv_importedComplexReturnType_5_0= ruleImportedComplexType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeImportedComplexTypeParserRuleCall_1_1_1_2_0());
                            							
                            pushFollow(FOLLOW_11);
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

            // InternalDataDsl.g:1325:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalDataDsl.g:1326:4: (lv_name_6_0= RULE_ID )
            {
            // InternalDataDsl.g:1326:4: (lv_name_6_0= RULE_ID )
            // InternalDataDsl.g:1327:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_36); 

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

            // InternalDataDsl.g:1343:3: (otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==31) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalDataDsl.g:1344:4: otherlv_7= '(' ( (lv_parameters_8_0= ruleDataOperationParameter ) )? (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )* otherlv_11= ')'
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_37); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalDataDsl.g:1348:4: ( (lv_parameters_8_0= ruleDataOperationParameter ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_ID||(LA33_0>=36 && LA33_0<=46)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalDataDsl.g:1349:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            {
                            // InternalDataDsl.g:1349:5: (lv_parameters_8_0= ruleDataOperationParameter )
                            // InternalDataDsl.g:1350:6: lv_parameters_8_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_38);
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

                    // InternalDataDsl.g:1367:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==23) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalDataDsl.g:1368:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_27); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalDataDsl.g:1372:5: ( (lv_parameters_10_0= ruleDataOperationParameter ) )
                    	    // InternalDataDsl.g:1373:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalDataDsl.g:1373:6: (lv_parameters_10_0= ruleDataOperationParameter )
                    	    // InternalDataDsl.g:1374:7: lv_parameters_10_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_38);
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
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,32,FOLLOW_30); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalDataDsl.g:1397:3: (otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==22) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDataDsl.g:1398:4: otherlv_12= '<' ( (lv_features_13_0= ruleDataOperationFeature ) ) (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )* otherlv_16= '>'
                    {
                    otherlv_12=(Token)match(input,22,FOLLOW_39); 

                    				newLeafNode(otherlv_12, grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalDataDsl.g:1402:4: ( (lv_features_13_0= ruleDataOperationFeature ) )
                    // InternalDataDsl.g:1403:5: (lv_features_13_0= ruleDataOperationFeature )
                    {
                    // InternalDataDsl.g:1403:5: (lv_features_13_0= ruleDataOperationFeature )
                    // InternalDataDsl.g:1404:6: lv_features_13_0= ruleDataOperationFeature
                    {

                    						newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalDataDsl.g:1421:4: (otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==23) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalDataDsl.g:1422:5: otherlv_14= ',' ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    {
                    	    otherlv_14=(Token)match(input,23,FOLLOW_39); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalDataDsl.g:1426:5: ( (lv_features_15_0= ruleDataOperationFeature ) )
                    	    // InternalDataDsl.g:1427:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    {
                    	    // InternalDataDsl.g:1427:6: (lv_features_15_0= ruleDataOperationFeature )
                    	    // InternalDataDsl.g:1428:7: lv_features_15_0= ruleDataOperationFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,24,FOLLOW_2); 

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
    // InternalDataDsl.g:1455:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalDataDsl.g:1455:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalDataDsl.g:1456:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalDataDsl.g:1462:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_importedComplexType_2_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:1468:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalDataDsl.g:1469:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalDataDsl.g:1469:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalDataDsl.g:1470:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalDataDsl.g:1470:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedComplexType_2_0= ruleImportedComplexType ) ) )
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=36 && LA38_0<=46)) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_ID) ) {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==35) ) {
                    alt38=3;
                }
                else if ( (LA38_2==RULE_ID||LA38_2==47) ) {
                    alt38=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalDataDsl.g:1471:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalDataDsl.g:1471:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalDataDsl.g:1472:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalDataDsl.g:1472:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalDataDsl.g:1473:6: lv_primitiveType_0_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_11);
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
                    // InternalDataDsl.g:1491:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalDataDsl.g:1491:4: ( ( ruleQualifiedName ) )
                    // InternalDataDsl.g:1492:5: ( ruleQualifiedName )
                    {
                    // InternalDataDsl.g:1492:5: ( ruleQualifiedName )
                    // InternalDataDsl.g:1493:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataOperationParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:1508:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    {
                    // InternalDataDsl.g:1508:4: ( (lv_importedComplexType_2_0= ruleImportedComplexType ) )
                    // InternalDataDsl.g:1509:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    {
                    // InternalDataDsl.g:1509:5: (lv_importedComplexType_2_0= ruleImportedComplexType )
                    // InternalDataDsl.g:1510:6: lv_importedComplexType_2_0= ruleImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_11);
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

            // InternalDataDsl.g:1528:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalDataDsl.g:1529:4: (lv_name_3_0= RULE_ID )
            {
            // InternalDataDsl.g:1529:4: (lv_name_3_0= RULE_ID )
            // InternalDataDsl.g:1530:5: lv_name_3_0= RULE_ID
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
    // InternalDataDsl.g:1550:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalDataDsl.g:1550:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalDataDsl.g:1551:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalDataDsl.g:1557:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1563:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalDataDsl.g:1564:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalDataDsl.g:1564:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt39=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt39=2;
                }
                break;
            case RULE_STRING:
                {
                alt39=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalDataDsl.g:1565:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalDataDsl.g:1565:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalDataDsl.g:1566:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalDataDsl.g:1566:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalDataDsl.g:1567:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalDataDsl.g:1584:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalDataDsl.g:1584:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalDataDsl.g:1585:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalDataDsl.g:1585:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalDataDsl.g:1586:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalDataDsl.g:1603:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalDataDsl.g:1603:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalDataDsl.g:1604:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalDataDsl.g:1604:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalDataDsl.g:1605:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalDataDsl.g:1625:1: entryRuleImportedComplexType returns [EObject current=null] : iv_ruleImportedComplexType= ruleImportedComplexType EOF ;
    public final EObject entryRuleImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedComplexType = null;


        try {
            // InternalDataDsl.g:1625:60: (iv_ruleImportedComplexType= ruleImportedComplexType EOF )
            // InternalDataDsl.g:1626:2: iv_ruleImportedComplexType= ruleImportedComplexType EOF
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
    // InternalDataDsl.g:1632:1: ruleImportedComplexType returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1638:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalDataDsl.g:1639:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalDataDsl.g:1639:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:1640:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:1640:3: ( (otherlv_0= RULE_ID ) )
            // InternalDataDsl.g:1641:4: (otherlv_0= RULE_ID )
            {
            // InternalDataDsl.g:1641:4: (otherlv_0= RULE_ID )
            // InternalDataDsl.g:1642:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportedComplexTypeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_40); 

            					newLeafNode(otherlv_0, grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1());
            		
            // InternalDataDsl.g:1657:3: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:1658:4: ( ruleQualifiedName )
            {
            // InternalDataDsl.g:1658:4: ( ruleQualifiedName )
            // InternalDataDsl.g:1659:5: ruleQualifiedName
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
    // InternalDataDsl.g:1677:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalDataDsl.g:1677:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalDataDsl.g:1678:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalDataDsl.g:1684:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) ;
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
            // InternalDataDsl.g:1690:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) ) )
            // InternalDataDsl.g:1691:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            {
            // InternalDataDsl.g:1691:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) | ( () otherlv_21= 'unspecified' ) )
            int alt40=11;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt40=1;
                }
                break;
            case 37:
                {
                alt40=2;
                }
                break;
            case 38:
                {
                alt40=3;
                }
                break;
            case 39:
                {
                alt40=4;
                }
                break;
            case 40:
                {
                alt40=5;
                }
                break;
            case 41:
                {
                alt40=6;
                }
                break;
            case 42:
                {
                alt40=7;
                }
                break;
            case 43:
                {
                alt40=8;
                }
                break;
            case 44:
                {
                alt40=9;
                }
                break;
            case 45:
                {
                alt40=10;
                }
                break;
            case 46:
                {
                alt40=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalDataDsl.g:1692:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalDataDsl.g:1692:3: ( () otherlv_1= 'boolean' )
                    // InternalDataDsl.g:1693:4: () otherlv_1= 'boolean'
                    {
                    // InternalDataDsl.g:1693:4: ()
                    // InternalDataDsl.g:1694:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:1706:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalDataDsl.g:1706:3: ( () otherlv_3= 'byte' )
                    // InternalDataDsl.g:1707:4: () otherlv_3= 'byte'
                    {
                    // InternalDataDsl.g:1707:4: ()
                    // InternalDataDsl.g:1708:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,37,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:1720:3: ( () otherlv_5= 'char' )
                    {
                    // InternalDataDsl.g:1720:3: ( () otherlv_5= 'char' )
                    // InternalDataDsl.g:1721:4: () otherlv_5= 'char'
                    {
                    // InternalDataDsl.g:1721:4: ()
                    // InternalDataDsl.g:1722:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:1734:3: ( () otherlv_7= 'date' )
                    {
                    // InternalDataDsl.g:1734:3: ( () otherlv_7= 'date' )
                    // InternalDataDsl.g:1735:4: () otherlv_7= 'date'
                    {
                    // InternalDataDsl.g:1735:4: ()
                    // InternalDataDsl.g:1736:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDsl.g:1748:3: ( () otherlv_9= 'double' )
                    {
                    // InternalDataDsl.g:1748:3: ( () otherlv_9= 'double' )
                    // InternalDataDsl.g:1749:4: () otherlv_9= 'double'
                    {
                    // InternalDataDsl.g:1749:4: ()
                    // InternalDataDsl.g:1750:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,40,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDsl.g:1762:3: ( () otherlv_11= 'float' )
                    {
                    // InternalDataDsl.g:1762:3: ( () otherlv_11= 'float' )
                    // InternalDataDsl.g:1763:4: () otherlv_11= 'float'
                    {
                    // InternalDataDsl.g:1763:4: ()
                    // InternalDataDsl.g:1764:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,41,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDsl.g:1776:3: ( () otherlv_13= 'int' )
                    {
                    // InternalDataDsl.g:1776:3: ( () otherlv_13= 'int' )
                    // InternalDataDsl.g:1777:4: () otherlv_13= 'int'
                    {
                    // InternalDataDsl.g:1777:4: ()
                    // InternalDataDsl.g:1778:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,42,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDsl.g:1790:3: ( () otherlv_15= 'long' )
                    {
                    // InternalDataDsl.g:1790:3: ( () otherlv_15= 'long' )
                    // InternalDataDsl.g:1791:4: () otherlv_15= 'long'
                    {
                    // InternalDataDsl.g:1791:4: ()
                    // InternalDataDsl.g:1792:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDsl.g:1804:3: ( () otherlv_17= 'short' )
                    {
                    // InternalDataDsl.g:1804:3: ( () otherlv_17= 'short' )
                    // InternalDataDsl.g:1805:4: () otherlv_17= 'short'
                    {
                    // InternalDataDsl.g:1805:4: ()
                    // InternalDataDsl.g:1806:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,44,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDsl.g:1818:3: ( () otherlv_19= 'string' )
                    {
                    // InternalDataDsl.g:1818:3: ( () otherlv_19= 'string' )
                    // InternalDataDsl.g:1819:4: () otherlv_19= 'string'
                    {
                    // InternalDataDsl.g:1819:4: ()
                    // InternalDataDsl.g:1820:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,45,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDsl.g:1832:3: ( () otherlv_21= 'unspecified' )
                    {
                    // InternalDataDsl.g:1832:3: ( () otherlv_21= 'unspecified' )
                    // InternalDataDsl.g:1833:4: () otherlv_21= 'unspecified'
                    {
                    // InternalDataDsl.g:1833:4: ()
                    // InternalDataDsl.g:1834:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0(),
                    						current);
                    				

                    }

                    otherlv_21=(Token)match(input,46,FOLLOW_2); 

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
    // InternalDataDsl.g:1849:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDataDsl.g:1849:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDataDsl.g:1850:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDataDsl.g:1856:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1862:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDataDsl.g:1863:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDataDsl.g:1863:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDataDsl.g:1864:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalDataDsl.g:1871:3: (kw= '.' this_ID_2= RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==47) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalDataDsl.g:1872:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,47,FOLLOW_11); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_41); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop41;
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


    // $ANTLR start "ruleComplexTypeFeature"
    // InternalDataDsl.g:1889:1: ruleComplexTypeFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) ;
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
            // InternalDataDsl.g:1895:2: ( ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) ) )
            // InternalDataDsl.g:1896:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            {
            // InternalDataDsl.g:1896:2: ( (enumLiteral_0= 'aggregate' ) | (enumLiteral_1= 'applicationService' ) | (enumLiteral_2= 'domainEvent' ) | (enumLiteral_3= 'domainService' ) | (enumLiteral_4= 'entity' ) | (enumLiteral_5= 'factory' ) | (enumLiteral_6= 'infrastructureService' ) | (enumLiteral_7= 'repository' ) | (enumLiteral_8= 'service' ) | (enumLiteral_9= 'specification' ) | (enumLiteral_10= 'valueObject' ) )
            int alt42=11;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt42=1;
                }
                break;
            case 49:
                {
                alt42=2;
                }
                break;
            case 50:
                {
                alt42=3;
                }
                break;
            case 51:
                {
                alt42=4;
                }
                break;
            case 52:
                {
                alt42=5;
                }
                break;
            case 53:
                {
                alt42=6;
                }
                break;
            case 54:
                {
                alt42=7;
                }
                break;
            case 55:
                {
                alt42=8;
                }
                break;
            case 56:
                {
                alt42=9;
                }
                break;
            case 57:
                {
                alt42=10;
                }
                break;
            case 58:
                {
                alt42=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalDataDsl.g:1897:3: (enumLiteral_0= 'aggregate' )
                    {
                    // InternalDataDsl.g:1897:3: (enumLiteral_0= 'aggregate' )
                    // InternalDataDsl.g:1898:4: enumLiteral_0= 'aggregate'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:1905:3: (enumLiteral_1= 'applicationService' )
                    {
                    // InternalDataDsl.g:1905:3: (enumLiteral_1= 'applicationService' )
                    // InternalDataDsl.g:1906:4: enumLiteral_1= 'applicationService'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:1913:3: (enumLiteral_2= 'domainEvent' )
                    {
                    // InternalDataDsl.g:1913:3: (enumLiteral_2= 'domainEvent' )
                    // InternalDataDsl.g:1914:4: enumLiteral_2= 'domainEvent'
                    {
                    enumLiteral_2=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:1921:3: (enumLiteral_3= 'domainService' )
                    {
                    // InternalDataDsl.g:1921:3: (enumLiteral_3= 'domainService' )
                    // InternalDataDsl.g:1922:4: enumLiteral_3= 'domainService'
                    {
                    enumLiteral_3=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDsl.g:1929:3: (enumLiteral_4= 'entity' )
                    {
                    // InternalDataDsl.g:1929:3: (enumLiteral_4= 'entity' )
                    // InternalDataDsl.g:1930:4: enumLiteral_4= 'entity'
                    {
                    enumLiteral_4=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDsl.g:1937:3: (enumLiteral_5= 'factory' )
                    {
                    // InternalDataDsl.g:1937:3: (enumLiteral_5= 'factory' )
                    // InternalDataDsl.g:1938:4: enumLiteral_5= 'factory'
                    {
                    enumLiteral_5=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDsl.g:1945:3: (enumLiteral_6= 'infrastructureService' )
                    {
                    // InternalDataDsl.g:1945:3: (enumLiteral_6= 'infrastructureService' )
                    // InternalDataDsl.g:1946:4: enumLiteral_6= 'infrastructureService'
                    {
                    enumLiteral_6=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDsl.g:1953:3: (enumLiteral_7= 'repository' )
                    {
                    // InternalDataDsl.g:1953:3: (enumLiteral_7= 'repository' )
                    // InternalDataDsl.g:1954:4: enumLiteral_7= 'repository'
                    {
                    enumLiteral_7=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDsl.g:1961:3: (enumLiteral_8= 'service' )
                    {
                    // InternalDataDsl.g:1961:3: (enumLiteral_8= 'service' )
                    // InternalDataDsl.g:1962:4: enumLiteral_8= 'service'
                    {
                    enumLiteral_8=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDsl.g:1969:3: (enumLiteral_9= 'specification' )
                    {
                    // InternalDataDsl.g:1969:3: (enumLiteral_9= 'specification' )
                    // InternalDataDsl.g:1970:4: enumLiteral_9= 'specification'
                    {
                    enumLiteral_9=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDsl.g:1977:3: (enumLiteral_10= 'valueObject' )
                    {
                    // InternalDataDsl.g:1977:3: (enumLiteral_10= 'valueObject' )
                    // InternalDataDsl.g:1978:4: enumLiteral_10= 'valueObject'
                    {
                    enumLiteral_10=(Token)match(input,58,FOLLOW_2); 

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
    // InternalDataDsl.g:1988:1: ruleDataFieldFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) ;
    public final Enumerator ruleDataFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1994:2: ( ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) ) )
            // InternalDataDsl.g:1995:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            {
            // InternalDataDsl.g:1995:2: ( (enumLiteral_0= 'identifier' ) | (enumLiteral_1= 'neverEmpty' ) | (enumLiteral_2= 'part' ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt43=1;
                }
                break;
            case 60:
                {
                alt43=2;
                }
                break;
            case 61:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalDataDsl.g:1996:3: (enumLiteral_0= 'identifier' )
                    {
                    // InternalDataDsl.g:1996:3: (enumLiteral_0= 'identifier' )
                    // InternalDataDsl.g:1997:4: enumLiteral_0= 'identifier'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:2004:3: (enumLiteral_1= 'neverEmpty' )
                    {
                    // InternalDataDsl.g:2004:3: (enumLiteral_1= 'neverEmpty' )
                    // InternalDataDsl.g:2005:4: enumLiteral_1= 'neverEmpty'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:2012:3: (enumLiteral_2= 'part' )
                    {
                    // InternalDataDsl.g:2012:3: (enumLiteral_2= 'part' )
                    // InternalDataDsl.g:2013:4: enumLiteral_2= 'part'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_2); 

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
    // InternalDataDsl.g:2023:1: ruleDataOperationFeature returns [Enumerator current=null] : ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) ;
    public final Enumerator ruleDataOperationFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDataDsl.g:2029:2: ( ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) ) )
            // InternalDataDsl.g:2030:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            {
            // InternalDataDsl.g:2030:2: ( (enumLiteral_0= 'closure' ) | (enumLiteral_1= 'identifier' ) | (enumLiteral_2= 'sideEffectFree' ) | (enumLiteral_3= 'validator' ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt44=1;
                }
                break;
            case 59:
                {
                alt44=2;
                }
                break;
            case 63:
                {
                alt44=3;
                }
                break;
            case 64:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalDataDsl.g:2031:3: (enumLiteral_0= 'closure' )
                    {
                    // InternalDataDsl.g:2031:3: (enumLiteral_0= 'closure' )
                    // InternalDataDsl.g:2032:4: enumLiteral_0= 'closure'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:2039:3: (enumLiteral_1= 'identifier' )
                    {
                    // InternalDataDsl.g:2039:3: (enumLiteral_1= 'identifier' )
                    // InternalDataDsl.g:2040:4: enumLiteral_1= 'identifier'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:2047:3: (enumLiteral_2= 'sideEffectFree' )
                    {
                    // InternalDataDsl.g:2047:3: (enumLiteral_2= 'sideEffectFree' )
                    // InternalDataDsl.g:2048:4: enumLiteral_2= 'sideEffectFree'
                    {
                    enumLiteral_2=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:2055:3: (enumLiteral_3= 'validator' )
                    {
                    // InternalDataDsl.g:2055:3: (enumLiteral_3= 'validator' )
                    // InternalDataDsl.g:2056:4: enumLiteral_3= 'validator'
                    {
                    enumLiteral_3=(Token)match(input,64,FOLLOW_2); 

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


    protected DFA19 dfa19 = new DFA19(this);
    static final String dfa_1s = "\21\uffff";
    static final String dfa_2s = "\1\32\1\5\1\22\1\5\1\uffff\13\5\1\uffff";
    static final String dfa_3s = "\1\32\1\5\1\22\1\56\1\uffff\13\23\1\uffff";
    static final String dfa_4s = "\4\uffff\1\1\13\uffff\1\2";
    static final String dfa_5s = "\21\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\25\uffff\2\4\7\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17",
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

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "667:2: ( (otherlv_0= 'collection' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'collection' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000044322000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000044320002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000443A0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000044320000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002440000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x07FF000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00007FF618080020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00007FF618000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00007FF018000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00007FF000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00007FF010000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00007FF000000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020400002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x3800000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000080400002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00007FF100800020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100800000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xC800000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000800000000002L});

}