package de.fhdo.ddmm.data.ide.contentassist.antlr.internal;

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
import de.fhdo.ddmm.data.services.DataDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDataDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'datatypes'", "'from'", "'as'", "'version'", "'{'", "'}'", "'context'", "'structure'", "'extends'", "','", "'list'", "'::'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'hide'"
    };
    public static final int RULE_BOOLEAN=8;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_BIG_DECIMAL=7;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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


    // $ANTLR start "entryRulePossiblyImportedComplexType"
    // InternalDataDsl.g:253:1: entryRulePossiblyImportedComplexType : rulePossiblyImportedComplexType EOF ;
    public final void entryRulePossiblyImportedComplexType() throws RecognitionException {
        try {
            // InternalDataDsl.g:254:1: ( rulePossiblyImportedComplexType EOF )
            // InternalDataDsl.g:255:1: rulePossiblyImportedComplexType EOF
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
    // InternalDataDsl.g:262:1: rulePossiblyImportedComplexType : ( ( rule__PossiblyImportedComplexType__Group__0 ) ) ;
    public final void rulePossiblyImportedComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:266:2: ( ( ( rule__PossiblyImportedComplexType__Group__0 ) ) )
            // InternalDataDsl.g:267:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            {
            // InternalDataDsl.g:267:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            // InternalDataDsl.g:268:3: ( rule__PossiblyImportedComplexType__Group__0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup()); 
            // InternalDataDsl.g:269:3: ( rule__PossiblyImportedComplexType__Group__0 )
            // InternalDataDsl.g:269:4: rule__PossiblyImportedComplexType__Group__0
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
    // InternalDataDsl.g:278:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalDataDsl.g:279:1: ( rulePrimitiveType EOF )
            // InternalDataDsl.g:280:1: rulePrimitiveType EOF
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
    // InternalDataDsl.g:287:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:291:2: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalDataDsl.g:292:2: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalDataDsl.g:292:2: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalDataDsl.g:293:3: ( rule__PrimitiveType__Alternatives )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            // InternalDataDsl.g:294:3: ( rule__PrimitiveType__Alternatives )
            // InternalDataDsl.g:294:4: rule__PrimitiveType__Alternatives
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
    // InternalDataDsl.g:303:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDataDsl.g:304:1: ( ruleQualifiedName EOF )
            // InternalDataDsl.g:305:1: ruleQualifiedName EOF
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
    // InternalDataDsl.g:312:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:316:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDataDsl.g:317:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDataDsl.g:317:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDataDsl.g:318:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalDataDsl.g:319:3: ( rule__QualifiedName__Group__0 )
            // InternalDataDsl.g:319:4: rule__QualifiedName__Group__0
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


    // $ANTLR start "rule__DataModel__Alternatives_1"
    // InternalDataDsl.g:327:1: rule__DataModel__Alternatives_1 : ( ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) ) | ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) ) | ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) ) );
    public final void rule__DataModel__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:331:1: ( ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) ) | ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) ) | ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 21:
            case 24:
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
                    // InternalDataDsl.g:332:2: ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) )
                    {
                    // InternalDataDsl.g:332:2: ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) )
                    // InternalDataDsl.g:333:3: ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* )
                    {
                    // InternalDataDsl.g:333:3: ( ( rule__DataModel__VersionsAssignment_1_0 ) )
                    // InternalDataDsl.g:334:4: ( rule__DataModel__VersionsAssignment_1_0 )
                    {
                     before(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 
                    // InternalDataDsl.g:335:4: ( rule__DataModel__VersionsAssignment_1_0 )
                    // InternalDataDsl.g:335:5: rule__DataModel__VersionsAssignment_1_0
                    {
                    pushFollow(FOLLOW_3);
                    rule__DataModel__VersionsAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 

                    }

                    // InternalDataDsl.g:338:3: ( ( rule__DataModel__VersionsAssignment_1_0 )* )
                    // InternalDataDsl.g:339:4: ( rule__DataModel__VersionsAssignment_1_0 )*
                    {
                     before(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 
                    // InternalDataDsl.g:340:4: ( rule__DataModel__VersionsAssignment_1_0 )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==17) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalDataDsl.g:340:5: rule__DataModel__VersionsAssignment_1_0
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
                    // InternalDataDsl.g:345:2: ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) )
                    {
                    // InternalDataDsl.g:345:2: ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) )
                    // InternalDataDsl.g:346:3: ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* )
                    {
                    // InternalDataDsl.g:346:3: ( ( rule__DataModel__ContextsAssignment_1_1 ) )
                    // InternalDataDsl.g:347:4: ( rule__DataModel__ContextsAssignment_1_1 )
                    {
                     before(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 
                    // InternalDataDsl.g:348:4: ( rule__DataModel__ContextsAssignment_1_1 )
                    // InternalDataDsl.g:348:5: rule__DataModel__ContextsAssignment_1_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__DataModel__ContextsAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 

                    }

                    // InternalDataDsl.g:351:3: ( ( rule__DataModel__ContextsAssignment_1_1 )* )
                    // InternalDataDsl.g:352:4: ( rule__DataModel__ContextsAssignment_1_1 )*
                    {
                     before(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 
                    // InternalDataDsl.g:353:4: ( rule__DataModel__ContextsAssignment_1_1 )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==20) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDsl.g:353:5: rule__DataModel__ContextsAssignment_1_1
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
                    // InternalDataDsl.g:358:2: ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) )
                    {
                    // InternalDataDsl.g:358:2: ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) )
                    // InternalDataDsl.g:359:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* )
                    {
                    // InternalDataDsl.g:359:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) )
                    // InternalDataDsl.g:360:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )
                    {
                     before(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 
                    // InternalDataDsl.g:361:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )
                    // InternalDataDsl.g:361:5: rule__DataModel__ComplexTypesAssignment_1_2
                    {
                    pushFollow(FOLLOW_5);
                    rule__DataModel__ComplexTypesAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 

                    }

                    // InternalDataDsl.g:364:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* )
                    // InternalDataDsl.g:365:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )*
                    {
                     before(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 
                    // InternalDataDsl.g:366:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==21||LA3_0==24) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalDataDsl.g:366:5: rule__DataModel__ComplexTypesAssignment_1_2
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
    // InternalDataDsl.g:375:1: rule__Version__Alternatives_3 : ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) );
    public final void rule__Version__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:379:1: ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21||LA7_0==24) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDataDsl.g:380:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    {
                    // InternalDataDsl.g:380:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    // InternalDataDsl.g:381:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    {
                    // InternalDataDsl.g:381:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) )
                    // InternalDataDsl.g:382:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalDataDsl.g:383:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    // InternalDataDsl.g:383:5: rule__Version__ComplexTypesAssignment_3_0
                    {
                    pushFollow(FOLLOW_5);
                    rule__Version__ComplexTypesAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }

                    // InternalDataDsl.g:386:3: ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    // InternalDataDsl.g:387:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalDataDsl.g:388:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21||LA5_0==24) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDataDsl.g:388:5: rule__Version__ComplexTypesAssignment_3_0
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
                    // InternalDataDsl.g:393:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    {
                    // InternalDataDsl.g:393:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    // InternalDataDsl.g:394:3: ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* )
                    {
                    // InternalDataDsl.g:394:3: ( ( rule__Version__ContextsAssignment_3_1 ) )
                    // InternalDataDsl.g:395:4: ( rule__Version__ContextsAssignment_3_1 )
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalDataDsl.g:396:4: ( rule__Version__ContextsAssignment_3_1 )
                    // InternalDataDsl.g:396:5: rule__Version__ContextsAssignment_3_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__Version__ContextsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 

                    }

                    // InternalDataDsl.g:399:3: ( ( rule__Version__ContextsAssignment_3_1 )* )
                    // InternalDataDsl.g:400:4: ( rule__Version__ContextsAssignment_3_1 )*
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalDataDsl.g:401:4: ( rule__Version__ContextsAssignment_3_1 )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==20) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDsl.g:401:5: rule__Version__ContextsAssignment_3_1
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
    // InternalDataDsl.g:410:1: rule__ComplexType__Alternatives : ( ( ruleDataStructure ) | ( ruleListType ) );
    public final void rule__ComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:414:1: ( ( ruleDataStructure ) | ( ruleListType ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==24) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalDataDsl.g:415:2: ( ruleDataStructure )
                    {
                    // InternalDataDsl.g:415:2: ( ruleDataStructure )
                    // InternalDataDsl.g:416:3: ruleDataStructure
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
                    // InternalDataDsl.g:421:2: ( ruleListType )
                    {
                    // InternalDataDsl.g:421:2: ( ruleListType )
                    // InternalDataDsl.g:422:3: ruleListType
                    {
                     before(grammarAccess.getComplexTypeAccess().getListTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleListType();

                    state._fsp--;

                     after(grammarAccess.getComplexTypeAccess().getListTypeParserRuleCall_1()); 

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


    // $ANTLR start "rule__ListType__Alternatives"
    // InternalDataDsl.g:431:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );
    public final void rule__ListType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:435:1: ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) )
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalDataDsl.g:436:2: ( ( rule__ListType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:436:2: ( ( rule__ListType__Group_0__0 ) )
                    // InternalDataDsl.g:437:3: ( rule__ListType__Group_0__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:438:3: ( rule__ListType__Group_0__0 )
                    // InternalDataDsl.g:438:4: rule__ListType__Group_0__0
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
                    // InternalDataDsl.g:442:2: ( ( rule__ListType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:442:2: ( ( rule__ListType__Group_1__0 ) )
                    // InternalDataDsl.g:443:3: ( rule__ListType__Group_1__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:444:3: ( rule__ListType__Group_1__0 )
                    // InternalDataDsl.g:444:4: rule__ListType__Group_1__0
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
    // InternalDataDsl.g:452:1: rule__DataField__Alternatives_1 : ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) );
    public final void rule__DataField__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:456:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=26 && LA10_0<=35)) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalDataDsl.g:457:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    {
                    // InternalDataDsl.g:457:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    // InternalDataDsl.g:458:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_1_0()); 
                    // InternalDataDsl.g:459:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    // InternalDataDsl.g:459:4: rule__DataField__PrimitiveTypeAssignment_1_0
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
                    // InternalDataDsl.g:463:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    {
                    // InternalDataDsl.g:463:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    // InternalDataDsl.g:464:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    {
                     before(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 
                    // InternalDataDsl.g:465:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    // InternalDataDsl.g:465:4: rule__DataField__ComplexTypeAssignment_1_1
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


    // $ANTLR start "rule__PrimitiveType__Alternatives"
    // InternalDataDsl.g:473:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:477:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) )
            int alt11=10;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt11=1;
                }
                break;
            case 27:
                {
                alt11=2;
                }
                break;
            case 28:
                {
                alt11=3;
                }
                break;
            case 29:
                {
                alt11=4;
                }
                break;
            case 30:
                {
                alt11=5;
                }
                break;
            case 31:
                {
                alt11=6;
                }
                break;
            case 32:
                {
                alt11=7;
                }
                break;
            case 33:
                {
                alt11=8;
                }
                break;
            case 34:
                {
                alt11=9;
                }
                break;
            case 35:
                {
                alt11=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalDataDsl.g:478:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:478:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalDataDsl.g:479:3: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:480:3: ( rule__PrimitiveType__Group_0__0 )
                    // InternalDataDsl.g:480:4: rule__PrimitiveType__Group_0__0
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
                    // InternalDataDsl.g:484:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:484:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalDataDsl.g:485:3: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:486:3: ( rule__PrimitiveType__Group_1__0 )
                    // InternalDataDsl.g:486:4: rule__PrimitiveType__Group_1__0
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
                    // InternalDataDsl.g:490:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalDataDsl.g:490:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalDataDsl.g:491:3: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalDataDsl.g:492:3: ( rule__PrimitiveType__Group_2__0 )
                    // InternalDataDsl.g:492:4: rule__PrimitiveType__Group_2__0
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
                    // InternalDataDsl.g:496:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalDataDsl.g:496:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalDataDsl.g:497:3: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalDataDsl.g:498:3: ( rule__PrimitiveType__Group_3__0 )
                    // InternalDataDsl.g:498:4: rule__PrimitiveType__Group_3__0
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
                    // InternalDataDsl.g:502:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    {
                    // InternalDataDsl.g:502:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    // InternalDataDsl.g:503:3: ( rule__PrimitiveType__Group_4__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 
                    // InternalDataDsl.g:504:3: ( rule__PrimitiveType__Group_4__0 )
                    // InternalDataDsl.g:504:4: rule__PrimitiveType__Group_4__0
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
                    // InternalDataDsl.g:508:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    {
                    // InternalDataDsl.g:508:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    // InternalDataDsl.g:509:3: ( rule__PrimitiveType__Group_5__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 
                    // InternalDataDsl.g:510:3: ( rule__PrimitiveType__Group_5__0 )
                    // InternalDataDsl.g:510:4: rule__PrimitiveType__Group_5__0
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
                    // InternalDataDsl.g:514:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    {
                    // InternalDataDsl.g:514:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    // InternalDataDsl.g:515:3: ( rule__PrimitiveType__Group_6__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 
                    // InternalDataDsl.g:516:3: ( rule__PrimitiveType__Group_6__0 )
                    // InternalDataDsl.g:516:4: rule__PrimitiveType__Group_6__0
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
                    // InternalDataDsl.g:520:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    {
                    // InternalDataDsl.g:520:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    // InternalDataDsl.g:521:3: ( rule__PrimitiveType__Group_7__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 
                    // InternalDataDsl.g:522:3: ( rule__PrimitiveType__Group_7__0 )
                    // InternalDataDsl.g:522:4: rule__PrimitiveType__Group_7__0
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
                    // InternalDataDsl.g:526:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    {
                    // InternalDataDsl.g:526:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    // InternalDataDsl.g:527:3: ( rule__PrimitiveType__Group_8__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 
                    // InternalDataDsl.g:528:3: ( rule__PrimitiveType__Group_8__0 )
                    // InternalDataDsl.g:528:4: rule__PrimitiveType__Group_8__0
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
                    // InternalDataDsl.g:532:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    {
                    // InternalDataDsl.g:532:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    // InternalDataDsl.g:533:3: ( rule__PrimitiveType__Group_9__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 
                    // InternalDataDsl.g:534:3: ( rule__PrimitiveType__Group_9__0 )
                    // InternalDataDsl.g:534:4: rule__PrimitiveType__Group_9__0
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
    // InternalDataDsl.g:542:1: rule__DataModel__Group__0 : rule__DataModel__Group__0__Impl rule__DataModel__Group__1 ;
    public final void rule__DataModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:546:1: ( rule__DataModel__Group__0__Impl rule__DataModel__Group__1 )
            // InternalDataDsl.g:547:2: rule__DataModel__Group__0__Impl rule__DataModel__Group__1
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
    // InternalDataDsl.g:554:1: rule__DataModel__Group__0__Impl : ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) ;
    public final void rule__DataModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:558:1: ( ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) )
            // InternalDataDsl.g:559:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            {
            // InternalDataDsl.g:559:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            // InternalDataDsl.g:560:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            {
             before(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0()); 
            // InternalDataDsl.g:561:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDataDsl.g:561:3: rule__DataModel__ComplexTypeImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataModel__ComplexTypeImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalDataDsl.g:569:1: rule__DataModel__Group__1 : rule__DataModel__Group__1__Impl ;
    public final void rule__DataModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:573:1: ( rule__DataModel__Group__1__Impl )
            // InternalDataDsl.g:574:2: rule__DataModel__Group__1__Impl
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
    // InternalDataDsl.g:580:1: rule__DataModel__Group__1__Impl : ( ( rule__DataModel__Alternatives_1 ) ) ;
    public final void rule__DataModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:584:1: ( ( ( rule__DataModel__Alternatives_1 ) ) )
            // InternalDataDsl.g:585:1: ( ( rule__DataModel__Alternatives_1 ) )
            {
            // InternalDataDsl.g:585:1: ( ( rule__DataModel__Alternatives_1 ) )
            // InternalDataDsl.g:586:2: ( rule__DataModel__Alternatives_1 )
            {
             before(grammarAccess.getDataModelAccess().getAlternatives_1()); 
            // InternalDataDsl.g:587:2: ( rule__DataModel__Alternatives_1 )
            // InternalDataDsl.g:587:3: rule__DataModel__Alternatives_1
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
    // InternalDataDsl.g:596:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:600:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalDataDsl.g:601:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
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
    // InternalDataDsl.g:608:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:612:1: ( ( 'import' ) )
            // InternalDataDsl.g:613:1: ( 'import' )
            {
            // InternalDataDsl.g:613:1: ( 'import' )
            // InternalDataDsl.g:614:2: 'import'
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportKeyword_0()); 
            match(input,13,FOLLOW_2); 
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
    // InternalDataDsl.g:623:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:627:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalDataDsl.g:628:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
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
    // InternalDataDsl.g:635:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:639:1: ( ( 'datatypes' ) )
            // InternalDataDsl.g:640:1: ( 'datatypes' )
            {
            // InternalDataDsl.g:640:1: ( 'datatypes' )
            // InternalDataDsl.g:641:2: 'datatypes'
            {
             before(grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1()); 
            match(input,14,FOLLOW_2); 
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
    // InternalDataDsl.g:650:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:654:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalDataDsl.g:655:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
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
    // InternalDataDsl.g:662:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:666:1: ( ( 'from' ) )
            // InternalDataDsl.g:667:1: ( 'from' )
            {
            // InternalDataDsl.g:667:1: ( 'from' )
            // InternalDataDsl.g:668:2: 'from'
            {
             before(grammarAccess.getComplexTypeImportAccess().getFromKeyword_2()); 
            match(input,15,FOLLOW_2); 
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
    // InternalDataDsl.g:677:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:681:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalDataDsl.g:682:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
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
    // InternalDataDsl.g:689:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:693:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalDataDsl.g:694:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalDataDsl.g:694:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalDataDsl.g:695:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalDataDsl.g:696:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalDataDsl.g:696:3: rule__ComplexTypeImport__ImportURIAssignment_3
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
    // InternalDataDsl.g:704:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:708:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalDataDsl.g:709:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
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
    // InternalDataDsl.g:716:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:720:1: ( ( 'as' ) )
            // InternalDataDsl.g:721:1: ( 'as' )
            {
            // InternalDataDsl.g:721:1: ( 'as' )
            // InternalDataDsl.g:722:2: 'as'
            {
             before(grammarAccess.getComplexTypeImportAccess().getAsKeyword_4()); 
            match(input,16,FOLLOW_2); 
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
    // InternalDataDsl.g:731:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:735:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalDataDsl.g:736:2: rule__ComplexTypeImport__Group__5__Impl
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
    // InternalDataDsl.g:742:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:746:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalDataDsl.g:747:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalDataDsl.g:747:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalDataDsl.g:748:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalDataDsl.g:749:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalDataDsl.g:749:3: rule__ComplexTypeImport__NameAssignment_5
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
    // InternalDataDsl.g:758:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:762:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalDataDsl.g:763:2: rule__Version__Group__0__Impl rule__Version__Group__1
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
    // InternalDataDsl.g:770:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:774:1: ( ( 'version' ) )
            // InternalDataDsl.g:775:1: ( 'version' )
            {
            // InternalDataDsl.g:775:1: ( 'version' )
            // InternalDataDsl.g:776:2: 'version'
            {
             before(grammarAccess.getVersionAccess().getVersionKeyword_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalDataDsl.g:785:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:789:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalDataDsl.g:790:2: rule__Version__Group__1__Impl rule__Version__Group__2
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
    // InternalDataDsl.g:797:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:801:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalDataDsl.g:802:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:802:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalDataDsl.g:803:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:804:2: ( rule__Version__NameAssignment_1 )
            // InternalDataDsl.g:804:3: rule__Version__NameAssignment_1
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
    // InternalDataDsl.g:812:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:816:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalDataDsl.g:817:2: rule__Version__Group__2__Impl rule__Version__Group__3
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
    // InternalDataDsl.g:824:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:828:1: ( ( '{' ) )
            // InternalDataDsl.g:829:1: ( '{' )
            {
            // InternalDataDsl.g:829:1: ( '{' )
            // InternalDataDsl.g:830:2: '{'
            {
             before(grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,18,FOLLOW_2); 
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
    // InternalDataDsl.g:839:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:843:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalDataDsl.g:844:2: rule__Version__Group__3__Impl rule__Version__Group__4
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
    // InternalDataDsl.g:851:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:855:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalDataDsl.g:856:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalDataDsl.g:856:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalDataDsl.g:857:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalDataDsl.g:858:2: ( rule__Version__Alternatives_3 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=20 && LA13_0<=21)||LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDsl.g:858:3: rule__Version__Alternatives_3
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
    // InternalDataDsl.g:866:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:870:1: ( rule__Version__Group__4__Impl )
            // InternalDataDsl.g:871:2: rule__Version__Group__4__Impl
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
    // InternalDataDsl.g:877:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:881:1: ( ( '}' ) )
            // InternalDataDsl.g:882:1: ( '}' )
            {
            // InternalDataDsl.g:882:1: ( '}' )
            // InternalDataDsl.g:883:2: '}'
            {
             before(grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,19,FOLLOW_2); 
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
    // InternalDataDsl.g:893:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:897:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalDataDsl.g:898:2: rule__Context__Group__0__Impl rule__Context__Group__1
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
    // InternalDataDsl.g:905:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:909:1: ( ( 'context' ) )
            // InternalDataDsl.g:910:1: ( 'context' )
            {
            // InternalDataDsl.g:910:1: ( 'context' )
            // InternalDataDsl.g:911:2: 'context'
            {
             before(grammarAccess.getContextAccess().getContextKeyword_0()); 
            match(input,20,FOLLOW_2); 
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
    // InternalDataDsl.g:920:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:924:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalDataDsl.g:925:2: rule__Context__Group__1__Impl rule__Context__Group__2
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
    // InternalDataDsl.g:932:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:936:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalDataDsl.g:937:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:937:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalDataDsl.g:938:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:939:2: ( rule__Context__NameAssignment_1 )
            // InternalDataDsl.g:939:3: rule__Context__NameAssignment_1
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
    // InternalDataDsl.g:947:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:951:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalDataDsl.g:952:2: rule__Context__Group__2__Impl rule__Context__Group__3
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
    // InternalDataDsl.g:959:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:963:1: ( ( '{' ) )
            // InternalDataDsl.g:964:1: ( '{' )
            {
            // InternalDataDsl.g:964:1: ( '{' )
            // InternalDataDsl.g:965:2: '{'
            {
             before(grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,18,FOLLOW_2); 
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
    // InternalDataDsl.g:974:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:978:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalDataDsl.g:979:2: rule__Context__Group__3__Impl rule__Context__Group__4
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
    // InternalDataDsl.g:986:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:990:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalDataDsl.g:991:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalDataDsl.g:991:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalDataDsl.g:992:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalDataDsl.g:992:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalDataDsl.g:993:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:994:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalDataDsl.g:994:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_5);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalDataDsl.g:997:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalDataDsl.g:998:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:999:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==21||LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDataDsl.g:999:4: rule__Context__ComplexTypesAssignment_3
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Context__ComplexTypesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalDataDsl.g:1008:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1012:1: ( rule__Context__Group__4__Impl )
            // InternalDataDsl.g:1013:2: rule__Context__Group__4__Impl
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
    // InternalDataDsl.g:1019:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1023:1: ( ( '}' ) )
            // InternalDataDsl.g:1024:1: ( '}' )
            {
            // InternalDataDsl.g:1024:1: ( '}' )
            // InternalDataDsl.g:1025:2: '}'
            {
             before(grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4()); 
            match(input,19,FOLLOW_2); 
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
    // InternalDataDsl.g:1035:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1039:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalDataDsl.g:1040:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
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
    // InternalDataDsl.g:1047:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1051:1: ( ( 'structure' ) )
            // InternalDataDsl.g:1052:1: ( 'structure' )
            {
            // InternalDataDsl.g:1052:1: ( 'structure' )
            // InternalDataDsl.g:1053:2: 'structure'
            {
             before(grammarAccess.getDataStructureAccess().getStructureKeyword_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalDataDsl.g:1062:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1066:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalDataDsl.g:1067:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
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
    // InternalDataDsl.g:1074:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1078:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1079:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1079:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalDataDsl.g:1080:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1081:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalDataDsl.g:1081:3: rule__DataStructure__NameAssignment_1
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
    // InternalDataDsl.g:1089:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1093:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalDataDsl.g:1094:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
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
    // InternalDataDsl.g:1101:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1105:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalDataDsl.g:1106:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalDataDsl.g:1106:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalDataDsl.g:1107:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalDataDsl.g:1108:2: ( rule__DataStructure__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDataDsl.g:1108:3: rule__DataStructure__Group_2__0
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
    // InternalDataDsl.g:1116:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1120:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalDataDsl.g:1121:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
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
    // InternalDataDsl.g:1128:1: rule__DataStructure__Group__3__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1132:1: ( ( '{' ) )
            // InternalDataDsl.g:1133:1: ( '{' )
            {
            // InternalDataDsl.g:1133:1: ( '{' )
            // InternalDataDsl.g:1134:2: '{'
            {
             before(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,18,FOLLOW_2); 
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
    // InternalDataDsl.g:1143:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1147:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalDataDsl.g:1148:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
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
    // InternalDataDsl.g:1155:1: rule__DataStructure__Group__4__Impl : ( ( rule__DataStructure__Group_4__0 )? ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1159:1: ( ( ( rule__DataStructure__Group_4__0 )? ) )
            // InternalDataDsl.g:1160:1: ( ( rule__DataStructure__Group_4__0 )? )
            {
            // InternalDataDsl.g:1160:1: ( ( rule__DataStructure__Group_4__0 )? )
            // InternalDataDsl.g:1161:2: ( rule__DataStructure__Group_4__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4()); 
            // InternalDataDsl.g:1162:2: ( rule__DataStructure__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||(LA16_0>=26 && LA16_0<=35)||LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDataDsl.g:1162:3: rule__DataStructure__Group_4__0
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
    // InternalDataDsl.g:1170:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1174:1: ( rule__DataStructure__Group__5__Impl )
            // InternalDataDsl.g:1175:2: rule__DataStructure__Group__5__Impl
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
    // InternalDataDsl.g:1181:1: rule__DataStructure__Group__5__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1185:1: ( ( '}' ) )
            // InternalDataDsl.g:1186:1: ( '}' )
            {
            // InternalDataDsl.g:1186:1: ( '}' )
            // InternalDataDsl.g:1187:2: '}'
            {
             before(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5()); 
            match(input,19,FOLLOW_2); 
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
    // InternalDataDsl.g:1197:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1201:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalDataDsl.g:1202:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
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
    // InternalDataDsl.g:1209:1: rule__DataStructure__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1213:1: ( ( 'extends' ) )
            // InternalDataDsl.g:1214:1: ( 'extends' )
            {
            // InternalDataDsl.g:1214:1: ( 'extends' )
            // InternalDataDsl.g:1215:2: 'extends'
            {
             before(grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalDataDsl.g:1224:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1228:1: ( rule__DataStructure__Group_2__1__Impl )
            // InternalDataDsl.g:1229:2: rule__DataStructure__Group_2__1__Impl
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
    // InternalDataDsl.g:1235:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__SuperAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1239:1: ( ( ( rule__DataStructure__SuperAssignment_2_1 ) ) )
            // InternalDataDsl.g:1240:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            {
            // InternalDataDsl.g:1240:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            // InternalDataDsl.g:1241:2: ( rule__DataStructure__SuperAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_2_1()); 
            // InternalDataDsl.g:1242:2: ( rule__DataStructure__SuperAssignment_2_1 )
            // InternalDataDsl.g:1242:3: rule__DataStructure__SuperAssignment_2_1
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
    // InternalDataDsl.g:1251:1: rule__DataStructure__Group_4__0 : rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 ;
    public final void rule__DataStructure__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1255:1: ( rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 )
            // InternalDataDsl.g:1256:2: rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalDataDsl.g:1263:1: rule__DataStructure__Group_4__0__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) ) ;
    public final void rule__DataStructure__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1267:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) ) )
            // InternalDataDsl.g:1268:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) )
            {
            // InternalDataDsl.g:1268:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) )
            // InternalDataDsl.g:1269:2: ( rule__DataStructure__DataFieldsAssignment_4_0 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0()); 
            // InternalDataDsl.g:1270:2: ( rule__DataStructure__DataFieldsAssignment_4_0 )
            // InternalDataDsl.g:1270:3: rule__DataStructure__DataFieldsAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__DataFieldsAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0()); 

            }


            }

        }
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
    // InternalDataDsl.g:1278:1: rule__DataStructure__Group_4__1 : rule__DataStructure__Group_4__1__Impl ;
    public final void rule__DataStructure__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1282:1: ( rule__DataStructure__Group_4__1__Impl )
            // InternalDataDsl.g:1283:2: rule__DataStructure__Group_4__1__Impl
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
    // InternalDataDsl.g:1289:1: rule__DataStructure__Group_4__1__Impl : ( ( rule__DataStructure__Group_4_1__0 )* ) ;
    public final void rule__DataStructure__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1293:1: ( ( ( rule__DataStructure__Group_4_1__0 )* ) )
            // InternalDataDsl.g:1294:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            {
            // InternalDataDsl.g:1294:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            // InternalDataDsl.g:1295:2: ( rule__DataStructure__Group_4_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_1()); 
            // InternalDataDsl.g:1296:2: ( rule__DataStructure__Group_4_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==23) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDataDsl.g:1296:3: rule__DataStructure__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalDataDsl.g:1305:1: rule__DataStructure__Group_4_1__0 : rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 ;
    public final void rule__DataStructure__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1309:1: ( rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 )
            // InternalDataDsl.g:1310:2: rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalDataDsl.g:1317:1: rule__DataStructure__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1321:1: ( ( ',' ) )
            // InternalDataDsl.g:1322:1: ( ',' )
            {
            // InternalDataDsl.g:1322:1: ( ',' )
            // InternalDataDsl.g:1323:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalDataDsl.g:1332:1: rule__DataStructure__Group_4_1__1 : rule__DataStructure__Group_4_1__1__Impl ;
    public final void rule__DataStructure__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1336:1: ( rule__DataStructure__Group_4_1__1__Impl )
            // InternalDataDsl.g:1337:2: rule__DataStructure__Group_4_1__1__Impl
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
    // InternalDataDsl.g:1343:1: rule__DataStructure__Group_4_1__1__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1347:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) ) )
            // InternalDataDsl.g:1348:1: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) )
            {
            // InternalDataDsl.g:1348:1: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) )
            // InternalDataDsl.g:1349:2: ( rule__DataStructure__DataFieldsAssignment_4_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_1_1()); 
            // InternalDataDsl.g:1350:2: ( rule__DataStructure__DataFieldsAssignment_4_1_1 )
            // InternalDataDsl.g:1350:3: rule__DataStructure__DataFieldsAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__DataFieldsAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_1_1()); 

            }


            }

        }
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
    // InternalDataDsl.g:1359:1: rule__ListType__Group_0__0 : rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 ;
    public final void rule__ListType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1363:1: ( rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 )
            // InternalDataDsl.g:1364:2: rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1
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
    // InternalDataDsl.g:1371:1: rule__ListType__Group_0__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1375:1: ( ( 'list' ) )
            // InternalDataDsl.g:1376:1: ( 'list' )
            {
            // InternalDataDsl.g:1376:1: ( 'list' )
            // InternalDataDsl.g:1377:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_0_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalDataDsl.g:1386:1: rule__ListType__Group_0__1 : rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 ;
    public final void rule__ListType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1390:1: ( rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 )
            // InternalDataDsl.g:1391:2: rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2
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
    // InternalDataDsl.g:1398:1: rule__ListType__Group_0__1__Impl : ( ( rule__ListType__NameAssignment_0_1 ) ) ;
    public final void rule__ListType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1402:1: ( ( ( rule__ListType__NameAssignment_0_1 ) ) )
            // InternalDataDsl.g:1403:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            {
            // InternalDataDsl.g:1403:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            // InternalDataDsl.g:1404:2: ( rule__ListType__NameAssignment_0_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 
            // InternalDataDsl.g:1405:2: ( rule__ListType__NameAssignment_0_1 )
            // InternalDataDsl.g:1405:3: rule__ListType__NameAssignment_0_1
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
    // InternalDataDsl.g:1413:1: rule__ListType__Group_0__2 : rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 ;
    public final void rule__ListType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1417:1: ( rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 )
            // InternalDataDsl.g:1418:2: rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3
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
    // InternalDataDsl.g:1425:1: rule__ListType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1429:1: ( ( '{' ) )
            // InternalDataDsl.g:1430:1: ( '{' )
            {
            // InternalDataDsl.g:1430:1: ( '{' )
            // InternalDataDsl.g:1431:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,18,FOLLOW_2); 
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
    // InternalDataDsl.g:1440:1: rule__ListType__Group_0__3 : rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 ;
    public final void rule__ListType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1444:1: ( rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 )
            // InternalDataDsl.g:1445:2: rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4
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
    // InternalDataDsl.g:1452:1: rule__ListType__Group_0__3__Impl : ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__ListType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1456:1: ( ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) )
            // InternalDataDsl.g:1457:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            {
            // InternalDataDsl.g:1457:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            // InternalDataDsl.g:1458:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalDataDsl.g:1459:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            // InternalDataDsl.g:1459:3: rule__ListType__DataFieldsAssignment_0_3
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
    // InternalDataDsl.g:1467:1: rule__ListType__Group_0__4 : rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 ;
    public final void rule__ListType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1471:1: ( rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 )
            // InternalDataDsl.g:1472:2: rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5
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
    // InternalDataDsl.g:1479:1: rule__ListType__Group_0__4__Impl : ( ( rule__ListType__Group_0_4__0 )* ) ;
    public final void rule__ListType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1483:1: ( ( ( rule__ListType__Group_0_4__0 )* ) )
            // InternalDataDsl.g:1484:1: ( ( rule__ListType__Group_0_4__0 )* )
            {
            // InternalDataDsl.g:1484:1: ( ( rule__ListType__Group_0_4__0 )* )
            // InternalDataDsl.g:1485:2: ( rule__ListType__Group_0_4__0 )*
            {
             before(grammarAccess.getListTypeAccess().getGroup_0_4()); 
            // InternalDataDsl.g:1486:2: ( rule__ListType__Group_0_4__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDataDsl.g:1486:3: rule__ListType__Group_0_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__ListType__Group_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalDataDsl.g:1494:1: rule__ListType__Group_0__5 : rule__ListType__Group_0__5__Impl ;
    public final void rule__ListType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1498:1: ( rule__ListType__Group_0__5__Impl )
            // InternalDataDsl.g:1499:2: rule__ListType__Group_0__5__Impl
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
    // InternalDataDsl.g:1505:1: rule__ListType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__ListType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1509:1: ( ( '}' ) )
            // InternalDataDsl.g:1510:1: ( '}' )
            {
            // InternalDataDsl.g:1510:1: ( '}' )
            // InternalDataDsl.g:1511:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5()); 
            match(input,19,FOLLOW_2); 
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
    // InternalDataDsl.g:1521:1: rule__ListType__Group_0_4__0 : rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 ;
    public final void rule__ListType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1525:1: ( rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 )
            // InternalDataDsl.g:1526:2: rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1
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
    // InternalDataDsl.g:1533:1: rule__ListType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__ListType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1537:1: ( ( ',' ) )
            // InternalDataDsl.g:1538:1: ( ',' )
            {
            // InternalDataDsl.g:1538:1: ( ',' )
            // InternalDataDsl.g:1539:2: ','
            {
             before(grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalDataDsl.g:1548:1: rule__ListType__Group_0_4__1 : rule__ListType__Group_0_4__1__Impl ;
    public final void rule__ListType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1552:1: ( rule__ListType__Group_0_4__1__Impl )
            // InternalDataDsl.g:1553:2: rule__ListType__Group_0_4__1__Impl
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
    // InternalDataDsl.g:1559:1: rule__ListType__Group_0_4__1__Impl : ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__ListType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1563:1: ( ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalDataDsl.g:1564:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalDataDsl.g:1564:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            // InternalDataDsl.g:1565:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalDataDsl.g:1566:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            // InternalDataDsl.g:1566:3: rule__ListType__DataFieldsAssignment_0_4_1
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
    // InternalDataDsl.g:1575:1: rule__ListType__Group_1__0 : rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 ;
    public final void rule__ListType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1579:1: ( rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 )
            // InternalDataDsl.g:1580:2: rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1
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
    // InternalDataDsl.g:1587:1: rule__ListType__Group_1__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1591:1: ( ( 'list' ) )
            // InternalDataDsl.g:1592:1: ( 'list' )
            {
            // InternalDataDsl.g:1592:1: ( 'list' )
            // InternalDataDsl.g:1593:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_1_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalDataDsl.g:1602:1: rule__ListType__Group_1__1 : rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 ;
    public final void rule__ListType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1606:1: ( rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 )
            // InternalDataDsl.g:1607:2: rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2
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
    // InternalDataDsl.g:1614:1: rule__ListType__Group_1__1__Impl : ( ( rule__ListType__NameAssignment_1_1 ) ) ;
    public final void rule__ListType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1618:1: ( ( ( rule__ListType__NameAssignment_1_1 ) ) )
            // InternalDataDsl.g:1619:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            {
            // InternalDataDsl.g:1619:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            // InternalDataDsl.g:1620:2: ( rule__ListType__NameAssignment_1_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 
            // InternalDataDsl.g:1621:2: ( rule__ListType__NameAssignment_1_1 )
            // InternalDataDsl.g:1621:3: rule__ListType__NameAssignment_1_1
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
    // InternalDataDsl.g:1629:1: rule__ListType__Group_1__2 : rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 ;
    public final void rule__ListType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1633:1: ( rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 )
            // InternalDataDsl.g:1634:2: rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3
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
    // InternalDataDsl.g:1641:1: rule__ListType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1645:1: ( ( '{' ) )
            // InternalDataDsl.g:1646:1: ( '{' )
            {
            // InternalDataDsl.g:1646:1: ( '{' )
            // InternalDataDsl.g:1647:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2()); 
            match(input,18,FOLLOW_2); 
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
    // InternalDataDsl.g:1656:1: rule__ListType__Group_1__3 : rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 ;
    public final void rule__ListType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1660:1: ( rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 )
            // InternalDataDsl.g:1661:2: rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4
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
    // InternalDataDsl.g:1668:1: rule__ListType__Group_1__3__Impl : ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__ListType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1672:1: ( ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalDataDsl.g:1673:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalDataDsl.g:1673:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            // InternalDataDsl.g:1674:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalDataDsl.g:1675:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            // InternalDataDsl.g:1675:3: rule__ListType__PrimitiveTypeAssignment_1_3
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
    // InternalDataDsl.g:1683:1: rule__ListType__Group_1__4 : rule__ListType__Group_1__4__Impl ;
    public final void rule__ListType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1687:1: ( rule__ListType__Group_1__4__Impl )
            // InternalDataDsl.g:1688:2: rule__ListType__Group_1__4__Impl
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
    // InternalDataDsl.g:1694:1: rule__ListType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__ListType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1698:1: ( ( '}' ) )
            // InternalDataDsl.g:1699:1: ( '}' )
            {
            // InternalDataDsl.g:1699:1: ( '}' )
            // InternalDataDsl.g:1700:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4()); 
            match(input,19,FOLLOW_2); 
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
    // InternalDataDsl.g:1710:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1714:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalDataDsl.g:1715:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
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
    // InternalDataDsl.g:1722:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1726:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:1727:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:1727:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalDataDsl.g:1728:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:1729:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDataDsl.g:1729:3: rule__DataField__HiddenAssignment_0
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
    // InternalDataDsl.g:1737:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1741:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalDataDsl.g:1742:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
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
    // InternalDataDsl.g:1749:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__Alternatives_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1753:1: ( ( ( rule__DataField__Alternatives_1 )? ) )
            // InternalDataDsl.g:1754:1: ( ( rule__DataField__Alternatives_1 )? )
            {
            // InternalDataDsl.g:1754:1: ( ( rule__DataField__Alternatives_1 )? )
            // InternalDataDsl.g:1755:2: ( rule__DataField__Alternatives_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_1()); 
            // InternalDataDsl.g:1756:2: ( rule__DataField__Alternatives_1 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=26 && LA20_0<=35)) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==RULE_ID||LA20_2==25||LA20_2==36) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalDataDsl.g:1756:3: rule__DataField__Alternatives_1
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
    // InternalDataDsl.g:1764:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1768:1: ( rule__DataField__Group__2__Impl )
            // InternalDataDsl.g:1769:2: rule__DataField__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group__2__Impl();

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
    // InternalDataDsl.g:1775:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__NameAssignment_2 ) ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1779:1: ( ( ( rule__DataField__NameAssignment_2 ) ) )
            // InternalDataDsl.g:1780:1: ( ( rule__DataField__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:1780:1: ( ( rule__DataField__NameAssignment_2 ) )
            // InternalDataDsl.g:1781:2: ( rule__DataField__NameAssignment_2 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:1782:2: ( rule__DataField__NameAssignment_2 )
            // InternalDataDsl.g:1782:3: rule__DataField__NameAssignment_2
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


    // $ANTLR start "rule__PossiblyImportedComplexType__Group__0"
    // InternalDataDsl.g:1791:1: rule__PossiblyImportedComplexType__Group__0 : rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 ;
    public final void rule__PossiblyImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1795:1: ( rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 )
            // InternalDataDsl.g:1796:2: rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1
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
    // InternalDataDsl.g:1803:1: rule__PossiblyImportedComplexType__Group__0__Impl : ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) ;
    public final void rule__PossiblyImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1807:1: ( ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) )
            // InternalDataDsl.g:1808:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            {
            // InternalDataDsl.g:1808:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            // InternalDataDsl.g:1809:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup_0()); 
            // InternalDataDsl.g:1810:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==25) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalDataDsl.g:1810:3: rule__PossiblyImportedComplexType__Group_0__0
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
    // InternalDataDsl.g:1818:1: rule__PossiblyImportedComplexType__Group__1 : rule__PossiblyImportedComplexType__Group__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1822:1: ( rule__PossiblyImportedComplexType__Group__1__Impl )
            // InternalDataDsl.g:1823:2: rule__PossiblyImportedComplexType__Group__1__Impl
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
    // InternalDataDsl.g:1829:1: rule__PossiblyImportedComplexType__Group__1__Impl : ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1833:1: ( ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) )
            // InternalDataDsl.g:1834:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            {
            // InternalDataDsl.g:1834:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            // InternalDataDsl.g:1835:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeAssignment_1()); 
            // InternalDataDsl.g:1836:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            // InternalDataDsl.g:1836:3: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1
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
    // InternalDataDsl.g:1845:1: rule__PossiblyImportedComplexType__Group_0__0 : rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 ;
    public final void rule__PossiblyImportedComplexType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1849:1: ( rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 )
            // InternalDataDsl.g:1850:2: rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:1857:1: rule__PossiblyImportedComplexType__Group_0__0__Impl : ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1861:1: ( ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) )
            // InternalDataDsl.g:1862:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            {
            // InternalDataDsl.g:1862:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            // InternalDataDsl.g:1863:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportAssignment_0_0()); 
            // InternalDataDsl.g:1864:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            // InternalDataDsl.g:1864:3: rule__PossiblyImportedComplexType__ImportAssignment_0_0
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
    // InternalDataDsl.g:1872:1: rule__PossiblyImportedComplexType__Group_0__1 : rule__PossiblyImportedComplexType__Group_0__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1876:1: ( rule__PossiblyImportedComplexType__Group_0__1__Impl )
            // InternalDataDsl.g:1877:2: rule__PossiblyImportedComplexType__Group_0__1__Impl
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
    // InternalDataDsl.g:1883:1: rule__PossiblyImportedComplexType__Group_0__1__Impl : ( '::' ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1887:1: ( ( '::' ) )
            // InternalDataDsl.g:1888:1: ( '::' )
            {
            // InternalDataDsl.g:1888:1: ( '::' )
            // InternalDataDsl.g:1889:2: '::'
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1()); 
            match(input,25,FOLLOW_2); 
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
    // InternalDataDsl.g:1899:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1903:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalDataDsl.g:1904:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalDataDsl.g:1911:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1915:1: ( ( () ) )
            // InternalDataDsl.g:1916:1: ( () )
            {
            // InternalDataDsl.g:1916:1: ( () )
            // InternalDataDsl.g:1917:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalDataDsl.g:1918:2: ()
            // InternalDataDsl.g:1918:3: 
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
    // InternalDataDsl.g:1926:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1930:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalDataDsl.g:1931:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalDataDsl.g:1937:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1941:1: ( ( 'boolean' ) )
            // InternalDataDsl.g:1942:1: ( 'boolean' )
            {
            // InternalDataDsl.g:1942:1: ( 'boolean' )
            // InternalDataDsl.g:1943:2: 'boolean'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalDataDsl.g:1953:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1957:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalDataDsl.g:1958:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalDataDsl.g:1965:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1969:1: ( ( () ) )
            // InternalDataDsl.g:1970:1: ( () )
            {
            // InternalDataDsl.g:1970:1: ( () )
            // InternalDataDsl.g:1971:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalDataDsl.g:1972:2: ()
            // InternalDataDsl.g:1972:3: 
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
    // InternalDataDsl.g:1980:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1984:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalDataDsl.g:1985:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalDataDsl.g:1991:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1995:1: ( ( 'byte' ) )
            // InternalDataDsl.g:1996:1: ( 'byte' )
            {
            // InternalDataDsl.g:1996:1: ( 'byte' )
            // InternalDataDsl.g:1997:2: 'byte'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 
            match(input,27,FOLLOW_2); 
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
    // InternalDataDsl.g:2007:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2011:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalDataDsl.g:2012:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDsl.g:2019:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2023:1: ( ( () ) )
            // InternalDataDsl.g:2024:1: ( () )
            {
            // InternalDataDsl.g:2024:1: ( () )
            // InternalDataDsl.g:2025:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalDataDsl.g:2026:2: ()
            // InternalDataDsl.g:2026:3: 
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
    // InternalDataDsl.g:2034:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2038:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalDataDsl.g:2039:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalDataDsl.g:2045:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2049:1: ( ( 'char' ) )
            // InternalDataDsl.g:2050:1: ( 'char' )
            {
            // InternalDataDsl.g:2050:1: ( 'char' )
            // InternalDataDsl.g:2051:2: 'char'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 
            match(input,28,FOLLOW_2); 
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
    // InternalDataDsl.g:2061:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2065:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalDataDsl.g:2066:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalDataDsl.g:2073:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2077:1: ( ( () ) )
            // InternalDataDsl.g:2078:1: ( () )
            {
            // InternalDataDsl.g:2078:1: ( () )
            // InternalDataDsl.g:2079:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalDataDsl.g:2080:2: ()
            // InternalDataDsl.g:2080:3: 
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
    // InternalDataDsl.g:2088:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2092:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalDataDsl.g:2093:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalDataDsl.g:2099:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2103:1: ( ( 'date' ) )
            // InternalDataDsl.g:2104:1: ( 'date' )
            {
            // InternalDataDsl.g:2104:1: ( 'date' )
            // InternalDataDsl.g:2105:2: 'date'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 
            match(input,29,FOLLOW_2); 
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
    // InternalDataDsl.g:2115:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2119:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalDataDsl.g:2120:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalDataDsl.g:2127:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2131:1: ( ( () ) )
            // InternalDataDsl.g:2132:1: ( () )
            {
            // InternalDataDsl.g:2132:1: ( () )
            // InternalDataDsl.g:2133:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalDataDsl.g:2134:2: ()
            // InternalDataDsl.g:2134:3: 
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
    // InternalDataDsl.g:2142:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2146:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalDataDsl.g:2147:2: rule__PrimitiveType__Group_4__1__Impl
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
    // InternalDataDsl.g:2153:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2157:1: ( ( 'double' ) )
            // InternalDataDsl.g:2158:1: ( 'double' )
            {
            // InternalDataDsl.g:2158:1: ( 'double' )
            // InternalDataDsl.g:2159:2: 'double'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalDataDsl.g:2169:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2173:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalDataDsl.g:2174:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalDataDsl.g:2181:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2185:1: ( ( () ) )
            // InternalDataDsl.g:2186:1: ( () )
            {
            // InternalDataDsl.g:2186:1: ( () )
            // InternalDataDsl.g:2187:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalDataDsl.g:2188:2: ()
            // InternalDataDsl.g:2188:3: 
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
    // InternalDataDsl.g:2196:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2200:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalDataDsl.g:2201:2: rule__PrimitiveType__Group_5__1__Impl
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
    // InternalDataDsl.g:2207:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2211:1: ( ( 'float' ) )
            // InternalDataDsl.g:2212:1: ( 'float' )
            {
            // InternalDataDsl.g:2212:1: ( 'float' )
            // InternalDataDsl.g:2213:2: 'float'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalDataDsl.g:2223:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2227:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalDataDsl.g:2228:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalDataDsl.g:2235:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2239:1: ( ( () ) )
            // InternalDataDsl.g:2240:1: ( () )
            {
            // InternalDataDsl.g:2240:1: ( () )
            // InternalDataDsl.g:2241:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalDataDsl.g:2242:2: ()
            // InternalDataDsl.g:2242:3: 
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
    // InternalDataDsl.g:2250:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2254:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalDataDsl.g:2255:2: rule__PrimitiveType__Group_6__1__Impl
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
    // InternalDataDsl.g:2261:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2265:1: ( ( 'int' ) )
            // InternalDataDsl.g:2266:1: ( 'int' )
            {
            // InternalDataDsl.g:2266:1: ( 'int' )
            // InternalDataDsl.g:2267:2: 'int'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 
            match(input,32,FOLLOW_2); 
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
    // InternalDataDsl.g:2277:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2281:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalDataDsl.g:2282:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDsl.g:2289:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2293:1: ( ( () ) )
            // InternalDataDsl.g:2294:1: ( () )
            {
            // InternalDataDsl.g:2294:1: ( () )
            // InternalDataDsl.g:2295:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalDataDsl.g:2296:2: ()
            // InternalDataDsl.g:2296:3: 
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
    // InternalDataDsl.g:2304:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2308:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalDataDsl.g:2309:2: rule__PrimitiveType__Group_7__1__Impl
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
    // InternalDataDsl.g:2315:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2319:1: ( ( 'long' ) )
            // InternalDataDsl.g:2320:1: ( 'long' )
            {
            // InternalDataDsl.g:2320:1: ( 'long' )
            // InternalDataDsl.g:2321:2: 'long'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalDataDsl.g:2331:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2335:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalDataDsl.g:2336:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDsl.g:2343:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2347:1: ( ( () ) )
            // InternalDataDsl.g:2348:1: ( () )
            {
            // InternalDataDsl.g:2348:1: ( () )
            // InternalDataDsl.g:2349:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalDataDsl.g:2350:2: ()
            // InternalDataDsl.g:2350:3: 
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
    // InternalDataDsl.g:2358:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2362:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalDataDsl.g:2363:2: rule__PrimitiveType__Group_8__1__Impl
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
    // InternalDataDsl.g:2369:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2373:1: ( ( 'short' ) )
            // InternalDataDsl.g:2374:1: ( 'short' )
            {
            // InternalDataDsl.g:2374:1: ( 'short' )
            // InternalDataDsl.g:2375:2: 'short'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 
            match(input,34,FOLLOW_2); 
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
    // InternalDataDsl.g:2385:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2389:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalDataDsl.g:2390:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
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
    // InternalDataDsl.g:2397:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2401:1: ( ( () ) )
            // InternalDataDsl.g:2402:1: ( () )
            {
            // InternalDataDsl.g:2402:1: ( () )
            // InternalDataDsl.g:2403:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalDataDsl.g:2404:2: ()
            // InternalDataDsl.g:2404:3: 
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
    // InternalDataDsl.g:2412:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2416:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalDataDsl.g:2417:2: rule__PrimitiveType__Group_9__1__Impl
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
    // InternalDataDsl.g:2423:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2427:1: ( ( 'string' ) )
            // InternalDataDsl.g:2428:1: ( 'string' )
            {
            // InternalDataDsl.g:2428:1: ( 'string' )
            // InternalDataDsl.g:2429:2: 'string'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDataDsl.g:2439:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2443:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDsl.g:2444:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDsl.g:2451:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2455:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2456:1: ( RULE_ID )
            {
            // InternalDataDsl.g:2456:1: ( RULE_ID )
            // InternalDataDsl.g:2457:2: RULE_ID
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
    // InternalDataDsl.g:2466:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2470:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDsl.g:2471:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDataDsl.g:2477:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2481:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDsl.g:2482:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDsl.g:2482:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDsl.g:2483:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDataDsl.g:2484:2: ( rule__QualifiedName__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==36) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDataDsl.g:2484:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalDataDsl.g:2493:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2497:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDsl.g:2498:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDataDsl.g:2505:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2509:1: ( ( '.' ) )
            // InternalDataDsl.g:2510:1: ( '.' )
            {
            // InternalDataDsl.g:2510:1: ( '.' )
            // InternalDataDsl.g:2511:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDataDsl.g:2520:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2524:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDsl.g:2525:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDataDsl.g:2531:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2535:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2536:1: ( RULE_ID )
            {
            // InternalDataDsl.g:2536:1: ( RULE_ID )
            // InternalDataDsl.g:2537:2: RULE_ID
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
    // InternalDataDsl.g:2547:1: rule__DataModel__ComplexTypeImportsAssignment_0 : ( ruleComplexTypeImport ) ;
    public final void rule__DataModel__ComplexTypeImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2551:1: ( ( ruleComplexTypeImport ) )
            // InternalDataDsl.g:2552:2: ( ruleComplexTypeImport )
            {
            // InternalDataDsl.g:2552:2: ( ruleComplexTypeImport )
            // InternalDataDsl.g:2553:3: ruleComplexTypeImport
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
    // InternalDataDsl.g:2562:1: rule__DataModel__VersionsAssignment_1_0 : ( ruleVersion ) ;
    public final void rule__DataModel__VersionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2566:1: ( ( ruleVersion ) )
            // InternalDataDsl.g:2567:2: ( ruleVersion )
            {
            // InternalDataDsl.g:2567:2: ( ruleVersion )
            // InternalDataDsl.g:2568:3: ruleVersion
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
    // InternalDataDsl.g:2577:1: rule__DataModel__ContextsAssignment_1_1 : ( ruleContext ) ;
    public final void rule__DataModel__ContextsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2581:1: ( ( ruleContext ) )
            // InternalDataDsl.g:2582:2: ( ruleContext )
            {
            // InternalDataDsl.g:2582:2: ( ruleContext )
            // InternalDataDsl.g:2583:3: ruleContext
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
    // InternalDataDsl.g:2592:1: rule__DataModel__ComplexTypesAssignment_1_2 : ( ruleComplexType ) ;
    public final void rule__DataModel__ComplexTypesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2596:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:2597:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:2597:2: ( ruleComplexType )
            // InternalDataDsl.g:2598:3: ruleComplexType
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
    // InternalDataDsl.g:2607:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2611:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:2612:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:2612:2: ( RULE_STRING )
            // InternalDataDsl.g:2613:3: RULE_STRING
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
    // InternalDataDsl.g:2622:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2626:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2627:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2627:2: ( RULE_ID )
            // InternalDataDsl.g:2628:3: RULE_ID
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
    // InternalDataDsl.g:2637:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2641:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2642:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2642:2: ( RULE_ID )
            // InternalDataDsl.g:2643:3: RULE_ID
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
    // InternalDataDsl.g:2652:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2656:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:2657:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:2657:2: ( ruleComplexType )
            // InternalDataDsl.g:2658:3: ruleComplexType
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
    // InternalDataDsl.g:2667:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2671:1: ( ( ruleContext ) )
            // InternalDataDsl.g:2672:2: ( ruleContext )
            {
            // InternalDataDsl.g:2672:2: ( ruleContext )
            // InternalDataDsl.g:2673:3: ruleContext
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
    // InternalDataDsl.g:2682:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2686:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2687:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2687:2: ( RULE_ID )
            // InternalDataDsl.g:2688:3: RULE_ID
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
    // InternalDataDsl.g:2697:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2701:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:2702:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:2702:2: ( ruleComplexType )
            // InternalDataDsl.g:2703:3: ruleComplexType
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
    // InternalDataDsl.g:2712:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2716:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2717:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2717:2: ( RULE_ID )
            // InternalDataDsl.g:2718:3: RULE_ID
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
    // InternalDataDsl.g:2727:1: rule__DataStructure__SuperAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2731:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:2732:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:2732:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:2733:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0()); 
            // InternalDataDsl.g:2734:3: ( ruleQualifiedName )
            // InternalDataDsl.g:2735:4: ruleQualifiedName
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


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_0"
    // InternalDataDsl.g:2746:1: rule__DataStructure__DataFieldsAssignment_4_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2750:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:2751:2: ( ruleDataField )
            {
            // InternalDataDsl.g:2751:2: ( ruleDataField )
            // InternalDataDsl.g:2752:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_0"


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_4_1_1"
    // InternalDataDsl.g:2761:1: rule__DataStructure__DataFieldsAssignment_4_1_1 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2765:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:2766:2: ( ruleDataField )
            {
            // InternalDataDsl.g:2766:2: ( ruleDataField )
            // InternalDataDsl.g:2767:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_4_1_1"


    // $ANTLR start "rule__ListType__NameAssignment_0_1"
    // InternalDataDsl.g:2776:1: rule__ListType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2780:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2781:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2781:2: ( RULE_ID )
            // InternalDataDsl.g:2782:3: RULE_ID
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
    // InternalDataDsl.g:2791:1: rule__ListType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2795:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:2796:2: ( ruleDataField )
            {
            // InternalDataDsl.g:2796:2: ( ruleDataField )
            // InternalDataDsl.g:2797:3: ruleDataField
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
    // InternalDataDsl.g:2806:1: rule__ListType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2810:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:2811:2: ( ruleDataField )
            {
            // InternalDataDsl.g:2811:2: ( ruleDataField )
            // InternalDataDsl.g:2812:3: ruleDataField
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
    // InternalDataDsl.g:2821:1: rule__ListType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2825:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2826:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2826:2: ( RULE_ID )
            // InternalDataDsl.g:2827:3: RULE_ID
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
    // InternalDataDsl.g:2836:1: rule__ListType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__ListType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2840:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:2841:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:2841:2: ( rulePrimitiveType )
            // InternalDataDsl.g:2842:3: rulePrimitiveType
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
    // InternalDataDsl.g:2851:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2855:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:2856:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:2856:2: ( ( 'hide' ) )
            // InternalDataDsl.g:2857:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:2858:3: ( 'hide' )
            // InternalDataDsl.g:2859:4: 'hide'
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalDataDsl.g:2870:1: rule__DataField__PrimitiveTypeAssignment_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2874:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:2875:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:2875:2: ( rulePrimitiveType )
            // InternalDataDsl.g:2876:3: rulePrimitiveType
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
    // InternalDataDsl.g:2885:1: rule__DataField__ComplexTypeAssignment_1_1 : ( rulePossiblyImportedComplexType ) ;
    public final void rule__DataField__ComplexTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2889:1: ( ( rulePossiblyImportedComplexType ) )
            // InternalDataDsl.g:2890:2: ( rulePossiblyImportedComplexType )
            {
            // InternalDataDsl.g:2890:2: ( rulePossiblyImportedComplexType )
            // InternalDataDsl.g:2891:3: rulePossiblyImportedComplexType
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
    // InternalDataDsl.g:2900:1: rule__DataField__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2904:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:2905:2: ( RULE_ID )
            {
            // InternalDataDsl.g:2905:2: ( RULE_ID )
            // InternalDataDsl.g:2906:3: RULE_ID
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


    // $ANTLR start "rule__PossiblyImportedComplexType__ImportAssignment_0_0"
    // InternalDataDsl.g:2915:1: rule__PossiblyImportedComplexType__ImportAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__PossiblyImportedComplexType__ImportAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2919:1: ( ( ( RULE_ID ) ) )
            // InternalDataDsl.g:2920:2: ( ( RULE_ID ) )
            {
            // InternalDataDsl.g:2920:2: ( ( RULE_ID ) )
            // InternalDataDsl.g:2921:3: ( RULE_ID )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0()); 
            // InternalDataDsl.g:2922:3: ( RULE_ID )
            // InternalDataDsl.g:2923:4: RULE_ID
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
    // InternalDataDsl.g:2934:1: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__PossiblyImportedComplexType__ComplexTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2938:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:2939:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:2939:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:2940:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeCrossReference_1_0()); 
            // InternalDataDsl.g:2941:3: ( ruleQualifiedName )
            // InternalDataDsl.g:2942:4: ruleQualifiedName
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
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\30\1\4\1\22\13\4\2\uffff";
    static final String dfa_3s = "\1\30\1\4\1\22\1\45\12\23\2\uffff";
    static final String dfa_4s = "\16\uffff\1\1\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\16\25\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\uffff\1\16",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "\1\16\16\uffff\1\17",
            "",
            ""
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
            return "431:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001320000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001380000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000002FFC080010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000FFC000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000002FFC000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000FFC000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000002L});

}