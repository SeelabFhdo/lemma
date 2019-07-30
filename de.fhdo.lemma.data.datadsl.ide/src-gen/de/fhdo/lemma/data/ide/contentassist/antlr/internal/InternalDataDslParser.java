package de.fhdo.lemma.data.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.fhdo.lemma.data.services.DataDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDataDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'derived'", "'import'", "'datatypes'", "'from'", "'as'", "'version'", "'{'", "'}'", "'context'", "'structure'", "'extends'", "','", "'list'", "'<'", "'>'", "'enum'", "'('", "')'", "'function'", "'::'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'hide'", "'procedure'"
    };
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=5;
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

    	public void setGrammarAccess(DataDslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleDataModel"
    // InternalDataDsl.g:53:1: entryRuleDataModel : ruleDataModel EOF ;
    public final void entryRuleDataModel() throws RecognitionException {
        try {
            // InternalDataDsl.g:54:1: ( ruleDataModel EOF )
            // InternalDataDsl.g:55:1: ruleDataModel EOF
            {
             before(grammarAccess.getDataModelRule()); 
            pushFollow(FOLLOW_1);
            ruleDataModel();

            state._fsp--;

             after(grammarAccess.getDataModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataModel"


    // $ANTLR start "ruleDataModel"
    // InternalDataDsl.g:62:1: ruleDataModel : ( ( rule__DataModel__Group__0 ) ) ;
    public final void ruleDataModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:66:2: ( ( ( rule__DataModel__Group__0 ) ) )
            // InternalDataDsl.g:67:2: ( ( rule__DataModel__Group__0 ) )
            {
            // InternalDataDsl.g:67:2: ( ( rule__DataModel__Group__0 ) )
            // InternalDataDsl.g:68:3: ( rule__DataModel__Group__0 )
            {
             before(grammarAccess.getDataModelAccess().getGroup()); 
            // InternalDataDsl.g:69:3: ( rule__DataModel__Group__0 )
            // InternalDataDsl.g:69:4: rule__DataModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataModel"


    // $ANTLR start "entryRuleComplexTypeImport"
    // InternalDataDsl.g:78:1: entryRuleComplexTypeImport : ruleComplexTypeImport EOF ;
    public final void entryRuleComplexTypeImport() throws RecognitionException {
        try {
            // InternalDataDsl.g:79:1: ( ruleComplexTypeImport EOF )
            // InternalDataDsl.g:80:1: ruleComplexTypeImport EOF
            {
             before(grammarAccess.getComplexTypeImportRule()); 
            pushFollow(FOLLOW_1);
            ruleComplexTypeImport();

            state._fsp--;

             after(grammarAccess.getComplexTypeImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComplexTypeImport"


    // $ANTLR start "ruleComplexTypeImport"
    // InternalDataDsl.g:87:1: ruleComplexTypeImport : ( ( rule__ComplexTypeImport__Group__0 ) ) ;
    public final void ruleComplexTypeImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:91:2: ( ( ( rule__ComplexTypeImport__Group__0 ) ) )
            // InternalDataDsl.g:92:2: ( ( rule__ComplexTypeImport__Group__0 ) )
            {
            // InternalDataDsl.g:92:2: ( ( rule__ComplexTypeImport__Group__0 ) )
            // InternalDataDsl.g:93:3: ( rule__ComplexTypeImport__Group__0 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getGroup()); 
            // InternalDataDsl.g:94:3: ( rule__ComplexTypeImport__Group__0 )
            // InternalDataDsl.g:94:4: rule__ComplexTypeImport__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComplexTypeImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexTypeImport"


    // $ANTLR start "entryRuleVersion"
    // InternalDataDsl.g:103:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {
        try {
            // InternalDataDsl.g:104:1: ( ruleVersion EOF )
            // InternalDataDsl.g:105:1: ruleVersion EOF
            {
             before(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_1);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getVersionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // InternalDataDsl.g:112:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:116:2: ( ( ( rule__Version__Group__0 ) ) )
            // InternalDataDsl.g:117:2: ( ( rule__Version__Group__0 ) )
            {
            // InternalDataDsl.g:117:2: ( ( rule__Version__Group__0 ) )
            // InternalDataDsl.g:118:3: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // InternalDataDsl.g:119:3: ( rule__Version__Group__0 )
            // InternalDataDsl.g:119:4: rule__Version__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Version__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVersionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleContext"
    // InternalDataDsl.g:128:1: entryRuleContext : ruleContext EOF ;
    public final void entryRuleContext() throws RecognitionException {
        try {
            // InternalDataDsl.g:129:1: ( ruleContext EOF )
            // InternalDataDsl.g:130:1: ruleContext EOF
            {
             before(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            ruleContext();

            state._fsp--;

             after(grammarAccess.getContextRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalDataDsl.g:137:1: ruleContext : ( ( rule__Context__Group__0 ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:141:2: ( ( ( rule__Context__Group__0 ) ) )
            // InternalDataDsl.g:142:2: ( ( rule__Context__Group__0 ) )
            {
            // InternalDataDsl.g:142:2: ( ( rule__Context__Group__0 ) )
            // InternalDataDsl.g:143:3: ( rule__Context__Group__0 )
            {
             before(grammarAccess.getContextAccess().getGroup()); 
            // InternalDataDsl.g:144:3: ( rule__Context__Group__0 )
            // InternalDataDsl.g:144:4: rule__Context__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Context__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRuleComplexType"
    // InternalDataDsl.g:153:1: entryRuleComplexType : ruleComplexType EOF ;
    public final void entryRuleComplexType() throws RecognitionException {
        try {
            // InternalDataDsl.g:154:1: ( ruleComplexType EOF )
            // InternalDataDsl.g:155:1: ruleComplexType EOF
            {
             before(grammarAccess.getComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleComplexType();

            state._fsp--;

             after(grammarAccess.getComplexTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComplexType"


    // $ANTLR start "ruleComplexType"
    // InternalDataDsl.g:162:1: ruleComplexType : ( ( rule__ComplexType__Alternatives ) ) ;
    public final void ruleComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:166:2: ( ( ( rule__ComplexType__Alternatives ) ) )
            // InternalDataDsl.g:167:2: ( ( rule__ComplexType__Alternatives ) )
            {
            // InternalDataDsl.g:167:2: ( ( rule__ComplexType__Alternatives ) )
            // InternalDataDsl.g:168:3: ( rule__ComplexType__Alternatives )
            {
             before(grammarAccess.getComplexTypeAccess().getAlternatives()); 
            // InternalDataDsl.g:169:3: ( rule__ComplexType__Alternatives )
            // InternalDataDsl.g:169:4: rule__ComplexType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComplexType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComplexTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexType"


    // $ANTLR start "entryRuleDataStructure"
    // InternalDataDsl.g:178:1: entryRuleDataStructure : ruleDataStructure EOF ;
    public final void entryRuleDataStructure() throws RecognitionException {
        try {
            // InternalDataDsl.g:179:1: ( ruleDataStructure EOF )
            // InternalDataDsl.g:180:1: ruleDataStructure EOF
            {
             before(grammarAccess.getDataStructureRule()); 
            pushFollow(FOLLOW_1);
            ruleDataStructure();

            state._fsp--;

             after(grammarAccess.getDataStructureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataStructure"


    // $ANTLR start "ruleDataStructure"
    // InternalDataDsl.g:187:1: ruleDataStructure : ( ( rule__DataStructure__Group__0 ) ) ;
    public final void ruleDataStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:191:2: ( ( ( rule__DataStructure__Group__0 ) ) )
            // InternalDataDsl.g:192:2: ( ( rule__DataStructure__Group__0 ) )
            {
            // InternalDataDsl.g:192:2: ( ( rule__DataStructure__Group__0 ) )
            // InternalDataDsl.g:193:3: ( rule__DataStructure__Group__0 )
            {
             before(grammarAccess.getDataStructureAccess().getGroup()); 
            // InternalDataDsl.g:194:3: ( rule__DataStructure__Group__0 )
            // InternalDataDsl.g:194:4: rule__DataStructure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataStructure"


    // $ANTLR start "entryRuleListType"
    // InternalDataDsl.g:203:1: entryRuleListType : ruleListType EOF ;
    public final void entryRuleListType() throws RecognitionException {
        try {
            // InternalDataDsl.g:204:1: ( ruleListType EOF )
            // InternalDataDsl.g:205:1: ruleListType EOF
            {
             before(grammarAccess.getListTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleListType();

            state._fsp--;

             after(grammarAccess.getListTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // InternalDataDsl.g:212:1: ruleListType : ( ( rule__ListType__Alternatives ) ) ;
    public final void ruleListType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:216:2: ( ( ( rule__ListType__Alternatives ) ) )
            // InternalDataDsl.g:217:2: ( ( rule__ListType__Alternatives ) )
            {
            // InternalDataDsl.g:217:2: ( ( rule__ListType__Alternatives ) )
            // InternalDataDsl.g:218:3: ( rule__ListType__Alternatives )
            {
             before(grammarAccess.getListTypeAccess().getAlternatives()); 
            // InternalDataDsl.g:219:3: ( rule__ListType__Alternatives )
            // InternalDataDsl.g:219:4: rule__ListType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleDataField"
    // InternalDataDsl.g:228:1: entryRuleDataField : ruleDataField EOF ;
    public final void entryRuleDataField() throws RecognitionException {
        try {
            // InternalDataDsl.g:229:1: ( ruleDataField EOF )
            // InternalDataDsl.g:230:1: ruleDataField EOF
            {
             before(grammarAccess.getDataFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataField"


    // $ANTLR start "ruleDataField"
    // InternalDataDsl.g:237:1: ruleDataField : ( ( rule__DataField__Group__0 ) ) ;
    public final void ruleDataField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:241:2: ( ( ( rule__DataField__Group__0 ) ) )
            // InternalDataDsl.g:242:2: ( ( rule__DataField__Group__0 ) )
            {
            // InternalDataDsl.g:242:2: ( ( rule__DataField__Group__0 ) )
            // InternalDataDsl.g:243:3: ( rule__DataField__Group__0 )
            {
             before(grammarAccess.getDataFieldAccess().getGroup()); 
            // InternalDataDsl.g:244:3: ( rule__DataField__Group__0 )
            // InternalDataDsl.g:244:4: rule__DataField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataField"


    // $ANTLR start "entryRuleEnumeration"
    // InternalDataDsl.g:253:1: entryRuleEnumeration : ruleEnumeration EOF ;
    public final void entryRuleEnumeration() throws RecognitionException {
        try {
            // InternalDataDsl.g:254:1: ( ruleEnumeration EOF )
            // InternalDataDsl.g:255:1: ruleEnumeration EOF
            {
             before(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumeration();

            state._fsp--;

             after(grammarAccess.getEnumerationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalDataDsl.g:262:1: ruleEnumeration : ( ( rule__Enumeration__Group__0 ) ) ;
    public final void ruleEnumeration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:266:2: ( ( ( rule__Enumeration__Group__0 ) ) )
            // InternalDataDsl.g:267:2: ( ( rule__Enumeration__Group__0 ) )
            {
            // InternalDataDsl.g:267:2: ( ( rule__Enumeration__Group__0 ) )
            // InternalDataDsl.g:268:3: ( rule__Enumeration__Group__0 )
            {
             before(grammarAccess.getEnumerationAccess().getGroup()); 
            // InternalDataDsl.g:269:3: ( rule__Enumeration__Group__0 )
            // InternalDataDsl.g:269:4: rule__Enumeration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleEnumerationField"
    // InternalDataDsl.g:278:1: entryRuleEnumerationField : ruleEnumerationField EOF ;
    public final void entryRuleEnumerationField() throws RecognitionException {
        try {
            // InternalDataDsl.g:279:1: ( ruleEnumerationField EOF )
            // InternalDataDsl.g:280:1: ruleEnumerationField EOF
            {
             before(grammarAccess.getEnumerationFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumerationField();

            state._fsp--;

             after(grammarAccess.getEnumerationFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumerationField"


    // $ANTLR start "ruleEnumerationField"
    // InternalDataDsl.g:287:1: ruleEnumerationField : ( ( rule__EnumerationField__Group__0 ) ) ;
    public final void ruleEnumerationField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:291:2: ( ( ( rule__EnumerationField__Group__0 ) ) )
            // InternalDataDsl.g:292:2: ( ( rule__EnumerationField__Group__0 ) )
            {
            // InternalDataDsl.g:292:2: ( ( rule__EnumerationField__Group__0 ) )
            // InternalDataDsl.g:293:3: ( rule__EnumerationField__Group__0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup()); 
            // InternalDataDsl.g:294:3: ( rule__EnumerationField__Group__0 )
            // InternalDataDsl.g:294:4: rule__EnumerationField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumerationField"


    // $ANTLR start "entryRuleDataOperation"
    // InternalDataDsl.g:303:1: entryRuleDataOperation : ruleDataOperation EOF ;
    public final void entryRuleDataOperation() throws RecognitionException {
        try {
            // InternalDataDsl.g:304:1: ( ruleDataOperation EOF )
            // InternalDataDsl.g:305:1: ruleDataOperation EOF
            {
             before(grammarAccess.getDataOperationRule()); 
            pushFollow(FOLLOW_1);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataOperationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataOperation"


    // $ANTLR start "ruleDataOperation"
    // InternalDataDsl.g:312:1: ruleDataOperation : ( ( rule__DataOperation__Group__0 ) ) ;
    public final void ruleDataOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:316:2: ( ( ( rule__DataOperation__Group__0 ) ) )
            // InternalDataDsl.g:317:2: ( ( rule__DataOperation__Group__0 ) )
            {
            // InternalDataDsl.g:317:2: ( ( rule__DataOperation__Group__0 ) )
            // InternalDataDsl.g:318:3: ( rule__DataOperation__Group__0 )
            {
             before(grammarAccess.getDataOperationAccess().getGroup()); 
            // InternalDataDsl.g:319:3: ( rule__DataOperation__Group__0 )
            // InternalDataDsl.g:319:4: rule__DataOperation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataOperation"


    // $ANTLR start "entryRuleDataOperationParameter"
    // InternalDataDsl.g:328:1: entryRuleDataOperationParameter : ruleDataOperationParameter EOF ;
    public final void entryRuleDataOperationParameter() throws RecognitionException {
        try {
            // InternalDataDsl.g:329:1: ( ruleDataOperationParameter EOF )
            // InternalDataDsl.g:330:1: ruleDataOperationParameter EOF
            {
             before(grammarAccess.getDataOperationParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleDataOperationParameter();

            state._fsp--;

             after(grammarAccess.getDataOperationParameterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataOperationParameter"


    // $ANTLR start "ruleDataOperationParameter"
    // InternalDataDsl.g:337:1: ruleDataOperationParameter : ( ( rule__DataOperationParameter__Group__0 ) ) ;
    public final void ruleDataOperationParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:341:2: ( ( ( rule__DataOperationParameter__Group__0 ) ) )
            // InternalDataDsl.g:342:2: ( ( rule__DataOperationParameter__Group__0 ) )
            {
            // InternalDataDsl.g:342:2: ( ( rule__DataOperationParameter__Group__0 ) )
            // InternalDataDsl.g:343:3: ( rule__DataOperationParameter__Group__0 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getGroup()); 
            // InternalDataDsl.g:344:3: ( rule__DataOperationParameter__Group__0 )
            // InternalDataDsl.g:344:4: rule__DataOperationParameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataOperationParameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataOperationParameter"


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalDataDsl.g:353:1: entryRulePrimitiveValue : rulePrimitiveValue EOF ;
    public final void entryRulePrimitiveValue() throws RecognitionException {
        try {
            // InternalDataDsl.g:354:1: ( rulePrimitiveValue EOF )
            // InternalDataDsl.g:355:1: rulePrimitiveValue EOF
            {
             before(grammarAccess.getPrimitiveValueRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveValue();

            state._fsp--;

             after(grammarAccess.getPrimitiveValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveValue"


    // $ANTLR start "rulePrimitiveValue"
    // InternalDataDsl.g:362:1: rulePrimitiveValue : ( ( rule__PrimitiveValue__Alternatives ) ) ;
    public final void rulePrimitiveValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:366:2: ( ( ( rule__PrimitiveValue__Alternatives ) ) )
            // InternalDataDsl.g:367:2: ( ( rule__PrimitiveValue__Alternatives ) )
            {
            // InternalDataDsl.g:367:2: ( ( rule__PrimitiveValue__Alternatives ) )
            // InternalDataDsl.g:368:3: ( rule__PrimitiveValue__Alternatives )
            {
             before(grammarAccess.getPrimitiveValueAccess().getAlternatives()); 
            // InternalDataDsl.g:369:3: ( rule__PrimitiveValue__Alternatives )
            // InternalDataDsl.g:369:4: rule__PrimitiveValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveValue"


    // $ANTLR start "entryRuleImportedComplexType"
    // InternalDataDsl.g:378:1: entryRuleImportedComplexType : ruleImportedComplexType EOF ;
    public final void entryRuleImportedComplexType() throws RecognitionException {
        try {
            // InternalDataDsl.g:379:1: ( ruleImportedComplexType EOF )
            // InternalDataDsl.g:380:1: ruleImportedComplexType EOF
            {
             before(grammarAccess.getImportedComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleImportedComplexType();

            state._fsp--;

             after(grammarAccess.getImportedComplexTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportedComplexType"


    // $ANTLR start "ruleImportedComplexType"
    // InternalDataDsl.g:387:1: ruleImportedComplexType : ( ( rule__ImportedComplexType__Group__0 ) ) ;
    public final void ruleImportedComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:391:2: ( ( ( rule__ImportedComplexType__Group__0 ) ) )
            // InternalDataDsl.g:392:2: ( ( rule__ImportedComplexType__Group__0 ) )
            {
            // InternalDataDsl.g:392:2: ( ( rule__ImportedComplexType__Group__0 ) )
            // InternalDataDsl.g:393:3: ( rule__ImportedComplexType__Group__0 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getGroup()); 
            // InternalDataDsl.g:394:3: ( rule__ImportedComplexType__Group__0 )
            // InternalDataDsl.g:394:4: rule__ImportedComplexType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportedComplexType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportedComplexTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportedComplexType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalDataDsl.g:403:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalDataDsl.g:404:1: ( rulePrimitiveType EOF )
            // InternalDataDsl.g:405:1: rulePrimitiveType EOF
            {
             before(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getPrimitiveTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalDataDsl.g:412:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:416:2: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalDataDsl.g:417:2: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalDataDsl.g:417:2: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalDataDsl.g:418:3: ( rule__PrimitiveType__Alternatives )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            // InternalDataDsl.g:419:3: ( rule__PrimitiveType__Alternatives )
            // InternalDataDsl.g:419:4: rule__PrimitiveType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalDataDsl.g:428:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDataDsl.g:429:1: ( ruleQualifiedName EOF )
            // InternalDataDsl.g:430:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalDataDsl.g:437:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:441:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDataDsl.g:442:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDataDsl.g:442:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDataDsl.g:443:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalDataDsl.g:444:3: ( rule__QualifiedName__Group__0 )
            // InternalDataDsl.g:444:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleFieldFeature"
    // InternalDataDsl.g:453:1: ruleFieldFeature : ( ( 'derived' ) ) ;
    public final void ruleFieldFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:457:1: ( ( ( 'derived' ) ) )
            // InternalDataDsl.g:458:2: ( ( 'derived' ) )
            {
            // InternalDataDsl.g:458:2: ( ( 'derived' ) )
            // InternalDataDsl.g:459:3: ( 'derived' )
            {
             before(grammarAccess.getFieldFeatureAccess().getDERIVEDEnumLiteralDeclaration()); 
            // InternalDataDsl.g:460:3: ( 'derived' )
            // InternalDataDsl.g:460:4: 'derived'
            {
            match(input,13,FOLLOW_2); 

            }

             after(grammarAccess.getFieldFeatureAccess().getDERIVEDEnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFieldFeature"


    // $ANTLR start "rule__DataModel__Alternatives_1"
    // InternalDataDsl.g:468:1: rule__DataModel__Alternatives_1 : ( ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) ) | ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) ) | ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) ) );
    public final void rule__DataModel__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:472:1: ( ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) ) | ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) ) | ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt4=1;
                }
                break;
            case 21:
                {
                alt4=2;
                }
                break;
            case 22:
            case 25:
            case 28:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDataDsl.g:473:2: ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) )
                    {
                    // InternalDataDsl.g:473:2: ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) )
                    // InternalDataDsl.g:474:3: ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* )
                    {
                    // InternalDataDsl.g:474:3: ( ( rule__DataModel__VersionsAssignment_1_0 ) )
                    // InternalDataDsl.g:475:4: ( rule__DataModel__VersionsAssignment_1_0 )
                    {
                     before(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 
                    // InternalDataDsl.g:476:4: ( rule__DataModel__VersionsAssignment_1_0 )
                    // InternalDataDsl.g:476:5: rule__DataModel__VersionsAssignment_1_0
                    {
                    pushFollow(FOLLOW_3);
                    rule__DataModel__VersionsAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 

                    }

                    // InternalDataDsl.g:479:3: ( ( rule__DataModel__VersionsAssignment_1_0 )* )
                    // InternalDataDsl.g:480:4: ( rule__DataModel__VersionsAssignment_1_0 )*
                    {
                     before(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 
                    // InternalDataDsl.g:481:4: ( rule__DataModel__VersionsAssignment_1_0 )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==18) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalDataDsl.g:481:5: rule__DataModel__VersionsAssignment_1_0
                    	    {
                    	    pushFollow(FOLLOW_3);
                    	    rule__DataModel__VersionsAssignment_1_0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                     after(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:486:2: ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) )
                    {
                    // InternalDataDsl.g:486:2: ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) )
                    // InternalDataDsl.g:487:3: ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* )
                    {
                    // InternalDataDsl.g:487:3: ( ( rule__DataModel__ContextsAssignment_1_1 ) )
                    // InternalDataDsl.g:488:4: ( rule__DataModel__ContextsAssignment_1_1 )
                    {
                     before(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 
                    // InternalDataDsl.g:489:4: ( rule__DataModel__ContextsAssignment_1_1 )
                    // InternalDataDsl.g:489:5: rule__DataModel__ContextsAssignment_1_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__DataModel__ContextsAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 

                    }

                    // InternalDataDsl.g:492:3: ( ( rule__DataModel__ContextsAssignment_1_1 )* )
                    // InternalDataDsl.g:493:4: ( rule__DataModel__ContextsAssignment_1_1 )*
                    {
                     before(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 
                    // InternalDataDsl.g:494:4: ( rule__DataModel__ContextsAssignment_1_1 )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==21) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDsl.g:494:5: rule__DataModel__ContextsAssignment_1_1
                    	    {
                    	    pushFollow(FOLLOW_4);
                    	    rule__DataModel__ContextsAssignment_1_1();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                     after(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:499:2: ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) )
                    {
                    // InternalDataDsl.g:499:2: ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) )
                    // InternalDataDsl.g:500:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* )
                    {
                    // InternalDataDsl.g:500:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) )
                    // InternalDataDsl.g:501:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )
                    {
                     before(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 
                    // InternalDataDsl.g:502:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )
                    // InternalDataDsl.g:502:5: rule__DataModel__ComplexTypesAssignment_1_2
                    {
                    pushFollow(FOLLOW_5);
                    rule__DataModel__ComplexTypesAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 

                    }

                    // InternalDataDsl.g:505:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* )
                    // InternalDataDsl.g:506:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )*
                    {
                     before(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 
                    // InternalDataDsl.g:507:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==22||LA3_0==25||LA3_0==28) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalDataDsl.g:507:5: rule__DataModel__ComplexTypesAssignment_1_2
                    	    {
                    	    pushFollow(FOLLOW_5);
                    	    rule__DataModel__ComplexTypesAssignment_1_2();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                     after(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 

                    }


                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__Alternatives_1"


    // $ANTLR start "rule__Version__Alternatives_3"
    // InternalDataDsl.g:516:1: rule__Version__Alternatives_3 : ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) );
    public final void rule__Version__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:520:1: ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22||LA7_0==25||LA7_0==28) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDataDsl.g:521:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    {
                    // InternalDataDsl.g:521:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    // InternalDataDsl.g:522:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    {
                    // InternalDataDsl.g:522:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) )
                    // InternalDataDsl.g:523:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalDataDsl.g:524:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    // InternalDataDsl.g:524:5: rule__Version__ComplexTypesAssignment_3_0
                    {
                    pushFollow(FOLLOW_5);
                    rule__Version__ComplexTypesAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }

                    // InternalDataDsl.g:527:3: ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    // InternalDataDsl.g:528:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalDataDsl.g:529:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==22||LA5_0==25||LA5_0==28) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDataDsl.g:529:5: rule__Version__ComplexTypesAssignment_3_0
                    	    {
                    	    pushFollow(FOLLOW_5);
                    	    rule__Version__ComplexTypesAssignment_3_0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:534:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    {
                    // InternalDataDsl.g:534:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    // InternalDataDsl.g:535:3: ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* )
                    {
                    // InternalDataDsl.g:535:3: ( ( rule__Version__ContextsAssignment_3_1 ) )
                    // InternalDataDsl.g:536:4: ( rule__Version__ContextsAssignment_3_1 )
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalDataDsl.g:537:4: ( rule__Version__ContextsAssignment_3_1 )
                    // InternalDataDsl.g:537:5: rule__Version__ContextsAssignment_3_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__Version__ContextsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 

                    }

                    // InternalDataDsl.g:540:3: ( ( rule__Version__ContextsAssignment_3_1 )* )
                    // InternalDataDsl.g:541:4: ( rule__Version__ContextsAssignment_3_1 )*
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalDataDsl.g:542:4: ( rule__Version__ContextsAssignment_3_1 )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==21) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDsl.g:542:5: rule__Version__ContextsAssignment_3_1
                    	    {
                    	    pushFollow(FOLLOW_4);
                    	    rule__Version__ContextsAssignment_3_1();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                     after(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 

                    }


                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Alternatives_3"


    // $ANTLR start "rule__ComplexType__Alternatives"
    // InternalDataDsl.g:551:1: rule__ComplexType__Alternatives : ( ( ruleDataStructure ) | ( ruleListType ) | ( ruleEnumeration ) );
    public final void rule__ComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:555:1: ( ( ruleDataStructure ) | ( ruleListType ) | ( ruleEnumeration ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt8=1;
                }
                break;
            case 25:
                {
                alt8=2;
                }
                break;
            case 28:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDataDsl.g:556:2: ( ruleDataStructure )
                    {
                    // InternalDataDsl.g:556:2: ( ruleDataStructure )
                    // InternalDataDsl.g:557:3: ruleDataStructure
                    {
                     before(grammarAccess.getComplexTypeAccess().getDataStructureParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDataStructure();

                    state._fsp--;

                     after(grammarAccess.getComplexTypeAccess().getDataStructureParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:562:2: ( ruleListType )
                    {
                    // InternalDataDsl.g:562:2: ( ruleListType )
                    // InternalDataDsl.g:563:3: ruleListType
                    {
                     before(grammarAccess.getComplexTypeAccess().getListTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleListType();

                    state._fsp--;

                     after(grammarAccess.getComplexTypeAccess().getListTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:568:2: ( ruleEnumeration )
                    {
                    // InternalDataDsl.g:568:2: ( ruleEnumeration )
                    // InternalDataDsl.g:569:3: ruleEnumeration
                    {
                     before(grammarAccess.getComplexTypeAccess().getEnumerationParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleEnumeration();

                    state._fsp--;

                     after(grammarAccess.getComplexTypeAccess().getEnumerationParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexType__Alternatives"


    // $ANTLR start "rule__DataStructure__Alternatives_4_0"
    // InternalDataDsl.g:578:1: rule__DataStructure__Alternatives_4_0 : ( ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_4_0_1 ) ) );
    public final void rule__DataStructure__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:582:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_4_0_1 ) ) )
            int alt9=2;
            switch ( input.LA(1) ) {
            case 44:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_ID||(LA9_1>=33 && LA9_1<=42)) ) {
                    alt9=1;
                }
                else if ( (LA9_1==31||LA9_1==45) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
                {
                alt9=1;
                }
                break;
            case 31:
            case 45:
                {
                alt9=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalDataDsl.g:583:2: ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) )
                    {
                    // InternalDataDsl.g:583:2: ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) )
                    // InternalDataDsl.g:584:3: ( rule__DataStructure__DataFieldsAssignment_4_0_0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0_0()); 
                    // InternalDataDsl.g:585:3: ( rule__DataStructure__DataFieldsAssignment_4_0_0 )
                    // InternalDataDsl.g:585:4: rule__DataStructure__DataFieldsAssignment_4_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__DataFieldsAssignment_4_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:589:2: ( ( rule__DataStructure__OperationsAssignment_4_0_1 ) )
                    {
                    // InternalDataDsl.g:589:2: ( ( rule__DataStructure__OperationsAssignment_4_0_1 ) )
                    // InternalDataDsl.g:590:3: ( rule__DataStructure__OperationsAssignment_4_0_1 )
                    {
                     before(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_0_1()); 
                    // InternalDataDsl.g:591:3: ( rule__DataStructure__OperationsAssignment_4_0_1 )
                    // InternalDataDsl.g:591:4: rule__DataStructure__OperationsAssignment_4_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__OperationsAssignment_4_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Alternatives_4_0"


    // $ANTLR start "rule__DataStructure__Alternatives_4_1_1"
    // InternalDataDsl.g:599:1: rule__DataStructure__Alternatives_4_1_1 : ( ( ( rule__DataStructure__DataFieldsAssignment_4_1_1_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) ) );
    public final void rule__DataStructure__Alternatives_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:603:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_1_1_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case 44:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==31||LA10_1==45) ) {
                    alt10=2;
                }
                else if ( (LA10_1==RULE_ID||(LA10_1>=33 && LA10_1<=42)) ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
                {
                alt10=1;
                }
                break;
            case 31:
            case 45:
                {
                alt10=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalDataDsl.g:604:2: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1_0 ) )
                    {
                    // InternalDataDsl.g:604:2: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1_0 ) )
                    // InternalDataDsl.g:605:3: ( rule__DataStructure__DataFieldsAssignment_4_1_1_0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_1_1_0()); 
                    // InternalDataDsl.g:606:3: ( rule__DataStructure__DataFieldsAssignment_4_1_1_0 )
                    // InternalDataDsl.g:606:4: rule__DataStructure__DataFieldsAssignment_4_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__DataFieldsAssignment_4_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:610:2: ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) )
                    {
                    // InternalDataDsl.g:610:2: ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) )
                    // InternalDataDsl.g:611:3: ( rule__DataStructure__OperationsAssignment_4_1_1_1 )
                    {
                     before(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_1_1_1()); 
                    // InternalDataDsl.g:612:3: ( rule__DataStructure__OperationsAssignment_4_1_1_1 )
                    // InternalDataDsl.g:612:4: rule__DataStructure__OperationsAssignment_4_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__OperationsAssignment_4_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_1_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Alternatives_4_1_1"


    // $ANTLR start "rule__ListType__Alternatives"
    // InternalDataDsl.g:620:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );
    public final void rule__ListType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:624:1: ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalDataDsl.g:625:2: ( ( rule__ListType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:625:2: ( ( rule__ListType__Group_0__0 ) )
                    // InternalDataDsl.g:626:3: ( rule__ListType__Group_0__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:627:3: ( rule__ListType__Group_0__0 )
                    // InternalDataDsl.g:627:4: rule__ListType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ListType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getListTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:631:2: ( ( rule__ListType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:631:2: ( ( rule__ListType__Group_1__0 ) )
                    // InternalDataDsl.g:632:3: ( rule__ListType__Group_1__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:633:3: ( rule__ListType__Group_1__0 )
                    // InternalDataDsl.g:633:4: rule__ListType__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ListType__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getListTypeAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Alternatives"


    // $ANTLR start "rule__DataField__Alternatives_1"
    // InternalDataDsl.g:641:1: rule__DataField__Alternatives_1 : ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) | ( ( rule__DataField__ImportedComplexTypeAssignment_1_2 ) ) );
    public final void rule__DataField__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:645:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) | ( ( rule__DataField__ImportedComplexTypeAssignment_1_2 ) ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=33 && LA12_0<=42)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==32) ) {
                    alt12=3;
                }
                else if ( (LA12_2==RULE_ID||LA12_2==43) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalDataDsl.g:646:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    {
                    // InternalDataDsl.g:646:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    // InternalDataDsl.g:647:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_1_0()); 
                    // InternalDataDsl.g:648:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    // InternalDataDsl.g:648:4: rule__DataField__PrimitiveTypeAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__PrimitiveTypeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:652:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    {
                    // InternalDataDsl.g:652:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    // InternalDataDsl.g:653:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    {
                     before(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 
                    // InternalDataDsl.g:654:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    // InternalDataDsl.g:654:4: rule__DataField__ComplexTypeAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__ComplexTypeAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:658:2: ( ( rule__DataField__ImportedComplexTypeAssignment_1_2 ) )
                    {
                    // InternalDataDsl.g:658:2: ( ( rule__DataField__ImportedComplexTypeAssignment_1_2 ) )
                    // InternalDataDsl.g:659:3: ( rule__DataField__ImportedComplexTypeAssignment_1_2 )
                    {
                     before(grammarAccess.getDataFieldAccess().getImportedComplexTypeAssignment_1_2()); 
                    // InternalDataDsl.g:660:3: ( rule__DataField__ImportedComplexTypeAssignment_1_2 )
                    // InternalDataDsl.g:660:4: rule__DataField__ImportedComplexTypeAssignment_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__ImportedComplexTypeAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getImportedComplexTypeAssignment_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Alternatives_1"


    // $ANTLR start "rule__DataOperation__Alternatives_1"
    // InternalDataDsl.g:668:1: rule__DataOperation__Alternatives_1 : ( ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) ) | ( ( rule__DataOperation__Group_1_1__0 ) ) );
    public final void rule__DataOperation__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:672:1: ( ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) ) | ( ( rule__DataOperation__Group_1_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==45) ) {
                alt13=1;
            }
            else if ( (LA13_0==31) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDsl.g:673:2: ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) )
                    {
                    // InternalDataDsl.g:673:2: ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) )
                    // InternalDataDsl.g:674:3: ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeAssignment_1_0()); 
                    // InternalDataDsl.g:675:3: ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 )
                    // InternalDataDsl.g:675:4: rule__DataOperation__HasNoReturnTypeAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__HasNoReturnTypeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationAccess().getHasNoReturnTypeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:679:2: ( ( rule__DataOperation__Group_1_1__0 ) )
                    {
                    // InternalDataDsl.g:679:2: ( ( rule__DataOperation__Group_1_1__0 ) )
                    // InternalDataDsl.g:680:3: ( rule__DataOperation__Group_1_1__0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getGroup_1_1()); 
                    // InternalDataDsl.g:681:3: ( rule__DataOperation__Group_1_1__0 )
                    // InternalDataDsl.g:681:4: rule__DataOperation__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Alternatives_1"


    // $ANTLR start "rule__DataOperation__Alternatives_1_1_1"
    // InternalDataDsl.g:689:1: rule__DataOperation__Alternatives_1_1_1 : ( ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) ) | ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) ) | ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) ) );
    public final void rule__DataOperation__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:693:1: ( ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) ) | ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) ) | ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) ) )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=33 && LA14_0<=42)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==32) ) {
                    alt14=3;
                }
                else if ( (LA14_2==RULE_ID||LA14_2==43) ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalDataDsl.g:694:2: ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) )
                    {
                    // InternalDataDsl.g:694:2: ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) )
                    // InternalDataDsl.g:695:3: ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypeAssignment_1_1_1_0()); 
                    // InternalDataDsl.g:696:3: ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 )
                    // InternalDataDsl.g:696:4: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypeAssignment_1_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:700:2: ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) )
                    {
                    // InternalDataDsl.g:700:2: ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) )
                    // InternalDataDsl.g:701:3: ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 )
                    {
                     before(grammarAccess.getDataOperationAccess().getComplexReturnTypeAssignment_1_1_1_1()); 
                    // InternalDataDsl.g:702:3: ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 )
                    // InternalDataDsl.g:702:4: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationAccess().getComplexReturnTypeAssignment_1_1_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:706:2: ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) )
                    {
                    // InternalDataDsl.g:706:2: ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) )
                    // InternalDataDsl.g:707:3: ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 )
                    {
                     before(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeAssignment_1_1_1_2()); 
                    // InternalDataDsl.g:708:3: ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 )
                    // InternalDataDsl.g:708:4: rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeAssignment_1_1_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Alternatives_1_1_1"


    // $ANTLR start "rule__DataOperationParameter__Alternatives_0"
    // InternalDataDsl.g:716:1: rule__DataOperationParameter__Alternatives_0 : ( ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) ) | ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) ) | ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) ) );
    public final void rule__DataOperationParameter__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:720:1: ( ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) ) | ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) ) | ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=33 && LA15_0<=42)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==32) ) {
                    alt15=3;
                }
                else if ( (LA15_2==RULE_ID||LA15_2==43) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDsl.g:721:2: ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) )
                    {
                    // InternalDataDsl.g:721:2: ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) )
                    // InternalDataDsl.g:722:3: ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypeAssignment_0_0()); 
                    // InternalDataDsl.g:723:3: ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 )
                    // InternalDataDsl.g:723:4: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperationParameter__PrimitiveTypeAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypeAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:727:2: ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) )
                    {
                    // InternalDataDsl.g:727:2: ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) )
                    // InternalDataDsl.g:728:3: ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getComplexTypeAssignment_0_1()); 
                    // InternalDataDsl.g:729:3: ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 )
                    // InternalDataDsl.g:729:4: rule__DataOperationParameter__ComplexTypeAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperationParameter__ComplexTypeAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationParameterAccess().getComplexTypeAssignment_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:733:2: ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) )
                    {
                    // InternalDataDsl.g:733:2: ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) )
                    // InternalDataDsl.g:734:3: ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeAssignment_0_2()); 
                    // InternalDataDsl.g:735:3: ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 )
                    // InternalDataDsl.g:735:4: rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeAssignment_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__Alternatives_0"


    // $ANTLR start "rule__PrimitiveValue__Alternatives"
    // InternalDataDsl.g:743:1: rule__PrimitiveValue__Alternatives : ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) );
    public final void rule__PrimitiveValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:747:1: ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt16=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt16=2;
                }
                break;
            case RULE_STRING:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalDataDsl.g:748:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    {
                    // InternalDataDsl.g:748:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    // InternalDataDsl.g:749:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0()); 
                    // InternalDataDsl.g:750:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    // InternalDataDsl.g:750:4: rule__PrimitiveValue__NumericValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveValue__NumericValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:754:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    {
                    // InternalDataDsl.g:754:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    // InternalDataDsl.g:755:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1()); 
                    // InternalDataDsl.g:756:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    // InternalDataDsl.g:756:4: rule__PrimitiveValue__BooleanValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveValue__BooleanValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:760:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    {
                    // InternalDataDsl.g:760:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    // InternalDataDsl.g:761:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2()); 
                    // InternalDataDsl.g:762:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    // InternalDataDsl.g:762:4: rule__PrimitiveValue__StringValueAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveValue__StringValueAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValue__Alternatives"


    // $ANTLR start "rule__PrimitiveType__Alternatives"
    // InternalDataDsl.g:770:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:774:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) )
            int alt17=10;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt17=1;
                }
                break;
            case 34:
                {
                alt17=2;
                }
                break;
            case 35:
                {
                alt17=3;
                }
                break;
            case 36:
                {
                alt17=4;
                }
                break;
            case 37:
                {
                alt17=5;
                }
                break;
            case 38:
                {
                alt17=6;
                }
                break;
            case 39:
                {
                alt17=7;
                }
                break;
            case 40:
                {
                alt17=8;
                }
                break;
            case 41:
                {
                alt17=9;
                }
                break;
            case 42:
                {
                alt17=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalDataDsl.g:775:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:775:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalDataDsl.g:776:3: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:777:3: ( rule__PrimitiveType__Group_0__0 )
                    // InternalDataDsl.g:777:4: rule__PrimitiveType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:781:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:781:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalDataDsl.g:782:3: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:783:3: ( rule__PrimitiveType__Group_1__0 )
                    // InternalDataDsl.g:783:4: rule__PrimitiveType__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:787:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalDataDsl.g:787:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalDataDsl.g:788:3: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalDataDsl.g:789:3: ( rule__PrimitiveType__Group_2__0 )
                    // InternalDataDsl.g:789:4: rule__PrimitiveType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:793:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalDataDsl.g:793:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalDataDsl.g:794:3: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalDataDsl.g:795:3: ( rule__PrimitiveType__Group_3__0 )
                    // InternalDataDsl.g:795:4: rule__PrimitiveType__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDsl.g:799:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    {
                    // InternalDataDsl.g:799:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    // InternalDataDsl.g:800:3: ( rule__PrimitiveType__Group_4__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 
                    // InternalDataDsl.g:801:3: ( rule__PrimitiveType__Group_4__0 )
                    // InternalDataDsl.g:801:4: rule__PrimitiveType__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDsl.g:805:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    {
                    // InternalDataDsl.g:805:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    // InternalDataDsl.g:806:3: ( rule__PrimitiveType__Group_5__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 
                    // InternalDataDsl.g:807:3: ( rule__PrimitiveType__Group_5__0 )
                    // InternalDataDsl.g:807:4: rule__PrimitiveType__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDsl.g:811:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    {
                    // InternalDataDsl.g:811:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    // InternalDataDsl.g:812:3: ( rule__PrimitiveType__Group_6__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 
                    // InternalDataDsl.g:813:3: ( rule__PrimitiveType__Group_6__0 )
                    // InternalDataDsl.g:813:4: rule__PrimitiveType__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDsl.g:817:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    {
                    // InternalDataDsl.g:817:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    // InternalDataDsl.g:818:3: ( rule__PrimitiveType__Group_7__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 
                    // InternalDataDsl.g:819:3: ( rule__PrimitiveType__Group_7__0 )
                    // InternalDataDsl.g:819:4: rule__PrimitiveType__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDsl.g:823:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    {
                    // InternalDataDsl.g:823:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    // InternalDataDsl.g:824:3: ( rule__PrimitiveType__Group_8__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 
                    // InternalDataDsl.g:825:3: ( rule__PrimitiveType__Group_8__0 )
                    // InternalDataDsl.g:825:4: rule__PrimitiveType__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDsl.g:829:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    {
                    // InternalDataDsl.g:829:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    // InternalDataDsl.g:830:3: ( rule__PrimitiveType__Group_9__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 
                    // InternalDataDsl.g:831:3: ( rule__PrimitiveType__Group_9__0 )
                    // InternalDataDsl.g:831:4: rule__PrimitiveType__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Alternatives"


    // $ANTLR start "rule__DataModel__Group__0"
    // InternalDataDsl.g:839:1: rule__DataModel__Group__0 : rule__DataModel__Group__0__Impl rule__DataModel__Group__1 ;
    public final void rule__DataModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:843:1: ( rule__DataModel__Group__0__Impl rule__DataModel__Group__1 )
            // InternalDataDsl.g:844:2: rule__DataModel__Group__0__Impl rule__DataModel__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__DataModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__Group__0"


    // $ANTLR start "rule__DataModel__Group__0__Impl"
    // InternalDataDsl.g:851:1: rule__DataModel__Group__0__Impl : ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) ;
    public final void rule__DataModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:855:1: ( ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) )
            // InternalDataDsl.g:856:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            {
            // InternalDataDsl.g:856:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            // InternalDataDsl.g:857:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            {
             before(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0()); 
            // InternalDataDsl.g:858:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==14) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDsl.g:858:3: rule__DataModel__ComplexTypeImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataModel__ComplexTypeImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__Group__0__Impl"


    // $ANTLR start "rule__DataModel__Group__1"
    // InternalDataDsl.g:866:1: rule__DataModel__Group__1 : rule__DataModel__Group__1__Impl ;
    public final void rule__DataModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:870:1: ( rule__DataModel__Group__1__Impl )
            // InternalDataDsl.g:871:2: rule__DataModel__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataModel__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__Group__1"


    // $ANTLR start "rule__DataModel__Group__1__Impl"
    // InternalDataDsl.g:877:1: rule__DataModel__Group__1__Impl : ( ( rule__DataModel__Alternatives_1 ) ) ;
    public final void rule__DataModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:881:1: ( ( ( rule__DataModel__Alternatives_1 ) ) )
            // InternalDataDsl.g:882:1: ( ( rule__DataModel__Alternatives_1 ) )
            {
            // InternalDataDsl.g:882:1: ( ( rule__DataModel__Alternatives_1 ) )
            // InternalDataDsl.g:883:2: ( rule__DataModel__Alternatives_1 )
            {
             before(grammarAccess.getDataModelAccess().getAlternatives_1()); 
            // InternalDataDsl.g:884:2: ( rule__DataModel__Alternatives_1 )
            // InternalDataDsl.g:884:3: rule__DataModel__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__DataModel__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getDataModelAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__Group__1__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__0"
    // InternalDataDsl.g:893:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:897:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalDataDsl.g:898:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ComplexTypeImport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__0"


    // $ANTLR start "rule__ComplexTypeImport__Group__0__Impl"
    // InternalDataDsl.g:905:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:909:1: ( ( 'import' ) )
            // InternalDataDsl.g:910:1: ( 'import' )
            {
            // InternalDataDsl.g:910:1: ( 'import' )
            // InternalDataDsl.g:911:2: 'import'
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getComplexTypeImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__0__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__1"
    // InternalDataDsl.g:920:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:924:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalDataDsl.g:925:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__ComplexTypeImport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__1"


    // $ANTLR start "rule__ComplexTypeImport__Group__1__Impl"
    // InternalDataDsl.g:932:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:936:1: ( ( 'datatypes' ) )
            // InternalDataDsl.g:937:1: ( 'datatypes' )
            {
            // InternalDataDsl.g:937:1: ( 'datatypes' )
            // InternalDataDsl.g:938:2: 'datatypes'
            {
             before(grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__1__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__2"
    // InternalDataDsl.g:947:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:951:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalDataDsl.g:952:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__ComplexTypeImport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__2"


    // $ANTLR start "rule__ComplexTypeImport__Group__2__Impl"
    // InternalDataDsl.g:959:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:963:1: ( ( 'from' ) )
            // InternalDataDsl.g:964:1: ( 'from' )
            {
            // InternalDataDsl.g:964:1: ( 'from' )
            // InternalDataDsl.g:965:2: 'from'
            {
             before(grammarAccess.getComplexTypeImportAccess().getFromKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getComplexTypeImportAccess().getFromKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__2__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__3"
    // InternalDataDsl.g:974:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:978:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalDataDsl.g:979:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__ComplexTypeImport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__3"


    // $ANTLR start "rule__ComplexTypeImport__Group__3__Impl"
    // InternalDataDsl.g:986:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:990:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalDataDsl.g:991:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalDataDsl.g:991:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalDataDsl.g:992:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalDataDsl.g:993:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalDataDsl.g:993:3: rule__ComplexTypeImport__ImportURIAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__ImportURIAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__3__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__4"
    // InternalDataDsl.g:1001:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1005:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalDataDsl.g:1006:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__ComplexTypeImport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__4"


    // $ANTLR start "rule__ComplexTypeImport__Group__4__Impl"
    // InternalDataDsl.g:1013:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1017:1: ( ( 'as' ) )
            // InternalDataDsl.g:1018:1: ( 'as' )
            {
            // InternalDataDsl.g:1018:1: ( 'as' )
            // InternalDataDsl.g:1019:2: 'as'
            {
             before(grammarAccess.getComplexTypeImportAccess().getAsKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getComplexTypeImportAccess().getAsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__4__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__5"
    // InternalDataDsl.g:1028:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1032:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalDataDsl.g:1033:2: rule__ComplexTypeImport__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__5"


    // $ANTLR start "rule__ComplexTypeImport__Group__5__Impl"
    // InternalDataDsl.g:1039:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1043:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalDataDsl.g:1044:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalDataDsl.g:1044:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalDataDsl.g:1045:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalDataDsl.g:1046:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalDataDsl.g:1046:3: rule__ComplexTypeImport__NameAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__ComplexTypeImport__NameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__Group__5__Impl"


    // $ANTLR start "rule__Version__Group__0"
    // InternalDataDsl.g:1055:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1059:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalDataDsl.g:1060:2: rule__Version__Group__0__Impl rule__Version__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Version__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Version__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__0"


    // $ANTLR start "rule__Version__Group__0__Impl"
    // InternalDataDsl.g:1067:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1071:1: ( ( 'version' ) )
            // InternalDataDsl.g:1072:1: ( 'version' )
            {
            // InternalDataDsl.g:1072:1: ( 'version' )
            // InternalDataDsl.g:1073:2: 'version'
            {
             before(grammarAccess.getVersionAccess().getVersionKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getVersionAccess().getVersionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__0__Impl"


    // $ANTLR start "rule__Version__Group__1"
    // InternalDataDsl.g:1082:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1086:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalDataDsl.g:1087:2: rule__Version__Group__1__Impl rule__Version__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Version__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Version__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__1"


    // $ANTLR start "rule__Version__Group__1__Impl"
    // InternalDataDsl.g:1094:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1098:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1099:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1099:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalDataDsl.g:1100:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1101:2: ( rule__Version__NameAssignment_1 )
            // InternalDataDsl.g:1101:3: rule__Version__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Version__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVersionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__1__Impl"


    // $ANTLR start "rule__Version__Group__2"
    // InternalDataDsl.g:1109:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1113:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalDataDsl.g:1114:2: rule__Version__Group__2__Impl rule__Version__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Version__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Version__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__2"


    // $ANTLR start "rule__Version__Group__2__Impl"
    // InternalDataDsl.g:1121:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1125:1: ( ( '{' ) )
            // InternalDataDsl.g:1126:1: ( '{' )
            {
            // InternalDataDsl.g:1126:1: ( '{' )
            // InternalDataDsl.g:1127:2: '{'
            {
             before(grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__2__Impl"


    // $ANTLR start "rule__Version__Group__3"
    // InternalDataDsl.g:1136:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1140:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalDataDsl.g:1141:2: rule__Version__Group__3__Impl rule__Version__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__Version__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Version__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__3"


    // $ANTLR start "rule__Version__Group__3__Impl"
    // InternalDataDsl.g:1148:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1152:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalDataDsl.g:1153:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalDataDsl.g:1153:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalDataDsl.g:1154:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalDataDsl.g:1155:2: ( rule__Version__Alternatives_3 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=21 && LA19_0<=22)||LA19_0==25||LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDataDsl.g:1155:3: rule__Version__Alternatives_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Version__Alternatives_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVersionAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__3__Impl"


    // $ANTLR start "rule__Version__Group__4"
    // InternalDataDsl.g:1163:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1167:1: ( rule__Version__Group__4__Impl )
            // InternalDataDsl.g:1168:2: rule__Version__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Version__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__4"


    // $ANTLR start "rule__Version__Group__4__Impl"
    // InternalDataDsl.g:1174:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1178:1: ( ( '}' ) )
            // InternalDataDsl.g:1179:1: ( '}' )
            {
            // InternalDataDsl.g:1179:1: ( '}' )
            // InternalDataDsl.g:1180:2: '}'
            {
             before(grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__Group__4__Impl"


    // $ANTLR start "rule__Context__Group__0"
    // InternalDataDsl.g:1190:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1194:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalDataDsl.g:1195:2: rule__Context__Group__0__Impl rule__Context__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Context__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Context__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__0"


    // $ANTLR start "rule__Context__Group__0__Impl"
    // InternalDataDsl.g:1202:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1206:1: ( ( 'context' ) )
            // InternalDataDsl.g:1207:1: ( 'context' )
            {
            // InternalDataDsl.g:1207:1: ( 'context' )
            // InternalDataDsl.g:1208:2: 'context'
            {
             before(grammarAccess.getContextAccess().getContextKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getContextAccess().getContextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__0__Impl"


    // $ANTLR start "rule__Context__Group__1"
    // InternalDataDsl.g:1217:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1221:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalDataDsl.g:1222:2: rule__Context__Group__1__Impl rule__Context__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Context__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Context__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__1"


    // $ANTLR start "rule__Context__Group__1__Impl"
    // InternalDataDsl.g:1229:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1233:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1234:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1234:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalDataDsl.g:1235:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1236:2: ( rule__Context__NameAssignment_1 )
            // InternalDataDsl.g:1236:3: rule__Context__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Context__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__1__Impl"


    // $ANTLR start "rule__Context__Group__2"
    // InternalDataDsl.g:1244:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1248:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalDataDsl.g:1249:2: rule__Context__Group__2__Impl rule__Context__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Context__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Context__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__2"


    // $ANTLR start "rule__Context__Group__2__Impl"
    // InternalDataDsl.g:1256:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1260:1: ( ( '{' ) )
            // InternalDataDsl.g:1261:1: ( '{' )
            {
            // InternalDataDsl.g:1261:1: ( '{' )
            // InternalDataDsl.g:1262:2: '{'
            {
             before(grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__2__Impl"


    // $ANTLR start "rule__Context__Group__3"
    // InternalDataDsl.g:1271:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1275:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalDataDsl.g:1276:2: rule__Context__Group__3__Impl rule__Context__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__Context__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Context__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__3"


    // $ANTLR start "rule__Context__Group__3__Impl"
    // InternalDataDsl.g:1283:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1287:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalDataDsl.g:1288:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalDataDsl.g:1288:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalDataDsl.g:1289:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalDataDsl.g:1289:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalDataDsl.g:1290:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1291:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalDataDsl.g:1291:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_5);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalDataDsl.g:1294:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalDataDsl.g:1295:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1296:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==22||LA20_0==25||LA20_0==28) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDataDsl.g:1296:4: rule__Context__ComplexTypesAssignment_3
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Context__ComplexTypesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__3__Impl"


    // $ANTLR start "rule__Context__Group__4"
    // InternalDataDsl.g:1305:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1309:1: ( rule__Context__Group__4__Impl )
            // InternalDataDsl.g:1310:2: rule__Context__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Context__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__4"


    // $ANTLR start "rule__Context__Group__4__Impl"
    // InternalDataDsl.g:1316:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1320:1: ( ( '}' ) )
            // InternalDataDsl.g:1321:1: ( '}' )
            {
            // InternalDataDsl.g:1321:1: ( '}' )
            // InternalDataDsl.g:1322:2: '}'
            {
             before(grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Group__4__Impl"


    // $ANTLR start "rule__DataStructure__Group__0"
    // InternalDataDsl.g:1332:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1336:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalDataDsl.g:1337:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__DataStructure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__0"


    // $ANTLR start "rule__DataStructure__Group__0__Impl"
    // InternalDataDsl.g:1344:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1348:1: ( ( 'structure' ) )
            // InternalDataDsl.g:1349:1: ( 'structure' )
            {
            // InternalDataDsl.g:1349:1: ( 'structure' )
            // InternalDataDsl.g:1350:2: 'structure'
            {
             before(grammarAccess.getDataStructureAccess().getStructureKeyword_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getStructureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__0__Impl"


    // $ANTLR start "rule__DataStructure__Group__1"
    // InternalDataDsl.g:1359:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1363:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalDataDsl.g:1364:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__DataStructure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__1"


    // $ANTLR start "rule__DataStructure__Group__1__Impl"
    // InternalDataDsl.g:1371:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1375:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1376:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1376:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalDataDsl.g:1377:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1378:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalDataDsl.g:1378:3: rule__DataStructure__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__1__Impl"


    // $ANTLR start "rule__DataStructure__Group__2"
    // InternalDataDsl.g:1386:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1390:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalDataDsl.g:1391:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__DataStructure__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__2"


    // $ANTLR start "rule__DataStructure__Group__2__Impl"
    // InternalDataDsl.g:1398:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1402:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalDataDsl.g:1403:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalDataDsl.g:1403:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalDataDsl.g:1404:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalDataDsl.g:1405:2: ( rule__DataStructure__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDsl.g:1405:3: rule__DataStructure__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStructureAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__2__Impl"


    // $ANTLR start "rule__DataStructure__Group__3"
    // InternalDataDsl.g:1413:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1417:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalDataDsl.g:1418:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__DataStructure__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__3"


    // $ANTLR start "rule__DataStructure__Group__3__Impl"
    // InternalDataDsl.g:1425:1: rule__DataStructure__Group__3__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1429:1: ( ( '{' ) )
            // InternalDataDsl.g:1430:1: ( '{' )
            {
            // InternalDataDsl.g:1430:1: ( '{' )
            // InternalDataDsl.g:1431:2: '{'
            {
             before(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__3__Impl"


    // $ANTLR start "rule__DataStructure__Group__4"
    // InternalDataDsl.g:1440:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1444:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalDataDsl.g:1445:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__DataStructure__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__4"


    // $ANTLR start "rule__DataStructure__Group__4__Impl"
    // InternalDataDsl.g:1452:1: rule__DataStructure__Group__4__Impl : ( ( rule__DataStructure__Group_4__0 )? ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1456:1: ( ( ( rule__DataStructure__Group_4__0 )? ) )
            // InternalDataDsl.g:1457:1: ( ( rule__DataStructure__Group_4__0 )? )
            {
            // InternalDataDsl.g:1457:1: ( ( rule__DataStructure__Group_4__0 )? )
            // InternalDataDsl.g:1458:2: ( rule__DataStructure__Group_4__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4()); 
            // InternalDataDsl.g:1459:2: ( rule__DataStructure__Group_4__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID||LA22_0==31||(LA22_0>=33 && LA22_0<=42)||(LA22_0>=44 && LA22_0<=45)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDsl.g:1459:3: rule__DataStructure__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStructureAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__4__Impl"


    // $ANTLR start "rule__DataStructure__Group__5"
    // InternalDataDsl.g:1467:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1471:1: ( rule__DataStructure__Group__5__Impl )
            // InternalDataDsl.g:1472:2: rule__DataStructure__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__5"


    // $ANTLR start "rule__DataStructure__Group__5__Impl"
    // InternalDataDsl.g:1478:1: rule__DataStructure__Group__5__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1482:1: ( ( '}' ) )
            // InternalDataDsl.g:1483:1: ( '}' )
            {
            // InternalDataDsl.g:1483:1: ( '}' )
            // InternalDataDsl.g:1484:2: '}'
            {
             before(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__5__Impl"


    // $ANTLR start "rule__DataStructure__Group_2__0"
    // InternalDataDsl.g:1494:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1498:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalDataDsl.g:1499:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
            {
            pushFollow(FOLLOW_12);
            rule__DataStructure__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__0"


    // $ANTLR start "rule__DataStructure__Group_2__0__Impl"
    // InternalDataDsl.g:1506:1: rule__DataStructure__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1510:1: ( ( 'extends' ) )
            // InternalDataDsl.g:1511:1: ( 'extends' )
            {
            // InternalDataDsl.g:1511:1: ( 'extends' )
            // InternalDataDsl.g:1512:2: 'extends'
            {
             before(grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_2__1"
    // InternalDataDsl.g:1521:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1525:1: ( rule__DataStructure__Group_2__1__Impl )
            // InternalDataDsl.g:1526:2: rule__DataStructure__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__1"


    // $ANTLR start "rule__DataStructure__Group_2__1__Impl"
    // InternalDataDsl.g:1532:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__SuperAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1536:1: ( ( ( rule__DataStructure__SuperAssignment_2_1 ) ) )
            // InternalDataDsl.g:1537:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            {
            // InternalDataDsl.g:1537:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            // InternalDataDsl.g:1538:2: ( rule__DataStructure__SuperAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_2_1()); 
            // InternalDataDsl.g:1539:2: ( rule__DataStructure__SuperAssignment_2_1 )
            // InternalDataDsl.g:1539:3: rule__DataStructure__SuperAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__SuperAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getSuperAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4__0"
    // InternalDataDsl.g:1548:1: rule__DataStructure__Group_4__0 : rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 ;
    public final void rule__DataStructure__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1552:1: ( rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 )
            // InternalDataDsl.g:1553:2: rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1
            {
            pushFollow(FOLLOW_19);
            rule__DataStructure__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4__0"


    // $ANTLR start "rule__DataStructure__Group_4__0__Impl"
    // InternalDataDsl.g:1560:1: rule__DataStructure__Group_4__0__Impl : ( ( rule__DataStructure__Alternatives_4_0 ) ) ;
    public final void rule__DataStructure__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1564:1: ( ( ( rule__DataStructure__Alternatives_4_0 ) ) )
            // InternalDataDsl.g:1565:1: ( ( rule__DataStructure__Alternatives_4_0 ) )
            {
            // InternalDataDsl.g:1565:1: ( ( rule__DataStructure__Alternatives_4_0 ) )
            // InternalDataDsl.g:1566:2: ( rule__DataStructure__Alternatives_4_0 )
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_4_0()); 
            // InternalDataDsl.g:1567:2: ( rule__DataStructure__Alternatives_4_0 )
            // InternalDataDsl.g:1567:3: rule__DataStructure__Alternatives_4_0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Alternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4__1"
    // InternalDataDsl.g:1575:1: rule__DataStructure__Group_4__1 : rule__DataStructure__Group_4__1__Impl ;
    public final void rule__DataStructure__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1579:1: ( rule__DataStructure__Group_4__1__Impl )
            // InternalDataDsl.g:1580:2: rule__DataStructure__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4__1"


    // $ANTLR start "rule__DataStructure__Group_4__1__Impl"
    // InternalDataDsl.g:1586:1: rule__DataStructure__Group_4__1__Impl : ( ( rule__DataStructure__Group_4_1__0 )* ) ;
    public final void rule__DataStructure__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1590:1: ( ( ( rule__DataStructure__Group_4_1__0 )* ) )
            // InternalDataDsl.g:1591:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            {
            // InternalDataDsl.g:1591:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            // InternalDataDsl.g:1592:2: ( rule__DataStructure__Group_4_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_1()); 
            // InternalDataDsl.g:1593:2: ( rule__DataStructure__Group_4_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDsl.g:1593:3: rule__DataStructure__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__DataStructure__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_1__0"
    // InternalDataDsl.g:1602:1: rule__DataStructure__Group_4_1__0 : rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 ;
    public final void rule__DataStructure__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1606:1: ( rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 )
            // InternalDataDsl.g:1607:2: rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1
            {
            pushFollow(FOLLOW_21);
            rule__DataStructure__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4_1__0"


    // $ANTLR start "rule__DataStructure__Group_4_1__0__Impl"
    // InternalDataDsl.g:1614:1: rule__DataStructure__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1618:1: ( ( ',' ) )
            // InternalDataDsl.g:1619:1: ( ',' )
            {
            // InternalDataDsl.g:1619:1: ( ',' )
            // InternalDataDsl.g:1620:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4_1__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_1__1"
    // InternalDataDsl.g:1629:1: rule__DataStructure__Group_4_1__1 : rule__DataStructure__Group_4_1__1__Impl ;
    public final void rule__DataStructure__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1633:1: ( rule__DataStructure__Group_4_1__1__Impl )
            // InternalDataDsl.g:1634:2: rule__DataStructure__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4_1__1"


    // $ANTLR start "rule__DataStructure__Group_4_1__1__Impl"
    // InternalDataDsl.g:1640:1: rule__DataStructure__Group_4_1__1__Impl : ( ( rule__DataStructure__Alternatives_4_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1644:1: ( ( ( rule__DataStructure__Alternatives_4_1_1 ) ) )
            // InternalDataDsl.g:1645:1: ( ( rule__DataStructure__Alternatives_4_1_1 ) )
            {
            // InternalDataDsl.g:1645:1: ( ( rule__DataStructure__Alternatives_4_1_1 ) )
            // InternalDataDsl.g:1646:2: ( rule__DataStructure__Alternatives_4_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_4_1_1()); 
            // InternalDataDsl.g:1647:2: ( rule__DataStructure__Alternatives_4_1_1 )
            // InternalDataDsl.g:1647:3: rule__DataStructure__Alternatives_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Alternatives_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getAlternatives_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_4_1__1__Impl"


    // $ANTLR start "rule__ListType__Group_0__0"
    // InternalDataDsl.g:1656:1: rule__ListType__Group_0__0 : rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 ;
    public final void rule__ListType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1660:1: ( rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 )
            // InternalDataDsl.g:1661:2: rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1
            {
            pushFollow(FOLLOW_12);
            rule__ListType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__0"


    // $ANTLR start "rule__ListType__Group_0__0__Impl"
    // InternalDataDsl.g:1668:1: rule__ListType__Group_0__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1672:1: ( ( 'list' ) )
            // InternalDataDsl.g:1673:1: ( 'list' )
            {
            // InternalDataDsl.g:1673:1: ( 'list' )
            // InternalDataDsl.g:1674:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_0_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getListKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__0__Impl"


    // $ANTLR start "rule__ListType__Group_0__1"
    // InternalDataDsl.g:1683:1: rule__ListType__Group_0__1 : rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 ;
    public final void rule__ListType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1687:1: ( rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 )
            // InternalDataDsl.g:1688:2: rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2
            {
            pushFollow(FOLLOW_13);
            rule__ListType__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__1"


    // $ANTLR start "rule__ListType__Group_0__1__Impl"
    // InternalDataDsl.g:1695:1: rule__ListType__Group_0__1__Impl : ( ( rule__ListType__NameAssignment_0_1 ) ) ;
    public final void rule__ListType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1699:1: ( ( ( rule__ListType__NameAssignment_0_1 ) ) )
            // InternalDataDsl.g:1700:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            {
            // InternalDataDsl.g:1700:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            // InternalDataDsl.g:1701:2: ( rule__ListType__NameAssignment_0_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 
            // InternalDataDsl.g:1702:2: ( rule__ListType__NameAssignment_0_1 )
            // InternalDataDsl.g:1702:3: rule__ListType__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ListType__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__1__Impl"


    // $ANTLR start "rule__ListType__Group_0__2"
    // InternalDataDsl.g:1710:1: rule__ListType__Group_0__2 : rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 ;
    public final void rule__ListType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1714:1: ( rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 )
            // InternalDataDsl.g:1715:2: rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3
            {
            pushFollow(FOLLOW_22);
            rule__ListType__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__2"


    // $ANTLR start "rule__ListType__Group_0__2__Impl"
    // InternalDataDsl.g:1722:1: rule__ListType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1726:1: ( ( '{' ) )
            // InternalDataDsl.g:1727:1: ( '{' )
            {
            // InternalDataDsl.g:1727:1: ( '{' )
            // InternalDataDsl.g:1728:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__2__Impl"


    // $ANTLR start "rule__ListType__Group_0__3"
    // InternalDataDsl.g:1737:1: rule__ListType__Group_0__3 : rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 ;
    public final void rule__ListType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1741:1: ( rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 )
            // InternalDataDsl.g:1742:2: rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4
            {
            pushFollow(FOLLOW_23);
            rule__ListType__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__3"


    // $ANTLR start "rule__ListType__Group_0__3__Impl"
    // InternalDataDsl.g:1749:1: rule__ListType__Group_0__3__Impl : ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__ListType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1753:1: ( ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) )
            // InternalDataDsl.g:1754:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            {
            // InternalDataDsl.g:1754:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            // InternalDataDsl.g:1755:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalDataDsl.g:1756:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            // InternalDataDsl.g:1756:3: rule__ListType__DataFieldsAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__ListType__DataFieldsAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__3__Impl"


    // $ANTLR start "rule__ListType__Group_0__4"
    // InternalDataDsl.g:1764:1: rule__ListType__Group_0__4 : rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 ;
    public final void rule__ListType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1768:1: ( rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 )
            // InternalDataDsl.g:1769:2: rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5
            {
            pushFollow(FOLLOW_23);
            rule__ListType__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__4"


    // $ANTLR start "rule__ListType__Group_0__4__Impl"
    // InternalDataDsl.g:1776:1: rule__ListType__Group_0__4__Impl : ( ( rule__ListType__Group_0_4__0 )* ) ;
    public final void rule__ListType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1780:1: ( ( ( rule__ListType__Group_0_4__0 )* ) )
            // InternalDataDsl.g:1781:1: ( ( rule__ListType__Group_0_4__0 )* )
            {
            // InternalDataDsl.g:1781:1: ( ( rule__ListType__Group_0_4__0 )* )
            // InternalDataDsl.g:1782:2: ( rule__ListType__Group_0_4__0 )*
            {
             before(grammarAccess.getListTypeAccess().getGroup_0_4()); 
            // InternalDataDsl.g:1783:2: ( rule__ListType__Group_0_4__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==24) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDataDsl.g:1783:3: rule__ListType__Group_0_4__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ListType__Group_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getListTypeAccess().getGroup_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__4__Impl"


    // $ANTLR start "rule__ListType__Group_0__5"
    // InternalDataDsl.g:1791:1: rule__ListType__Group_0__5 : rule__ListType__Group_0__5__Impl ;
    public final void rule__ListType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1795:1: ( rule__ListType__Group_0__5__Impl )
            // InternalDataDsl.g:1796:2: rule__ListType__Group_0__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group_0__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__5"


    // $ANTLR start "rule__ListType__Group_0__5__Impl"
    // InternalDataDsl.g:1802:1: rule__ListType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__ListType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1806:1: ( ( '}' ) )
            // InternalDataDsl.g:1807:1: ( '}' )
            {
            // InternalDataDsl.g:1807:1: ( '}' )
            // InternalDataDsl.g:1808:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0__5__Impl"


    // $ANTLR start "rule__ListType__Group_0_4__0"
    // InternalDataDsl.g:1818:1: rule__ListType__Group_0_4__0 : rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 ;
    public final void rule__ListType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1822:1: ( rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 )
            // InternalDataDsl.g:1823:2: rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1
            {
            pushFollow(FOLLOW_22);
            rule__ListType__Group_0_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_0_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0_4__0"


    // $ANTLR start "rule__ListType__Group_0_4__0__Impl"
    // InternalDataDsl.g:1830:1: rule__ListType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__ListType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1834:1: ( ( ',' ) )
            // InternalDataDsl.g:1835:1: ( ',' )
            {
            // InternalDataDsl.g:1835:1: ( ',' )
            // InternalDataDsl.g:1836:2: ','
            {
             before(grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0_4__0__Impl"


    // $ANTLR start "rule__ListType__Group_0_4__1"
    // InternalDataDsl.g:1845:1: rule__ListType__Group_0_4__1 : rule__ListType__Group_0_4__1__Impl ;
    public final void rule__ListType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1849:1: ( rule__ListType__Group_0_4__1__Impl )
            // InternalDataDsl.g:1850:2: rule__ListType__Group_0_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group_0_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0_4__1"


    // $ANTLR start "rule__ListType__Group_0_4__1__Impl"
    // InternalDataDsl.g:1856:1: rule__ListType__Group_0_4__1__Impl : ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__ListType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1860:1: ( ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalDataDsl.g:1861:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalDataDsl.g:1861:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            // InternalDataDsl.g:1862:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalDataDsl.g:1863:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            // InternalDataDsl.g:1863:3: rule__ListType__DataFieldsAssignment_0_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ListType__DataFieldsAssignment_0_4_1();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_0_4__1__Impl"


    // $ANTLR start "rule__ListType__Group_1__0"
    // InternalDataDsl.g:1872:1: rule__ListType__Group_1__0 : rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 ;
    public final void rule__ListType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1876:1: ( rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 )
            // InternalDataDsl.g:1877:2: rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__ListType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__0"


    // $ANTLR start "rule__ListType__Group_1__0__Impl"
    // InternalDataDsl.g:1884:1: rule__ListType__Group_1__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1888:1: ( ( 'list' ) )
            // InternalDataDsl.g:1889:1: ( 'list' )
            {
            // InternalDataDsl.g:1889:1: ( 'list' )
            // InternalDataDsl.g:1890:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_1_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getListKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__0__Impl"


    // $ANTLR start "rule__ListType__Group_1__1"
    // InternalDataDsl.g:1899:1: rule__ListType__Group_1__1 : rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 ;
    public final void rule__ListType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1903:1: ( rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 )
            // InternalDataDsl.g:1904:2: rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2
            {
            pushFollow(FOLLOW_13);
            rule__ListType__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__1"


    // $ANTLR start "rule__ListType__Group_1__1__Impl"
    // InternalDataDsl.g:1911:1: rule__ListType__Group_1__1__Impl : ( ( rule__ListType__NameAssignment_1_1 ) ) ;
    public final void rule__ListType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1915:1: ( ( ( rule__ListType__NameAssignment_1_1 ) ) )
            // InternalDataDsl.g:1916:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            {
            // InternalDataDsl.g:1916:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            // InternalDataDsl.g:1917:2: ( rule__ListType__NameAssignment_1_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 
            // InternalDataDsl.g:1918:2: ( rule__ListType__NameAssignment_1_1 )
            // InternalDataDsl.g:1918:3: rule__ListType__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ListType__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__1__Impl"


    // $ANTLR start "rule__ListType__Group_1__2"
    // InternalDataDsl.g:1926:1: rule__ListType__Group_1__2 : rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 ;
    public final void rule__ListType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1930:1: ( rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 )
            // InternalDataDsl.g:1931:2: rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3
            {
            pushFollow(FOLLOW_24);
            rule__ListType__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__2"


    // $ANTLR start "rule__ListType__Group_1__2__Impl"
    // InternalDataDsl.g:1938:1: rule__ListType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1942:1: ( ( '{' ) )
            // InternalDataDsl.g:1943:1: ( '{' )
            {
            // InternalDataDsl.g:1943:1: ( '{' )
            // InternalDataDsl.g:1944:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__2__Impl"


    // $ANTLR start "rule__ListType__Group_1__3"
    // InternalDataDsl.g:1953:1: rule__ListType__Group_1__3 : rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 ;
    public final void rule__ListType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1957:1: ( rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 )
            // InternalDataDsl.g:1958:2: rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4
            {
            pushFollow(FOLLOW_16);
            rule__ListType__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListType__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__3"


    // $ANTLR start "rule__ListType__Group_1__3__Impl"
    // InternalDataDsl.g:1965:1: rule__ListType__Group_1__3__Impl : ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__ListType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1969:1: ( ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalDataDsl.g:1970:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalDataDsl.g:1970:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            // InternalDataDsl.g:1971:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalDataDsl.g:1972:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            // InternalDataDsl.g:1972:3: rule__ListType__PrimitiveTypeAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__ListType__PrimitiveTypeAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__3__Impl"


    // $ANTLR start "rule__ListType__Group_1__4"
    // InternalDataDsl.g:1980:1: rule__ListType__Group_1__4 : rule__ListType__Group_1__4__Impl ;
    public final void rule__ListType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1984:1: ( rule__ListType__Group_1__4__Impl )
            // InternalDataDsl.g:1985:2: rule__ListType__Group_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListType__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__4"


    // $ANTLR start "rule__ListType__Group_1__4__Impl"
    // InternalDataDsl.g:1991:1: rule__ListType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__ListType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1995:1: ( ( '}' ) )
            // InternalDataDsl.g:1996:1: ( '}' )
            {
            // InternalDataDsl.g:1996:1: ( '}' )
            // InternalDataDsl.g:1997:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__Group_1__4__Impl"


    // $ANTLR start "rule__DataField__Group__0"
    // InternalDataDsl.g:2007:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2011:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalDataDsl.g:2012:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__DataField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__0"


    // $ANTLR start "rule__DataField__Group__0__Impl"
    // InternalDataDsl.g:2019:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2023:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:2024:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:2024:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalDataDsl.g:2025:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:2026:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==44) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDsl.g:2026:3: rule__DataField__HiddenAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__HiddenAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__0__Impl"


    // $ANTLR start "rule__DataField__Group__1"
    // InternalDataDsl.g:2034:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2038:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalDataDsl.g:2039:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__DataField__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__1"


    // $ANTLR start "rule__DataField__Group__1__Impl"
    // InternalDataDsl.g:2046:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__Alternatives_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2050:1: ( ( ( rule__DataField__Alternatives_1 )? ) )
            // InternalDataDsl.g:2051:1: ( ( rule__DataField__Alternatives_1 )? )
            {
            // InternalDataDsl.g:2051:1: ( ( rule__DataField__Alternatives_1 )? )
            // InternalDataDsl.g:2052:2: ( rule__DataField__Alternatives_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_1()); 
            // InternalDataDsl.g:2053:2: ( rule__DataField__Alternatives_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=33 && LA26_0<=42)) ) {
                alt26=1;
            }
            else if ( (LA26_0==RULE_ID) ) {
                int LA26_2 = input.LA(2);

                if ( (LA26_2==RULE_ID||LA26_2==32||LA26_2==43) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDsl.g:2053:3: rule__DataField__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__1__Impl"


    // $ANTLR start "rule__DataField__Group__2"
    // InternalDataDsl.g:2061:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl rule__DataField__Group__3 ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2065:1: ( rule__DataField__Group__2__Impl rule__DataField__Group__3 )
            // InternalDataDsl.g:2066:2: rule__DataField__Group__2__Impl rule__DataField__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__DataField__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__2"


    // $ANTLR start "rule__DataField__Group__2__Impl"
    // InternalDataDsl.g:2073:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__NameAssignment_2 ) ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2077:1: ( ( ( rule__DataField__NameAssignment_2 ) ) )
            // InternalDataDsl.g:2078:1: ( ( rule__DataField__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:2078:1: ( ( rule__DataField__NameAssignment_2 ) )
            // InternalDataDsl.g:2079:2: ( rule__DataField__NameAssignment_2 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:2080:2: ( rule__DataField__NameAssignment_2 )
            // InternalDataDsl.g:2080:3: rule__DataField__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataField__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__2__Impl"


    // $ANTLR start "rule__DataField__Group__3"
    // InternalDataDsl.g:2088:1: rule__DataField__Group__3 : rule__DataField__Group__3__Impl ;
    public final void rule__DataField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2092:1: ( rule__DataField__Group__3__Impl )
            // InternalDataDsl.g:2093:2: rule__DataField__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__3"


    // $ANTLR start "rule__DataField__Group__3__Impl"
    // InternalDataDsl.g:2099:1: rule__DataField__Group__3__Impl : ( ( rule__DataField__Group_3__0 )? ) ;
    public final void rule__DataField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2103:1: ( ( ( rule__DataField__Group_3__0 )? ) )
            // InternalDataDsl.g:2104:1: ( ( rule__DataField__Group_3__0 )? )
            {
            // InternalDataDsl.g:2104:1: ( ( rule__DataField__Group_3__0 )? )
            // InternalDataDsl.g:2105:2: ( rule__DataField__Group_3__0 )?
            {
             before(grammarAccess.getDataFieldAccess().getGroup_3()); 
            // InternalDataDsl.g:2106:2: ( rule__DataField__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDsl.g:2106:3: rule__DataField__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__3__Impl"


    // $ANTLR start "rule__DataField__Group_3__0"
    // InternalDataDsl.g:2115:1: rule__DataField__Group_3__0 : rule__DataField__Group_3__0__Impl rule__DataField__Group_3__1 ;
    public final void rule__DataField__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2119:1: ( rule__DataField__Group_3__0__Impl rule__DataField__Group_3__1 )
            // InternalDataDsl.g:2120:2: rule__DataField__Group_3__0__Impl rule__DataField__Group_3__1
            {
            pushFollow(FOLLOW_26);
            rule__DataField__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__0"


    // $ANTLR start "rule__DataField__Group_3__0__Impl"
    // InternalDataDsl.g:2127:1: rule__DataField__Group_3__0__Impl : ( '<' ) ;
    public final void rule__DataField__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2131:1: ( ( '<' ) )
            // InternalDataDsl.g:2132:1: ( '<' )
            {
            // InternalDataDsl.g:2132:1: ( '<' )
            // InternalDataDsl.g:2133:2: '<'
            {
             before(grammarAccess.getDataFieldAccess().getLessThanSignKeyword_3_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getLessThanSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__0__Impl"


    // $ANTLR start "rule__DataField__Group_3__1"
    // InternalDataDsl.g:2142:1: rule__DataField__Group_3__1 : rule__DataField__Group_3__1__Impl rule__DataField__Group_3__2 ;
    public final void rule__DataField__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2146:1: ( rule__DataField__Group_3__1__Impl rule__DataField__Group_3__2 )
            // InternalDataDsl.g:2147:2: rule__DataField__Group_3__1__Impl rule__DataField__Group_3__2
            {
            pushFollow(FOLLOW_27);
            rule__DataField__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__1"


    // $ANTLR start "rule__DataField__Group_3__1__Impl"
    // InternalDataDsl.g:2154:1: rule__DataField__Group_3__1__Impl : ( ( rule__DataField__FeaturesAssignment_3_1 ) ) ;
    public final void rule__DataField__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2158:1: ( ( ( rule__DataField__FeaturesAssignment_3_1 ) ) )
            // InternalDataDsl.g:2159:1: ( ( rule__DataField__FeaturesAssignment_3_1 ) )
            {
            // InternalDataDsl.g:2159:1: ( ( rule__DataField__FeaturesAssignment_3_1 ) )
            // InternalDataDsl.g:2160:2: ( rule__DataField__FeaturesAssignment_3_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_3_1()); 
            // InternalDataDsl.g:2161:2: ( rule__DataField__FeaturesAssignment_3_1 )
            // InternalDataDsl.g:2161:3: rule__DataField__FeaturesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__FeaturesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getFeaturesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__1__Impl"


    // $ANTLR start "rule__DataField__Group_3__2"
    // InternalDataDsl.g:2169:1: rule__DataField__Group_3__2 : rule__DataField__Group_3__2__Impl rule__DataField__Group_3__3 ;
    public final void rule__DataField__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2173:1: ( rule__DataField__Group_3__2__Impl rule__DataField__Group_3__3 )
            // InternalDataDsl.g:2174:2: rule__DataField__Group_3__2__Impl rule__DataField__Group_3__3
            {
            pushFollow(FOLLOW_27);
            rule__DataField__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__2"


    // $ANTLR start "rule__DataField__Group_3__2__Impl"
    // InternalDataDsl.g:2181:1: rule__DataField__Group_3__2__Impl : ( ( rule__DataField__Group_3_2__0 )* ) ;
    public final void rule__DataField__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2185:1: ( ( ( rule__DataField__Group_3_2__0 )* ) )
            // InternalDataDsl.g:2186:1: ( ( rule__DataField__Group_3_2__0 )* )
            {
            // InternalDataDsl.g:2186:1: ( ( rule__DataField__Group_3_2__0 )* )
            // InternalDataDsl.g:2187:2: ( rule__DataField__Group_3_2__0 )*
            {
             before(grammarAccess.getDataFieldAccess().getGroup_3_2()); 
            // InternalDataDsl.g:2188:2: ( rule__DataField__Group_3_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==24) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDsl.g:2188:3: rule__DataField__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__DataField__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getDataFieldAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__2__Impl"


    // $ANTLR start "rule__DataField__Group_3__3"
    // InternalDataDsl.g:2196:1: rule__DataField__Group_3__3 : rule__DataField__Group_3__3__Impl ;
    public final void rule__DataField__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2200:1: ( rule__DataField__Group_3__3__Impl )
            // InternalDataDsl.g:2201:2: rule__DataField__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__3"


    // $ANTLR start "rule__DataField__Group_3__3__Impl"
    // InternalDataDsl.g:2207:1: rule__DataField__Group_3__3__Impl : ( '>' ) ;
    public final void rule__DataField__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2211:1: ( ( '>' ) )
            // InternalDataDsl.g:2212:1: ( '>' )
            {
            // InternalDataDsl.g:2212:1: ( '>' )
            // InternalDataDsl.g:2213:2: '>'
            {
             before(grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_3_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3__3__Impl"


    // $ANTLR start "rule__DataField__Group_3_2__0"
    // InternalDataDsl.g:2223:1: rule__DataField__Group_3_2__0 : rule__DataField__Group_3_2__0__Impl rule__DataField__Group_3_2__1 ;
    public final void rule__DataField__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2227:1: ( rule__DataField__Group_3_2__0__Impl rule__DataField__Group_3_2__1 )
            // InternalDataDsl.g:2228:2: rule__DataField__Group_3_2__0__Impl rule__DataField__Group_3_2__1
            {
            pushFollow(FOLLOW_26);
            rule__DataField__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3_2__0"


    // $ANTLR start "rule__DataField__Group_3_2__0__Impl"
    // InternalDataDsl.g:2235:1: rule__DataField__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__DataField__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2239:1: ( ( ',' ) )
            // InternalDataDsl.g:2240:1: ( ',' )
            {
            // InternalDataDsl.g:2240:1: ( ',' )
            // InternalDataDsl.g:2241:2: ','
            {
             before(grammarAccess.getDataFieldAccess().getCommaKeyword_3_2_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3_2__0__Impl"


    // $ANTLR start "rule__DataField__Group_3_2__1"
    // InternalDataDsl.g:2250:1: rule__DataField__Group_3_2__1 : rule__DataField__Group_3_2__1__Impl ;
    public final void rule__DataField__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2254:1: ( rule__DataField__Group_3_2__1__Impl )
            // InternalDataDsl.g:2255:2: rule__DataField__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3_2__1"


    // $ANTLR start "rule__DataField__Group_3_2__1__Impl"
    // InternalDataDsl.g:2261:1: rule__DataField__Group_3_2__1__Impl : ( ( rule__DataField__FeaturesAssignment_3_2_1 ) ) ;
    public final void rule__DataField__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2265:1: ( ( ( rule__DataField__FeaturesAssignment_3_2_1 ) ) )
            // InternalDataDsl.g:2266:1: ( ( rule__DataField__FeaturesAssignment_3_2_1 ) )
            {
            // InternalDataDsl.g:2266:1: ( ( rule__DataField__FeaturesAssignment_3_2_1 ) )
            // InternalDataDsl.g:2267:2: ( rule__DataField__FeaturesAssignment_3_2_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_3_2_1()); 
            // InternalDataDsl.g:2268:2: ( rule__DataField__FeaturesAssignment_3_2_1 )
            // InternalDataDsl.g:2268:3: rule__DataField__FeaturesAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__FeaturesAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getFeaturesAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_3_2__1__Impl"


    // $ANTLR start "rule__Enumeration__Group__0"
    // InternalDataDsl.g:2277:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2281:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalDataDsl.g:2282:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Enumeration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__0"


    // $ANTLR start "rule__Enumeration__Group__0__Impl"
    // InternalDataDsl.g:2289:1: rule__Enumeration__Group__0__Impl : ( 'enum' ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2293:1: ( ( 'enum' ) )
            // InternalDataDsl.g:2294:1: ( 'enum' )
            {
            // InternalDataDsl.g:2294:1: ( 'enum' )
            // InternalDataDsl.g:2295:2: 'enum'
            {
             before(grammarAccess.getEnumerationAccess().getEnumKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__0__Impl"


    // $ANTLR start "rule__Enumeration__Group__1"
    // InternalDataDsl.g:2304:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2308:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalDataDsl.g:2309:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Enumeration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__1"


    // $ANTLR start "rule__Enumeration__Group__1__Impl"
    // InternalDataDsl.g:2316:1: rule__Enumeration__Group__1__Impl : ( ( rule__Enumeration__NameAssignment_1 ) ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2320:1: ( ( ( rule__Enumeration__NameAssignment_1 ) ) )
            // InternalDataDsl.g:2321:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:2321:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            // InternalDataDsl.g:2322:2: ( rule__Enumeration__NameAssignment_1 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:2323:2: ( rule__Enumeration__NameAssignment_1 )
            // InternalDataDsl.g:2323:3: rule__Enumeration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__1__Impl"


    // $ANTLR start "rule__Enumeration__Group__2"
    // InternalDataDsl.g:2331:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2335:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalDataDsl.g:2336:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Enumeration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__2"


    // $ANTLR start "rule__Enumeration__Group__2__Impl"
    // InternalDataDsl.g:2343:1: rule__Enumeration__Group__2__Impl : ( '{' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2347:1: ( ( '{' ) )
            // InternalDataDsl.g:2348:1: ( '{' )
            {
            // InternalDataDsl.g:2348:1: ( '{' )
            // InternalDataDsl.g:2349:2: '{'
            {
             before(grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__2__Impl"


    // $ANTLR start "rule__Enumeration__Group__3"
    // InternalDataDsl.g:2358:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2362:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalDataDsl.g:2363:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Enumeration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__3"


    // $ANTLR start "rule__Enumeration__Group__3__Impl"
    // InternalDataDsl.g:2370:1: rule__Enumeration__Group__3__Impl : ( ( rule__Enumeration__FieldsAssignment_3 ) ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2374:1: ( ( ( rule__Enumeration__FieldsAssignment_3 ) ) )
            // InternalDataDsl.g:2375:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            {
            // InternalDataDsl.g:2375:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            // InternalDataDsl.g:2376:2: ( rule__Enumeration__FieldsAssignment_3 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_3()); 
            // InternalDataDsl.g:2377:2: ( rule__Enumeration__FieldsAssignment_3 )
            // InternalDataDsl.g:2377:3: rule__Enumeration__FieldsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__FieldsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getFieldsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__3__Impl"


    // $ANTLR start "rule__Enumeration__Group__4"
    // InternalDataDsl.g:2385:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2389:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalDataDsl.g:2390:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__Enumeration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__4"


    // $ANTLR start "rule__Enumeration__Group__4__Impl"
    // InternalDataDsl.g:2397:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2401:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalDataDsl.g:2402:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalDataDsl.g:2402:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalDataDsl.g:2403:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalDataDsl.g:2404:2: ( rule__Enumeration__Group_4__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==24) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDsl.g:2404:3: rule__Enumeration__Group_4__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Enumeration__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getEnumerationAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__4__Impl"


    // $ANTLR start "rule__Enumeration__Group__5"
    // InternalDataDsl.g:2412:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2416:1: ( rule__Enumeration__Group__5__Impl )
            // InternalDataDsl.g:2417:2: rule__Enumeration__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__5"


    // $ANTLR start "rule__Enumeration__Group__5__Impl"
    // InternalDataDsl.g:2423:1: rule__Enumeration__Group__5__Impl : ( '}' ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2427:1: ( ( '}' ) )
            // InternalDataDsl.g:2428:1: ( '}' )
            {
            // InternalDataDsl.g:2428:1: ( '}' )
            // InternalDataDsl.g:2429:2: '}'
            {
             before(grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__5__Impl"


    // $ANTLR start "rule__Enumeration__Group_4__0"
    // InternalDataDsl.g:2439:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2443:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalDataDsl.g:2444:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
            {
            pushFollow(FOLLOW_12);
            rule__Enumeration__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__0"


    // $ANTLR start "rule__Enumeration__Group_4__0__Impl"
    // InternalDataDsl.g:2451:1: rule__Enumeration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2455:1: ( ( ',' ) )
            // InternalDataDsl.g:2456:1: ( ',' )
            {
            // InternalDataDsl.g:2456:1: ( ',' )
            // InternalDataDsl.g:2457:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_4_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__0__Impl"


    // $ANTLR start "rule__Enumeration__Group_4__1"
    // InternalDataDsl.g:2466:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2470:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalDataDsl.g:2471:2: rule__Enumeration__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__1"


    // $ANTLR start "rule__Enumeration__Group_4__1__Impl"
    // InternalDataDsl.g:2477:1: rule__Enumeration__Group_4__1__Impl : ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2481:1: ( ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) )
            // InternalDataDsl.g:2482:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            {
            // InternalDataDsl.g:2482:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            // InternalDataDsl.g:2483:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_4_1()); 
            // InternalDataDsl.g:2484:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            // InternalDataDsl.g:2484:3: rule__Enumeration__FieldsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__FieldsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getFieldsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__1__Impl"


    // $ANTLR start "rule__EnumerationField__Group__0"
    // InternalDataDsl.g:2493:1: rule__EnumerationField__Group__0 : rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 ;
    public final void rule__EnumerationField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2497:1: ( rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 )
            // InternalDataDsl.g:2498:2: rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__EnumerationField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group__0"


    // $ANTLR start "rule__EnumerationField__Group__0__Impl"
    // InternalDataDsl.g:2505:1: rule__EnumerationField__Group__0__Impl : ( ( rule__EnumerationField__NameAssignment_0 ) ) ;
    public final void rule__EnumerationField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2509:1: ( ( ( rule__EnumerationField__NameAssignment_0 ) ) )
            // InternalDataDsl.g:2510:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            {
            // InternalDataDsl.g:2510:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            // InternalDataDsl.g:2511:2: ( rule__EnumerationField__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0()); 
            // InternalDataDsl.g:2512:2: ( rule__EnumerationField__NameAssignment_0 )
            // InternalDataDsl.g:2512:3: rule__EnumerationField__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationField__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group__0__Impl"


    // $ANTLR start "rule__EnumerationField__Group__1"
    // InternalDataDsl.g:2520:1: rule__EnumerationField__Group__1 : rule__EnumerationField__Group__1__Impl ;
    public final void rule__EnumerationField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2524:1: ( rule__EnumerationField__Group__1__Impl )
            // InternalDataDsl.g:2525:2: rule__EnumerationField__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationField__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group__1"


    // $ANTLR start "rule__EnumerationField__Group__1__Impl"
    // InternalDataDsl.g:2531:1: rule__EnumerationField__Group__1__Impl : ( ( rule__EnumerationField__Group_1__0 )? ) ;
    public final void rule__EnumerationField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2535:1: ( ( ( rule__EnumerationField__Group_1__0 )? ) )
            // InternalDataDsl.g:2536:1: ( ( rule__EnumerationField__Group_1__0 )? )
            {
            // InternalDataDsl.g:2536:1: ( ( rule__EnumerationField__Group_1__0 )? )
            // InternalDataDsl.g:2537:2: ( rule__EnumerationField__Group_1__0 )?
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup_1()); 
            // InternalDataDsl.g:2538:2: ( rule__EnumerationField__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDataDsl.g:2538:3: rule__EnumerationField__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EnumerationField__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumerationFieldAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group__1__Impl"


    // $ANTLR start "rule__EnumerationField__Group_1__0"
    // InternalDataDsl.g:2547:1: rule__EnumerationField__Group_1__0 : rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 ;
    public final void rule__EnumerationField__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2551:1: ( rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 )
            // InternalDataDsl.g:2552:2: rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1
            {
            pushFollow(FOLLOW_29);
            rule__EnumerationField__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationField__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group_1__0"


    // $ANTLR start "rule__EnumerationField__Group_1__0__Impl"
    // InternalDataDsl.g:2559:1: rule__EnumerationField__Group_1__0__Impl : ( '(' ) ;
    public final void rule__EnumerationField__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2563:1: ( ( '(' ) )
            // InternalDataDsl.g:2564:1: ( '(' )
            {
            // InternalDataDsl.g:2564:1: ( '(' )
            // InternalDataDsl.g:2565:2: '('
            {
             before(grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group_1__0__Impl"


    // $ANTLR start "rule__EnumerationField__Group_1__1"
    // InternalDataDsl.g:2574:1: rule__EnumerationField__Group_1__1 : rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 ;
    public final void rule__EnumerationField__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2578:1: ( rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 )
            // InternalDataDsl.g:2579:2: rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2
            {
            pushFollow(FOLLOW_30);
            rule__EnumerationField__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationField__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group_1__1"


    // $ANTLR start "rule__EnumerationField__Group_1__1__Impl"
    // InternalDataDsl.g:2586:1: rule__EnumerationField__Group_1__1__Impl : ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) ;
    public final void rule__EnumerationField__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2590:1: ( ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) )
            // InternalDataDsl.g:2591:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            {
            // InternalDataDsl.g:2591:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            // InternalDataDsl.g:2592:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1()); 
            // InternalDataDsl.g:2593:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            // InternalDataDsl.g:2593:3: rule__EnumerationField__InitializationValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationField__InitializationValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group_1__1__Impl"


    // $ANTLR start "rule__EnumerationField__Group_1__2"
    // InternalDataDsl.g:2601:1: rule__EnumerationField__Group_1__2 : rule__EnumerationField__Group_1__2__Impl ;
    public final void rule__EnumerationField__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2605:1: ( rule__EnumerationField__Group_1__2__Impl )
            // InternalDataDsl.g:2606:2: rule__EnumerationField__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationField__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group_1__2"


    // $ANTLR start "rule__EnumerationField__Group_1__2__Impl"
    // InternalDataDsl.g:2612:1: rule__EnumerationField__Group_1__2__Impl : ( ')' ) ;
    public final void rule__EnumerationField__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2616:1: ( ( ')' ) )
            // InternalDataDsl.g:2617:1: ( ')' )
            {
            // InternalDataDsl.g:2617:1: ( ')' )
            // InternalDataDsl.g:2618:2: ')'
            {
             before(grammarAccess.getEnumerationFieldAccess().getRightParenthesisKeyword_1_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getEnumerationFieldAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__Group_1__2__Impl"


    // $ANTLR start "rule__DataOperation__Group__0"
    // InternalDataDsl.g:2628:1: rule__DataOperation__Group__0 : rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 ;
    public final void rule__DataOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2632:1: ( rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 )
            // InternalDataDsl.g:2633:2: rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__DataOperation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__0"


    // $ANTLR start "rule__DataOperation__Group__0__Impl"
    // InternalDataDsl.g:2640:1: rule__DataOperation__Group__0__Impl : ( ( rule__DataOperation__HiddenAssignment_0 )? ) ;
    public final void rule__DataOperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2644:1: ( ( ( rule__DataOperation__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:2645:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:2645:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            // InternalDataDsl.g:2646:2: ( rule__DataOperation__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataOperationAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:2647:2: ( rule__DataOperation__HiddenAssignment_0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDsl.g:2647:3: rule__DataOperation__HiddenAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__HiddenAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataOperationAccess().getHiddenAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__0__Impl"


    // $ANTLR start "rule__DataOperation__Group__1"
    // InternalDataDsl.g:2655:1: rule__DataOperation__Group__1 : rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 ;
    public final void rule__DataOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2659:1: ( rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 )
            // InternalDataDsl.g:2660:2: rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__DataOperation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__1"


    // $ANTLR start "rule__DataOperation__Group__1__Impl"
    // InternalDataDsl.g:2667:1: rule__DataOperation__Group__1__Impl : ( ( rule__DataOperation__Alternatives_1 ) ) ;
    public final void rule__DataOperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2671:1: ( ( ( rule__DataOperation__Alternatives_1 ) ) )
            // InternalDataDsl.g:2672:1: ( ( rule__DataOperation__Alternatives_1 ) )
            {
            // InternalDataDsl.g:2672:1: ( ( rule__DataOperation__Alternatives_1 ) )
            // InternalDataDsl.g:2673:2: ( rule__DataOperation__Alternatives_1 )
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1()); 
            // InternalDataDsl.g:2674:2: ( rule__DataOperation__Alternatives_1 )
            // InternalDataDsl.g:2674:3: rule__DataOperation__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__1__Impl"


    // $ANTLR start "rule__DataOperation__Group__2"
    // InternalDataDsl.g:2682:1: rule__DataOperation__Group__2 : rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 ;
    public final void rule__DataOperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2686:1: ( rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 )
            // InternalDataDsl.g:2687:2: rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__DataOperation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__2"


    // $ANTLR start "rule__DataOperation__Group__2__Impl"
    // InternalDataDsl.g:2694:1: rule__DataOperation__Group__2__Impl : ( ( rule__DataOperation__NameAssignment_2 ) ) ;
    public final void rule__DataOperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2698:1: ( ( ( rule__DataOperation__NameAssignment_2 ) ) )
            // InternalDataDsl.g:2699:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:2699:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            // InternalDataDsl.g:2700:2: ( rule__DataOperation__NameAssignment_2 )
            {
             before(grammarAccess.getDataOperationAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:2701:2: ( rule__DataOperation__NameAssignment_2 )
            // InternalDataDsl.g:2701:3: rule__DataOperation__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__2__Impl"


    // $ANTLR start "rule__DataOperation__Group__3"
    // InternalDataDsl.g:2709:1: rule__DataOperation__Group__3 : rule__DataOperation__Group__3__Impl ;
    public final void rule__DataOperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2713:1: ( rule__DataOperation__Group__3__Impl )
            // InternalDataDsl.g:2714:2: rule__DataOperation__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__3"


    // $ANTLR start "rule__DataOperation__Group__3__Impl"
    // InternalDataDsl.g:2720:1: rule__DataOperation__Group__3__Impl : ( ( rule__DataOperation__Group_3__0 )? ) ;
    public final void rule__DataOperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2724:1: ( ( ( rule__DataOperation__Group_3__0 )? ) )
            // InternalDataDsl.g:2725:1: ( ( rule__DataOperation__Group_3__0 )? )
            {
            // InternalDataDsl.g:2725:1: ( ( rule__DataOperation__Group_3__0 )? )
            // InternalDataDsl.g:2726:2: ( rule__DataOperation__Group_3__0 )?
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3()); 
            // InternalDataDsl.g:2727:2: ( rule__DataOperation__Group_3__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDsl.g:2727:3: rule__DataOperation__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataOperationAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__3__Impl"


    // $ANTLR start "rule__DataOperation__Group_1_1__0"
    // InternalDataDsl.g:2736:1: rule__DataOperation__Group_1_1__0 : rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 ;
    public final void rule__DataOperation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2740:1: ( rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 )
            // InternalDataDsl.g:2741:2: rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1
            {
            pushFollow(FOLLOW_31);
            rule__DataOperation__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_1_1__0"


    // $ANTLR start "rule__DataOperation__Group_1_1__0__Impl"
    // InternalDataDsl.g:2748:1: rule__DataOperation__Group_1_1__0__Impl : ( 'function' ) ;
    public final void rule__DataOperation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2752:1: ( ( 'function' ) )
            // InternalDataDsl.g:2753:1: ( 'function' )
            {
            // InternalDataDsl.g:2753:1: ( 'function' )
            // InternalDataDsl.g:2754:2: 'function'
            {
             before(grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_1_1__0__Impl"


    // $ANTLR start "rule__DataOperation__Group_1_1__1"
    // InternalDataDsl.g:2763:1: rule__DataOperation__Group_1_1__1 : rule__DataOperation__Group_1_1__1__Impl ;
    public final void rule__DataOperation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2767:1: ( rule__DataOperation__Group_1_1__1__Impl )
            // InternalDataDsl.g:2768:2: rule__DataOperation__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_1_1__1"


    // $ANTLR start "rule__DataOperation__Group_1_1__1__Impl"
    // InternalDataDsl.g:2774:1: rule__DataOperation__Group_1_1__1__Impl : ( ( rule__DataOperation__Alternatives_1_1_1 )? ) ;
    public final void rule__DataOperation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2778:1: ( ( ( rule__DataOperation__Alternatives_1_1_1 )? ) )
            // InternalDataDsl.g:2779:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            {
            // InternalDataDsl.g:2779:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            // InternalDataDsl.g:2780:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1_1_1()); 
            // InternalDataDsl.g:2781:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=33 && LA33_0<=42)) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID) ) {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==RULE_ID||LA33_2==32||LA33_2==43) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDsl.g:2781:3: rule__DataOperation__Alternatives_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__Alternatives_1_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataOperationAccess().getAlternatives_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_1_1__1__Impl"


    // $ANTLR start "rule__DataOperation__Group_3__0"
    // InternalDataDsl.g:2790:1: rule__DataOperation__Group_3__0 : rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 ;
    public final void rule__DataOperation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2794:1: ( rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 )
            // InternalDataDsl.g:2795:2: rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1
            {
            pushFollow(FOLLOW_32);
            rule__DataOperation__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__0"


    // $ANTLR start "rule__DataOperation__Group_3__0__Impl"
    // InternalDataDsl.g:2802:1: rule__DataOperation__Group_3__0__Impl : ( '(' ) ;
    public final void rule__DataOperation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2806:1: ( ( '(' ) )
            // InternalDataDsl.g:2807:1: ( '(' )
            {
            // InternalDataDsl.g:2807:1: ( '(' )
            // InternalDataDsl.g:2808:2: '('
            {
             before(grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__0__Impl"


    // $ANTLR start "rule__DataOperation__Group_3__1"
    // InternalDataDsl.g:2817:1: rule__DataOperation__Group_3__1 : rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 ;
    public final void rule__DataOperation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2821:1: ( rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 )
            // InternalDataDsl.g:2822:2: rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2
            {
            pushFollow(FOLLOW_32);
            rule__DataOperation__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__1"


    // $ANTLR start "rule__DataOperation__Group_3__1__Impl"
    // InternalDataDsl.g:2829:1: rule__DataOperation__Group_3__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) ;
    public final void rule__DataOperation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2833:1: ( ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) )
            // InternalDataDsl.g:2834:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            {
            // InternalDataDsl.g:2834:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            // InternalDataDsl.g:2835:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_1()); 
            // InternalDataDsl.g:2836:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID||(LA34_0>=33 && LA34_0<=42)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDataDsl.g:2836:3: rule__DataOperation__ParametersAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__ParametersAssignment_3_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataOperationAccess().getParametersAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__1__Impl"


    // $ANTLR start "rule__DataOperation__Group_3__2"
    // InternalDataDsl.g:2844:1: rule__DataOperation__Group_3__2 : rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 ;
    public final void rule__DataOperation__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2848:1: ( rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 )
            // InternalDataDsl.g:2849:2: rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3
            {
            pushFollow(FOLLOW_32);
            rule__DataOperation__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__2"


    // $ANTLR start "rule__DataOperation__Group_3__2__Impl"
    // InternalDataDsl.g:2856:1: rule__DataOperation__Group_3__2__Impl : ( ( rule__DataOperation__Group_3_2__0 )* ) ;
    public final void rule__DataOperation__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2860:1: ( ( ( rule__DataOperation__Group_3_2__0 )* ) )
            // InternalDataDsl.g:2861:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            {
            // InternalDataDsl.g:2861:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            // InternalDataDsl.g:2862:2: ( rule__DataOperation__Group_3_2__0 )*
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3_2()); 
            // InternalDataDsl.g:2863:2: ( rule__DataOperation__Group_3_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==24) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDsl.g:2863:3: rule__DataOperation__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__DataOperation__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getDataOperationAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__2__Impl"


    // $ANTLR start "rule__DataOperation__Group_3__3"
    // InternalDataDsl.g:2871:1: rule__DataOperation__Group_3__3 : rule__DataOperation__Group_3__3__Impl ;
    public final void rule__DataOperation__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2875:1: ( rule__DataOperation__Group_3__3__Impl )
            // InternalDataDsl.g:2876:2: rule__DataOperation__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__3"


    // $ANTLR start "rule__DataOperation__Group_3__3__Impl"
    // InternalDataDsl.g:2882:1: rule__DataOperation__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DataOperation__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2886:1: ( ( ')' ) )
            // InternalDataDsl.g:2887:1: ( ')' )
            {
            // InternalDataDsl.g:2887:1: ( ')' )
            // InternalDataDsl.g:2888:2: ')'
            {
             before(grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3__3__Impl"


    // $ANTLR start "rule__DataOperation__Group_3_2__0"
    // InternalDataDsl.g:2898:1: rule__DataOperation__Group_3_2__0 : rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 ;
    public final void rule__DataOperation__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2902:1: ( rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 )
            // InternalDataDsl.g:2903:2: rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1
            {
            pushFollow(FOLLOW_31);
            rule__DataOperation__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3_2__0"


    // $ANTLR start "rule__DataOperation__Group_3_2__0__Impl"
    // InternalDataDsl.g:2910:1: rule__DataOperation__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__DataOperation__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2914:1: ( ( ',' ) )
            // InternalDataDsl.g:2915:1: ( ',' )
            {
            // InternalDataDsl.g:2915:1: ( ',' )
            // InternalDataDsl.g:2916:2: ','
            {
             before(grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3_2__0__Impl"


    // $ANTLR start "rule__DataOperation__Group_3_2__1"
    // InternalDataDsl.g:2925:1: rule__DataOperation__Group_3_2__1 : rule__DataOperation__Group_3_2__1__Impl ;
    public final void rule__DataOperation__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2929:1: ( rule__DataOperation__Group_3_2__1__Impl )
            // InternalDataDsl.g:2930:2: rule__DataOperation__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3_2__1"


    // $ANTLR start "rule__DataOperation__Group_3_2__1__Impl"
    // InternalDataDsl.g:2936:1: rule__DataOperation__Group_3_2__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) ;
    public final void rule__DataOperation__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2940:1: ( ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) )
            // InternalDataDsl.g:2941:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            {
            // InternalDataDsl.g:2941:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            // InternalDataDsl.g:2942:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_2_1()); 
            // InternalDataDsl.g:2943:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            // InternalDataDsl.g:2943:3: rule__DataOperation__ParametersAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__ParametersAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationAccess().getParametersAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_3_2__1__Impl"


    // $ANTLR start "rule__DataOperationParameter__Group__0"
    // InternalDataDsl.g:2952:1: rule__DataOperationParameter__Group__0 : rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 ;
    public final void rule__DataOperationParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2956:1: ( rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 )
            // InternalDataDsl.g:2957:2: rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__DataOperationParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperationParameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__Group__0"


    // $ANTLR start "rule__DataOperationParameter__Group__0__Impl"
    // InternalDataDsl.g:2964:1: rule__DataOperationParameter__Group__0__Impl : ( ( rule__DataOperationParameter__Alternatives_0 ) ) ;
    public final void rule__DataOperationParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2968:1: ( ( ( rule__DataOperationParameter__Alternatives_0 ) ) )
            // InternalDataDsl.g:2969:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            {
            // InternalDataDsl.g:2969:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            // InternalDataDsl.g:2970:2: ( rule__DataOperationParameter__Alternatives_0 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getAlternatives_0()); 
            // InternalDataDsl.g:2971:2: ( rule__DataOperationParameter__Alternatives_0 )
            // InternalDataDsl.g:2971:3: rule__DataOperationParameter__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__DataOperationParameter__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationParameterAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__Group__0__Impl"


    // $ANTLR start "rule__DataOperationParameter__Group__1"
    // InternalDataDsl.g:2979:1: rule__DataOperationParameter__Group__1 : rule__DataOperationParameter__Group__1__Impl ;
    public final void rule__DataOperationParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2983:1: ( rule__DataOperationParameter__Group__1__Impl )
            // InternalDataDsl.g:2984:2: rule__DataOperationParameter__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperationParameter__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__Group__1"


    // $ANTLR start "rule__DataOperationParameter__Group__1__Impl"
    // InternalDataDsl.g:2990:1: rule__DataOperationParameter__Group__1__Impl : ( ( rule__DataOperationParameter__NameAssignment_1 ) ) ;
    public final void rule__DataOperationParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2994:1: ( ( ( rule__DataOperationParameter__NameAssignment_1 ) ) )
            // InternalDataDsl.g:2995:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:2995:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            // InternalDataDsl.g:2996:2: ( rule__DataOperationParameter__NameAssignment_1 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:2997:2: ( rule__DataOperationParameter__NameAssignment_1 )
            // InternalDataDsl.g:2997:3: rule__DataOperationParameter__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DataOperationParameter__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationParameterAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__Group__1__Impl"


    // $ANTLR start "rule__ImportedComplexType__Group__0"
    // InternalDataDsl.g:3006:1: rule__ImportedComplexType__Group__0 : rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1 ;
    public final void rule__ImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3010:1: ( rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1 )
            // InternalDataDsl.g:3011:2: rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__ImportedComplexType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportedComplexType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__Group__0"


    // $ANTLR start "rule__ImportedComplexType__Group__0__Impl"
    // InternalDataDsl.g:3018:1: rule__ImportedComplexType__Group__0__Impl : ( ( rule__ImportedComplexType__ImportAssignment_0 ) ) ;
    public final void rule__ImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3022:1: ( ( ( rule__ImportedComplexType__ImportAssignment_0 ) ) )
            // InternalDataDsl.g:3023:1: ( ( rule__ImportedComplexType__ImportAssignment_0 ) )
            {
            // InternalDataDsl.g:3023:1: ( ( rule__ImportedComplexType__ImportAssignment_0 ) )
            // InternalDataDsl.g:3024:2: ( rule__ImportedComplexType__ImportAssignment_0 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportAssignment_0()); 
            // InternalDataDsl.g:3025:2: ( rule__ImportedComplexType__ImportAssignment_0 )
            // InternalDataDsl.g:3025:3: rule__ImportedComplexType__ImportAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ImportedComplexType__ImportAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getImportedComplexTypeAccess().getImportAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__Group__0__Impl"


    // $ANTLR start "rule__ImportedComplexType__Group__1"
    // InternalDataDsl.g:3033:1: rule__ImportedComplexType__Group__1 : rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2 ;
    public final void rule__ImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3037:1: ( rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2 )
            // InternalDataDsl.g:3038:2: rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__ImportedComplexType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportedComplexType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__Group__1"


    // $ANTLR start "rule__ImportedComplexType__Group__1__Impl"
    // InternalDataDsl.g:3045:1: rule__ImportedComplexType__Group__1__Impl : ( '::' ) ;
    public final void rule__ImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3049:1: ( ( '::' ) )
            // InternalDataDsl.g:3050:1: ( '::' )
            {
            // InternalDataDsl.g:3050:1: ( '::' )
            // InternalDataDsl.g:3051:2: '::'
            {
             before(grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__Group__1__Impl"


    // $ANTLR start "rule__ImportedComplexType__Group__2"
    // InternalDataDsl.g:3060:1: rule__ImportedComplexType__Group__2 : rule__ImportedComplexType__Group__2__Impl ;
    public final void rule__ImportedComplexType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3064:1: ( rule__ImportedComplexType__Group__2__Impl )
            // InternalDataDsl.g:3065:2: rule__ImportedComplexType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportedComplexType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__Group__2"


    // $ANTLR start "rule__ImportedComplexType__Group__2__Impl"
    // InternalDataDsl.g:3071:1: rule__ImportedComplexType__Group__2__Impl : ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) ) ;
    public final void rule__ImportedComplexType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3075:1: ( ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) ) )
            // InternalDataDsl.g:3076:1: ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) )
            {
            // InternalDataDsl.g:3076:1: ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) )
            // InternalDataDsl.g:3077:2: ( rule__ImportedComplexType__ImportedTypeAssignment_2 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeAssignment_2()); 
            // InternalDataDsl.g:3078:2: ( rule__ImportedComplexType__ImportedTypeAssignment_2 )
            // InternalDataDsl.g:3078:3: rule__ImportedComplexType__ImportedTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ImportedComplexType__ImportedTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImportedComplexTypeAccess().getImportedTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__Group__2__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_0__0"
    // InternalDataDsl.g:3087:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3091:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalDataDsl.g:3092:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_34);
            rule__PrimitiveType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__0"


    // $ANTLR start "rule__PrimitiveType__Group_0__0__Impl"
    // InternalDataDsl.g:3099:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3103:1: ( ( () ) )
            // InternalDataDsl.g:3104:1: ( () )
            {
            // InternalDataDsl.g:3104:1: ( () )
            // InternalDataDsl.g:3105:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalDataDsl.g:3106:2: ()
            // InternalDataDsl.g:3106:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_0__1"
    // InternalDataDsl.g:3114:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3118:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalDataDsl.g:3119:2: rule__PrimitiveType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__1"


    // $ANTLR start "rule__PrimitiveType__Group_0__1__Impl"
    // InternalDataDsl.g:3125:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3129:1: ( ( 'boolean' ) )
            // InternalDataDsl.g:3130:1: ( 'boolean' )
            {
            // InternalDataDsl.g:3130:1: ( 'boolean' )
            // InternalDataDsl.g:3131:2: 'boolean'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_0__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_1__0"
    // InternalDataDsl.g:3141:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3145:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalDataDsl.g:3146:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_35);
            rule__PrimitiveType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__0"


    // $ANTLR start "rule__PrimitiveType__Group_1__0__Impl"
    // InternalDataDsl.g:3153:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3157:1: ( ( () ) )
            // InternalDataDsl.g:3158:1: ( () )
            {
            // InternalDataDsl.g:3158:1: ( () )
            // InternalDataDsl.g:3159:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalDataDsl.g:3160:2: ()
            // InternalDataDsl.g:3160:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_1__1"
    // InternalDataDsl.g:3168:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3172:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalDataDsl.g:3173:2: rule__PrimitiveType__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__1"


    // $ANTLR start "rule__PrimitiveType__Group_1__1__Impl"
    // InternalDataDsl.g:3179:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3183:1: ( ( 'byte' ) )
            // InternalDataDsl.g:3184:1: ( 'byte' )
            {
            // InternalDataDsl.g:3184:1: ( 'byte' )
            // InternalDataDsl.g:3185:2: 'byte'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_1__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_2__0"
    // InternalDataDsl.g:3195:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3199:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalDataDsl.g:3200:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_36);
            rule__PrimitiveType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__0"


    // $ANTLR start "rule__PrimitiveType__Group_2__0__Impl"
    // InternalDataDsl.g:3207:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3211:1: ( ( () ) )
            // InternalDataDsl.g:3212:1: ( () )
            {
            // InternalDataDsl.g:3212:1: ( () )
            // InternalDataDsl.g:3213:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalDataDsl.g:3214:2: ()
            // InternalDataDsl.g:3214:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_2__1"
    // InternalDataDsl.g:3222:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3226:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalDataDsl.g:3227:2: rule__PrimitiveType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__1"


    // $ANTLR start "rule__PrimitiveType__Group_2__1__Impl"
    // InternalDataDsl.g:3233:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3237:1: ( ( 'char' ) )
            // InternalDataDsl.g:3238:1: ( 'char' )
            {
            // InternalDataDsl.g:3238:1: ( 'char' )
            // InternalDataDsl.g:3239:2: 'char'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_2__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_3__0"
    // InternalDataDsl.g:3249:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3253:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalDataDsl.g:3254:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_37);
            rule__PrimitiveType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__0"


    // $ANTLR start "rule__PrimitiveType__Group_3__0__Impl"
    // InternalDataDsl.g:3261:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3265:1: ( ( () ) )
            // InternalDataDsl.g:3266:1: ( () )
            {
            // InternalDataDsl.g:3266:1: ( () )
            // InternalDataDsl.g:3267:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalDataDsl.g:3268:2: ()
            // InternalDataDsl.g:3268:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_3__1"
    // InternalDataDsl.g:3276:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3280:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalDataDsl.g:3281:2: rule__PrimitiveType__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__1"


    // $ANTLR start "rule__PrimitiveType__Group_3__1__Impl"
    // InternalDataDsl.g:3287:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3291:1: ( ( 'date' ) )
            // InternalDataDsl.g:3292:1: ( 'date' )
            {
            // InternalDataDsl.g:3292:1: ( 'date' )
            // InternalDataDsl.g:3293:2: 'date'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_3__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_4__0"
    // InternalDataDsl.g:3303:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3307:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalDataDsl.g:3308:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
            {
            pushFollow(FOLLOW_38);
            rule__PrimitiveType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_4__0"


    // $ANTLR start "rule__PrimitiveType__Group_4__0__Impl"
    // InternalDataDsl.g:3315:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3319:1: ( ( () ) )
            // InternalDataDsl.g:3320:1: ( () )
            {
            // InternalDataDsl.g:3320:1: ( () )
            // InternalDataDsl.g:3321:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalDataDsl.g:3322:2: ()
            // InternalDataDsl.g:3322:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_4__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_4__1"
    // InternalDataDsl.g:3330:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3334:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalDataDsl.g:3335:2: rule__PrimitiveType__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_4__1"


    // $ANTLR start "rule__PrimitiveType__Group_4__1__Impl"
    // InternalDataDsl.g:3341:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3345:1: ( ( 'double' ) )
            // InternalDataDsl.g:3346:1: ( 'double' )
            {
            // InternalDataDsl.g:3346:1: ( 'double' )
            // InternalDataDsl.g:3347:2: 'double'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_4__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_5__0"
    // InternalDataDsl.g:3357:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3361:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalDataDsl.g:3362:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
            {
            pushFollow(FOLLOW_39);
            rule__PrimitiveType__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_5__0"


    // $ANTLR start "rule__PrimitiveType__Group_5__0__Impl"
    // InternalDataDsl.g:3369:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3373:1: ( ( () ) )
            // InternalDataDsl.g:3374:1: ( () )
            {
            // InternalDataDsl.g:3374:1: ( () )
            // InternalDataDsl.g:3375:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalDataDsl.g:3376:2: ()
            // InternalDataDsl.g:3376:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_5__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_5__1"
    // InternalDataDsl.g:3384:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3388:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalDataDsl.g:3389:2: rule__PrimitiveType__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_5__1"


    // $ANTLR start "rule__PrimitiveType__Group_5__1__Impl"
    // InternalDataDsl.g:3395:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3399:1: ( ( 'float' ) )
            // InternalDataDsl.g:3400:1: ( 'float' )
            {
            // InternalDataDsl.g:3400:1: ( 'float' )
            // InternalDataDsl.g:3401:2: 'float'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_5__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_6__0"
    // InternalDataDsl.g:3411:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3415:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalDataDsl.g:3416:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
            {
            pushFollow(FOLLOW_40);
            rule__PrimitiveType__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_6__0"


    // $ANTLR start "rule__PrimitiveType__Group_6__0__Impl"
    // InternalDataDsl.g:3423:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3427:1: ( ( () ) )
            // InternalDataDsl.g:3428:1: ( () )
            {
            // InternalDataDsl.g:3428:1: ( () )
            // InternalDataDsl.g:3429:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalDataDsl.g:3430:2: ()
            // InternalDataDsl.g:3430:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_6__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_6__1"
    // InternalDataDsl.g:3438:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3442:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalDataDsl.g:3443:2: rule__PrimitiveType__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_6__1"


    // $ANTLR start "rule__PrimitiveType__Group_6__1__Impl"
    // InternalDataDsl.g:3449:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3453:1: ( ( 'int' ) )
            // InternalDataDsl.g:3454:1: ( 'int' )
            {
            // InternalDataDsl.g:3454:1: ( 'int' )
            // InternalDataDsl.g:3455:2: 'int'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_6__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_7__0"
    // InternalDataDsl.g:3465:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3469:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalDataDsl.g:3470:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
            {
            pushFollow(FOLLOW_41);
            rule__PrimitiveType__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_7__0"


    // $ANTLR start "rule__PrimitiveType__Group_7__0__Impl"
    // InternalDataDsl.g:3477:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3481:1: ( ( () ) )
            // InternalDataDsl.g:3482:1: ( () )
            {
            // InternalDataDsl.g:3482:1: ( () )
            // InternalDataDsl.g:3483:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalDataDsl.g:3484:2: ()
            // InternalDataDsl.g:3484:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_7__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_7__1"
    // InternalDataDsl.g:3492:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3496:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalDataDsl.g:3497:2: rule__PrimitiveType__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_7__1"


    // $ANTLR start "rule__PrimitiveType__Group_7__1__Impl"
    // InternalDataDsl.g:3503:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3507:1: ( ( 'long' ) )
            // InternalDataDsl.g:3508:1: ( 'long' )
            {
            // InternalDataDsl.g:3508:1: ( 'long' )
            // InternalDataDsl.g:3509:2: 'long'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_7__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_8__0"
    // InternalDataDsl.g:3519:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3523:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalDataDsl.g:3524:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
            {
            pushFollow(FOLLOW_42);
            rule__PrimitiveType__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_8__0"


    // $ANTLR start "rule__PrimitiveType__Group_8__0__Impl"
    // InternalDataDsl.g:3531:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3535:1: ( ( () ) )
            // InternalDataDsl.g:3536:1: ( () )
            {
            // InternalDataDsl.g:3536:1: ( () )
            // InternalDataDsl.g:3537:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalDataDsl.g:3538:2: ()
            // InternalDataDsl.g:3538:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_8__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_8__1"
    // InternalDataDsl.g:3546:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3550:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalDataDsl.g:3551:2: rule__PrimitiveType__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_8__1"


    // $ANTLR start "rule__PrimitiveType__Group_8__1__Impl"
    // InternalDataDsl.g:3557:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3561:1: ( ( 'short' ) )
            // InternalDataDsl.g:3562:1: ( 'short' )
            {
            // InternalDataDsl.g:3562:1: ( 'short' )
            // InternalDataDsl.g:3563:2: 'short'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_8__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_9__0"
    // InternalDataDsl.g:3573:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3577:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalDataDsl.g:3578:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
            {
            pushFollow(FOLLOW_24);
            rule__PrimitiveType__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_9__0"


    // $ANTLR start "rule__PrimitiveType__Group_9__0__Impl"
    // InternalDataDsl.g:3585:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3589:1: ( ( () ) )
            // InternalDataDsl.g:3590:1: ( () )
            {
            // InternalDataDsl.g:3590:1: ( () )
            // InternalDataDsl.g:3591:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalDataDsl.g:3592:2: ()
            // InternalDataDsl.g:3592:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_9__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_9__1"
    // InternalDataDsl.g:3600:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3604:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalDataDsl.g:3605:2: rule__PrimitiveType__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_9__1"


    // $ANTLR start "rule__PrimitiveType__Group_9__1__Impl"
    // InternalDataDsl.g:3611:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3615:1: ( ( 'string' ) )
            // InternalDataDsl.g:3616:1: ( 'string' )
            {
            // InternalDataDsl.g:3616:1: ( 'string' )
            // InternalDataDsl.g:3617:2: 'string'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_9__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalDataDsl.g:3627:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3631:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDsl.g:3632:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalDataDsl.g:3639:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3643:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3644:1: ( RULE_ID )
            {
            // InternalDataDsl.g:3644:1: ( RULE_ID )
            // InternalDataDsl.g:3645:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalDataDsl.g:3654:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3658:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDsl.g:3659:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalDataDsl.g:3665:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3669:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDsl.g:3670:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDsl.g:3670:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDsl.g:3671:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDataDsl.g:3672:2: ( rule__QualifiedName__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==43) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalDataDsl.g:3672:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_44);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalDataDsl.g:3681:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3685:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDsl.g:3686:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalDataDsl.g:3693:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3697:1: ( ( '.' ) )
            // InternalDataDsl.g:3698:1: ( '.' )
            {
            // InternalDataDsl.g:3698:1: ( '.' )
            // InternalDataDsl.g:3699:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalDataDsl.g:3708:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3712:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDsl.g:3713:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalDataDsl.g:3719:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3723:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3724:1: ( RULE_ID )
            {
            // InternalDataDsl.g:3724:1: ( RULE_ID )
            // InternalDataDsl.g:3725:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__DataModel__ComplexTypeImportsAssignment_0"
    // InternalDataDsl.g:3735:1: rule__DataModel__ComplexTypeImportsAssignment_0 : ( ruleComplexTypeImport ) ;
    public final void rule__DataModel__ComplexTypeImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3739:1: ( ( ruleComplexTypeImport ) )
            // InternalDataDsl.g:3740:2: ( ruleComplexTypeImport )
            {
            // InternalDataDsl.g:3740:2: ( ruleComplexTypeImport )
            // InternalDataDsl.g:3741:3: ruleComplexTypeImport
            {
             before(grammarAccess.getDataModelAccess().getComplexTypeImportsComplexTypeImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexTypeImport();

            state._fsp--;

             after(grammarAccess.getDataModelAccess().getComplexTypeImportsComplexTypeImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__ComplexTypeImportsAssignment_0"


    // $ANTLR start "rule__DataModel__VersionsAssignment_1_0"
    // InternalDataDsl.g:3750:1: rule__DataModel__VersionsAssignment_1_0 : ( ruleVersion ) ;
    public final void rule__DataModel__VersionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3754:1: ( ( ruleVersion ) )
            // InternalDataDsl.g:3755:2: ( ruleVersion )
            {
            // InternalDataDsl.g:3755:2: ( ruleVersion )
            // InternalDataDsl.g:3756:3: ruleVersion
            {
             before(grammarAccess.getDataModelAccess().getVersionsVersionParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVersion();

            state._fsp--;

             after(grammarAccess.getDataModelAccess().getVersionsVersionParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__VersionsAssignment_1_0"


    // $ANTLR start "rule__DataModel__ContextsAssignment_1_1"
    // InternalDataDsl.g:3765:1: rule__DataModel__ContextsAssignment_1_1 : ( ruleContext ) ;
    public final void rule__DataModel__ContextsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3769:1: ( ( ruleContext ) )
            // InternalDataDsl.g:3770:2: ( ruleContext )
            {
            // InternalDataDsl.g:3770:2: ( ruleContext )
            // InternalDataDsl.g:3771:3: ruleContext
            {
             before(grammarAccess.getDataModelAccess().getContextsContextParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleContext();

            state._fsp--;

             after(grammarAccess.getDataModelAccess().getContextsContextParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__ContextsAssignment_1_1"


    // $ANTLR start "rule__DataModel__ComplexTypesAssignment_1_2"
    // InternalDataDsl.g:3780:1: rule__DataModel__ComplexTypesAssignment_1_2 : ( ruleComplexType ) ;
    public final void rule__DataModel__ComplexTypesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3784:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:3785:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:3785:2: ( ruleComplexType )
            // InternalDataDsl.g:3786:3: ruleComplexType
            {
             before(grammarAccess.getDataModelAccess().getComplexTypesComplexTypeParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexType();

            state._fsp--;

             after(grammarAccess.getDataModelAccess().getComplexTypesComplexTypeParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataModel__ComplexTypesAssignment_1_2"


    // $ANTLR start "rule__ComplexTypeImport__ImportURIAssignment_3"
    // InternalDataDsl.g:3795:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3799:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:3800:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:3800:2: ( RULE_STRING )
            // InternalDataDsl.g:3801:3: RULE_STRING
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getComplexTypeImportAccess().getImportURISTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__ImportURIAssignment_3"


    // $ANTLR start "rule__ComplexTypeImport__NameAssignment_5"
    // InternalDataDsl.g:3810:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3814:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3815:2: ( RULE_ID )
            {
            // InternalDataDsl.g:3815:2: ( RULE_ID )
            // InternalDataDsl.g:3816:3: RULE_ID
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComplexTypeImportAccess().getNameIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexTypeImport__NameAssignment_5"


    // $ANTLR start "rule__Version__NameAssignment_1"
    // InternalDataDsl.g:3825:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3829:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3830:2: ( RULE_ID )
            {
            // InternalDataDsl.g:3830:2: ( RULE_ID )
            // InternalDataDsl.g:3831:3: RULE_ID
            {
             before(grammarAccess.getVersionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVersionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__NameAssignment_1"


    // $ANTLR start "rule__Version__ComplexTypesAssignment_3_0"
    // InternalDataDsl.g:3840:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3844:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:3845:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:3845:2: ( ruleComplexType )
            // InternalDataDsl.g:3846:3: ruleComplexType
            {
             before(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexType();

            state._fsp--;

             after(grammarAccess.getVersionAccess().getComplexTypesComplexTypeParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__ComplexTypesAssignment_3_0"


    // $ANTLR start "rule__Version__ContextsAssignment_3_1"
    // InternalDataDsl.g:3855:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3859:1: ( ( ruleContext ) )
            // InternalDataDsl.g:3860:2: ( ruleContext )
            {
            // InternalDataDsl.g:3860:2: ( ruleContext )
            // InternalDataDsl.g:3861:3: ruleContext
            {
             before(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleContext();

            state._fsp--;

             after(grammarAccess.getVersionAccess().getContextsContextParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Version__ContextsAssignment_3_1"


    // $ANTLR start "rule__Context__NameAssignment_1"
    // InternalDataDsl.g:3870:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3874:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3875:2: ( RULE_ID )
            {
            // InternalDataDsl.g:3875:2: ( RULE_ID )
            // InternalDataDsl.g:3876:3: RULE_ID
            {
             before(grammarAccess.getContextAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getContextAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__NameAssignment_1"


    // $ANTLR start "rule__Context__ComplexTypesAssignment_3"
    // InternalDataDsl.g:3885:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3889:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:3890:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:3890:2: ( ruleComplexType )
            // InternalDataDsl.g:3891:3: ruleComplexType
            {
             before(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexType();

            state._fsp--;

             after(grammarAccess.getContextAccess().getComplexTypesComplexTypeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__ComplexTypesAssignment_3"


    // $ANTLR start "rule__DataStructure__NameAssignment_1"
    // InternalDataDsl.g:3900:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3904:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3905:2: ( RULE_ID )
            {
            // InternalDataDsl.g:3905:2: ( RULE_ID )
            // InternalDataDsl.g:3906:3: RULE_ID
            {
             before(grammarAccess.getDataStructureAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__NameAssignment_1"


    // $ANTLR start "rule__DataStructure__SuperAssignment_2_1"
    // InternalDataDsl.g:3915:1: rule__DataStructure__SuperAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3919:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:3920:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:3920:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:3921:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0()); 
            // InternalDataDsl.g:3922:3: ( ruleQualifiedName )
            // InternalDataDsl.g:3923:4: ruleQualifiedName
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getSuperDataStructureQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__SuperAssignment_2_1"


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_0_0"
    // InternalDataDsl.g:3934:1: rule__DataStructure__DataFieldsAssignment_4_0_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3938:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:3939:2: ( ruleDataField )
            {
            // InternalDataDsl.g:3939:2: ( ruleDataField )
            // InternalDataDsl.g:3940:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_0_0"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_4_0_1"
    // InternalDataDsl.g:3949:1: rule__DataStructure__OperationsAssignment_4_0_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3953:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:3954:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:3954:2: ( ruleDataOperation )
            // InternalDataDsl.g:3955:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__OperationsAssignment_4_0_1"


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_1_1_0"
    // InternalDataDsl.g:3964:1: rule__DataStructure__DataFieldsAssignment_4_1_1_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3968:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:3969:2: ( ruleDataField )
            {
            // InternalDataDsl.g:3969:2: ( ruleDataField )
            // InternalDataDsl.g:3970:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_1_1_0"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_4_1_1_1"
    // InternalDataDsl.g:3979:1: rule__DataStructure__OperationsAssignment_4_1_1_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3983:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:3984:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:3984:2: ( ruleDataOperation )
            // InternalDataDsl.g:3985:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__OperationsAssignment_4_1_1_1"


    // $ANTLR start "rule__ListType__NameAssignment_0_1"
    // InternalDataDsl.g:3994:1: rule__ListType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3998:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3999:2: ( RULE_ID )
            {
            // InternalDataDsl.g:3999:2: ( RULE_ID )
            // InternalDataDsl.g:4000:3: RULE_ID
            {
             before(grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__NameAssignment_0_1"


    // $ANTLR start "rule__ListType__DataFieldsAssignment_0_3"
    // InternalDataDsl.g:4009:1: rule__ListType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4013:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4014:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4014:2: ( ruleDataField )
            // InternalDataDsl.g:4015:3: ruleDataField
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__DataFieldsAssignment_0_3"


    // $ANTLR start "rule__ListType__DataFieldsAssignment_0_4_1"
    // InternalDataDsl.g:4024:1: rule__ListType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4028:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4029:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4029:2: ( ruleDataField )
            // InternalDataDsl.g:4030:3: ruleDataField
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getListTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__DataFieldsAssignment_0_4_1"


    // $ANTLR start "rule__ListType__NameAssignment_1_1"
    // InternalDataDsl.g:4039:1: rule__ListType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4043:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4044:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4044:2: ( RULE_ID )
            // InternalDataDsl.g:4045:3: RULE_ID
            {
             before(grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getListTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__NameAssignment_1_1"


    // $ANTLR start "rule__ListType__PrimitiveTypeAssignment_1_3"
    // InternalDataDsl.g:4054:1: rule__ListType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__ListType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4058:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4059:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4059:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4060:3: rulePrimitiveType
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getListTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListType__PrimitiveTypeAssignment_1_3"


    // $ANTLR start "rule__DataField__HiddenAssignment_0"
    // InternalDataDsl.g:4069:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4073:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:4074:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:4074:2: ( ( 'hide' ) )
            // InternalDataDsl.g:4075:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:4076:3: ( 'hide' )
            // InternalDataDsl.g:4077:4: 'hide'
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 

            }

             after(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__HiddenAssignment_0"


    // $ANTLR start "rule__DataField__PrimitiveTypeAssignment_1_0"
    // InternalDataDsl.g:4088:1: rule__DataField__PrimitiveTypeAssignment_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4092:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4093:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4093:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4094:3: rulePrimitiveType
            {
             before(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__PrimitiveTypeAssignment_1_0"


    // $ANTLR start "rule__DataField__ComplexTypeAssignment_1_1"
    // InternalDataDsl.g:4103:1: rule__DataField__ComplexTypeAssignment_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataField__ComplexTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4107:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4108:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4108:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4109:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_1_1_0()); 
            // InternalDataDsl.g:4110:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4111:4: ruleQualifiedName
            {
             before(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__ComplexTypeAssignment_1_1"


    // $ANTLR start "rule__DataField__ImportedComplexTypeAssignment_1_2"
    // InternalDataDsl.g:4122:1: rule__DataField__ImportedComplexTypeAssignment_1_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataField__ImportedComplexTypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4126:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:4127:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:4127:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:4128:3: ruleImportedComplexType
            {
             before(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__ImportedComplexTypeAssignment_1_2"


    // $ANTLR start "rule__DataField__NameAssignment_2"
    // InternalDataDsl.g:4137:1: rule__DataField__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4141:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4142:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4142:2: ( RULE_ID )
            // InternalDataDsl.g:4143:3: RULE_ID
            {
             before(grammarAccess.getDataFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__NameAssignment_2"


    // $ANTLR start "rule__DataField__FeaturesAssignment_3_1"
    // InternalDataDsl.g:4152:1: rule__DataField__FeaturesAssignment_3_1 : ( ruleFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4156:1: ( ( ruleFieldFeature ) )
            // InternalDataDsl.g:4157:2: ( ruleFieldFeature )
            {
            // InternalDataDsl.g:4157:2: ( ruleFieldFeature )
            // InternalDataDsl.g:4158:3: ruleFieldFeature
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFieldFeature();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__FeaturesAssignment_3_1"


    // $ANTLR start "rule__DataField__FeaturesAssignment_3_2_1"
    // InternalDataDsl.g:4167:1: rule__DataField__FeaturesAssignment_3_2_1 : ( ruleFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4171:1: ( ( ruleFieldFeature ) )
            // InternalDataDsl.g:4172:2: ( ruleFieldFeature )
            {
            // InternalDataDsl.g:4172:2: ( ruleFieldFeature )
            // InternalDataDsl.g:4173:3: ruleFieldFeature
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFieldFeature();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getFeaturesFieldFeatureEnumRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__FeaturesAssignment_3_2_1"


    // $ANTLR start "rule__Enumeration__NameAssignment_1"
    // InternalDataDsl.g:4182:1: rule__Enumeration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4186:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4187:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4187:2: ( RULE_ID )
            // InternalDataDsl.g:4188:3: RULE_ID
            {
             before(grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__NameAssignment_1"


    // $ANTLR start "rule__Enumeration__FieldsAssignment_3"
    // InternalDataDsl.g:4197:1: rule__Enumeration__FieldsAssignment_3 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4201:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:4202:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:4202:2: ( ruleEnumerationField )
            // InternalDataDsl.g:4203:3: ruleEnumerationField
            {
             before(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerationField();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__FieldsAssignment_3"


    // $ANTLR start "rule__Enumeration__FieldsAssignment_4_1"
    // InternalDataDsl.g:4212:1: rule__Enumeration__FieldsAssignment_4_1 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4216:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:4217:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:4217:2: ( ruleEnumerationField )
            // InternalDataDsl.g:4218:3: ruleEnumerationField
            {
             before(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerationField();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__FieldsAssignment_4_1"


    // $ANTLR start "rule__EnumerationField__NameAssignment_0"
    // InternalDataDsl.g:4227:1: rule__EnumerationField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EnumerationField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4231:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4232:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4232:2: ( RULE_ID )
            // InternalDataDsl.g:4233:3: RULE_ID
            {
             before(grammarAccess.getEnumerationFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumerationFieldAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__NameAssignment_0"


    // $ANTLR start "rule__EnumerationField__InitializationValueAssignment_1_1"
    // InternalDataDsl.g:4242:1: rule__EnumerationField__InitializationValueAssignment_1_1 : ( rulePrimitiveValue ) ;
    public final void rule__EnumerationField__InitializationValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4246:1: ( ( rulePrimitiveValue ) )
            // InternalDataDsl.g:4247:2: ( rulePrimitiveValue )
            {
            // InternalDataDsl.g:4247:2: ( rulePrimitiveValue )
            // InternalDataDsl.g:4248:3: rulePrimitiveValue
            {
             before(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveValue();

            state._fsp--;

             after(grammarAccess.getEnumerationFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationField__InitializationValueAssignment_1_1"


    // $ANTLR start "rule__DataOperation__HiddenAssignment_0"
    // InternalDataDsl.g:4257:1: rule__DataOperation__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataOperation__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4261:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:4262:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:4262:2: ( ( 'hide' ) )
            // InternalDataDsl.g:4263:3: ( 'hide' )
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:4264:3: ( 'hide' )
            // InternalDataDsl.g:4265:4: 'hide'
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 

            }

             after(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__HiddenAssignment_0"


    // $ANTLR start "rule__DataOperation__HasNoReturnTypeAssignment_1_0"
    // InternalDataDsl.g:4276:1: rule__DataOperation__HasNoReturnTypeAssignment_1_0 : ( ( 'procedure' ) ) ;
    public final void rule__DataOperation__HasNoReturnTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4280:1: ( ( ( 'procedure' ) ) )
            // InternalDataDsl.g:4281:2: ( ( 'procedure' ) )
            {
            // InternalDataDsl.g:4281:2: ( ( 'procedure' ) )
            // InternalDataDsl.g:4282:3: ( 'procedure' )
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            // InternalDataDsl.g:4283:3: ( 'procedure' )
            // InternalDataDsl.g:4284:4: 'procedure'
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 

            }

             after(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__HasNoReturnTypeAssignment_1_0"


    // $ANTLR start "rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0"
    // InternalDataDsl.g:4295:1: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4299:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4300:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4300:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4301:3: rulePrimitiveType
            {
             before(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypePrimitiveTypeParserRuleCall_1_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypePrimitiveTypeParserRuleCall_1_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0"


    // $ANTLR start "rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1"
    // InternalDataDsl.g:4310:1: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4314:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4315:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4315:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4316:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0()); 
            // InternalDataDsl.g:4317:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4318:4: ruleQualifiedName
            {
             before(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeQualifiedNameParserRuleCall_1_1_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeQualifiedNameParserRuleCall_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1"


    // $ANTLR start "rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2"
    // InternalDataDsl.g:4329:1: rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4333:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:4334:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:4334:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:4335:3: ruleImportedComplexType
            {
             before(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeImportedComplexTypeParserRuleCall_1_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeImportedComplexTypeParserRuleCall_1_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2"


    // $ANTLR start "rule__DataOperation__NameAssignment_2"
    // InternalDataDsl.g:4344:1: rule__DataOperation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataOperation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4348:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4349:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4349:2: ( RULE_ID )
            // InternalDataDsl.g:4350:3: RULE_ID
            {
             before(grammarAccess.getDataOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__NameAssignment_2"


    // $ANTLR start "rule__DataOperation__ParametersAssignment_3_1"
    // InternalDataDsl.g:4359:1: rule__DataOperation__ParametersAssignment_3_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4363:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:4364:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:4364:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:4365:3: ruleDataOperationParameter
            {
             before(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperationParameter();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__ParametersAssignment_3_1"


    // $ANTLR start "rule__DataOperation__ParametersAssignment_3_2_1"
    // InternalDataDsl.g:4374:1: rule__DataOperation__ParametersAssignment_3_2_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4378:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:4379:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:4379:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:4380:3: ruleDataOperationParameter
            {
             before(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperationParameter();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getParametersDataOperationParameterParserRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__ParametersAssignment_3_2_1"


    // $ANTLR start "rule__DataOperationParameter__PrimitiveTypeAssignment_0_0"
    // InternalDataDsl.g:4389:1: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperationParameter__PrimitiveTypeAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4393:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4394:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4394:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4395:3: rulePrimitiveType
            {
             before(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__PrimitiveTypeAssignment_0_0"


    // $ANTLR start "rule__DataOperationParameter__ComplexTypeAssignment_0_1"
    // InternalDataDsl.g:4404:1: rule__DataOperationParameter__ComplexTypeAssignment_0_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataOperationParameter__ComplexTypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4408:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4409:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4409:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4410:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0()); 
            // InternalDataDsl.g:4411:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4412:4: ruleQualifiedName
            {
             before(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_0_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__ComplexTypeAssignment_0_1"


    // $ANTLR start "rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2"
    // InternalDataDsl.g:4423:1: rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4427:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:4428:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:4428:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:4429:3: ruleImportedComplexType
            {
             before(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2"


    // $ANTLR start "rule__DataOperationParameter__NameAssignment_1"
    // InternalDataDsl.g:4438:1: rule__DataOperationParameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataOperationParameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4442:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4443:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4443:2: ( RULE_ID )
            // InternalDataDsl.g:4444:3: RULE_ID
            {
             before(grammarAccess.getDataOperationParameterAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataOperationParameterAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperationParameter__NameAssignment_1"


    // $ANTLR start "rule__PrimitiveValue__NumericValueAssignment_0"
    // InternalDataDsl.g:4453:1: rule__PrimitiveValue__NumericValueAssignment_0 : ( RULE_BIG_DECIMAL ) ;
    public final void rule__PrimitiveValue__NumericValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4457:1: ( ( RULE_BIG_DECIMAL ) )
            // InternalDataDsl.g:4458:2: ( RULE_BIG_DECIMAL )
            {
            // InternalDataDsl.g:4458:2: ( RULE_BIG_DECIMAL )
            // InternalDataDsl.g:4459:3: RULE_BIG_DECIMAL
            {
             before(grammarAccess.getPrimitiveValueAccess().getNumericValueBIG_DECIMALTerminalRuleCall_0_0()); 
            match(input,RULE_BIG_DECIMAL,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueAccess().getNumericValueBIG_DECIMALTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValue__NumericValueAssignment_0"


    // $ANTLR start "rule__PrimitiveValue__BooleanValueAssignment_1"
    // InternalDataDsl.g:4468:1: rule__PrimitiveValue__BooleanValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__PrimitiveValue__BooleanValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4472:1: ( ( RULE_BOOLEAN ) )
            // InternalDataDsl.g:4473:2: ( RULE_BOOLEAN )
            {
            // InternalDataDsl.g:4473:2: ( RULE_BOOLEAN )
            // InternalDataDsl.g:4474:3: RULE_BOOLEAN
            {
             before(grammarAccess.getPrimitiveValueAccess().getBooleanValueBOOLEANTerminalRuleCall_1_0()); 
            match(input,RULE_BOOLEAN,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueAccess().getBooleanValueBOOLEANTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValue__BooleanValueAssignment_1"


    // $ANTLR start "rule__PrimitiveValue__StringValueAssignment_2"
    // InternalDataDsl.g:4483:1: rule__PrimitiveValue__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4487:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:4488:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:4488:2: ( RULE_STRING )
            // InternalDataDsl.g:4489:3: RULE_STRING
            {
             before(grammarAccess.getPrimitiveValueAccess().getStringValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueAccess().getStringValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValue__StringValueAssignment_2"


    // $ANTLR start "rule__ImportedComplexType__ImportAssignment_0"
    // InternalDataDsl.g:4498:1: rule__ImportedComplexType__ImportAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ImportedComplexType__ImportAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4502:1: ( ( ( RULE_ID ) ) )
            // InternalDataDsl.g:4503:2: ( ( RULE_ID ) )
            {
            // InternalDataDsl.g:4503:2: ( ( RULE_ID ) )
            // InternalDataDsl.g:4504:3: ( RULE_ID )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0()); 
            // InternalDataDsl.g:4505:3: ( RULE_ID )
            // InternalDataDsl.g:4506:4: RULE_ID
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__ImportAssignment_0"


    // $ANTLR start "rule__ImportedComplexType__ImportedTypeAssignment_2"
    // InternalDataDsl.g:4517:1: rule__ImportedComplexType__ImportedTypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ImportedComplexType__ImportedTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4521:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4522:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4522:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4523:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeCrossReference_2_0()); 
            // InternalDataDsl.g:4524:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4525:4: ruleQualifiedName
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedComplexType__ImportedTypeAssignment_2"

    // Delegated rules


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\31\1\4\1\23\13\4\2\uffff";
    static final String dfa_3s = "\1\31\1\4\1\23\1\54\12\24\2\uffff";
    static final String dfa_4s = "\16\uffff\1\1\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\16\34\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\uffff\1\16",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "\1\16\17\uffff\1\17",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "620:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000012400002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000012640000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000012700000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000037FE80100010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000037FE80000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000017FE00000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000007FE00000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000007FE00000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000007FE41000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000080000000002L});

}