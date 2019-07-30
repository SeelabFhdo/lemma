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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'datatypes'", "'from'", "'as'", "'version'", "'{'", "'}'", "'context'", "'structure'", "'extends'", "','", "'list'", "'hide'", "'<'", "'>'", "'enum'", "'('", "')'", "'procedure'", "'function'", "'::'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'derived'"
    };
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
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
    public static final int T__20=20;
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
    public static final int T__44=44;
    public static final int T__45=45;
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
            case 24:
            case 28:
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

                        if ( (LA4_0==21||LA4_0==24||LA4_0==28) ) {
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

            if ( (LA8_0==21||LA8_0==24||LA8_0==28) ) {
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

                        if ( (LA6_0==21||LA6_0==24||LA6_0==28) ) {
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

                if ( (LA9_0==21||LA9_0==24||LA9_0==28) ) {
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
    // InternalDataDsl.g:400:1: ruleComplexType returns [EObject current=null] : (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataStructure_0 = null;

        EObject this_ListType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:406:2: ( (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration ) )
            // InternalDataDsl.g:407:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalDataDsl.g:407:2: (this_DataStructure_0= ruleDataStructure | this_ListType_1= ruleListType | this_Enumeration_2= ruleEnumeration )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt10=1;
                }
                break;
            case 24:
                {
                alt10=2;
                }
                break;
            case 28:
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
                    // InternalDataDsl.g:417:3: this_ListType_1= ruleListType
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
    // InternalDataDsl.g:445:1: ruleDataStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )? otherlv_18= '}' ) ;
    public final EObject ruleDataStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_dataFields_5_0 = null;

        EObject lv_dataFields_7_0 = null;

        EObject lv_operations_8_0 = null;

        EObject lv_operations_10_0 = null;

        EObject lv_dataFields_11_0 = null;

        EObject lv_dataFields_13_0 = null;

        EObject lv_operations_15_0 = null;

        EObject lv_operations_17_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:451:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )? otherlv_18= '}' ) )
            // InternalDataDsl.g:452:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )? otherlv_18= '}' )
            {
            // InternalDataDsl.g:452:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )? otherlv_18= '}' )
            // InternalDataDsl.g:453:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )? otherlv_18= '}'
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

            // InternalDataDsl.g:475:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDataDsl.g:476:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0());
                    			
                    // InternalDataDsl.g:480:4: ( ( ruleQualifiedName ) )
                    // InternalDataDsl.g:481:5: ( ruleQualifiedName )
                    {
                    // InternalDataDsl.g:481:5: ( ruleQualifiedName )
                    // InternalDataDsl.g:482:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataStructureRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalDataDsl.g:501:3: ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )?
            int alt16=4;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalDataDsl.g:502:4: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )
                    {
                    // InternalDataDsl.g:502:4: ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* )
                    // InternalDataDsl.g:503:5: ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    {
                    // InternalDataDsl.g:503:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    // InternalDataDsl.g:504:6: (lv_dataFields_5_0= ruleDataField )
                    {
                    // InternalDataDsl.g:504:6: (lv_dataFields_5_0= ruleDataField )
                    // InternalDataDsl.g:505:7: lv_dataFields_5_0= ruleDataField
                    {

                    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0_0());
                    						
                    pushFollow(FOLLOW_18);
                    lv_dataFields_5_0=ruleDataField();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    							}
                    							add(
                    								current,
                    								"dataFields",
                    								lv_dataFields_5_0,
                    								"de.fhdo.lemma.data.DataDsl.DataField");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalDataDsl.g:522:5: (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==23) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalDataDsl.g:523:6: otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_19); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getDataStructureAccess().getCommaKeyword_4_0_1_0());
                    	    					
                    	    // InternalDataDsl.g:527:6: ( (lv_dataFields_7_0= ruleDataField ) )
                    	    // InternalDataDsl.g:528:7: (lv_dataFields_7_0= ruleDataField )
                    	    {
                    	    // InternalDataDsl.g:528:7: (lv_dataFields_7_0= ruleDataField )
                    	    // InternalDataDsl.g:529:8: lv_dataFields_7_0= ruleDataField
                    	    {

                    	    								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_18);
                    	    lv_dataFields_7_0=ruleDataField();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"dataFields",
                    	    									lv_dataFields_7_0,
                    	    									"de.fhdo.lemma.data.DataDsl.DataField");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:549:4: ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* )
                    {
                    // InternalDataDsl.g:549:4: ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* )
                    // InternalDataDsl.g:550:5: ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )*
                    {
                    // InternalDataDsl.g:550:5: ( (lv_operations_8_0= ruleDataOperation ) )
                    // InternalDataDsl.g:551:6: (lv_operations_8_0= ruleDataOperation )
                    {
                    // InternalDataDsl.g:551:6: (lv_operations_8_0= ruleDataOperation )
                    // InternalDataDsl.g:552:7: lv_operations_8_0= ruleDataOperation
                    {

                    							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_1_0_0());
                    						
                    pushFollow(FOLLOW_18);
                    lv_operations_8_0=ruleDataOperation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    							}
                    							add(
                    								current,
                    								"operations",
                    								lv_operations_8_0,
                    								"de.fhdo.lemma.data.DataDsl.DataOperation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalDataDsl.g:569:5: (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==23) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalDataDsl.g:570:6: otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_20); 

                    	    						newLeafNode(otherlv_9, grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_1_0());
                    	    					
                    	    // InternalDataDsl.g:574:6: ( (lv_operations_10_0= ruleDataOperation ) )
                    	    // InternalDataDsl.g:575:7: (lv_operations_10_0= ruleDataOperation )
                    	    {
                    	    // InternalDataDsl.g:575:7: (lv_operations_10_0= ruleDataOperation )
                    	    // InternalDataDsl.g:576:8: lv_operations_10_0= ruleDataOperation
                    	    {

                    	    								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_18);
                    	    lv_operations_10_0=ruleDataOperation();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"operations",
                    	    									lv_operations_10_0,
                    	    									"de.fhdo.lemma.data.DataDsl.DataOperation");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:596:4: ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* )
                    {
                    // InternalDataDsl.g:596:4: ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* )
                    // InternalDataDsl.g:597:5: ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )*
                    {
                    // InternalDataDsl.g:597:5: ( (lv_dataFields_11_0= ruleDataField ) )
                    // InternalDataDsl.g:598:6: (lv_dataFields_11_0= ruleDataField )
                    {
                    // InternalDataDsl.g:598:6: (lv_dataFields_11_0= ruleDataField )
                    // InternalDataDsl.g:599:7: lv_dataFields_11_0= ruleDataField
                    {

                    							newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_2_0_0());
                    						
                    pushFollow(FOLLOW_21);
                    lv_dataFields_11_0=ruleDataField();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    							}
                    							add(
                    								current,
                    								"dataFields",
                    								lv_dataFields_11_0,
                    								"de.fhdo.lemma.data.DataDsl.DataField");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalDataDsl.g:616:5: (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==23) ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1==25) ) {
                                int LA14_2 = input.LA(3);

                                if ( (LA14_2==RULE_ID||(LA14_2>=34 && LA14_2<=43)) ) {
                                    alt14=1;
                                }


                            }
                            else if ( (LA14_1==RULE_ID||(LA14_1>=34 && LA14_1<=43)) ) {
                                alt14=1;
                            }


                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalDataDsl.g:617:6: otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_19); 

                    	    						newLeafNode(otherlv_12, grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_1_0());
                    	    					
                    	    // InternalDataDsl.g:621:6: ( (lv_dataFields_13_0= ruleDataField ) )
                    	    // InternalDataDsl.g:622:7: (lv_dataFields_13_0= ruleDataField )
                    	    {
                    	    // InternalDataDsl.g:622:7: (lv_dataFields_13_0= ruleDataField )
                    	    // InternalDataDsl.g:623:8: lv_dataFields_13_0= ruleDataField
                    	    {

                    	    								newCompositeNode(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_2_1_1_0());
                    	    							
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

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,23,FOLLOW_20); 

                    					newLeafNode(otherlv_14, grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_2());
                    				
                    // InternalDataDsl.g:645:5: ( (lv_operations_15_0= ruleDataOperation ) )
                    // InternalDataDsl.g:646:6: (lv_operations_15_0= ruleDataOperation )
                    {
                    // InternalDataDsl.g:646:6: (lv_operations_15_0= ruleDataOperation )
                    // InternalDataDsl.g:647:7: lv_operations_15_0= ruleDataOperation
                    {

                    							newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_2_3_0());
                    						
                    pushFollow(FOLLOW_18);
                    lv_operations_15_0=ruleDataOperation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    							}
                    							add(
                    								current,
                    								"operations",
                    								lv_operations_15_0,
                    								"de.fhdo.lemma.data.DataDsl.DataOperation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalDataDsl.g:664:5: (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==23) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalDataDsl.g:665:6: otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_20); 

                    	    						newLeafNode(otherlv_16, grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_4_0());
                    	    					
                    	    // InternalDataDsl.g:669:6: ( (lv_operations_17_0= ruleDataOperation ) )
                    	    // InternalDataDsl.g:670:7: (lv_operations_17_0= ruleDataOperation )
                    	    {
                    	    // InternalDataDsl.g:670:7: (lv_operations_17_0= ruleDataOperation )
                    	    // InternalDataDsl.g:671:8: lv_operations_17_0= ruleDataOperation
                    	    {

                    	    								newCompositeNode(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_2_4_1_0());
                    	    							
                    	    pushFollow(FOLLOW_18);
                    	    lv_operations_17_0=ruleDataOperation();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getDataStructureRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"operations",
                    	    									lv_operations_17_0,
                    	    									"de.fhdo.lemma.data.DataDsl.DataOperation");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_18=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalDataDsl.g:699:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalDataDsl.g:699:49: (iv_ruleListType= ruleListType EOF )
            // InternalDataDsl.g:700:2: iv_ruleListType= ruleListType EOF
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
    // InternalDataDsl.g:706:1: ruleListType returns [EObject current=null] : ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) ;
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
            // InternalDataDsl.g:712:2: ( ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) ) )
            // InternalDataDsl.g:713:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            {
            // InternalDataDsl.g:713:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalDataDsl.g:714:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    {
                    // InternalDataDsl.g:714:3: (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' )
                    // InternalDataDsl.g:715:4: otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0_0());
                    			
                    // InternalDataDsl.g:719:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalDataDsl.g:720:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalDataDsl.g:720:5: (lv_name_1_0= RULE_ID )
                    // InternalDataDsl.g:721:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

                    otherlv_2=(Token)match(input,18,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalDataDsl.g:741:4: ( (lv_dataFields_3_0= ruleDataField ) )
                    // InternalDataDsl.g:742:5: (lv_dataFields_3_0= ruleDataField )
                    {
                    // InternalDataDsl.g:742:5: (lv_dataFields_3_0= ruleDataField )
                    // InternalDataDsl.g:743:6: lv_dataFields_3_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalDataDsl.g:760:4: (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==23) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalDataDsl.g:761:5: otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_19); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0());
                    	    				
                    	    // InternalDataDsl.g:765:5: ( (lv_dataFields_5_0= ruleDataField ) )
                    	    // InternalDataDsl.g:766:6: (lv_dataFields_5_0= ruleDataField )
                    	    {
                    	    // InternalDataDsl.g:766:6: (lv_dataFields_5_0= ruleDataField )
                    	    // InternalDataDsl.g:767:7: lv_dataFields_5_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:791:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    {
                    // InternalDataDsl.g:791:3: (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' )
                    // InternalDataDsl.g:792:4: otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getListTypeAccess().getListKeyword_1_0());
                    			
                    // InternalDataDsl.g:796:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalDataDsl.g:797:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalDataDsl.g:797:5: (lv_name_8_0= RULE_ID )
                    // InternalDataDsl.g:798:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

                    otherlv_9=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_9, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalDataDsl.g:818:4: ( (lv_primitiveType_10_0= rulePrimitiveType ) )
                    // InternalDataDsl.g:819:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    {
                    // InternalDataDsl.g:819:5: (lv_primitiveType_10_0= rulePrimitiveType )
                    // InternalDataDsl.g:820:6: lv_primitiveType_10_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_23);
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

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:846:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalDataDsl.g:846:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalDataDsl.g:847:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalDataDsl.g:853:1: ruleDataField returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_primitiveType_1_0 = null;

        EObject lv_complexType_2_0 = null;

        Enumerator lv_features_5_0 = null;

        Enumerator lv_features_7_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:859:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? ) )
            // InternalDataDsl.g:860:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? )
            {
            // InternalDataDsl.g:860:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )? )
            // InternalDataDsl.g:861:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )?
            {
            // InternalDataDsl.g:861:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDataDsl.g:862:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalDataDsl.g:862:4: (lv_hidden_0_0= 'hide' )
                    // InternalDataDsl.g:863:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,25,FOLLOW_24); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataFieldRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalDataDsl.g:875:3: ( ( (lv_primitiveType_1_0= rulePrimitiveType ) ) | ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) ) )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=34 && LA20_0<=43)) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==RULE_ID||LA20_2==33||LA20_2==44) ) {
                    alt20=2;
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalDataDsl.g:876:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    {
                    // InternalDataDsl.g:876:4: ( (lv_primitiveType_1_0= rulePrimitiveType ) )
                    // InternalDataDsl.g:877:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    {
                    // InternalDataDsl.g:877:5: (lv_primitiveType_1_0= rulePrimitiveType )
                    // InternalDataDsl.g:878:6: lv_primitiveType_1_0= rulePrimitiveType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_primitiveType_1_0=rulePrimitiveType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"primitiveType",
                    							lv_primitiveType_1_0,
                    							"de.fhdo.lemma.data.DataDsl.PrimitiveType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:896:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalDataDsl.g:896:4: ( (lv_complexType_2_0= rulePossiblyImportedComplexType ) )
                    // InternalDataDsl.g:897:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    {
                    // InternalDataDsl.g:897:5: (lv_complexType_2_0= rulePossiblyImportedComplexType )
                    // InternalDataDsl.g:898:6: lv_complexType_2_0= rulePossiblyImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_complexType_2_0=rulePossiblyImportedComplexType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						set(
                    							current,
                    							"complexType",
                    							lv_complexType_2_0,
                    							"de.fhdo.lemma.data.DataDsl.PossiblyImportedComplexType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalDataDsl.g:916:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalDataDsl.g:917:4: (lv_name_3_0= RULE_ID )
            {
            // InternalDataDsl.g:917:4: (lv_name_3_0= RULE_ID )
            // InternalDataDsl.g:918:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_25); 

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

            // InternalDataDsl.g:934:3: (otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDsl.g:935:4: otherlv_4= '<' ( (lv_features_5_0= ruleFieldFeature ) ) (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_26); 

                    				newLeafNode(otherlv_4, grammarAccess.getDataFieldAccess().getLessThanSignKeyword_3_0());
                    			
                    // InternalDataDsl.g:939:4: ( (lv_features_5_0= ruleFieldFeature ) )
                    // InternalDataDsl.g:940:5: (lv_features_5_0= ruleFieldFeature )
                    {
                    // InternalDataDsl.g:940:5: (lv_features_5_0= ruleFieldFeature )
                    // InternalDataDsl.g:941:6: lv_features_5_0= ruleFieldFeature
                    {

                    						newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_features_5_0=ruleFieldFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    						}
                    						add(
                    							current,
                    							"features",
                    							lv_features_5_0,
                    							"de.fhdo.lemma.data.DataDsl.FieldFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDataDsl.g:958:4: (otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==23) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalDataDsl.g:959:5: otherlv_6= ',' ( (lv_features_7_0= ruleFieldFeature ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_26); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDataFieldAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalDataDsl.g:963:5: ( (lv_features_7_0= ruleFieldFeature ) )
                    	    // InternalDataDsl.g:964:6: (lv_features_7_0= ruleFieldFeature )
                    	    {
                    	    // InternalDataDsl.g:964:6: (lv_features_7_0= ruleFieldFeature )
                    	    // InternalDataDsl.g:965:7: lv_features_7_0= ruleFieldFeature
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_27);
                    	    lv_features_7_0=ruleFieldFeature();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataFieldRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"features",
                    	    								lv_features_7_0,
                    	    								"de.fhdo.lemma.data.DataDsl.FieldFeature");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_3_3());
                    			

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
    // InternalDataDsl.g:992:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalDataDsl.g:992:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalDataDsl.g:993:2: iv_ruleEnumeration= ruleEnumeration EOF
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
    // InternalDataDsl.g:999:1: ruleEnumeration returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) ;
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
            // InternalDataDsl.g:1005:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' ) )
            // InternalDataDsl.g:1006:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            {
            // InternalDataDsl.g:1006:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}' )
            // InternalDataDsl.g:1007:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleEnumerationField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationAccess().getEnumKeyword_0());
            		
            // InternalDataDsl.g:1011:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDataDsl.g:1012:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDataDsl.g:1012:4: (lv_name_1_0= RULE_ID )
            // InternalDataDsl.g:1013:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDataDsl.g:1033:3: ( (lv_fields_3_0= ruleEnumerationField ) )
            // InternalDataDsl.g:1034:4: (lv_fields_3_0= ruleEnumerationField )
            {
            // InternalDataDsl.g:1034:4: (lv_fields_3_0= ruleEnumerationField )
            // InternalDataDsl.g:1035:5: lv_fields_3_0= ruleEnumerationField
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_18);
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

            // InternalDataDsl.g:1052:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==23) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDsl.g:1053:4: otherlv_4= ',' ( (lv_fields_5_0= ruleEnumerationField ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_11); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalDataDsl.g:1057:4: ( (lv_fields_5_0= ruleEnumerationField ) )
            	    // InternalDataDsl.g:1058:5: (lv_fields_5_0= ruleEnumerationField )
            	    {
            	    // InternalDataDsl.g:1058:5: (lv_fields_5_0= ruleEnumerationField )
            	    // InternalDataDsl.g:1059:6: lv_fields_5_0= ruleEnumerationField
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_18);
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
            	    break loop23;
                }
            } while (true);

            otherlv_6=(Token)match(input,19,FOLLOW_2); 

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
    // InternalDataDsl.g:1085:1: entryRuleEnumerationField returns [EObject current=null] : iv_ruleEnumerationField= ruleEnumerationField EOF ;
    public final EObject entryRuleEnumerationField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationField = null;


        try {
            // InternalDataDsl.g:1085:57: (iv_ruleEnumerationField= ruleEnumerationField EOF )
            // InternalDataDsl.g:1086:2: iv_ruleEnumerationField= ruleEnumerationField EOF
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
    // InternalDataDsl.g:1092:1: ruleEnumerationField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleEnumerationField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_initializationValue_2_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:1098:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? ) )
            // InternalDataDsl.g:1099:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            {
            // InternalDataDsl.g:1099:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )? )
            // InternalDataDsl.g:1100:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            {
            // InternalDataDsl.g:1100:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDataDsl.g:1101:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDataDsl.g:1101:4: (lv_name_0_0= RULE_ID )
            // InternalDataDsl.g:1102:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

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

            // InternalDataDsl.g:1118:3: (otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDsl.g:1119:4: otherlv_1= '(' ( (lv_initializationValue_2_0= rulePrimitiveValue ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalDataDsl.g:1123:4: ( (lv_initializationValue_2_0= rulePrimitiveValue ) )
                    // InternalDataDsl.g:1124:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    {
                    // InternalDataDsl.g:1124:5: (lv_initializationValue_2_0= rulePrimitiveValue )
                    // InternalDataDsl.g:1125:6: lv_initializationValue_2_0= rulePrimitiveValue
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

                    otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // InternalDataDsl.g:1151:1: entryRuleDataOperation returns [EObject current=null] : iv_ruleDataOperation= ruleDataOperation EOF ;
    public final EObject entryRuleDataOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperation = null;


        try {
            // InternalDataDsl.g:1151:54: (iv_ruleDataOperation= ruleDataOperation EOF )
            // InternalDataDsl.g:1152:2: iv_ruleDataOperation= ruleDataOperation EOF
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
    // InternalDataDsl.g:1158:1: ruleDataOperation returns [EObject current=null] : ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? ) ) ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')' )? ) ;
    public final EObject ruleDataOperation() throws RecognitionException {
        EObject current = null;

        Token lv_hidden_0_0=null;
        Token lv_hasNoReturnType_1_0=null;
        Token otherlv_2=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_primitiveReturnType_3_0 = null;

        EObject lv_complexReturnType_4_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_9_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:1164:2: ( ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? ) ) ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')' )? ) )
            // InternalDataDsl.g:1165:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? ) ) ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')' )? )
            {
            // InternalDataDsl.g:1165:2: ( ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? ) ) ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')' )? )
            // InternalDataDsl.g:1166:3: ( (lv_hidden_0_0= 'hide' ) )? ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? ) ) ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')' )?
            {
            // InternalDataDsl.g:1166:3: ( (lv_hidden_0_0= 'hide' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==25) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDsl.g:1167:4: (lv_hidden_0_0= 'hide' )
                    {
                    // InternalDataDsl.g:1167:4: (lv_hidden_0_0= 'hide' )
                    // InternalDataDsl.g:1168:5: lv_hidden_0_0= 'hide'
                    {
                    lv_hidden_0_0=(Token)match(input,25,FOLLOW_31); 

                    					newLeafNode(lv_hidden_0_0, grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataOperationRule());
                    					}
                    					setWithLastConsumed(current, "hidden", true, "hide");
                    				

                    }


                    }
                    break;

            }

            // InternalDataDsl.g:1180:3: ( ( (lv_hasNoReturnType_1_0= 'procedure' ) ) | (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==31) ) {
                alt27=1;
            }
            else if ( (LA27_0==32) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDsl.g:1181:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    {
                    // InternalDataDsl.g:1181:4: ( (lv_hasNoReturnType_1_0= 'procedure' ) )
                    // InternalDataDsl.g:1182:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    {
                    // InternalDataDsl.g:1182:5: (lv_hasNoReturnType_1_0= 'procedure' )
                    // InternalDataDsl.g:1183:6: lv_hasNoReturnType_1_0= 'procedure'
                    {
                    lv_hasNoReturnType_1_0=(Token)match(input,31,FOLLOW_11); 

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
                    // InternalDataDsl.g:1196:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? )
                    {
                    // InternalDataDsl.g:1196:4: (otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )? )
                    // InternalDataDsl.g:1197:5: otherlv_2= 'function' ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_24); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0());
                    				
                    // InternalDataDsl.g:1201:5: ( ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) ) | ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) ) )?
                    int alt26=3;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=34 && LA26_0<=43)) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_ID) ) {
                        int LA26_2 = input.LA(2);

                        if ( (LA26_2==RULE_ID||LA26_2==33||LA26_2==44) ) {
                            alt26=2;
                        }
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalDataDsl.g:1202:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            {
                            // InternalDataDsl.g:1202:6: ( (lv_primitiveReturnType_3_0= rulePrimitiveType ) )
                            // InternalDataDsl.g:1203:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            {
                            // InternalDataDsl.g:1203:7: (lv_primitiveReturnType_3_0= rulePrimitiveType )
                            // InternalDataDsl.g:1204:8: lv_primitiveReturnType_3_0= rulePrimitiveType
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
                            // InternalDataDsl.g:1222:6: ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) )
                            {
                            // InternalDataDsl.g:1222:6: ( (lv_complexReturnType_4_0= rulePossiblyImportedComplexType ) )
                            // InternalDataDsl.g:1223:7: (lv_complexReturnType_4_0= rulePossiblyImportedComplexType )
                            {
                            // InternalDataDsl.g:1223:7: (lv_complexReturnType_4_0= rulePossiblyImportedComplexType )
                            // InternalDataDsl.g:1224:8: lv_complexReturnType_4_0= rulePossiblyImportedComplexType
                            {

                            								newCompositeNode(grammarAccess.getDataOperationAccess().getComplexReturnTypePossiblyImportedComplexTypeParserRuleCall_1_1_1_1_0());
                            							
                            pushFollow(FOLLOW_11);
                            lv_complexReturnType_4_0=rulePossiblyImportedComplexType();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getDataOperationRule());
                            								}
                            								set(
                            									current,
                            									"complexReturnType",
                            									lv_complexReturnType_4_0,
                            									"de.fhdo.lemma.data.DataDsl.PossiblyImportedComplexType");
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

            // InternalDataDsl.g:1244:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalDataDsl.g:1245:4: (lv_name_5_0= RULE_ID )
            {
            // InternalDataDsl.g:1245:4: (lv_name_5_0= RULE_ID )
            // InternalDataDsl.g:1246:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_5_0, grammarAccess.getDataOperationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDataDsl.g:1262:3: (otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDataDsl.g:1263:4: otherlv_6= '(' ( (lv_parameters_7_0= ruleDataOperationParameter ) )? (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )* otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_32); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalDataDsl.g:1267:4: ( (lv_parameters_7_0= ruleDataOperationParameter ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_ID||(LA28_0>=34 && LA28_0<=43)) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalDataDsl.g:1268:5: (lv_parameters_7_0= ruleDataOperationParameter )
                            {
                            // InternalDataDsl.g:1268:5: (lv_parameters_7_0= ruleDataOperationParameter )
                            // InternalDataDsl.g:1269:6: lv_parameters_7_0= ruleDataOperationParameter
                            {

                            						newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_33);
                            lv_parameters_7_0=ruleDataOperationParameter();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getDataOperationRule());
                            						}
                            						add(
                            							current,
                            							"parameters",
                            							lv_parameters_7_0,
                            							"de.fhdo.lemma.data.DataDsl.DataOperationParameter");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalDataDsl.g:1286:4: (otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==23) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalDataDsl.g:1287:5: otherlv_8= ',' ( (lv_parameters_9_0= ruleDataOperationParameter ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_24); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalDataDsl.g:1291:5: ( (lv_parameters_9_0= ruleDataOperationParameter ) )
                    	    // InternalDataDsl.g:1292:6: (lv_parameters_9_0= ruleDataOperationParameter )
                    	    {
                    	    // InternalDataDsl.g:1292:6: (lv_parameters_9_0= ruleDataOperationParameter )
                    	    // InternalDataDsl.g:1293:7: lv_parameters_9_0= ruleDataOperationParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_33);
                    	    lv_parameters_9_0=ruleDataOperationParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataOperationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_9_0,
                    	    								"de.fhdo.lemma.data.DataDsl.DataOperationParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,30,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3());
                    			

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
    // InternalDataDsl.g:1320:1: entryRuleDataOperationParameter returns [EObject current=null] : iv_ruleDataOperationParameter= ruleDataOperationParameter EOF ;
    public final EObject entryRuleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataOperationParameter = null;


        try {
            // InternalDataDsl.g:1320:63: (iv_ruleDataOperationParameter= ruleDataOperationParameter EOF )
            // InternalDataDsl.g:1321:2: iv_ruleDataOperationParameter= ruleDataOperationParameter EOF
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
    // InternalDataDsl.g:1327:1: ruleDataOperationParameter returns [EObject current=null] : ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleDataOperationParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_primitiveType_0_0 = null;

        EObject lv_complexType_1_0 = null;



        	enterRule();

        try {
            // InternalDataDsl.g:1333:2: ( ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalDataDsl.g:1334:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalDataDsl.g:1334:2: ( ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // InternalDataDsl.g:1335:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalDataDsl.g:1335:3: ( ( (lv_primitiveType_0_0= rulePrimitiveType ) ) | ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=34 && LA31_0<=43)) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_ID) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDsl.g:1336:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    {
                    // InternalDataDsl.g:1336:4: ( (lv_primitiveType_0_0= rulePrimitiveType ) )
                    // InternalDataDsl.g:1337:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    {
                    // InternalDataDsl.g:1337:5: (lv_primitiveType_0_0= rulePrimitiveType )
                    // InternalDataDsl.g:1338:6: lv_primitiveType_0_0= rulePrimitiveType
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
                    // InternalDataDsl.g:1356:4: ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) )
                    {
                    // InternalDataDsl.g:1356:4: ( (lv_complexType_1_0= rulePossiblyImportedComplexType ) )
                    // InternalDataDsl.g:1357:5: (lv_complexType_1_0= rulePossiblyImportedComplexType )
                    {
                    // InternalDataDsl.g:1357:5: (lv_complexType_1_0= rulePossiblyImportedComplexType )
                    // InternalDataDsl.g:1358:6: lv_complexType_1_0= rulePossiblyImportedComplexType
                    {

                    						newCompositeNode(grammarAccess.getDataOperationParameterAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_complexType_1_0=rulePossiblyImportedComplexType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataOperationParameterRule());
                    						}
                    						set(
                    							current,
                    							"complexType",
                    							lv_complexType_1_0,
                    							"de.fhdo.lemma.data.DataDsl.PossiblyImportedComplexType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalDataDsl.g:1376:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDataDsl.g:1377:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDataDsl.g:1377:4: (lv_name_2_0= RULE_ID )
            // InternalDataDsl.g:1378:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getDataOperationParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataOperationParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
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
    // InternalDataDsl.g:1398:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalDataDsl.g:1398:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalDataDsl.g:1399:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalDataDsl.g:1405:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_numericValue_0_0=null;
        Token lv_booleanValue_1_0=null;
        Token lv_stringValue_2_0=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1411:2: ( ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) ) )
            // InternalDataDsl.g:1412:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            {
            // InternalDataDsl.g:1412:2: ( ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) ) | ( (lv_booleanValue_1_0= RULE_BOOLEAN ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt32=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt32=2;
                }
                break;
            case RULE_STRING:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalDataDsl.g:1413:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    {
                    // InternalDataDsl.g:1413:3: ( (lv_numericValue_0_0= RULE_BIG_DECIMAL ) )
                    // InternalDataDsl.g:1414:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    {
                    // InternalDataDsl.g:1414:4: (lv_numericValue_0_0= RULE_BIG_DECIMAL )
                    // InternalDataDsl.g:1415:5: lv_numericValue_0_0= RULE_BIG_DECIMAL
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
                    // InternalDataDsl.g:1432:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalDataDsl.g:1432:3: ( (lv_booleanValue_1_0= RULE_BOOLEAN ) )
                    // InternalDataDsl.g:1433:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    {
                    // InternalDataDsl.g:1433:4: (lv_booleanValue_1_0= RULE_BOOLEAN )
                    // InternalDataDsl.g:1434:5: lv_booleanValue_1_0= RULE_BOOLEAN
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
                    // InternalDataDsl.g:1451:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalDataDsl.g:1451:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalDataDsl.g:1452:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalDataDsl.g:1452:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalDataDsl.g:1453:5: lv_stringValue_2_0= RULE_STRING
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
    // InternalDataDsl.g:1473:1: entryRulePossiblyImportedComplexType returns [EObject current=null] : iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF ;
    public final EObject entryRulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePossiblyImportedComplexType = null;


        try {
            // InternalDataDsl.g:1473:68: (iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF )
            // InternalDataDsl.g:1474:2: iv_rulePossiblyImportedComplexType= rulePossiblyImportedComplexType EOF
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
    // InternalDataDsl.g:1480:1: rulePossiblyImportedComplexType returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePossiblyImportedComplexType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1486:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) ) )
            // InternalDataDsl.g:1487:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            {
            // InternalDataDsl.g:1487:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:1488:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:1488:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==33) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDsl.g:1489:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalDataDsl.g:1489:4: ( (otherlv_0= RULE_ID ) )
                    // InternalDataDsl.g:1490:5: (otherlv_0= RULE_ID )
                    {
                    // InternalDataDsl.g:1490:5: (otherlv_0= RULE_ID )
                    // InternalDataDsl.g:1491:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPossiblyImportedComplexTypeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_34); 

                    						newLeafNode(otherlv_0, grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_11); 

                    				newLeafNode(otherlv_1, grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalDataDsl.g:1507:3: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:1508:4: ( ruleQualifiedName )
            {
            // InternalDataDsl.g:1508:4: ( ruleQualifiedName )
            // InternalDataDsl.g:1509:5: ruleQualifiedName
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
    // InternalDataDsl.g:1527:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalDataDsl.g:1527:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalDataDsl.g:1528:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalDataDsl.g:1534:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) ;
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
            // InternalDataDsl.g:1540:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) ) )
            // InternalDataDsl.g:1541:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            {
            // InternalDataDsl.g:1541:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'byte' ) | ( () otherlv_5= 'char' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'double' ) | ( () otherlv_11= 'float' ) | ( () otherlv_13= 'int' ) | ( () otherlv_15= 'long' ) | ( () otherlv_17= 'short' ) | ( () otherlv_19= 'string' ) )
            int alt34=10;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt34=1;
                }
                break;
            case 35:
                {
                alt34=2;
                }
                break;
            case 36:
                {
                alt34=3;
                }
                break;
            case 37:
                {
                alt34=4;
                }
                break;
            case 38:
                {
                alt34=5;
                }
                break;
            case 39:
                {
                alt34=6;
                }
                break;
            case 40:
                {
                alt34=7;
                }
                break;
            case 41:
                {
                alt34=8;
                }
                break;
            case 42:
                {
                alt34=9;
                }
                break;
            case 43:
                {
                alt34=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalDataDsl.g:1542:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalDataDsl.g:1542:3: ( () otherlv_1= 'boolean' )
                    // InternalDataDsl.g:1543:4: () otherlv_1= 'boolean'
                    {
                    // InternalDataDsl.g:1543:4: ()
                    // InternalDataDsl.g:1544:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,34,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:1556:3: ( () otherlv_3= 'byte' )
                    {
                    // InternalDataDsl.g:1556:3: ( () otherlv_3= 'byte' )
                    // InternalDataDsl.g:1557:4: () otherlv_3= 'byte'
                    {
                    // InternalDataDsl.g:1557:4: ()
                    // InternalDataDsl.g:1558:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_3=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:1570:3: ( () otherlv_5= 'char' )
                    {
                    // InternalDataDsl.g:1570:3: ( () otherlv_5= 'char' )
                    // InternalDataDsl.g:1571:4: () otherlv_5= 'char'
                    {
                    // InternalDataDsl.g:1571:4: ()
                    // InternalDataDsl.g:1572:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:1584:3: ( () otherlv_7= 'date' )
                    {
                    // InternalDataDsl.g:1584:3: ( () otherlv_7= 'date' )
                    // InternalDataDsl.g:1585:4: () otherlv_7= 'date'
                    {
                    // InternalDataDsl.g:1585:4: ()
                    // InternalDataDsl.g:1586:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,37,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDsl.g:1598:3: ( () otherlv_9= 'double' )
                    {
                    // InternalDataDsl.g:1598:3: ( () otherlv_9= 'double' )
                    // InternalDataDsl.g:1599:4: () otherlv_9= 'double'
                    {
                    // InternalDataDsl.g:1599:4: ()
                    // InternalDataDsl.g:1600:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0(),
                    						current);
                    				

                    }

                    otherlv_9=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDsl.g:1612:3: ( () otherlv_11= 'float' )
                    {
                    // InternalDataDsl.g:1612:3: ( () otherlv_11= 'float' )
                    // InternalDataDsl.g:1613:4: () otherlv_11= 'float'
                    {
                    // InternalDataDsl.g:1613:4: ()
                    // InternalDataDsl.g:1614:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0(),
                    						current);
                    				

                    }

                    otherlv_11=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDsl.g:1626:3: ( () otherlv_13= 'int' )
                    {
                    // InternalDataDsl.g:1626:3: ( () otherlv_13= 'int' )
                    // InternalDataDsl.g:1627:4: () otherlv_13= 'int'
                    {
                    // InternalDataDsl.g:1627:4: ()
                    // InternalDataDsl.g:1628:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0(),
                    						current);
                    				

                    }

                    otherlv_13=(Token)match(input,40,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDsl.g:1640:3: ( () otherlv_15= 'long' )
                    {
                    // InternalDataDsl.g:1640:3: ( () otherlv_15= 'long' )
                    // InternalDataDsl.g:1641:4: () otherlv_15= 'long'
                    {
                    // InternalDataDsl.g:1641:4: ()
                    // InternalDataDsl.g:1642:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,41,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDsl.g:1654:3: ( () otherlv_17= 'short' )
                    {
                    // InternalDataDsl.g:1654:3: ( () otherlv_17= 'short' )
                    // InternalDataDsl.g:1655:4: () otherlv_17= 'short'
                    {
                    // InternalDataDsl.g:1655:4: ()
                    // InternalDataDsl.g:1656:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0(),
                    						current);
                    				

                    }

                    otherlv_17=(Token)match(input,42,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDsl.g:1668:3: ( () otherlv_19= 'string' )
                    {
                    // InternalDataDsl.g:1668:3: ( () otherlv_19= 'string' )
                    // InternalDataDsl.g:1669:4: () otherlv_19= 'string'
                    {
                    // InternalDataDsl.g:1669:4: ()
                    // InternalDataDsl.g:1670:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0(),
                    						current);
                    				

                    }

                    otherlv_19=(Token)match(input,43,FOLLOW_2); 

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
    // InternalDataDsl.g:1685:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDataDsl.g:1685:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDataDsl.g:1686:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDataDsl.g:1692:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1698:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDataDsl.g:1699:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDataDsl.g:1699:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDataDsl.g:1700:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalDataDsl.g:1707:3: (kw= '.' this_ID_2= RULE_ID )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==44) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDsl.g:1708:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,44,FOLLOW_11); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_35); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop35;
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


    // $ANTLR start "ruleFieldFeature"
    // InternalDataDsl.g:1725:1: ruleFieldFeature returns [Enumerator current=null] : (enumLiteral_0= 'derived' ) ;
    public final Enumerator ruleFieldFeature() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalDataDsl.g:1731:2: ( (enumLiteral_0= 'derived' ) )
            // InternalDataDsl.g:1732:2: (enumLiteral_0= 'derived' )
            {
            // InternalDataDsl.g:1732:2: (enumLiteral_0= 'derived' )
            // InternalDataDsl.g:1733:3: enumLiteral_0= 'derived'
            {
            enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

            			current = grammarAccess.getFieldFeatureAccess().getDERIVEDEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getFieldFeatureAccess().getDERIVEDEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldFeature"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String dfa_1s = "\62\uffff";
    static final String dfa_2s = "\15\5\2\uffff\1\23\1\55\3\5\1\uffff\1\27\14\5\1\uffff\2\5\1\55\2\23\2\5\1\55\1\27\2\5\1\27\1\55\1\23\1\27";
    static final String dfa_3s = "\2\53\12\5\1\54\2\uffff\1\32\1\55\1\53\2\5\1\uffff\1\33\1\53\12\5\1\54\1\uffff\2\54\1\55\1\27\1\32\2\5\1\55\1\33\2\54\1\33\1\55\1\27\1\33";
    static final String dfa_4s = "\15\uffff\1\2\1\4\5\uffff\1\1\15\uffff\1\3\17\uffff";
    static final String dfa_5s = "\62\uffff}>";
    static final String[] dfa_6s = {
            "\1\14\15\uffff\1\16\5\uffff\1\1\5\uffff\2\15\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13",
            "\1\14\31\uffff\2\15\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17\15\uffff\1\24\3\uffff\1\21\2\uffff\1\20\6\uffff\1\22\12\uffff\1\23",
            "",
            "",
            "\1\24\3\uffff\1\21\2\uffff\1\20",
            "\1\25",
            "\1\41\23\uffff\1\26\5\uffff\2\42\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40",
            "\1\43",
            "\1\44",
            "",
            "\1\45\3\uffff\1\46",
            "\1\41\31\uffff\2\42\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47",
            "\1\47\15\uffff\1\24\3\uffff\1\21\2\uffff\1\52\6\uffff\1\50\12\uffff\1\51",
            "",
            "\1\17\46\uffff\1\23",
            "\1\17\46\uffff\1\23",
            "\1\53",
            "\1\24\3\uffff\1\21",
            "\1\24\3\uffff\1\21\2\uffff\1\52",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\45\3\uffff\1\46",
            "\1\47\46\uffff\1\51",
            "\1\47\46\uffff\1\51",
            "\1\57\3\uffff\1\60",
            "\1\61",
            "\1\24\3\uffff\1\21",
            "\1\57\3\uffff\1\60"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "501:3: ( ( ( (lv_dataFields_5_0= ruleDataField ) ) (otherlv_6= ',' ( (lv_dataFields_7_0= ruleDataField ) ) )* ) | ( ( (lv_operations_8_0= ruleDataOperation ) ) (otherlv_9= ',' ( (lv_operations_10_0= ruleDataOperation ) ) )* ) | ( ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= ',' ( (lv_operations_15_0= ruleDataOperation ) ) (otherlv_16= ',' ( (lv_operations_17_0= ruleDataOperation ) ) )* ) )?";
        }
    }
    static final String dfa_7s = "\20\uffff";
    static final String dfa_8s = "\1\30\1\5\1\22\1\5\1\uffff\12\5\1\uffff";
    static final String dfa_9s = "\1\30\1\5\1\22\1\53\1\uffff\12\23\1\uffff";
    static final String dfa_10s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_11s = "\20\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\23\uffff\1\4\10\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16",
            "",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            "\1\4\15\uffff\1\17",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "713:2: ( (otherlv_0= 'list' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_dataFields_3_0= ruleDataField ) ) (otherlv_4= ',' ( (lv_dataFields_5_0= ruleDataField ) ) )* otherlv_6= '}' ) | (otherlv_7= 'list' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_primitiveType_10_0= rulePrimitiveType ) ) otherlv_11= '}' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000011322000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000011320002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000113A0000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000011320000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000FFD82080020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000FFC02000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000182000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000FFC00000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000FFC00000020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000FFC40800020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000100000000002L});

}