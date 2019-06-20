package de.fhdo.ddmm.technology.ide.contentassist.antlr.internal;

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
import de.fhdo.ddmm.technology.services.TechnologyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTechnologyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'->'", "'<->'", "'microservices'", "'interfaces'", "'operations'", "'parameters'", "'types'", "'fields'", "'containers'", "'infrastructure'", "'technology'", "'{'", "'}'", "'compatibility'", "'matrix'", "'protocols'", "'service'", "'aspects'", "'deployment'", "'technologies'", "'operation'", "'import'", "'from'", "'as'", "'data'", "'formats'", "','", "'with'", "'format'", "'primitive'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'::'", "'environments'", "'='", "'properties'", "'selector'", "'('", "')'", "'aspect'", "'for'", "'datatypes'", "'version'", "'context'", "'extends'", "'enum'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'default'", "'mandatory'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'hide'"
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
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int RULE_BIG_DECIMAL=6;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;

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

    	public void setGrammarAccess(TechnologyDslGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleTechnology"
    // InternalTechnologyDsl.g:53:1: entryRuleTechnology : ruleTechnology EOF ;
    public final void entryRuleTechnology() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:54:1: ( ruleTechnology EOF )
            // InternalTechnologyDsl.g:55:1: ruleTechnology EOF
            {
             before(grammarAccess.getTechnologyRule()); 
            pushFollow(FOLLOW_1);
            ruleTechnology();

            state._fsp--;

             after(grammarAccess.getTechnologyRule()); 
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
    // $ANTLR end "entryRuleTechnology"


    // $ANTLR start "ruleTechnology"
    // InternalTechnologyDsl.g:62:1: ruleTechnology : ( ( rule__Technology__Group__0 ) ) ;
    public final void ruleTechnology() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:66:2: ( ( ( rule__Technology__Group__0 ) ) )
            // InternalTechnologyDsl.g:67:2: ( ( rule__Technology__Group__0 ) )
            {
            // InternalTechnologyDsl.g:67:2: ( ( rule__Technology__Group__0 ) )
            // InternalTechnologyDsl.g:68:3: ( rule__Technology__Group__0 )
            {
             before(grammarAccess.getTechnologyAccess().getGroup()); 
            // InternalTechnologyDsl.g:69:3: ( rule__Technology__Group__0 )
            // InternalTechnologyDsl.g:69:4: rule__Technology__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTechnology"


    // $ANTLR start "entryRuleTechnologyImport"
    // InternalTechnologyDsl.g:78:1: entryRuleTechnologyImport : ruleTechnologyImport EOF ;
    public final void entryRuleTechnologyImport() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:79:1: ( ruleTechnologyImport EOF )
            // InternalTechnologyDsl.g:80:1: ruleTechnologyImport EOF
            {
             before(grammarAccess.getTechnologyImportRule()); 
            pushFollow(FOLLOW_1);
            ruleTechnologyImport();

            state._fsp--;

             after(grammarAccess.getTechnologyImportRule()); 
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
    // $ANTLR end "entryRuleTechnologyImport"


    // $ANTLR start "ruleTechnologyImport"
    // InternalTechnologyDsl.g:87:1: ruleTechnologyImport : ( ( rule__TechnologyImport__Group__0 ) ) ;
    public final void ruleTechnologyImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:91:2: ( ( ( rule__TechnologyImport__Group__0 ) ) )
            // InternalTechnologyDsl.g:92:2: ( ( rule__TechnologyImport__Group__0 ) )
            {
            // InternalTechnologyDsl.g:92:2: ( ( rule__TechnologyImport__Group__0 ) )
            // InternalTechnologyDsl.g:93:3: ( rule__TechnologyImport__Group__0 )
            {
             before(grammarAccess.getTechnologyImportAccess().getGroup()); 
            // InternalTechnologyDsl.g:94:3: ( rule__TechnologyImport__Group__0 )
            // InternalTechnologyDsl.g:94:4: rule__TechnologyImport__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTechnologyImport"


    // $ANTLR start "entryRuleProtocol"
    // InternalTechnologyDsl.g:103:1: entryRuleProtocol : ruleProtocol EOF ;
    public final void entryRuleProtocol() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:104:1: ( ruleProtocol EOF )
            // InternalTechnologyDsl.g:105:1: ruleProtocol EOF
            {
             before(grammarAccess.getProtocolRule()); 
            pushFollow(FOLLOW_1);
            ruleProtocol();

            state._fsp--;

             after(grammarAccess.getProtocolRule()); 
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
    // $ANTLR end "entryRuleProtocol"


    // $ANTLR start "ruleProtocol"
    // InternalTechnologyDsl.g:112:1: ruleProtocol : ( ( rule__Protocol__Group__0 ) ) ;
    public final void ruleProtocol() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:116:2: ( ( ( rule__Protocol__Group__0 ) ) )
            // InternalTechnologyDsl.g:117:2: ( ( rule__Protocol__Group__0 ) )
            {
            // InternalTechnologyDsl.g:117:2: ( ( rule__Protocol__Group__0 ) )
            // InternalTechnologyDsl.g:118:3: ( rule__Protocol__Group__0 )
            {
             before(grammarAccess.getProtocolAccess().getGroup()); 
            // InternalTechnologyDsl.g:119:3: ( rule__Protocol__Group__0 )
            // InternalTechnologyDsl.g:119:4: rule__Protocol__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProtocol"


    // $ANTLR start "entryRuleDataFormat"
    // InternalTechnologyDsl.g:128:1: entryRuleDataFormat : ruleDataFormat EOF ;
    public final void entryRuleDataFormat() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:129:1: ( ruleDataFormat EOF )
            // InternalTechnologyDsl.g:130:1: ruleDataFormat EOF
            {
             before(grammarAccess.getDataFormatRule()); 
            pushFollow(FOLLOW_1);
            ruleDataFormat();

            state._fsp--;

             after(grammarAccess.getDataFormatRule()); 
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
    // $ANTLR end "entryRuleDataFormat"


    // $ANTLR start "ruleDataFormat"
    // InternalTechnologyDsl.g:137:1: ruleDataFormat : ( ( rule__DataFormat__FormatNameAssignment ) ) ;
    public final void ruleDataFormat() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:141:2: ( ( ( rule__DataFormat__FormatNameAssignment ) ) )
            // InternalTechnologyDsl.g:142:2: ( ( rule__DataFormat__FormatNameAssignment ) )
            {
            // InternalTechnologyDsl.g:142:2: ( ( rule__DataFormat__FormatNameAssignment ) )
            // InternalTechnologyDsl.g:143:3: ( rule__DataFormat__FormatNameAssignment )
            {
             before(grammarAccess.getDataFormatAccess().getFormatNameAssignment()); 
            // InternalTechnologyDsl.g:144:3: ( rule__DataFormat__FormatNameAssignment )
            // InternalTechnologyDsl.g:144:4: rule__DataFormat__FormatNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DataFormat__FormatNameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDataFormatAccess().getFormatNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataFormat"


    // $ANTLR start "entryRuleTechnologySpecificPrimitiveType"
    // InternalTechnologyDsl.g:153:1: entryRuleTechnologySpecificPrimitiveType : ruleTechnologySpecificPrimitiveType EOF ;
    public final void entryRuleTechnologySpecificPrimitiveType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:154:1: ( ruleTechnologySpecificPrimitiveType EOF )
            // InternalTechnologyDsl.g:155:1: ruleTechnologySpecificPrimitiveType EOF
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleTechnologySpecificPrimitiveType();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificPrimitiveTypeRule()); 
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
    // $ANTLR end "entryRuleTechnologySpecificPrimitiveType"


    // $ANTLR start "ruleTechnologySpecificPrimitiveType"
    // InternalTechnologyDsl.g:162:1: ruleTechnologySpecificPrimitiveType : ( ( rule__TechnologySpecificPrimitiveType__Group__0 ) ) ;
    public final void ruleTechnologySpecificPrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:166:2: ( ( ( rule__TechnologySpecificPrimitiveType__Group__0 ) ) )
            // InternalTechnologyDsl.g:167:2: ( ( rule__TechnologySpecificPrimitiveType__Group__0 ) )
            {
            // InternalTechnologyDsl.g:167:2: ( ( rule__TechnologySpecificPrimitiveType__Group__0 ) )
            // InternalTechnologyDsl.g:168:3: ( rule__TechnologySpecificPrimitiveType__Group__0 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup()); 
            // InternalTechnologyDsl.g:169:3: ( rule__TechnologySpecificPrimitiveType__Group__0 )
            // InternalTechnologyDsl.g:169:4: rule__TechnologySpecificPrimitiveType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTechnologySpecificPrimitiveType"


    // $ANTLR start "entryRuleTechnologySpecificListType"
    // InternalTechnologyDsl.g:178:1: entryRuleTechnologySpecificListType : ruleTechnologySpecificListType EOF ;
    public final void entryRuleTechnologySpecificListType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:179:1: ( ruleTechnologySpecificListType EOF )
            // InternalTechnologyDsl.g:180:1: ruleTechnologySpecificListType EOF
            {
             before(grammarAccess.getTechnologySpecificListTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleTechnologySpecificListType();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificListTypeRule()); 
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
    // $ANTLR end "entryRuleTechnologySpecificListType"


    // $ANTLR start "ruleTechnologySpecificListType"
    // InternalTechnologyDsl.g:187:1: ruleTechnologySpecificListType : ( ( rule__TechnologySpecificListType__Group__0 ) ) ;
    public final void ruleTechnologySpecificListType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:191:2: ( ( ( rule__TechnologySpecificListType__Group__0 ) ) )
            // InternalTechnologyDsl.g:192:2: ( ( rule__TechnologySpecificListType__Group__0 ) )
            {
            // InternalTechnologyDsl.g:192:2: ( ( rule__TechnologySpecificListType__Group__0 ) )
            // InternalTechnologyDsl.g:193:3: ( rule__TechnologySpecificListType__Group__0 )
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getGroup()); 
            // InternalTechnologyDsl.g:194:3: ( rule__TechnologySpecificListType__Group__0 )
            // InternalTechnologyDsl.g:194:4: rule__TechnologySpecificListType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificListType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificListTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTechnologySpecificListType"


    // $ANTLR start "entryRuleTechnologySpecificDataStructure"
    // InternalTechnologyDsl.g:203:1: entryRuleTechnologySpecificDataStructure : ruleTechnologySpecificDataStructure EOF ;
    public final void entryRuleTechnologySpecificDataStructure() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:204:1: ( ruleTechnologySpecificDataStructure EOF )
            // InternalTechnologyDsl.g:205:1: ruleTechnologySpecificDataStructure EOF
            {
             before(grammarAccess.getTechnologySpecificDataStructureRule()); 
            pushFollow(FOLLOW_1);
            ruleTechnologySpecificDataStructure();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificDataStructureRule()); 
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
    // $ANTLR end "entryRuleTechnologySpecificDataStructure"


    // $ANTLR start "ruleTechnologySpecificDataStructure"
    // InternalTechnologyDsl.g:212:1: ruleTechnologySpecificDataStructure : ( ( rule__TechnologySpecificDataStructure__Group__0 ) ) ;
    public final void ruleTechnologySpecificDataStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:216:2: ( ( ( rule__TechnologySpecificDataStructure__Group__0 ) ) )
            // InternalTechnologyDsl.g:217:2: ( ( rule__TechnologySpecificDataStructure__Group__0 ) )
            {
            // InternalTechnologyDsl.g:217:2: ( ( rule__TechnologySpecificDataStructure__Group__0 ) )
            // InternalTechnologyDsl.g:218:3: ( rule__TechnologySpecificDataStructure__Group__0 )
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getGroup()); 
            // InternalTechnologyDsl.g:219:3: ( rule__TechnologySpecificDataStructure__Group__0 )
            // InternalTechnologyDsl.g:219:4: rule__TechnologySpecificDataStructure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificDataStructure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificDataStructureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTechnologySpecificDataStructure"


    // $ANTLR start "entryRulePossiblyImportedTechnologySpecificType"
    // InternalTechnologyDsl.g:228:1: entryRulePossiblyImportedTechnologySpecificType : rulePossiblyImportedTechnologySpecificType EOF ;
    public final void entryRulePossiblyImportedTechnologySpecificType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:229:1: ( rulePossiblyImportedTechnologySpecificType EOF )
            // InternalTechnologyDsl.g:230:1: rulePossiblyImportedTechnologySpecificType EOF
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePossiblyImportedTechnologySpecificType();

            state._fsp--;

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeRule()); 
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
    // $ANTLR end "entryRulePossiblyImportedTechnologySpecificType"


    // $ANTLR start "rulePossiblyImportedTechnologySpecificType"
    // InternalTechnologyDsl.g:237:1: rulePossiblyImportedTechnologySpecificType : ( ( rule__PossiblyImportedTechnologySpecificType__Group__0 ) ) ;
    public final void rulePossiblyImportedTechnologySpecificType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:241:2: ( ( ( rule__PossiblyImportedTechnologySpecificType__Group__0 ) ) )
            // InternalTechnologyDsl.g:242:2: ( ( rule__PossiblyImportedTechnologySpecificType__Group__0 ) )
            {
            // InternalTechnologyDsl.g:242:2: ( ( rule__PossiblyImportedTechnologySpecificType__Group__0 ) )
            // InternalTechnologyDsl.g:243:3: ( rule__PossiblyImportedTechnologySpecificType__Group__0 )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup()); 
            // InternalTechnologyDsl.g:244:3: ( rule__PossiblyImportedTechnologySpecificType__Group__0 )
            // InternalTechnologyDsl.g:244:4: rule__PossiblyImportedTechnologySpecificType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePossiblyImportedTechnologySpecificType"


    // $ANTLR start "entryRuleCompatibilityMatrixEntry"
    // InternalTechnologyDsl.g:253:1: entryRuleCompatibilityMatrixEntry : ruleCompatibilityMatrixEntry EOF ;
    public final void entryRuleCompatibilityMatrixEntry() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:254:1: ( ruleCompatibilityMatrixEntry EOF )
            // InternalTechnologyDsl.g:255:1: ruleCompatibilityMatrixEntry EOF
            {
             before(grammarAccess.getCompatibilityMatrixEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleCompatibilityMatrixEntry();

            state._fsp--;

             after(grammarAccess.getCompatibilityMatrixEntryRule()); 
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
    // $ANTLR end "entryRuleCompatibilityMatrixEntry"


    // $ANTLR start "ruleCompatibilityMatrixEntry"
    // InternalTechnologyDsl.g:262:1: ruleCompatibilityMatrixEntry : ( ( rule__CompatibilityMatrixEntry__Group__0 ) ) ;
    public final void ruleCompatibilityMatrixEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:266:2: ( ( ( rule__CompatibilityMatrixEntry__Group__0 ) ) )
            // InternalTechnologyDsl.g:267:2: ( ( rule__CompatibilityMatrixEntry__Group__0 ) )
            {
            // InternalTechnologyDsl.g:267:2: ( ( rule__CompatibilityMatrixEntry__Group__0 ) )
            // InternalTechnologyDsl.g:268:3: ( rule__CompatibilityMatrixEntry__Group__0 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup()); 
            // InternalTechnologyDsl.g:269:3: ( rule__CompatibilityMatrixEntry__Group__0 )
            // InternalTechnologyDsl.g:269:4: rule__CompatibilityMatrixEntry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompatibilityMatrixEntry"


    // $ANTLR start "entryRuleDeploymentTechnology"
    // InternalTechnologyDsl.g:278:1: entryRuleDeploymentTechnology : ruleDeploymentTechnology EOF ;
    public final void entryRuleDeploymentTechnology() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:279:1: ( ruleDeploymentTechnology EOF )
            // InternalTechnologyDsl.g:280:1: ruleDeploymentTechnology EOF
            {
             before(grammarAccess.getDeploymentTechnologyRule()); 
            pushFollow(FOLLOW_1);
            ruleDeploymentTechnology();

            state._fsp--;

             after(grammarAccess.getDeploymentTechnologyRule()); 
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
    // $ANTLR end "entryRuleDeploymentTechnology"


    // $ANTLR start "ruleDeploymentTechnology"
    // InternalTechnologyDsl.g:287:1: ruleDeploymentTechnology : ( ( rule__DeploymentTechnology__Group__0 ) ) ;
    public final void ruleDeploymentTechnology() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:291:2: ( ( ( rule__DeploymentTechnology__Group__0 ) ) )
            // InternalTechnologyDsl.g:292:2: ( ( rule__DeploymentTechnology__Group__0 ) )
            {
            // InternalTechnologyDsl.g:292:2: ( ( rule__DeploymentTechnology__Group__0 ) )
            // InternalTechnologyDsl.g:293:3: ( rule__DeploymentTechnology__Group__0 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getGroup()); 
            // InternalTechnologyDsl.g:294:3: ( rule__DeploymentTechnology__Group__0 )
            // InternalTechnologyDsl.g:294:4: rule__DeploymentTechnology__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeploymentTechnologyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeploymentTechnology"


    // $ANTLR start "entryRuleInfrastructureTechnology"
    // InternalTechnologyDsl.g:303:1: entryRuleInfrastructureTechnology : ruleInfrastructureTechnology EOF ;
    public final void entryRuleInfrastructureTechnology() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:304:1: ( ruleInfrastructureTechnology EOF )
            // InternalTechnologyDsl.g:305:1: ruleInfrastructureTechnology EOF
            {
             before(grammarAccess.getInfrastructureTechnologyRule()); 
            pushFollow(FOLLOW_1);
            ruleInfrastructureTechnology();

            state._fsp--;

             after(grammarAccess.getInfrastructureTechnologyRule()); 
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
    // $ANTLR end "entryRuleInfrastructureTechnology"


    // $ANTLR start "ruleInfrastructureTechnology"
    // InternalTechnologyDsl.g:312:1: ruleInfrastructureTechnology : ( ( rule__InfrastructureTechnology__Group__0 ) ) ;
    public final void ruleInfrastructureTechnology() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:316:2: ( ( ( rule__InfrastructureTechnology__Group__0 ) ) )
            // InternalTechnologyDsl.g:317:2: ( ( rule__InfrastructureTechnology__Group__0 ) )
            {
            // InternalTechnologyDsl.g:317:2: ( ( rule__InfrastructureTechnology__Group__0 ) )
            // InternalTechnologyDsl.g:318:3: ( rule__InfrastructureTechnology__Group__0 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getGroup()); 
            // InternalTechnologyDsl.g:319:3: ( rule__InfrastructureTechnology__Group__0 )
            // InternalTechnologyDsl.g:319:4: rule__InfrastructureTechnology__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInfrastructureTechnology"


    // $ANTLR start "entryRuleOperationEnvironment"
    // InternalTechnologyDsl.g:328:1: entryRuleOperationEnvironment : ruleOperationEnvironment EOF ;
    public final void entryRuleOperationEnvironment() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:329:1: ( ruleOperationEnvironment EOF )
            // InternalTechnologyDsl.g:330:1: ruleOperationEnvironment EOF
            {
             before(grammarAccess.getOperationEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            ruleOperationEnvironment();

            state._fsp--;

             after(grammarAccess.getOperationEnvironmentRule()); 
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
    // $ANTLR end "entryRuleOperationEnvironment"


    // $ANTLR start "ruleOperationEnvironment"
    // InternalTechnologyDsl.g:337:1: ruleOperationEnvironment : ( ( rule__OperationEnvironment__Group__0 ) ) ;
    public final void ruleOperationEnvironment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:341:2: ( ( ( rule__OperationEnvironment__Group__0 ) ) )
            // InternalTechnologyDsl.g:342:2: ( ( rule__OperationEnvironment__Group__0 ) )
            {
            // InternalTechnologyDsl.g:342:2: ( ( rule__OperationEnvironment__Group__0 ) )
            // InternalTechnologyDsl.g:343:3: ( rule__OperationEnvironment__Group__0 )
            {
             before(grammarAccess.getOperationEnvironmentAccess().getGroup()); 
            // InternalTechnologyDsl.g:344:3: ( rule__OperationEnvironment__Group__0 )
            // InternalTechnologyDsl.g:344:4: rule__OperationEnvironment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OperationEnvironment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationEnvironmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperationEnvironment"


    // $ANTLR start "entryRuleTechnologySpecificProperty"
    // InternalTechnologyDsl.g:353:1: entryRuleTechnologySpecificProperty : ruleTechnologySpecificProperty EOF ;
    public final void entryRuleTechnologySpecificProperty() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:354:1: ( ruleTechnologySpecificProperty EOF )
            // InternalTechnologyDsl.g:355:1: ruleTechnologySpecificProperty EOF
            {
             before(grammarAccess.getTechnologySpecificPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleTechnologySpecificProperty();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificPropertyRule()); 
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
    // $ANTLR end "entryRuleTechnologySpecificProperty"


    // $ANTLR start "ruleTechnologySpecificProperty"
    // InternalTechnologyDsl.g:362:1: ruleTechnologySpecificProperty : ( ( rule__TechnologySpecificProperty__Group__0 ) ) ;
    public final void ruleTechnologySpecificProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:366:2: ( ( ( rule__TechnologySpecificProperty__Group__0 ) ) )
            // InternalTechnologyDsl.g:367:2: ( ( rule__TechnologySpecificProperty__Group__0 ) )
            {
            // InternalTechnologyDsl.g:367:2: ( ( rule__TechnologySpecificProperty__Group__0 ) )
            // InternalTechnologyDsl.g:368:3: ( rule__TechnologySpecificProperty__Group__0 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getGroup()); 
            // InternalTechnologyDsl.g:369:3: ( rule__TechnologySpecificProperty__Group__0 )
            // InternalTechnologyDsl.g:369:4: rule__TechnologySpecificProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTechnologySpecificProperty"


    // $ANTLR start "entryRuleServiceAspectPointcut"
    // InternalTechnologyDsl.g:378:1: entryRuleServiceAspectPointcut : ruleServiceAspectPointcut EOF ;
    public final void entryRuleServiceAspectPointcut() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:379:1: ( ruleServiceAspectPointcut EOF )
            // InternalTechnologyDsl.g:380:1: ruleServiceAspectPointcut EOF
            {
             before(grammarAccess.getServiceAspectPointcutRule()); 
            pushFollow(FOLLOW_1);
            ruleServiceAspectPointcut();

            state._fsp--;

             after(grammarAccess.getServiceAspectPointcutRule()); 
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
    // $ANTLR end "entryRuleServiceAspectPointcut"


    // $ANTLR start "ruleServiceAspectPointcut"
    // InternalTechnologyDsl.g:387:1: ruleServiceAspectPointcut : ( ( rule__ServiceAspectPointcut__Alternatives ) ) ;
    public final void ruleServiceAspectPointcut() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:391:2: ( ( ( rule__ServiceAspectPointcut__Alternatives ) ) )
            // InternalTechnologyDsl.g:392:2: ( ( rule__ServiceAspectPointcut__Alternatives ) )
            {
            // InternalTechnologyDsl.g:392:2: ( ( rule__ServiceAspectPointcut__Alternatives ) )
            // InternalTechnologyDsl.g:393:3: ( rule__ServiceAspectPointcut__Alternatives )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:394:3: ( rule__ServiceAspectPointcut__Alternatives )
            // InternalTechnologyDsl.g:394:4: rule__ServiceAspectPointcut__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleServiceAspectPointcut"


    // $ANTLR start "entryRuleServiceAspectPointcutSelector"
    // InternalTechnologyDsl.g:403:1: entryRuleServiceAspectPointcutSelector : ruleServiceAspectPointcutSelector EOF ;
    public final void entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:404:1: ( ruleServiceAspectPointcutSelector EOF )
            // InternalTechnologyDsl.g:405:1: ruleServiceAspectPointcutSelector EOF
            {
             before(grammarAccess.getServiceAspectPointcutSelectorRule()); 
            pushFollow(FOLLOW_1);
            ruleServiceAspectPointcutSelector();

            state._fsp--;

             after(grammarAccess.getServiceAspectPointcutSelectorRule()); 
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
    // $ANTLR end "entryRuleServiceAspectPointcutSelector"


    // $ANTLR start "ruleServiceAspectPointcutSelector"
    // InternalTechnologyDsl.g:412:1: ruleServiceAspectPointcutSelector : ( ( rule__ServiceAspectPointcutSelector__Group__0 ) ) ;
    public final void ruleServiceAspectPointcutSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:416:2: ( ( ( rule__ServiceAspectPointcutSelector__Group__0 ) ) )
            // InternalTechnologyDsl.g:417:2: ( ( rule__ServiceAspectPointcutSelector__Group__0 ) )
            {
            // InternalTechnologyDsl.g:417:2: ( ( rule__ServiceAspectPointcutSelector__Group__0 ) )
            // InternalTechnologyDsl.g:418:3: ( rule__ServiceAspectPointcutSelector__Group__0 )
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup()); 
            // InternalTechnologyDsl.g:419:3: ( rule__ServiceAspectPointcutSelector__Group__0 )
            // InternalTechnologyDsl.g:419:4: rule__ServiceAspectPointcutSelector__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleServiceAspectPointcutSelector"


    // $ANTLR start "entryRuleServiceAspect"
    // InternalTechnologyDsl.g:428:1: entryRuleServiceAspect : ruleServiceAspect EOF ;
    public final void entryRuleServiceAspect() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:429:1: ( ruleServiceAspect EOF )
            // InternalTechnologyDsl.g:430:1: ruleServiceAspect EOF
            {
             before(grammarAccess.getServiceAspectRule()); 
            pushFollow(FOLLOW_1);
            ruleServiceAspect();

            state._fsp--;

             after(grammarAccess.getServiceAspectRule()); 
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
    // $ANTLR end "entryRuleServiceAspect"


    // $ANTLR start "ruleServiceAspect"
    // InternalTechnologyDsl.g:437:1: ruleServiceAspect : ( ( rule__ServiceAspect__Group__0 ) ) ;
    public final void ruleServiceAspect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:441:2: ( ( ( rule__ServiceAspect__Group__0 ) ) )
            // InternalTechnologyDsl.g:442:2: ( ( rule__ServiceAspect__Group__0 ) )
            {
            // InternalTechnologyDsl.g:442:2: ( ( rule__ServiceAspect__Group__0 ) )
            // InternalTechnologyDsl.g:443:3: ( rule__ServiceAspect__Group__0 )
            {
             before(grammarAccess.getServiceAspectAccess().getGroup()); 
            // InternalTechnologyDsl.g:444:3: ( rule__ServiceAspect__Group__0 )
            // InternalTechnologyDsl.g:444:4: rule__ServiceAspect__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleServiceAspect"


    // $ANTLR start "entryRuleOperationAspect"
    // InternalTechnologyDsl.g:453:1: entryRuleOperationAspect : ruleOperationAspect EOF ;
    public final void entryRuleOperationAspect() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:454:1: ( ruleOperationAspect EOF )
            // InternalTechnologyDsl.g:455:1: ruleOperationAspect EOF
            {
             before(grammarAccess.getOperationAspectRule()); 
            pushFollow(FOLLOW_1);
            ruleOperationAspect();

            state._fsp--;

             after(grammarAccess.getOperationAspectRule()); 
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
    // $ANTLR end "entryRuleOperationAspect"


    // $ANTLR start "ruleOperationAspect"
    // InternalTechnologyDsl.g:462:1: ruleOperationAspect : ( ( rule__OperationAspect__Group__0 ) ) ;
    public final void ruleOperationAspect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:466:2: ( ( ( rule__OperationAspect__Group__0 ) ) )
            // InternalTechnologyDsl.g:467:2: ( ( rule__OperationAspect__Group__0 ) )
            {
            // InternalTechnologyDsl.g:467:2: ( ( rule__OperationAspect__Group__0 ) )
            // InternalTechnologyDsl.g:468:3: ( rule__OperationAspect__Group__0 )
            {
             before(grammarAccess.getOperationAspectAccess().getGroup()); 
            // InternalTechnologyDsl.g:469:3: ( rule__OperationAspect__Group__0 )
            // InternalTechnologyDsl.g:469:4: rule__OperationAspect__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationAspectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperationAspect"


    // $ANTLR start "entryRuleComplexTypeImport"
    // InternalTechnologyDsl.g:478:1: entryRuleComplexTypeImport : ruleComplexTypeImport EOF ;
    public final void entryRuleComplexTypeImport() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:479:1: ( ruleComplexTypeImport EOF )
            // InternalTechnologyDsl.g:480:1: ruleComplexTypeImport EOF
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
    // InternalTechnologyDsl.g:487:1: ruleComplexTypeImport : ( ( rule__ComplexTypeImport__Group__0 ) ) ;
    public final void ruleComplexTypeImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:491:2: ( ( ( rule__ComplexTypeImport__Group__0 ) ) )
            // InternalTechnologyDsl.g:492:2: ( ( rule__ComplexTypeImport__Group__0 ) )
            {
            // InternalTechnologyDsl.g:492:2: ( ( rule__ComplexTypeImport__Group__0 ) )
            // InternalTechnologyDsl.g:493:3: ( rule__ComplexTypeImport__Group__0 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getGroup()); 
            // InternalTechnologyDsl.g:494:3: ( rule__ComplexTypeImport__Group__0 )
            // InternalTechnologyDsl.g:494:4: rule__ComplexTypeImport__Group__0
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
    // InternalTechnologyDsl.g:503:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:504:1: ( ruleVersion EOF )
            // InternalTechnologyDsl.g:505:1: ruleVersion EOF
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
    // InternalTechnologyDsl.g:512:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:516:2: ( ( ( rule__Version__Group__0 ) ) )
            // InternalTechnologyDsl.g:517:2: ( ( rule__Version__Group__0 ) )
            {
            // InternalTechnologyDsl.g:517:2: ( ( rule__Version__Group__0 ) )
            // InternalTechnologyDsl.g:518:3: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // InternalTechnologyDsl.g:519:3: ( rule__Version__Group__0 )
            // InternalTechnologyDsl.g:519:4: rule__Version__Group__0
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
    // InternalTechnologyDsl.g:528:1: entryRuleContext : ruleContext EOF ;
    public final void entryRuleContext() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:529:1: ( ruleContext EOF )
            // InternalTechnologyDsl.g:530:1: ruleContext EOF
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
    // InternalTechnologyDsl.g:537:1: ruleContext : ( ( rule__Context__Group__0 ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:541:2: ( ( ( rule__Context__Group__0 ) ) )
            // InternalTechnologyDsl.g:542:2: ( ( rule__Context__Group__0 ) )
            {
            // InternalTechnologyDsl.g:542:2: ( ( rule__Context__Group__0 ) )
            // InternalTechnologyDsl.g:543:3: ( rule__Context__Group__0 )
            {
             before(grammarAccess.getContextAccess().getGroup()); 
            // InternalTechnologyDsl.g:544:3: ( rule__Context__Group__0 )
            // InternalTechnologyDsl.g:544:4: rule__Context__Group__0
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
    // InternalTechnologyDsl.g:553:1: entryRuleComplexType : ruleComplexType EOF ;
    public final void entryRuleComplexType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:554:1: ( ruleComplexType EOF )
            // InternalTechnologyDsl.g:555:1: ruleComplexType EOF
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
    // InternalTechnologyDsl.g:562:1: ruleComplexType : ( ( rule__ComplexType__Alternatives ) ) ;
    public final void ruleComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:566:2: ( ( ( rule__ComplexType__Alternatives ) ) )
            // InternalTechnologyDsl.g:567:2: ( ( rule__ComplexType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:567:2: ( ( rule__ComplexType__Alternatives ) )
            // InternalTechnologyDsl.g:568:3: ( rule__ComplexType__Alternatives )
            {
             before(grammarAccess.getComplexTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:569:3: ( rule__ComplexType__Alternatives )
            // InternalTechnologyDsl.g:569:4: rule__ComplexType__Alternatives
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
    // InternalTechnologyDsl.g:578:1: entryRuleDataStructure : ruleDataStructure EOF ;
    public final void entryRuleDataStructure() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:579:1: ( ruleDataStructure EOF )
            // InternalTechnologyDsl.g:580:1: ruleDataStructure EOF
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
    // InternalTechnologyDsl.g:587:1: ruleDataStructure : ( ( rule__DataStructure__Group__0 ) ) ;
    public final void ruleDataStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:591:2: ( ( ( rule__DataStructure__Group__0 ) ) )
            // InternalTechnologyDsl.g:592:2: ( ( rule__DataStructure__Group__0 ) )
            {
            // InternalTechnologyDsl.g:592:2: ( ( rule__DataStructure__Group__0 ) )
            // InternalTechnologyDsl.g:593:3: ( rule__DataStructure__Group__0 )
            {
             before(grammarAccess.getDataStructureAccess().getGroup()); 
            // InternalTechnologyDsl.g:594:3: ( rule__DataStructure__Group__0 )
            // InternalTechnologyDsl.g:594:4: rule__DataStructure__Group__0
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
    // InternalTechnologyDsl.g:603:1: entryRuleListType : ruleListType EOF ;
    public final void entryRuleListType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:604:1: ( ruleListType EOF )
            // InternalTechnologyDsl.g:605:1: ruleListType EOF
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
    // InternalTechnologyDsl.g:612:1: ruleListType : ( ( rule__ListType__Alternatives ) ) ;
    public final void ruleListType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:616:2: ( ( ( rule__ListType__Alternatives ) ) )
            // InternalTechnologyDsl.g:617:2: ( ( rule__ListType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:617:2: ( ( rule__ListType__Alternatives ) )
            // InternalTechnologyDsl.g:618:3: ( rule__ListType__Alternatives )
            {
             before(grammarAccess.getListTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:619:3: ( rule__ListType__Alternatives )
            // InternalTechnologyDsl.g:619:4: rule__ListType__Alternatives
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
    // InternalTechnologyDsl.g:628:1: entryRuleDataField : ruleDataField EOF ;
    public final void entryRuleDataField() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:629:1: ( ruleDataField EOF )
            // InternalTechnologyDsl.g:630:1: ruleDataField EOF
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
    // InternalTechnologyDsl.g:637:1: ruleDataField : ( ( rule__DataField__Group__0 ) ) ;
    public final void ruleDataField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:641:2: ( ( ( rule__DataField__Group__0 ) ) )
            // InternalTechnologyDsl.g:642:2: ( ( rule__DataField__Group__0 ) )
            {
            // InternalTechnologyDsl.g:642:2: ( ( rule__DataField__Group__0 ) )
            // InternalTechnologyDsl.g:643:3: ( rule__DataField__Group__0 )
            {
             before(grammarAccess.getDataFieldAccess().getGroup()); 
            // InternalTechnologyDsl.g:644:3: ( rule__DataField__Group__0 )
            // InternalTechnologyDsl.g:644:4: rule__DataField__Group__0
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
    // InternalTechnologyDsl.g:653:1: entryRuleEnumeration : ruleEnumeration EOF ;
    public final void entryRuleEnumeration() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:654:1: ( ruleEnumeration EOF )
            // InternalTechnologyDsl.g:655:1: ruleEnumeration EOF
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
    // InternalTechnologyDsl.g:662:1: ruleEnumeration : ( ( rule__Enumeration__Group__0 ) ) ;
    public final void ruleEnumeration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:666:2: ( ( ( rule__Enumeration__Group__0 ) ) )
            // InternalTechnologyDsl.g:667:2: ( ( rule__Enumeration__Group__0 ) )
            {
            // InternalTechnologyDsl.g:667:2: ( ( rule__Enumeration__Group__0 ) )
            // InternalTechnologyDsl.g:668:3: ( rule__Enumeration__Group__0 )
            {
             before(grammarAccess.getEnumerationAccess().getGroup()); 
            // InternalTechnologyDsl.g:669:3: ( rule__Enumeration__Group__0 )
            // InternalTechnologyDsl.g:669:4: rule__Enumeration__Group__0
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
    // InternalTechnologyDsl.g:678:1: entryRuleEnumerationField : ruleEnumerationField EOF ;
    public final void entryRuleEnumerationField() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:679:1: ( ruleEnumerationField EOF )
            // InternalTechnologyDsl.g:680:1: ruleEnumerationField EOF
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
    // InternalTechnologyDsl.g:687:1: ruleEnumerationField : ( ( rule__EnumerationField__Group__0 ) ) ;
    public final void ruleEnumerationField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:691:2: ( ( ( rule__EnumerationField__Group__0 ) ) )
            // InternalTechnologyDsl.g:692:2: ( ( rule__EnumerationField__Group__0 ) )
            {
            // InternalTechnologyDsl.g:692:2: ( ( rule__EnumerationField__Group__0 ) )
            // InternalTechnologyDsl.g:693:3: ( rule__EnumerationField__Group__0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup()); 
            // InternalTechnologyDsl.g:694:3: ( rule__EnumerationField__Group__0 )
            // InternalTechnologyDsl.g:694:4: rule__EnumerationField__Group__0
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


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalTechnologyDsl.g:703:1: entryRulePrimitiveValue : rulePrimitiveValue EOF ;
    public final void entryRulePrimitiveValue() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:704:1: ( rulePrimitiveValue EOF )
            // InternalTechnologyDsl.g:705:1: rulePrimitiveValue EOF
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
    // InternalTechnologyDsl.g:712:1: rulePrimitiveValue : ( ( rule__PrimitiveValue__Alternatives ) ) ;
    public final void rulePrimitiveValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:716:2: ( ( ( rule__PrimitiveValue__Alternatives ) ) )
            // InternalTechnologyDsl.g:717:2: ( ( rule__PrimitiveValue__Alternatives ) )
            {
            // InternalTechnologyDsl.g:717:2: ( ( rule__PrimitiveValue__Alternatives ) )
            // InternalTechnologyDsl.g:718:3: ( rule__PrimitiveValue__Alternatives )
            {
             before(grammarAccess.getPrimitiveValueAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:719:3: ( rule__PrimitiveValue__Alternatives )
            // InternalTechnologyDsl.g:719:4: rule__PrimitiveValue__Alternatives
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
    // InternalTechnologyDsl.g:728:1: entryRulePossiblyImportedComplexType : rulePossiblyImportedComplexType EOF ;
    public final void entryRulePossiblyImportedComplexType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:729:1: ( rulePossiblyImportedComplexType EOF )
            // InternalTechnologyDsl.g:730:1: rulePossiblyImportedComplexType EOF
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
    // InternalTechnologyDsl.g:737:1: rulePossiblyImportedComplexType : ( ( rule__PossiblyImportedComplexType__Group__0 ) ) ;
    public final void rulePossiblyImportedComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:741:2: ( ( ( rule__PossiblyImportedComplexType__Group__0 ) ) )
            // InternalTechnologyDsl.g:742:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            {
            // InternalTechnologyDsl.g:742:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            // InternalTechnologyDsl.g:743:3: ( rule__PossiblyImportedComplexType__Group__0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup()); 
            // InternalTechnologyDsl.g:744:3: ( rule__PossiblyImportedComplexType__Group__0 )
            // InternalTechnologyDsl.g:744:4: rule__PossiblyImportedComplexType__Group__0
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
    // InternalTechnologyDsl.g:753:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:754:1: ( rulePrimitiveType EOF )
            // InternalTechnologyDsl.g:755:1: rulePrimitiveType EOF
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
    // InternalTechnologyDsl.g:762:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:766:2: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalTechnologyDsl.g:767:2: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:767:2: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalTechnologyDsl.g:768:3: ( rule__PrimitiveType__Alternatives )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:769:3: ( rule__PrimitiveType__Alternatives )
            // InternalTechnologyDsl.g:769:4: rule__PrimitiveType__Alternatives
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
    // InternalTechnologyDsl.g:778:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:779:1: ( ruleQualifiedName EOF )
            // InternalTechnologyDsl.g:780:1: ruleQualifiedName EOF
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
    // InternalTechnologyDsl.g:787:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:791:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalTechnologyDsl.g:792:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalTechnologyDsl.g:792:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalTechnologyDsl.g:793:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalTechnologyDsl.g:794:3: ( rule__QualifiedName__Group__0 )
            // InternalTechnologyDsl.g:794:4: rule__QualifiedName__Group__0
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


    // $ANTLR start "ruleExchangePattern"
    // InternalTechnologyDsl.g:803:1: ruleExchangePattern : ( ( rule__ExchangePattern__Alternatives ) ) ;
    public final void ruleExchangePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:807:1: ( ( ( rule__ExchangePattern__Alternatives ) ) )
            // InternalTechnologyDsl.g:808:2: ( ( rule__ExchangePattern__Alternatives ) )
            {
            // InternalTechnologyDsl.g:808:2: ( ( rule__ExchangePattern__Alternatives ) )
            // InternalTechnologyDsl.g:809:3: ( rule__ExchangePattern__Alternatives )
            {
             before(grammarAccess.getExchangePatternAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:810:3: ( rule__ExchangePattern__Alternatives )
            // InternalTechnologyDsl.g:810:4: rule__ExchangePattern__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExchangePattern__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExchangePatternAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExchangePattern"


    // $ANTLR start "ruleCommunicationType"
    // InternalTechnologyDsl.g:819:1: ruleCommunicationType : ( ( rule__CommunicationType__Alternatives ) ) ;
    public final void ruleCommunicationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:823:1: ( ( ( rule__CommunicationType__Alternatives ) ) )
            // InternalTechnologyDsl.g:824:2: ( ( rule__CommunicationType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:824:2: ( ( rule__CommunicationType__Alternatives ) )
            // InternalTechnologyDsl.g:825:3: ( rule__CommunicationType__Alternatives )
            {
             before(grammarAccess.getCommunicationTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:826:3: ( rule__CommunicationType__Alternatives )
            // InternalTechnologyDsl.g:826:4: rule__CommunicationType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CommunicationType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCommunicationTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCommunicationType"


    // $ANTLR start "ruleCompatibilityDirection"
    // InternalTechnologyDsl.g:835:1: ruleCompatibilityDirection : ( ( rule__CompatibilityDirection__Alternatives ) ) ;
    public final void ruleCompatibilityDirection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:839:1: ( ( ( rule__CompatibilityDirection__Alternatives ) ) )
            // InternalTechnologyDsl.g:840:2: ( ( rule__CompatibilityDirection__Alternatives ) )
            {
            // InternalTechnologyDsl.g:840:2: ( ( rule__CompatibilityDirection__Alternatives ) )
            // InternalTechnologyDsl.g:841:3: ( rule__CompatibilityDirection__Alternatives )
            {
             before(grammarAccess.getCompatibilityDirectionAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:842:3: ( rule__CompatibilityDirection__Alternatives )
            // InternalTechnologyDsl.g:842:4: rule__CompatibilityDirection__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityDirection__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCompatibilityDirectionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompatibilityDirection"


    // $ANTLR start "ruleServiceJoinPointType"
    // InternalTechnologyDsl.g:851:1: ruleServiceJoinPointType : ( ( rule__ServiceJoinPointType__Alternatives ) ) ;
    public final void ruleServiceJoinPointType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:855:1: ( ( ( rule__ServiceJoinPointType__Alternatives ) ) )
            // InternalTechnologyDsl.g:856:2: ( ( rule__ServiceJoinPointType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:856:2: ( ( rule__ServiceJoinPointType__Alternatives ) )
            // InternalTechnologyDsl.g:857:3: ( rule__ServiceJoinPointType__Alternatives )
            {
             before(grammarAccess.getServiceJoinPointTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:858:3: ( rule__ServiceJoinPointType__Alternatives )
            // InternalTechnologyDsl.g:858:4: rule__ServiceJoinPointType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ServiceJoinPointType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getServiceJoinPointTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleServiceJoinPointType"


    // $ANTLR start "ruleOperationJoinPointType"
    // InternalTechnologyDsl.g:867:1: ruleOperationJoinPointType : ( ( rule__OperationJoinPointType__Alternatives ) ) ;
    public final void ruleOperationJoinPointType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:871:1: ( ( ( rule__OperationJoinPointType__Alternatives ) ) )
            // InternalTechnologyDsl.g:872:2: ( ( rule__OperationJoinPointType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:872:2: ( ( rule__OperationJoinPointType__Alternatives ) )
            // InternalTechnologyDsl.g:873:3: ( rule__OperationJoinPointType__Alternatives )
            {
             before(grammarAccess.getOperationJoinPointTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:874:3: ( rule__OperationJoinPointType__Alternatives )
            // InternalTechnologyDsl.g:874:4: rule__OperationJoinPointType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OperationJoinPointType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOperationJoinPointTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperationJoinPointType"


    // $ANTLR start "rule__Technology__Alternatives_4_2"
    // InternalTechnologyDsl.g:882:1: rule__Technology__Alternatives_4_2 : ( ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) ) | ( ( rule__Technology__ListTypesAssignment_4_2_1 ) ) | ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) ) );
    public final void rule__Technology__Alternatives_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:886:1: ( ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) ) | ( ( rule__Technology__ListTypesAssignment_4_2_1 ) ) | ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt1=1;
                }
                break;
            case 53:
                {
                alt1=2;
                }
                break;
            case 54:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalTechnologyDsl.g:887:2: ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) )
                    {
                    // InternalTechnologyDsl.g:887:2: ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) )
                    // InternalTechnologyDsl.g:888:3: ( rule__Technology__PrimitiveTypesAssignment_4_2_0 )
                    {
                     before(grammarAccess.getTechnologyAccess().getPrimitiveTypesAssignment_4_2_0()); 
                    // InternalTechnologyDsl.g:889:3: ( rule__Technology__PrimitiveTypesAssignment_4_2_0 )
                    // InternalTechnologyDsl.g:889:4: rule__Technology__PrimitiveTypesAssignment_4_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__PrimitiveTypesAssignment_4_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTechnologyAccess().getPrimitiveTypesAssignment_4_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:893:2: ( ( rule__Technology__ListTypesAssignment_4_2_1 ) )
                    {
                    // InternalTechnologyDsl.g:893:2: ( ( rule__Technology__ListTypesAssignment_4_2_1 ) )
                    // InternalTechnologyDsl.g:894:3: ( rule__Technology__ListTypesAssignment_4_2_1 )
                    {
                     before(grammarAccess.getTechnologyAccess().getListTypesAssignment_4_2_1()); 
                    // InternalTechnologyDsl.g:895:3: ( rule__Technology__ListTypesAssignment_4_2_1 )
                    // InternalTechnologyDsl.g:895:4: rule__Technology__ListTypesAssignment_4_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__ListTypesAssignment_4_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTechnologyAccess().getListTypesAssignment_4_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:899:2: ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) )
                    {
                    // InternalTechnologyDsl.g:899:2: ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) )
                    // InternalTechnologyDsl.g:900:3: ( rule__Technology__DataStructuresAssignment_4_2_2 )
                    {
                     before(grammarAccess.getTechnologyAccess().getDataStructuresAssignment_4_2_2()); 
                    // InternalTechnologyDsl.g:901:3: ( rule__Technology__DataStructuresAssignment_4_2_2 )
                    // InternalTechnologyDsl.g:901:4: rule__Technology__DataStructuresAssignment_4_2_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__DataStructuresAssignment_4_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getTechnologyAccess().getDataStructuresAssignment_4_2_2()); 

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
    // $ANTLR end "rule__Technology__Alternatives_4_2"


    // $ANTLR start "rule__TechnologySpecificProperty__Alternatives_2"
    // InternalTechnologyDsl.g:909:1: rule__TechnologySpecificProperty__Alternatives_2 : ( ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) ) | ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) ) );
    public final void rule__TechnologySpecificProperty__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:913:1: ( ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) ) | ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==57) ) {
                alt2=1;
            }
            else if ( (LA2_0==81) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTechnologyDsl.g:914:2: ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:914:2: ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) )
                    // InternalTechnologyDsl.g:915:3: ( rule__TechnologySpecificProperty__Group_2_0__0 )
                    {
                     before(grammarAccess.getTechnologySpecificPropertyAccess().getGroup_2_0()); 
                    // InternalTechnologyDsl.g:916:3: ( rule__TechnologySpecificProperty__Group_2_0__0 )
                    // InternalTechnologyDsl.g:916:4: rule__TechnologySpecificProperty__Group_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TechnologySpecificProperty__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTechnologySpecificPropertyAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:920:2: ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) )
                    {
                    // InternalTechnologyDsl.g:920:2: ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) )
                    // InternalTechnologyDsl.g:921:3: ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 )
                    {
                     before(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryAssignment_2_1()); 
                    // InternalTechnologyDsl.g:922:3: ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 )
                    // InternalTechnologyDsl.g:922:4: rule__TechnologySpecificProperty__MandatoryAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TechnologySpecificProperty__MandatoryAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryAssignment_2_1()); 

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
    // $ANTLR end "rule__TechnologySpecificProperty__Alternatives_2"


    // $ANTLR start "rule__ServiceAspectPointcut__Alternatives"
    // InternalTechnologyDsl.g:930:1: rule__ServiceAspectPointcut__Alternatives : ( ( ( rule__ServiceAspectPointcut__Group_0__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_1__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_2__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_3__0 ) ) );
    public final void rule__ServiceAspectPointcut__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:934:1: ( ( ( rule__ServiceAspectPointcut__Group_0__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_1__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_2__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_3__0 ) ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt3=1;
                }
                break;
            case 83:
                {
                alt3=2;
                }
                break;
            case 84:
                {
                alt3=3;
                }
                break;
            case 85:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalTechnologyDsl.g:935:2: ( ( rule__ServiceAspectPointcut__Group_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:935:2: ( ( rule__ServiceAspectPointcut__Group_0__0 ) )
                    // InternalTechnologyDsl.g:936:3: ( rule__ServiceAspectPointcut__Group_0__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_0()); 
                    // InternalTechnologyDsl.g:937:3: ( rule__ServiceAspectPointcut__Group_0__0 )
                    // InternalTechnologyDsl.g:937:4: rule__ServiceAspectPointcut__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ServiceAspectPointcut__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getServiceAspectPointcutAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:941:2: ( ( rule__ServiceAspectPointcut__Group_1__0 ) )
                    {
                    // InternalTechnologyDsl.g:941:2: ( ( rule__ServiceAspectPointcut__Group_1__0 ) )
                    // InternalTechnologyDsl.g:942:3: ( rule__ServiceAspectPointcut__Group_1__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_1()); 
                    // InternalTechnologyDsl.g:943:3: ( rule__ServiceAspectPointcut__Group_1__0 )
                    // InternalTechnologyDsl.g:943:4: rule__ServiceAspectPointcut__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ServiceAspectPointcut__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getServiceAspectPointcutAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:947:2: ( ( rule__ServiceAspectPointcut__Group_2__0 ) )
                    {
                    // InternalTechnologyDsl.g:947:2: ( ( rule__ServiceAspectPointcut__Group_2__0 ) )
                    // InternalTechnologyDsl.g:948:3: ( rule__ServiceAspectPointcut__Group_2__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_2()); 
                    // InternalTechnologyDsl.g:949:3: ( rule__ServiceAspectPointcut__Group_2__0 )
                    // InternalTechnologyDsl.g:949:4: rule__ServiceAspectPointcut__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ServiceAspectPointcut__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getServiceAspectPointcutAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:953:2: ( ( rule__ServiceAspectPointcut__Group_3__0 ) )
                    {
                    // InternalTechnologyDsl.g:953:2: ( ( rule__ServiceAspectPointcut__Group_3__0 ) )
                    // InternalTechnologyDsl.g:954:3: ( rule__ServiceAspectPointcut__Group_3__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_3()); 
                    // InternalTechnologyDsl.g:955:3: ( rule__ServiceAspectPointcut__Group_3__0 )
                    // InternalTechnologyDsl.g:955:4: rule__ServiceAspectPointcut__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ServiceAspectPointcut__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getServiceAspectPointcutAccess().getGroup_3()); 

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
    // $ANTLR end "rule__ServiceAspectPointcut__Alternatives"


    // $ANTLR start "rule__ServiceAspect__Alternatives_5"
    // InternalTechnologyDsl.g:963:1: rule__ServiceAspect__Alternatives_5 : ( ( ( rule__ServiceAspect__Group_5_0__0 ) ) | ( ';' ) );
    public final void rule__ServiceAspect__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:967:1: ( ( ( rule__ServiceAspect__Group_5_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==31) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTechnologyDsl.g:968:2: ( ( rule__ServiceAspect__Group_5_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:968:2: ( ( rule__ServiceAspect__Group_5_0__0 ) )
                    // InternalTechnologyDsl.g:969:3: ( rule__ServiceAspect__Group_5_0__0 )
                    {
                     before(grammarAccess.getServiceAspectAccess().getGroup_5_0()); 
                    // InternalTechnologyDsl.g:970:3: ( rule__ServiceAspect__Group_5_0__0 )
                    // InternalTechnologyDsl.g:970:4: rule__ServiceAspect__Group_5_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ServiceAspect__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getServiceAspectAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:974:2: ( ';' )
                    {
                    // InternalTechnologyDsl.g:974:2: ( ';' )
                    // InternalTechnologyDsl.g:975:3: ';'
                    {
                     before(grammarAccess.getServiceAspectAccess().getSemicolonKeyword_5_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getServiceAspectAccess().getSemicolonKeyword_5_1()); 

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
    // $ANTLR end "rule__ServiceAspect__Alternatives_5"


    // $ANTLR start "rule__OperationAspect__Alternatives_5"
    // InternalTechnologyDsl.g:984:1: rule__OperationAspect__Alternatives_5 : ( ( ( rule__OperationAspect__Group_5_0__0 ) ) | ( ';' ) );
    public final void rule__OperationAspect__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:988:1: ( ( ( rule__OperationAspect__Group_5_0__0 ) ) | ( ';' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            else if ( (LA5_0==13) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTechnologyDsl.g:989:2: ( ( rule__OperationAspect__Group_5_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:989:2: ( ( rule__OperationAspect__Group_5_0__0 ) )
                    // InternalTechnologyDsl.g:990:3: ( rule__OperationAspect__Group_5_0__0 )
                    {
                     before(grammarAccess.getOperationAspectAccess().getGroup_5_0()); 
                    // InternalTechnologyDsl.g:991:3: ( rule__OperationAspect__Group_5_0__0 )
                    // InternalTechnologyDsl.g:991:4: rule__OperationAspect__Group_5_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OperationAspect__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOperationAspectAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:995:2: ( ';' )
                    {
                    // InternalTechnologyDsl.g:995:2: ( ';' )
                    // InternalTechnologyDsl.g:996:3: ';'
                    {
                     before(grammarAccess.getOperationAspectAccess().getSemicolonKeyword_5_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getOperationAspectAccess().getSemicolonKeyword_5_1()); 

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
    // $ANTLR end "rule__OperationAspect__Alternatives_5"


    // $ANTLR start "rule__Version__Alternatives_3"
    // InternalTechnologyDsl.g:1005:1: rule__Version__Alternatives_3 : ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) );
    public final void rule__Version__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1009:1: ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=53 && LA8_0<=54)||LA8_0==68) ) {
                alt8=1;
            }
            else if ( (LA8_0==66) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalTechnologyDsl.g:1010:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    {
                    // InternalTechnologyDsl.g:1010:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    // InternalTechnologyDsl.g:1011:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    {
                    // InternalTechnologyDsl.g:1011:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) )
                    // InternalTechnologyDsl.g:1012:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalTechnologyDsl.g:1013:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    // InternalTechnologyDsl.g:1013:5: rule__Version__ComplexTypesAssignment_3_0
                    {
                    pushFollow(FOLLOW_3);
                    rule__Version__ComplexTypesAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }

                    // InternalTechnologyDsl.g:1016:3: ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    // InternalTechnologyDsl.g:1017:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalTechnologyDsl.g:1018:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=53 && LA6_0<=54)||LA6_0==68) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1018:5: rule__Version__ComplexTypesAssignment_3_0
                    	    {
                    	    pushFollow(FOLLOW_3);
                    	    rule__Version__ComplexTypesAssignment_3_0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1023:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    {
                    // InternalTechnologyDsl.g:1023:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    // InternalTechnologyDsl.g:1024:3: ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* )
                    {
                    // InternalTechnologyDsl.g:1024:3: ( ( rule__Version__ContextsAssignment_3_1 ) )
                    // InternalTechnologyDsl.g:1025:4: ( rule__Version__ContextsAssignment_3_1 )
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalTechnologyDsl.g:1026:4: ( rule__Version__ContextsAssignment_3_1 )
                    // InternalTechnologyDsl.g:1026:5: rule__Version__ContextsAssignment_3_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__Version__ContextsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 

                    }

                    // InternalTechnologyDsl.g:1029:3: ( ( rule__Version__ContextsAssignment_3_1 )* )
                    // InternalTechnologyDsl.g:1030:4: ( rule__Version__ContextsAssignment_3_1 )*
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalTechnologyDsl.g:1031:4: ( rule__Version__ContextsAssignment_3_1 )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==66) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1031:5: rule__Version__ContextsAssignment_3_1
                    	    {
                    	    pushFollow(FOLLOW_4);
                    	    rule__Version__ContextsAssignment_3_1();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
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
    // InternalTechnologyDsl.g:1040:1: rule__ComplexType__Alternatives : ( ( ruleDataStructure ) | ( ruleListType ) | ( ruleEnumeration ) );
    public final void rule__ComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1044:1: ( ( ruleDataStructure ) | ( ruleListType ) | ( ruleEnumeration ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt9=1;
                }
                break;
            case 53:
                {
                alt9=2;
                }
                break;
            case 68:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalTechnologyDsl.g:1045:2: ( ruleDataStructure )
                    {
                    // InternalTechnologyDsl.g:1045:2: ( ruleDataStructure )
                    // InternalTechnologyDsl.g:1046:3: ruleDataStructure
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
                    // InternalTechnologyDsl.g:1051:2: ( ruleListType )
                    {
                    // InternalTechnologyDsl.g:1051:2: ( ruleListType )
                    // InternalTechnologyDsl.g:1052:3: ruleListType
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
                    // InternalTechnologyDsl.g:1057:2: ( ruleEnumeration )
                    {
                    // InternalTechnologyDsl.g:1057:2: ( ruleEnumeration )
                    // InternalTechnologyDsl.g:1058:3: ruleEnumeration
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


    // $ANTLR start "rule__ListType__Alternatives"
    // InternalTechnologyDsl.g:1067:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );
    public final void rule__ListType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1071:1: ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalTechnologyDsl.g:1072:2: ( ( rule__ListType__Group_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:1072:2: ( ( rule__ListType__Group_0__0 ) )
                    // InternalTechnologyDsl.g:1073:3: ( rule__ListType__Group_0__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_0()); 
                    // InternalTechnologyDsl.g:1074:3: ( rule__ListType__Group_0__0 )
                    // InternalTechnologyDsl.g:1074:4: rule__ListType__Group_0__0
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
                    // InternalTechnologyDsl.g:1078:2: ( ( rule__ListType__Group_1__0 ) )
                    {
                    // InternalTechnologyDsl.g:1078:2: ( ( rule__ListType__Group_1__0 ) )
                    // InternalTechnologyDsl.g:1079:3: ( rule__ListType__Group_1__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_1()); 
                    // InternalTechnologyDsl.g:1080:3: ( rule__ListType__Group_1__0 )
                    // InternalTechnologyDsl.g:1080:4: rule__ListType__Group_1__0
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
    // InternalTechnologyDsl.g:1088:1: rule__DataField__Alternatives_1 : ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) );
    public final void rule__DataField__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1092:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=69 && LA11_0<=78)) ) {
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
                    // InternalTechnologyDsl.g:1093:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    {
                    // InternalTechnologyDsl.g:1093:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    // InternalTechnologyDsl.g:1094:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_1_0()); 
                    // InternalTechnologyDsl.g:1095:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    // InternalTechnologyDsl.g:1095:4: rule__DataField__PrimitiveTypeAssignment_1_0
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
                    // InternalTechnologyDsl.g:1099:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    {
                    // InternalTechnologyDsl.g:1099:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    // InternalTechnologyDsl.g:1100:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    {
                     before(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 
                    // InternalTechnologyDsl.g:1101:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    // InternalTechnologyDsl.g:1101:4: rule__DataField__ComplexTypeAssignment_1_1
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


    // $ANTLR start "rule__PrimitiveValue__Alternatives"
    // InternalTechnologyDsl.g:1109:1: rule__PrimitiveValue__Alternatives : ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) );
    public final void rule__PrimitiveValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1113:1: ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt12=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt12=2;
                }
                break;
            case RULE_STRING:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalTechnologyDsl.g:1114:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    {
                    // InternalTechnologyDsl.g:1114:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    // InternalTechnologyDsl.g:1115:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0()); 
                    // InternalTechnologyDsl.g:1116:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    // InternalTechnologyDsl.g:1116:4: rule__PrimitiveValue__NumericValueAssignment_0
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
                    // InternalTechnologyDsl.g:1120:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    {
                    // InternalTechnologyDsl.g:1120:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    // InternalTechnologyDsl.g:1121:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1()); 
                    // InternalTechnologyDsl.g:1122:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    // InternalTechnologyDsl.g:1122:4: rule__PrimitiveValue__BooleanValueAssignment_1
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
                    // InternalTechnologyDsl.g:1126:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    {
                    // InternalTechnologyDsl.g:1126:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    // InternalTechnologyDsl.g:1127:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2()); 
                    // InternalTechnologyDsl.g:1128:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    // InternalTechnologyDsl.g:1128:4: rule__PrimitiveValue__StringValueAssignment_2
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
    // InternalTechnologyDsl.g:1136:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1140:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) )
            int alt13=10;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt13=1;
                }
                break;
            case 70:
                {
                alt13=2;
                }
                break;
            case 71:
                {
                alt13=3;
                }
                break;
            case 72:
                {
                alt13=4;
                }
                break;
            case 73:
                {
                alt13=5;
                }
                break;
            case 74:
                {
                alt13=6;
                }
                break;
            case 75:
                {
                alt13=7;
                }
                break;
            case 76:
                {
                alt13=8;
                }
                break;
            case 77:
                {
                alt13=9;
                }
                break;
            case 78:
                {
                alt13=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalTechnologyDsl.g:1141:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:1141:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalTechnologyDsl.g:1142:3: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalTechnologyDsl.g:1143:3: ( rule__PrimitiveType__Group_0__0 )
                    // InternalTechnologyDsl.g:1143:4: rule__PrimitiveType__Group_0__0
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
                    // InternalTechnologyDsl.g:1147:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalTechnologyDsl.g:1147:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalTechnologyDsl.g:1148:3: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalTechnologyDsl.g:1149:3: ( rule__PrimitiveType__Group_1__0 )
                    // InternalTechnologyDsl.g:1149:4: rule__PrimitiveType__Group_1__0
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
                    // InternalTechnologyDsl.g:1153:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalTechnologyDsl.g:1153:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalTechnologyDsl.g:1154:3: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalTechnologyDsl.g:1155:3: ( rule__PrimitiveType__Group_2__0 )
                    // InternalTechnologyDsl.g:1155:4: rule__PrimitiveType__Group_2__0
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
                    // InternalTechnologyDsl.g:1159:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalTechnologyDsl.g:1159:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalTechnologyDsl.g:1160:3: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalTechnologyDsl.g:1161:3: ( rule__PrimitiveType__Group_3__0 )
                    // InternalTechnologyDsl.g:1161:4: rule__PrimitiveType__Group_3__0
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
                    // InternalTechnologyDsl.g:1165:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    {
                    // InternalTechnologyDsl.g:1165:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    // InternalTechnologyDsl.g:1166:3: ( rule__PrimitiveType__Group_4__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 
                    // InternalTechnologyDsl.g:1167:3: ( rule__PrimitiveType__Group_4__0 )
                    // InternalTechnologyDsl.g:1167:4: rule__PrimitiveType__Group_4__0
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
                    // InternalTechnologyDsl.g:1171:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    {
                    // InternalTechnologyDsl.g:1171:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    // InternalTechnologyDsl.g:1172:3: ( rule__PrimitiveType__Group_5__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 
                    // InternalTechnologyDsl.g:1173:3: ( rule__PrimitiveType__Group_5__0 )
                    // InternalTechnologyDsl.g:1173:4: rule__PrimitiveType__Group_5__0
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
                    // InternalTechnologyDsl.g:1177:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    {
                    // InternalTechnologyDsl.g:1177:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    // InternalTechnologyDsl.g:1178:3: ( rule__PrimitiveType__Group_6__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 
                    // InternalTechnologyDsl.g:1179:3: ( rule__PrimitiveType__Group_6__0 )
                    // InternalTechnologyDsl.g:1179:4: rule__PrimitiveType__Group_6__0
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
                    // InternalTechnologyDsl.g:1183:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    {
                    // InternalTechnologyDsl.g:1183:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    // InternalTechnologyDsl.g:1184:3: ( rule__PrimitiveType__Group_7__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 
                    // InternalTechnologyDsl.g:1185:3: ( rule__PrimitiveType__Group_7__0 )
                    // InternalTechnologyDsl.g:1185:4: rule__PrimitiveType__Group_7__0
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
                    // InternalTechnologyDsl.g:1189:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    {
                    // InternalTechnologyDsl.g:1189:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    // InternalTechnologyDsl.g:1190:3: ( rule__PrimitiveType__Group_8__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 
                    // InternalTechnologyDsl.g:1191:3: ( rule__PrimitiveType__Group_8__0 )
                    // InternalTechnologyDsl.g:1191:4: rule__PrimitiveType__Group_8__0
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
                    // InternalTechnologyDsl.g:1195:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    {
                    // InternalTechnologyDsl.g:1195:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    // InternalTechnologyDsl.g:1196:3: ( rule__PrimitiveType__Group_9__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 
                    // InternalTechnologyDsl.g:1197:3: ( rule__PrimitiveType__Group_9__0 )
                    // InternalTechnologyDsl.g:1197:4: rule__PrimitiveType__Group_9__0
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


    // $ANTLR start "rule__ExchangePattern__Alternatives"
    // InternalTechnologyDsl.g:1205:1: rule__ExchangePattern__Alternatives : ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) );
    public final void rule__ExchangePattern__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1209:1: ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt14=1;
                }
                break;
            case 15:
                {
                alt14=2;
                }
                break;
            case 16:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalTechnologyDsl.g:1210:2: ( ( 'in' ) )
                    {
                    // InternalTechnologyDsl.g:1210:2: ( ( 'in' ) )
                    // InternalTechnologyDsl.g:1211:3: ( 'in' )
                    {
                     before(grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1212:3: ( 'in' )
                    // InternalTechnologyDsl.g:1212:4: 'in'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1216:2: ( ( 'out' ) )
                    {
                    // InternalTechnologyDsl.g:1216:2: ( ( 'out' ) )
                    // InternalTechnologyDsl.g:1217:3: ( 'out' )
                    {
                     before(grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1218:3: ( 'out' )
                    // InternalTechnologyDsl.g:1218:4: 'out'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1222:2: ( ( 'inout' ) )
                    {
                    // InternalTechnologyDsl.g:1222:2: ( ( 'inout' ) )
                    // InternalTechnologyDsl.g:1223:3: ( 'inout' )
                    {
                     before(grammarAccess.getExchangePatternAccess().getINOUTEnumLiteralDeclaration_2()); 
                    // InternalTechnologyDsl.g:1224:3: ( 'inout' )
                    // InternalTechnologyDsl.g:1224:4: 'inout'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getExchangePatternAccess().getINOUTEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__ExchangePattern__Alternatives"


    // $ANTLR start "rule__CommunicationType__Alternatives"
    // InternalTechnologyDsl.g:1232:1: rule__CommunicationType__Alternatives : ( ( ( 'sync' ) ) | ( ( 'async' ) ) );
    public final void rule__CommunicationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1236:1: ( ( ( 'sync' ) ) | ( ( 'async' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            else if ( (LA15_0==18) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalTechnologyDsl.g:1237:2: ( ( 'sync' ) )
                    {
                    // InternalTechnologyDsl.g:1237:2: ( ( 'sync' ) )
                    // InternalTechnologyDsl.g:1238:3: ( 'sync' )
                    {
                     before(grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1239:3: ( 'sync' )
                    // InternalTechnologyDsl.g:1239:4: 'sync'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1243:2: ( ( 'async' ) )
                    {
                    // InternalTechnologyDsl.g:1243:2: ( ( 'async' ) )
                    // InternalTechnologyDsl.g:1244:3: ( 'async' )
                    {
                     before(grammarAccess.getCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1245:3: ( 'async' )
                    // InternalTechnologyDsl.g:1245:4: 'async'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__CommunicationType__Alternatives"


    // $ANTLR start "rule__CompatibilityDirection__Alternatives"
    // InternalTechnologyDsl.g:1253:1: rule__CompatibilityDirection__Alternatives : ( ( ( '<-' ) ) | ( ( '->' ) ) | ( ( '<->' ) ) );
    public final void rule__CompatibilityDirection__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1257:1: ( ( ( '<-' ) ) | ( ( '->' ) ) | ( ( '<->' ) ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt16=1;
                }
                break;
            case 20:
                {
                alt16=2;
                }
                break;
            case 21:
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
                    // InternalTechnologyDsl.g:1258:2: ( ( '<-' ) )
                    {
                    // InternalTechnologyDsl.g:1258:2: ( ( '<-' ) )
                    // InternalTechnologyDsl.g:1259:3: ( '<-' )
                    {
                     before(grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1260:3: ( '<-' )
                    // InternalTechnologyDsl.g:1260:4: '<-'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1264:2: ( ( '->' ) )
                    {
                    // InternalTechnologyDsl.g:1264:2: ( ( '->' ) )
                    // InternalTechnologyDsl.g:1265:3: ( '->' )
                    {
                     before(grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1266:3: ( '->' )
                    // InternalTechnologyDsl.g:1266:4: '->'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1270:2: ( ( '<->' ) )
                    {
                    // InternalTechnologyDsl.g:1270:2: ( ( '<->' ) )
                    // InternalTechnologyDsl.g:1271:3: ( '<->' )
                    {
                     before(grammarAccess.getCompatibilityDirectionAccess().getBIDIRECTIONALEnumLiteralDeclaration_2()); 
                    // InternalTechnologyDsl.g:1272:3: ( '<->' )
                    // InternalTechnologyDsl.g:1272:4: '<->'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getCompatibilityDirectionAccess().getBIDIRECTIONALEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__CompatibilityDirection__Alternatives"


    // $ANTLR start "rule__ServiceJoinPointType__Alternatives"
    // InternalTechnologyDsl.g:1280:1: rule__ServiceJoinPointType__Alternatives : ( ( ( 'microservices' ) ) | ( ( 'interfaces' ) ) | ( ( 'operations' ) ) | ( ( 'parameters' ) ) | ( ( 'types' ) ) | ( ( 'fields' ) ) );
    public final void rule__ServiceJoinPointType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1284:1: ( ( ( 'microservices' ) ) | ( ( 'interfaces' ) ) | ( ( 'operations' ) ) | ( ( 'parameters' ) ) | ( ( 'types' ) ) | ( ( 'fields' ) ) )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt17=1;
                }
                break;
            case 23:
                {
                alt17=2;
                }
                break;
            case 24:
                {
                alt17=3;
                }
                break;
            case 25:
                {
                alt17=4;
                }
                break;
            case 26:
                {
                alt17=5;
                }
                break;
            case 27:
                {
                alt17=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalTechnologyDsl.g:1285:2: ( ( 'microservices' ) )
                    {
                    // InternalTechnologyDsl.g:1285:2: ( ( 'microservices' ) )
                    // InternalTechnologyDsl.g:1286:3: ( 'microservices' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1287:3: ( 'microservices' )
                    // InternalTechnologyDsl.g:1287:4: 'microservices'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1291:2: ( ( 'interfaces' ) )
                    {
                    // InternalTechnologyDsl.g:1291:2: ( ( 'interfaces' ) )
                    // InternalTechnologyDsl.g:1292:3: ( 'interfaces' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1293:3: ( 'interfaces' )
                    // InternalTechnologyDsl.g:1293:4: 'interfaces'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1297:2: ( ( 'operations' ) )
                    {
                    // InternalTechnologyDsl.g:1297:2: ( ( 'operations' ) )
                    // InternalTechnologyDsl.g:1298:3: ( 'operations' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2()); 
                    // InternalTechnologyDsl.g:1299:3: ( 'operations' )
                    // InternalTechnologyDsl.g:1299:4: 'operations'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:1303:2: ( ( 'parameters' ) )
                    {
                    // InternalTechnologyDsl.g:1303:2: ( ( 'parameters' ) )
                    // InternalTechnologyDsl.g:1304:3: ( 'parameters' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3()); 
                    // InternalTechnologyDsl.g:1305:3: ( 'parameters' )
                    // InternalTechnologyDsl.g:1305:4: 'parameters'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:1309:2: ( ( 'types' ) )
                    {
                    // InternalTechnologyDsl.g:1309:2: ( ( 'types' ) )
                    // InternalTechnologyDsl.g:1310:3: ( 'types' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4()); 
                    // InternalTechnologyDsl.g:1311:3: ( 'types' )
                    // InternalTechnologyDsl.g:1311:4: 'types'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getCOMPLEX_TYPESEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalTechnologyDsl.g:1315:2: ( ( 'fields' ) )
                    {
                    // InternalTechnologyDsl.g:1315:2: ( ( 'fields' ) )
                    // InternalTechnologyDsl.g:1316:3: ( 'fields' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_5()); 
                    // InternalTechnologyDsl.g:1317:3: ( 'fields' )
                    // InternalTechnologyDsl.g:1317:4: 'fields'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_5()); 

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
    // $ANTLR end "rule__ServiceJoinPointType__Alternatives"


    // $ANTLR start "rule__OperationJoinPointType__Alternatives"
    // InternalTechnologyDsl.g:1325:1: rule__OperationJoinPointType__Alternatives : ( ( ( 'containers' ) ) | ( ( 'infrastructure' ) ) );
    public final void rule__OperationJoinPointType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1329:1: ( ( ( 'containers' ) ) | ( ( 'infrastructure' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            else if ( (LA18_0==29) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalTechnologyDsl.g:1330:2: ( ( 'containers' ) )
                    {
                    // InternalTechnologyDsl.g:1330:2: ( ( 'containers' ) )
                    // InternalTechnologyDsl.g:1331:3: ( 'containers' )
                    {
                     before(grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1332:3: ( 'containers' )
                    // InternalTechnologyDsl.g:1332:4: 'containers'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1336:2: ( ( 'infrastructure' ) )
                    {
                    // InternalTechnologyDsl.g:1336:2: ( ( 'infrastructure' ) )
                    // InternalTechnologyDsl.g:1337:3: ( 'infrastructure' )
                    {
                     before(grammarAccess.getOperationJoinPointTypeAccess().getINFRASTRUCTURE_NODESEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1338:3: ( 'infrastructure' )
                    // InternalTechnologyDsl.g:1338:4: 'infrastructure'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getOperationJoinPointTypeAccess().getINFRASTRUCTURE_NODESEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__OperationJoinPointType__Alternatives"


    // $ANTLR start "rule__Technology__Group__0"
    // InternalTechnologyDsl.g:1346:1: rule__Technology__Group__0 : rule__Technology__Group__0__Impl rule__Technology__Group__1 ;
    public final void rule__Technology__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1350:1: ( rule__Technology__Group__0__Impl rule__Technology__Group__1 )
            // InternalTechnologyDsl.g:1351:2: rule__Technology__Group__0__Impl rule__Technology__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Technology__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__0"


    // $ANTLR start "rule__Technology__Group__0__Impl"
    // InternalTechnologyDsl.g:1358:1: rule__Technology__Group__0__Impl : ( ( rule__Technology__ImportsAssignment_0 )* ) ;
    public final void rule__Technology__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1362:1: ( ( ( rule__Technology__ImportsAssignment_0 )* ) )
            // InternalTechnologyDsl.g:1363:1: ( ( rule__Technology__ImportsAssignment_0 )* )
            {
            // InternalTechnologyDsl.g:1363:1: ( ( rule__Technology__ImportsAssignment_0 )* )
            // InternalTechnologyDsl.g:1364:2: ( rule__Technology__ImportsAssignment_0 )*
            {
             before(grammarAccess.getTechnologyAccess().getImportsAssignment_0()); 
            // InternalTechnologyDsl.g:1365:2: ( rule__Technology__ImportsAssignment_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==41) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1365:3: rule__Technology__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Technology__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__0__Impl"


    // $ANTLR start "rule__Technology__Group__1"
    // InternalTechnologyDsl.g:1373:1: rule__Technology__Group__1 : rule__Technology__Group__1__Impl rule__Technology__Group__2 ;
    public final void rule__Technology__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1377:1: ( rule__Technology__Group__1__Impl rule__Technology__Group__2 )
            // InternalTechnologyDsl.g:1378:2: rule__Technology__Group__1__Impl rule__Technology__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Technology__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__1"


    // $ANTLR start "rule__Technology__Group__1__Impl"
    // InternalTechnologyDsl.g:1385:1: rule__Technology__Group__1__Impl : ( 'technology' ) ;
    public final void rule__Technology__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1389:1: ( ( 'technology' ) )
            // InternalTechnologyDsl.g:1390:1: ( 'technology' )
            {
            // InternalTechnologyDsl.g:1390:1: ( 'technology' )
            // InternalTechnologyDsl.g:1391:2: 'technology'
            {
             before(grammarAccess.getTechnologyAccess().getTechnologyKeyword_1()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getTechnologyKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__1__Impl"


    // $ANTLR start "rule__Technology__Group__2"
    // InternalTechnologyDsl.g:1400:1: rule__Technology__Group__2 : rule__Technology__Group__2__Impl rule__Technology__Group__3 ;
    public final void rule__Technology__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1404:1: ( rule__Technology__Group__2__Impl rule__Technology__Group__3 )
            // InternalTechnologyDsl.g:1405:2: rule__Technology__Group__2__Impl rule__Technology__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__2"


    // $ANTLR start "rule__Technology__Group__2__Impl"
    // InternalTechnologyDsl.g:1412:1: rule__Technology__Group__2__Impl : ( ( rule__Technology__NameAssignment_2 ) ) ;
    public final void rule__Technology__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1416:1: ( ( ( rule__Technology__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:1417:1: ( ( rule__Technology__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:1417:1: ( ( rule__Technology__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:1418:2: ( rule__Technology__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologyAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:1419:2: ( rule__Technology__NameAssignment_2 )
            // InternalTechnologyDsl.g:1419:3: rule__Technology__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Technology__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__2__Impl"


    // $ANTLR start "rule__Technology__Group__3"
    // InternalTechnologyDsl.g:1427:1: rule__Technology__Group__3 : rule__Technology__Group__3__Impl rule__Technology__Group__4 ;
    public final void rule__Technology__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1431:1: ( rule__Technology__Group__3__Impl rule__Technology__Group__4 )
            // InternalTechnologyDsl.g:1432:2: rule__Technology__Group__3__Impl rule__Technology__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__3"


    // $ANTLR start "rule__Technology__Group__3__Impl"
    // InternalTechnologyDsl.g:1439:1: rule__Technology__Group__3__Impl : ( '{' ) ;
    public final void rule__Technology__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1443:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1444:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1444:1: ( '{' )
            // InternalTechnologyDsl.g:1445:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__3__Impl"


    // $ANTLR start "rule__Technology__Group__4"
    // InternalTechnologyDsl.g:1454:1: rule__Technology__Group__4 : rule__Technology__Group__4__Impl rule__Technology__Group__5 ;
    public final void rule__Technology__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1458:1: ( rule__Technology__Group__4__Impl rule__Technology__Group__5 )
            // InternalTechnologyDsl.g:1459:2: rule__Technology__Group__4__Impl rule__Technology__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__4"


    // $ANTLR start "rule__Technology__Group__4__Impl"
    // InternalTechnologyDsl.g:1466:1: rule__Technology__Group__4__Impl : ( ( rule__Technology__Group_4__0 )? ) ;
    public final void rule__Technology__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1470:1: ( ( ( rule__Technology__Group_4__0 )? ) )
            // InternalTechnologyDsl.g:1471:1: ( ( rule__Technology__Group_4__0 )? )
            {
            // InternalTechnologyDsl.g:1471:1: ( ( rule__Technology__Group_4__0 )? )
            // InternalTechnologyDsl.g:1472:2: ( rule__Technology__Group_4__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:1473:2: ( rule__Technology__Group_4__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTechnologyDsl.g:1473:3: rule__Technology__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__4__Impl"


    // $ANTLR start "rule__Technology__Group__5"
    // InternalTechnologyDsl.g:1481:1: rule__Technology__Group__5 : rule__Technology__Group__5__Impl rule__Technology__Group__6 ;
    public final void rule__Technology__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1485:1: ( rule__Technology__Group__5__Impl rule__Technology__Group__6 )
            // InternalTechnologyDsl.g:1486:2: rule__Technology__Group__5__Impl rule__Technology__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__5"


    // $ANTLR start "rule__Technology__Group__5__Impl"
    // InternalTechnologyDsl.g:1493:1: rule__Technology__Group__5__Impl : ( ( rule__Technology__Group_5__0 )? ) ;
    public final void rule__Technology__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1497:1: ( ( ( rule__Technology__Group_5__0 )? ) )
            // InternalTechnologyDsl.g:1498:1: ( ( rule__Technology__Group_5__0 )? )
            {
            // InternalTechnologyDsl.g:1498:1: ( ( rule__Technology__Group_5__0 )? )
            // InternalTechnologyDsl.g:1499:2: ( rule__Technology__Group_5__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_5()); 
            // InternalTechnologyDsl.g:1500:2: ( rule__Technology__Group_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==35) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTechnologyDsl.g:1500:3: rule__Technology__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__5__Impl"


    // $ANTLR start "rule__Technology__Group__6"
    // InternalTechnologyDsl.g:1508:1: rule__Technology__Group__6 : rule__Technology__Group__6__Impl rule__Technology__Group__7 ;
    public final void rule__Technology__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1512:1: ( rule__Technology__Group__6__Impl rule__Technology__Group__7 )
            // InternalTechnologyDsl.g:1513:2: rule__Technology__Group__6__Impl rule__Technology__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__6"


    // $ANTLR start "rule__Technology__Group__6__Impl"
    // InternalTechnologyDsl.g:1520:1: rule__Technology__Group__6__Impl : ( ( rule__Technology__Group_6__0 )? ) ;
    public final void rule__Technology__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1524:1: ( ( ( rule__Technology__Group_6__0 )? ) )
            // InternalTechnologyDsl.g:1525:1: ( ( rule__Technology__Group_6__0 )? )
            {
            // InternalTechnologyDsl.g:1525:1: ( ( rule__Technology__Group_6__0 )? )
            // InternalTechnologyDsl.g:1526:2: ( rule__Technology__Group_6__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:1527:2: ( rule__Technology__Group_6__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTechnologyDsl.g:1527:3: rule__Technology__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__6__Impl"


    // $ANTLR start "rule__Technology__Group__7"
    // InternalTechnologyDsl.g:1535:1: rule__Technology__Group__7 : rule__Technology__Group__7__Impl rule__Technology__Group__8 ;
    public final void rule__Technology__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1539:1: ( rule__Technology__Group__7__Impl rule__Technology__Group__8 )
            // InternalTechnologyDsl.g:1540:2: rule__Technology__Group__7__Impl rule__Technology__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__7"


    // $ANTLR start "rule__Technology__Group__7__Impl"
    // InternalTechnologyDsl.g:1547:1: rule__Technology__Group__7__Impl : ( ( rule__Technology__Group_7__0 )? ) ;
    public final void rule__Technology__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1551:1: ( ( ( rule__Technology__Group_7__0 )? ) )
            // InternalTechnologyDsl.g:1552:1: ( ( rule__Technology__Group_7__0 )? )
            {
            // InternalTechnologyDsl.g:1552:1: ( ( rule__Technology__Group_7__0 )? )
            // InternalTechnologyDsl.g:1553:2: ( rule__Technology__Group_7__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_7()); 
            // InternalTechnologyDsl.g:1554:2: ( rule__Technology__Group_7__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==38) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTechnologyDsl.g:1554:3: rule__Technology__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__7__Impl"


    // $ANTLR start "rule__Technology__Group__8"
    // InternalTechnologyDsl.g:1562:1: rule__Technology__Group__8 : rule__Technology__Group__8__Impl rule__Technology__Group__9 ;
    public final void rule__Technology__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1566:1: ( rule__Technology__Group__8__Impl rule__Technology__Group__9 )
            // InternalTechnologyDsl.g:1567:2: rule__Technology__Group__8__Impl rule__Technology__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__8"


    // $ANTLR start "rule__Technology__Group__8__Impl"
    // InternalTechnologyDsl.g:1574:1: rule__Technology__Group__8__Impl : ( ( rule__Technology__Group_8__0 )? ) ;
    public final void rule__Technology__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1578:1: ( ( ( rule__Technology__Group_8__0 )? ) )
            // InternalTechnologyDsl.g:1579:1: ( ( rule__Technology__Group_8__0 )? )
            {
            // InternalTechnologyDsl.g:1579:1: ( ( rule__Technology__Group_8__0 )? )
            // InternalTechnologyDsl.g:1580:2: ( rule__Technology__Group_8__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_8()); 
            // InternalTechnologyDsl.g:1581:2: ( rule__Technology__Group_8__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTechnologyDsl.g:1581:3: rule__Technology__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__8__Impl"


    // $ANTLR start "rule__Technology__Group__9"
    // InternalTechnologyDsl.g:1589:1: rule__Technology__Group__9 : rule__Technology__Group__9__Impl rule__Technology__Group__10 ;
    public final void rule__Technology__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1593:1: ( rule__Technology__Group__9__Impl rule__Technology__Group__10 )
            // InternalTechnologyDsl.g:1594:2: rule__Technology__Group__9__Impl rule__Technology__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__Technology__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__9"


    // $ANTLR start "rule__Technology__Group__9__Impl"
    // InternalTechnologyDsl.g:1601:1: rule__Technology__Group__9__Impl : ( ( rule__Technology__Group_9__0 )? ) ;
    public final void rule__Technology__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1605:1: ( ( ( rule__Technology__Group_9__0 )? ) )
            // InternalTechnologyDsl.g:1606:1: ( ( rule__Technology__Group_9__0 )? )
            {
            // InternalTechnologyDsl.g:1606:1: ( ( rule__Technology__Group_9__0 )? )
            // InternalTechnologyDsl.g:1607:2: ( rule__Technology__Group_9__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_9()); 
            // InternalTechnologyDsl.g:1608:2: ( rule__Technology__Group_9__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTechnologyDsl.g:1608:3: rule__Technology__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__9__Impl"


    // $ANTLR start "rule__Technology__Group__10"
    // InternalTechnologyDsl.g:1616:1: rule__Technology__Group__10 : rule__Technology__Group__10__Impl ;
    public final void rule__Technology__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1620:1: ( rule__Technology__Group__10__Impl )
            // InternalTechnologyDsl.g:1621:2: rule__Technology__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__10"


    // $ANTLR start "rule__Technology__Group__10__Impl"
    // InternalTechnologyDsl.g:1627:1: rule__Technology__Group__10__Impl : ( '}' ) ;
    public final void rule__Technology__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1631:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1632:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1632:1: ( '}' )
            // InternalTechnologyDsl.g:1633:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_10()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group__10__Impl"


    // $ANTLR start "rule__Technology__Group_4__0"
    // InternalTechnologyDsl.g:1643:1: rule__Technology__Group_4__0 : rule__Technology__Group_4__0__Impl rule__Technology__Group_4__1 ;
    public final void rule__Technology__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1647:1: ( rule__Technology__Group_4__0__Impl rule__Technology__Group_4__1 )
            // InternalTechnologyDsl.g:1648:2: rule__Technology__Group_4__0__Impl rule__Technology__Group_4__1
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__0"


    // $ANTLR start "rule__Technology__Group_4__0__Impl"
    // InternalTechnologyDsl.g:1655:1: rule__Technology__Group_4__0__Impl : ( 'types' ) ;
    public final void rule__Technology__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1659:1: ( ( 'types' ) )
            // InternalTechnologyDsl.g:1660:1: ( 'types' )
            {
            // InternalTechnologyDsl.g:1660:1: ( 'types' )
            // InternalTechnologyDsl.g:1661:2: 'types'
            {
             before(grammarAccess.getTechnologyAccess().getTypesKeyword_4_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getTypesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__0__Impl"


    // $ANTLR start "rule__Technology__Group_4__1"
    // InternalTechnologyDsl.g:1670:1: rule__Technology__Group_4__1 : rule__Technology__Group_4__1__Impl rule__Technology__Group_4__2 ;
    public final void rule__Technology__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1674:1: ( rule__Technology__Group_4__1__Impl rule__Technology__Group_4__2 )
            // InternalTechnologyDsl.g:1675:2: rule__Technology__Group_4__1__Impl rule__Technology__Group_4__2
            {
            pushFollow(FOLLOW_10);
            rule__Technology__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__1"


    // $ANTLR start "rule__Technology__Group_4__1__Impl"
    // InternalTechnologyDsl.g:1682:1: rule__Technology__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Technology__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1686:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1687:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1687:1: ( '{' )
            // InternalTechnologyDsl.g:1688:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__1__Impl"


    // $ANTLR start "rule__Technology__Group_4__2"
    // InternalTechnologyDsl.g:1697:1: rule__Technology__Group_4__2 : rule__Technology__Group_4__2__Impl rule__Technology__Group_4__3 ;
    public final void rule__Technology__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1701:1: ( rule__Technology__Group_4__2__Impl rule__Technology__Group_4__3 )
            // InternalTechnologyDsl.g:1702:2: rule__Technology__Group_4__2__Impl rule__Technology__Group_4__3
            {
            pushFollow(FOLLOW_11);
            rule__Technology__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__2"


    // $ANTLR start "rule__Technology__Group_4__2__Impl"
    // InternalTechnologyDsl.g:1709:1: rule__Technology__Group_4__2__Impl : ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) ) ;
    public final void rule__Technology__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1713:1: ( ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) ) )
            // InternalTechnologyDsl.g:1714:1: ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) )
            {
            // InternalTechnologyDsl.g:1714:1: ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) )
            // InternalTechnologyDsl.g:1715:2: ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* )
            {
            // InternalTechnologyDsl.g:1715:2: ( ( rule__Technology__Alternatives_4_2 ) )
            // InternalTechnologyDsl.g:1716:3: ( rule__Technology__Alternatives_4_2 )
            {
             before(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 
            // InternalTechnologyDsl.g:1717:3: ( rule__Technology__Alternatives_4_2 )
            // InternalTechnologyDsl.g:1717:4: rule__Technology__Alternatives_4_2
            {
            pushFollow(FOLLOW_12);
            rule__Technology__Alternatives_4_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 

            }

            // InternalTechnologyDsl.g:1720:2: ( ( rule__Technology__Alternatives_4_2 )* )
            // InternalTechnologyDsl.g:1721:3: ( rule__Technology__Alternatives_4_2 )*
            {
             before(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 
            // InternalTechnologyDsl.g:1722:3: ( rule__Technology__Alternatives_4_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==49||(LA26_0>=53 && LA26_0<=54)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1722:4: rule__Technology__Alternatives_4_2
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Technology__Alternatives_4_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 

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
    // $ANTLR end "rule__Technology__Group_4__2__Impl"


    // $ANTLR start "rule__Technology__Group_4__3"
    // InternalTechnologyDsl.g:1731:1: rule__Technology__Group_4__3 : rule__Technology__Group_4__3__Impl rule__Technology__Group_4__4 ;
    public final void rule__Technology__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1735:1: ( rule__Technology__Group_4__3__Impl rule__Technology__Group_4__4 )
            // InternalTechnologyDsl.g:1736:2: rule__Technology__Group_4__3__Impl rule__Technology__Group_4__4
            {
            pushFollow(FOLLOW_11);
            rule__Technology__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__3"


    // $ANTLR start "rule__Technology__Group_4__3__Impl"
    // InternalTechnologyDsl.g:1743:1: rule__Technology__Group_4__3__Impl : ( ( rule__Technology__Group_4_3__0 )? ) ;
    public final void rule__Technology__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1747:1: ( ( ( rule__Technology__Group_4_3__0 )? ) )
            // InternalTechnologyDsl.g:1748:1: ( ( rule__Technology__Group_4_3__0 )? )
            {
            // InternalTechnologyDsl.g:1748:1: ( ( rule__Technology__Group_4_3__0 )? )
            // InternalTechnologyDsl.g:1749:2: ( rule__Technology__Group_4_3__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_4_3()); 
            // InternalTechnologyDsl.g:1750:2: ( rule__Technology__Group_4_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTechnologyDsl.g:1750:3: rule__Technology__Group_4_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Technology__Group_4_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologyAccess().getGroup_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__3__Impl"


    // $ANTLR start "rule__Technology__Group_4__4"
    // InternalTechnologyDsl.g:1758:1: rule__Technology__Group_4__4 : rule__Technology__Group_4__4__Impl ;
    public final void rule__Technology__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1762:1: ( rule__Technology__Group_4__4__Impl )
            // InternalTechnologyDsl.g:1763:2: rule__Technology__Group_4__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_4__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__4"


    // $ANTLR start "rule__Technology__Group_4__4__Impl"
    // InternalTechnologyDsl.g:1769:1: rule__Technology__Group_4__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1773:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1774:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1774:1: ( '}' )
            // InternalTechnologyDsl.g:1775:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4__4__Impl"


    // $ANTLR start "rule__Technology__Group_4_3__0"
    // InternalTechnologyDsl.g:1785:1: rule__Technology__Group_4_3__0 : rule__Technology__Group_4_3__0__Impl rule__Technology__Group_4_3__1 ;
    public final void rule__Technology__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1789:1: ( rule__Technology__Group_4_3__0__Impl rule__Technology__Group_4_3__1 )
            // InternalTechnologyDsl.g:1790:2: rule__Technology__Group_4_3__0__Impl rule__Technology__Group_4_3__1
            {
            pushFollow(FOLLOW_13);
            rule__Technology__Group_4_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__0"


    // $ANTLR start "rule__Technology__Group_4_3__0__Impl"
    // InternalTechnologyDsl.g:1797:1: rule__Technology__Group_4_3__0__Impl : ( 'compatibility' ) ;
    public final void rule__Technology__Group_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1801:1: ( ( 'compatibility' ) )
            // InternalTechnologyDsl.g:1802:1: ( 'compatibility' )
            {
            // InternalTechnologyDsl.g:1802:1: ( 'compatibility' )
            // InternalTechnologyDsl.g:1803:2: 'compatibility'
            {
             before(grammarAccess.getTechnologyAccess().getCompatibilityKeyword_4_3_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getCompatibilityKeyword_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__0__Impl"


    // $ANTLR start "rule__Technology__Group_4_3__1"
    // InternalTechnologyDsl.g:1812:1: rule__Technology__Group_4_3__1 : rule__Technology__Group_4_3__1__Impl rule__Technology__Group_4_3__2 ;
    public final void rule__Technology__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1816:1: ( rule__Technology__Group_4_3__1__Impl rule__Technology__Group_4_3__2 )
            // InternalTechnologyDsl.g:1817:2: rule__Technology__Group_4_3__1__Impl rule__Technology__Group_4_3__2
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_4_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__1"


    // $ANTLR start "rule__Technology__Group_4_3__1__Impl"
    // InternalTechnologyDsl.g:1824:1: rule__Technology__Group_4_3__1__Impl : ( 'matrix' ) ;
    public final void rule__Technology__Group_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1828:1: ( ( 'matrix' ) )
            // InternalTechnologyDsl.g:1829:1: ( 'matrix' )
            {
            // InternalTechnologyDsl.g:1829:1: ( 'matrix' )
            // InternalTechnologyDsl.g:1830:2: 'matrix'
            {
             before(grammarAccess.getTechnologyAccess().getMatrixKeyword_4_3_1()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getMatrixKeyword_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__1__Impl"


    // $ANTLR start "rule__Technology__Group_4_3__2"
    // InternalTechnologyDsl.g:1839:1: rule__Technology__Group_4_3__2 : rule__Technology__Group_4_3__2__Impl rule__Technology__Group_4_3__3 ;
    public final void rule__Technology__Group_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1843:1: ( rule__Technology__Group_4_3__2__Impl rule__Technology__Group_4_3__3 )
            // InternalTechnologyDsl.g:1844:2: rule__Technology__Group_4_3__2__Impl rule__Technology__Group_4_3__3
            {
            pushFollow(FOLLOW_7);
            rule__Technology__Group_4_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__2"


    // $ANTLR start "rule__Technology__Group_4_3__2__Impl"
    // InternalTechnologyDsl.g:1851:1: rule__Technology__Group_4_3__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1855:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1856:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1856:1: ( '{' )
            // InternalTechnologyDsl.g:1857:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_3_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__2__Impl"


    // $ANTLR start "rule__Technology__Group_4_3__3"
    // InternalTechnologyDsl.g:1866:1: rule__Technology__Group_4_3__3 : rule__Technology__Group_4_3__3__Impl rule__Technology__Group_4_3__4 ;
    public final void rule__Technology__Group_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1870:1: ( rule__Technology__Group_4_3__3__Impl rule__Technology__Group_4_3__4 )
            // InternalTechnologyDsl.g:1871:2: rule__Technology__Group_4_3__3__Impl rule__Technology__Group_4_3__4
            {
            pushFollow(FOLLOW_14);
            rule__Technology__Group_4_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_4_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__3"


    // $ANTLR start "rule__Technology__Group_4_3__3__Impl"
    // InternalTechnologyDsl.g:1878:1: rule__Technology__Group_4_3__3__Impl : ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) ) ;
    public final void rule__Technology__Group_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1882:1: ( ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) ) )
            // InternalTechnologyDsl.g:1883:1: ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) )
            {
            // InternalTechnologyDsl.g:1883:1: ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) )
            // InternalTechnologyDsl.g:1884:2: ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* )
            {
            // InternalTechnologyDsl.g:1884:2: ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) )
            // InternalTechnologyDsl.g:1885:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )
            {
             before(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 
            // InternalTechnologyDsl.g:1886:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )
            // InternalTechnologyDsl.g:1886:4: rule__Technology__CompatibilityEntriesAssignment_4_3_3
            {
            pushFollow(FOLLOW_15);
            rule__Technology__CompatibilityEntriesAssignment_4_3_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 

            }

            // InternalTechnologyDsl.g:1889:2: ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* )
            // InternalTechnologyDsl.g:1890:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 
            // InternalTechnologyDsl.g:1891:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1891:4: rule__Technology__CompatibilityEntriesAssignment_4_3_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Technology__CompatibilityEntriesAssignment_4_3_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 

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
    // $ANTLR end "rule__Technology__Group_4_3__3__Impl"


    // $ANTLR start "rule__Technology__Group_4_3__4"
    // InternalTechnologyDsl.g:1900:1: rule__Technology__Group_4_3__4 : rule__Technology__Group_4_3__4__Impl ;
    public final void rule__Technology__Group_4_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1904:1: ( rule__Technology__Group_4_3__4__Impl )
            // InternalTechnologyDsl.g:1905:2: rule__Technology__Group_4_3__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_4_3__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__4"


    // $ANTLR start "rule__Technology__Group_4_3__4__Impl"
    // InternalTechnologyDsl.g:1911:1: rule__Technology__Group_4_3__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_4_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1915:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1916:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1916:1: ( '}' )
            // InternalTechnologyDsl.g:1917:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_3_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_4_3__4__Impl"


    // $ANTLR start "rule__Technology__Group_5__0"
    // InternalTechnologyDsl.g:1927:1: rule__Technology__Group_5__0 : rule__Technology__Group_5__0__Impl rule__Technology__Group_5__1 ;
    public final void rule__Technology__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1931:1: ( rule__Technology__Group_5__0__Impl rule__Technology__Group_5__1 )
            // InternalTechnologyDsl.g:1932:2: rule__Technology__Group_5__0__Impl rule__Technology__Group_5__1
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__0"


    // $ANTLR start "rule__Technology__Group_5__0__Impl"
    // InternalTechnologyDsl.g:1939:1: rule__Technology__Group_5__0__Impl : ( 'protocols' ) ;
    public final void rule__Technology__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1943:1: ( ( 'protocols' ) )
            // InternalTechnologyDsl.g:1944:1: ( 'protocols' )
            {
            // InternalTechnologyDsl.g:1944:1: ( 'protocols' )
            // InternalTechnologyDsl.g:1945:2: 'protocols'
            {
             before(grammarAccess.getTechnologyAccess().getProtocolsKeyword_5_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getProtocolsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__0__Impl"


    // $ANTLR start "rule__Technology__Group_5__1"
    // InternalTechnologyDsl.g:1954:1: rule__Technology__Group_5__1 : rule__Technology__Group_5__1__Impl rule__Technology__Group_5__2 ;
    public final void rule__Technology__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1958:1: ( rule__Technology__Group_5__1__Impl rule__Technology__Group_5__2 )
            // InternalTechnologyDsl.g:1959:2: rule__Technology__Group_5__1__Impl rule__Technology__Group_5__2
            {
            pushFollow(FOLLOW_16);
            rule__Technology__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__1"


    // $ANTLR start "rule__Technology__Group_5__1__Impl"
    // InternalTechnologyDsl.g:1966:1: rule__Technology__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Technology__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1970:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1971:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1971:1: ( '{' )
            // InternalTechnologyDsl.g:1972:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_5_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__1__Impl"


    // $ANTLR start "rule__Technology__Group_5__2"
    // InternalTechnologyDsl.g:1981:1: rule__Technology__Group_5__2 : rule__Technology__Group_5__2__Impl rule__Technology__Group_5__3 ;
    public final void rule__Technology__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1985:1: ( rule__Technology__Group_5__2__Impl rule__Technology__Group_5__3 )
            // InternalTechnologyDsl.g:1986:2: rule__Technology__Group_5__2__Impl rule__Technology__Group_5__3
            {
            pushFollow(FOLLOW_14);
            rule__Technology__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__2"


    // $ANTLR start "rule__Technology__Group_5__2__Impl"
    // InternalTechnologyDsl.g:1993:1: rule__Technology__Group_5__2__Impl : ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) ) ;
    public final void rule__Technology__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1997:1: ( ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) ) )
            // InternalTechnologyDsl.g:1998:1: ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) )
            {
            // InternalTechnologyDsl.g:1998:1: ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) )
            // InternalTechnologyDsl.g:1999:2: ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* )
            {
            // InternalTechnologyDsl.g:1999:2: ( ( rule__Technology__ProtocolsAssignment_5_2 ) )
            // InternalTechnologyDsl.g:2000:3: ( rule__Technology__ProtocolsAssignment_5_2 )
            {
             before(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 
            // InternalTechnologyDsl.g:2001:3: ( rule__Technology__ProtocolsAssignment_5_2 )
            // InternalTechnologyDsl.g:2001:4: rule__Technology__ProtocolsAssignment_5_2
            {
            pushFollow(FOLLOW_17);
            rule__Technology__ProtocolsAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 

            }

            // InternalTechnologyDsl.g:2004:2: ( ( rule__Technology__ProtocolsAssignment_5_2 )* )
            // InternalTechnologyDsl.g:2005:3: ( rule__Technology__ProtocolsAssignment_5_2 )*
            {
             before(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 
            // InternalTechnologyDsl.g:2006:3: ( rule__Technology__ProtocolsAssignment_5_2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=17 && LA29_0<=18)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2006:4: rule__Technology__ProtocolsAssignment_5_2
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Technology__ProtocolsAssignment_5_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 

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
    // $ANTLR end "rule__Technology__Group_5__2__Impl"


    // $ANTLR start "rule__Technology__Group_5__3"
    // InternalTechnologyDsl.g:2015:1: rule__Technology__Group_5__3 : rule__Technology__Group_5__3__Impl ;
    public final void rule__Technology__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2019:1: ( rule__Technology__Group_5__3__Impl )
            // InternalTechnologyDsl.g:2020:2: rule__Technology__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__3"


    // $ANTLR start "rule__Technology__Group_5__3__Impl"
    // InternalTechnologyDsl.g:2026:1: rule__Technology__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Technology__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2030:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2031:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2031:1: ( '}' )
            // InternalTechnologyDsl.g:2032:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_5_3()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_5__3__Impl"


    // $ANTLR start "rule__Technology__Group_6__0"
    // InternalTechnologyDsl.g:2042:1: rule__Technology__Group_6__0 : rule__Technology__Group_6__0__Impl rule__Technology__Group_6__1 ;
    public final void rule__Technology__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2046:1: ( rule__Technology__Group_6__0__Impl rule__Technology__Group_6__1 )
            // InternalTechnologyDsl.g:2047:2: rule__Technology__Group_6__0__Impl rule__Technology__Group_6__1
            {
            pushFollow(FOLLOW_18);
            rule__Technology__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__0"


    // $ANTLR start "rule__Technology__Group_6__0__Impl"
    // InternalTechnologyDsl.g:2054:1: rule__Technology__Group_6__0__Impl : ( 'service' ) ;
    public final void rule__Technology__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2058:1: ( ( 'service' ) )
            // InternalTechnologyDsl.g:2059:1: ( 'service' )
            {
            // InternalTechnologyDsl.g:2059:1: ( 'service' )
            // InternalTechnologyDsl.g:2060:2: 'service'
            {
             before(grammarAccess.getTechnologyAccess().getServiceKeyword_6_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getServiceKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__0__Impl"


    // $ANTLR start "rule__Technology__Group_6__1"
    // InternalTechnologyDsl.g:2069:1: rule__Technology__Group_6__1 : rule__Technology__Group_6__1__Impl rule__Technology__Group_6__2 ;
    public final void rule__Technology__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2073:1: ( rule__Technology__Group_6__1__Impl rule__Technology__Group_6__2 )
            // InternalTechnologyDsl.g:2074:2: rule__Technology__Group_6__1__Impl rule__Technology__Group_6__2
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__1"


    // $ANTLR start "rule__Technology__Group_6__1__Impl"
    // InternalTechnologyDsl.g:2081:1: rule__Technology__Group_6__1__Impl : ( 'aspects' ) ;
    public final void rule__Technology__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2085:1: ( ( 'aspects' ) )
            // InternalTechnologyDsl.g:2086:1: ( 'aspects' )
            {
            // InternalTechnologyDsl.g:2086:1: ( 'aspects' )
            // InternalTechnologyDsl.g:2087:2: 'aspects'
            {
             before(grammarAccess.getTechnologyAccess().getAspectsKeyword_6_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getAspectsKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__1__Impl"


    // $ANTLR start "rule__Technology__Group_6__2"
    // InternalTechnologyDsl.g:2096:1: rule__Technology__Group_6__2 : rule__Technology__Group_6__2__Impl rule__Technology__Group_6__3 ;
    public final void rule__Technology__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2100:1: ( rule__Technology__Group_6__2__Impl rule__Technology__Group_6__3 )
            // InternalTechnologyDsl.g:2101:2: rule__Technology__Group_6__2__Impl rule__Technology__Group_6__3
            {
            pushFollow(FOLLOW_19);
            rule__Technology__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__2"


    // $ANTLR start "rule__Technology__Group_6__2__Impl"
    // InternalTechnologyDsl.g:2108:1: rule__Technology__Group_6__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2112:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2113:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2113:1: ( '{' )
            // InternalTechnologyDsl.g:2114:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_6_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__2__Impl"


    // $ANTLR start "rule__Technology__Group_6__3"
    // InternalTechnologyDsl.g:2123:1: rule__Technology__Group_6__3 : rule__Technology__Group_6__3__Impl rule__Technology__Group_6__4 ;
    public final void rule__Technology__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2127:1: ( rule__Technology__Group_6__3__Impl rule__Technology__Group_6__4 )
            // InternalTechnologyDsl.g:2128:2: rule__Technology__Group_6__3__Impl rule__Technology__Group_6__4
            {
            pushFollow(FOLLOW_14);
            rule__Technology__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__3"


    // $ANTLR start "rule__Technology__Group_6__3__Impl"
    // InternalTechnologyDsl.g:2135:1: rule__Technology__Group_6__3__Impl : ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) ) ;
    public final void rule__Technology__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2139:1: ( ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) ) )
            // InternalTechnologyDsl.g:2140:1: ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) )
            {
            // InternalTechnologyDsl.g:2140:1: ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) )
            // InternalTechnologyDsl.g:2141:2: ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* )
            {
            // InternalTechnologyDsl.g:2141:2: ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) )
            // InternalTechnologyDsl.g:2142:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )
            {
             before(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 
            // InternalTechnologyDsl.g:2143:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )
            // InternalTechnologyDsl.g:2143:4: rule__Technology__ServiceAspectsAssignment_6_3
            {
            pushFollow(FOLLOW_20);
            rule__Technology__ServiceAspectsAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 

            }

            // InternalTechnologyDsl.g:2146:2: ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* )
            // InternalTechnologyDsl.g:2147:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 
            // InternalTechnologyDsl.g:2148:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==62) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2148:4: rule__Technology__ServiceAspectsAssignment_6_3
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Technology__ServiceAspectsAssignment_6_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 

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
    // $ANTLR end "rule__Technology__Group_6__3__Impl"


    // $ANTLR start "rule__Technology__Group_6__4"
    // InternalTechnologyDsl.g:2157:1: rule__Technology__Group_6__4 : rule__Technology__Group_6__4__Impl ;
    public final void rule__Technology__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2161:1: ( rule__Technology__Group_6__4__Impl )
            // InternalTechnologyDsl.g:2162:2: rule__Technology__Group_6__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_6__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__4"


    // $ANTLR start "rule__Technology__Group_6__4__Impl"
    // InternalTechnologyDsl.g:2168:1: rule__Technology__Group_6__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2172:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2173:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2173:1: ( '}' )
            // InternalTechnologyDsl.g:2174:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_6_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_6__4__Impl"


    // $ANTLR start "rule__Technology__Group_7__0"
    // InternalTechnologyDsl.g:2184:1: rule__Technology__Group_7__0 : rule__Technology__Group_7__0__Impl rule__Technology__Group_7__1 ;
    public final void rule__Technology__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2188:1: ( rule__Technology__Group_7__0__Impl rule__Technology__Group_7__1 )
            // InternalTechnologyDsl.g:2189:2: rule__Technology__Group_7__0__Impl rule__Technology__Group_7__1
            {
            pushFollow(FOLLOW_21);
            rule__Technology__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__0"


    // $ANTLR start "rule__Technology__Group_7__0__Impl"
    // InternalTechnologyDsl.g:2196:1: rule__Technology__Group_7__0__Impl : ( 'deployment' ) ;
    public final void rule__Technology__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2200:1: ( ( 'deployment' ) )
            // InternalTechnologyDsl.g:2201:1: ( 'deployment' )
            {
            // InternalTechnologyDsl.g:2201:1: ( 'deployment' )
            // InternalTechnologyDsl.g:2202:2: 'deployment'
            {
             before(grammarAccess.getTechnologyAccess().getDeploymentKeyword_7_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getDeploymentKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__0__Impl"


    // $ANTLR start "rule__Technology__Group_7__1"
    // InternalTechnologyDsl.g:2211:1: rule__Technology__Group_7__1 : rule__Technology__Group_7__1__Impl rule__Technology__Group_7__2 ;
    public final void rule__Technology__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2215:1: ( rule__Technology__Group_7__1__Impl rule__Technology__Group_7__2 )
            // InternalTechnologyDsl.g:2216:2: rule__Technology__Group_7__1__Impl rule__Technology__Group_7__2
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__1"


    // $ANTLR start "rule__Technology__Group_7__1__Impl"
    // InternalTechnologyDsl.g:2223:1: rule__Technology__Group_7__1__Impl : ( 'technologies' ) ;
    public final void rule__Technology__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2227:1: ( ( 'technologies' ) )
            // InternalTechnologyDsl.g:2228:1: ( 'technologies' )
            {
            // InternalTechnologyDsl.g:2228:1: ( 'technologies' )
            // InternalTechnologyDsl.g:2229:2: 'technologies'
            {
             before(grammarAccess.getTechnologyAccess().getTechnologiesKeyword_7_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getTechnologiesKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__1__Impl"


    // $ANTLR start "rule__Technology__Group_7__2"
    // InternalTechnologyDsl.g:2238:1: rule__Technology__Group_7__2 : rule__Technology__Group_7__2__Impl rule__Technology__Group_7__3 ;
    public final void rule__Technology__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2242:1: ( rule__Technology__Group_7__2__Impl rule__Technology__Group_7__3 )
            // InternalTechnologyDsl.g:2243:2: rule__Technology__Group_7__2__Impl rule__Technology__Group_7__3
            {
            pushFollow(FOLLOW_7);
            rule__Technology__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__2"


    // $ANTLR start "rule__Technology__Group_7__2__Impl"
    // InternalTechnologyDsl.g:2250:1: rule__Technology__Group_7__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2254:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2255:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2255:1: ( '{' )
            // InternalTechnologyDsl.g:2256:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_7_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__2__Impl"


    // $ANTLR start "rule__Technology__Group_7__3"
    // InternalTechnologyDsl.g:2265:1: rule__Technology__Group_7__3 : rule__Technology__Group_7__3__Impl rule__Technology__Group_7__4 ;
    public final void rule__Technology__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2269:1: ( rule__Technology__Group_7__3__Impl rule__Technology__Group_7__4 )
            // InternalTechnologyDsl.g:2270:2: rule__Technology__Group_7__3__Impl rule__Technology__Group_7__4
            {
            pushFollow(FOLLOW_14);
            rule__Technology__Group_7__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_7__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__3"


    // $ANTLR start "rule__Technology__Group_7__3__Impl"
    // InternalTechnologyDsl.g:2277:1: rule__Technology__Group_7__3__Impl : ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) ) ;
    public final void rule__Technology__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2281:1: ( ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) ) )
            // InternalTechnologyDsl.g:2282:1: ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) )
            {
            // InternalTechnologyDsl.g:2282:1: ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) )
            // InternalTechnologyDsl.g:2283:2: ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* )
            {
            // InternalTechnologyDsl.g:2283:2: ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) )
            // InternalTechnologyDsl.g:2284:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )
            {
             before(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 
            // InternalTechnologyDsl.g:2285:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )
            // InternalTechnologyDsl.g:2285:4: rule__Technology__DeploymentTechnologiesAssignment_7_3
            {
            pushFollow(FOLLOW_15);
            rule__Technology__DeploymentTechnologiesAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 

            }

            // InternalTechnologyDsl.g:2288:2: ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* )
            // InternalTechnologyDsl.g:2289:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 
            // InternalTechnologyDsl.g:2290:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2290:4: rule__Technology__DeploymentTechnologiesAssignment_7_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Technology__DeploymentTechnologiesAssignment_7_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 

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
    // $ANTLR end "rule__Technology__Group_7__3__Impl"


    // $ANTLR start "rule__Technology__Group_7__4"
    // InternalTechnologyDsl.g:2299:1: rule__Technology__Group_7__4 : rule__Technology__Group_7__4__Impl ;
    public final void rule__Technology__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2303:1: ( rule__Technology__Group_7__4__Impl )
            // InternalTechnologyDsl.g:2304:2: rule__Technology__Group_7__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_7__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__4"


    // $ANTLR start "rule__Technology__Group_7__4__Impl"
    // InternalTechnologyDsl.g:2310:1: rule__Technology__Group_7__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2314:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2315:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2315:1: ( '}' )
            // InternalTechnologyDsl.g:2316:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_7_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_7_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_7__4__Impl"


    // $ANTLR start "rule__Technology__Group_8__0"
    // InternalTechnologyDsl.g:2326:1: rule__Technology__Group_8__0 : rule__Technology__Group_8__0__Impl rule__Technology__Group_8__1 ;
    public final void rule__Technology__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2330:1: ( rule__Technology__Group_8__0__Impl rule__Technology__Group_8__1 )
            // InternalTechnologyDsl.g:2331:2: rule__Technology__Group_8__0__Impl rule__Technology__Group_8__1
            {
            pushFollow(FOLLOW_21);
            rule__Technology__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__0"


    // $ANTLR start "rule__Technology__Group_8__0__Impl"
    // InternalTechnologyDsl.g:2338:1: rule__Technology__Group_8__0__Impl : ( 'infrastructure' ) ;
    public final void rule__Technology__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2342:1: ( ( 'infrastructure' ) )
            // InternalTechnologyDsl.g:2343:1: ( 'infrastructure' )
            {
            // InternalTechnologyDsl.g:2343:1: ( 'infrastructure' )
            // InternalTechnologyDsl.g:2344:2: 'infrastructure'
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureKeyword_8_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getInfrastructureKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__0__Impl"


    // $ANTLR start "rule__Technology__Group_8__1"
    // InternalTechnologyDsl.g:2353:1: rule__Technology__Group_8__1 : rule__Technology__Group_8__1__Impl rule__Technology__Group_8__2 ;
    public final void rule__Technology__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2357:1: ( rule__Technology__Group_8__1__Impl rule__Technology__Group_8__2 )
            // InternalTechnologyDsl.g:2358:2: rule__Technology__Group_8__1__Impl rule__Technology__Group_8__2
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__1"


    // $ANTLR start "rule__Technology__Group_8__1__Impl"
    // InternalTechnologyDsl.g:2365:1: rule__Technology__Group_8__1__Impl : ( 'technologies' ) ;
    public final void rule__Technology__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2369:1: ( ( 'technologies' ) )
            // InternalTechnologyDsl.g:2370:1: ( 'technologies' )
            {
            // InternalTechnologyDsl.g:2370:1: ( 'technologies' )
            // InternalTechnologyDsl.g:2371:2: 'technologies'
            {
             before(grammarAccess.getTechnologyAccess().getTechnologiesKeyword_8_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getTechnologiesKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__1__Impl"


    // $ANTLR start "rule__Technology__Group_8__2"
    // InternalTechnologyDsl.g:2380:1: rule__Technology__Group_8__2 : rule__Technology__Group_8__2__Impl rule__Technology__Group_8__3 ;
    public final void rule__Technology__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2384:1: ( rule__Technology__Group_8__2__Impl rule__Technology__Group_8__3 )
            // InternalTechnologyDsl.g:2385:2: rule__Technology__Group_8__2__Impl rule__Technology__Group_8__3
            {
            pushFollow(FOLLOW_7);
            rule__Technology__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__2"


    // $ANTLR start "rule__Technology__Group_8__2__Impl"
    // InternalTechnologyDsl.g:2392:1: rule__Technology__Group_8__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2396:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2397:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2397:1: ( '{' )
            // InternalTechnologyDsl.g:2398:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__2__Impl"


    // $ANTLR start "rule__Technology__Group_8__3"
    // InternalTechnologyDsl.g:2407:1: rule__Technology__Group_8__3 : rule__Technology__Group_8__3__Impl rule__Technology__Group_8__4 ;
    public final void rule__Technology__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2411:1: ( rule__Technology__Group_8__3__Impl rule__Technology__Group_8__4 )
            // InternalTechnologyDsl.g:2412:2: rule__Technology__Group_8__3__Impl rule__Technology__Group_8__4
            {
            pushFollow(FOLLOW_14);
            rule__Technology__Group_8__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_8__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__3"


    // $ANTLR start "rule__Technology__Group_8__3__Impl"
    // InternalTechnologyDsl.g:2419:1: rule__Technology__Group_8__3__Impl : ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) ) ;
    public final void rule__Technology__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2423:1: ( ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) ) )
            // InternalTechnologyDsl.g:2424:1: ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) )
            {
            // InternalTechnologyDsl.g:2424:1: ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) )
            // InternalTechnologyDsl.g:2425:2: ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* )
            {
            // InternalTechnologyDsl.g:2425:2: ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) )
            // InternalTechnologyDsl.g:2426:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:2427:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )
            // InternalTechnologyDsl.g:2427:4: rule__Technology__InfrastructureTechnologiesAssignment_8_3
            {
            pushFollow(FOLLOW_15);
            rule__Technology__InfrastructureTechnologiesAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 

            }

            // InternalTechnologyDsl.g:2430:2: ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* )
            // InternalTechnologyDsl.g:2431:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:2432:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2432:4: rule__Technology__InfrastructureTechnologiesAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Technology__InfrastructureTechnologiesAssignment_8_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 

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
    // $ANTLR end "rule__Technology__Group_8__3__Impl"


    // $ANTLR start "rule__Technology__Group_8__4"
    // InternalTechnologyDsl.g:2441:1: rule__Technology__Group_8__4 : rule__Technology__Group_8__4__Impl ;
    public final void rule__Technology__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2445:1: ( rule__Technology__Group_8__4__Impl )
            // InternalTechnologyDsl.g:2446:2: rule__Technology__Group_8__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_8__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__4"


    // $ANTLR start "rule__Technology__Group_8__4__Impl"
    // InternalTechnologyDsl.g:2452:1: rule__Technology__Group_8__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2456:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2457:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2457:1: ( '}' )
            // InternalTechnologyDsl.g:2458:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_8__4__Impl"


    // $ANTLR start "rule__Technology__Group_9__0"
    // InternalTechnologyDsl.g:2468:1: rule__Technology__Group_9__0 : rule__Technology__Group_9__0__Impl rule__Technology__Group_9__1 ;
    public final void rule__Technology__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2472:1: ( rule__Technology__Group_9__0__Impl rule__Technology__Group_9__1 )
            // InternalTechnologyDsl.g:2473:2: rule__Technology__Group_9__0__Impl rule__Technology__Group_9__1
            {
            pushFollow(FOLLOW_18);
            rule__Technology__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__0"


    // $ANTLR start "rule__Technology__Group_9__0__Impl"
    // InternalTechnologyDsl.g:2480:1: rule__Technology__Group_9__0__Impl : ( 'operation' ) ;
    public final void rule__Technology__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2484:1: ( ( 'operation' ) )
            // InternalTechnologyDsl.g:2485:1: ( 'operation' )
            {
            // InternalTechnologyDsl.g:2485:1: ( 'operation' )
            // InternalTechnologyDsl.g:2486:2: 'operation'
            {
             before(grammarAccess.getTechnologyAccess().getOperationKeyword_9_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getOperationKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__0__Impl"


    // $ANTLR start "rule__Technology__Group_9__1"
    // InternalTechnologyDsl.g:2495:1: rule__Technology__Group_9__1 : rule__Technology__Group_9__1__Impl rule__Technology__Group_9__2 ;
    public final void rule__Technology__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2499:1: ( rule__Technology__Group_9__1__Impl rule__Technology__Group_9__2 )
            // InternalTechnologyDsl.g:2500:2: rule__Technology__Group_9__1__Impl rule__Technology__Group_9__2
            {
            pushFollow(FOLLOW_8);
            rule__Technology__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__1"


    // $ANTLR start "rule__Technology__Group_9__1__Impl"
    // InternalTechnologyDsl.g:2507:1: rule__Technology__Group_9__1__Impl : ( 'aspects' ) ;
    public final void rule__Technology__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2511:1: ( ( 'aspects' ) )
            // InternalTechnologyDsl.g:2512:1: ( 'aspects' )
            {
            // InternalTechnologyDsl.g:2512:1: ( 'aspects' )
            // InternalTechnologyDsl.g:2513:2: 'aspects'
            {
             before(grammarAccess.getTechnologyAccess().getAspectsKeyword_9_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getAspectsKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__1__Impl"


    // $ANTLR start "rule__Technology__Group_9__2"
    // InternalTechnologyDsl.g:2522:1: rule__Technology__Group_9__2 : rule__Technology__Group_9__2__Impl rule__Technology__Group_9__3 ;
    public final void rule__Technology__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2526:1: ( rule__Technology__Group_9__2__Impl rule__Technology__Group_9__3 )
            // InternalTechnologyDsl.g:2527:2: rule__Technology__Group_9__2__Impl rule__Technology__Group_9__3
            {
            pushFollow(FOLLOW_19);
            rule__Technology__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__2"


    // $ANTLR start "rule__Technology__Group_9__2__Impl"
    // InternalTechnologyDsl.g:2534:1: rule__Technology__Group_9__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2538:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2539:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2539:1: ( '{' )
            // InternalTechnologyDsl.g:2540:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_9_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__2__Impl"


    // $ANTLR start "rule__Technology__Group_9__3"
    // InternalTechnologyDsl.g:2549:1: rule__Technology__Group_9__3 : rule__Technology__Group_9__3__Impl rule__Technology__Group_9__4 ;
    public final void rule__Technology__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2553:1: ( rule__Technology__Group_9__3__Impl rule__Technology__Group_9__4 )
            // InternalTechnologyDsl.g:2554:2: rule__Technology__Group_9__3__Impl rule__Technology__Group_9__4
            {
            pushFollow(FOLLOW_14);
            rule__Technology__Group_9__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Technology__Group_9__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__3"


    // $ANTLR start "rule__Technology__Group_9__3__Impl"
    // InternalTechnologyDsl.g:2561:1: rule__Technology__Group_9__3__Impl : ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) ) ;
    public final void rule__Technology__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2565:1: ( ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) ) )
            // InternalTechnologyDsl.g:2566:1: ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) )
            {
            // InternalTechnologyDsl.g:2566:1: ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) )
            // InternalTechnologyDsl.g:2567:2: ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* )
            {
            // InternalTechnologyDsl.g:2567:2: ( ( rule__Technology__OperationAspectsAssignment_9_3 ) )
            // InternalTechnologyDsl.g:2568:3: ( rule__Technology__OperationAspectsAssignment_9_3 )
            {
             before(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 
            // InternalTechnologyDsl.g:2569:3: ( rule__Technology__OperationAspectsAssignment_9_3 )
            // InternalTechnologyDsl.g:2569:4: rule__Technology__OperationAspectsAssignment_9_3
            {
            pushFollow(FOLLOW_20);
            rule__Technology__OperationAspectsAssignment_9_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 

            }

            // InternalTechnologyDsl.g:2572:2: ( ( rule__Technology__OperationAspectsAssignment_9_3 )* )
            // InternalTechnologyDsl.g:2573:3: ( rule__Technology__OperationAspectsAssignment_9_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 
            // InternalTechnologyDsl.g:2574:3: ( rule__Technology__OperationAspectsAssignment_9_3 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==62) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2574:4: rule__Technology__OperationAspectsAssignment_9_3
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Technology__OperationAspectsAssignment_9_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 

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
    // $ANTLR end "rule__Technology__Group_9__3__Impl"


    // $ANTLR start "rule__Technology__Group_9__4"
    // InternalTechnologyDsl.g:2583:1: rule__Technology__Group_9__4 : rule__Technology__Group_9__4__Impl ;
    public final void rule__Technology__Group_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2587:1: ( rule__Technology__Group_9__4__Impl )
            // InternalTechnologyDsl.g:2588:2: rule__Technology__Group_9__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Technology__Group_9__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__4"


    // $ANTLR start "rule__Technology__Group_9__4__Impl"
    // InternalTechnologyDsl.g:2594:1: rule__Technology__Group_9__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2598:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2599:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2599:1: ( '}' )
            // InternalTechnologyDsl.g:2600:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_9_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_9_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__Group_9__4__Impl"


    // $ANTLR start "rule__TechnologyImport__Group__0"
    // InternalTechnologyDsl.g:2610:1: rule__TechnologyImport__Group__0 : rule__TechnologyImport__Group__0__Impl rule__TechnologyImport__Group__1 ;
    public final void rule__TechnologyImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2614:1: ( rule__TechnologyImport__Group__0__Impl rule__TechnologyImport__Group__1 )
            // InternalTechnologyDsl.g:2615:2: rule__TechnologyImport__Group__0__Impl rule__TechnologyImport__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__TechnologyImport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__0"


    // $ANTLR start "rule__TechnologyImport__Group__0__Impl"
    // InternalTechnologyDsl.g:2622:1: rule__TechnologyImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__TechnologyImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2626:1: ( ( 'import' ) )
            // InternalTechnologyDsl.g:2627:1: ( 'import' )
            {
            // InternalTechnologyDsl.g:2627:1: ( 'import' )
            // InternalTechnologyDsl.g:2628:2: 'import'
            {
             before(grammarAccess.getTechnologyImportAccess().getImportKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTechnologyImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__0__Impl"


    // $ANTLR start "rule__TechnologyImport__Group__1"
    // InternalTechnologyDsl.g:2637:1: rule__TechnologyImport__Group__1 : rule__TechnologyImport__Group__1__Impl rule__TechnologyImport__Group__2 ;
    public final void rule__TechnologyImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2641:1: ( rule__TechnologyImport__Group__1__Impl rule__TechnologyImport__Group__2 )
            // InternalTechnologyDsl.g:2642:2: rule__TechnologyImport__Group__1__Impl rule__TechnologyImport__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__TechnologyImport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__1"


    // $ANTLR start "rule__TechnologyImport__Group__1__Impl"
    // InternalTechnologyDsl.g:2649:1: rule__TechnologyImport__Group__1__Impl : ( 'technology' ) ;
    public final void rule__TechnologyImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2653:1: ( ( 'technology' ) )
            // InternalTechnologyDsl.g:2654:1: ( 'technology' )
            {
            // InternalTechnologyDsl.g:2654:1: ( 'technology' )
            // InternalTechnologyDsl.g:2655:2: 'technology'
            {
             before(grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__1__Impl"


    // $ANTLR start "rule__TechnologyImport__Group__2"
    // InternalTechnologyDsl.g:2664:1: rule__TechnologyImport__Group__2 : rule__TechnologyImport__Group__2__Impl rule__TechnologyImport__Group__3 ;
    public final void rule__TechnologyImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2668:1: ( rule__TechnologyImport__Group__2__Impl rule__TechnologyImport__Group__3 )
            // InternalTechnologyDsl.g:2669:2: rule__TechnologyImport__Group__2__Impl rule__TechnologyImport__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__TechnologyImport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__2"


    // $ANTLR start "rule__TechnologyImport__Group__2__Impl"
    // InternalTechnologyDsl.g:2676:1: rule__TechnologyImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__TechnologyImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2680:1: ( ( 'from' ) )
            // InternalTechnologyDsl.g:2681:1: ( 'from' )
            {
            // InternalTechnologyDsl.g:2681:1: ( 'from' )
            // InternalTechnologyDsl.g:2682:2: 'from'
            {
             before(grammarAccess.getTechnologyImportAccess().getFromKeyword_2()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getTechnologyImportAccess().getFromKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__2__Impl"


    // $ANTLR start "rule__TechnologyImport__Group__3"
    // InternalTechnologyDsl.g:2691:1: rule__TechnologyImport__Group__3 : rule__TechnologyImport__Group__3__Impl rule__TechnologyImport__Group__4 ;
    public final void rule__TechnologyImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2695:1: ( rule__TechnologyImport__Group__3__Impl rule__TechnologyImport__Group__4 )
            // InternalTechnologyDsl.g:2696:2: rule__TechnologyImport__Group__3__Impl rule__TechnologyImport__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__TechnologyImport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__3"


    // $ANTLR start "rule__TechnologyImport__Group__3__Impl"
    // InternalTechnologyDsl.g:2703:1: rule__TechnologyImport__Group__3__Impl : ( ( rule__TechnologyImport__ImportURIAssignment_3 ) ) ;
    public final void rule__TechnologyImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2707:1: ( ( ( rule__TechnologyImport__ImportURIAssignment_3 ) ) )
            // InternalTechnologyDsl.g:2708:1: ( ( rule__TechnologyImport__ImportURIAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:2708:1: ( ( rule__TechnologyImport__ImportURIAssignment_3 ) )
            // InternalTechnologyDsl.g:2709:2: ( rule__TechnologyImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getTechnologyImportAccess().getImportURIAssignment_3()); 
            // InternalTechnologyDsl.g:2710:2: ( rule__TechnologyImport__ImportURIAssignment_3 )
            // InternalTechnologyDsl.g:2710:3: rule__TechnologyImport__ImportURIAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TechnologyImport__ImportURIAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyImportAccess().getImportURIAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__3__Impl"


    // $ANTLR start "rule__TechnologyImport__Group__4"
    // InternalTechnologyDsl.g:2718:1: rule__TechnologyImport__Group__4 : rule__TechnologyImport__Group__4__Impl rule__TechnologyImport__Group__5 ;
    public final void rule__TechnologyImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2722:1: ( rule__TechnologyImport__Group__4__Impl rule__TechnologyImport__Group__5 )
            // InternalTechnologyDsl.g:2723:2: rule__TechnologyImport__Group__4__Impl rule__TechnologyImport__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__TechnologyImport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__4"


    // $ANTLR start "rule__TechnologyImport__Group__4__Impl"
    // InternalTechnologyDsl.g:2730:1: rule__TechnologyImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__TechnologyImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2734:1: ( ( 'as' ) )
            // InternalTechnologyDsl.g:2735:1: ( 'as' )
            {
            // InternalTechnologyDsl.g:2735:1: ( 'as' )
            // InternalTechnologyDsl.g:2736:2: 'as'
            {
             before(grammarAccess.getTechnologyImportAccess().getAsKeyword_4()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTechnologyImportAccess().getAsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__4__Impl"


    // $ANTLR start "rule__TechnologyImport__Group__5"
    // InternalTechnologyDsl.g:2745:1: rule__TechnologyImport__Group__5 : rule__TechnologyImport__Group__5__Impl ;
    public final void rule__TechnologyImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2749:1: ( rule__TechnologyImport__Group__5__Impl )
            // InternalTechnologyDsl.g:2750:2: rule__TechnologyImport__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologyImport__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__5"


    // $ANTLR start "rule__TechnologyImport__Group__5__Impl"
    // InternalTechnologyDsl.g:2756:1: rule__TechnologyImport__Group__5__Impl : ( ( rule__TechnologyImport__NameAssignment_5 ) ) ;
    public final void rule__TechnologyImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2760:1: ( ( ( rule__TechnologyImport__NameAssignment_5 ) ) )
            // InternalTechnologyDsl.g:2761:1: ( ( rule__TechnologyImport__NameAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:2761:1: ( ( rule__TechnologyImport__NameAssignment_5 ) )
            // InternalTechnologyDsl.g:2762:2: ( rule__TechnologyImport__NameAssignment_5 )
            {
             before(grammarAccess.getTechnologyImportAccess().getNameAssignment_5()); 
            // InternalTechnologyDsl.g:2763:2: ( rule__TechnologyImport__NameAssignment_5 )
            // InternalTechnologyDsl.g:2763:3: rule__TechnologyImport__NameAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__TechnologyImport__NameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyImportAccess().getNameAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__Group__5__Impl"


    // $ANTLR start "rule__Protocol__Group__0"
    // InternalTechnologyDsl.g:2772:1: rule__Protocol__Group__0 : rule__Protocol__Group__0__Impl rule__Protocol__Group__1 ;
    public final void rule__Protocol__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2776:1: ( rule__Protocol__Group__0__Impl rule__Protocol__Group__1 )
            // InternalTechnologyDsl.g:2777:2: rule__Protocol__Group__0__Impl rule__Protocol__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Protocol__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__0"


    // $ANTLR start "rule__Protocol__Group__0__Impl"
    // InternalTechnologyDsl.g:2784:1: rule__Protocol__Group__0__Impl : ( ( rule__Protocol__CommunicationTypeAssignment_0 ) ) ;
    public final void rule__Protocol__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2788:1: ( ( ( rule__Protocol__CommunicationTypeAssignment_0 ) ) )
            // InternalTechnologyDsl.g:2789:1: ( ( rule__Protocol__CommunicationTypeAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:2789:1: ( ( rule__Protocol__CommunicationTypeAssignment_0 ) )
            // InternalTechnologyDsl.g:2790:2: ( rule__Protocol__CommunicationTypeAssignment_0 )
            {
             before(grammarAccess.getProtocolAccess().getCommunicationTypeAssignment_0()); 
            // InternalTechnologyDsl.g:2791:2: ( rule__Protocol__CommunicationTypeAssignment_0 )
            // InternalTechnologyDsl.g:2791:3: rule__Protocol__CommunicationTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__CommunicationTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getCommunicationTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__0__Impl"


    // $ANTLR start "rule__Protocol__Group__1"
    // InternalTechnologyDsl.g:2799:1: rule__Protocol__Group__1 : rule__Protocol__Group__1__Impl rule__Protocol__Group__2 ;
    public final void rule__Protocol__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2803:1: ( rule__Protocol__Group__1__Impl rule__Protocol__Group__2 )
            // InternalTechnologyDsl.g:2804:2: rule__Protocol__Group__1__Impl rule__Protocol__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Protocol__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__1"


    // $ANTLR start "rule__Protocol__Group__1__Impl"
    // InternalTechnologyDsl.g:2811:1: rule__Protocol__Group__1__Impl : ( ( rule__Protocol__NameAssignment_1 ) ) ;
    public final void rule__Protocol__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2815:1: ( ( ( rule__Protocol__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:2816:1: ( ( rule__Protocol__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:2816:1: ( ( rule__Protocol__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:2817:2: ( rule__Protocol__NameAssignment_1 )
            {
             before(grammarAccess.getProtocolAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:2818:2: ( rule__Protocol__NameAssignment_1 )
            // InternalTechnologyDsl.g:2818:3: rule__Protocol__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__1__Impl"


    // $ANTLR start "rule__Protocol__Group__2"
    // InternalTechnologyDsl.g:2826:1: rule__Protocol__Group__2 : rule__Protocol__Group__2__Impl rule__Protocol__Group__3 ;
    public final void rule__Protocol__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2830:1: ( rule__Protocol__Group__2__Impl rule__Protocol__Group__3 )
            // InternalTechnologyDsl.g:2831:2: rule__Protocol__Group__2__Impl rule__Protocol__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__Protocol__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__2"


    // $ANTLR start "rule__Protocol__Group__2__Impl"
    // InternalTechnologyDsl.g:2838:1: rule__Protocol__Group__2__Impl : ( 'data' ) ;
    public final void rule__Protocol__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2842:1: ( ( 'data' ) )
            // InternalTechnologyDsl.g:2843:1: ( 'data' )
            {
            // InternalTechnologyDsl.g:2843:1: ( 'data' )
            // InternalTechnologyDsl.g:2844:2: 'data'
            {
             before(grammarAccess.getProtocolAccess().getDataKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getDataKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__2__Impl"


    // $ANTLR start "rule__Protocol__Group__3"
    // InternalTechnologyDsl.g:2853:1: rule__Protocol__Group__3 : rule__Protocol__Group__3__Impl rule__Protocol__Group__4 ;
    public final void rule__Protocol__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2857:1: ( rule__Protocol__Group__3__Impl rule__Protocol__Group__4 )
            // InternalTechnologyDsl.g:2858:2: rule__Protocol__Group__3__Impl rule__Protocol__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Protocol__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__3"


    // $ANTLR start "rule__Protocol__Group__3__Impl"
    // InternalTechnologyDsl.g:2865:1: rule__Protocol__Group__3__Impl : ( 'formats' ) ;
    public final void rule__Protocol__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2869:1: ( ( 'formats' ) )
            // InternalTechnologyDsl.g:2870:1: ( 'formats' )
            {
            // InternalTechnologyDsl.g:2870:1: ( 'formats' )
            // InternalTechnologyDsl.g:2871:2: 'formats'
            {
             before(grammarAccess.getProtocolAccess().getFormatsKeyword_3()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getFormatsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__3__Impl"


    // $ANTLR start "rule__Protocol__Group__4"
    // InternalTechnologyDsl.g:2880:1: rule__Protocol__Group__4 : rule__Protocol__Group__4__Impl rule__Protocol__Group__5 ;
    public final void rule__Protocol__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2884:1: ( rule__Protocol__Group__4__Impl rule__Protocol__Group__5 )
            // InternalTechnologyDsl.g:2885:2: rule__Protocol__Group__4__Impl rule__Protocol__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__Protocol__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__4"


    // $ANTLR start "rule__Protocol__Group__4__Impl"
    // InternalTechnologyDsl.g:2892:1: rule__Protocol__Group__4__Impl : ( ( rule__Protocol__DataFormatsAssignment_4 ) ) ;
    public final void rule__Protocol__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2896:1: ( ( ( rule__Protocol__DataFormatsAssignment_4 ) ) )
            // InternalTechnologyDsl.g:2897:1: ( ( rule__Protocol__DataFormatsAssignment_4 ) )
            {
            // InternalTechnologyDsl.g:2897:1: ( ( rule__Protocol__DataFormatsAssignment_4 ) )
            // InternalTechnologyDsl.g:2898:2: ( rule__Protocol__DataFormatsAssignment_4 )
            {
             before(grammarAccess.getProtocolAccess().getDataFormatsAssignment_4()); 
            // InternalTechnologyDsl.g:2899:2: ( rule__Protocol__DataFormatsAssignment_4 )
            // InternalTechnologyDsl.g:2899:3: rule__Protocol__DataFormatsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__DataFormatsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getDataFormatsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__4__Impl"


    // $ANTLR start "rule__Protocol__Group__5"
    // InternalTechnologyDsl.g:2907:1: rule__Protocol__Group__5 : rule__Protocol__Group__5__Impl rule__Protocol__Group__6 ;
    public final void rule__Protocol__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2911:1: ( rule__Protocol__Group__5__Impl rule__Protocol__Group__6 )
            // InternalTechnologyDsl.g:2912:2: rule__Protocol__Group__5__Impl rule__Protocol__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__Protocol__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__5"


    // $ANTLR start "rule__Protocol__Group__5__Impl"
    // InternalTechnologyDsl.g:2919:1: rule__Protocol__Group__5__Impl : ( ( rule__Protocol__Group_5__0 )* ) ;
    public final void rule__Protocol__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2923:1: ( ( ( rule__Protocol__Group_5__0 )* ) )
            // InternalTechnologyDsl.g:2924:1: ( ( rule__Protocol__Group_5__0 )* )
            {
            // InternalTechnologyDsl.g:2924:1: ( ( rule__Protocol__Group_5__0 )* )
            // InternalTechnologyDsl.g:2925:2: ( rule__Protocol__Group_5__0 )*
            {
             before(grammarAccess.getProtocolAccess().getGroup_5()); 
            // InternalTechnologyDsl.g:2926:2: ( rule__Protocol__Group_5__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==46) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2926:3: rule__Protocol__Group_5__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__Protocol__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getProtocolAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__5__Impl"


    // $ANTLR start "rule__Protocol__Group__6"
    // InternalTechnologyDsl.g:2934:1: rule__Protocol__Group__6 : rule__Protocol__Group__6__Impl rule__Protocol__Group__7 ;
    public final void rule__Protocol__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2938:1: ( rule__Protocol__Group__6__Impl rule__Protocol__Group__7 )
            // InternalTechnologyDsl.g:2939:2: rule__Protocol__Group__6__Impl rule__Protocol__Group__7
            {
            pushFollow(FOLLOW_27);
            rule__Protocol__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__6"


    // $ANTLR start "rule__Protocol__Group__6__Impl"
    // InternalTechnologyDsl.g:2946:1: rule__Protocol__Group__6__Impl : ( ( rule__Protocol__Group_6__0 )? ) ;
    public final void rule__Protocol__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2950:1: ( ( ( rule__Protocol__Group_6__0 )? ) )
            // InternalTechnologyDsl.g:2951:1: ( ( rule__Protocol__Group_6__0 )? )
            {
            // InternalTechnologyDsl.g:2951:1: ( ( rule__Protocol__Group_6__0 )? )
            // InternalTechnologyDsl.g:2952:2: ( rule__Protocol__Group_6__0 )?
            {
             before(grammarAccess.getProtocolAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:2953:2: ( rule__Protocol__Group_6__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==80) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTechnologyDsl.g:2953:3: rule__Protocol__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Protocol__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProtocolAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__6__Impl"


    // $ANTLR start "rule__Protocol__Group__7"
    // InternalTechnologyDsl.g:2961:1: rule__Protocol__Group__7 : rule__Protocol__Group__7__Impl ;
    public final void rule__Protocol__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2965:1: ( rule__Protocol__Group__7__Impl )
            // InternalTechnologyDsl.g:2966:2: rule__Protocol__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__7"


    // $ANTLR start "rule__Protocol__Group__7__Impl"
    // InternalTechnologyDsl.g:2972:1: rule__Protocol__Group__7__Impl : ( ';' ) ;
    public final void rule__Protocol__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2976:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:2977:1: ( ';' )
            {
            // InternalTechnologyDsl.g:2977:1: ( ';' )
            // InternalTechnologyDsl.g:2978:2: ';'
            {
             before(grammarAccess.getProtocolAccess().getSemicolonKeyword_7()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group__7__Impl"


    // $ANTLR start "rule__Protocol__Group_5__0"
    // InternalTechnologyDsl.g:2988:1: rule__Protocol__Group_5__0 : rule__Protocol__Group_5__0__Impl rule__Protocol__Group_5__1 ;
    public final void rule__Protocol__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2992:1: ( rule__Protocol__Group_5__0__Impl rule__Protocol__Group_5__1 )
            // InternalTechnologyDsl.g:2993:2: rule__Protocol__Group_5__0__Impl rule__Protocol__Group_5__1
            {
            pushFollow(FOLLOW_7);
            rule__Protocol__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_5__0"


    // $ANTLR start "rule__Protocol__Group_5__0__Impl"
    // InternalTechnologyDsl.g:3000:1: rule__Protocol__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Protocol__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3004:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:3005:1: ( ',' )
            {
            // InternalTechnologyDsl.g:3005:1: ( ',' )
            // InternalTechnologyDsl.g:3006:2: ','
            {
             before(grammarAccess.getProtocolAccess().getCommaKeyword_5_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_5__0__Impl"


    // $ANTLR start "rule__Protocol__Group_5__1"
    // InternalTechnologyDsl.g:3015:1: rule__Protocol__Group_5__1 : rule__Protocol__Group_5__1__Impl ;
    public final void rule__Protocol__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3019:1: ( rule__Protocol__Group_5__1__Impl )
            // InternalTechnologyDsl.g:3020:2: rule__Protocol__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_5__1"


    // $ANTLR start "rule__Protocol__Group_5__1__Impl"
    // InternalTechnologyDsl.g:3026:1: rule__Protocol__Group_5__1__Impl : ( ( rule__Protocol__DataFormatsAssignment_5_1 ) ) ;
    public final void rule__Protocol__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3030:1: ( ( ( rule__Protocol__DataFormatsAssignment_5_1 ) ) )
            // InternalTechnologyDsl.g:3031:1: ( ( rule__Protocol__DataFormatsAssignment_5_1 ) )
            {
            // InternalTechnologyDsl.g:3031:1: ( ( rule__Protocol__DataFormatsAssignment_5_1 ) )
            // InternalTechnologyDsl.g:3032:2: ( rule__Protocol__DataFormatsAssignment_5_1 )
            {
             before(grammarAccess.getProtocolAccess().getDataFormatsAssignment_5_1()); 
            // InternalTechnologyDsl.g:3033:2: ( rule__Protocol__DataFormatsAssignment_5_1 )
            // InternalTechnologyDsl.g:3033:3: rule__Protocol__DataFormatsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__DataFormatsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getDataFormatsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_5__1__Impl"


    // $ANTLR start "rule__Protocol__Group_6__0"
    // InternalTechnologyDsl.g:3042:1: rule__Protocol__Group_6__0 : rule__Protocol__Group_6__0__Impl rule__Protocol__Group_6__1 ;
    public final void rule__Protocol__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3046:1: ( rule__Protocol__Group_6__0__Impl rule__Protocol__Group_6__1 )
            // InternalTechnologyDsl.g:3047:2: rule__Protocol__Group_6__0__Impl rule__Protocol__Group_6__1
            {
            pushFollow(FOLLOW_29);
            rule__Protocol__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__0"


    // $ANTLR start "rule__Protocol__Group_6__0__Impl"
    // InternalTechnologyDsl.g:3054:1: rule__Protocol__Group_6__0__Impl : ( ( rule__Protocol__DefaultAssignment_6_0 ) ) ;
    public final void rule__Protocol__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3058:1: ( ( ( rule__Protocol__DefaultAssignment_6_0 ) ) )
            // InternalTechnologyDsl.g:3059:1: ( ( rule__Protocol__DefaultAssignment_6_0 ) )
            {
            // InternalTechnologyDsl.g:3059:1: ( ( rule__Protocol__DefaultAssignment_6_0 ) )
            // InternalTechnologyDsl.g:3060:2: ( rule__Protocol__DefaultAssignment_6_0 )
            {
             before(grammarAccess.getProtocolAccess().getDefaultAssignment_6_0()); 
            // InternalTechnologyDsl.g:3061:2: ( rule__Protocol__DefaultAssignment_6_0 )
            // InternalTechnologyDsl.g:3061:3: rule__Protocol__DefaultAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__DefaultAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getDefaultAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__0__Impl"


    // $ANTLR start "rule__Protocol__Group_6__1"
    // InternalTechnologyDsl.g:3069:1: rule__Protocol__Group_6__1 : rule__Protocol__Group_6__1__Impl rule__Protocol__Group_6__2 ;
    public final void rule__Protocol__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3073:1: ( rule__Protocol__Group_6__1__Impl rule__Protocol__Group_6__2 )
            // InternalTechnologyDsl.g:3074:2: rule__Protocol__Group_6__1__Impl rule__Protocol__Group_6__2
            {
            pushFollow(FOLLOW_30);
            rule__Protocol__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__1"


    // $ANTLR start "rule__Protocol__Group_6__1__Impl"
    // InternalTechnologyDsl.g:3081:1: rule__Protocol__Group_6__1__Impl : ( 'with' ) ;
    public final void rule__Protocol__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3085:1: ( ( 'with' ) )
            // InternalTechnologyDsl.g:3086:1: ( 'with' )
            {
            // InternalTechnologyDsl.g:3086:1: ( 'with' )
            // InternalTechnologyDsl.g:3087:2: 'with'
            {
             before(grammarAccess.getProtocolAccess().getWithKeyword_6_1()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getWithKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__1__Impl"


    // $ANTLR start "rule__Protocol__Group_6__2"
    // InternalTechnologyDsl.g:3096:1: rule__Protocol__Group_6__2 : rule__Protocol__Group_6__2__Impl rule__Protocol__Group_6__3 ;
    public final void rule__Protocol__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3100:1: ( rule__Protocol__Group_6__2__Impl rule__Protocol__Group_6__3 )
            // InternalTechnologyDsl.g:3101:2: rule__Protocol__Group_6__2__Impl rule__Protocol__Group_6__3
            {
            pushFollow(FOLLOW_7);
            rule__Protocol__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Protocol__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__2"


    // $ANTLR start "rule__Protocol__Group_6__2__Impl"
    // InternalTechnologyDsl.g:3108:1: rule__Protocol__Group_6__2__Impl : ( 'format' ) ;
    public final void rule__Protocol__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3112:1: ( ( 'format' ) )
            // InternalTechnologyDsl.g:3113:1: ( 'format' )
            {
            // InternalTechnologyDsl.g:3113:1: ( 'format' )
            // InternalTechnologyDsl.g:3114:2: 'format'
            {
             before(grammarAccess.getProtocolAccess().getFormatKeyword_6_2()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getFormatKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__2__Impl"


    // $ANTLR start "rule__Protocol__Group_6__3"
    // InternalTechnologyDsl.g:3123:1: rule__Protocol__Group_6__3 : rule__Protocol__Group_6__3__Impl ;
    public final void rule__Protocol__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3127:1: ( rule__Protocol__Group_6__3__Impl )
            // InternalTechnologyDsl.g:3128:2: rule__Protocol__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__3"


    // $ANTLR start "rule__Protocol__Group_6__3__Impl"
    // InternalTechnologyDsl.g:3134:1: rule__Protocol__Group_6__3__Impl : ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) ) ;
    public final void rule__Protocol__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3138:1: ( ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) ) )
            // InternalTechnologyDsl.g:3139:1: ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) )
            {
            // InternalTechnologyDsl.g:3139:1: ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) )
            // InternalTechnologyDsl.g:3140:2: ( rule__Protocol__DefaultFormatAssignment_6_3 )
            {
             before(grammarAccess.getProtocolAccess().getDefaultFormatAssignment_6_3()); 
            // InternalTechnologyDsl.g:3141:2: ( rule__Protocol__DefaultFormatAssignment_6_3 )
            // InternalTechnologyDsl.g:3141:3: rule__Protocol__DefaultFormatAssignment_6_3
            {
            pushFollow(FOLLOW_2);
            rule__Protocol__DefaultFormatAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getProtocolAccess().getDefaultFormatAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__Group_6__3__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__0"
    // InternalTechnologyDsl.g:3150:1: rule__TechnologySpecificPrimitiveType__Group__0 : rule__TechnologySpecificPrimitiveType__Group__0__Impl rule__TechnologySpecificPrimitiveType__Group__1 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3154:1: ( rule__TechnologySpecificPrimitiveType__Group__0__Impl rule__TechnologySpecificPrimitiveType__Group__1 )
            // InternalTechnologyDsl.g:3155:2: rule__TechnologySpecificPrimitiveType__Group__0__Impl rule__TechnologySpecificPrimitiveType__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__TechnologySpecificPrimitiveType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__0"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__0__Impl"
    // InternalTechnologyDsl.g:3162:1: rule__TechnologySpecificPrimitiveType__Group__0__Impl : ( 'primitive' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3166:1: ( ( 'primitive' ) )
            // InternalTechnologyDsl.g:3167:1: ( 'primitive' )
            {
            // InternalTechnologyDsl.g:3167:1: ( 'primitive' )
            // InternalTechnologyDsl.g:3168:2: 'primitive'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getPrimitiveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__0__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__1"
    // InternalTechnologyDsl.g:3177:1: rule__TechnologySpecificPrimitiveType__Group__1 : rule__TechnologySpecificPrimitiveType__Group__1__Impl rule__TechnologySpecificPrimitiveType__Group__2 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3181:1: ( rule__TechnologySpecificPrimitiveType__Group__1__Impl rule__TechnologySpecificPrimitiveType__Group__2 )
            // InternalTechnologyDsl.g:3182:2: rule__TechnologySpecificPrimitiveType__Group__1__Impl rule__TechnologySpecificPrimitiveType__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__TechnologySpecificPrimitiveType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__1"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__1__Impl"
    // InternalTechnologyDsl.g:3189:1: rule__TechnologySpecificPrimitiveType__Group__1__Impl : ( 'type' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3193:1: ( ( 'type' ) )
            // InternalTechnologyDsl.g:3194:1: ( 'type' )
            {
            // InternalTechnologyDsl.g:3194:1: ( 'type' )
            // InternalTechnologyDsl.g:3195:2: 'type'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__1__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__2"
    // InternalTechnologyDsl.g:3204:1: rule__TechnologySpecificPrimitiveType__Group__2 : rule__TechnologySpecificPrimitiveType__Group__2__Impl rule__TechnologySpecificPrimitiveType__Group__3 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3208:1: ( rule__TechnologySpecificPrimitiveType__Group__2__Impl rule__TechnologySpecificPrimitiveType__Group__3 )
            // InternalTechnologyDsl.g:3209:2: rule__TechnologySpecificPrimitiveType__Group__2__Impl rule__TechnologySpecificPrimitiveType__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__TechnologySpecificPrimitiveType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__2"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__2__Impl"
    // InternalTechnologyDsl.g:3216:1: rule__TechnologySpecificPrimitiveType__Group__2__Impl : ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3220:1: ( ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3221:1: ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3221:1: ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:3222:2: ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:3223:2: ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 )
            // InternalTechnologyDsl.g:3223:3: rule__TechnologySpecificPrimitiveType__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__2__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__3"
    // InternalTechnologyDsl.g:3231:1: rule__TechnologySpecificPrimitiveType__Group__3 : rule__TechnologySpecificPrimitiveType__Group__3__Impl rule__TechnologySpecificPrimitiveType__Group__4 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3235:1: ( rule__TechnologySpecificPrimitiveType__Group__3__Impl rule__TechnologySpecificPrimitiveType__Group__4 )
            // InternalTechnologyDsl.g:3236:2: rule__TechnologySpecificPrimitiveType__Group__3__Impl rule__TechnologySpecificPrimitiveType__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__TechnologySpecificPrimitiveType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__3"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__3__Impl"
    // InternalTechnologyDsl.g:3243:1: rule__TechnologySpecificPrimitiveType__Group__3__Impl : ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3247:1: ( ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? ) )
            // InternalTechnologyDsl.g:3248:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? )
            {
            // InternalTechnologyDsl.g:3248:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? )
            // InternalTechnologyDsl.g:3249:2: ( rule__TechnologySpecificPrimitiveType__Group_3__0 )?
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3()); 
            // InternalTechnologyDsl.g:3250:2: ( rule__TechnologySpecificPrimitiveType__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==51) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTechnologyDsl.g:3250:3: rule__TechnologySpecificPrimitiveType__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TechnologySpecificPrimitiveType__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__3__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__4"
    // InternalTechnologyDsl.g:3258:1: rule__TechnologySpecificPrimitiveType__Group__4 : rule__TechnologySpecificPrimitiveType__Group__4__Impl ;
    public final void rule__TechnologySpecificPrimitiveType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3262:1: ( rule__TechnologySpecificPrimitiveType__Group__4__Impl )
            // InternalTechnologyDsl.g:3263:2: rule__TechnologySpecificPrimitiveType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__4"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group__4__Impl"
    // InternalTechnologyDsl.g:3269:1: rule__TechnologySpecificPrimitiveType__Group__4__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3273:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3274:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3274:1: ( ';' )
            // InternalTechnologyDsl.g:3275:2: ';'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getSemicolonKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group__4__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__0"
    // InternalTechnologyDsl.g:3285:1: rule__TechnologySpecificPrimitiveType__Group_3__0 : rule__TechnologySpecificPrimitiveType__Group_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3__1 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3289:1: ( rule__TechnologySpecificPrimitiveType__Group_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3__1 )
            // InternalTechnologyDsl.g:3290:2: rule__TechnologySpecificPrimitiveType__Group_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_33);
            rule__TechnologySpecificPrimitiveType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__0"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__0__Impl"
    // InternalTechnologyDsl.g:3297:1: rule__TechnologySpecificPrimitiveType__Group_3__0__Impl : ( 'based' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3301:1: ( ( 'based' ) )
            // InternalTechnologyDsl.g:3302:1: ( 'based' )
            {
            // InternalTechnologyDsl.g:3302:1: ( 'based' )
            // InternalTechnologyDsl.g:3303:2: 'based'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasedKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__0__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__1"
    // InternalTechnologyDsl.g:3312:1: rule__TechnologySpecificPrimitiveType__Group_3__1 : rule__TechnologySpecificPrimitiveType__Group_3__1__Impl rule__TechnologySpecificPrimitiveType__Group_3__2 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3316:1: ( rule__TechnologySpecificPrimitiveType__Group_3__1__Impl rule__TechnologySpecificPrimitiveType__Group_3__2 )
            // InternalTechnologyDsl.g:3317:2: rule__TechnologySpecificPrimitiveType__Group_3__1__Impl rule__TechnologySpecificPrimitiveType__Group_3__2
            {
            pushFollow(FOLLOW_34);
            rule__TechnologySpecificPrimitiveType__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__1"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__1__Impl"
    // InternalTechnologyDsl.g:3324:1: rule__TechnologySpecificPrimitiveType__Group_3__1__Impl : ( 'on' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3328:1: ( ( 'on' ) )
            // InternalTechnologyDsl.g:3329:1: ( 'on' )
            {
            // InternalTechnologyDsl.g:3329:1: ( 'on' )
            // InternalTechnologyDsl.g:3330:2: 'on'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getOnKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__1__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__2"
    // InternalTechnologyDsl.g:3339:1: rule__TechnologySpecificPrimitiveType__Group_3__2 : rule__TechnologySpecificPrimitiveType__Group_3__2__Impl rule__TechnologySpecificPrimitiveType__Group_3__3 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3343:1: ( rule__TechnologySpecificPrimitiveType__Group_3__2__Impl rule__TechnologySpecificPrimitiveType__Group_3__3 )
            // InternalTechnologyDsl.g:3344:2: rule__TechnologySpecificPrimitiveType__Group_3__2__Impl rule__TechnologySpecificPrimitiveType__Group_3__3
            {
            pushFollow(FOLLOW_35);
            rule__TechnologySpecificPrimitiveType__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__2"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__2__Impl"
    // InternalTechnologyDsl.g:3351:1: rule__TechnologySpecificPrimitiveType__Group_3__2__Impl : ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3355:1: ( ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) ) )
            // InternalTechnologyDsl.g:3356:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) )
            {
            // InternalTechnologyDsl.g:3356:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) )
            // InternalTechnologyDsl.g:3357:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_2()); 
            // InternalTechnologyDsl.g:3358:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 )
            // InternalTechnologyDsl.g:3358:3: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__2__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__3"
    // InternalTechnologyDsl.g:3366:1: rule__TechnologySpecificPrimitiveType__Group_3__3 : rule__TechnologySpecificPrimitiveType__Group_3__3__Impl rule__TechnologySpecificPrimitiveType__Group_3__4 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3370:1: ( rule__TechnologySpecificPrimitiveType__Group_3__3__Impl rule__TechnologySpecificPrimitiveType__Group_3__4 )
            // InternalTechnologyDsl.g:3371:2: rule__TechnologySpecificPrimitiveType__Group_3__3__Impl rule__TechnologySpecificPrimitiveType__Group_3__4
            {
            pushFollow(FOLLOW_35);
            rule__TechnologySpecificPrimitiveType__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__3"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__3__Impl"
    // InternalTechnologyDsl.g:3378:1: rule__TechnologySpecificPrimitiveType__Group_3__3__Impl : ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3382:1: ( ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* ) )
            // InternalTechnologyDsl.g:3383:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* )
            {
            // InternalTechnologyDsl.g:3383:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* )
            // InternalTechnologyDsl.g:3384:2: ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )*
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3_3()); 
            // InternalTechnologyDsl.g:3385:2: ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==46) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3385:3: rule__TechnologySpecificPrimitiveType__Group_3_3__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__TechnologySpecificPrimitiveType__Group_3_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__3__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__4"
    // InternalTechnologyDsl.g:3393:1: rule__TechnologySpecificPrimitiveType__Group_3__4 : rule__TechnologySpecificPrimitiveType__Group_3__4__Impl ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3397:1: ( rule__TechnologySpecificPrimitiveType__Group_3__4__Impl )
            // InternalTechnologyDsl.g:3398:2: rule__TechnologySpecificPrimitiveType__Group_3__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__4"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3__4__Impl"
    // InternalTechnologyDsl.g:3404:1: rule__TechnologySpecificPrimitiveType__Group_3__4__Impl : ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3408:1: ( ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? ) )
            // InternalTechnologyDsl.g:3409:1: ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? )
            {
            // InternalTechnologyDsl.g:3409:1: ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? )
            // InternalTechnologyDsl.g:3410:2: ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )?
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultAssignment_3_4()); 
            // InternalTechnologyDsl.g:3411:2: ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==80) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTechnologyDsl.g:3411:3: rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultAssignment_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3__4__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3_3__0"
    // InternalTechnologyDsl.g:3420:1: rule__TechnologySpecificPrimitiveType__Group_3_3__0 : rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3_3__1 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3424:1: ( rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3_3__1 )
            // InternalTechnologyDsl.g:3425:2: rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3_3__1
            {
            pushFollow(FOLLOW_34);
            rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3_3__0"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl"
    // InternalTechnologyDsl.g:3432:1: rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl : ( ',' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3436:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:3437:1: ( ',' )
            {
            // InternalTechnologyDsl.g:3437:1: ( ',' )
            // InternalTechnologyDsl.g:3438:2: ','
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getCommaKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3_3__1"
    // InternalTechnologyDsl.g:3447:1: rule__TechnologySpecificPrimitiveType__Group_3_3__1 : rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3451:1: ( rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl )
            // InternalTechnologyDsl.g:3452:2: rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3_3__1"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl"
    // InternalTechnologyDsl.g:3458:1: rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl : ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3462:1: ( ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) ) )
            // InternalTechnologyDsl.g:3463:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) )
            {
            // InternalTechnologyDsl.g:3463:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) )
            // InternalTechnologyDsl.g:3464:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_3_1()); 
            // InternalTechnologyDsl.g:3465:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 )
            // InternalTechnologyDsl.g:3465:3: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl"


    // $ANTLR start "rule__TechnologySpecificListType__Group__0"
    // InternalTechnologyDsl.g:3474:1: rule__TechnologySpecificListType__Group__0 : rule__TechnologySpecificListType__Group__0__Impl rule__TechnologySpecificListType__Group__1 ;
    public final void rule__TechnologySpecificListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3478:1: ( rule__TechnologySpecificListType__Group__0__Impl rule__TechnologySpecificListType__Group__1 )
            // InternalTechnologyDsl.g:3479:2: rule__TechnologySpecificListType__Group__0__Impl rule__TechnologySpecificListType__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__TechnologySpecificListType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificListType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__0"


    // $ANTLR start "rule__TechnologySpecificListType__Group__0__Impl"
    // InternalTechnologyDsl.g:3486:1: rule__TechnologySpecificListType__Group__0__Impl : ( 'list' ) ;
    public final void rule__TechnologySpecificListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3490:1: ( ( 'list' ) )
            // InternalTechnologyDsl.g:3491:1: ( 'list' )
            {
            // InternalTechnologyDsl.g:3491:1: ( 'list' )
            // InternalTechnologyDsl.g:3492:2: 'list'
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificListTypeAccess().getListKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__0__Impl"


    // $ANTLR start "rule__TechnologySpecificListType__Group__1"
    // InternalTechnologyDsl.g:3501:1: rule__TechnologySpecificListType__Group__1 : rule__TechnologySpecificListType__Group__1__Impl rule__TechnologySpecificListType__Group__2 ;
    public final void rule__TechnologySpecificListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3505:1: ( rule__TechnologySpecificListType__Group__1__Impl rule__TechnologySpecificListType__Group__2 )
            // InternalTechnologyDsl.g:3506:2: rule__TechnologySpecificListType__Group__1__Impl rule__TechnologySpecificListType__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__TechnologySpecificListType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificListType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__1"


    // $ANTLR start "rule__TechnologySpecificListType__Group__1__Impl"
    // InternalTechnologyDsl.g:3513:1: rule__TechnologySpecificListType__Group__1__Impl : ( 'type' ) ;
    public final void rule__TechnologySpecificListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3517:1: ( ( 'type' ) )
            // InternalTechnologyDsl.g:3518:1: ( 'type' )
            {
            // InternalTechnologyDsl.g:3518:1: ( 'type' )
            // InternalTechnologyDsl.g:3519:2: 'type'
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificListTypeAccess().getTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__1__Impl"


    // $ANTLR start "rule__TechnologySpecificListType__Group__2"
    // InternalTechnologyDsl.g:3528:1: rule__TechnologySpecificListType__Group__2 : rule__TechnologySpecificListType__Group__2__Impl rule__TechnologySpecificListType__Group__3 ;
    public final void rule__TechnologySpecificListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3532:1: ( rule__TechnologySpecificListType__Group__2__Impl rule__TechnologySpecificListType__Group__3 )
            // InternalTechnologyDsl.g:3533:2: rule__TechnologySpecificListType__Group__2__Impl rule__TechnologySpecificListType__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__TechnologySpecificListType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificListType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__2"


    // $ANTLR start "rule__TechnologySpecificListType__Group__2__Impl"
    // InternalTechnologyDsl.g:3540:1: rule__TechnologySpecificListType__Group__2__Impl : ( ( rule__TechnologySpecificListType__NameAssignment_2 ) ) ;
    public final void rule__TechnologySpecificListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3544:1: ( ( ( rule__TechnologySpecificListType__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3545:1: ( ( rule__TechnologySpecificListType__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3545:1: ( ( rule__TechnologySpecificListType__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:3546:2: ( rule__TechnologySpecificListType__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:3547:2: ( rule__TechnologySpecificListType__NameAssignment_2 )
            // InternalTechnologyDsl.g:3547:3: rule__TechnologySpecificListType__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificListType__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificListTypeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__2__Impl"


    // $ANTLR start "rule__TechnologySpecificListType__Group__3"
    // InternalTechnologyDsl.g:3555:1: rule__TechnologySpecificListType__Group__3 : rule__TechnologySpecificListType__Group__3__Impl ;
    public final void rule__TechnologySpecificListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3559:1: ( rule__TechnologySpecificListType__Group__3__Impl )
            // InternalTechnologyDsl.g:3560:2: rule__TechnologySpecificListType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificListType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__3"


    // $ANTLR start "rule__TechnologySpecificListType__Group__3__Impl"
    // InternalTechnologyDsl.g:3566:1: rule__TechnologySpecificListType__Group__3__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3570:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3571:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3571:1: ( ';' )
            // InternalTechnologyDsl.g:3572:2: ';'
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getSemicolonKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificListTypeAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__Group__3__Impl"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__0"
    // InternalTechnologyDsl.g:3582:1: rule__TechnologySpecificDataStructure__Group__0 : rule__TechnologySpecificDataStructure__Group__0__Impl rule__TechnologySpecificDataStructure__Group__1 ;
    public final void rule__TechnologySpecificDataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3586:1: ( rule__TechnologySpecificDataStructure__Group__0__Impl rule__TechnologySpecificDataStructure__Group__1 )
            // InternalTechnologyDsl.g:3587:2: rule__TechnologySpecificDataStructure__Group__0__Impl rule__TechnologySpecificDataStructure__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__TechnologySpecificDataStructure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificDataStructure__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__0"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__0__Impl"
    // InternalTechnologyDsl.g:3594:1: rule__TechnologySpecificDataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__TechnologySpecificDataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3598:1: ( ( 'structure' ) )
            // InternalTechnologyDsl.g:3599:1: ( 'structure' )
            {
            // InternalTechnologyDsl.g:3599:1: ( 'structure' )
            // InternalTechnologyDsl.g:3600:2: 'structure'
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificDataStructureAccess().getStructureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__0__Impl"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__1"
    // InternalTechnologyDsl.g:3609:1: rule__TechnologySpecificDataStructure__Group__1 : rule__TechnologySpecificDataStructure__Group__1__Impl rule__TechnologySpecificDataStructure__Group__2 ;
    public final void rule__TechnologySpecificDataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3613:1: ( rule__TechnologySpecificDataStructure__Group__1__Impl rule__TechnologySpecificDataStructure__Group__2 )
            // InternalTechnologyDsl.g:3614:2: rule__TechnologySpecificDataStructure__Group__1__Impl rule__TechnologySpecificDataStructure__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__TechnologySpecificDataStructure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificDataStructure__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__1"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__1__Impl"
    // InternalTechnologyDsl.g:3621:1: rule__TechnologySpecificDataStructure__Group__1__Impl : ( 'type' ) ;
    public final void rule__TechnologySpecificDataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3625:1: ( ( 'type' ) )
            // InternalTechnologyDsl.g:3626:1: ( 'type' )
            {
            // InternalTechnologyDsl.g:3626:1: ( 'type' )
            // InternalTechnologyDsl.g:3627:2: 'type'
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificDataStructureAccess().getTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__1__Impl"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__2"
    // InternalTechnologyDsl.g:3636:1: rule__TechnologySpecificDataStructure__Group__2 : rule__TechnologySpecificDataStructure__Group__2__Impl rule__TechnologySpecificDataStructure__Group__3 ;
    public final void rule__TechnologySpecificDataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3640:1: ( rule__TechnologySpecificDataStructure__Group__2__Impl rule__TechnologySpecificDataStructure__Group__3 )
            // InternalTechnologyDsl.g:3641:2: rule__TechnologySpecificDataStructure__Group__2__Impl rule__TechnologySpecificDataStructure__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__TechnologySpecificDataStructure__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificDataStructure__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__2"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__2__Impl"
    // InternalTechnologyDsl.g:3648:1: rule__TechnologySpecificDataStructure__Group__2__Impl : ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) ) ;
    public final void rule__TechnologySpecificDataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3652:1: ( ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3653:1: ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3653:1: ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:3654:2: ( rule__TechnologySpecificDataStructure__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:3655:2: ( rule__TechnologySpecificDataStructure__NameAssignment_2 )
            // InternalTechnologyDsl.g:3655:3: rule__TechnologySpecificDataStructure__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificDataStructure__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificDataStructureAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__2__Impl"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__3"
    // InternalTechnologyDsl.g:3663:1: rule__TechnologySpecificDataStructure__Group__3 : rule__TechnologySpecificDataStructure__Group__3__Impl ;
    public final void rule__TechnologySpecificDataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3667:1: ( rule__TechnologySpecificDataStructure__Group__3__Impl )
            // InternalTechnologyDsl.g:3668:2: rule__TechnologySpecificDataStructure__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificDataStructure__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__3"


    // $ANTLR start "rule__TechnologySpecificDataStructure__Group__3__Impl"
    // InternalTechnologyDsl.g:3674:1: rule__TechnologySpecificDataStructure__Group__3__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificDataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3678:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3679:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3679:1: ( ';' )
            // InternalTechnologyDsl.g:3680:2: ';'
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getSemicolonKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificDataStructureAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__Group__3__Impl"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group__0"
    // InternalTechnologyDsl.g:3690:1: rule__PossiblyImportedTechnologySpecificType__Group__0 : rule__PossiblyImportedTechnologySpecificType__Group__0__Impl rule__PossiblyImportedTechnologySpecificType__Group__1 ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3694:1: ( rule__PossiblyImportedTechnologySpecificType__Group__0__Impl rule__PossiblyImportedTechnologySpecificType__Group__1 )
            // InternalTechnologyDsl.g:3695:2: rule__PossiblyImportedTechnologySpecificType__Group__0__Impl rule__PossiblyImportedTechnologySpecificType__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__PossiblyImportedTechnologySpecificType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group__0"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group__0__Impl"
    // InternalTechnologyDsl.g:3702:1: rule__PossiblyImportedTechnologySpecificType__Group__0__Impl : ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3706:1: ( ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? ) )
            // InternalTechnologyDsl.g:3707:1: ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? )
            {
            // InternalTechnologyDsl.g:3707:1: ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? )
            // InternalTechnologyDsl.g:3708:2: ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )?
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup_0()); 
            // InternalTechnologyDsl.g:3709:2: ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==55) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalTechnologyDsl.g:3709:3: rule__PossiblyImportedTechnologySpecificType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PossiblyImportedTechnologySpecificType__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group__0__Impl"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group__1"
    // InternalTechnologyDsl.g:3717:1: rule__PossiblyImportedTechnologySpecificType__Group__1 : rule__PossiblyImportedTechnologySpecificType__Group__1__Impl ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3721:1: ( rule__PossiblyImportedTechnologySpecificType__Group__1__Impl )
            // InternalTechnologyDsl.g:3722:2: rule__PossiblyImportedTechnologySpecificType__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group__1"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group__1__Impl"
    // InternalTechnologyDsl.g:3728:1: rule__PossiblyImportedTechnologySpecificType__Group__1__Impl : ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3732:1: ( ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) ) )
            // InternalTechnologyDsl.g:3733:1: ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:3733:1: ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) )
            // InternalTechnologyDsl.g:3734:2: ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeAssignment_1()); 
            // InternalTechnologyDsl.g:3735:2: ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 )
            // InternalTechnologyDsl.g:3735:3: rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group__1__Impl"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group_0__0"
    // InternalTechnologyDsl.g:3744:1: rule__PossiblyImportedTechnologySpecificType__Group_0__0 : rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl rule__PossiblyImportedTechnologySpecificType__Group_0__1 ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3748:1: ( rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl rule__PossiblyImportedTechnologySpecificType__Group_0__1 )
            // InternalTechnologyDsl.g:3749:2: rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl rule__PossiblyImportedTechnologySpecificType__Group_0__1
            {
            pushFollow(FOLLOW_37);
            rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group_0__0"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl"
    // InternalTechnologyDsl.g:3756:1: rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl : ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3760:1: ( ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) ) )
            // InternalTechnologyDsl.g:3761:1: ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) )
            {
            // InternalTechnologyDsl.g:3761:1: ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) )
            // InternalTechnologyDsl.g:3762:2: ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportAssignment_0_0()); 
            // InternalTechnologyDsl.g:3763:2: ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 )
            // InternalTechnologyDsl.g:3763:3: rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group_0__1"
    // InternalTechnologyDsl.g:3771:1: rule__PossiblyImportedTechnologySpecificType__Group_0__1 : rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3775:1: ( rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl )
            // InternalTechnologyDsl.g:3776:2: rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group_0__1"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl"
    // InternalTechnologyDsl.g:3782:1: rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl : ( '::' ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3786:1: ( ( '::' ) )
            // InternalTechnologyDsl.g:3787:1: ( '::' )
            {
            // InternalTechnologyDsl.g:3787:1: ( '::' )
            // InternalTechnologyDsl.g:3788:2: '::'
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__0"
    // InternalTechnologyDsl.g:3798:1: rule__CompatibilityMatrixEntry__Group__0 : rule__CompatibilityMatrixEntry__Group__0__Impl rule__CompatibilityMatrixEntry__Group__1 ;
    public final void rule__CompatibilityMatrixEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3802:1: ( rule__CompatibilityMatrixEntry__Group__0__Impl rule__CompatibilityMatrixEntry__Group__1 )
            // InternalTechnologyDsl.g:3803:2: rule__CompatibilityMatrixEntry__Group__0__Impl rule__CompatibilityMatrixEntry__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__CompatibilityMatrixEntry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__0"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__0__Impl"
    // InternalTechnologyDsl.g:3810:1: rule__CompatibilityMatrixEntry__Group__0__Impl : ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3814:1: ( ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) ) )
            // InternalTechnologyDsl.g:3815:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:3815:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) )
            // InternalTechnologyDsl.g:3816:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_0()); 
            // InternalTechnologyDsl.g:3817:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 )
            // InternalTechnologyDsl.g:3817:3: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__0__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__1"
    // InternalTechnologyDsl.g:3825:1: rule__CompatibilityMatrixEntry__Group__1 : rule__CompatibilityMatrixEntry__Group__1__Impl rule__CompatibilityMatrixEntry__Group__2 ;
    public final void rule__CompatibilityMatrixEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3829:1: ( rule__CompatibilityMatrixEntry__Group__1__Impl rule__CompatibilityMatrixEntry__Group__2 )
            // InternalTechnologyDsl.g:3830:2: rule__CompatibilityMatrixEntry__Group__1__Impl rule__CompatibilityMatrixEntry__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__CompatibilityMatrixEntry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__1"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__1__Impl"
    // InternalTechnologyDsl.g:3837:1: rule__CompatibilityMatrixEntry__Group__1__Impl : ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* ) ;
    public final void rule__CompatibilityMatrixEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3841:1: ( ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* ) )
            // InternalTechnologyDsl.g:3842:1: ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* )
            {
            // InternalTechnologyDsl.g:3842:1: ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* )
            // InternalTechnologyDsl.g:3843:2: ( rule__CompatibilityMatrixEntry__Group_1__0 )*
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup_1()); 
            // InternalTechnologyDsl.g:3844:2: ( rule__CompatibilityMatrixEntry__Group_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==46) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3844:3: rule__CompatibilityMatrixEntry__Group_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__CompatibilityMatrixEntry__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__1__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__2"
    // InternalTechnologyDsl.g:3852:1: rule__CompatibilityMatrixEntry__Group__2 : rule__CompatibilityMatrixEntry__Group__2__Impl rule__CompatibilityMatrixEntry__Group__3 ;
    public final void rule__CompatibilityMatrixEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3856:1: ( rule__CompatibilityMatrixEntry__Group__2__Impl rule__CompatibilityMatrixEntry__Group__3 )
            // InternalTechnologyDsl.g:3857:2: rule__CompatibilityMatrixEntry__Group__2__Impl rule__CompatibilityMatrixEntry__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__CompatibilityMatrixEntry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__2"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__2__Impl"
    // InternalTechnologyDsl.g:3864:1: rule__CompatibilityMatrixEntry__Group__2__Impl : ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3868:1: ( ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3869:1: ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3869:1: ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) )
            // InternalTechnologyDsl.g:3870:2: ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionAssignment_2()); 
            // InternalTechnologyDsl.g:3871:2: ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 )
            // InternalTechnologyDsl.g:3871:3: rule__CompatibilityMatrixEntry__DirectionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__DirectionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__2__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__3"
    // InternalTechnologyDsl.g:3879:1: rule__CompatibilityMatrixEntry__Group__3 : rule__CompatibilityMatrixEntry__Group__3__Impl rule__CompatibilityMatrixEntry__Group__4 ;
    public final void rule__CompatibilityMatrixEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3883:1: ( rule__CompatibilityMatrixEntry__Group__3__Impl rule__CompatibilityMatrixEntry__Group__4 )
            // InternalTechnologyDsl.g:3884:2: rule__CompatibilityMatrixEntry__Group__3__Impl rule__CompatibilityMatrixEntry__Group__4
            {
            pushFollow(FOLLOW_36);
            rule__CompatibilityMatrixEntry__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__3"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__3__Impl"
    // InternalTechnologyDsl.g:3891:1: rule__CompatibilityMatrixEntry__Group__3__Impl : ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3895:1: ( ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) ) )
            // InternalTechnologyDsl.g:3896:1: ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:3896:1: ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) )
            // InternalTechnologyDsl.g:3897:2: ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypeAssignment_3()); 
            // InternalTechnologyDsl.g:3898:2: ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 )
            // InternalTechnologyDsl.g:3898:3: rule__CompatibilityMatrixEntry__MappingTypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__MappingTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__3__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__4"
    // InternalTechnologyDsl.g:3906:1: rule__CompatibilityMatrixEntry__Group__4 : rule__CompatibilityMatrixEntry__Group__4__Impl ;
    public final void rule__CompatibilityMatrixEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3910:1: ( rule__CompatibilityMatrixEntry__Group__4__Impl )
            // InternalTechnologyDsl.g:3911:2: rule__CompatibilityMatrixEntry__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__4"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group__4__Impl"
    // InternalTechnologyDsl.g:3917:1: rule__CompatibilityMatrixEntry__Group__4__Impl : ( ';' ) ;
    public final void rule__CompatibilityMatrixEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3921:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3922:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3922:1: ( ';' )
            // InternalTechnologyDsl.g:3923:2: ';'
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getSemicolonKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getCompatibilityMatrixEntryAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group__4__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group_1__0"
    // InternalTechnologyDsl.g:3933:1: rule__CompatibilityMatrixEntry__Group_1__0 : rule__CompatibilityMatrixEntry__Group_1__0__Impl rule__CompatibilityMatrixEntry__Group_1__1 ;
    public final void rule__CompatibilityMatrixEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3937:1: ( rule__CompatibilityMatrixEntry__Group_1__0__Impl rule__CompatibilityMatrixEntry__Group_1__1 )
            // InternalTechnologyDsl.g:3938:2: rule__CompatibilityMatrixEntry__Group_1__0__Impl rule__CompatibilityMatrixEntry__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__CompatibilityMatrixEntry__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group_1__0"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group_1__0__Impl"
    // InternalTechnologyDsl.g:3945:1: rule__CompatibilityMatrixEntry__Group_1__0__Impl : ( ',' ) ;
    public final void rule__CompatibilityMatrixEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3949:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:3950:1: ( ',' )
            {
            // InternalTechnologyDsl.g:3950:1: ( ',' )
            // InternalTechnologyDsl.g:3951:2: ','
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getCompatibilityMatrixEntryAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group_1__0__Impl"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group_1__1"
    // InternalTechnologyDsl.g:3960:1: rule__CompatibilityMatrixEntry__Group_1__1 : rule__CompatibilityMatrixEntry__Group_1__1__Impl ;
    public final void rule__CompatibilityMatrixEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3964:1: ( rule__CompatibilityMatrixEntry__Group_1__1__Impl )
            // InternalTechnologyDsl.g:3965:2: rule__CompatibilityMatrixEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group_1__1"


    // $ANTLR start "rule__CompatibilityMatrixEntry__Group_1__1__Impl"
    // InternalTechnologyDsl.g:3971:1: rule__CompatibilityMatrixEntry__Group_1__1__Impl : ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3975:1: ( ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) ) )
            // InternalTechnologyDsl.g:3976:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) )
            {
            // InternalTechnologyDsl.g:3976:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) )
            // InternalTechnologyDsl.g:3977:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_1_1()); 
            // InternalTechnologyDsl.g:3978:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 )
            // InternalTechnologyDsl.g:3978:3: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__Group_1__1__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__0"
    // InternalTechnologyDsl.g:3987:1: rule__DeploymentTechnology__Group__0 : rule__DeploymentTechnology__Group__0__Impl rule__DeploymentTechnology__Group__1 ;
    public final void rule__DeploymentTechnology__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3991:1: ( rule__DeploymentTechnology__Group__0__Impl rule__DeploymentTechnology__Group__1 )
            // InternalTechnologyDsl.g:3992:2: rule__DeploymentTechnology__Group__0__Impl rule__DeploymentTechnology__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__DeploymentTechnology__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__0"


    // $ANTLR start "rule__DeploymentTechnology__Group__0__Impl"
    // InternalTechnologyDsl.g:3999:1: rule__DeploymentTechnology__Group__0__Impl : ( ( rule__DeploymentTechnology__NameAssignment_0 ) ) ;
    public final void rule__DeploymentTechnology__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4003:1: ( ( ( rule__DeploymentTechnology__NameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4004:1: ( ( rule__DeploymentTechnology__NameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4004:1: ( ( rule__DeploymentTechnology__NameAssignment_0 ) )
            // InternalTechnologyDsl.g:4005:2: ( rule__DeploymentTechnology__NameAssignment_0 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getNameAssignment_0()); 
            // InternalTechnologyDsl.g:4006:2: ( rule__DeploymentTechnology__NameAssignment_0 )
            // InternalTechnologyDsl.g:4006:3: rule__DeploymentTechnology__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeploymentTechnologyAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__0__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__1"
    // InternalTechnologyDsl.g:4014:1: rule__DeploymentTechnology__Group__1 : rule__DeploymentTechnology__Group__1__Impl rule__DeploymentTechnology__Group__2 ;
    public final void rule__DeploymentTechnology__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4018:1: ( rule__DeploymentTechnology__Group__1__Impl rule__DeploymentTechnology__Group__2 )
            // InternalTechnologyDsl.g:4019:2: rule__DeploymentTechnology__Group__1__Impl rule__DeploymentTechnology__Group__2
            {
            pushFollow(FOLLOW_39);
            rule__DeploymentTechnology__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__1"


    // $ANTLR start "rule__DeploymentTechnology__Group__1__Impl"
    // InternalTechnologyDsl.g:4026:1: rule__DeploymentTechnology__Group__1__Impl : ( '{' ) ;
    public final void rule__DeploymentTechnology__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4030:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4031:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4031:1: ( '{' )
            // InternalTechnologyDsl.g:4032:2: '{'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__1__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__2"
    // InternalTechnologyDsl.g:4041:1: rule__DeploymentTechnology__Group__2 : rule__DeploymentTechnology__Group__2__Impl rule__DeploymentTechnology__Group__3 ;
    public final void rule__DeploymentTechnology__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4045:1: ( rule__DeploymentTechnology__Group__2__Impl rule__DeploymentTechnology__Group__3 )
            // InternalTechnologyDsl.g:4046:2: rule__DeploymentTechnology__Group__2__Impl rule__DeploymentTechnology__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__DeploymentTechnology__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__2"


    // $ANTLR start "rule__DeploymentTechnology__Group__2__Impl"
    // InternalTechnologyDsl.g:4053:1: rule__DeploymentTechnology__Group__2__Impl : ( 'operation' ) ;
    public final void rule__DeploymentTechnology__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4057:1: ( ( 'operation' ) )
            // InternalTechnologyDsl.g:4058:1: ( 'operation' )
            {
            // InternalTechnologyDsl.g:4058:1: ( 'operation' )
            // InternalTechnologyDsl.g:4059:2: 'operation'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getOperationKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__2__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__3"
    // InternalTechnologyDsl.g:4068:1: rule__DeploymentTechnology__Group__3 : rule__DeploymentTechnology__Group__3__Impl rule__DeploymentTechnology__Group__4 ;
    public final void rule__DeploymentTechnology__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4072:1: ( rule__DeploymentTechnology__Group__3__Impl rule__DeploymentTechnology__Group__4 )
            // InternalTechnologyDsl.g:4073:2: rule__DeploymentTechnology__Group__3__Impl rule__DeploymentTechnology__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__DeploymentTechnology__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__3"


    // $ANTLR start "rule__DeploymentTechnology__Group__3__Impl"
    // InternalTechnologyDsl.g:4080:1: rule__DeploymentTechnology__Group__3__Impl : ( 'environments' ) ;
    public final void rule__DeploymentTechnology__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4084:1: ( ( 'environments' ) )
            // InternalTechnologyDsl.g:4085:1: ( 'environments' )
            {
            // InternalTechnologyDsl.g:4085:1: ( 'environments' )
            // InternalTechnologyDsl.g:4086:2: 'environments'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getEnvironmentsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__3__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__4"
    // InternalTechnologyDsl.g:4095:1: rule__DeploymentTechnology__Group__4 : rule__DeploymentTechnology__Group__4__Impl rule__DeploymentTechnology__Group__5 ;
    public final void rule__DeploymentTechnology__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4099:1: ( rule__DeploymentTechnology__Group__4__Impl rule__DeploymentTechnology__Group__5 )
            // InternalTechnologyDsl.g:4100:2: rule__DeploymentTechnology__Group__4__Impl rule__DeploymentTechnology__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__DeploymentTechnology__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__4"


    // $ANTLR start "rule__DeploymentTechnology__Group__4__Impl"
    // InternalTechnologyDsl.g:4107:1: rule__DeploymentTechnology__Group__4__Impl : ( '=' ) ;
    public final void rule__DeploymentTechnology__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4111:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:4112:1: ( '=' )
            {
            // InternalTechnologyDsl.g:4112:1: ( '=' )
            // InternalTechnologyDsl.g:4113:2: '='
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getEqualsSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__4__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__5"
    // InternalTechnologyDsl.g:4122:1: rule__DeploymentTechnology__Group__5 : rule__DeploymentTechnology__Group__5__Impl rule__DeploymentTechnology__Group__6 ;
    public final void rule__DeploymentTechnology__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4126:1: ( rule__DeploymentTechnology__Group__5__Impl rule__DeploymentTechnology__Group__6 )
            // InternalTechnologyDsl.g:4127:2: rule__DeploymentTechnology__Group__5__Impl rule__DeploymentTechnology__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__DeploymentTechnology__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__5"


    // $ANTLR start "rule__DeploymentTechnology__Group__5__Impl"
    // InternalTechnologyDsl.g:4134:1: rule__DeploymentTechnology__Group__5__Impl : ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) ) ;
    public final void rule__DeploymentTechnology__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4138:1: ( ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) ) )
            // InternalTechnologyDsl.g:4139:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:4139:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) )
            // InternalTechnologyDsl.g:4140:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_5()); 
            // InternalTechnologyDsl.g:4141:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 )
            // InternalTechnologyDsl.g:4141:3: rule__DeploymentTechnology__OperationEnvironmentsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__OperationEnvironmentsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__5__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__6"
    // InternalTechnologyDsl.g:4149:1: rule__DeploymentTechnology__Group__6 : rule__DeploymentTechnology__Group__6__Impl rule__DeploymentTechnology__Group__7 ;
    public final void rule__DeploymentTechnology__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4153:1: ( rule__DeploymentTechnology__Group__6__Impl rule__DeploymentTechnology__Group__7 )
            // InternalTechnologyDsl.g:4154:2: rule__DeploymentTechnology__Group__6__Impl rule__DeploymentTechnology__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__DeploymentTechnology__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__6"


    // $ANTLR start "rule__DeploymentTechnology__Group__6__Impl"
    // InternalTechnologyDsl.g:4161:1: rule__DeploymentTechnology__Group__6__Impl : ( ( rule__DeploymentTechnology__Group_6__0 )* ) ;
    public final void rule__DeploymentTechnology__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4165:1: ( ( ( rule__DeploymentTechnology__Group_6__0 )* ) )
            // InternalTechnologyDsl.g:4166:1: ( ( rule__DeploymentTechnology__Group_6__0 )* )
            {
            // InternalTechnologyDsl.g:4166:1: ( ( rule__DeploymentTechnology__Group_6__0 )* )
            // InternalTechnologyDsl.g:4167:2: ( rule__DeploymentTechnology__Group_6__0 )*
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:4168:2: ( rule__DeploymentTechnology__Group_6__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==46) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4168:3: rule__DeploymentTechnology__Group_6__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__DeploymentTechnology__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getDeploymentTechnologyAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__6__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__7"
    // InternalTechnologyDsl.g:4176:1: rule__DeploymentTechnology__Group__7 : rule__DeploymentTechnology__Group__7__Impl rule__DeploymentTechnology__Group__8 ;
    public final void rule__DeploymentTechnology__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4180:1: ( rule__DeploymentTechnology__Group__7__Impl rule__DeploymentTechnology__Group__8 )
            // InternalTechnologyDsl.g:4181:2: rule__DeploymentTechnology__Group__7__Impl rule__DeploymentTechnology__Group__8
            {
            pushFollow(FOLLOW_43);
            rule__DeploymentTechnology__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__7"


    // $ANTLR start "rule__DeploymentTechnology__Group__7__Impl"
    // InternalTechnologyDsl.g:4188:1: rule__DeploymentTechnology__Group__7__Impl : ( ';' ) ;
    public final void rule__DeploymentTechnology__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4192:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:4193:1: ( ';' )
            {
            // InternalTechnologyDsl.g:4193:1: ( ';' )
            // InternalTechnologyDsl.g:4194:2: ';'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__7__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__8"
    // InternalTechnologyDsl.g:4203:1: rule__DeploymentTechnology__Group__8 : rule__DeploymentTechnology__Group__8__Impl rule__DeploymentTechnology__Group__9 ;
    public final void rule__DeploymentTechnology__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4207:1: ( rule__DeploymentTechnology__Group__8__Impl rule__DeploymentTechnology__Group__9 )
            // InternalTechnologyDsl.g:4208:2: rule__DeploymentTechnology__Group__8__Impl rule__DeploymentTechnology__Group__9
            {
            pushFollow(FOLLOW_43);
            rule__DeploymentTechnology__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__8"


    // $ANTLR start "rule__DeploymentTechnology__Group__8__Impl"
    // InternalTechnologyDsl.g:4215:1: rule__DeploymentTechnology__Group__8__Impl : ( ( rule__DeploymentTechnology__Group_8__0 )? ) ;
    public final void rule__DeploymentTechnology__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4219:1: ( ( ( rule__DeploymentTechnology__Group_8__0 )? ) )
            // InternalTechnologyDsl.g:4220:1: ( ( rule__DeploymentTechnology__Group_8__0 )? )
            {
            // InternalTechnologyDsl.g:4220:1: ( ( rule__DeploymentTechnology__Group_8__0 )? )
            // InternalTechnologyDsl.g:4221:2: ( rule__DeploymentTechnology__Group_8__0 )?
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getGroup_8()); 
            // InternalTechnologyDsl.g:4222:2: ( rule__DeploymentTechnology__Group_8__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==36) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTechnologyDsl.g:4222:3: rule__DeploymentTechnology__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DeploymentTechnology__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeploymentTechnologyAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__8__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group__9"
    // InternalTechnologyDsl.g:4230:1: rule__DeploymentTechnology__Group__9 : rule__DeploymentTechnology__Group__9__Impl ;
    public final void rule__DeploymentTechnology__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4234:1: ( rule__DeploymentTechnology__Group__9__Impl )
            // InternalTechnologyDsl.g:4235:2: rule__DeploymentTechnology__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__9"


    // $ANTLR start "rule__DeploymentTechnology__Group__9__Impl"
    // InternalTechnologyDsl.g:4241:1: rule__DeploymentTechnology__Group__9__Impl : ( '}' ) ;
    public final void rule__DeploymentTechnology__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4245:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4246:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4246:1: ( '}' )
            // InternalTechnologyDsl.g:4247:2: '}'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_9()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group__9__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_6__0"
    // InternalTechnologyDsl.g:4257:1: rule__DeploymentTechnology__Group_6__0 : rule__DeploymentTechnology__Group_6__0__Impl rule__DeploymentTechnology__Group_6__1 ;
    public final void rule__DeploymentTechnology__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4261:1: ( rule__DeploymentTechnology__Group_6__0__Impl rule__DeploymentTechnology__Group_6__1 )
            // InternalTechnologyDsl.g:4262:2: rule__DeploymentTechnology__Group_6__0__Impl rule__DeploymentTechnology__Group_6__1
            {
            pushFollow(FOLLOW_23);
            rule__DeploymentTechnology__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_6__0"


    // $ANTLR start "rule__DeploymentTechnology__Group_6__0__Impl"
    // InternalTechnologyDsl.g:4269:1: rule__DeploymentTechnology__Group_6__0__Impl : ( ',' ) ;
    public final void rule__DeploymentTechnology__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4273:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:4274:1: ( ',' )
            {
            // InternalTechnologyDsl.g:4274:1: ( ',' )
            // InternalTechnologyDsl.g:4275:2: ','
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_6__0__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_6__1"
    // InternalTechnologyDsl.g:4284:1: rule__DeploymentTechnology__Group_6__1 : rule__DeploymentTechnology__Group_6__1__Impl ;
    public final void rule__DeploymentTechnology__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4288:1: ( rule__DeploymentTechnology__Group_6__1__Impl )
            // InternalTechnologyDsl.g:4289:2: rule__DeploymentTechnology__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_6__1"


    // $ANTLR start "rule__DeploymentTechnology__Group_6__1__Impl"
    // InternalTechnologyDsl.g:4295:1: rule__DeploymentTechnology__Group_6__1__Impl : ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) ) ;
    public final void rule__DeploymentTechnology__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4299:1: ( ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) ) )
            // InternalTechnologyDsl.g:4300:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) )
            {
            // InternalTechnologyDsl.g:4300:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) )
            // InternalTechnologyDsl.g:4301:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_6_1()); 
            // InternalTechnologyDsl.g:4302:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 )
            // InternalTechnologyDsl.g:4302:3: rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_6__1__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__0"
    // InternalTechnologyDsl.g:4311:1: rule__DeploymentTechnology__Group_8__0 : rule__DeploymentTechnology__Group_8__0__Impl rule__DeploymentTechnology__Group_8__1 ;
    public final void rule__DeploymentTechnology__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4315:1: ( rule__DeploymentTechnology__Group_8__0__Impl rule__DeploymentTechnology__Group_8__1 )
            // InternalTechnologyDsl.g:4316:2: rule__DeploymentTechnology__Group_8__0__Impl rule__DeploymentTechnology__Group_8__1
            {
            pushFollow(FOLLOW_44);
            rule__DeploymentTechnology__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__0"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__0__Impl"
    // InternalTechnologyDsl.g:4323:1: rule__DeploymentTechnology__Group_8__0__Impl : ( 'service' ) ;
    public final void rule__DeploymentTechnology__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4327:1: ( ( 'service' ) )
            // InternalTechnologyDsl.g:4328:1: ( 'service' )
            {
            // InternalTechnologyDsl.g:4328:1: ( 'service' )
            // InternalTechnologyDsl.g:4329:2: 'service'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getServiceKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__0__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__1"
    // InternalTechnologyDsl.g:4338:1: rule__DeploymentTechnology__Group_8__1 : rule__DeploymentTechnology__Group_8__1__Impl rule__DeploymentTechnology__Group_8__2 ;
    public final void rule__DeploymentTechnology__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4342:1: ( rule__DeploymentTechnology__Group_8__1__Impl rule__DeploymentTechnology__Group_8__2 )
            // InternalTechnologyDsl.g:4343:2: rule__DeploymentTechnology__Group_8__1__Impl rule__DeploymentTechnology__Group_8__2
            {
            pushFollow(FOLLOW_8);
            rule__DeploymentTechnology__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__1"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__1__Impl"
    // InternalTechnologyDsl.g:4350:1: rule__DeploymentTechnology__Group_8__1__Impl : ( 'properties' ) ;
    public final void rule__DeploymentTechnology__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4354:1: ( ( 'properties' ) )
            // InternalTechnologyDsl.g:4355:1: ( 'properties' )
            {
            // InternalTechnologyDsl.g:4355:1: ( 'properties' )
            // InternalTechnologyDsl.g:4356:2: 'properties'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getPropertiesKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__1__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__2"
    // InternalTechnologyDsl.g:4365:1: rule__DeploymentTechnology__Group_8__2 : rule__DeploymentTechnology__Group_8__2__Impl rule__DeploymentTechnology__Group_8__3 ;
    public final void rule__DeploymentTechnology__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4369:1: ( rule__DeploymentTechnology__Group_8__2__Impl rule__DeploymentTechnology__Group_8__3 )
            // InternalTechnologyDsl.g:4370:2: rule__DeploymentTechnology__Group_8__2__Impl rule__DeploymentTechnology__Group_8__3
            {
            pushFollow(FOLLOW_34);
            rule__DeploymentTechnology__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__2"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__2__Impl"
    // InternalTechnologyDsl.g:4377:1: rule__DeploymentTechnology__Group_8__2__Impl : ( '{' ) ;
    public final void rule__DeploymentTechnology__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4381:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4382:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4382:1: ( '{' )
            // InternalTechnologyDsl.g:4383:2: '{'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__2__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__3"
    // InternalTechnologyDsl.g:4392:1: rule__DeploymentTechnology__Group_8__3 : rule__DeploymentTechnology__Group_8__3__Impl rule__DeploymentTechnology__Group_8__4 ;
    public final void rule__DeploymentTechnology__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4396:1: ( rule__DeploymentTechnology__Group_8__3__Impl rule__DeploymentTechnology__Group_8__4 )
            // InternalTechnologyDsl.g:4397:2: rule__DeploymentTechnology__Group_8__3__Impl rule__DeploymentTechnology__Group_8__4
            {
            pushFollow(FOLLOW_14);
            rule__DeploymentTechnology__Group_8__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_8__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__3"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__3__Impl"
    // InternalTechnologyDsl.g:4404:1: rule__DeploymentTechnology__Group_8__3__Impl : ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) ) ;
    public final void rule__DeploymentTechnology__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4408:1: ( ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) ) )
            // InternalTechnologyDsl.g:4409:1: ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) )
            {
            // InternalTechnologyDsl.g:4409:1: ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) )
            // InternalTechnologyDsl.g:4410:2: ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* )
            {
            // InternalTechnologyDsl.g:4410:2: ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) )
            // InternalTechnologyDsl.g:4411:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4412:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )
            // InternalTechnologyDsl.g:4412:4: rule__DeploymentTechnology__ServicePropertiesAssignment_8_3
            {
            pushFollow(FOLLOW_45);
            rule__DeploymentTechnology__ServicePropertiesAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 

            }

            // InternalTechnologyDsl.g:4415:2: ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* )
            // InternalTechnologyDsl.g:4416:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )*
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4417:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=69 && LA43_0<=78)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4417:4: rule__DeploymentTechnology__ServicePropertiesAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__DeploymentTechnology__ServicePropertiesAssignment_8_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 

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
    // $ANTLR end "rule__DeploymentTechnology__Group_8__3__Impl"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__4"
    // InternalTechnologyDsl.g:4426:1: rule__DeploymentTechnology__Group_8__4 : rule__DeploymentTechnology__Group_8__4__Impl ;
    public final void rule__DeploymentTechnology__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4430:1: ( rule__DeploymentTechnology__Group_8__4__Impl )
            // InternalTechnologyDsl.g:4431:2: rule__DeploymentTechnology__Group_8__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeploymentTechnology__Group_8__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__4"


    // $ANTLR start "rule__DeploymentTechnology__Group_8__4__Impl"
    // InternalTechnologyDsl.g:4437:1: rule__DeploymentTechnology__Group_8__4__Impl : ( '}' ) ;
    public final void rule__DeploymentTechnology__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4441:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4442:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4442:1: ( '}' )
            // InternalTechnologyDsl.g:4443:2: '}'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__Group_8__4__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__0"
    // InternalTechnologyDsl.g:4453:1: rule__InfrastructureTechnology__Group__0 : rule__InfrastructureTechnology__Group__0__Impl rule__InfrastructureTechnology__Group__1 ;
    public final void rule__InfrastructureTechnology__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4457:1: ( rule__InfrastructureTechnology__Group__0__Impl rule__InfrastructureTechnology__Group__1 )
            // InternalTechnologyDsl.g:4458:2: rule__InfrastructureTechnology__Group__0__Impl rule__InfrastructureTechnology__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__InfrastructureTechnology__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__0"


    // $ANTLR start "rule__InfrastructureTechnology__Group__0__Impl"
    // InternalTechnologyDsl.g:4465:1: rule__InfrastructureTechnology__Group__0__Impl : ( ( rule__InfrastructureTechnology__NameAssignment_0 ) ) ;
    public final void rule__InfrastructureTechnology__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4469:1: ( ( ( rule__InfrastructureTechnology__NameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4470:1: ( ( rule__InfrastructureTechnology__NameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4470:1: ( ( rule__InfrastructureTechnology__NameAssignment_0 ) )
            // InternalTechnologyDsl.g:4471:2: ( rule__InfrastructureTechnology__NameAssignment_0 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getNameAssignment_0()); 
            // InternalTechnologyDsl.g:4472:2: ( rule__InfrastructureTechnology__NameAssignment_0 )
            // InternalTechnologyDsl.g:4472:3: rule__InfrastructureTechnology__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__0__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__1"
    // InternalTechnologyDsl.g:4480:1: rule__InfrastructureTechnology__Group__1 : rule__InfrastructureTechnology__Group__1__Impl rule__InfrastructureTechnology__Group__2 ;
    public final void rule__InfrastructureTechnology__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4484:1: ( rule__InfrastructureTechnology__Group__1__Impl rule__InfrastructureTechnology__Group__2 )
            // InternalTechnologyDsl.g:4485:2: rule__InfrastructureTechnology__Group__1__Impl rule__InfrastructureTechnology__Group__2
            {
            pushFollow(FOLLOW_39);
            rule__InfrastructureTechnology__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__1"


    // $ANTLR start "rule__InfrastructureTechnology__Group__1__Impl"
    // InternalTechnologyDsl.g:4492:1: rule__InfrastructureTechnology__Group__1__Impl : ( '{' ) ;
    public final void rule__InfrastructureTechnology__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4496:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4497:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4497:1: ( '{' )
            // InternalTechnologyDsl.g:4498:2: '{'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__1__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__2"
    // InternalTechnologyDsl.g:4507:1: rule__InfrastructureTechnology__Group__2 : rule__InfrastructureTechnology__Group__2__Impl rule__InfrastructureTechnology__Group__3 ;
    public final void rule__InfrastructureTechnology__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4511:1: ( rule__InfrastructureTechnology__Group__2__Impl rule__InfrastructureTechnology__Group__3 )
            // InternalTechnologyDsl.g:4512:2: rule__InfrastructureTechnology__Group__2__Impl rule__InfrastructureTechnology__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__InfrastructureTechnology__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__2"


    // $ANTLR start "rule__InfrastructureTechnology__Group__2__Impl"
    // InternalTechnologyDsl.g:4519:1: rule__InfrastructureTechnology__Group__2__Impl : ( 'operation' ) ;
    public final void rule__InfrastructureTechnology__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4523:1: ( ( 'operation' ) )
            // InternalTechnologyDsl.g:4524:1: ( 'operation' )
            {
            // InternalTechnologyDsl.g:4524:1: ( 'operation' )
            // InternalTechnologyDsl.g:4525:2: 'operation'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getOperationKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__2__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__3"
    // InternalTechnologyDsl.g:4534:1: rule__InfrastructureTechnology__Group__3 : rule__InfrastructureTechnology__Group__3__Impl rule__InfrastructureTechnology__Group__4 ;
    public final void rule__InfrastructureTechnology__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4538:1: ( rule__InfrastructureTechnology__Group__3__Impl rule__InfrastructureTechnology__Group__4 )
            // InternalTechnologyDsl.g:4539:2: rule__InfrastructureTechnology__Group__3__Impl rule__InfrastructureTechnology__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__InfrastructureTechnology__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__3"


    // $ANTLR start "rule__InfrastructureTechnology__Group__3__Impl"
    // InternalTechnologyDsl.g:4546:1: rule__InfrastructureTechnology__Group__3__Impl : ( 'environments' ) ;
    public final void rule__InfrastructureTechnology__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4550:1: ( ( 'environments' ) )
            // InternalTechnologyDsl.g:4551:1: ( 'environments' )
            {
            // InternalTechnologyDsl.g:4551:1: ( 'environments' )
            // InternalTechnologyDsl.g:4552:2: 'environments'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getEnvironmentsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__3__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__4"
    // InternalTechnologyDsl.g:4561:1: rule__InfrastructureTechnology__Group__4 : rule__InfrastructureTechnology__Group__4__Impl rule__InfrastructureTechnology__Group__5 ;
    public final void rule__InfrastructureTechnology__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4565:1: ( rule__InfrastructureTechnology__Group__4__Impl rule__InfrastructureTechnology__Group__5 )
            // InternalTechnologyDsl.g:4566:2: rule__InfrastructureTechnology__Group__4__Impl rule__InfrastructureTechnology__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__InfrastructureTechnology__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__4"


    // $ANTLR start "rule__InfrastructureTechnology__Group__4__Impl"
    // InternalTechnologyDsl.g:4573:1: rule__InfrastructureTechnology__Group__4__Impl : ( '=' ) ;
    public final void rule__InfrastructureTechnology__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4577:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:4578:1: ( '=' )
            {
            // InternalTechnologyDsl.g:4578:1: ( '=' )
            // InternalTechnologyDsl.g:4579:2: '='
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getEqualsSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__4__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__5"
    // InternalTechnologyDsl.g:4588:1: rule__InfrastructureTechnology__Group__5 : rule__InfrastructureTechnology__Group__5__Impl rule__InfrastructureTechnology__Group__6 ;
    public final void rule__InfrastructureTechnology__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4592:1: ( rule__InfrastructureTechnology__Group__5__Impl rule__InfrastructureTechnology__Group__6 )
            // InternalTechnologyDsl.g:4593:2: rule__InfrastructureTechnology__Group__5__Impl rule__InfrastructureTechnology__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__InfrastructureTechnology__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__5"


    // $ANTLR start "rule__InfrastructureTechnology__Group__5__Impl"
    // InternalTechnologyDsl.g:4600:1: rule__InfrastructureTechnology__Group__5__Impl : ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) ) ;
    public final void rule__InfrastructureTechnology__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4604:1: ( ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) ) )
            // InternalTechnologyDsl.g:4605:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:4605:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) )
            // InternalTechnologyDsl.g:4606:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_5()); 
            // InternalTechnologyDsl.g:4607:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 )
            // InternalTechnologyDsl.g:4607:3: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__5__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__6"
    // InternalTechnologyDsl.g:4615:1: rule__InfrastructureTechnology__Group__6 : rule__InfrastructureTechnology__Group__6__Impl rule__InfrastructureTechnology__Group__7 ;
    public final void rule__InfrastructureTechnology__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4619:1: ( rule__InfrastructureTechnology__Group__6__Impl rule__InfrastructureTechnology__Group__7 )
            // InternalTechnologyDsl.g:4620:2: rule__InfrastructureTechnology__Group__6__Impl rule__InfrastructureTechnology__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__InfrastructureTechnology__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__6"


    // $ANTLR start "rule__InfrastructureTechnology__Group__6__Impl"
    // InternalTechnologyDsl.g:4627:1: rule__InfrastructureTechnology__Group__6__Impl : ( ( rule__InfrastructureTechnology__Group_6__0 )* ) ;
    public final void rule__InfrastructureTechnology__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4631:1: ( ( ( rule__InfrastructureTechnology__Group_6__0 )* ) )
            // InternalTechnologyDsl.g:4632:1: ( ( rule__InfrastructureTechnology__Group_6__0 )* )
            {
            // InternalTechnologyDsl.g:4632:1: ( ( rule__InfrastructureTechnology__Group_6__0 )* )
            // InternalTechnologyDsl.g:4633:2: ( rule__InfrastructureTechnology__Group_6__0 )*
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:4634:2: ( rule__InfrastructureTechnology__Group_6__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==46) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4634:3: rule__InfrastructureTechnology__Group_6__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__InfrastructureTechnology__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getInfrastructureTechnologyAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__6__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__7"
    // InternalTechnologyDsl.g:4642:1: rule__InfrastructureTechnology__Group__7 : rule__InfrastructureTechnology__Group__7__Impl rule__InfrastructureTechnology__Group__8 ;
    public final void rule__InfrastructureTechnology__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4646:1: ( rule__InfrastructureTechnology__Group__7__Impl rule__InfrastructureTechnology__Group__8 )
            // InternalTechnologyDsl.g:4647:2: rule__InfrastructureTechnology__Group__7__Impl rule__InfrastructureTechnology__Group__8
            {
            pushFollow(FOLLOW_43);
            rule__InfrastructureTechnology__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__7"


    // $ANTLR start "rule__InfrastructureTechnology__Group__7__Impl"
    // InternalTechnologyDsl.g:4654:1: rule__InfrastructureTechnology__Group__7__Impl : ( ';' ) ;
    public final void rule__InfrastructureTechnology__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4658:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:4659:1: ( ';' )
            {
            // InternalTechnologyDsl.g:4659:1: ( ';' )
            // InternalTechnologyDsl.g:4660:2: ';'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__7__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__8"
    // InternalTechnologyDsl.g:4669:1: rule__InfrastructureTechnology__Group__8 : rule__InfrastructureTechnology__Group__8__Impl rule__InfrastructureTechnology__Group__9 ;
    public final void rule__InfrastructureTechnology__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4673:1: ( rule__InfrastructureTechnology__Group__8__Impl rule__InfrastructureTechnology__Group__9 )
            // InternalTechnologyDsl.g:4674:2: rule__InfrastructureTechnology__Group__8__Impl rule__InfrastructureTechnology__Group__9
            {
            pushFollow(FOLLOW_43);
            rule__InfrastructureTechnology__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__8"


    // $ANTLR start "rule__InfrastructureTechnology__Group__8__Impl"
    // InternalTechnologyDsl.g:4681:1: rule__InfrastructureTechnology__Group__8__Impl : ( ( rule__InfrastructureTechnology__Group_8__0 )? ) ;
    public final void rule__InfrastructureTechnology__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4685:1: ( ( ( rule__InfrastructureTechnology__Group_8__0 )? ) )
            // InternalTechnologyDsl.g:4686:1: ( ( rule__InfrastructureTechnology__Group_8__0 )? )
            {
            // InternalTechnologyDsl.g:4686:1: ( ( rule__InfrastructureTechnology__Group_8__0 )? )
            // InternalTechnologyDsl.g:4687:2: ( rule__InfrastructureTechnology__Group_8__0 )?
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getGroup_8()); 
            // InternalTechnologyDsl.g:4688:2: ( rule__InfrastructureTechnology__Group_8__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==36) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTechnologyDsl.g:4688:3: rule__InfrastructureTechnology__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__InfrastructureTechnology__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__8__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group__9"
    // InternalTechnologyDsl.g:4696:1: rule__InfrastructureTechnology__Group__9 : rule__InfrastructureTechnology__Group__9__Impl ;
    public final void rule__InfrastructureTechnology__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4700:1: ( rule__InfrastructureTechnology__Group__9__Impl )
            // InternalTechnologyDsl.g:4701:2: rule__InfrastructureTechnology__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__9"


    // $ANTLR start "rule__InfrastructureTechnology__Group__9__Impl"
    // InternalTechnologyDsl.g:4707:1: rule__InfrastructureTechnology__Group__9__Impl : ( '}' ) ;
    public final void rule__InfrastructureTechnology__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4711:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4712:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4712:1: ( '}' )
            // InternalTechnologyDsl.g:4713:2: '}'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_9()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group__9__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_6__0"
    // InternalTechnologyDsl.g:4723:1: rule__InfrastructureTechnology__Group_6__0 : rule__InfrastructureTechnology__Group_6__0__Impl rule__InfrastructureTechnology__Group_6__1 ;
    public final void rule__InfrastructureTechnology__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4727:1: ( rule__InfrastructureTechnology__Group_6__0__Impl rule__InfrastructureTechnology__Group_6__1 )
            // InternalTechnologyDsl.g:4728:2: rule__InfrastructureTechnology__Group_6__0__Impl rule__InfrastructureTechnology__Group_6__1
            {
            pushFollow(FOLLOW_23);
            rule__InfrastructureTechnology__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_6__0"


    // $ANTLR start "rule__InfrastructureTechnology__Group_6__0__Impl"
    // InternalTechnologyDsl.g:4735:1: rule__InfrastructureTechnology__Group_6__0__Impl : ( ',' ) ;
    public final void rule__InfrastructureTechnology__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4739:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:4740:1: ( ',' )
            {
            // InternalTechnologyDsl.g:4740:1: ( ',' )
            // InternalTechnologyDsl.g:4741:2: ','
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_6__0__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_6__1"
    // InternalTechnologyDsl.g:4750:1: rule__InfrastructureTechnology__Group_6__1 : rule__InfrastructureTechnology__Group_6__1__Impl ;
    public final void rule__InfrastructureTechnology__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4754:1: ( rule__InfrastructureTechnology__Group_6__1__Impl )
            // InternalTechnologyDsl.g:4755:2: rule__InfrastructureTechnology__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_6__1"


    // $ANTLR start "rule__InfrastructureTechnology__Group_6__1__Impl"
    // InternalTechnologyDsl.g:4761:1: rule__InfrastructureTechnology__Group_6__1__Impl : ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) ) ;
    public final void rule__InfrastructureTechnology__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4765:1: ( ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) ) )
            // InternalTechnologyDsl.g:4766:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) )
            {
            // InternalTechnologyDsl.g:4766:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) )
            // InternalTechnologyDsl.g:4767:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_6_1()); 
            // InternalTechnologyDsl.g:4768:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 )
            // InternalTechnologyDsl.g:4768:3: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_6__1__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__0"
    // InternalTechnologyDsl.g:4777:1: rule__InfrastructureTechnology__Group_8__0 : rule__InfrastructureTechnology__Group_8__0__Impl rule__InfrastructureTechnology__Group_8__1 ;
    public final void rule__InfrastructureTechnology__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4781:1: ( rule__InfrastructureTechnology__Group_8__0__Impl rule__InfrastructureTechnology__Group_8__1 )
            // InternalTechnologyDsl.g:4782:2: rule__InfrastructureTechnology__Group_8__0__Impl rule__InfrastructureTechnology__Group_8__1
            {
            pushFollow(FOLLOW_44);
            rule__InfrastructureTechnology__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__0"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__0__Impl"
    // InternalTechnologyDsl.g:4789:1: rule__InfrastructureTechnology__Group_8__0__Impl : ( 'service' ) ;
    public final void rule__InfrastructureTechnology__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4793:1: ( ( 'service' ) )
            // InternalTechnologyDsl.g:4794:1: ( 'service' )
            {
            // InternalTechnologyDsl.g:4794:1: ( 'service' )
            // InternalTechnologyDsl.g:4795:2: 'service'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getServiceKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__0__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__1"
    // InternalTechnologyDsl.g:4804:1: rule__InfrastructureTechnology__Group_8__1 : rule__InfrastructureTechnology__Group_8__1__Impl rule__InfrastructureTechnology__Group_8__2 ;
    public final void rule__InfrastructureTechnology__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4808:1: ( rule__InfrastructureTechnology__Group_8__1__Impl rule__InfrastructureTechnology__Group_8__2 )
            // InternalTechnologyDsl.g:4809:2: rule__InfrastructureTechnology__Group_8__1__Impl rule__InfrastructureTechnology__Group_8__2
            {
            pushFollow(FOLLOW_8);
            rule__InfrastructureTechnology__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__1"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__1__Impl"
    // InternalTechnologyDsl.g:4816:1: rule__InfrastructureTechnology__Group_8__1__Impl : ( 'properties' ) ;
    public final void rule__InfrastructureTechnology__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4820:1: ( ( 'properties' ) )
            // InternalTechnologyDsl.g:4821:1: ( 'properties' )
            {
            // InternalTechnologyDsl.g:4821:1: ( 'properties' )
            // InternalTechnologyDsl.g:4822:2: 'properties'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getPropertiesKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__1__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__2"
    // InternalTechnologyDsl.g:4831:1: rule__InfrastructureTechnology__Group_8__2 : rule__InfrastructureTechnology__Group_8__2__Impl rule__InfrastructureTechnology__Group_8__3 ;
    public final void rule__InfrastructureTechnology__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4835:1: ( rule__InfrastructureTechnology__Group_8__2__Impl rule__InfrastructureTechnology__Group_8__3 )
            // InternalTechnologyDsl.g:4836:2: rule__InfrastructureTechnology__Group_8__2__Impl rule__InfrastructureTechnology__Group_8__3
            {
            pushFollow(FOLLOW_34);
            rule__InfrastructureTechnology__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__2"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__2__Impl"
    // InternalTechnologyDsl.g:4843:1: rule__InfrastructureTechnology__Group_8__2__Impl : ( '{' ) ;
    public final void rule__InfrastructureTechnology__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4847:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4848:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4848:1: ( '{' )
            // InternalTechnologyDsl.g:4849:2: '{'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__2__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__3"
    // InternalTechnologyDsl.g:4858:1: rule__InfrastructureTechnology__Group_8__3 : rule__InfrastructureTechnology__Group_8__3__Impl rule__InfrastructureTechnology__Group_8__4 ;
    public final void rule__InfrastructureTechnology__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4862:1: ( rule__InfrastructureTechnology__Group_8__3__Impl rule__InfrastructureTechnology__Group_8__4 )
            // InternalTechnologyDsl.g:4863:2: rule__InfrastructureTechnology__Group_8__3__Impl rule__InfrastructureTechnology__Group_8__4
            {
            pushFollow(FOLLOW_14);
            rule__InfrastructureTechnology__Group_8__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_8__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__3"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__3__Impl"
    // InternalTechnologyDsl.g:4870:1: rule__InfrastructureTechnology__Group_8__3__Impl : ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) ) ;
    public final void rule__InfrastructureTechnology__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4874:1: ( ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) ) )
            // InternalTechnologyDsl.g:4875:1: ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) )
            {
            // InternalTechnologyDsl.g:4875:1: ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) )
            // InternalTechnologyDsl.g:4876:2: ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* )
            {
            // InternalTechnologyDsl.g:4876:2: ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) )
            // InternalTechnologyDsl.g:4877:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4878:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )
            // InternalTechnologyDsl.g:4878:4: rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3
            {
            pushFollow(FOLLOW_45);
            rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 

            }

            // InternalTechnologyDsl.g:4881:2: ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* )
            // InternalTechnologyDsl.g:4882:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )*
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4883:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=69 && LA46_0<=78)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4883:4: rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 

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
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__3__Impl"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__4"
    // InternalTechnologyDsl.g:4892:1: rule__InfrastructureTechnology__Group_8__4 : rule__InfrastructureTechnology__Group_8__4__Impl ;
    public final void rule__InfrastructureTechnology__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4896:1: ( rule__InfrastructureTechnology__Group_8__4__Impl )
            // InternalTechnologyDsl.g:4897:2: rule__InfrastructureTechnology__Group_8__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InfrastructureTechnology__Group_8__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__4"


    // $ANTLR start "rule__InfrastructureTechnology__Group_8__4__Impl"
    // InternalTechnologyDsl.g:4903:1: rule__InfrastructureTechnology__Group_8__4__Impl : ( '}' ) ;
    public final void rule__InfrastructureTechnology__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4907:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4908:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4908:1: ( '}' )
            // InternalTechnologyDsl.g:4909:2: '}'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__Group_8__4__Impl"


    // $ANTLR start "rule__OperationEnvironment__Group__0"
    // InternalTechnologyDsl.g:4919:1: rule__OperationEnvironment__Group__0 : rule__OperationEnvironment__Group__0__Impl rule__OperationEnvironment__Group__1 ;
    public final void rule__OperationEnvironment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4923:1: ( rule__OperationEnvironment__Group__0__Impl rule__OperationEnvironment__Group__1 )
            // InternalTechnologyDsl.g:4924:2: rule__OperationEnvironment__Group__0__Impl rule__OperationEnvironment__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__OperationEnvironment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationEnvironment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationEnvironment__Group__0"


    // $ANTLR start "rule__OperationEnvironment__Group__0__Impl"
    // InternalTechnologyDsl.g:4931:1: rule__OperationEnvironment__Group__0__Impl : ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) ) ;
    public final void rule__OperationEnvironment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4935:1: ( ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4936:1: ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4936:1: ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) )
            // InternalTechnologyDsl.g:4937:2: ( rule__OperationEnvironment__EnvironmentNameAssignment_0 )
            {
             before(grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameAssignment_0()); 
            // InternalTechnologyDsl.g:4938:2: ( rule__OperationEnvironment__EnvironmentNameAssignment_0 )
            // InternalTechnologyDsl.g:4938:3: rule__OperationEnvironment__EnvironmentNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OperationEnvironment__EnvironmentNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationEnvironment__Group__0__Impl"


    // $ANTLR start "rule__OperationEnvironment__Group__1"
    // InternalTechnologyDsl.g:4946:1: rule__OperationEnvironment__Group__1 : rule__OperationEnvironment__Group__1__Impl ;
    public final void rule__OperationEnvironment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4950:1: ( rule__OperationEnvironment__Group__1__Impl )
            // InternalTechnologyDsl.g:4951:2: rule__OperationEnvironment__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationEnvironment__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationEnvironment__Group__1"


    // $ANTLR start "rule__OperationEnvironment__Group__1__Impl"
    // InternalTechnologyDsl.g:4957:1: rule__OperationEnvironment__Group__1__Impl : ( ( rule__OperationEnvironment__DefaultAssignment_1 )? ) ;
    public final void rule__OperationEnvironment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4961:1: ( ( ( rule__OperationEnvironment__DefaultAssignment_1 )? ) )
            // InternalTechnologyDsl.g:4962:1: ( ( rule__OperationEnvironment__DefaultAssignment_1 )? )
            {
            // InternalTechnologyDsl.g:4962:1: ( ( rule__OperationEnvironment__DefaultAssignment_1 )? )
            // InternalTechnologyDsl.g:4963:2: ( rule__OperationEnvironment__DefaultAssignment_1 )?
            {
             before(grammarAccess.getOperationEnvironmentAccess().getDefaultAssignment_1()); 
            // InternalTechnologyDsl.g:4964:2: ( rule__OperationEnvironment__DefaultAssignment_1 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==80) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTechnologyDsl.g:4964:3: rule__OperationEnvironment__DefaultAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__OperationEnvironment__DefaultAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationEnvironmentAccess().getDefaultAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationEnvironment__Group__1__Impl"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__0"
    // InternalTechnologyDsl.g:4973:1: rule__TechnologySpecificProperty__Group__0 : rule__TechnologySpecificProperty__Group__0__Impl rule__TechnologySpecificProperty__Group__1 ;
    public final void rule__TechnologySpecificProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4977:1: ( rule__TechnologySpecificProperty__Group__0__Impl rule__TechnologySpecificProperty__Group__1 )
            // InternalTechnologyDsl.g:4978:2: rule__TechnologySpecificProperty__Group__0__Impl rule__TechnologySpecificProperty__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__TechnologySpecificProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__0"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__0__Impl"
    // InternalTechnologyDsl.g:4985:1: rule__TechnologySpecificProperty__Group__0__Impl : ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) ) ;
    public final void rule__TechnologySpecificProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4989:1: ( ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4990:1: ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4990:1: ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) )
            // InternalTechnologyDsl.g:4991:2: ( rule__TechnologySpecificProperty__TypeAssignment_0 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getTypeAssignment_0()); 
            // InternalTechnologyDsl.g:4992:2: ( rule__TechnologySpecificProperty__TypeAssignment_0 )
            // InternalTechnologyDsl.g:4992:3: rule__TechnologySpecificProperty__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPropertyAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__0__Impl"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__1"
    // InternalTechnologyDsl.g:5000:1: rule__TechnologySpecificProperty__Group__1 : rule__TechnologySpecificProperty__Group__1__Impl rule__TechnologySpecificProperty__Group__2 ;
    public final void rule__TechnologySpecificProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5004:1: ( rule__TechnologySpecificProperty__Group__1__Impl rule__TechnologySpecificProperty__Group__2 )
            // InternalTechnologyDsl.g:5005:2: rule__TechnologySpecificProperty__Group__1__Impl rule__TechnologySpecificProperty__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__TechnologySpecificProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__1"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__1__Impl"
    // InternalTechnologyDsl.g:5012:1: rule__TechnologySpecificProperty__Group__1__Impl : ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) ) ;
    public final void rule__TechnologySpecificProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5016:1: ( ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:5017:1: ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:5017:1: ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:5018:2: ( rule__TechnologySpecificProperty__NameAssignment_1 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:5019:2: ( rule__TechnologySpecificProperty__NameAssignment_1 )
            // InternalTechnologyDsl.g:5019:3: rule__TechnologySpecificProperty__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPropertyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__1__Impl"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__2"
    // InternalTechnologyDsl.g:5027:1: rule__TechnologySpecificProperty__Group__2 : rule__TechnologySpecificProperty__Group__2__Impl rule__TechnologySpecificProperty__Group__3 ;
    public final void rule__TechnologySpecificProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5031:1: ( rule__TechnologySpecificProperty__Group__2__Impl rule__TechnologySpecificProperty__Group__3 )
            // InternalTechnologyDsl.g:5032:2: rule__TechnologySpecificProperty__Group__2__Impl rule__TechnologySpecificProperty__Group__3
            {
            pushFollow(FOLLOW_47);
            rule__TechnologySpecificProperty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__2"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__2__Impl"
    // InternalTechnologyDsl.g:5039:1: rule__TechnologySpecificProperty__Group__2__Impl : ( ( rule__TechnologySpecificProperty__Alternatives_2 )? ) ;
    public final void rule__TechnologySpecificProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5043:1: ( ( ( rule__TechnologySpecificProperty__Alternatives_2 )? ) )
            // InternalTechnologyDsl.g:5044:1: ( ( rule__TechnologySpecificProperty__Alternatives_2 )? )
            {
            // InternalTechnologyDsl.g:5044:1: ( ( rule__TechnologySpecificProperty__Alternatives_2 )? )
            // InternalTechnologyDsl.g:5045:2: ( rule__TechnologySpecificProperty__Alternatives_2 )?
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getAlternatives_2()); 
            // InternalTechnologyDsl.g:5046:2: ( rule__TechnologySpecificProperty__Alternatives_2 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==57||LA48_0==81) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalTechnologyDsl.g:5046:3: rule__TechnologySpecificProperty__Alternatives_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__TechnologySpecificProperty__Alternatives_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTechnologySpecificPropertyAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__2__Impl"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__3"
    // InternalTechnologyDsl.g:5054:1: rule__TechnologySpecificProperty__Group__3 : rule__TechnologySpecificProperty__Group__3__Impl ;
    public final void rule__TechnologySpecificProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5058:1: ( rule__TechnologySpecificProperty__Group__3__Impl )
            // InternalTechnologyDsl.g:5059:2: rule__TechnologySpecificProperty__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__3"


    // $ANTLR start "rule__TechnologySpecificProperty__Group__3__Impl"
    // InternalTechnologyDsl.g:5065:1: rule__TechnologySpecificProperty__Group__3__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5069:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:5070:1: ( ';' )
            {
            // InternalTechnologyDsl.g:5070:1: ( ';' )
            // InternalTechnologyDsl.g:5071:2: ';'
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getSemicolonKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPropertyAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group__3__Impl"


    // $ANTLR start "rule__TechnologySpecificProperty__Group_2_0__0"
    // InternalTechnologyDsl.g:5081:1: rule__TechnologySpecificProperty__Group_2_0__0 : rule__TechnologySpecificProperty__Group_2_0__0__Impl rule__TechnologySpecificProperty__Group_2_0__1 ;
    public final void rule__TechnologySpecificProperty__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5085:1: ( rule__TechnologySpecificProperty__Group_2_0__0__Impl rule__TechnologySpecificProperty__Group_2_0__1 )
            // InternalTechnologyDsl.g:5086:2: rule__TechnologySpecificProperty__Group_2_0__0__Impl rule__TechnologySpecificProperty__Group_2_0__1
            {
            pushFollow(FOLLOW_48);
            rule__TechnologySpecificProperty__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group_2_0__0"


    // $ANTLR start "rule__TechnologySpecificProperty__Group_2_0__0__Impl"
    // InternalTechnologyDsl.g:5093:1: rule__TechnologySpecificProperty__Group_2_0__0__Impl : ( '=' ) ;
    public final void rule__TechnologySpecificProperty__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5097:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5098:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5098:1: ( '=' )
            // InternalTechnologyDsl.g:5099:2: '='
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPropertyAccess().getEqualsSignKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group_2_0__0__Impl"


    // $ANTLR start "rule__TechnologySpecificProperty__Group_2_0__1"
    // InternalTechnologyDsl.g:5108:1: rule__TechnologySpecificProperty__Group_2_0__1 : rule__TechnologySpecificProperty__Group_2_0__1__Impl ;
    public final void rule__TechnologySpecificProperty__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5112:1: ( rule__TechnologySpecificProperty__Group_2_0__1__Impl )
            // InternalTechnologyDsl.g:5113:2: rule__TechnologySpecificProperty__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group_2_0__1"


    // $ANTLR start "rule__TechnologySpecificProperty__Group_2_0__1__Impl"
    // InternalTechnologyDsl.g:5119:1: rule__TechnologySpecificProperty__Group_2_0__1__Impl : ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) ) ;
    public final void rule__TechnologySpecificProperty__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5123:1: ( ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) ) )
            // InternalTechnologyDsl.g:5124:1: ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) )
            {
            // InternalTechnologyDsl.g:5124:1: ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) )
            // InternalTechnologyDsl.g:5125:2: ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValueAssignment_2_0_1()); 
            // InternalTechnologyDsl.g:5126:2: ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 )
            // InternalTechnologyDsl.g:5126:3: rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValueAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__Group_2_0__1__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_0__0"
    // InternalTechnologyDsl.g:5135:1: rule__ServiceAspectPointcut__Group_0__0 : rule__ServiceAspectPointcut__Group_0__0__Impl rule__ServiceAspectPointcut__Group_0__1 ;
    public final void rule__ServiceAspectPointcut__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5139:1: ( rule__ServiceAspectPointcut__Group_0__0__Impl rule__ServiceAspectPointcut__Group_0__1 )
            // InternalTechnologyDsl.g:5140:2: rule__ServiceAspectPointcut__Group_0__0__Impl rule__ServiceAspectPointcut__Group_0__1
            {
            pushFollow(FOLLOW_41);
            rule__ServiceAspectPointcut__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_0__0"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_0__0__Impl"
    // InternalTechnologyDsl.g:5147:1: rule__ServiceAspectPointcut__Group_0__0__Impl : ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5151:1: ( ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) ) )
            // InternalTechnologyDsl.g:5152:1: ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) )
            {
            // InternalTechnologyDsl.g:5152:1: ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) )
            // InternalTechnologyDsl.g:5153:2: ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternAssignment_0_0()); 
            // InternalTechnologyDsl.g:5154:2: ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 )
            // InternalTechnologyDsl.g:5154:3: rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_0__0__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_0__1"
    // InternalTechnologyDsl.g:5162:1: rule__ServiceAspectPointcut__Group_0__1 : rule__ServiceAspectPointcut__Group_0__1__Impl rule__ServiceAspectPointcut__Group_0__2 ;
    public final void rule__ServiceAspectPointcut__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5166:1: ( rule__ServiceAspectPointcut__Group_0__1__Impl rule__ServiceAspectPointcut__Group_0__2 )
            // InternalTechnologyDsl.g:5167:2: rule__ServiceAspectPointcut__Group_0__1__Impl rule__ServiceAspectPointcut__Group_0__2
            {
            pushFollow(FOLLOW_49);
            rule__ServiceAspectPointcut__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_0__1"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_0__1__Impl"
    // InternalTechnologyDsl.g:5174:1: rule__ServiceAspectPointcut__Group_0__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5178:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5179:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5179:1: ( '=' )
            // InternalTechnologyDsl.g:5180:2: '='
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_0__1__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_0__2"
    // InternalTechnologyDsl.g:5189:1: rule__ServiceAspectPointcut__Group_0__2 : rule__ServiceAspectPointcut__Group_0__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5193:1: ( rule__ServiceAspectPointcut__Group_0__2__Impl )
            // InternalTechnologyDsl.g:5194:2: rule__ServiceAspectPointcut__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_0__2"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_0__2__Impl"
    // InternalTechnologyDsl.g:5200:1: rule__ServiceAspectPointcut__Group_0__2__Impl : ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5204:1: ( ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) ) )
            // InternalTechnologyDsl.g:5205:1: ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) )
            {
            // InternalTechnologyDsl.g:5205:1: ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) )
            // InternalTechnologyDsl.g:5206:2: ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternAssignment_0_2()); 
            // InternalTechnologyDsl.g:5207:2: ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 )
            // InternalTechnologyDsl.g:5207:3: rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_0__2__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_1__0"
    // InternalTechnologyDsl.g:5216:1: rule__ServiceAspectPointcut__Group_1__0 : rule__ServiceAspectPointcut__Group_1__0__Impl rule__ServiceAspectPointcut__Group_1__1 ;
    public final void rule__ServiceAspectPointcut__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5220:1: ( rule__ServiceAspectPointcut__Group_1__0__Impl rule__ServiceAspectPointcut__Group_1__1 )
            // InternalTechnologyDsl.g:5221:2: rule__ServiceAspectPointcut__Group_1__0__Impl rule__ServiceAspectPointcut__Group_1__1
            {
            pushFollow(FOLLOW_41);
            rule__ServiceAspectPointcut__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_1__0"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_1__0__Impl"
    // InternalTechnologyDsl.g:5228:1: rule__ServiceAspectPointcut__Group_1__0__Impl : ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5232:1: ( ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) ) )
            // InternalTechnologyDsl.g:5233:1: ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) )
            {
            // InternalTechnologyDsl.g:5233:1: ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) )
            // InternalTechnologyDsl.g:5234:2: ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeAssignment_1_0()); 
            // InternalTechnologyDsl.g:5235:2: ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 )
            // InternalTechnologyDsl.g:5235:3: rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_1__0__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_1__1"
    // InternalTechnologyDsl.g:5243:1: rule__ServiceAspectPointcut__Group_1__1 : rule__ServiceAspectPointcut__Group_1__1__Impl rule__ServiceAspectPointcut__Group_1__2 ;
    public final void rule__ServiceAspectPointcut__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5247:1: ( rule__ServiceAspectPointcut__Group_1__1__Impl rule__ServiceAspectPointcut__Group_1__2 )
            // InternalTechnologyDsl.g:5248:2: rule__ServiceAspectPointcut__Group_1__1__Impl rule__ServiceAspectPointcut__Group_1__2
            {
            pushFollow(FOLLOW_16);
            rule__ServiceAspectPointcut__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_1__1"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_1__1__Impl"
    // InternalTechnologyDsl.g:5255:1: rule__ServiceAspectPointcut__Group_1__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5259:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5260:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5260:1: ( '=' )
            // InternalTechnologyDsl.g:5261:2: '='
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_1__1__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_1__2"
    // InternalTechnologyDsl.g:5270:1: rule__ServiceAspectPointcut__Group_1__2 : rule__ServiceAspectPointcut__Group_1__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5274:1: ( rule__ServiceAspectPointcut__Group_1__2__Impl )
            // InternalTechnologyDsl.g:5275:2: rule__ServiceAspectPointcut__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_1__2"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_1__2__Impl"
    // InternalTechnologyDsl.g:5281:1: rule__ServiceAspectPointcut__Group_1__2__Impl : ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5285:1: ( ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) ) )
            // InternalTechnologyDsl.g:5286:1: ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) )
            {
            // InternalTechnologyDsl.g:5286:1: ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) )
            // InternalTechnologyDsl.g:5287:2: ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeAssignment_1_2()); 
            // InternalTechnologyDsl.g:5288:2: ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 )
            // InternalTechnologyDsl.g:5288:3: rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_1__2__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_2__0"
    // InternalTechnologyDsl.g:5297:1: rule__ServiceAspectPointcut__Group_2__0 : rule__ServiceAspectPointcut__Group_2__0__Impl rule__ServiceAspectPointcut__Group_2__1 ;
    public final void rule__ServiceAspectPointcut__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5301:1: ( rule__ServiceAspectPointcut__Group_2__0__Impl rule__ServiceAspectPointcut__Group_2__1 )
            // InternalTechnologyDsl.g:5302:2: rule__ServiceAspectPointcut__Group_2__0__Impl rule__ServiceAspectPointcut__Group_2__1
            {
            pushFollow(FOLLOW_41);
            rule__ServiceAspectPointcut__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_2__0"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_2__0__Impl"
    // InternalTechnologyDsl.g:5309:1: rule__ServiceAspectPointcut__Group_2__0__Impl : ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5313:1: ( ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) ) )
            // InternalTechnologyDsl.g:5314:1: ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) )
            {
            // InternalTechnologyDsl.g:5314:1: ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) )
            // InternalTechnologyDsl.g:5315:2: ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForProtocolAssignment_2_0()); 
            // InternalTechnologyDsl.g:5316:2: ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 )
            // InternalTechnologyDsl.g:5316:3: rule__ServiceAspectPointcut__ForProtocolAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__ForProtocolAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForProtocolAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_2__0__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_2__1"
    // InternalTechnologyDsl.g:5324:1: rule__ServiceAspectPointcut__Group_2__1 : rule__ServiceAspectPointcut__Group_2__1__Impl rule__ServiceAspectPointcut__Group_2__2 ;
    public final void rule__ServiceAspectPointcut__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5328:1: ( rule__ServiceAspectPointcut__Group_2__1__Impl rule__ServiceAspectPointcut__Group_2__2 )
            // InternalTechnologyDsl.g:5329:2: rule__ServiceAspectPointcut__Group_2__1__Impl rule__ServiceAspectPointcut__Group_2__2
            {
            pushFollow(FOLLOW_7);
            rule__ServiceAspectPointcut__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_2__1"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_2__1__Impl"
    // InternalTechnologyDsl.g:5336:1: rule__ServiceAspectPointcut__Group_2__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5340:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5341:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5341:1: ( '=' )
            // InternalTechnologyDsl.g:5342:2: '='
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_2__1__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_2__2"
    // InternalTechnologyDsl.g:5351:1: rule__ServiceAspectPointcut__Group_2__2 : rule__ServiceAspectPointcut__Group_2__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5355:1: ( rule__ServiceAspectPointcut__Group_2__2__Impl )
            // InternalTechnologyDsl.g:5356:2: rule__ServiceAspectPointcut__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_2__2"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_2__2__Impl"
    // InternalTechnologyDsl.g:5362:1: rule__ServiceAspectPointcut__Group_2__2__Impl : ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5366:1: ( ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) ) )
            // InternalTechnologyDsl.g:5367:1: ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) )
            {
            // InternalTechnologyDsl.g:5367:1: ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) )
            // InternalTechnologyDsl.g:5368:2: ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getProtocolAssignment_2_2()); 
            // InternalTechnologyDsl.g:5369:2: ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 )
            // InternalTechnologyDsl.g:5369:3: rule__ServiceAspectPointcut__ProtocolAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__ProtocolAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getProtocolAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_2__2__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_3__0"
    // InternalTechnologyDsl.g:5378:1: rule__ServiceAspectPointcut__Group_3__0 : rule__ServiceAspectPointcut__Group_3__0__Impl rule__ServiceAspectPointcut__Group_3__1 ;
    public final void rule__ServiceAspectPointcut__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5382:1: ( rule__ServiceAspectPointcut__Group_3__0__Impl rule__ServiceAspectPointcut__Group_3__1 )
            // InternalTechnologyDsl.g:5383:2: rule__ServiceAspectPointcut__Group_3__0__Impl rule__ServiceAspectPointcut__Group_3__1
            {
            pushFollow(FOLLOW_41);
            rule__ServiceAspectPointcut__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_3__0"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_3__0__Impl"
    // InternalTechnologyDsl.g:5390:1: rule__ServiceAspectPointcut__Group_3__0__Impl : ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5394:1: ( ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) ) )
            // InternalTechnologyDsl.g:5395:1: ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) )
            {
            // InternalTechnologyDsl.g:5395:1: ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) )
            // InternalTechnologyDsl.g:5396:2: ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatAssignment_3_0()); 
            // InternalTechnologyDsl.g:5397:2: ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 )
            // InternalTechnologyDsl.g:5397:3: rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_3__0__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_3__1"
    // InternalTechnologyDsl.g:5405:1: rule__ServiceAspectPointcut__Group_3__1 : rule__ServiceAspectPointcut__Group_3__1__Impl rule__ServiceAspectPointcut__Group_3__2 ;
    public final void rule__ServiceAspectPointcut__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5409:1: ( rule__ServiceAspectPointcut__Group_3__1__Impl rule__ServiceAspectPointcut__Group_3__2 )
            // InternalTechnologyDsl.g:5410:2: rule__ServiceAspectPointcut__Group_3__1__Impl rule__ServiceAspectPointcut__Group_3__2
            {
            pushFollow(FOLLOW_7);
            rule__ServiceAspectPointcut__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_3__1"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_3__1__Impl"
    // InternalTechnologyDsl.g:5417:1: rule__ServiceAspectPointcut__Group_3__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5421:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5422:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5422:1: ( '=' )
            // InternalTechnologyDsl.g:5423:2: '='
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getEqualsSignKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_3__1__Impl"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_3__2"
    // InternalTechnologyDsl.g:5432:1: rule__ServiceAspectPointcut__Group_3__2 : rule__ServiceAspectPointcut__Group_3__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5436:1: ( rule__ServiceAspectPointcut__Group_3__2__Impl )
            // InternalTechnologyDsl.g:5437:2: rule__ServiceAspectPointcut__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_3__2"


    // $ANTLR start "rule__ServiceAspectPointcut__Group_3__2__Impl"
    // InternalTechnologyDsl.g:5443:1: rule__ServiceAspectPointcut__Group_3__2__Impl : ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5447:1: ( ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) ) )
            // InternalTechnologyDsl.g:5448:1: ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) )
            {
            // InternalTechnologyDsl.g:5448:1: ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) )
            // InternalTechnologyDsl.g:5449:2: ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getDataFormatAssignment_3_2()); 
            // InternalTechnologyDsl.g:5450:2: ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 )
            // InternalTechnologyDsl.g:5450:3: rule__ServiceAspectPointcut__DataFormatAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcut__DataFormatAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutAccess().getDataFormatAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__Group_3__2__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__0"
    // InternalTechnologyDsl.g:5459:1: rule__ServiceAspectPointcutSelector__Group__0 : rule__ServiceAspectPointcutSelector__Group__0__Impl rule__ServiceAspectPointcutSelector__Group__1 ;
    public final void rule__ServiceAspectPointcutSelector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5463:1: ( rule__ServiceAspectPointcutSelector__Group__0__Impl rule__ServiceAspectPointcutSelector__Group__1 )
            // InternalTechnologyDsl.g:5464:2: rule__ServiceAspectPointcutSelector__Group__0__Impl rule__ServiceAspectPointcutSelector__Group__1
            {
            pushFollow(FOLLOW_50);
            rule__ServiceAspectPointcutSelector__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__0"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__0__Impl"
    // InternalTechnologyDsl.g:5471:1: rule__ServiceAspectPointcutSelector__Group__0__Impl : ( 'selector' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5475:1: ( ( 'selector' ) )
            // InternalTechnologyDsl.g:5476:1: ( 'selector' )
            {
            // InternalTechnologyDsl.g:5476:1: ( 'selector' )
            // InternalTechnologyDsl.g:5477:2: 'selector'
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getSelectorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__0__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__1"
    // InternalTechnologyDsl.g:5486:1: rule__ServiceAspectPointcutSelector__Group__1 : rule__ServiceAspectPointcutSelector__Group__1__Impl rule__ServiceAspectPointcutSelector__Group__2 ;
    public final void rule__ServiceAspectPointcutSelector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5490:1: ( rule__ServiceAspectPointcutSelector__Group__1__Impl rule__ServiceAspectPointcutSelector__Group__2 )
            // InternalTechnologyDsl.g:5491:2: rule__ServiceAspectPointcutSelector__Group__1__Impl rule__ServiceAspectPointcutSelector__Group__2
            {
            pushFollow(FOLLOW_51);
            rule__ServiceAspectPointcutSelector__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__1"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__1__Impl"
    // InternalTechnologyDsl.g:5498:1: rule__ServiceAspectPointcutSelector__Group__1__Impl : ( '(' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5502:1: ( ( '(' ) )
            // InternalTechnologyDsl.g:5503:1: ( '(' )
            {
            // InternalTechnologyDsl.g:5503:1: ( '(' )
            // InternalTechnologyDsl.g:5504:2: '('
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__1__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__2"
    // InternalTechnologyDsl.g:5513:1: rule__ServiceAspectPointcutSelector__Group__2 : rule__ServiceAspectPointcutSelector__Group__2__Impl rule__ServiceAspectPointcutSelector__Group__3 ;
    public final void rule__ServiceAspectPointcutSelector__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5517:1: ( rule__ServiceAspectPointcutSelector__Group__2__Impl rule__ServiceAspectPointcutSelector__Group__3 )
            // InternalTechnologyDsl.g:5518:2: rule__ServiceAspectPointcutSelector__Group__2__Impl rule__ServiceAspectPointcutSelector__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__ServiceAspectPointcutSelector__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__2"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__2__Impl"
    // InternalTechnologyDsl.g:5525:1: rule__ServiceAspectPointcutSelector__Group__2__Impl : ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5529:1: ( ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) ) )
            // InternalTechnologyDsl.g:5530:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:5530:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) )
            // InternalTechnologyDsl.g:5531:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 )
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_2()); 
            // InternalTechnologyDsl.g:5532:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 )
            // InternalTechnologyDsl.g:5532:3: rule__ServiceAspectPointcutSelector__PointcutsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__PointcutsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__2__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__3"
    // InternalTechnologyDsl.g:5540:1: rule__ServiceAspectPointcutSelector__Group__3 : rule__ServiceAspectPointcutSelector__Group__3__Impl rule__ServiceAspectPointcutSelector__Group__4 ;
    public final void rule__ServiceAspectPointcutSelector__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5544:1: ( rule__ServiceAspectPointcutSelector__Group__3__Impl rule__ServiceAspectPointcutSelector__Group__4 )
            // InternalTechnologyDsl.g:5545:2: rule__ServiceAspectPointcutSelector__Group__3__Impl rule__ServiceAspectPointcutSelector__Group__4
            {
            pushFollow(FOLLOW_52);
            rule__ServiceAspectPointcutSelector__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__3"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__3__Impl"
    // InternalTechnologyDsl.g:5552:1: rule__ServiceAspectPointcutSelector__Group__3__Impl : ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5556:1: ( ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* ) )
            // InternalTechnologyDsl.g:5557:1: ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* )
            {
            // InternalTechnologyDsl.g:5557:1: ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* )
            // InternalTechnologyDsl.g:5558:2: ( rule__ServiceAspectPointcutSelector__Group_3__0 )*
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup_3()); 
            // InternalTechnologyDsl.g:5559:2: ( rule__ServiceAspectPointcutSelector__Group_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==46) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5559:3: rule__ServiceAspectPointcutSelector__Group_3__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ServiceAspectPointcutSelector__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__3__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__4"
    // InternalTechnologyDsl.g:5567:1: rule__ServiceAspectPointcutSelector__Group__4 : rule__ServiceAspectPointcutSelector__Group__4__Impl rule__ServiceAspectPointcutSelector__Group__5 ;
    public final void rule__ServiceAspectPointcutSelector__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5571:1: ( rule__ServiceAspectPointcutSelector__Group__4__Impl rule__ServiceAspectPointcutSelector__Group__5 )
            // InternalTechnologyDsl.g:5572:2: rule__ServiceAspectPointcutSelector__Group__4__Impl rule__ServiceAspectPointcutSelector__Group__5
            {
            pushFollow(FOLLOW_36);
            rule__ServiceAspectPointcutSelector__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__4"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__4__Impl"
    // InternalTechnologyDsl.g:5579:1: rule__ServiceAspectPointcutSelector__Group__4__Impl : ( ')' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5583:1: ( ( ')' ) )
            // InternalTechnologyDsl.g:5584:1: ( ')' )
            {
            // InternalTechnologyDsl.g:5584:1: ( ')' )
            // InternalTechnologyDsl.g:5585:2: ')'
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__4__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__5"
    // InternalTechnologyDsl.g:5594:1: rule__ServiceAspectPointcutSelector__Group__5 : rule__ServiceAspectPointcutSelector__Group__5__Impl ;
    public final void rule__ServiceAspectPointcutSelector__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5598:1: ( rule__ServiceAspectPointcutSelector__Group__5__Impl )
            // InternalTechnologyDsl.g:5599:2: rule__ServiceAspectPointcutSelector__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__5"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group__5__Impl"
    // InternalTechnologyDsl.g:5605:1: rule__ServiceAspectPointcutSelector__Group__5__Impl : ( ';' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5609:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:5610:1: ( ';' )
            {
            // InternalTechnologyDsl.g:5610:1: ( ';' )
            // InternalTechnologyDsl.g:5611:2: ';'
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getSemicolonKeyword_5()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group__5__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group_3__0"
    // InternalTechnologyDsl.g:5621:1: rule__ServiceAspectPointcutSelector__Group_3__0 : rule__ServiceAspectPointcutSelector__Group_3__0__Impl rule__ServiceAspectPointcutSelector__Group_3__1 ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5625:1: ( rule__ServiceAspectPointcutSelector__Group_3__0__Impl rule__ServiceAspectPointcutSelector__Group_3__1 )
            // InternalTechnologyDsl.g:5626:2: rule__ServiceAspectPointcutSelector__Group_3__0__Impl rule__ServiceAspectPointcutSelector__Group_3__1
            {
            pushFollow(FOLLOW_51);
            rule__ServiceAspectPointcutSelector__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group_3__0"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group_3__0__Impl"
    // InternalTechnologyDsl.g:5633:1: rule__ServiceAspectPointcutSelector__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5637:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:5638:1: ( ',' )
            {
            // InternalTechnologyDsl.g:5638:1: ( ',' )
            // InternalTechnologyDsl.g:5639:2: ','
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group_3__0__Impl"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group_3__1"
    // InternalTechnologyDsl.g:5648:1: rule__ServiceAspectPointcutSelector__Group_3__1 : rule__ServiceAspectPointcutSelector__Group_3__1__Impl ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5652:1: ( rule__ServiceAspectPointcutSelector__Group_3__1__Impl )
            // InternalTechnologyDsl.g:5653:2: rule__ServiceAspectPointcutSelector__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group_3__1"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__Group_3__1__Impl"
    // InternalTechnologyDsl.g:5659:1: rule__ServiceAspectPointcutSelector__Group_3__1__Impl : ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) ) ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5663:1: ( ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) ) )
            // InternalTechnologyDsl.g:5664:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) )
            {
            // InternalTechnologyDsl.g:5664:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) )
            // InternalTechnologyDsl.g:5665:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 )
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_3_1()); 
            // InternalTechnologyDsl.g:5666:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 )
            // InternalTechnologyDsl.g:5666:3: rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__Group_3__1__Impl"


    // $ANTLR start "rule__ServiceAspect__Group__0"
    // InternalTechnologyDsl.g:5675:1: rule__ServiceAspect__Group__0 : rule__ServiceAspect__Group__0__Impl rule__ServiceAspect__Group__1 ;
    public final void rule__ServiceAspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5679:1: ( rule__ServiceAspect__Group__0__Impl rule__ServiceAspect__Group__1 )
            // InternalTechnologyDsl.g:5680:2: rule__ServiceAspect__Group__0__Impl rule__ServiceAspect__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ServiceAspect__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__0"


    // $ANTLR start "rule__ServiceAspect__Group__0__Impl"
    // InternalTechnologyDsl.g:5687:1: rule__ServiceAspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__ServiceAspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5691:1: ( ( 'aspect' ) )
            // InternalTechnologyDsl.g:5692:1: ( 'aspect' )
            {
            // InternalTechnologyDsl.g:5692:1: ( 'aspect' )
            // InternalTechnologyDsl.g:5693:2: 'aspect'
            {
             before(grammarAccess.getServiceAspectAccess().getAspectKeyword_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getServiceAspectAccess().getAspectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__0__Impl"


    // $ANTLR start "rule__ServiceAspect__Group__1"
    // InternalTechnologyDsl.g:5702:1: rule__ServiceAspect__Group__1 : rule__ServiceAspect__Group__1__Impl rule__ServiceAspect__Group__2 ;
    public final void rule__ServiceAspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5706:1: ( rule__ServiceAspect__Group__1__Impl rule__ServiceAspect__Group__2 )
            // InternalTechnologyDsl.g:5707:2: rule__ServiceAspect__Group__1__Impl rule__ServiceAspect__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__ServiceAspect__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__1"


    // $ANTLR start "rule__ServiceAspect__Group__1__Impl"
    // InternalTechnologyDsl.g:5714:1: rule__ServiceAspect__Group__1__Impl : ( ( rule__ServiceAspect__NameAssignment_1 ) ) ;
    public final void rule__ServiceAspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5718:1: ( ( ( rule__ServiceAspect__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:5719:1: ( ( rule__ServiceAspect__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:5719:1: ( ( rule__ServiceAspect__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:5720:2: ( rule__ServiceAspect__NameAssignment_1 )
            {
             before(grammarAccess.getServiceAspectAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:5721:2: ( rule__ServiceAspect__NameAssignment_1 )
            // InternalTechnologyDsl.g:5721:3: rule__ServiceAspect__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__1__Impl"


    // $ANTLR start "rule__ServiceAspect__Group__2"
    // InternalTechnologyDsl.g:5729:1: rule__ServiceAspect__Group__2 : rule__ServiceAspect__Group__2__Impl rule__ServiceAspect__Group__3 ;
    public final void rule__ServiceAspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5733:1: ( rule__ServiceAspect__Group__2__Impl rule__ServiceAspect__Group__3 )
            // InternalTechnologyDsl.g:5734:2: rule__ServiceAspect__Group__2__Impl rule__ServiceAspect__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__ServiceAspect__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__2"


    // $ANTLR start "rule__ServiceAspect__Group__2__Impl"
    // InternalTechnologyDsl.g:5741:1: rule__ServiceAspect__Group__2__Impl : ( 'for' ) ;
    public final void rule__ServiceAspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5745:1: ( ( 'for' ) )
            // InternalTechnologyDsl.g:5746:1: ( 'for' )
            {
            // InternalTechnologyDsl.g:5746:1: ( 'for' )
            // InternalTechnologyDsl.g:5747:2: 'for'
            {
             before(grammarAccess.getServiceAspectAccess().getForKeyword_2()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getServiceAspectAccess().getForKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__2__Impl"


    // $ANTLR start "rule__ServiceAspect__Group__3"
    // InternalTechnologyDsl.g:5756:1: rule__ServiceAspect__Group__3 : rule__ServiceAspect__Group__3__Impl rule__ServiceAspect__Group__4 ;
    public final void rule__ServiceAspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5760:1: ( rule__ServiceAspect__Group__3__Impl rule__ServiceAspect__Group__4 )
            // InternalTechnologyDsl.g:5761:2: rule__ServiceAspect__Group__3__Impl rule__ServiceAspect__Group__4
            {
            pushFollow(FOLLOW_55);
            rule__ServiceAspect__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__3"


    // $ANTLR start "rule__ServiceAspect__Group__3__Impl"
    // InternalTechnologyDsl.g:5768:1: rule__ServiceAspect__Group__3__Impl : ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) ) ;
    public final void rule__ServiceAspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5772:1: ( ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) ) )
            // InternalTechnologyDsl.g:5773:1: ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:5773:1: ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) )
            // InternalTechnologyDsl.g:5774:2: ( rule__ServiceAspect__JoinPointsAssignment_3 )
            {
             before(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_3()); 
            // InternalTechnologyDsl.g:5775:2: ( rule__ServiceAspect__JoinPointsAssignment_3 )
            // InternalTechnologyDsl.g:5775:3: rule__ServiceAspect__JoinPointsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__JoinPointsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__3__Impl"


    // $ANTLR start "rule__ServiceAspect__Group__4"
    // InternalTechnologyDsl.g:5783:1: rule__ServiceAspect__Group__4 : rule__ServiceAspect__Group__4__Impl rule__ServiceAspect__Group__5 ;
    public final void rule__ServiceAspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5787:1: ( rule__ServiceAspect__Group__4__Impl rule__ServiceAspect__Group__5 )
            // InternalTechnologyDsl.g:5788:2: rule__ServiceAspect__Group__4__Impl rule__ServiceAspect__Group__5
            {
            pushFollow(FOLLOW_55);
            rule__ServiceAspect__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__4"


    // $ANTLR start "rule__ServiceAspect__Group__4__Impl"
    // InternalTechnologyDsl.g:5795:1: rule__ServiceAspect__Group__4__Impl : ( ( rule__ServiceAspect__Group_4__0 )* ) ;
    public final void rule__ServiceAspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5799:1: ( ( ( rule__ServiceAspect__Group_4__0 )* ) )
            // InternalTechnologyDsl.g:5800:1: ( ( rule__ServiceAspect__Group_4__0 )* )
            {
            // InternalTechnologyDsl.g:5800:1: ( ( rule__ServiceAspect__Group_4__0 )* )
            // InternalTechnologyDsl.g:5801:2: ( rule__ServiceAspect__Group_4__0 )*
            {
             before(grammarAccess.getServiceAspectAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:5802:2: ( rule__ServiceAspect__Group_4__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==46) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5802:3: rule__ServiceAspect__Group_4__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ServiceAspect__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getServiceAspectAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__4__Impl"


    // $ANTLR start "rule__ServiceAspect__Group__5"
    // InternalTechnologyDsl.g:5810:1: rule__ServiceAspect__Group__5 : rule__ServiceAspect__Group__5__Impl ;
    public final void rule__ServiceAspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5814:1: ( rule__ServiceAspect__Group__5__Impl )
            // InternalTechnologyDsl.g:5815:2: rule__ServiceAspect__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__5"


    // $ANTLR start "rule__ServiceAspect__Group__5__Impl"
    // InternalTechnologyDsl.g:5821:1: rule__ServiceAspect__Group__5__Impl : ( ( rule__ServiceAspect__Alternatives_5 ) ) ;
    public final void rule__ServiceAspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5825:1: ( ( ( rule__ServiceAspect__Alternatives_5 ) ) )
            // InternalTechnologyDsl.g:5826:1: ( ( rule__ServiceAspect__Alternatives_5 ) )
            {
            // InternalTechnologyDsl.g:5826:1: ( ( rule__ServiceAspect__Alternatives_5 ) )
            // InternalTechnologyDsl.g:5827:2: ( rule__ServiceAspect__Alternatives_5 )
            {
             before(grammarAccess.getServiceAspectAccess().getAlternatives_5()); 
            // InternalTechnologyDsl.g:5828:2: ( rule__ServiceAspect__Alternatives_5 )
            // InternalTechnologyDsl.g:5828:3: rule__ServiceAspect__Alternatives_5
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group__5__Impl"


    // $ANTLR start "rule__ServiceAspect__Group_4__0"
    // InternalTechnologyDsl.g:5837:1: rule__ServiceAspect__Group_4__0 : rule__ServiceAspect__Group_4__0__Impl rule__ServiceAspect__Group_4__1 ;
    public final void rule__ServiceAspect__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5841:1: ( rule__ServiceAspect__Group_4__0__Impl rule__ServiceAspect__Group_4__1 )
            // InternalTechnologyDsl.g:5842:2: rule__ServiceAspect__Group_4__0__Impl rule__ServiceAspect__Group_4__1
            {
            pushFollow(FOLLOW_54);
            rule__ServiceAspect__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_4__0"


    // $ANTLR start "rule__ServiceAspect__Group_4__0__Impl"
    // InternalTechnologyDsl.g:5849:1: rule__ServiceAspect__Group_4__0__Impl : ( ',' ) ;
    public final void rule__ServiceAspect__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5853:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:5854:1: ( ',' )
            {
            // InternalTechnologyDsl.g:5854:1: ( ',' )
            // InternalTechnologyDsl.g:5855:2: ','
            {
             before(grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getServiceAspectAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_4__0__Impl"


    // $ANTLR start "rule__ServiceAspect__Group_4__1"
    // InternalTechnologyDsl.g:5864:1: rule__ServiceAspect__Group_4__1 : rule__ServiceAspect__Group_4__1__Impl ;
    public final void rule__ServiceAspect__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5868:1: ( rule__ServiceAspect__Group_4__1__Impl )
            // InternalTechnologyDsl.g:5869:2: rule__ServiceAspect__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_4__1"


    // $ANTLR start "rule__ServiceAspect__Group_4__1__Impl"
    // InternalTechnologyDsl.g:5875:1: rule__ServiceAspect__Group_4__1__Impl : ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) ) ;
    public final void rule__ServiceAspect__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5879:1: ( ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) ) )
            // InternalTechnologyDsl.g:5880:1: ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) )
            {
            // InternalTechnologyDsl.g:5880:1: ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) )
            // InternalTechnologyDsl.g:5881:2: ( rule__ServiceAspect__JoinPointsAssignment_4_1 )
            {
             before(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_4_1()); 
            // InternalTechnologyDsl.g:5882:2: ( rule__ServiceAspect__JoinPointsAssignment_4_1 )
            // InternalTechnologyDsl.g:5882:3: rule__ServiceAspect__JoinPointsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__JoinPointsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_4__1__Impl"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__0"
    // InternalTechnologyDsl.g:5891:1: rule__ServiceAspect__Group_5_0__0 : rule__ServiceAspect__Group_5_0__0__Impl rule__ServiceAspect__Group_5_0__1 ;
    public final void rule__ServiceAspect__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5895:1: ( rule__ServiceAspect__Group_5_0__0__Impl rule__ServiceAspect__Group_5_0__1 )
            // InternalTechnologyDsl.g:5896:2: rule__ServiceAspect__Group_5_0__0__Impl rule__ServiceAspect__Group_5_0__1
            {
            pushFollow(FOLLOW_56);
            rule__ServiceAspect__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group_5_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__0"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__0__Impl"
    // InternalTechnologyDsl.g:5903:1: rule__ServiceAspect__Group_5_0__0__Impl : ( '{' ) ;
    public final void rule__ServiceAspect__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5907:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:5908:1: ( '{' )
            {
            // InternalTechnologyDsl.g:5908:1: ( '{' )
            // InternalTechnologyDsl.g:5909:2: '{'
            {
             before(grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__0__Impl"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__1"
    // InternalTechnologyDsl.g:5918:1: rule__ServiceAspect__Group_5_0__1 : rule__ServiceAspect__Group_5_0__1__Impl rule__ServiceAspect__Group_5_0__2 ;
    public final void rule__ServiceAspect__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5922:1: ( rule__ServiceAspect__Group_5_0__1__Impl rule__ServiceAspect__Group_5_0__2 )
            // InternalTechnologyDsl.g:5923:2: rule__ServiceAspect__Group_5_0__1__Impl rule__ServiceAspect__Group_5_0__2
            {
            pushFollow(FOLLOW_56);
            rule__ServiceAspect__Group_5_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group_5_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__1"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__1__Impl"
    // InternalTechnologyDsl.g:5930:1: rule__ServiceAspect__Group_5_0__1__Impl : ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* ) ;
    public final void rule__ServiceAspect__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5934:1: ( ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* ) )
            // InternalTechnologyDsl.g:5935:1: ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* )
            {
            // InternalTechnologyDsl.g:5935:1: ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* )
            // InternalTechnologyDsl.g:5936:2: ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )*
            {
             before(grammarAccess.getServiceAspectAccess().getPointcutSelectorsAssignment_5_0_1()); 
            // InternalTechnologyDsl.g:5937:2: ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==59) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5937:3: rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1
            	    {
            	    pushFollow(FOLLOW_57);
            	    rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getServiceAspectAccess().getPointcutSelectorsAssignment_5_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__1__Impl"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__2"
    // InternalTechnologyDsl.g:5945:1: rule__ServiceAspect__Group_5_0__2 : rule__ServiceAspect__Group_5_0__2__Impl rule__ServiceAspect__Group_5_0__3 ;
    public final void rule__ServiceAspect__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5949:1: ( rule__ServiceAspect__Group_5_0__2__Impl rule__ServiceAspect__Group_5_0__3 )
            // InternalTechnologyDsl.g:5950:2: rule__ServiceAspect__Group_5_0__2__Impl rule__ServiceAspect__Group_5_0__3
            {
            pushFollow(FOLLOW_56);
            rule__ServiceAspect__Group_5_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group_5_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__2"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__2__Impl"
    // InternalTechnologyDsl.g:5957:1: rule__ServiceAspect__Group_5_0__2__Impl : ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* ) ;
    public final void rule__ServiceAspect__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5961:1: ( ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* ) )
            // InternalTechnologyDsl.g:5962:1: ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* )
            {
            // InternalTechnologyDsl.g:5962:1: ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* )
            // InternalTechnologyDsl.g:5963:2: ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )*
            {
             before(grammarAccess.getServiceAspectAccess().getPropertiesAssignment_5_0_2()); 
            // InternalTechnologyDsl.g:5964:2: ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=69 && LA52_0<=78)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5964:3: rule__ServiceAspect__PropertiesAssignment_5_0_2
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__ServiceAspect__PropertiesAssignment_5_0_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getServiceAspectAccess().getPropertiesAssignment_5_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__2__Impl"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__3"
    // InternalTechnologyDsl.g:5972:1: rule__ServiceAspect__Group_5_0__3 : rule__ServiceAspect__Group_5_0__3__Impl ;
    public final void rule__ServiceAspect__Group_5_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5976:1: ( rule__ServiceAspect__Group_5_0__3__Impl )
            // InternalTechnologyDsl.g:5977:2: rule__ServiceAspect__Group_5_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ServiceAspect__Group_5_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__3"


    // $ANTLR start "rule__ServiceAspect__Group_5_0__3__Impl"
    // InternalTechnologyDsl.g:5983:1: rule__ServiceAspect__Group_5_0__3__Impl : ( '}' ) ;
    public final void rule__ServiceAspect__Group_5_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5987:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:5988:1: ( '}' )
            {
            // InternalTechnologyDsl.g:5988:1: ( '}' )
            // InternalTechnologyDsl.g:5989:2: '}'
            {
             before(grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__Group_5_0__3__Impl"


    // $ANTLR start "rule__OperationAspect__Group__0"
    // InternalTechnologyDsl.g:5999:1: rule__OperationAspect__Group__0 : rule__OperationAspect__Group__0__Impl rule__OperationAspect__Group__1 ;
    public final void rule__OperationAspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6003:1: ( rule__OperationAspect__Group__0__Impl rule__OperationAspect__Group__1 )
            // InternalTechnologyDsl.g:6004:2: rule__OperationAspect__Group__0__Impl rule__OperationAspect__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__OperationAspect__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__0"


    // $ANTLR start "rule__OperationAspect__Group__0__Impl"
    // InternalTechnologyDsl.g:6011:1: rule__OperationAspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__OperationAspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6015:1: ( ( 'aspect' ) )
            // InternalTechnologyDsl.g:6016:1: ( 'aspect' )
            {
            // InternalTechnologyDsl.g:6016:1: ( 'aspect' )
            // InternalTechnologyDsl.g:6017:2: 'aspect'
            {
             before(grammarAccess.getOperationAspectAccess().getAspectKeyword_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getOperationAspectAccess().getAspectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__0__Impl"


    // $ANTLR start "rule__OperationAspect__Group__1"
    // InternalTechnologyDsl.g:6026:1: rule__OperationAspect__Group__1 : rule__OperationAspect__Group__1__Impl rule__OperationAspect__Group__2 ;
    public final void rule__OperationAspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6030:1: ( rule__OperationAspect__Group__1__Impl rule__OperationAspect__Group__2 )
            // InternalTechnologyDsl.g:6031:2: rule__OperationAspect__Group__1__Impl rule__OperationAspect__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__OperationAspect__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__1"


    // $ANTLR start "rule__OperationAspect__Group__1__Impl"
    // InternalTechnologyDsl.g:6038:1: rule__OperationAspect__Group__1__Impl : ( ( rule__OperationAspect__NameAssignment_1 ) ) ;
    public final void rule__OperationAspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6042:1: ( ( ( rule__OperationAspect__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6043:1: ( ( rule__OperationAspect__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6043:1: ( ( rule__OperationAspect__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6044:2: ( rule__OperationAspect__NameAssignment_1 )
            {
             before(grammarAccess.getOperationAspectAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6045:2: ( rule__OperationAspect__NameAssignment_1 )
            // InternalTechnologyDsl.g:6045:3: rule__OperationAspect__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationAspectAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__1__Impl"


    // $ANTLR start "rule__OperationAspect__Group__2"
    // InternalTechnologyDsl.g:6053:1: rule__OperationAspect__Group__2 : rule__OperationAspect__Group__2__Impl rule__OperationAspect__Group__3 ;
    public final void rule__OperationAspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6057:1: ( rule__OperationAspect__Group__2__Impl rule__OperationAspect__Group__3 )
            // InternalTechnologyDsl.g:6058:2: rule__OperationAspect__Group__2__Impl rule__OperationAspect__Group__3
            {
            pushFollow(FOLLOW_58);
            rule__OperationAspect__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__2"


    // $ANTLR start "rule__OperationAspect__Group__2__Impl"
    // InternalTechnologyDsl.g:6065:1: rule__OperationAspect__Group__2__Impl : ( 'for' ) ;
    public final void rule__OperationAspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6069:1: ( ( 'for' ) )
            // InternalTechnologyDsl.g:6070:1: ( 'for' )
            {
            // InternalTechnologyDsl.g:6070:1: ( 'for' )
            // InternalTechnologyDsl.g:6071:2: 'for'
            {
             before(grammarAccess.getOperationAspectAccess().getForKeyword_2()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getOperationAspectAccess().getForKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__2__Impl"


    // $ANTLR start "rule__OperationAspect__Group__3"
    // InternalTechnologyDsl.g:6080:1: rule__OperationAspect__Group__3 : rule__OperationAspect__Group__3__Impl rule__OperationAspect__Group__4 ;
    public final void rule__OperationAspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6084:1: ( rule__OperationAspect__Group__3__Impl rule__OperationAspect__Group__4 )
            // InternalTechnologyDsl.g:6085:2: rule__OperationAspect__Group__3__Impl rule__OperationAspect__Group__4
            {
            pushFollow(FOLLOW_55);
            rule__OperationAspect__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__3"


    // $ANTLR start "rule__OperationAspect__Group__3__Impl"
    // InternalTechnologyDsl.g:6092:1: rule__OperationAspect__Group__3__Impl : ( ( rule__OperationAspect__JoinPointsAssignment_3 ) ) ;
    public final void rule__OperationAspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6096:1: ( ( ( rule__OperationAspect__JoinPointsAssignment_3 ) ) )
            // InternalTechnologyDsl.g:6097:1: ( ( rule__OperationAspect__JoinPointsAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:6097:1: ( ( rule__OperationAspect__JoinPointsAssignment_3 ) )
            // InternalTechnologyDsl.g:6098:2: ( rule__OperationAspect__JoinPointsAssignment_3 )
            {
             before(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_3()); 
            // InternalTechnologyDsl.g:6099:2: ( rule__OperationAspect__JoinPointsAssignment_3 )
            // InternalTechnologyDsl.g:6099:3: rule__OperationAspect__JoinPointsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__JoinPointsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__3__Impl"


    // $ANTLR start "rule__OperationAspect__Group__4"
    // InternalTechnologyDsl.g:6107:1: rule__OperationAspect__Group__4 : rule__OperationAspect__Group__4__Impl rule__OperationAspect__Group__5 ;
    public final void rule__OperationAspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6111:1: ( rule__OperationAspect__Group__4__Impl rule__OperationAspect__Group__5 )
            // InternalTechnologyDsl.g:6112:2: rule__OperationAspect__Group__4__Impl rule__OperationAspect__Group__5
            {
            pushFollow(FOLLOW_55);
            rule__OperationAspect__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__4"


    // $ANTLR start "rule__OperationAspect__Group__4__Impl"
    // InternalTechnologyDsl.g:6119:1: rule__OperationAspect__Group__4__Impl : ( ( rule__OperationAspect__Group_4__0 )* ) ;
    public final void rule__OperationAspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6123:1: ( ( ( rule__OperationAspect__Group_4__0 )* ) )
            // InternalTechnologyDsl.g:6124:1: ( ( rule__OperationAspect__Group_4__0 )* )
            {
            // InternalTechnologyDsl.g:6124:1: ( ( rule__OperationAspect__Group_4__0 )* )
            // InternalTechnologyDsl.g:6125:2: ( rule__OperationAspect__Group_4__0 )*
            {
             before(grammarAccess.getOperationAspectAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:6126:2: ( rule__OperationAspect__Group_4__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==46) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6126:3: rule__OperationAspect__Group_4__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__OperationAspect__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getOperationAspectAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__4__Impl"


    // $ANTLR start "rule__OperationAspect__Group__5"
    // InternalTechnologyDsl.g:6134:1: rule__OperationAspect__Group__5 : rule__OperationAspect__Group__5__Impl ;
    public final void rule__OperationAspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6138:1: ( rule__OperationAspect__Group__5__Impl )
            // InternalTechnologyDsl.g:6139:2: rule__OperationAspect__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__5"


    // $ANTLR start "rule__OperationAspect__Group__5__Impl"
    // InternalTechnologyDsl.g:6145:1: rule__OperationAspect__Group__5__Impl : ( ( rule__OperationAspect__Alternatives_5 ) ) ;
    public final void rule__OperationAspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6149:1: ( ( ( rule__OperationAspect__Alternatives_5 ) ) )
            // InternalTechnologyDsl.g:6150:1: ( ( rule__OperationAspect__Alternatives_5 ) )
            {
            // InternalTechnologyDsl.g:6150:1: ( ( rule__OperationAspect__Alternatives_5 ) )
            // InternalTechnologyDsl.g:6151:2: ( rule__OperationAspect__Alternatives_5 )
            {
             before(grammarAccess.getOperationAspectAccess().getAlternatives_5()); 
            // InternalTechnologyDsl.g:6152:2: ( rule__OperationAspect__Alternatives_5 )
            // InternalTechnologyDsl.g:6152:3: rule__OperationAspect__Alternatives_5
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getOperationAspectAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group__5__Impl"


    // $ANTLR start "rule__OperationAspect__Group_4__0"
    // InternalTechnologyDsl.g:6161:1: rule__OperationAspect__Group_4__0 : rule__OperationAspect__Group_4__0__Impl rule__OperationAspect__Group_4__1 ;
    public final void rule__OperationAspect__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6165:1: ( rule__OperationAspect__Group_4__0__Impl rule__OperationAspect__Group_4__1 )
            // InternalTechnologyDsl.g:6166:2: rule__OperationAspect__Group_4__0__Impl rule__OperationAspect__Group_4__1
            {
            pushFollow(FOLLOW_58);
            rule__OperationAspect__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_4__0"


    // $ANTLR start "rule__OperationAspect__Group_4__0__Impl"
    // InternalTechnologyDsl.g:6173:1: rule__OperationAspect__Group_4__0__Impl : ( ',' ) ;
    public final void rule__OperationAspect__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6177:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:6178:1: ( ',' )
            {
            // InternalTechnologyDsl.g:6178:1: ( ',' )
            // InternalTechnologyDsl.g:6179:2: ','
            {
             before(grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getOperationAspectAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_4__0__Impl"


    // $ANTLR start "rule__OperationAspect__Group_4__1"
    // InternalTechnologyDsl.g:6188:1: rule__OperationAspect__Group_4__1 : rule__OperationAspect__Group_4__1__Impl ;
    public final void rule__OperationAspect__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6192:1: ( rule__OperationAspect__Group_4__1__Impl )
            // InternalTechnologyDsl.g:6193:2: rule__OperationAspect__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_4__1"


    // $ANTLR start "rule__OperationAspect__Group_4__1__Impl"
    // InternalTechnologyDsl.g:6199:1: rule__OperationAspect__Group_4__1__Impl : ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) ) ;
    public final void rule__OperationAspect__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6203:1: ( ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) ) )
            // InternalTechnologyDsl.g:6204:1: ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) )
            {
            // InternalTechnologyDsl.g:6204:1: ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) )
            // InternalTechnologyDsl.g:6205:2: ( rule__OperationAspect__JoinPointsAssignment_4_1 )
            {
             before(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_4_1()); 
            // InternalTechnologyDsl.g:6206:2: ( rule__OperationAspect__JoinPointsAssignment_4_1 )
            // InternalTechnologyDsl.g:6206:3: rule__OperationAspect__JoinPointsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__JoinPointsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_4__1__Impl"


    // $ANTLR start "rule__OperationAspect__Group_5_0__0"
    // InternalTechnologyDsl.g:6215:1: rule__OperationAspect__Group_5_0__0 : rule__OperationAspect__Group_5_0__0__Impl rule__OperationAspect__Group_5_0__1 ;
    public final void rule__OperationAspect__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6219:1: ( rule__OperationAspect__Group_5_0__0__Impl rule__OperationAspect__Group_5_0__1 )
            // InternalTechnologyDsl.g:6220:2: rule__OperationAspect__Group_5_0__0__Impl rule__OperationAspect__Group_5_0__1
            {
            pushFollow(FOLLOW_59);
            rule__OperationAspect__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group_5_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_5_0__0"


    // $ANTLR start "rule__OperationAspect__Group_5_0__0__Impl"
    // InternalTechnologyDsl.g:6227:1: rule__OperationAspect__Group_5_0__0__Impl : ( '{' ) ;
    public final void rule__OperationAspect__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6231:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6232:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6232:1: ( '{' )
            // InternalTechnologyDsl.g:6233:2: '{'
            {
             before(grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_5_0__0__Impl"


    // $ANTLR start "rule__OperationAspect__Group_5_0__1"
    // InternalTechnologyDsl.g:6242:1: rule__OperationAspect__Group_5_0__1 : rule__OperationAspect__Group_5_0__1__Impl rule__OperationAspect__Group_5_0__2 ;
    public final void rule__OperationAspect__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6246:1: ( rule__OperationAspect__Group_5_0__1__Impl rule__OperationAspect__Group_5_0__2 )
            // InternalTechnologyDsl.g:6247:2: rule__OperationAspect__Group_5_0__1__Impl rule__OperationAspect__Group_5_0__2
            {
            pushFollow(FOLLOW_59);
            rule__OperationAspect__Group_5_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group_5_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_5_0__1"


    // $ANTLR start "rule__OperationAspect__Group_5_0__1__Impl"
    // InternalTechnologyDsl.g:6254:1: rule__OperationAspect__Group_5_0__1__Impl : ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* ) ;
    public final void rule__OperationAspect__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6258:1: ( ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* ) )
            // InternalTechnologyDsl.g:6259:1: ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* )
            {
            // InternalTechnologyDsl.g:6259:1: ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* )
            // InternalTechnologyDsl.g:6260:2: ( rule__OperationAspect__PropertiesAssignment_5_0_1 )*
            {
             before(grammarAccess.getOperationAspectAccess().getPropertiesAssignment_5_0_1()); 
            // InternalTechnologyDsl.g:6261:2: ( rule__OperationAspect__PropertiesAssignment_5_0_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=69 && LA54_0<=78)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6261:3: rule__OperationAspect__PropertiesAssignment_5_0_1
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__OperationAspect__PropertiesAssignment_5_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

             after(grammarAccess.getOperationAspectAccess().getPropertiesAssignment_5_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_5_0__1__Impl"


    // $ANTLR start "rule__OperationAspect__Group_5_0__2"
    // InternalTechnologyDsl.g:6269:1: rule__OperationAspect__Group_5_0__2 : rule__OperationAspect__Group_5_0__2__Impl ;
    public final void rule__OperationAspect__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6273:1: ( rule__OperationAspect__Group_5_0__2__Impl )
            // InternalTechnologyDsl.g:6274:2: rule__OperationAspect__Group_5_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationAspect__Group_5_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_5_0__2"


    // $ANTLR start "rule__OperationAspect__Group_5_0__2__Impl"
    // InternalTechnologyDsl.g:6280:1: rule__OperationAspect__Group_5_0__2__Impl : ( '}' ) ;
    public final void rule__OperationAspect__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6284:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6285:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6285:1: ( '}' )
            // InternalTechnologyDsl.g:6286:2: '}'
            {
             before(grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__Group_5_0__2__Impl"


    // $ANTLR start "rule__ComplexTypeImport__Group__0"
    // InternalTechnologyDsl.g:6296:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6300:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalTechnologyDsl.g:6301:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
            {
            pushFollow(FOLLOW_60);
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
    // InternalTechnologyDsl.g:6308:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6312:1: ( ( 'import' ) )
            // InternalTechnologyDsl.g:6313:1: ( 'import' )
            {
            // InternalTechnologyDsl.g:6313:1: ( 'import' )
            // InternalTechnologyDsl.g:6314:2: 'import'
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportKeyword_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6323:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6327:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalTechnologyDsl.g:6328:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalTechnologyDsl.g:6335:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6339:1: ( ( 'datatypes' ) )
            // InternalTechnologyDsl.g:6340:1: ( 'datatypes' )
            {
            // InternalTechnologyDsl.g:6340:1: ( 'datatypes' )
            // InternalTechnologyDsl.g:6341:2: 'datatypes'
            {
             before(grammarAccess.getComplexTypeImportAccess().getDatatypesKeyword_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6350:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6354:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalTechnologyDsl.g:6355:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalTechnologyDsl.g:6362:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6366:1: ( ( 'from' ) )
            // InternalTechnologyDsl.g:6367:1: ( 'from' )
            {
            // InternalTechnologyDsl.g:6367:1: ( 'from' )
            // InternalTechnologyDsl.g:6368:2: 'from'
            {
             before(grammarAccess.getComplexTypeImportAccess().getFromKeyword_2()); 
            match(input,42,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6377:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6381:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalTechnologyDsl.g:6382:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalTechnologyDsl.g:6389:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6393:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalTechnologyDsl.g:6394:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:6394:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalTechnologyDsl.g:6395:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalTechnologyDsl.g:6396:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalTechnologyDsl.g:6396:3: rule__ComplexTypeImport__ImportURIAssignment_3
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
    // InternalTechnologyDsl.g:6404:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6408:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalTechnologyDsl.g:6409:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:6416:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6420:1: ( ( 'as' ) )
            // InternalTechnologyDsl.g:6421:1: ( 'as' )
            {
            // InternalTechnologyDsl.g:6421:1: ( 'as' )
            // InternalTechnologyDsl.g:6422:2: 'as'
            {
             before(grammarAccess.getComplexTypeImportAccess().getAsKeyword_4()); 
            match(input,43,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6431:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6435:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalTechnologyDsl.g:6436:2: rule__ComplexTypeImport__Group__5__Impl
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
    // InternalTechnologyDsl.g:6442:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6446:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalTechnologyDsl.g:6447:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:6447:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalTechnologyDsl.g:6448:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalTechnologyDsl.g:6449:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalTechnologyDsl.g:6449:3: rule__ComplexTypeImport__NameAssignment_5
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
    // InternalTechnologyDsl.g:6458:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6462:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalTechnologyDsl.g:6463:2: rule__Version__Group__0__Impl rule__Version__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:6470:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6474:1: ( ( 'version' ) )
            // InternalTechnologyDsl.g:6475:1: ( 'version' )
            {
            // InternalTechnologyDsl.g:6475:1: ( 'version' )
            // InternalTechnologyDsl.g:6476:2: 'version'
            {
             before(grammarAccess.getVersionAccess().getVersionKeyword_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6485:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6489:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalTechnologyDsl.g:6490:2: rule__Version__Group__1__Impl rule__Version__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalTechnologyDsl.g:6497:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6501:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6502:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6502:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6503:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6504:2: ( rule__Version__NameAssignment_1 )
            // InternalTechnologyDsl.g:6504:3: rule__Version__NameAssignment_1
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
    // InternalTechnologyDsl.g:6512:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6516:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalTechnologyDsl.g:6517:2: rule__Version__Group__2__Impl rule__Version__Group__3
            {
            pushFollow(FOLLOW_61);
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
    // InternalTechnologyDsl.g:6524:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6528:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6529:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6529:1: ( '{' )
            // InternalTechnologyDsl.g:6530:2: '{'
            {
             before(grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6539:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6543:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalTechnologyDsl.g:6544:2: rule__Version__Group__3__Impl rule__Version__Group__4
            {
            pushFollow(FOLLOW_61);
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
    // InternalTechnologyDsl.g:6551:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6555:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalTechnologyDsl.g:6556:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalTechnologyDsl.g:6556:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalTechnologyDsl.g:6557:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalTechnologyDsl.g:6558:2: ( rule__Version__Alternatives_3 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=53 && LA55_0<=54)||LA55_0==66||LA55_0==68) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTechnologyDsl.g:6558:3: rule__Version__Alternatives_3
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
    // InternalTechnologyDsl.g:6566:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6570:1: ( rule__Version__Group__4__Impl )
            // InternalTechnologyDsl.g:6571:2: rule__Version__Group__4__Impl
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
    // InternalTechnologyDsl.g:6577:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6581:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6582:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6582:1: ( '}' )
            // InternalTechnologyDsl.g:6583:2: '}'
            {
             before(grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6593:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6597:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalTechnologyDsl.g:6598:2: rule__Context__Group__0__Impl rule__Context__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:6605:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6609:1: ( ( 'context' ) )
            // InternalTechnologyDsl.g:6610:1: ( 'context' )
            {
            // InternalTechnologyDsl.g:6610:1: ( 'context' )
            // InternalTechnologyDsl.g:6611:2: 'context'
            {
             before(grammarAccess.getContextAccess().getContextKeyword_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6620:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6624:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalTechnologyDsl.g:6625:2: rule__Context__Group__1__Impl rule__Context__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalTechnologyDsl.g:6632:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6636:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6637:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6637:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6638:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6639:2: ( rule__Context__NameAssignment_1 )
            // InternalTechnologyDsl.g:6639:3: rule__Context__NameAssignment_1
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
    // InternalTechnologyDsl.g:6647:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6651:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalTechnologyDsl.g:6652:2: rule__Context__Group__2__Impl rule__Context__Group__3
            {
            pushFollow(FOLLOW_62);
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
    // InternalTechnologyDsl.g:6659:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6663:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6664:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6664:1: ( '{' )
            // InternalTechnologyDsl.g:6665:2: '{'
            {
             before(grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6674:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6678:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalTechnologyDsl.g:6679:2: rule__Context__Group__3__Impl rule__Context__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalTechnologyDsl.g:6686:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6690:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalTechnologyDsl.g:6691:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalTechnologyDsl.g:6691:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalTechnologyDsl.g:6692:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalTechnologyDsl.g:6692:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalTechnologyDsl.g:6693:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalTechnologyDsl.g:6694:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalTechnologyDsl.g:6694:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_3);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalTechnologyDsl.g:6697:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalTechnologyDsl.g:6698:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalTechnologyDsl.g:6699:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=53 && LA56_0<=54)||LA56_0==68) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6699:4: rule__Context__ComplexTypesAssignment_3
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Context__ComplexTypesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalTechnologyDsl.g:6708:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6712:1: ( rule__Context__Group__4__Impl )
            // InternalTechnologyDsl.g:6713:2: rule__Context__Group__4__Impl
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
    // InternalTechnologyDsl.g:6719:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6723:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6724:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6724:1: ( '}' )
            // InternalTechnologyDsl.g:6725:2: '}'
            {
             before(grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6735:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6739:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalTechnologyDsl.g:6740:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:6747:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6751:1: ( ( 'structure' ) )
            // InternalTechnologyDsl.g:6752:1: ( 'structure' )
            {
            // InternalTechnologyDsl.g:6752:1: ( 'structure' )
            // InternalTechnologyDsl.g:6753:2: 'structure'
            {
             before(grammarAccess.getDataStructureAccess().getStructureKeyword_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6762:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6766:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalTechnologyDsl.g:6767:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
            {
            pushFollow(FOLLOW_63);
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
    // InternalTechnologyDsl.g:6774:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6778:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6779:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6779:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6780:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6781:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalTechnologyDsl.g:6781:3: rule__DataStructure__NameAssignment_1
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
    // InternalTechnologyDsl.g:6789:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6793:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalTechnologyDsl.g:6794:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
            {
            pushFollow(FOLLOW_63);
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
    // InternalTechnologyDsl.g:6801:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6805:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalTechnologyDsl.g:6806:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalTechnologyDsl.g:6806:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalTechnologyDsl.g:6807:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalTechnologyDsl.g:6808:2: ( rule__DataStructure__Group_2__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==67) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalTechnologyDsl.g:6808:3: rule__DataStructure__Group_2__0
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
    // InternalTechnologyDsl.g:6816:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6820:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalTechnologyDsl.g:6821:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
            {
            pushFollow(FOLLOW_64);
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
    // InternalTechnologyDsl.g:6828:1: rule__DataStructure__Group__3__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6832:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6833:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6833:1: ( '{' )
            // InternalTechnologyDsl.g:6834:2: '{'
            {
             before(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6843:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6847:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalTechnologyDsl.g:6848:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
            {
            pushFollow(FOLLOW_64);
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
    // InternalTechnologyDsl.g:6855:1: rule__DataStructure__Group__4__Impl : ( ( rule__DataStructure__Group_4__0 )? ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6859:1: ( ( ( rule__DataStructure__Group_4__0 )? ) )
            // InternalTechnologyDsl.g:6860:1: ( ( rule__DataStructure__Group_4__0 )? )
            {
            // InternalTechnologyDsl.g:6860:1: ( ( rule__DataStructure__Group_4__0 )? )
            // InternalTechnologyDsl.g:6861:2: ( rule__DataStructure__Group_4__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:6862:2: ( rule__DataStructure__Group_4__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID||(LA58_0>=69 && LA58_0<=78)||LA58_0==86) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalTechnologyDsl.g:6862:3: rule__DataStructure__Group_4__0
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
    // InternalTechnologyDsl.g:6870:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6874:1: ( rule__DataStructure__Group__5__Impl )
            // InternalTechnologyDsl.g:6875:2: rule__DataStructure__Group__5__Impl
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
    // InternalTechnologyDsl.g:6881:1: rule__DataStructure__Group__5__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6885:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6886:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6886:1: ( '}' )
            // InternalTechnologyDsl.g:6887:2: '}'
            {
             before(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6897:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6901:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalTechnologyDsl.g:6902:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:6909:1: rule__DataStructure__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6913:1: ( ( 'extends' ) )
            // InternalTechnologyDsl.g:6914:1: ( 'extends' )
            {
            // InternalTechnologyDsl.g:6914:1: ( 'extends' )
            // InternalTechnologyDsl.g:6915:2: 'extends'
            {
             before(grammarAccess.getDataStructureAccess().getExtendsKeyword_2_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6924:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6928:1: ( rule__DataStructure__Group_2__1__Impl )
            // InternalTechnologyDsl.g:6929:2: rule__DataStructure__Group_2__1__Impl
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
    // InternalTechnologyDsl.g:6935:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__SuperAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6939:1: ( ( ( rule__DataStructure__SuperAssignment_2_1 ) ) )
            // InternalTechnologyDsl.g:6940:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            {
            // InternalTechnologyDsl.g:6940:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            // InternalTechnologyDsl.g:6941:2: ( rule__DataStructure__SuperAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_2_1()); 
            // InternalTechnologyDsl.g:6942:2: ( rule__DataStructure__SuperAssignment_2_1 )
            // InternalTechnologyDsl.g:6942:3: rule__DataStructure__SuperAssignment_2_1
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
    // InternalTechnologyDsl.g:6951:1: rule__DataStructure__Group_4__0 : rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 ;
    public final void rule__DataStructure__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6955:1: ( rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 )
            // InternalTechnologyDsl.g:6956:2: rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1
            {
            pushFollow(FOLLOW_65);
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
    // InternalTechnologyDsl.g:6963:1: rule__DataStructure__Group_4__0__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) ) ;
    public final void rule__DataStructure__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6967:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) ) )
            // InternalTechnologyDsl.g:6968:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) )
            {
            // InternalTechnologyDsl.g:6968:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) )
            // InternalTechnologyDsl.g:6969:2: ( rule__DataStructure__DataFieldsAssignment_4_0 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0()); 
            // InternalTechnologyDsl.g:6970:2: ( rule__DataStructure__DataFieldsAssignment_4_0 )
            // InternalTechnologyDsl.g:6970:3: rule__DataStructure__DataFieldsAssignment_4_0
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
    // InternalTechnologyDsl.g:6978:1: rule__DataStructure__Group_4__1 : rule__DataStructure__Group_4__1__Impl ;
    public final void rule__DataStructure__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6982:1: ( rule__DataStructure__Group_4__1__Impl )
            // InternalTechnologyDsl.g:6983:2: rule__DataStructure__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:6989:1: rule__DataStructure__Group_4__1__Impl : ( ( rule__DataStructure__Group_4_1__0 )* ) ;
    public final void rule__DataStructure__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6993:1: ( ( ( rule__DataStructure__Group_4_1__0 )* ) )
            // InternalTechnologyDsl.g:6994:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            {
            // InternalTechnologyDsl.g:6994:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            // InternalTechnologyDsl.g:6995:2: ( rule__DataStructure__Group_4_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_1()); 
            // InternalTechnologyDsl.g:6996:2: ( rule__DataStructure__Group_4_1__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==46) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6996:3: rule__DataStructure__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__DataStructure__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // InternalTechnologyDsl.g:7005:1: rule__DataStructure__Group_4_1__0 : rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 ;
    public final void rule__DataStructure__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7009:1: ( rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 )
            // InternalTechnologyDsl.g:7010:2: rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1
            {
            pushFollow(FOLLOW_66);
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
    // InternalTechnologyDsl.g:7017:1: rule__DataStructure__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7021:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:7022:1: ( ',' )
            {
            // InternalTechnologyDsl.g:7022:1: ( ',' )
            // InternalTechnologyDsl.g:7023:2: ','
            {
             before(grammarAccess.getDataStructureAccess().getCommaKeyword_4_1_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7032:1: rule__DataStructure__Group_4_1__1 : rule__DataStructure__Group_4_1__1__Impl ;
    public final void rule__DataStructure__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7036:1: ( rule__DataStructure__Group_4_1__1__Impl )
            // InternalTechnologyDsl.g:7037:2: rule__DataStructure__Group_4_1__1__Impl
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
    // InternalTechnologyDsl.g:7043:1: rule__DataStructure__Group_4_1__1__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7047:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) ) )
            // InternalTechnologyDsl.g:7048:1: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) )
            {
            // InternalTechnologyDsl.g:7048:1: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) )
            // InternalTechnologyDsl.g:7049:2: ( rule__DataStructure__DataFieldsAssignment_4_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_1_1()); 
            // InternalTechnologyDsl.g:7050:2: ( rule__DataStructure__DataFieldsAssignment_4_1_1 )
            // InternalTechnologyDsl.g:7050:3: rule__DataStructure__DataFieldsAssignment_4_1_1
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
    // InternalTechnologyDsl.g:7059:1: rule__ListType__Group_0__0 : rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 ;
    public final void rule__ListType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7063:1: ( rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 )
            // InternalTechnologyDsl.g:7064:2: rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:7071:1: rule__ListType__Group_0__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7075:1: ( ( 'list' ) )
            // InternalTechnologyDsl.g:7076:1: ( 'list' )
            {
            // InternalTechnologyDsl.g:7076:1: ( 'list' )
            // InternalTechnologyDsl.g:7077:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_0_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7086:1: rule__ListType__Group_0__1 : rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 ;
    public final void rule__ListType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7090:1: ( rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 )
            // InternalTechnologyDsl.g:7091:2: rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalTechnologyDsl.g:7098:1: rule__ListType__Group_0__1__Impl : ( ( rule__ListType__NameAssignment_0_1 ) ) ;
    public final void rule__ListType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7102:1: ( ( ( rule__ListType__NameAssignment_0_1 ) ) )
            // InternalTechnologyDsl.g:7103:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            {
            // InternalTechnologyDsl.g:7103:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            // InternalTechnologyDsl.g:7104:2: ( rule__ListType__NameAssignment_0_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 
            // InternalTechnologyDsl.g:7105:2: ( rule__ListType__NameAssignment_0_1 )
            // InternalTechnologyDsl.g:7105:3: rule__ListType__NameAssignment_0_1
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
    // InternalTechnologyDsl.g:7113:1: rule__ListType__Group_0__2 : rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 ;
    public final void rule__ListType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7117:1: ( rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 )
            // InternalTechnologyDsl.g:7118:2: rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3
            {
            pushFollow(FOLLOW_66);
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
    // InternalTechnologyDsl.g:7125:1: rule__ListType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7129:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:7130:1: ( '{' )
            {
            // InternalTechnologyDsl.g:7130:1: ( '{' )
            // InternalTechnologyDsl.g:7131:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7140:1: rule__ListType__Group_0__3 : rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 ;
    public final void rule__ListType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7144:1: ( rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 )
            // InternalTechnologyDsl.g:7145:2: rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4
            {
            pushFollow(FOLLOW_67);
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
    // InternalTechnologyDsl.g:7152:1: rule__ListType__Group_0__3__Impl : ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__ListType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7156:1: ( ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) )
            // InternalTechnologyDsl.g:7157:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            {
            // InternalTechnologyDsl.g:7157:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            // InternalTechnologyDsl.g:7158:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalTechnologyDsl.g:7159:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            // InternalTechnologyDsl.g:7159:3: rule__ListType__DataFieldsAssignment_0_3
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
    // InternalTechnologyDsl.g:7167:1: rule__ListType__Group_0__4 : rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 ;
    public final void rule__ListType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7171:1: ( rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 )
            // InternalTechnologyDsl.g:7172:2: rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5
            {
            pushFollow(FOLLOW_67);
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
    // InternalTechnologyDsl.g:7179:1: rule__ListType__Group_0__4__Impl : ( ( rule__ListType__Group_0_4__0 )* ) ;
    public final void rule__ListType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7183:1: ( ( ( rule__ListType__Group_0_4__0 )* ) )
            // InternalTechnologyDsl.g:7184:1: ( ( rule__ListType__Group_0_4__0 )* )
            {
            // InternalTechnologyDsl.g:7184:1: ( ( rule__ListType__Group_0_4__0 )* )
            // InternalTechnologyDsl.g:7185:2: ( rule__ListType__Group_0_4__0 )*
            {
             before(grammarAccess.getListTypeAccess().getGroup_0_4()); 
            // InternalTechnologyDsl.g:7186:2: ( rule__ListType__Group_0_4__0 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==46) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalTechnologyDsl.g:7186:3: rule__ListType__Group_0_4__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ListType__Group_0_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
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
    // InternalTechnologyDsl.g:7194:1: rule__ListType__Group_0__5 : rule__ListType__Group_0__5__Impl ;
    public final void rule__ListType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7198:1: ( rule__ListType__Group_0__5__Impl )
            // InternalTechnologyDsl.g:7199:2: rule__ListType__Group_0__5__Impl
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
    // InternalTechnologyDsl.g:7205:1: rule__ListType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__ListType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7209:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:7210:1: ( '}' )
            {
            // InternalTechnologyDsl.g:7210:1: ( '}' )
            // InternalTechnologyDsl.g:7211:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7221:1: rule__ListType__Group_0_4__0 : rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 ;
    public final void rule__ListType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7225:1: ( rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 )
            // InternalTechnologyDsl.g:7226:2: rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1
            {
            pushFollow(FOLLOW_66);
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
    // InternalTechnologyDsl.g:7233:1: rule__ListType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__ListType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7237:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:7238:1: ( ',' )
            {
            // InternalTechnologyDsl.g:7238:1: ( ',' )
            // InternalTechnologyDsl.g:7239:2: ','
            {
             before(grammarAccess.getListTypeAccess().getCommaKeyword_0_4_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7248:1: rule__ListType__Group_0_4__1 : rule__ListType__Group_0_4__1__Impl ;
    public final void rule__ListType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7252:1: ( rule__ListType__Group_0_4__1__Impl )
            // InternalTechnologyDsl.g:7253:2: rule__ListType__Group_0_4__1__Impl
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
    // InternalTechnologyDsl.g:7259:1: rule__ListType__Group_0_4__1__Impl : ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__ListType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7263:1: ( ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalTechnologyDsl.g:7264:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalTechnologyDsl.g:7264:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            // InternalTechnologyDsl.g:7265:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalTechnologyDsl.g:7266:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            // InternalTechnologyDsl.g:7266:3: rule__ListType__DataFieldsAssignment_0_4_1
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
    // InternalTechnologyDsl.g:7275:1: rule__ListType__Group_1__0 : rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 ;
    public final void rule__ListType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7279:1: ( rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 )
            // InternalTechnologyDsl.g:7280:2: rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:7287:1: rule__ListType__Group_1__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7291:1: ( ( 'list' ) )
            // InternalTechnologyDsl.g:7292:1: ( 'list' )
            {
            // InternalTechnologyDsl.g:7292:1: ( 'list' )
            // InternalTechnologyDsl.g:7293:2: 'list'
            {
             before(grammarAccess.getListTypeAccess().getListKeyword_1_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7302:1: rule__ListType__Group_1__1 : rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 ;
    public final void rule__ListType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7306:1: ( rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 )
            // InternalTechnologyDsl.g:7307:2: rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalTechnologyDsl.g:7314:1: rule__ListType__Group_1__1__Impl : ( ( rule__ListType__NameAssignment_1_1 ) ) ;
    public final void rule__ListType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7318:1: ( ( ( rule__ListType__NameAssignment_1_1 ) ) )
            // InternalTechnologyDsl.g:7319:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            {
            // InternalTechnologyDsl.g:7319:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            // InternalTechnologyDsl.g:7320:2: ( rule__ListType__NameAssignment_1_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 
            // InternalTechnologyDsl.g:7321:2: ( rule__ListType__NameAssignment_1_1 )
            // InternalTechnologyDsl.g:7321:3: rule__ListType__NameAssignment_1_1
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
    // InternalTechnologyDsl.g:7329:1: rule__ListType__Group_1__2 : rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 ;
    public final void rule__ListType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7333:1: ( rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 )
            // InternalTechnologyDsl.g:7334:2: rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3
            {
            pushFollow(FOLLOW_34);
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
    // InternalTechnologyDsl.g:7341:1: rule__ListType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7345:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:7346:1: ( '{' )
            {
            // InternalTechnologyDsl.g:7346:1: ( '{' )
            // InternalTechnologyDsl.g:7347:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7356:1: rule__ListType__Group_1__3 : rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 ;
    public final void rule__ListType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7360:1: ( rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 )
            // InternalTechnologyDsl.g:7361:2: rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalTechnologyDsl.g:7368:1: rule__ListType__Group_1__3__Impl : ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__ListType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7372:1: ( ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalTechnologyDsl.g:7373:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalTechnologyDsl.g:7373:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            // InternalTechnologyDsl.g:7374:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalTechnologyDsl.g:7375:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            // InternalTechnologyDsl.g:7375:3: rule__ListType__PrimitiveTypeAssignment_1_3
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
    // InternalTechnologyDsl.g:7383:1: rule__ListType__Group_1__4 : rule__ListType__Group_1__4__Impl ;
    public final void rule__ListType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7387:1: ( rule__ListType__Group_1__4__Impl )
            // InternalTechnologyDsl.g:7388:2: rule__ListType__Group_1__4__Impl
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
    // InternalTechnologyDsl.g:7394:1: rule__ListType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__ListType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7398:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:7399:1: ( '}' )
            {
            // InternalTechnologyDsl.g:7399:1: ( '}' )
            // InternalTechnologyDsl.g:7400:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7410:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7414:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalTechnologyDsl.g:7415:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
            {
            pushFollow(FOLLOW_66);
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
    // InternalTechnologyDsl.g:7422:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7426:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalTechnologyDsl.g:7427:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalTechnologyDsl.g:7427:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalTechnologyDsl.g:7428:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalTechnologyDsl.g:7429:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==86) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalTechnologyDsl.g:7429:3: rule__DataField__HiddenAssignment_0
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
    // InternalTechnologyDsl.g:7437:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7441:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalTechnologyDsl.g:7442:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
            {
            pushFollow(FOLLOW_66);
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
    // InternalTechnologyDsl.g:7449:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__Alternatives_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7453:1: ( ( ( rule__DataField__Alternatives_1 )? ) )
            // InternalTechnologyDsl.g:7454:1: ( ( rule__DataField__Alternatives_1 )? )
            {
            // InternalTechnologyDsl.g:7454:1: ( ( rule__DataField__Alternatives_1 )? )
            // InternalTechnologyDsl.g:7455:2: ( rule__DataField__Alternatives_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_1()); 
            // InternalTechnologyDsl.g:7456:2: ( rule__DataField__Alternatives_1 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=69 && LA62_0<=78)) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_ID) ) {
                int LA62_2 = input.LA(2);

                if ( (LA62_2==RULE_ID||LA62_2==55||LA62_2==79) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // InternalTechnologyDsl.g:7456:3: rule__DataField__Alternatives_1
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
    // InternalTechnologyDsl.g:7464:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7468:1: ( rule__DataField__Group__2__Impl )
            // InternalTechnologyDsl.g:7469:2: rule__DataField__Group__2__Impl
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
    // InternalTechnologyDsl.g:7475:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__NameAssignment_2 ) ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7479:1: ( ( ( rule__DataField__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:7480:1: ( ( rule__DataField__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:7480:1: ( ( rule__DataField__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:7481:2: ( rule__DataField__NameAssignment_2 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:7482:2: ( rule__DataField__NameAssignment_2 )
            // InternalTechnologyDsl.g:7482:3: rule__DataField__NameAssignment_2
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


    // $ANTLR start "rule__Enumeration__Group__0"
    // InternalTechnologyDsl.g:7491:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7495:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalTechnologyDsl.g:7496:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:7503:1: rule__Enumeration__Group__0__Impl : ( 'enum' ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7507:1: ( ( 'enum' ) )
            // InternalTechnologyDsl.g:7508:1: ( 'enum' )
            {
            // InternalTechnologyDsl.g:7508:1: ( 'enum' )
            // InternalTechnologyDsl.g:7509:2: 'enum'
            {
             before(grammarAccess.getEnumerationAccess().getEnumKeyword_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7518:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7522:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalTechnologyDsl.g:7523:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalTechnologyDsl.g:7530:1: rule__Enumeration__Group__1__Impl : ( ( rule__Enumeration__NameAssignment_1 ) ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7534:1: ( ( ( rule__Enumeration__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:7535:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:7535:1: ( ( rule__Enumeration__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:7536:2: ( rule__Enumeration__NameAssignment_1 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:7537:2: ( rule__Enumeration__NameAssignment_1 )
            // InternalTechnologyDsl.g:7537:3: rule__Enumeration__NameAssignment_1
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
    // InternalTechnologyDsl.g:7545:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7549:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalTechnologyDsl.g:7550:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:7557:1: rule__Enumeration__Group__2__Impl : ( '{' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7561:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:7562:1: ( '{' )
            {
            // InternalTechnologyDsl.g:7562:1: ( '{' )
            // InternalTechnologyDsl.g:7563:2: '{'
            {
             before(grammarAccess.getEnumerationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7572:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7576:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalTechnologyDsl.g:7577:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
            {
            pushFollow(FOLLOW_67);
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
    // InternalTechnologyDsl.g:7584:1: rule__Enumeration__Group__3__Impl : ( ( rule__Enumeration__FieldsAssignment_3 ) ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7588:1: ( ( ( rule__Enumeration__FieldsAssignment_3 ) ) )
            // InternalTechnologyDsl.g:7589:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:7589:1: ( ( rule__Enumeration__FieldsAssignment_3 ) )
            // InternalTechnologyDsl.g:7590:2: ( rule__Enumeration__FieldsAssignment_3 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_3()); 
            // InternalTechnologyDsl.g:7591:2: ( rule__Enumeration__FieldsAssignment_3 )
            // InternalTechnologyDsl.g:7591:3: rule__Enumeration__FieldsAssignment_3
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
    // InternalTechnologyDsl.g:7599:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7603:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalTechnologyDsl.g:7604:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
            {
            pushFollow(FOLLOW_67);
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
    // InternalTechnologyDsl.g:7611:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7615:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalTechnologyDsl.g:7616:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalTechnologyDsl.g:7616:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalTechnologyDsl.g:7617:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:7618:2: ( rule__Enumeration__Group_4__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==46) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalTechnologyDsl.g:7618:3: rule__Enumeration__Group_4__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__Enumeration__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalTechnologyDsl.g:7626:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7630:1: ( rule__Enumeration__Group__5__Impl )
            // InternalTechnologyDsl.g:7631:2: rule__Enumeration__Group__5__Impl
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
    // InternalTechnologyDsl.g:7637:1: rule__Enumeration__Group__5__Impl : ( '}' ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7641:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:7642:1: ( '}' )
            {
            // InternalTechnologyDsl.g:7642:1: ( '}' )
            // InternalTechnologyDsl.g:7643:2: '}'
            {
             before(grammarAccess.getEnumerationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7653:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7657:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalTechnologyDsl.g:7658:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:7665:1: rule__Enumeration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7669:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:7670:1: ( ',' )
            {
            // InternalTechnologyDsl.g:7670:1: ( ',' )
            // InternalTechnologyDsl.g:7671:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7680:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7684:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalTechnologyDsl.g:7685:2: rule__Enumeration__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:7691:1: rule__Enumeration__Group_4__1__Impl : ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7695:1: ( ( ( rule__Enumeration__FieldsAssignment_4_1 ) ) )
            // InternalTechnologyDsl.g:7696:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            {
            // InternalTechnologyDsl.g:7696:1: ( ( rule__Enumeration__FieldsAssignment_4_1 ) )
            // InternalTechnologyDsl.g:7697:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            {
             before(grammarAccess.getEnumerationAccess().getFieldsAssignment_4_1()); 
            // InternalTechnologyDsl.g:7698:2: ( rule__Enumeration__FieldsAssignment_4_1 )
            // InternalTechnologyDsl.g:7698:3: rule__Enumeration__FieldsAssignment_4_1
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
    // InternalTechnologyDsl.g:7707:1: rule__EnumerationField__Group__0 : rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 ;
    public final void rule__EnumerationField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7711:1: ( rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1 )
            // InternalTechnologyDsl.g:7712:2: rule__EnumerationField__Group__0__Impl rule__EnumerationField__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalTechnologyDsl.g:7719:1: rule__EnumerationField__Group__0__Impl : ( ( rule__EnumerationField__NameAssignment_0 ) ) ;
    public final void rule__EnumerationField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7723:1: ( ( ( rule__EnumerationField__NameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:7724:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:7724:1: ( ( rule__EnumerationField__NameAssignment_0 ) )
            // InternalTechnologyDsl.g:7725:2: ( rule__EnumerationField__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0()); 
            // InternalTechnologyDsl.g:7726:2: ( rule__EnumerationField__NameAssignment_0 )
            // InternalTechnologyDsl.g:7726:3: rule__EnumerationField__NameAssignment_0
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
    // InternalTechnologyDsl.g:7734:1: rule__EnumerationField__Group__1 : rule__EnumerationField__Group__1__Impl ;
    public final void rule__EnumerationField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7738:1: ( rule__EnumerationField__Group__1__Impl )
            // InternalTechnologyDsl.g:7739:2: rule__EnumerationField__Group__1__Impl
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
    // InternalTechnologyDsl.g:7745:1: rule__EnumerationField__Group__1__Impl : ( ( rule__EnumerationField__Group_1__0 )? ) ;
    public final void rule__EnumerationField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7749:1: ( ( ( rule__EnumerationField__Group_1__0 )? ) )
            // InternalTechnologyDsl.g:7750:1: ( ( rule__EnumerationField__Group_1__0 )? )
            {
            // InternalTechnologyDsl.g:7750:1: ( ( rule__EnumerationField__Group_1__0 )? )
            // InternalTechnologyDsl.g:7751:2: ( rule__EnumerationField__Group_1__0 )?
            {
             before(grammarAccess.getEnumerationFieldAccess().getGroup_1()); 
            // InternalTechnologyDsl.g:7752:2: ( rule__EnumerationField__Group_1__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==60) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalTechnologyDsl.g:7752:3: rule__EnumerationField__Group_1__0
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
    // InternalTechnologyDsl.g:7761:1: rule__EnumerationField__Group_1__0 : rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 ;
    public final void rule__EnumerationField__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7765:1: ( rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1 )
            // InternalTechnologyDsl.g:7766:2: rule__EnumerationField__Group_1__0__Impl rule__EnumerationField__Group_1__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalTechnologyDsl.g:7773:1: rule__EnumerationField__Group_1__0__Impl : ( '(' ) ;
    public final void rule__EnumerationField__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7777:1: ( ( '(' ) )
            // InternalTechnologyDsl.g:7778:1: ( '(' )
            {
            // InternalTechnologyDsl.g:7778:1: ( '(' )
            // InternalTechnologyDsl.g:7779:2: '('
            {
             before(grammarAccess.getEnumerationFieldAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,60,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7788:1: rule__EnumerationField__Group_1__1 : rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 ;
    public final void rule__EnumerationField__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7792:1: ( rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2 )
            // InternalTechnologyDsl.g:7793:2: rule__EnumerationField__Group_1__1__Impl rule__EnumerationField__Group_1__2
            {
            pushFollow(FOLLOW_68);
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
    // InternalTechnologyDsl.g:7800:1: rule__EnumerationField__Group_1__1__Impl : ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) ;
    public final void rule__EnumerationField__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7804:1: ( ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) ) )
            // InternalTechnologyDsl.g:7805:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            {
            // InternalTechnologyDsl.g:7805:1: ( ( rule__EnumerationField__InitializationValueAssignment_1_1 ) )
            // InternalTechnologyDsl.g:7806:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            {
             before(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1()); 
            // InternalTechnologyDsl.g:7807:2: ( rule__EnumerationField__InitializationValueAssignment_1_1 )
            // InternalTechnologyDsl.g:7807:3: rule__EnumerationField__InitializationValueAssignment_1_1
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
    // InternalTechnologyDsl.g:7815:1: rule__EnumerationField__Group_1__2 : rule__EnumerationField__Group_1__2__Impl ;
    public final void rule__EnumerationField__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7819:1: ( rule__EnumerationField__Group_1__2__Impl )
            // InternalTechnologyDsl.g:7820:2: rule__EnumerationField__Group_1__2__Impl
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
    // InternalTechnologyDsl.g:7826:1: rule__EnumerationField__Group_1__2__Impl : ( ')' ) ;
    public final void rule__EnumerationField__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7830:1: ( ( ')' ) )
            // InternalTechnologyDsl.g:7831:1: ( ')' )
            {
            // InternalTechnologyDsl.g:7831:1: ( ')' )
            // InternalTechnologyDsl.g:7832:2: ')'
            {
             before(grammarAccess.getEnumerationFieldAccess().getRightParenthesisKeyword_1_2()); 
            match(input,61,FOLLOW_2); 
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


    // $ANTLR start "rule__PossiblyImportedComplexType__Group__0"
    // InternalTechnologyDsl.g:7842:1: rule__PossiblyImportedComplexType__Group__0 : rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 ;
    public final void rule__PossiblyImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7846:1: ( rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 )
            // InternalTechnologyDsl.g:7847:2: rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1
            {
            pushFollow(FOLLOW_69);
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
    // InternalTechnologyDsl.g:7854:1: rule__PossiblyImportedComplexType__Group__0__Impl : ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) ;
    public final void rule__PossiblyImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7858:1: ( ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) )
            // InternalTechnologyDsl.g:7859:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            {
            // InternalTechnologyDsl.g:7859:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            // InternalTechnologyDsl.g:7860:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup_0()); 
            // InternalTechnologyDsl.g:7861:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==55) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalTechnologyDsl.g:7861:3: rule__PossiblyImportedComplexType__Group_0__0
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
    // InternalTechnologyDsl.g:7869:1: rule__PossiblyImportedComplexType__Group__1 : rule__PossiblyImportedComplexType__Group__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7873:1: ( rule__PossiblyImportedComplexType__Group__1__Impl )
            // InternalTechnologyDsl.g:7874:2: rule__PossiblyImportedComplexType__Group__1__Impl
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
    // InternalTechnologyDsl.g:7880:1: rule__PossiblyImportedComplexType__Group__1__Impl : ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7884:1: ( ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) )
            // InternalTechnologyDsl.g:7885:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:7885:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            // InternalTechnologyDsl.g:7886:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeAssignment_1()); 
            // InternalTechnologyDsl.g:7887:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            // InternalTechnologyDsl.g:7887:3: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1
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
    // InternalTechnologyDsl.g:7896:1: rule__PossiblyImportedComplexType__Group_0__0 : rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 ;
    public final void rule__PossiblyImportedComplexType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7900:1: ( rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 )
            // InternalTechnologyDsl.g:7901:2: rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalTechnologyDsl.g:7908:1: rule__PossiblyImportedComplexType__Group_0__0__Impl : ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7912:1: ( ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) )
            // InternalTechnologyDsl.g:7913:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            {
            // InternalTechnologyDsl.g:7913:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            // InternalTechnologyDsl.g:7914:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportAssignment_0_0()); 
            // InternalTechnologyDsl.g:7915:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            // InternalTechnologyDsl.g:7915:3: rule__PossiblyImportedComplexType__ImportAssignment_0_0
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
    // InternalTechnologyDsl.g:7923:1: rule__PossiblyImportedComplexType__Group_0__1 : rule__PossiblyImportedComplexType__Group_0__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7927:1: ( rule__PossiblyImportedComplexType__Group_0__1__Impl )
            // InternalTechnologyDsl.g:7928:2: rule__PossiblyImportedComplexType__Group_0__1__Impl
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
    // InternalTechnologyDsl.g:7934:1: rule__PossiblyImportedComplexType__Group_0__1__Impl : ( '::' ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7938:1: ( ( '::' ) )
            // InternalTechnologyDsl.g:7939:1: ( '::' )
            {
            // InternalTechnologyDsl.g:7939:1: ( '::' )
            // InternalTechnologyDsl.g:7940:2: '::'
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getColonColonKeyword_0_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7950:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7954:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalTechnologyDsl.g:7955:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_70);
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
    // InternalTechnologyDsl.g:7962:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7966:1: ( ( () ) )
            // InternalTechnologyDsl.g:7967:1: ( () )
            {
            // InternalTechnologyDsl.g:7967:1: ( () )
            // InternalTechnologyDsl.g:7968:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalTechnologyDsl.g:7969:2: ()
            // InternalTechnologyDsl.g:7969:3: 
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
    // InternalTechnologyDsl.g:7977:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7981:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalTechnologyDsl.g:7982:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalTechnologyDsl.g:7988:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7992:1: ( ( 'boolean' ) )
            // InternalTechnologyDsl.g:7993:1: ( 'boolean' )
            {
            // InternalTechnologyDsl.g:7993:1: ( 'boolean' )
            // InternalTechnologyDsl.g:7994:2: 'boolean'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 
            match(input,69,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8004:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8008:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalTechnologyDsl.g:8009:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_71);
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
    // InternalTechnologyDsl.g:8016:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8020:1: ( ( () ) )
            // InternalTechnologyDsl.g:8021:1: ( () )
            {
            // InternalTechnologyDsl.g:8021:1: ( () )
            // InternalTechnologyDsl.g:8022:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalTechnologyDsl.g:8023:2: ()
            // InternalTechnologyDsl.g:8023:3: 
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
    // InternalTechnologyDsl.g:8031:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8035:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalTechnologyDsl.g:8036:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalTechnologyDsl.g:8042:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8046:1: ( ( 'byte' ) )
            // InternalTechnologyDsl.g:8047:1: ( 'byte' )
            {
            // InternalTechnologyDsl.g:8047:1: ( 'byte' )
            // InternalTechnologyDsl.g:8048:2: 'byte'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8058:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8062:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalTechnologyDsl.g:8063:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_72);
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
    // InternalTechnologyDsl.g:8070:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8074:1: ( ( () ) )
            // InternalTechnologyDsl.g:8075:1: ( () )
            {
            // InternalTechnologyDsl.g:8075:1: ( () )
            // InternalTechnologyDsl.g:8076:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalTechnologyDsl.g:8077:2: ()
            // InternalTechnologyDsl.g:8077:3: 
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
    // InternalTechnologyDsl.g:8085:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8089:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalTechnologyDsl.g:8090:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalTechnologyDsl.g:8096:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8100:1: ( ( 'char' ) )
            // InternalTechnologyDsl.g:8101:1: ( 'char' )
            {
            // InternalTechnologyDsl.g:8101:1: ( 'char' )
            // InternalTechnologyDsl.g:8102:2: 'char'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 
            match(input,71,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8112:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8116:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalTechnologyDsl.g:8117:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_73);
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
    // InternalTechnologyDsl.g:8124:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8128:1: ( ( () ) )
            // InternalTechnologyDsl.g:8129:1: ( () )
            {
            // InternalTechnologyDsl.g:8129:1: ( () )
            // InternalTechnologyDsl.g:8130:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalTechnologyDsl.g:8131:2: ()
            // InternalTechnologyDsl.g:8131:3: 
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
    // InternalTechnologyDsl.g:8139:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8143:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalTechnologyDsl.g:8144:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalTechnologyDsl.g:8150:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8154:1: ( ( 'date' ) )
            // InternalTechnologyDsl.g:8155:1: ( 'date' )
            {
            // InternalTechnologyDsl.g:8155:1: ( 'date' )
            // InternalTechnologyDsl.g:8156:2: 'date'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 
            match(input,72,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8166:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8170:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalTechnologyDsl.g:8171:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
            {
            pushFollow(FOLLOW_74);
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
    // InternalTechnologyDsl.g:8178:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8182:1: ( ( () ) )
            // InternalTechnologyDsl.g:8183:1: ( () )
            {
            // InternalTechnologyDsl.g:8183:1: ( () )
            // InternalTechnologyDsl.g:8184:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalTechnologyDsl.g:8185:2: ()
            // InternalTechnologyDsl.g:8185:3: 
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
    // InternalTechnologyDsl.g:8193:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8197:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalTechnologyDsl.g:8198:2: rule__PrimitiveType__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:8204:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8208:1: ( ( 'double' ) )
            // InternalTechnologyDsl.g:8209:1: ( 'double' )
            {
            // InternalTechnologyDsl.g:8209:1: ( 'double' )
            // InternalTechnologyDsl.g:8210:2: 'double'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 
            match(input,73,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8220:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8224:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalTechnologyDsl.g:8225:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
            {
            pushFollow(FOLLOW_75);
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
    // InternalTechnologyDsl.g:8232:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8236:1: ( ( () ) )
            // InternalTechnologyDsl.g:8237:1: ( () )
            {
            // InternalTechnologyDsl.g:8237:1: ( () )
            // InternalTechnologyDsl.g:8238:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalTechnologyDsl.g:8239:2: ()
            // InternalTechnologyDsl.g:8239:3: 
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
    // InternalTechnologyDsl.g:8247:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8251:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalTechnologyDsl.g:8252:2: rule__PrimitiveType__Group_5__1__Impl
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
    // InternalTechnologyDsl.g:8258:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8262:1: ( ( 'float' ) )
            // InternalTechnologyDsl.g:8263:1: ( 'float' )
            {
            // InternalTechnologyDsl.g:8263:1: ( 'float' )
            // InternalTechnologyDsl.g:8264:2: 'float'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 
            match(input,74,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8274:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8278:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalTechnologyDsl.g:8279:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
            {
            pushFollow(FOLLOW_76);
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
    // InternalTechnologyDsl.g:8286:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8290:1: ( ( () ) )
            // InternalTechnologyDsl.g:8291:1: ( () )
            {
            // InternalTechnologyDsl.g:8291:1: ( () )
            // InternalTechnologyDsl.g:8292:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalTechnologyDsl.g:8293:2: ()
            // InternalTechnologyDsl.g:8293:3: 
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
    // InternalTechnologyDsl.g:8301:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8305:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalTechnologyDsl.g:8306:2: rule__PrimitiveType__Group_6__1__Impl
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
    // InternalTechnologyDsl.g:8312:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8316:1: ( ( 'int' ) )
            // InternalTechnologyDsl.g:8317:1: ( 'int' )
            {
            // InternalTechnologyDsl.g:8317:1: ( 'int' )
            // InternalTechnologyDsl.g:8318:2: 'int'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 
            match(input,75,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8328:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8332:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalTechnologyDsl.g:8333:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
            {
            pushFollow(FOLLOW_77);
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
    // InternalTechnologyDsl.g:8340:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8344:1: ( ( () ) )
            // InternalTechnologyDsl.g:8345:1: ( () )
            {
            // InternalTechnologyDsl.g:8345:1: ( () )
            // InternalTechnologyDsl.g:8346:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalTechnologyDsl.g:8347:2: ()
            // InternalTechnologyDsl.g:8347:3: 
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
    // InternalTechnologyDsl.g:8355:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8359:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalTechnologyDsl.g:8360:2: rule__PrimitiveType__Group_7__1__Impl
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
    // InternalTechnologyDsl.g:8366:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8370:1: ( ( 'long' ) )
            // InternalTechnologyDsl.g:8371:1: ( 'long' )
            {
            // InternalTechnologyDsl.g:8371:1: ( 'long' )
            // InternalTechnologyDsl.g:8372:2: 'long'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 
            match(input,76,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8382:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8386:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalTechnologyDsl.g:8387:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
            {
            pushFollow(FOLLOW_78);
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
    // InternalTechnologyDsl.g:8394:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8398:1: ( ( () ) )
            // InternalTechnologyDsl.g:8399:1: ( () )
            {
            // InternalTechnologyDsl.g:8399:1: ( () )
            // InternalTechnologyDsl.g:8400:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalTechnologyDsl.g:8401:2: ()
            // InternalTechnologyDsl.g:8401:3: 
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
    // InternalTechnologyDsl.g:8409:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8413:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalTechnologyDsl.g:8414:2: rule__PrimitiveType__Group_8__1__Impl
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
    // InternalTechnologyDsl.g:8420:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8424:1: ( ( 'short' ) )
            // InternalTechnologyDsl.g:8425:1: ( 'short' )
            {
            // InternalTechnologyDsl.g:8425:1: ( 'short' )
            // InternalTechnologyDsl.g:8426:2: 'short'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 
            match(input,77,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8436:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8440:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalTechnologyDsl.g:8441:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalTechnologyDsl.g:8448:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8452:1: ( ( () ) )
            // InternalTechnologyDsl.g:8453:1: ( () )
            {
            // InternalTechnologyDsl.g:8453:1: ( () )
            // InternalTechnologyDsl.g:8454:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalTechnologyDsl.g:8455:2: ()
            // InternalTechnologyDsl.g:8455:3: 
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
    // InternalTechnologyDsl.g:8463:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8467:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalTechnologyDsl.g:8468:2: rule__PrimitiveType__Group_9__1__Impl
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
    // InternalTechnologyDsl.g:8474:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8478:1: ( ( 'string' ) )
            // InternalTechnologyDsl.g:8479:1: ( 'string' )
            {
            // InternalTechnologyDsl.g:8479:1: ( 'string' )
            // InternalTechnologyDsl.g:8480:2: 'string'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8490:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8494:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalTechnologyDsl.g:8495:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_79);
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
    // InternalTechnologyDsl.g:8502:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8506:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8507:1: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8507:1: ( RULE_ID )
            // InternalTechnologyDsl.g:8508:2: RULE_ID
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
    // InternalTechnologyDsl.g:8517:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8521:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalTechnologyDsl.g:8522:2: rule__QualifiedName__Group__1__Impl
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
    // InternalTechnologyDsl.g:8528:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8532:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalTechnologyDsl.g:8533:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalTechnologyDsl.g:8533:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalTechnologyDsl.g:8534:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalTechnologyDsl.g:8535:2: ( rule__QualifiedName__Group_1__0 )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==79) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalTechnologyDsl.g:8535:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_80);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // InternalTechnologyDsl.g:8544:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8548:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalTechnologyDsl.g:8549:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTechnologyDsl.g:8556:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8560:1: ( ( '.' ) )
            // InternalTechnologyDsl.g:8561:1: ( '.' )
            {
            // InternalTechnologyDsl.g:8561:1: ( '.' )
            // InternalTechnologyDsl.g:8562:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8571:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8575:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalTechnologyDsl.g:8576:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalTechnologyDsl.g:8582:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8586:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8587:1: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8587:1: ( RULE_ID )
            // InternalTechnologyDsl.g:8588:2: RULE_ID
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


    // $ANTLR start "rule__Technology__ImportsAssignment_0"
    // InternalTechnologyDsl.g:8598:1: rule__Technology__ImportsAssignment_0 : ( ruleTechnologyImport ) ;
    public final void rule__Technology__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8602:1: ( ( ruleTechnologyImport ) )
            // InternalTechnologyDsl.g:8603:2: ( ruleTechnologyImport )
            {
            // InternalTechnologyDsl.g:8603:2: ( ruleTechnologyImport )
            // InternalTechnologyDsl.g:8604:3: ruleTechnologyImport
            {
             before(grammarAccess.getTechnologyAccess().getImportsTechnologyImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologyImport();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getImportsTechnologyImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__ImportsAssignment_0"


    // $ANTLR start "rule__Technology__NameAssignment_2"
    // InternalTechnologyDsl.g:8613:1: rule__Technology__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Technology__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8617:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8618:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8618:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8619:3: RULE_ID
            {
             before(grammarAccess.getTechnologyAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTechnologyAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__NameAssignment_2"


    // $ANTLR start "rule__Technology__PrimitiveTypesAssignment_4_2_0"
    // InternalTechnologyDsl.g:8628:1: rule__Technology__PrimitiveTypesAssignment_4_2_0 : ( ruleTechnologySpecificPrimitiveType ) ;
    public final void rule__Technology__PrimitiveTypesAssignment_4_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8632:1: ( ( ruleTechnologySpecificPrimitiveType ) )
            // InternalTechnologyDsl.g:8633:2: ( ruleTechnologySpecificPrimitiveType )
            {
            // InternalTechnologyDsl.g:8633:2: ( ruleTechnologySpecificPrimitiveType )
            // InternalTechnologyDsl.g:8634:3: ruleTechnologySpecificPrimitiveType
            {
             before(grammarAccess.getTechnologyAccess().getPrimitiveTypesTechnologySpecificPrimitiveTypeParserRuleCall_4_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificPrimitiveType();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getPrimitiveTypesTechnologySpecificPrimitiveTypeParserRuleCall_4_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__PrimitiveTypesAssignment_4_2_0"


    // $ANTLR start "rule__Technology__ListTypesAssignment_4_2_1"
    // InternalTechnologyDsl.g:8643:1: rule__Technology__ListTypesAssignment_4_2_1 : ( ruleTechnologySpecificListType ) ;
    public final void rule__Technology__ListTypesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8647:1: ( ( ruleTechnologySpecificListType ) )
            // InternalTechnologyDsl.g:8648:2: ( ruleTechnologySpecificListType )
            {
            // InternalTechnologyDsl.g:8648:2: ( ruleTechnologySpecificListType )
            // InternalTechnologyDsl.g:8649:3: ruleTechnologySpecificListType
            {
             before(grammarAccess.getTechnologyAccess().getListTypesTechnologySpecificListTypeParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificListType();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getListTypesTechnologySpecificListTypeParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__ListTypesAssignment_4_2_1"


    // $ANTLR start "rule__Technology__DataStructuresAssignment_4_2_2"
    // InternalTechnologyDsl.g:8658:1: rule__Technology__DataStructuresAssignment_4_2_2 : ( ruleTechnologySpecificDataStructure ) ;
    public final void rule__Technology__DataStructuresAssignment_4_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8662:1: ( ( ruleTechnologySpecificDataStructure ) )
            // InternalTechnologyDsl.g:8663:2: ( ruleTechnologySpecificDataStructure )
            {
            // InternalTechnologyDsl.g:8663:2: ( ruleTechnologySpecificDataStructure )
            // InternalTechnologyDsl.g:8664:3: ruleTechnologySpecificDataStructure
            {
             before(grammarAccess.getTechnologyAccess().getDataStructuresTechnologySpecificDataStructureParserRuleCall_4_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificDataStructure();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getDataStructuresTechnologySpecificDataStructureParserRuleCall_4_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__DataStructuresAssignment_4_2_2"


    // $ANTLR start "rule__Technology__CompatibilityEntriesAssignment_4_3_3"
    // InternalTechnologyDsl.g:8673:1: rule__Technology__CompatibilityEntriesAssignment_4_3_3 : ( ruleCompatibilityMatrixEntry ) ;
    public final void rule__Technology__CompatibilityEntriesAssignment_4_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8677:1: ( ( ruleCompatibilityMatrixEntry ) )
            // InternalTechnologyDsl.g:8678:2: ( ruleCompatibilityMatrixEntry )
            {
            // InternalTechnologyDsl.g:8678:2: ( ruleCompatibilityMatrixEntry )
            // InternalTechnologyDsl.g:8679:3: ruleCompatibilityMatrixEntry
            {
             before(grammarAccess.getTechnologyAccess().getCompatibilityEntriesCompatibilityMatrixEntryParserRuleCall_4_3_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCompatibilityMatrixEntry();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getCompatibilityEntriesCompatibilityMatrixEntryParserRuleCall_4_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__CompatibilityEntriesAssignment_4_3_3"


    // $ANTLR start "rule__Technology__ProtocolsAssignment_5_2"
    // InternalTechnologyDsl.g:8688:1: rule__Technology__ProtocolsAssignment_5_2 : ( ruleProtocol ) ;
    public final void rule__Technology__ProtocolsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8692:1: ( ( ruleProtocol ) )
            // InternalTechnologyDsl.g:8693:2: ( ruleProtocol )
            {
            // InternalTechnologyDsl.g:8693:2: ( ruleProtocol )
            // InternalTechnologyDsl.g:8694:3: ruleProtocol
            {
             before(grammarAccess.getTechnologyAccess().getProtocolsProtocolParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
            ruleProtocol();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getProtocolsProtocolParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__ProtocolsAssignment_5_2"


    // $ANTLR start "rule__Technology__ServiceAspectsAssignment_6_3"
    // InternalTechnologyDsl.g:8703:1: rule__Technology__ServiceAspectsAssignment_6_3 : ( ruleServiceAspect ) ;
    public final void rule__Technology__ServiceAspectsAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8707:1: ( ( ruleServiceAspect ) )
            // InternalTechnologyDsl.g:8708:2: ( ruleServiceAspect )
            {
            // InternalTechnologyDsl.g:8708:2: ( ruleServiceAspect )
            // InternalTechnologyDsl.g:8709:3: ruleServiceAspect
            {
             before(grammarAccess.getTechnologyAccess().getServiceAspectsServiceAspectParserRuleCall_6_3_0()); 
            pushFollow(FOLLOW_2);
            ruleServiceAspect();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getServiceAspectsServiceAspectParserRuleCall_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__ServiceAspectsAssignment_6_3"


    // $ANTLR start "rule__Technology__DeploymentTechnologiesAssignment_7_3"
    // InternalTechnologyDsl.g:8718:1: rule__Technology__DeploymentTechnologiesAssignment_7_3 : ( ruleDeploymentTechnology ) ;
    public final void rule__Technology__DeploymentTechnologiesAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8722:1: ( ( ruleDeploymentTechnology ) )
            // InternalTechnologyDsl.g:8723:2: ( ruleDeploymentTechnology )
            {
            // InternalTechnologyDsl.g:8723:2: ( ruleDeploymentTechnology )
            // InternalTechnologyDsl.g:8724:3: ruleDeploymentTechnology
            {
             before(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesDeploymentTechnologyParserRuleCall_7_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDeploymentTechnology();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesDeploymentTechnologyParserRuleCall_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__DeploymentTechnologiesAssignment_7_3"


    // $ANTLR start "rule__Technology__InfrastructureTechnologiesAssignment_8_3"
    // InternalTechnologyDsl.g:8733:1: rule__Technology__InfrastructureTechnologiesAssignment_8_3 : ( ruleInfrastructureTechnology ) ;
    public final void rule__Technology__InfrastructureTechnologiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8737:1: ( ( ruleInfrastructureTechnology ) )
            // InternalTechnologyDsl.g:8738:2: ( ruleInfrastructureTechnology )
            {
            // InternalTechnologyDsl.g:8738:2: ( ruleInfrastructureTechnology )
            // InternalTechnologyDsl.g:8739:3: ruleInfrastructureTechnology
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesInfrastructureTechnologyParserRuleCall_8_3_0()); 
            pushFollow(FOLLOW_2);
            ruleInfrastructureTechnology();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesInfrastructureTechnologyParserRuleCall_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__InfrastructureTechnologiesAssignment_8_3"


    // $ANTLR start "rule__Technology__OperationAspectsAssignment_9_3"
    // InternalTechnologyDsl.g:8748:1: rule__Technology__OperationAspectsAssignment_9_3 : ( ruleOperationAspect ) ;
    public final void rule__Technology__OperationAspectsAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8752:1: ( ( ruleOperationAspect ) )
            // InternalTechnologyDsl.g:8753:2: ( ruleOperationAspect )
            {
            // InternalTechnologyDsl.g:8753:2: ( ruleOperationAspect )
            // InternalTechnologyDsl.g:8754:3: ruleOperationAspect
            {
             before(grammarAccess.getTechnologyAccess().getOperationAspectsOperationAspectParserRuleCall_9_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationAspect();

            state._fsp--;

             after(grammarAccess.getTechnologyAccess().getOperationAspectsOperationAspectParserRuleCall_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Technology__OperationAspectsAssignment_9_3"


    // $ANTLR start "rule__TechnologyImport__ImportURIAssignment_3"
    // InternalTechnologyDsl.g:8763:1: rule__TechnologyImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__TechnologyImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8767:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:8768:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:8768:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:8769:3: RULE_STRING
            {
             before(grammarAccess.getTechnologyImportAccess().getImportURISTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTechnologyImportAccess().getImportURISTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__ImportURIAssignment_3"


    // $ANTLR start "rule__TechnologyImport__NameAssignment_5"
    // InternalTechnologyDsl.g:8778:1: rule__TechnologyImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__TechnologyImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8782:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8783:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8783:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8784:3: RULE_ID
            {
             before(grammarAccess.getTechnologyImportAccess().getNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTechnologyImportAccess().getNameIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologyImport__NameAssignment_5"


    // $ANTLR start "rule__Protocol__CommunicationTypeAssignment_0"
    // InternalTechnologyDsl.g:8793:1: rule__Protocol__CommunicationTypeAssignment_0 : ( ruleCommunicationType ) ;
    public final void rule__Protocol__CommunicationTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8797:1: ( ( ruleCommunicationType ) )
            // InternalTechnologyDsl.g:8798:2: ( ruleCommunicationType )
            {
            // InternalTechnologyDsl.g:8798:2: ( ruleCommunicationType )
            // InternalTechnologyDsl.g:8799:3: ruleCommunicationType
            {
             before(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCommunicationType();

            state._fsp--;

             after(grammarAccess.getProtocolAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__CommunicationTypeAssignment_0"


    // $ANTLR start "rule__Protocol__NameAssignment_1"
    // InternalTechnologyDsl.g:8808:1: rule__Protocol__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Protocol__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8812:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8813:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8813:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8814:3: RULE_ID
            {
             before(grammarAccess.getProtocolAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__NameAssignment_1"


    // $ANTLR start "rule__Protocol__DataFormatsAssignment_4"
    // InternalTechnologyDsl.g:8823:1: rule__Protocol__DataFormatsAssignment_4 : ( ruleDataFormat ) ;
    public final void rule__Protocol__DataFormatsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8827:1: ( ( ruleDataFormat ) )
            // InternalTechnologyDsl.g:8828:2: ( ruleDataFormat )
            {
            // InternalTechnologyDsl.g:8828:2: ( ruleDataFormat )
            // InternalTechnologyDsl.g:8829:3: ruleDataFormat
            {
             before(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDataFormat();

            state._fsp--;

             after(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__DataFormatsAssignment_4"


    // $ANTLR start "rule__Protocol__DataFormatsAssignment_5_1"
    // InternalTechnologyDsl.g:8838:1: rule__Protocol__DataFormatsAssignment_5_1 : ( ruleDataFormat ) ;
    public final void rule__Protocol__DataFormatsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8842:1: ( ( ruleDataFormat ) )
            // InternalTechnologyDsl.g:8843:2: ( ruleDataFormat )
            {
            // InternalTechnologyDsl.g:8843:2: ( ruleDataFormat )
            // InternalTechnologyDsl.g:8844:3: ruleDataFormat
            {
             before(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataFormat();

            state._fsp--;

             after(grammarAccess.getProtocolAccess().getDataFormatsDataFormatParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__DataFormatsAssignment_5_1"


    // $ANTLR start "rule__Protocol__DefaultAssignment_6_0"
    // InternalTechnologyDsl.g:8853:1: rule__Protocol__DefaultAssignment_6_0 : ( ( 'default' ) ) ;
    public final void rule__Protocol__DefaultAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8857:1: ( ( ( 'default' ) ) )
            // InternalTechnologyDsl.g:8858:2: ( ( 'default' ) )
            {
            // InternalTechnologyDsl.g:8858:2: ( ( 'default' ) )
            // InternalTechnologyDsl.g:8859:3: ( 'default' )
            {
             before(grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0()); 
            // InternalTechnologyDsl.g:8860:3: ( 'default' )
            // InternalTechnologyDsl.g:8861:4: 'default'
            {
             before(grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0()); 

            }

             after(grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__DefaultAssignment_6_0"


    // $ANTLR start "rule__Protocol__DefaultFormatAssignment_6_3"
    // InternalTechnologyDsl.g:8872:1: rule__Protocol__DefaultFormatAssignment_6_3 : ( ( RULE_ID ) ) ;
    public final void rule__Protocol__DefaultFormatAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8876:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:8877:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:8877:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8878:3: ( RULE_ID )
            {
             before(grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0()); 
            // InternalTechnologyDsl.g:8879:3: ( RULE_ID )
            // InternalTechnologyDsl.g:8880:4: RULE_ID
            {
             before(grammarAccess.getProtocolAccess().getDefaultFormatDataFormatIDTerminalRuleCall_6_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getProtocolAccess().getDefaultFormatDataFormatIDTerminalRuleCall_6_3_0_1()); 

            }

             after(grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Protocol__DefaultFormatAssignment_6_3"


    // $ANTLR start "rule__DataFormat__FormatNameAssignment"
    // InternalTechnologyDsl.g:8891:1: rule__DataFormat__FormatNameAssignment : ( RULE_ID ) ;
    public final void rule__DataFormat__FormatNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8895:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8896:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8896:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8897:3: RULE_ID
            {
             before(grammarAccess.getDataFormatAccess().getFormatNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataFormatAccess().getFormatNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataFormat__FormatNameAssignment"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__NameAssignment_2"
    // InternalTechnologyDsl.g:8906:1: rule__TechnologySpecificPrimitiveType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificPrimitiveType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8910:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8911:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8911:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8912:3: RULE_ID
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__NameAssignment_2"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2"
    // InternalTechnologyDsl.g:8921:1: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 : ( rulePrimitiveType ) ;
    public final void rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8925:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:8926:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:8926:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:8927:3: rulePrimitiveType
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1"
    // InternalTechnologyDsl.g:8936:1: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 : ( rulePrimitiveType ) ;
    public final void rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8940:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:8941:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:8941:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:8942:3: rulePrimitiveType
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesPrimitiveTypeParserRuleCall_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1"


    // $ANTLR start "rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4"
    // InternalTechnologyDsl.g:8951:1: rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 : ( ( 'default' ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8955:1: ( ( ( 'default' ) ) )
            // InternalTechnologyDsl.g:8956:2: ( ( 'default' ) )
            {
            // InternalTechnologyDsl.g:8956:2: ( ( 'default' ) )
            // InternalTechnologyDsl.g:8957:3: ( 'default' )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0()); 
            // InternalTechnologyDsl.g:8958:3: ( 'default' )
            // InternalTechnologyDsl.g:8959:4: 'default'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0()); 

            }

             after(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4"


    // $ANTLR start "rule__TechnologySpecificListType__NameAssignment_2"
    // InternalTechnologyDsl.g:8970:1: rule__TechnologySpecificListType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificListType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8974:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8975:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8975:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8976:3: RULE_ID
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificListTypeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificListType__NameAssignment_2"


    // $ANTLR start "rule__TechnologySpecificDataStructure__NameAssignment_2"
    // InternalTechnologyDsl.g:8985:1: rule__TechnologySpecificDataStructure__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificDataStructure__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8989:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8990:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8990:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8991:3: RULE_ID
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificDataStructureAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificDataStructure__NameAssignment_2"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0"
    // InternalTechnologyDsl.g:9000:1: rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9004:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:9005:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:9005:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9006:3: ( RULE_ID )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0()); 
            // InternalTechnologyDsl.g:9007:3: ( RULE_ID )
            // InternalTechnologyDsl.g:9008:4: RULE_ID
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0"


    // $ANTLR start "rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1"
    // InternalTechnologyDsl.g:9019:1: rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9023:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:9024:2: ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:9024:2: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:9025:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeTypeCrossReference_1_0()); 
            // InternalTechnologyDsl.g:9026:3: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:9027:4: ruleQualifiedName
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeTypeQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeTypeQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1"


    // $ANTLR start "rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0"
    // InternalTechnologyDsl.g:9038:1: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 : ( rulePossiblyImportedTechnologySpecificType ) ;
    public final void rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9042:1: ( ( rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:9043:2: ( rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:9043:2: ( rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:9044:3: rulePossiblyImportedTechnologySpecificType
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePossiblyImportedTechnologySpecificType();

            state._fsp--;

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0"


    // $ANTLR start "rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1"
    // InternalTechnologyDsl.g:9053:1: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 : ( rulePossiblyImportedTechnologySpecificType ) ;
    public final void rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9057:1: ( ( rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:9058:2: ( rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:9058:2: ( rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:9059:3: rulePossiblyImportedTechnologySpecificType
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePossiblyImportedTechnologySpecificType();

            state._fsp--;

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesPossiblyImportedTechnologySpecificTypeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1"


    // $ANTLR start "rule__CompatibilityMatrixEntry__DirectionAssignment_2"
    // InternalTechnologyDsl.g:9068:1: rule__CompatibilityMatrixEntry__DirectionAssignment_2 : ( ruleCompatibilityDirection ) ;
    public final void rule__CompatibilityMatrixEntry__DirectionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9072:1: ( ( ruleCompatibilityDirection ) )
            // InternalTechnologyDsl.g:9073:2: ( ruleCompatibilityDirection )
            {
            // InternalTechnologyDsl.g:9073:2: ( ruleCompatibilityDirection )
            // InternalTechnologyDsl.g:9074:3: ruleCompatibilityDirection
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCompatibilityDirection();

            state._fsp--;

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionCompatibilityDirectionEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__DirectionAssignment_2"


    // $ANTLR start "rule__CompatibilityMatrixEntry__MappingTypeAssignment_3"
    // InternalTechnologyDsl.g:9083:1: rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 : ( rulePossiblyImportedTechnologySpecificType ) ;
    public final void rule__CompatibilityMatrixEntry__MappingTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9087:1: ( ( rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:9088:2: ( rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:9088:2: ( rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:9089:3: rulePossiblyImportedTechnologySpecificType
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePossiblyImportedTechnologySpecificType();

            state._fsp--;

             after(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypePossiblyImportedTechnologySpecificTypeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompatibilityMatrixEntry__MappingTypeAssignment_3"


    // $ANTLR start "rule__DeploymentTechnology__NameAssignment_0"
    // InternalTechnologyDsl.g:9098:1: rule__DeploymentTechnology__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__DeploymentTechnology__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9102:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9103:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9103:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9104:3: RULE_ID
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeploymentTechnologyAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__NameAssignment_0"


    // $ANTLR start "rule__DeploymentTechnology__OperationEnvironmentsAssignment_5"
    // InternalTechnologyDsl.g:9113:1: rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 : ( ruleOperationEnvironment ) ;
    public final void rule__DeploymentTechnology__OperationEnvironmentsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9117:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:9118:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:9118:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:9119:3: ruleOperationEnvironment
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationEnvironment();

            state._fsp--;

             after(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__OperationEnvironmentsAssignment_5"


    // $ANTLR start "rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1"
    // InternalTechnologyDsl.g:9128:1: rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 : ( ruleOperationEnvironment ) ;
    public final void rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9132:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:9133:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:9133:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:9134:3: ruleOperationEnvironment
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationEnvironment();

            state._fsp--;

             after(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1"


    // $ANTLR start "rule__DeploymentTechnology__ServicePropertiesAssignment_8_3"
    // InternalTechnologyDsl.g:9143:1: rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__DeploymentTechnology__ServicePropertiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9147:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:9148:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:9148:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:9149:3: ruleTechnologySpecificProperty
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificProperty();

            state._fsp--;

             after(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeploymentTechnology__ServicePropertiesAssignment_8_3"


    // $ANTLR start "rule__InfrastructureTechnology__NameAssignment_0"
    // InternalTechnologyDsl.g:9158:1: rule__InfrastructureTechnology__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__InfrastructureTechnology__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9162:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9163:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9163:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9164:3: RULE_ID
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getInfrastructureTechnologyAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__NameAssignment_0"


    // $ANTLR start "rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5"
    // InternalTechnologyDsl.g:9173:1: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 : ( ruleOperationEnvironment ) ;
    public final void rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9177:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:9178:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:9178:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:9179:3: ruleOperationEnvironment
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationEnvironment();

            state._fsp--;

             after(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5"


    // $ANTLR start "rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1"
    // InternalTechnologyDsl.g:9188:1: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 : ( ruleOperationEnvironment ) ;
    public final void rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9192:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:9193:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:9193:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:9194:3: ruleOperationEnvironment
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationEnvironment();

            state._fsp--;

             after(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsOperationEnvironmentParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1"


    // $ANTLR start "rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3"
    // InternalTechnologyDsl.g:9203:1: rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9207:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:9208:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:9208:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:9209:3: ruleTechnologySpecificProperty
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificProperty();

            state._fsp--;

             after(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesTechnologySpecificPropertyParserRuleCall_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3"


    // $ANTLR start "rule__OperationEnvironment__EnvironmentNameAssignment_0"
    // InternalTechnologyDsl.g:9218:1: rule__OperationEnvironment__EnvironmentNameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__OperationEnvironment__EnvironmentNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9222:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:9223:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:9223:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:9224:3: RULE_STRING
            {
             before(grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationEnvironment__EnvironmentNameAssignment_0"


    // $ANTLR start "rule__OperationEnvironment__DefaultAssignment_1"
    // InternalTechnologyDsl.g:9233:1: rule__OperationEnvironment__DefaultAssignment_1 : ( ( 'default' ) ) ;
    public final void rule__OperationEnvironment__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9237:1: ( ( ( 'default' ) ) )
            // InternalTechnologyDsl.g:9238:2: ( ( 'default' ) )
            {
            // InternalTechnologyDsl.g:9238:2: ( ( 'default' ) )
            // InternalTechnologyDsl.g:9239:3: ( 'default' )
            {
             before(grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0()); 
            // InternalTechnologyDsl.g:9240:3: ( 'default' )
            // InternalTechnologyDsl.g:9241:4: 'default'
            {
             before(grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0()); 

            }

             after(grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationEnvironment__DefaultAssignment_1"


    // $ANTLR start "rule__TechnologySpecificProperty__TypeAssignment_0"
    // InternalTechnologyDsl.g:9252:1: rule__TechnologySpecificProperty__TypeAssignment_0 : ( rulePrimitiveType ) ;
    public final void rule__TechnologySpecificProperty__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9256:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:9257:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:9257:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:9258:3: rulePrimitiveType
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificPropertyAccess().getTypePrimitiveTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__TypeAssignment_0"


    // $ANTLR start "rule__TechnologySpecificProperty__NameAssignment_1"
    // InternalTechnologyDsl.g:9267:1: rule__TechnologySpecificProperty__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificProperty__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9271:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9272:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9272:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9273:3: RULE_ID
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPropertyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__NameAssignment_1"


    // $ANTLR start "rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1"
    // InternalTechnologyDsl.g:9282:1: rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 : ( rulePrimitiveValue ) ;
    public final void rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9286:1: ( ( rulePrimitiveValue ) )
            // InternalTechnologyDsl.g:9287:2: ( rulePrimitiveValue )
            {
            // InternalTechnologyDsl.g:9287:2: ( rulePrimitiveValue )
            // InternalTechnologyDsl.g:9288:3: rulePrimitiveValue
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_0_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveValue();

            state._fsp--;

             after(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValuePrimitiveValueParserRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1"


    // $ANTLR start "rule__TechnologySpecificProperty__MandatoryAssignment_2_1"
    // InternalTechnologyDsl.g:9297:1: rule__TechnologySpecificProperty__MandatoryAssignment_2_1 : ( ( 'mandatory' ) ) ;
    public final void rule__TechnologySpecificProperty__MandatoryAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9301:1: ( ( ( 'mandatory' ) ) )
            // InternalTechnologyDsl.g:9302:2: ( ( 'mandatory' ) )
            {
            // InternalTechnologyDsl.g:9302:2: ( ( 'mandatory' ) )
            // InternalTechnologyDsl.g:9303:3: ( 'mandatory' )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0()); 
            // InternalTechnologyDsl.g:9304:3: ( 'mandatory' )
            // InternalTechnologyDsl.g:9305:4: 'mandatory'
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0()); 

            }

             after(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TechnologySpecificProperty__MandatoryAssignment_2_1"


    // $ANTLR start "rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0"
    // InternalTechnologyDsl.g:9316:1: rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 : ( ( 'exchange_pattern' ) ) ;
    public final void rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9320:1: ( ( ( 'exchange_pattern' ) ) )
            // InternalTechnologyDsl.g:9321:2: ( ( 'exchange_pattern' ) )
            {
            // InternalTechnologyDsl.g:9321:2: ( ( 'exchange_pattern' ) )
            // InternalTechnologyDsl.g:9322:3: ( 'exchange_pattern' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0()); 
            // InternalTechnologyDsl.g:9323:3: ( 'exchange_pattern' )
            // InternalTechnologyDsl.g:9324:4: 'exchange_pattern'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0()); 

            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0"


    // $ANTLR start "rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2"
    // InternalTechnologyDsl.g:9335:1: rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 : ( ruleExchangePattern ) ;
    public final void rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9339:1: ( ( ruleExchangePattern ) )
            // InternalTechnologyDsl.g:9340:2: ( ruleExchangePattern )
            {
            // InternalTechnologyDsl.g:9340:2: ( ruleExchangePattern )
            // InternalTechnologyDsl.g:9341:3: ruleExchangePattern
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternExchangePatternEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExchangePattern();

            state._fsp--;

             after(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternExchangePatternEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2"


    // $ANTLR start "rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0"
    // InternalTechnologyDsl.g:9350:1: rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 : ( ( 'communication_type' ) ) ;
    public final void rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9354:1: ( ( ( 'communication_type' ) ) )
            // InternalTechnologyDsl.g:9355:2: ( ( 'communication_type' ) )
            {
            // InternalTechnologyDsl.g:9355:2: ( ( 'communication_type' ) )
            // InternalTechnologyDsl.g:9356:3: ( 'communication_type' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0()); 
            // InternalTechnologyDsl.g:9357:3: ( 'communication_type' )
            // InternalTechnologyDsl.g:9358:4: 'communication_type'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0()); 

            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0"


    // $ANTLR start "rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2"
    // InternalTechnologyDsl.g:9369:1: rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 : ( ruleCommunicationType ) ;
    public final void rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9373:1: ( ( ruleCommunicationType ) )
            // InternalTechnologyDsl.g:9374:2: ( ruleCommunicationType )
            {
            // InternalTechnologyDsl.g:9374:2: ( ruleCommunicationType )
            // InternalTechnologyDsl.g:9375:3: ruleCommunicationType
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCommunicationType();

            state._fsp--;

             after(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeCommunicationTypeEnumRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2"


    // $ANTLR start "rule__ServiceAspectPointcut__ForProtocolAssignment_2_0"
    // InternalTechnologyDsl.g:9384:1: rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 : ( ( 'protocol' ) ) ;
    public final void rule__ServiceAspectPointcut__ForProtocolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9388:1: ( ( ( 'protocol' ) ) )
            // InternalTechnologyDsl.g:9389:2: ( ( 'protocol' ) )
            {
            // InternalTechnologyDsl.g:9389:2: ( ( 'protocol' ) )
            // InternalTechnologyDsl.g:9390:3: ( 'protocol' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0()); 
            // InternalTechnologyDsl.g:9391:3: ( 'protocol' )
            // InternalTechnologyDsl.g:9392:4: 'protocol'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0()); 

            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__ForProtocolAssignment_2_0"


    // $ANTLR start "rule__ServiceAspectPointcut__ProtocolAssignment_2_2"
    // InternalTechnologyDsl.g:9403:1: rule__ServiceAspectPointcut__ProtocolAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__ServiceAspectPointcut__ProtocolAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9407:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:9408:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:9408:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9409:3: ( RULE_ID )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getProtocolProtocolCrossReference_2_2_0()); 
            // InternalTechnologyDsl.g:9410:3: ( RULE_ID )
            // InternalTechnologyDsl.g:9411:4: RULE_ID
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getProtocolProtocolIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getProtocolProtocolIDTerminalRuleCall_2_2_0_1()); 

            }

             after(grammarAccess.getServiceAspectPointcutAccess().getProtocolProtocolCrossReference_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__ProtocolAssignment_2_2"


    // $ANTLR start "rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0"
    // InternalTechnologyDsl.g:9422:1: rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 : ( ( 'data_format' ) ) ;
    public final void rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9426:1: ( ( ( 'data_format' ) ) )
            // InternalTechnologyDsl.g:9427:2: ( ( 'data_format' ) )
            {
            // InternalTechnologyDsl.g:9427:2: ( ( 'data_format' ) )
            // InternalTechnologyDsl.g:9428:3: ( 'data_format' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0()); 
            // InternalTechnologyDsl.g:9429:3: ( 'data_format' )
            // InternalTechnologyDsl.g:9430:4: 'data_format'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0()); 

            }

             after(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0"


    // $ANTLR start "rule__ServiceAspectPointcut__DataFormatAssignment_3_2"
    // InternalTechnologyDsl.g:9441:1: rule__ServiceAspectPointcut__DataFormatAssignment_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__ServiceAspectPointcut__DataFormatAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9445:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:9446:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:9446:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9447:3: ( RULE_ID )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getDataFormatDataFormatCrossReference_3_2_0()); 
            // InternalTechnologyDsl.g:9448:3: ( RULE_ID )
            // InternalTechnologyDsl.g:9449:4: RULE_ID
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getDataFormatDataFormatIDTerminalRuleCall_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getServiceAspectPointcutAccess().getDataFormatDataFormatIDTerminalRuleCall_3_2_0_1()); 

            }

             after(grammarAccess.getServiceAspectPointcutAccess().getDataFormatDataFormatCrossReference_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcut__DataFormatAssignment_3_2"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__PointcutsAssignment_2"
    // InternalTechnologyDsl.g:9460:1: rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 : ( ruleServiceAspectPointcut ) ;
    public final void rule__ServiceAspectPointcutSelector__PointcutsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9464:1: ( ( ruleServiceAspectPointcut ) )
            // InternalTechnologyDsl.g:9465:2: ( ruleServiceAspectPointcut )
            {
            // InternalTechnologyDsl.g:9465:2: ( ruleServiceAspectPointcut )
            // InternalTechnologyDsl.g:9466:3: ruleServiceAspectPointcut
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleServiceAspectPointcut();

            state._fsp--;

             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__PointcutsAssignment_2"


    // $ANTLR start "rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1"
    // InternalTechnologyDsl.g:9475:1: rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 : ( ruleServiceAspectPointcut ) ;
    public final void rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9479:1: ( ( ruleServiceAspectPointcut ) )
            // InternalTechnologyDsl.g:9480:2: ( ruleServiceAspectPointcut )
            {
            // InternalTechnologyDsl.g:9480:2: ( ruleServiceAspectPointcut )
            // InternalTechnologyDsl.g:9481:3: ruleServiceAspectPointcut
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleServiceAspectPointcut();

            state._fsp--;

             after(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsServiceAspectPointcutParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1"


    // $ANTLR start "rule__ServiceAspect__NameAssignment_1"
    // InternalTechnologyDsl.g:9490:1: rule__ServiceAspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ServiceAspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9494:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9495:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9495:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9496:3: RULE_ID
            {
             before(grammarAccess.getServiceAspectAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getServiceAspectAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__NameAssignment_1"


    // $ANTLR start "rule__ServiceAspect__JoinPointsAssignment_3"
    // InternalTechnologyDsl.g:9505:1: rule__ServiceAspect__JoinPointsAssignment_3 : ( ruleServiceJoinPointType ) ;
    public final void rule__ServiceAspect__JoinPointsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9509:1: ( ( ruleServiceJoinPointType ) )
            // InternalTechnologyDsl.g:9510:2: ( ruleServiceJoinPointType )
            {
            // InternalTechnologyDsl.g:9510:2: ( ruleServiceJoinPointType )
            // InternalTechnologyDsl.g:9511:3: ruleServiceJoinPointType
            {
             before(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleServiceJoinPointType();

            state._fsp--;

             after(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__JoinPointsAssignment_3"


    // $ANTLR start "rule__ServiceAspect__JoinPointsAssignment_4_1"
    // InternalTechnologyDsl.g:9520:1: rule__ServiceAspect__JoinPointsAssignment_4_1 : ( ruleServiceJoinPointType ) ;
    public final void rule__ServiceAspect__JoinPointsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9524:1: ( ( ruleServiceJoinPointType ) )
            // InternalTechnologyDsl.g:9525:2: ( ruleServiceJoinPointType )
            {
            // InternalTechnologyDsl.g:9525:2: ( ruleServiceJoinPointType )
            // InternalTechnologyDsl.g:9526:3: ruleServiceJoinPointType
            {
             before(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleServiceJoinPointType();

            state._fsp--;

             after(grammarAccess.getServiceAspectAccess().getJoinPointsServiceJoinPointTypeEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__JoinPointsAssignment_4_1"


    // $ANTLR start "rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1"
    // InternalTechnologyDsl.g:9535:1: rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 : ( ruleServiceAspectPointcutSelector ) ;
    public final void rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9539:1: ( ( ruleServiceAspectPointcutSelector ) )
            // InternalTechnologyDsl.g:9540:2: ( ruleServiceAspectPointcutSelector )
            {
            // InternalTechnologyDsl.g:9540:2: ( ruleServiceAspectPointcutSelector )
            // InternalTechnologyDsl.g:9541:3: ruleServiceAspectPointcutSelector
            {
             before(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleServiceAspectPointcutSelector();

            state._fsp--;

             after(grammarAccess.getServiceAspectAccess().getPointcutSelectorsServiceAspectPointcutSelectorParserRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1"


    // $ANTLR start "rule__ServiceAspect__PropertiesAssignment_5_0_2"
    // InternalTechnologyDsl.g:9550:1: rule__ServiceAspect__PropertiesAssignment_5_0_2 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__ServiceAspect__PropertiesAssignment_5_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9554:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:9555:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:9555:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:9556:3: ruleTechnologySpecificProperty
            {
             before(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificProperty();

            state._fsp--;

             after(grammarAccess.getServiceAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ServiceAspect__PropertiesAssignment_5_0_2"


    // $ANTLR start "rule__OperationAspect__NameAssignment_1"
    // InternalTechnologyDsl.g:9565:1: rule__OperationAspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OperationAspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9569:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9570:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9570:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9571:3: RULE_ID
            {
             before(grammarAccess.getOperationAspectAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOperationAspectAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__NameAssignment_1"


    // $ANTLR start "rule__OperationAspect__JoinPointsAssignment_3"
    // InternalTechnologyDsl.g:9580:1: rule__OperationAspect__JoinPointsAssignment_3 : ( ruleOperationJoinPointType ) ;
    public final void rule__OperationAspect__JoinPointsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9584:1: ( ( ruleOperationJoinPointType ) )
            // InternalTechnologyDsl.g:9585:2: ( ruleOperationJoinPointType )
            {
            // InternalTechnologyDsl.g:9585:2: ( ruleOperationJoinPointType )
            // InternalTechnologyDsl.g:9586:3: ruleOperationJoinPointType
            {
             before(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationJoinPointType();

            state._fsp--;

             after(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__JoinPointsAssignment_3"


    // $ANTLR start "rule__OperationAspect__JoinPointsAssignment_4_1"
    // InternalTechnologyDsl.g:9595:1: rule__OperationAspect__JoinPointsAssignment_4_1 : ( ruleOperationJoinPointType ) ;
    public final void rule__OperationAspect__JoinPointsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9599:1: ( ( ruleOperationJoinPointType ) )
            // InternalTechnologyDsl.g:9600:2: ( ruleOperationJoinPointType )
            {
            // InternalTechnologyDsl.g:9600:2: ( ruleOperationJoinPointType )
            // InternalTechnologyDsl.g:9601:3: ruleOperationJoinPointType
            {
             before(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationJoinPointType();

            state._fsp--;

             after(grammarAccess.getOperationAspectAccess().getJoinPointsOperationJoinPointTypeEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__JoinPointsAssignment_4_1"


    // $ANTLR start "rule__OperationAspect__PropertiesAssignment_5_0_1"
    // InternalTechnologyDsl.g:9610:1: rule__OperationAspect__PropertiesAssignment_5_0_1 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__OperationAspect__PropertiesAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9614:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:9615:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:9615:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:9616:3: ruleTechnologySpecificProperty
            {
             before(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTechnologySpecificProperty();

            state._fsp--;

             after(grammarAccess.getOperationAspectAccess().getPropertiesTechnologySpecificPropertyParserRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationAspect__PropertiesAssignment_5_0_1"


    // $ANTLR start "rule__ComplexTypeImport__ImportURIAssignment_3"
    // InternalTechnologyDsl.g:9625:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9629:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:9630:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:9630:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:9631:3: RULE_STRING
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
    // InternalTechnologyDsl.g:9640:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9644:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9645:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9645:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9646:3: RULE_ID
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
    // InternalTechnologyDsl.g:9655:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9659:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9660:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9660:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9661:3: RULE_ID
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
    // InternalTechnologyDsl.g:9670:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9674:1: ( ( ruleComplexType ) )
            // InternalTechnologyDsl.g:9675:2: ( ruleComplexType )
            {
            // InternalTechnologyDsl.g:9675:2: ( ruleComplexType )
            // InternalTechnologyDsl.g:9676:3: ruleComplexType
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
    // InternalTechnologyDsl.g:9685:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9689:1: ( ( ruleContext ) )
            // InternalTechnologyDsl.g:9690:2: ( ruleContext )
            {
            // InternalTechnologyDsl.g:9690:2: ( ruleContext )
            // InternalTechnologyDsl.g:9691:3: ruleContext
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
    // InternalTechnologyDsl.g:9700:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9704:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9705:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9705:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9706:3: RULE_ID
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
    // InternalTechnologyDsl.g:9715:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9719:1: ( ( ruleComplexType ) )
            // InternalTechnologyDsl.g:9720:2: ( ruleComplexType )
            {
            // InternalTechnologyDsl.g:9720:2: ( ruleComplexType )
            // InternalTechnologyDsl.g:9721:3: ruleComplexType
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
    // InternalTechnologyDsl.g:9730:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9734:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9735:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9735:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9736:3: RULE_ID
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
    // InternalTechnologyDsl.g:9745:1: rule__DataStructure__SuperAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9749:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:9750:2: ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:9750:2: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:9751:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0()); 
            // InternalTechnologyDsl.g:9752:3: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:9753:4: ruleQualifiedName
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
    // InternalTechnologyDsl.g:9764:1: rule__DataStructure__DataFieldsAssignment_4_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9768:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9769:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9769:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9770:3: ruleDataField
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
    // InternalTechnologyDsl.g:9779:1: rule__DataStructure__DataFieldsAssignment_4_1_1 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9783:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9784:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9784:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9785:3: ruleDataField
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
    // InternalTechnologyDsl.g:9794:1: rule__ListType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9798:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9799:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9799:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9800:3: RULE_ID
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
    // InternalTechnologyDsl.g:9809:1: rule__ListType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9813:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9814:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9814:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9815:3: ruleDataField
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
    // InternalTechnologyDsl.g:9824:1: rule__ListType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9828:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9829:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9829:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9830:3: ruleDataField
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
    // InternalTechnologyDsl.g:9839:1: rule__ListType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9843:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9844:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9844:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9845:3: RULE_ID
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
    // InternalTechnologyDsl.g:9854:1: rule__ListType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__ListType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9858:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:9859:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:9859:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:9860:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:9869:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9873:1: ( ( ( 'hide' ) ) )
            // InternalTechnologyDsl.g:9874:2: ( ( 'hide' ) )
            {
            // InternalTechnologyDsl.g:9874:2: ( ( 'hide' ) )
            // InternalTechnologyDsl.g:9875:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalTechnologyDsl.g:9876:3: ( 'hide' )
            // InternalTechnologyDsl.g:9877:4: 'hide'
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            match(input,86,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:9888:1: rule__DataField__PrimitiveTypeAssignment_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9892:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:9893:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:9893:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:9894:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:9903:1: rule__DataField__ComplexTypeAssignment_1_1 : ( rulePossiblyImportedComplexType ) ;
    public final void rule__DataField__ComplexTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9907:1: ( ( rulePossiblyImportedComplexType ) )
            // InternalTechnologyDsl.g:9908:2: ( rulePossiblyImportedComplexType )
            {
            // InternalTechnologyDsl.g:9908:2: ( rulePossiblyImportedComplexType )
            // InternalTechnologyDsl.g:9909:3: rulePossiblyImportedComplexType
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
    // InternalTechnologyDsl.g:9918:1: rule__DataField__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9922:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9923:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9923:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9924:3: RULE_ID
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


    // $ANTLR start "rule__Enumeration__NameAssignment_1"
    // InternalTechnologyDsl.g:9933:1: rule__Enumeration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9937:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9938:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9938:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9939:3: RULE_ID
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
    // InternalTechnologyDsl.g:9948:1: rule__Enumeration__FieldsAssignment_3 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9952:1: ( ( ruleEnumerationField ) )
            // InternalTechnologyDsl.g:9953:2: ( ruleEnumerationField )
            {
            // InternalTechnologyDsl.g:9953:2: ( ruleEnumerationField )
            // InternalTechnologyDsl.g:9954:3: ruleEnumerationField
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
    // InternalTechnologyDsl.g:9963:1: rule__Enumeration__FieldsAssignment_4_1 : ( ruleEnumerationField ) ;
    public final void rule__Enumeration__FieldsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9967:1: ( ( ruleEnumerationField ) )
            // InternalTechnologyDsl.g:9968:2: ( ruleEnumerationField )
            {
            // InternalTechnologyDsl.g:9968:2: ( ruleEnumerationField )
            // InternalTechnologyDsl.g:9969:3: ruleEnumerationField
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
    // InternalTechnologyDsl.g:9978:1: rule__EnumerationField__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EnumerationField__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9982:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9983:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9983:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9984:3: RULE_ID
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
    // InternalTechnologyDsl.g:9993:1: rule__EnumerationField__InitializationValueAssignment_1_1 : ( rulePrimitiveValue ) ;
    public final void rule__EnumerationField__InitializationValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9997:1: ( ( rulePrimitiveValue ) )
            // InternalTechnologyDsl.g:9998:2: ( rulePrimitiveValue )
            {
            // InternalTechnologyDsl.g:9998:2: ( rulePrimitiveValue )
            // InternalTechnologyDsl.g:9999:3: rulePrimitiveValue
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


    // $ANTLR start "rule__PrimitiveValue__NumericValueAssignment_0"
    // InternalTechnologyDsl.g:10008:1: rule__PrimitiveValue__NumericValueAssignment_0 : ( RULE_BIG_DECIMAL ) ;
    public final void rule__PrimitiveValue__NumericValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:10012:1: ( ( RULE_BIG_DECIMAL ) )
            // InternalTechnologyDsl.g:10013:2: ( RULE_BIG_DECIMAL )
            {
            // InternalTechnologyDsl.g:10013:2: ( RULE_BIG_DECIMAL )
            // InternalTechnologyDsl.g:10014:3: RULE_BIG_DECIMAL
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
    // InternalTechnologyDsl.g:10023:1: rule__PrimitiveValue__BooleanValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__PrimitiveValue__BooleanValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:10027:1: ( ( RULE_BOOLEAN ) )
            // InternalTechnologyDsl.g:10028:2: ( RULE_BOOLEAN )
            {
            // InternalTechnologyDsl.g:10028:2: ( RULE_BOOLEAN )
            // InternalTechnologyDsl.g:10029:3: RULE_BOOLEAN
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
    // InternalTechnologyDsl.g:10038:1: rule__PrimitiveValue__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:10042:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:10043:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:10043:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:10044:3: RULE_STRING
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
    // InternalTechnologyDsl.g:10053:1: rule__PossiblyImportedComplexType__ImportAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__PossiblyImportedComplexType__ImportAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:10057:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:10058:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:10058:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:10059:3: ( RULE_ID )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0()); 
            // InternalTechnologyDsl.g:10060:3: ( RULE_ID )
            // InternalTechnologyDsl.g:10061:4: RULE_ID
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
    // InternalTechnologyDsl.g:10072:1: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__PossiblyImportedComplexType__ComplexTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:10076:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:10077:2: ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:10077:2: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:10078:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeCrossReference_1_0()); 
            // InternalTechnologyDsl.g:10079:3: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:10080:4: ruleQualifiedName
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


    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\65\1\4\1\37\1\4\1\uffff\12\4\1\uffff";
    static final String dfa_3s = "\1\65\1\4\1\37\1\126\1\uffff\12\40\1\uffff";
    static final String dfa_4s = "\4\uffff\1\1\12\uffff\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4\100\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\7\uffff\1\4",
            "",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            "\1\4\33\uffff\1\17",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1067:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0060000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000015924000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0062000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0062000000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000400000002000L,0x0000000000010000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0008000000002000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007FE0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000400000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000400000380000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000400000002000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000007FE0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0200000000002000L,0x0000000000020000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x00000000003C0000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x2000400000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000000000FC00000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000400080002000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0800000100000000L,0x0000000000007FE0L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000100000000L,0x0000000000007FE0L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0060000100000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0060000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000100000010L,0x0000000000407FE0L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000010L,0x0000000000407FE0L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000400100000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000010L,0x0000000000007FE0L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});

}