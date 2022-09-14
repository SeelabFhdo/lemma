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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'aggregate'", "'applicationService'", "'domainEvent'", "'domainService'", "'entity'", "'factory'", "'infrastructureService'", "'repository'", "'service'", "'specification'", "'valueObject'", "'identifier'", "'neverEmpty'", "'part'", "'closure'", "'sideEffectFree'", "'validator'", "'import'", "'datatypes'", "'from'", "'as'", "'version'", "'{'", "'}'", "'context'", "'structure'", "'<'", "'>'", "','", "'extends'", "'collection'", "'='", "'enum'", "'('", "')'", "'function'", "'::'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'unspecified'", "'.'", "'hide'", "'immutable'", "'procedure'"
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
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
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


    // $ANTLR start "entryRuleCollectionType"
    // InternalDataDsl.g:203:1: entryRuleCollectionType : ruleCollectionType EOF ;
    public final void entryRuleCollectionType() throws RecognitionException {
        try {
            // InternalDataDsl.g:204:1: ( ruleCollectionType EOF )
            // InternalDataDsl.g:205:1: ruleCollectionType EOF
            {
             before(grammarAccess.getCollectionTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleCollectionType();

            state._fsp--;

             after(grammarAccess.getCollectionTypeRule()); 
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
    // $ANTLR end "entryRuleCollectionType"


    // $ANTLR start "ruleCollectionType"
    // InternalDataDsl.g:212:1: ruleCollectionType : ( ( rule__CollectionType__Alternatives ) ) ;
    public final void ruleCollectionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:216:2: ( ( ( rule__CollectionType__Alternatives ) ) )
            // InternalDataDsl.g:217:2: ( ( rule__CollectionType__Alternatives ) )
            {
            // InternalDataDsl.g:217:2: ( ( rule__CollectionType__Alternatives ) )
            // InternalDataDsl.g:218:3: ( rule__CollectionType__Alternatives )
            {
             before(grammarAccess.getCollectionTypeAccess().getAlternatives()); 
            // InternalDataDsl.g:219:3: ( rule__CollectionType__Alternatives )
            // InternalDataDsl.g:219:4: rule__CollectionType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionType"


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


    // $ANTLR start "ruleComplexTypeFeature"
    // InternalDataDsl.g:453:1: ruleComplexTypeFeature : ( ( rule__ComplexTypeFeature__Alternatives ) ) ;
    public final void ruleComplexTypeFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:457:1: ( ( ( rule__ComplexTypeFeature__Alternatives ) ) )
            // InternalDataDsl.g:458:2: ( ( rule__ComplexTypeFeature__Alternatives ) )
            {
            // InternalDataDsl.g:458:2: ( ( rule__ComplexTypeFeature__Alternatives ) )
            // InternalDataDsl.g:459:3: ( rule__ComplexTypeFeature__Alternatives )
            {
             before(grammarAccess.getComplexTypeFeatureAccess().getAlternatives()); 
            // InternalDataDsl.g:460:3: ( rule__ComplexTypeFeature__Alternatives )
            // InternalDataDsl.g:460:4: rule__ComplexTypeFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComplexTypeFeature__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComplexTypeFeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexTypeFeature"


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
            case 45:
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

                        if ( (LA3_0==38||LA3_0==43||LA3_0==45) ) {
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

            if ( (LA7_0==38||LA7_0==43||LA7_0==45) ) {
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

                        if ( (LA5_0==38||LA5_0==43||LA5_0==45) ) {
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
    // InternalDataDsl.g:583:1: rule__ComplexType__Alternatives : ( ( ruleDataStructure ) | ( ruleCollectionType ) | ( ruleEnumeration ) );
    public final void rule__ComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:587:1: ( ( ruleDataStructure ) | ( ruleCollectionType ) | ( ruleEnumeration ) )
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
            case 45:
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
                    // InternalDataDsl.g:594:2: ( ruleCollectionType )
                    {
                    // InternalDataDsl.g:594:2: ( ruleCollectionType )
                    // InternalDataDsl.g:595:3: ruleCollectionType
                    {
                     before(grammarAccess.getComplexTypeAccess().getCollectionTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCollectionType();

                    state._fsp--;

                     after(grammarAccess.getComplexTypeAccess().getCollectionTypeParserRuleCall_1()); 

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
            case 62:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==48||LA9_1==64) ) {
                    alt9=2;
                }
                else if ( (LA9_1==RULE_ID||(LA9_1>=50 && LA9_1<=60)||LA9_1==63) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 63:
                {
                alt9=1;
                }
                break;
            case 48:
            case 64:
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
            case 62:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_ID||(LA10_1>=50 && LA10_1<=60)||LA10_1==63) ) {
                    alt10=1;
                }
                else if ( (LA10_1==48||LA10_1==64) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 63:
                {
                alt10=1;
                }
                break;
            case 48:
            case 64:
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


    // $ANTLR start "rule__CollectionType__Alternatives"
    // InternalDataDsl.g:652:1: rule__CollectionType__Alternatives : ( ( ( rule__CollectionType__Group_0__0 ) ) | ( ( rule__CollectionType__Group_1__0 ) ) );
    public final void rule__CollectionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:656:1: ( ( ( rule__CollectionType__Group_0__0 ) ) | ( ( rule__CollectionType__Group_1__0 ) ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalDataDsl.g:657:2: ( ( rule__CollectionType__Group_0__0 ) )
                    {
                    // InternalDataDsl.g:657:2: ( ( rule__CollectionType__Group_0__0 ) )
                    // InternalDataDsl.g:658:3: ( rule__CollectionType__Group_0__0 )
                    {
                     before(grammarAccess.getCollectionTypeAccess().getGroup_0()); 
                    // InternalDataDsl.g:659:3: ( rule__CollectionType__Group_0__0 )
                    // InternalDataDsl.g:659:4: rule__CollectionType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CollectionType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCollectionTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:663:2: ( ( rule__CollectionType__Group_1__0 ) )
                    {
                    // InternalDataDsl.g:663:2: ( ( rule__CollectionType__Group_1__0 ) )
                    // InternalDataDsl.g:664:3: ( rule__CollectionType__Group_1__0 )
                    {
                     before(grammarAccess.getCollectionTypeAccess().getGroup_1()); 
                    // InternalDataDsl.g:665:3: ( rule__CollectionType__Group_1__0 )
                    // InternalDataDsl.g:665:4: rule__CollectionType__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CollectionType__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCollectionTypeAccess().getGroup_1()); 

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
    // $ANTLR end "rule__CollectionType__Alternatives"


    // $ANTLR start "rule__DataField__Alternatives_2"
    // InternalDataDsl.g:673:1: rule__DataField__Alternatives_2 : ( ( ( rule__DataField__PrimitiveTypeAssignment_2_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_2_1 ) ) | ( ( rule__DataField__ImportedComplexTypeAssignment_2_2 ) ) );
    public final void rule__DataField__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:677:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_2_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_2_1 ) ) | ( ( rule__DataField__ImportedComplexTypeAssignment_2_2 ) ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=50 && LA12_0<=60)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==49) ) {
                    alt12=3;
                }
                else if ( (LA12_2==RULE_ID||LA12_2==61) ) {
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

            if ( (LA13_0==64) ) {
                alt13=1;
            }
            else if ( (LA13_0==48) ) {
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

            if ( ((LA14_0>=50 && LA14_0<=60)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==49) ) {
                    alt14=3;
                }
                else if ( (LA14_2==RULE_ID||LA14_2==61) ) {
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

            if ( ((LA15_0>=50 && LA15_0<=60)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==49) ) {
                    alt15=3;
                }
                else if ( (LA15_2==RULE_ID||LA15_2==61) ) {
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
    // InternalDataDsl.g:802:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) | ( ( rule__PrimitiveType__Group_10__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:806:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) | ( ( rule__PrimitiveType__Group_10__0 ) ) )
            int alt17=11;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt17=1;
                }
                break;
            case 51:
                {
                alt17=2;
                }
                break;
            case 52:
                {
                alt17=3;
                }
                break;
            case 53:
                {
                alt17=4;
                }
                break;
            case 54:
                {
                alt17=5;
                }
                break;
            case 55:
                {
                alt17=6;
                }
                break;
            case 56:
                {
                alt17=7;
                }
                break;
            case 57:
                {
                alt17=8;
                }
                break;
            case 58:
                {
                alt17=9;
                }
                break;
            case 59:
                {
                alt17=10;
                }
                break;
            case 60:
                {
                alt17=11;
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
                case 11 :
                    // InternalDataDsl.g:867:2: ( ( rule__PrimitiveType__Group_10__0 ) )
                    {
                    // InternalDataDsl.g:867:2: ( ( rule__PrimitiveType__Group_10__0 ) )
                    // InternalDataDsl.g:868:3: ( rule__PrimitiveType__Group_10__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_10()); 
                    // InternalDataDsl.g:869:3: ( rule__PrimitiveType__Group_10__0 )
                    // InternalDataDsl.g:869:4: rule__PrimitiveType__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveType__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveTypeAccess().getGroup_10()); 

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


    // $ANTLR start "rule__ComplexTypeFeature__Alternatives"
    // InternalDataDsl.g:877:1: rule__ComplexTypeFeature__Alternatives : ( ( ( 'aggregate' ) ) | ( ( 'applicationService' ) ) | ( ( 'domainEvent' ) ) | ( ( 'domainService' ) ) | ( ( 'entity' ) ) | ( ( 'factory' ) ) | ( ( 'infrastructureService' ) ) | ( ( 'repository' ) ) | ( ( 'service' ) ) | ( ( 'specification' ) ) | ( ( 'valueObject' ) ) );
    public final void rule__ComplexTypeFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:881:1: ( ( ( 'aggregate' ) ) | ( ( 'applicationService' ) ) | ( ( 'domainEvent' ) ) | ( ( 'domainService' ) ) | ( ( 'entity' ) ) | ( ( 'factory' ) ) | ( ( 'infrastructureService' ) ) | ( ( 'repository' ) ) | ( ( 'service' ) ) | ( ( 'specification' ) ) | ( ( 'valueObject' ) ) )
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
                    // InternalDataDsl.g:882:2: ( ( 'aggregate' ) )
                    {
                    // InternalDataDsl.g:882:2: ( ( 'aggregate' ) )
                    // InternalDataDsl.g:883:3: ( 'aggregate' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0()); 
                    // InternalDataDsl.g:884:3: ( 'aggregate' )
                    // InternalDataDsl.g:884:4: 'aggregate'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getAGGREGATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:888:2: ( ( 'applicationService' ) )
                    {
                    // InternalDataDsl.g:888:2: ( ( 'applicationService' ) )
                    // InternalDataDsl.g:889:3: ( 'applicationService' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1()); 
                    // InternalDataDsl.g:890:3: ( 'applicationService' )
                    // InternalDataDsl.g:890:4: 'applicationService'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getAPPLICATION_SERVICEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:894:2: ( ( 'domainEvent' ) )
                    {
                    // InternalDataDsl.g:894:2: ( ( 'domainEvent' ) )
                    // InternalDataDsl.g:895:3: ( 'domainEvent' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2()); 
                    // InternalDataDsl.g:896:3: ( 'domainEvent' )
                    // InternalDataDsl.g:896:4: 'domainEvent'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_EVENTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:900:2: ( ( 'domainService' ) )
                    {
                    // InternalDataDsl.g:900:2: ( ( 'domainService' ) )
                    // InternalDataDsl.g:901:3: ( 'domainService' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3()); 
                    // InternalDataDsl.g:902:3: ( 'domainService' )
                    // InternalDataDsl.g:902:4: 'domainService'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getDOMAIN_SERVICEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDataDsl.g:906:2: ( ( 'entity' ) )
                    {
                    // InternalDataDsl.g:906:2: ( ( 'entity' ) )
                    // InternalDataDsl.g:907:3: ( 'entity' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4()); 
                    // InternalDataDsl.g:908:3: ( 'entity' )
                    // InternalDataDsl.g:908:4: 'entity'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getENTITYEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDataDsl.g:912:2: ( ( 'factory' ) )
                    {
                    // InternalDataDsl.g:912:2: ( ( 'factory' ) )
                    // InternalDataDsl.g:913:3: ( 'factory' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5()); 
                    // InternalDataDsl.g:914:3: ( 'factory' )
                    // InternalDataDsl.g:914:4: 'factory'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getFACTORYEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDataDsl.g:918:2: ( ( 'infrastructureService' ) )
                    {
                    // InternalDataDsl.g:918:2: ( ( 'infrastructureService' ) )
                    // InternalDataDsl.g:919:3: ( 'infrastructureService' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6()); 
                    // InternalDataDsl.g:920:3: ( 'infrastructureService' )
                    // InternalDataDsl.g:920:4: 'infrastructureService'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getINFRASTRUCTURE_SERVICEEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDataDsl.g:924:2: ( ( 'repository' ) )
                    {
                    // InternalDataDsl.g:924:2: ( ( 'repository' ) )
                    // InternalDataDsl.g:925:3: ( 'repository' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7()); 
                    // InternalDataDsl.g:926:3: ( 'repository' )
                    // InternalDataDsl.g:926:4: 'repository'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getREPOSITORYEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDataDsl.g:930:2: ( ( 'service' ) )
                    {
                    // InternalDataDsl.g:930:2: ( ( 'service' ) )
                    // InternalDataDsl.g:931:3: ( 'service' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8()); 
                    // InternalDataDsl.g:932:3: ( 'service' )
                    // InternalDataDsl.g:932:4: 'service'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getSERVICEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDataDsl.g:936:2: ( ( 'specification' ) )
                    {
                    // InternalDataDsl.g:936:2: ( ( 'specification' ) )
                    // InternalDataDsl.g:937:3: ( 'specification' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9()); 
                    // InternalDataDsl.g:938:3: ( 'specification' )
                    // InternalDataDsl.g:938:4: 'specification'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getSPECIFICATIONEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDataDsl.g:942:2: ( ( 'valueObject' ) )
                    {
                    // InternalDataDsl.g:942:2: ( ( 'valueObject' ) )
                    // InternalDataDsl.g:943:3: ( 'valueObject' )
                    {
                     before(grammarAccess.getComplexTypeFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10()); 
                    // InternalDataDsl.g:944:3: ( 'valueObject' )
                    // InternalDataDsl.g:944:4: 'valueObject'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getComplexTypeFeatureAccess().getVALUE_OBJECTEnumLiteralDeclaration_10()); 

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
    // $ANTLR end "rule__ComplexTypeFeature__Alternatives"


    // $ANTLR start "rule__DataFieldFeature__Alternatives"
    // InternalDataDsl.g:952:1: rule__DataFieldFeature__Alternatives : ( ( ( 'identifier' ) ) | ( ( 'neverEmpty' ) ) | ( ( 'part' ) ) );
    public final void rule__DataFieldFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:956:1: ( ( ( 'identifier' ) ) | ( ( 'neverEmpty' ) ) | ( ( 'part' ) ) )
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
                    // InternalDataDsl.g:957:2: ( ( 'identifier' ) )
                    {
                    // InternalDataDsl.g:957:2: ( ( 'identifier' ) )
                    // InternalDataDsl.g:958:3: ( 'identifier' )
                    {
                     before(grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0()); 
                    // InternalDataDsl.g:959:3: ( 'identifier' )
                    // InternalDataDsl.g:959:4: 'identifier'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataFieldFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:963:2: ( ( 'neverEmpty' ) )
                    {
                    // InternalDataDsl.g:963:2: ( ( 'neverEmpty' ) )
                    // InternalDataDsl.g:964:3: ( 'neverEmpty' )
                    {
                     before(grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1()); 
                    // InternalDataDsl.g:965:3: ( 'neverEmpty' )
                    // InternalDataDsl.g:965:4: 'neverEmpty'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataFieldFeatureAccess().getNEVER_EMPTYEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:969:2: ( ( 'part' ) )
                    {
                    // InternalDataDsl.g:969:2: ( ( 'part' ) )
                    // InternalDataDsl.g:970:3: ( 'part' )
                    {
                     before(grammarAccess.getDataFieldFeatureAccess().getPARTEnumLiteralDeclaration_2()); 
                    // InternalDataDsl.g:971:3: ( 'part' )
                    // InternalDataDsl.g:971:4: 'part'
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
    // InternalDataDsl.g:979:1: rule__DataOperationFeature__Alternatives : ( ( ( 'closure' ) ) | ( ( 'identifier' ) ) | ( ( 'sideEffectFree' ) ) | ( ( 'validator' ) ) );
    public final void rule__DataOperationFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:983:1: ( ( ( 'closure' ) ) | ( ( 'identifier' ) ) | ( ( 'sideEffectFree' ) ) | ( ( 'validator' ) ) )
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
                    // InternalDataDsl.g:984:2: ( ( 'closure' ) )
                    {
                    // InternalDataDsl.g:984:2: ( ( 'closure' ) )
                    // InternalDataDsl.g:985:3: ( 'closure' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0()); 
                    // InternalDataDsl.g:986:3: ( 'closure' )
                    // InternalDataDsl.g:986:4: 'closure'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getCLOSUREEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:990:2: ( ( 'identifier' ) )
                    {
                    // InternalDataDsl.g:990:2: ( ( 'identifier' ) )
                    // InternalDataDsl.g:991:3: ( 'identifier' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1()); 
                    // InternalDataDsl.g:992:3: ( 'identifier' )
                    // InternalDataDsl.g:992:4: 'identifier'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getIDENTIFIEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDataDsl.g:996:2: ( ( 'sideEffectFree' ) )
                    {
                    // InternalDataDsl.g:996:2: ( ( 'sideEffectFree' ) )
                    // InternalDataDsl.g:997:3: ( 'sideEffectFree' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2()); 
                    // InternalDataDsl.g:998:3: ( 'sideEffectFree' )
                    // InternalDataDsl.g:998:4: 'sideEffectFree'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataOperationFeatureAccess().getSIDE_EFFECT_FREEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDataDsl.g:1002:2: ( ( 'validator' ) )
                    {
                    // InternalDataDsl.g:1002:2: ( ( 'validator' ) )
                    // InternalDataDsl.g:1003:3: ( 'validator' )
                    {
                     before(grammarAccess.getDataOperationFeatureAccess().getVALIDATOREnumLiteralDeclaration_3()); 
                    // InternalDataDsl.g:1004:3: ( 'validator' )
                    // InternalDataDsl.g:1004:4: 'validator'
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
    // InternalDataDsl.g:1012:1: rule__DataModel__Group__0 : rule__DataModel__Group__0__Impl rule__DataModel__Group__1 ;
    public final void rule__DataModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1016:1: ( rule__DataModel__Group__0__Impl rule__DataModel__Group__1 )
            // InternalDataDsl.g:1017:2: rule__DataModel__Group__0__Impl rule__DataModel__Group__1
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
    // InternalDataDsl.g:1024:1: rule__DataModel__Group__0__Impl : ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) ;
    public final void rule__DataModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1028:1: ( ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* ) )
            // InternalDataDsl.g:1029:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            {
            // InternalDataDsl.g:1029:1: ( ( rule__DataModel__ComplexTypeImportsAssignment_0 )* )
            // InternalDataDsl.g:1030:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            {
             before(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0()); 
            // InternalDataDsl.g:1031:2: ( rule__DataModel__ComplexTypeImportsAssignment_0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDataDsl.g:1031:3: rule__DataModel__ComplexTypeImportsAssignment_0
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
    // InternalDataDsl.g:1039:1: rule__DataModel__Group__1 : rule__DataModel__Group__1__Impl ;
    public final void rule__DataModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1043:1: ( rule__DataModel__Group__1__Impl )
            // InternalDataDsl.g:1044:2: rule__DataModel__Group__1__Impl
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
    // InternalDataDsl.g:1050:1: rule__DataModel__Group__1__Impl : ( ( rule__DataModel__Alternatives_1 ) ) ;
    public final void rule__DataModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1054:1: ( ( ( rule__DataModel__Alternatives_1 ) ) )
            // InternalDataDsl.g:1055:1: ( ( rule__DataModel__Alternatives_1 ) )
            {
            // InternalDataDsl.g:1055:1: ( ( rule__DataModel__Alternatives_1 ) )
            // InternalDataDsl.g:1056:2: ( rule__DataModel__Alternatives_1 )
            {
             before(grammarAccess.getDataModelAccess().getAlternatives_1()); 
            // InternalDataDsl.g:1057:2: ( rule__DataModel__Alternatives_1 )
            // InternalDataDsl.g:1057:3: rule__DataModel__Alternatives_1
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
    // InternalDataDsl.g:1066:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1070:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalDataDsl.g:1071:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
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
    // InternalDataDsl.g:1078:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1082:1: ( ( 'import' ) )
            // InternalDataDsl.g:1083:1: ( 'import' )
            {
            // InternalDataDsl.g:1083:1: ( 'import' )
            // InternalDataDsl.g:1084:2: 'import'
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
    // InternalDataDsl.g:1093:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1097:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalDataDsl.g:1098:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
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
    // InternalDataDsl.g:1105:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1109:1: ( ( 'datatypes' ) )
            // InternalDataDsl.g:1110:1: ( 'datatypes' )
            {
            // InternalDataDsl.g:1110:1: ( 'datatypes' )
            // InternalDataDsl.g:1111:2: 'datatypes'
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
    // InternalDataDsl.g:1120:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1124:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalDataDsl.g:1125:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
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
    // InternalDataDsl.g:1132:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1136:1: ( ( 'from' ) )
            // InternalDataDsl.g:1137:1: ( 'from' )
            {
            // InternalDataDsl.g:1137:1: ( 'from' )
            // InternalDataDsl.g:1138:2: 'from'
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
    // InternalDataDsl.g:1147:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1151:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalDataDsl.g:1152:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
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
    // InternalDataDsl.g:1159:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1163:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalDataDsl.g:1164:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalDataDsl.g:1164:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalDataDsl.g:1165:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalDataDsl.g:1166:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalDataDsl.g:1166:3: rule__ComplexTypeImport__ImportURIAssignment_3
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
    // InternalDataDsl.g:1174:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1178:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalDataDsl.g:1179:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
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
    // InternalDataDsl.g:1186:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1190:1: ( ( 'as' ) )
            // InternalDataDsl.g:1191:1: ( 'as' )
            {
            // InternalDataDsl.g:1191:1: ( 'as' )
            // InternalDataDsl.g:1192:2: 'as'
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
    // InternalDataDsl.g:1201:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1205:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalDataDsl.g:1206:2: rule__ComplexTypeImport__Group__5__Impl
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
    // InternalDataDsl.g:1212:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1216:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalDataDsl.g:1217:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalDataDsl.g:1217:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalDataDsl.g:1218:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalDataDsl.g:1219:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalDataDsl.g:1219:3: rule__ComplexTypeImport__NameAssignment_5
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
    // InternalDataDsl.g:1228:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1232:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalDataDsl.g:1233:2: rule__Version__Group__0__Impl rule__Version__Group__1
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
    // InternalDataDsl.g:1240:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1244:1: ( ( 'version' ) )
            // InternalDataDsl.g:1245:1: ( 'version' )
            {
            // InternalDataDsl.g:1245:1: ( 'version' )
            // InternalDataDsl.g:1246:2: 'version'
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
    // InternalDataDsl.g:1255:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1259:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalDataDsl.g:1260:2: rule__Version__Group__1__Impl rule__Version__Group__2
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
    // InternalDataDsl.g:1267:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1271:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1272:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1272:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalDataDsl.g:1273:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1274:2: ( rule__Version__NameAssignment_1 )
            // InternalDataDsl.g:1274:3: rule__Version__NameAssignment_1
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
    // InternalDataDsl.g:1282:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1286:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalDataDsl.g:1287:2: rule__Version__Group__2__Impl rule__Version__Group__3
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
    // InternalDataDsl.g:1294:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1298:1: ( ( '{' ) )
            // InternalDataDsl.g:1299:1: ( '{' )
            {
            // InternalDataDsl.g:1299:1: ( '{' )
            // InternalDataDsl.g:1300:2: '{'
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
    // InternalDataDsl.g:1309:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1313:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalDataDsl.g:1314:2: rule__Version__Group__3__Impl rule__Version__Group__4
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
    // InternalDataDsl.g:1321:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1325:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalDataDsl.g:1326:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalDataDsl.g:1326:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalDataDsl.g:1327:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalDataDsl.g:1328:2: ( rule__Version__Alternatives_3 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=37 && LA22_0<=38)||LA22_0==43||LA22_0==45) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDataDsl.g:1328:3: rule__Version__Alternatives_3
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
    // InternalDataDsl.g:1336:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1340:1: ( rule__Version__Group__4__Impl )
            // InternalDataDsl.g:1341:2: rule__Version__Group__4__Impl
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
    // InternalDataDsl.g:1347:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1351:1: ( ( '}' ) )
            // InternalDataDsl.g:1352:1: ( '}' )
            {
            // InternalDataDsl.g:1352:1: ( '}' )
            // InternalDataDsl.g:1353:2: '}'
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
    // InternalDataDsl.g:1363:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1367:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalDataDsl.g:1368:2: rule__Context__Group__0__Impl rule__Context__Group__1
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
    // InternalDataDsl.g:1375:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1379:1: ( ( 'context' ) )
            // InternalDataDsl.g:1380:1: ( 'context' )
            {
            // InternalDataDsl.g:1380:1: ( 'context' )
            // InternalDataDsl.g:1381:2: 'context'
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
    // InternalDataDsl.g:1390:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1394:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalDataDsl.g:1395:2: rule__Context__Group__1__Impl rule__Context__Group__2
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
    // InternalDataDsl.g:1402:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1406:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1407:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1407:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalDataDsl.g:1408:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1409:2: ( rule__Context__NameAssignment_1 )
            // InternalDataDsl.g:1409:3: rule__Context__NameAssignment_1
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
    // InternalDataDsl.g:1417:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1421:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalDataDsl.g:1422:2: rule__Context__Group__2__Impl rule__Context__Group__3
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
    // InternalDataDsl.g:1429:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1433:1: ( ( '{' ) )
            // InternalDataDsl.g:1434:1: ( '{' )
            {
            // InternalDataDsl.g:1434:1: ( '{' )
            // InternalDataDsl.g:1435:2: '{'
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
    // InternalDataDsl.g:1444:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1448:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalDataDsl.g:1449:2: rule__Context__Group__3__Impl rule__Context__Group__4
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
    // InternalDataDsl.g:1456:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1460:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalDataDsl.g:1461:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalDataDsl.g:1461:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalDataDsl.g:1462:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalDataDsl.g:1462:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalDataDsl.g:1463:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1464:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalDataDsl.g:1464:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_5);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalDataDsl.g:1467:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalDataDsl.g:1468:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalDataDsl.g:1469:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==38||LA23_0==43||LA23_0==45) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDataDsl.g:1469:4: rule__Context__ComplexTypesAssignment_3
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
    // InternalDataDsl.g:1478:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1482:1: ( rule__Context__Group__4__Impl )
            // InternalDataDsl.g:1483:2: rule__Context__Group__4__Impl
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
    // InternalDataDsl.g:1489:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1493:1: ( ( '}' ) )
            // InternalDataDsl.g:1494:1: ( '}' )
            {
            // InternalDataDsl.g:1494:1: ( '}' )
            // InternalDataDsl.g:1495:2: '}'
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
    // InternalDataDsl.g:1505:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1509:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalDataDsl.g:1510:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
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
    // InternalDataDsl.g:1517:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1521:1: ( ( 'structure' ) )
            // InternalDataDsl.g:1522:1: ( 'structure' )
            {
            // InternalDataDsl.g:1522:1: ( 'structure' )
            // InternalDataDsl.g:1523:2: 'structure'
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
    // InternalDataDsl.g:1532:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1536:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalDataDsl.g:1537:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
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
    // InternalDataDsl.g:1544:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1548:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalDataDsl.g:1549:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:1549:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalDataDsl.g:1550:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:1551:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalDataDsl.g:1551:3: rule__DataStructure__NameAssignment_1
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
    // InternalDataDsl.g:1559:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1563:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalDataDsl.g:1564:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
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
    // InternalDataDsl.g:1571:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1575:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalDataDsl.g:1576:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalDataDsl.g:1576:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalDataDsl.g:1577:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalDataDsl.g:1578:2: ( rule__DataStructure__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDataDsl.g:1578:3: rule__DataStructure__Group_2__0
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
    // InternalDataDsl.g:1586:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1590:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalDataDsl.g:1591:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
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
    // InternalDataDsl.g:1598:1: rule__DataStructure__Group__3__Impl : ( ( rule__DataStructure__Group_3__0 )? ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1602:1: ( ( ( rule__DataStructure__Group_3__0 )? ) )
            // InternalDataDsl.g:1603:1: ( ( rule__DataStructure__Group_3__0 )? )
            {
            // InternalDataDsl.g:1603:1: ( ( rule__DataStructure__Group_3__0 )? )
            // InternalDataDsl.g:1604:2: ( rule__DataStructure__Group_3__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_3()); 
            // InternalDataDsl.g:1605:2: ( rule__DataStructure__Group_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDataDsl.g:1605:3: rule__DataStructure__Group_3__0
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
    // InternalDataDsl.g:1613:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1617:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalDataDsl.g:1618:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
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
    // InternalDataDsl.g:1625:1: rule__DataStructure__Group__4__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1629:1: ( ( '{' ) )
            // InternalDataDsl.g:1630:1: ( '{' )
            {
            // InternalDataDsl.g:1630:1: ( '{' )
            // InternalDataDsl.g:1631:2: '{'
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
    // InternalDataDsl.g:1640:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl rule__DataStructure__Group__6 ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1644:1: ( rule__DataStructure__Group__5__Impl rule__DataStructure__Group__6 )
            // InternalDataDsl.g:1645:2: rule__DataStructure__Group__5__Impl rule__DataStructure__Group__6
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
    // InternalDataDsl.g:1652:1: rule__DataStructure__Group__5__Impl : ( ( rule__DataStructure__Group_5__0 )? ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1656:1: ( ( ( rule__DataStructure__Group_5__0 )? ) )
            // InternalDataDsl.g:1657:1: ( ( rule__DataStructure__Group_5__0 )? )
            {
            // InternalDataDsl.g:1657:1: ( ( rule__DataStructure__Group_5__0 )? )
            // InternalDataDsl.g:1658:2: ( rule__DataStructure__Group_5__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_5()); 
            // InternalDataDsl.g:1659:2: ( rule__DataStructure__Group_5__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||LA26_0==48||(LA26_0>=50 && LA26_0<=60)||(LA26_0>=62 && LA26_0<=64)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDataDsl.g:1659:3: rule__DataStructure__Group_5__0
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
    // InternalDataDsl.g:1667:1: rule__DataStructure__Group__6 : rule__DataStructure__Group__6__Impl ;
    public final void rule__DataStructure__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1671:1: ( rule__DataStructure__Group__6__Impl )
            // InternalDataDsl.g:1672:2: rule__DataStructure__Group__6__Impl
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
    // InternalDataDsl.g:1678:1: rule__DataStructure__Group__6__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1682:1: ( ( '}' ) )
            // InternalDataDsl.g:1683:1: ( '}' )
            {
            // InternalDataDsl.g:1683:1: ( '}' )
            // InternalDataDsl.g:1684:2: '}'
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
    // InternalDataDsl.g:1694:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1698:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalDataDsl.g:1699:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
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
    // InternalDataDsl.g:1706:1: rule__DataStructure__Group_2__0__Impl : ( '<' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1710:1: ( ( '<' ) )
            // InternalDataDsl.g:1711:1: ( '<' )
            {
            // InternalDataDsl.g:1711:1: ( '<' )
            // InternalDataDsl.g:1712:2: '<'
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
    // InternalDataDsl.g:1721:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl rule__DataStructure__Group_2__2 ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1725:1: ( rule__DataStructure__Group_2__1__Impl rule__DataStructure__Group_2__2 )
            // InternalDataDsl.g:1726:2: rule__DataStructure__Group_2__1__Impl rule__DataStructure__Group_2__2
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
    // InternalDataDsl.g:1733:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__FeaturesAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1737:1: ( ( ( rule__DataStructure__FeaturesAssignment_2_1 ) ) )
            // InternalDataDsl.g:1738:1: ( ( rule__DataStructure__FeaturesAssignment_2_1 ) )
            {
            // InternalDataDsl.g:1738:1: ( ( rule__DataStructure__FeaturesAssignment_2_1 ) )
            // InternalDataDsl.g:1739:2: ( rule__DataStructure__FeaturesAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_1()); 
            // InternalDataDsl.g:1740:2: ( rule__DataStructure__FeaturesAssignment_2_1 )
            // InternalDataDsl.g:1740:3: rule__DataStructure__FeaturesAssignment_2_1
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
    // InternalDataDsl.g:1748:1: rule__DataStructure__Group_2__2 : rule__DataStructure__Group_2__2__Impl rule__DataStructure__Group_2__3 ;
    public final void rule__DataStructure__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1752:1: ( rule__DataStructure__Group_2__2__Impl rule__DataStructure__Group_2__3 )
            // InternalDataDsl.g:1753:2: rule__DataStructure__Group_2__2__Impl rule__DataStructure__Group_2__3
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
    // InternalDataDsl.g:1760:1: rule__DataStructure__Group_2__2__Impl : ( ( rule__DataStructure__Group_2_2__0 )* ) ;
    public final void rule__DataStructure__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1764:1: ( ( ( rule__DataStructure__Group_2_2__0 )* ) )
            // InternalDataDsl.g:1765:1: ( ( rule__DataStructure__Group_2_2__0 )* )
            {
            // InternalDataDsl.g:1765:1: ( ( rule__DataStructure__Group_2_2__0 )* )
            // InternalDataDsl.g:1766:2: ( rule__DataStructure__Group_2_2__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2_2()); 
            // InternalDataDsl.g:1767:2: ( rule__DataStructure__Group_2_2__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDataDsl.g:1767:3: rule__DataStructure__Group_2_2__0
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
    // InternalDataDsl.g:1775:1: rule__DataStructure__Group_2__3 : rule__DataStructure__Group_2__3__Impl ;
    public final void rule__DataStructure__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1779:1: ( rule__DataStructure__Group_2__3__Impl )
            // InternalDataDsl.g:1780:2: rule__DataStructure__Group_2__3__Impl
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
    // InternalDataDsl.g:1786:1: rule__DataStructure__Group_2__3__Impl : ( '>' ) ;
    public final void rule__DataStructure__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1790:1: ( ( '>' ) )
            // InternalDataDsl.g:1791:1: ( '>' )
            {
            // InternalDataDsl.g:1791:1: ( '>' )
            // InternalDataDsl.g:1792:2: '>'
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
    // InternalDataDsl.g:1802:1: rule__DataStructure__Group_2_2__0 : rule__DataStructure__Group_2_2__0__Impl rule__DataStructure__Group_2_2__1 ;
    public final void rule__DataStructure__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1806:1: ( rule__DataStructure__Group_2_2__0__Impl rule__DataStructure__Group_2_2__1 )
            // InternalDataDsl.g:1807:2: rule__DataStructure__Group_2_2__0__Impl rule__DataStructure__Group_2_2__1
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
    // InternalDataDsl.g:1814:1: rule__DataStructure__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1818:1: ( ( ',' ) )
            // InternalDataDsl.g:1819:1: ( ',' )
            {
            // InternalDataDsl.g:1819:1: ( ',' )
            // InternalDataDsl.g:1820:2: ','
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
    // InternalDataDsl.g:1829:1: rule__DataStructure__Group_2_2__1 : rule__DataStructure__Group_2_2__1__Impl ;
    public final void rule__DataStructure__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1833:1: ( rule__DataStructure__Group_2_2__1__Impl )
            // InternalDataDsl.g:1834:2: rule__DataStructure__Group_2_2__1__Impl
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
    // InternalDataDsl.g:1840:1: rule__DataStructure__Group_2_2__1__Impl : ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) ) ;
    public final void rule__DataStructure__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1844:1: ( ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) ) )
            // InternalDataDsl.g:1845:1: ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) )
            {
            // InternalDataDsl.g:1845:1: ( ( rule__DataStructure__FeaturesAssignment_2_2_1 ) )
            // InternalDataDsl.g:1846:2: ( rule__DataStructure__FeaturesAssignment_2_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_2_1()); 
            // InternalDataDsl.g:1847:2: ( rule__DataStructure__FeaturesAssignment_2_2_1 )
            // InternalDataDsl.g:1847:3: rule__DataStructure__FeaturesAssignment_2_2_1
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
    // InternalDataDsl.g:1856:1: rule__DataStructure__Group_3__0 : rule__DataStructure__Group_3__0__Impl rule__DataStructure__Group_3__1 ;
    public final void rule__DataStructure__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1860:1: ( rule__DataStructure__Group_3__0__Impl rule__DataStructure__Group_3__1 )
            // InternalDataDsl.g:1861:2: rule__DataStructure__Group_3__0__Impl rule__DataStructure__Group_3__1
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
    // InternalDataDsl.g:1868:1: rule__DataStructure__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1872:1: ( ( 'extends' ) )
            // InternalDataDsl.g:1873:1: ( 'extends' )
            {
            // InternalDataDsl.g:1873:1: ( 'extends' )
            // InternalDataDsl.g:1874:2: 'extends'
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
    // InternalDataDsl.g:1883:1: rule__DataStructure__Group_3__1 : rule__DataStructure__Group_3__1__Impl ;
    public final void rule__DataStructure__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1887:1: ( rule__DataStructure__Group_3__1__Impl )
            // InternalDataDsl.g:1888:2: rule__DataStructure__Group_3__1__Impl
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
    // InternalDataDsl.g:1894:1: rule__DataStructure__Group_3__1__Impl : ( ( rule__DataStructure__SuperAssignment_3_1 ) ) ;
    public final void rule__DataStructure__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1898:1: ( ( ( rule__DataStructure__SuperAssignment_3_1 ) ) )
            // InternalDataDsl.g:1899:1: ( ( rule__DataStructure__SuperAssignment_3_1 ) )
            {
            // InternalDataDsl.g:1899:1: ( ( rule__DataStructure__SuperAssignment_3_1 ) )
            // InternalDataDsl.g:1900:2: ( rule__DataStructure__SuperAssignment_3_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_3_1()); 
            // InternalDataDsl.g:1901:2: ( rule__DataStructure__SuperAssignment_3_1 )
            // InternalDataDsl.g:1901:3: rule__DataStructure__SuperAssignment_3_1
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
    // InternalDataDsl.g:1910:1: rule__DataStructure__Group_5__0 : rule__DataStructure__Group_5__0__Impl rule__DataStructure__Group_5__1 ;
    public final void rule__DataStructure__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1914:1: ( rule__DataStructure__Group_5__0__Impl rule__DataStructure__Group_5__1 )
            // InternalDataDsl.g:1915:2: rule__DataStructure__Group_5__0__Impl rule__DataStructure__Group_5__1
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
    // InternalDataDsl.g:1922:1: rule__DataStructure__Group_5__0__Impl : ( ( rule__DataStructure__Alternatives_5_0 ) ) ;
    public final void rule__DataStructure__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1926:1: ( ( ( rule__DataStructure__Alternatives_5_0 ) ) )
            // InternalDataDsl.g:1927:1: ( ( rule__DataStructure__Alternatives_5_0 ) )
            {
            // InternalDataDsl.g:1927:1: ( ( rule__DataStructure__Alternatives_5_0 ) )
            // InternalDataDsl.g:1928:2: ( rule__DataStructure__Alternatives_5_0 )
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_5_0()); 
            // InternalDataDsl.g:1929:2: ( rule__DataStructure__Alternatives_5_0 )
            // InternalDataDsl.g:1929:3: rule__DataStructure__Alternatives_5_0
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
    // InternalDataDsl.g:1937:1: rule__DataStructure__Group_5__1 : rule__DataStructure__Group_5__1__Impl ;
    public final void rule__DataStructure__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1941:1: ( rule__DataStructure__Group_5__1__Impl )
            // InternalDataDsl.g:1942:2: rule__DataStructure__Group_5__1__Impl
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
    // InternalDataDsl.g:1948:1: rule__DataStructure__Group_5__1__Impl : ( ( rule__DataStructure__Group_5_1__0 )* ) ;
    public final void rule__DataStructure__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1952:1: ( ( ( rule__DataStructure__Group_5_1__0 )* ) )
            // InternalDataDsl.g:1953:1: ( ( rule__DataStructure__Group_5_1__0 )* )
            {
            // InternalDataDsl.g:1953:1: ( ( rule__DataStructure__Group_5_1__0 )* )
            // InternalDataDsl.g:1954:2: ( rule__DataStructure__Group_5_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_5_1()); 
            // InternalDataDsl.g:1955:2: ( rule__DataStructure__Group_5_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==41) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDataDsl.g:1955:3: rule__DataStructure__Group_5_1__0
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
    // InternalDataDsl.g:1964:1: rule__DataStructure__Group_5_1__0 : rule__DataStructure__Group_5_1__0__Impl rule__DataStructure__Group_5_1__1 ;
    public final void rule__DataStructure__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1968:1: ( rule__DataStructure__Group_5_1__0__Impl rule__DataStructure__Group_5_1__1 )
            // InternalDataDsl.g:1969:2: rule__DataStructure__Group_5_1__0__Impl rule__DataStructure__Group_5_1__1
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
    // InternalDataDsl.g:1976:1: rule__DataStructure__Group_5_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1980:1: ( ( ',' ) )
            // InternalDataDsl.g:1981:1: ( ',' )
            {
            // InternalDataDsl.g:1981:1: ( ',' )
            // InternalDataDsl.g:1982:2: ','
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
    // InternalDataDsl.g:1991:1: rule__DataStructure__Group_5_1__1 : rule__DataStructure__Group_5_1__1__Impl ;
    public final void rule__DataStructure__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:1995:1: ( rule__DataStructure__Group_5_1__1__Impl )
            // InternalDataDsl.g:1996:2: rule__DataStructure__Group_5_1__1__Impl
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
    // InternalDataDsl.g:2002:1: rule__DataStructure__Group_5_1__1__Impl : ( ( rule__DataStructure__Alternatives_5_1_1 ) ) ;
    public final void rule__DataStructure__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2006:1: ( ( ( rule__DataStructure__Alternatives_5_1_1 ) ) )
            // InternalDataDsl.g:2007:1: ( ( rule__DataStructure__Alternatives_5_1_1 ) )
            {
            // InternalDataDsl.g:2007:1: ( ( rule__DataStructure__Alternatives_5_1_1 ) )
            // InternalDataDsl.g:2008:2: ( rule__DataStructure__Alternatives_5_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getAlternatives_5_1_1()); 
            // InternalDataDsl.g:2009:2: ( rule__DataStructure__Alternatives_5_1_1 )
            // InternalDataDsl.g:2009:3: rule__DataStructure__Alternatives_5_1_1
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


    // $ANTLR start "rule__CollectionType__Group_0__0"
    // InternalDataDsl.g:2018:1: rule__CollectionType__Group_0__0 : rule__CollectionType__Group_0__0__Impl rule__CollectionType__Group_0__1 ;
    public final void rule__CollectionType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2022:1: ( rule__CollectionType__Group_0__0__Impl rule__CollectionType__Group_0__1 )
            // InternalDataDsl.g:2023:2: rule__CollectionType__Group_0__0__Impl rule__CollectionType__Group_0__1
            {
            pushFollow(FOLLOW_12);
            rule__CollectionType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__0"


    // $ANTLR start "rule__CollectionType__Group_0__0__Impl"
    // InternalDataDsl.g:2030:1: rule__CollectionType__Group_0__0__Impl : ( 'collection' ) ;
    public final void rule__CollectionType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2034:1: ( ( 'collection' ) )
            // InternalDataDsl.g:2035:1: ( 'collection' )
            {
            // InternalDataDsl.g:2035:1: ( 'collection' )
            // InternalDataDsl.g:2036:2: 'collection'
            {
             before(grammarAccess.getCollectionTypeAccess().getCollectionKeyword_0_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getCollectionKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__0__Impl"


    // $ANTLR start "rule__CollectionType__Group_0__1"
    // InternalDataDsl.g:2045:1: rule__CollectionType__Group_0__1 : rule__CollectionType__Group_0__1__Impl rule__CollectionType__Group_0__2 ;
    public final void rule__CollectionType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2049:1: ( rule__CollectionType__Group_0__1__Impl rule__CollectionType__Group_0__2 )
            // InternalDataDsl.g:2050:2: rule__CollectionType__Group_0__1__Impl rule__CollectionType__Group_0__2
            {
            pushFollow(FOLLOW_13);
            rule__CollectionType__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__1"


    // $ANTLR start "rule__CollectionType__Group_0__1__Impl"
    // InternalDataDsl.g:2057:1: rule__CollectionType__Group_0__1__Impl : ( ( rule__CollectionType__NameAssignment_0_1 ) ) ;
    public final void rule__CollectionType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2061:1: ( ( ( rule__CollectionType__NameAssignment_0_1 ) ) )
            // InternalDataDsl.g:2062:1: ( ( rule__CollectionType__NameAssignment_0_1 ) )
            {
            // InternalDataDsl.g:2062:1: ( ( rule__CollectionType__NameAssignment_0_1 ) )
            // InternalDataDsl.g:2063:2: ( rule__CollectionType__NameAssignment_0_1 )
            {
             before(grammarAccess.getCollectionTypeAccess().getNameAssignment_0_1()); 
            // InternalDataDsl.g:2064:2: ( rule__CollectionType__NameAssignment_0_1 )
            // InternalDataDsl.g:2064:3: rule__CollectionType__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__1__Impl"


    // $ANTLR start "rule__CollectionType__Group_0__2"
    // InternalDataDsl.g:2072:1: rule__CollectionType__Group_0__2 : rule__CollectionType__Group_0__2__Impl rule__CollectionType__Group_0__3 ;
    public final void rule__CollectionType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2076:1: ( rule__CollectionType__Group_0__2__Impl rule__CollectionType__Group_0__3 )
            // InternalDataDsl.g:2077:2: rule__CollectionType__Group_0__2__Impl rule__CollectionType__Group_0__3
            {
            pushFollow(FOLLOW_24);
            rule__CollectionType__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__2"


    // $ANTLR start "rule__CollectionType__Group_0__2__Impl"
    // InternalDataDsl.g:2084:1: rule__CollectionType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__CollectionType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2088:1: ( ( '{' ) )
            // InternalDataDsl.g:2089:1: ( '{' )
            {
            // InternalDataDsl.g:2089:1: ( '{' )
            // InternalDataDsl.g:2090:2: '{'
            {
             before(grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__2__Impl"


    // $ANTLR start "rule__CollectionType__Group_0__3"
    // InternalDataDsl.g:2099:1: rule__CollectionType__Group_0__3 : rule__CollectionType__Group_0__3__Impl rule__CollectionType__Group_0__4 ;
    public final void rule__CollectionType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2103:1: ( rule__CollectionType__Group_0__3__Impl rule__CollectionType__Group_0__4 )
            // InternalDataDsl.g:2104:2: rule__CollectionType__Group_0__3__Impl rule__CollectionType__Group_0__4
            {
            pushFollow(FOLLOW_25);
            rule__CollectionType__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__3"


    // $ANTLR start "rule__CollectionType__Group_0__3__Impl"
    // InternalDataDsl.g:2111:1: rule__CollectionType__Group_0__3__Impl : ( ( rule__CollectionType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__CollectionType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2115:1: ( ( ( rule__CollectionType__DataFieldsAssignment_0_3 ) ) )
            // InternalDataDsl.g:2116:1: ( ( rule__CollectionType__DataFieldsAssignment_0_3 ) )
            {
            // InternalDataDsl.g:2116:1: ( ( rule__CollectionType__DataFieldsAssignment_0_3 ) )
            // InternalDataDsl.g:2117:2: ( rule__CollectionType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getCollectionTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalDataDsl.g:2118:2: ( rule__CollectionType__DataFieldsAssignment_0_3 )
            // InternalDataDsl.g:2118:3: rule__CollectionType__DataFieldsAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__DataFieldsAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeAccess().getDataFieldsAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__3__Impl"


    // $ANTLR start "rule__CollectionType__Group_0__4"
    // InternalDataDsl.g:2126:1: rule__CollectionType__Group_0__4 : rule__CollectionType__Group_0__4__Impl rule__CollectionType__Group_0__5 ;
    public final void rule__CollectionType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2130:1: ( rule__CollectionType__Group_0__4__Impl rule__CollectionType__Group_0__5 )
            // InternalDataDsl.g:2131:2: rule__CollectionType__Group_0__4__Impl rule__CollectionType__Group_0__5
            {
            pushFollow(FOLLOW_25);
            rule__CollectionType__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__4"


    // $ANTLR start "rule__CollectionType__Group_0__4__Impl"
    // InternalDataDsl.g:2138:1: rule__CollectionType__Group_0__4__Impl : ( ( rule__CollectionType__Group_0_4__0 )* ) ;
    public final void rule__CollectionType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2142:1: ( ( ( rule__CollectionType__Group_0_4__0 )* ) )
            // InternalDataDsl.g:2143:1: ( ( rule__CollectionType__Group_0_4__0 )* )
            {
            // InternalDataDsl.g:2143:1: ( ( rule__CollectionType__Group_0_4__0 )* )
            // InternalDataDsl.g:2144:2: ( rule__CollectionType__Group_0_4__0 )*
            {
             before(grammarAccess.getCollectionTypeAccess().getGroup_0_4()); 
            // InternalDataDsl.g:2145:2: ( rule__CollectionType__Group_0_4__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==41) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDataDsl.g:2145:3: rule__CollectionType__Group_0_4__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__CollectionType__Group_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getCollectionTypeAccess().getGroup_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__4__Impl"


    // $ANTLR start "rule__CollectionType__Group_0__5"
    // InternalDataDsl.g:2153:1: rule__CollectionType__Group_0__5 : rule__CollectionType__Group_0__5__Impl ;
    public final void rule__CollectionType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2157:1: ( rule__CollectionType__Group_0__5__Impl )
            // InternalDataDsl.g:2158:2: rule__CollectionType__Group_0__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__5"


    // $ANTLR start "rule__CollectionType__Group_0__5__Impl"
    // InternalDataDsl.g:2164:1: rule__CollectionType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__CollectionType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2168:1: ( ( '}' ) )
            // InternalDataDsl.g:2169:1: ( '}' )
            {
            // InternalDataDsl.g:2169:1: ( '}' )
            // InternalDataDsl.g:2170:2: '}'
            {
             before(grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_0_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0__5__Impl"


    // $ANTLR start "rule__CollectionType__Group_0_4__0"
    // InternalDataDsl.g:2180:1: rule__CollectionType__Group_0_4__0 : rule__CollectionType__Group_0_4__0__Impl rule__CollectionType__Group_0_4__1 ;
    public final void rule__CollectionType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2184:1: ( rule__CollectionType__Group_0_4__0__Impl rule__CollectionType__Group_0_4__1 )
            // InternalDataDsl.g:2185:2: rule__CollectionType__Group_0_4__0__Impl rule__CollectionType__Group_0_4__1
            {
            pushFollow(FOLLOW_24);
            rule__CollectionType__Group_0_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0_4__0"


    // $ANTLR start "rule__CollectionType__Group_0_4__0__Impl"
    // InternalDataDsl.g:2192:1: rule__CollectionType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__CollectionType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2196:1: ( ( ',' ) )
            // InternalDataDsl.g:2197:1: ( ',' )
            {
            // InternalDataDsl.g:2197:1: ( ',' )
            // InternalDataDsl.g:2198:2: ','
            {
             before(grammarAccess.getCollectionTypeAccess().getCommaKeyword_0_4_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getCommaKeyword_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0_4__0__Impl"


    // $ANTLR start "rule__CollectionType__Group_0_4__1"
    // InternalDataDsl.g:2207:1: rule__CollectionType__Group_0_4__1 : rule__CollectionType__Group_0_4__1__Impl ;
    public final void rule__CollectionType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2211:1: ( rule__CollectionType__Group_0_4__1__Impl )
            // InternalDataDsl.g:2212:2: rule__CollectionType__Group_0_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_0_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0_4__1"


    // $ANTLR start "rule__CollectionType__Group_0_4__1__Impl"
    // InternalDataDsl.g:2218:1: rule__CollectionType__Group_0_4__1__Impl : ( ( rule__CollectionType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__CollectionType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2222:1: ( ( ( rule__CollectionType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalDataDsl.g:2223:1: ( ( rule__CollectionType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalDataDsl.g:2223:1: ( ( rule__CollectionType__DataFieldsAssignment_0_4_1 ) )
            // InternalDataDsl.g:2224:2: ( rule__CollectionType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getCollectionTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalDataDsl.g:2225:2: ( rule__CollectionType__DataFieldsAssignment_0_4_1 )
            // InternalDataDsl.g:2225:3: rule__CollectionType__DataFieldsAssignment_0_4_1
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__DataFieldsAssignment_0_4_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeAccess().getDataFieldsAssignment_0_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_0_4__1__Impl"


    // $ANTLR start "rule__CollectionType__Group_1__0"
    // InternalDataDsl.g:2234:1: rule__CollectionType__Group_1__0 : rule__CollectionType__Group_1__0__Impl rule__CollectionType__Group_1__1 ;
    public final void rule__CollectionType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2238:1: ( rule__CollectionType__Group_1__0__Impl rule__CollectionType__Group_1__1 )
            // InternalDataDsl.g:2239:2: rule__CollectionType__Group_1__0__Impl rule__CollectionType__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__CollectionType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__0"


    // $ANTLR start "rule__CollectionType__Group_1__0__Impl"
    // InternalDataDsl.g:2246:1: rule__CollectionType__Group_1__0__Impl : ( 'collection' ) ;
    public final void rule__CollectionType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2250:1: ( ( 'collection' ) )
            // InternalDataDsl.g:2251:1: ( 'collection' )
            {
            // InternalDataDsl.g:2251:1: ( 'collection' )
            // InternalDataDsl.g:2252:2: 'collection'
            {
             before(grammarAccess.getCollectionTypeAccess().getCollectionKeyword_1_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getCollectionKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__0__Impl"


    // $ANTLR start "rule__CollectionType__Group_1__1"
    // InternalDataDsl.g:2261:1: rule__CollectionType__Group_1__1 : rule__CollectionType__Group_1__1__Impl rule__CollectionType__Group_1__2 ;
    public final void rule__CollectionType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2265:1: ( rule__CollectionType__Group_1__1__Impl rule__CollectionType__Group_1__2 )
            // InternalDataDsl.g:2266:2: rule__CollectionType__Group_1__1__Impl rule__CollectionType__Group_1__2
            {
            pushFollow(FOLLOW_13);
            rule__CollectionType__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__1"


    // $ANTLR start "rule__CollectionType__Group_1__1__Impl"
    // InternalDataDsl.g:2273:1: rule__CollectionType__Group_1__1__Impl : ( ( rule__CollectionType__NameAssignment_1_1 ) ) ;
    public final void rule__CollectionType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2277:1: ( ( ( rule__CollectionType__NameAssignment_1_1 ) ) )
            // InternalDataDsl.g:2278:1: ( ( rule__CollectionType__NameAssignment_1_1 ) )
            {
            // InternalDataDsl.g:2278:1: ( ( rule__CollectionType__NameAssignment_1_1 ) )
            // InternalDataDsl.g:2279:2: ( rule__CollectionType__NameAssignment_1_1 )
            {
             before(grammarAccess.getCollectionTypeAccess().getNameAssignment_1_1()); 
            // InternalDataDsl.g:2280:2: ( rule__CollectionType__NameAssignment_1_1 )
            // InternalDataDsl.g:2280:3: rule__CollectionType__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__1__Impl"


    // $ANTLR start "rule__CollectionType__Group_1__2"
    // InternalDataDsl.g:2288:1: rule__CollectionType__Group_1__2 : rule__CollectionType__Group_1__2__Impl rule__CollectionType__Group_1__3 ;
    public final void rule__CollectionType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2292:1: ( rule__CollectionType__Group_1__2__Impl rule__CollectionType__Group_1__3 )
            // InternalDataDsl.g:2293:2: rule__CollectionType__Group_1__2__Impl rule__CollectionType__Group_1__3
            {
            pushFollow(FOLLOW_26);
            rule__CollectionType__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__2"


    // $ANTLR start "rule__CollectionType__Group_1__2__Impl"
    // InternalDataDsl.g:2300:1: rule__CollectionType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__CollectionType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2304:1: ( ( '{' ) )
            // InternalDataDsl.g:2305:1: ( '{' )
            {
            // InternalDataDsl.g:2305:1: ( '{' )
            // InternalDataDsl.g:2306:2: '{'
            {
             before(grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_1_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getLeftCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__2__Impl"


    // $ANTLR start "rule__CollectionType__Group_1__3"
    // InternalDataDsl.g:2315:1: rule__CollectionType__Group_1__3 : rule__CollectionType__Group_1__3__Impl rule__CollectionType__Group_1__4 ;
    public final void rule__CollectionType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2319:1: ( rule__CollectionType__Group_1__3__Impl rule__CollectionType__Group_1__4 )
            // InternalDataDsl.g:2320:2: rule__CollectionType__Group_1__3__Impl rule__CollectionType__Group_1__4
            {
            pushFollow(FOLLOW_16);
            rule__CollectionType__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__3"


    // $ANTLR start "rule__CollectionType__Group_1__3__Impl"
    // InternalDataDsl.g:2327:1: rule__CollectionType__Group_1__3__Impl : ( ( rule__CollectionType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__CollectionType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2331:1: ( ( ( rule__CollectionType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalDataDsl.g:2332:1: ( ( rule__CollectionType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalDataDsl.g:2332:1: ( ( rule__CollectionType__PrimitiveTypeAssignment_1_3 ) )
            // InternalDataDsl.g:2333:2: ( rule__CollectionType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getCollectionTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalDataDsl.g:2334:2: ( rule__CollectionType__PrimitiveTypeAssignment_1_3 )
            // InternalDataDsl.g:2334:3: rule__CollectionType__PrimitiveTypeAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__PrimitiveTypeAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeAccess().getPrimitiveTypeAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__3__Impl"


    // $ANTLR start "rule__CollectionType__Group_1__4"
    // InternalDataDsl.g:2342:1: rule__CollectionType__Group_1__4 : rule__CollectionType__Group_1__4__Impl ;
    public final void rule__CollectionType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2346:1: ( rule__CollectionType__Group_1__4__Impl )
            // InternalDataDsl.g:2347:2: rule__CollectionType__Group_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionType__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__4"


    // $ANTLR start "rule__CollectionType__Group_1__4__Impl"
    // InternalDataDsl.g:2353:1: rule__CollectionType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__CollectionType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2357:1: ( ( '}' ) )
            // InternalDataDsl.g:2358:1: ( '}' )
            {
            // InternalDataDsl.g:2358:1: ( '}' )
            // InternalDataDsl.g:2359:2: '}'
            {
             before(grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_1_4()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getRightCurlyBracketKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__Group_1__4__Impl"


    // $ANTLR start "rule__DataField__Group__0"
    // InternalDataDsl.g:2369:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2373:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalDataDsl.g:2374:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
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
    // InternalDataDsl.g:2381:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2385:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:2386:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:2386:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalDataDsl.g:2387:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:2388:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==62) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDataDsl.g:2388:3: rule__DataField__HiddenAssignment_0
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
    // InternalDataDsl.g:2396:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2400:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalDataDsl.g:2401:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
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
    // InternalDataDsl.g:2408:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__ImmutableAssignment_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2412:1: ( ( ( rule__DataField__ImmutableAssignment_1 )? ) )
            // InternalDataDsl.g:2413:1: ( ( rule__DataField__ImmutableAssignment_1 )? )
            {
            // InternalDataDsl.g:2413:1: ( ( rule__DataField__ImmutableAssignment_1 )? )
            // InternalDataDsl.g:2414:2: ( rule__DataField__ImmutableAssignment_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getImmutableAssignment_1()); 
            // InternalDataDsl.g:2415:2: ( rule__DataField__ImmutableAssignment_1 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==63) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDataDsl.g:2415:3: rule__DataField__ImmutableAssignment_1
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
    // InternalDataDsl.g:2423:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl rule__DataField__Group__3 ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2427:1: ( rule__DataField__Group__2__Impl rule__DataField__Group__3 )
            // InternalDataDsl.g:2428:2: rule__DataField__Group__2__Impl rule__DataField__Group__3
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
    // InternalDataDsl.g:2435:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__Alternatives_2 )? ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2439:1: ( ( ( rule__DataField__Alternatives_2 )? ) )
            // InternalDataDsl.g:2440:1: ( ( rule__DataField__Alternatives_2 )? )
            {
            // InternalDataDsl.g:2440:1: ( ( rule__DataField__Alternatives_2 )? )
            // InternalDataDsl.g:2441:2: ( rule__DataField__Alternatives_2 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_2()); 
            // InternalDataDsl.g:2442:2: ( rule__DataField__Alternatives_2 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=50 && LA32_0<=60)) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                int LA32_2 = input.LA(2);

                if ( (LA32_2==RULE_ID||LA32_2==49||LA32_2==61) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalDataDsl.g:2442:3: rule__DataField__Alternatives_2
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
    // InternalDataDsl.g:2450:1: rule__DataField__Group__3 : rule__DataField__Group__3__Impl rule__DataField__Group__4 ;
    public final void rule__DataField__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2454:1: ( rule__DataField__Group__3__Impl rule__DataField__Group__4 )
            // InternalDataDsl.g:2455:2: rule__DataField__Group__3__Impl rule__DataField__Group__4
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
    // InternalDataDsl.g:2462:1: rule__DataField__Group__3__Impl : ( ( rule__DataField__NameAssignment_3 ) ) ;
    public final void rule__DataField__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2466:1: ( ( ( rule__DataField__NameAssignment_3 ) ) )
            // InternalDataDsl.g:2467:1: ( ( rule__DataField__NameAssignment_3 ) )
            {
            // InternalDataDsl.g:2467:1: ( ( rule__DataField__NameAssignment_3 ) )
            // InternalDataDsl.g:2468:2: ( rule__DataField__NameAssignment_3 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_3()); 
            // InternalDataDsl.g:2469:2: ( rule__DataField__NameAssignment_3 )
            // InternalDataDsl.g:2469:3: rule__DataField__NameAssignment_3
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
    // InternalDataDsl.g:2477:1: rule__DataField__Group__4 : rule__DataField__Group__4__Impl rule__DataField__Group__5 ;
    public final void rule__DataField__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2481:1: ( rule__DataField__Group__4__Impl rule__DataField__Group__5 )
            // InternalDataDsl.g:2482:2: rule__DataField__Group__4__Impl rule__DataField__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__DataField__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group__5();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:2489:1: rule__DataField__Group__4__Impl : ( ( rule__DataField__Group_4__0 )? ) ;
    public final void rule__DataField__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2493:1: ( ( ( rule__DataField__Group_4__0 )? ) )
            // InternalDataDsl.g:2494:1: ( ( rule__DataField__Group_4__0 )? )
            {
            // InternalDataDsl.g:2494:1: ( ( rule__DataField__Group_4__0 )? )
            // InternalDataDsl.g:2495:2: ( rule__DataField__Group_4__0 )?
            {
             before(grammarAccess.getDataFieldAccess().getGroup_4()); 
            // InternalDataDsl.g:2496:2: ( rule__DataField__Group_4__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDataDsl.g:2496:3: rule__DataField__Group_4__0
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


    // $ANTLR start "rule__DataField__Group__5"
    // InternalDataDsl.g:2504:1: rule__DataField__Group__5 : rule__DataField__Group__5__Impl ;
    public final void rule__DataField__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2508:1: ( rule__DataField__Group__5__Impl )
            // InternalDataDsl.g:2509:2: rule__DataField__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__5"


    // $ANTLR start "rule__DataField__Group__5__Impl"
    // InternalDataDsl.g:2515:1: rule__DataField__Group__5__Impl : ( ( rule__DataField__Group_5__0 )? ) ;
    public final void rule__DataField__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2519:1: ( ( ( rule__DataField__Group_5__0 )? ) )
            // InternalDataDsl.g:2520:1: ( ( rule__DataField__Group_5__0 )? )
            {
            // InternalDataDsl.g:2520:1: ( ( rule__DataField__Group_5__0 )? )
            // InternalDataDsl.g:2521:2: ( rule__DataField__Group_5__0 )?
            {
             before(grammarAccess.getDataFieldAccess().getGroup_5()); 
            // InternalDataDsl.g:2522:2: ( rule__DataField__Group_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==39) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDataDsl.g:2522:3: rule__DataField__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataField__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataFieldAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group__5__Impl"


    // $ANTLR start "rule__DataField__Group_4__0"
    // InternalDataDsl.g:2531:1: rule__DataField__Group_4__0 : rule__DataField__Group_4__0__Impl rule__DataField__Group_4__1 ;
    public final void rule__DataField__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2535:1: ( rule__DataField__Group_4__0__Impl rule__DataField__Group_4__1 )
            // InternalDataDsl.g:2536:2: rule__DataField__Group_4__0__Impl rule__DataField__Group_4__1
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
    // InternalDataDsl.g:2543:1: rule__DataField__Group_4__0__Impl : ( '=' ) ;
    public final void rule__DataField__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2547:1: ( ( '=' ) )
            // InternalDataDsl.g:2548:1: ( '=' )
            {
            // InternalDataDsl.g:2548:1: ( '=' )
            // InternalDataDsl.g:2549:2: '='
            {
             before(grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getEqualsSignKeyword_4_0()); 

            }


            }

        }
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
    // InternalDataDsl.g:2558:1: rule__DataField__Group_4__1 : rule__DataField__Group_4__1__Impl ;
    public final void rule__DataField__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2562:1: ( rule__DataField__Group_4__1__Impl )
            // InternalDataDsl.g:2563:2: rule__DataField__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_4__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:2569:1: rule__DataField__Group_4__1__Impl : ( ( rule__DataField__InitializationValueAssignment_4_1 ) ) ;
    public final void rule__DataField__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2573:1: ( ( ( rule__DataField__InitializationValueAssignment_4_1 ) ) )
            // InternalDataDsl.g:2574:1: ( ( rule__DataField__InitializationValueAssignment_4_1 ) )
            {
            // InternalDataDsl.g:2574:1: ( ( rule__DataField__InitializationValueAssignment_4_1 ) )
            // InternalDataDsl.g:2575:2: ( rule__DataField__InitializationValueAssignment_4_1 )
            {
             before(grammarAccess.getDataFieldAccess().getInitializationValueAssignment_4_1()); 
            // InternalDataDsl.g:2576:2: ( rule__DataField__InitializationValueAssignment_4_1 )
            // InternalDataDsl.g:2576:3: rule__DataField__InitializationValueAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__InitializationValueAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getInitializationValueAssignment_4_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__DataField__Group_5__0"
    // InternalDataDsl.g:2585:1: rule__DataField__Group_5__0 : rule__DataField__Group_5__0__Impl rule__DataField__Group_5__1 ;
    public final void rule__DataField__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2589:1: ( rule__DataField__Group_5__0__Impl rule__DataField__Group_5__1 )
            // InternalDataDsl.g:2590:2: rule__DataField__Group_5__0__Impl rule__DataField__Group_5__1
            {
            pushFollow(FOLLOW_29);
            rule__DataField__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__0"


    // $ANTLR start "rule__DataField__Group_5__0__Impl"
    // InternalDataDsl.g:2597:1: rule__DataField__Group_5__0__Impl : ( '<' ) ;
    public final void rule__DataField__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2601:1: ( ( '<' ) )
            // InternalDataDsl.g:2602:1: ( '<' )
            {
            // InternalDataDsl.g:2602:1: ( '<' )
            // InternalDataDsl.g:2603:2: '<'
            {
             before(grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getLessThanSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__0__Impl"


    // $ANTLR start "rule__DataField__Group_5__1"
    // InternalDataDsl.g:2612:1: rule__DataField__Group_5__1 : rule__DataField__Group_5__1__Impl rule__DataField__Group_5__2 ;
    public final void rule__DataField__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2616:1: ( rule__DataField__Group_5__1__Impl rule__DataField__Group_5__2 )
            // InternalDataDsl.g:2617:2: rule__DataField__Group_5__1__Impl rule__DataField__Group_5__2
            {
            pushFollow(FOLLOW_20);
            rule__DataField__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__1"


    // $ANTLR start "rule__DataField__Group_5__1__Impl"
    // InternalDataDsl.g:2624:1: rule__DataField__Group_5__1__Impl : ( ( rule__DataField__FeaturesAssignment_5_1 ) ) ;
    public final void rule__DataField__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2628:1: ( ( ( rule__DataField__FeaturesAssignment_5_1 ) ) )
            // InternalDataDsl.g:2629:1: ( ( rule__DataField__FeaturesAssignment_5_1 ) )
            {
            // InternalDataDsl.g:2629:1: ( ( rule__DataField__FeaturesAssignment_5_1 ) )
            // InternalDataDsl.g:2630:2: ( rule__DataField__FeaturesAssignment_5_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_5_1()); 
            // InternalDataDsl.g:2631:2: ( rule__DataField__FeaturesAssignment_5_1 )
            // InternalDataDsl.g:2631:3: rule__DataField__FeaturesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__FeaturesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getFeaturesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__1__Impl"


    // $ANTLR start "rule__DataField__Group_5__2"
    // InternalDataDsl.g:2639:1: rule__DataField__Group_5__2 : rule__DataField__Group_5__2__Impl rule__DataField__Group_5__3 ;
    public final void rule__DataField__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2643:1: ( rule__DataField__Group_5__2__Impl rule__DataField__Group_5__3 )
            // InternalDataDsl.g:2644:2: rule__DataField__Group_5__2__Impl rule__DataField__Group_5__3
            {
            pushFollow(FOLLOW_20);
            rule__DataField__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__2"


    // $ANTLR start "rule__DataField__Group_5__2__Impl"
    // InternalDataDsl.g:2651:1: rule__DataField__Group_5__2__Impl : ( ( rule__DataField__Group_5_2__0 )* ) ;
    public final void rule__DataField__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2655:1: ( ( ( rule__DataField__Group_5_2__0 )* ) )
            // InternalDataDsl.g:2656:1: ( ( rule__DataField__Group_5_2__0 )* )
            {
            // InternalDataDsl.g:2656:1: ( ( rule__DataField__Group_5_2__0 )* )
            // InternalDataDsl.g:2657:2: ( rule__DataField__Group_5_2__0 )*
            {
             before(grammarAccess.getDataFieldAccess().getGroup_5_2()); 
            // InternalDataDsl.g:2658:2: ( rule__DataField__Group_5_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==41) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDataDsl.g:2658:3: rule__DataField__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataField__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getDataFieldAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__2__Impl"


    // $ANTLR start "rule__DataField__Group_5__3"
    // InternalDataDsl.g:2666:1: rule__DataField__Group_5__3 : rule__DataField__Group_5__3__Impl ;
    public final void rule__DataField__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2670:1: ( rule__DataField__Group_5__3__Impl )
            // InternalDataDsl.g:2671:2: rule__DataField__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__3"


    // $ANTLR start "rule__DataField__Group_5__3__Impl"
    // InternalDataDsl.g:2677:1: rule__DataField__Group_5__3__Impl : ( '>' ) ;
    public final void rule__DataField__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2681:1: ( ( '>' ) )
            // InternalDataDsl.g:2682:1: ( '>' )
            {
            // InternalDataDsl.g:2682:1: ( '>' )
            // InternalDataDsl.g:2683:2: '>'
            {
             before(grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_5_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getGreaterThanSignKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5__3__Impl"


    // $ANTLR start "rule__DataField__Group_5_2__0"
    // InternalDataDsl.g:2693:1: rule__DataField__Group_5_2__0 : rule__DataField__Group_5_2__0__Impl rule__DataField__Group_5_2__1 ;
    public final void rule__DataField__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2697:1: ( rule__DataField__Group_5_2__0__Impl rule__DataField__Group_5_2__1 )
            // InternalDataDsl.g:2698:2: rule__DataField__Group_5_2__0__Impl rule__DataField__Group_5_2__1
            {
            pushFollow(FOLLOW_29);
            rule__DataField__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataField__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5_2__0"


    // $ANTLR start "rule__DataField__Group_5_2__0__Impl"
    // InternalDataDsl.g:2705:1: rule__DataField__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__DataField__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2709:1: ( ( ',' ) )
            // InternalDataDsl.g:2710:1: ( ',' )
            {
            // InternalDataDsl.g:2710:1: ( ',' )
            // InternalDataDsl.g:2711:2: ','
            {
             before(grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDataFieldAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5_2__0__Impl"


    // $ANTLR start "rule__DataField__Group_5_2__1"
    // InternalDataDsl.g:2720:1: rule__DataField__Group_5_2__1 : rule__DataField__Group_5_2__1__Impl ;
    public final void rule__DataField__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2724:1: ( rule__DataField__Group_5_2__1__Impl )
            // InternalDataDsl.g:2725:2: rule__DataField__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataField__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5_2__1"


    // $ANTLR start "rule__DataField__Group_5_2__1__Impl"
    // InternalDataDsl.g:2731:1: rule__DataField__Group_5_2__1__Impl : ( ( rule__DataField__FeaturesAssignment_5_2_1 ) ) ;
    public final void rule__DataField__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2735:1: ( ( ( rule__DataField__FeaturesAssignment_5_2_1 ) ) )
            // InternalDataDsl.g:2736:1: ( ( rule__DataField__FeaturesAssignment_5_2_1 ) )
            {
            // InternalDataDsl.g:2736:1: ( ( rule__DataField__FeaturesAssignment_5_2_1 ) )
            // InternalDataDsl.g:2737:2: ( rule__DataField__FeaturesAssignment_5_2_1 )
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesAssignment_5_2_1()); 
            // InternalDataDsl.g:2738:2: ( rule__DataField__FeaturesAssignment_5_2_1 )
            // InternalDataDsl.g:2738:3: rule__DataField__FeaturesAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataField__FeaturesAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataFieldAccess().getFeaturesAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__Group_5_2__1__Impl"


    // $ANTLR start "rule__Enumeration__Group__0"
    // InternalDataDsl.g:2747:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2751:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalDataDsl.g:2752:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
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
    // InternalDataDsl.g:2759:1: rule__Enumeration__Group__0__Impl : ( 'enum' ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2763:1: ( ( 'enum' ) )
            // InternalDataDsl.g:2764:1: ( 'enum' )
            {
            // InternalDataDsl.g:2764:1: ( 'enum' )
            // InternalDataDsl.g:2765:2: 'enum'
            {
             before(grammarAccess.getEnumerationAccess().getEnumKeyword_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalDataDsl.g:2774:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2778:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalDataDsl.g:2779:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalDataDsl.g:2786:1: rule__Enumeration__Group__1__Impl : ( ( rule__Enumeration__NameAssignment_1 ) ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2790:1: ( ( ( rule__Enumeration__NameAssignment_1 ) ) )
            // InternalDataDsl.g:2791:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:2791:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            // InternalDataDsl.g:2792:2: ( rule__Enumeration__NameAssignment_1 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:2793:2: ( rule__Enumeration__NameAssignment_1 )
            // InternalDataDsl.g:2793:3: rule__Enumeration__NameAssignment_1
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
    // InternalDataDsl.g:2801:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2805:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalDataDsl.g:2806:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalDataDsl.g:2813:1: rule__Enumeration__Group__2__Impl : ( ( rule__Enumeration__Group_2__0 )? ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2817:1: ( ( ( rule__Enumeration__Group_2__0 )? ) )
            // InternalDataDsl.g:2818:1: ( ( rule__Enumeration__Group_2__0 )? )
            {
            // InternalDataDsl.g:2818:1: ( ( rule__Enumeration__Group_2__0 )? )
            // InternalDataDsl.g:2819:2: ( rule__Enumeration__Group_2__0 )?
            {
             before(grammarAccess.getEnumerationAccess().getGroup_2()); 
            // InternalDataDsl.g:2820:2: ( rule__Enumeration__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==39) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDataDsl.g:2820:3: rule__Enumeration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Enumeration__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumerationAccess().getGroup_2()); 

            }


            }

        }
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
    // InternalDataDsl.g:2828:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2832:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalDataDsl.g:2833:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalDataDsl.g:2840:1: rule__Enumeration__Group__3__Impl : ( '{' ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2844:1: ( ( '{' ) )
            // InternalDataDsl.g:2845:1: ( '{' )
            {
            // InternalDataDsl.g:2845:1: ( '{' )
            // InternalDataDsl.g:2846:2: '{'
            {
             before(grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
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
    // InternalDataDsl.g:2855:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2859:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalDataDsl.g:2860:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
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
    // InternalDataDsl.g:2867:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__FieldsAssignment_4 ) ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2871:1: ( ( ( rule__Enumeration__FieldsAssignment_4 ) ) )
            // InternalDataDsl.g:2872:1: ( ( rule__Enumeration__FieldsAssignment_4 ) )
            {
            // InternalDataDsl.g:2872:1: ( ( rule__Enumeration__FieldsAssignment_4 ) )
            // InternalDataDsl.g:2873:2: ( rule__Enumeration__FieldsAssignment_4 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_4()); 
            // InternalDataDsl.g:2874:2: ( rule__Enumeration__FieldsAssignment_4 )
            // InternalDataDsl.g:2874:3: rule__Enumeration__FieldsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__FieldsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getFieldsAssignment_4()); 

            }


            }

        }
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
    // InternalDataDsl.g:2882:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2886:1: ( rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 )
            // InternalDataDsl.g:2887:2: rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__Enumeration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__6();

            state._fsp--;


            }

        }
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
    // InternalDataDsl.g:2894:1: rule__Enumeration__Group__5__Impl : ( ( rule__Enumeration__Group_5__0 )* ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2898:1: ( ( ( rule__Enumeration__Group_5__0 )* ) )
            // InternalDataDsl.g:2899:1: ( ( rule__Enumeration__Group_5__0 )* )
            {
            // InternalDataDsl.g:2899:1: ( ( rule__Enumeration__Group_5__0 )* )
            // InternalDataDsl.g:2900:2: ( rule__Enumeration__Group_5__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_5()); 
            // InternalDataDsl.g:2901:2: ( rule__Enumeration__Group_5__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==41) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDataDsl.g:2901:3: rule__Enumeration__Group_5__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Enumeration__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getEnumerationAccess().getGroup_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__Enumeration__Group__6"
    // InternalDataDsl.g:2909:1: rule__Enumeration__Group__6 : rule__Enumeration__Group__6__Impl ;
    public final void rule__Enumeration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2913:1: ( rule__Enumeration__Group__6__Impl )
            // InternalDataDsl.g:2914:2: rule__Enumeration__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__6"


    // $ANTLR start "rule__Enumeration__Group__6__Impl"
    // InternalDataDsl.g:2920:1: rule__Enumeration__Group__6__Impl : ( '}' ) ;
    public final void rule__Enumeration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2924:1: ( ( '}' ) )
            // InternalDataDsl.g:2925:1: ( '}' )
            {
            // InternalDataDsl.g:2925:1: ( '}' )
            // InternalDataDsl.g:2926:2: '}'
            {
             before(grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_6()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__6__Impl"


    // $ANTLR start "rule__Enumeration__Group_2__0"
    // InternalDataDsl.g:2936:1: rule__Enumeration__Group_2__0 : rule__Enumeration__Group_2__0__Impl rule__Enumeration__Group_2__1 ;
    public final void rule__Enumeration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2940:1: ( rule__Enumeration__Group_2__0__Impl rule__Enumeration__Group_2__1 )
            // InternalDataDsl.g:2941:2: rule__Enumeration__Group_2__0__Impl rule__Enumeration__Group_2__1
            {
            pushFollow(FOLLOW_19);
            rule__Enumeration__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__0"


    // $ANTLR start "rule__Enumeration__Group_2__0__Impl"
    // InternalDataDsl.g:2948:1: rule__Enumeration__Group_2__0__Impl : ( '<' ) ;
    public final void rule__Enumeration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2952:1: ( ( '<' ) )
            // InternalDataDsl.g:2953:1: ( '<' )
            {
            // InternalDataDsl.g:2953:1: ( '<' )
            // InternalDataDsl.g:2954:2: '<'
            {
             before(grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getLessThanSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__0__Impl"


    // $ANTLR start "rule__Enumeration__Group_2__1"
    // InternalDataDsl.g:2963:1: rule__Enumeration__Group_2__1 : rule__Enumeration__Group_2__1__Impl rule__Enumeration__Group_2__2 ;
    public final void rule__Enumeration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2967:1: ( rule__Enumeration__Group_2__1__Impl rule__Enumeration__Group_2__2 )
            // InternalDataDsl.g:2968:2: rule__Enumeration__Group_2__1__Impl rule__Enumeration__Group_2__2
            {
            pushFollow(FOLLOW_20);
            rule__Enumeration__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__1"


    // $ANTLR start "rule__Enumeration__Group_2__1__Impl"
    // InternalDataDsl.g:2975:1: rule__Enumeration__Group_2__1__Impl : ( ( rule__Enumeration__FeaturesAssignment_2_1 ) ) ;
    public final void rule__Enumeration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2979:1: ( ( ( rule__Enumeration__FeaturesAssignment_2_1 ) ) )
            // InternalDataDsl.g:2980:1: ( ( rule__Enumeration__FeaturesAssignment_2_1 ) )
            {
            // InternalDataDsl.g:2980:1: ( ( rule__Enumeration__FeaturesAssignment_2_1 ) )
            // InternalDataDsl.g:2981:2: ( rule__Enumeration__FeaturesAssignment_2_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFeaturesAssignment_2_1()); 
            // InternalDataDsl.g:2982:2: ( rule__Enumeration__FeaturesAssignment_2_1 )
            // InternalDataDsl.g:2982:3: rule__Enumeration__FeaturesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__FeaturesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getFeaturesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__1__Impl"


    // $ANTLR start "rule__Enumeration__Group_2__2"
    // InternalDataDsl.g:2990:1: rule__Enumeration__Group_2__2 : rule__Enumeration__Group_2__2__Impl rule__Enumeration__Group_2__3 ;
    public final void rule__Enumeration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:2994:1: ( rule__Enumeration__Group_2__2__Impl rule__Enumeration__Group_2__3 )
            // InternalDataDsl.g:2995:2: rule__Enumeration__Group_2__2__Impl rule__Enumeration__Group_2__3
            {
            pushFollow(FOLLOW_20);
            rule__Enumeration__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__2"


    // $ANTLR start "rule__Enumeration__Group_2__2__Impl"
    // InternalDataDsl.g:3002:1: rule__Enumeration__Group_2__2__Impl : ( ( rule__Enumeration__Group_2_2__0 )* ) ;
    public final void rule__Enumeration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3006:1: ( ( ( rule__Enumeration__Group_2_2__0 )* ) )
            // InternalDataDsl.g:3007:1: ( ( rule__Enumeration__Group_2_2__0 )* )
            {
            // InternalDataDsl.g:3007:1: ( ( rule__Enumeration__Group_2_2__0 )* )
            // InternalDataDsl.g:3008:2: ( rule__Enumeration__Group_2_2__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_2_2()); 
            // InternalDataDsl.g:3009:2: ( rule__Enumeration__Group_2_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==41) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalDataDsl.g:3009:3: rule__Enumeration__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Enumeration__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getEnumerationAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__2__Impl"


    // $ANTLR start "rule__Enumeration__Group_2__3"
    // InternalDataDsl.g:3017:1: rule__Enumeration__Group_2__3 : rule__Enumeration__Group_2__3__Impl ;
    public final void rule__Enumeration__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3021:1: ( rule__Enumeration__Group_2__3__Impl )
            // InternalDataDsl.g:3022:2: rule__Enumeration__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__3"


    // $ANTLR start "rule__Enumeration__Group_2__3__Impl"
    // InternalDataDsl.g:3028:1: rule__Enumeration__Group_2__3__Impl : ( '>' ) ;
    public final void rule__Enumeration__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3032:1: ( ( '>' ) )
            // InternalDataDsl.g:3033:1: ( '>' )
            {
            // InternalDataDsl.g:3033:1: ( '>' )
            // InternalDataDsl.g:3034:2: '>'
            {
             before(grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getGreaterThanSignKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2__3__Impl"


    // $ANTLR start "rule__Enumeration__Group_2_2__0"
    // InternalDataDsl.g:3044:1: rule__Enumeration__Group_2_2__0 : rule__Enumeration__Group_2_2__0__Impl rule__Enumeration__Group_2_2__1 ;
    public final void rule__Enumeration__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3048:1: ( rule__Enumeration__Group_2_2__0__Impl rule__Enumeration__Group_2_2__1 )
            // InternalDataDsl.g:3049:2: rule__Enumeration__Group_2_2__0__Impl rule__Enumeration__Group_2_2__1
            {
            pushFollow(FOLLOW_19);
            rule__Enumeration__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2_2__0"


    // $ANTLR start "rule__Enumeration__Group_2_2__0__Impl"
    // InternalDataDsl.g:3056:1: rule__Enumeration__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3060:1: ( ( ',' ) )
            // InternalDataDsl.g:3061:1: ( ',' )
            {
            // InternalDataDsl.g:3061:1: ( ',' )
            // InternalDataDsl.g:3062:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2_2__0__Impl"


    // $ANTLR start "rule__Enumeration__Group_2_2__1"
    // InternalDataDsl.g:3071:1: rule__Enumeration__Group_2_2__1 : rule__Enumeration__Group_2_2__1__Impl ;
    public final void rule__Enumeration__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3075:1: ( rule__Enumeration__Group_2_2__1__Impl )
            // InternalDataDsl.g:3076:2: rule__Enumeration__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2_2__1"


    // $ANTLR start "rule__Enumeration__Group_2_2__1__Impl"
    // InternalDataDsl.g:3082:1: rule__Enumeration__Group_2_2__1__Impl : ( ( rule__Enumeration__FeaturesAssignment_2_2_1 ) ) ;
    public final void rule__Enumeration__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3086:1: ( ( ( rule__Enumeration__FeaturesAssignment_2_2_1 ) ) )
            // InternalDataDsl.g:3087:1: ( ( rule__Enumeration__FeaturesAssignment_2_2_1 ) )
            {
            // InternalDataDsl.g:3087:1: ( ( rule__Enumeration__FeaturesAssignment_2_2_1 ) )
            // InternalDataDsl.g:3088:2: ( rule__Enumeration__FeaturesAssignment_2_2_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFeaturesAssignment_2_2_1()); 
            // InternalDataDsl.g:3089:2: ( rule__Enumeration__FeaturesAssignment_2_2_1 )
            // InternalDataDsl.g:3089:3: rule__Enumeration__FeaturesAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__FeaturesAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getFeaturesAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_2_2__1__Impl"


    // $ANTLR start "rule__Enumeration__Group_5__0"
    // InternalDataDsl.g:3098:1: rule__Enumeration__Group_5__0 : rule__Enumeration__Group_5__0__Impl rule__Enumeration__Group_5__1 ;
    public final void rule__Enumeration__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3102:1: ( rule__Enumeration__Group_5__0__Impl rule__Enumeration__Group_5__1 )
            // InternalDataDsl.g:3103:2: rule__Enumeration__Group_5__0__Impl rule__Enumeration__Group_5__1
            {
            pushFollow(FOLLOW_12);
            rule__Enumeration__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_5__0"


    // $ANTLR start "rule__Enumeration__Group_5__0__Impl"
    // InternalDataDsl.g:3110:1: rule__Enumeration__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3114:1: ( ( ',' ) )
            // InternalDataDsl.g:3115:1: ( ',' )
            {
            // InternalDataDsl.g:3115:1: ( ',' )
            // InternalDataDsl.g:3116:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_5_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_5__0__Impl"


    // $ANTLR start "rule__Enumeration__Group_5__1"
    // InternalDataDsl.g:3125:1: rule__Enumeration__Group_5__1 : rule__Enumeration__Group_5__1__Impl ;
    public final void rule__Enumeration__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3129:1: ( rule__Enumeration__Group_5__1__Impl )
            // InternalDataDsl.g:3130:2: rule__Enumeration__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_5__1"


    // $ANTLR start "rule__Enumeration__Group_5__1__Impl"
    // InternalDataDsl.g:3136:1: rule__Enumeration__Group_5__1__Impl : ( ( rule__Enumeration__FieldsAssignment_5_1 ) ) ;
    public final void rule__Enumeration__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3140:1: ( ( ( rule__Enumeration__FieldsAssignment_5_1 ) ) )
            // InternalDataDsl.g:3141:1: ( ( rule__Enumeration__FieldsAssignment_5_1 ) )
            {
            // InternalDataDsl.g:3141:1: ( ( rule__Enumeration__FieldsAssignment_5_1 ) )
            // InternalDataDsl.g:3142:2: ( rule__Enumeration__FieldsAssignment_5_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_5_1()); 
            // InternalDataDsl.g:3143:2: ( rule__Enumeration__FieldsAssignment_5_1 )
            // InternalDataDsl.g:3143:3: rule__Enumeration__FieldsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__FieldsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getFieldsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_5__1__Impl"


    // $ANTLR start "rule__EnumerationField__Group__0"
    // InternalDataDsl.g:3152:1: rule__EnumerationField__Group__0 : rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 ;
    public final void rule__EnumerationField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3156:1: ( rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 )
            // InternalDataDsl.g:3157:2: rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalDataDsl.g:3164:1: rule__EnumerationField__Group__0__Impl : ( ( rule__EnumerationField__NameAssignment_0 ) ) ;
    public final void rule__EnumerationField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3168:1: ( ( ( rule__EnumerationField__NameAssignment_0 ) ) )
            // InternalDataDsl.g:3169:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            {
            // InternalDataDsl.g:3169:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            // InternalDataDsl.g:3170:2: ( rule__EnumerationField__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0()); 
            // InternalDataDsl.g:3171:2: ( rule__EnumerationField__NameAssignment_0 )
            // InternalDataDsl.g:3171:3: rule__EnumerationField__NameAssignment_0
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
    // InternalDataDsl.g:3179:1: rule__EnumerationField__Group__1 : rule__EnumerationField__Group__1__Impl ;
    public final void rule__EnumerationField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3183:1: ( rule__EnumerationField__Group__1__Impl )
            // InternalDataDsl.g:3184:2: rule__EnumerationField__Group__1__Impl
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
    // InternalDataDsl.g:3190:1: rule__EnumerationField__Group__1__Impl : ( ( rule__EnumerationField__Group_1__0 )? ) ;
    public final void rule__EnumerationField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3194:1: ( ( ( rule__EnumerationField__Group_1__0 )? ) )
            // InternalDataDsl.g:3195:1: ( ( rule__EnumerationField__Group_1__0 )? )
            {
            // InternalDataDsl.g:3195:1: ( ( rule__EnumerationField__Group_1__0 )? )
            // InternalDataDsl.g:3196:2: ( rule__EnumerationField__Group_1__0 )?
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup_1()); 
            // InternalDataDsl.g:3197:2: ( rule__EnumerationField__Group_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==46) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDataDsl.g:3197:3: rule__EnumerationField__Group_1__0
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
    // InternalDataDsl.g:3206:1: rule__EnumerationField__Group_1__0 : rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 ;
    public final void rule__EnumerationField__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3210:1: ( rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 )
            // InternalDataDsl.g:3211:2: rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalDataDsl.g:3218:1: rule__EnumerationField__Group_1__0__Impl : ( '(' ) ;
    public final void rule__EnumerationField__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3222:1: ( ( '(' ) )
            // InternalDataDsl.g:3223:1: ( '(' )
            {
            // InternalDataDsl.g:3223:1: ( '(' )
            // InternalDataDsl.g:3224:2: '('
            {
             before(grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalDataDsl.g:3233:1: rule__EnumerationField__Group_1__1 : rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 ;
    public final void rule__EnumerationField__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3237:1: ( rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 )
            // InternalDataDsl.g:3238:2: rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalDataDsl.g:3245:1: rule__EnumerationField__Group_1__1__Impl : ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) ;
    public final void rule__EnumerationField__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3249:1: ( ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) )
            // InternalDataDsl.g:3250:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            {
            // InternalDataDsl.g:3250:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            // InternalDataDsl.g:3251:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1()); 
            // InternalDataDsl.g:3252:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            // InternalDataDsl.g:3252:3: rule__EnumerationField__InitializationValueAssignment_1_1
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
    // InternalDataDsl.g:3260:1: rule__EnumerationField__Group_1__2 : rule__EnumerationField__Group_1__2__Impl ;
    public final void rule__EnumerationField__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3264:1: ( rule__EnumerationField__Group_1__2__Impl )
            // InternalDataDsl.g:3265:2: rule__EnumerationField__Group_1__2__Impl
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
    // InternalDataDsl.g:3271:1: rule__EnumerationField__Group_1__2__Impl : ( ')' ) ;
    public final void rule__EnumerationField__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3275:1: ( ( ')' ) )
            // InternalDataDsl.g:3276:1: ( ')' )
            {
            // InternalDataDsl.g:3276:1: ( ')' )
            // InternalDataDsl.g:3277:2: ')'
            {
             before(grammarAccess.getEnumerationFieldAccess().getRightParenthesisKeyword_1_2()); 
            match(input,47,FOLLOW_2); 
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
    // InternalDataDsl.g:3287:1: rule__DataOperation__Group__0 : rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 ;
    public final void rule__DataOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3291:1: ( rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1 )
            // InternalDataDsl.g:3292:2: rule__DataOperation__Group__0__Impl rule__DataOperation__Group__1
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
    // InternalDataDsl.g:3299:1: rule__DataOperation__Group__0__Impl : ( ( rule__DataOperation__HiddenAssignment_0 )? ) ;
    public final void rule__DataOperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3303:1: ( ( ( rule__DataOperation__HiddenAssignment_0 )? ) )
            // InternalDataDsl.g:3304:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            {
            // InternalDataDsl.g:3304:1: ( ( rule__DataOperation__HiddenAssignment_0 )? )
            // InternalDataDsl.g:3305:2: ( rule__DataOperation__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataOperationAccess().getHiddenAssignment_0()); 
            // InternalDataDsl.g:3306:2: ( rule__DataOperation__HiddenAssignment_0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==62) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalDataDsl.g:3306:3: rule__DataOperation__HiddenAssignment_0
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
    // InternalDataDsl.g:3314:1: rule__DataOperation__Group__1 : rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 ;
    public final void rule__DataOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3318:1: ( rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2 )
            // InternalDataDsl.g:3319:2: rule__DataOperation__Group__1__Impl rule__DataOperation__Group__2
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
    // InternalDataDsl.g:3326:1: rule__DataOperation__Group__1__Impl : ( ( rule__DataOperation__Alternatives_1 ) ) ;
    public final void rule__DataOperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3330:1: ( ( ( rule__DataOperation__Alternatives_1 ) ) )
            // InternalDataDsl.g:3331:1: ( ( rule__DataOperation__Alternatives_1 ) )
            {
            // InternalDataDsl.g:3331:1: ( ( rule__DataOperation__Alternatives_1 ) )
            // InternalDataDsl.g:3332:2: ( rule__DataOperation__Alternatives_1 )
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1()); 
            // InternalDataDsl.g:3333:2: ( rule__DataOperation__Alternatives_1 )
            // InternalDataDsl.g:3333:3: rule__DataOperation__Alternatives_1
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
    // InternalDataDsl.g:3341:1: rule__DataOperation__Group__2 : rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 ;
    public final void rule__DataOperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3345:1: ( rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3 )
            // InternalDataDsl.g:3346:2: rule__DataOperation__Group__2__Impl rule__DataOperation__Group__3
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDsl.g:3353:1: rule__DataOperation__Group__2__Impl : ( ( rule__DataOperation__NameAssignment_2 ) ) ;
    public final void rule__DataOperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3357:1: ( ( ( rule__DataOperation__NameAssignment_2 ) ) )
            // InternalDataDsl.g:3358:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            {
            // InternalDataDsl.g:3358:1: ( ( rule__DataOperation__NameAssignment_2 ) )
            // InternalDataDsl.g:3359:2: ( rule__DataOperation__NameAssignment_2 )
            {
             before(grammarAccess.getDataOperationAccess().getNameAssignment_2()); 
            // InternalDataDsl.g:3360:2: ( rule__DataOperation__NameAssignment_2 )
            // InternalDataDsl.g:3360:3: rule__DataOperation__NameAssignment_2
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
    // InternalDataDsl.g:3368:1: rule__DataOperation__Group__3 : rule__DataOperation__Group__3__Impl rule__DataOperation__Group__4 ;
    public final void rule__DataOperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3372:1: ( rule__DataOperation__Group__3__Impl rule__DataOperation__Group__4 )
            // InternalDataDsl.g:3373:2: rule__DataOperation__Group__3__Impl rule__DataOperation__Group__4
            {
            pushFollow(FOLLOW_33);
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
    // InternalDataDsl.g:3380:1: rule__DataOperation__Group__3__Impl : ( ( rule__DataOperation__Group_3__0 )? ) ;
    public final void rule__DataOperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3384:1: ( ( ( rule__DataOperation__Group_3__0 )? ) )
            // InternalDataDsl.g:3385:1: ( ( rule__DataOperation__Group_3__0 )? )
            {
            // InternalDataDsl.g:3385:1: ( ( rule__DataOperation__Group_3__0 )? )
            // InternalDataDsl.g:3386:2: ( rule__DataOperation__Group_3__0 )?
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3()); 
            // InternalDataDsl.g:3387:2: ( rule__DataOperation__Group_3__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==46) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDataDsl.g:3387:3: rule__DataOperation__Group_3__0
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
    // InternalDataDsl.g:3395:1: rule__DataOperation__Group__4 : rule__DataOperation__Group__4__Impl ;
    public final void rule__DataOperation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3399:1: ( rule__DataOperation__Group__4__Impl )
            // InternalDataDsl.g:3400:2: rule__DataOperation__Group__4__Impl
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
    // InternalDataDsl.g:3406:1: rule__DataOperation__Group__4__Impl : ( ( rule__DataOperation__Group_4__0 )? ) ;
    public final void rule__DataOperation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3410:1: ( ( ( rule__DataOperation__Group_4__0 )? ) )
            // InternalDataDsl.g:3411:1: ( ( rule__DataOperation__Group_4__0 )? )
            {
            // InternalDataDsl.g:3411:1: ( ( rule__DataOperation__Group_4__0 )? )
            // InternalDataDsl.g:3412:2: ( rule__DataOperation__Group_4__0 )?
            {
             before(grammarAccess.getDataOperationAccess().getGroup_4()); 
            // InternalDataDsl.g:3413:2: ( rule__DataOperation__Group_4__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==39) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalDataDsl.g:3413:3: rule__DataOperation__Group_4__0
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
    // InternalDataDsl.g:3422:1: rule__DataOperation__Group_1_1__0 : rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 ;
    public final void rule__DataOperation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3426:1: ( rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1 )
            // InternalDataDsl.g:3427:2: rule__DataOperation__Group_1_1__0__Impl rule__DataOperation__Group_1_1__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDsl.g:3434:1: rule__DataOperation__Group_1_1__0__Impl : ( 'function' ) ;
    public final void rule__DataOperation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3438:1: ( ( 'function' ) )
            // InternalDataDsl.g:3439:1: ( 'function' )
            {
            // InternalDataDsl.g:3439:1: ( 'function' )
            // InternalDataDsl.g:3440:2: 'function'
            {
             before(grammarAccess.getDataOperationAccess().getFunctionKeyword_1_1_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalDataDsl.g:3449:1: rule__DataOperation__Group_1_1__1 : rule__DataOperation__Group_1_1__1__Impl ;
    public final void rule__DataOperation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3453:1: ( rule__DataOperation__Group_1_1__1__Impl )
            // InternalDataDsl.g:3454:2: rule__DataOperation__Group_1_1__1__Impl
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
    // InternalDataDsl.g:3460:1: rule__DataOperation__Group_1_1__1__Impl : ( ( rule__DataOperation__Alternatives_1_1_1 )? ) ;
    public final void rule__DataOperation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3464:1: ( ( ( rule__DataOperation__Alternatives_1_1_1 )? ) )
            // InternalDataDsl.g:3465:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            {
            // InternalDataDsl.g:3465:1: ( ( rule__DataOperation__Alternatives_1_1_1 )? )
            // InternalDataDsl.g:3466:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getAlternatives_1_1_1()); 
            // InternalDataDsl.g:3467:2: ( rule__DataOperation__Alternatives_1_1_1 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=50 && LA43_0<=60)) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID) ) {
                int LA43_2 = input.LA(2);

                if ( (LA43_2==RULE_ID||LA43_2==49||LA43_2==61) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalDataDsl.g:3467:3: rule__DataOperation__Alternatives_1_1_1
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
    // InternalDataDsl.g:3476:1: rule__DataOperation__Group_3__0 : rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 ;
    public final void rule__DataOperation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3480:1: ( rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1 )
            // InternalDataDsl.g:3481:2: rule__DataOperation__Group_3__0__Impl rule__DataOperation__Group_3__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDsl.g:3488:1: rule__DataOperation__Group_3__0__Impl : ( '(' ) ;
    public final void rule__DataOperation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3492:1: ( ( '(' ) )
            // InternalDataDsl.g:3493:1: ( '(' )
            {
            // InternalDataDsl.g:3493:1: ( '(' )
            // InternalDataDsl.g:3494:2: '('
            {
             before(grammarAccess.getDataOperationAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalDataDsl.g:3503:1: rule__DataOperation__Group_3__1 : rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 ;
    public final void rule__DataOperation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3507:1: ( rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2 )
            // InternalDataDsl.g:3508:2: rule__DataOperation__Group_3__1__Impl rule__DataOperation__Group_3__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDsl.g:3515:1: rule__DataOperation__Group_3__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) ;
    public final void rule__DataOperation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3519:1: ( ( ( rule__DataOperation__ParametersAssignment_3_1 )? ) )
            // InternalDataDsl.g:3520:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            {
            // InternalDataDsl.g:3520:1: ( ( rule__DataOperation__ParametersAssignment_3_1 )? )
            // InternalDataDsl.g:3521:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_1()); 
            // InternalDataDsl.g:3522:2: ( rule__DataOperation__ParametersAssignment_3_1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID||(LA44_0>=50 && LA44_0<=60)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalDataDsl.g:3522:3: rule__DataOperation__ParametersAssignment_3_1
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
    // InternalDataDsl.g:3530:1: rule__DataOperation__Group_3__2 : rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 ;
    public final void rule__DataOperation__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3534:1: ( rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3 )
            // InternalDataDsl.g:3535:2: rule__DataOperation__Group_3__2__Impl rule__DataOperation__Group_3__3
            {
            pushFollow(FOLLOW_35);
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
    // InternalDataDsl.g:3542:1: rule__DataOperation__Group_3__2__Impl : ( ( rule__DataOperation__Group_3_2__0 )* ) ;
    public final void rule__DataOperation__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3546:1: ( ( ( rule__DataOperation__Group_3_2__0 )* ) )
            // InternalDataDsl.g:3547:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            {
            // InternalDataDsl.g:3547:1: ( ( rule__DataOperation__Group_3_2__0 )* )
            // InternalDataDsl.g:3548:2: ( rule__DataOperation__Group_3_2__0 )*
            {
             before(grammarAccess.getDataOperationAccess().getGroup_3_2()); 
            // InternalDataDsl.g:3549:2: ( rule__DataOperation__Group_3_2__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==41) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalDataDsl.g:3549:3: rule__DataOperation__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataOperation__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // InternalDataDsl.g:3557:1: rule__DataOperation__Group_3__3 : rule__DataOperation__Group_3__3__Impl ;
    public final void rule__DataOperation__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3561:1: ( rule__DataOperation__Group_3__3__Impl )
            // InternalDataDsl.g:3562:2: rule__DataOperation__Group_3__3__Impl
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
    // InternalDataDsl.g:3568:1: rule__DataOperation__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DataOperation__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3572:1: ( ( ')' ) )
            // InternalDataDsl.g:3573:1: ( ')' )
            {
            // InternalDataDsl.g:3573:1: ( ')' )
            // InternalDataDsl.g:3574:2: ')'
            {
             before(grammarAccess.getDataOperationAccess().getRightParenthesisKeyword_3_3()); 
            match(input,47,FOLLOW_2); 
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
    // InternalDataDsl.g:3584:1: rule__DataOperation__Group_3_2__0 : rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 ;
    public final void rule__DataOperation__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3588:1: ( rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1 )
            // InternalDataDsl.g:3589:2: rule__DataOperation__Group_3_2__0__Impl rule__DataOperation__Group_3_2__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalDataDsl.g:3596:1: rule__DataOperation__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__DataOperation__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3600:1: ( ( ',' ) )
            // InternalDataDsl.g:3601:1: ( ',' )
            {
            // InternalDataDsl.g:3601:1: ( ',' )
            // InternalDataDsl.g:3602:2: ','
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
    // InternalDataDsl.g:3611:1: rule__DataOperation__Group_3_2__1 : rule__DataOperation__Group_3_2__1__Impl ;
    public final void rule__DataOperation__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3615:1: ( rule__DataOperation__Group_3_2__1__Impl )
            // InternalDataDsl.g:3616:2: rule__DataOperation__Group_3_2__1__Impl
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
    // InternalDataDsl.g:3622:1: rule__DataOperation__Group_3_2__1__Impl : ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) ;
    public final void rule__DataOperation__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3626:1: ( ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) ) )
            // InternalDataDsl.g:3627:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            {
            // InternalDataDsl.g:3627:1: ( ( rule__DataOperation__ParametersAssignment_3_2_1 ) )
            // InternalDataDsl.g:3628:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            {
             before(grammarAccess.getDataOperationAccess().getParametersAssignment_3_2_1()); 
            // InternalDataDsl.g:3629:2: ( rule__DataOperation__ParametersAssignment_3_2_1 )
            // InternalDataDsl.g:3629:3: rule__DataOperation__ParametersAssignment_3_2_1
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
    // InternalDataDsl.g:3638:1: rule__DataOperation__Group_4__0 : rule__DataOperation__Group_4__0__Impl rule__DataOperation__Group_4__1 ;
    public final void rule__DataOperation__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3642:1: ( rule__DataOperation__Group_4__0__Impl rule__DataOperation__Group_4__1 )
            // InternalDataDsl.g:3643:2: rule__DataOperation__Group_4__0__Impl rule__DataOperation__Group_4__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalDataDsl.g:3650:1: rule__DataOperation__Group_4__0__Impl : ( '<' ) ;
    public final void rule__DataOperation__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3654:1: ( ( '<' ) )
            // InternalDataDsl.g:3655:1: ( '<' )
            {
            // InternalDataDsl.g:3655:1: ( '<' )
            // InternalDataDsl.g:3656:2: '<'
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
    // InternalDataDsl.g:3665:1: rule__DataOperation__Group_4__1 : rule__DataOperation__Group_4__1__Impl rule__DataOperation__Group_4__2 ;
    public final void rule__DataOperation__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3669:1: ( rule__DataOperation__Group_4__1__Impl rule__DataOperation__Group_4__2 )
            // InternalDataDsl.g:3670:2: rule__DataOperation__Group_4__1__Impl rule__DataOperation__Group_4__2
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
    // InternalDataDsl.g:3677:1: rule__DataOperation__Group_4__1__Impl : ( ( rule__DataOperation__FeaturesAssignment_4_1 ) ) ;
    public final void rule__DataOperation__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3681:1: ( ( ( rule__DataOperation__FeaturesAssignment_4_1 ) ) )
            // InternalDataDsl.g:3682:1: ( ( rule__DataOperation__FeaturesAssignment_4_1 ) )
            {
            // InternalDataDsl.g:3682:1: ( ( rule__DataOperation__FeaturesAssignment_4_1 ) )
            // InternalDataDsl.g:3683:2: ( rule__DataOperation__FeaturesAssignment_4_1 )
            {
             before(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_1()); 
            // InternalDataDsl.g:3684:2: ( rule__DataOperation__FeaturesAssignment_4_1 )
            // InternalDataDsl.g:3684:3: rule__DataOperation__FeaturesAssignment_4_1
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
    // InternalDataDsl.g:3692:1: rule__DataOperation__Group_4__2 : rule__DataOperation__Group_4__2__Impl rule__DataOperation__Group_4__3 ;
    public final void rule__DataOperation__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3696:1: ( rule__DataOperation__Group_4__2__Impl rule__DataOperation__Group_4__3 )
            // InternalDataDsl.g:3697:2: rule__DataOperation__Group_4__2__Impl rule__DataOperation__Group_4__3
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
    // InternalDataDsl.g:3704:1: rule__DataOperation__Group_4__2__Impl : ( ( rule__DataOperation__Group_4_2__0 )* ) ;
    public final void rule__DataOperation__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3708:1: ( ( ( rule__DataOperation__Group_4_2__0 )* ) )
            // InternalDataDsl.g:3709:1: ( ( rule__DataOperation__Group_4_2__0 )* )
            {
            // InternalDataDsl.g:3709:1: ( ( rule__DataOperation__Group_4_2__0 )* )
            // InternalDataDsl.g:3710:2: ( rule__DataOperation__Group_4_2__0 )*
            {
             before(grammarAccess.getDataOperationAccess().getGroup_4_2()); 
            // InternalDataDsl.g:3711:2: ( rule__DataOperation__Group_4_2__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==41) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalDataDsl.g:3711:3: rule__DataOperation__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__DataOperation__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalDataDsl.g:3719:1: rule__DataOperation__Group_4__3 : rule__DataOperation__Group_4__3__Impl ;
    public final void rule__DataOperation__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3723:1: ( rule__DataOperation__Group_4__3__Impl )
            // InternalDataDsl.g:3724:2: rule__DataOperation__Group_4__3__Impl
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
    // InternalDataDsl.g:3730:1: rule__DataOperation__Group_4__3__Impl : ( '>' ) ;
    public final void rule__DataOperation__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3734:1: ( ( '>' ) )
            // InternalDataDsl.g:3735:1: ( '>' )
            {
            // InternalDataDsl.g:3735:1: ( '>' )
            // InternalDataDsl.g:3736:2: '>'
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
    // InternalDataDsl.g:3746:1: rule__DataOperation__Group_4_2__0 : rule__DataOperation__Group_4_2__0__Impl rule__DataOperation__Group_4_2__1 ;
    public final void rule__DataOperation__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3750:1: ( rule__DataOperation__Group_4_2__0__Impl rule__DataOperation__Group_4_2__1 )
            // InternalDataDsl.g:3751:2: rule__DataOperation__Group_4_2__0__Impl rule__DataOperation__Group_4_2__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalDataDsl.g:3758:1: rule__DataOperation__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__DataOperation__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3762:1: ( ( ',' ) )
            // InternalDataDsl.g:3763:1: ( ',' )
            {
            // InternalDataDsl.g:3763:1: ( ',' )
            // InternalDataDsl.g:3764:2: ','
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
    // InternalDataDsl.g:3773:1: rule__DataOperation__Group_4_2__1 : rule__DataOperation__Group_4_2__1__Impl ;
    public final void rule__DataOperation__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3777:1: ( rule__DataOperation__Group_4_2__1__Impl )
            // InternalDataDsl.g:3778:2: rule__DataOperation__Group_4_2__1__Impl
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
    // InternalDataDsl.g:3784:1: rule__DataOperation__Group_4_2__1__Impl : ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) ) ;
    public final void rule__DataOperation__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3788:1: ( ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) ) )
            // InternalDataDsl.g:3789:1: ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) )
            {
            // InternalDataDsl.g:3789:1: ( ( rule__DataOperation__FeaturesAssignment_4_2_1 ) )
            // InternalDataDsl.g:3790:2: ( rule__DataOperation__FeaturesAssignment_4_2_1 )
            {
             before(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_2_1()); 
            // InternalDataDsl.g:3791:2: ( rule__DataOperation__FeaturesAssignment_4_2_1 )
            // InternalDataDsl.g:3791:3: rule__DataOperation__FeaturesAssignment_4_2_1
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
    // InternalDataDsl.g:3800:1: rule__DataOperationParameter__Group__0 : rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 ;
    public final void rule__DataOperationParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3804:1: ( rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1 )
            // InternalDataDsl.g:3805:2: rule__DataOperationParameter__Group__0__Impl rule__DataOperationParameter__Group__1
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
    // InternalDataDsl.g:3812:1: rule__DataOperationParameter__Group__0__Impl : ( ( rule__DataOperationParameter__Alternatives_0 ) ) ;
    public final void rule__DataOperationParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3816:1: ( ( ( rule__DataOperationParameter__Alternatives_0 ) ) )
            // InternalDataDsl.g:3817:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            {
            // InternalDataDsl.g:3817:1: ( ( rule__DataOperationParameter__Alternatives_0 ) )
            // InternalDataDsl.g:3818:2: ( rule__DataOperationParameter__Alternatives_0 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getAlternatives_0()); 
            // InternalDataDsl.g:3819:2: ( rule__DataOperationParameter__Alternatives_0 )
            // InternalDataDsl.g:3819:3: rule__DataOperationParameter__Alternatives_0
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
    // InternalDataDsl.g:3827:1: rule__DataOperationParameter__Group__1 : rule__DataOperationParameter__Group__1__Impl ;
    public final void rule__DataOperationParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3831:1: ( rule__DataOperationParameter__Group__1__Impl )
            // InternalDataDsl.g:3832:2: rule__DataOperationParameter__Group__1__Impl
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
    // InternalDataDsl.g:3838:1: rule__DataOperationParameter__Group__1__Impl : ( ( rule__DataOperationParameter__NameAssignment_1 ) ) ;
    public final void rule__DataOperationParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3842:1: ( ( ( rule__DataOperationParameter__NameAssignment_1 ) ) )
            // InternalDataDsl.g:3843:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            {
            // InternalDataDsl.g:3843:1: ( ( rule__DataOperationParameter__NameAssignment_1 ) )
            // InternalDataDsl.g:3844:2: ( rule__DataOperationParameter__NameAssignment_1 )
            {
             before(grammarAccess.getDataOperationParameterAccess().getNameAssignment_1()); 
            // InternalDataDsl.g:3845:2: ( rule__DataOperationParameter__NameAssignment_1 )
            // InternalDataDsl.g:3845:3: rule__DataOperationParameter__NameAssignment_1
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
    // InternalDataDsl.g:3854:1: rule__ImportedComplexType__Group__0 : rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1 ;
    public final void rule__ImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3858:1: ( rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1 )
            // InternalDataDsl.g:3859:2: rule__ImportedComplexType__Group__0__Impl rule__ImportedComplexType__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalDataDsl.g:3866:1: rule__ImportedComplexType__Group__0__Impl : ( ( rule__ImportedComplexType__ImportAssignment_0 ) ) ;
    public final void rule__ImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3870:1: ( ( ( rule__ImportedComplexType__ImportAssignment_0 ) ) )
            // InternalDataDsl.g:3871:1: ( ( rule__ImportedComplexType__ImportAssignment_0 ) )
            {
            // InternalDataDsl.g:3871:1: ( ( rule__ImportedComplexType__ImportAssignment_0 ) )
            // InternalDataDsl.g:3872:2: ( rule__ImportedComplexType__ImportAssignment_0 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportAssignment_0()); 
            // InternalDataDsl.g:3873:2: ( rule__ImportedComplexType__ImportAssignment_0 )
            // InternalDataDsl.g:3873:3: rule__ImportedComplexType__ImportAssignment_0
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
    // InternalDataDsl.g:3881:1: rule__ImportedComplexType__Group__1 : rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2 ;
    public final void rule__ImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3885:1: ( rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2 )
            // InternalDataDsl.g:3886:2: rule__ImportedComplexType__Group__1__Impl rule__ImportedComplexType__Group__2
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
    // InternalDataDsl.g:3893:1: rule__ImportedComplexType__Group__1__Impl : ( '::' ) ;
    public final void rule__ImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3897:1: ( ( '::' ) )
            // InternalDataDsl.g:3898:1: ( '::' )
            {
            // InternalDataDsl.g:3898:1: ( '::' )
            // InternalDataDsl.g:3899:2: '::'
            {
             before(grammarAccess.getImportedComplexTypeAccess().getColonColonKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalDataDsl.g:3908:1: rule__ImportedComplexType__Group__2 : rule__ImportedComplexType__Group__2__Impl ;
    public final void rule__ImportedComplexType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3912:1: ( rule__ImportedComplexType__Group__2__Impl )
            // InternalDataDsl.g:3913:2: rule__ImportedComplexType__Group__2__Impl
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
    // InternalDataDsl.g:3919:1: rule__ImportedComplexType__Group__2__Impl : ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) ) ;
    public final void rule__ImportedComplexType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3923:1: ( ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) ) )
            // InternalDataDsl.g:3924:1: ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) )
            {
            // InternalDataDsl.g:3924:1: ( ( rule__ImportedComplexType__ImportedTypeAssignment_2 ) )
            // InternalDataDsl.g:3925:2: ( rule__ImportedComplexType__ImportedTypeAssignment_2 )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeAssignment_2()); 
            // InternalDataDsl.g:3926:2: ( rule__ImportedComplexType__ImportedTypeAssignment_2 )
            // InternalDataDsl.g:3926:3: rule__ImportedComplexType__ImportedTypeAssignment_2
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
    // InternalDataDsl.g:3935:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3939:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalDataDsl.g:3940:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalDataDsl.g:3947:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3951:1: ( ( () ) )
            // InternalDataDsl.g:3952:1: ( () )
            {
            // InternalDataDsl.g:3952:1: ( () )
            // InternalDataDsl.g:3953:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalDataDsl.g:3954:2: ()
            // InternalDataDsl.g:3954:3: 
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
    // InternalDataDsl.g:3962:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3966:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalDataDsl.g:3967:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalDataDsl.g:3973:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3977:1: ( ( 'boolean' ) )
            // InternalDataDsl.g:3978:1: ( 'boolean' )
            {
            // InternalDataDsl.g:3978:1: ( 'boolean' )
            // InternalDataDsl.g:3979:2: 'boolean'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 
            match(input,50,FOLLOW_2); 
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
    // InternalDataDsl.g:3989:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:3993:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalDataDsl.g:3994:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalDataDsl.g:4001:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4005:1: ( ( () ) )
            // InternalDataDsl.g:4006:1: ( () )
            {
            // InternalDataDsl.g:4006:1: ( () )
            // InternalDataDsl.g:4007:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalDataDsl.g:4008:2: ()
            // InternalDataDsl.g:4008:3: 
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
    // InternalDataDsl.g:4016:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4020:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalDataDsl.g:4021:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalDataDsl.g:4027:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4031:1: ( ( 'byte' ) )
            // InternalDataDsl.g:4032:1: ( 'byte' )
            {
            // InternalDataDsl.g:4032:1: ( 'byte' )
            // InternalDataDsl.g:4033:2: 'byte'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalDataDsl.g:4043:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4047:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalDataDsl.g:4048:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalDataDsl.g:4055:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4059:1: ( ( () ) )
            // InternalDataDsl.g:4060:1: ( () )
            {
            // InternalDataDsl.g:4060:1: ( () )
            // InternalDataDsl.g:4061:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalDataDsl.g:4062:2: ()
            // InternalDataDsl.g:4062:3: 
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
    // InternalDataDsl.g:4070:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4074:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalDataDsl.g:4075:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalDataDsl.g:4081:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4085:1: ( ( 'char' ) )
            // InternalDataDsl.g:4086:1: ( 'char' )
            {
            // InternalDataDsl.g:4086:1: ( 'char' )
            // InternalDataDsl.g:4087:2: 'char'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalDataDsl.g:4097:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4101:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalDataDsl.g:4102:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalDataDsl.g:4109:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4113:1: ( ( () ) )
            // InternalDataDsl.g:4114:1: ( () )
            {
            // InternalDataDsl.g:4114:1: ( () )
            // InternalDataDsl.g:4115:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalDataDsl.g:4116:2: ()
            // InternalDataDsl.g:4116:3: 
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
    // InternalDataDsl.g:4124:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4128:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalDataDsl.g:4129:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalDataDsl.g:4135:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4139:1: ( ( 'date' ) )
            // InternalDataDsl.g:4140:1: ( 'date' )
            {
            // InternalDataDsl.g:4140:1: ( 'date' )
            // InternalDataDsl.g:4141:2: 'date'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 
            match(input,53,FOLLOW_2); 
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
    // InternalDataDsl.g:4151:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4155:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalDataDsl.g:4156:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalDataDsl.g:4163:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4167:1: ( ( () ) )
            // InternalDataDsl.g:4168:1: ( () )
            {
            // InternalDataDsl.g:4168:1: ( () )
            // InternalDataDsl.g:4169:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalDataDsl.g:4170:2: ()
            // InternalDataDsl.g:4170:3: 
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
    // InternalDataDsl.g:4178:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4182:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalDataDsl.g:4183:2: rule__PrimitiveType__Group_4__1__Impl
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
    // InternalDataDsl.g:4189:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4193:1: ( ( 'double' ) )
            // InternalDataDsl.g:4194:1: ( 'double' )
            {
            // InternalDataDsl.g:4194:1: ( 'double' )
            // InternalDataDsl.g:4195:2: 'double'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalDataDsl.g:4205:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4209:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalDataDsl.g:4210:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalDataDsl.g:4217:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4221:1: ( ( () ) )
            // InternalDataDsl.g:4222:1: ( () )
            {
            // InternalDataDsl.g:4222:1: ( () )
            // InternalDataDsl.g:4223:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalDataDsl.g:4224:2: ()
            // InternalDataDsl.g:4224:3: 
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
    // InternalDataDsl.g:4232:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4236:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalDataDsl.g:4237:2: rule__PrimitiveType__Group_5__1__Impl
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
    // InternalDataDsl.g:4243:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4247:1: ( ( 'float' ) )
            // InternalDataDsl.g:4248:1: ( 'float' )
            {
            // InternalDataDsl.g:4248:1: ( 'float' )
            // InternalDataDsl.g:4249:2: 'float'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalDataDsl.g:4259:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4263:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalDataDsl.g:4264:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalDataDsl.g:4271:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4275:1: ( ( () ) )
            // InternalDataDsl.g:4276:1: ( () )
            {
            // InternalDataDsl.g:4276:1: ( () )
            // InternalDataDsl.g:4277:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalDataDsl.g:4278:2: ()
            // InternalDataDsl.g:4278:3: 
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
    // InternalDataDsl.g:4286:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4290:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalDataDsl.g:4291:2: rule__PrimitiveType__Group_6__1__Impl
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
    // InternalDataDsl.g:4297:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4301:1: ( ( 'int' ) )
            // InternalDataDsl.g:4302:1: ( 'int' )
            {
            // InternalDataDsl.g:4302:1: ( 'int' )
            // InternalDataDsl.g:4303:2: 'int'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 
            match(input,56,FOLLOW_2); 
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
    // InternalDataDsl.g:4313:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4317:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalDataDsl.g:4318:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalDataDsl.g:4325:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4329:1: ( ( () ) )
            // InternalDataDsl.g:4330:1: ( () )
            {
            // InternalDataDsl.g:4330:1: ( () )
            // InternalDataDsl.g:4331:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalDataDsl.g:4332:2: ()
            // InternalDataDsl.g:4332:3: 
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
    // InternalDataDsl.g:4340:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4344:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalDataDsl.g:4345:2: rule__PrimitiveType__Group_7__1__Impl
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
    // InternalDataDsl.g:4351:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4355:1: ( ( 'long' ) )
            // InternalDataDsl.g:4356:1: ( 'long' )
            {
            // InternalDataDsl.g:4356:1: ( 'long' )
            // InternalDataDsl.g:4357:2: 'long'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 
            match(input,57,FOLLOW_2); 
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
    // InternalDataDsl.g:4367:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4371:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalDataDsl.g:4372:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalDataDsl.g:4379:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4383:1: ( ( () ) )
            // InternalDataDsl.g:4384:1: ( () )
            {
            // InternalDataDsl.g:4384:1: ( () )
            // InternalDataDsl.g:4385:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalDataDsl.g:4386:2: ()
            // InternalDataDsl.g:4386:3: 
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
    // InternalDataDsl.g:4394:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4398:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalDataDsl.g:4399:2: rule__PrimitiveType__Group_8__1__Impl
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
    // InternalDataDsl.g:4405:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4409:1: ( ( 'short' ) )
            // InternalDataDsl.g:4410:1: ( 'short' )
            {
            // InternalDataDsl.g:4410:1: ( 'short' )
            // InternalDataDsl.g:4411:2: 'short'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 
            match(input,58,FOLLOW_2); 
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
    // InternalDataDsl.g:4421:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4425:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalDataDsl.g:4426:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalDataDsl.g:4433:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4437:1: ( ( () ) )
            // InternalDataDsl.g:4438:1: ( () )
            {
            // InternalDataDsl.g:4438:1: ( () )
            // InternalDataDsl.g:4439:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalDataDsl.g:4440:2: ()
            // InternalDataDsl.g:4440:3: 
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
    // InternalDataDsl.g:4448:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4452:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalDataDsl.g:4453:2: rule__PrimitiveType__Group_9__1__Impl
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
    // InternalDataDsl.g:4459:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4463:1: ( ( 'string' ) )
            // InternalDataDsl.g:4464:1: ( 'string' )
            {
            // InternalDataDsl.g:4464:1: ( 'string' )
            // InternalDataDsl.g:4465:2: 'string'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 
            match(input,59,FOLLOW_2); 
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


    // $ANTLR start "rule__PrimitiveType__Group_10__0"
    // InternalDataDsl.g:4475:1: rule__PrimitiveType__Group_10__0 : rule__PrimitiveType__Group_10__0__Impl rule__PrimitiveType__Group_10__1 ;
    public final void rule__PrimitiveType__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4479:1: ( rule__PrimitiveType__Group_10__0__Impl rule__PrimitiveType__Group_10__1 )
            // InternalDataDsl.g:4480:2: rule__PrimitiveType__Group_10__0__Impl rule__PrimitiveType__Group_10__1
            {
            pushFollow(FOLLOW_26);
            rule__PrimitiveType__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_10__0"


    // $ANTLR start "rule__PrimitiveType__Group_10__0__Impl"
    // InternalDataDsl.g:4487:1: rule__PrimitiveType__Group_10__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4491:1: ( ( () ) )
            // InternalDataDsl.g:4492:1: ( () )
            {
            // InternalDataDsl.g:4492:1: ( () )
            // InternalDataDsl.g:4493:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0()); 
            // InternalDataDsl.g:4494:2: ()
            // InternalDataDsl.g:4494:3: 
            {
            }

             after(grammarAccess.getPrimitiveTypeAccess().getPrimitiveUnspecifiedAction_10_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_10__0__Impl"


    // $ANTLR start "rule__PrimitiveType__Group_10__1"
    // InternalDataDsl.g:4502:1: rule__PrimitiveType__Group_10__1 : rule__PrimitiveType__Group_10__1__Impl ;
    public final void rule__PrimitiveType__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4506:1: ( rule__PrimitiveType__Group_10__1__Impl )
            // InternalDataDsl.g:4507:2: rule__PrimitiveType__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_10__1"


    // $ANTLR start "rule__PrimitiveType__Group_10__1__Impl"
    // InternalDataDsl.g:4513:1: rule__PrimitiveType__Group_10__1__Impl : ( 'unspecified' ) ;
    public final void rule__PrimitiveType__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4517:1: ( ( 'unspecified' ) )
            // InternalDataDsl.g:4518:1: ( 'unspecified' )
            {
            // InternalDataDsl.g:4518:1: ( 'unspecified' )
            // InternalDataDsl.g:4519:2: 'unspecified'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getUnspecifiedKeyword_10_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getPrimitiveTypeAccess().getUnspecifiedKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveType__Group_10__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalDataDsl.g:4529:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4533:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDataDsl.g:4534:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalDataDsl.g:4541:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4545:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4546:1: ( RULE_ID )
            {
            // InternalDataDsl.g:4546:1: ( RULE_ID )
            // InternalDataDsl.g:4547:2: RULE_ID
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
    // InternalDataDsl.g:4556:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4560:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDataDsl.g:4561:2: rule__QualifiedName__Group__1__Impl
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
    // InternalDataDsl.g:4567:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4571:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDataDsl.g:4572:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDataDsl.g:4572:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDataDsl.g:4573:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDataDsl.g:4574:2: ( rule__QualifiedName__Group_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==61) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalDataDsl.g:4574:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalDataDsl.g:4583:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4587:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDataDsl.g:4588:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalDataDsl.g:4595:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4599:1: ( ( '.' ) )
            // InternalDataDsl.g:4600:1: ( '.' )
            {
            // InternalDataDsl.g:4600:1: ( '.' )
            // InternalDataDsl.g:4601:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalDataDsl.g:4610:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4614:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDataDsl.g:4615:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalDataDsl.g:4621:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4625:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4626:1: ( RULE_ID )
            {
            // InternalDataDsl.g:4626:1: ( RULE_ID )
            // InternalDataDsl.g:4627:2: RULE_ID
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
    // InternalDataDsl.g:4637:1: rule__DataModel__ComplexTypeImportsAssignment_0 : ( ruleComplexTypeImport ) ;
    public final void rule__DataModel__ComplexTypeImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4641:1: ( ( ruleComplexTypeImport ) )
            // InternalDataDsl.g:4642:2: ( ruleComplexTypeImport )
            {
            // InternalDataDsl.g:4642:2: ( ruleComplexTypeImport )
            // InternalDataDsl.g:4643:3: ruleComplexTypeImport
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
    // InternalDataDsl.g:4652:1: rule__DataModel__VersionsAssignment_1_0 : ( ruleVersion ) ;
    public final void rule__DataModel__VersionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4656:1: ( ( ruleVersion ) )
            // InternalDataDsl.g:4657:2: ( ruleVersion )
            {
            // InternalDataDsl.g:4657:2: ( ruleVersion )
            // InternalDataDsl.g:4658:3: ruleVersion
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
    // InternalDataDsl.g:4667:1: rule__DataModel__ContextsAssignment_1_1 : ( ruleContext ) ;
    public final void rule__DataModel__ContextsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4671:1: ( ( ruleContext ) )
            // InternalDataDsl.g:4672:2: ( ruleContext )
            {
            // InternalDataDsl.g:4672:2: ( ruleContext )
            // InternalDataDsl.g:4673:3: ruleContext
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
    // InternalDataDsl.g:4682:1: rule__DataModel__ComplexTypesAssignment_1_2 : ( ruleComplexType ) ;
    public final void rule__DataModel__ComplexTypesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4686:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4687:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4687:2: ( ruleComplexType )
            // InternalDataDsl.g:4688:3: ruleComplexType
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
    // InternalDataDsl.g:4697:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4701:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:4702:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:4702:2: ( RULE_STRING )
            // InternalDataDsl.g:4703:3: RULE_STRING
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
    // InternalDataDsl.g:4712:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4716:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4717:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4717:2: ( RULE_ID )
            // InternalDataDsl.g:4718:3: RULE_ID
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
    // InternalDataDsl.g:4727:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4731:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4732:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4732:2: ( RULE_ID )
            // InternalDataDsl.g:4733:3: RULE_ID
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
    // InternalDataDsl.g:4742:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4746:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4747:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4747:2: ( ruleComplexType )
            // InternalDataDsl.g:4748:3: ruleComplexType
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
    // InternalDataDsl.g:4757:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4761:1: ( ( ruleContext ) )
            // InternalDataDsl.g:4762:2: ( ruleContext )
            {
            // InternalDataDsl.g:4762:2: ( ruleContext )
            // InternalDataDsl.g:4763:3: ruleContext
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
    // InternalDataDsl.g:4772:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4776:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4777:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4777:2: ( RULE_ID )
            // InternalDataDsl.g:4778:3: RULE_ID
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
    // InternalDataDsl.g:4787:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4791:1: ( ( ruleComplexType ) )
            // InternalDataDsl.g:4792:2: ( ruleComplexType )
            {
            // InternalDataDsl.g:4792:2: ( ruleComplexType )
            // InternalDataDsl.g:4793:3: ruleComplexType
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
    // InternalDataDsl.g:4802:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4806:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4807:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4807:2: ( RULE_ID )
            // InternalDataDsl.g:4808:3: RULE_ID
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
    // InternalDataDsl.g:4817:1: rule__DataStructure__FeaturesAssignment_2_1 : ( ruleComplexTypeFeature ) ;
    public final void rule__DataStructure__FeaturesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4821:1: ( ( ruleComplexTypeFeature ) )
            // InternalDataDsl.g:4822:2: ( ruleComplexTypeFeature )
            {
            // InternalDataDsl.g:4822:2: ( ruleComplexTypeFeature )
            // InternalDataDsl.g:4823:3: ruleComplexTypeFeature
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexTypeFeature();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0()); 

            }


            }

        }
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
    // InternalDataDsl.g:4832:1: rule__DataStructure__FeaturesAssignment_2_2_1 : ( ruleComplexTypeFeature ) ;
    public final void rule__DataStructure__FeaturesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4836:1: ( ( ruleComplexTypeFeature ) )
            // InternalDataDsl.g:4837:2: ( ruleComplexTypeFeature )
            {
            // InternalDataDsl.g:4837:2: ( ruleComplexTypeFeature )
            // InternalDataDsl.g:4838:3: ruleComplexTypeFeature
            {
             before(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexTypeFeature();

            state._fsp--;

             after(grammarAccess.getDataStructureAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0()); 

            }


            }

        }
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
    // InternalDataDsl.g:4847:1: rule__DataStructure__SuperAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4851:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:4852:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:4852:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:4853:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_3_1_0()); 
            // InternalDataDsl.g:4854:3: ( ruleQualifiedName )
            // InternalDataDsl.g:4855:4: ruleQualifiedName
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
    // InternalDataDsl.g:4866:1: rule__DataStructure__DataFieldsAssignment_5_0_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_5_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4870:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4871:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4871:2: ( ruleDataField )
            // InternalDataDsl.g:4872:3: ruleDataField
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
    // InternalDataDsl.g:4881:1: rule__DataStructure__OperationsAssignment_5_0_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4885:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4886:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4886:2: ( ruleDataOperation )
            // InternalDataDsl.g:4887:3: ruleDataOperation
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
    // InternalDataDsl.g:4896:1: rule__DataStructure__DataFieldsAssignment_5_1_1_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_5_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4900:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4901:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4901:2: ( ruleDataField )
            // InternalDataDsl.g:4902:3: ruleDataField
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
    // InternalDataDsl.g:4911:1: rule__DataStructure__OperationsAssignment_5_1_1_1 : ( ruleDataOperation ) ;
    public final void rule__DataStructure__OperationsAssignment_5_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4915:1: ( ( ruleDataOperation ) )
            // InternalDataDsl.g:4916:2: ( ruleDataOperation )
            {
            // InternalDataDsl.g:4916:2: ( ruleDataOperation )
            // InternalDataDsl.g:4917:3: ruleDataOperation
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


    // $ANTLR start "rule__CollectionType__NameAssignment_0_1"
    // InternalDataDsl.g:4926:1: rule__CollectionType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__CollectionType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4930:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4931:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4931:2: ( RULE_ID )
            // InternalDataDsl.g:4932:3: RULE_ID
            {
             before(grammarAccess.getCollectionTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__NameAssignment_0_1"


    // $ANTLR start "rule__CollectionType__DataFieldsAssignment_0_3"
    // InternalDataDsl.g:4941:1: rule__CollectionType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__CollectionType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4945:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4946:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4946:2: ( ruleDataField )
            // InternalDataDsl.g:4947:3: ruleDataField
            {
             before(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__DataFieldsAssignment_0_3"


    // $ANTLR start "rule__CollectionType__DataFieldsAssignment_0_4_1"
    // InternalDataDsl.g:4956:1: rule__CollectionType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__CollectionType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4960:1: ( ( ruleDataField ) )
            // InternalDataDsl.g:4961:2: ( ruleDataField )
            {
            // InternalDataDsl.g:4961:2: ( ruleDataField )
            // InternalDataDsl.g:4962:3: ruleDataField
            {
             before(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataField();

            state._fsp--;

             after(grammarAccess.getCollectionTypeAccess().getDataFieldsDataFieldParserRuleCall_0_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__DataFieldsAssignment_0_4_1"


    // $ANTLR start "rule__CollectionType__NameAssignment_1_1"
    // InternalDataDsl.g:4971:1: rule__CollectionType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__CollectionType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4975:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:4976:2: ( RULE_ID )
            {
            // InternalDataDsl.g:4976:2: ( RULE_ID )
            // InternalDataDsl.g:4977:3: RULE_ID
            {
             before(grammarAccess.getCollectionTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCollectionTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__NameAssignment_1_1"


    // $ANTLR start "rule__CollectionType__PrimitiveTypeAssignment_1_3"
    // InternalDataDsl.g:4986:1: rule__CollectionType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__CollectionType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:4990:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:4991:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:4991:2: ( rulePrimitiveType )
            // InternalDataDsl.g:4992:3: rulePrimitiveType
            {
             before(grammarAccess.getCollectionTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getCollectionTypeAccess().getPrimitiveTypePrimitiveTypeParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionType__PrimitiveTypeAssignment_1_3"


    // $ANTLR start "rule__DataField__HiddenAssignment_0"
    // InternalDataDsl.g:5001:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5005:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:5006:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:5006:2: ( ( 'hide' ) )
            // InternalDataDsl.g:5007:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:5008:3: ( 'hide' )
            // InternalDataDsl.g:5009:4: 'hide'
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalDataDsl.g:5020:1: rule__DataField__ImmutableAssignment_1 : ( ( 'immutable' ) ) ;
    public final void rule__DataField__ImmutableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5024:1: ( ( ( 'immutable' ) ) )
            // InternalDataDsl.g:5025:2: ( ( 'immutable' ) )
            {
            // InternalDataDsl.g:5025:2: ( ( 'immutable' ) )
            // InternalDataDsl.g:5026:3: ( 'immutable' )
            {
             before(grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0()); 
            // InternalDataDsl.g:5027:3: ( 'immutable' )
            // InternalDataDsl.g:5028:4: 'immutable'
            {
             before(grammarAccess.getDataFieldAccess().getImmutableImmutableKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalDataDsl.g:5039:1: rule__DataField__PrimitiveTypeAssignment_2_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5043:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:5044:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:5044:2: ( rulePrimitiveType )
            // InternalDataDsl.g:5045:3: rulePrimitiveType
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
    // InternalDataDsl.g:5054:1: rule__DataField__ComplexTypeAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataField__ComplexTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5058:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:5059:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:5059:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:5060:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataFieldAccess().getComplexTypeComplexTypeCrossReference_2_1_0()); 
            // InternalDataDsl.g:5061:3: ( ruleQualifiedName )
            // InternalDataDsl.g:5062:4: ruleQualifiedName
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
    // InternalDataDsl.g:5073:1: rule__DataField__ImportedComplexTypeAssignment_2_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataField__ImportedComplexTypeAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5077:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:5078:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:5078:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:5079:3: ruleImportedComplexType
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
    // InternalDataDsl.g:5088:1: rule__DataField__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5092:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:5093:2: ( RULE_ID )
            {
            // InternalDataDsl.g:5093:2: ( RULE_ID )
            // InternalDataDsl.g:5094:3: RULE_ID
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


    // $ANTLR start "rule__DataField__InitializationValueAssignment_4_1"
    // InternalDataDsl.g:5103:1: rule__DataField__InitializationValueAssignment_4_1 : ( rulePrimitiveValue ) ;
    public final void rule__DataField__InitializationValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5107:1: ( ( rulePrimitiveValue ) )
            // InternalDataDsl.g:5108:2: ( rulePrimitiveValue )
            {
            // InternalDataDsl.g:5108:2: ( rulePrimitiveValue )
            // InternalDataDsl.g:5109:3: rulePrimitiveValue
            {
             before(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveValue();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getInitializationValuePrimitiveValueParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__InitializationValueAssignment_4_1"


    // $ANTLR start "rule__DataField__FeaturesAssignment_5_1"
    // InternalDataDsl.g:5118:1: rule__DataField__FeaturesAssignment_5_1 : ( ruleDataFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5122:1: ( ( ruleDataFieldFeature ) )
            // InternalDataDsl.g:5123:2: ( ruleDataFieldFeature )
            {
            // InternalDataDsl.g:5123:2: ( ruleDataFieldFeature )
            // InternalDataDsl.g:5124:3: ruleDataFieldFeature
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataFieldFeature();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__FeaturesAssignment_5_1"


    // $ANTLR start "rule__DataField__FeaturesAssignment_5_2_1"
    // InternalDataDsl.g:5133:1: rule__DataField__FeaturesAssignment_5_2_1 : ( ruleDataFieldFeature ) ;
    public final void rule__DataField__FeaturesAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5137:1: ( ( ruleDataFieldFeature ) )
            // InternalDataDsl.g:5138:2: ( ruleDataFieldFeature )
            {
            // InternalDataDsl.g:5138:2: ( ruleDataFieldFeature )
            // InternalDataDsl.g:5139:3: ruleDataFieldFeature
            {
             before(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataFieldFeature();

            state._fsp--;

             after(grammarAccess.getDataFieldAccess().getFeaturesDataFieldFeatureEnumRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataField__FeaturesAssignment_5_2_1"


    // $ANTLR start "rule__Enumeration__NameAssignment_1"
    // InternalDataDsl.g:5148:1: rule__Enumeration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5152:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:5153:2: ( RULE_ID )
            {
            // InternalDataDsl.g:5153:2: ( RULE_ID )
            // InternalDataDsl.g:5154:3: RULE_ID
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


    // $ANTLR start "rule__Enumeration__FeaturesAssignment_2_1"
    // InternalDataDsl.g:5163:1: rule__Enumeration__FeaturesAssignment_2_1 : ( ruleComplexTypeFeature ) ;
    public final void rule__Enumeration__FeaturesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5167:1: ( ( ruleComplexTypeFeature ) )
            // InternalDataDsl.g:5168:2: ( ruleComplexTypeFeature )
            {
            // InternalDataDsl.g:5168:2: ( ruleComplexTypeFeature )
            // InternalDataDsl.g:5169:3: ruleComplexTypeFeature
            {
             before(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexTypeFeature();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__FeaturesAssignment_2_1"


    // $ANTLR start "rule__Enumeration__FeaturesAssignment_2_2_1"
    // InternalDataDsl.g:5178:1: rule__Enumeration__FeaturesAssignment_2_2_1 : ( ruleComplexTypeFeature ) ;
    public final void rule__Enumeration__FeaturesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5182:1: ( ( ruleComplexTypeFeature ) )
            // InternalDataDsl.g:5183:2: ( ruleComplexTypeFeature )
            {
            // InternalDataDsl.g:5183:2: ( ruleComplexTypeFeature )
            // InternalDataDsl.g:5184:3: ruleComplexTypeFeature
            {
             before(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComplexTypeFeature();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getFeaturesComplexTypeFeatureEnumRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__FeaturesAssignment_2_2_1"


    // $ANTLR start "rule__Enumeration__FieldsAssignment_4"
    // InternalDataDsl.g:5193:1: rule__Enumeration__FieldsAssignment_4 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5197:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:5198:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:5198:2: ( ruleEnumerationField )
            // InternalDataDsl.g:5199:3: ruleEnumerationField
            {
             before(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerationField();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__FieldsAssignment_4"


    // $ANTLR start "rule__Enumeration__FieldsAssignment_5_1"
    // InternalDataDsl.g:5208:1: rule__Enumeration__FieldsAssignment_5_1 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5212:1: ( ( ruleEnumerationField ) )
            // InternalDataDsl.g:5213:2: ( ruleEnumerationField )
            {
            // InternalDataDsl.g:5213:2: ( ruleEnumerationField )
            // InternalDataDsl.g:5214:3: ruleEnumerationField
            {
             before(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerationField();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getFieldsEnumerationFieldParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__FieldsAssignment_5_1"


    // $ANTLR start "rule__EnumerationField__NameAssignment_0"
    // InternalDataDsl.g:5223:1: rule__EnumerationField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EnumerationField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5227:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:5228:2: ( RULE_ID )
            {
            // InternalDataDsl.g:5228:2: ( RULE_ID )
            // InternalDataDsl.g:5229:3: RULE_ID
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
    // InternalDataDsl.g:5238:1: rule__EnumerationField__InitializationValueAssignment_1_1 : ( rulePrimitiveValue ) ;
    public final void rule__EnumerationField__InitializationValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5242:1: ( ( rulePrimitiveValue ) )
            // InternalDataDsl.g:5243:2: ( rulePrimitiveValue )
            {
            // InternalDataDsl.g:5243:2: ( rulePrimitiveValue )
            // InternalDataDsl.g:5244:3: rulePrimitiveValue
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
    // InternalDataDsl.g:5253:1: rule__DataOperation__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataOperation__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5257:1: ( ( ( 'hide' ) ) )
            // InternalDataDsl.g:5258:2: ( ( 'hide' ) )
            {
            // InternalDataDsl.g:5258:2: ( ( 'hide' ) )
            // InternalDataDsl.g:5259:3: ( 'hide' )
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            // InternalDataDsl.g:5260:3: ( 'hide' )
            // InternalDataDsl.g:5261:4: 'hide'
            {
             before(grammarAccess.getDataOperationAccess().getHiddenHideKeyword_0_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalDataDsl.g:5272:1: rule__DataOperation__HasNoReturnTypeAssignment_1_0 : ( ( 'procedure' ) ) ;
    public final void rule__DataOperation__HasNoReturnTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5276:1: ( ( ( 'procedure' ) ) )
            // InternalDataDsl.g:5277:2: ( ( 'procedure' ) )
            {
            // InternalDataDsl.g:5277:2: ( ( 'procedure' ) )
            // InternalDataDsl.g:5278:3: ( 'procedure' )
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            // InternalDataDsl.g:5279:3: ( 'procedure' )
            // InternalDataDsl.g:5280:4: 'procedure'
            {
             before(grammarAccess.getDataOperationAccess().getHasNoReturnTypeProcedureKeyword_1_0_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalDataDsl.g:5291:1: rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5295:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:5296:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:5296:2: ( rulePrimitiveType )
            // InternalDataDsl.g:5297:3: rulePrimitiveType
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
    // InternalDataDsl.g:5306:1: rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5310:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:5311:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:5311:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:5312:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataOperationAccess().getComplexReturnTypeComplexTypeCrossReference_1_1_1_1_0()); 
            // InternalDataDsl.g:5313:3: ( ruleQualifiedName )
            // InternalDataDsl.g:5314:4: ruleQualifiedName
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
    // InternalDataDsl.g:5325:1: rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5329:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:5330:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:5330:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:5331:3: ruleImportedComplexType
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
    // InternalDataDsl.g:5340:1: rule__DataOperation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataOperation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5344:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:5345:2: ( RULE_ID )
            {
            // InternalDataDsl.g:5345:2: ( RULE_ID )
            // InternalDataDsl.g:5346:3: RULE_ID
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
    // InternalDataDsl.g:5355:1: rule__DataOperation__ParametersAssignment_3_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5359:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:5360:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:5360:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:5361:3: ruleDataOperationParameter
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
    // InternalDataDsl.g:5370:1: rule__DataOperation__ParametersAssignment_3_2_1 : ( ruleDataOperationParameter ) ;
    public final void rule__DataOperation__ParametersAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5374:1: ( ( ruleDataOperationParameter ) )
            // InternalDataDsl.g:5375:2: ( ruleDataOperationParameter )
            {
            // InternalDataDsl.g:5375:2: ( ruleDataOperationParameter )
            // InternalDataDsl.g:5376:3: ruleDataOperationParameter
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
    // InternalDataDsl.g:5385:1: rule__DataOperation__FeaturesAssignment_4_1 : ( ruleDataOperationFeature ) ;
    public final void rule__DataOperation__FeaturesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5389:1: ( ( ruleDataOperationFeature ) )
            // InternalDataDsl.g:5390:2: ( ruleDataOperationFeature )
            {
            // InternalDataDsl.g:5390:2: ( ruleDataOperationFeature )
            // InternalDataDsl.g:5391:3: ruleDataOperationFeature
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
    // InternalDataDsl.g:5400:1: rule__DataOperation__FeaturesAssignment_4_2_1 : ( ruleDataOperationFeature ) ;
    public final void rule__DataOperation__FeaturesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5404:1: ( ( ruleDataOperationFeature ) )
            // InternalDataDsl.g:5405:2: ( ruleDataOperationFeature )
            {
            // InternalDataDsl.g:5405:2: ( ruleDataOperationFeature )
            // InternalDataDsl.g:5406:3: ruleDataOperationFeature
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
    // InternalDataDsl.g:5415:1: rule__DataOperationParameter__PrimitiveTypeAssignment_0_0 : ( rulePrimitiveType ) ;
    public final void rule__DataOperationParameter__PrimitiveTypeAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5419:1: ( ( rulePrimitiveType ) )
            // InternalDataDsl.g:5420:2: ( rulePrimitiveType )
            {
            // InternalDataDsl.g:5420:2: ( rulePrimitiveType )
            // InternalDataDsl.g:5421:3: rulePrimitiveType
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
    // InternalDataDsl.g:5430:1: rule__DataOperationParameter__ComplexTypeAssignment_0_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataOperationParameter__ComplexTypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5434:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:5435:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:5435:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:5436:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataOperationParameterAccess().getComplexTypeComplexTypeCrossReference_0_1_0()); 
            // InternalDataDsl.g:5437:3: ( ruleQualifiedName )
            // InternalDataDsl.g:5438:4: ruleQualifiedName
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
    // InternalDataDsl.g:5449:1: rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2 : ( ruleImportedComplexType ) ;
    public final void rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5453:1: ( ( ruleImportedComplexType ) )
            // InternalDataDsl.g:5454:2: ( ruleImportedComplexType )
            {
            // InternalDataDsl.g:5454:2: ( ruleImportedComplexType )
            // InternalDataDsl.g:5455:3: ruleImportedComplexType
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
    // InternalDataDsl.g:5464:1: rule__DataOperationParameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataOperationParameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5468:1: ( ( RULE_ID ) )
            // InternalDataDsl.g:5469:2: ( RULE_ID )
            {
            // InternalDataDsl.g:5469:2: ( RULE_ID )
            // InternalDataDsl.g:5470:3: RULE_ID
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
    // InternalDataDsl.g:5479:1: rule__PrimitiveValue__NumericValueAssignment_0 : ( RULE_BIG_DECIMAL ) ;
    public final void rule__PrimitiveValue__NumericValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5483:1: ( ( RULE_BIG_DECIMAL ) )
            // InternalDataDsl.g:5484:2: ( RULE_BIG_DECIMAL )
            {
            // InternalDataDsl.g:5484:2: ( RULE_BIG_DECIMAL )
            // InternalDataDsl.g:5485:3: RULE_BIG_DECIMAL
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
    // InternalDataDsl.g:5494:1: rule__PrimitiveValue__BooleanValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__PrimitiveValue__BooleanValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5498:1: ( ( RULE_BOOLEAN ) )
            // InternalDataDsl.g:5499:2: ( RULE_BOOLEAN )
            {
            // InternalDataDsl.g:5499:2: ( RULE_BOOLEAN )
            // InternalDataDsl.g:5500:3: RULE_BOOLEAN
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
    // InternalDataDsl.g:5509:1: rule__PrimitiveValue__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5513:1: ( ( RULE_STRING ) )
            // InternalDataDsl.g:5514:2: ( RULE_STRING )
            {
            // InternalDataDsl.g:5514:2: ( RULE_STRING )
            // InternalDataDsl.g:5515:3: RULE_STRING
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
    // InternalDataDsl.g:5524:1: rule__ImportedComplexType__ImportAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ImportedComplexType__ImportAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5528:1: ( ( ( RULE_ID ) ) )
            // InternalDataDsl.g:5529:2: ( ( RULE_ID ) )
            {
            // InternalDataDsl.g:5529:2: ( ( RULE_ID ) )
            // InternalDataDsl.g:5530:3: ( RULE_ID )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0()); 
            // InternalDataDsl.g:5531:3: ( RULE_ID )
            // InternalDataDsl.g:5532:4: RULE_ID
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
    // InternalDataDsl.g:5543:1: rule__ImportedComplexType__ImportedTypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ImportedComplexType__ImportedTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDataDsl.g:5547:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDataDsl.g:5548:2: ( ( ruleQualifiedName ) )
            {
            // InternalDataDsl.g:5548:2: ( ( ruleQualifiedName ) )
            // InternalDataDsl.g:5549:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getImportedComplexTypeAccess().getImportedTypeTypeCrossReference_2_0()); 
            // InternalDataDsl.g:5550:3: ( ruleQualifiedName )
            // InternalDataDsl.g:5551:4: ruleQualifiedName
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
    static final String dfa_1s = "\21\uffff";
    static final String dfa_2s = "\1\53\1\4\1\43\14\4\2\uffff";
    static final String dfa_3s = "\1\53\1\4\1\43\1\77\13\44\2\uffff";
    static final String dfa_4s = "\17\uffff\1\1\1\2";
    static final String dfa_5s = "\21\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\17\55\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\uffff\2\17",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
            "\1\17\37\uffff\1\20",
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
            return "652:1: rule__CollectionType__Alternatives : ( ( ( rule__CollectionType__Group_0__0 ) ) | ( ( rule__CollectionType__Group_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000284000000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000286400000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000287000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000284000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000048800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0xDFFD001000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000FFE000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xDFFD000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xDFFC000000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000021000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x1FFC000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000408000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x1FFC000000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x1FFC820000000010L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000039000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x2000000000000002L});

}