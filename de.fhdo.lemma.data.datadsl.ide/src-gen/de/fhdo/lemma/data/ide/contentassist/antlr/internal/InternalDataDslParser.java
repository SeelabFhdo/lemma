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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'service'", "'specification'", "'valueObject'", "'identifier'", "'neverEmpty'", "'part'", "'closure'", "'sideEffectFree'", "'validator'", "'import'", "'datatypes'", "'from'", "'as'", "'version'", "'{'", "'}'", "'context'", "'structure'", "'<'", "'>'", "','", "'extends'", "'list'", "'enum'", "'('", "')'", "'function'", "'::'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'hide'", "'immutable'", "'procedure'"
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
    public static final int T__62=62;
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


    // $ANTLR start "ruleDataStructureFeature"
    // InternalDataDsl.g:453:1: ruleDataStructureFeature : ( ( rule__DataStructureFeature__Alternatives ) ) ;
    public final void ruleDataStructureFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:457:1: ( ( ( rule__DataStructureFeature__Alternatives ) ) )
            // InternalDataDsl.g:458:2: ( ( rule__DataStructureFeature__Alternatives ) )
            {
            // InternalDataDsl.g:458:2: ( ( rule__DataStructureFeature__Alternatives ) )
            // InternalDataDsl.g:459:3: ( rule__DataStructureFeature__Alternatives )
            {
             before(grammarAccess.getDataStructureFeatureAccess().getAlternatives()); 
            // InternalDataDsl.g:460:3: ( rule__DataStructureFeature__Alternatives )
            // InternalDataDsl.g:460:4: rule__DataStructureFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataStructureFeature__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureFeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataStructureFeature"


    // $ANTLR start "ruleDataFieldFeature"
    // InternalDataDsl.g:469:1: ruleDataFieldFeature : ( ( rule__DataFieldFeature__Alternatives ) ) ;
    public final void ruleDataFieldFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:473:1: ( ( ( rule__DataFieldFeature__Alternatives ) ) )
            // InternalDataDsl.g:474:2: ( ( rule__DataFieldFeature__Alternatives ) )
            {
            // InternalDataDsl.g:474:2: ( ( rule__DataFieldFeature__Alternatives ) )
            // InternalDataDsl.g:475:3: ( rule__DataFieldFeature__Alternatives )
            {
             before(grammarAccess.getDataFieldFeatureAccess().getAlternatives()); 
            // InternalDataDsl.g:476:3: ( rule__DataFieldFeature__Alternatives )
            // InternalDataDsl.g:476:4: rule__DataFieldFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataFieldFeature__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldFeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataFieldFeature"


    // $ANTLR start "ruleDataOperationFeature"
    // InternalDataDsl.g:485:1: ruleDataOperationFeature : ( ( rule__DataOperationFeature__Alternatives ) ) ;
    public final void ruleDataOperationFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:489:1: ( ( ( rule__DataOperationFeature__Alternatives ) ) )
            // InternalDataDsl.g:490:2: ( ( rule__DataOperationFeature__Alternatives ) )
            {
            // InternalDataDsl.g:490:2: ( ( rule__DataOperationFeature__Alternatives ) )
            // InternalDataDsl.g:491:3: ( rule__DataOperationFeature__Alternatives )
            {
             before(grammarAccess.getDataOperationFeatureAccess().getAlternatives()); 
            // InternalDataDsl.g:492:3: ( rule__DataOperationFeature__Alternatives )
            // InternalDataDsl.g:492:4: rule__DataOperationFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataOperationFeature__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationFeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataOperationFeature"


    // $ANTLR start "rule__DataModel__Alternatives_1"
    // InternalDataDsl.g:500:1: rule__DataModel__Alternatives_1 : ( ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) ) | ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) ) | ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) ) );
    public final void rule__DataModel__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:504:1: ( ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) ) | ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) ) | ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt4=1;
                }
                break;
            case 37:
                {
                alt4=2;
                }
                break;
            case 38:
            case 43:
            case 44:
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
                    // InternalDataDsl.g:505:2: ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) )
                    {
                    // InternalDataDsl.g:505:2: ( ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* ) )
                    // InternalDataDsl.g:506:3: ( ( rule__DataModel__VersionsAssignment_1_0 ) ) ( ( rule__DataModel__VersionsAssignment_1_0 )* )
                    {
                    // InternalDataDsl.g:506:3: ( ( rule__DataModel__VersionsAssignment_1_0 ) )
                    // InternalDataDsl.g:507:4: ( rule__DataModel__VersionsAssignment_1_0 )
                    {
                     before(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 
                    // InternalDataDsl.g:508:4: ( rule__DataModel__VersionsAssignment_1_0 )
                    // InternalDataDsl.g:508:5: rule__DataModel__VersionsAssignment_1_0
                    {
                    pushFollow(FOLLOW_3);
                    rule__DataModel__VersionsAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 

                    }

                    // InternalDataDsl.g:511:3: ( ( rule__DataModel__VersionsAssignment_1_0 )* )
                    // InternalDataDsl.g:512:4: ( rule__DataModel__VersionsAssignment_1_0 )*
                    {
                     before(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0()); 
                    // InternalDataDsl.g:513:4: ( rule__DataModel__VersionsAssignment_1_0 )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==34) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalDataDsl.g:513:5: rule__DataModel__VersionsAssignment_1_0
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
                    // InternalDataDsl.g:518:2: ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) )
                    {
                    // InternalDataDsl.g:518:2: ( ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* ) )
                    // InternalDataDsl.g:519:3: ( ( rule__DataModel__ContextsAssignment_1_1 ) ) ( ( rule__DataModel__ContextsAssignment_1_1 )* )
                    {
                    // InternalDataDsl.g:519:3: ( ( rule__DataModel__ContextsAssignment_1_1 ) )
                    // InternalDataDsl.g:520:4: ( rule__DataModel__ContextsAssignment_1_1 )
                    {
                     before(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 
                    // InternalDataDsl.g:521:4: ( rule__DataModel__ContextsAssignment_1_1 )
                    // InternalDataDsl.g:521:5: rule__DataModel__ContextsAssignment_1_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__DataModel__ContextsAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 

                    }

                    // InternalDataDsl.g:524:3: ( ( rule__DataModel__ContextsAssignment_1_1 )* )
                    // InternalDataDsl.g:525:4: ( rule__DataModel__ContextsAssignment_1_1 )*
                    {
                     before(grammarAccess.getDataModelAccess().getContextsAssignment_1_1()); 
                    // InternalDataDsl.g:526:4: ( rule__DataModel__ContextsAssignment_1_1 )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==37) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalDataDsl.g:526:5: rule__DataModel__ContextsAssignment_1_1
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
                    // InternalDataDsl.g:531:2: ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) )
                    {
                    // InternalDataDsl.g:531:2: ( ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* ) )
                    // InternalDataDsl.g:532:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) ) ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* )
                    {
                    // InternalDataDsl.g:532:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 ) )
                    // InternalDataDsl.g:533:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )
                    {
                     before(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 
                    // InternalDataDsl.g:534:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )
                    // InternalDataDsl.g:534:5: rule__DataModel__ComplexTypesAssignment_1_2
                    {
                    pushFollow(FOLLOW_5);
                    rule__DataModel__ComplexTypesAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 

                    }

                    // InternalDataDsl.g:537:3: ( ( rule__DataModel__ComplexTypesAssignment_1_2 )* )
                    // InternalDataDsl.g:538:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )*
                    {
                     before(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2()); 
                    // InternalDataDsl.g:539:4: ( rule__DataModel__ComplexTypesAssignment_1_2 )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==38||(LA3_0>=43 && LA3_0<=44)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalDataDsl.g:539:5: rule__DataModel__ComplexTypesAssignment_1_2
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
    // InternalDataDsl.g:548:1: rule__Version__Alternatives_3 : ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) );
    public final void rule__Version__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:552:1: ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==38||(LA7_0>=43 && LA7_0<=44)) ) {
                alt7=1;
            }
            else if ( (LA7_0==37) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDataDsl.g:553:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    {
                    // InternalDataDsl.g:553:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    // InternalDataDsl.g:554:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    {
                    // InternalDataDsl.g:554:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) )
                    // InternalDataDsl.g:555:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalDataDsl.g:556:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    // InternalDataDsl.g:556:5: rule__Version__ComplexTypesAssignment_3_0
                    {
                    pushFollow(FOLLOW_5);
                    rule__Version__ComplexTypesAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }

                    // InternalDataDsl.g:559:3: ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    // InternalDataDsl.g:560:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalDataDsl.g:561:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==38||(LA5_0>=43 && LA5_0<=44)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalDataDsl.g:561:5: rule__Version__ComplexTypesAssignment_3_0
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
                    // InternalDataDsl.g:566:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    {
                    // InternalDataDsl.g:566:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    // InternalDataDsl.g:567:3: ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* )
                    {
                    // InternalDataDsl.g:567:3: ( ( rule__Version__ContextsAssignment_3_1 ) )
                    // InternalDataDsl.g:568:4: ( rule__Version__ContextsAssignment_3_1 )
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalDataDsl.g:569:4: ( rule__Version__ContextsAssignment_3_1 )
                    // InternalDataDsl.g:569:5: rule__Version__ContextsAssignment_3_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__Version__ContextsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 

                    }

                    // InternalDataDsl.g:572:3: ( ( rule__Version__ContextsAssignment_3_1 )* )
                    // InternalDataDsl.g:573:4: ( rule__Version__ContextsAssignment_3_1 )*
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalDataDsl.g:574:4: ( rule__Version__ContextsAssignment_3_1 )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==37) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDataDsl.g:574:5: rule__Version__ContextsAssignment_3_1
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
    // InternalDataDsl.g:583:1: rule__ComplexType__Alternatives : ( ( ruleDataStructure ) | ( ruleListType ) | ( ruleEnumeration ) );
    public final void rule__ComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:587:1: ( ( ruleDataStructure ) | ( ruleListType ) | ( ruleEnumeration ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt8=1;
                }
                break;
            case 43:
                {
                alt8=2;
                }
                break;
            case 44:
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
                    // InternalDataDsl.g:588:2: ( ruleDataStructure )
                    {
                    // InternalDataDsl.g:588:2: ( ruleDataStructure )
                    // InternalDataDsl.g:589:3: ruleDataStructure
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
                    // InternalDataDsl.g:594:2: ( ruleListType )
                    {
                    // InternalDataDsl.g:594:2: ( ruleListType )
                    // InternalDataDsl.g:595:3: ruleListType
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
                    // InternalDataDsl.g:600:2: ( ruleEnumeration )
                    {
                    // InternalDataDsl.g:600:2: ( ruleEnumeration )
                    // InternalDataDsl.g:601:3: ruleEnumeration
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


    // $ANTLR start "rule__DataStructure__Alternatives_5_0"
    // InternalDataDsl.g:610:1: rule__DataStructure__Alternatives_5_0 : ( ( ( rule__DataStructure__DataFieldsAssignment_5_0_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_5_0_1 ) ) );
    public final void rule__DataStructure__Alternatives_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:614:1: ( ( ( rule__DataStructure__DataFieldsAssignment_5_0_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_5_0_1 ) ) )
            int alt9=2;
            switch ( input.LA(1) ) {
            case 60:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_ID||(LA9_1>=49 && LA9_1<=58)||LA9_1==61) ) {
                    alt9=1;
                }
                else if ( (LA9_1==47||LA9_1==62) ) {
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
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 61:
                {
                alt9=1;
                }
                break;
            case 47:
            case 62:
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
                    // InternalDataDsl.g:615:2: ( ( rule__DataStructure__DataFieldsAssignment_5_0_0 ) )
                    {
                    // InternalDataDsl.g:615:2: ( ( rule__DataStructure__DataFieldsAssignment_5_0_0 ) )
                    // InternalDataDsl.g:616:3: ( rule__DataStructure__DataFieldsAssignment_5_0_0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_5_0_0()); 
                    // InternalDataDsl.g:617:3: ( rule__DataStructure__DataFieldsAssignment_5_0_0 )
                    // InternalDataDsl.g:617:4: rule__DataStructure__DataFieldsAssignment_5_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__DataFieldsAssignment_5_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_5_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:621:2: ( ( rule__DataStructure__OperationsAssignment_5_0_1 ) )
                    {
                    // InternalDataDsl.g:621:2: ( ( rule__DataStructure__OperationsAssignment_5_0_1 ) )
                    // InternalDataDsl.g:622:3: ( rule__DataStructure__OperationsAssignment_5_0_1 )
                    {
                     before(grammarAccess.getDataStructureAccess().getOperationsAssignment_5_0_1()); 
                    // InternalDataDsl.g:623:3: ( rule__DataStructure__OperationsAssignment_5_0_1 )
                    // InternalDataDsl.g:623:4: rule__DataStructure__OperationsAssignment_5_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__OperationsAssignment_5_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getOperationsAssignment_5_0_1()); 

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
    // $ANTLR end "rule__DataStructure__Alternatives_5_0"


    // $ANTLR start "rule__DataStructure__Alternatives_5_1_1"
    // InternalDataDsl.g:631:1: rule__DataStructure__Alternatives_5_1_1 : ( ( ( rule__DataStructure__DataFieldsAssignment_5_1_1_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_5_1_1_1 ) ) );
    public final void rule__DataStructure__Alternatives_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:635:1: ( ( ( rule__DataStructure__DataFieldsAssignment_5_1_1_0 ) ) | ( ( rule__DataStructure__OperationsAssignment_5_1_1_1 ) ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case 60:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==47||LA10_1==62) ) {
                    alt10=2;
                }
                else if ( (LA10_1==RULE_ID||(LA10_1>=49 && LA10_1<=58)||LA10_1==61) ) {
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
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 61:
                {
                alt10=1;
                }
                break;
            case 47:
            case 62:
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
                    // InternalDataDsl.g:636:2: ( ( rule__DataStructure__DataFieldsAssignment_5_1_1_0 ) )
                    {
                    // InternalDataDsl.g:636:2: ( ( rule__DataStructure__DataFieldsAssignment_5_1_1_0 ) )
                    // InternalDataDsl.g:637:3: ( rule__DataStructure__DataFieldsAssignment_5_1_1_0 )
                    {
                     before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_5_1_1_0()); 
                    // InternalDataDsl.g:638:3: ( rule__DataStructure__DataFieldsAssignment_5_1_1_0 )
                    // InternalDataDsl.g:638:4: rule__DataStructure__DataFieldsAssignment_5_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__DataFieldsAssignment_5_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_5_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:642:2: ( ( rule__DataStructure__OperationsAssignment_5_1_1_1 ) )
                    {
                    // InternalDataDsl.g:642:2: ( ( rule__DataStructure__OperationsAssignment_5_1_1_1 ) )
                    // InternalDataDsl.g:643:3: ( rule__DataStructure__OperationsAssignment_5_1_1_1 )
                    {
                     before(grammarAccess.getDataStructureAccess().getOperationsAssignment_5_1_1_1()); 
                    // InternalDataDsl.g:644:3: ( rule__DataStructure__OperationsAssignment_5_1_1_1 )
                    // InternalDataDsl.g:644:4: rule__DataStructure__OperationsAssignment_5_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__OperationsAssignment_5_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataStructureAccess().getOperationsAssignment_5_1_1_1()); 

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
    // $ANTLR end "rule__DataStructure__Alternatives_5_1_1"


    // $ANTLR start "rule__ListType__Alternatives"
    // InternalDataDsl.g:652:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );
    public final void rule__ListType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:656:1: ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalDataDsl.g:657:2: ( ( rule__ListType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:657:2: ( ( rule__ListType__Group_0__0 ) )
                    // InternalDataDsl.g:658:3: ( rule__ListType__Group_0__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:659:3: ( rule__ListType__Group_0__0 )
                    // InternalDataDsl.g:659:4: rule__ListType__Group_0__0
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
                    // InternalDataDsl.g:663:2: ( ( rule__ListType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:663:2: ( ( rule__ListType__Group_1__0 ) )
                    // InternalDataDsl.g:664:3: ( rule__ListType__Group_1__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:665:3: ( rule__ListType__Group_1__0 )
                    // InternalDataDsl.g:665:4: rule__ListType__Group_1__0
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


    // $ANTLR start "rule__DataField__Alternatives_2"
    // InternalDataDsl.g:673:1: rule__DataField__Alternatives_2 : ( ( ( rule__DataField__PrimitiveTypeAssignment_2_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_2_1 ) ) | ( ( rule__DataField__ImportedComplexTypeAssignment_2_2 ) ) );
    public final void rule__DataField__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:677:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_2_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_2_1 ) ) | ( ( rule__DataField__ImportedComplexTypeAssignment_2_2 ) ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=49 && LA12_0<=58)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==48) ) {
                    alt12=3;
                }
                else if ( (LA12_2==RULE_ID||LA12_2==59) ) {
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
                    // InternalDataDsl.g:678:2: ( ( rule__DataField__PrimitiveTypeAssignment_2_0 ) )
                    {
                    // InternalDataDsl.g:678:2: ( ( rule__DataField__PrimitiveTypeAssignment_2_0 ) )
                    // InternalDataDsl.g:679:3: ( rule__DataField__PrimitiveTypeAssignment_2_0 )
                    {
                     before(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_2_0()); 
                    // InternalDataDsl.g:680:3: ( rule__DataField__PrimitiveTypeAssignment_2_0 )
                    // InternalDataDsl.g:680:4: rule__DataField__PrimitiveTypeAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__PrimitiveTypeAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:684:2: ( ( rule__DataField__ComplexTypeAssignment_2_1 ) )
                    {
                    // InternalDataDsl.g:684:2: ( ( rule__DataField__ComplexTypeAssignment_2_1 ) )
                    // InternalDataDsl.g:685:3: ( rule__DataField__ComplexTypeAssignment_2_1 )
                    {
                     before(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_2_1()); 
                    // InternalDataDsl.g:686:3: ( rule__DataField__ComplexTypeAssignment_2_1 )
                    // InternalDataDsl.g:686:4: rule__DataField__ComplexTypeAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__ComplexTypeAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:690:2: ( ( rule__DataField__ImportedComplexTypeAssignment_2_2 ) )
                    {
                    // InternalDataDsl.g:690:2: ( ( rule__DataField__ImportedComplexTypeAssignment_2_2 ) )
                    // InternalDataDsl.g:691:3: ( rule__DataField__ImportedComplexTypeAssignment_2_2 )
                    {
                     before(grammarAccess.getDataFieldAccess().getImportedComplexTypeAssignment_2_2()); 
                    // InternalDataDsl.g:692:3: ( rule__DataField__ImportedComplexTypeAssignment_2_2 )
                    // InternalDataDsl.g:692:4: rule__DataField__ImportedComplexTypeAssignment_2_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__ImportedComplexTypeAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataFieldAccess().getImportedComplexTypeAssignment_2_2()); 

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
    // $ANTLR end "rule__DataField__Alternatives_2"


    // $ANTLR start "rule__DataOperation__Alternatives_1"
    // InternalDataDsl.g:700:1: rule__DataOperation__Alternatives_1 : ( ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) ) | ( ( rule__DataOperation__Group_1_1__0 ) ) );
    public final void rule__DataOperation__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:704:1: ( ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) ) | ( ( rule__DataOperation__Group_1_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==62) ) {
                alt13=1;
            }
            else if ( (LA13_0==47) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDsl.g:705:2: ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) )
                    {
                    // InternalDataDsl.g:705:2: ( ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 ) )
                    // InternalDataDsl.g:706:3: ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeAssignment_1_0()); 
                    // InternalDataDsl.g:707:3: ( rule__DataOperation__HasNoReturnTypeAssignment_1_0 )
                    // InternalDataDsl.g:707:4: rule__DataOperation__HasNoReturnTypeAssignment_1_0
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
                    // InternalDataDsl.g:711:2: ( ( rule__DataOperation__Group_1_1__0 ) )
                    {
                    // InternalDataDsl.g:711:2: ( ( rule__DataOperation__Group_1_1__0 ) )
                    // InternalDataDsl.g:712:3: ( rule__DataOperation__Group_1_1__0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getGroup_1_1()); 
                    // InternalDataDsl.g:713:3: ( rule__DataOperation__Group_1_1__0 )
                    // InternalDataDsl.g:713:4: rule__DataOperation__Group_1_1__0
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
    // InternalDataDsl.g:721:1: rule__DataOperation__Alternatives_1_1_1 : ( ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) ) | ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) ) | ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) ) );
    public final void rule__DataOperation__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:725:1: ( ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) ) | ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) ) | ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) ) )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=49 && LA14_0<=58)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==RULE_ID||LA14_2==59) ) {
                    alt14=2;
                }
                else if ( (LA14_2==48) ) {
                    alt14=3;
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
                    // InternalDataDsl.g:726:2: ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) )
                    {
                    // InternalDataDsl.g:726:2: ( ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 ) )
                    // InternalDataDsl.g:727:3: ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 )
                    {
                     before(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypeAssignment_1_1_1_0()); 
                    // InternalDataDsl.g:728:3: ( rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 )
                    // InternalDataDsl.g:728:4: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0
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
                    // InternalDataDsl.g:732:2: ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) )
                    {
                    // InternalDataDsl.g:732:2: ( ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 ) )
                    // InternalDataDsl.g:733:3: ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 )
                    {
                     before(grammarAccess.getDataOperationAccess().getComplexReturnTypeAssignment_1_1_1_1()); 
                    // InternalDataDsl.g:734:3: ( rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 )
                    // InternalDataDsl.g:734:4: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1
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
                    // InternalDataDsl.g:738:2: ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) )
                    {
                    // InternalDataDsl.g:738:2: ( ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 ) )
                    // InternalDataDsl.g:739:3: ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 )
                    {
                     before(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeAssignment_1_1_1_2()); 
                    // InternalDataDsl.g:740:3: ( rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 )
                    // InternalDataDsl.g:740:4: rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2
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
    // InternalDataDsl.g:748:1: rule__DataOperationParameter__Alternatives_0 : ( ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) ) | ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) ) | ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) ) );
    public final void rule__DataOperationParameter__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:752:1: ( ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) ) | ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) ) | ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=49 && LA15_0<=58)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==RULE_ID||LA15_2==59) ) {
                    alt15=2;
                }
                else if ( (LA15_2==48) ) {
                    alt15=3;
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
                    // InternalDataDsl.g:753:2: ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) )
                    {
                    // InternalDataDsl.g:753:2: ( ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 ) )
                    // InternalDataDsl.g:754:3: ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypeAssignment_0_0()); 
                    // InternalDataDsl.g:755:3: ( rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 )
                    // InternalDataDsl.g:755:4: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0
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
                    // InternalDataDsl.g:759:2: ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) )
                    {
                    // InternalDataDsl.g:759:2: ( ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 ) )
                    // InternalDataDsl.g:760:3: ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getComplexTypeAssignment_0_1()); 
                    // InternalDataDsl.g:761:3: ( rule__DataOperationParameter__ComplexTypeAssignment_0_1 )
                    // InternalDataDsl.g:761:4: rule__DataOperationParameter__ComplexTypeAssignment_0_1
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
                    // InternalDataDsl.g:765:2: ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) )
                    {
                    // InternalDataDsl.g:765:2: ( ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 ) )
                    // InternalDataDsl.g:766:3: ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 )
                    {
                     before(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeAssignment_0_2()); 
                    // InternalDataDsl.g:767:3: ( rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 )
                    // InternalDataDsl.g:767:4: rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2
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
    // InternalDataDsl.g:775:1: rule__PrimitiveValue__Alternatives : ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) );
    public final void rule__PrimitiveValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:779:1: ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) )
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
                    // InternalDataDsl.g:780:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    {
                    // InternalDataDsl.g:780:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    // InternalDataDsl.g:781:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0()); 
                    // InternalDataDsl.g:782:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    // InternalDataDsl.g:782:4: rule__PrimitiveValue__NumericValueAssignment_0
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
                    // InternalDataDsl.g:786:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    {
                    // InternalDataDsl.g:786:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    // InternalDataDsl.g:787:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1()); 
                    // InternalDataDsl.g:788:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    // InternalDataDsl.g:788:4: rule__PrimitiveValue__BooleanValueAssignment_1
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
                    // InternalDataDsl.g:792:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    {
                    // InternalDataDsl.g:792:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    // InternalDataDsl.g:793:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2()); 
                    // InternalDataDsl.g:794:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    // InternalDataDsl.g:794:4: rule__PrimitiveValue__StringValueAssignment_2
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
    // InternalDataDsl.g:802:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:806:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) )
            int alt17=10;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt17=1;
                }
                break;
            case 50:
                {
                alt17=2;
                }
                break;
            case 51:
                {
                alt17=3;
                }
                break;
            case 52:
                {
                alt17=4;
                }
                break;
            case 53:
                {
                alt17=5;
                }
                break;
            case 54:
                {
                alt17=6;
                }
                break;
            case 55:
                {
                alt17=7;
                }
                break;
            case 56:
                {
                alt17=8;
                }
                break;
            case 57:
                {
                alt17=9;
                }
                break;
            case 58:
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
                    // InternalDataDsl.g:807:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:807:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalDataDsl.g:808:3: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:809:3: ( rule__PrimitiveType__Group_0__0 )
                    // InternalDataDsl.g:809:4: rule__PrimitiveType__Group_0__0
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
                    // InternalDataDsl.g:813:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:813:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalDataDsl.g:814:3: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:815:3: ( rule__PrimitiveType__Group_1__0 )
                    // InternalDataDsl.g:815:4: rule__PrimitiveType__Group_1__0
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
                    // InternalDataDsl.g:819:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalDataDsl.g:819:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalDataDsl.g:820:3: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalDataDsl.g:821:3: ( rule__PrimitiveType__Group_2__0 )
                    // InternalDataDsl.g:821:4: rule__PrimitiveType__Group_2__0
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
                    // InternalDataDsl.g:825:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalDataDsl.g:825:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalDataDsl.g:826:3: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalDataDsl.g:827:3: ( rule__PrimitiveType__Group_3__0 )
                    // InternalDataDsl.g:827:4: rule__PrimitiveType__Group_3__0
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
                    // InternalDataDsl.g:831:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    {
                    // InternalDataDsl.g:831:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    // InternalDataDsl.g:832:3: ( rule__PrimitiveType__Group_4__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 
                    // InternalDataDsl.g:833:3: ( rule__PrimitiveType__Group_4__0 )
                    // InternalDataDsl.g:833:4: rule__PrimitiveType__Group_4__0
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
                    // InternalDataDsl.g:837:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    {
                    // InternalDataDsl.g:837:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    // InternalDataDsl.g:838:3: ( rule__PrimitiveType__Group_5__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 
                    // InternalDataDsl.g:839:3: ( rule__PrimitiveType__Group_5__0 )
                    // InternalDataDsl.g:839:4: rule__PrimitiveType__Group_5__0
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
                    // InternalDataDsl.g:843:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    {
                    // InternalDataDsl.g:843:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    // InternalDataDsl.g:844:3: ( rule__PrimitiveType__Group_6__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 
                    // InternalDataDsl.g:845:3: ( rule__PrimitiveType__Group_6__0 )
                    // InternalDataDsl.g:845:4: rule__PrimitiveType__Group_6__0
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
                    // InternalDataDsl.g:849:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    {
                    // InternalDataDsl.g:849:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    // InternalDataDsl.g:850:3: ( rule__PrimitiveType__Group_7__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 
                    // InternalDataDsl.g:851:3: ( rule__PrimitiveType__Group_7__0 )
                    // InternalDataDsl.g:851:4: rule__PrimitiveType__Group_7__0
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
                    // InternalDataDsl.g:855:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    {
                    // InternalDataDsl.g:855:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    // InternalDataDsl.g:856:3: ( rule__PrimitiveType__Group_8__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 
                    // InternalDataDsl.g:857:3: ( rule__PrimitiveType__Group_8__0 )
                    // InternalDataDsl.g:857:4: rule__PrimitiveType__Group_8__0
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
                    // InternalDataDsl.g:861:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    {
                    // InternalDataDsl.g:861:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    // InternalDataDsl.g:862:3: ( rule__PrimitiveType__Group_9__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 
                    // InternalDataDsl.g:863:3: ( rule__PrimitiveType__Group_9__0 )
                    // InternalDataDsl.g:863:4: rule__PrimitiveType__Group_9__0
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


    // $ANTLR start "rule__DataStructureFeature__Alternatives"
    // InternalDataDsl.g:871:1: rule__DataStructureFeature__Alternatives : ( ( ( 'aggregate' ) ) | ( ( 'applicationService' ) ) | ( ( 'domainEvent' ) ) | ( ( 'domainService' ) ) | ( ( 'entity' ) ) | ( ( 'factory' ) ) | ( ( 'infrastructureService' ) ) | ( ( 'repository' ) ) | ( ( 'service' ) ) | ( ( 'specification' ) ) | ( ( 'valueObject' ) ) );
    public final void rule__DataStructureFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:875:1: ( ( ( 'aggregate' ) ) | ( ( 'applicationService' ) ) | ( ( 'domainEvent' ) ) | ( ( 'domainService' ) ) | ( ( 'entity' ) ) | ( ( 'factory' ) ) | ( ( 'infrastructureService' ) ) | ( ( 'repository' ) ) | ( ( 'service' ) ) | ( ( 'specification' ) ) | ( ( 'valueObject' ) ) )
            int alt18=11;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt18=1;
                }
                break;
            case 14:
                {
                alt18=2;
                }
                break;
            case 15:
                {
                alt18=3;
                }
                break;
            case 16:
                {
                alt18=4;
                }
                break;
            case 17:
                {
                alt18=5;
                }
                break;
            case 18:
                {
                alt18=6;
                }
                break;
            case 19:
                {
                alt18=7;
                }
                break;
            case 20:
                {
                alt18=8;
                }
                break;
            case 21:
                {
                alt18=9;
                }
                break;
            case 22:
                {
                alt18=10;
                }
                break;
            case 23:
                {
                alt18=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalDataDsl.g:876:2: ( ( 'aggregate' ) )
                    {
                    // InternalDataDsl.g:876:2: ( ( 'aggregate' ) )
                    // InternalDataDsl.g:877:3: ( 'aggregate' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0()); 
                    // InternalDataDsl.g:878:3: ( 'aggregate' )
                    // InternalDataDsl.g:878:4: 'aggregate'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:882:2: ( ( 'applicationService' ) )
                    {
                    // InternalDataDsl.g:882:2: ( ( 'applicationService' ) )
                    // InternalDataDsl.g:883:3: ( 'applicationService' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1()); 
                    // InternalDataDsl.g:884:3: ( 'applicationService' )
                    // InternalDataDsl.g:884:4: 'applicationService'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:888:2: ( ( 'domainEvent' ) )
                    {
                    // InternalDataDsl.g:888:2: ( ( 'domainEvent' ) )
                    // InternalDataDsl.g:889:3: ( 'domainEvent' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2()); 
                    // InternalDataDsl.g:890:3: ( 'domainEvent' )
                    // InternalDataDsl.g:890:4: 'domainEvent'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:894:2: ( ( 'domainService' ) )
                    {
                    // InternalDataDsl.g:894:2: ( ( 'domainService' ) )
                    // InternalDataDsl.g:895:3: ( 'domainService' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3()); 
                    // InternalDataDsl.g:896:3: ( 'domainService' )
                    // InternalDataDsl.g:896:4: 'domainService'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDsl.g:900:2: ( ( 'entity' ) )
                    {
                    // InternalDataDsl.g:900:2: ( ( 'entity' ) )
                    // InternalDataDsl.g:901:3: ( 'entity' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getENTITYEnumLiteralDeclaration_4()); 
                    // InternalDataDsl.g:902:3: ( 'entity' )
                    // InternalDataDsl.g:902:4: 'entity'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getENTITYEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDsl.g:906:2: ( ( 'factory' ) )
                    {
                    // InternalDataDsl.g:906:2: ( ( 'factory' ) )
                    // InternalDataDsl.g:907:3: ( 'factory' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getFACTORYEnumLiteralDeclaration_5()); 
                    // InternalDataDsl.g:908:3: ( 'factory' )
                    // InternalDataDsl.g:908:4: 'factory'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getFACTORYEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDsl.g:912:2: ( ( 'infrastructureService' ) )
                    {
                    // InternalDataDsl.g:912:2: ( ( 'infrastructureService' ) )
                    // InternalDataDsl.g:913:3: ( 'infrastructureService' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6()); 
                    // InternalDataDsl.g:914:3: ( 'infrastructureService' )
                    // InternalDataDsl.g:914:4: 'infrastructureService'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDsl.g:918:2: ( ( 'repository' ) )
                    {
                    // InternalDataDsl.g:918:2: ( ( 'repository' ) )
                    // InternalDataDsl.g:919:3: ( 'repository' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7()); 
                    // InternalDataDsl.g:920:3: ( 'repository' )
                    // InternalDataDsl.g:920:4: 'repository'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDsl.g:924:2: ( ( 'service' ) )
                    {
                    // InternalDataDsl.g:924:2: ( ( 'service' ) )
                    // InternalDataDsl.g:925:3: ( 'service' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getSERVICEEnumLiteralDeclaration_8()); 
                    // InternalDataDsl.g:926:3: ( 'service' )
                    // InternalDataDsl.g:926:4: 'service'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getSERVICEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDsl.g:930:2: ( ( 'specification' ) )
                    {
                    // InternalDataDsl.g:930:2: ( ( 'specification' ) )
                    // InternalDataDsl.g:931:3: ( 'specification' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9()); 
                    // InternalDataDsl.g:932:3: ( 'specification' )
                    // InternalDataDsl.g:932:4: 'specification'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDsl.g:936:2: ( ( 'valueObject' ) )
                    {
                    // InternalDataDsl.g:936:2: ( ( 'valueObject' ) )
                    // InternalDataDsl.g:937:3: ( 'valueObject' )
                    {
                     before(grammarAccess.getDataStructureFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10()); 
                    // InternalDataDsl.g:938:3: ( 'valueObject' )
                    // InternalDataDsl.g:938:4: 'valueObject'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataStructureFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10()); 

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
    // $ANTLR end "rule__DataStructureFeature__Alternatives"


    // $ANTLR start "rule__DataFieldFeature__Alternatives"
    // InternalDataDsl.g:946:1: rule__DataFieldFeature__Alternatives : ( ( ( 'identifier' ) ) | ( ( 'neverEmpty' ) ) | ( ( 'part' ) ) );
    public final void rule__DataFieldFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:950:1: ( ( ( 'identifier' ) ) | ( ( 'neverEmpty' ) ) | ( ( 'part' ) ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt19=1;
                }
                break;
            case 25:
                {
                alt19=2;
                }
                break;
            case 26:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalDataDsl.g:951:2: ( ( 'identifier' ) )
                    {
                    // InternalDataDsl.g:951:2: ( ( 'identifier' ) )
                    // InternalDataDsl.g:952:3: ( 'identifier' )
                    {
                     before(grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0()); 
                    // InternalDataDsl.g:953:3: ( 'identifier' )
                    // InternalDataDsl.g:953:4: 'identifier'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:957:2: ( ( 'neverEmpty' ) )
                    {
                    // InternalDataDsl.g:957:2: ( ( 'neverEmpty' ) )
                    // InternalDataDsl.g:958:3: ( 'neverEmpty' )
                    {
                     before(grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1()); 
                    // InternalDataDsl.g:959:3: ( 'neverEmpty' )
                    // InternalDataDsl.g:959:4: 'neverEmpty'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:963:2: ( ( 'part' ) )
                    {
                    // InternalDataDsl.g:963:2: ( ( 'part' ) )
                    // InternalDataDsl.g:964:3: ( 'part' )
                    {
                     before(grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_2()); 
                    // InternalDataDsl.g:965:3: ( 'part' )
                    // InternalDataDsl.g:965:4: 'part'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__DataFieldFeature__Alternatives"


    // $ANTLR start "rule__DataOperationFeature__Alternatives"
    // InternalDataDsl.g:973:1: rule__DataOperationFeature__Alternatives : ( ( ( 'closure' ) ) | ( ( 'identifier' ) ) | ( ( 'sideEffectFree' ) ) | ( ( 'validator' ) ) );
    public final void rule__DataOperationFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:977:1: ( ( ( 'closure' ) ) | ( ( 'identifier' ) ) | ( ( 'sideEffectFree' ) ) | ( ( 'validator' ) ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt20=1;
                }
                break;
            case 24:
                {
                alt20=2;
                }
                break;
            case 28:
                {
                alt20=3;
                }
                break;
            case 29:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalDataDsl.g:978:2: ( ( 'closure' ) )
                    {
                    // InternalDataDsl.g:978:2: ( ( 'closure' ) )
                    // InternalDataDsl.g:979:3: ( 'closure' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0()); 
                    // InternalDataDsl.g:980:3: ( 'closure' )
                    // InternalDataDsl.g:980:4: 'closure'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:984:2: ( ( 'identifier' ) )
                    {
                    // InternalDataDsl.g:984:2: ( ( 'identifier' ) )
                    // InternalDataDsl.g:985:3: ( 'identifier' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1()); 
                    // InternalDataDsl.g:986:3: ( 'identifier' )
                    // InternalDataDsl.g:986:4: 'identifier'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:990:2: ( ( 'sideEffectFree' ) )
                    {
                    // InternalDataDsl.g:990:2: ( ( 'sideEffectFree' ) )
                    // InternalDataDsl.g:991:3: ( 'sideEffectFree' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2()); 
                    // InternalDataDsl.g:992:3: ( 'sideEffectFree' )
                    // InternalDataDsl.g:992:4: 'sideEffectFree'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:996:2: ( ( 'validator' ) )
                    {
                    // InternalDataDsl.g:996:2: ( ( 'validator' ) )
                    // InternalDataDsl.g:997:3: ( 'validator' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getVALIDATOREnumLiteralDeclaration_3()); 
                    // InternalDataDsl.g:998:3: ( 'validator' )
                    // InternalDataDsl.g:998:4: 'validator'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getVALIDATOREnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__DataOperationFeature__Alternatives"


    // $ANTLR start "rule__DataModel__Group__0"
    // InternalDataDsl.g:1006:1: rule__DataModel__Group__0 : rule__DataModel__Group__0__Impl rule__DataModel__Group__1 ;
    public final void rule__DataModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1010:1: ( rule__DataModel__Group__0__Impl rule__DataModel__Group__1 )
            // InternalDataDsl.g:1011:2: rule__DataModel__Group__0__Impl rule__DataModel__Group__1
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
    // InternalDataDsl.g:1018:1: rule__DataModel__Group__0__Impl : ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) ;
    public final void rule__DataModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1022:1: ( ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) )
            // InternalDataDsl.g:1023:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            {
            // InternalDataDsl.g:1023:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            // InternalDataDsl.g:1024:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            {
             before(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0()); 
            // InternalDataDsl.g:1025:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDataDsl.g:1025:3: rule__DataModel__ComplexTypeImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__DataModel__ComplexTypeImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalDataDsl.g:1033:1: rule__DataModel__Group__1 : rule__DataModel__Group__1__Impl ;
    public final void rule__DataModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1037:1: ( rule__DataModel__Group__1__Impl )
            // InternalDataDsl.g:1038:2: rule__DataModel__Group__1__Impl
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
    // InternalDataDsl.g:1044:1: rule__DataModel__Group__1__Impl : ( ( rule__DataModel__Alternatives_1 ) ) ;
    public final void rule__DataModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1048:1: ( ( ( rule__DataModel__Alternatives_1 ) ) )
            // InternalDataDsl.g:1049:1: ( ( rule__DataModel__Alternatives_1 ) )
            {
            // InternalDataDsl.g:1049:1: ( ( rule__DataModel__Alternatives_1 ) )
            // InternalDataDsl.g:1050:2: ( rule__DataModel__Alternatives_1 )
            {
             before(grammarAccess.getDataModelAccess().getAlternatives_1()); 
            // InternalDataDsl.g:1051:2: ( rule__DataModel__Alternatives_1 )
            // InternalDataDsl.g:1051:3: rule__DataModel__Alternatives_1
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
    // InternalDataDsl.g:1060:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1064:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalDataDsl.g:1065:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
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
    // InternalDataDsl.g:1072:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1076:1: ( ( 'import' ) )
            // InternalDataDsl.g:1077:1: ( 'import' )
            {
            // InternalDataDsl.g:1077:1: ( 'import' )
            // InternalDataDsl.g:1078:2: 'import'
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportKeyword_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalDataDsl.g:1087:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1091:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalDataDsl.g:1092:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
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
    // InternalDataDsl.g:1099:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1103:1: ( ( 'datatypes' ) )
            // InternalDataDsl.g:1104:1: ( 'datatypes' )
            {
            // InternalDataDsl.g:1104:1: ( 'datatypes' )
            // InternalDataDsl.g:1105:2: 'datatypes'
            {
             before(grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalDataDsl.g:1114:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1118:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalDataDsl.g:1119:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
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
    // InternalDataDsl.g:1126:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1130:1: ( ( 'from' ) )
            // InternalDataDsl.g:1131:1: ( 'from' )
            {
            // InternalDataDsl.g:1131:1: ( 'from' )
            // InternalDataDsl.g:1132:2: 'from'
            {
             before(grammarAccess.getComplexTypeImportAccess().getFromKeyword_2()); 
            match(input,32,FOLLOW_2); 
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
    // InternalDataDsl.g:1141:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1145:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalDataDsl.g:1146:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
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
    // InternalDataDsl.g:1153:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1157:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalDataDsl.g:1158:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalDataDsl.g:1158:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalDataDsl.g:1159:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalDataDsl.g:1160:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalDataDsl.g:1160:3: rule__ComplexTypeImport__ImportURIAssignment_3
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
    // InternalDataDsl.g:1168:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1172:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalDataDsl.g:1173:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
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
    // InternalDataDsl.g:1180:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1184:1: ( ( 'as' ) )
            // InternalDataDsl.g:1185:1: ( 'as' )
            {
            // InternalDataDsl.g:1185:1: ( 'as' )
            // InternalDataDsl.g:1186:2: 'as'
            {
             before(grammarAccess.getComplexTypeImportAccess().getAsKeyword_4()); 
            match(input,33,FOLLOW_2); 
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
    // InternalDataDsl.g:1195:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1199:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalDataDsl.g:1200:2: rule__ComplexTypeImport__Group__5__Impl
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
    // InternalDataDsl.g:1206:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1210:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalDataDsl.g:1211:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalDataDsl.g:1211:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalDataDsl.g:1212:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalDataDsl.g:1213:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalDataDsl.g:1213:3: rule__ComplexTypeImport__NameAssignment_5
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
    // InternalDataDsl.g:1222:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1226:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalDataDsl.g:1227:2: rule__Version__Group__0__Impl rule__Version__Group__1
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
    // InternalDataDsl.g:1234:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1238:1: ( ( 'version' ) )
            // InternalDataDsl.g:1239:1: ( 'version' )
            {
            // InternalDataDsl.g:1239:1: ( 'version' )
            // InternalDataDsl.g:1240:2: 'version'
            {
             before(grammarAccess.getVersionAccess().getVersionKeyword_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalDataDsl.g:1249:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1253:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalDataDsl.g:1254:2: rule__Version__Group__1__Impl rule__Version__Group__2
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
    // InternalDataDsl.g:1261:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1265:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1266:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1266:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalDataDsl.g:1267:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1268:2: ( rule__Version__NameAssignment_1 )
            // InternalDataDsl.g:1268:3: rule__Version__NameAssignment_1
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
    // InternalDataDsl.g:1276:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1280:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalDataDsl.g:1281:2: rule__Version__Group__2__Impl rule__Version__Group__3
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
    // InternalDataDsl.g:1288:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1292:1: ( ( '{' ) )
            // InternalDataDsl.g:1293:1: ( '{' )
            {
            // InternalDataDsl.g:1293:1: ( '{' )
            // InternalDataDsl.g:1294:2: '{'
            {
             before(grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDataDsl.g:1303:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1307:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalDataDsl.g:1308:2: rule__Version__Group__3__Impl rule__Version__Group__4
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
    // InternalDataDsl.g:1315:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1319:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalDataDsl.g:1320:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalDataDsl.g:1320:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalDataDsl.g:1321:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalDataDsl.g:1322:2: ( rule__Version__Alternatives_3 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=37 && LA22_0<=38)||(LA22_0>=43 && LA22_0<=44)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDsl.g:1322:3: rule__Version__Alternatives_3
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
    // InternalDataDsl.g:1330:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1334:1: ( rule__Version__Group__4__Impl )
            // InternalDataDsl.g:1335:2: rule__Version__Group__4__Impl
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
    // InternalDataDsl.g:1341:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1345:1: ( ( '}' ) )
            // InternalDataDsl.g:1346:1: ( '}' )
            {
            // InternalDataDsl.g:1346:1: ( '}' )
            // InternalDataDsl.g:1347:2: '}'
            {
             before(grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDataDsl.g:1357:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1361:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalDataDsl.g:1362:2: rule__Context__Group__0__Impl rule__Context__Group__1
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
    // InternalDataDsl.g:1369:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1373:1: ( ( 'context' ) )
            // InternalDataDsl.g:1374:1: ( 'context' )
            {
            // InternalDataDsl.g:1374:1: ( 'context' )
            // InternalDataDsl.g:1375:2: 'context'
            {
             before(grammarAccess.getContextAccess().getContextKeyword_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalDataDsl.g:1384:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1388:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalDataDsl.g:1389:2: rule__Context__Group__1__Impl rule__Context__Group__2
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
    // InternalDataDsl.g:1396:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1400:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1401:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1401:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalDataDsl.g:1402:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1403:2: ( rule__Context__NameAssignment_1 )
            // InternalDataDsl.g:1403:3: rule__Context__NameAssignment_1
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
    // InternalDataDsl.g:1411:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1415:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalDataDsl.g:1416:2: rule__Context__Group__2__Impl rule__Context__Group__3
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
    // InternalDataDsl.g:1423:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1427:1: ( ( '{' ) )
            // InternalDataDsl.g:1428:1: ( '{' )
            {
            // InternalDataDsl.g:1428:1: ( '{' )
            // InternalDataDsl.g:1429:2: '{'
            {
             before(grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDataDsl.g:1438:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1442:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalDataDsl.g:1443:2: rule__Context__Group__3__Impl rule__Context__Group__4
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
    // InternalDataDsl.g:1450:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1454:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalDataDsl.g:1455:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalDataDsl.g:1455:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalDataDsl.g:1456:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalDataDsl.g:1456:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalDataDsl.g:1457:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1458:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalDataDsl.g:1458:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_5);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalDataDsl.g:1461:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalDataDsl.g:1462:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1463:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==38||(LA23_0>=43 && LA23_0<=44)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDsl.g:1463:4: rule__Context__ComplexTypesAssignment_3
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Context__ComplexTypesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalDataDsl.g:1472:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1476:1: ( rule__Context__Group__4__Impl )
            // InternalDataDsl.g:1477:2: rule__Context__Group__4__Impl
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
    // InternalDataDsl.g:1483:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1487:1: ( ( '}' ) )
            // InternalDataDsl.g:1488:1: ( '}' )
            {
            // InternalDataDsl.g:1488:1: ( '}' )
            // InternalDataDsl.g:1489:2: '}'
            {
             before(grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDataDsl.g:1499:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1503:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalDataDsl.g:1504:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
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
    // InternalDataDsl.g:1511:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1515:1: ( ( 'structure' ) )
            // InternalDataDsl.g:1516:1: ( 'structure' )
            {
            // InternalDataDsl.g:1516:1: ( 'structure' )
            // InternalDataDsl.g:1517:2: 'structure'
            {
             before(grammarAccess.getDataStructureAccess().getStructureKeyword_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalDataDsl.g:1526:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1530:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalDataDsl.g:1531:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
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
    // InternalDataDsl.g:1538:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1542:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1543:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1543:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalDataDsl.g:1544:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1545:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalDataDsl.g:1545:3: rule__DataStructure__NameAssignment_1
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
    // InternalDataDsl.g:1553:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1557:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalDataDsl.g:1558:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
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
    // InternalDataDsl.g:1565:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1569:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalDataDsl.g:1570:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalDataDsl.g:1570:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalDataDsl.g:1571:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalDataDsl.g:1572:2: ( rule__DataStructure__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDsl.g:1572:3: rule__DataStructure__Group_2__0
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
    // InternalDataDsl.g:1580:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1584:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalDataDsl.g:1585:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
            {
            pushFollow(FOLLOW_17);
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
    // InternalDataDsl.g:1592:1: rule__DataStructure__Group__3__Impl : ( ( rule__DataStructure__Group_3__0 )? ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1596:1: ( ( ( rule__DataStructure__Group_3__0 )? ) )
            // InternalDataDsl.g:1597:1: ( ( rule__DataStructure__Group_3__0 )? )
            {
            // InternalDataDsl.g:1597:1: ( ( rule__DataStructure__Group_3__0 )? )
            // InternalDataDsl.g:1598:2: ( rule__DataStructure__Group_3__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_3()); 
            // InternalDataDsl.g:1599:2: ( rule__DataStructure__Group_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDsl.g:1599:3: rule__DataStructure__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStructureAccess().getGroup_3()); 

            }


            }

        }
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
    // InternalDataDsl.g:1607:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1611:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalDataDsl.g:1612:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
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
    // InternalDataDsl.g:1619:1: rule__DataStructure__Group__4__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1623:1: ( ( '{' ) )
            // InternalDataDsl.g:1624:1: ( '{' )
            {
            // InternalDataDsl.g:1624:1: ( '{' )
            // InternalDataDsl.g:1625:2: '{'
            {
             before(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
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
    // InternalDataDsl.g:1634:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl rule__DataStructure__Group__6 ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1638:1: ( rule__DataStructure__Group__5__Impl rule__DataStructure__Group__6 )
            // InternalDataDsl.g:1639:2: rule__DataStructure__Group__5__Impl rule__DataStructure__Group__6
            {
            pushFollow(FOLLOW_18);
            rule__DataStructure__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__6();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:1646:1: rule__DataStructure__Group__5__Impl : ( ( rule__DataStructure__Group_5__0 )? ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1650:1: ( ( ( rule__DataStructure__Group_5__0 )? ) )
            // InternalDataDsl.g:1651:1: ( ( rule__DataStructure__Group_5__0 )? )
            {
            // InternalDataDsl.g:1651:1: ( ( rule__DataStructure__Group_5__0 )? )
            // InternalDataDsl.g:1652:2: ( rule__DataStructure__Group_5__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_5()); 
            // InternalDataDsl.g:1653:2: ( rule__DataStructure__Group_5__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||LA26_0==47||(LA26_0>=49 && LA26_0<=58)||(LA26_0>=60 && LA26_0<=62)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDsl.g:1653:3: rule__DataStructure__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStructure__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStructureAccess().getGroup_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__DataStructure__Group__6"
    // InternalDataDsl.g:1661:1: rule__DataStructure__Group__6 : rule__DataStructure__Group__6__Impl ;
    public final void rule__DataStructure__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1665:1: ( rule__DataStructure__Group__6__Impl )
            // InternalDataDsl.g:1666:2: rule__DataStructure__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__6"


    // $ANTLR start "rule__DataStructure__Group__6__Impl"
    // InternalDataDsl.g:1672:1: rule__DataStructure__Group__6__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1676:1: ( ( '}' ) )
            // InternalDataDsl.g:1677:1: ( '}' )
            {
            // InternalDataDsl.g:1677:1: ( '}' )
            // InternalDataDsl.g:1678:2: '}'
            {
             before(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_6()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group__6__Impl"


    // $ANTLR start "rule__DataStructure__Group_2__0"
    // InternalDataDsl.g:1688:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1692:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalDataDsl.g:1693:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
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
    // InternalDataDsl.g:1700:1: rule__DataStructure__Group_2__0__Impl : ( '<' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1704:1: ( ( '<' ) )
            // InternalDataDsl.g:1705:1: ( '<' )
            {
            // InternalDataDsl.g:1705:1: ( '<' )
            // InternalDataDsl.g:1706:2: '<'
            {
             before(grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getLessThanSignKeyword_2_0()); 

            }


            }

        }
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
    // InternalDataDsl.g:1715:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl rule__DataStructure__Group_2__2 ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1719:1: ( rule__DataStructure__Group_2__1__Impl rule__DataStructure__Group_2__2 )
            // InternalDataDsl.g:1720:2: rule__DataStructure__Group_2__1__Impl rule__DataStructure__Group_2__2
            {
            pushFollow(FOLLOW_20);
            rule__DataStructure__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2__2();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:1727:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__FeaturesAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1731:1: ( ( ( rule__DataStructure__FeaturesAssignment_2_1 ) ) )
            // InternalDataDsl.g:1732:1: ( ( rule__DataStructure__FeaturesAssignment_2_1 ) )
            {
            // InternalDataDsl.g:1732:1: ( ( rule__DataStructure__FeaturesAssignment_2_1 ) )
            // InternalDataDsl.g:1733:2: ( rule__DataStructure__FeaturesAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_1()); 
            // InternalDataDsl.g:1734:2: ( rule__DataStructure__FeaturesAssignment_2_1 )
            // InternalDataDsl.g:1734:3: rule__DataStructure__FeaturesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__FeaturesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__DataStructure__Group_2__2"
    // InternalDataDsl.g:1742:1: rule__DataStructure__Group_2__2 : rule__DataStructure__Group_2__2__Impl rule__DataStructure__Group_2__3 ;
    public final void rule__DataStructure__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1746:1: ( rule__DataStructure__Group_2__2__Impl rule__DataStructure__Group_2__3 )
            // InternalDataDsl.g:1747:2: rule__DataStructure__Group_2__2__Impl rule__DataStructure__Group_2__3
            {
            pushFollow(FOLLOW_20);
            rule__DataStructure__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__2"


    // $ANTLR start "rule__DataStructure__Group_2__2__Impl"
    // InternalDataDsl.g:1754:1: rule__DataStructure__Group_2__2__Impl : ( ( rule__DataStructure__Group_2_2__0 )* ) ;
    public final void rule__DataStructure__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1758:1: ( ( ( rule__DataStructure__Group_2_2__0 )* ) )
            // InternalDataDsl.g:1759:1: ( ( rule__DataStructure__Group_2_2__0 )* )
            {
            // InternalDataDsl.g:1759:1: ( ( rule__DataStructure__Group_2_2__0 )* )
            // InternalDataDsl.g:1760:2: ( rule__DataStructure__Group_2_2__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2_2()); 
            // InternalDataDsl.g:1761:2: ( rule__DataStructure__Group_2_2__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDataDsl.g:1761:3: rule__DataStructure__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__2__Impl"


    // $ANTLR start "rule__DataStructure__Group_2__3"
    // InternalDataDsl.g:1769:1: rule__DataStructure__Group_2__3 : rule__DataStructure__Group_2__3__Impl ;
    public final void rule__DataStructure__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1773:1: ( rule__DataStructure__Group_2__3__Impl )
            // InternalDataDsl.g:1774:2: rule__DataStructure__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__3"


    // $ANTLR start "rule__DataStructure__Group_2__3__Impl"
    // InternalDataDsl.g:1780:1: rule__DataStructure__Group_2__3__Impl : ( '>' ) ;
    public final void rule__DataStructure__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1784:1: ( ( '>' ) )
            // InternalDataDsl.g:1785:1: ( '>' )
            {
            // InternalDataDsl.g:1785:1: ( '>' )
            // InternalDataDsl.g:1786:2: '>'
            {
             before(grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getGreaterThanSignKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2__3__Impl"


    // $ANTLR start "rule__DataStructure__Group_2_2__0"
    // InternalDataDsl.g:1796:1: rule__DataStructure__Group_2_2__0 : rule__DataStructure__Group_2_2__0__Impl rule__DataStructure__Group_2_2__1 ;
    public final void rule__DataStructure__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1800:1: ( rule__DataStructure__Group_2_2__0__Impl rule__DataStructure__Group_2_2__1 )
            // InternalDataDsl.g:1801:2: rule__DataStructure__Group_2_2__0__Impl rule__DataStructure__Group_2_2__1
            {
            pushFollow(FOLLOW_19);
            rule__DataStructure__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2_2__0"


    // $ANTLR start "rule__DataStructure__Group_2_2__0__Impl"
    // InternalDataDsl.g:1808:1: rule__DataStructure__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1812:1: ( ( ',' ) )
            // InternalDataDsl.g:1813:1: ( ',' )
            {
            // InternalDataDsl.g:1813:1: ( ',' )
            // InternalDataDsl.g:1814:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2_2__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_2_2__1"
    // InternalDataDsl.g:1823:1: rule__DataStructure__Group_2_2__1 : rule__DataStructure__Group_2_2__1__Impl ;
    public final void rule__DataStructure__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1827:1: ( rule__DataStructure__Group_2_2__1__Impl )
            // InternalDataDsl.g:1828:2: rule__DataStructure__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2_2__1"


    // $ANTLR start "rule__DataStructure__Group_2_2__1__Impl"
    // InternalDataDsl.g:1834:1: rule__DataStructure__Group_2_2__1__Impl : ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) ) ;
    public final void rule__DataStructure__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1838:1: ( ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) ) )
            // InternalDataDsl.g:1839:1: ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) )
            {
            // InternalDataDsl.g:1839:1: ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) )
            // InternalDataDsl.g:1840:2: ( rule__DataStructure__FeaturesAssignment_2_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_2_1()); 
            // InternalDataDsl.g:1841:2: ( rule__DataStructure__FeaturesAssignment_2_2_1 )
            // InternalDataDsl.g:1841:3: rule__DataStructure__FeaturesAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__FeaturesAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_2_2__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_3__0"
    // InternalDataDsl.g:1850:1: rule__DataStructure__Group_3__0 : rule__DataStructure__Group_3__0__Impl rule__DataStructure__Group_3__1 ;
    public final void rule__DataStructure__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1854:1: ( rule__DataStructure__Group_3__0__Impl rule__DataStructure__Group_3__1 )
            // InternalDataDsl.g:1855:2: rule__DataStructure__Group_3__0__Impl rule__DataStructure__Group_3__1
            {
            pushFollow(FOLLOW_12);
            rule__DataStructure__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_3__0"


    // $ANTLR start "rule__DataStructure__Group_3__0__Impl"
    // InternalDataDsl.g:1862:1: rule__DataStructure__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1866:1: ( ( 'extends' ) )
            // InternalDataDsl.g:1867:1: ( 'extends' )
            {
            // InternalDataDsl.g:1867:1: ( 'extends' )
            // InternalDataDsl.g:1868:2: 'extends'
            {
             before(grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getExtendsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_3__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_3__1"
    // InternalDataDsl.g:1877:1: rule__DataStructure__Group_3__1 : rule__DataStructure__Group_3__1__Impl ;
    public final void rule__DataStructure__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1881:1: ( rule__DataStructure__Group_3__1__Impl )
            // InternalDataDsl.g:1882:2: rule__DataStructure__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_3__1"


    // $ANTLR start "rule__DataStructure__Group_3__1__Impl"
    // InternalDataDsl.g:1888:1: rule__DataStructure__Group_3__1__Impl : ( ( rule__DataStructure__SuperAssignment_3_1 ) ) ;
    public final void rule__DataStructure__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1892:1: ( ( ( rule__DataStructure__SuperAssignment_3_1 ) ) )
            // InternalDataDsl.g:1893:1: ( ( rule__DataStructure__SuperAssignment_3_1 ) )
            {
            // InternalDataDsl.g:1893:1: ( ( rule__DataStructure__SuperAssignment_3_1 ) )
            // InternalDataDsl.g:1894:2: ( rule__DataStructure__SuperAssignment_3_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_3_1()); 
            // InternalDataDsl.g:1895:2: ( rule__DataStructure__SuperAssignment_3_1 )
            // InternalDataDsl.g:1895:3: rule__DataStructure__SuperAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__SuperAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getSuperAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_3__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_5__0"
    // InternalDataDsl.g:1904:1: rule__DataStructure__Group_5__0 : rule__DataStructure__Group_5__0__Impl rule__DataStructure__Group_5__1 ;
    public final void rule__DataStructure__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1908:1: ( rule__DataStructure__Group_5__0__Impl rule__DataStructure__Group_5__1 )
            // InternalDataDsl.g:1909:2: rule__DataStructure__Group_5__0__Impl rule__DataStructure__Group_5__1
            {
            pushFollow(FOLLOW_22);
            rule__DataStructure__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5__0"


    // $ANTLR start "rule__DataStructure__Group_5__0__Impl"
    // InternalDataDsl.g:1916:1: rule__DataStructure__Group_5__0__Impl : ( ( rule__DataStructure__Alternatives_5_0 ) ) ;
    public final void rule__DataStructure__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1920:1: ( ( ( rule__DataStructure__Alternatives_5_0 ) ) )
            // InternalDataDsl.g:1921:1: ( ( rule__DataStructure__Alternatives_5_0 ) )
            {
            // InternalDataDsl.g:1921:1: ( ( rule__DataStructure__Alternatives_5_0 ) )
            // InternalDataDsl.g:1922:2: ( rule__DataStructure__Alternatives_5_0 )
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_5_0()); 
            // InternalDataDsl.g:1923:2: ( rule__DataStructure__Alternatives_5_0 )
            // InternalDataDsl.g:1923:3: rule__DataStructure__Alternatives_5_0
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Alternatives_5_0();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getAlternatives_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_5__1"
    // InternalDataDsl.g:1931:1: rule__DataStructure__Group_5__1 : rule__DataStructure__Group_5__1__Impl ;
    public final void rule__DataStructure__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1935:1: ( rule__DataStructure__Group_5__1__Impl )
            // InternalDataDsl.g:1936:2: rule__DataStructure__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5__1"


    // $ANTLR start "rule__DataStructure__Group_5__1__Impl"
    // InternalDataDsl.g:1942:1: rule__DataStructure__Group_5__1__Impl : ( ( rule__DataStructure__Group_5_1__0 )* ) ;
    public final void rule__DataStructure__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1946:1: ( ( ( rule__DataStructure__Group_5_1__0 )* ) )
            // InternalDataDsl.g:1947:1: ( ( rule__DataStructure__Group_5_1__0 )* )
            {
            // InternalDataDsl.g:1947:1: ( ( rule__DataStructure__Group_5_1__0 )* )
            // InternalDataDsl.g:1948:2: ( rule__DataStructure__Group_5_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_5_1()); 
            // InternalDataDsl.g:1949:2: ( rule__DataStructure__Group_5_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==41) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDsl.g:1949:3: rule__DataStructure__Group_5_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataStructure__Group_5_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getDataStructureAccess().getGroup_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5__1__Impl"


    // $ANTLR start "rule__DataStructure__Group_5_1__0"
    // InternalDataDsl.g:1958:1: rule__DataStructure__Group_5_1__0 : rule__DataStructure__Group_5_1__0__Impl rule__DataStructure__Group_5_1__1 ;
    public final void rule__DataStructure__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1962:1: ( rule__DataStructure__Group_5_1__0__Impl rule__DataStructure__Group_5_1__1 )
            // InternalDataDsl.g:1963:2: rule__DataStructure__Group_5_1__0__Impl rule__DataStructure__Group_5_1__1
            {
            pushFollow(FOLLOW_23);
            rule__DataStructure__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_5_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5_1__0"


    // $ANTLR start "rule__DataStructure__Group_5_1__0__Impl"
    // InternalDataDsl.g:1970:1: rule__DataStructure__Group_5_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1974:1: ( ( ',' ) )
            // InternalDataDsl.g:1975:1: ( ',' )
            {
            // InternalDataDsl.g:1975:1: ( ',' )
            // InternalDataDsl.g:1976:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDataStructureAccess().getCommaKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5_1__0__Impl"


    // $ANTLR start "rule__DataStructure__Group_5_1__1"
    // InternalDataDsl.g:1985:1: rule__DataStructure__Group_5_1__1 : rule__DataStructure__Group_5_1__1__Impl ;
    public final void rule__DataStructure__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1989:1: ( rule__DataStructure__Group_5_1__1__Impl )
            // InternalDataDsl.g:1990:2: rule__DataStructure__Group_5_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Group_5_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5_1__1"


    // $ANTLR start "rule__DataStructure__Group_5_1__1__Impl"
    // InternalDataDsl.g:1996:1: rule__DataStructure__Group_5_1__1__Impl : ( ( rule__DataStructure__Alternatives_5_1_1 ) ) ;
    public final void rule__DataStructure__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2000:1: ( ( ( rule__DataStructure__Alternatives_5_1_1 ) ) )
            // InternalDataDsl.g:2001:1: ( ( rule__DataStructure__Alternatives_5_1_1 ) )
            {
            // InternalDataDsl.g:2001:1: ( ( rule__DataStructure__Alternatives_5_1_1 ) )
            // InternalDataDsl.g:2002:2: ( rule__DataStructure__Alternatives_5_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_5_1_1()); 
            // InternalDataDsl.g:2003:2: ( rule__DataStructure__Alternatives_5_1_1 )
            // InternalDataDsl.g:2003:3: rule__DataStructure__Alternatives_5_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStructure__Alternatives_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStructureAccess().getAlternatives_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__Group_5_1__1__Impl"


    // $ANTLR start "rule__ListType__Group_0__0"
    // InternalDataDsl.g:2012:1: rule__ListType__Group_0__0 : rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 ;
    public final void rule__ListType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2016:1: ( rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 )
            // InternalDataDsl.g:2017:2: rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1
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
    // InternalDataDsl.g:2024:1: rule__ListType__Group_0__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2028:1: ( ( 'list' ) )
            // InternalDataDsl.g:2029:1: ( 'list' )
            {
            // InternalDataDsl.g:2029:1: ( 'list' )
            // InternalDataDsl.g:2030:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_0_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalDataDsl.g:2039:1: rule__ListType__Group_0__1 : rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 ;
    public final void rule__ListType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2043:1: ( rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 )
            // InternalDataDsl.g:2044:2: rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2
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
    // InternalDataDsl.g:2051:1: rule__ListType__Group_0__1__Impl : ( ( rule__ListType__NameAssignment_0_1 ) ) ;
    public final void rule__ListType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2055:1: ( ( ( rule__ListType__NameAssignment_0_1 ) ) )
            // InternalDataDsl.g:2056:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            {
            // InternalDataDsl.g:2056:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            // InternalDataDsl.g:2057:2: ( rule__ListType__NameAssignment_0_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 
            // InternalDataDsl.g:2058:2: ( rule__ListType__NameAssignment_0_1 )
            // InternalDataDsl.g:2058:3: rule__ListType__NameAssignment_0_1
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
    // InternalDataDsl.g:2066:1: rule__ListType__Group_0__2 : rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 ;
    public final void rule__ListType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2070:1: ( rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 )
            // InternalDataDsl.g:2071:2: rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2078:1: rule__ListType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2082:1: ( ( '{' ) )
            // InternalDataDsl.g:2083:1: ( '{' )
            {
            // InternalDataDsl.g:2083:1: ( '{' )
            // InternalDataDsl.g:2084:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDataDsl.g:2093:1: rule__ListType__Group_0__3 : rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 ;
    public final void rule__ListType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2097:1: ( rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 )
            // InternalDataDsl.g:2098:2: rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:2105:1: rule__ListType__Group_0__3__Impl : ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__ListType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2109:1: ( ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) )
            // InternalDataDsl.g:2110:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            {
            // InternalDataDsl.g:2110:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            // InternalDataDsl.g:2111:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalDataDsl.g:2112:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            // InternalDataDsl.g:2112:3: rule__ListType__DataFieldsAssignment_0_3
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
    // InternalDataDsl.g:2120:1: rule__ListType__Group_0__4 : rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 ;
    public final void rule__ListType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2124:1: ( rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 )
            // InternalDataDsl.g:2125:2: rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:2132:1: rule__ListType__Group_0__4__Impl : ( ( rule__ListType__Group_0_4__0 )* ) ;
    public final void rule__ListType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2136:1: ( ( ( rule__ListType__Group_0_4__0 )* ) )
            // InternalDataDsl.g:2137:1: ( ( rule__ListType__Group_0_4__0 )* )
            {
            // InternalDataDsl.g:2137:1: ( ( rule__ListType__Group_0_4__0 )* )
            // InternalDataDsl.g:2138:2: ( rule__ListType__Group_0_4__0 )*
            {
             before(grammarAccess.getListTypeAccess().getGroup_0_4()); 
            // InternalDataDsl.g:2139:2: ( rule__ListType__Group_0_4__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==41) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDsl.g:2139:3: rule__ListType__Group_0_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__ListType__Group_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalDataDsl.g:2147:1: rule__ListType__Group_0__5 : rule__ListType__Group_0__5__Impl ;
    public final void rule__ListType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2151:1: ( rule__ListType__Group_0__5__Impl )
            // InternalDataDsl.g:2152:2: rule__ListType__Group_0__5__Impl
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
    // InternalDataDsl.g:2158:1: rule__ListType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__ListType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2162:1: ( ( '}' ) )
            // InternalDataDsl.g:2163:1: ( '}' )
            {
            // InternalDataDsl.g:2163:1: ( '}' )
            // InternalDataDsl.g:2164:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDataDsl.g:2174:1: rule__ListType__Group_0_4__0 : rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 ;
    public final void rule__ListType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2178:1: ( rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 )
            // InternalDataDsl.g:2179:2: rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2186:1: rule__ListType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__ListType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2190:1: ( ( ',' ) )
            // InternalDataDsl.g:2191:1: ( ',' )
            {
            // InternalDataDsl.g:2191:1: ( ',' )
            // InternalDataDsl.g:2192:2: ','
            {
             before(grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalDataDsl.g:2201:1: rule__ListType__Group_0_4__1 : rule__ListType__Group_0_4__1__Impl ;
    public final void rule__ListType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2205:1: ( rule__ListType__Group_0_4__1__Impl )
            // InternalDataDsl.g:2206:2: rule__ListType__Group_0_4__1__Impl
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
    // InternalDataDsl.g:2212:1: rule__ListType__Group_0_4__1__Impl : ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__ListType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2216:1: ( ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalDataDsl.g:2217:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalDataDsl.g:2217:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            // InternalDataDsl.g:2218:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalDataDsl.g:2219:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            // InternalDataDsl.g:2219:3: rule__ListType__DataFieldsAssignment_0_4_1
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
    // InternalDataDsl.g:2228:1: rule__ListType__Group_1__0 : rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 ;
    public final void rule__ListType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2232:1: ( rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 )
            // InternalDataDsl.g:2233:2: rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1
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
    // InternalDataDsl.g:2240:1: rule__ListType__Group_1__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2244:1: ( ( 'list' ) )
            // InternalDataDsl.g:2245:1: ( 'list' )
            {
            // InternalDataDsl.g:2245:1: ( 'list' )
            // InternalDataDsl.g:2246:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_1_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalDataDsl.g:2255:1: rule__ListType__Group_1__1 : rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 ;
    public final void rule__ListType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2259:1: ( rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 )
            // InternalDataDsl.g:2260:2: rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2
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
    // InternalDataDsl.g:2267:1: rule__ListType__Group_1__1__Impl : ( ( rule__ListType__NameAssignment_1_1 ) ) ;
    public final void rule__ListType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2271:1: ( ( ( rule__ListType__NameAssignment_1_1 ) ) )
            // InternalDataDsl.g:2272:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            {
            // InternalDataDsl.g:2272:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            // InternalDataDsl.g:2273:2: ( rule__ListType__NameAssignment_1_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 
            // InternalDataDsl.g:2274:2: ( rule__ListType__NameAssignment_1_1 )
            // InternalDataDsl.g:2274:3: rule__ListType__NameAssignment_1_1
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
    // InternalDataDsl.g:2282:1: rule__ListType__Group_1__2 : rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 ;
    public final void rule__ListType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2286:1: ( rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 )
            // InternalDataDsl.g:2287:2: rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalDataDsl.g:2294:1: rule__ListType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2298:1: ( ( '{' ) )
            // InternalDataDsl.g:2299:1: ( '{' )
            {
            // InternalDataDsl.g:2299:1: ( '{' )
            // InternalDataDsl.g:2300:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDataDsl.g:2309:1: rule__ListType__Group_1__3 : rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 ;
    public final void rule__ListType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2313:1: ( rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 )
            // InternalDataDsl.g:2314:2: rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4
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
    // InternalDataDsl.g:2321:1: rule__ListType__Group_1__3__Impl : ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__ListType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2325:1: ( ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalDataDsl.g:2326:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalDataDsl.g:2326:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            // InternalDataDsl.g:2327:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalDataDsl.g:2328:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            // InternalDataDsl.g:2328:3: rule__ListType__PrimitiveTypeAssignment_1_3
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
    // InternalDataDsl.g:2336:1: rule__ListType__Group_1__4 : rule__ListType__Group_1__4__Impl ;
    public final void rule__ListType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2340:1: ( rule__ListType__Group_1__4__Impl )
            // InternalDataDsl.g:2341:2: rule__ListType__Group_1__4__Impl
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
    // InternalDataDsl.g:2347:1: rule__ListType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__ListType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2351:1: ( ( '}' ) )
            // InternalDataDsl.g:2352:1: ( '}' )
            {
            // InternalDataDsl.g:2352:1: ( '}' )
            // InternalDataDsl.g:2353:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDataDsl.g:2363:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2367:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalDataDsl.g:2368:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2375:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2379:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:2380:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:2380:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalDataDsl.g:2381:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:2382:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==60) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDataDsl.g:2382:3: rule__DataField__HiddenAssignment_0
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
    // InternalDataDsl.g:2390:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2394:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalDataDsl.g:2395:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2402:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__ImmutableAssignment_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2406:1: ( ( ( rule__DataField__ImmutableAssignment_1 )? ) )
            // InternalDataDsl.g:2407:1: ( ( rule__DataField__ImmutableAssignment_1 )? )
            {
            // InternalDataDsl.g:2407:1: ( ( rule__DataField__ImmutableAssignment_1 )? )
            // InternalDataDsl.g:2408:2: ( rule__DataField__ImmutableAssignment_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getImmutableAssignment_1()); 
            // InternalDataDsl.g:2409:2: ( rule__DataField__ImmutableAssignment_1 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==61) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDsl.g:2409:3: rule__DataField__ImmutableAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__ImmutableAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getImmutableAssignment_1()); 

            }


            }

        }
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
    // InternalDataDsl.g:2417:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl rule__DataField__Group__3 ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2421:1: ( rule__DataField__Group__2__Impl rule__DataField__Group__3 )
            // InternalDataDsl.g:2422:2: rule__DataField__Group__2__Impl rule__DataField__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalDataDsl.g:2429:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__Alternatives_2 )? ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2433:1: ( ( ( rule__DataField__Alternatives_2 )? ) )
            // InternalDataDsl.g:2434:1: ( ( rule__DataField__Alternatives_2 )? )
            {
            // InternalDataDsl.g:2434:1: ( ( rule__DataField__Alternatives_2 )? )
            // InternalDataDsl.g:2435:2: ( rule__DataField__Alternatives_2 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_2()); 
            // InternalDataDsl.g:2436:2: ( rule__DataField__Alternatives_2 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=49 && LA32_0<=58)) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                int LA32_2 = input.LA(2);

                if ( (LA32_2==RULE_ID||LA32_2==48||LA32_2==59) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDsl.g:2436:3: rule__DataField__Alternatives_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__Alternatives_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getAlternatives_2()); 

            }


            }

        }
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
    // InternalDataDsl.g:2444:1: rule__DataField__Group__3 : rule__DataField__Group__3__Impl rule__DataField__Group__4 ;
    public final void rule__DataField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2448:1: ( rule__DataField__Group__3__Impl rule__DataField__Group__4 )
            // InternalDataDsl.g:2449:2: rule__DataField__Group__3__Impl rule__DataField__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__DataField__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group__4();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:2456:1: rule__DataField__Group__3__Impl : ( ( rule__DataField__NameAssignment_3 ) ) ;
    public final void rule__DataField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2460:1: ( ( ( rule__DataField__NameAssignment_3 ) ) )
            // InternalDataDsl.g:2461:1: ( ( rule__DataField__NameAssignment_3 ) )
            {
            // InternalDataDsl.g:2461:1: ( ( rule__DataField__NameAssignment_3 ) )
            // InternalDataDsl.g:2462:2: ( rule__DataField__NameAssignment_3 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_3()); 
            // InternalDataDsl.g:2463:2: ( rule__DataField__NameAssignment_3 )
            // InternalDataDsl.g:2463:3: rule__DataField__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DataField__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getNameAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__DataField__Group__4"
    // InternalDataDsl.g:2471:1: rule__DataField__Group__4 : rule__DataField__Group__4__Impl ;
    public final void rule__DataField__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2475:1: ( rule__DataField__Group__4__Impl )
            // InternalDataDsl.g:2476:2: rule__DataField__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__4"


    // $ANTLR start "rule__DataField__Group__4__Impl"
    // InternalDataDsl.g:2482:1: rule__DataField__Group__4__Impl : ( ( rule__DataField__Group_4__0 )? ) ;
    public final void rule__DataField__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2486:1: ( ( ( rule__DataField__Group_4__0 )? ) )
            // InternalDataDsl.g:2487:1: ( ( rule__DataField__Group_4__0 )? )
            {
            // InternalDataDsl.g:2487:1: ( ( rule__DataField__Group_4__0 )? )
            // InternalDataDsl.g:2488:2: ( rule__DataField__Group_4__0 )?
            {
             before(grammarAccess.getDataFieldAccess().getGroup_4()); 
            // InternalDataDsl.g:2489:2: ( rule__DataField__Group_4__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==39) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDsl.g:2489:3: rule__DataField__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__4__Impl"


    // $ANTLR start "rule__DataField__Group_4__0"
    // InternalDataDsl.g:2498:1: rule__DataField__Group_4__0 : rule__DataField__Group_4__0__Impl rule__DataField__Group_4__1 ;
    public final void rule__DataField__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2502:1: ( rule__DataField__Group_4__0__Impl rule__DataField__Group_4__1 )
            // InternalDataDsl.g:2503:2: rule__DataField__Group_4__0__Impl rule__DataField__Group_4__1
            {
            pushFollow(FOLLOW_28);
            rule__DataField__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__0"


    // $ANTLR start "rule__DataField__Group_4__0__Impl"
    // InternalDataDsl.g:2510:1: rule__DataField__Group_4__0__Impl : ( '<' ) ;
    public final void rule__DataField__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2514:1: ( ( '<' ) )
            // InternalDataDsl.g:2515:1: ( '<' )
            {
            // InternalDataDsl.g:2515:1: ( '<' )
            // InternalDataDsl.g:2516:2: '<'
            {
             before(grammarAccess.getDataFieldAccess().getLessThanSignKeyword_4_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getLessThanSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__0__Impl"


    // $ANTLR start "rule__DataField__Group_4__1"
    // InternalDataDsl.g:2525:1: rule__DataField__Group_4__1 : rule__DataField__Group_4__1__Impl rule__DataField__Group_4__2 ;
    public final void rule__DataField__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2529:1: ( rule__DataField__Group_4__1__Impl rule__DataField__Group_4__2 )
            // InternalDataDsl.g:2530:2: rule__DataField__Group_4__1__Impl rule__DataField__Group_4__2
            {
            pushFollow(FOLLOW_20);
            rule__DataField__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__1"


    // $ANTLR start "rule__DataField__Group_4__1__Impl"
    // InternalDataDsl.g:2537:1: rule__DataField__Group_4__1__Impl : ( ( rule__DataField__FeaturesAssignment_4_1 ) ) ;
    public final void rule__DataField__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2541:1: ( ( ( rule__DataField__FeaturesAssignment_4_1 ) ) )
            // InternalDataDsl.g:2542:1: ( ( rule__DataField__FeaturesAssignment_4_1 ) )
            {
            // InternalDataDsl.g:2542:1: ( ( rule__DataField__FeaturesAssignment_4_1 ) )
            // InternalDataDsl.g:2543:2: ( rule__DataField__FeaturesAssignment_4_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_4_1()); 
            // InternalDataDsl.g:2544:2: ( rule__DataField__FeaturesAssignment_4_1 )
            // InternalDataDsl.g:2544:3: rule__DataField__FeaturesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__FeaturesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getFeaturesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__1__Impl"


    // $ANTLR start "rule__DataField__Group_4__2"
    // InternalDataDsl.g:2552:1: rule__DataField__Group_4__2 : rule__DataField__Group_4__2__Impl rule__DataField__Group_4__3 ;
    public final void rule__DataField__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2556:1: ( rule__DataField__Group_4__2__Impl rule__DataField__Group_4__3 )
            // InternalDataDsl.g:2557:2: rule__DataField__Group_4__2__Impl rule__DataField__Group_4__3
            {
            pushFollow(FOLLOW_20);
            rule__DataField__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__2"


    // $ANTLR start "rule__DataField__Group_4__2__Impl"
    // InternalDataDsl.g:2564:1: rule__DataField__Group_4__2__Impl : ( ( rule__DataField__Group_4_2__0 )* ) ;
    public final void rule__DataField__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2568:1: ( ( ( rule__DataField__Group_4_2__0 )* ) )
            // InternalDataDsl.g:2569:1: ( ( rule__DataField__Group_4_2__0 )* )
            {
            // InternalDataDsl.g:2569:1: ( ( rule__DataField__Group_4_2__0 )* )
            // InternalDataDsl.g:2570:2: ( rule__DataField__Group_4_2__0 )*
            {
             before(grammarAccess.getDataFieldAccess().getGroup_4_2()); 
            // InternalDataDsl.g:2571:2: ( rule__DataField__Group_4_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==41) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDataDsl.g:2571:3: rule__DataField__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataField__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getDataFieldAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__2__Impl"


    // $ANTLR start "rule__DataField__Group_4__3"
    // InternalDataDsl.g:2579:1: rule__DataField__Group_4__3 : rule__DataField__Group_4__3__Impl ;
    public final void rule__DataField__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2583:1: ( rule__DataField__Group_4__3__Impl )
            // InternalDataDsl.g:2584:2: rule__DataField__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__3"


    // $ANTLR start "rule__DataField__Group_4__3__Impl"
    // InternalDataDsl.g:2590:1: rule__DataField__Group_4__3__Impl : ( '>' ) ;
    public final void rule__DataField__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2594:1: ( ( '>' ) )
            // InternalDataDsl.g:2595:1: ( '>' )
            {
            // InternalDataDsl.g:2595:1: ( '>' )
            // InternalDataDsl.g:2596:2: '>'
            {
             before(grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4__3__Impl"


    // $ANTLR start "rule__DataField__Group_4_2__0"
    // InternalDataDsl.g:2606:1: rule__DataField__Group_4_2__0 : rule__DataField__Group_4_2__0__Impl rule__DataField__Group_4_2__1 ;
    public final void rule__DataField__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2610:1: ( rule__DataField__Group_4_2__0__Impl rule__DataField__Group_4_2__1 )
            // InternalDataDsl.g:2611:2: rule__DataField__Group_4_2__0__Impl rule__DataField__Group_4_2__1
            {
            pushFollow(FOLLOW_28);
            rule__DataField__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4_2__0"


    // $ANTLR start "rule__DataField__Group_4_2__0__Impl"
    // InternalDataDsl.g:2618:1: rule__DataField__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__DataField__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2622:1: ( ( ',' ) )
            // InternalDataDsl.g:2623:1: ( ',' )
            {
            // InternalDataDsl.g:2623:1: ( ',' )
            // InternalDataDsl.g:2624:2: ','
            {
             before(grammarAccess.getDataFieldAccess().getCommaKeyword_4_2_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4_2__0__Impl"


    // $ANTLR start "rule__DataField__Group_4_2__1"
    // InternalDataDsl.g:2633:1: rule__DataField__Group_4_2__1 : rule__DataField__Group_4_2__1__Impl ;
    public final void rule__DataField__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2637:1: ( rule__DataField__Group_4_2__1__Impl )
            // InternalDataDsl.g:2638:2: rule__DataField__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4_2__1"


    // $ANTLR start "rule__DataField__Group_4_2__1__Impl"
    // InternalDataDsl.g:2644:1: rule__DataField__Group_4_2__1__Impl : ( ( rule__DataField__FeaturesAssignment_4_2_1 ) ) ;
    public final void rule__DataField__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2648:1: ( ( ( rule__DataField__FeaturesAssignment_4_2_1 ) ) )
            // InternalDataDsl.g:2649:1: ( ( rule__DataField__FeaturesAssignment_4_2_1 ) )
            {
            // InternalDataDsl.g:2649:1: ( ( rule__DataField__FeaturesAssignment_4_2_1 ) )
            // InternalDataDsl.g:2650:2: ( rule__DataField__FeaturesAssignment_4_2_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_4_2_1()); 
            // InternalDataDsl.g:2651:2: ( rule__DataField__FeaturesAssignment_4_2_1 )
            // InternalDataDsl.g:2651:3: rule__DataField__FeaturesAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__FeaturesAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getFeaturesAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_4_2__1__Impl"


    // $ANTLR start "rule__Enumeration__Group__0"
    // InternalDataDsl.g:2660:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2664:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalDataDsl.g:2665:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
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
    // InternalDataDsl.g:2672:1: rule__Enumeration__Group__0__Impl : ( 'enum' ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2676:1: ( ( 'enum' ) )
            // InternalDataDsl.g:2677:1: ( 'enum' )
            {
            // InternalDataDsl.g:2677:1: ( 'enum' )
            // InternalDataDsl.g:2678:2: 'enum'
            {
             before(grammarAccess.getEnumerationAccess().getEnumKeyword_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalDataDsl.g:2687:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2691:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalDataDsl.g:2692:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
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
    // InternalDataDsl.g:2699:1: rule__Enumeration__Group__1__Impl : ( ( rule__Enumeration__NameAssignment_1 ) ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2703:1: ( ( ( rule__Enumeration__NameAssignment_1 ) ) )
            // InternalDataDsl.g:2704:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:2704:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            // InternalDataDsl.g:2705:2: ( rule__Enumeration__NameAssignment_1 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:2706:2: ( rule__Enumeration__NameAssignment_1 )
            // InternalDataDsl.g:2706:3: rule__Enumeration__NameAssignment_1
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
    // InternalDataDsl.g:2714:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2718:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalDataDsl.g:2719:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
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
    // InternalDataDsl.g:2726:1: rule__Enumeration__Group__2__Impl : ( '{' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2730:1: ( ( '{' ) )
            // InternalDataDsl.g:2731:1: ( '{' )
            {
            // InternalDataDsl.g:2731:1: ( '{' )
            // InternalDataDsl.g:2732:2: '{'
            {
             before(grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalDataDsl.g:2741:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2745:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalDataDsl.g:2746:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:2753:1: rule__Enumeration__Group__3__Impl : ( ( rule__Enumeration__FieldsAssignment_3 ) ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2757:1: ( ( ( rule__Enumeration__FieldsAssignment_3 ) ) )
            // InternalDataDsl.g:2758:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            {
            // InternalDataDsl.g:2758:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            // InternalDataDsl.g:2759:2: ( rule__Enumeration__FieldsAssignment_3 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_3()); 
            // InternalDataDsl.g:2760:2: ( rule__Enumeration__FieldsAssignment_3 )
            // InternalDataDsl.g:2760:3: rule__Enumeration__FieldsAssignment_3
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
    // InternalDataDsl.g:2768:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2772:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalDataDsl.g:2773:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalDataDsl.g:2780:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2784:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalDataDsl.g:2785:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalDataDsl.g:2785:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalDataDsl.g:2786:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalDataDsl.g:2787:2: ( rule__Enumeration__Group_4__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==41) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDsl.g:2787:3: rule__Enumeration__Group_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Enumeration__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalDataDsl.g:2795:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2799:1: ( rule__Enumeration__Group__5__Impl )
            // InternalDataDsl.g:2800:2: rule__Enumeration__Group__5__Impl
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
    // InternalDataDsl.g:2806:1: rule__Enumeration__Group__5__Impl : ( '}' ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2810:1: ( ( '}' ) )
            // InternalDataDsl.g:2811:1: ( '}' )
            {
            // InternalDataDsl.g:2811:1: ( '}' )
            // InternalDataDsl.g:2812:2: '}'
            {
             before(grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,36,FOLLOW_2); 
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
    // InternalDataDsl.g:2822:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2826:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalDataDsl.g:2827:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
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
    // InternalDataDsl.g:2834:1: rule__Enumeration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2838:1: ( ( ',' ) )
            // InternalDataDsl.g:2839:1: ( ',' )
            {
            // InternalDataDsl.g:2839:1: ( ',' )
            // InternalDataDsl.g:2840:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_4_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalDataDsl.g:2849:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2853:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalDataDsl.g:2854:2: rule__Enumeration__Group_4__1__Impl
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
    // InternalDataDsl.g:2860:1: rule__Enumeration__Group_4__1__Impl : ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2864:1: ( ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) )
            // InternalDataDsl.g:2865:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            {
            // InternalDataDsl.g:2865:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            // InternalDataDsl.g:2866:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_4_1()); 
            // InternalDataDsl.g:2867:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            // InternalDataDsl.g:2867:3: rule__Enumeration__FieldsAssignment_4_1
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
    // InternalDataDsl.g:2876:1: rule__EnumerationField__Group__0 : rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 ;
    public final void rule__EnumerationField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2880:1: ( rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 )
            // InternalDataDsl.g:2881:2: rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1
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
    // InternalDataDsl.g:2888:1: rule__EnumerationField__Group__0__Impl : ( ( rule__EnumerationField__NameAssignment_0 ) ) ;
    public final void rule__EnumerationField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2892:1: ( ( ( rule__EnumerationField__NameAssignment_0 ) ) )
            // InternalDataDsl.g:2893:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            {
            // InternalDataDsl.g:2893:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            // InternalDataDsl.g:2894:2: ( rule__EnumerationField__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0()); 
            // InternalDataDsl.g:2895:2: ( rule__EnumerationField__NameAssignment_0 )
            // InternalDataDsl.g:2895:3: rule__EnumerationField__NameAssignment_0
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
    // InternalDataDsl.g:2903:1: rule__EnumerationField__Group__1 : rule__EnumerationField__Group__1__Impl ;
    public final void rule__EnumerationField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2907:1: ( rule__EnumerationField__Group__1__Impl )
            // InternalDataDsl.g:2908:2: rule__EnumerationField__Group__1__Impl
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
    // InternalDataDsl.g:2914:1: rule__EnumerationField__Group__1__Impl : ( ( rule__EnumerationField__Group_1__0 )? ) ;
    public final void rule__EnumerationField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2918:1: ( ( ( rule__EnumerationField__Group_1__0 )? ) )
            // InternalDataDsl.g:2919:1: ( ( rule__EnumerationField__Group_1__0 )? )
            {
            // InternalDataDsl.g:2919:1: ( ( rule__EnumerationField__Group_1__0 )? )
            // InternalDataDsl.g:2920:2: ( rule__EnumerationField__Group_1__0 )?
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup_1()); 
            // InternalDataDsl.g:2921:2: ( rule__EnumerationField__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDsl.g:2921:3: rule__EnumerationField__Group_1__0
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
    // InternalDataDsl.g:2930:1: rule__EnumerationField__Group_1__0 : rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 ;
    public final void rule__EnumerationField__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2934:1: ( rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 )
            // InternalDataDsl.g:2935:2: rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1
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
    // InternalDataDsl.g:2942:1: rule__EnumerationField__Group_1__0__Impl : ( '(' ) ;
    public final void rule__EnumerationField__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2946:1: ( ( '(' ) )
            // InternalDataDsl.g:2947:1: ( '(' )
            {
            // InternalDataDsl.g:2947:1: ( '(' )
            // InternalDataDsl.g:2948:2: '('
            {
             before(grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalDataDsl.g:2957:1: rule__EnumerationField__Group_1__1 : rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 ;
    public final void rule__EnumerationField__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2961:1: ( rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 )
            // InternalDataDsl.g:2962:2: rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2
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
    // InternalDataDsl.g:2969:1: rule__EnumerationField__Group_1__1__Impl : ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) ;
    public final void rule__EnumerationField__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2973:1: ( ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) )
            // InternalDataDsl.g:2974:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            {
            // InternalDataDsl.g:2974:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            // InternalDataDsl.g:2975:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1()); 
            // InternalDataDsl.g:2976:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            // InternalDataDsl.g:2976:3: rule__EnumerationField__InitializationValueAssignment_1_1
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
    // InternalDataDsl.g:2984:1: rule__EnumerationField__Group_1__2 : rule__EnumerationField__Group_1__2__Impl ;
    public final void rule__EnumerationField__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2988:1: ( rule__EnumerationField__Group_1__2__Impl )
            // InternalDataDsl.g:2989:2: rule__EnumerationField__Group_1__2__Impl
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
    // InternalDataDsl.g:2995:1: rule__EnumerationField__Group_1__2__Impl : ( ')' ) ;
    public final void rule__EnumerationField__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2999:1: ( ( ')' ) )
            // InternalDataDsl.g:3000:1: ( ')' )
            {
            // InternalDataDsl.g:3000:1: ( ')' )
            // InternalDataDsl.g:3001:2: ')'
            {
             before(grammarAccess.getEnumerationFieldAccess().getRightParenthesisKeyword_1_2()); 
            match(input,46,FOLLOW_2); 
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
    // InternalDataDsl.g:3011:1: rule__DataOperation__Group__0 : rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 ;
    public final void rule__DataOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3015:1: ( rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 )
            // InternalDataDsl.g:3016:2: rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1
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
    // InternalDataDsl.g:3023:1: rule__DataOperation__Group__0__Impl : ( ( rule__DataOperation__HiddenAssignment_0 )? ) ;
    public final void rule__DataOperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3027:1: ( ( ( rule__DataOperation__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:3028:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:3028:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            // InternalDataDsl.g:3029:2: ( rule__DataOperation__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataOperationAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:3030:2: ( rule__DataOperation__HiddenAssignment_0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==60) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDataDsl.g:3030:3: rule__DataOperation__HiddenAssignment_0
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
    // InternalDataDsl.g:3038:1: rule__DataOperation__Group__1 : rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 ;
    public final void rule__DataOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3042:1: ( rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 )
            // InternalDataDsl.g:3043:2: rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2
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
    // InternalDataDsl.g:3050:1: rule__DataOperation__Group__1__Impl : ( ( rule__DataOperation__Alternatives_1 ) ) ;
    public final void rule__DataOperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3054:1: ( ( ( rule__DataOperation__Alternatives_1 ) ) )
            // InternalDataDsl.g:3055:1: ( ( rule__DataOperation__Alternatives_1 ) )
            {
            // InternalDataDsl.g:3055:1: ( ( rule__DataOperation__Alternatives_1 ) )
            // InternalDataDsl.g:3056:2: ( rule__DataOperation__Alternatives_1 )
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1()); 
            // InternalDataDsl.g:3057:2: ( rule__DataOperation__Alternatives_1 )
            // InternalDataDsl.g:3057:3: rule__DataOperation__Alternatives_1
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
    // InternalDataDsl.g:3065:1: rule__DataOperation__Group__2 : rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 ;
    public final void rule__DataOperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3069:1: ( rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 )
            // InternalDataDsl.g:3070:2: rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3
            {
            pushFollow(FOLLOW_32);
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
    // InternalDataDsl.g:3077:1: rule__DataOperation__Group__2__Impl : ( ( rule__DataOperation__NameAssignment_2 ) ) ;
    public final void rule__DataOperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3081:1: ( ( ( rule__DataOperation__NameAssignment_2 ) ) )
            // InternalDataDsl.g:3082:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:3082:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            // InternalDataDsl.g:3083:2: ( rule__DataOperation__NameAssignment_2 )
            {
             before(grammarAccess.getDataOperationAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:3084:2: ( rule__DataOperation__NameAssignment_2 )
            // InternalDataDsl.g:3084:3: rule__DataOperation__NameAssignment_2
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
    // InternalDataDsl.g:3092:1: rule__DataOperation__Group__3 : rule__DataOperation__Group__3__Impl rule__DataOperation__Group__4 ;
    public final void rule__DataOperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3096:1: ( rule__DataOperation__Group__3__Impl rule__DataOperation__Group__4 )
            // InternalDataDsl.g:3097:2: rule__DataOperation__Group__3__Impl rule__DataOperation__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__DataOperation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__4();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:3104:1: rule__DataOperation__Group__3__Impl : ( ( rule__DataOperation__Group_3__0 )? ) ;
    public final void rule__DataOperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3108:1: ( ( ( rule__DataOperation__Group_3__0 )? ) )
            // InternalDataDsl.g:3109:1: ( ( rule__DataOperation__Group_3__0 )? )
            {
            // InternalDataDsl.g:3109:1: ( ( rule__DataOperation__Group_3__0 )? )
            // InternalDataDsl.g:3110:2: ( rule__DataOperation__Group_3__0 )?
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3()); 
            // InternalDataDsl.g:3111:2: ( rule__DataOperation__Group_3__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==45) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDataDsl.g:3111:3: rule__DataOperation__Group_3__0
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


    // $ANTLR start "rule__DataOperation__Group__4"
    // InternalDataDsl.g:3119:1: rule__DataOperation__Group__4 : rule__DataOperation__Group__4__Impl ;
    public final void rule__DataOperation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3123:1: ( rule__DataOperation__Group__4__Impl )
            // InternalDataDsl.g:3124:2: rule__DataOperation__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__4"


    // $ANTLR start "rule__DataOperation__Group__4__Impl"
    // InternalDataDsl.g:3130:1: rule__DataOperation__Group__4__Impl : ( ( rule__DataOperation__Group_4__0 )? ) ;
    public final void rule__DataOperation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3134:1: ( ( ( rule__DataOperation__Group_4__0 )? ) )
            // InternalDataDsl.g:3135:1: ( ( rule__DataOperation__Group_4__0 )? )
            {
            // InternalDataDsl.g:3135:1: ( ( rule__DataOperation__Group_4__0 )? )
            // InternalDataDsl.g:3136:2: ( rule__DataOperation__Group_4__0 )?
            {
             before(grammarAccess.getDataOperationAccess().getGroup_4()); 
            // InternalDataDsl.g:3137:2: ( rule__DataOperation__Group_4__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==39) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDataDsl.g:3137:3: rule__DataOperation__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataOperation__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataOperationAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group__4__Impl"


    // $ANTLR start "rule__DataOperation__Group_1_1__0"
    // InternalDataDsl.g:3146:1: rule__DataOperation__Group_1_1__0 : rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 ;
    public final void rule__DataOperation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3150:1: ( rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 )
            // InternalDataDsl.g:3151:2: rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDsl.g:3158:1: rule__DataOperation__Group_1_1__0__Impl : ( 'function' ) ;
    public final void rule__DataOperation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3162:1: ( ( 'function' ) )
            // InternalDataDsl.g:3163:1: ( 'function' )
            {
            // InternalDataDsl.g:3163:1: ( 'function' )
            // InternalDataDsl.g:3164:2: 'function'
            {
             before(grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalDataDsl.g:3173:1: rule__DataOperation__Group_1_1__1 : rule__DataOperation__Group_1_1__1__Impl ;
    public final void rule__DataOperation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3177:1: ( rule__DataOperation__Group_1_1__1__Impl )
            // InternalDataDsl.g:3178:2: rule__DataOperation__Group_1_1__1__Impl
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
    // InternalDataDsl.g:3184:1: rule__DataOperation__Group_1_1__1__Impl : ( ( rule__DataOperation__Alternatives_1_1_1 )? ) ;
    public final void rule__DataOperation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3188:1: ( ( ( rule__DataOperation__Alternatives_1_1_1 )? ) )
            // InternalDataDsl.g:3189:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            {
            // InternalDataDsl.g:3189:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            // InternalDataDsl.g:3190:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1_1_1()); 
            // InternalDataDsl.g:3191:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=49 && LA40_0<=58)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==RULE_ID||LA40_2==48||LA40_2==59) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalDataDsl.g:3191:3: rule__DataOperation__Alternatives_1_1_1
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
    // InternalDataDsl.g:3200:1: rule__DataOperation__Group_3__0 : rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 ;
    public final void rule__DataOperation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3204:1: ( rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 )
            // InternalDataDsl.g:3205:2: rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDsl.g:3212:1: rule__DataOperation__Group_3__0__Impl : ( '(' ) ;
    public final void rule__DataOperation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3216:1: ( ( '(' ) )
            // InternalDataDsl.g:3217:1: ( '(' )
            {
            // InternalDataDsl.g:3217:1: ( '(' )
            // InternalDataDsl.g:3218:2: '('
            {
             before(grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalDataDsl.g:3227:1: rule__DataOperation__Group_3__1 : rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 ;
    public final void rule__DataOperation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3231:1: ( rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 )
            // InternalDataDsl.g:3232:2: rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDsl.g:3239:1: rule__DataOperation__Group_3__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) ;
    public final void rule__DataOperation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3243:1: ( ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) )
            // InternalDataDsl.g:3244:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            {
            // InternalDataDsl.g:3244:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            // InternalDataDsl.g:3245:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_1()); 
            // InternalDataDsl.g:3246:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||(LA41_0>=49 && LA41_0<=58)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDataDsl.g:3246:3: rule__DataOperation__ParametersAssignment_3_1
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
    // InternalDataDsl.g:3254:1: rule__DataOperation__Group_3__2 : rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 ;
    public final void rule__DataOperation__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3258:1: ( rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 )
            // InternalDataDsl.g:3259:2: rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDsl.g:3266:1: rule__DataOperation__Group_3__2__Impl : ( ( rule__DataOperation__Group_3_2__0 )* ) ;
    public final void rule__DataOperation__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3270:1: ( ( ( rule__DataOperation__Group_3_2__0 )* ) )
            // InternalDataDsl.g:3271:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            {
            // InternalDataDsl.g:3271:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            // InternalDataDsl.g:3272:2: ( rule__DataOperation__Group_3_2__0 )*
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3_2()); 
            // InternalDataDsl.g:3273:2: ( rule__DataOperation__Group_3_2__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==41) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalDataDsl.g:3273:3: rule__DataOperation__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataOperation__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalDataDsl.g:3281:1: rule__DataOperation__Group_3__3 : rule__DataOperation__Group_3__3__Impl ;
    public final void rule__DataOperation__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3285:1: ( rule__DataOperation__Group_3__3__Impl )
            // InternalDataDsl.g:3286:2: rule__DataOperation__Group_3__3__Impl
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
    // InternalDataDsl.g:3292:1: rule__DataOperation__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DataOperation__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3296:1: ( ( ')' ) )
            // InternalDataDsl.g:3297:1: ( ')' )
            {
            // InternalDataDsl.g:3297:1: ( ')' )
            // InternalDataDsl.g:3298:2: ')'
            {
             before(grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3()); 
            match(input,46,FOLLOW_2); 
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
    // InternalDataDsl.g:3308:1: rule__DataOperation__Group_3_2__0 : rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 ;
    public final void rule__DataOperation__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3312:1: ( rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 )
            // InternalDataDsl.g:3313:2: rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDsl.g:3320:1: rule__DataOperation__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__DataOperation__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3324:1: ( ( ',' ) )
            // InternalDataDsl.g:3325:1: ( ',' )
            {
            // InternalDataDsl.g:3325:1: ( ',' )
            // InternalDataDsl.g:3326:2: ','
            {
             before(grammarAccess.getDataOperationAccess().getCommaKeyword_3_2_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalDataDsl.g:3335:1: rule__DataOperation__Group_3_2__1 : rule__DataOperation__Group_3_2__1__Impl ;
    public final void rule__DataOperation__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3339:1: ( rule__DataOperation__Group_3_2__1__Impl )
            // InternalDataDsl.g:3340:2: rule__DataOperation__Group_3_2__1__Impl
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
    // InternalDataDsl.g:3346:1: rule__DataOperation__Group_3_2__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) ;
    public final void rule__DataOperation__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3350:1: ( ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) )
            // InternalDataDsl.g:3351:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            {
            // InternalDataDsl.g:3351:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            // InternalDataDsl.g:3352:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_2_1()); 
            // InternalDataDsl.g:3353:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            // InternalDataDsl.g:3353:3: rule__DataOperation__ParametersAssignment_3_2_1
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


    // $ANTLR start "rule__DataOperation__Group_4__0"
    // InternalDataDsl.g:3362:1: rule__DataOperation__Group_4__0 : rule__DataOperation__Group_4__0__Impl rule__DataOperation__Group_4__1 ;
    public final void rule__DataOperation__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3366:1: ( rule__DataOperation__Group_4__0__Impl rule__DataOperation__Group_4__1 )
            // InternalDataDsl.g:3367:2: rule__DataOperation__Group_4__0__Impl rule__DataOperation__Group_4__1
            {
            pushFollow(FOLLOW_35);
            rule__DataOperation__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__0"


    // $ANTLR start "rule__DataOperation__Group_4__0__Impl"
    // InternalDataDsl.g:3374:1: rule__DataOperation__Group_4__0__Impl : ( '<' ) ;
    public final void rule__DataOperation__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3378:1: ( ( '<' ) )
            // InternalDataDsl.g:3379:1: ( '<' )
            {
            // InternalDataDsl.g:3379:1: ( '<' )
            // InternalDataDsl.g:3380:2: '<'
            {
             before(grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getLessThanSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__0__Impl"


    // $ANTLR start "rule__DataOperation__Group_4__1"
    // InternalDataDsl.g:3389:1: rule__DataOperation__Group_4__1 : rule__DataOperation__Group_4__1__Impl rule__DataOperation__Group_4__2 ;
    public final void rule__DataOperation__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3393:1: ( rule__DataOperation__Group_4__1__Impl rule__DataOperation__Group_4__2 )
            // InternalDataDsl.g:3394:2: rule__DataOperation__Group_4__1__Impl rule__DataOperation__Group_4__2
            {
            pushFollow(FOLLOW_20);
            rule__DataOperation__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__1"


    // $ANTLR start "rule__DataOperation__Group_4__1__Impl"
    // InternalDataDsl.g:3401:1: rule__DataOperation__Group_4__1__Impl : ( ( rule__DataOperation__FeaturesAssignment_4_1 ) ) ;
    public final void rule__DataOperation__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3405:1: ( ( ( rule__DataOperation__FeaturesAssignment_4_1 ) ) )
            // InternalDataDsl.g:3406:1: ( ( rule__DataOperation__FeaturesAssignment_4_1 ) )
            {
            // InternalDataDsl.g:3406:1: ( ( rule__DataOperation__FeaturesAssignment_4_1 ) )
            // InternalDataDsl.g:3407:2: ( rule__DataOperation__FeaturesAssignment_4_1 )
            {
             before(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_1()); 
            // InternalDataDsl.g:3408:2: ( rule__DataOperation__FeaturesAssignment_4_1 )
            // InternalDataDsl.g:3408:3: rule__DataOperation__FeaturesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__FeaturesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__1__Impl"


    // $ANTLR start "rule__DataOperation__Group_4__2"
    // InternalDataDsl.g:3416:1: rule__DataOperation__Group_4__2 : rule__DataOperation__Group_4__2__Impl rule__DataOperation__Group_4__3 ;
    public final void rule__DataOperation__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3420:1: ( rule__DataOperation__Group_4__2__Impl rule__DataOperation__Group_4__3 )
            // InternalDataDsl.g:3421:2: rule__DataOperation__Group_4__2__Impl rule__DataOperation__Group_4__3
            {
            pushFollow(FOLLOW_20);
            rule__DataOperation__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__2"


    // $ANTLR start "rule__DataOperation__Group_4__2__Impl"
    // InternalDataDsl.g:3428:1: rule__DataOperation__Group_4__2__Impl : ( ( rule__DataOperation__Group_4_2__0 )* ) ;
    public final void rule__DataOperation__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3432:1: ( ( ( rule__DataOperation__Group_4_2__0 )* ) )
            // InternalDataDsl.g:3433:1: ( ( rule__DataOperation__Group_4_2__0 )* )
            {
            // InternalDataDsl.g:3433:1: ( ( rule__DataOperation__Group_4_2__0 )* )
            // InternalDataDsl.g:3434:2: ( rule__DataOperation__Group_4_2__0 )*
            {
             before(grammarAccess.getDataOperationAccess().getGroup_4_2()); 
            // InternalDataDsl.g:3435:2: ( rule__DataOperation__Group_4_2__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==41) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalDataDsl.g:3435:3: rule__DataOperation__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataOperation__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getDataOperationAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__2__Impl"


    // $ANTLR start "rule__DataOperation__Group_4__3"
    // InternalDataDsl.g:3443:1: rule__DataOperation__Group_4__3 : rule__DataOperation__Group_4__3__Impl ;
    public final void rule__DataOperation__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3447:1: ( rule__DataOperation__Group_4__3__Impl )
            // InternalDataDsl.g:3448:2: rule__DataOperation__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__3"


    // $ANTLR start "rule__DataOperation__Group_4__3__Impl"
    // InternalDataDsl.g:3454:1: rule__DataOperation__Group_4__3__Impl : ( '>' ) ;
    public final void rule__DataOperation__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3458:1: ( ( '>' ) )
            // InternalDataDsl.g:3459:1: ( '>' )
            {
            // InternalDataDsl.g:3459:1: ( '>' )
            // InternalDataDsl.g:3460:2: '>'
            {
             before(grammarAccess.getDataOperationAccess().getGreaterThanSignKeyword_4_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getGreaterThanSignKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4__3__Impl"


    // $ANTLR start "rule__DataOperation__Group_4_2__0"
    // InternalDataDsl.g:3470:1: rule__DataOperation__Group_4_2__0 : rule__DataOperation__Group_4_2__0__Impl rule__DataOperation__Group_4_2__1 ;
    public final void rule__DataOperation__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3474:1: ( rule__DataOperation__Group_4_2__0__Impl rule__DataOperation__Group_4_2__1 )
            // InternalDataDsl.g:3475:2: rule__DataOperation__Group_4_2__0__Impl rule__DataOperation__Group_4_2__1
            {
            pushFollow(FOLLOW_35);
            rule__DataOperation__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4_2__0"


    // $ANTLR start "rule__DataOperation__Group_4_2__0__Impl"
    // InternalDataDsl.g:3482:1: rule__DataOperation__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__DataOperation__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3486:1: ( ( ',' ) )
            // InternalDataDsl.g:3487:1: ( ',' )
            {
            // InternalDataDsl.g:3487:1: ( ',' )
            // InternalDataDsl.g:3488:2: ','
            {
             before(grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDataOperationAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4_2__0__Impl"


    // $ANTLR start "rule__DataOperation__Group_4_2__1"
    // InternalDataDsl.g:3497:1: rule__DataOperation__Group_4_2__1 : rule__DataOperation__Group_4_2__1__Impl ;
    public final void rule__DataOperation__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3501:1: ( rule__DataOperation__Group_4_2__1__Impl )
            // InternalDataDsl.g:3502:2: rule__DataOperation__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4_2__1"


    // $ANTLR start "rule__DataOperation__Group_4_2__1__Impl"
    // InternalDataDsl.g:3508:1: rule__DataOperation__Group_4_2__1__Impl : ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) ) ;
    public final void rule__DataOperation__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3512:1: ( ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) ) )
            // InternalDataDsl.g:3513:1: ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) )
            {
            // InternalDataDsl.g:3513:1: ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) )
            // InternalDataDsl.g:3514:2: ( rule__DataOperation__FeaturesAssignment_4_2_1 )
            {
             before(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_2_1()); 
            // InternalDataDsl.g:3515:2: ( rule__DataOperation__FeaturesAssignment_4_2_1 )
            // InternalDataDsl.g:3515:3: rule__DataOperation__FeaturesAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataOperation__FeaturesAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__Group_4_2__1__Impl"


    // $ANTLR start "rule__DataOperationParameter__Group__0"
    // InternalDataDsl.g:3524:1: rule__DataOperationParameter__Group__0 : rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 ;
    public final void rule__DataOperationParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3528:1: ( rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 )
            // InternalDataDsl.g:3529:2: rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1
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
    // InternalDataDsl.g:3536:1: rule__DataOperationParameter__Group__0__Impl : ( ( rule__DataOperationParameter__Alternatives_0 ) ) ;
    public final void rule__DataOperationParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3540:1: ( ( ( rule__DataOperationParameter__Alternatives_0 ) ) )
            // InternalDataDsl.g:3541:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            {
            // InternalDataDsl.g:3541:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            // InternalDataDsl.g:3542:2: ( rule__DataOperationParameter__Alternatives_0 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getAlternatives_0()); 
            // InternalDataDsl.g:3543:2: ( rule__DataOperationParameter__Alternatives_0 )
            // InternalDataDsl.g:3543:3: rule__DataOperationParameter__Alternatives_0
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
    // InternalDataDsl.g:3551:1: rule__DataOperationParameter__Group__1 : rule__DataOperationParameter__Group__1__Impl ;
    public final void rule__DataOperationParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3555:1: ( rule__DataOperationParameter__Group__1__Impl )
            // InternalDataDsl.g:3556:2: rule__DataOperationParameter__Group__1__Impl
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
    // InternalDataDsl.g:3562:1: rule__DataOperationParameter__Group__1__Impl : ( ( rule__DataOperationParameter__NameAssignment_1 ) ) ;
    public final void rule__DataOperationParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3566:1: ( ( ( rule__DataOperationParameter__NameAssignment_1 ) ) )
            // InternalDataDsl.g:3567:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:3567:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            // InternalDataDsl.g:3568:2: ( rule__DataOperationParameter__NameAssignment_1 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:3569:2: ( rule__DataOperationParameter__NameAssignment_1 )
            // InternalDataDsl.g:3569:3: rule__DataOperationParameter__NameAssignment_1
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
    // InternalDataDsl.g:3578:1: rule__ImportedComplexType__Group__0 : rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1 ;
    public final void rule__ImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3582:1: ( rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1 )
            // InternalDataDsl.g:3583:2: rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalDataDsl.g:3590:1: rule__ImportedComplexType__Group__0__Impl : ( ( rule__ImportedComplexType__ImportAssignment_0 ) ) ;
    public final void rule__ImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3594:1: ( ( ( rule__ImportedComplexType__ImportAssignment_0 ) ) )
            // InternalDataDsl.g:3595:1: ( ( rule__ImportedComplexType__ImportAssignment_0 ) )
            {
            // InternalDataDsl.g:3595:1: ( ( rule__ImportedComplexType__ImportAssignment_0 ) )
            // InternalDataDsl.g:3596:2: ( rule__ImportedComplexType__ImportAssignment_0 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportAssignment_0()); 
            // InternalDataDsl.g:3597:2: ( rule__ImportedComplexType__ImportAssignment_0 )
            // InternalDataDsl.g:3597:3: rule__ImportedComplexType__ImportAssignment_0
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
    // InternalDataDsl.g:3605:1: rule__ImportedComplexType__Group__1 : rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2 ;
    public final void rule__ImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3609:1: ( rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2 )
            // InternalDataDsl.g:3610:2: rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2
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
    // InternalDataDsl.g:3617:1: rule__ImportedComplexType__Group__1__Impl : ( '::' ) ;
    public final void rule__ImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3621:1: ( ( '::' ) )
            // InternalDataDsl.g:3622:1: ( '::' )
            {
            // InternalDataDsl.g:3622:1: ( '::' )
            // InternalDataDsl.g:3623:2: '::'
            {
             before(grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1()); 
            match(input,48,FOLLOW_2); 
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
    // InternalDataDsl.g:3632:1: rule__ImportedComplexType__Group__2 : rule__ImportedComplexType__Group__2__Impl ;
    public final void rule__ImportedComplexType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3636:1: ( rule__ImportedComplexType__Group__2__Impl )
            // InternalDataDsl.g:3637:2: rule__ImportedComplexType__Group__2__Impl
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
    // InternalDataDsl.g:3643:1: rule__ImportedComplexType__Group__2__Impl : ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) ) ;
    public final void rule__ImportedComplexType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3647:1: ( ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) ) )
            // InternalDataDsl.g:3648:1: ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) )
            {
            // InternalDataDsl.g:3648:1: ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) )
            // InternalDataDsl.g:3649:2: ( rule__ImportedComplexType__ImportedTypeAssignment_2 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeAssignment_2()); 
            // InternalDataDsl.g:3650:2: ( rule__ImportedComplexType__ImportedTypeAssignment_2 )
            // InternalDataDsl.g:3650:3: rule__ImportedComplexType__ImportedTypeAssignment_2
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
    // InternalDataDsl.g:3659:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3663:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalDataDsl.g:3664:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalDataDsl.g:3671:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3675:1: ( ( () ) )
            // InternalDataDsl.g:3676:1: ( () )
            {
            // InternalDataDsl.g:3676:1: ( () )
            // InternalDataDsl.g:3677:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalDataDsl.g:3678:2: ()
            // InternalDataDsl.g:3678:3: 
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
    // InternalDataDsl.g:3686:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3690:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalDataDsl.g:3691:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalDataDsl.g:3697:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3701:1: ( ( 'boolean' ) )
            // InternalDataDsl.g:3702:1: ( 'boolean' )
            {
            // InternalDataDsl.g:3702:1: ( 'boolean' )
            // InternalDataDsl.g:3703:2: 'boolean'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalDataDsl.g:3713:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3717:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalDataDsl.g:3718:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalDataDsl.g:3725:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3729:1: ( ( () ) )
            // InternalDataDsl.g:3730:1: ( () )
            {
            // InternalDataDsl.g:3730:1: ( () )
            // InternalDataDsl.g:3731:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalDataDsl.g:3732:2: ()
            // InternalDataDsl.g:3732:3: 
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
    // InternalDataDsl.g:3740:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3744:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalDataDsl.g:3745:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalDataDsl.g:3751:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3755:1: ( ( 'byte' ) )
            // InternalDataDsl.g:3756:1: ( 'byte' )
            {
            // InternalDataDsl.g:3756:1: ( 'byte' )
            // InternalDataDsl.g:3757:2: 'byte'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 
            match(input,50,FOLLOW_2); 
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
    // InternalDataDsl.g:3767:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3771:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalDataDsl.g:3772:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalDataDsl.g:3779:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3783:1: ( ( () ) )
            // InternalDataDsl.g:3784:1: ( () )
            {
            // InternalDataDsl.g:3784:1: ( () )
            // InternalDataDsl.g:3785:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalDataDsl.g:3786:2: ()
            // InternalDataDsl.g:3786:3: 
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
    // InternalDataDsl.g:3794:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3798:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalDataDsl.g:3799:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalDataDsl.g:3805:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3809:1: ( ( 'char' ) )
            // InternalDataDsl.g:3810:1: ( 'char' )
            {
            // InternalDataDsl.g:3810:1: ( 'char' )
            // InternalDataDsl.g:3811:2: 'char'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalDataDsl.g:3821:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3825:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalDataDsl.g:3826:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalDataDsl.g:3833:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3837:1: ( ( () ) )
            // InternalDataDsl.g:3838:1: ( () )
            {
            // InternalDataDsl.g:3838:1: ( () )
            // InternalDataDsl.g:3839:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalDataDsl.g:3840:2: ()
            // InternalDataDsl.g:3840:3: 
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
    // InternalDataDsl.g:3848:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3852:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalDataDsl.g:3853:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalDataDsl.g:3859:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3863:1: ( ( 'date' ) )
            // InternalDataDsl.g:3864:1: ( 'date' )
            {
            // InternalDataDsl.g:3864:1: ( 'date' )
            // InternalDataDsl.g:3865:2: 'date'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalDataDsl.g:3875:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3879:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalDataDsl.g:3880:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalDataDsl.g:3887:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3891:1: ( ( () ) )
            // InternalDataDsl.g:3892:1: ( () )
            {
            // InternalDataDsl.g:3892:1: ( () )
            // InternalDataDsl.g:3893:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalDataDsl.g:3894:2: ()
            // InternalDataDsl.g:3894:3: 
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
    // InternalDataDsl.g:3902:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3906:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalDataDsl.g:3907:2: rule__PrimitiveType__Group_4__1__Impl
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
    // InternalDataDsl.g:3913:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3917:1: ( ( 'double' ) )
            // InternalDataDsl.g:3918:1: ( 'double' )
            {
            // InternalDataDsl.g:3918:1: ( 'double' )
            // InternalDataDsl.g:3919:2: 'double'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 
            match(input,53,FOLLOW_2); 
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
    // InternalDataDsl.g:3929:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3933:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalDataDsl.g:3934:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDataDsl.g:3941:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3945:1: ( ( () ) )
            // InternalDataDsl.g:3946:1: ( () )
            {
            // InternalDataDsl.g:3946:1: ( () )
            // InternalDataDsl.g:3947:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalDataDsl.g:3948:2: ()
            // InternalDataDsl.g:3948:3: 
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
    // InternalDataDsl.g:3956:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3960:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalDataDsl.g:3961:2: rule__PrimitiveType__Group_5__1__Impl
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
    // InternalDataDsl.g:3967:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3971:1: ( ( 'float' ) )
            // InternalDataDsl.g:3972:1: ( 'float' )
            {
            // InternalDataDsl.g:3972:1: ( 'float' )
            // InternalDataDsl.g:3973:2: 'float'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalDataDsl.g:3983:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3987:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalDataDsl.g:3988:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalDataDsl.g:3995:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3999:1: ( ( () ) )
            // InternalDataDsl.g:4000:1: ( () )
            {
            // InternalDataDsl.g:4000:1: ( () )
            // InternalDataDsl.g:4001:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalDataDsl.g:4002:2: ()
            // InternalDataDsl.g:4002:3: 
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
    // InternalDataDsl.g:4010:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4014:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalDataDsl.g:4015:2: rule__PrimitiveType__Group_6__1__Impl
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
    // InternalDataDsl.g:4021:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4025:1: ( ( 'int' ) )
            // InternalDataDsl.g:4026:1: ( 'int' )
            {
            // InternalDataDsl.g:4026:1: ( 'int' )
            // InternalDataDsl.g:4027:2: 'int'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalDataDsl.g:4037:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4041:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalDataDsl.g:4042:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDsl.g:4049:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4053:1: ( ( () ) )
            // InternalDataDsl.g:4054:1: ( () )
            {
            // InternalDataDsl.g:4054:1: ( () )
            // InternalDataDsl.g:4055:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalDataDsl.g:4056:2: ()
            // InternalDataDsl.g:4056:3: 
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
    // InternalDataDsl.g:4064:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4068:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalDataDsl.g:4069:2: rule__PrimitiveType__Group_7__1__Impl
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
    // InternalDataDsl.g:4075:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4079:1: ( ( 'long' ) )
            // InternalDataDsl.g:4080:1: ( 'long' )
            {
            // InternalDataDsl.g:4080:1: ( 'long' )
            // InternalDataDsl.g:4081:2: 'long'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 
            match(input,56,FOLLOW_2); 
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
    // InternalDataDsl.g:4091:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4095:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalDataDsl.g:4096:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalDataDsl.g:4103:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4107:1: ( ( () ) )
            // InternalDataDsl.g:4108:1: ( () )
            {
            // InternalDataDsl.g:4108:1: ( () )
            // InternalDataDsl.g:4109:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalDataDsl.g:4110:2: ()
            // InternalDataDsl.g:4110:3: 
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
    // InternalDataDsl.g:4118:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4122:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalDataDsl.g:4123:2: rule__PrimitiveType__Group_8__1__Impl
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
    // InternalDataDsl.g:4129:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4133:1: ( ( 'short' ) )
            // InternalDataDsl.g:4134:1: ( 'short' )
            {
            // InternalDataDsl.g:4134:1: ( 'short' )
            // InternalDataDsl.g:4135:2: 'short'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 
            match(input,57,FOLLOW_2); 
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
    // InternalDataDsl.g:4145:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4149:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalDataDsl.g:4150:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalDataDsl.g:4157:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4161:1: ( ( () ) )
            // InternalDataDsl.g:4162:1: ( () )
            {
            // InternalDataDsl.g:4162:1: ( () )
            // InternalDataDsl.g:4163:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalDataDsl.g:4164:2: ()
            // InternalDataDsl.g:4164:3: 
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
    // InternalDataDsl.g:4172:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4176:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalDataDsl.g:4177:2: rule__PrimitiveType__Group_9__1__Impl
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
    // InternalDataDsl.g:4183:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4187:1: ( ( 'string' ) )
            // InternalDataDsl.g:4188:1: ( 'string' )
            {
            // InternalDataDsl.g:4188:1: ( 'string' )
            // InternalDataDsl.g:4189:2: 'string'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 
            match(input,58,FOLLOW_2); 
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
    // InternalDataDsl.g:4199:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4203:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDsl.g:4204:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalDataDsl.g:4211:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4215:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4216:1: ( RULE_ID )
            {
            // InternalDataDsl.g:4216:1: ( RULE_ID )
            // InternalDataDsl.g:4217:2: RULE_ID
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
    // InternalDataDsl.g:4226:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4230:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDsl.g:4231:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDataDsl.g:4237:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4241:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDsl.g:4242:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDsl.g:4242:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDsl.g:4243:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDataDsl.g:4244:2: ( rule__QualifiedName__Group_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==59) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalDataDsl.g:4244:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_47);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalDataDsl.g:4253:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4257:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDsl.g:4258:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDataDsl.g:4265:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4269:1: ( ( '.' ) )
            // InternalDataDsl.g:4270:1: ( '.' )
            {
            // InternalDataDsl.g:4270:1: ( '.' )
            // InternalDataDsl.g:4271:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalDataDsl.g:4280:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4284:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDsl.g:4285:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDataDsl.g:4291:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4295:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4296:1: ( RULE_ID )
            {
            // InternalDataDsl.g:4296:1: ( RULE_ID )
            // InternalDataDsl.g:4297:2: RULE_ID
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
    // InternalDataDsl.g:4307:1: rule__DataModel__ComplexTypeImportsAssignment_0 : ( ruleComplexTypeImport ) ;
    public final void rule__DataModel__ComplexTypeImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4311:1: ( ( ruleComplexTypeImport ) )
            // InternalDataDsl.g:4312:2: ( ruleComplexTypeImport )
            {
            // InternalDataDsl.g:4312:2: ( ruleComplexTypeImport )
            // InternalDataDsl.g:4313:3: ruleComplexTypeImport
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
    // InternalDataDsl.g:4322:1: rule__DataModel__VersionsAssignment_1_0 : ( ruleVersion ) ;
    public final void rule__DataModel__VersionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4326:1: ( ( ruleVersion ) )
            // InternalDataDsl.g:4327:2: ( ruleVersion )
            {
            // InternalDataDsl.g:4327:2: ( ruleVersion )
            // InternalDataDsl.g:4328:3: ruleVersion
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
    // InternalDataDsl.g:4337:1: rule__DataModel__ContextsAssignment_1_1 : ( ruleContext ) ;
    public final void rule__DataModel__ContextsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4341:1: ( ( ruleContext ) )
            // InternalDataDsl.g:4342:2: ( ruleContext )
            {
            // InternalDataDsl.g:4342:2: ( ruleContext )
            // InternalDataDsl.g:4343:3: ruleContext
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
    // InternalDataDsl.g:4352:1: rule__DataModel__ComplexTypesAssignment_1_2 : ( ruleComplexType ) ;
    public final void rule__DataModel__ComplexTypesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4356:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4357:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4357:2: ( ruleComplexType )
            // InternalDataDsl.g:4358:3: ruleComplexType
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
    // InternalDataDsl.g:4367:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4371:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:4372:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:4372:2: ( RULE_STRING )
            // InternalDataDsl.g:4373:3: RULE_STRING
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
    // InternalDataDsl.g:4382:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4386:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4387:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4387:2: ( RULE_ID )
            // InternalDataDsl.g:4388:3: RULE_ID
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
    // InternalDataDsl.g:4397:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4401:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4402:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4402:2: ( RULE_ID )
            // InternalDataDsl.g:4403:3: RULE_ID
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
    // InternalDataDsl.g:4412:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4416:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4417:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4417:2: ( ruleComplexType )
            // InternalDataDsl.g:4418:3: ruleComplexType
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
    // InternalDataDsl.g:4427:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4431:1: ( ( ruleContext ) )
            // InternalDataDsl.g:4432:2: ( ruleContext )
            {
            // InternalDataDsl.g:4432:2: ( ruleContext )
            // InternalDataDsl.g:4433:3: ruleContext
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
    // InternalDataDsl.g:4442:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4446:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4447:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4447:2: ( RULE_ID )
            // InternalDataDsl.g:4448:3: RULE_ID
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
    // InternalDataDsl.g:4457:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4461:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4462:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4462:2: ( ruleComplexType )
            // InternalDataDsl.g:4463:3: ruleComplexType
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
    // InternalDataDsl.g:4472:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4476:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4477:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4477:2: ( RULE_ID )
            // InternalDataDsl.g:4478:3: RULE_ID
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


    // $ANTLR start "rule__DataStructure__FeaturesAssignment_2_1"
    // InternalDataDsl.g:4487:1: rule__DataStructure__FeaturesAssignment_2_1 : ( ruleDataStructureFeature ) ;
    public final void rule__DataStructure__FeaturesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4491:1: ( ( ruleDataStructureFeature ) )
            // InternalDataDsl.g:4492:2: ( ruleDataStructureFeature )
            {
            // InternalDataDsl.g:4492:2: ( ruleDataStructureFeature )
            // InternalDataDsl.g:4493:3: ruleDataStructureFeature
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataStructureFeature();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__FeaturesAssignment_2_1"


    // $ANTLR start "rule__DataStructure__FeaturesAssignment_2_2_1"
    // InternalDataDsl.g:4502:1: rule__DataStructure__FeaturesAssignment_2_2_1 : ( ruleDataStructureFeature ) ;
    public final void rule__DataStructure__FeaturesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4506:1: ( ( ruleDataStructureFeature ) )
            // InternalDataDsl.g:4507:2: ( ruleDataStructureFeature )
            {
            // InternalDataDsl.g:4507:2: ( ruleDataStructureFeature )
            // InternalDataDsl.g:4508:3: ruleDataStructureFeature
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataStructureFeature();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getFeaturesDataStructureFeatureEnumRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__FeaturesAssignment_2_2_1"


    // $ANTLR start "rule__DataStructure__SuperAssignment_3_1"
    // InternalDataDsl.g:4517:1: rule__DataStructure__SuperAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4521:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4522:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4522:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4523:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0()); 
            // InternalDataDsl.g:4524:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4525:4: ruleQualifiedName
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getSuperDataStructureQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__SuperAssignment_3_1"


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_5_0_0"
    // InternalDataDsl.g:4536:1: rule__DataStructure__DataFieldsAssignment_5_0_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_5_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4540:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4541:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4541:2: ( ruleDataField )
            // InternalDataDsl.g:4542:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_5_0_0"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_5_0_1"
    // InternalDataDsl.g:4551:1: rule__DataStructure__OperationsAssignment_5_0_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4555:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4556:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4556:2: ( ruleDataOperation )
            // InternalDataDsl.g:4557:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__OperationsAssignment_5_0_1"


    // $ANTLR start "rule__DataStructure__DataFieldsAssignment_5_1_1_0"
    // InternalDataDsl.g:4566:1: rule__DataStructure__DataFieldsAssignment_5_1_1_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_5_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4570:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4571:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4571:2: ( ruleDataField )
            // InternalDataDsl.g:4572:3: ruleDataField
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getDataFieldsDataFieldParserRuleCall_5_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__DataFieldsAssignment_5_1_1_0"


    // $ANTLR start "rule__DataStructure__OperationsAssignment_5_1_1_1"
    // InternalDataDsl.g:4581:1: rule__DataStructure__OperationsAssignment_5_1_1_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_5_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4585:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4586:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4586:2: ( ruleDataOperation )
            // InternalDataDsl.g:4587:3: ruleDataOperation
            {
             before(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperation();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getOperationsDataOperationParserRuleCall_5_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStructure__OperationsAssignment_5_1_1_1"


    // $ANTLR start "rule__ListType__NameAssignment_0_1"
    // InternalDataDsl.g:4596:1: rule__ListType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4600:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4601:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4601:2: ( RULE_ID )
            // InternalDataDsl.g:4602:3: RULE_ID
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
    // InternalDataDsl.g:4611:1: rule__ListType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4615:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4616:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4616:2: ( ruleDataField )
            // InternalDataDsl.g:4617:3: ruleDataField
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
    // InternalDataDsl.g:4626:1: rule__ListType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4630:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4631:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4631:2: ( ruleDataField )
            // InternalDataDsl.g:4632:3: ruleDataField
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
    // InternalDataDsl.g:4641:1: rule__ListType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4645:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4646:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4646:2: ( RULE_ID )
            // InternalDataDsl.g:4647:3: RULE_ID
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
    // InternalDataDsl.g:4656:1: rule__ListType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__ListType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4660:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4661:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4661:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4662:3: rulePrimitiveType
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
    // InternalDataDsl.g:4671:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4675:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:4676:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:4676:2: ( ( 'hide' ) )
            // InternalDataDsl.g:4677:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:4678:3: ( 'hide' )
            // InternalDataDsl.g:4679:4: 'hide'
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
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


    // $ANTLR start "rule__DataField__ImmutableAssignment_1"
    // InternalDataDsl.g:4690:1: rule__DataField__ImmutableAssignment_1 : ( ( 'immutable' ) ) ;
    public final void rule__DataField__ImmutableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4694:1: ( ( ( 'immutable' ) ) )
            // InternalDataDsl.g:4695:2: ( ( 'immutable' ) )
            {
            // InternalDataDsl.g:4695:2: ( ( 'immutable' ) )
            // InternalDataDsl.g:4696:3: ( 'immutable' )
            {
             before(grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0()); 
            // InternalDataDsl.g:4697:3: ( 'immutable' )
            // InternalDataDsl.g:4698:4: 'immutable'
            {
             before(grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0()); 

            }

             after(grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__ImmutableAssignment_1"


    // $ANTLR start "rule__DataField__PrimitiveTypeAssignment_2_0"
    // InternalDataDsl.g:4709:1: rule__DataField__PrimitiveTypeAssignment_2_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4713:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4714:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4714:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4715:3: rulePrimitiveType
            {
             before(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__PrimitiveTypeAssignment_2_0"


    // $ANTLR start "rule__DataField__ComplexTypeAssignment_2_1"
    // InternalDataDsl.g:4724:1: rule__DataField__ComplexTypeAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataField__ComplexTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4728:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4729:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4729:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4730:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0()); 
            // InternalDataDsl.g:4731:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4732:4: ruleQualifiedName
            {
             before(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__ComplexTypeAssignment_2_1"


    // $ANTLR start "rule__DataField__ImportedComplexTypeAssignment_2_2"
    // InternalDataDsl.g:4743:1: rule__DataField__ImportedComplexTypeAssignment_2_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataField__ImportedComplexTypeAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4747:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:4748:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:4748:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:4749:3: ruleImportedComplexType
            {
             before(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedComplexType();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getImportedComplexTypeImportedComplexTypeParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__ImportedComplexTypeAssignment_2_2"


    // $ANTLR start "rule__DataField__NameAssignment_3"
    // InternalDataDsl.g:4758:1: rule__DataField__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4762:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4763:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4763:2: ( RULE_ID )
            // InternalDataDsl.g:4764:3: RULE_ID
            {
             before(grammarAccess.getDataFieldAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__NameAssignment_3"


    // $ANTLR start "rule__DataField__FeaturesAssignment_4_1"
    // InternalDataDsl.g:4773:1: rule__DataField__FeaturesAssignment_4_1 : ( ruleDataFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4777:1: ( ( ruleDataFieldFeature ) )
            // InternalDataDsl.g:4778:2: ( ruleDataFieldFeature )
            {
            // InternalDataDsl.g:4778:2: ( ruleDataFieldFeature )
            // InternalDataDsl.g:4779:3: ruleDataFieldFeature
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataFieldFeature();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__FeaturesAssignment_4_1"


    // $ANTLR start "rule__DataField__FeaturesAssignment_4_2_1"
    // InternalDataDsl.g:4788:1: rule__DataField__FeaturesAssignment_4_2_1 : ( ruleDataFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4792:1: ( ( ruleDataFieldFeature ) )
            // InternalDataDsl.g:4793:2: ( ruleDataFieldFeature )
            {
            // InternalDataDsl.g:4793:2: ( ruleDataFieldFeature )
            // InternalDataDsl.g:4794:3: ruleDataFieldFeature
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataFieldFeature();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__FeaturesAssignment_4_2_1"


    // $ANTLR start "rule__Enumeration__NameAssignment_1"
    // InternalDataDsl.g:4803:1: rule__Enumeration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4807:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4808:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4808:2: ( RULE_ID )
            // InternalDataDsl.g:4809:3: RULE_ID
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
    // InternalDataDsl.g:4818:1: rule__Enumeration__FieldsAssignment_3 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4822:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:4823:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:4823:2: ( ruleEnumerationField )
            // InternalDataDsl.g:4824:3: ruleEnumerationField
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
    // InternalDataDsl.g:4833:1: rule__Enumeration__FieldsAssignment_4_1 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4837:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:4838:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:4838:2: ( ruleEnumerationField )
            // InternalDataDsl.g:4839:3: ruleEnumerationField
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
    // InternalDataDsl.g:4848:1: rule__EnumerationField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EnumerationField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4852:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4853:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4853:2: ( RULE_ID )
            // InternalDataDsl.g:4854:3: RULE_ID
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
    // InternalDataDsl.g:4863:1: rule__EnumerationField__InitializationValueAssignment_1_1 : ( rulePrimitiveValue ) ;
    public final void rule__EnumerationField__InitializationValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4867:1: ( ( rulePrimitiveValue ) )
            // InternalDataDsl.g:4868:2: ( rulePrimitiveValue )
            {
            // InternalDataDsl.g:4868:2: ( rulePrimitiveValue )
            // InternalDataDsl.g:4869:3: rulePrimitiveValue
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
    // InternalDataDsl.g:4878:1: rule__DataOperation__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataOperation__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4882:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:4883:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:4883:2: ( ( 'hide' ) )
            // InternalDataDsl.g:4884:3: ( 'hide' )
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:4885:3: ( 'hide' )
            // InternalDataDsl.g:4886:4: 'hide'
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
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
    // InternalDataDsl.g:4897:1: rule__DataOperation__HasNoReturnTypeAssignment_1_0 : ( ( 'procedure' ) ) ;
    public final void rule__DataOperation__HasNoReturnTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4901:1: ( ( ( 'procedure' ) ) )
            // InternalDataDsl.g:4902:2: ( ( 'procedure' ) )
            {
            // InternalDataDsl.g:4902:2: ( ( 'procedure' ) )
            // InternalDataDsl.g:4903:3: ( 'procedure' )
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            // InternalDataDsl.g:4904:3: ( 'procedure' )
            // InternalDataDsl.g:4905:4: 'procedure'
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalDataDsl.g:4916:1: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4920:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4921:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4921:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4922:3: rulePrimitiveType
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
    // InternalDataDsl.g:4931:1: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4935:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4936:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4936:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4937:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0()); 
            // InternalDataDsl.g:4938:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4939:4: ruleQualifiedName
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
    // InternalDataDsl.g:4950:1: rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4954:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:4955:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:4955:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:4956:3: ruleImportedComplexType
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
    // InternalDataDsl.g:4965:1: rule__DataOperation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataOperation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4969:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4970:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4970:2: ( RULE_ID )
            // InternalDataDsl.g:4971:3: RULE_ID
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
    // InternalDataDsl.g:4980:1: rule__DataOperation__ParametersAssignment_3_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4984:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:4985:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:4985:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:4986:3: ruleDataOperationParameter
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
    // InternalDataDsl.g:4995:1: rule__DataOperation__ParametersAssignment_3_2_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4999:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:5000:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:5000:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:5001:3: ruleDataOperationParameter
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


    // $ANTLR start "rule__DataOperation__FeaturesAssignment_4_1"
    // InternalDataDsl.g:5010:1: rule__DataOperation__FeaturesAssignment_4_1 : ( ruleDataOperationFeature ) ;
    public final void rule__DataOperation__FeaturesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5014:1: ( ( ruleDataOperationFeature ) )
            // InternalDataDsl.g:5015:2: ( ruleDataOperationFeature )
            {
            // InternalDataDsl.g:5015:2: ( ruleDataOperationFeature )
            // InternalDataDsl.g:5016:3: ruleDataOperationFeature
            {
             before(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperationFeature();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__FeaturesAssignment_4_1"


    // $ANTLR start "rule__DataOperation__FeaturesAssignment_4_2_1"
    // InternalDataDsl.g:5025:1: rule__DataOperation__FeaturesAssignment_4_2_1 : ( ruleDataOperationFeature ) ;
    public final void rule__DataOperation__FeaturesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5029:1: ( ( ruleDataOperationFeature ) )
            // InternalDataDsl.g:5030:2: ( ruleDataOperationFeature )
            {
            // InternalDataDsl.g:5030:2: ( ruleDataOperationFeature )
            // InternalDataDsl.g:5031:3: ruleDataOperationFeature
            {
             before(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataOperationFeature();

            state._fsp--;

             after(grammarAccess.getDataOperationAccess().getFeaturesDataOperationFeatureEnumRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataOperation__FeaturesAssignment_4_2_1"


    // $ANTLR start "rule__DataOperationParameter__PrimitiveTypeAssignment_0_0"
    // InternalDataDsl.g:5040:1: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperationParameter__PrimitiveTypeAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5044:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:5045:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:5045:2: ( rulePrimitiveType )
            // InternalDataDsl.g:5046:3: rulePrimitiveType
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
    // InternalDataDsl.g:5055:1: rule__DataOperationParameter__ComplexTypeAssignment_0_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataOperationParameter__ComplexTypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5059:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:5060:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:5060:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:5061:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0()); 
            // InternalDataDsl.g:5062:3: ( ruleQualifiedName )
            // InternalDataDsl.g:5063:4: ruleQualifiedName
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
    // InternalDataDsl.g:5074:1: rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5078:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:5079:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:5079:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:5080:3: ruleImportedComplexType
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
    // InternalDataDsl.g:5089:1: rule__DataOperationParameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataOperationParameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5093:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:5094:2: ( RULE_ID )
            {
            // InternalDataDsl.g:5094:2: ( RULE_ID )
            // InternalDataDsl.g:5095:3: RULE_ID
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
    // InternalDataDsl.g:5104:1: rule__PrimitiveValue__NumericValueAssignment_0 : ( RULE_BIG_DECIMAL ) ;
    public final void rule__PrimitiveValue__NumericValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5108:1: ( ( RULE_BIG_DECIMAL ) )
            // InternalDataDsl.g:5109:2: ( RULE_BIG_DECIMAL )
            {
            // InternalDataDsl.g:5109:2: ( RULE_BIG_DECIMAL )
            // InternalDataDsl.g:5110:3: RULE_BIG_DECIMAL
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
    // InternalDataDsl.g:5119:1: rule__PrimitiveValue__BooleanValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__PrimitiveValue__BooleanValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5123:1: ( ( RULE_BOOLEAN ) )
            // InternalDataDsl.g:5124:2: ( RULE_BOOLEAN )
            {
            // InternalDataDsl.g:5124:2: ( RULE_BOOLEAN )
            // InternalDataDsl.g:5125:3: RULE_BOOLEAN
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
    // InternalDataDsl.g:5134:1: rule__PrimitiveValue__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5138:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:5139:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:5139:2: ( RULE_STRING )
            // InternalDataDsl.g:5140:3: RULE_STRING
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
    // InternalDataDsl.g:5149:1: rule__ImportedComplexType__ImportAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ImportedComplexType__ImportAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5153:1: ( ( ( RULE_ID ) ) )
            // InternalDataDsl.g:5154:2: ( ( RULE_ID ) )
            {
            // InternalDataDsl.g:5154:2: ( ( RULE_ID ) )
            // InternalDataDsl.g:5155:3: ( RULE_ID )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0()); 
            // InternalDataDsl.g:5156:3: ( RULE_ID )
            // InternalDataDsl.g:5157:4: RULE_ID
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
    // InternalDataDsl.g:5168:1: rule__ImportedComplexType__ImportedTypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ImportedComplexType__ImportedTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5172:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:5173:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:5173:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:5174:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeCrossReference_2_0()); 
            // InternalDataDsl.g:5175:3: ( ruleQualifiedName )
            // InternalDataDsl.g:5176:4: ruleQualifiedName
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
    static final String dfa_2s = "\1\53\1\4\1\43\13\4\2\uffff";
    static final String dfa_3s = "\1\53\1\4\1\43\1\75\12\44\2\uffff";
    static final String dfa_4s = "\16\uffff\1\1\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\16\54\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\uffff\2\16",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
            "\1\16\37\uffff\1\17",
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
            return "652:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000186400000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000187000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000184000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000048800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x77FE801000000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000FFE000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x77FE800000000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x37FE000000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000021000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x07FE000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x07FE000000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x07FE420000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000039000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0800000000000002L});

}