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


    // $ANTLR start "entryRulePossiblyImportedComplexType"
    // InternalDataDsl.g:378:1: entryRulePossiblyImportedComplexType : rulePossiblyImportedComplexType EOF ;
    public final void entryRulePossiblyImportedComplexType() throws RecognitionException {
        try {
            // InternalDataDsl.g:379:1: ( rulePossiblyImportedComplexType EOF )
            // InternalDataDsl.g:380:1: rulePossiblyImportedComplexType EOF
            {
             before(grammarAccess.getPossiblyImportedComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePossiblyImportedComplexType();

            state._fsp--;

             after(grammarAccess.getPossiblyImportedComplexTypeRule()); 
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
    // $ANTLR end "entryRulePossiblyImportedComplexType"


    // $ANTLR start "rulePossiblyImportedComplexType"
    // InternalDataDsl.g:387:1: rulePossiblyImportedComplexType : ( ( rule__PossiblyImportedComplexType__Group__0 ) ) ;
    public final void rulePossiblyImportedComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:391:2: ( ( ( rule__PossiblyImportedComplexType__Group__0 ) ) )
            // InternalDataDsl.g:392:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            {
            // InternalDataDsl.g:392:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            // InternalDataDsl.g:393:3: ( rule__PossiblyImportedComplexType__Group__0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup()); 
            // InternalDataDsl.g:394:3: ( rule__PossiblyImportedComplexType__Group__0 )
            // InternalDataDsl.g:394:4: rule__PossiblyImportedComplexType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup()); 

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
    // $ANTLR end "rulePossiblyImportedComplexType"


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


    // $ANTLR start "rule__DataStructure__Alternatives_4"
    // InternalDataDsl.g:578:1: rule__DataStructure__Alternatives_4 : ( ( ( rule__DataStructure__Group_4_0__0 ) ) | ( ( rule__DataStructure__Group_4_1__0 ) ) | ( ( rule__DataStructure__Group_4_2__0 ) ) );
    public final void rule__DataStructure__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:582:1: ( ( ( rule__DataStructure__Group_4_0__0 ) ) | ( ( rule__DataStructure__Group_4_1__0 ) ) | ( ( rule__DataStructure__Group_4_2__0 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalDataDsl.g:583:2: ( ( rule__DataStructure__Group_4_0__0 ) )
                    {
                    // InternalDataDsl.g:583:2: ( ( rule__DataStructure__Group_4_0__0 ) )
                    // InternalDataDsl.g:584:3: ( rule__DataStructure__Group_4_0__0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getGroup_4_0()); 
                    // InternalDataDsl.g:585:3: ( rule__DataStructure__Group_4_0__0 )
                    // InternalDataDsl.g:585:4: rule__DataStructure__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:589:2: ( ( rule__DataStructure__Group_4_1__0 ) )
                    {
                    // InternalDataDsl.g:589:2: ( ( rule__DataStructure__Group_4_1__0 ) )
                    // InternalDataDsl.g:590:3: ( rule__DataStructure__Group_4_1__0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getGroup_4_1()); 
                    // InternalDataDsl.g:591:3: ( rule__DataStructure__Group_4_1__0 )
                    // InternalDataDsl.g:591:4: rule__DataStructure__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getGroup_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:595:2: ( ( rule__DataStructure__Group_4_2__0 ) )
                    {
                    // InternalDataDsl.g:595:2: ( ( rule__DataStructure__Group_4_2__0 ) )
                    // InternalDataDsl.g:596:3: ( rule__DataStructure__Group_4_2__0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getGroup_4_2()); 
                    // InternalDataDsl.g:597:3: ( rule__DataStructure__Group_4_2__0 )
                    // InternalDataDsl.g:597:4: rule__DataStructure__Group_4_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_4_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getGroup_4_2()); 

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
    // $ANTLR end "rule__DataStructure__Alternatives_4"


    // $ANTLR start "rule__ListType__Alternatives"
    // InternalDataDsl.g:605:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );
    public final void rule__ListType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:609:1: ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalDataDsl.g:610:2: ( ( rule__ListType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:610:2: ( ( rule__ListType__Group_0__0 ) )
                    // InternalDataDsl.g:611:3: ( rule__ListType__Group_0__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:612:3: ( rule__ListType__Group_0__0 )
                    // InternalDataDsl.g:612:4: rule__ListType__Group_0__0
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
                    // InternalDataDsl.g:616:2: ( ( rule__ListType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:616:2: ( ( rule__ListType__Group_1__0 ) )
                    // InternalDataDsl.g:617:3: ( rule__ListType__Group_1__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:618:3: ( rule__ListType__Group_1__0 )
                    // InternalDataDsl.g:618:4: rule__ListType__Group_1__0
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
    // InternalDataDsl.g:626:1: rule__DataField__Alternatives_1 : ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) );
    public final void rule__DataField__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:630:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=33 && LA11_0<=42)) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalDataDsl.g:631:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    {
                    // InternalDataDsl.g:631:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    // InternalDataDsl.g:632:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_1_0()); 
                    // InternalDataDsl.g:633:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    // InternalDataDsl.g:633:4: rule__DataField__PrimitiveTypeAssignment_1_0
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
                    // InternalDataDsl.g:637:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    {
                    // InternalDataDsl.g:637:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    // InternalDataDsl.g:638:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    {
                     before(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 
                    // InternalDataDsl.g:639:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    // InternalDataDsl.g:639:4: rule__DataField__ComplexTypeAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__ComplexTypeAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 

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
    // InternalDataDsl.g:647:1: rule__DataOperation__Alternatives_1 : ( ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) ) | ( ( rule__DataOperation__Group_1_1__0 ) ) );
    public final void rule__DataOperation__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:651:1: ( ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) ) | ( ( rule__DataOperation__Group_1_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==45) ) {
                alt12=1;
            }
            else if ( (LA12_0==31) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalDataDsl.g:652:2: ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) )
                    {
                    // InternalDataDsl.g:652:2: ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) )
                    // InternalDataDsl.g:653:3: ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeAssignment_1_0()); 
                    // InternalDataDsl.g:654:3: ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 )
                    // InternalDataDsl.g:654:4: rule__DataOperation__HasNoReturnTypeAssignment_1_0
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
                    // InternalDataDsl.g:658:2: ( ( rule__DataOperation__Group_1_1__0 ) )
                    {
                    // InternalDataDsl.g:658:2: ( ( rule__DataOperation__Group_1_1__0 ) )
                    // InternalDataDsl.g:659:3: ( rule__DataOperation__Group_1_1__0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getGroup_1_1()); 
                    // InternalDataDsl.g:660:3: ( rule__DataOperation__Group_1_1__0 )
                    // InternalDataDsl.g:660:4: rule__DataOperation__Group_1_1__0
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
    // InternalDataDsl.g:668:1: rule__DataOperation__Alternatives_1_1_1 : ( ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) ) | ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) ) );
    public final void rule__DataOperation__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:672:1: ( ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) ) | ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=33 && LA13_0<=42)) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDsl.g:673:2: ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) )
                    {
                    // InternalDataDsl.g:673:2: ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) )
                    // InternalDataDsl.g:674:3: ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypeAssignment_1_1_1_0()); 
                    // InternalDataDsl.g:675:3: ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 )
                    // InternalDataDsl.g:675:4: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0
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
                    // InternalDataDsl.g:679:2: ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) )
                    {
                    // InternalDataDsl.g:679:2: ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) )
                    // InternalDataDsl.g:680:3: ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 )
                    {
                     before(grammarAccess.getDataOperationAccess().getComplexReturnTypeAssignment_1_1_1_1()); 
                    // InternalDataDsl.g:681:3: ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 )
                    // InternalDataDsl.g:681:4: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationAccess().getComplexReturnTypeAssignment_1_1_1_1()); 

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
    // InternalDataDsl.g:689:1: rule__DataOperationParameter__Alternatives_0 : ( ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) ) | ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) ) );
    public final void rule__DataOperationParameter__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:693:1: ( ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) ) | ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=33 && LA14_0<=42)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalDataDsl.g:694:2: ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) )
                    {
                    // InternalDataDsl.g:694:2: ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) )
                    // InternalDataDsl.g:695:3: ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypeAssignment_0_0()); 
                    // InternalDataDsl.g:696:3: ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 )
                    // InternalDataDsl.g:696:4: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0
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
                    // InternalDataDsl.g:700:2: ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) )
                    {
                    // InternalDataDsl.g:700:2: ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) )
                    // InternalDataDsl.g:701:3: ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getComplexTypeAssignment_0_1()); 
                    // InternalDataDsl.g:702:3: ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 )
                    // InternalDataDsl.g:702:4: rule__DataOperationParameter__ComplexTypeAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperationParameter__ComplexTypeAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataOperationParameterAccess().getComplexTypeAssignment_0_1()); 

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
    // InternalDataDsl.g:710:1: rule__PrimitiveValue__Alternatives : ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) );
    public final void rule__PrimitiveValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:714:1: ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt15=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt15=2;
                }
                break;
            case RULE_STRING:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalDataDsl.g:715:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    {
                    // InternalDataDsl.g:715:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    // InternalDataDsl.g:716:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0()); 
                    // InternalDataDsl.g:717:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    // InternalDataDsl.g:717:4: rule__PrimitiveValue__NumericValueAssignment_0
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
                    // InternalDataDsl.g:721:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    {
                    // InternalDataDsl.g:721:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    // InternalDataDsl.g:722:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1()); 
                    // InternalDataDsl.g:723:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    // InternalDataDsl.g:723:4: rule__PrimitiveValue__BooleanValueAssignment_1
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
                    // InternalDataDsl.g:727:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    {
                    // InternalDataDsl.g:727:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    // InternalDataDsl.g:728:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2()); 
                    // InternalDataDsl.g:729:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    // InternalDataDsl.g:729:4: rule__PrimitiveValue__StringValueAssignment_2
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
    // InternalDataDsl.g:737:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:741:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) )
            int alt16=10;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt16=1;
                }
                break;
            case 34:
                {
                alt16=2;
                }
                break;
            case 35:
                {
                alt16=3;
                }
                break;
            case 36:
                {
                alt16=4;
                }
                break;
            case 37:
                {
                alt16=5;
                }
                break;
            case 38:
                {
                alt16=6;
                }
                break;
            case 39:
                {
                alt16=7;
                }
                break;
            case 40:
                {
                alt16=8;
                }
                break;
            case 41:
                {
                alt16=9;
                }
                break;
            case 42:
                {
                alt16=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalDataDsl.g:742:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:742:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalDataDsl.g:743:3: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:744:3: ( rule__PrimitiveType__Group_0__0 )
                    // InternalDataDsl.g:744:4: rule__PrimitiveType__Group_0__0
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
                    // InternalDataDsl.g:748:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:748:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalDataDsl.g:749:3: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:750:3: ( rule__PrimitiveType__Group_1__0 )
                    // InternalDataDsl.g:750:4: rule__PrimitiveType__Group_1__0
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
                    // InternalDataDsl.g:754:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalDataDsl.g:754:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalDataDsl.g:755:3: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalDataDsl.g:756:3: ( rule__PrimitiveType__Group_2__0 )
                    // InternalDataDsl.g:756:4: rule__PrimitiveType__Group_2__0
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
                    // InternalDataDsl.g:760:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalDataDsl.g:760:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalDataDsl.g:761:3: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalDataDsl.g:762:3: ( rule__PrimitiveType__Group_3__0 )
                    // InternalDataDsl.g:762:4: rule__PrimitiveType__Group_3__0
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
                    // InternalDataDsl.g:766:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    {
                    // InternalDataDsl.g:766:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    // InternalDataDsl.g:767:3: ( rule__PrimitiveType__Group_4__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 
                    // InternalDataDsl.g:768:3: ( rule__PrimitiveType__Group_4__0 )
                    // InternalDataDsl.g:768:4: rule__PrimitiveType__Group_4__0
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
                    // InternalDataDsl.g:772:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    {
                    // InternalDataDsl.g:772:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    // InternalDataDsl.g:773:3: ( rule__PrimitiveType__Group_5__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 
                    // InternalDataDsl.g:774:3: ( rule__PrimitiveType__Group_5__0 )
                    // InternalDataDsl.g:774:4: rule__PrimitiveType__Group_5__0
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
                    // InternalDataDsl.g:778:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    {
                    // InternalDataDsl.g:778:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    // InternalDataDsl.g:779:3: ( rule__PrimitiveType__Group_6__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 
                    // InternalDataDsl.g:780:3: ( rule__PrimitiveType__Group_6__0 )
                    // InternalDataDsl.g:780:4: rule__PrimitiveType__Group_6__0
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
                    // InternalDataDsl.g:784:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    {
                    // InternalDataDsl.g:784:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    // InternalDataDsl.g:785:3: ( rule__PrimitiveType__Group_7__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 
                    // InternalDataDsl.g:786:3: ( rule__PrimitiveType__Group_7__0 )
                    // InternalDataDsl.g:786:4: rule__PrimitiveType__Group_7__0
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
                    // InternalDataDsl.g:790:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    {
                    // InternalDataDsl.g:790:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    // InternalDataDsl.g:791:3: ( rule__PrimitiveType__Group_8__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 
                    // InternalDataDsl.g:792:3: ( rule__PrimitiveType__Group_8__0 )
                    // InternalDataDsl.g:792:4: rule__PrimitiveType__Group_8__0
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
                    // InternalDataDsl.g:796:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    {
                    // InternalDataDsl.g:796:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    // InternalDataDsl.g:797:3: ( rule__PrimitiveType__Group_9__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 
                    // InternalDataDsl.g:798:3: ( rule__PrimitiveType__Group_9__0 )
                    // InternalDataDsl.g:798:4: rule__PrimitiveType__Group_9__0
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
    // InternalDataDsl.g:806:1: rule__DataModel__Group__0 : rule__DataModel__Group__0__Impl rule__DataModel__Group__1 ;
    public final void rule__DataModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:810:1: ( rule__DataModel__Group__0__Impl rule__DataModel__Group__1 )
            // InternalDataDsl.g:811:2: rule__DataModel__Group__0__Impl rule__DataModel__Group__1
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
    // InternalDataDsl.g:818:1: rule__DataModel__Group__0__Impl : ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) ;
    public final void rule__DataModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:822:1: ( ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) )
            // InternalDataDsl.g:823:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            {
            // InternalDataDsl.g:823:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            // InternalDataDsl.g:824:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            {
             before(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0()); 
            // InternalDataDsl.g:825:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDataDsl.g:825:3: rule__DataModel__ComplexTypeImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataModel__ComplexTypeImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalDataDsl.g:833:1: rule__DataModel__Group__1 : rule__DataModel__Group__1__Impl ;
    public final void rule__DataModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:837:1: ( rule__DataModel__Group__1__Impl )
            // InternalDataDsl.g:838:2: rule__DataModel__Group__1__Impl
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
    // InternalDataDsl.g:844:1: rule__DataModel__Group__1__Impl : ( ( rule__DataModel__Alternatives_1 ) ) ;
    public final void rule__DataModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:848:1: ( ( ( rule__DataModel__Alternatives_1 ) ) )
            // InternalDataDsl.g:849:1: ( ( rule__DataModel__Alternatives_1 ) )
            {
            // InternalDataDsl.g:849:1: ( ( rule__DataModel__Alternatives_1 ) )
            // InternalDataDsl.g:850:2: ( rule__DataModel__Alternatives_1 )
            {
             before(grammarAccess.getDataModelAccess().getAlternatives_1()); 
            // InternalDataDsl.g:851:2: ( rule__DataModel__Alternatives_1 )
            // InternalDataDsl.g:851:3: rule__DataModel__Alternatives_1
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
    // InternalDataDsl.g:860:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:864:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalDataDsl.g:865:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
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
    // InternalDataDsl.g:872:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:876:1: ( ( 'import' ) )
            // InternalDataDsl.g:877:1: ( 'import' )
            {
            // InternalDataDsl.g:877:1: ( 'import' )
            // InternalDataDsl.g:878:2: 'import'
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
    // InternalDataDsl.g:887:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:891:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalDataDsl.g:892:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
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
    // InternalDataDsl.g:899:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:903:1: ( ( 'datatypes' ) )
            // InternalDataDsl.g:904:1: ( 'datatypes' )
            {
            // InternalDataDsl.g:904:1: ( 'datatypes' )
            // InternalDataDsl.g:905:2: 'datatypes'
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
    // InternalDataDsl.g:914:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:918:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalDataDsl.g:919:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
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
    // InternalDataDsl.g:926:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:930:1: ( ( 'from' ) )
            // InternalDataDsl.g:931:1: ( 'from' )
            {
            // InternalDataDsl.g:931:1: ( 'from' )
            // InternalDataDsl.g:932:2: 'from'
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
    // InternalDataDsl.g:941:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:945:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalDataDsl.g:946:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
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
    // InternalDataDsl.g:953:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:957:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalDataDsl.g:958:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalDataDsl.g:958:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalDataDsl.g:959:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalDataDsl.g:960:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalDataDsl.g:960:3: rule__ComplexTypeImport__ImportURIAssignment_3
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
    // InternalDataDsl.g:968:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:972:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalDataDsl.g:973:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
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
    // InternalDataDsl.g:980:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:984:1: ( ( 'as' ) )
            // InternalDataDsl.g:985:1: ( 'as' )
            {
            // InternalDataDsl.g:985:1: ( 'as' )
            // InternalDataDsl.g:986:2: 'as'
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
    // InternalDataDsl.g:995:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:999:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalDataDsl.g:1000:2: rule__ComplexTypeImport__Group__5__Impl
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
    // InternalDataDsl.g:1006:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1010:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalDataDsl.g:1011:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalDataDsl.g:1011:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalDataDsl.g:1012:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalDataDsl.g:1013:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalDataDsl.g:1013:3: rule__ComplexTypeImport__NameAssignment_5
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
    // InternalDataDsl.g:1022:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1026:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalDataDsl.g:1027:2: rule__Version__Group__0__Impl rule__Version__Group__1
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
    // InternalDataDsl.g:1034:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1038:1: ( ( 'version' ) )
            // InternalDataDsl.g:1039:1: ( 'version' )
            {
            // InternalDataDsl.g:1039:1: ( 'version' )
            // InternalDataDsl.g:1040:2: 'version'
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
    // InternalDataDsl.g:1049:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1053:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalDataDsl.g:1054:2: rule__Version__Group__1__Impl rule__Version__Group__2
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
    // InternalDataDsl.g:1061:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1065:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1066:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1066:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalDataDsl.g:1067:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1068:2: ( rule__Version__NameAssignment_1 )
            // InternalDataDsl.g:1068:3: rule__Version__NameAssignment_1
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
    // InternalDataDsl.g:1076:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1080:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalDataDsl.g:1081:2: rule__Version__Group__2__Impl rule__Version__Group__3
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
    // InternalDataDsl.g:1088:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1092:1: ( ( '{' ) )
            // InternalDataDsl.g:1093:1: ( '{' )
            {
            // InternalDataDsl.g:1093:1: ( '{' )
            // InternalDataDsl.g:1094:2: '{'
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
    // InternalDataDsl.g:1103:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1107:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalDataDsl.g:1108:2: rule__Version__Group__3__Impl rule__Version__Group__4
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
    // InternalDataDsl.g:1115:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1119:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalDataDsl.g:1120:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalDataDsl.g:1120:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalDataDsl.g:1121:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalDataDsl.g:1122:2: ( rule__Version__Alternatives_3 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=21 && LA18_0<=22)||LA18_0==25||LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDataDsl.g:1122:3: rule__Version__Alternatives_3
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
    // InternalDataDsl.g:1130:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1134:1: ( rule__Version__Group__4__Impl )
            // InternalDataDsl.g:1135:2: rule__Version__Group__4__Impl
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
    // InternalDataDsl.g:1141:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1145:1: ( ( '}' ) )
            // InternalDataDsl.g:1146:1: ( '}' )
            {
            // InternalDataDsl.g:1146:1: ( '}' )
            // InternalDataDsl.g:1147:2: '}'
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
    // InternalDataDsl.g:1157:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1161:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalDataDsl.g:1162:2: rule__Context__Group__0__Impl rule__Context__Group__1
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
    // InternalDataDsl.g:1169:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1173:1: ( ( 'context' ) )
            // InternalDataDsl.g:1174:1: ( 'context' )
            {
            // InternalDataDsl.g:1174:1: ( 'context' )
            // InternalDataDsl.g:1175:2: 'context'
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
    // InternalDataDsl.g:1184:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1188:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalDataDsl.g:1189:2: rule__Context__Group__1__Impl rule__Context__Group__2
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
    // InternalDataDsl.g:1196:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1200:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1201:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1201:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalDataDsl.g:1202:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1203:2: ( rule__Context__NameAssignment_1 )
            // InternalDataDsl.g:1203:3: rule__Context__NameAssignment_1
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
    // InternalDataDsl.g:1211:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1215:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalDataDsl.g:1216:2: rule__Context__Group__2__Impl rule__Context__Group__3
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
    // InternalDataDsl.g:1223:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1227:1: ( ( '{' ) )
            // InternalDataDsl.g:1228:1: ( '{' )
            {
            // InternalDataDsl.g:1228:1: ( '{' )
            // InternalDataDsl.g:1229:2: '{'
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
    // InternalDataDsl.g:1238:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1242:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalDataDsl.g:1243:2: rule__Context__Group__3__Impl rule__Context__Group__4
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
    // InternalDataDsl.g:1250:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1254:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalDataDsl.g:1255:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalDataDsl.g:1255:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalDataDsl.g:1256:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalDataDsl.g:1256:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalDataDsl.g:1257:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1258:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalDataDsl.g:1258:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_5);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalDataDsl.g:1261:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalDataDsl.g:1262:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1263:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==22||LA19_0==25||LA19_0==28) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDataDsl.g:1263:4: rule__Context__ComplexTypesAssignment_3
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Context__ComplexTypesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalDataDsl.g:1272:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1276:1: ( rule__Context__Group__4__Impl )
            // InternalDataDsl.g:1277:2: rule__Context__Group__4__Impl
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
    // InternalDataDsl.g:1283:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1287:1: ( ( '}' ) )
            // InternalDataDsl.g:1288:1: ( '}' )
            {
            // InternalDataDsl.g:1288:1: ( '}' )
            // InternalDataDsl.g:1289:2: '}'
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
    // InternalDataDsl.g:1299:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1303:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalDataDsl.g:1304:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
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
    // InternalDataDsl.g:1311:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1315:1: ( ( 'structure' ) )
            // InternalDataDsl.g:1316:1: ( 'structure' )
            {
            // InternalDataDsl.g:1316:1: ( 'structure' )
            // InternalDataDsl.g:1317:2: 'structure'
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
    // InternalDataDsl.g:1326:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1330:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalDataDsl.g:1331:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
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
    // InternalDataDsl.g:1338:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1342:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1343:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1343:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalDataDsl.g:1344:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1345:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalDataDsl.g:1345:3: rule__DataStructure__NameAssignment_1
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
    // InternalDataDsl.g:1353:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1357:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalDataDsl.g:1358:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
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
    // InternalDataDsl.g:1365:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1369:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalDataDsl.g:1370:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalDataDsl.g:1370:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalDataDsl.g:1371:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalDataDsl.g:1372:2: ( rule__DataStructure__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDataDsl.g:1372:3: rule__DataStructure__Group_2__0
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
    // InternalDataDsl.g:1380:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1384:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalDataDsl.g:1385:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
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
    // InternalDataDsl.g:1392:1: rule__DataStructure__Group__3__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1396:1: ( ( '{' ) )
            // InternalDataDsl.g:1397:1: ( '{' )
            {
            // InternalDataDsl.g:1397:1: ( '{' )
            // InternalDataDsl.g:1398:2: '{'
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
    // InternalDataDsl.g:1407:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1411:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalDataDsl.g:1412:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
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
    // InternalDataDsl.g:1419:1: rule__DataStructure__Group__4__Impl : ( ( rule__DataStructure__Alternatives_4 )? ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1423:1: ( ( ( rule__DataStructure__Alternatives_4 )? ) )
            // InternalDataDsl.g:1424:1: ( ( rule__DataStructure__Alternatives_4 )? )
            {
            // InternalDataDsl.g:1424:1: ( ( rule__DataStructure__Alternatives_4 )? )
            // InternalDataDsl.g:1425:2: ( rule__DataStructure__Alternatives_4 )?
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_4()); 
            // InternalDataDsl.g:1426:2: ( rule__DataStructure__Alternatives_4 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||LA21_0==31||(LA21_0>=33 && LA21_0<=42)||(LA21_0>=44 && LA21_0<=45)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDsl.g:1426:3: rule__DataStructure__Alternatives_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Alternatives_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStructureAccess().getAlternatives_4()); 

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
    // InternalDataDsl.g:1434:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1438:1: ( rule__DataStructure__Group__5__Impl )
            // InternalDataDsl.g:1439:2: rule__DataStructure__Group__5__Impl
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
    // InternalDataDsl.g:1445:1: rule__DataStructure__Group__5__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1449:1: ( ( '}' ) )
            // InternalDataDsl.g:1450:1: ( '}' )
            {
            // InternalDataDsl.g:1450:1: ( '}' )
            // InternalDataDsl.g:1451:2: '}'
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
    // InternalDataDsl.g:1461:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1465:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalDataDsl.g:1466:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalDataDsl.g:1473:1: rule__DataStructure__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1477:1: ( ( 'extends' ) )
            // InternalDataDsl.g:1478:1: ( 'extends' )
            {
            // InternalDataDsl.g:1478:1: ( 'extends' )
            // InternalDataDsl.g:1479:2: 'extends'
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
    // InternalDataDsl.g:1488:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1492:1: ( rule__DataStructure__Group_2__1__Impl )
            // InternalDataDsl.g:1493:2: rule__DataStructure__Group_2__1__Impl
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
    // InternalDataDsl.g:1499:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__SuperAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1503:1: ( ( ( rule__DataStructure__SuperAssignment_2_1 ) ) )
            // InternalDataDsl.g:1504:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            {
            // InternalDataDsl.g:1504:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            // InternalDataDsl.g:1505:2: ( rule__DataStructure__SuperAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_2_1()); 
            // InternalDataDsl.g:1506:2: ( rule__DataStructure__SuperAssignment_2_1 )
            // InternalDataDsl.g:1506:3: rule__DataStructure__SuperAssignment_2_1
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


    // $ANTLR start "rule__DataStructure__Group_4_0__0"
    // InternalDataDsl.g:1515:1: rule__DataStructure__Group_4_0__0 : rule__DataStructure__Group_4_0__0__Impl rule__DataStructure__Group_4_0__1 ;
    public final void rule__DataStructure__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1519:1: ( rule__DataStructure__Group_4_0__0__Impl rule__DataStructure__Group_4_0__1 )
            // InternalDataDsl.g:1520:2: rule__DataStructure__Group_4_0__0__Impl rule__DataStructure__Group_4_0__1
            {
            pushFollow(FOLLOW_20);
            rule__DataStructure__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_0__1();

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
    // $ANTLR end "rule__DataStructure__Group_4_0__0"


    // $ANTLR start "rule__DataStructure__Group_4_0__0__Impl"
    // InternalDataDsl.g:1527:1: rule__DataStructure__Group_4_0__0__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) ) ;
    public final void rule__DataStructure__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1531:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) ) )
            // InternalDataDsl.g:1532:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) )
            {
            // InternalDataDsl.g:1532:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0_0 ) )
            // InternalDataDsl.g:1533:2: ( rule__DataStructure__DataFieldsAssignment_4_0_0 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0_0()); 
            // InternalDataDsl.g:1534:2: ( rule__DataStructure__DataFieldsAssignment_4_0_0 )
            // InternalDataDsl.g:1534:3: rule__DataStructure__DataFieldsAssignment_4_0_0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__DataFieldsAssignment_4_0_0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0_0()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_0__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_0__1"
    // InternalDataDsl.g:1542:1: rule__DataStructure__Group_4_0__1 : rule__DataStructure__Group_4_0__1__Impl ;
    public final void rule__DataStructure__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1546:1: ( rule__DataStructure__Group_4_0__1__Impl )
            // InternalDataDsl.g:1547:2: rule__DataStructure__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_0__1__Impl();

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
    // $ANTLR end "rule__DataStructure__Group_4_0__1"


    // $ANTLR start "rule__DataStructure__Group_4_0__1__Impl"
    // InternalDataDsl.g:1553:1: rule__DataStructure__Group_4_0__1__Impl : ( ( rule__DataStructure__Group_4_0_1__0 )* ) ;
    public final void rule__DataStructure__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1557:1: ( ( ( rule__DataStructure__Group_4_0_1__0 )* ) )
            // InternalDataDsl.g:1558:1: ( ( rule__DataStructure__Group_4_0_1__0 )* )
            {
            // InternalDataDsl.g:1558:1: ( ( rule__DataStructure__Group_4_0_1__0 )* )
            // InternalDataDsl.g:1559:2: ( rule__DataStructure__Group_4_0_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_0_1()); 
            // InternalDataDsl.g:1560:2: ( rule__DataStructure__Group_4_0_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==24) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDataDsl.g:1560:3: rule__DataStructure__Group_4_0_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_4_0_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_4_0_1()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_0__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_0_1__0"
    // InternalDataDsl.g:1569:1: rule__DataStructure__Group_4_0_1__0 : rule__DataStructure__Group_4_0_1__0__Impl rule__DataStructure__Group_4_0_1__1 ;
    public final void rule__DataStructure__Group_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1573:1: ( rule__DataStructure__Group_4_0_1__0__Impl rule__DataStructure__Group_4_0_1__1 )
            // InternalDataDsl.g:1574:2: rule__DataStructure__Group_4_0_1__0__Impl rule__DataStructure__Group_4_0_1__1
            {
            pushFollow(FOLLOW_22);
            rule__DataStructure__Group_4_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_0_1__1();

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
    // $ANTLR end "rule__DataStructure__Group_4_0_1__0"


    // $ANTLR start "rule__DataStructure__Group_4_0_1__0__Impl"
    // InternalDataDsl.g:1581:1: rule__DataStructure__Group_4_0_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1585:1: ( ( ',' ) )
            // InternalDataDsl.g:1586:1: ( ',' )
            {
            // InternalDataDsl.g:1586:1: ( ',' )
            // InternalDataDsl.g:1587:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_0_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_4_0_1_0()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_0_1__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_0_1__1"
    // InternalDataDsl.g:1596:1: rule__DataStructure__Group_4_0_1__1 : rule__DataStructure__Group_4_0_1__1__Impl ;
    public final void rule__DataStructure__Group_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1600:1: ( rule__DataStructure__Group_4_0_1__1__Impl )
            // InternalDataDsl.g:1601:2: rule__DataStructure__Group_4_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_0_1__1__Impl();

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
    // $ANTLR end "rule__DataStructure__Group_4_0_1__1"


    // $ANTLR start "rule__DataStructure__Group_4_0_1__1__Impl"
    // InternalDataDsl.g:1607:1: rule__DataStructure__Group_4_0_1__1__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_0_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1611:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_0_1_1 ) ) )
            // InternalDataDsl.g:1612:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0_1_1 ) )
            {
            // InternalDataDsl.g:1612:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0_1_1 ) )
            // InternalDataDsl.g:1613:2: ( rule__DataStructure__DataFieldsAssignment_4_0_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0_1_1()); 
            // InternalDataDsl.g:1614:2: ( rule__DataStructure__DataFieldsAssignment_4_0_1_1 )
            // InternalDataDsl.g:1614:3: rule__DataStructure__DataFieldsAssignment_4_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__DataFieldsAssignment_4_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0_1_1()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_0_1__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_1__0"
    // InternalDataDsl.g:1623:1: rule__DataStructure__Group_4_1__0 : rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 ;
    public final void rule__DataStructure__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1627:1: ( rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 )
            // InternalDataDsl.g:1628:2: rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalDataDsl.g:1635:1: rule__DataStructure__Group_4_1__0__Impl : ( ( rule__DataStructure__OperationsAssignment_4_1_0 ) ) ;
    public final void rule__DataStructure__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1639:1: ( ( ( rule__DataStructure__OperationsAssignment_4_1_0 ) ) )
            // InternalDataDsl.g:1640:1: ( ( rule__DataStructure__OperationsAssignment_4_1_0 ) )
            {
            // InternalDataDsl.g:1640:1: ( ( rule__DataStructure__OperationsAssignment_4_1_0 ) )
            // InternalDataDsl.g:1641:2: ( rule__DataStructure__OperationsAssignment_4_1_0 )
            {
             before(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_1_0()); 
            // InternalDataDsl.g:1642:2: ( rule__DataStructure__OperationsAssignment_4_1_0 )
            // InternalDataDsl.g:1642:3: rule__DataStructure__OperationsAssignment_4_1_0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__OperationsAssignment_4_1_0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_1_0()); 

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
    // InternalDataDsl.g:1650:1: rule__DataStructure__Group_4_1__1 : rule__DataStructure__Group_4_1__1__Impl ;
    public final void rule__DataStructure__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1654:1: ( rule__DataStructure__Group_4_1__1__Impl )
            // InternalDataDsl.g:1655:2: rule__DataStructure__Group_4_1__1__Impl
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
    // InternalDataDsl.g:1661:1: rule__DataStructure__Group_4_1__1__Impl : ( ( rule__DataStructure__Group_4_1_1__0 )* ) ;
    public final void rule__DataStructure__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1665:1: ( ( ( rule__DataStructure__Group_4_1_1__0 )* ) )
            // InternalDataDsl.g:1666:1: ( ( rule__DataStructure__Group_4_1_1__0 )* )
            {
            // InternalDataDsl.g:1666:1: ( ( rule__DataStructure__Group_4_1_1__0 )* )
            // InternalDataDsl.g:1667:2: ( rule__DataStructure__Group_4_1_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_1_1()); 
            // InternalDataDsl.g:1668:2: ( rule__DataStructure__Group_4_1_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDsl.g:1668:3: rule__DataStructure__Group_4_1_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_4_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_4_1_1()); 

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


    // $ANTLR start "rule__DataStructure__Group_4_1_1__0"
    // InternalDataDsl.g:1677:1: rule__DataStructure__Group_4_1_1__0 : rule__DataStructure__Group_4_1_1__0__Impl rule__DataStructure__Group_4_1_1__1 ;
    public final void rule__DataStructure__Group_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1681:1: ( rule__DataStructure__Group_4_1_1__0__Impl rule__DataStructure__Group_4_1_1__1 )
            // InternalDataDsl.g:1682:2: rule__DataStructure__Group_4_1_1__0__Impl rule__DataStructure__Group_4_1_1__1
            {
            pushFollow(FOLLOW_23);
            rule__DataStructure__Group_4_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_1_1__1();

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
    // $ANTLR end "rule__DataStructure__Group_4_1_1__0"


    // $ANTLR start "rule__DataStructure__Group_4_1_1__0__Impl"
    // InternalDataDsl.g:1689:1: rule__DataStructure__Group_4_1_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1693:1: ( ( ',' ) )
            // InternalDataDsl.g:1694:1: ( ',' )
            {
            // InternalDataDsl.g:1694:1: ( ',' )
            // InternalDataDsl.g:1695:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_1_0()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_1_1__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_1_1__1"
    // InternalDataDsl.g:1704:1: rule__DataStructure__Group_4_1_1__1 : rule__DataStructure__Group_4_1_1__1__Impl ;
    public final void rule__DataStructure__Group_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1708:1: ( rule__DataStructure__Group_4_1_1__1__Impl )
            // InternalDataDsl.g:1709:2: rule__DataStructure__Group_4_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_1_1__1__Impl();

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
    // $ANTLR end "rule__DataStructure__Group_4_1_1__1"


    // $ANTLR start "rule__DataStructure__Group_4_1_1__1__Impl"
    // InternalDataDsl.g:1715:1: rule__DataStructure__Group_4_1_1__1__Impl : ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1719:1: ( ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) ) )
            // InternalDataDsl.g:1720:1: ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) )
            {
            // InternalDataDsl.g:1720:1: ( ( rule__DataStructure__OperationsAssignment_4_1_1_1 ) )
            // InternalDataDsl.g:1721:2: ( rule__DataStructure__OperationsAssignment_4_1_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_1_1_1()); 
            // InternalDataDsl.g:1722:2: ( rule__DataStructure__OperationsAssignment_4_1_1_1 )
            // InternalDataDsl.g:1722:3: rule__DataStructure__OperationsAssignment_4_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__OperationsAssignment_4_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_1_1_1()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_1_1__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2__0"
    // InternalDataDsl.g:1731:1: rule__DataStructure__Group_4_2__0 : rule__DataStructure__Group_4_2__0__Impl rule__DataStructure__Group_4_2__1 ;
    public final void rule__DataStructure__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1735:1: ( rule__DataStructure__Group_4_2__0__Impl rule__DataStructure__Group_4_2__1 )
            // InternalDataDsl.g:1736:2: rule__DataStructure__Group_4_2__0__Impl rule__DataStructure__Group_4_2__1
            {
            pushFollow(FOLLOW_20);
            rule__DataStructure__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2__1();

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
    // $ANTLR end "rule__DataStructure__Group_4_2__0"


    // $ANTLR start "rule__DataStructure__Group_4_2__0__Impl"
    // InternalDataDsl.g:1743:1: rule__DataStructure__Group_4_2__0__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_2_0 ) ) ;
    public final void rule__DataStructure__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1747:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_2_0 ) ) )
            // InternalDataDsl.g:1748:1: ( ( rule__DataStructure__DataFieldsAssignment_4_2_0 ) )
            {
            // InternalDataDsl.g:1748:1: ( ( rule__DataStructure__DataFieldsAssignment_4_2_0 ) )
            // InternalDataDsl.g:1749:2: ( rule__DataStructure__DataFieldsAssignment_4_2_0 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_2_0()); 
            // InternalDataDsl.g:1750:2: ( rule__DataStructure__DataFieldsAssignment_4_2_0 )
            // InternalDataDsl.g:1750:3: rule__DataStructure__DataFieldsAssignment_4_2_0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__DataFieldsAssignment_4_2_0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_2_0()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2__1"
    // InternalDataDsl.g:1758:1: rule__DataStructure__Group_4_2__1 : rule__DataStructure__Group_4_2__1__Impl rule__DataStructure__Group_4_2__2 ;
    public final void rule__DataStructure__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1762:1: ( rule__DataStructure__Group_4_2__1__Impl rule__DataStructure__Group_4_2__2 )
            // InternalDataDsl.g:1763:2: rule__DataStructure__Group_4_2__1__Impl rule__DataStructure__Group_4_2__2
            {
            pushFollow(FOLLOW_20);
            rule__DataStructure__Group_4_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2__2();

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
    // $ANTLR end "rule__DataStructure__Group_4_2__1"


    // $ANTLR start "rule__DataStructure__Group_4_2__1__Impl"
    // InternalDataDsl.g:1770:1: rule__DataStructure__Group_4_2__1__Impl : ( ( rule__DataStructure__Group_4_2_1__0 )* ) ;
    public final void rule__DataStructure__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1774:1: ( ( ( rule__DataStructure__Group_4_2_1__0 )* ) )
            // InternalDataDsl.g:1775:1: ( ( rule__DataStructure__Group_4_2_1__0 )* )
            {
            // InternalDataDsl.g:1775:1: ( ( rule__DataStructure__Group_4_2_1__0 )* )
            // InternalDataDsl.g:1776:2: ( rule__DataStructure__Group_4_2_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_2_1()); 
            // InternalDataDsl.g:1777:2: ( rule__DataStructure__Group_4_2_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==24) ) {
                    int LA24_1 = input.LA(2);

                    if ( (LA24_1==44) ) {
                        int LA24_2 = input.LA(3);

                        if ( (LA24_2==RULE_ID||(LA24_2>=33 && LA24_2<=42)) ) {
                            alt24=1;
                        }


                    }
                    else if ( (LA24_1==RULE_ID||(LA24_1>=33 && LA24_1<=42)) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // InternalDataDsl.g:1777:3: rule__DataStructure__Group_4_2_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_4_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_4_2_1()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2__2"
    // InternalDataDsl.g:1785:1: rule__DataStructure__Group_4_2__2 : rule__DataStructure__Group_4_2__2__Impl rule__DataStructure__Group_4_2__3 ;
    public final void rule__DataStructure__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1789:1: ( rule__DataStructure__Group_4_2__2__Impl rule__DataStructure__Group_4_2__3 )
            // InternalDataDsl.g:1790:2: rule__DataStructure__Group_4_2__2__Impl rule__DataStructure__Group_4_2__3
            {
            pushFollow(FOLLOW_23);
            rule__DataStructure__Group_4_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2__3();

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
    // $ANTLR end "rule__DataStructure__Group_4_2__2"


    // $ANTLR start "rule__DataStructure__Group_4_2__2__Impl"
    // InternalDataDsl.g:1797:1: rule__DataStructure__Group_4_2__2__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1801:1: ( ( ',' ) )
            // InternalDataDsl.g:1802:1: ( ',' )
            {
            // InternalDataDsl.g:1802:1: ( ',' )
            // InternalDataDsl.g:1803:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_2()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2__2__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2__3"
    // InternalDataDsl.g:1812:1: rule__DataStructure__Group_4_2__3 : rule__DataStructure__Group_4_2__3__Impl rule__DataStructure__Group_4_2__4 ;
    public final void rule__DataStructure__Group_4_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1816:1: ( rule__DataStructure__Group_4_2__3__Impl rule__DataStructure__Group_4_2__4 )
            // InternalDataDsl.g:1817:2: rule__DataStructure__Group_4_2__3__Impl rule__DataStructure__Group_4_2__4
            {
            pushFollow(FOLLOW_20);
            rule__DataStructure__Group_4_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2__4();

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
    // $ANTLR end "rule__DataStructure__Group_4_2__3"


    // $ANTLR start "rule__DataStructure__Group_4_2__3__Impl"
    // InternalDataDsl.g:1824:1: rule__DataStructure__Group_4_2__3__Impl : ( ( rule__DataStructure__OperationsAssignment_4_2_3 ) ) ;
    public final void rule__DataStructure__Group_4_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1828:1: ( ( ( rule__DataStructure__OperationsAssignment_4_2_3 ) ) )
            // InternalDataDsl.g:1829:1: ( ( rule__DataStructure__OperationsAssignment_4_2_3 ) )
            {
            // InternalDataDsl.g:1829:1: ( ( rule__DataStructure__OperationsAssignment_4_2_3 ) )
            // InternalDataDsl.g:1830:2: ( rule__DataStructure__OperationsAssignment_4_2_3 )
            {
             before(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_2_3()); 
            // InternalDataDsl.g:1831:2: ( rule__DataStructure__OperationsAssignment_4_2_3 )
            // InternalDataDsl.g:1831:3: rule__DataStructure__OperationsAssignment_4_2_3
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__OperationsAssignment_4_2_3();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_2_3()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2__3__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2__4"
    // InternalDataDsl.g:1839:1: rule__DataStructure__Group_4_2__4 : rule__DataStructure__Group_4_2__4__Impl ;
    public final void rule__DataStructure__Group_4_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1843:1: ( rule__DataStructure__Group_4_2__4__Impl )
            // InternalDataDsl.g:1844:2: rule__DataStructure__Group_4_2__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2__4__Impl();

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
    // $ANTLR end "rule__DataStructure__Group_4_2__4"


    // $ANTLR start "rule__DataStructure__Group_4_2__4__Impl"
    // InternalDataDsl.g:1850:1: rule__DataStructure__Group_4_2__4__Impl : ( ( rule__DataStructure__Group_4_2_4__0 )* ) ;
    public final void rule__DataStructure__Group_4_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1854:1: ( ( ( rule__DataStructure__Group_4_2_4__0 )* ) )
            // InternalDataDsl.g:1855:1: ( ( rule__DataStructure__Group_4_2_4__0 )* )
            {
            // InternalDataDsl.g:1855:1: ( ( rule__DataStructure__Group_4_2_4__0 )* )
            // InternalDataDsl.g:1856:2: ( rule__DataStructure__Group_4_2_4__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_2_4()); 
            // InternalDataDsl.g:1857:2: ( rule__DataStructure__Group_4_2_4__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==24) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDataDsl.g:1857:3: rule__DataStructure__Group_4_2_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_4_2_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_4_2_4()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2__4__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2_1__0"
    // InternalDataDsl.g:1866:1: rule__DataStructure__Group_4_2_1__0 : rule__DataStructure__Group_4_2_1__0__Impl rule__DataStructure__Group_4_2_1__1 ;
    public final void rule__DataStructure__Group_4_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1870:1: ( rule__DataStructure__Group_4_2_1__0__Impl rule__DataStructure__Group_4_2_1__1 )
            // InternalDataDsl.g:1871:2: rule__DataStructure__Group_4_2_1__0__Impl rule__DataStructure__Group_4_2_1__1
            {
            pushFollow(FOLLOW_22);
            rule__DataStructure__Group_4_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2_1__1();

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
    // $ANTLR end "rule__DataStructure__Group_4_2_1__0"


    // $ANTLR start "rule__DataStructure__Group_4_2_1__0__Impl"
    // InternalDataDsl.g:1878:1: rule__DataStructure__Group_4_2_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1882:1: ( ( ',' ) )
            // InternalDataDsl.g:1883:1: ( ',' )
            {
            // InternalDataDsl.g:1883:1: ( ',' )
            // InternalDataDsl.g:1884:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_1_0()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2_1__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2_1__1"
    // InternalDataDsl.g:1893:1: rule__DataStructure__Group_4_2_1__1 : rule__DataStructure__Group_4_2_1__1__Impl ;
    public final void rule__DataStructure__Group_4_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1897:1: ( rule__DataStructure__Group_4_2_1__1__Impl )
            // InternalDataDsl.g:1898:2: rule__DataStructure__Group_4_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2_1__1__Impl();

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
    // $ANTLR end "rule__DataStructure__Group_4_2_1__1"


    // $ANTLR start "rule__DataStructure__Group_4_2_1__1__Impl"
    // InternalDataDsl.g:1904:1: rule__DataStructure__Group_4_2_1__1__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_2_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1908:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_2_1_1 ) ) )
            // InternalDataDsl.g:1909:1: ( ( rule__DataStructure__DataFieldsAssignment_4_2_1_1 ) )
            {
            // InternalDataDsl.g:1909:1: ( ( rule__DataStructure__DataFieldsAssignment_4_2_1_1 ) )
            // InternalDataDsl.g:1910:2: ( rule__DataStructure__DataFieldsAssignment_4_2_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_2_1_1()); 
            // InternalDataDsl.g:1911:2: ( rule__DataStructure__DataFieldsAssignment_4_2_1_1 )
            // InternalDataDsl.g:1911:3: rule__DataStructure__DataFieldsAssignment_4_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__DataFieldsAssignment_4_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_2_1_1()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2_1__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2_4__0"
    // InternalDataDsl.g:1920:1: rule__DataStructure__Group_4_2_4__0 : rule__DataStructure__Group_4_2_4__0__Impl rule__DataStructure__Group_4_2_4__1 ;
    public final void rule__DataStructure__Group_4_2_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1924:1: ( rule__DataStructure__Group_4_2_4__0__Impl rule__DataStructure__Group_4_2_4__1 )
            // InternalDataDsl.g:1925:2: rule__DataStructure__Group_4_2_4__0__Impl rule__DataStructure__Group_4_2_4__1
            {
            pushFollow(FOLLOW_23);
            rule__DataStructure__Group_4_2_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2_4__1();

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
    // $ANTLR end "rule__DataStructure__Group_4_2_4__0"


    // $ANTLR start "rule__DataStructure__Group_4_2_4__0__Impl"
    // InternalDataDsl.g:1932:1: rule__DataStructure__Group_4_2_4__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_2_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1936:1: ( ( ',' ) )
            // InternalDataDsl.g:1937:1: ( ',' )
            {
            // InternalDataDsl.g:1937:1: ( ',' )
            // InternalDataDsl.g:1938:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_4_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_4_2_4_0()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2_4__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_4_2_4__1"
    // InternalDataDsl.g:1947:1: rule__DataStructure__Group_4_2_4__1 : rule__DataStructure__Group_4_2_4__1__Impl ;
    public final void rule__DataStructure__Group_4_2_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1951:1: ( rule__DataStructure__Group_4_2_4__1__Impl )
            // InternalDataDsl.g:1952:2: rule__DataStructure__Group_4_2_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_4_2_4__1__Impl();

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
    // $ANTLR end "rule__DataStructure__Group_4_2_4__1"


    // $ANTLR start "rule__DataStructure__Group_4_2_4__1__Impl"
    // InternalDataDsl.g:1958:1: rule__DataStructure__Group_4_2_4__1__Impl : ( ( rule__DataStructure__OperationsAssignment_4_2_4_1 ) ) ;
    public final void rule__DataStructure__Group_4_2_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1962:1: ( ( ( rule__DataStructure__OperationsAssignment_4_2_4_1 ) ) )
            // InternalDataDsl.g:1963:1: ( ( rule__DataStructure__OperationsAssignment_4_2_4_1 ) )
            {
            // InternalDataDsl.g:1963:1: ( ( rule__DataStructure__OperationsAssignment_4_2_4_1 ) )
            // InternalDataDsl.g:1964:2: ( rule__DataStructure__OperationsAssignment_4_2_4_1 )
            {
             before(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_2_4_1()); 
            // InternalDataDsl.g:1965:2: ( rule__DataStructure__OperationsAssignment_4_2_4_1 )
            // InternalDataDsl.g:1965:3: rule__DataStructure__OperationsAssignment_4_2_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__OperationsAssignment_4_2_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getOperationsAssignment_4_2_4_1()); 

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
    // $ANTLR end "rule__DataStructure__Group_4_2_4__1__Impl"


    // $ANTLR start "rule__ListType__Group_0__0"
    // InternalDataDsl.g:1974:1: rule__ListType__Group_0__0 : rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 ;
    public final void rule__ListType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1978:1: ( rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 )
            // InternalDataDsl.g:1979:2: rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1
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
    // InternalDataDsl.g:1986:1: rule__ListType__Group_0__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1990:1: ( ( 'list' ) )
            // InternalDataDsl.g:1991:1: ( 'list' )
            {
            // InternalDataDsl.g:1991:1: ( 'list' )
            // InternalDataDsl.g:1992:2: 'list'
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
    // InternalDataDsl.g:2001:1: rule__ListType__Group_0__1 : rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 ;
    public final void rule__ListType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2005:1: ( rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 )
            // InternalDataDsl.g:2006:2: rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2
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
    // InternalDataDsl.g:2013:1: rule__ListType__Group_0__1__Impl : ( ( rule__ListType__NameAssignment_0_1 ) ) ;
    public final void rule__ListType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2017:1: ( ( ( rule__ListType__NameAssignment_0_1 ) ) )
            // InternalDataDsl.g:2018:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            {
            // InternalDataDsl.g:2018:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            // InternalDataDsl.g:2019:2: ( rule__ListType__NameAssignment_0_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 
            // InternalDataDsl.g:2020:2: ( rule__ListType__NameAssignment_0_1 )
            // InternalDataDsl.g:2020:3: rule__ListType__NameAssignment_0_1
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
    // InternalDataDsl.g:2028:1: rule__ListType__Group_0__2 : rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 ;
    public final void rule__ListType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2032:1: ( rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 )
            // InternalDataDsl.g:2033:2: rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3
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
    // InternalDataDsl.g:2040:1: rule__ListType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2044:1: ( ( '{' ) )
            // InternalDataDsl.g:2045:1: ( '{' )
            {
            // InternalDataDsl.g:2045:1: ( '{' )
            // InternalDataDsl.g:2046:2: '{'
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
    // InternalDataDsl.g:2055:1: rule__ListType__Group_0__3 : rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 ;
    public final void rule__ListType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2059:1: ( rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 )
            // InternalDataDsl.g:2060:2: rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2067:1: rule__ListType__Group_0__3__Impl : ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__ListType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2071:1: ( ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) )
            // InternalDataDsl.g:2072:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            {
            // InternalDataDsl.g:2072:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            // InternalDataDsl.g:2073:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalDataDsl.g:2074:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            // InternalDataDsl.g:2074:3: rule__ListType__DataFieldsAssignment_0_3
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
    // InternalDataDsl.g:2082:1: rule__ListType__Group_0__4 : rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 ;
    public final void rule__ListType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2086:1: ( rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 )
            // InternalDataDsl.g:2087:2: rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2094:1: rule__ListType__Group_0__4__Impl : ( ( rule__ListType__Group_0_4__0 )* ) ;
    public final void rule__ListType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2098:1: ( ( ( rule__ListType__Group_0_4__0 )* ) )
            // InternalDataDsl.g:2099:1: ( ( rule__ListType__Group_0_4__0 )* )
            {
            // InternalDataDsl.g:2099:1: ( ( rule__ListType__Group_0_4__0 )* )
            // InternalDataDsl.g:2100:2: ( rule__ListType__Group_0_4__0 )*
            {
             before(grammarAccess.getListTypeAccess().getGroup_0_4()); 
            // InternalDataDsl.g:2101:2: ( rule__ListType__Group_0_4__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==24) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDataDsl.g:2101:3: rule__ListType__Group_0_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__ListType__Group_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalDataDsl.g:2109:1: rule__ListType__Group_0__5 : rule__ListType__Group_0__5__Impl ;
    public final void rule__ListType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2113:1: ( rule__ListType__Group_0__5__Impl )
            // InternalDataDsl.g:2114:2: rule__ListType__Group_0__5__Impl
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
    // InternalDataDsl.g:2120:1: rule__ListType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__ListType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2124:1: ( ( '}' ) )
            // InternalDataDsl.g:2125:1: ( '}' )
            {
            // InternalDataDsl.g:2125:1: ( '}' )
            // InternalDataDsl.g:2126:2: '}'
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
    // InternalDataDsl.g:2136:1: rule__ListType__Group_0_4__0 : rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 ;
    public final void rule__ListType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2140:1: ( rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 )
            // InternalDataDsl.g:2141:2: rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1
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
    // InternalDataDsl.g:2148:1: rule__ListType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__ListType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2152:1: ( ( ',' ) )
            // InternalDataDsl.g:2153:1: ( ',' )
            {
            // InternalDataDsl.g:2153:1: ( ',' )
            // InternalDataDsl.g:2154:2: ','
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
    // InternalDataDsl.g:2163:1: rule__ListType__Group_0_4__1 : rule__ListType__Group_0_4__1__Impl ;
    public final void rule__ListType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2167:1: ( rule__ListType__Group_0_4__1__Impl )
            // InternalDataDsl.g:2168:2: rule__ListType__Group_0_4__1__Impl
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
    // InternalDataDsl.g:2174:1: rule__ListType__Group_0_4__1__Impl : ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__ListType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2178:1: ( ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalDataDsl.g:2179:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalDataDsl.g:2179:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            // InternalDataDsl.g:2180:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalDataDsl.g:2181:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            // InternalDataDsl.g:2181:3: rule__ListType__DataFieldsAssignment_0_4_1
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
    // InternalDataDsl.g:2190:1: rule__ListType__Group_1__0 : rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 ;
    public final void rule__ListType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2194:1: ( rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 )
            // InternalDataDsl.g:2195:2: rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1
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
    // InternalDataDsl.g:2202:1: rule__ListType__Group_1__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2206:1: ( ( 'list' ) )
            // InternalDataDsl.g:2207:1: ( 'list' )
            {
            // InternalDataDsl.g:2207:1: ( 'list' )
            // InternalDataDsl.g:2208:2: 'list'
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
    // InternalDataDsl.g:2217:1: rule__ListType__Group_1__1 : rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 ;
    public final void rule__ListType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2221:1: ( rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 )
            // InternalDataDsl.g:2222:2: rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2
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
    // InternalDataDsl.g:2229:1: rule__ListType__Group_1__1__Impl : ( ( rule__ListType__NameAssignment_1_1 ) ) ;
    public final void rule__ListType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2233:1: ( ( ( rule__ListType__NameAssignment_1_1 ) ) )
            // InternalDataDsl.g:2234:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            {
            // InternalDataDsl.g:2234:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            // InternalDataDsl.g:2235:2: ( rule__ListType__NameAssignment_1_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 
            // InternalDataDsl.g:2236:2: ( rule__ListType__NameAssignment_1_1 )
            // InternalDataDsl.g:2236:3: rule__ListType__NameAssignment_1_1
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
    // InternalDataDsl.g:2244:1: rule__ListType__Group_1__2 : rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 ;
    public final void rule__ListType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2248:1: ( rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 )
            // InternalDataDsl.g:2249:2: rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:2256:1: rule__ListType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2260:1: ( ( '{' ) )
            // InternalDataDsl.g:2261:1: ( '{' )
            {
            // InternalDataDsl.g:2261:1: ( '{' )
            // InternalDataDsl.g:2262:2: '{'
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
    // InternalDataDsl.g:2271:1: rule__ListType__Group_1__3 : rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 ;
    public final void rule__ListType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2275:1: ( rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 )
            // InternalDataDsl.g:2276:2: rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4
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
    // InternalDataDsl.g:2283:1: rule__ListType__Group_1__3__Impl : ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__ListType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2287:1: ( ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalDataDsl.g:2288:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalDataDsl.g:2288:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            // InternalDataDsl.g:2289:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalDataDsl.g:2290:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            // InternalDataDsl.g:2290:3: rule__ListType__PrimitiveTypeAssignment_1_3
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
    // InternalDataDsl.g:2298:1: rule__ListType__Group_1__4 : rule__ListType__Group_1__4__Impl ;
    public final void rule__ListType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2302:1: ( rule__ListType__Group_1__4__Impl )
            // InternalDataDsl.g:2303:2: rule__ListType__Group_1__4__Impl
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
    // InternalDataDsl.g:2309:1: rule__ListType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__ListType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2313:1: ( ( '}' ) )
            // InternalDataDsl.g:2314:1: ( '}' )
            {
            // InternalDataDsl.g:2314:1: ( '}' )
            // InternalDataDsl.g:2315:2: '}'
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
    // InternalDataDsl.g:2325:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2329:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalDataDsl.g:2330:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
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
    // InternalDataDsl.g:2337:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2341:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:2342:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:2342:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalDataDsl.g:2343:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:2344:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDataDsl.g:2344:3: rule__DataField__HiddenAssignment_0
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
    // InternalDataDsl.g:2352:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2356:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalDataDsl.g:2357:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
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
    // InternalDataDsl.g:2364:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__Alternatives_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2368:1: ( ( ( rule__DataField__Alternatives_1 )? ) )
            // InternalDataDsl.g:2369:1: ( ( rule__DataField__Alternatives_1 )? )
            {
            // InternalDataDsl.g:2369:1: ( ( rule__DataField__Alternatives_1 )? )
            // InternalDataDsl.g:2370:2: ( rule__DataField__Alternatives_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_1()); 
            // InternalDataDsl.g:2371:2: ( rule__DataField__Alternatives_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=33 && LA28_0<=42)) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID) ) {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==RULE_ID||LA28_2==32||LA28_2==43) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // InternalDataDsl.g:2371:3: rule__DataField__Alternatives_1
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
    // InternalDataDsl.g:2379:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl rule__DataField__Group__3 ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2383:1: ( rule__DataField__Group__2__Impl rule__DataField__Group__3 )
            // InternalDataDsl.g:2384:2: rule__DataField__Group__2__Impl rule__DataField__Group__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalDataDsl.g:2391:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__NameAssignment_2 ) ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2395:1: ( ( ( rule__DataField__NameAssignment_2 ) ) )
            // InternalDataDsl.g:2396:1: ( ( rule__DataField__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:2396:1: ( ( rule__DataField__NameAssignment_2 ) )
            // InternalDataDsl.g:2397:2: ( rule__DataField__NameAssignment_2 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:2398:2: ( rule__DataField__NameAssignment_2 )
            // InternalDataDsl.g:2398:3: rule__DataField__NameAssignment_2
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
    // InternalDataDsl.g:2406:1: rule__DataField__Group__3 : rule__DataField__Group__3__Impl ;
    public final void rule__DataField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2410:1: ( rule__DataField__Group__3__Impl )
            // InternalDataDsl.g:2411:2: rule__DataField__Group__3__Impl
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
    // InternalDataDsl.g:2417:1: rule__DataField__Group__3__Impl : ( ( rule__DataField__Group_3__0 )? ) ;
    public final void rule__DataField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2421:1: ( ( ( rule__DataField__Group_3__0 )? ) )
            // InternalDataDsl.g:2422:1: ( ( rule__DataField__Group_3__0 )? )
            {
            // InternalDataDsl.g:2422:1: ( ( rule__DataField__Group_3__0 )? )
            // InternalDataDsl.g:2423:2: ( rule__DataField__Group_3__0 )?
            {
             before(grammarAccess.getDataFieldAccess().getGroup_3()); 
            // InternalDataDsl.g:2424:2: ( rule__DataField__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==26) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDataDsl.g:2424:3: rule__DataField__Group_3__0
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
    // InternalDataDsl.g:2433:1: rule__DataField__Group_3__0 : rule__DataField__Group_3__0__Impl rule__DataField__Group_3__1 ;
    public final void rule__DataField__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2437:1: ( rule__DataField__Group_3__0__Impl rule__DataField__Group_3__1 )
            // InternalDataDsl.g:2438:2: rule__DataField__Group_3__0__Impl rule__DataField__Group_3__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalDataDsl.g:2445:1: rule__DataField__Group_3__0__Impl : ( '<' ) ;
    public final void rule__DataField__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2449:1: ( ( '<' ) )
            // InternalDataDsl.g:2450:1: ( '<' )
            {
            // InternalDataDsl.g:2450:1: ( '<' )
            // InternalDataDsl.g:2451:2: '<'
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
    // InternalDataDsl.g:2460:1: rule__DataField__Group_3__1 : rule__DataField__Group_3__1__Impl rule__DataField__Group_3__2 ;
    public final void rule__DataField__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2464:1: ( rule__DataField__Group_3__1__Impl rule__DataField__Group_3__2 )
            // InternalDataDsl.g:2465:2: rule__DataField__Group_3__1__Impl rule__DataField__Group_3__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDsl.g:2472:1: rule__DataField__Group_3__1__Impl : ( ( rule__DataField__FeaturesAssignment_3_1 ) ) ;
    public final void rule__DataField__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2476:1: ( ( ( rule__DataField__FeaturesAssignment_3_1 ) ) )
            // InternalDataDsl.g:2477:1: ( ( rule__DataField__FeaturesAssignment_3_1 ) )
            {
            // InternalDataDsl.g:2477:1: ( ( rule__DataField__FeaturesAssignment_3_1 ) )
            // InternalDataDsl.g:2478:2: ( rule__DataField__FeaturesAssignment_3_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_3_1()); 
            // InternalDataDsl.g:2479:2: ( rule__DataField__FeaturesAssignment_3_1 )
            // InternalDataDsl.g:2479:3: rule__DataField__FeaturesAssignment_3_1
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
    // InternalDataDsl.g:2487:1: rule__DataField__Group_3__2 : rule__DataField__Group_3__2__Impl rule__DataField__Group_3__3 ;
    public final void rule__DataField__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2491:1: ( rule__DataField__Group_3__2__Impl rule__DataField__Group_3__3 )
            // InternalDataDsl.g:2492:2: rule__DataField__Group_3__2__Impl rule__DataField__Group_3__3
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDsl.g:2499:1: rule__DataField__Group_3__2__Impl : ( ( rule__DataField__Group_3_2__0 )* ) ;
    public final void rule__DataField__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2503:1: ( ( ( rule__DataField__Group_3_2__0 )* ) )
            // InternalDataDsl.g:2504:1: ( ( rule__DataField__Group_3_2__0 )* )
            {
            // InternalDataDsl.g:2504:1: ( ( rule__DataField__Group_3_2__0 )* )
            // InternalDataDsl.g:2505:2: ( rule__DataField__Group_3_2__0 )*
            {
             before(grammarAccess.getDataFieldAccess().getGroup_3_2()); 
            // InternalDataDsl.g:2506:2: ( rule__DataField__Group_3_2__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==24) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDataDsl.g:2506:3: rule__DataField__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataField__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalDataDsl.g:2514:1: rule__DataField__Group_3__3 : rule__DataField__Group_3__3__Impl ;
    public final void rule__DataField__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2518:1: ( rule__DataField__Group_3__3__Impl )
            // InternalDataDsl.g:2519:2: rule__DataField__Group_3__3__Impl
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
    // InternalDataDsl.g:2525:1: rule__DataField__Group_3__3__Impl : ( '>' ) ;
    public final void rule__DataField__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2529:1: ( ( '>' ) )
            // InternalDataDsl.g:2530:1: ( '>' )
            {
            // InternalDataDsl.g:2530:1: ( '>' )
            // InternalDataDsl.g:2531:2: '>'
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
    // InternalDataDsl.g:2541:1: rule__DataField__Group_3_2__0 : rule__DataField__Group_3_2__0__Impl rule__DataField__Group_3_2__1 ;
    public final void rule__DataField__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2545:1: ( rule__DataField__Group_3_2__0__Impl rule__DataField__Group_3_2__1 )
            // InternalDataDsl.g:2546:2: rule__DataField__Group_3_2__0__Impl rule__DataField__Group_3_2__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalDataDsl.g:2553:1: rule__DataField__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__DataField__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2557:1: ( ( ',' ) )
            // InternalDataDsl.g:2558:1: ( ',' )
            {
            // InternalDataDsl.g:2558:1: ( ',' )
            // InternalDataDsl.g:2559:2: ','
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
    // InternalDataDsl.g:2568:1: rule__DataField__Group_3_2__1 : rule__DataField__Group_3_2__1__Impl ;
    public final void rule__DataField__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2572:1: ( rule__DataField__Group_3_2__1__Impl )
            // InternalDataDsl.g:2573:2: rule__DataField__Group_3_2__1__Impl
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
    // InternalDataDsl.g:2579:1: rule__DataField__Group_3_2__1__Impl : ( ( rule__DataField__FeaturesAssignment_3_2_1 ) ) ;
    public final void rule__DataField__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2583:1: ( ( ( rule__DataField__FeaturesAssignment_3_2_1 ) ) )
            // InternalDataDsl.g:2584:1: ( ( rule__DataField__FeaturesAssignment_3_2_1 ) )
            {
            // InternalDataDsl.g:2584:1: ( ( rule__DataField__FeaturesAssignment_3_2_1 ) )
            // InternalDataDsl.g:2585:2: ( rule__DataField__FeaturesAssignment_3_2_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_3_2_1()); 
            // InternalDataDsl.g:2586:2: ( rule__DataField__FeaturesAssignment_3_2_1 )
            // InternalDataDsl.g:2586:3: rule__DataField__FeaturesAssignment_3_2_1
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
    // InternalDataDsl.g:2595:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2599:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalDataDsl.g:2600:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
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
    // InternalDataDsl.g:2607:1: rule__Enumeration__Group__0__Impl : ( 'enum' ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2611:1: ( ( 'enum' ) )
            // InternalDataDsl.g:2612:1: ( 'enum' )
            {
            // InternalDataDsl.g:2612:1: ( 'enum' )
            // InternalDataDsl.g:2613:2: 'enum'
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
    // InternalDataDsl.g:2622:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2626:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalDataDsl.g:2627:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
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
    // InternalDataDsl.g:2634:1: rule__Enumeration__Group__1__Impl : ( ( rule__Enumeration__NameAssignment_1 ) ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2638:1: ( ( ( rule__Enumeration__NameAssignment_1 ) ) )
            // InternalDataDsl.g:2639:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:2639:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            // InternalDataDsl.g:2640:2: ( rule__Enumeration__NameAssignment_1 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:2641:2: ( rule__Enumeration__NameAssignment_1 )
            // InternalDataDsl.g:2641:3: rule__Enumeration__NameAssignment_1
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
    // InternalDataDsl.g:2649:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2653:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalDataDsl.g:2654:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
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
    // InternalDataDsl.g:2661:1: rule__Enumeration__Group__2__Impl : ( '{' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2665:1: ( ( '{' ) )
            // InternalDataDsl.g:2666:1: ( '{' )
            {
            // InternalDataDsl.g:2666:1: ( '{' )
            // InternalDataDsl.g:2667:2: '{'
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
    // InternalDataDsl.g:2676:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2680:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalDataDsl.g:2681:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2688:1: rule__Enumeration__Group__3__Impl : ( ( rule__Enumeration__FieldsAssignment_3 ) ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2692:1: ( ( ( rule__Enumeration__FieldsAssignment_3 ) ) )
            // InternalDataDsl.g:2693:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            {
            // InternalDataDsl.g:2693:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            // InternalDataDsl.g:2694:2: ( rule__Enumeration__FieldsAssignment_3 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_3()); 
            // InternalDataDsl.g:2695:2: ( rule__Enumeration__FieldsAssignment_3 )
            // InternalDataDsl.g:2695:3: rule__Enumeration__FieldsAssignment_3
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
    // InternalDataDsl.g:2703:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2707:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalDataDsl.g:2708:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2715:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2719:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalDataDsl.g:2720:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalDataDsl.g:2720:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalDataDsl.g:2721:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalDataDsl.g:2722:2: ( rule__Enumeration__Group_4__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==24) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDataDsl.g:2722:3: rule__Enumeration__Group_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Enumeration__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalDataDsl.g:2730:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2734:1: ( rule__Enumeration__Group__5__Impl )
            // InternalDataDsl.g:2735:2: rule__Enumeration__Group__5__Impl
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
    // InternalDataDsl.g:2741:1: rule__Enumeration__Group__5__Impl : ( '}' ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2745:1: ( ( '}' ) )
            // InternalDataDsl.g:2746:1: ( '}' )
            {
            // InternalDataDsl.g:2746:1: ( '}' )
            // InternalDataDsl.g:2747:2: '}'
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
    // InternalDataDsl.g:2757:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2761:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalDataDsl.g:2762:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
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
    // InternalDataDsl.g:2769:1: rule__Enumeration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2773:1: ( ( ',' ) )
            // InternalDataDsl.g:2774:1: ( ',' )
            {
            // InternalDataDsl.g:2774:1: ( ',' )
            // InternalDataDsl.g:2775:2: ','
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
    // InternalDataDsl.g:2784:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2788:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalDataDsl.g:2789:2: rule__Enumeration__Group_4__1__Impl
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
    // InternalDataDsl.g:2795:1: rule__Enumeration__Group_4__1__Impl : ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2799:1: ( ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) )
            // InternalDataDsl.g:2800:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            {
            // InternalDataDsl.g:2800:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            // InternalDataDsl.g:2801:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_4_1()); 
            // InternalDataDsl.g:2802:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            // InternalDataDsl.g:2802:3: rule__Enumeration__FieldsAssignment_4_1
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
    // InternalDataDsl.g:2811:1: rule__EnumerationField__Group__0 : rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 ;
    public final void rule__EnumerationField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2815:1: ( rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 )
            // InternalDataDsl.g:2816:2: rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalDataDsl.g:2823:1: rule__EnumerationField__Group__0__Impl : ( ( rule__EnumerationField__NameAssignment_0 ) ) ;
    public final void rule__EnumerationField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2827:1: ( ( ( rule__EnumerationField__NameAssignment_0 ) ) )
            // InternalDataDsl.g:2828:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            {
            // InternalDataDsl.g:2828:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            // InternalDataDsl.g:2829:2: ( rule__EnumerationField__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0()); 
            // InternalDataDsl.g:2830:2: ( rule__EnumerationField__NameAssignment_0 )
            // InternalDataDsl.g:2830:3: rule__EnumerationField__NameAssignment_0
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
    // InternalDataDsl.g:2838:1: rule__EnumerationField__Group__1 : rule__EnumerationField__Group__1__Impl ;
    public final void rule__EnumerationField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2842:1: ( rule__EnumerationField__Group__1__Impl )
            // InternalDataDsl.g:2843:2: rule__EnumerationField__Group__1__Impl
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
    // InternalDataDsl.g:2849:1: rule__EnumerationField__Group__1__Impl : ( ( rule__EnumerationField__Group_1__0 )? ) ;
    public final void rule__EnumerationField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2853:1: ( ( ( rule__EnumerationField__Group_1__0 )? ) )
            // InternalDataDsl.g:2854:1: ( ( rule__EnumerationField__Group_1__0 )? )
            {
            // InternalDataDsl.g:2854:1: ( ( rule__EnumerationField__Group_1__0 )? )
            // InternalDataDsl.g:2855:2: ( rule__EnumerationField__Group_1__0 )?
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup_1()); 
            // InternalDataDsl.g:2856:2: ( rule__EnumerationField__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDsl.g:2856:3: rule__EnumerationField__Group_1__0
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
    // InternalDataDsl.g:2865:1: rule__EnumerationField__Group_1__0 : rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 ;
    public final void rule__EnumerationField__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2869:1: ( rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 )
            // InternalDataDsl.g:2870:2: rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalDataDsl.g:2877:1: rule__EnumerationField__Group_1__0__Impl : ( '(' ) ;
    public final void rule__EnumerationField__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2881:1: ( ( '(' ) )
            // InternalDataDsl.g:2882:1: ( '(' )
            {
            // InternalDataDsl.g:2882:1: ( '(' )
            // InternalDataDsl.g:2883:2: '('
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
    // InternalDataDsl.g:2892:1: rule__EnumerationField__Group_1__1 : rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 ;
    public final void rule__EnumerationField__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2896:1: ( rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 )
            // InternalDataDsl.g:2897:2: rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalDataDsl.g:2904:1: rule__EnumerationField__Group_1__1__Impl : ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) ;
    public final void rule__EnumerationField__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2908:1: ( ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) )
            // InternalDataDsl.g:2909:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            {
            // InternalDataDsl.g:2909:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            // InternalDataDsl.g:2910:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1()); 
            // InternalDataDsl.g:2911:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            // InternalDataDsl.g:2911:3: rule__EnumerationField__InitializationValueAssignment_1_1
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
    // InternalDataDsl.g:2919:1: rule__EnumerationField__Group_1__2 : rule__EnumerationField__Group_1__2__Impl ;
    public final void rule__EnumerationField__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2923:1: ( rule__EnumerationField__Group_1__2__Impl )
            // InternalDataDsl.g:2924:2: rule__EnumerationField__Group_1__2__Impl
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
    // InternalDataDsl.g:2930:1: rule__EnumerationField__Group_1__2__Impl : ( ')' ) ;
    public final void rule__EnumerationField__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2934:1: ( ( ')' ) )
            // InternalDataDsl.g:2935:1: ( ')' )
            {
            // InternalDataDsl.g:2935:1: ( ')' )
            // InternalDataDsl.g:2936:2: ')'
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
    // InternalDataDsl.g:2946:1: rule__DataOperation__Group__0 : rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 ;
    public final void rule__DataOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2950:1: ( rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 )
            // InternalDataDsl.g:2951:2: rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalDataDsl.g:2958:1: rule__DataOperation__Group__0__Impl : ( ( rule__DataOperation__HiddenAssignment_0 )? ) ;
    public final void rule__DataOperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2962:1: ( ( ( rule__DataOperation__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:2963:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:2963:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            // InternalDataDsl.g:2964:2: ( rule__DataOperation__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataOperationAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:2965:2: ( rule__DataOperation__HiddenAssignment_0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDsl.g:2965:3: rule__DataOperation__HiddenAssignment_0
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
    // InternalDataDsl.g:2973:1: rule__DataOperation__Group__1 : rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 ;
    public final void rule__DataOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2977:1: ( rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 )
            // InternalDataDsl.g:2978:2: rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2
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
    // InternalDataDsl.g:2985:1: rule__DataOperation__Group__1__Impl : ( ( rule__DataOperation__Alternatives_1 ) ) ;
    public final void rule__DataOperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2989:1: ( ( ( rule__DataOperation__Alternatives_1 ) ) )
            // InternalDataDsl.g:2990:1: ( ( rule__DataOperation__Alternatives_1 ) )
            {
            // InternalDataDsl.g:2990:1: ( ( rule__DataOperation__Alternatives_1 ) )
            // InternalDataDsl.g:2991:2: ( rule__DataOperation__Alternatives_1 )
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1()); 
            // InternalDataDsl.g:2992:2: ( rule__DataOperation__Alternatives_1 )
            // InternalDataDsl.g:2992:3: rule__DataOperation__Alternatives_1
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
    // InternalDataDsl.g:3000:1: rule__DataOperation__Group__2 : rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 ;
    public final void rule__DataOperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3004:1: ( rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 )
            // InternalDataDsl.g:3005:2: rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3
            {
            pushFollow(FOLLOW_29);
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
    // InternalDataDsl.g:3012:1: rule__DataOperation__Group__2__Impl : ( ( rule__DataOperation__NameAssignment_2 ) ) ;
    public final void rule__DataOperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3016:1: ( ( ( rule__DataOperation__NameAssignment_2 ) ) )
            // InternalDataDsl.g:3017:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:3017:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            // InternalDataDsl.g:3018:2: ( rule__DataOperation__NameAssignment_2 )
            {
             before(grammarAccess.getDataOperationAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:3019:2: ( rule__DataOperation__NameAssignment_2 )
            // InternalDataDsl.g:3019:3: rule__DataOperation__NameAssignment_2
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
    // InternalDataDsl.g:3027:1: rule__DataOperation__Group__3 : rule__DataOperation__Group__3__Impl ;
    public final void rule__DataOperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3031:1: ( rule__DataOperation__Group__3__Impl )
            // InternalDataDsl.g:3032:2: rule__DataOperation__Group__3__Impl
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
    // InternalDataDsl.g:3038:1: rule__DataOperation__Group__3__Impl : ( ( rule__DataOperation__Group_3__0 )? ) ;
    public final void rule__DataOperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3042:1: ( ( ( rule__DataOperation__Group_3__0 )? ) )
            // InternalDataDsl.g:3043:1: ( ( rule__DataOperation__Group_3__0 )? )
            {
            // InternalDataDsl.g:3043:1: ( ( rule__DataOperation__Group_3__0 )? )
            // InternalDataDsl.g:3044:2: ( rule__DataOperation__Group_3__0 )?
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3()); 
            // InternalDataDsl.g:3045:2: ( rule__DataOperation__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDataDsl.g:3045:3: rule__DataOperation__Group_3__0
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
    // InternalDataDsl.g:3054:1: rule__DataOperation__Group_1_1__0 : rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 ;
    public final void rule__DataOperation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3058:1: ( rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 )
            // InternalDataDsl.g:3059:2: rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalDataDsl.g:3066:1: rule__DataOperation__Group_1_1__0__Impl : ( 'function' ) ;
    public final void rule__DataOperation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3070:1: ( ( 'function' ) )
            // InternalDataDsl.g:3071:1: ( 'function' )
            {
            // InternalDataDsl.g:3071:1: ( 'function' )
            // InternalDataDsl.g:3072:2: 'function'
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
    // InternalDataDsl.g:3081:1: rule__DataOperation__Group_1_1__1 : rule__DataOperation__Group_1_1__1__Impl ;
    public final void rule__DataOperation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3085:1: ( rule__DataOperation__Group_1_1__1__Impl )
            // InternalDataDsl.g:3086:2: rule__DataOperation__Group_1_1__1__Impl
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
    // InternalDataDsl.g:3092:1: rule__DataOperation__Group_1_1__1__Impl : ( ( rule__DataOperation__Alternatives_1_1_1 )? ) ;
    public final void rule__DataOperation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3096:1: ( ( ( rule__DataOperation__Alternatives_1_1_1 )? ) )
            // InternalDataDsl.g:3097:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            {
            // InternalDataDsl.g:3097:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            // InternalDataDsl.g:3098:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1_1_1()); 
            // InternalDataDsl.g:3099:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=33 && LA35_0<=42)) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID) ) {
                int LA35_2 = input.LA(2);

                if ( (LA35_2==RULE_ID||LA35_2==32||LA35_2==43) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // InternalDataDsl.g:3099:3: rule__DataOperation__Alternatives_1_1_1
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
    // InternalDataDsl.g:3108:1: rule__DataOperation__Group_3__0 : rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 ;
    public final void rule__DataOperation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3112:1: ( rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 )
            // InternalDataDsl.g:3113:2: rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1
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
    // InternalDataDsl.g:3120:1: rule__DataOperation__Group_3__0__Impl : ( '(' ) ;
    public final void rule__DataOperation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3124:1: ( ( '(' ) )
            // InternalDataDsl.g:3125:1: ( '(' )
            {
            // InternalDataDsl.g:3125:1: ( '(' )
            // InternalDataDsl.g:3126:2: '('
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
    // InternalDataDsl.g:3135:1: rule__DataOperation__Group_3__1 : rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 ;
    public final void rule__DataOperation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3139:1: ( rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 )
            // InternalDataDsl.g:3140:2: rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2
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
    // InternalDataDsl.g:3147:1: rule__DataOperation__Group_3__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) ;
    public final void rule__DataOperation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3151:1: ( ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) )
            // InternalDataDsl.g:3152:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            {
            // InternalDataDsl.g:3152:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            // InternalDataDsl.g:3153:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_1()); 
            // InternalDataDsl.g:3154:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||(LA36_0>=33 && LA36_0<=42)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDsl.g:3154:3: rule__DataOperation__ParametersAssignment_3_1
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
    // InternalDataDsl.g:3162:1: rule__DataOperation__Group_3__2 : rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 ;
    public final void rule__DataOperation__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3166:1: ( rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 )
            // InternalDataDsl.g:3167:2: rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3
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
    // InternalDataDsl.g:3174:1: rule__DataOperation__Group_3__2__Impl : ( ( rule__DataOperation__Group_3_2__0 )* ) ;
    public final void rule__DataOperation__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3178:1: ( ( ( rule__DataOperation__Group_3_2__0 )* ) )
            // InternalDataDsl.g:3179:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            {
            // InternalDataDsl.g:3179:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            // InternalDataDsl.g:3180:2: ( rule__DataOperation__Group_3_2__0 )*
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3_2()); 
            // InternalDataDsl.g:3181:2: ( rule__DataOperation__Group_3_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==24) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDataDsl.g:3181:3: rule__DataOperation__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataOperation__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalDataDsl.g:3189:1: rule__DataOperation__Group_3__3 : rule__DataOperation__Group_3__3__Impl ;
    public final void rule__DataOperation__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3193:1: ( rule__DataOperation__Group_3__3__Impl )
            // InternalDataDsl.g:3194:2: rule__DataOperation__Group_3__3__Impl
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
    // InternalDataDsl.g:3200:1: rule__DataOperation__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DataOperation__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3204:1: ( ( ')' ) )
            // InternalDataDsl.g:3205:1: ( ')' )
            {
            // InternalDataDsl.g:3205:1: ( ')' )
            // InternalDataDsl.g:3206:2: ')'
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
    // InternalDataDsl.g:3216:1: rule__DataOperation__Group_3_2__0 : rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 ;
    public final void rule__DataOperation__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3220:1: ( rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 )
            // InternalDataDsl.g:3221:2: rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalDataDsl.g:3228:1: rule__DataOperation__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__DataOperation__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3232:1: ( ( ',' ) )
            // InternalDataDsl.g:3233:1: ( ',' )
            {
            // InternalDataDsl.g:3233:1: ( ',' )
            // InternalDataDsl.g:3234:2: ','
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
    // InternalDataDsl.g:3243:1: rule__DataOperation__Group_3_2__1 : rule__DataOperation__Group_3_2__1__Impl ;
    public final void rule__DataOperation__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3247:1: ( rule__DataOperation__Group_3_2__1__Impl )
            // InternalDataDsl.g:3248:2: rule__DataOperation__Group_3_2__1__Impl
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
    // InternalDataDsl.g:3254:1: rule__DataOperation__Group_3_2__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) ;
    public final void rule__DataOperation__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3258:1: ( ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) )
            // InternalDataDsl.g:3259:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            {
            // InternalDataDsl.g:3259:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            // InternalDataDsl.g:3260:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_2_1()); 
            // InternalDataDsl.g:3261:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            // InternalDataDsl.g:3261:3: rule__DataOperation__ParametersAssignment_3_2_1
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
    // InternalDataDsl.g:3270:1: rule__DataOperationParameter__Group__0 : rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 ;
    public final void rule__DataOperationParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3274:1: ( rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 )
            // InternalDataDsl.g:3275:2: rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1
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
    // InternalDataDsl.g:3282:1: rule__DataOperationParameter__Group__0__Impl : ( ( rule__DataOperationParameter__Alternatives_0 ) ) ;
    public final void rule__DataOperationParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3286:1: ( ( ( rule__DataOperationParameter__Alternatives_0 ) ) )
            // InternalDataDsl.g:3287:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            {
            // InternalDataDsl.g:3287:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            // InternalDataDsl.g:3288:2: ( rule__DataOperationParameter__Alternatives_0 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getAlternatives_0()); 
            // InternalDataDsl.g:3289:2: ( rule__DataOperationParameter__Alternatives_0 )
            // InternalDataDsl.g:3289:3: rule__DataOperationParameter__Alternatives_0
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
    // InternalDataDsl.g:3297:1: rule__DataOperationParameter__Group__1 : rule__DataOperationParameter__Group__1__Impl ;
    public final void rule__DataOperationParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3301:1: ( rule__DataOperationParameter__Group__1__Impl )
            // InternalDataDsl.g:3302:2: rule__DataOperationParameter__Group__1__Impl
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
    // InternalDataDsl.g:3308:1: rule__DataOperationParameter__Group__1__Impl : ( ( rule__DataOperationParameter__NameAssignment_1 ) ) ;
    public final void rule__DataOperationParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3312:1: ( ( ( rule__DataOperationParameter__NameAssignment_1 ) ) )
            // InternalDataDsl.g:3313:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:3313:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            // InternalDataDsl.g:3314:2: ( rule__DataOperationParameter__NameAssignment_1 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:3315:2: ( rule__DataOperationParameter__NameAssignment_1 )
            // InternalDataDsl.g:3315:3: rule__DataOperationParameter__NameAssignment_1
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


    // $ANTLR start "rule__PossiblyImportedComplexType__Group__0"
    // InternalDataDsl.g:3324:1: rule__PossiblyImportedComplexType__Group__0 : rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 ;
    public final void rule__PossiblyImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3328:1: ( rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 )
            // InternalDataDsl.g:3329:2: rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__PossiblyImportedComplexType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__Group__1();

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group__0"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group__0__Impl"
    // InternalDataDsl.g:3336:1: rule__PossiblyImportedComplexType__Group__0__Impl : ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) ;
    public final void rule__PossiblyImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3340:1: ( ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) )
            // InternalDataDsl.g:3341:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            {
            // InternalDataDsl.g:3341:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            // InternalDataDsl.g:3342:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup_0()); 
            // InternalDataDsl.g:3343:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==32) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalDataDsl.g:3343:3: rule__PossiblyImportedComplexType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PossiblyImportedComplexType__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup_0()); 

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group__0__Impl"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group__1"
    // InternalDataDsl.g:3351:1: rule__PossiblyImportedComplexType__Group__1 : rule__PossiblyImportedComplexType__Group__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3355:1: ( rule__PossiblyImportedComplexType__Group__1__Impl )
            // InternalDataDsl.g:3356:2: rule__PossiblyImportedComplexType__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__Group__1__Impl();

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group__1"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group__1__Impl"
    // InternalDataDsl.g:3362:1: rule__PossiblyImportedComplexType__Group__1__Impl : ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3366:1: ( ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) )
            // InternalDataDsl.g:3367:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            {
            // InternalDataDsl.g:3367:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            // InternalDataDsl.g:3368:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeAssignment_1()); 
            // InternalDataDsl.g:3369:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            // InternalDataDsl.g:3369:3: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__ComplexTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeAssignment_1()); 

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group__1__Impl"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group_0__0"
    // InternalDataDsl.g:3378:1: rule__PossiblyImportedComplexType__Group_0__0 : rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 ;
    public final void rule__PossiblyImportedComplexType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3382:1: ( rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 )
            // InternalDataDsl.g:3383:2: rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1
            {
            pushFollow(FOLLOW_33);
            rule__PossiblyImportedComplexType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__Group_0__1();

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group_0__0"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group_0__0__Impl"
    // InternalDataDsl.g:3390:1: rule__PossiblyImportedComplexType__Group_0__0__Impl : ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3394:1: ( ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) )
            // InternalDataDsl.g:3395:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            {
            // InternalDataDsl.g:3395:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            // InternalDataDsl.g:3396:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportAssignment_0_0()); 
            // InternalDataDsl.g:3397:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            // InternalDataDsl.g:3397:3: rule__PossiblyImportedComplexType__ImportAssignment_0_0
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__ImportAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportAssignment_0_0()); 

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group_0__0__Impl"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group_0__1"
    // InternalDataDsl.g:3405:1: rule__PossiblyImportedComplexType__Group_0__1 : rule__PossiblyImportedComplexType__Group_0__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3409:1: ( rule__PossiblyImportedComplexType__Group_0__1__Impl )
            // InternalDataDsl.g:3410:2: rule__PossiblyImportedComplexType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedComplexType__Group_0__1__Impl();

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group_0__1"


    // $ANTLR start "rule__PossiblyImportedComplexType__Group_0__1__Impl"
    // InternalDataDsl.g:3416:1: rule__PossiblyImportedComplexType__Group_0__1__Impl : ( '::' ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3420:1: ( ( '::' ) )
            // InternalDataDsl.g:3421:1: ( '::' )
            {
            // InternalDataDsl.g:3421:1: ( '::' )
            // InternalDataDsl.g:3422:2: '::'
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1()); 

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
    // $ANTLR end "rule__PossiblyImportedComplexType__Group_0__1__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_0__0"
    // InternalDataDsl.g:3432:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3436:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalDataDsl.g:3437:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
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
    // InternalDataDsl.g:3444:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3448:1: ( ( () ) )
            // InternalDataDsl.g:3449:1: ( () )
            {
            // InternalDataDsl.g:3449:1: ( () )
            // InternalDataDsl.g:3450:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalDataDsl.g:3451:2: ()
            // InternalDataDsl.g:3451:3: 
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
    // InternalDataDsl.g:3459:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3463:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalDataDsl.g:3464:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalDataDsl.g:3470:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3474:1: ( ( 'boolean' ) )
            // InternalDataDsl.g:3475:1: ( 'boolean' )
            {
            // InternalDataDsl.g:3475:1: ( 'boolean' )
            // InternalDataDsl.g:3476:2: 'boolean'
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
    // InternalDataDsl.g:3486:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3490:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalDataDsl.g:3491:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
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
    // InternalDataDsl.g:3498:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3502:1: ( ( () ) )
            // InternalDataDsl.g:3503:1: ( () )
            {
            // InternalDataDsl.g:3503:1: ( () )
            // InternalDataDsl.g:3504:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalDataDsl.g:3505:2: ()
            // InternalDataDsl.g:3505:3: 
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
    // InternalDataDsl.g:3513:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3517:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalDataDsl.g:3518:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalDataDsl.g:3524:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3528:1: ( ( 'byte' ) )
            // InternalDataDsl.g:3529:1: ( 'byte' )
            {
            // InternalDataDsl.g:3529:1: ( 'byte' )
            // InternalDataDsl.g:3530:2: 'byte'
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
    // InternalDataDsl.g:3540:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3544:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalDataDsl.g:3545:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
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
    // InternalDataDsl.g:3552:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3556:1: ( ( () ) )
            // InternalDataDsl.g:3557:1: ( () )
            {
            // InternalDataDsl.g:3557:1: ( () )
            // InternalDataDsl.g:3558:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalDataDsl.g:3559:2: ()
            // InternalDataDsl.g:3559:3: 
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
    // InternalDataDsl.g:3567:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3571:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalDataDsl.g:3572:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalDataDsl.g:3578:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3582:1: ( ( 'char' ) )
            // InternalDataDsl.g:3583:1: ( 'char' )
            {
            // InternalDataDsl.g:3583:1: ( 'char' )
            // InternalDataDsl.g:3584:2: 'char'
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
    // InternalDataDsl.g:3594:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3598:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalDataDsl.g:3599:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
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
    // InternalDataDsl.g:3606:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3610:1: ( ( () ) )
            // InternalDataDsl.g:3611:1: ( () )
            {
            // InternalDataDsl.g:3611:1: ( () )
            // InternalDataDsl.g:3612:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalDataDsl.g:3613:2: ()
            // InternalDataDsl.g:3613:3: 
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
    // InternalDataDsl.g:3621:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3625:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalDataDsl.g:3626:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalDataDsl.g:3632:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3636:1: ( ( 'date' ) )
            // InternalDataDsl.g:3637:1: ( 'date' )
            {
            // InternalDataDsl.g:3637:1: ( 'date' )
            // InternalDataDsl.g:3638:2: 'date'
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
    // InternalDataDsl.g:3648:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3652:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalDataDsl.g:3653:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
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
    // InternalDataDsl.g:3660:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3664:1: ( ( () ) )
            // InternalDataDsl.g:3665:1: ( () )
            {
            // InternalDataDsl.g:3665:1: ( () )
            // InternalDataDsl.g:3666:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalDataDsl.g:3667:2: ()
            // InternalDataDsl.g:3667:3: 
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
    // InternalDataDsl.g:3675:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3679:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalDataDsl.g:3680:2: rule__PrimitiveType__Group_4__1__Impl
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
    // InternalDataDsl.g:3686:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3690:1: ( ( 'double' ) )
            // InternalDataDsl.g:3691:1: ( 'double' )
            {
            // InternalDataDsl.g:3691:1: ( 'double' )
            // InternalDataDsl.g:3692:2: 'double'
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
    // InternalDataDsl.g:3702:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3706:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalDataDsl.g:3707:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
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
    // InternalDataDsl.g:3714:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3718:1: ( ( () ) )
            // InternalDataDsl.g:3719:1: ( () )
            {
            // InternalDataDsl.g:3719:1: ( () )
            // InternalDataDsl.g:3720:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalDataDsl.g:3721:2: ()
            // InternalDataDsl.g:3721:3: 
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
    // InternalDataDsl.g:3729:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3733:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalDataDsl.g:3734:2: rule__PrimitiveType__Group_5__1__Impl
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
    // InternalDataDsl.g:3740:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3744:1: ( ( 'float' ) )
            // InternalDataDsl.g:3745:1: ( 'float' )
            {
            // InternalDataDsl.g:3745:1: ( 'float' )
            // InternalDataDsl.g:3746:2: 'float'
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
    // InternalDataDsl.g:3756:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3760:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalDataDsl.g:3761:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
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
    // InternalDataDsl.g:3768:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3772:1: ( ( () ) )
            // InternalDataDsl.g:3773:1: ( () )
            {
            // InternalDataDsl.g:3773:1: ( () )
            // InternalDataDsl.g:3774:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalDataDsl.g:3775:2: ()
            // InternalDataDsl.g:3775:3: 
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
    // InternalDataDsl.g:3783:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3787:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalDataDsl.g:3788:2: rule__PrimitiveType__Group_6__1__Impl
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
    // InternalDataDsl.g:3794:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3798:1: ( ( 'int' ) )
            // InternalDataDsl.g:3799:1: ( 'int' )
            {
            // InternalDataDsl.g:3799:1: ( 'int' )
            // InternalDataDsl.g:3800:2: 'int'
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
    // InternalDataDsl.g:3810:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3814:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalDataDsl.g:3815:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
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
    // InternalDataDsl.g:3822:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3826:1: ( ( () ) )
            // InternalDataDsl.g:3827:1: ( () )
            {
            // InternalDataDsl.g:3827:1: ( () )
            // InternalDataDsl.g:3828:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalDataDsl.g:3829:2: ()
            // InternalDataDsl.g:3829:3: 
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
    // InternalDataDsl.g:3837:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3841:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalDataDsl.g:3842:2: rule__PrimitiveType__Group_7__1__Impl
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
    // InternalDataDsl.g:3848:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3852:1: ( ( 'long' ) )
            // InternalDataDsl.g:3853:1: ( 'long' )
            {
            // InternalDataDsl.g:3853:1: ( 'long' )
            // InternalDataDsl.g:3854:2: 'long'
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
    // InternalDataDsl.g:3864:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3868:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalDataDsl.g:3869:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
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
    // InternalDataDsl.g:3876:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3880:1: ( ( () ) )
            // InternalDataDsl.g:3881:1: ( () )
            {
            // InternalDataDsl.g:3881:1: ( () )
            // InternalDataDsl.g:3882:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalDataDsl.g:3883:2: ()
            // InternalDataDsl.g:3883:3: 
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
    // InternalDataDsl.g:3891:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3895:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalDataDsl.g:3896:2: rule__PrimitiveType__Group_8__1__Impl
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
    // InternalDataDsl.g:3902:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3906:1: ( ( 'short' ) )
            // InternalDataDsl.g:3907:1: ( 'short' )
            {
            // InternalDataDsl.g:3907:1: ( 'short' )
            // InternalDataDsl.g:3908:2: 'short'
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
    // InternalDataDsl.g:3918:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3922:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalDataDsl.g:3923:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:3930:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3934:1: ( ( () ) )
            // InternalDataDsl.g:3935:1: ( () )
            {
            // InternalDataDsl.g:3935:1: ( () )
            // InternalDataDsl.g:3936:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalDataDsl.g:3937:2: ()
            // InternalDataDsl.g:3937:3: 
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
    // InternalDataDsl.g:3945:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3949:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalDataDsl.g:3950:2: rule__PrimitiveType__Group_9__1__Impl
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
    // InternalDataDsl.g:3956:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3960:1: ( ( 'string' ) )
            // InternalDataDsl.g:3961:1: ( 'string' )
            {
            // InternalDataDsl.g:3961:1: ( 'string' )
            // InternalDataDsl.g:3962:2: 'string'
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
    // InternalDataDsl.g:3972:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3976:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDsl.g:3977:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalDataDsl.g:3984:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3988:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:3989:1: ( RULE_ID )
            {
            // InternalDataDsl.g:3989:1: ( RULE_ID )
            // InternalDataDsl.g:3990:2: RULE_ID
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
    // InternalDataDsl.g:3999:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4003:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDsl.g:4004:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDataDsl.g:4010:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4014:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDsl.g:4015:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDsl.g:4015:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDsl.g:4016:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDataDsl.g:4017:2: ( rule__QualifiedName__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==43) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalDataDsl.g:4017:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_44);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalDataDsl.g:4026:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4030:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDsl.g:4031:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDataDsl.g:4038:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4042:1: ( ( '.' ) )
            // InternalDataDsl.g:4043:1: ( '.' )
            {
            // InternalDataDsl.g:4043:1: ( '.' )
            // InternalDataDsl.g:4044:2: '.'
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
    // InternalDataDsl.g:4053:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4057:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDsl.g:4058:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDataDsl.g:4064:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4068:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4069:1: ( RULE_ID )
            {
            // InternalDataDsl.g:4069:1: ( RULE_ID )
            // InternalDataDsl.g:4070:2: RULE_ID
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
    // InternalDataDsl.g:4080:1: rule__DataModel__ComplexTypeImportsAssignment_0 : ( ruleComplexTypeImport ) ;
    public final void rule__DataModel__ComplexTypeImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4084:1: ( ( ruleComplexTypeImport ) )
            // InternalDataDsl.g:4085:2: ( ruleComplexTypeImport )
            {
            // InternalDataDsl.g:4085:2: ( ruleComplexTypeImport )
            // InternalDataDsl.g:4086:3: ruleComplexTypeImport
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
    // InternalDataDsl.g:4095:1: rule__DataModel__VersionsAssignment_1_0 : ( ruleVersion ) ;
    public final void rule__DataModel__VersionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4099:1: ( ( ruleVersion ) )
            // InternalDataDsl.g:4100:2: ( ruleVersion )
            {
            // InternalDataDsl.g:4100:2: ( ruleVersion )
            // InternalDataDsl.g:4101:3: ruleVersion
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
    // InternalDataDsl.g:4110:1: rule__DataModel__ContextsAssignment_1_1 : ( ruleContext ) ;
    public final void rule__DataModel__ContextsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4114:1: ( ( ruleContext ) )
            // InternalDataDsl.g:4115:2: ( ruleContext )
            {
            // InternalDataDsl.g:4115:2: ( ruleContext )
            // InternalDataDsl.g:4116:3: ruleContext
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
    // InternalDataDsl.g:4125:1: rule__DataModel__ComplexTypesAssignment_1_2 : ( ruleComplexType ) ;
    public final void rule__DataModel__ComplexTypesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4129:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4130:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4130:2: ( ruleComplexType )
            // InternalDataDsl.g:4131:3: ruleComplexType
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
    // InternalDataDsl.g:4140:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4144:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:4145:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:4145:2: ( RULE_STRING )
            // InternalDataDsl.g:4146:3: RULE_STRING
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
    // InternalDataDsl.g:4155:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4159:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4160:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4160:2: ( RULE_ID )
            // InternalDataDsl.g:4161:3: RULE_ID
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
    // InternalDataDsl.g:4170:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4174:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4175:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4175:2: ( RULE_ID )
            // InternalDataDsl.g:4176:3: RULE_ID
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
    // InternalDataDsl.g:4185:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4189:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4190:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4190:2: ( ruleComplexType )
            // InternalDataDsl.g:4191:3: ruleComplexType
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
    // InternalDataDsl.g:4200:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4204:1: ( ( ruleContext ) )
            // InternalDataDsl.g:4205:2: ( ruleContext )
            {
            // InternalDataDsl.g:4205:2: ( ruleContext )
            // InternalDataDsl.g:4206:3: ruleContext
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
    // InternalDataDsl.g:4215:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4219:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4220:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4220:2: ( RULE_ID )
            // InternalDataDsl.g:4221:3: RULE_ID
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
    // InternalDataDsl.g:4230:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4234:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4235:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4235:2: ( ruleComplexType )
            // InternalDataDsl.g:4236:3: ruleComplexType
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
    // InternalDataDsl.g:4245:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4249:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4250:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4250:2: ( RULE_ID )
            // InternalDataDsl.g:4251:3: RULE_ID
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
    // InternalDataDsl.g:4260:1: rule__DataStructure__SuperAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4264:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4265:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4265:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4266:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0()); 
            // InternalDataDsl.g:4267:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4268:4: ruleQualifiedName
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
    // InternalDataDsl.g:4279:1: rule__DataStructure__DataFieldsAssignment_4_0_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4283:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4284:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4284:2: ( ruleDataField )
            // InternalDataDsl.g:4285:3: ruleDataField
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


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_0_1_1"
    // InternalDataDsl.g:4294:1: rule__DataStructure__DataFieldsAssignment_4_0_1_1 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4298:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4299:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4299:2: ( ruleDataField )
            // InternalDataDsl.g:4300:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_1_1_0()); 

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
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_0_1_1"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_4_1_0"
    // InternalDataDsl.g:4309:1: rule__DataStructure__OperationsAssignment_4_1_0 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4313:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4314:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4314:2: ( ruleDataOperation )
            // InternalDataDsl.g:4315:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_1_0_0()); 

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
    // $ANTLR end "rule__DataStructure__OperationsAssignment_4_1_0"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_4_1_1_1"
    // InternalDataDsl.g:4324:1: rule__DataStructure__OperationsAssignment_4_1_1_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4328:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4329:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4329:2: ( ruleDataOperation )
            // InternalDataDsl.g:4330:3: ruleDataOperation
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


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_2_0"
    // InternalDataDsl.g:4339:1: rule__DataStructure__DataFieldsAssignment_4_2_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4343:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4344:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4344:2: ( ruleDataField )
            // InternalDataDsl.g:4345:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_2_0_0()); 

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
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_2_0"


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_2_1_1"
    // InternalDataDsl.g:4354:1: rule__DataStructure__DataFieldsAssignment_4_2_1_1 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4358:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4359:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4359:2: ( ruleDataField )
            // InternalDataDsl.g:4360:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_2_1_1_0()); 

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
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_2_1_1"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_4_2_3"
    // InternalDataDsl.g:4369:1: rule__DataStructure__OperationsAssignment_4_2_3 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_4_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4373:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4374:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4374:2: ( ruleDataOperation )
            // InternalDataDsl.g:4375:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_2_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_2_3_0()); 

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
    // $ANTLR end "rule__DataStructure__OperationsAssignment_4_2_3"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_4_2_4_1"
    // InternalDataDsl.g:4384:1: rule__DataStructure__OperationsAssignment_4_2_4_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_4_2_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4388:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4389:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4389:2: ( ruleDataOperation )
            // InternalDataDsl.g:4390:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_2_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_4_2_4_1_0()); 

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
    // $ANTLR end "rule__DataStructure__OperationsAssignment_4_2_4_1"


    // $ANTLR start "rule__ListType__NameAssignment_0_1"
    // InternalDataDsl.g:4399:1: rule__ListType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4403:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4404:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4404:2: ( RULE_ID )
            // InternalDataDsl.g:4405:3: RULE_ID
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
    // InternalDataDsl.g:4414:1: rule__ListType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4418:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4419:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4419:2: ( ruleDataField )
            // InternalDataDsl.g:4420:3: ruleDataField
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
    // InternalDataDsl.g:4429:1: rule__ListType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4433:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4434:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4434:2: ( ruleDataField )
            // InternalDataDsl.g:4435:3: ruleDataField
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
    // InternalDataDsl.g:4444:1: rule__ListType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4448:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4449:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4449:2: ( RULE_ID )
            // InternalDataDsl.g:4450:3: RULE_ID
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
    // InternalDataDsl.g:4459:1: rule__ListType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__ListType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4463:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4464:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4464:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4465:3: rulePrimitiveType
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
    // InternalDataDsl.g:4474:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4478:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:4479:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:4479:2: ( ( 'hide' ) )
            // InternalDataDsl.g:4480:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:4481:3: ( 'hide' )
            // InternalDataDsl.g:4482:4: 'hide'
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
    // InternalDataDsl.g:4493:1: rule__DataField__PrimitiveTypeAssignment_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4497:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4498:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4498:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4499:3: rulePrimitiveType
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
    // InternalDataDsl.g:4508:1: rule__DataField__ComplexTypeAssignment_1_1 : ( rulePossiblyImportedComplexType ) ;
    public final void rule__DataField__ComplexTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4512:1: ( ( rulePossiblyImportedComplexType ) )
            // InternalDataDsl.g:4513:2: ( rulePossiblyImportedComplexType )
            {
            // InternalDataDsl.g:4513:2: ( rulePossiblyImportedComplexType )
            // InternalDataDsl.g:4514:3: rulePossiblyImportedComplexType
            {
             before(grammarAccess.getDataFieldAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePossiblyImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_1_1_0()); 

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


    // $ANTLR start "rule__DataField__NameAssignment_2"
    // InternalDataDsl.g:4523:1: rule__DataField__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4527:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4528:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4528:2: ( RULE_ID )
            // InternalDataDsl.g:4529:3: RULE_ID
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
    // InternalDataDsl.g:4538:1: rule__DataField__FeaturesAssignment_3_1 : ( ruleFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4542:1: ( ( ruleFieldFeature ) )
            // InternalDataDsl.g:4543:2: ( ruleFieldFeature )
            {
            // InternalDataDsl.g:4543:2: ( ruleFieldFeature )
            // InternalDataDsl.g:4544:3: ruleFieldFeature
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
    // InternalDataDsl.g:4553:1: rule__DataField__FeaturesAssignment_3_2_1 : ( ruleFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4557:1: ( ( ruleFieldFeature ) )
            // InternalDataDsl.g:4558:2: ( ruleFieldFeature )
            {
            // InternalDataDsl.g:4558:2: ( ruleFieldFeature )
            // InternalDataDsl.g:4559:3: ruleFieldFeature
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
    // InternalDataDsl.g:4568:1: rule__Enumeration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4572:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4573:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4573:2: ( RULE_ID )
            // InternalDataDsl.g:4574:3: RULE_ID
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
    // InternalDataDsl.g:4583:1: rule__Enumeration__FieldsAssignment_3 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4587:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:4588:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:4588:2: ( ruleEnumerationField )
            // InternalDataDsl.g:4589:3: ruleEnumerationField
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
    // InternalDataDsl.g:4598:1: rule__Enumeration__FieldsAssignment_4_1 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4602:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:4603:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:4603:2: ( ruleEnumerationField )
            // InternalDataDsl.g:4604:3: ruleEnumerationField
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
    // InternalDataDsl.g:4613:1: rule__EnumerationField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EnumerationField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4617:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4618:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4618:2: ( RULE_ID )
            // InternalDataDsl.g:4619:3: RULE_ID
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
    // InternalDataDsl.g:4628:1: rule__EnumerationField__InitializationValueAssignment_1_1 : ( rulePrimitiveValue ) ;
    public final void rule__EnumerationField__InitializationValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4632:1: ( ( rulePrimitiveValue ) )
            // InternalDataDsl.g:4633:2: ( rulePrimitiveValue )
            {
            // InternalDataDsl.g:4633:2: ( rulePrimitiveValue )
            // InternalDataDsl.g:4634:3: rulePrimitiveValue
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
    // InternalDataDsl.g:4643:1: rule__DataOperation__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataOperation__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4647:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:4648:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:4648:2: ( ( 'hide' ) )
            // InternalDataDsl.g:4649:3: ( 'hide' )
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:4650:3: ( 'hide' )
            // InternalDataDsl.g:4651:4: 'hide'
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
    // InternalDataDsl.g:4662:1: rule__DataOperation__HasNoReturnTypeAssignment_1_0 : ( ( 'procedure' ) ) ;
    public final void rule__DataOperation__HasNoReturnTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4666:1: ( ( ( 'procedure' ) ) )
            // InternalDataDsl.g:4667:2: ( ( 'procedure' ) )
            {
            // InternalDataDsl.g:4667:2: ( ( 'procedure' ) )
            // InternalDataDsl.g:4668:3: ( 'procedure' )
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            // InternalDataDsl.g:4669:3: ( 'procedure' )
            // InternalDataDsl.g:4670:4: 'procedure'
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
    // InternalDataDsl.g:4681:1: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4685:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4686:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4686:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4687:3: rulePrimitiveType
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
    // InternalDataDsl.g:4696:1: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 : ( rulePossiblyImportedComplexType ) ;
    public final void rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4700:1: ( ( rulePossiblyImportedComplexType ) )
            // InternalDataDsl.g:4701:2: ( rulePossiblyImportedComplexType )
            {
            // InternalDataDsl.g:4701:2: ( rulePossiblyImportedComplexType )
            // InternalDataDsl.g:4702:3: rulePossiblyImportedComplexType
            {
             before(grammarAccess.getDataOperationAccess().getComplexReturnTypePossiblyImportedComplexTypeParserRuleCall_1_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePossiblyImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getComplexReturnTypePossiblyImportedComplexTypeParserRuleCall_1_1_1_1_0()); 

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


    // $ANTLR start "rule__DataOperation__NameAssignment_2"
    // InternalDataDsl.g:4711:1: rule__DataOperation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataOperation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4715:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4716:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4716:2: ( RULE_ID )
            // InternalDataDsl.g:4717:3: RULE_ID
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
    // InternalDataDsl.g:4726:1: rule__DataOperation__ParametersAssignment_3_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4730:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:4731:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:4731:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:4732:3: ruleDataOperationParameter
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
    // InternalDataDsl.g:4741:1: rule__DataOperation__ParametersAssignment_3_2_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4745:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:4746:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:4746:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:4747:3: ruleDataOperationParameter
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
    // InternalDataDsl.g:4756:1: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperationParameter__PrimitiveTypeAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4760:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4761:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4761:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4762:3: rulePrimitiveType
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
    // InternalDataDsl.g:4771:1: rule__DataOperationParameter__ComplexTypeAssignment_0_1 : ( rulePossiblyImportedComplexType ) ;
    public final void rule__DataOperationParameter__ComplexTypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4775:1: ( ( rulePossiblyImportedComplexType ) )
            // InternalDataDsl.g:4776:2: ( rulePossiblyImportedComplexType )
            {
            // InternalDataDsl.g:4776:2: ( rulePossiblyImportedComplexType )
            // InternalDataDsl.g:4777:3: rulePossiblyImportedComplexType
            {
             before(grammarAccess.getDataOperationParameterAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            rulePossiblyImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataOperationParameterAccess().getComplexTypePossiblyImportedComplexTypeParserRuleCall_0_1_0()); 

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


    // $ANTLR start "rule__DataOperationParameter__NameAssignment_1"
    // InternalDataDsl.g:4786:1: rule__DataOperationParameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataOperationParameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4790:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4791:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4791:2: ( RULE_ID )
            // InternalDataDsl.g:4792:3: RULE_ID
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
    // InternalDataDsl.g:4801:1: rule__PrimitiveValue__NumericValueAssignment_0 : ( RULE_BIG_DECIMAL ) ;
    public final void rule__PrimitiveValue__NumericValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4805:1: ( ( RULE_BIG_DECIMAL ) )
            // InternalDataDsl.g:4806:2: ( RULE_BIG_DECIMAL )
            {
            // InternalDataDsl.g:4806:2: ( RULE_BIG_DECIMAL )
            // InternalDataDsl.g:4807:3: RULE_BIG_DECIMAL
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
    // InternalDataDsl.g:4816:1: rule__PrimitiveValue__BooleanValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__PrimitiveValue__BooleanValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4820:1: ( ( RULE_BOOLEAN ) )
            // InternalDataDsl.g:4821:2: ( RULE_BOOLEAN )
            {
            // InternalDataDsl.g:4821:2: ( RULE_BOOLEAN )
            // InternalDataDsl.g:4822:3: RULE_BOOLEAN
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
    // InternalDataDsl.g:4831:1: rule__PrimitiveValue__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4835:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:4836:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:4836:2: ( RULE_STRING )
            // InternalDataDsl.g:4837:3: RULE_STRING
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


    // $ANTLR start "rule__PossiblyImportedComplexType__ImportAssignment_0_0"
    // InternalDataDsl.g:4846:1: rule__PossiblyImportedComplexType__ImportAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__PossiblyImportedComplexType__ImportAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4850:1: ( ( ( RULE_ID ) ) )
            // InternalDataDsl.g:4851:2: ( ( RULE_ID ) )
            {
            // InternalDataDsl.g:4851:2: ( ( RULE_ID ) )
            // InternalDataDsl.g:4852:3: ( RULE_ID )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0()); 
            // InternalDataDsl.g:4853:3: ( RULE_ID )
            // InternalDataDsl.g:4854:4: RULE_ID
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0()); 

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
    // $ANTLR end "rule__PossiblyImportedComplexType__ImportAssignment_0_0"


    // $ANTLR start "rule__PossiblyImportedComplexType__ComplexTypeAssignment_1"
    // InternalDataDsl.g:4865:1: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__PossiblyImportedComplexType__ComplexTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4869:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4870:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4870:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4871:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeCrossReference_1_0()); 
            // InternalDataDsl.g:4872:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4873:4: ruleQualifiedName
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeCrossReference_1_0()); 

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
    // $ANTLR end "rule__PossiblyImportedComplexType__ComplexTypeAssignment_1"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\61\uffff";
    static final String dfa_2s = "\15\4\1\uffff\1\24\1\4\1\15\1\4\1\uffff\2\4\1\30\14\4\1\uffff\1\4\1\15\2\24\1\15\2\4\2\30\2\4\1\15\1\24\1\30";
    static final String dfa_3s = "\2\55\12\4\1\53\1\uffff\1\32\1\4\1\15\1\55\1\uffff\1\4\1\53\1\33\1\55\12\4\1\53\1\uffff\1\53\1\15\1\30\1\32\1\15\2\4\2\33\2\53\1\15\1\30\1\33";
    static final String dfa_4s = "\15\uffff\1\2\4\uffff\1\1\17\uffff\1\3\16\uffff";
    static final String dfa_5s = "\61\uffff}>";
    static final String[] dfa_6s = {
            "\1\14\32\uffff\1\15\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff\1\1\1\15",
            "\1\14\32\uffff\1\15\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\2\uffff\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16\17\uffff\1\22\3\uffff\1\21\1\uffff\1\20\5\uffff\1\17\12\uffff\1\23",
            "",
            "\1\22\3\uffff\1\21\1\uffff\1\20",
            "\1\24",
            "\1\25",
            "\1\41\32\uffff\1\42\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\uffff\1\26\1\42",
            "",
            "\1\43",
            "\1\16\46\uffff\1\23",
            "\1\44\2\uffff\1\45",
            "\1\41\32\uffff\1\42\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\2\uffff\1\42",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46",
            "\1\46\17\uffff\1\22\3\uffff\1\21\1\uffff\1\47\5\uffff\1\51\12\uffff\1\50",
            "",
            "\1\16\46\uffff\1\23",
            "\1\52",
            "\1\22\3\uffff\1\21",
            "\1\22\3\uffff\1\21\1\uffff\1\47",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\44\2\uffff\1\45",
            "\1\56\2\uffff\1\57",
            "\1\46\46\uffff\1\50",
            "\1\46\46\uffff\1\50",
            "\1\60",
            "\1\22\3\uffff\1\21",
            "\1\56\2\uffff\1\57"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "578:1: rule__DataStructure__Alternatives_4 : ( ( ( rule__DataStructure__Group_4_0__0 ) ) | ( ( rule__DataStructure__Group_4_1__0 ) ) | ( ( rule__DataStructure__Group_4_2__0 ) ) );";
        }
    }
    static final String dfa_7s = "\20\uffff";
    static final String dfa_8s = "\1\31\1\4\1\23\13\4\2\uffff";
    static final String dfa_9s = "\1\31\1\4\1\23\1\54\12\24\2\uffff";
    static final String dfa_10s = "\16\uffff\1\1\1\2";
    static final String dfa_11s = "\20\uffff}>";
    static final String[] dfa_12s = {
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

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "605:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );";
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
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000007FE00000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000017FE00000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000300080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000007FE00000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000000L});
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